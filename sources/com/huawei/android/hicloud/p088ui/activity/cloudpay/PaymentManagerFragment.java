package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.AbstractC0984a;
import androidx.viewpager.widget.ViewPager;
import com.huawei.android.hicloud.logic.threadpool.TaskHandle;
import com.huawei.android.hicloud.p088ui.activity.PaymanagerBaseFragment;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchFitRelativeLayout;
import com.huawei.android.hicloud.p088ui.uiextend.ListItemWith2TextView;
import com.huawei.android.hicloud.p088ui.views.WrapContentHeightViewPager;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.MonthDetail;
import com.huawei.cloud.pay.model.MonthSign;
import com.huawei.cloud.pay.model.MonthStartResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;
import com.huawei.hms.support.api.pay.PayResult;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import dj.C9158a;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import p015ak.C0209d;
import p015ak.C0225l;
import p054cj.C1442a;
import p429kk.C11060c;
import p454lj.C11290m;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p681uj.C13197n;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

@SuppressLint({"ValidFragment"})
/* loaded from: classes3.dex */
public class PaymentManagerFragment extends PaymanagerBaseFragment implements View.OnClickListener {

    /* renamed from: A */
    public String f17246A;

    /* renamed from: B */
    public String f17247B;

    /* renamed from: C */
    public String f17248C;

    /* renamed from: D */
    public String f17249D;

    /* renamed from: E */
    public ListItemWith2TextView f17250E;

    /* renamed from: F */
    public ListItemWith2TextView f17251F;

    /* renamed from: G */
    public View f17252G;

    /* renamed from: H */
    public View f17253H;

    /* renamed from: I */
    public ListItemWith2TextView f17254I;

    /* renamed from: J */
    public ListItemWith2TextView f17255J;

    /* renamed from: K */
    public ListItemWith2TextView f17256K;

    /* renamed from: L */
    public ListItemWith2TextView f17257L;

    /* renamed from: M */
    public ListItemWith2TextView f17258M;

    /* renamed from: N */
    public ListItemWith2TextView f17259N;

    /* renamed from: O */
    public ListItemWith2TextView f17260O;

    /* renamed from: P */
    public ListItemWith2TextView f17261P;

    /* renamed from: Q */
    public View f17262Q;

    /* renamed from: R */
    public TextView f17263R;

    /* renamed from: S */
    public View f17264S;

    /* renamed from: T */
    public NotchFitRelativeLayout f17265T;

    /* renamed from: U */
    public WrapContentHeightViewPager f17266U;

    /* renamed from: V */
    public ImageView f17267V;

    /* renamed from: W */
    public ImageView f17268W;

    /* renamed from: X */
    public CloudSpaceUpgradeActivity.C3625l f17269X;

    /* renamed from: b0 */
    public AlertDialog f17273b0;

    /* renamed from: c */
    public View f17274c;

    /* renamed from: c0 */
    public boolean f17275c0;

    /* renamed from: d */
    public ListItemWith2TextView f17276d;

    /* renamed from: d0 */
    public UserPackage f17277d0;

    /* renamed from: e */
    public ListItemWith2TextView f17278e;

    /* renamed from: e0 */
    public ArrayList<FilterAvailabalGradePackage> f17279e0;

    /* renamed from: f */
    public ListItemWith2TextView f17280f;

    /* renamed from: f0 */
    public GetClientUIConfigResp f17281f0;

    /* renamed from: g */
    public ListItemWith2TextView f17282g;

    /* renamed from: g0 */
    public C11060c f17283g0;

    /* renamed from: h */
    public NotchFitRelativeLayout f17284h;

    /* renamed from: h0 */
    public Context f17285h0;

    /* renamed from: i */
    public View f17286i;

    /* renamed from: i0 */
    public TaskHandle f17287i0;

    /* renamed from: j */
    public View f17288j;

    /* renamed from: k */
    public View f17290k;

    /* renamed from: k0 */
    public LinearLayout f17291k0;

    /* renamed from: l */
    public View f17292l;

    /* renamed from: l0 */
    public LinearLayout f17293l0;

    /* renamed from: m */
    public View f17294m;

    /* renamed from: m0 */
    public TextView f17295m0;

    /* renamed from: n */
    public View f17296n;

    /* renamed from: n0 */
    public TextView f17297n0;

    /* renamed from: o */
    public View f17298o;

    /* renamed from: o0 */
    public ListItemWith2TextView f17299o0;

    /* renamed from: p */
    public AutoSizeButton f17300p;

    /* renamed from: p0 */
    public LinearLayout f17301p0;

    /* renamed from: q */
    public AutoSizeButton f17302q;

    /* renamed from: q0 */
    public MonthDetail f17303q0;

    /* renamed from: r */
    public TextView f17304r;

    /* renamed from: r0 */
    public MonthDetail f17305r0;

    /* renamed from: s */
    public String f17306s;

    /* renamed from: t */
    public String f17308t;

    /* renamed from: u */
    public String f17310u;

    /* renamed from: v */
    public String f17312v;

    /* renamed from: w */
    public String f17314w;

    /* renamed from: x */
    public String f17315x;

    /* renamed from: y */
    public String f17316y;

    /* renamed from: z */
    public String f17317z;

    /* renamed from: Y */
    public int f17270Y = 0;

    /* renamed from: Z */
    public List<GradePackageCardView> f17271Z = new ArrayList();

    /* renamed from: a0 */
    public HandlerC3643b f17272a0 = new HandlerC3643b(this);

    /* renamed from: j0 */
    public List<Voucher> f17289j0 = new ArrayList();

    /* renamed from: s0 */
    public boolean f17307s0 = false;

    /* renamed from: t0 */
    public long f17309t0 = 0;

    /* renamed from: u0 */
    public long f17311u0 = 0;

    /* renamed from: v0 */
    public boolean f17313v0 = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PaymentManagerFragment$a */
    public class DialogInterfaceOnClickListenerC3642a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3642a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (PaymentManagerFragment.this.f17273b0 != null) {
                PaymentManagerFragment.this.f17273b0.dismiss();
                PaymentManagerFragment.this.getActivity().setResult(-1);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PaymentManagerFragment$b */
    public class HandlerC3643b extends Handler {

        /* renamed from: a */
        public WeakReference<PaymentManagerFragment> f17319a;

        public HandlerC3643b(PaymentManagerFragment paymentManagerFragment) {
            this.f17319a = new WeakReference<>(paymentManagerFragment);
        }

