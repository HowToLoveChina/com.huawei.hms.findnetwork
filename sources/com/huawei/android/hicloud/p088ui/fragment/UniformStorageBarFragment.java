package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.huawei.android.hicloud.cloudspace.bean.StorageModuleInfo;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback;
import com.huawei.android.hicloud.commonlib.util.HwAnimationReflection;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.uiextend.HiCloudEndTextLayout;
import com.huawei.android.hicloud.p088ui.uiextend.StorageLabelView;
import com.huawei.android.hicloud.p088ui.uiextend.UniformStorageBar;
import com.huawei.android.hicloud.p088ui.uilistener.CloudSpaceShowDetailsRegionListener;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.hicloud.base.bean.LastMemberInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.base.bean.SpaceFormatSplit;
import com.huawei.hicloud.base.view.widget.HightLightNumView;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0223k;
import p431ko.C11079e;
import p454lj.C11290m;
import p459lp.C11333k;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p616rk.C12515a;
import p684un.C13222a;
import p684un.C13223b;
import p684un.C13227f;
import p684un.C13230i;
import p703v8.C13368e;
import p703v8.C13381r;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class UniformStorageBarFragment extends Fragment implements CloudStorageCallback {

    /* renamed from: C */
    public boolean f18290C;

    /* renamed from: a */
    public View f18292a;

    /* renamed from: c */
    public HwTextView f18294c;

    /* renamed from: i */
    public ProgressBar f18300i;

    /* renamed from: j */
    public long f18301j;

    /* renamed from: k */
    public long f18302k;

    /* renamed from: l */
    public long f18303l;

    /* renamed from: p */
    public ImageView f18307p;

    /* renamed from: r */
    public HiCloudEndTextLayout f18309r;

    /* renamed from: s */
    public Context f18310s;

    /* renamed from: t */
    public HwTextView f18311t;

    /* renamed from: u */
    public RelativeLayout f18312u;

    /* renamed from: v */
    public String f18313v;

    /* renamed from: b */
    public HightLightNumView f18293b = null;

    /* renamed from: d */
    public UniformStorageBar f18295d = null;

    /* renamed from: e */
    public FlexboxLayout f18296e = null;

    /* renamed from: f */
    public View f18297f = null;

    /* renamed from: g */
    public RelativeLayout f18298g = null;

    /* renamed from: h */
    public TextView f18299h = null;

    /* renamed from: m */
    public boolean f18304m = false;

    /* renamed from: n */
    public boolean f18305n = false;

    /* renamed from: o */
    public boolean f18306o = false;

    /* renamed from: q */
    public CloudSpaceShowDetailsRegionListener f18308q = null;

    /* renamed from: w */
    public TextView f18314w = null;

    /* renamed from: x */
    public RelativeLayout f18315x = null;

    /* renamed from: y */
    public RelativeLayout f18316y = null;

    /* renamed from: z */
    public RelativeLayout f18317z = null;

    /* renamed from: A */
    public RelativeLayout f18288A = null;

    /* renamed from: B */
    public boolean f18289B = false;

    /* renamed from: D */
    public boolean f18291D = false;

    /* renamed from: A */
    private void m24339A() {
        HiCloudEndTextLayout hiCloudEndTextLayout;
        if (this.f18300i == null || this.f18293b == null || (hiCloudEndTextLayout = this.f18309r) == null || this.f18307p == null) {
            C11839m.m70687e("UniformStorageBarFragment", "fragStorageValueFrame mLoadingView or storageText or fragStorageRightArrow is null");
            return;
        }
        hiCloudEndTextLayout.setVisibility(0);
        if (this.f18289B) {
            this.f18307p.setVisibility(0);
        }
    }

    /* renamed from: C */
    private void m24340C() throws JSONException, Resources.NotFoundException {
        C11839m.m70686d("UniformStorageBarFragment", "usingStorageCache");
        QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
        if (quotaSpaceInfoM80224M == null) {
            C11839m.m70688i("UniformStorageBarFragment", "cachespace is null");
            this.f18295d.clearAll();
            this.f18296e.setVisibility(8);
            this.f18299h.setVisibility(0);
            this.f18299h.setText(getString(R$string.frag_quering_space));
            return;
        }
        long total = quotaSpaceInfoM80224M.getTotal();
        long used = quotaSpaceInfoM80224M.getUsed();
        String strM67746g = C11290m.m67746g(this.f18310s, total, 1024, true, true);
        String strM1526i = C0223k.m1526i(this.f18310s, used, 1024, true, true);
        SpaceFormatSplit spaceFormatSplitM83088j = C13843a.m83088j(getContext(), quotaSpaceInfoM80224M.getUsed());
        if (this.f18305n) {
            m24353i(strM67746g, strM1526i);
        } else {
            int i10 = R$string.frag_cloud_storage_value_style_2;
            String string = getString(i10, "");
            if (C13843a.m83067S()) {
                this.f18293b.m29165e(i10, string, spaceFormatSplitM83088j.getSize(), getString(R$string.cloudpay_used_total_space, spaceFormatSplitM83088j.getUnit(), strM67746g));
            } else {
                this.f18293b.m29165e(i10, string, " " + spaceFormatSplitM83088j.getSize(), getString(R$string.cloudpay_used_total_space, spaceFormatSplitM83088j.getUnit(), strM67746g));
            }
            C11839m.m70688i("UniformStorageBarFragment", "usingStorageCache usedStr = " + spaceFormatSplitM83088j.getSize() + "" + spaceFormatSplitM83088j.getUnit());
        }
        boolean zM68090e = C11333k.m68086b().m68090e(quotaSpaceInfoM80224M.getAvailable());
        m24351c(strM1526i);
        m24365y(getString(R$string.main_space_display_divider, strM1526i, strM67746g), zM68090e);
        if (zM68090e) {
            this.f18306o = true;
        }
        ArrayList<StorageModuleInfo> arrayListM80220I = C13368e.m80184F().m80220I();
        if (arrayListM80220I == null || arrayListM80220I.size() <= 0) {
            return;
        }
        m24348u();
        this.f18295d.refresh(arrayListM80220I);
        m24349v();
        this.f18306o = true;
    }

    /* renamed from: e */
    private GradientDrawable m24343e(int i10) {
        int iM70840n = C11842p.m70840n(C0213f.m1377a(), 5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(iM70840n);
        return gradientDrawable;
    }

    /* renamed from: f */
    private void m24344f(List<StorageModuleInfo> list) {
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (list == null || list.size() <= 0 || quotaSpaceInfoM80223L == null) {
            C11839m.m70687e("UniformStorageBarFragment", "buildLabelLayout results exception");
            return;
        }
        long used = quotaSpaceInfoM80223L.getUsed();
        try {
            this.f18296e.removeAllViews();
            for (StorageModuleInfo storageModuleInfo : list) {
                StorageLabelView storageLabelView = new StorageLabelView(getContext());
                storageLabelView.setLabelIcon(m24343e(C11842p.m70732H0(getActivity()) ? storageModuleInfo.getModuleDarkColor() : storageModuleInfo.getModuleColor()));
                String moduleName = storageModuleInfo.getModuleName();
                if (!TextUtils.isEmpty(moduleName)) {
                    storageLabelView.setLabelText(moduleName);
                }
                if (storageModuleInfo.getPercent() != 0.0d || used == 0) {
                    this.f18296e.addView(storageLabelView);
                }
            }
            this.f18296e.setVisibility(0);
            this.f18299h.setVisibility(8);
        } catch (Exception e10) {
            C11839m.m70687e("UniformStorageBarFragment", "buildLabelLayout exception: " + e10.toString());
        }
    }

    /* renamed from: g */
    private void m24345g() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "com.huawei.android.ds_spcace_detail_cache", 0);
        sharedPreferencesM1382b.edit().putLong("total_space_sp_key", this.f18301j).commit();
        sharedPreferencesM1382b.edit().putLong("used_space_sp_key", this.f18302k).commit();
        sharedPreferencesM1382b.edit().putLong("available_space_sp_key", this.f18303l).commit();
        sharedPreferencesM1382b.edit().putLong("storage_cache_timestamp", System.currentTimeMillis()).commit();
    }

    /* renamed from: h */
    private void m24346h(long j10, long j11) {
        if (C11333k.m68086b().m68090e(j10)) {
            C11839m.m70688i("UniformStorageBarFragment", "space full, availableSpaceValue=" + j10);
            this.f18299h.setVisibility(8);
            this.f18294c.setTextColor(this.f18310s.getColor(R$color.used_space_full_color));
            return;
        }
        if (j11 != 0) {
            this.f18294c.setTextColor(this.f18290C ? this.f18310s.getColor(R$color.black_text_color) : this.f18310s.getColor(R$color.mian_storage_loading_color));
            this.f18295d.clearSpaceFull();
            return;
        }
        C11839m.m70688i("UniformStorageBarFragment", "space not used, mUsedSpaceValue=" + j11);
        this.f18299h.setVisibility(8);
        this.f18299h.setText(getString(R$string.frag_no_space_use));
        this.f18295d.clearSpaceFull();
        this.f18294c.setTextColor(this.f18310s.getColor(R$color.mian_storage_loading_color));
    }

    /* renamed from: n */
    private boolean m24347n() {
        return C2783d.m16154k0(C0214f0.m1382b(getContext(), "com.huawei.android.ds_spcace_detail_cache", 0).getLong("storage_cache_timestamp", 0L));
    }

    /* renamed from: u */
    private void m24348u() {
        m24344f(C13368e.m80184F().m80218H());
    }

    /* renamed from: v */
    private void m24349v() {
        m24344f(C13368e.m80184F().m80220I());
    }

    /* renamed from: B */
    public void m24350B() {
        UniformStorageBar uniformStorageBar = this.f18295d;
        if (uniformStorageBar != null) {
            uniformStorageBar.updateDirection();
        }
    }

    /* renamed from: c */
    public final void m24351c(final String str) {
        if (this.f18291D) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("bs.userdata.remain.dwnldDays");
            C12515a.m75110o().m75172d(new C11079e(new C11079e.a() { // from class: com.huawei.android.hicloud.ui.fragment.l
                @Override // p431ko.C11079e.a
                /* renamed from: a */
                public final void mo14511a(UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
                    this.f18340a.m24358o(str, userDataStateInfo);
                }
            }, true, arrayList, true, "ExpirationReminderCardView"));
        }
    }

    /* renamed from: d */
    public void m24352d(Context context) {
        C11839m.m70686d("UniformStorageBarFragment", "backUpBasicDataService");
        this.f18295d.setVisibility(0);
        this.f18315x.setVisibility(8);
        this.f18314w.setVisibility(8);
        this.f18317z.setVisibility(0);
        this.f18288A.setVisibility(0);
    }

    /* renamed from: i */
    public final void m24353i(String str, String str2) {
        if (this.f18300i == null || this.f18293b == null || this.f18309r == null || this.f18307p == null) {
            C11839m.m70687e("UniformStorageBarFragment", "mLoadingView or storageText or fragStorageValueFrame or fragStorageRightArrow is null");
            return;
        }
        C11839m.m70688i("UniformStorageBarFragment", "needShowLoading");
        this.f18300i.setVisibility(0);
        this.f18309r.setVisibility(8);
        this.f18307p.setVisibility(8);
    }

    /* renamed from: j */
    public void m24354j() {
        if (!C11829c.m70528K0()) {
            getFragmentManager().beginTransaction().hide(this).commitAllowingStateLoss();
            CloudSpaceShowDetailsRegionListener cloudSpaceShowDetailsRegionListener = this.f18308q;
            if (cloudSpaceShowDetailsRegionListener != null) {
                cloudSpaceShowDetailsRegionListener.mo21122B(false);
                return;
            }
            return;
        }
        if (!m24347n() && this.f18304m) {
            m24340C();
        }
        if (C0209d.m1208S0(getContext())) {
            C13368e.m80184F().m80250o0();
            return;
        }
        m24360r();
        ProgressBar progressBar = this.f18300i;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        m24339A();
    }

    /* renamed from: k */
    public final String m24355k(String str) {
        String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("default_expiration_card_title");
        return !TextUtils.isEmpty(spaceMultLanguage) ? String.format(spaceMultLanguage, str) : this.f18310s.getString(R$string.expiration_card_default_title, str);
    }

    /* renamed from: l */
    public void m24356l(Context context) {
        C11839m.m70686d("UniformStorageBarFragment", "initBasicDataService");
        this.f18316y.setMinimumHeight(C11842p.m70840n(context, 21));
        this.f18295d.setVisibility(8);
        this.f18315x.setVisibility(0);
        this.f18314w.setVisibility(0);
        this.f18317z.setVisibility(8);
        this.f18288A.setVisibility(8);
    }

    /* renamed from: m */
    public void m24357m(boolean z10) {
        if (z10) {
            C11839m.m70686d("UniformStorageBarFragment", "initData getCloudSpace");
            m24354j();
        } else {
            C11839m.m70686d("UniformStorageBarFragment", "initData onQueryStorageFinish");
            mo15483q();
        }
    }

    /* renamed from: o */
    public final /* synthetic */ void m24358o(String str, UserDataStateInfo userDataStateInfo) throws Resources.NotFoundException {
        int remainDwnldDays = userDataStateInfo.getRemainDwnldDays();
        this.f18311t.setVisibility(0);
        if (remainDwnldDays <= 0) {
            this.f18311t.setText(m24355k(str));
        } else {
            this.f18311t.setText(this.f18310s.getResources().getQuantityString(R$plurals.expiration_card_title, remainDwnldDays, str, Integer.valueOf(remainDwnldDays)));
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2;
        C11839m.m70688i("UniformStorageBarFragment", "onCreate");
        C11839m.m70686d("UniformStorageBarFragment", "superview=" + super.onCreateView(layoutInflater, viewGroup, bundle));
        View view = this.f18292a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18292a);
        }
        if (C0209d.m1195O(this.f18310s) >= 1.75f) {
            this.f18292a = layoutInflater.inflate(R$layout.uniform_storage_fragment_layout_font_scale, viewGroup, false);
        } else {
            this.f18292a = layoutInflater.inflate(R$layout.uniform_storage_fragment_layout, viewGroup, false);
        }
        this.f18312u = (RelativeLayout) C12809f.m76831d(this.f18292a, R$id.storage_upgrade_entrance);
        HwTextView hwTextView = (HwTextView) C12809f.m76831d(this.f18292a, R$id.frag_storage_text_title);
        this.f18311t = hwTextView;
        hwTextView.setVisibility(0);
        m24366z();
        HightLightNumView hightLightNumView = (HightLightNumView) C12809f.m76831d(this.f18292a, R$id.frag_storage_value);
        this.f18293b = hightLightNumView;
        hightLightNumView.setVisibility(8);
        this.f18294c = (HwTextView) C12809f.m76831d(this.f18292a, R$id.storage_usage_content);
        UniformStorageBar uniformStorageBar = (UniformStorageBar) C12809f.m76831d(this.f18292a, R$id.frag_storage_bar);
        this.f18295d = uniformStorageBar;
        uniformStorageBar.clearAll();
        this.f18296e = (FlexboxLayout) C12809f.m76831d(this.f18292a, R$id.frag_label_frame);
        this.f18297f = C12809f.m76831d(this.f18292a, R$id.divider);
        this.f18298g = (RelativeLayout) C12809f.m76831d(this.f18292a, R$id.rl_continue_use);
        this.f18299h = (TextView) C12809f.m76831d(this.f18292a, R$id.frag_storage_tips);
        this.f18300i = (ProgressBar) C12809f.m76831d(this.f18292a, R$id.frag_storage_value_loading_progress);
        this.f18309r = (HiCloudEndTextLayout) C12809f.m76831d(this.f18292a, R$id.frag_storage_value_frame);
        this.f18307p = (ImageView) C12809f.m76831d(this.f18292a, R$id.frag_storage_right_arrow);
        this.f18299h.setVisibility(0);
        if (!this.f18304m || m24347n()) {
            this.f18299h.setText(getString(R$string.frag_quering_space));
        }
        this.f18295d.initLayerBackground();
        this.f18315x = (RelativeLayout) C12809f.m76831d(this.f18292a, R$id.frag_storage_desc_text_frame);
        this.f18314w = (TextView) C12809f.m76831d(this.f18292a, R$id.basic_data_service_desc);
        this.f18317z = (RelativeLayout) C12809f.m76831d(this.f18292a, R$id.storage_usage_and_upgrade_layout);
        this.f18288A = (RelativeLayout) C12809f.m76831d(this.f18292a, R$id.manage_space_storagebar_frame);
        this.f18316y = (RelativeLayout) C12809f.m76831d(this.f18292a, R$id.frag_storage_text_frame);
        this.f18290C = C13452e.m80781L().m80887a1();
        return this.f18292a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        UniformStorageBar uniformStorageBar = this.f18295d;
        if (uniformStorageBar != null) {
            uniformStorageBar.clearAll();
        }
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        this.f18310s = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.storage_bar);
        this.f18304m = typedArrayObtainStyledAttributes.getBoolean(R$styleable.storage_bar_use_cache, false);
        this.f18305n = typedArrayObtainStyledAttributes.getBoolean(R$styleable.storage_bar_need_loading, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* renamed from: p */
    public final /* synthetic */ void m24359p(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Bundle bundle = new Bundle();
        bundle.putInt("from_where", 15);
        C13230i.m79522d1(bundle, "1", "7");
        String strM79465g = C13222a.m79465g(getActivity());
        C12126b.m72707c(strM79465g, bundle);
        new HwAnimationReflection(this.f18310s).m15927c(1);
        String strM80790C = C13452e.m80781L().m80790C();
        C13223b.m79478f("manage_member_data_continue_use", "1", C13452e.m80781L().m80971t0(), strM79465g, strM80790C);
        UBAAnalyze.m29960U("PVC", "manage_member_data_continue_use", "1", "7", "1", strM79465g, strM80790C);
        C13227f.m79492i1().m79586g0("mecloud_member_data_cloudspace_click_upgrade", C13452e.m80781L().m80971t0(), strM80790C);
        UBAAnalyze.m29956Q("PVC", "mecloud_member_data_cloudspace_click_upgrade", "1", "7", strM80790C);
    }

    @Override // com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback
    /* renamed from: q */
    public void mo15483q() {
        LastMemberInfo lastMemberInfoM80837O;
        if (!isAdded()) {
            C11839m.m70687e("UniformStorageBarFragment", "onQueryStorageFinish fragment not attached");
            return;
        }
        C11839m.m70688i("UniformStorageBarFragment", "onQueryStorageFinish");
        this.f18296e.setVisibility(0);
        this.f18299h.setVisibility(8);
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L == null) {
            m24360r();
            return;
        }
        long total = quotaSpaceInfoM80223L.getTotal();
        if (this.f18291D && (lastMemberInfoM80837O = C13452e.m80781L().m80837O()) != null) {
            total = lastMemberInfoM80837O.getTotalCapacity();
        }
        C11839m.m70688i("UniformStorageBarFragment", "onQueryStorageFinish totalSize=" + total);
        if (total <= 0 && !this.f18291D) {
            m24360r();
            return;
        }
        ArrayList<StorageModuleInfo> arrayListM80231U = this.f18291D ? C13368e.m80184F().m80231U() : C13368e.m80184F().m80218H();
        if (arrayListM80231U == null && !this.f18291D) {
            C11839m.m70688i("UniformStorageBarFragment", "percents is null ");
            m24360r();
        } else {
            m24348u();
            m24363w();
            this.f18295d.refresh(arrayListM80231U);
            m24345g();
        }
    }

    /* renamed from: r */
    public void m24360r() {
        if (!isAdded()) {
            C11839m.m70687e("UniformStorageBarFragment", "onQueryStorageFailed fragment not attached");
            return;
        }
        C11839m.m70688i("UniformStorageBarFragment", "onQueryStorageFailed");
        if (this.f18306o) {
            return;
        }
        this.f18296e.setVisibility(8);
        this.f18295d.reset();
        this.f18299h.setText(getString(R$string.frag_query_space_failed));
        this.f18299h.setVisibility(0);
    }

    /* renamed from: s */
    public void m24361s() {
        if (C0209d.m1208S0(getContext())) {
            C13381r.m80356a().m80358c();
        } else {
            m24360r();
        }
    }

    /* renamed from: t */
    public void m24362t() {
        UniformStorageBar uniformStorageBar = this.f18295d;
        if (uniformStorageBar != null) {
            uniformStorageBar.initLayerBackground();
        }
    }

    /* renamed from: w */
    public void m24363w() {
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L == null) {
            C11839m.m70687e("UniformStorageBarFragment", "refreshUsedTotalSpace totalInfo null");
            m24360r();
            return;
        }
        this.f18303l = quotaSpaceInfoM80223L.getAvailable();
        this.f18301j = quotaSpaceInfoM80223L.getTotal();
        this.f18302k = quotaSpaceInfoM80223L.getUsed();
        C11839m.m70686d("UniformStorageBarFragment", "onquerystoragefinish usedStorageVaule=" + this.f18302k);
        String strM67746g = C11290m.m67746g(this.f18310s, this.f18301j, 1024, true, true);
        String strM1526i = C0223k.m1526i(this.f18310s, this.f18302k, 1024, true, true);
        SpaceFormatSplit spaceFormatSplitM83088j = C13843a.m83088j(getContext(), this.f18302k);
        int i10 = R$string.frag_cloud_storage_value_style_2;
        String string = getString(i10, "");
        if (TextUtils.isEmpty(spaceFormatSplitM83088j.getUnit()) || TextUtils.isEmpty(strM67746g)) {
            C11839m.m70688i("UniformStorageBarFragment", "MSG_GET_CLOUD_SPACE_SUCCESS query storage failed");
            m24360r();
        } else {
            this.f18293b.m29165e(i10, string, spaceFormatSplitM83088j.getSize(), getString(R$string.cloudpay_used_total_space, spaceFormatSplitM83088j.getUnit(), strM67746g));
            m24351c(strM1526i);
            m24365y(getString(R$string.main_space_display_divider, strM1526i, strM67746g), C11333k.m68086b().m68090e(this.f18303l));
            m24346h(this.f18303l, this.f18302k);
        }
    }

    /* renamed from: x */
    public void m24364x(boolean z10) {
        this.f18291D = z10;
        C12809f.m76843p(this.f18297f, z10);
        C12809f.m76843p(this.f18298g, this.f18291D);
        C12809f.m76843p(this.f18294c, !this.f18291D);
        if (this.f18291D) {
            this.f18316y.setMinimumHeight(C11842p.m70840n(this.f18310s, 21));
            this.f18311t.setTextColor(this.f18310s.getColor(R$color.expansion_service_prompt_text_color));
            this.f18311t.setVisibility(4);
            this.f18298g.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.fragment.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    this.f18339a.m24359p(view);
                }
            });
        }
    }

    /* renamed from: y */
    public final void m24365y(String str, boolean z10) {
        Context context;
        if (this.f18291D) {
            C11839m.m70689w("UniformStorageBarFragment", "setStorageValueText isNewMemberDataManagement is true");
            C12809f.m76843p(this.f18294c, false);
            return;
        }
        HwTextView hwTextView = this.f18294c;
        if (hwTextView != null && (context = this.f18310s) != null) {
            if (z10) {
                hwTextView.setText(context.getString(R$string.used_space_full, C0223k.m1529l(str)));
            } else {
                hwTextView.setText(context.getString(R$string.frag_cloud_storage_value_style_2, C0223k.m1529l(str)));
            }
            if (z10) {
                this.f18294c.setTextColor(this.f18310s.getColor(R$color.used_space_full_color));
            } else {
                this.f18294c.setTextColor(this.f18290C ? this.f18310s.getColor(R$color.black_text_color) : this.f18310s.getColor(R$color.mian_storage_loading_color));
            }
        }
        this.f18313v = str;
    }

    /* renamed from: z */
    public void m24366z() {
        if (this.f18311t == null) {
            C11839m.m70687e("UniformStorageBarFragment", "title text is null");
        } else if (C13452e.m80781L().m80887a1()) {
            this.f18311t.setTypeface(Typeface.create("HwChinese-medium", 1));
        } else {
            this.f18311t.setTypeface(Typeface.create("HwChinese-medium", 0));
        }
    }
}
