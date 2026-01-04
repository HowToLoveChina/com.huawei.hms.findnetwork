package com.huawei.android.hicloud.p088ui.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.p088ui.uiadapter.ExpirationCardItemAdapter;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.bean.HomepagePackageExpiresCardBean;
import com.huawei.hicloud.bean.HomepagePackageExpiresCardItemBean;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0223k;
import p015ak.C0226l0;
import p292fn.C9733f;
import p371ik.C10527a;
import p431ko.C11079e;
import p514o9.C11839m;
import p616rk.C12515a;
import p684un.C13227f;
import p684un.C13230i;
import p703v8.C13368e;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ExpirationReminderCardView extends RelativeLayout {

    /* renamed from: a */
    public final Context f19447a;

    /* renamed from: b */
    public RelativeLayout f19448b;

    /* renamed from: c */
    public View f19449c;

    /* renamed from: d */
    public TextView f19450d;

    /* renamed from: e */
    public RecyclerView f19451e;

    /* renamed from: f */
    public ExpirationCardItemAdapter f19452f;

    /* renamed from: g */
    public LinearLayoutManager f19453g;

    /* renamed from: h */
    public HomepagePackageExpiresCardBean f19454h;

    public ExpirationReminderCardView(Context context) {
        this(context, null, 0, 0);
    }

    /* renamed from: c */
    public final HomepagePackageExpiresCardBean m25754c(String str, int i10, int i11) {
        String strM25756e;
        if (this.f19447a == null) {
            C11839m.m70687e("ExpirationReminderCardView", "mContext is null");
            return null;
        }
        HiCloudSysParamMap hiCloudSysParamMapM60758q = C9733f.m60705z().m60758q();
        if (hiCloudSysParamMapM60758q == null) {
            C11839m.m70687e("ExpirationReminderCardView", "getCardBean, sysParamMap is null!");
            return null;
        }
        List<HomepagePackageExpiresCardBean> listM64626d = C10527a.m64626d(hiCloudSysParamMapM60758q.getHomepagePackageExpiresCardsEx(), HomepagePackageExpiresCardBean.class);
        if (listM64626d.isEmpty()) {
            C11839m.m70687e("ExpirationReminderCardView", "getCardBean, config list is empty");
            return null;
        }
        String strM25757f = m25757f(C13452e.m80781L().m80946n());
        for (HomepagePackageExpiresCardBean homepagePackageExpiresCardBean : listM64626d) {
            if (homepagePackageExpiresCardBean == null) {
                C11839m.m70687e("ExpirationReminderCardView", "configBean is null");
            } else if (strM25757f.equals(homepagePackageExpiresCardBean.getType())) {
                if (i10 < 1) {
                    strM25756e = this.f19447a.getString(R$string.expiration_card_default_title, str);
                } else {
                    String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage(homepagePackageExpiresCardBean.getTitle());
                    strM25756e = TextUtils.isEmpty(spaceMultLanguage) ? m25756e(str, i10) : String.format(spaceMultLanguage, str, Integer.valueOf(i10));
                }
                if (TextUtils.isEmpty(strM25756e)) {
                    return null;
                }
                homepagePackageExpiresCardBean.setTitle(strM25756e);
                if (homepagePackageExpiresCardBean.getItems() == null) {
                    C11839m.m70687e("ExpirationReminderCardView", "getCardBean, config bean items is null");
                    return null;
                }
                for (int i12 = 0; i12 < homepagePackageExpiresCardBean.getItems().size(); i12++) {
                    HomepagePackageExpiresCardItemBean homepagePackageExpiresCardItemBean = homepagePackageExpiresCardBean.getItems().get(i12);
                    if (homepagePackageExpiresCardItemBean == null) {
                        C11839m.m70687e("ExpirationReminderCardView", "configItem is null");
                        return null;
                    }
                    if (TextUtils.isEmpty(homepagePackageExpiresCardItemBean.getButtonLinkUrl()) || ("aboutToDeleted".equals(strM25757f) && TextUtils.isEmpty(homepagePackageExpiresCardItemBean.getButtonLinkUrl2()))) {
                        C11839m.m70687e("ExpirationReminderCardView", "getCardBean, button link url is empty");
                        return null;
                    }
                    String spaceMultLanguage2 = SpaceMultLanguageUtil.getSpaceMultLanguage(homepagePackageExpiresCardItemBean.getTitle());
                    String spaceMultLanguage3 = SpaceMultLanguageUtil.getSpaceMultLanguage(homepagePackageExpiresCardItemBean.getContent());
                    if (TextUtils.isEmpty(spaceMultLanguage3)) {
                        if (i11 <= 0) {
                            i11 = 1;
                        }
                        spaceMultLanguage3 = m25755d(homepagePackageExpiresCardItemBean.getContent(), i11);
                    }
                    if (TextUtils.isEmpty(spaceMultLanguage3)) {
                        C11839m.m70687e("ExpirationReminderCardView", "itemContent is null");
                        return null;
                    }
                    String strReplaceParams = CloudSpaceNotifyUtil.getInstance().replaceParams(spaceMultLanguage3, "ExpirationReminderCardView");
                    String spaceMultLanguage4 = SpaceMultLanguageUtil.getSpaceMultLanguage(homepagePackageExpiresCardItemBean.getButton());
                    String spaceMultLanguage5 = SpaceMultLanguageUtil.getSpaceMultLanguage(homepagePackageExpiresCardItemBean.getRecommendation());
                    try {
                        homepagePackageExpiresCardItemBean.setTitle(spaceMultLanguage2);
                        homepagePackageExpiresCardItemBean.setContent(strReplaceParams);
                        homepagePackageExpiresCardItemBean.setButton(spaceMultLanguage4);
                        homepagePackageExpiresCardItemBean.setRecommendation(spaceMultLanguage5);
                        if (C13452e.m80781L().m80823K0()) {
                            homepagePackageExpiresCardItemBean.setButton2(SpaceMultLanguageUtil.getSpaceMultLanguage(homepagePackageExpiresCardItemBean.getButton2()));
                        }
                    } catch (IndexOutOfBoundsException unused) {
                        if (TextUtils.isEmpty(spaceMultLanguage2) || TextUtils.isEmpty(strReplaceParams) || TextUtils.isEmpty(spaceMultLanguage4)) {
                            C11839m.m70687e("ExpirationReminderCardView", "getCardBean, config item text is empty, title: " + spaceMultLanguage2 + ", content: " + strReplaceParams + ", button: " + spaceMultLanguage4);
                            return null;
                        }
                        homepagePackageExpiresCardItemBean.setTitle(spaceMultLanguage2);
                        homepagePackageExpiresCardItemBean.setContent(strReplaceParams);
                        homepagePackageExpiresCardItemBean.setButton(spaceMultLanguage4);
                    }
                }
                return homepagePackageExpiresCardBean;
            }
        }
        C11839m.m70687e("ExpirationReminderCardView", "getCardBean, there is no config bean");
        return null;
    }

    /* renamed from: d */
    public final String m25755d(String str, int i10) {
        Resources resources;
        return (!"download_service_data_tips".equals(str) || i10 <= 0 || (resources = getResources()) == null) ? "" : resources.getQuantityString(R$plurals.download_service_data_tips, i10, Integer.valueOf(i10));
    }

    /* renamed from: e */
    public final String m25756e(String str, int i10) {
        if (this.f19447a == null) {
            return "";
        }
        if (C13452e.m80781L().m80823K0()) {
            String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("default_expiration_card_title");
            if (!TextUtils.isEmpty(spaceMultLanguage)) {
                return String.format(spaceMultLanguage, str);
            }
        } else if (C13452e.m80781L().m80815I0() || C13452e.m80781L().m80819J0()) {
            Resources resources = getResources();
            return resources == null ? "" : resources.getQuantityString(R$plurals.expiration_card_title, i10, str, Integer.valueOf(i10));
        }
        return this.f19447a.getString(R$string.expiration_card_default_title, str);
    }

    /* renamed from: f */
    public final String m25757f(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? "" : "aboutToDeleted" : "willBeDeleted2" : "willBeDeleted";
    }

    /* renamed from: g */
    public final void m25758g() {
        this.f19449c = View.inflate(this.f19447a, R$layout.expiration_reminder_card, this);
        this.f19448b = (RelativeLayout) C12809f.m76831d(this, R$id.expiration_card_main_layout);
        this.f19451e = (RecyclerView) C12809f.m76831d(this, R$id.expiration_items_recycle_view);
        this.f19450d = (TextView) C12809f.m76831d(this, R$id.expiration_card_title);
        if (this.f19452f == null) {
            this.f19452f = new ExpirationCardItemAdapter(this.f19447a);
        }
        this.f19451e.setAdapter(this.f19452f);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f19447a, 1, false);
        this.f19453g = linearLayoutManager;
        this.f19451e.setLayoutManager(linearLayoutManager);
    }

    /* renamed from: h */
    public final /* synthetic */ void m25759h(HomepagePackageExpiresCardBean homepagePackageExpiresCardBean) {
        if (homepagePackageExpiresCardBean == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            setCardBean(homepagePackageExpiresCardBean);
        }
    }

    /* renamed from: i */
    public final /* synthetic */ void m25760i(QuotaSpaceInfo quotaSpaceInfo, UserDataStateInfo userDataStateInfo) {
        if (userDataStateInfo == null) {
            C11839m.m70688i("ExpirationReminderCardView", "userGradeInfo is nul");
            return;
        }
        String strM1524g = C0223k.m1524g(this.f19447a, quotaSpaceInfo.getUsed());
        int remainDwnldDays = (C13452e.m80781L().m80815I0() || C13452e.m80781L().m80819J0()) ? userDataStateInfo.getRemainDwnldDays() : C13452e.m80781L().m80823K0() ? userDataStateInfo.getRemainRegretDays() : -1;
        C11839m.m70688i("ExpirationReminderCardView", "remainDays: " + remainDwnldDays);
        final HomepagePackageExpiresCardBean homepagePackageExpiresCardBeanM25754c = m25754c(strM1524g, remainDwnldDays, userDataStateInfo.getDwnldPeriod1Days());
        C0226l0.m1584d(new Runnable() { // from class: de.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f45848a.m25759h(homepagePackageExpiresCardBeanM25754c);
            }
        });
    }

    /* renamed from: j */
    public final void m25761j() {
        HomepagePackageExpiresCardBean homepagePackageExpiresCardBean = this.f19454h;
        if (homepagePackageExpiresCardBean == null) {
            C11839m.m70687e("ExpirationReminderCardView", "card bean is null");
            return;
        }
        this.f19450d.setText(homepagePackageExpiresCardBean.getTitle());
        this.f19452f.m25025K(this.f19454h.getItems());
        this.f19452f.m5213j();
    }

    /* renamed from: k */
    public void m25762k() {
        int iM80798E = C13452e.m80781L().m80798E();
        String strM80790C = C13452e.m80781L().m80790C();
        C11839m.m70688i("ExpirationReminderCardView", "gradeState: " + iM80798E + ", gradeCode: " + strM80790C);
        final QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L != null) {
            C11839m.m70688i("ExpirationReminderCardView", "used size: " + quotaSpaceInfoM80223L.getUsed());
        } else {
            C11839m.m70687e("ExpirationReminderCardView", "quota info is null");
        }
        if (!CloudBackupConstant.UserPackageInfo.BASE_DATA_SERVICE.equals(strM80790C) || iM80798E != 0 || quotaSpaceInfoM80223L == null || quotaSpaceInfoM80223L.getUsed() <= 0) {
            setVisibility(8);
            return;
        }
        try {
            C11839m.m70688i("ExpirationReminderCardView", "show expiration card view");
            m25763l();
            ArrayList arrayList = new ArrayList();
            arrayList.add(NotifyConstants.MashupKey.BS_USERDATA_REMAIN_DWNLD1DAYS);
            arrayList.add("bs.userdata.remain.dwnldDays");
            arrayList.add("bs.userdata.remain.regretDays");
            C12515a.m75110o().m75172d(new C11079e(new C11079e.a() { // from class: de.o
                @Override // p431ko.C11079e.a
                /* renamed from: a */
                public final void mo14511a(UserDataStateInfo userDataStateInfo) {
                    this.f45846a.m25760i(quotaSpaceInfoM80223L, userDataStateInfo);
                }
            }, false, arrayList, true, "ExpirationReminderCardView"));
        } catch (Exception e10) {
            C11839m.m70687e("ExpirationReminderCardView", "show expiration card view error: " + e10);
        }
    }

    /* renamed from: l */
    public final void m25763l() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("dataPeriod", String.valueOf(C13452e.m80781L().m80946n()));
        C13227f.m79492i1().m79567R("expiration_card_show", linkedHashMapM79497A);
        UBAAnalyze.m29947H("PVC", "expiration_card_show", linkedHashMapM79497A);
    }

    public void setCardBean(HomepagePackageExpiresCardBean homepagePackageExpiresCardBean) {
        this.f19454h = homepagePackageExpiresCardBean;
        m25761j();
    }

    public ExpirationReminderCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public ExpirationReminderCardView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ExpirationReminderCardView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f19447a = context;
        m25758g();
    }
}