        /* renamed from: a */
        public void m23724a(Message message) {
            int i10 = message.what;
            if (i10 == 2018) {
                PaymentManagerFragment.this.m23685C(message.arg1, message.obj);
            } else if (i10 != 2118) {
                super.handleMessage(message);
            } else {
                C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler START_MONTH_PAY_FAILED");
                PaymentManagerFragment.this.f17273b0.show();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            Object obj;
            if (this.f17319a.get() == null) {
                C1442a.m8289e("PaymentManagerFragment", " ContinuousMonthlyHandler error, PaymentManagerFragment getcontext is null.");
                return;
            }
            Activity activity = PaymentManagerFragment.this.getActivity();
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).m28583a1();
            }
            int i10 = message.what;
            if (i10 == 2015) {
                PaymentManagerFragment.this.m23684B(message.arg1, message.obj);
                return;
            }
            if (i10 == 2017) {
                if (!PaymentManagerFragment.this.f17307s0) {
                    PaymentManagerFragment.this.m23723z(message.arg1, message.obj);
                } else if (message.arg1 == 0 && (obj = message.obj) != null && (obj instanceof MonthDetail)) {
                    PaymentManagerFragment.this.f17303q0 = (MonthDetail) obj;
                }
                PaymentManagerFragment.this.m23690H(2);
                return;
            }
            if (i10 == 2117) {
                PaymentManagerFragment.this.m23690H(2);
                C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GETMONTHPAY_FAILED query failed");
                if (message.arg1 == 802) {
                    PaymentManagerFragment.this.f17275c0 = true;
                }
                PaymentManagerFragment.this.m23714h0(true);
                return;
            }
            if (i10 == 2114) {
                C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GET_MANAGER_UIPARAMS_FAILED query failed");
                return;
            }
            if (i10 == 2115) {
                PaymentManagerFragment.this.m23683A(message.arg1);
                return;
            }
            if (i10 == 2132) {
                C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GETMONTHPAY_WORRY_FREE_FAILED query failed");
                if (message.arg1 == 802) {
                    PaymentManagerFragment.this.f17253H.setVisibility(8);
                }
                if (PaymentManagerFragment.this.f17307s0) {
                    PaymentManagerFragment paymentManagerFragment = PaymentManagerFragment.this;
                    paymentManagerFragment.m23723z(0, paymentManagerFragment.f17303q0);
                    return;
                }
                return;
            }
            if (i10 != 2133) {
                m23724a(message);
                return;
            }
            if (PaymentManagerFragment.this.f17307s0) {
                PaymentManagerFragment paymentManagerFragment2 = PaymentManagerFragment.this;
                paymentManagerFragment2.m23723z(0, paymentManagerFragment2.f17303q0);
            }
            PaymentManagerFragment.this.m23722y(message.arg1, message.obj);
            PaymentManagerFragment.this.m23688F();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PaymentManagerFragment$c */
    public class C3644c implements ResultCallback<PayResult> {

        /* renamed from: a */
        public int f17321a;

