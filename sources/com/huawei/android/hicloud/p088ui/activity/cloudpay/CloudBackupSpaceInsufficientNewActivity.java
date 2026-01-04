package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackup3rdIconUtil;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupLanguageUtil;
import com.huawei.android.hicloud.cloudbackup.util.PackageParamUtil;
import com.huawei.android.hicloud.cloudbackup.util.TransferedUtil;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.BackupOptionsActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudSpaceShareActivity;
import com.huawei.android.hicloud.p088ui.common.HiCloudExceptionView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.LearnMorePayClickListener;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.uiutil.NewHiSyncUtil;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.hicloud.task.simple.C3024d2;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetAvailableGradePackagesResp;
import com.huawei.cloud.pay.model.GetPackagesBySpaceRuleResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.RecommendVouchers;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardBaseResourceBean;
import com.huawei.cloud.pay.model.cardresourcebean.GradeCardDefaultResourceBean;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.RecommendNeedData;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import dj.C9158a;
import fj.C9718g;
import gp.C10028c;
import id.C10469c;
import id.C10470d;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p010a9.C0079a;
import p015ak.C0209d;
import p015ak.C0223k;
import p015ak.C0226l0;
import p054cj.C1442a;
import p292fn.C9733f;
import p364ib.C10465b;
import p454lj.C11290m;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12590s0;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import p778xk.C13823d;
import p848zl.C14333b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CloudBackupSpaceInsufficientNewActivity extends BuyPackageBaseActivity implements View.OnClickListener, RenewAgreementTextview.RenewAgreementTVCallback {

    /* renamed from: A1 */
    public TextView f16718A1;

    /* renamed from: B1 */
    public TextView f16719B1;

    /* renamed from: C1 */
    public TextView f16720C1;

    /* renamed from: D1 */
    public RelativeLayout f16721D1;

    /* renamed from: E1 */
    public View f16722E1;

    /* renamed from: F1 */
    public RecommendNeedData f16723F1;

    /* renamed from: G1 */
    public View f16724G1;

    /* renamed from: H1 */
    public View f16725H1;

    /* renamed from: I1 */
    public HiCloudExceptionView f16726I1;

    /* renamed from: J1 */
    public AutoSizeButton f16727J1;

    /* renamed from: K1 */
    public NotchTopFitLinearLayout f16728K1;

    /* renamed from: L1 */
    public NotchFitRelativeLayout f16729L1;

    /* renamed from: M1 */
    public View f16730M1;

    /* renamed from: N1 */
    public int f16731N1;

    /* renamed from: O1 */
    public CloudPackage f16732O1;

    /* renamed from: P1 */
    public String f16733P1;

    /* renamed from: Q1 */
    public PackageGrades f16734Q1;

    /* renamed from: R1 */
    public int f16735R1;

    /* renamed from: S1 */
    public int f16736S1;

    /* renamed from: T1 */
    public boolean f16737T1;

    /* renamed from: W1 */
    public TextView f16740W1;

    /* renamed from: i1 */
    public RelativeLayout f16742i1;

    /* renamed from: j1 */
    public TextView f16743j1;

    /* renamed from: k1 */
    public TextView f16744k1;

    /* renamed from: l1 */
    public TextView f16745l1;

    /* renamed from: m1 */
    public TextView f16746m1;

    /* renamed from: n1 */
    public RelativeLayout f16747n1;

    /* renamed from: o1 */
    public LinearLayout f16748o1;

    /* renamed from: p1 */
    public TextView f16749p1;

    /* renamed from: q1 */
    public TextView f16750q1;

    /* renamed from: r1 */
    public TextView f16751r1;

    /* renamed from: s1 */
    public TextView f16752s1;

    /* renamed from: t1 */
    public TextView f16753t1;

    /* renamed from: u1 */
    public AutoSizeButton f16754u1;

    /* renamed from: v1 */
    public SpanClickText f16755v1;

    /* renamed from: w1 */
    public LinearLayout f16756w1;

    /* renamed from: x1 */
    public RenewAgreementTextview f16757x1;

    /* renamed from: y1 */
    public ImageView f16758y1;

    /* renamed from: z1 */
    public boolean f16759z1;

    /* renamed from: h1 */
    public C13149f f16741h1 = new C13149f();

    /* renamed from: U1 */
    public List<BackupOptionItem> f16738U1 = new ArrayList();

    /* renamed from: V1 */
    public boolean f16739V1 = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudBackupSpaceInsufficientNewActivity$a */
    public class C3602a implements ConfirmRenewAgreementDialog.AgreementDlgCallback {
        public C3602a() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void refreshCheckboxStatus(boolean z10) {
            if (CloudBackupSpaceInsufficientNewActivity.this.f16758y1 == null) {
                C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "refreshCheckboxStatus, renewCheckboxView is null.");
                return;
            }
            if (z10) {
                CloudBackupSpaceInsufficientNewActivity.this.f16758y1.setBackground(CloudBackupSpaceInsufficientNewActivity.this.getDrawable(R$drawable.renew_check_icon_on));
            } else {
                CloudBackupSpaceInsufficientNewActivity.this.f16758y1.setBackground(CloudBackupSpaceInsufficientNewActivity.this.getDrawable(R$drawable.renew_check_icon_off));
            }
            CloudBackupSpaceInsufficientNewActivity.this.f16759z1 = z10;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
            linkedHashMap.put("way_of_purchase", "recommend3_purchase");
            CloudBackupSpaceInsufficientNewActivity.this.m22842j4(str, linkedHashMap);
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void startPaymentProcess(C0079a c0079a) throws JSONException {
            if (c0079a == null) {
                C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "startPaymentProcess, agreementDialogNeedData is null.");
            } else {
                CloudBackupSpaceInsufficientNewActivity.this.m23153z6();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CloudBackupSpaceInsufficientNewActivity$b */
    public class C3603b extends AbstractC12367d {
        public C3603b() {
        }

        public /* synthetic */ void lambda$call$0() throws JSONException, Resources.NotFoundException {
            C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "GetBackupOptionItemsTask showView");
            CloudBackupSpaceInsufficientNewActivity.this.mo19479s5();
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "GetBackupOptionItemsTask start");
            CloudBackupSpaceInsufficientNewActivity.this.f16738U1.clear();
            CloudBackupSpaceInsufficientNewActivity.this.f16738U1.addAll(TransferedUtil.querySortedBackupDataExcludeSystemApp());
            if (CloudBackupSpaceInsufficientNewActivity.this.f16739V1) {
                long jM69963a = C12590s0.m75923y(true).m69963a();
                if (CloudBackupSpaceInsufficientNewActivity.this.f16723F1 != null) {
                    C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "getWaitSize increase =" + jM69963a + " backupNeedSpace =" + CloudBackupSpaceInsufficientNewActivity.this.f16723F1.getBackupNeedSpace());
                    CloudBackupSpaceInsufficientNewActivity.this.f16723F1.setBackupNeedSpace(jM69963a);
                }
            }
            CloudBackupSpaceInsufficientNewActivity.this.f16737T1 = true;
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.l
                @Override // java.lang.Runnable
                public final void run() throws JSONException, Resources.NotFoundException {
                    this.f17555a.lambda$call$0();
                }
            });
            C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "GetBackupOptionItemsTask end");
        }
    }

    /* renamed from: a6 */
    private void m23113a6() {
        long j10;
        RecommendNeedData recommendNeedData = this.f16723F1;
        if (recommendNeedData == null) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "getRecommedPackages recommendNeedData is null.");
            finish();
            return;
        }
        if (recommendNeedData.isV5BackupNotEnoughDialog()) {
            Filter filter = new Filter();
            filter.setShowPlace(2);
            C9158a.m57503F().m57559x(this.f16524O, filter, null, m22882v2(), true, true, this.f16723F1.getTotalNeedSpace());
            return;
        }
        if (TextUtils.isEmpty(this.f16723F1.getRecommendType())) {
            C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "getRecommedPackages recommendType is null.");
            return;
        }
        long totalNeedSpace = this.f16723F1.getTotalNeedSpace();
        if (totalNeedSpace < 5368709120L) {
            C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "getRecommedPackages totalNeedSpace = " + totalNeedSpace + " reset the value.");
            j10 = 5368709120L;
        } else {
            j10 = totalNeedSpace;
        }
        String recommendType = this.f16723F1.getRecommendType();
        ChannelInfo channelInfoM22882v2 = m22882v2();
        recommendType.hashCode();
        if (recommendType.equals(NotifyConstants.CLOUD_BACKUP_SPACE_INSUFFICIENT)) {
            C9158a.m57503F().m57513K(this.f16524O, this.f21448i, 0, j10, 2, channelInfoM22882v2, this.f16723F1.isWorryFreeExpire());
            return;
        }
        C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "getRecommedPackages default type : " + recommendType);
    }

    /* renamed from: d6 */
    private void m23114d6() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt(FamilyShareConstants.ENTRY_TYPE, this.f16735R1);
        bundle.putInt(FamilyShareConstants.EXTRA_KEY, this.f16736S1);
        intent.putExtras(bundle);
        intent.setClass(this, CloudSpaceShareActivity.class);
        startActivity(intent);
    }

    /* renamed from: e6 */
    private void m23115e6() {
        this.f16730M1.setVisibility(8);
        this.f16724G1.setVisibility(8);
    }

    /* renamed from: j6 */
    private void m23116j6() throws JSONException {
        if (this.f16723F1 == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "jumptoUpgradeActivity recommendNeedData is null.");
            finish();
            return;
        }
        JSONObject jSONObjectM79464f = C13222a.m79464f(this, "DYNAMIC_NOTIFY_CLICK", "1", C13452e.m80781L().m80971t0(), "4");
        try {
            jSONObjectM79464f.put("notify_id", this.f16723F1.getId());
            jSONObjectM79464f.put("notify_type", "1");
            jSONObjectM79464f.put("click_upgrade_cloudSpace", true);
            jSONObjectM79464f.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, this.f16731N1);
            jSONObjectM79464f.put(HNConstants.C4906BI.FROM_NOTIFY, String.valueOf(this.f16741h1.m79064b()));
            jSONObjectM79464f.put("page_type", NotifyConstants.DETAIL3);
        } catch (JSONException e10) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "ERROR OCCUR:" + e10.getMessage());
        }
        C13225d.m79490f1().m79602z(jSONObjectM79464f);
        UBAAnalyze.m29963X("PVC", "DYNAMIC_NOTIFY_CLICK", "4", "9", jSONObjectM79464f);
        m23152y6(false);
        C13225d.m79490f1().m79585f0("mecloud_cloudspacetips_upgrade", C13452e.m80781L().m80971t0());
        UBAAnalyze.m29954O("PVC", "mecloud_cloudspacetips_upgrade", "1", "30");
        finish();
    }

    /* renamed from: l6 */
    private void m23117l6() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("time", String.valueOf(System.currentTimeMillis() - mo18593F0()));
        linkedHashMapM79497A.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, String.valueOf(this.f16731N1));
        linkedHashMapM79497A.put(HNConstants.C4906BI.FROM_NOTIFY, String.valueOf(this.f16741h1.m79064b()));
        linkedHashMapM79497A.put("page_type", NotifyConstants.DETAIL3);
        C13225d.m79490f1().m79591l0("action_code_space_not_enough_detail3_time", linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", "action_code_space_not_enough_detail3_time", "1", "83", linkedHashMapM79497A);
    }

    /* renamed from: m6 */
    private void m23118m6() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "setActionbarTitle actionBar is null.");
            return;
        }
        if (C13452e.m80781L().m80887a1()) {
            C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "new BM, set new title");
            actionBar.setTitle(R$string.full_data_service);
        } else {
            actionBar.setTitle(R$string.cloudpay_cloud_backup_item_title);
        }
        int i10 = R$color.hicloud_hmos_bg;
        C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
        actionBar.setBackgroundDrawable(new ColorDrawable(getColor(i10)));
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(getColor(i10));
        }
    }

    /* renamed from: n6 */
    private void m23119n6() {
        C11842p.m70760Q1(this, this.f16724G1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: v6 */
    private void m23120v6() {
        this.f16725H1.setVisibility(0);
        m23115e6();
    }

    /* renamed from: A6 */
    public final void m23121A6(int i10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(i10));
        linkedHashMap.put(HNConstants.C4906BI.FROM_NOTIFY, String.valueOf(this.f16741h1.m79064b()));
        linkedHashMap.put("page_type", NotifyConstants.DETAIL3);
        C13225d.m79490f1().m79591l0("cloudbackup_space_insufficient_upgrade", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_space_insufficient_upgrade", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "cloudbackup_space_insufficient_upgrade", "4", "16", linkedHashMap);
    }

    /* renamed from: B6 */
    public final void m23122B6() throws JSONException {
        m23121A6(this.f16731N1);
        LinearLayout linearLayout = this.f16756w1;
        if (linearLayout == null || linearLayout.getVisibility() != 0 || this.f16759z1) {
            m23153z6();
            return;
        }
        C0079a c0079a = new C0079a();
        c0079a.m652i(this.f16538V.getCheckDialogRenewAgreement());
        c0079a.m651h(new C3602a());
        ConfirmRenewAgreementDialog confirmRenewAgreementDialog = new ConfirmRenewAgreementDialog(this, c0079a);
        confirmRenewAgreementDialog.setCanceledOnTouchOutside(false);
        confirmRenewAgreementDialog.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
    }

    /* renamed from: N5 */
    public final void m23123N5() throws Resources.NotFoundException {
        C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "addDownloadAppContent");
        C11842p.m70866t1(this, this.f16754u1);
        this.f16754u1.setText(R$string.cloudpay_recevie_now);
        this.f16754u1.setOnClickListener(this);
        this.f16746m1.setVisibility(0);
        this.f16749p1.setText(R$string.recommend_package_one);
        this.f16750q1.setText(R$string.receive_free_space_title);
        String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this, 53687091200L));
        Resources resources = getResources();
        if (resources != null) {
            String string = resources.getString(R$string.receive_free_space_package_name, strM1157C0);
            String string2 = resources.getString(R$string.receive_free_space_package_text, string);
            try {
                int iIndexOf = string2.indexOf(string);
                int length = string.length() + iIndexOf;
                SpannableString spannableString = new SpannableString(string2);
                spannableString.setSpan(new ForegroundColorSpan(getColor(R$color.title_color_100)), iIndexOf, length, 33);
                spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, length, 33);
                this.f16751r1.setText(spannableString);
            } catch (Exception unused) {
                this.f16751r1.setText(string2);
            }
        }
        this.f16752s1.setVisibility(8);
        this.f16755v1.setVisibility(8);
        this.f16753t1.setVisibility(4);
        this.f16747n1.setVisibility(0);
        this.f16742i1.setVisibility(0);
        m23149u6();
        m23148t6();
        m23115e6();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O4 */
    public void mo19453O4(int i10, Intent intent) throws JSONException {
        super.mo19453O4(i10, intent);
        if (i10 == 10002) {
            RecommendNeedData recommendNeedData = this.f16723F1;
            if (recommendNeedData == null) {
                C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "handleScene, recommendNeedData is null.");
                finish();
            } else {
                if (!"family_share".equals(recommendNeedData.getRecommendType())) {
                    m23116j6();
                    return;
                }
                C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "handleScene family share finish.");
                setResult(103);
                m23114d6();
                finish();
            }
        }
    }

    /* renamed from: O5 */
    public final void m23124O5(ArrayList<FilterAvailabalGradePackage> arrayList) {
        C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "addRecommendPackageContent");
        FilterAvailabalGradePackage filterAvailabalGradePackage = arrayList.get(0);
        List<CloudPackage> monthlyPackageList = filterAvailabalGradePackage.getMonthlyPackageList();
        List<CloudPackage> basicPackageList = filterAvailabalGradePackage.getBasicPackageList();
        List<CloudPackage> incrementList = filterAvailabalGradePackage.getIncrementList();
        this.f16733P1 = filterAvailabalGradePackage.getMemAD();
        if (monthlyPackageList != null && monthlyPackageList.size() > 0) {
            this.f16732O1 = monthlyPackageList.get(0);
        } else if (basicPackageList != null && basicPackageList.size() > 0) {
            this.f16732O1 = basicPackageList.get(0);
        } else if (incrementList != null && incrementList.size() > 0) {
            this.f16732O1 = incrementList.get(0);
        }
        this.f16734Q1 = filterAvailabalGradePackage.getPackageGrades();
        if (this.f16732O1 == null) {
            C11839m.m70686d("CloudBackupSpaceInsufficientNewActivity", "selectCloudPackage is null");
            return;
        }
        C11842p.m70866t1(this, this.f16754u1);
        this.f16754u1.setText(m23136b6());
        this.f16754u1.setOnClickListener(this);
        this.f16746m1.setVisibility(0);
        this.f16749p1.setText(R$string.recommend_package_one);
        this.f16750q1.setText(m23135Z5(this.f16732O1));
        if (TextUtils.isEmpty(this.f16733P1)) {
            this.f16751r1.setVisibility(8);
        } else {
            this.f16751r1.setText(this.f16733P1);
            this.f16751r1.setTextSize(2, 12.0f);
        }
        m23150w6(this.f16752s1, this.f16732O1);
        m23151x6(this.f16753t1, this.f16732O1);
        if (!m23127R5(this)) {
            m23145q6(this.f16755v1, this.f16732O1, monthlyPackageList);
        }
        this.f16747n1.setVisibility(0);
        this.f16742i1.setVisibility(0);
        m23149u6();
        m23148t6();
        m23115e6();
    }

    /* renamed from: P5 */
    public final SpannableStringBuilder m23125P5(String str, String str2, String str3, CloudPackage cloudPackage) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "buildPriceDisplayText error, resource is null");
            return spannableStringBuilder;
        }
        GradeCardDefaultResourceBean gradeCardDefaultResourceBean = new GradeCardDefaultResourceBean();
        int iIndexOf = str.indexOf(str2);
        int length = str2.length();
        Resources resources = getResources();
        float fM1195O = C0209d.m1195O(this);
        String currencySymbol = cloudPackage.getCurrencySymbol();
        int length2 = currencySymbol.length();
        m23144p6(spannableStringBuilder, iIndexOf, length, str.indexOf(currencySymbol, iIndexOf), length2, gradeCardDefaultResourceBean, resources, fM1195O);
        if (!TextUtils.isEmpty(str3)) {
            int iIndexOf2 = str.indexOf(str3, iIndexOf + length);
            m23143o6(spannableStringBuilder, iIndexOf2, str3.length(), str.indexOf(currencySymbol, iIndexOf2), length2, fM1195O);
        }
        return spannableStringBuilder;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Q2 */
    public void mo19455Q2(int i10) throws JSONException {
        C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "errCode = " + i10);
        if (NotifyConstants.THRID_APP_SPACE_INSUFFICIENT.equals(this.f16723F1.getRecommendType())) {
            finish();
        } else {
            mo19477k5();
        }
    }

    /* renamed from: Q5 */
    public final BigDecimal m23126Q5(List<CloudPackage> list) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "calculateMaxPriceGap, dataList is empty");
            return bigDecimal;
        }
        int size = list.size();
        if (size > 1) {
            size = 1;
        }
        for (int i10 = 0; i10 < size; i10++) {
            CloudPackage cloudPackage = list.get(i10);
            BigDecimal bigDecimalSubtract = BigDecimal.ZERO;
            int productType = cloudPackage.getProductType();
            if (productType == 7 || productType == 8) {
                BigDecimal price = cloudPackage.getPrice();
                BigDecimal spPrice = cloudPackage.getSpPrice();
                if (price.compareTo(spPrice) >= 0) {
                    bigDecimalSubtract = price.subtract(spPrice);
                }
            }
            if (bigDecimal.compareTo(bigDecimalSubtract) <= 0) {
                bigDecimal = bigDecimalSubtract;
            }
        }
        return bigDecimal;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: R2 */
    public void mo19456R2(Object obj) throws JSONException, Resources.NotFoundException {
        if (!(obj instanceof GetAvailableGradePackagesResp)) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "dealGetAvailableGradePackagesSuccess obj is invalid");
            mo19477k5();
            return;
        }
        GetPackagesBySpaceRuleResp getPackagesBySpaceRuleRespBuildSpaceRuleResp = BackupNotificationV5Util.buildSpaceRuleResp((GetAvailableGradePackagesResp) obj);
        if (getPackagesBySpaceRuleRespBuildSpaceRuleResp == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "getPackagesBySpaceRuleResp is null.");
            m23116j6();
            return;
        }
        this.f16548a0 = C11296s.m67829n(getPackagesBySpaceRuleRespBuildSpaceRuleResp.getPackageGrades(), getPackagesBySpaceRuleRespBuildSpaceRuleResp.getSpacePackages());
        List<Voucher> voucherList = getPackagesBySpaceRuleRespBuildSpaceRuleResp.getVoucherList();
        this.f16535T0 = voucherList;
        if (voucherList == null || !C11296s.m67787K() || !C11296s.m67789M(this)) {
            this.f16535T0 = new ArrayList();
        }
        if (this.f16548a0 == null) {
            this.f16548a0 = new ArrayList<>();
        }
        mo19479s5();
    }

    /* renamed from: R5 */
    public boolean m23127R5(RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback) {
        if (!C13452e.m80781L().m80803F0().booleanValue()) {
            return false;
        }
        if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
            C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "checkShowRecommendRenewArea, switch is close.");
            return false;
        }
        CloudPackage cloudPackage = this.f16732O1;
        if (cloudPackage == null) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "checkShowRecommendRenewArea, selectCloudPackage is null.");
            return false;
        }
        int productType = cloudPackage.getProductType();
        if (productType != 6 && productType != 8 && productType != 12) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "checkShowRecommendRenewArea, invalid productType = " + productType);
            return false;
        }
        if (this.f16756w1 == null) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "checkShowRecommendRenewArea, renewCheckViewArea is null.");
            return false;
        }
        String packageCardAgreement = this.f16538V.getPackageCardAgreement();
        String checkDialogRenewAgreement = this.f16538V.getCheckDialogRenewAgreement();
        if (TextUtils.isEmpty(packageCardAgreement)) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "checkShowRecommendRenewArea, packageCardRenewAgreementText is null.");
            return false;
        }
        if (TextUtils.isEmpty(checkDialogRenewAgreement)) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "checkShowRecommendRenewArea, checkDialogRenewAgreementText is null.");
            return false;
        }
        this.f16756w1.setVisibility(0);
        if (this.f16759z1) {
            this.f16758y1.setBackground(getDrawable(R$drawable.renew_check_icon_on));
        } else {
            this.f16758y1.setBackground(getDrawable(R$drawable.renew_check_icon_off));
        }
        String string = getString(R$string.cloudpay_monthly_renew_agreement);
        String string2 = getString(R$string.cloudpay_user_agreement);
        this.f16757x1.m25806w(String.format(packageCardAgreement, string2, string), string2, string, this, renewAgreementTVCallback);
        this.f16757x1.setTextColor(getResources().getColor(R$color.view_details_text_color));
        return true;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    /* renamed from: S5 */
    public final String m23128S5(BackupOptionItem backupOptionItem) {
        String strM25632b = NewHiSyncUtil.m25632b(backupOptionItem.getAppId());
        if (TextUtils.isEmpty(strM25632b)) {
            String appName = backupOptionItem.getAppName();
            return TextUtils.isEmpty(appName) ? backupOptionItem.getAppId() : appName;
        }
        backupOptionItem.setAppName(strM25632b);
        return strM25632b;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() throws JSONException {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        try {
            RecommendNeedData recommendNeedData = (RecommendNeedData) hiCloudSafeIntent.getSerializableExtra(NotifyConstants.RecommendNeedDataKey.RECOMMEND_NEED_DATA_KEY);
            this.f16723F1 = recommendNeedData;
            String title = recommendNeedData.getTitle();
            String subTitle = this.f16723F1.getSubTitle();
            String mainText = this.f16723F1.getMainText();
            String secondMainText = this.f16723F1.getSecondMainText();
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(subTitle) && !TextUtils.isEmpty(mainText) && !TextUtils.isEmpty(secondMainText)) {
                this.f16743j1.setText(title);
                this.f16744k1.setText(subTitle);
                this.f16745l1.setText(m23132W5(mainText, this.f16723F1.getBackupNeedSpace(), this.f16723F1.getNotUsedSpace()));
                this.f16746m1.setText(secondMainText);
                this.f16731N1 = m23129T5(this.f16723F1.getActivityType());
                this.f16735R1 = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.ENTRY_TYPE, -1);
                this.f16736S1 = hiCloudSafeIntent.getIntExtra(FamilyShareConstants.EXTRA_KEY, -1);
                if (!C11296s.m67786J(this)) {
                    m23120v6();
                    return;
                }
                this.f16538V = null;
                this.f21452m = null;
                this.f16548a0 = null;
                this.f16535T0 = null;
                mo19474g5();
                m28588o1("06008");
                C13612b.m81829B().m81848K(this.f16524O);
                C12515a.m75110o().m75175e(new C3024d2(this, this.f16526P, 2, "CloudBackupSpaceInsufficientNewActivity"), false);
                m23134Y5();
                m23146r6();
                return;
            }
            C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "text is empty");
            mo19477k5();
        } catch (Exception e10) {
            C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", e10.getMessage());
            mo19477k5();
        }
    }

    /* renamed from: T5 */
    public final int m23129T5(int i10) {
        int i11;
        if (i10 != 1 || C11829c.m70530L0()) {
            i11 = i10;
        } else {
            C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "change USER_TYPE_INCENTIVE to USER_TYPE_NORMAL.");
            i11 = 0;
        }
        if (i10 == 4 && !m23139g6()) {
            C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "change USER_TYPE_TASK to USER_TYPE_NORMAL.");
            i11 = 0;
        }
        if (i10 == 0 || C13452e.m80781L().m80897c1()) {
            return i11;
        }
        C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "change to USER_TYPE_NORMAL, type = " + i10);
        return 0;
    }

    /* renamed from: U5 */
    public final String m23130U5(CloudPackage cloudPackage) {
        int promDuration = cloudPackage.getPromDuration();
        BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
        try {
            int promType = cloudPackage.getPromType();
            if (m23140h6()) {
                RecommendVouchers recommendVouchersM67839w = C11296s.m67839w(cloudPackage, C11296s.m67837u(this.f16535T0, cloudPackage, this.f21452m.getDeductAmount()), this.f21452m.getDeductAmount());
                if (recommendVouchersM67839w != null) {
                    List<Voucher> voucherList = recommendVouchersM67839w.getVoucherList();
                    if (promType != 1 || promDuration <= 1) {
                        bigDecimalM67838v = C11296s.m67833q(cloudPackage, voucherList, this.f21452m.getDeductAmount(), recommendVouchersM67839w.getDiscountAmount());
                    }
                }
            } else if (promType != 1 || promDuration <= 1) {
                bigDecimalM67838v = C11296s.m67833q(cloudPackage, new ArrayList(), this.f21452m.getDeductAmount(), BigDecimal.ZERO);
            }
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "getDiscountPackagePrice Exception : " + e10.toString());
        }
        return C11290m.m67749j(bigDecimalM67838v, cloudPackage.getCurrency(), cloudPackage.getCurrencySymbol());
    }

    /* renamed from: V5 */
    public final Intent m23131V5(boolean z10) {
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 8);
        intent.putExtra("more_pkg", z10);
        C0209d.m1302r2(intent, getPackageName());
        C13230i.m79525e1(intent, "4", "8");
        m28580X0(intent);
        return intent;
    }

    /* renamed from: W5 */
    public final SpannableString m23132W5(String str, long j10, long j11) {
        String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this, j10));
        String strM1157C02 = C0209d.m1157C0(C0223k.m1524g(this, j11));
        String strM64293c = C10465b.m64293c(str, strM1157C0, strM1157C02);
        SpannableString spannableString = new SpannableString(strM64293c);
        try {
            int iIndexOf = strM64293c.indexOf(strM1157C0);
            int iIndexOf2 = strM64293c.indexOf(strM1157C02);
            Resources resources = getResources();
            int i10 = R$color.stock_active_open_later_color_ff;
            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(i10)), iIndexOf, strM1157C0.length() + iIndexOf, 33);
            float fM1195O = C0209d.m1195O(this);
            int i11 = (fM1195O < 1.75f || fM1195O >= 2.0f) ? (fM1195O < 2.0f || fM1195O >= 3.2f) ? fM1195O >= 3.2f ? 64 : 18 : 40 : 35;
            spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf, strM1157C0.length() + iIndexOf, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(i11, true), iIndexOf, strM1157C0.length() + iIndexOf, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(i10)), iIndexOf2, strM1157C02.length() + iIndexOf2, 33);
            spannableString.setSpan(new TypefaceSpan("HwChinese-medium"), iIndexOf2, strM1157C02.length() + iIndexOf2, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(i11, true), iIndexOf2, strM1157C02.length() + iIndexOf2, 33);
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "getMainText error, " + e10.toString());
        }
        return spannableString;
    }

    /* renamed from: X5 */
    public final String m23133X5(List<CloudPackage> list) {
        if (list == null || list.size() <= 0) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "getMaxDiscountText, dataList is empty");
            return "";
        }
        CloudPackage cloudPackage = list.get(0);
        return C11290m.m67749j(m23126Q5(list), cloudPackage.getCurrency(), cloudPackage.getSymbol());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: Y2 */
    public void mo19466Y2() throws JSONException {
        super.mo19466Y2();
        mo19477k5();
    }

    /* renamed from: Y5 */
    public final void m23134Y5() throws JSONException {
        C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "getPackageInfo");
        if (this.f16723F1 == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "getPackageInfo recommendNeedData is null.");
            mo19477k5();
            return;
        }
        int i10 = this.f16731N1;
        if (i10 == 1) {
            C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "get space info, not family share, check campaign");
            if (C11829c.m70530L0()) {
                m22750C3(3);
                return;
            } else {
                C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "not support activity");
                mo19477k5();
                return;
            }
        }
        if (i10 == 4) {
            C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "activityType is 4");
            return;
        }
        C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
        C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "cloudBpSpItNewActivity");
        m23113a6();
    }

    /* renamed from: Z5 */
    public final String m23135Z5(CloudPackage cloudPackage) {
        String string;
        String productName = cloudPackage.getProductName();
        try {
            if (cloudPackage.getProductType() == 12) {
                string = getString(R$string.payment_renewal_package_size, productName, PackageParamUtil.procWorryFreeDurationText(this, cloudPackage));
            } else {
                long capacity = cloudPackage.getCapacity();
                productName = PackageParamUtil.getProductName(cloudPackage, this.f16538V);
                string = getString(R$string.payment_renewal_package_size, C0209d.m1157C0(C0223k.m1524g(this, capacity)), productName);
            }
            return string;
        } catch (Exception e10) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "getProductName Exception : " + e10.toString());
            return productName;
        }
    }

    /* renamed from: b6 */
    public final String m23136b6() {
        return C13452e.m80781L().m80887a1() ? this.f21452m.getIsAutoPay() == 1 ? getString(R$string.change_plan) : getString(R$string.cloudpay_subscribe_now) : getString(R$string.upgrade_now);
    }

    /* renamed from: c6 */
    public final void m23137c6() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, Integer.valueOf(this.f16731N1));
        linkedHashMap.put(HNConstants.C4906BI.FROM_NOTIFY, String.valueOf(this.f16741h1.m79064b()));
        linkedHashMap.put("page_type", NotifyConstants.DETAIL3);
        C13225d.m79490f1().m79591l0("cloudbackup_space_unenough_to_backup_option", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "cloudbackup_space_unenough_to_backup_option", linkedHashMap);
        UBAAnalyze.m29958S("PVC", "cloudbackup_space_unenough_to_backup_option", "4", "16", linkedHashMap);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: f3 */
    public void mo19473f3(Object obj) throws JSONException {
        if (obj == null || !(obj instanceof UserPackage)) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "dealGetUserPackageSuccess obj is not UserPackage.");
            mo19477k5();
        } else {
            this.f21452m = (UserPackage) obj;
            RecommendNeedData recommendNeedData = this.f16723F1;
            if (recommendNeedData == null) {
                C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "dealGetUserPackageSuccess recommendNeedData is null.");
                return;
            }
            if ("family_share".equals(recommendNeedData.getRecommendType())) {
                if (C11293p.m67757a(this.f21452m) == null) {
                    C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "dealGetUserPackageSuccess effectivePackage is null.");
                    return;
                }
                long jM67762f = C11293p.m67762f(this.f21452m);
                long used = this.f21452m.getUsed();
                if (jM67762f > used) {
                    this.f16723F1.setTotalNeedSpace(jM67762f);
                } else {
                    this.f16723F1.setTotalNeedSpace(used);
                }
            }
        }
        super.mo19473f3(obj);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: f4 */
    public void mo22832f4(Message message) throws JSONException {
        super.mo22832f4(message);
        mo19477k5();
    }

    /* renamed from: f6 */
    public void m23138f6() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f16728K1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f16729L1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.cloud_space_insufficient_new_layout);
        this.f16730M1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f16724G1 = C12809f.m76829b(this, R$id.layout_loading);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f16725H1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f16727J1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f16727J1.setOnClickListener(this);
        this.f16742i1 = (RelativeLayout) C12809f.m76829b(this, R$id.cloud_space_insufficient_title_frame);
        this.f16743j1 = (TextView) C12809f.m76829b(this, R$id.cloud_space_insufficient_title_text);
        this.f16744k1 = (TextView) C12809f.m76829b(this, R$id.cloud_space_insufficient_suh_title_text);
        this.f16745l1 = (TextView) C12809f.m76829b(this, R$id.cloud_space_insufficient_main_text);
        this.f16746m1 = (TextView) C12809f.m76829b(this, R$id.tv_recommend_solution);
        this.f16747n1 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_recommend_package_content);
        this.f16726I1 = (HiCloudExceptionView) C12809f.m76829b(this, R$id.exception_view);
        View viewInflate = LayoutInflater.from(this).inflate((C0209d.m1195O(this) > 1.75f ? 1 : (C0209d.m1195O(this) == 1.75f ? 0 : -1)) >= 0 ? R$layout.space_recommend_content_new_scale : R$layout.space_recommend_content_new, this.f16747n1);
        this.f16748o1 = (LinearLayout) C12809f.m76831d(viewInflate, R$id.ll_recommend_pkg_title);
        int i10 = R$id.tv_recommend_title;
        this.f16749p1 = (TextView) C12809f.m76831d(viewInflate, i10);
        this.f16750q1 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_package_title);
        this.f16751r1 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_package_sub_title);
        this.f16752s1 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_package_price);
        this.f16753t1 = (TextView) C12809f.m76831d(viewInflate, R$id.tv_package_order_content);
        this.f16754u1 = (AutoSizeButton) C12809f.m76831d(viewInflate, R$id.bt_order_now);
        this.f16755v1 = (SpanClickText) C12809f.m76831d(viewInflate, R$id.tv_package_mark);
        this.f16756w1 = (LinearLayout) C12809f.m76831d(viewInflate, R$id.recommend_third_renew_check_area);
        this.f16757x1 = (RenewAgreementTextview) C12809f.m76831d(viewInflate, R$id.recommend_third_renew_text);
        ImageView imageView = (ImageView) C12809f.m76831d(viewInflate, R$id.recommend_third_renew_check_view);
        this.f16758y1 = imageView;
        imageView.setOnClickListener(this);
        m23142k6();
        TextView textView = (TextView) C12809f.m76829b(this, R$id.more_btn);
        this.f16740W1 = textView;
        textView.setOnClickListener(this);
        this.f16721D1 = (RelativeLayout) C12809f.m76829b(this, R$id.rl_backup_option_content);
        View viewInflate2 = LayoutInflater.from(this).inflate(R$layout.space_insufficient_backup_option_content, this.f16721D1);
        this.f16722E1 = viewInflate2;
        TextView textView2 = (TextView) C12809f.m76831d(viewInflate2, R$id.bt_go_to_close);
        this.f16720C1 = textView2;
        textView2.setText(R$string.cloudpay_go_to_close_button);
        this.f16720C1.setOnClickListener(this);
        this.f16718A1 = (TextView) C12809f.m76831d(this.f16722E1, i10);
        this.f16719B1 = (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_backup_option_title);
        this.f16742i1.setVisibility(8);
        this.f16747n1.setVisibility(8);
        this.f16721D1.setVisibility(8);
        this.f16740W1.setVisibility(8);
        mo23770l1();
        m23119n6();
        m23118m6();
    }

    @Override // android.app.Activity
    public void finish() {
        m23117l6();
        super.finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g4 */
    public boolean mo22835g4(Message message) throws JSONException, Resources.NotFoundException {
        boolean zMo22835g4 = super.mo22835g4(message);
        if (zMo22835g4) {
            mo19479s5();
        } else {
            mo19477k5();
        }
        return zMo22835g4;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f16730M1.setVisibility(0);
        this.f16724G1.setVisibility(0);
        this.f16725H1.setVisibility(8);
    }

    /* renamed from: g6 */
    public final boolean m23139g6() {
        if (!C10028c.m62182c0().m62413x()) {
            NotifyLogger.m29915i("CloudBackupSpaceInsufficientNewActivity", "mItemSwitch is false");
            return false;
        }
        if (C0209d.m1293p1()) {
            NotifyLogger.m29915i("CloudBackupSpaceInsufficientNewActivity", "isInkScreen not show campaign");
            return false;
        }
        if (C13452e.m80781L().m80795D0()) {
            NotifyLogger.m29915i("CloudBackupSpaceInsufficientNewActivity", "child account not show campaign");
            return false;
        }
        if (!C0209d.m1166E1()) {
            NotifyLogger.m29915i("CloudBackupSpaceInsufficientNewActivity", "no owner user not show campaign");
            return false;
        }
        if (!C9718g.m60602t().m60612J(this)) {
            C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "initCampaignEntryView not show");
            return false;
        }
        if (!C9718g.m60602t().m60606D(this)) {
            return true;
        }
        C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "initCampaignEntryView activity finished");
        return false;
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16728K1);
        arrayList.add(this.f16729L1);
        arrayList.add(this.f16730M1);
        arrayList.add(this.f16726I1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() throws JSONException, Resources.NotFoundException {
        mo19479s5();
        this.f16729L1.setVisibility(0);
    }

    /* renamed from: h6 */
    public final boolean m23140h6() {
        List<Voucher> list;
        return C11296s.m67787K() && C11296s.m67789M(this) && (list = this.f16535T0) != null && !list.isEmpty();
    }

    /* renamed from: i6 */
    public final void m23141i6() {
        if (TextUtils.isEmpty(this.f16571r0)) {
            C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "jumpToDownloadApp is empty");
            return;
        }
        try {
            try {
                m23121A6(this.f16731N1);
                C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "jumpToDownloadApp: " + this.f16571r0);
                startActivityForResult(NotifyUtil.getDlAppWebViewIntent(this, this.f16571r0), NotifyConstants.RequestCode.REQUESTCODE_CAMPAIGN);
            } catch (Exception e10) {
                C11839m.m70687e("CloudBackupSpaceInsufficientNewActivity", "jumpToDownloadApp Exception : " + e10.toString());
            }
        } finally {
            finish();
        }
    }

    @Override // com.huawei.android.hicloud.ui.views.RenewAgreementTextview.RenewAgreementTVCallback
    /* renamed from: j0 */
    public void mo18858j0(boolean z10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("way_of_purchase", "recommend3_purchase");
        m22842j4(z10 ? "UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT" : "UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT", linkedHashMapM79497A);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() throws JSONException {
        m23116j6();
    }

    /* renamed from: k6 */
    public final void m23142k6() {
        if (this.f16758y1 != null) {
            float fM1195O = C0209d.m1195O(this);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f16758y1.getLayoutParams();
            int iM70840n = fM1195O < 1.75f ? (C11842p.m70771U0() || C11842p.m70753O0(this)) ? C11842p.m70840n(this, 6) : 0 : C11842p.m70771U0() ? (C11842p.m70753O0(this) && C0223k.m1518a((double) fM1195O, 3.200000047683716d)) ? C11842p.m70840n(this, 22) : C11842p.m70840n(this, 14) : C0223k.m1518a((double) fM1195O, 3.200000047683716d) ? C11842p.m70840n(this, 9) : C11842p.m70840n(this, 6);
            layoutParams.topMargin = iM70840n;
            this.f16758y1.setLayoutParams(layoutParams);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f16730M1.setVisibility(0);
        this.f16724G1.setVisibility(0);
        this.f16725H1.setVisibility(8);
        this.f16729L1.setVisibility(8);
    }

    /* renamed from: o6 */
    public final void m23143o6(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, float f10) {
        if (spannableStringBuilder == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "setOldPriceSpan error, priceSpan is null");
            return;
        }
        if (i10 < 0 || i12 < 0 || i13 <= 0 || i11 <= i13) {
            return;
        }
        int i14 = i11 - i13;
        if (i13 <= 3) {
            if (i14 <= 6) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
            } else {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(10, true), i10, i10 + i11, 33);
            }
        } else if (i14 <= 4) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
        } else {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(10, true), i10, i10 + i11, 33);
        }
        int i15 = i11 + i10;
        spannableStringBuilder.setSpan(new TypefaceSpan(NotifyConstants.TYPE_FACE_SPAN_FAMILY_HARMONY_HEITI), i10, i15, 33);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), i10, i15, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.title_color_59)), i10, i15, 33);
        int i16 = i13 + i12;
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i12, i16, 33);
        int i17 = (f10 < 2.0f || f10 >= 3.2f) ? f10 >= 3.2f ? 38 : 20 : 24;
        if (f10 >= 1.75f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i17, true), i10, i15, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i17, true), i12, i16, 33);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException {
        C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (i11 == -1) {
            mo19453O4(i10, intent);
        } else if (i11 == 1) {
            this.f16739V1 = true;
            C12515a.m75110o().m75172d(new C3603b());
        } else if (i11 == 201 || i11 == 802) {
            C1442a.m8288d("CloudBackupSpaceInsufficientNewActivity", "refresh data by requestCode:" + i10 + ", resultCode:" + i11);
            mo19460T3();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws JSONException {
        int id2 = view.getId();
        if (id2 == R$id.set_no_net_btn) {
            mo19446D1();
            return;
        }
        if (id2 == R$id.bt_order_now) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "bt_order_now click too fast");
                return;
            }
            int i10 = this.f16731N1;
            if (i10 == 1) {
                m23141i6();
                return;
            } else {
                if (i10 != 4) {
                    m23122B6();
                    return;
                }
                m23121A6(i10);
                C13823d.m82904y().m82913I(this, 11);
                finish();
                return;
            }
        }
        if (id2 == R$id.bt_go_to_close) {
            if (C0209d.m1226Y0()) {
                C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "bt_go_to_close click too fast");
                return;
            }
            Intent intent = new Intent(this, (Class<?>) BackupOptionsActivity.class);
            intent.putExtra("source", 3);
            startActivityForResult(intent, 1);
            m23137c6();
            return;
        }
        if (id2 == R$id.more_btn) {
            m23152y6(true);
            C13225d.m79490f1().m79587h0("detail_3_more_pkg", C13452e.m80781L().m80971t0(), HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, String.valueOf(this.f16731N1));
            UBAAnalyze.m29957R("PVC", "detail_3_more_pkg", "1", "30", HNConstants.C4906BI.KEY_OF_ACTIVITY_TYPE, String.valueOf(this.f16731N1));
        } else if (id2 == R$id.recommend_third_renew_check_view) {
            if (this.f16759z1) {
                this.f16758y1.setBackground(getDrawable(R$drawable.renew_check_icon_off));
                this.f16759z1 = false;
            } else {
                this.f16758y1.setBackground(getDrawable(R$drawable.renew_check_icon_on));
                this.f16759z1 = true;
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("renew_checkbox_status", String.valueOf(this.f16759z1));
            linkedHashMap.put("way_of_purchase", "recommend3_purchase");
            m22842j4("UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", linkedHashMap);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m23142k6();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, JSONException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        this.f16741h1.m79065c(this, getIntent(), C13222a.m79465g(this));
        setContentView(R$layout.activity_cloud_backup_space_insufficient_new);
        m23138f6();
        m28587n1();
        mo23770l1();
        mo19460T3();
    }

    /* renamed from: p6 */
    public final void m23144p6(SpannableStringBuilder spannableStringBuilder, int i10, int i11, int i12, int i13, GradeCardBaseResourceBean gradeCardBaseResourceBean, Resources resources, float f10) {
        int i14;
        int i15;
        if (spannableStringBuilder == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "setRealPriceSpan error, priceSpan is null");
            return;
        }
        if (i10 < 0 || i12 < 0 || i13 <= 0 || i11 <= i13) {
            return;
        }
        int i16 = i11 - i13;
        if (i13 <= 3) {
            if (i16 <= 6) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(34, true), i10, i10 + i11, 33);
            } else {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
            }
        } else if (i16 <= 4) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(34, true), i10, i10 + i11, 33);
        } else {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i10, i10 + i11, 33);
        }
        int i17 = i11 + i10;
        spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-medium"), i10, i17, 33);
        int i18 = i13 + i12;
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), i12, i18, 33);
        if (f10 >= 2.0f && f10 < 3.2f) {
            i14 = 64;
            i15 = 28;
        } else if (f10 >= 3.2f) {
            i14 = 76;
            i15 = 45;
        } else {
            i14 = 55;
            i15 = 24;
        }
        if (f10 >= 1.75f) {
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i14, true), i10, i17, 33);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(i15, true), i12, i18, 33);
        }
    }

    /* renamed from: q6 */
    public final void m23145q6(SpanClickText spanClickText, CloudPackage cloudPackage, List<CloudPackage> list) {
        if (cloudPackage == null || TextUtils.isEmpty(cloudPackage.getRenewChooseDesc())) {
            spanClickText.setVisibility(8);
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "setRecommendPackageMark is null, no need to show");
            return;
        }
        int productType = cloudPackage.getProductType();
        if (productType == 5 || productType == 7) {
            spanClickText.setVisibility(8);
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "setRecommendPackageMark productType illegal, no need to show");
            return;
        }
        String renewChooseDesc = cloudPackage.getRenewChooseDesc();
        String string = getString(R$string.cloudpay_continuous_monthly_agreement_new);
        String strReplaceAll = renewChooseDesc.contains("SSS%") ? renewChooseDesc.replaceAll("SSS%", string) : renewChooseDesc;
        if (renewChooseDesc.contains("DDD%")) {
            String strM23133X5 = m23133X5(list);
            if (!TextUtils.isEmpty(strM23133X5)) {
                strReplaceAll = strReplaceAll.replace("DDD%", strM23133X5);
            }
        }
        spanClickText.m15931c(string, new LearnMorePayClickListener(this, "/payagreement?lang="));
        spanClickText.m15934g(strReplaceAll, false);
        spanClickText.setVisibility(0);
    }

    /* renamed from: r6 */
    public final void m23146r6() {
        C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "showBackupOptionData");
        C12515a.m75110o().m75172d(new C3603b());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() throws JSONException, Resources.NotFoundException {
        C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "showView");
        if (this.f16723F1 == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "showView recommendNeedData is null.");
            return;
        }
        if (!this.f16737T1) {
            C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "showView backup ontion items not init.");
            return;
        }
        int i10 = this.f16731N1;
        if (i10 == 1) {
            if (this.f16571r0 == null) {
                C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "jump url no prepare ok");
                return;
            }
            m23123N5();
        } else if (i10 != 4) {
            ArrayList<FilterAvailabalGradePackage> arrayList = this.f16548a0;
            if (arrayList == null || this.f21452m == null || this.f16538V == null) {
                C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "data no prepare ok");
                return;
            } else {
                if (arrayList.isEmpty()) {
                    C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "recommendPackagesList is null");
                    mo19477k5();
                    return;
                }
                m23124O5(this.f16548a0);
            }
        } else {
            if (!m23139g6()) {
                C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "cannot show campaign entry");
                mo19477k5();
                return;
            }
            m23123N5();
        }
        C1442a.m8290i("CloudBackupSpaceInsufficientNewActivity", "showView finish.");
    }

    /* renamed from: s6 */
    public final void m23147s6(BackupOptionItem backupOptionItem, LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        String appId = backupOptionItem.getAppId();
        if ("virtualApp".equals(backupOptionItem.getParent())) {
            textView.setText(CloudBackupLanguageUtil.getVirtualName(appId));
            imageView.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId, null));
        } else if (C14333b.m85483r().containsKey(appId)) {
            textView.setText(C2783d.m16079E(this, appId));
            imageView.setImageDrawable(CloudBackup3rdIconUtil.getDrawable(appId));
        } else {
            textView.setText(C14333b.f63653e.containsKey(appId) ? C2783d.m16079E(this, appId) : m23128S5(backupOptionItem));
            imageView.setImageDrawable(CloudBackup3rdIconUtil.get3rdDrawable(appId));
        }
        textView2.setText(C0209d.m1157C0(C0223k.m1524g(this, backupOptionItem.getDataBytes())));
        linearLayout.setVisibility(0);
    }

    /* renamed from: t6 */
    public final void m23148t6() {
        C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "showBackupOptionItemsView");
        if (this.f16738U1.size() <= 0) {
            C11839m.m70688i("CloudBackupSpaceInsufficientNewActivity", "GetRecommendOptions showView return, backup app size = 0");
            this.f16721D1.setVisibility(8);
            this.f16722E1.setVisibility(8);
            this.f16748o1.setVisibility(4);
            return;
        }
        if (this.f16739V1) {
            this.f16745l1.setText(m23132W5(this.f16723F1.getMainText(), this.f16723F1.getBackupNeedSpace(), this.f16723F1.getNotUsedSpace()));
            this.f16739V1 = false;
        }
        this.f16721D1.setVisibility(0);
        this.f16722E1.setVisibility(0);
        this.f16719B1.setText(R$string.cloudpay_close_app_backup);
        this.f16718A1.setText(R$string.recommend_package_two);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76831d(this.f16722E1, R$id.ll_first);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76831d(this.f16722E1, R$id.ll_sendcond);
        LinearLayout linearLayout3 = (LinearLayout) C12809f.m76831d(this.f16722E1, R$id.ll_third);
        LinearLayout linearLayout4 = (LinearLayout) C12809f.m76831d(this.f16722E1, R$id.ll_fourth);
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(8);
        linearLayout3.setVisibility(8);
        linearLayout4.setVisibility(8);
        View view = this.f16722E1;
        int i10 = R$id.view_sencond;
        View viewM76831d = C12809f.m76831d(view, i10);
        View viewM76831d2 = C12809f.m76831d(this.f16722E1, i10);
        View viewM76831d3 = C12809f.m76831d(this.f16722E1, i10);
        viewM76831d.setVisibility(8);
        viewM76831d2.setVisibility(8);
        viewM76831d3.setVisibility(8);
        for (int i11 = 0; i11 < this.f16738U1.size(); i11++) {
            BackupOptionItem backupOptionItem = this.f16738U1.get(i11);
            if (i11 == 0) {
                m23147s6(backupOptionItem, linearLayout, (ImageView) C12809f.m76831d(this.f16722E1, R$id.iv_first), (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_first), (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_first_szie));
            } else if (i11 == 1) {
                ImageView imageView = (ImageView) C12809f.m76831d(this.f16722E1, R$id.iv_sencond);
                TextView textView = (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_sencond);
                TextView textView2 = (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_sencond_size);
                viewM76831d.setVisibility(0);
                m23147s6(backupOptionItem, linearLayout2, imageView, textView, textView2);
            } else if (i11 == 2) {
                ImageView imageView2 = (ImageView) C12809f.m76831d(this.f16722E1, R$id.iv_third);
                TextView textView3 = (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_third);
                TextView textView4 = (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_third_size);
                viewM76831d2.setVisibility(0);
                m23147s6(backupOptionItem, linearLayout3, imageView2, textView3, textView4);
            } else if (i11 == 3) {
                ImageView imageView3 = (ImageView) C12809f.m76831d(this.f16722E1, R$id.iv_fourth);
                TextView textView5 = (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_fourth);
                TextView textView6 = (TextView) C12809f.m76831d(this.f16722E1, R$id.tv_fourth_size);
                viewM76831d3.setVisibility(0);
                m23147s6(backupOptionItem, linearLayout4, imageView3, textView5, textView6);
                return;
            }
        }
    }

    /* renamed from: u6 */
    public void m23149u6() {
        TextView textView = this.f16740W1;
        if (textView == null) {
            C11839m.m70689w("CloudBackupSpaceInsufficientNewActivity", "morePkg btn is null");
        } else {
            textView.setVisibility(0);
        }
    }

    /* renamed from: w6 */
    public final void m23150w6(TextView textView, CloudPackage cloudPackage) {
        String strM23130U5;
        String strM67749j;
        String string;
        if (textView == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "showPrice priceDisTv is null.");
            return;
        }
        String currency = cloudPackage.getCurrency();
        String symbol = cloudPackage.getSymbol();
        BigDecimal price = cloudPackage.getPrice();
        int productType = cloudPackage.getProductType();
        if ((productType == 7 || productType == 8) && cloudPackage.getSpPrice() != null && cloudPackage.getSpPrice().compareTo(cloudPackage.getPrice()) == -1) {
            strM23130U5 = m23130U5(cloudPackage);
            strM67749j = C11290m.m67749j(price, currency, symbol);
            string = getString(R$string.cloudpay_package_urse_space_detail, strM23130U5, strM67749j);
        } else if (cloudPackage.getSpPrice() == null || cloudPackage.getSpPrice().compareTo(price) >= 0) {
            if (productType == 12) {
                price = C11296s.m67838v(cloudPackage);
            }
            strM23130U5 = C11290m.m67749j(price, currency, symbol);
            strM67749j = "";
            string = strM23130U5;
        } else {
            strM23130U5 = productType == 12 ? C11290m.m67749j(C11296s.m67838v(cloudPackage), currency, symbol) : m23130U5(cloudPackage);
            strM67749j = C11290m.m67749j(price, currency, symbol);
            string = getString(R$string.cloudpay_package_urse_space_detail, strM23130U5, strM67749j);
        }
        textView.setText(m23125P5(string, strM23130U5, strM67749j, cloudPackage));
        textView.setContentDescription(strM23130U5);
    }

    /* renamed from: x6 */
    public final void m23151x6(TextView textView, CloudPackage cloudPackage) {
        String packageTitle;
        if (textView == null) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "showRemark remarkTV is null.");
            return;
        }
        int productType = cloudPackage.getProductType();
        if (productType == 8 || productType == 7) {
            packageTitle = cloudPackage.getPackageTitle();
        } else {
            packageTitle = "";
            if (productType == 6 && this.f16538V != null) {
                HashMap<String, String> extendTagMap = cloudPackage.getExtendTagMap();
                packageTitle = extendTagMap != null ? extendTagMap.get("desc") : "";
                if (TextUtils.isEmpty(packageTitle)) {
                    packageTitle = this.f16538V.getRecommendBasicPackageRemarak(cloudPackage.getDurationMonth());
                }
            }
        }
        if (TextUtils.isEmpty(packageTitle)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(packageTitle);
        }
    }

    /* renamed from: y6 */
    public final void m23152y6(boolean z10) {
        C12515a.m75110o().m75165a1(C10469c.m64350p(this));
        C10469c.m64350p(this).cancel();
        C10470d.m64355p(this).cancel();
        ScreenListener.m18023c(this).m18028g();
        try {
            startActivity(m23131V5(z10));
        } catch (ActivityNotFoundException e10) {
            C1442a.m8289e("CloudBackupSpaceInsufficientNewActivity", "jumptoUpgradeActivity error:" + e10.toString());
        }
    }

    /* renamed from: z6 */
    public final void m23153z6() throws JSONException {
        if (this.f16732O1 == null || this.f21452m == null) {
            finish();
            return;
        }
        m22880u5(this.f16732O1, this.f16734Q1, "recommend3_purchase", new ArrayList(), m22882v2(), new ReportVoucherInfo(), this.f21452m.getDeductAmount());
    }
}
