package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.UserPackage;
import dj.C9158a;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import p054cj.C1442a;
import p398jj.ViewOnTouchListenerC10894c;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11842p;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class UnusefulVoucherActivity extends BuyPackageBaseActivity implements View.OnClickListener {

    /* renamed from: A1 */
    public View f17411A1;

    /* renamed from: B1 */
    public AlertDialog f17412B1;

    /* renamed from: h1 */
    public NotchTopFitLinearLayout f17413h1;

    /* renamed from: i1 */
    public NotchFitRelativeLayout f17414i1;

    /* renamed from: j1 */
    public NotchFitRelativeLayout f17415j1;

    /* renamed from: k1 */
    public LinearLayout f17416k1;

    /* renamed from: l1 */
    public LinearLayout f17417l1;

    /* renamed from: m1 */
    public View f17418m1;

    /* renamed from: n1 */
    public View f17419n1;

    /* renamed from: o1 */
    public TextView f17420o1;

    /* renamed from: p1 */
    public TextView f17421p1;

    /* renamed from: q1 */
    public View f17422q1;

    /* renamed from: r1 */
    public View f17423r1;

    /* renamed from: s1 */
    public FragmentManager f17424s1;

    /* renamed from: t1 */
    public UsedVoucherListFragment f17425t1;

    /* renamed from: u1 */
    public ExpiredVoucherListFragment f17426u1;

    /* renamed from: v1 */
    public View f17427v1;

    /* renamed from: w1 */
    public View f17428w1;

    /* renamed from: x1 */
    public TextView f17429x1;

    /* renamed from: y1 */
    public AutoSizeButton f17430y1;

    /* renamed from: z1 */
    public AutoSizeButton f17431z1;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.UnusefulVoucherActivity$a */
    public class DialogInterfaceOnClickListenerC3656a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3656a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (UnusefulVoucherActivity.this.f17412B1 != null) {
                UnusefulVoucherActivity.this.f17412B1.dismiss();
                UnusefulVoucherActivity.this.setResult(-1);
            }
        }
    }

    /* renamed from: H5 */
    private void m23821H5() throws IllegalAccessException, IllegalArgumentException {
        this.f17413h1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f17414i1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f17416k1 = (LinearLayout) C12809f.m76829b(this, R$id.used_layout);
        this.f17415j1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_frame_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.used_voucher);
        this.f17420o1 = textView;
        textView.setMaxWidth(m28584g1(2));
        this.f17417l1 = (LinearLayout) C12809f.m76829b(this, R$id.expired_layout);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.expired_voucher);
        this.f17421p1 = textView2;
        textView2.setMaxWidth(m28584g1(2));
        this.f17422q1 = C12809f.m76829b(this, R$id.used_divide);
        this.f17423r1 = C12809f.m76829b(this, R$id.expired_divide);
        this.f17418m1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f17419n1 = C12809f.m76829b(this, R$id.frame_layout);
        this.f17420o1.setOnClickListener(this);
        this.f17420o1.setOnTouchListener(new ViewOnTouchListenerC10894c(this, this.f17416k1));
        this.f17421p1.setOnClickListener(this);
        this.f17421p1.setOnTouchListener(new ViewOnTouchListenerC10894c(this, this.f17417l1));
        this.f17413h1.setVisibility(0);
        AlertDialog alertDialogMo2027a = new AlertDialog.Builder(this).mo2027a();
        this.f17412B1 = alertDialogMo2027a;
        C11829c.m70594l1(this, alertDialogMo2027a);
        this.f17412B1.m2026q(getString(R$string.cloudpay_open_continuous_monthly_failed_tips));
        this.f17412B1.m2025p(-1, getString(R$string.cloudpay_huaweipay_sure), new DialogInterfaceOnClickListenerC3656a());
        this.f17427v1 = C12809f.m76829b(this, R$id.layout_nodata);
        this.f17411A1 = C12809f.m76829b(this, R$id.layout_loading);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f17428w1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        this.f17430y1 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f17427v1.setOnClickListener(this);
        C11842p.m70874v1(this, this.f17430y1);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f17431z1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f17431z1.setOnClickListener(this);
        this.f17429x1 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        m23823M5();
    }

    /* renamed from: I5 */
    private boolean m23822I5() {
        if (this.f21452m != null) {
            return true;
        }
        C1442a.m8288d("UnusefulVoucherActivity", " data no prepare ok , gradePackagesResp is null.");
        return false;
    }

    /* renamed from: M5 */
    private void m23823M5() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f17411A1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: P5 */
    private void m23824P5(UserPackage userPackage) {
        this.f17424s1 = getFragmentManager();
        this.f17425t1 = new UsedVoucherListFragment();
        this.f17426u1 = new ExpiredVoucherListFragment();
        FragmentTransaction fragmentTransactionBeginTransaction = this.f17424s1.beginTransaction();
        int i10 = R$id.frame_layout;
        fragmentTransactionBeginTransaction.add(i10, this.f17425t1).add(i10, this.f17426u1).hide(this.f17426u1).commitAllowingStateLoss();
        m23829O5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
        C9158a.m57503F().m57516N(this.f16524O, this.f21448i, false, "UnusefulVoucherActivity");
        C1442a.m8290i("UnusefulVoucherActivity", "getAvailableGradePackagesLogic, enter place :2");
    }

    /* renamed from: J5 */
    public void m23825J5(String str) {
        m22842j4(str, C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    /* renamed from: K5 */
    public void m23826K5(String str) {
        m22842j4(str, C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    /* renamed from: L5 */
    public void m23827L5() {
        View view = this.f17422q1;
        if (view != null) {
            view.setVisibility(4);
        }
        if (this.f17420o1 != null) {
            String string = getString(R$string.voucher_used);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), 0, string.length(), 33);
            this.f17420o1.setText(spannableStringBuilder);
            this.f17420o1.setTextColor(getColor(R$color.grade_card_text_color_unselect));
        }
        View view2 = this.f17423r1;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if (this.f17421p1 != null) {
            String string2 = getString(R$string.voucher_expired);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string2);
            spannableStringBuilder2.setSpan(new TypefaceSpan("HwChinese-medium"), 0, string2.length(), 33);
            this.f17421p1.setText(spannableStringBuilder2);
            this.f17421p1.setTextColor(getColor(R$color.payment_order_button_click));
        }
    }

    /* renamed from: N5 */
    public final void m23828N5() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C1442a.m8289e("UnusefulVoucherActivity", "actionBar is null");
        } else {
            actionBar.setTitle(getString(R$string.voucher_useless));
        }
    }

    /* renamed from: O5 */
    public void m23829O5() {
        View view = this.f17422q1;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.f17420o1 != null) {
            String string = getString(R$string.voucher_used);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-medium"), 0, string.length(), 33);
            this.f17420o1.setText(spannableStringBuilder);
            this.f17420o1.setTextColor(getColor(R$color.payment_order_button_click));
        }
        View view2 = this.f17423r1;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        if (this.f17421p1 != null) {
            String string2 = getString(R$string.voucher_expired);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string2);
            spannableStringBuilder2.setSpan(new TypefaceSpan("HwChinese-regular"), 0, string2.length(), 33);
            this.f17421p1.setText(spannableStringBuilder2);
            this.f17421p1.setTextColor(getColor(R$color.grade_card_text_color_unselect));
        }
    }

    /* renamed from: Q5 */
    public void m23830Q5() {
        this.f17428w1.setVisibility(0);
        this.f17419n1.setVisibility(8);
        this.f17411A1.setVisibility(8);
        this.f17427v1.setVisibility(8);
        this.f17414i1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C1442a.m8290i("UnusefulVoucherActivity", "initData");
        if (!C11296s.m67786J(this)) {
            m23830Q5();
            return;
        }
        this.f21452m = null;
        this.f16540W = null;
        mo19474g5();
        m28588o1("06008");
        mo19451H3(new Bundle());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f17411A1.setVisibility(0);
        this.f17427v1.setVisibility(8);
        this.f17414i1.setVisibility(8);
        this.f17428w1.setVisibility(8);
        this.f17419n1.setVisibility(8);
        this.f17429x1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17413h1);
        arrayList.add(this.f17414i1);
        arrayList.add(this.f17418m1);
        arrayList.add(this.f17415j1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        this.f17428w1.setVisibility(8);
        this.f17411A1.setVisibility(8);
        this.f17427v1.setVisibility(8);
        this.f17419n1.setVisibility(0);
        this.f17414i1.setVisibility(0);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "UnusefulVoucherActivity";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f17428w1.setVisibility(8);
        this.f17419n1.setVisibility(8);
        this.f17411A1.setVisibility(8);
        this.f17427v1.setVisibility(0);
        this.f17414i1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f17411A1.setVisibility(0);
        this.f17427v1.setVisibility(8);
        this.f17428w1.setVisibility(8);
        this.f17419n1.setVisibility(8);
        this.f17414i1.setVisibility(8);
        this.f17429x1.setText(R$string.cloudpay_loading);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.used_voucher) {
            m23826K5("UNIFORM_CLOUDPAY_PAY_MANAGE_USED_VOUCHER_CLICK");
            m23829O5();
            FragmentManager fragmentManager = this.f17424s1;
            if (fragmentManager != null) {
                fragmentManager.beginTransaction().show(this.f17425t1).hide(this.f17426u1).commitAllowingStateLoss();
            }
            mo19476h5();
            return;
        }
        if (id2 == R$id.expired_voucher) {
            m23825J5("UNIFORM_CLOUDPAY_PAY_MANAGE_EXPIRED_VOUCHER_CLICK");
            m23827L5();
            FragmentManager fragmentManager2 = this.f17424s1;
            if (fragmentManager2 != null) {
                fragmentManager2.beginTransaction().show(this.f17426u1).hide(this.f17425t1).commitAllowingStateLoss();
            }
            mo19476h5();
            return;
        }
        if (R$id.layout_nonetwork == id2) {
            mo19460T3();
        } else if (R$id.set_no_net_btn == id2) {
            mo19446D1();
        } else if (R$id.layout_nodata == id2) {
            mo19460T3();
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int iM28584g1 = m28584g1(2);
        C12809f.m76839l(this.f17420o1, iM28584g1);
        C12809f.m76839l(this.f17421p1, iM28584g1);
        m23823M5();
        UsedVoucherListFragment usedVoucherListFragment = this.f17425t1;
        if (usedVoucherListFragment != null) {
            usedVoucherListFragment.onConfigurationChanged(configuration);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.unuseful_vouchers_layout);
        C1442a.m8290i("UnusefulVoucherActivity", "onCreate");
        m23821H5();
        m28587n1();
        mo19460T3();
        m23828N5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        m28583a1();
        if (m23822I5()) {
            C1442a.m8290i("UnusefulVoucherActivity", "begin showView");
            m23824P5(this.f21452m);
            mo19476h5();
        }
    }
}
