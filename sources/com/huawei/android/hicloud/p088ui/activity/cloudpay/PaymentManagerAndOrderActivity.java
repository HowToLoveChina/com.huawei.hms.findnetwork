package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.GradePackageCardView;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.Filter;
import com.huawei.cloud.pay.model.GetAllTicketsResp;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.Tickets;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import dj.C9158a;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p054cj.C1442a;
import p364ib.C10465b;
import p398jj.InterfaceC10892a;
import p398jj.ViewOnTouchListenerC10894c;
import p398jj.ViewTreeObserverOnGlobalLayoutListenerC10895d;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11842p;
import p684un.C13230i;
import p709vj.C13452e;
import p742wj.C13612b;
import sk.C12809f;

/* loaded from: classes3.dex */
public class PaymentManagerAndOrderActivity extends BuyPackageBaseActivity implements View.OnClickListener, GradePackageCardView.SendMessageCommunicator, InterfaceC10892a {

    /* renamed from: A1 */
    public PaymentManagerFragment f17208A1;

    /* renamed from: B1 */
    public OrderListFragment f17209B1;

    /* renamed from: C1 */
    public View f17210C1;

    /* renamed from: D1 */
    public View f17211D1;

    /* renamed from: E1 */
    public View f17212E1;

    /* renamed from: F1 */
    public TextView f17213F1;

    /* renamed from: G1 */
    public AutoSizeButton f17214G1;

    /* renamed from: H1 */
    public AutoSizeButton f17215H1;

    /* renamed from: I1 */
    public AlertDialog f17216I1;

    /* renamed from: J1 */
    public boolean f17217J1 = false;

    /* renamed from: K1 */
    public boolean f17218K1 = false;

    /* renamed from: L1 */
    public boolean f17219L1 = false;

    /* renamed from: M1 */
    public List<Tickets> f17220M1 = null;

    /* renamed from: N1 */
    public HandlerC3641b f17221N1 = new HandlerC3641b(this);

    /* renamed from: O1 */
    public String f17222O1;

    /* renamed from: P1 */
    public String f17223P1;

    /* renamed from: Q1 */
    public String f17224Q1;

    /* renamed from: h1 */
    public NotchTopFitLinearLayout f17225h1;

    /* renamed from: i1 */
    public NotchFitRelativeLayout f17226i1;

    /* renamed from: j1 */
    public LinearLayout f17227j1;

    /* renamed from: k1 */
    public NotchFitRelativeLayout f17228k1;

    /* renamed from: l1 */
    public LinearLayout f17229l1;

    /* renamed from: m1 */
    public LinearLayout f17230m1;

    /* renamed from: n1 */
    public LinearLayout f17231n1;

    /* renamed from: o1 */
    public LinearLayout f17232o1;

    /* renamed from: p1 */
    public View f17233p1;

    /* renamed from: q1 */
    public View f17234q1;

    /* renamed from: r1 */
    public TextView f17235r1;

    /* renamed from: s1 */
    public TextView f17236s1;

    /* renamed from: t1 */
    public TextView f17237t1;

    /* renamed from: u1 */
    public TextView f17238u1;

    /* renamed from: v1 */
    public View f17239v1;

    /* renamed from: w1 */
    public View f17240w1;

    /* renamed from: x1 */
    public View f17241x1;

    /* renamed from: y1 */
    public View f17242y1;

    /* renamed from: z1 */
    public FragmentManager f17243z1;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PaymentManagerAndOrderActivity$a */
    public class DialogInterfaceOnClickListenerC3640a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3640a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (PaymentManagerAndOrderActivity.this.f17216I1 != null) {
                PaymentManagerAndOrderActivity.this.f17216I1.dismiss();
                PaymentManagerAndOrderActivity.this.setResult(-1);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PaymentManagerAndOrderActivity$b */
    public static class HandlerC3641b extends Handler {

        /* renamed from: a */
        public WeakReference<PaymentManagerAndOrderActivity> f17245a;

