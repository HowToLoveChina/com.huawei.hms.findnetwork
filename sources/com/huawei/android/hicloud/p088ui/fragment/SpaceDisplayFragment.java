package com.huawei.android.hicloud.p088ui.fragment;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.huawei.android.hicloud.cloudspace.bean.StorageModuleInfo;
import com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback;
import com.huawei.android.hicloud.common.manager.BasicServicePkgQueryManager;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.ServiceStatusTipsView;
import com.huawei.android.hicloud.p088ui.uiextend.FullDataServiceTipView;
import com.huawei.android.hicloud.p088ui.uiextend.MembershipExpiredView;
import com.huawei.android.hicloud.p088ui.uiextend.StorageLabelView;
import com.huawei.android.hicloud.p088ui.uiextend.UniformStorageBar;
import com.huawei.android.hicloud.p088ui.uilistener.CloudSpaceShowDetailsRegionListener;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.android.p073ds.R$styleable;
import com.huawei.hicloud.base.bean.LastMemberInfo;
import com.huawei.hicloud.base.bean.QuotaSpaceInfo;
import com.huawei.hicloud.notification.spacelanguage.util.SpaceMultLanguageUtil;
import com.huawei.hicloud.request.basic.bean.UserDataStateInfo;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import com.huawei.uikit.phone.hwtextview.widget.HwTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0214f0;
import p015ak.C0223k;
import p015ak.C0226l0;
import p431ko.C11079e;
import p454lj.C11290m;
import p459lp.C11333k;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p572qb.C12299b;
import p616rk.C12515a;
import p703v8.C13368e;
import p703v8.C13381r;
import p709vj.C13452e;
import p780xm.C13834f;
import sk.C12806c;
import sk.C12809f;

/* loaded from: classes3.dex */
public class SpaceDisplayFragment extends Fragment implements CloudStorageCallback, BasicServicePkgQueryManager.OnBasicServiceMinPriceRefresh {

    /* renamed from: A */
    public RelativeLayout f18169A;

    /* renamed from: B */
    public View f18170B;

    /* renamed from: C */
    public View f18171C;

    /* renamed from: D */
    public View f18172D;

    /* renamed from: E */
    public View f18173E;

    /* renamed from: F */
    public Context f18174F;

    /* renamed from: G */
    public View.OnClickListener f18175G;

    /* renamed from: H */
    public TextView f18176H;

    /* renamed from: I */
    public RelativeLayout f18177I;

    /* renamed from: J */
    public LinearLayout f18178J;

    /* renamed from: K */
    public View f18179K;

    /* renamed from: L */
    public HwTextView f18180L;

    /* renamed from: M */
    public ServiceStatusTipsView f18181M;

    /* renamed from: N */
    public TextView f18182N;

    /* renamed from: O */
    public FullDataServiceTipView f18183O;

    /* renamed from: P */
    public FullDataServiceTipView f18184P;

    /* renamed from: Q */
    public MembershipExpiredView f18185Q;

    /* renamed from: R */
    public View f18186R;

    /* renamed from: S */
    public boolean f18187S;

    /* renamed from: T */
    public boolean f18188T;

    /* renamed from: U */
    public LinearLayout f18189U;

    /* renamed from: V */
    public HwProgressBar f18190V;

    /* renamed from: W */
    public RelativeLayout f18191W;

    /* renamed from: X */
    public View f18192X;

    /* renamed from: Y */
    public TextView f18193Y;

    /* renamed from: a */
    public View f18194a;

    /* renamed from: c */
    public HwTextView f18196c;

    /* renamed from: d */
    public String f18197d;

    /* renamed from: e */
    public RelativeLayout f18198e;

    /* renamed from: f */
    public RelativeLayout f18199f;

    /* renamed from: g */
    public RelativeLayout f18200g;

    /* renamed from: h */
    public RelativeLayout f18201h;

    /* renamed from: n */
    public ProgressBar f18207n;

    /* renamed from: q */
    public long f18210q;

    /* renamed from: r */
    public long f18211r;

    /* renamed from: s */
    public long f18212s;

    /* renamed from: x */
    public HwTextView f18217x;

    /* renamed from: y */
    public RelativeLayout f18218y;

    /* renamed from: z */
    public RelativeLayout f18219z;

    /* renamed from: b */
    public HwTextView f18195b = null;

    /* renamed from: i */
    public RelativeLayout f18202i = null;

    /* renamed from: j */
    public View f18203j = null;

    /* renamed from: k */
    public LinearLayout f18204k = null;

    /* renamed from: l */
    public RelativeLayout f18205l = null;

    /* renamed from: m */
    public UniformStorageBar f18206m = null;

    /* renamed from: o */
    public FlexboxLayout f18208o = null;

    /* renamed from: p */
    public TextView f18209p = null;

    /* renamed from: t */
    public boolean f18213t = false;

    /* renamed from: u */
    public boolean f18214u = false;

    /* renamed from: v */
    public boolean f18215v = false;

    /* renamed from: w */
    public CloudSpaceShowDetailsRegionListener f18216w = null;

    /* renamed from: com.huawei.android.hicloud.ui.fragment.SpaceDisplayFragment$a */
    public class ViewTreeObserverOnPreDrawListenerC3971a implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserverOnPreDrawListenerC3971a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            SpaceDisplayFragment.this.f18205l.getViewTreeObserver().removeOnPreDrawListener(this);
            int height = SpaceDisplayFragment.this.f18205l.getHeight();
            int height2 = (SpaceDisplayFragment.this.f18218y == null ? SpaceDisplayFragment.this.f18189U : SpaceDisplayFragment.this.f18218y).getHeight() - C11842p.m70840n(SpaceDisplayFragment.this.getContext(), 40);
            int i10 = height - height2;
            if (SpaceDisplayFragment.this.f18219z != null || SpaceDisplayFragment.this.f18169A != null) {
                C11842p.m70727F1(SpaceDisplayFragment.this.f18219z, i10);
                C11842p.m70727F1(SpaceDisplayFragment.this.f18169A, height2);
            }
            SpaceDisplayFragment.this.m24257J();
            return false;
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.fragment.SpaceDisplayFragment$b */
    public class C3972b implements C11079e.a {
        public C3972b() {
        }