        public C3644c(int i10) {
            this.f17321a = i10;
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(PayResult payResult) {
            Status status = payResult.getStatus();
            PaymentManagerFragment.this.f17283g0.m66665u("114_" + status.getStatusCode());
            PaymentManagerFragment.this.f17283g0.m66635A(status.getStatusMessage());
            if (status.getStatusCode() != 0) {
                C1442a.m8289e("PaymentManagerFragment", "hms pay error. code = " + status.getStatusCode() + " msg = " + status.getStatusMessage());
                return;
            }
            try {
                status.startResolutionForResult(PaymentManagerFragment.this.getActivity(), this.f17321a);
            } catch (IntentSender.SendIntentException e10) {
                C1442a.m8289e("PaymentManagerFragment", "hms pay error." + e10.getMessage());
                PaymentManagerFragment.this.f17273b0.show();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.PaymentManagerFragment$d */
    public class C3645d implements ViewPager.InterfaceC0980i {

        /* renamed from: a */
        public WrapContentHeightViewPager f17323a;

        public C3645d(WrapContentHeightViewPager wrapContentHeightViewPager) {
            this.f17323a = wrapContentHeightViewPager;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0980i
        public void onPageSelected(int i10) {
            List<GradePackageCardView> listM23471d;
            WrapContentHeightViewPager wrapContentHeightViewPager = this.f17323a;
            if (wrapContentHeightViewPager == null) {
                return;
            }
            AbstractC0984a adapter = wrapContentHeightViewPager.getAdapter();
            if (!(adapter instanceof CloudSpaceUpgradeActivity.C3625l) || (listM23471d = ((CloudSpaceUpgradeActivity.C3625l) adapter).m23471d()) == null || i10 >= listM23471d.size() || listM23471d.get(i10) == null) {
                return;
            }
            PaymentManagerFragment.this.m23719v(i10, listM23471d.size());
        }
    }

    /* renamed from: L */
    public static void m23664L(Context context, int i10, int i11, View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            if (view != null) {
                if (C11842p.m70771U0()) {
                    if (C11842p.m70753O0(context)) {
                        m23665Y(view, C11842p.m70840n(context, i10));
                    } else {
                        m23665Y(view, C11842p.m70840n(context, i10));
                    }
                } else if (C11842p.m70747M0(context)) {
                    if (C11842p.m70753O0(context)) {
                        m23665Y(view, C11842p.m70840n(context, i10));
                    } else {
                        m23665Y(view, C11842p.m70840n(context, i10));
                    }
                } else if (C11842p.m70753O0(context)) {
                    m23665Y(view, C11842p.m70840n(context, i10));
                } else {
                    m23665Y(view, C11842p.m70840n(context, i11));
                }
            }
        }
    }

    /* renamed from: Y */
    public static void m23665Y(View view, int i10) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                layoutParams2.setMarginStart(i10);
                layoutParams2.setMarginEnd(i10);
                view.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: A */
    public final void m23683A(int i10) {
        C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GETSIGNINFO_FAILED");
        this.f17273b0.show();
    }

    /* renamed from: B */
    public final void m23684B(int i10, Object obj) {
        C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GETSIGNINFO_SUCCESS");
        if (i10 != 0 || obj == null || !(obj instanceof MonthSign)) {
            this.f17273b0.show();
        } else {
            C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GETSIGNINFO_SUCCESS callHWWalletSigned");
            m23718u((MonthSign) obj);
        }
    }

    /* renamed from: C */
    public final void m23685C(int i10, Object obj) {
        C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler STARTMONTHPAY_SUCCESS");
        if (i10 != 0 || obj == null || !(obj instanceof MonthStartResp)) {
            this.f17273b0.show();
            return;
        }
        MonthStartResp monthStartResp = (MonthStartResp) obj;
        MonthDetail monthDetail = new MonthDetail();
        monthDetail.setIsAutoPay(1);
        monthDetail.setNextCapacity(monthStartResp.getCapacity());
        monthDetail.setNextProductType(monthStartResp.getProductType());
        monthDetail.setNextPackageId(monthStartResp.getId());
        monthDetail.setCurProductType(monthStartResp.getProductType());
        monthDetail.setNextPrice(monthStartResp.getPrice());
        monthDetail.setTaskDate(monthStartResp.getTaskDate());
        monthDetail.setChannel(monthStartResp.getChannel());
        m23708b0(monthDetail);
    }

    /* renamed from: D */
    public final void m23686D(String str, boolean z10) throws Resources.NotFoundException {
        this.f17308t = str;
        if (this.f17277d0.getIsAutoPay() == 0) {
            this.f17276d.setRightText(str);
            this.f17280f.setVisibility(0);
            this.f17280f.setLeftText(m23692J(R$string.payment_date_title));
            String strM67741b = C11290m.m67741b(getContext(), C11293p.m67757a(this.f17277d0).getEndTime());
            this.f17306s = strM67741b;
            this.f17280f.setRightText(strM67741b);
            this.f17276d.setVisibility(0);
            m23714h0(z10);
            m23690H(2);
        } else {
            this.f17276d.setRightText(str);
            this.f17276d.setVisibility(8);
            this.f17280f.setVisibility(8);
            this.f17262Q.setVisibility(8);
            this.f17264S.setVisibility(8);
            m23689G();
        }
        m23687E();
    }

    /* renamed from: E */
    public final void m23687E() {
        if (!C11293p.m67772p(this.f17277d0)) {
            this.f17301p0.setVisibility(8);
            return;
        }
        CloudSpace cloudSpaceM67758b = C11293p.m67758b(this.f17277d0);
        if (cloudSpaceM67758b != null && cloudSpaceM67758b.getIsAutoPay() == 0) {
            this.f17301p0.setVisibility(0);
            this.f17278e.setText(cloudSpaceM67758b.getProductName());
            this.f17282g.setLeftText(m23692J(R$string.payment_date_title));
            this.f17282g.setVisibility(0);
            String strM67741b = C11290m.m67741b(getContext(), cloudSpaceM67758b.getEndTime());
            this.f17317z = strM67741b;
            this.f17282g.setText(strM67741b);
            this.f17278e.setVisibility(0);
        }
        if (getActivity() != null) {
            this.f17278e.setTextColor(getActivity().getResources().getColor(R$color.worry_free_enjoying_title));
        }
    }

    /* renamed from: F */
    public final void m23688F() {
        MonthDetail monthDetail = this.f17303q0;
        if (monthDetail == null || this.f17305r0 == null || !this.f17307s0) {
            return;
        }
        boolean z10 = monthDetail.getIsAutoPay() == 1;
        boolean z11 = this.f17305r0.getIsAutoPay() == 1;
        String channel = this.f17303q0.getChannel();
        String nextPrice = this.f17303q0.getNextPrice();
        String currency = this.f17303q0.getCurrency();
        String channel2 = this.f17305r0.getChannel();
        String nextPrice2 = this.f17305r0.getNextPrice();
        String currency2 = this.f17305r0.getCurrency();
        if (z10 && z11) {
            this.f17250E.setVisibility(0);
            this.f17252G.setVisibility(0);
            this.f17251F.setVisibility(0);
            this.f17253H.setVisibility(0);
            if (this.f17309t0 <= this.f17311u0) {
                this.f17313v0 = false;
                this.f17312v = this.f17303q0.getNextProductName();
                this.f17315x = C11290m.m67741b(getContext(), this.f17303q0.getTaskDate());
                try {
                    this.f17314w = C11290m.m67749j(new BigDecimal(nextPrice), currency, currency);
                } catch (NumberFormatException unused) {
                    C1442a.m8289e("PaymentManagerFragment", "showMonthPayRenewalInfo NumberFormatException");
                    m23711e0();
                }
                if ("AliPay".equalsIgnoreCase(channel)) {
                    channel = m23692J(R$string.cloudpay_paymend_method_alipay);
                } else if ("TenPay".equalsIgnoreCase(channel)) {
                    channel = m23692J(R$string.cloudpay_paymend_method_tenpay);
                }
                this.f17310u = channel;
                if (getActivity() != null) {
                    Resources resources = getActivity().getResources();
                    this.f17278e.setTextColor(resources.getColor(R$color.worry_free_enjoying_title));
                    this.f17276d.setTextColor(resources.getColor(R$color.emui_color_text_secondary));
                }
                this.f17316y = this.f17305r0.getCurProductName();
                this.f17247B = this.f17305r0.getNextProductName();
                try {
                    this.f17248C = C11290m.m67749j(new BigDecimal(nextPrice2), currency2, currency2);
                } catch (NumberFormatException unused2) {
                    C1442a.m8289e("PaymentManagerFragment", "showMonthPayRenewalInfo NumberFormatException");
                    m23711e0();
                }
                this.f17249D = C11290m.m67741b(getContext(), this.f17305r0.getTaskDate());
                if ("AliPay".equalsIgnoreCase(channel2)) {
                    channel2 = m23692J(R$string.cloudpay_paymend_method_alipay);
                } else if ("TenPay".equalsIgnoreCase(channel2)) {
                    channel2 = m23692J(R$string.cloudpay_paymend_method_tenpay);
                }
                this.f17246A = channel2;
                this.f17276d.setRightText(this.f17308t);
                this.f17278e.setText(this.f17316y);
            } else {
                this.f17313v0 = true;
                this.f17312v = this.f17305r0.getNextProductName();
                this.f17316y = this.f17305r0.getCurProductName();
                this.f17315x = C11290m.m67741b(getContext(), this.f17305r0.getTaskDate());
                try {
                    this.f17314w = C11290m.m67749j(new BigDecimal(nextPrice2), currency2, currency2);
                } catch (NumberFormatException unused3) {
                    C1442a.m8289e("PaymentManagerFragment", "showMonthPayRenewalInfo NumberFormatException");
                    m23711e0();
                }
                if ("AliPay".equalsIgnoreCase(channel2)) {
                    channel2 = m23692J(R$string.cloudpay_paymend_method_alipay);
                } else if ("TenPay".equalsIgnoreCase(channel2)) {
                    channel2 = m23692J(R$string.cloudpay_paymend_method_tenpay);
                }
                this.f17310u = channel2;
                if (getActivity() != null) {
                    Resources resources2 = getActivity().getResources();
                    this.f17276d.setTextColor(resources2.getColor(R$color.worry_free_enjoying_title));
                    this.f17278e.setTextColor(resources2.getColor(R$color.emui_color_text_secondary));
                }
                this.f17247B = this.f17303q0.getNextProductName();
                try {
                    this.f17248C = C11290m.m67749j(new BigDecimal(nextPrice), currency, currency);
                } catch (NumberFormatException unused4) {
                    C1442a.m8289e("PaymentManagerFragment", "showMonthPayRenewalInfo NumberFormatException");
                    m23711e0();
                }
                this.f17249D = C11290m.m67741b(getContext(), this.f17303q0.getTaskDate());
                if ("AliPay".equalsIgnoreCase(channel)) {
                    channel = m23692J(R$string.cloudpay_paymend_method_alipay);
                } else if ("TenPay".equalsIgnoreCase(channel)) {
                    channel = m23692J(R$string.cloudpay_paymend_method_tenpay);
                }
                this.f17246A = channel;
                this.f17276d.setRightText(this.f17316y);
                this.f17278e.setText(this.f17308t);
            }
            this.f17276d.setVisibility(0);
            this.f17276d.showDivider(true);
            this.f17254I.setRightText(this.f17312v);
            this.f17256K.setText(this.f17314w);
            this.f17258M.setText(this.f17315x);
            this.f17260O.setRightText(this.f17310u);
            this.f17255J.setText(this.f17247B);
            this.f17257L.setText(this.f17248C);
            this.f17259N.setText(this.f17249D);
            this.f17261P.setText(this.f17246A);
        }
    }

    /* renamed from: G */
    public final void m23689G() {
        if (getActivity() instanceof BasePayActivity) {
            this.f17287i0 = C9158a.m57503F().m57525W(this.f17272a0, this.f17283g0);
        }
    }

    /* renamed from: H */
    public final void m23690H(int i10) {
        C1442a.m8290i("PaymentManagerFragment", "getContinuousMonthlyPkgInfo worryFree start");
        CloudSpace cloudSpaceM67758b = C11293p.m67758b(this.f17277d0);
        if (cloudSpaceM67758b == null) {
            C1442a.m8290i("PaymentManagerFragment", "getContinuousMonthlyPkgInfo worryFree is null");
        } else if (cloudSpaceM67758b.getIsAutoPay() == 5) {
            C1442a.m8290i("PaymentManagerFragment", "getContinuousMonthlyPkgInfo worryFree isAutoPay is BASIC_TYPE");
        } else if (getActivity() instanceof BasePayActivity) {
            this.f17287i0 = C9158a.m57503F().m57526X(this.f17272a0, this.f17283g0, i10, null);
        }
    }

    /* renamed from: I */
    public List<GradePackageCardView> m23691I(ArrayList<FilterAvailabalGradePackage> arrayList) {
        return C0209d.m1205R0(arrayList) ? new ArrayList() : C0225l.m1579c(arrayList, new Function() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.l0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f17556a.m23697P((FilterAvailabalGradePackage) obj);
            }
        });
    }

    /* renamed from: J */
    public final String m23692J(int i10) {
        return isAdded() ? getString(i10) : "";
    }

    /* renamed from: K */
    public final void m23693K() throws Resources.NotFoundException {
        C1442a.m8290i("PaymentManagerFragment", "initData");
        Activity activity = getActivity();
        if (activity instanceof BasePayActivity) {
            BasePayActivity basePayActivity = (BasePayActivity) activity;
            basePayActivity.m28588o1("06008");
            this.f17283g0 = basePayActivity.f21448i;
        }
        UserPackage userPackage = this.f17277d0;
        if (userPackage == null) {
            C1442a.m8289e("PaymentManagerFragment", "initData user is null.");
            return;
        }
        boolean zM67772p = C11293p.m67772p(userPackage);
        CloudSpace cloudSpaceM67758b = C11293p.m67758b(this.f17277d0);
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f17277d0);
        if (cloudSpaceM67758b == null || cloudSpaceM67757a == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("effectivePackageWorryFree is null: ");
            sb2.append(cloudSpaceM67758b == null);
            C1442a.m8290i("PaymentManagerFragment", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("effectivePackage is null: ");
            sb3.append(cloudSpaceM67758b == null);
            C1442a.m8290i("PaymentManagerFragment", sb3.toString());
        } else {
            this.f17309t0 = cloudSpaceM67757a.getEndTime();
            this.f17311u0 = cloudSpaceM67758b.getEndTime();
            this.f17307s0 = cloudSpaceM67758b.getIsAutoPay() == 1 && this.f17277d0.getIsAutoPay() == 1;
        }
        if (C11293p.m67767k(this.f17277d0) == 1) {
            m23686D(C11293p.m67763g(this.f17277d0), true);
        } else if (zM67772p) {
            m23686D(C11293p.m67764h(this.f17277d0, 12), false);
        } else {
            this.f17301p0.setVisibility(8);
            m23714h0(false);
        }
        m23707a0();
    }

    /* renamed from: M */
    public final void m23694M() throws Resources.NotFoundException {
        this.f17265T = (NotchFitRelativeLayout) C12809f.m76831d(this.f17274c, R$id.payment_viewpage_area);
        this.f17266U = (WrapContentHeightViewPager) C12809f.m76831d(this.f17274c, R$id.member_card_fragment);
        int iM70840n = C11842p.m70840n(this.f17285h0, 16);
        CloudSpaceUpgradeActivity.C3625l c3625l = new CloudSpaceUpgradeActivity.C3625l(this.f17285h0, this.f17271Z);
        this.f17269X = c3625l;
        this.f17266U.setAdapter(c3625l);
        this.f17266U.setCurrentItem(0);
        this.f17266U.setPageMargin(iM70840n);
        this.f17266U.setOffscreenPageLimit(3);
        WrapContentHeightViewPager wrapContentHeightViewPager = this.f17266U;
        wrapContentHeightViewPager.addOnPageChangeListener(new C3645d(wrapContentHeightViewPager));
        this.f17267V = (ImageView) C12809f.m76831d(this.f17274c, R$id.payment_viewpage_left_iv);
        this.f17268W = (ImageView) C12809f.m76831d(this.f17274c, R$id.payment_viewpage_right_iv);
        this.f17267V.setOnClickListener(this);
        this.f17268W.setOnClickListener(this);
    }

    /* renamed from: N */
    public final void m23695N() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f17284h = (NotchFitRelativeLayout) C12809f.m76831d(this.f17274c, R$id.notch_main_layout);
        this.f17276d = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.member_name_info_tv_list_item);
        this.f17278e = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.member_name_info_tv_second);
        this.f17282g = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.monthly_not_auto_tv_second);
        this.f17280f = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.monthly_not_auto_tv_list_item);
        this.f17286i = C12809f.m76831d(this.f17274c, R$id.notch_fit_load_view);
        this.f17301p0 = (LinearLayout) C12809f.m76831d(this.f17274c, R$id.second_scheme_container);
        this.f17250E = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.continuous_monthly_opened_tittle);
        this.f17251F = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.continuous_monthly_opened_tittle_second);
        this.f17250E.setVisibility(8);
        this.f17251F.setVisibility(8);
        this.f17252G = C12809f.m76831d(this.f17274c, R$id.next_month_renewal_package_detail);
        this.f17253H = C12809f.m76831d(this.f17274c, R$id.next_month_renewal_package_detail_second);
        this.f17252G.setVisibility(8);
        this.f17253H.setVisibility(8);
        this.f17254I = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.renewal_package_size);
        this.f17255J = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.renewal_package_size_second);
        this.f17256K = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.next_month_renewal_amount);
        this.f17257L = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.next_month_renewal_amount_second);
        this.f17258M = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.next_renewal_date);
        this.f17259N = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.next_renewal_date_second);
        this.f17260O = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.payment_method_list_item);
        this.f17261P = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.payment_method_second);
        this.f17262Q = C12809f.m76831d(this.f17274c, R$id.reconmend_layout);
        this.f17264S = C12809f.m76831d(this.f17274c, R$id.fragment_title_layout);
        this.f17263R = (TextView) C12809f.m76831d(this.f17274c, R$id.fragment_title_value);
        this.f17250E.setOnClickListener(this);
        this.f17251F.setOnClickListener(this);
        this.f17296n = C12809f.m76831d(this.f17274c, R$id.pay_card_line);
        this.f17298o = C12809f.m76831d(this.f17274c, R$id.pay_card_line_second);
        this.f17296n.setVisibility(8);
        this.f17273b0 = new AlertDialog.Builder(getContext()).create();
        C11829c.m70594l1(getContext(), this.f17273b0);
        this.f17273b0.setMessage(m23692J(R$string.cloudpay_open_continuous_monthly_failed_tips));
        this.f17273b0.setButton(-1, m23692J(R$string.cloudpay_huaweipay_sure), new DialogInterfaceOnClickListenerC3642a());
        this.f17288j = C12809f.m76831d(this.f17274c, R$id.layout_main);
        this.f17290k = C12809f.m76831d(this.f17274c, R$id.layout_loading);
        this.f17292l = C12809f.m76831d(this.f17274c, R$id.layout_no_information);
        this.f17294m = C12809f.m76831d(this.f17274c, R$id.layout_nonetwork);
        this.f17300p = (AutoSizeButton) C12809f.m76831d(this.f17274c, R$id.set_no_information_get_info);
        this.f17295m0 = (TextView) C12809f.m76831d(this.f17274c, R$id.diff_current_register);
        this.f17297n0 = (TextView) C12809f.m76831d(this.f17274c, R$id.diff_current_service);
        C11842p.m70866t1(getActivity(), this.f17300p);
        this.f17300p.setOnClickListener(this);
        this.f17302q = (AutoSizeButton) C12809f.m76831d(this.f17274c, R$id.set_no_net_btn);
        C11842p.m70866t1(getActivity(), this.f17302q);
        this.f17302q.setOnClickListener(this);
        this.f17304r = (TextView) C12809f.m76831d(this.f17274c, R$id.free_user_tips);
        this.f17291k0 = (LinearLayout) C12809f.m76831d(this.f17274c, R$id.renewal_service_diff_register);
        this.f17293l0 = (LinearLayout) C12809f.m76831d(this.f17274c, R$id.renewal_no_package);
        ListItemWith2TextView listItemWith2TextView = (ListItemWith2TextView) C12809f.m76831d(this.f17274c, R$id.notch_petal_one_layout);
        this.f17299o0 = listItemWith2TextView;
        listItemWith2TextView.setOnClickListener(this);
        m23700S();
        C11842p.m70863s2(this.f17288j, this.f17286i);
        m23664L(this.f17285h0, 24, 0, this.f17296n);
        m23664L(this.f17285h0, 24, 24, this.f17266U);
        m23694M();
    }

    /* renamed from: O */
    public final boolean m23696O(FilterAvailabalGradePackage filterAvailabalGradePackage) {
        return (filterAvailabalGradePackage.getMonthlyPackageList() == null || filterAvailabalGradePackage.getMonthlyPackageList().isEmpty()) ? false : true;
    }

    /* renamed from: P */
    public final /* synthetic */ GradePackageCardView m23697P(FilterAvailabalGradePackage filterAvailabalGradePackage) {
        if (filterAvailabalGradePackage == null || !m23696O(filterAvailabalGradePackage)) {
            return null;
        }
        GradePackageCardView gradePackageCardView = new GradePackageCardView(getActivity());
        String gradeCode = this.f17277d0.getGradeRights().getGradeCode();
        boolean z10 = !TextUtils.isEmpty(gradeCode) && gradeCode.equals(filterAvailabalGradePackage.getGradeCode());
        gradePackageCardView.setUser(this.f17277d0);
        if (!C11296s.m67787K() || C11296s.m67789M(this.f17285h0)) {
            gradePackageCardView.m23553O(filterAvailabalGradePackage, this.f17281f0, false, z10, this.f17289j0, null, null, true, this.f17277d0.getDeductAmount(), (Activity) this.f17285h0);
        } else {
            gradePackageCardView.m23553O(filterAvailabalGradePackage, this.f17281f0, false, z10, this.f17289j0, null, null, true, this.f17277d0.getDeductAmount(), (Activity) this.f17285h0);
        }
        return gradePackageCardView;
    }

    /* renamed from: Q */
    public final void m23698Q() throws Resources.NotFoundException {
        ArrayList<FilterAvailabalGradePackage> arrayList = this.f17279e0;
        if (arrayList == null || arrayList.isEmpty()) {
            C1442a.m8290i("PaymentManagerFragment", "readyShowRecommendPackage dataList == null or isEmpty");
        } else {
            Iterator<FilterAvailabalGradePackage> it = this.f17279e0.iterator();
            while (it.hasNext()) {
                FilterAvailabalGradePackage next = it.next();
                PackageGrades packageGrades = next.getPackageGrades();
                if (packageGrades != null && packageGrades.getRecommended() == 1) {
                    next.getMonthlyPackageList().isEmpty();
                }
            }
        }
        m23715i0();
    }

    /* renamed from: R */
    public void m23699R(UserPackage userPackage, ArrayList<FilterAvailabalGradePackage> arrayList, GetClientUIConfigResp getClientUIConfigResp, Context context, List<Voucher> list) {
        this.f17277d0 = userPackage;
        this.f17281f0 = getClientUIConfigResp;
        this.f17279e0 = arrayList;
        this.f17285h0 = context;
        this.f17289j0 = list;
    }

    /* renamed from: S */
    public final void m23700S() {
        if (!C11293p.m67770n(this.f17277d0) || C11293p.m67771o(this.f17277d0)) {
            this.f17299o0.setVisibility(8);
            this.f17251F.showDivider(false);
            return;
        }
        GetClientUIConfigResp getClientUIConfigResp = this.f17281f0;
        if (getClientUIConfigResp == null) {
            this.f17299o0.setVisibility(8);
            return;
        }
        String petalOneTitle = getClientUIConfigResp.getPetalOneTitle();
        String petalOneManageTips = this.f17281f0.getPetalOneManageTips();
        if (TextUtils.isEmpty(petalOneTitle) || TextUtils.isEmpty(petalOneManageTips)) {
            this.f17299o0.setVisibility(8);
            this.f17251F.showDivider(false);
        } else {
            this.f17299o0.setVisibility(0);
            this.f17299o0.setLeftText(petalOneTitle);
            this.f17299o0.setRightText(petalOneManageTips);
        }
    }

    /* renamed from: T */
    public void m23701T() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            Activity activity = getActivity();
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).m28593u1(linkedHashMapM79497A);
            }
            C13227f.m79492i1().m79567R("UNIFORM_CLICK_AUTO_RENEWAL_ITEM", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLICK_AUTO_RENEWAL_ITEM", "1", "32", linkedHashMapM79497A);
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).m28575A1("UNIFORM_CLICK_AUTO_RENEWAL_ITEM", linkedHashMapM79497A);
            }
        } catch (Exception e10) {
            C1442a.m8289e("PaymentManagerFragment", "reportClickAutoRenewalItemBySource error occur:" + e10.getMessage());
        }
    }

    /* renamed from: U */
    public void m23702U() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            Activity activity = getActivity();
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).m28593u1(linkedHashMapM79497A);
            }
            linkedHashMapM79497A.put("way_of_purchase", "pay_manage_purchase");
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_SERVICE_DIFF_COUNTRY", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_SERVICE_DIFF_COUNTRY", "1", "32", linkedHashMapM79497A);
            if (activity instanceof BasePayActivity) {
                ((BasePayActivity) activity).m28575A1("UNIFORM_CLOUDPAY_SERVICE_DIFF_COUNTRY", linkedHashMapM79497A);
            }
        } catch (Exception e10) {
            C1442a.m8289e("PaymentManagerFragment", "reportClickAutoRenewalItemBySource error occur:" + e10.getMessage());
        }
    }

    /* renamed from: V */
    public final void m23703V(ViewPager viewPager) throws Resources.NotFoundException {
        GradePackageCardView gradePackageCardView;
        if (viewPager == null) {
            return;
        }
        AbstractC0984a adapter = viewPager.getAdapter();
        if (adapter instanceof CloudSpaceUpgradeActivity.C3625l) {
            CloudSpaceUpgradeActivity.C3625l c3625l = (CloudSpaceUpgradeActivity.C3625l) adapter;
            int iM23468a = c3625l.m23468a();
            if (iM23468a == -1) {
                C1442a.m8291w("PaymentManagerFragment", "no recommend grade");
                return;
            }
            viewPager.setCurrentItem(iM23468a);
            m23719v(iM23468a, this.f17269X.getCount());
            List<GradePackageCardView> listM23471d = c3625l.m23471d();
            if (listM23471d == null || listM23471d.isEmpty() || (gradePackageCardView = listM23471d.get(iM23468a)) == null) {
                return;
            }
            gradePackageCardView.m23580q();
        }
    }

    /* renamed from: W */
    public final void m23704W(Intent intent) {
        Activity activity = getActivity();
        if (activity instanceof BasePayActivity) {
            ((BasePayActivity) activity).m28580X0(intent);
        }
    }

    /* renamed from: X */
    public final void m23705X() {
        Activity activity = getActivity();
        if (activity instanceof BasePayActivity) {
            ((BasePayActivity) activity).mo19446D1();
        }
    }

    /* renamed from: Z */
    public final void m23706Z() {
        if (this.f17266U == null) {
            C1442a.m8289e("PaymentManagerFragment", "setViewPagerMargin, viewPager is null.");
            return;
        }
        List<GradePackageCardView> list = this.f17271Z;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("PaymentManagerFragment", "setViewPagerMargin, packageViewList is null.");
            return;
        }
        if (this.f17271Z.size() != 1) {
            C11842p.m70733H1(this.f17266U, C11842p.m70840n(this.f17285h0, 32));
        } else if (C11842p.m70753O0(this.f17285h0) || C11842p.m70771U0() || C11842p.m70747M0(this.f17285h0)) {
            C11842p.m70733H1(this.f17266U, C11842p.m70840n(this.f17285h0, 0));
        } else {
            C11842p.m70733H1(this.f17266U, C11842p.m70840n(this.f17285h0, 16));
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.PaymanagerBaseFragment
    /* renamed from: a */
    public List<View> mo21938a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17284h);
        arrayList.add(this.f17265T);
        return arrayList;
    }

    /* renamed from: a0 */
    public final void m23707a0() {
        this.f17288j.setVisibility(0);
        this.f17290k.setVisibility(8);
        this.f17292l.setVisibility(8);
        this.f17294m.setVisibility(8);
    }

    /* renamed from: b0 */
    public final void m23708b0(MonthDetail monthDetail) {
        int isAutoPay = monthDetail.getIsAutoPay();
        String nextPrice = monthDetail.getNextPrice();
        this.f17315x = C11290m.m67741b(getContext(), monthDetail.getTaskDate());
        String channel = monthDetail.getChannel();
        String currency = monthDetail.getCurrency();
        this.f17276d.setVisibility(0);
        this.f17276d.showDivider(true);
        if (isAutoPay == 0) {
            m23712f0();
            this.f17275c0 = true;
            return;
        }
        if (isAutoPay == 1) {
            this.f17250E.setVisibility(0);
            this.f17252G.setVisibility(0);
            this.f17254I.setRightText(monthDetail.getNextProductName());
            this.f17312v = monthDetail.getNextProductName();
            try {
                String strM67749j = C11290m.m67749j(new BigDecimal(nextPrice), currency, currency);
                this.f17314w = strM67749j;
                this.f17256K.setText(strM67749j);
            } catch (NumberFormatException unused) {
                C1442a.m8289e("PaymentManagerFragment", "showMonthPayRenewalInfo NumberFormatException");
                m23711e0();
            }
            this.f17258M.setText(this.f17315x);
            if ("AliPay".equalsIgnoreCase(channel)) {
                channel = m23692J(R$string.cloudpay_paymend_method_alipay);
            } else if ("TenPay".equalsIgnoreCase(channel)) {
                channel = m23692J(R$string.cloudpay_paymend_method_tenpay);
            }
            this.f17260O.setRightText(channel);
            this.f17310u = channel;
            C13452e.m80781L().m80816I1(true);
        }
    }

    /* renamed from: c0 */
    public final void m23709c0(MonthDetail monthDetail, int i10) {
        int isAutoPay = monthDetail.getIsAutoPay();
        String nextPrice = monthDetail.getNextPrice();
        this.f17249D = C11290m.m67741b(getContext(), monthDetail.getTaskDate());
        String channel = monthDetail.getChannel();
        String currency = monthDetail.getCurrency();
        if (isAutoPay == 0) {
            this.f17251F.setVisibility(8);
            this.f17253H.setVisibility(8);
            this.f17282g.setVisibility(8);
            return;
        }
        if (isAutoPay == 1 && i10 == 2) {
            this.f17251F.setVisibility(0);
            this.f17253H.setVisibility(0);
            this.f17278e.setText(monthDetail.getCurProductName());
            if (getActivity() != null) {
                this.f17278e.setTextColor(getActivity().getResources().getColor(R$color.worry_free_enjoying_title));
            }
            this.f17255J.setText(monthDetail.getNextProductName());
            this.f17316y = monthDetail.getCurProductName();
            this.f17247B = monthDetail.getNextProductName();
            try {
                String strM67749j = C11290m.m67749j(new BigDecimal(nextPrice), currency, currency);
                this.f17248C = strM67749j;
                this.f17257L.setText(strM67749j);
            } catch (NumberFormatException unused) {
                C1442a.m8289e("PaymentManagerFragment", "showMonthPayRenewalInfo NumberFormatException");
                m23711e0();
            }
            this.f17259N.setText(this.f17249D);
            if ("AliPay".equalsIgnoreCase(channel)) {
                channel = m23692J(R$string.cloudpay_paymend_method_alipay);
            } else if ("TenPay".equalsIgnoreCase(channel)) {
                channel = m23692J(R$string.cloudpay_paymend_method_tenpay);
            }
            this.f17261P.setText(channel);
            this.f17246A = channel;
        }
    }

    /* renamed from: d0 */
    public final void m23710d0() {
        if (C11293p.m67772p(this.f17277d0)) {
            LinearLayout linearLayout = this.f17293l0;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (this.f17276d.getVisibility() == 8) {
                this.f17298o.setVisibility(8);
            } else {
                this.f17298o.setVisibility(0);
            }
            this.f17296n.setVisibility(8);
            this.f17264S.setVisibility(8);
        } else {
            this.f17298o.setVisibility(0);
            this.f17296n.setVisibility(0);
            this.f17264S.setVisibility(0);
            LinearLayout linearLayout2 = this.f17293l0;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        LinearLayout linearLayout3 = this.f17291k0;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
    }

    /* renamed from: e0 */
    public final void m23711e0() {
        this.f17292l.setVisibility(0);
        this.f17290k.setVisibility(8);
        this.f17288j.setVisibility(8);
        this.f17294m.setVisibility(8);
    }

    /* renamed from: f0 */
    public final void m23712f0() {
        this.f17250E.setVisibility(8);
        this.f17252G.setVisibility(8);
    }

    /* renamed from: g0 */
    public final void m23713g0() throws Resources.NotFoundException {
        NotchFitRelativeLayout notchFitRelativeLayout = this.f17265T;
        if (notchFitRelativeLayout == null) {
            C1442a.m8289e("PaymentManagerFragment", "showPackagesViewPager, packageArea is null.");
            if (C11296s.m67795S()) {
                m23716j0();
                return;
            } else {
                m23710d0();
                return;
            }
        }
        notchFitRelativeLayout.setVisibility(0);
        List<GradePackageCardView> listM23691I = m23691I(this.f17279e0);
        this.f17271Z = listM23691I;
        if (listM23691I == null || listM23691I.isEmpty()) {
            this.f17265T.setVisibility(8);
            if (C11296s.m67795S()) {
                m23716j0();
                return;
            } else {
                m23710d0();
                return;
            }
        }
        if (C11842p.m70753O0(this.f17285h0)) {
            C11842p.m70733H1(this.f17265T, C11842p.m70840n(this.f17285h0, 16));
        } else {
            C11842p.m70733H1(this.f17265T, C11842p.m70840n(this.f17285h0, C0209d.m1249e1() ? 16 : 0));
        }
        m23706Z();
        CloudSpaceUpgradeActivity.C3625l c3625l = new CloudSpaceUpgradeActivity.C3625l(this.f17285h0, this.f17271Z);
        this.f17269X = c3625l;
        this.f17266U.setAdapter(c3625l);
        if (this.f17269X != null) {
            m23719v(this.f17270Y, this.f17271Z.size());
        }
        m23703V(this.f17266U);
    }

    /* renamed from: h0 */
    public final void m23714h0(boolean z10) throws Resources.NotFoundException {
        if (z10) {
            View view = this.f17296n;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView = this.f17263R;
            if (textView != null) {
                textView.setText(m23692J(R$string.payment_member_recommend_title));
                this.f17262Q.setVisibility(0);
                this.f17264S.setVisibility(0);
            }
            TextView textView2 = this.f17304r;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            m23698Q();
            return;
        }
        boolean zM67772p = C11293p.m67772p(this.f17277d0);
        this.f17276d.setVisibility(8);
        this.f17280f.setVisibility(8);
        View view2 = this.f17296n;
        if (view2 != null) {
            view2.setVisibility(zM67772p ? 8 : 0);
        }
        TextView textView3 = this.f17263R;
        if (textView3 != null) {
            textView3.setText(m23692J(R$string.cloudpay_free_member_recommend));
            this.f17262Q.setVisibility(0);
            this.f17264S.setVisibility(0);
        }
        if (this.f17304r != null) {
            if (C11293p.m67770n(this.f17277d0) || zM67772p) {
                this.f17304r.setVisibility(8);
            } else {
                this.f17304r.setVisibility(0);
            }
        }
        m23698Q();
    }

    /* renamed from: i0 */
    public final void m23715i0() throws Resources.NotFoundException {
        m23713g0();
    }

    /* renamed from: j0 */
    public final void m23716j0() {
        LinearLayout linearLayout = this.f17293l0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this.f17291k0;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
            m23702U();
        }
        TextView textView = this.f17295m0;
        if (textView != null) {
            textView.setText(getString(R$string.cloudpay_current_register, C0209d.m1177I(C13452e.m80781L().m80942m())));
        }
        TextView textView2 = this.f17297n0;
        if (textView2 != null) {
            textView2.setText(getString(R$string.cloudpay_current_service, C0209d.m1177I(C13452e.m80781L().m80921h0())));
        }
    }

    /* renamed from: k0 */
    public final void m23717k0() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("hwmycenter://com.huawei.mycenter/commonjump?page=h5common&urlKey=petalOne&from=com.huawei.hidisk&queryUrl=1"));
            startActivity(intent);
        } catch (Exception e10) {
            C1442a.m8289e("PaymentManagerFragment", "toPetalOne exception:" + e10.toString());
            if (e10 instanceof ActivityNotFoundException) {
                Toast.makeText(this.f15775b, R$string.cloudpay_no_center_app, 1).show();
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        C1442a.m8290i("PaymentManagerFragment", "onActivityResult requestCode = " + i10 + " resultCode = " + i11);
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Resources.NotFoundException {
        int id2 = view.getId();
        if (id2 == R$id.payment_viewpage_left_iv) {
            m23720w();
            return;
        }
        if (id2 == R$id.payment_viewpage_right_iv) {
            m23721x();
            return;
        }
        if (C0209d.m1226Y0()) {
            C1442a.m8291w("PaymentManagerFragment", "click too fast");
            return;
        }
        if (R$id.layout_nonetwork == id2) {
            m23693K();
            return;
        }
        if (R$id.set_no_information_get_info == id2) {
            m23693K();
            return;
        }
        if (R$id.set_no_net_btn == id2) {
            m23705X();
            return;
        }
        if (R$id.continuous_monthly_opened_tittle == id2) {
            m23701T();
            Intent intent = new Intent(this.f17285h0, (Class<?>) CancelAutoRenewalActivity.class);
            m23704W(intent);
            if (this.f17313v0) {
                intent.putExtra("user_worry_free", this.f17277d0);
            } else {
                intent.putExtra("user", this.f17277d0);
            }
            intent.putExtra("params", this.f17281f0);
            getActivity().startActivityForResult(intent, NotifyConstants.CommonActionRequestCode.OPEN_DOUBLE_FRONT_APP_NOTICE);
            return;
        }
        if (R$id.continuous_monthly_opened_tittle_second != id2) {
            if (R$id.notch_petal_one_layout == id2) {
                m23717k0();
                return;
            }
            return;
        }
        m23701T();
        Intent intent2 = new Intent(this.f17285h0, (Class<?>) CancelAutoRenewalActivity.class);
        m23704W(intent2);
        if (this.f17313v0) {
            intent2.putExtra("user", this.f17277d0);
        } else {
            intent2.putExtra("user_worry_free", this.f17277d0);
        }
        intent2.putExtra("params", this.f17281f0);
        getActivity().startActivityForResult(intent2, NotifyConstants.CommonActionRequestCode.OPEN_DOUBLE_FRONT_APP_NOTICE);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.PaymanagerBaseFragment, android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f17302q != null) {
            C11842p.m70874v1(getActivity(), this.f17302q);
        }
        C11842p.m70863s2(this.f17288j, this.f17286i);
        m23664L(this.f17285h0, 24, 0, this.f17296n);
        m23664L(this.f17285h0, 24, 30, this.f17266U);
        if (this.f17265T.getVisibility() == 0) {
            if (C11842p.m70753O0(this.f17285h0)) {
                C11842p.m70733H1(this.f17265T, C11842p.m70840n(this.f17285h0, 16));
            } else {
                C11842p.m70733H1(this.f17265T, C11842p.m70840n(this.f17285h0, C0209d.m1249e1() ? 16 : 0));
            }
            int currentItem = this.f17266U.getCurrentItem();
            int iM70840n = C11842p.m70840n(this.f17285h0, 16);
            CloudSpaceUpgradeActivity.C3625l c3625l = new CloudSpaceUpgradeActivity.C3625l(this.f17285h0, this.f17271Z);
            this.f17269X = c3625l;
            this.f17266U.setAdapter(c3625l);
            this.f17266U.setCurrentItem(currentItem);
            this.f17266U.setPageMargin(iM70840n);
            m23719v(this.f17266U.getCurrentItem(), this.f17269X.getCount());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.PaymanagerBaseFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f17274c = layoutInflater.inflate(R$layout.renewal_management_fragment, viewGroup, false);
        m23695N();
        m21939b();
        m23693K();
        return this.f17274c;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AlertDialog alertDialog = this.f17273b0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f17273b0 = null;
        }
        TaskHandle taskHandle = this.f17287i0;
        if (taskHandle != null) {
            try {
                taskHandle.cancel();
            } catch (Exception e10) {
                C1442a.m8290i("PaymentManagerFragment", "cancel getMonthPayInfoTask err : " + e10.toString());
            }
        }
        HandlerC3643b handlerC3643b = this.f17272a0;
        if (handlerC3643b != null) {
            handlerC3643b.removeCallbacksAndMessages(null);
            this.f17272a0 = null;
        }
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C1442a.m8290i("PaymentManagerFragment", "onBackPressed onOptionsItemSelected = " + this.f17275c0);
        if (menuItem.getItemId() == 16908332 && this.f17275c0) {
            getActivity().setResult(ErrorCode.ERROR_PLACEMENT_EMPTY_AD_IDS);
            this.f17275c0 = false;
        }
        return false;
    }

    /* renamed from: u */
    public final void m23718u(MonthSign monthSign) {
        if (monthSign == null) {
            this.f17273b0.show();
            return;
        }
        WithholdRequest withholdRequest = new WithholdRequest();
        withholdRequest.productName = monthSign.getProductName();
        withholdRequest.productDesc = monthSign.getProductDesc();
        withholdRequest.requestId = monthSign.getRequestId();
        withholdRequest.applicationID = monthSign.getApplicationID();
        withholdRequest.serviceCatalog = monthSign.getServiceCatalog();
        withholdRequest.amount = monthSign.getAmount();
        withholdRequest.merchantId = monthSign.getMerchantId();
        withholdRequest.currency = monthSign.getCurrency();
        withholdRequest.country = monthSign.getCountry();
        withholdRequest.sdkChannel = monthSign.getSdkChannel();
        withholdRequest.url = monthSign.getUrl();
        withholdRequest.tradeType = monthSign.getTradeType();
        withholdRequest.merchantName = m23692J(R$string.cloudpay_pay_name);
        withholdRequest.sign = monthSign.getSign();
        C13197n.m79381a().m79383c(withholdRequest, new C3644c(10007));
    }

    /* renamed from: v */
    public final void m23719v(int i10, int i11) {
        ImageView imageView = this.f17267V;
        if (imageView == null || this.f17268W == null) {
            return;
        }
        this.f17270Y = i10;
        if (i11 <= 1) {
            imageView.setVisibility(4);
            this.f17268W.setVisibility(4);
        } else if (i10 == 0) {
            imageView.setVisibility(4);
            this.f17268W.setVisibility(0);
        } else if (i10 == i11 - 1) {
            imageView.setVisibility(0);
            this.f17268W.setVisibility(4);
        } else {
            imageView.setVisibility(0);
            this.f17268W.setVisibility(0);
        }
    }

    /* renamed from: w */
    public final void m23720w() {
        try {
            WrapContentHeightViewPager wrapContentHeightViewPager = this.f17266U;
            if (wrapContentHeightViewPager == null || wrapContentHeightViewPager.getCurrentItem() <= 0) {
                return;
            }
            this.f17266U.setCurrentItem(r2.getCurrentItem() - 1);
        } catch (Exception e10) {
            C11839m.m70687e("PaymentManagerFragment", "clickViewPageLeftImageView out of count : " + e10.toString());
        }
    }

    /* renamed from: x */
    public final void m23721x() {
        try {
            WrapContentHeightViewPager wrapContentHeightViewPager = this.f17266U;
            if (wrapContentHeightViewPager == null || wrapContentHeightViewPager.getCurrentItem() >= this.f17269X.getCount() - 1) {
                return;
            }
            WrapContentHeightViewPager wrapContentHeightViewPager2 = this.f17266U;
            wrapContentHeightViewPager2.setCurrentItem(wrapContentHeightViewPager2.getCurrentItem() + 1);
        } catch (Exception e10) {
            C11839m.m70687e("PaymentManagerFragment", "clickViewPageRightImageView out of count : " + e10.toString());
        }
    }

    /* renamed from: y */
    public final void m23722y(int i10, Object obj) {
        C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GETMONTHPAY_SCHEME_SUCCESS query success");
        if (i10 != 0 || obj == null || !(obj instanceof MonthDetail)) {
            this.f17301p0.setVisibility(8);
            C1442a.m8291w("PaymentManagerFragment", "ContinuousMonthlyHandler GETMONTHPAY_SCHEME_SUCCESS but receive GetMonthPayResp null");
            m23711e0();
        } else {
            this.f17305r0 = (MonthDetail) obj;
            this.f17301p0.setVisibility(0);
            this.f17282g.setVisibility(8);
            m23709c0(this.f17305r0, 2);
        }
    }

    /* renamed from: z */
    public final void m23723z(int i10, Object obj) {
        C1442a.m8288d("PaymentManagerFragment", "ContinuousMonthlyHandler GETMONTHPAY_SUCCESS query success");
        if (i10 != 0 || obj == null || !(obj instanceof MonthDetail)) {
            C1442a.m8291w("PaymentManagerFragment", "ContinuousMonthlyHandler GETMONTHPAY_SUCCESS but receive GetMonthPayResp null");
            m23711e0();
        } else {
            MonthDetail monthDetail = (MonthDetail) obj;
            this.f17303q0 = monthDetail;
            m23708b0(monthDetail);
        }
    }
}