        public HandlerC3641b(PaymentManagerAndOrderActivity paymentManagerAndOrderActivity) {
            this.f17245a = new WeakReference<>(paymentManagerAndOrderActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PaymentManagerAndOrderActivity paymentManagerAndOrderActivity = this.f17245a.get();
            if (paymentManagerAndOrderActivity == null) {
                C1442a.m8289e("PaymentManagerAndOrderActivity", "orders activity has been collected.");
                return;
            }
            try {
                try {
                    int i10 = message.what;
                    if (i10 == 6033) {
                        C1442a.m8290i("PaymentManagerAndOrderActivity", "GET_ALL_CARDS_SUCCESS");
                        Object obj = message.obj;
                        if (obj instanceof GetAllTicketsResp) {
                            List<Tickets> ticketsList = ((GetAllTicketsResp) obj).getTicketsList();
                            paymentManagerAndOrderActivity.m23657U5(ticketsList);
                            if (ticketsList.size() > 0) {
                                paymentManagerAndOrderActivity.f17219L1 = true;
                            }
                        } else {
                            C1442a.m8290i("PaymentManagerAndOrderActivity", "GET_ALL_CARDS_SUCCESS_WRONG_DATA");
                            paymentManagerAndOrderActivity.m23657U5(new ArrayList());
                        }
                    } else if (i10 != 6034) {
                        C1442a.m8290i("PaymentManagerAndOrderActivity", "GET_ALL_CARDS_UNKNOWN");
                        paymentManagerAndOrderActivity.m23657U5(new ArrayList());
                    } else {
                        C1442a.m8290i("PaymentManagerAndOrderActivity", "GET_ALL_CARDS_FAIL");
                        paymentManagerAndOrderActivity.m23657U5(new ArrayList());
                    }
                } catch (Exception e10) {
                    C1442a.m8289e("PaymentManagerAndOrderActivity", e10.getMessage());
                    paymentManagerAndOrderActivity.m23657U5(new ArrayList());
                }
                paymentManagerAndOrderActivity.mo19479s5();
            } catch (Throwable th2) {
                paymentManagerAndOrderActivity.mo19479s5();
                throw th2;
            }
        }
    }