        @Override // p431ko.C11079e.a
        /* renamed from: a */
        public void mo14511a(UserDataStateInfo userDataStateInfo) {
            if (userDataStateInfo == null) {
                return;
            }
            C13452e.m80781L().m80940l1(userDataStateInfo.getBsGrade());
            C13452e.m80781L().m80893b2(userDataStateInfo.getBmGradeState());
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.fragment.i
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f18337a.m24291c();
                }
            });
        }

        /* renamed from: c */
        public final /* synthetic */ void m24291c() throws Resources.NotFoundException {
            SpaceDisplayFragment.this.m24259L(false);
        }
    }

    /* renamed from: Q */
    private void m24234Q() {
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L == null) {
            C11839m.m70687e("SpaceDisplayFragment", "refreshUsedTotalSpace totalInfo null");
            m24254G();
            return;
        }
        this.f18212s = quotaSpaceInfoM80223L.getAvailable();
        this.f18210q = quotaSpaceInfoM80223L.getTotal();
        this.f18211r = quotaSpaceInfoM80223L.getUsed();
        String strM67746g = C11290m.m67746g(getContext(), this.f18210q, 1024, true, true);
        String strM1526i = C0223k.m1526i(getContext(), this.f18211r, 1024, true, true);
        if (TextUtils.isEmpty(strM1526i) || TextUtils.isEmpty(strM67746g)) {
            C11839m.m70688i("SpaceDisplayFragment", "MSG_GET_CLOUD_SPACE_SUCCESS query storage failed");
            m24254G();
        } else {
            m24270X(strM67746g, strM1526i, C11333k.m68086b().m68090e(this.f18212s));
            m24281m(this.f18212s, this.f18211r);
        }
    }

    /* renamed from: d0 */
    public static void m24238d0(final QuotaSpaceInfo quotaSpaceInfo) {
        if (quotaSpaceInfo == null) {
            C11839m.m70689w("SpaceDisplayFragment", "cachedSpaceInfo is null");
        } else {
            C13834f.m82974k(new Callable() { // from class: com.huawei.android.hicloud.ui.fragment.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return SpaceDisplayFragment.m24247y(quotaSpaceInfo);
                }
            }, null);
        }
    }

    /* renamed from: s */
    private void m24244s() {
        RelativeLayout relativeLayout = this.f18205l;
        if (relativeLayout == null) {
            C11839m.m70687e("SpaceDisplayFragment", "fragmentContentLayout is null");
        } else {
            relativeLayout.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC3971a());
        }
    }

    /* renamed from: u */
    private void m24245u() throws Resources.NotFoundException {
        m24259L(true);
        UniformStorageBar uniformStorageBar = this.f18206m;
        if (uniformStorageBar != null) {
            uniformStorageBar.clearAll();
        }
        if (!this.f18213t || m24246w()) {
            this.f18209p.setText(getString(R$string.frag_quering_space));
            m24274b0(true);
        }
        if (C0209d.m1195O(this.f18174F) >= 1.15f && !this.f18187S) {
            m24273a0(this.f18178J, 0);
            m24273a0(this.f18183O, 8);
            m24273a0(this.f18184P, 8);
        }
        UniformStorageBar uniformStorageBar2 = this.f18206m;
        if (uniformStorageBar2 != null) {
            uniformStorageBar2.initLayerBackground();
        }
        BasicServicePkgQueryManager.m15583m().m15594u(this);
    }

    /* renamed from: w */
    private boolean m24246w() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "com.huawei.android.ds_spcace_detail_cache", 0);
        long j10 = 0;
        if (sharedPreferencesM1382b != null) {
            j10 = sharedPreferencesM1382b.getLong("storage_cache_timestamp", 0L);
        } else {
            C11839m.m70688i("SpaceDisplayFragment", "isCacheOutOfDate storageSp is null ");
        }
        return C2783d.m16154k0(j10);
    }

    /* renamed from: y */
    public static /* synthetic */ Object m24247y(QuotaSpaceInfo quotaSpaceInfo) throws Exception {
        ContentValues contentValues = new ContentValues();
        contentValues.put("totalSize", Long.valueOf(quotaSpaceInfo.getTotal()));
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("usedSize", Long.valueOf(quotaSpaceInfo.getUsed()));
        C12299b.m73937s(contentValues);
        C12299b.m73937s(contentValues2);
        return null;
    }

    /* renamed from: A */
    public final void m24248A(View view) {
        this.f18207n = (ProgressBar) C12809f.m76831d(view, R$id.space_entrance_loading_bar);
        this.f18180L = (HwTextView) C12809f.m76831d(view, R$id.storage_service_status);
        this.f18186R = C12809f.m76831d(view, R$id.storage_service_status_layout);
        this.f18183O = (FullDataServiceTipView) C12809f.m76831d(view, R$id.tips_view);
        this.f18185Q = (MembershipExpiredView) C12809f.m76831d(view, R$id.membership_expired_view);
        this.f18195b = (HwTextView) C12809f.m76831d(view, R$id.storage_usage_content);
        this.f18196c = (HwTextView) C12809f.m76831d(view, R$id.storage_usage_title);
        this.f18177I = (RelativeLayout) C12809f.m76831d(view, R$id.rl_manage_space_entrance);
        this.f18201h = (RelativeLayout) C12809f.m76831d(view, R$id.storage_usage_layout);
        this.f18202i = (RelativeLayout) C12809f.m76831d(view, R$id.storage_usage_loading_layout);
        this.f18203j = C12809f.m76831d(view, R$id.storage_usage_and_upgrade_layout);
    }

    /* renamed from: B */
    public final boolean m24249B() {
        return C13452e.m80781L().m80791C0() && (!this.f18188T || C13368e.m80184F().m80230T() <= 0);
    }

    /* renamed from: C */
    public final void m24250C(View view) {
        this.f18199f = (RelativeLayout) C12809f.m76831d(view, R$id.storage_upgrade_entrance);
        this.f18200g = (RelativeLayout) C12809f.m76831d(view, R$id.base_upgrade_entrance);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.upgrade_space_text);
        this.f18176H = textView;
        textView.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("low_space_tip_buy_new"));
        this.f18181M = (ServiceStatusTipsView) C12809f.m76831d(view, R$id.service_status_tips);
        this.f18179K = C12809f.m76831d(view, R$id.storage_bra);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.manage_space_storagebar_frame);
        this.f18198e = relativeLayout;
        relativeLayout.setAccessibilityDelegate(C2783d.m16078D0());
        this.f18218y = (RelativeLayout) C12809f.m76831d(view, R$id.storage_manage_layout);
        this.f18206m = (UniformStorageBar) C12809f.m76831d(view, R$id.frag_storage_bar);
        this.f18182N = (TextView) C12809f.m76831d(view, R$id.base_upgrade);
        this.f18208o = (FlexboxLayout) C12809f.m76831d(view, R$id.frag_label_frame);
        this.f18209p = (TextView) C12809f.m76831d(view, R$id.frag_storage_tips);
        this.f18177I = (RelativeLayout) C12809f.m76831d(view, R$id.rl_manage_space_entrance);
        this.f18207n = (ProgressBar) C12809f.m76831d(view, R$id.space_entrance_loading_bar);
        this.f18217x = (HwTextView) C12809f.m76831d(view, R$id.manage_space_entrance);
        this.f18178J = (LinearLayout) C12809f.m76831d(view, R$id.ll_storage_manager);
        this.f18209p.setVisibility(0);
        C11842p.m70721D1(this.f18217x, 2.0f);
        C11842p.m70721D1(this.f18176H, 2.0f);
        m24269W();
        m24287v(this.f18175G);
    }

    /* renamed from: D */
    public final void m24251D(View view) {
        this.f18180L = (HwTextView) C12809f.m76831d(view, R$id.storage_service_status);
        this.f18186R = C12809f.m76831d(view, R$id.storage_service_status_layout);
        this.f18183O = (FullDataServiceTipView) C12809f.m76831d(view, R$id.tips_view);
        this.f18195b = (HwTextView) C12809f.m76831d(view, R$id.storage_usage_content);
        this.f18196c = (HwTextView) C12809f.m76831d(view, R$id.storage_usage_title);
        this.f18201h = (RelativeLayout) C12809f.m76831d(view, R$id.storage_usage_layout);
        this.f18202i = (RelativeLayout) C12809f.m76831d(view, R$id.storage_usage_loading_layout);
        this.f18203j = C12809f.m76831d(view, R$id.storage_usage_and_upgrade_layout);
    }

    /* renamed from: E */
    public final void m24252E(View view) {
        this.f18195b = (HwTextView) C12809f.m76831d(view, R$id.storage_usage_content);
        this.f18196c = (HwTextView) C12809f.m76831d(view, R$id.storage_usage_title);
        this.f18201h = (RelativeLayout) C12809f.m76831d(view, R$id.storage_usage_layout);
        this.f18202i = (RelativeLayout) C12809f.m76831d(view, R$id.storage_usage_loading_layout);
        this.f18203j = C12809f.m76831d(view, R$id.storage_usage_and_upgrade_layout);
        this.f18183O = (FullDataServiceTipView) C12809f.m76831d(view, R$id.tips_view);
        this.f18184P = (FullDataServiceTipView) C12809f.m76831d(view, R$id.tips_view_below);
    }

    /* renamed from: F */
    public final void m24253F(View view) {
        this.f18217x = (HwTextView) C12809f.m76831d(view, R$id.manage_space_entrance);
        this.f18207n = (ProgressBar) C12809f.m76831d(view, R$id.space_entrance_loading_bar);
        this.f18177I = (RelativeLayout) C12809f.m76831d(view, R$id.rl_manage_space_entrance);
        RelativeLayout relativeLayout = (RelativeLayout) C12809f.m76831d(view, R$id.manage_space_storagebar_frame);
        this.f18198e = relativeLayout;
        relativeLayout.setAccessibilityDelegate(C2783d.m16078D0());
        this.f18218y = (RelativeLayout) C12809f.m76831d(view, R$id.storage_manage_layout);
        this.f18206m = (UniformStorageBar) C12809f.m76831d(view, R$id.frag_storage_bar);
        this.f18178J = (LinearLayout) C12809f.m76831d(view, R$id.ll_storage_manager);
        this.f18199f = (RelativeLayout) C12809f.m76831d(view, R$id.storage_upgrade_entrance);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.upgrade_space_text);
        this.f18176H = textView;
        textView.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("low_space_tip_buy_new"));
        this.f18208o = (FlexboxLayout) C12809f.m76831d(view, R$id.frag_label_frame);
        TextView textView2 = (TextView) C12809f.m76831d(view, R$id.frag_storage_tips);
        this.f18209p = textView2;
        textView2.setVisibility(0);
        C11842p.m70721D1(this.f18217x, 2.0f);
        C11842p.m70721D1(this.f18176H, 2.0f);
        m24269W();
        m24287v(this.f18175G);
    }

    /* renamed from: G */
    public void m24254G() {
        if (!isAdded()) {
            C11839m.m70687e("SpaceDisplayFragment", "onQueryStorageFailed fragment not attached");
            return;
        }
        C11839m.m70688i("SpaceDisplayFragment", "onQueryStorageFailed");
        if (!this.f18215v) {
            FlexboxLayout flexboxLayout = this.f18208o;
            if (flexboxLayout == null || this.f18206m == null || this.f18209p == null) {
                return;
            }
            flexboxLayout.setVisibility(8);
            this.f18206m.reset();
            this.f18209p.setText(getString(R$string.frag_query_space_failed));
            this.f18209p.setVisibility(0);
            m24271Y(getString(R$string.main_query_storage_fail_text), false);
        }
        m24285r();
    }

    /* renamed from: H */
    public void m24255H() {
        if (C0209d.m1208S0(getContext())) {
            C13381r.m80356a().m80358c();
        } else {
            m24254G();
        }
    }

    /* renamed from: I */
    public void m24256I() {
        UniformStorageBar uniformStorageBar = this.f18206m;
        if (uniformStorageBar != null) {
            uniformStorageBar.initLayerBackground();
        }
    }

    /* renamed from: J */
    public final void m24257J() {
        HwTextView hwTextView;
        LinearLayout linearLayout = this.f18178J;
        if (linearLayout == null || linearLayout.getVisibility() == 8 || (hwTextView = this.f18217x) == null || this.f18176H == null) {
            return;
        }
        int iMax = Math.max(hwTextView.getHeight(), this.f18176H.getHeight());
        View viewM76831d = C12809f.m76831d(this.f18178J, R$id.v_manage);
        View viewM76831d2 = C12809f.m76831d(this.f18178J, R$id.v_storage);
        if (viewM76831d == null || viewM76831d2 == null || Math.min(viewM76831d.getHeight(), viewM76831d2.getHeight()) == iMax) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewM76831d.getLayoutParams();
        layoutParams.height = iMax;
        viewM76831d.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = viewM76831d2.getLayoutParams();
        layoutParams2.height = iMax;
        viewM76831d2.setLayoutParams(layoutParams2);
    }

    /* renamed from: K */
    public void m24258K() {
        m24259L(false);
        m24244s();
    }

    /* renamed from: L */
    public void m24259L(boolean z10) throws Resources.NotFoundException {
        boolean zM80887a1 = C13452e.m80781L().m80887a1();
        boolean z11 = C13452e.m80781L().m80798E() == 0 && C13452e.m80781L().m80791C0();
        C11839m.m70688i("SpaceDisplayFragment", "isMembershipExpired " + this.f18188T + "isExpired " + z11);
        if (zM80887a1 != this.f18187S || z10 || z11 != this.f18188T) {
            C11839m.m70688i("SpaceDisplayFragment", "bmType same");
            this.f18188T = z11;
            m24282n(zM80887a1, z11);
            if (!this.f18188T) {
                m24256I();
            }
            if (!z10) {
                m24286t(true);
            }
        }
        this.f18187S = zM80887a1;
        if (!zM80887a1) {
            m24273a0(this.f18182N, 8);
            this.f18170B.setVisibility(0);
            this.f18172D.setVisibility(0);
            m24273a0(this.f18186R, 8);
            m24267U();
            View view = this.f18173E;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.f18171C;
            if (view2 != null) {
                view2.setVisibility(8);
                return;
            }
            return;
        }
        this.f18173E.setVisibility(0);
        this.f18171C.setVisibility(0);
        View view3 = this.f18170B;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.f18172D;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        m24273a0(this.f18183O, 8);
        m24273a0(this.f18184P, 8);
        if (!C13452e.m80781L().m80791C0()) {
            m24273a0(this.f18178J, 0);
            m24273a0(this.f18201h, 0);
            m24273a0(this.f18177I, 0);
            m24273a0(this.f18181M, 0);
            m24273a0(this.f18179K, 0);
            m24273a0(this.f18191W, 8);
            m24273a0(this.f18192X, 8);
            m24273a0(this.f18193Y, 8);
            m24273a0(this.f18189U, 8);
            m24273a0(this.f18185Q, 8);
            m24273a0(this.f18182N, 8);
            m24273a0(this.f18203j, 0);
            m24260M();
            FullDataServiceTipView fullDataServiceTipView = this.f18183O;
            if (fullDataServiceTipView != null) {
                fullDataServiceTipView.show();
                m24272Z(this.f18180L, this.f18183O);
            }
            m24273a0(this.f18186R, 0);
            return;
        }
        HwTextView hwTextView = this.f18180L;
        if (hwTextView != null) {
            hwTextView.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_home_page_basic_server_des"));
        }
        m24273a0(this.f18178J, 8);
        m24273a0(this.f18179K, 8);
        if (!this.f18188T || C13368e.m80184F().m80230T() <= 0) {
            m24288x(BasicServicePkgQueryManager.m15583m().m15586l());
            BasicServicePkgQueryManager.m15583m().m15590q();
            this.f18182N.setVisibility(0);
            m24273a0(this.f18186R, 0);
            m24273a0(this.f18185Q, 8);
            m24273a0(this.f18201h, 8);
            m24273a0(this.f18177I, 8);
            m24273a0(this.f18180L, 0);
            m24273a0(this.f18186R, 0);
            m24273a0(this.f18189U, 8);
            m24273a0(this.f18181M, 0);
            m24273a0(this.f18193Y, 8);
            m24273a0(this.f18191W, 8);
            m24273a0(this.f18192X, 8);
            m24273a0(this.f18203j, 8);
            return;
        }
        this.f18182N.setVisibility(8);
        LastMemberInfo lastMemberInfoM80837O = C13452e.m80781L().m80837O();
        m24273a0(this.f18186R, 8);
        m24273a0(this.f18177I, 8);
        if (C13452e.m80781L().m80823K0()) {
            m24273a0(this.f18191W, 8);
            m24273a0(this.f18192X, 8);
        } else {
            m24273a0(this.f18191W, 0);
            m24273a0(this.f18192X, 0);
        }
        m24273a0(this.f18181M, 8);
        m24273a0(this.f18201h, 0);
        m24273a0(this.f18189U, 0);
        m24273a0(this.f18186R, 8);
        m24273a0(this.f18193Y, 0);
        m24273a0(this.f18203j, 0);
        if (lastMemberInfoM80837O == null) {
            m24273a0(this.f18185Q, 8);
            this.f18190V.setProgress(10000);
            return;
        }
        long totalCapacity = lastMemberInfoM80837O.getTotalCapacity();
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (totalCapacity <= 0 || quotaSpaceInfoM80223L == null) {
            this.f18190V.setProgress(10000);
            m24273a0(this.f18185Q, 8);
        } else {
            this.f18190V.setProgress((int) ((quotaSpaceInfoM80223L.getUsed() * 10000) / totalCapacity));
            m24273a0(this.f18185Q, 0);
            m24270X(C11290m.m67746g(getContext(), quotaSpaceInfoM80223L.getTotal(), 1024, true, true), C0223k.m1526i(getContext(), quotaSpaceInfoM80223L.getUsed(), 1024, true, true), false);
        }
        this.f18185Q.setText(lastMemberInfoM80837O.getExpireDays());
    }

    /* renamed from: M */
    public void m24260M() {
        if (C13452e.m80781L().m80887a1()) {
            if (C13452e.m80781L().m80838O0()) {
                if (this.f18180L != null) {
                    if (C13452e.m80781L().m80902d1()) {
                        this.f18180L.setText("Petal One");
                    } else {
                        HwTextView hwTextView = this.f18180L;
                        Context context = this.f18174F;
                        hwTextView.setText(context.getString(R$string.cloud_and_petalone, context.getString(R$string.basic_full_data_service), "Petal One"));
                    }
                }
                m24234Q();
                return;
            }
            if (C13452e.m80781L().m80791C0()) {
                HwTextView hwTextView2 = this.f18180L;
                if (hwTextView2 != null) {
                    hwTextView2.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_home_page_basic_server_des"));
                    return;
                }
                return;
            }
            HwTextView hwTextView3 = this.f18180L;
            if (hwTextView3 != null) {
                hwTextView3.setText(this.f18174F.getString(R$string.basic_full_data_service));
            }
        }
    }

    /* renamed from: N */
    public void m24261N() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("bs.grade");
        arrayList.add("bs.bm.grade.state");
        C12515a.m75110o().m75172d(new C11079e(new C3972b(), true, arrayList, "SpaceRefresh"));
    }

    /* renamed from: O */
    public final void m24262O() {
        m24279k(C13368e.m80184F().m80218H());
    }

    /* renamed from: P */
    public final void m24263P() {
        m24279k(C13368e.m80184F().m80220I());
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public final void m24288x(String str) {
        if (this.f18174F == null || this.f18182N == null) {
            C11839m.m70689w("SpaceDisplayFragment", "mContext or basicUpgradeText is null");
            return;
        }
        String strM80921h0 = C13452e.m80781L().m80921h0();
        String strM80942m = C13452e.m80781L().m80942m();
        String string = this.f18174F.getString(R$string.upgrade_member_services);
        C11839m.m70688i("SpaceDisplayFragment", "serviceCountry is " + strM80921h0 + ",country is " + strM80942m);
        if ("CN".equals(strM80921h0) && "CN".equals(strM80942m)) {
            if (TextUtils.isEmpty(str)) {
                String spaceMultLanguage = SpaceMultLanguageUtil.getSpaceMultLanguage("cloud_home_page_basic_server_sub_tips");
                if (!TextUtils.isEmpty(spaceMultLanguage)) {
                    string = spaceMultLanguage;
                }
            } else {
                string = this.f18174F.getString(R$string.upgrade_service_tip, str);
            }
        }
        this.f18182N.setText(string);
    }

    /* renamed from: S */
    public void m24265S(CloudSpaceShowDetailsRegionListener cloudSpaceShowDetailsRegionListener) {
        this.f18216w = cloudSpaceShowDetailsRegionListener;
    }

    /* renamed from: T */
    public final void m24266T() {
        LinearLayout linearLayout;
        Context context;
        if (!C0209d.m1293p1() || (linearLayout = this.f18204k) == null || (context = this.f18174F) == null) {
            return;
        }
        linearLayout.setBackground(context.getDrawable(R$drawable.storage_manage_cardview_list_ink));
    }

    /* renamed from: U */
    public final void m24267U() throws Resources.NotFoundException {
        if (this.f18183O == null || this.f18184P == null) {
            return;
        }
        if (C0209d.m1195O(this.f18174F) >= 1.15f) {
            m24273a0(this.f18183O, 8);
            this.f18184P.show();
        } else {
            m24273a0(this.f18184P, 8);
            this.f18183O.show();
            m24272Z(this.f18195b, this.f18183O);
        }
    }

    /* renamed from: V */
    public void m24268V(View.OnClickListener onClickListener) {
        this.f18175G = onClickListener;
    }

    /* renamed from: W */
    public void m24269W() {
        if (this.f18217x == null) {
            C11839m.m70687e("SpaceDisplayFragment", "title text is null");
            return;
        }
        if (!C13452e.m80781L().m80887a1()) {
            this.f18217x.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("manage_space"));
        } else if (this.f18188T) {
            this.f18217x.setText(getString(R$string.storage_service_expired_menu));
        } else {
            this.f18217x.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("manage_space"));
        }
    }

    /* renamed from: X */
    public final void m24270X(String str, String str2, boolean z10) {
        if (!this.f18188T) {
            m24271Y(getString(R$string.cloudpay_used_total_space, str2, str), z10);
            return;
        }
        LastMemberInfo lastMemberInfoM80837O = C13452e.m80781L().m80837O();
        if (lastMemberInfoM80837O == null) {
            m24271Y(str2, false);
            return;
        }
        long totalCapacity = lastMemberInfoM80837O.getTotalCapacity();
        if (totalCapacity <= 0) {
            m24271Y(str2, false);
        } else {
            m24271Y(getString(R$string.cloudpay_used_total_space, str2, C0223k.m1526i(getContext(), totalCapacity, 1024, true, true)), false);
        }
    }

    /* renamed from: Y */
    public final void m24271Y(String str, boolean z10) {
        Context context;
        if (this.f18195b != null && (context = this.f18174F) != null) {
            if (z10) {
                this.f18195b.setText(context.getString(R$string.used_space_full, C0223k.m1529l(str)));
                this.f18195b.setTextColor(this.f18174F.getColor(R$color.full_data_service_remain_link_text_color));
            } else {
                this.f18195b.setText(context.getString(R$string.frag_cloud_storage_value_style_2, C0223k.m1529l(str)));
                this.f18195b.setTextColor(this.f18174F.getColor(R$color.black_text_color));
            }
        }
        this.f18197d = str;
        m24274b0(false);
        m24244s();
    }

    /* renamed from: Z */
    public final void m24272Z(TextView textView, View view) {
        if (textView == null || textView.getVisibility() == 8) {
            return;
        }
        if (view == null || view.getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = -2;
            textView.setLayoutParams(layoutParams);
        } else if (C0209d.m1195O(this.f18174F) >= 1.15f) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = -2;
            textView.setLayoutParams(layoutParams2);
        } else {
            int iM70752O = C11842p.m70753O0(this.f18174F) ? C11842p.m70752O(this.f18174F) : C11842p.m70758Q(this.f18174F);
            int iM70840n = (iM70752O - (C11842p.m70840n(this.f18174F, 24) * 2)) / 2;
            if (!this.f18187S) {
                iM70840n = ((iM70752O - (C11842p.m70840n(this.f18174F, 24) * 2)) * 2) / 3;
            }
            textView.setMaxWidth(iM70840n);
        }
    }

    @Override // com.huawei.android.hicloud.common.manager.BasicServicePkgQueryManager.OnBasicServiceMinPriceRefresh
    /* renamed from: a */
    public void mo15595a(final String str) {
        C0226l0.m1586f(new Runnable() { // from class: com.huawei.android.hicloud.ui.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f18334a.m24288x(str);
            }
        });
    }

    /* renamed from: a0 */
    public final void m24273a0(View view, int i10) {
        if (view != null) {
            view.setVisibility(i10);
        }
    }

    /* renamed from: b0 */
    public final void m24274b0(boolean z10) {
        RelativeLayout relativeLayout = this.f18202i;
        if (relativeLayout == null || this.f18195b == null) {
            C11839m.m70687e("SpaceDisplayFragment", "showStorageLoadingView error layout is null");
            return;
        }
        if (z10) {
            relativeLayout.setVisibility(0);
            this.f18195b.setVisibility(4);
        } else {
            relativeLayout.setVisibility(8);
            this.f18195b.setVisibility(0);
        }
        m24244s();
    }

    /* renamed from: c0 */
    public void m24275c0() {
        ProgressBar progressBar = this.f18207n;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    /* renamed from: e0 */
    public void m24276e0() {
        UniformStorageBar uniformStorageBar = this.f18206m;
        if (uniformStorageBar != null) {
            uniformStorageBar.updateDirection();
        }
    }

    /* renamed from: f0 */
    public final void m24277f0() throws JSONException {
        QuotaSpaceInfo quotaSpaceInfoM80224M = C13368e.m80184F().m80224M();
        if (quotaSpaceInfoM80224M == null) {
            C11839m.m70688i("SpaceDisplayFragment", "usingStorageCache == null");
            UniformStorageBar uniformStorageBar = this.f18206m;
            if (uniformStorageBar != null) {
                uniformStorageBar.clearAll();
            }
            m24273a0(this.f18208o, 8);
            TextView textView = this.f18209p;
            if (textView != null) {
                textView.setVisibility(0);
                this.f18209p.setText(getString(R$string.frag_quering_space));
            }
            m24274b0(true);
            return;
        }
        String strM67746g = C11290m.m67746g(getContext(), quotaSpaceInfoM80224M.getTotal(), 1024, true, true);
        String strM1526i = C0223k.m1526i(getContext(), quotaSpaceInfoM80224M.getUsed(), 1024, true, true);
        m24238d0(quotaSpaceInfoM80224M);
        C11839m.m70688i("SpaceDisplayFragment", "usingStorageCache " + strM67746g + " " + strM1526i);
        m24270X(strM67746g, strM1526i, C11333k.m68086b().m68090e(quotaSpaceInfoM80224M.getAvailable()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("usingStorageCache usedStr = ");
        sb2.append(strM1526i);
        C11839m.m70688i("SpaceDisplayFragment", sb2.toString());
        if (C11333k.m68086b().m68090e(quotaSpaceInfoM80224M.getAvailable())) {
            this.f18215v = true;
        }
        ArrayList<StorageModuleInfo> arrayListM80220I = C13368e.m80184F().m80220I();
        if (arrayListM80220I == null || arrayListM80220I.size() <= 0) {
            return;
        }
        m24262O();
        UniformStorageBar uniformStorageBar2 = this.f18206m;
        if (uniformStorageBar2 != null) {
            uniformStorageBar2.refresh(arrayListM80220I);
        }
        m24263P();
        this.f18215v = true;
    }

    /* renamed from: j */
    public final GradientDrawable m24278j(int i10) {
        int iM70840n = C11842p.m70840n(C0213f.m1377a(), 5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(iM70840n);
        return gradientDrawable;
    }

    /* renamed from: k */
    public final void m24279k(List<StorageModuleInfo> list) {
        if (this.f18188T) {
            return;
        }
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (list == null || list.size() <= 0 || quotaSpaceInfoM80223L == null) {
            C11839m.m70687e("SpaceDisplayFragment", "buildLabelLayout results exception");
            return;
        }
        long used = quotaSpaceInfoM80223L.getUsed();
        try {
            Collections.sort(list);
            this.f18208o.removeAllViews();
            for (StorageModuleInfo storageModuleInfo : list) {
                StorageLabelView storageLabelView = new StorageLabelView(getContext());
                storageLabelView.setLabelIcon(m24278j(C11842p.m70732H0(getActivity()) ? storageModuleInfo.getModuleDarkColor() : storageModuleInfo.getModuleColor()));
                String moduleName = storageModuleInfo.getModuleName();
                if (!TextUtils.isEmpty(moduleName)) {
                    storageLabelView.setLabelText(moduleName);
                }
                if (storageModuleInfo.getPercent() != 0.0d || used == 0) {
                    this.f18208o.addView(storageLabelView);
                }
            }
            this.f18208o.setVisibility(0);
            this.f18209p.setVisibility(8);
        } catch (Exception e10) {
            C11839m.m70687e("SpaceDisplayFragment", "buildLabelLayout exception: " + e10.toString());
        }
    }

    /* renamed from: l */
    public final void m24280l() {
        SharedPreferences sharedPreferencesM1382b = C0214f0.m1382b(getContext(), "com.huawei.android.ds_spcace_detail_cache", 0);
        if (sharedPreferencesM1382b == null) {
            C11839m.m70687e("SpaceDisplayFragment", "cachePercent userInfoSp is null");
            return;
        }
        sharedPreferencesM1382b.edit().putLong("total_space_sp_key", this.f18210q).commit();
        sharedPreferencesM1382b.edit().putLong("used_space_sp_key", this.f18211r).commit();
        sharedPreferencesM1382b.edit().putLong("available_space_sp_key", this.f18212s).commit();
        sharedPreferencesM1382b.edit().putLong("storage_cache_timestamp", System.currentTimeMillis()).commit();
    }

    /* renamed from: m */
    public final void m24281m(long j10, long j11) {
        if (this.f18188T) {
            return;
        }
        if (C11333k.m68086b().m68090e(j10)) {
            C11839m.m70688i("SpaceDisplayFragment", "space full, availableSpaceValue=" + j10);
            this.f18209p.setVisibility(8);
            this.f18209p.setText(getString(R$string.sapce_fill_detail_title));
            return;
        }
        if (j11 != 0) {
            this.f18206m.clearSpaceFull();
            return;
        }
        C11839m.m70688i("SpaceDisplayFragment", "space not used, mUsedSpaceValue=" + j11);
        this.f18209p.setVisibility(8);
        this.f18206m.clearSpaceFull();
    }

    /* renamed from: n */
    public final void m24282n(boolean z10, boolean z11) {
        C11839m.m70688i("SpaceDisplayFragment", "findView  isNewBmType" + z10 + " isMembershipExpired " + z11);
        float fM1195O = C0209d.m1195O(this.f18174F);
        if (z10) {
            if (this.f18173E == null) {
                if (fM1195O >= 1.15f) {
                    this.f18173E = m24283o(this.f18194a, R$id.business_manage_title_scale).inflate();
                } else {
                    this.f18173E = m24283o(this.f18194a, R$id.business_manage_title).inflate();
                }
            }
            if (z11) {
                m24248A(this.f18173E);
            } else {
                m24251D(this.f18173E);
            }
        } else {
            if (this.f18172D == null) {
                this.f18172D = m24283o(this.f18194a, R$id.storage_manage_title).inflate();
            }
            m24252E(this.f18172D);
        }
        if (!z10) {
            if (this.f18170B == null) {
                if (fM1195O >= 1.15f) {
                    this.f18170B = m24283o(this.f18194a, R$id.storage_manage_stub_font_scale).inflate();
                } else {
                    this.f18170B = m24283o(this.f18194a, R$id.storage_manage_stub).inflate();
                }
            }
            m24253F(this.f18170B);
            return;
        }
        if (this.f18171C == null) {
            this.f18171C = m24283o(this.f18194a, R$id.storage_manage_business_stub).inflate();
        }
        if (z11) {
            m24289z(this.f18171C);
        } else {
            m24250C(this.f18171C);
        }
    }

    /* renamed from: o */
    public final ViewStub m24283o(View view, int i10) {
        if (view == null) {
            return null;
        }
        View viewFindViewById = view.findViewById(i10);
        if (viewFindViewById instanceof ViewStub) {
            return (ViewStub) viewFindViewById;
        }
        return null;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C11839m.m70686d("SpaceDisplayFragment", "onConfigurationChanged");
        super.onConfigurationChanged(configuration);
        m24276e0();
        if (C13452e.m80781L().m80858T0()) {
            m24272Z(this.f18180L, this.f18183O);
        } else {
            m24272Z(this.f18195b, this.f18183O);
        }
        C11842p.m70726F0(this.f18204k, getContext());
        m24244s();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        ViewGroup viewGroup2;
        C11839m.m70688i("SpaceDisplayFragment", "onCreate");
        C11839m.m70686d("SpaceDisplayFragment", "superview=" + super.onCreateView(layoutInflater, viewGroup, bundle));
        View view = this.f18194a;
        if (view != null && (viewGroup2 = (ViewGroup) view.getParent()) != null) {
            viewGroup2.removeView(this.f18194a);
        }
        this.f18187S = C13452e.m80781L().m80887a1();
        this.f18188T = C13452e.m80781L().m80798E() == 0 && C13452e.m80781L().m80791C0();
        C11839m.m70688i("SpaceDisplayFragment", "isMembershipExpired" + this.f18188T);
        View viewInflate = layoutInflater.inflate(R$layout.space_display_fragment_layout, viewGroup, false);
        this.f18194a = viewInflate;
        this.f18204k = (LinearLayout) C12809f.m76831d(viewInflate, R$id.fragment_content_layout);
        this.f18205l = (RelativeLayout) C12809f.m76831d(this.f18194a, R$id.notch_fragment_layout);
        this.f18219z = (RelativeLayout) C12809f.m76831d(this.f18194a, R$id.blue_region);
        this.f18169A = (RelativeLayout) C12809f.m76831d(this.f18194a, R$id.white_region);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f18205l);
        C12806c.m76817h(this.f18174F, arrayList);
        m24266T();
        m24244s();
        C11842p.m70726F0(this.f18204k, getContext());
        m24245u();
        return this.f18194a;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        UniformStorageBar uniformStorageBar = this.f18206m;
        if (uniformStorageBar != null) {
            uniformStorageBar.clearAll();
        }
    }

    @Override // android.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        this.f18174F = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.storage_bar);
        this.f18213t = typedArrayObtainStyledAttributes.getBoolean(R$styleable.storage_bar_use_cache, false);
        this.f18214u = typedArrayObtainStyledAttributes.getBoolean(R$styleable.storage_bar_need_loading, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.app.Fragment
    public void onResume() {
        C11839m.m70686d("SpaceDisplayFragment", "onResume");
        if (m24249B()) {
            BasicServicePkgQueryManager.m15583m().m15590q();
        }
        super.onResume();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    /* renamed from: p */
    public void m24284p() {
        C11839m.m70686d("SpaceDisplayFragment", "getCloudSpace");
        if (!C11829c.m70528K0()) {
            getFragmentManager().beginTransaction().hide(this).commitAllowingStateLoss();
            CloudSpaceShowDetailsRegionListener cloudSpaceShowDetailsRegionListener = this.f18216w;
            if (cloudSpaceShowDetailsRegionListener != null) {
                cloudSpaceShowDetailsRegionListener.mo21122B(false);
                return;
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getCloudSpace");
        sb2.append(!m24246w());
        sb2.append("  ");
        sb2.append(this.f18213t);
        C11839m.m70688i("SpaceDisplayFragment", sb2.toString());
        if (m24246w() || !this.f18213t) {
            m24274b0(true);
            m24275c0();
        } else {
            m24277f0();
        }
        if (C0209d.m1208S0(getContext())) {
            C13368e.m80184F().m80250o0();
        } else {
            m24254G();
        }
    }

    @Override // com.huawei.android.hicloud.cloudspace.manager.CloudStorageCallback
    /* renamed from: q */
    public void mo15483q() {
        if (!isAdded()) {
            C11839m.m70687e("SpaceDisplayFragment", "onQueryStorageFinish fragment not attached");
            return;
        }
        C11839m.m70688i("SpaceDisplayFragment", "onQueryStorageFinish");
        FlexboxLayout flexboxLayout = this.f18208o;
        if (flexboxLayout != null) {
            flexboxLayout.setVisibility(0);
        }
        m24273a0(this.f18209p, 8);
        m24274b0(false);
        QuotaSpaceInfo quotaSpaceInfoM80223L = C13368e.m80184F().m80223L();
        if (quotaSpaceInfoM80223L == null) {
            m24254G();
            return;
        }
        long total = quotaSpaceInfoM80223L.getTotal();
        C11839m.m70688i("SpaceDisplayFragment", "onQueryStorageFinish totalSize=" + total);
        if (this.f18188T) {
            LastMemberInfo lastMemberInfoM80837O = C13452e.m80781L().m80837O();
            if (lastMemberInfoM80837O != null) {
                total = lastMemberInfoM80837O.getTotalCapacity();
            }
            m24270X(C11290m.m67746g(getContext(), total, 1024, true, true), C0223k.m1526i(getContext(), quotaSpaceInfoM80223L.getUsed(), 1024, true, true), false);
            m24280l();
            return;
        }
        if (C13452e.m80781L().m80887a1() && C13452e.m80781L().m80791C0() && total <= 0) {
            C11839m.m70687e("SpaceDisplayFragment", "onQueryStorageFinish isBasicBusiness ");
            return;
        }
        if (total <= 0) {
            m24254G();
            return;
        }
        ArrayList<StorageModuleInfo> arrayListM80218H = C13368e.m80184F().m80218H();
        if (arrayListM80218H == null) {
            m24254G();
            return;
        }
        m24262O();
        m24234Q();
        UniformStorageBar uniformStorageBar = this.f18206m;
        if (uniformStorageBar != null) {
            uniformStorageBar.refresh(arrayListM80218H);
        }
        m24280l();
    }

    /* renamed from: r */
    public void m24285r() {
        ProgressBar progressBar = this.f18207n;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* renamed from: t */
    public void m24286t(boolean z10) {
        if (z10) {
            m24284p();
        } else {
            mo15483q();
        }
    }

    /* renamed from: v */
    public void m24287v(View.OnClickListener onClickListener) {
        TextView textView;
        m24268V(onClickListener);
        RelativeLayout relativeLayout = this.f18199f;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(onClickListener);
            if (C0209d.m1293p1() && (textView = this.f18176H) != null) {
                textView.setTextColor(this.f18174F.getColor(R$color.ink_color_black));
                this.f18199f.setBackground(this.f18174F.getDrawable(R$drawable.main_upgrade_entrance_ink));
                Resources resources = getResources();
                if (resources != null) {
                    C11842p.m70819h2(this.f18199f, resources.getDimensionPixelSize(R$dimen.cloud_space_12_dp));
                }
            }
        }
        RelativeLayout relativeLayout2 = this.f18200g;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(onClickListener);
        }
        RelativeLayout relativeLayout3 = this.f18177I;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(onClickListener);
        }
        if (this.f18191W != null) {
            C11839m.m70688i("SpaceDisplayFragment", "membershipExpiredManageSpace setOnClickListener ");
            this.f18191W.setOnClickListener(onClickListener);
        }
        RelativeLayout relativeLayout4 = this.f18198e;
        if (relativeLayout4 == null || this.f18187S) {
            return;
        }
        relativeLayout4.setOnClickListener(onClickListener);
    }

    /* renamed from: z */
    public final void m24289z(View view) {
        this.f18199f = (RelativeLayout) C12809f.m76831d(view, R$id.storage_upgrade_entrance);
        this.f18200g = (RelativeLayout) C12809f.m76831d(view, R$id.base_upgrade_entrance);
        TextView textView = (TextView) C12809f.m76831d(view, R$id.upgrade_space_text);
        this.f18176H = textView;
        textView.setText(SpaceMultLanguageUtil.getSpaceMultLanguage("low_space_tip_buy_new"));
        this.f18181M = (ServiceStatusTipsView) C12809f.m76831d(view, R$id.service_status_tips);
        this.f18182N = (TextView) C12809f.m76831d(view, R$id.base_upgrade);
        this.f18179K = C12809f.m76831d(view, R$id.storage_bra);
        TextView textView2 = (TextView) C12809f.m76831d(view, R$id.frag_storage_tips);
        this.f18209p = textView2;
        textView2.setVisibility(0);
        this.f18189U = (LinearLayout) C12809f.m76831d(view, R$id.membership_expired_stud_layout);
        this.f18207n = (ProgressBar) C12809f.m76831d(view, R$id.membership_expired_loading_bar);
        this.f18191W = (RelativeLayout) C12809f.m76831d(view, R$id.membership_expired_manage_space_entrance);
        this.f18192X = C12809f.m76831d(view, R$id.tips_divider);
        this.f18217x = (HwTextView) C12809f.m76831d(view, R$id.membership_expired_manage_space_text);
        this.f18190V = (HwProgressBar) C12809f.m76831d(view, R$id.membership_expired_bar);
        this.f18193Y = (TextView) C12809f.m76831d(view, R$id.membership_expired_text);
        this.f18178J = (LinearLayout) C12809f.m76831d(view, R$id.ll_storage_manager);
        m24269W();
        m24287v(this.f18175G);
    }
}
