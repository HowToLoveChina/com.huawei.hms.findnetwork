package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.reward.GetRewardsResp;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import p015ak.C0209d;
import p054cj.C1442a;
import p341hj.C10235i0;
import p398jj.ViewOnTouchListenerC10894c;
import p398jj.ViewTreeObserverOnGlobalLayoutListenerC10895d;
import p454lj.C11296s;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class CouponCenterActivity extends BuyPackageBaseActivity implements View.OnClickListener {

    /* renamed from: A1 */
    public TicketListFragment f17019A1;

    /* renamed from: B1 */
    public boolean f17020B1;

    /* renamed from: C1 */
    public View f17021C1;

    /* renamed from: D1 */
    public View f17022D1;

    /* renamed from: E1 */
    public View f17023E1;

    /* renamed from: F1 */
    public TextView f17024F1;

    /* renamed from: G1 */
    public AutoSizeButton f17025G1;

    /* renamed from: H1 */
    public AutoSizeButton f17026H1;

    /* renamed from: I1 */
    public RefreshCouponCenterReceiver f17027I1;

    /* renamed from: h1 */
    public NotchTopFitLinearLayout f17028h1;

    /* renamed from: i1 */
    public NotchFitRelativeLayout f17029i1;

    /* renamed from: j1 */
    public LinearLayout f17030j1;

    /* renamed from: k1 */
    public NotchFitRelativeLayout f17031k1;

    /* renamed from: l1 */
    public LinearLayout f17032l1;

    /* renamed from: m1 */
    public LinearLayout f17033m1;

    /* renamed from: n1 */
    public LinearLayout f17034n1;

    /* renamed from: o1 */
    public LinearLayout f17035o1;

    /* renamed from: p1 */
    public View f17036p1;

    /* renamed from: q1 */
    public View f17037q1;

    /* renamed from: r1 */
    public TextView f17038r1;

    /* renamed from: s1 */
    public TextView f17039s1;

    /* renamed from: t1 */
    public TextView f17040t1;

    /* renamed from: u1 */
    public View f17041u1;

    /* renamed from: v1 */
    public View f17042v1;

    /* renamed from: w1 */
    public View f17043w1;

    /* renamed from: x1 */
    public FragmentManager f17044x1;

    /* renamed from: y1 */
    public VoucherListFragment f17045y1;

    /* renamed from: z1 */
    public PackageExperienceFragment f17046z1;

    public class RefreshCouponCenterReceiver extends BroadcastReceiver {
        public RefreshCouponCenterReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && "com.huawei.hicloud.coupon.center.refresh".equals(new SafeIntent(intent).getAction())) {
                C1442a.m8290i("CouponCenterActivity", "RefreshCouponCenterReceiver ACTION_REFRESH_COUPON_CENTER_DATA");
                CouponCenterActivity.this.mo19460T3();
            }
        }
    }

    /* renamed from: I5 */
    private void m23473I5() {
        this.f17028h1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f17029i1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f17030j1 = (LinearLayout) C12809f.m76829b(this, R$id.inner_main_layout);
        this.f17031k1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_frame_layout);
        this.f17032l1 = (LinearLayout) C12809f.m76829b(this, R$id.payment_mananger_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.payment_mananger);
        this.f17038r1 = textView;
        textView.setText(R$string.cloudpay_voucher_text);
        this.f17038r1.setMaxWidth(m28584g1(3));
        this.f17038r1.setOnClickListener(this);
        this.f17038r1.setOnTouchListener(new ViewOnTouchListenerC10894c(this, this.f17032l1));
        this.f17038r1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10895d(this.f17038r1));
        this.f17041u1 = C12809f.m76829b(this, R$id.payment_divide);
        this.f17033m1 = (LinearLayout) C12809f.m76829b(this, R$id.payment_recode_layout);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.payment_recode);
        this.f17039s1 = textView2;
        textView2.setText(R$string.package_exp_tab_title);
        this.f17039s1.setMaxWidth(m28584g1(3));
        this.f17039s1.setOnClickListener(this);
        this.f17039s1.setOnTouchListener(new ViewOnTouchListenerC10894c(this, this.f17033m1));
        this.f17039s1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10895d(this.f17039s1));
        this.f17042v1 = C12809f.m76829b(this, R$id.recode_divide);
        this.f17034n1 = (LinearLayout) C12809f.m76829b(this, R$id.vouchers_layout);
        TextView textView3 = (TextView) C12809f.m76829b(this, R$id.vouchers_info);
        this.f17040t1 = textView3;
        textView3.setText(R$string.change_tab_title);
        this.f17040t1.setMaxWidth(m28584g1(3));
        this.f17040t1.setOnClickListener(this);
        this.f17040t1.setOnTouchListener(new ViewOnTouchListenerC10894c(this, this.f17034n1));
        this.f17040t1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10895d(this.f17040t1));
        this.f17043w1 = C12809f.m76829b(this, R$id.vouchers_divide);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.cards_layout);
        this.f17035o1 = linearLayout;
        C11842p.m70712A2(linearLayout, false);
        this.f17036p1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f17037q1 = C12809f.m76829b(this, R$id.frame_layout);
        this.f17021C1 = C12809f.m76829b(this, R$id.layout_loading);
        this.f17022D1 = C12809f.m76829b(this, R$id.layout_nodata);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f17023E1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f17025G1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f17022D1.setOnClickListener(this);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f17026H1 = autoSizeButton2;
        C11842p.m70874v1(this, autoSizeButton2);
        this.f17024F1 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        this.f17026H1.setOnClickListener(this);
        mo23770l1();
    }

    /* renamed from: N5 */
    private void m23474N5() {
        String stringExtra = new HiCloudSafeIntent(getIntent()).getStringExtra("srcChannel");
        if ("501".equals(stringExtra)) {
            C11839m.m70688i("CouponCenterActivity", "processPushChannelClick srcChannel=" + stringExtra);
            MessageCenterManager.getInstance().processNotifyClickEvent(getIntent());
            MessageCenterManager.getInstance().cancelCampaignMsgTypeSixNotification();
        }
    }

    /* renamed from: Q5 */
    private void m23475Q5(String str) {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setTitle("reward_detail".equals(str) ? getString(R$string.reward_detail_title) : getString(R$string.voucher_ticket_center_title));
        }
    }

    /* renamed from: R5 */
    private void m23476R5() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f17021C1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: T5 */
    private void m23477T5() {
        C11842p.m70712A2(this.f17023E1, true);
        C11842p.m70712A2(this.f17037q1, false);
        C11842p.m70712A2(this.f17021C1, false);
        C11842p.m70712A2(this.f17022D1, false);
        C11842p.m70712A2(this.f17029i1, false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
    }

    /* renamed from: H5 */
    public final void m23478H5() {
        C1442a.m8290i("CouponCenterActivity", "initRefreshReceiver");
        C13108a c13108aM78878b = C13108a.m78878b(this);
        if (this.f17027I1 == null) {
            this.f17027I1 = new RefreshCouponCenterReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.hicloud.coupon.center.refresh");
            c13108aM78878b.m78880c(this.f17027I1, intentFilter);
        }
    }

    /* renamed from: J5 */
    public final SpannableStringBuilder m23479J5(boolean z10, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (z10) {
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-medium"), 0, str.length(), 33);
        } else {
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), 0, str.length(), 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: K5 */
    public final void m23480K5() {
        m23484P5(this.f17042v1, this.f17039s1, getString(R$string.package_exp_tab_title));
        m23486U5(this.f17041u1, this.f17038r1, getString(R$string.voucher_manager));
        m23486U5(this.f17043w1, this.f17040t1, getString(R$string.change_tab_title));
        FragmentManager fragmentManager = this.f17044x1;
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().show(this.f17046z1).hide(this.f17045y1).hide(this.f17019A1).commitAllowingStateLoss();
        }
        mo19476h5();
    }

    /* renamed from: L5 */
    public final void m23481L5() {
        m23484P5(this.f17043w1, this.f17040t1, getString(R$string.change_tab_title));
        m23486U5(this.f17041u1, this.f17038r1, getString(R$string.voucher_manager));
        if (this.f17020B1) {
            m23486U5(this.f17042v1, this.f17039s1, getString(R$string.package_exp_tab_title));
        }
        FragmentManager fragmentManager = this.f17044x1;
        if (fragmentManager != null) {
            if (this.f17020B1) {
                fragmentManager.beginTransaction().show(this.f17019A1).hide(this.f17046z1).hide(this.f17045y1).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().show(this.f17019A1).hide(this.f17045y1).commitAllowingStateLoss();
            }
        }
        mo19476h5();
    }

    /* renamed from: M5 */
    public final void m23482M5() {
        m23484P5(this.f17041u1, this.f17038r1, getString(R$string.voucher_manager));
        m23486U5(this.f17043w1, this.f17040t1, getString(R$string.change_tab_title));
        if (this.f17020B1) {
            m23486U5(this.f17042v1, this.f17039s1, getString(R$string.package_exp_tab_title));
        }
        FragmentManager fragmentManager = this.f17044x1;
        if (fragmentManager != null) {
            if (this.f17020B1) {
                fragmentManager.beginTransaction().show(this.f17045y1).hide(this.f17046z1).hide(this.f17019A1).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().show(this.f17045y1).hide(this.f17019A1).commitAllowingStateLoss();
            }
        }
        mo19476h5();
    }

    /* renamed from: O5 */
    public final void m23483O5() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("pay_can_show_voucher_list", String.valueOf(C11296s.m67787K() && C11296s.m67789M(this)));
        m22842j4("UNIFORM_VOUCHER_CENTER_ENTER_MANAGE_ACTIVITY", linkedHashMapM79497A);
    }

    /* renamed from: P5 */
    public final void m23484P5(View view, TextView textView, String str) {
        if (view != null) {
            view.setVisibility(0);
        }
        if (textView != null) {
            textView.setText(m23479J5(true, str));
            textView.setTextColor(getColor(R$color.payment_order_button_click));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    /* renamed from: S5 */
    public final void m23485S5(GetRewardsResp getRewardsResp) {
        FragmentManager fragmentManager = getFragmentManager();
        this.f17044x1 = fragmentManager;
        if (fragmentManager == null) {
            C1442a.m8289e("CouponCenterActivity", "showFragment fail , manager is null");
            return;
        }
        mo19476h5();
        this.f17045y1 = new VoucherListFragment();
        this.f17019A1 = new TicketListFragment();
        boolean z10 = (getRewardsResp == null || C0209d.m1205R0(getRewardsResp.getRewards())) ? false : true;
        this.f17020B1 = z10;
        if (z10) {
            this.f17046z1 = new PackageExperienceFragment();
            FragmentTransaction fragmentTransactionBeginTransaction = this.f17044x1.beginTransaction();
            int i10 = R$id.frame_layout;
            fragmentTransactionBeginTransaction.add(i10, this.f17045y1).add(i10, this.f17046z1).add(i10, this.f17019A1).show(this.f17045y1).hide(this.f17046z1).hide(this.f17019A1).commitAllowingStateLoss();
            m23484P5(this.f17041u1, this.f17038r1, getString(R$string.voucher_manager));
            m23486U5(this.f17042v1, this.f17039s1, getString(R$string.package_exp_tab_title));
        } else {
            C11842p.m70712A2(this.f17033m1, false);
            FragmentTransaction fragmentTransactionBeginTransaction2 = this.f17044x1.beginTransaction();
            int i11 = R$id.frame_layout;
            fragmentTransactionBeginTransaction2.add(i11, this.f17045y1).add(i11, this.f17019A1).show(this.f17045y1).hide(this.f17019A1).commitAllowingStateLoss();
            m23484P5(this.f17041u1, this.f17038r1, getString(R$string.voucher_manager));
        }
        m23486U5(this.f17043w1, this.f17040t1, getString(R$string.change_tab_title));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C1442a.m8290i("CouponCenterActivity", "initData");
        if (!C0209d.m1333z1(this)) {
            m23477T5();
        } else {
            mo19474g5();
            new C10235i0(String.valueOf(0), 1, null, new Consumer() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.b0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f17535a.m23485S5((GetRewardsResp) obj);
                }
            }).m63381g();
        }
    }

    /* renamed from: U5 */
    public final void m23486U5(View view, TextView textView, String str) {
        if (view != null) {
            view.setVisibility(4);
        }
        if (textView != null) {
            textView.setText(m23479J5(false, str));
            textView.setTextColor(getColor(R$color.grade_card_text_color_unselect));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        C11842p.m70712A2(this.f17021C1, true);
        C11842p.m70712A2(this.f17022D1, false);
        C11842p.m70712A2(this.f17029i1, false);
        C11842p.m70712A2(this.f17023E1, false);
        C11842p.m70712A2(this.f17037q1, false);
        this.f17024F1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17028h1);
        arrayList.add(this.f17029i1);
        arrayList.add(this.f17036p1);
        arrayList.add(this.f17031k1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        C11842p.m70712A2(this.f17023E1, false);
        C11842p.m70712A2(this.f17021C1, false);
        C11842p.m70712A2(this.f17022D1, false);
        C11842p.m70712A2(this.f17037q1, true);
        C11842p.m70712A2(this.f17029i1, true);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        VoucherListFragment voucherListFragment;
        C1442a.m8290i("CouponCenterActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 10014 && (voucherListFragment = this.f17045y1) != null) {
            voucherListFragment.onActivityResult(i10, i11, intent);
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.payment_mananger) {
            m23482M5();
            return;
        }
        if (id2 == R$id.payment_recode) {
            m23480K5();
            return;
        }
        if (id2 == R$id.vouchers_info) {
            m23481L5();
            return;
        }
        if (R$id.layout_nonetwork == id2) {
            mo19460T3();
        } else if (R$id.layout_nodata == id2) {
            mo19460T3();
        } else if (R$id.set_no_net_btn == id2) {
            mo19446D1();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int iM28584g1 = m28584g1(3);
        C12809f.m76839l(this.f17038r1, iM28584g1);
        C12809f.m76839l(this.f17039s1, iM28584g1);
        C12809f.m76839l(this.f17040t1, iM28584g1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.payment_manager_layout);
        Intent intent = getIntent();
        if (intent != null) {
            m23475Q5(new HiCloudSafeIntent(intent).m29113i("page_from", ""));
        }
        C1442a.m8290i("CouponCenterActivity", "onCreate");
        m23473I5();
        m28587n1();
        mo19460T3();
        m23476R5();
        m23483O5();
        m23478H5();
        m23474N5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f17027I1 != null) {
            C13108a.m78878b(this).m78883f(this.f17027I1);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
    }
}