    /* renamed from: K5 */
    private void m23644K5() throws IllegalAccessException, IllegalArgumentException {
        this.f17225h1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        m23653Q5();
        this.f17226i1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.main_layout);
        this.f17227j1 = (LinearLayout) C12809f.m76829b(this, R$id.inner_main_layout);
        this.f17229l1 = (LinearLayout) C12809f.m76829b(this, R$id.payment_mananger_layout);
        this.f17228k1 = (NotchFitRelativeLayout) C12809f.m76829b(this, R$id.notch_frame_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.payment_mananger);
        this.f17235r1 = textView;
        textView.setMaxWidth(m28584g1(2));
        this.f17230m1 = (LinearLayout) C12809f.m76829b(this, R$id.payment_recode_layout);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.payment_recode);
        this.f17236s1 = textView2;
        textView2.setMaxWidth(m28584g1(2));
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.vouchers_layout);
        this.f17231n1 = linearLayout;
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.cards_layout);
        this.f17232o1 = linearLayout2;
        linearLayout2.setVisibility(8);
        this.f17237t1 = (TextView) C12809f.m76829b(this, R$id.vouchers_info);
        this.f17238u1 = (TextView) C12809f.m76829b(this, R$id.cards_info);
        View viewM76829b = C12809f.m76829b(this, R$id.payment_divide);
        this.f17239v1 = viewM76829b;
        int i10 = R$drawable.payment_tab_select_under_line_bg;
        viewM76829b.setBackground(getDrawable(i10));
        View viewM76829b2 = C12809f.m76829b(this, R$id.recode_divide);
        this.f17240w1 = viewM76829b2;
        viewM76829b2.setBackground(getDrawable(i10));
        View viewM76829b3 = C12809f.m76829b(this, R$id.vouchers_divide);
        this.f17241x1 = viewM76829b3;
        viewM76829b3.setBackground(getDrawable(i10));
        View viewM76829b4 = C12809f.m76829b(this, R$id.cards_divide);
        this.f17242y1 = viewM76829b4;
        viewM76829b4.setBackground(getDrawable(i10));
        this.f17233p1 = C12809f.m76829b(this, R$id.notch_fit_load_view);
        this.f17234q1 = C12809f.m76829b(this, R$id.frame_layout);
        this.f17229l1.setOnClickListener(this);
        LinearLayout linearLayout3 = this.f17229l1;
        linearLayout3.setOnTouchListener(new ViewOnTouchListenerC10894c(this, linearLayout3));
        this.f17235r1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10895d(this.f17235r1));
        this.f17230m1.setOnClickListener(this);
        LinearLayout linearLayout4 = this.f17230m1;
        linearLayout4.setOnTouchListener(new ViewOnTouchListenerC10894c(this, linearLayout4));
        this.f17236s1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10895d(this.f17236s1));
        this.f17231n1.setOnClickListener(this);
        LinearLayout linearLayout5 = this.f17231n1;
        linearLayout5.setOnTouchListener(new ViewOnTouchListenerC10894c(this, linearLayout5));
        this.f17237t1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10895d(this.f17237t1));
        this.f17238u1.setOnClickListener(this);
        this.f17238u1.setOnTouchListener(new ViewOnTouchListenerC10894c(this, this.f17232o1));
        this.f17238u1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC10895d(this.f17238u1));
        this.f17225h1.setVisibility(0);
        AlertDialog alertDialogMo2027a = new AlertDialog.Builder(this).mo2027a();
        this.f17216I1 = alertDialogMo2027a;
        C11829c.m70594l1(this, alertDialogMo2027a);
        this.f17216I1.m2026q(getString(R$string.cloudpay_open_continuous_monthly_failed_tips));
        this.f17216I1.m2025p(-1, getString(R$string.cloudpay_huaweipay_sure), new DialogInterfaceOnClickListenerC3640a());
        this.f17210C1 = C12809f.m76829b(this, R$id.layout_loading);
        this.f17211D1 = C12809f.m76829b(this, R$id.layout_nodata);
        View viewM76829b5 = C12809f.m76829b(this, R$id.layout_nonetwork);
        this.f17212E1 = viewM76829b5;
        viewM76829b5.setOnClickListener(this);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_retry_getinfo);
        this.f17214G1 = autoSizeButton;
        C11842p.m70874v1(this, autoSizeButton);
        this.f17211D1.setOnClickListener(this);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f17215H1 = autoSizeButton2;
        C11842p.m70874v1(this, autoSizeButton2);
        this.f17213F1 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        this.f17215H1.setOnClickListener(this);
        mo23770l1();
        this.f17208A1 = new PaymentManagerFragment();
        this.f17209B1 = new OrderListFragment(this);
    }

    /* renamed from: L5 */
    private boolean m23645L5() {
        if (this.f16540W == null) {
            C1442a.m8288d("PaymentManagerAndOrderActivity", " data no prepare ok , gradePackagesResp is null.");
            return false;
        }
        if (this.f21452m == null) {
            C1442a.m8288d("PaymentManagerAndOrderActivity", " data no prepare ok , gradePackagesResp is null.");
            return false;
        }
        if (this.f16535T0 == null) {
            C1442a.m8288d("PaymentManagerAndOrderActivity", " data no prepare ok , voucherList is null.");
            return false;
        }
        if (this.f16550b0 != null) {
            return true;
        }
        C1442a.m8288d("PaymentManagerAndOrderActivity", "data no prepare ok , mFamilyShareInfoResult is null");
        return true;
    }

    /* renamed from: P5 */
    private void m23646P5() throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Resources resources;
        ActionBar actionBar = getActionBar();
        if (actionBar == null || (resources = getResources()) == null) {
            return;
        }
        int color = resources.getColor(R$color.pay_activity_harmony_bg);
        C0209d.m1306s2(actionBar, this, color);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(color);
        }
    }

    /* renamed from: S5 */
    private void m23647S5() {
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_nonet_icon));
        C11842p.m70760Q1(this, this.f17210C1);
        C11842p.m70760Q1(this, C12809f.m76829b(this, R$id.layout_no_service_icon));
    }

    /* renamed from: X5 */
    private void m23648X5() {
        this.f17212E1.setVisibility(0);
        this.f17234q1.setVisibility(8);
        this.f17210C1.setVisibility(8);
        this.f17211D1.setVisibility(8);
        this.f17226i1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28576J1(this.f17227j1);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: C */
    public void mo23172C() {
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28576J1(this.f17227j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28576J1(this.f17227j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28576J1(this.f17227j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28576J1(this.f17227j1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f17227j1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
        Filter filter = new Filter();
        filter.setShowPlace(2);
        C1442a.m8290i("PaymentManagerAndOrderActivity", "getAvailableGradePackagesLogic, enter place :2");
        C9158a.m57503F().m57517O(this.f16524O, this.f21448i, false, true, "PaymentManagerAndOrderActivity");
        C9158a.m57503F().m57560y(this.f16524O, filter, null, true, m22882v2(), false, 0L);
        if (this.f17217J1 || this.f17218K1) {
            C9158a.m57503F().m57505B(this.f16524O, this.f21448i, false);
        }
        if (C11829c.m70626w0()) {
            C9158a.m57503F().m57506C(this.f16524O, true);
        }
    }

    /* renamed from: J5 */
    public final void m23649J5() {
        m23654R5();
        FragmentManager fragmentManager = this.f17243z1;
        if (fragmentManager != null) {
            fragmentManager.beginTransaction().show(this.f17208A1).hide(this.f17209B1).commitAllowingStateLoss();
        }
        mo19476h5();
    }

    /* renamed from: M5 */
    public final void m23650M5() {
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        if (!TextUtils.isEmpty(this.f17222O1)) {
            linkedHashMapM79497A.put("pay_src_channel", this.f17222O1);
        }
        if (!TextUtils.isEmpty(this.f17223P1)) {
            linkedHashMapM79497A.put("pay_sal_channel", this.f17223P1);
        }
        if (!TextUtils.isEmpty(this.f17224Q1)) {
            linkedHashMapM79497A.put("pay_activity_code", this.f17224Q1);
        }
        boolean z10 = false;
        linkedHashMapM79497A.put("nav_source", String.valueOf(hiCloudSafeIntent.getIntExtra("nav_source", 0)));
        linkedHashMapM79497A.put("pay_pkg_name", String.valueOf(hiCloudSafeIntent.getStringExtra("pkg_name")));
        if (C11296s.m67787K() && C11296s.m67789M(this)) {
            z10 = true;
        }
        linkedHashMapM79497A.put("pay_can_show_voucher_list", String.valueOf(z10));
        m22842j4("UNIFORM_CLOUDPAY_ENTER_MANAGE_ACTIVITY", linkedHashMapM79497A);
    }

    /* renamed from: N5 */
    public final void m23651N5() {
        View view = this.f17239v1;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.f17235r1 != null) {
            String string = getString(R$string.payment_manager_tag_short);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-medium"), 0, string.length(), 33);
            this.f17235r1.setText(spannableStringBuilder);
            this.f17235r1.setTextColor(getColor(R$color.payment_tab_selected_color));
        }
    }

    /* renamed from: O5 */
    public final void m23652O5() {
        View view = this.f17240w1;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.f17236s1 != null) {
            String string = getString(R$string.trade_history);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-medium"), 0, string.length(), 33);
            this.f17236s1.setText(spannableStringBuilder);
            this.f17236s1.setTextColor(getColor(R$color.payment_tab_selected_color));
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: P */
    public void mo23180P(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo, ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback) {
        m22820a5(m22848m2(cloudPackage, packageGrades, list, reportVoucherInfo, agreementDlgCallback));
    }

    /* renamed from: Q5 */
    public final void m23653Q5() {
        Resources resources;
        if (this.f17225h1 == null || (resources = getResources()) == null) {
            return;
        }
        this.f17225h1.setBackgroundColor(resources.getColor(R$color.pay_activity_harmony_bg));
    }

    /* renamed from: R5 */
    public final void m23654R5() {
        m23651N5();
        m23661Z5();
        m23663b6();
        m23662a6();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    @Override // p398jj.InterfaceC10892a
    /* renamed from: T */
    public void mo23655T() {
        m22842j4("UNIFORM_CLOUDPAY_COYP_ORDER_ID", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C1442a.m8290i("PaymentManagerAndOrderActivity", "initData");
        if (!C11296s.m67786J(this)) {
            m23648X5();
            return;
        }
        this.f21452m = null;
        this.f16540W = null;
        this.f16535T0 = null;
        this.f17220M1 = null;
        this.f16550b0 = null;
        mo19474g5();
        m28588o1("06008");
        if (this.f17217J1 || this.f17218K1) {
            C13612b.m81829B().m81848K(this.f16524O);
        } else {
            mo19451H3(new Bundle());
        }
    }

    /* renamed from: T5 */
    public final void m23656T5() {
        m23652O5();
        m23663b6();
        m23660Y5();
        m23662a6();
    }

    /* renamed from: U5 */
    public final void m23657U5(List<Tickets> list) {
        this.f17220M1 = list;
    }

    /* renamed from: V5 */
    public final void m23658V5() {
        if (C11829c.m70626w0() && C10465b.m64302l(this.f16550b0)) {
            mo22716i5();
        }
    }

    /* renamed from: W5 */
    public final void m23659W5(UserPackage userPackage) {
        FragmentManager fragmentManager = getFragmentManager();
        this.f17243z1 = fragmentManager;
        if (fragmentManager == null) {
            C1442a.m8289e("PaymentManagerAndOrderActivity", "showFragment fail , manager is null");
            return;
        }
        if (fragmentManager.getFragments().size() > 0) {
            FragmentTransaction fragmentTransactionBeginTransaction = this.f17243z1.beginTransaction();
            List<Fragment> fragments = getFragmentManager().getFragments();
            if (fragments != null) {
                Iterator<Fragment> it = fragments.iterator();
                while (it.hasNext()) {
                    fragmentTransactionBeginTransaction.remove(it.next());
                }
            }
            fragmentTransactionBeginTransaction.commit();
            this.f17208A1 = new PaymentManagerFragment();
            this.f17209B1 = new OrderListFragment(this);
        }
        this.f17208A1.m23699R(userPackage, this.f16540W, this.f16538V, this, this.f16535T0);
        FragmentTransaction fragmentTransactionBeginTransaction2 = this.f17243z1.beginTransaction();
        int i10 = R$id.frame_layout;
        fragmentTransactionBeginTransaction2.add(i10, this.f17208A1).add(i10, this.f17209B1).hide(this.f17209B1).commitAllowingStateLoss();
        m23654R5();
        if (this.f17219L1) {
            return;
        }
        this.f17232o1.setVisibility(8);
    }

    /* renamed from: Y5 */
    public final void m23660Y5() {
        View view = this.f17239v1;
        if (view != null) {
            view.setVisibility(4);
        }
        if (this.f17235r1 != null) {
            String string = getString(R$string.payment_manager_tag_short);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), 0, string.length(), 33);
            this.f17235r1.setText(spannableStringBuilder);
            this.f17235r1.setTextColor(getColor(R$color.grade_card_text_color_unselect));
        }
    }

    /* renamed from: Z5 */
    public final void m23661Z5() {
        View view = this.f17240w1;
        if (view != null) {
            view.setVisibility(4);
        }
        if (this.f17236s1 != null) {
            String string = getString(R$string.trade_history);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), 0, string.length(), 33);
            this.f17236s1.setText(spannableStringBuilder);
            this.f17236s1.setTextColor(getColor(R$color.grade_card_text_color_unselect));
        }
    }

    /* renamed from: a6 */
    public final void m23662a6() {
        View view = this.f17242y1;
        if (view != null) {
            view.setVisibility(4);
        }
        if (this.f17238u1 != null) {
            String string = getString(R$string.cloudpay_card_title_text);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), 0, string.length(), 33);
            this.f17238u1.setText(spannableStringBuilder);
            this.f17238u1.setTextColor(getColor(R$color.grade_card_text_color_unselect));
        }
    }

    /* renamed from: b6 */
    public final void m23663b6() {
        View view = this.f17241x1;
        if (view != null) {
            view.setVisibility(4);
        }
        if (this.f17237t1 != null) {
            String string = getString(R$string.voucher_manager);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new TypefaceSpan("HwChinese-regular"), 0, string.length(), 33);
            this.f17237t1.setText(spannableStringBuilder);
            this.f17237t1.setTextColor(getColor(R$color.grade_card_text_color_unselect));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f17210C1.setVisibility(0);
        this.f17211D1.setVisibility(8);
        this.f17226i1.setVisibility(8);
        this.f17212E1.setVisibility(8);
        this.f17234q1.setVisibility(8);
        this.f17213F1.setText(R$string.cloudpay_loading);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17225h1);
        arrayList.add(this.f17226i1);
        arrayList.add(this.f17233p1);
        arrayList.add(this.f17228k1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        this.f17212E1.setVisibility(8);
        this.f17210C1.setVisibility(8);
        this.f17211D1.setVisibility(8);
        this.f17234q1.setVisibility(0);
        this.f17226i1.setVisibility(0);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: i0 */
    public void mo23196i0(boolean z10) {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("way_of_purchase", "pay_manage_purchase");
        m22842j4(z10 ? "UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT" : "UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT", linkedHashMapM79497A);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "PaymentManagerAndOrderActivity";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        this.f17212E1.setVisibility(8);
        this.f17234q1.setVisibility(8);
        this.f17210C1.setVisibility(8);
        this.f17211D1.setVisibility(0);
        this.f17226i1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
        this.f17210C1.setVisibility(0);
        this.f17211D1.setVisibility(8);
        this.f17212E1.setVisibility(8);
        this.f17234q1.setVisibility(8);
        this.f17226i1.setVisibility(8);
        this.f17213F1.setText(R$string.cloudpay_loading);
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0089  */
    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r5, int r6, android.content.Intent r7) throws org.json.JSONException {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "onActivityResult requestCode = "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " resultCode "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PaymentManagerAndOrderActivity"
            p054cj.C1442a.m8290i(r1, r0)
            if (r6 != 0) goto L3d
            r4.m28583a1()
            com.huawei.cloud.pay.model.GetClientUIConfigResp r5 = r4.f16538V
            if (r5 == 0) goto L34
            com.huawei.cloud.pay.model.UserPackage r5 = r4.f21452m
            if (r5 == 0) goto L34
            java.util.ArrayList<com.huawei.cloud.pay.model.FilterAvailabalGradePackage> r5 = r4.f16540W
            if (r5 != 0) goto L30
            goto L34
        L30:
            r4.mo19476h5()
            return
        L34:
            java.lang.String r5 = " data no prepare ok"
            p054cj.C1442a.m8288d(r1, r5)
            r4.mo19460T3()
            return
        L3d:
            r0 = 10001(0x2711, float:1.4014E-41)
            r2 = -1
            if (r5 == r0) goto L89
            r0 = 10002(0x2712, float:1.4016E-41)
            if (r5 == r0) goto L60
            r0 = 10006(0x2716, float:1.4021E-41)
            if (r5 == r0) goto L57
            r0 = 10007(0x2717, float:1.4023E-41)
            if (r5 == r0) goto L89
            r0 = 10013(0x271d, float:1.4031E-41)
            if (r5 == r0) goto L53
            goto L97
        L53:
            r4.mo22790P3(r7)
            goto L97
        L57:
            if (r2 != r6) goto L97
            r4.mo19460T3()
            r4.setResult(r2)
            goto L97
        L60:
            r4.m22759E4()
            android.content.Context r0 = r4.getApplicationContext()
            u0.a r0 = p664u0.C13108a.m78878b(r0)
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"
            r1.<init>(r3)
            r0.m78881d(r1)
            r4.setResult(r2)
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.huawei.android.hicloud.ui.activity.cloudpay.CloudSpaceUpgradeActivity> r1 = com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity.class
            r0.<init>(r4, r1)
            r4.m28580X0(r0)
            r4.startActivity(r0)
            r4.finish()
            goto L97
        L89:
            if (r2 != r6) goto L8f
            r4.mo22829d4(r7)
            goto L97
        L8f:
            java.lang.String r0 = "hms pay callback resultCode is not ok;"
            p054cj.C1442a.m8289e(r1, r0)
            r4.mo19460T3()
        L97:
            super.onActivityResult(r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.cloudpay.PaymentManagerAndOrderActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        try {
            if (id2 != R$id.payment_mananger && id2 != R$id.payment_mananger_layout) {
                if (id2 != R$id.payment_recode && id2 != R$id.payment_recode_layout) {
                    if (R$id.layout_nonetwork == id2) {
                        mo19460T3();
                        return;
                    } else if (R$id.layout_nodata == id2) {
                        mo19460T3();
                        return;
                    } else {
                        if (R$id.set_no_net_btn == id2) {
                            mo19446D1();
                            return;
                        }
                        return;
                    }
                }
                m23656T5();
                FragmentManager fragmentManager = this.f17243z1;
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction().show(this.f17209B1).hide(this.f17208A1).commitAllowingStateLoss();
                }
                mo19476h5();
                return;
            }
            m23649J5();
        } catch (Exception e10) {
            C1442a.m8289e("PaymentManagerAndOrderActivity", "onClick error: " + e10.getMessage());
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int iM28584g1 = m28584g1(2);
        C12809f.m76839l(this.f17235r1, iM28584g1);
        C12809f.m76839l(this.f17236s1, iM28584g1);
        PaymentManagerFragment paymentManagerFragment = this.f17208A1;
        if (paymentManagerFragment != null && paymentManagerFragment.isAdded()) {
            this.f17208A1.onConfigurationChanged(configuration);
        }
        m23647S5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R$layout.payment_manager_layout);
        Intent intent = getIntent();
        if (intent != null) {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
            int intExtra = hiCloudSafeIntent.getIntExtra("nav_source", 0);
            if (intExtra == 11 || intExtra == 13) {
                this.f17217J1 = true;
            } else if (intExtra == 12) {
                this.f17218K1 = true;
            }
            try {
                this.f16538V = (GetClientUIConfigResp) hiCloudSafeIntent.getSerializableExtra("params");
            } catch (Exception e10) {
                C1442a.m8289e("PaymentManagerAndOrderActivity", "intent get params error " + e10.getMessage());
            }
            this.f17222O1 = hiCloudSafeIntent.getStringExtra("srcChannel");
            this.f17223P1 = hiCloudSafeIntent.getStringExtra("salChannel");
            this.f17224Q1 = hiCloudSafeIntent.getStringExtra("activityCode");
        }
        C1442a.m8290i("PaymentManagerAndOrderActivity", "onCreate");
        m23644K5();
        m28587n1();
        mo19460T3();
        m23647S5();
        m23650M5();
        m23646P5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        C1442a.m8290i("PaymentManagerAndOrderActivity", "onDestroy");
        super.onDestroy();
        AlertDialog alertDialog = this.f17216I1;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f17216I1 = null;
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: q0 */
    public void mo23205q0(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo) throws JSONException {
        if (cloudPackage == null) {
            C1442a.m8288d("PaymentManagerAndOrderActivity", " mSelectPackage is null.");
        } else {
            m22880u5(cloudPackage, packageGrades, "pay_manage_purchase", list, m22882v2(), reportVoucherInfo, this.f21452m.getDeductAmount());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        m28583a1();
        if (m23645L5()) {
            C1442a.m8290i("PaymentManagerAndOrderActivity", "begin showView");
            if (this.f16540W == null) {
                mo19477k5();
            }
            m23658V5();
            m23659W5(this.f21452m);
            mo19476h5();
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: t */
    public void mo23208t(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            C1442a.m8289e("PaymentManagerAndOrderActivity", "reportClickEvent, eventObject is null.");
        } else {
            linkedHashMap.put("way_of_purchase", "pay_manage_purchase");
            m22842j4(str, linkedHashMap);
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView.SendMessageCommunicator
    /* renamed from: y */
    public void mo23213y(CloudPackage cloudPackage, PackageGrades packageGrades, int i10) {
        m22872s4(cloudPackage, packageGrades, "pay_manage_purchase", i10);
    }
}
