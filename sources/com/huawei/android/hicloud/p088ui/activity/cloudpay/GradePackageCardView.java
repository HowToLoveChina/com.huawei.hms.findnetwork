package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.VoucherColumnView;
import com.huawei.android.hicloud.p088ui.uiadapter.cloudpay.RightGridWithTextAdapter$RightGridWidthAdapterCallback;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.views.PackageCardView;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.GiftRight;
import com.huawei.cloud.pay.model.PackageGradeRight;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.cloud.pay.model.PurchaseNeedData;
import com.huawei.cloud.pay.model.ReportVoucherInfo;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Voucher;
import com.huawei.cloud.pay.p098ui.uiextend.view.AutoRenewRuleDialog;
import com.huawei.feedback.constant.FeedbackConst;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.uikit.phone.hwbutton.widget.HwButton;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import p010a9.C0079a;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0223k;
import p015ak.C0234s;
import p054cj.C1442a;
import p252e9.C9433j;
import p292fn.C9733f;
import p454lj.C11290m;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11828b;
import p514o9.C11839m;
import p514o9.C11841o;
import p514o9.C11842p;
import p709vj.C13452e;
import p815ym.AbstractC14026a;
import sk.C12809f;
import tk.C13021b;

/* loaded from: classes3.dex */
public class GradePackageCardView extends LinearLayout implements View.OnClickListener, VoucherColumnView.UpdatePackagePriceCallback, RightGridWithTextAdapter$RightGridWidthAdapterCallback, ConfirmRenewAgreementDialog.AgreementDlgCallback, RenewAgreementTextview.RenewAgreementTVCallback {

    /* renamed from: A */
    public boolean f17096A;

    /* renamed from: B */
    public TextView f17097B;

    /* renamed from: C */
    public RenewAgreementTextview f17098C;

    /* renamed from: D */
    public long f17099D;

    /* renamed from: E */
    public String f17100E;

    /* renamed from: F */
    public String f17101F;

    /* renamed from: G */
    public String f17102G;

    /* renamed from: H */
    public List<PackageGradeRight> f17103H;

    /* renamed from: I */
    public GetClientUIConfigResp f17104I;

    /* renamed from: J */
    public SendMessageCommunicator f17105J;

    /* renamed from: K */
    public boolean f17106K;

    /* renamed from: L */
    public boolean f17107L;

    /* renamed from: M */
    public FilterAvailabalGradePackage f17108M;

    /* renamed from: N */
    public int f17109N;

    /* renamed from: O */
    public CloudPackage f17110O;

    /* renamed from: P */
    public HwButton f17111P;

    /* renamed from: Q */
    public List<Voucher> f17112Q;

    /* renamed from: R */
    public boolean f17113R;

    /* renamed from: S */
    public boolean f17114S;

    /* renamed from: T */
    public UserPackage f17115T;

    /* renamed from: U */
    public BigDecimal f17116U;

    /* renamed from: V */
    public BigDecimal f17117V;

    /* renamed from: W */
    public int f17118W;

    /* renamed from: a */
    public AutoRenewRuleDialog f17119a;

    /* renamed from: a0 */
    public Runnable f17120a0;

    /* renamed from: b */
    public Context f17121b;

    /* renamed from: b0 */
    public C11828b f17122b0;

    /* renamed from: c */
    public Activity f17123c;

    /* renamed from: d */
    public PackageGrades f17124d;

    /* renamed from: e */
    public int f17125e;

    /* renamed from: f */
    public String f17126f;

    /* renamed from: g */
    public View f17127g;

    /* renamed from: h */
    public TextView f17128h;

    /* renamed from: i */
    public TextView f17129i;

    /* renamed from: j */
    public TextView f17130j;

    /* renamed from: k */
    public RelativeLayout f17131k;

    /* renamed from: l */
    public LinearLayout f17132l;

    /* renamed from: m */
    public PackageCardView f17133m;

    /* renamed from: n */
    public PackageCardView f17134n;

    /* renamed from: o */
    public LinearLayout f17135o;

    /* renamed from: p */
    public VoucherColumnView f17136p;

    /* renamed from: q */
    public LinearLayout f17137q;

    /* renamed from: r */
    public TextView f17138r;

    /* renamed from: s */
    public TextView f17139s;

    /* renamed from: t */
    public View f17140t;

    /* renamed from: u */
    public LinearLayout f17141u;

    /* renamed from: v */
    public TextView f17142v;

    /* renamed from: w */
    public View f17143w;

    /* renamed from: x */
    public ImageView f17144x;

    /* renamed from: y */
    public View f17145y;

    /* renamed from: z */
    public View f17146z;

    public interface SendMessageCommunicator {
        /* renamed from: C */
        void mo23172C();

        /* renamed from: P */
        void mo23180P(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo, ConfirmRenewAgreementDialog.AgreementDlgCallback agreementDlgCallback);

        /* renamed from: i0 */
        void mo23196i0(boolean z10);

        /* renamed from: q0 */
        void mo23205q0(CloudPackage cloudPackage, PackageGrades packageGrades, List<Voucher> list, ReportVoucherInfo reportVoucherInfo);

        /* renamed from: t */
        void mo23208t(String str, LinkedHashMap<String, String> linkedHashMap);

        /* renamed from: y */
        void mo23213y(CloudPackage cloudPackage, PackageGrades packageGrades, int i10);
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView$a */
    public class RunnableC3632a implements Runnable {
        public RunnableC3632a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GradePackageCardView.this.f17133m == null || GradePackageCardView.this.f17134n == null) {
                C1442a.m8291w("GradePackageCardView", "mPriceCardPreDrawListener packageCardLeft or packageCardRight is null.");
                return;
            }
            if (GradePackageCardView.this.f17133m.getPackageCardDetailContainer() == null || GradePackageCardView.this.f17134n.getPackageCardDetailContainer() == null) {
                C1442a.m8291w("GradePackageCardView", "mPriceCardPreDrawListener packageCardLeft or packageCardRight packageCardDetailContainer is null.");
                return;
            }
            if (GradePackageCardView.this.f17134n.getVisibility() != 0 || GradePackageCardView.this.f17133m.getVisibility() != 0) {
                C1442a.m8291w("GradePackageCardView", "packageCardRight.getVisibility() packageCardLeft.getVisibility() no show");
                return;
            }
            if (C0209d.m1195O(GradePackageCardView.this.f17121b) >= 3.2f) {
                C1442a.m8291w("GradePackageCardView", "mPriceCardPreDrawListener fontScale > 3.2.");
                return;
            }
            int height = GradePackageCardView.this.f17133m.getPackageCardDetailContainer().getHeight();
            int height2 = GradePackageCardView.this.f17134n.getPackageCardDetailContainer().getHeight();
            C1442a.m8290i("GradePackageCardView", "mPriceCardPreDrawListener packageCardOneHeight = " + height + " , packageCardTwoHeight = " + height2);
            if (height != height2) {
                GradePackageCardView gradePackageCardView = GradePackageCardView.this;
                if (gradePackageCardView.f17118W == 0) {
                    gradePackageCardView.f17118W = height > height2 ? 1 : 2;
                }
                if (gradePackageCardView.f17118W == 1) {
                    gradePackageCardView.f17134n.setDetailHeight(height);
                } else {
                    gradePackageCardView.f17133m.setDetailHeight(height2);
                }
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView$b */
    public class RunnableC3633b implements Runnable {
        public RunnableC3633b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GradePackageCardView.this.f17136p.m23834d();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.GradePackageCardView$c */
    public class C3634c extends ClickableSpan {
        public C3634c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            GradePackageCardView gradePackageCardView = GradePackageCardView.this;
            if (gradePackageCardView.f17119a == null) {
                gradePackageCardView.f17119a = new AutoRenewRuleDialog(GradePackageCardView.this.getContext());
            }
            GradePackageCardView.this.f17119a.show();
        }
    }

    public GradePackageCardView(Context context) {
        super(context);
        this.f17107L = false;
        this.f17109N = 0;
        this.f17110O = null;
        this.f17117V = BigDecimal.ZERO;
        this.f17118W = 0;
        this.f17120a0 = new RunnableC3632a();
        this.f17122b0 = C9433j.m59164c().m59165b();
        this.f17121b = context;
        m23528C();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: C */
    private void m23528C() {
        Context context = this.f17121b;
        if (context == 0) {
            C1442a.m8289e("GradePackageCardView", "initView err, mContext is null");
            return;
        }
        if (context instanceof SendMessageCommunicator) {
            this.f17105J = (SendMessageCommunicator) context;
        }
        float fM1195O = C0209d.m1195O(context);
        if (fM1195O >= 3.2f) {
            this.f17127g = LayoutInflater.from(this.f17121b).inflate(R$layout.member_card_fragment_3dot2, this);
        } else if (fM1195O < 1.75f || fM1195O >= 3.2f) {
            this.f17127g = LayoutInflater.from(this.f17121b).inflate(R$layout.member_card_fragment, this);
        } else {
            this.f17127g = LayoutInflater.from(this.f17121b).inflate(R$layout.member_card_fragment_2, this);
        }
        this.f17128h = (TextView) C12809f.m76831d(this.f17127g, R$id.member_grade_title);
        this.f17131k = (RelativeLayout) C12809f.m76831d(this.f17127g, R$id.member_grade_value_layout);
        this.f17129i = (TextView) C12809f.m76831d(this.f17127g, R$id.member_grade_value);
        this.f17130j = (TextView) C12809f.m76831d(this.f17127g, R$id.member_grade_introduction);
        View viewM76831d = C12809f.m76831d(this.f17127g, R$id.renew_tip_check_hot_region);
        this.f17145y = viewM76831d;
        viewM76831d.setOnClickListener(this);
        this.f17146z = C12809f.m76831d(this.f17127g, R$id.check_interval_view);
        this.f17144x = (ImageView) C12809f.m76831d(this.f17127g, R$id.renew_tip_check_view);
        TextView textView = (TextView) C12809f.m76831d(this.f17127g, R$id.payment_Text);
        this.f17097B = textView;
        textView.setOnClickListener(this);
        RenewAgreementTextview renewAgreementTextview = (RenewAgreementTextview) C12809f.m76831d(this.f17127g, R$id.new_design_renew_text);
        this.f17098C = renewAgreementTextview;
        renewAgreementTextview.setOnClickListener(this);
        this.f17132l = (LinearLayout) C12809f.m76831d(this.f17127g, R$id.cloud_package_layout);
        PackageCardView packageCardView = (PackageCardView) C12809f.m76831d(this.f17127g, R$id.package_card_left);
        this.f17133m = packageCardView;
        packageCardView.setOnCountDownEndListener(new PackageCardView.CountDownEndListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.c0
            @Override // com.huawei.android.hicloud.ui.views.PackageCardView.CountDownEndListener
            /* renamed from: a */
            public final void mo23904a() {
                this.f17537a.m23548I();
            }
        });
        this.f17133m.setOnClickListener(this);
        PackageCardView packageCardView2 = (PackageCardView) C12809f.m76831d(this.f17127g, R$id.package_card_right);
        this.f17134n = packageCardView2;
        packageCardView2.setOnCountDownEndListener(new PackageCardView.CountDownEndListener() { // from class: com.huawei.android.hicloud.ui.activity.cloudpay.d0
            @Override // com.huawei.android.hicloud.ui.views.PackageCardView.CountDownEndListener
            /* renamed from: a */
            public final void mo23904a() {
                this.f17539a.m23529J();
            }
        });
        this.f17134n.setOnClickListener(this);
        m23532b0();
        HwButton hwButton = (HwButton) C12809f.m76831d(this.f17127g, R$id.order_now_btn);
        this.f17111P = hwButton;
        hwButton.setOnClickListener(this);
        Context context2 = this.f17121b;
        if (context2 instanceof Activity) {
            C11842p.m70711A1((Activity) context2, this.f17111P);
        }
        this.f17135o = (LinearLayout) C12809f.m76831d(this.f17127g, R$id.total_discount_container);
        View view = this.f17127g;
        int i10 = R$id.card_voucher_column;
        VoucherColumnView voucherColumnView = (VoucherColumnView) C12809f.m76831d(view, i10);
        this.f17136p = voucherColumnView;
        voucherColumnView.setOnClickListener(this);
        this.f17136p.setUpdatePackagePriceCallback(this);
        this.f17136p = (VoucherColumnView) C12809f.m76831d(this.f17127g, i10);
        this.f17137q = (LinearLayout) C12809f.m76831d(this.f17127g, R$id.deduct_amount_container);
        this.f17139s = (TextView) C12809f.m76831d(this.f17127g, R$id.deduct_amount_value);
        this.f17140t = C12809f.m76831d(this.f17127g, R$id.deduct_divider);
        this.f17138r = (TextView) C12809f.m76831d(this.f17127g, R$id.deduct_amount_text);
        this.f17141u = (LinearLayout) C12809f.m76831d(this.f17127g, R$id.ll_gift_right_des);
        this.f17142v = (TextView) C12809f.m76831d(this.f17127g, R$id.htxt_gift_right_des);
        this.f17143w = C12809f.m76831d(this.f17127g, R$id.gift_divider);
    }

    /* renamed from: J */
    public /* synthetic */ void m23529J() {
        this.f17105J.mo23172C();
    }

    /* renamed from: b0 */
    private void m23532b0() {
        this.f17128h.setMaxWidth(((this.f17121b instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f17121b)) ? C11842p.m70841n0() : C11842p.m70837m0());
    }

    /* renamed from: d0 */
    private void m23535d0() {
        if (this.f17104I == null) {
            C1442a.m8289e("GradePackageCardView", "showData params is null.");
            return;
        }
        this.f17128h.setText(this.f17101F);
        this.f17129i.setText(C0223k.m1524g(getContext(), this.f17099D));
        this.f17130j.setText(this.f17102G);
        m23567e0();
    }

    private List<CloudPackage> getBasicPackageList() {
        FilterAvailabalGradePackage filterAvailabalGradePackage = this.f17108M;
        return filterAvailabalGradePackage != null ? filterAvailabalGradePackage.getBasicPackageList() : new ArrayList();
    }

    private List<CloudPackage> getIncrementList() {
        FilterAvailabalGradePackage filterAvailabalGradePackage = this.f17108M;
        return filterAvailabalGradePackage != null ? filterAvailabalGradePackage.getIncrementList() : new ArrayList();
    }

    private List<CloudPackage> getMonthList() {
        FilterAvailabalGradePackage filterAvailabalGradePackage = this.f17108M;
        return filterAvailabalGradePackage != null ? filterAvailabalGradePackage.getMonthlyPackageList() : new ArrayList();
    }

    private String getUpdateBtnText() {
        return C13452e.m80781L().m80887a1() ? this.f17115T.getIsAutoPay() == 1 ? this.f17121b.getString(R$string.change_plan) : this.f17121b.getString(R$string.cloudpay_subscribe_now) : this.f17121b.getString(R$string.upgrade_now);
    }

    /* renamed from: h */
    private BigDecimal m23538h(List<CloudPackage> list) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("GradePackageCardView", "grade name : " + this.f17101F + ", calculateMaxPriceGap, dataList is empty");
            return bigDecimal;
        }
        int size = list.size();
        if (size > 2) {
            size = 2;
        }
        for (int i10 = 0; i10 < size; i10++) {
            BigDecimal bigDecimalM23569g = m23569g(list.get(i10));
            if (bigDecimal.compareTo(bigDecimalM23569g) <= 0) {
                bigDecimal = bigDecimalM23569g;
            }
        }
        return bigDecimal;
    }

    private void setMemberGradeImageView(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("GradePackageCardView", "mMemberGradeTitleStr is null.");
            return;
        }
        String str2 = str + "  ";
        SpannableString spannableString = new SpannableString(str2 + "[packageLogo]");
        Drawable drawable = ContextCompat.getDrawable(this.f17121b, C11842p.m70765S0() ? R$drawable.ic_incremental_space_mirror : R$drawable.ic_incremental_space);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new C13021b(drawable, C11842p.m70840n(this.f17121b, 8), "  "), str2.length(), str2.length() + 13, 17);
        this.f17128h.setText(spannableString);
    }

    private void setPackageCardData(List<CloudPackage> list) {
        PackageCardView packageCardView = this.f17133m;
        if (packageCardView == null || this.f17134n == null) {
            C1442a.m8289e("GradePackageCardView", "setPackageCardData card view is null.");
            return;
        }
        packageCardView.m25791k();
        this.f17134n.m25791k();
        if (list == null || list.isEmpty()) {
            C1442a.m8289e("GradePackageCardView", "setPackageCardData member grade list is empty.");
            this.f17133m.setVisibility(8);
            this.f17134n.setVisibility(8);
            return;
        }
        if (list.size() < 2) {
            this.f17133m.m25796p(list.get(0), this.f17104I, this.f17100E, 1);
            this.f17134n.m25783c();
        } else {
            this.f17133m.setIsHasWorryFreeMonth(this.f17114S);
            this.f17133m.m25796p(list.get(0), this.f17104I, this.f17100E, 2);
            this.f17134n.m25796p(list.get(1), this.f17104I, this.f17100E, 2);
        }
        if (this.f17133m.m25787g()) {
            this.f17133m.setVisibility(0);
        } else {
            this.f17133m.setVisibility(8);
        }
        if (this.f17134n.m25787g()) {
            this.f17134n.setVisibility(0);
            this.f17134n.setOnClickListener(this);
        } else {
            this.f17134n.setVisibility(8);
        }
        m23558T();
    }

    private void setRenewChooseStatusByType(int i10) throws Resources.NotFoundException {
        if (m23547H()) {
            this.f17145y.setVisibility(0);
            m23587y();
            if (this.f17096A) {
                this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
            } else {
                this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
            }
            this.f17145y.setAccessibilityDelegate(C2783d.m16128b1(this.f17096A));
            if (i10 == 4) {
                setPackageCardData(getIncrementList());
            } else {
                setPackageCardData(getMonthList());
            }
            this.f17097B.setVisibility(8);
            this.f17098C.setVisibility(0);
            m23556R();
            return;
        }
        if (i10 == 1) {
            this.f17145y.setVisibility(0);
            m23587y();
            this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
            this.f17096A = true;
            this.f17145y.setAccessibilityDelegate(C2783d.m16128b1(true));
            setPackageCardData(getMonthList());
            m23556R();
            return;
        }
        if (i10 == 2) {
            this.f17145y.setVisibility(0);
            m23587y();
            this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
            this.f17096A = false;
            this.f17145y.setAccessibilityDelegate(C2783d.m16128b1(false));
            setPackageCardData(getBasicPackageList());
            m23556R();
            return;
        }
        if (i10 == 3) {
            this.f17145y.setVisibility(8);
            m23587y();
            this.f17097B.setVisibility(8);
            setPackageCardData(getBasicPackageList());
            return;
        }
        if (i10 != 4) {
            this.f17145y.setVisibility(8);
            m23566c0();
            setPackageCardData(getMonthList());
            m23556R();
            return;
        }
        this.f17145y.setVisibility(8);
        m23566c0();
        setPackageCardData(getIncrementList());
        m23556R();
    }

    /* renamed from: t */
    private String m23539t(List<CloudPackage> list) {
        if (list != null && list.size() > 0) {
            CloudPackage cloudPackage = list.get(0);
            return C11290m.m67749j(m23538h(list), cloudPackage.getCurrency(), cloudPackage.getSymbol());
        }
        C1442a.m8289e("GradePackageCardView", "grade name : " + this.f17101F + ", getMaxDiscountText, dataList is empty");
        return "";
    }

    /* renamed from: z */
    private void m23540z() {
        this.f17099D = this.f17124d.getCapacity();
        this.f17100E = this.f17124d.getGradeCode();
        this.f17101F = this.f17124d.getGradeName();
        this.f17103H = this.f17124d.getRights();
    }

    /* renamed from: A */
    public final void m23541A() {
        int iM70840n;
        Context context;
        int i10;
        if (this.f17145y == null) {
            return;
        }
        float fM1195O = C0209d.m1195O(this.f17121b);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f17145y.getLayoutParams();
        if (fM1195O < 1.75f || fM1195O >= 3.2f) {
            iM70840n = fM1195O < 1.75f ? (C11842p.m70771U0() && C11842p.m70753O0(this.f17121b)) ? m23547H() ? C11842p.m70840n(this.f17121b, 7) : C11842p.m70840n(this.f17121b, 2) : m23547H() ? C11842p.m70840n(this.f17121b, 4) : C11842p.m70840n(this.f17121b, 2) : C0223k.m1518a((double) fM1195O, 3.200000047683716d) ? m23547H() ? C11842p.m70840n(this.f17121b, 4) : C11842p.m70840n(this.f17121b, 2) : 0;
        } else {
            if (m23547H()) {
                context = this.f17121b;
                i10 = 12;
            } else {
                context = this.f17121b;
                i10 = 10;
            }
            iM70840n = C11842p.m70840n(context, i10);
        }
        layoutParams.topMargin = iM70840n;
        this.f17145y.setLayoutParams(layoutParams);
    }

    /* renamed from: B */
    public final void m23542B(String str, String str2) throws Resources.NotFoundException {
        FilterAvailabalGradePackage filterAvailabalGradePackage = this.f17108M;
        if (filterAvailabalGradePackage == null) {
            C1442a.m8289e("GradePackageCardView", "initShowCloudSpaceList filterAvailabalGradePackage is null.");
            return;
        }
        this.f17125e = filterAvailabalGradePackage.getRenewChooseType();
        this.f17126f = this.f17108M.getRenewChooseDesc();
        this.f17125e = m23564Z(this.f17125e);
        if (this.f17106K) {
            this.f17125e = 0;
        }
        if (C11296s.m67787K() && C11296s.m67789M(this.f17121b) && !TextUtils.isEmpty(str)) {
            m23561W(str, str2);
            return;
        }
        setRenewChooseStatusByType(this.f17125e);
        if (this.f17114S) {
            m23550L(2);
        } else {
            m23579p();
        }
    }

    /* renamed from: D */
    public boolean m23543D() {
        return this.f17107L;
    }

    /* renamed from: E */
    public boolean m23544E() {
        PackageGrades packageGrades = this.f17124d;
        return packageGrades != null && packageGrades.getRecommended() == 1;
    }

    /* renamed from: F */
    public boolean m23545F(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(this.f17100E);
    }

    /* renamed from: G */
    public boolean m23546G(String str, long j10) {
        return !TextUtils.isEmpty(str) && str.equals(this.f17100E) && j10 == this.f17099D;
    }

    /* renamed from: H */
    public final boolean m23547H() {
        if (!C13452e.m80781L().m80803F0().booleanValue() || C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
            return false;
        }
        GetClientUIConfigResp getClientUIConfigResp = this.f17104I;
        if (getClientUIConfigResp == null) {
            C1442a.m8289e("GradePackageCardView", "isOnlyMonthPay, params is null.");
            return false;
        }
        if (TextUtils.isEmpty(getClientUIConfigResp.getCheckDialogRenewAgreement()) || TextUtils.isEmpty(this.f17104I.getPackageCardAgreement())) {
            C1442a.m8289e("GradePackageCardView", "isOnlyMonthPay, getCheckDialogRenewAgreement or getPackageCardAgreement is null or empty.");
            return false;
        }
        FilterAvailabalGradePackage filterAvailabalGradePackage = this.f17108M;
        if (filterAvailabalGradePackage == null) {
            C1442a.m8289e("GradePackageCardView", "isOnlyMonthPay, filterAvailabalGradePackage is null.");
            return false;
        }
        List<CloudPackage> basicPackageList = filterAvailabalGradePackage.getBasicPackageList();
        List<CloudPackage> monthlyPackageList = this.f17108M.getMonthlyPackageList();
        List<CloudPackage> incrementList = this.f17108M.getIncrementList();
        if (incrementList == null || incrementList.isEmpty()) {
            return ((basicPackageList != null && !basicPackageList.isEmpty()) || monthlyPackageList == null || monthlyPackageList.isEmpty()) ? false : true;
        }
        return true;
    }

    /* renamed from: I */
    public final /* synthetic */ void m23548I() {
        this.f17105J.mo23172C();
    }

    /* renamed from: K */
    public final boolean m23549K(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("GradePackageCardView", "grade name : " + this.f17101F + ", renewChooseDesc is null, no need show");
            return false;
        }
        if (str.contains("DDD%")) {
            return true;
        }
        C1442a.m8289e("GradePackageCardView", "grade name : " + this.f17101F + ", renewChooseDesc not contain MAX_PRICE_GAP_PLACEHOLDER, no need show");
        return false;
    }

    /* renamed from: L */
    public final void m23550L(int i10) {
        m23551M(i10, null);
    }

    /* renamed from: M */
    public final void m23551M(int i10, String str) {
        this.f17109N = i10;
        if (i10 == 1) {
            PackageCardView packageCardView = this.f17133m;
            if (packageCardView != null && packageCardView.getVisibility() == 0) {
                this.f17110O = this.f17133m.getPackage();
                this.f17133m.setCardSelected(true);
            }
            PackageCardView packageCardView2 = this.f17134n;
            if (packageCardView2 != null && packageCardView2.getVisibility() == 0) {
                this.f17134n.setCardSelected(false);
            }
        } else if (i10 == 2) {
            PackageCardView packageCardView3 = this.f17134n;
            if (packageCardView3 != null && packageCardView3.getVisibility() == 0) {
                this.f17110O = this.f17134n.getPackage();
                this.f17134n.setCardSelected(true);
            }
            PackageCardView packageCardView4 = this.f17133m;
            if (packageCardView4 != null && packageCardView4.getVisibility() == 0) {
                this.f17133m.setCardSelected(false);
            }
        }
        m23570g0(str);
    }

    /* renamed from: N */
    public void m23552N(FilterAvailabalGradePackage filterAvailabalGradePackage, GetClientUIConfigResp getClientUIConfigResp, boolean z10, boolean z11, List<Voucher> list, String str, String str2, BigDecimal bigDecimal, Activity activity) {
        m23553O(filterAvailabalGradePackage, getClientUIConfigResp, z10, z11, list, str, str2, false, bigDecimal, activity);
    }

    /* renamed from: O */
    public void m23553O(FilterAvailabalGradePackage filterAvailabalGradePackage, GetClientUIConfigResp getClientUIConfigResp, boolean z10, boolean z11, List<Voucher> list, String str, String str2, boolean z12, BigDecimal bigDecimal, Activity activity) {
        this.f17123c = activity;
        try {
            this.f17116U = bigDecimal;
            this.f17108M = filterAvailabalGradePackage;
            if (filterAvailabalGradePackage != null) {
                this.f17124d = filterAvailabalGradePackage.getPackageGrades();
                this.f17102G = filterAvailabalGradePackage.getMemAD();
            }
            this.f17104I = getClientUIConfigResp;
            this.f17106K = z10;
            this.f17107L = z11;
            this.f17112Q = list;
            this.f17113R = z12;
            m23541A();
            m23540z();
            m23542B(str, str2);
            m23535d0();
            if (this.f17136p != null) {
                if (!C11296s.m67787K() || !C11296s.m67789M(this.f17121b) || list == null || list.isEmpty()) {
                    this.f17136p.setVisibility(8);
                    m23554P();
                } else {
                    this.f17135o.setVisibility(0);
                    this.f17136p.setVisibility(0);
                }
            }
            m23555Q();
            if (getClientUIConfigResp != null) {
                this.f17138r.setText(getClientUIConfigResp.getTariffDeductionTitle());
            }
        } catch (Exception e10) {
            C1442a.m8289e("GradePackageCardView", "refreshData err : " + e10.getMessage());
        }
    }

    /* renamed from: P */
    public final void m23554P() {
        this.f17117V = C11296s.m67832p(this.f17110O, new ArrayList(), this.f17116U);
        CloudPackage cloudPackage = this.f17110O;
        if (cloudPackage != null && C11296s.m67785I(this.f17116U, cloudPackage.getProductType()) && this.f17117V.compareTo(BigDecimal.ZERO) != 0) {
            m23557S();
        } else {
            this.f17137q.setVisibility(8);
            this.f17140t.setVisibility(8);
        }
    }

    /* renamed from: Q */
    public final void m23555Q() {
        if (this.f17141u != null) {
            if (!m23586x()) {
                C11839m.m70689w("GradePackageCardView", "giftRight is null");
                this.f17141u.setVisibility(8);
                this.f17143w.setVisibility(8);
                return;
            }
            this.f17135o.setVisibility(0);
            this.f17141u.setVisibility(0);
            GiftRight giftRight = this.f17110O.getGiftRight();
            C11839m.m70688i("GradePackageCardView", giftRight.toString());
            if (this.f17142v != null) {
                Resources resources = this.f17121b.getResources();
                int duration = giftRight.getDuration();
                if (resources != null) {
                    this.f17142v.setText(resources.getQuantityString(R$plurals.cloud_space_renewal_tip, duration, Integer.valueOf(duration)));
                }
            }
            int visibility = this.f17137q.getVisibility();
            int visibility2 = this.f17136p.getVisibility();
            if (this.f17137q.getVisibility() != 0 && (visibility == 0 || visibility2 != 0)) {
                this.f17143w.setVisibility(8);
            } else {
                this.f17143w.setVisibility(0);
                this.f17136p.m23832b();
            }
        }
    }

    /* renamed from: R */
    public final void m23556R() throws Resources.NotFoundException {
        String string;
        String strReplace;
        String string2;
        if (this.f17121b == null) {
            C1442a.m8289e("GradePackageCardView", "refreshMaxDiscountData mContext is null.");
            return;
        }
        boolean z10 = false;
        if (m23547H()) {
            string = this.f17121b.getString(R$string.cloudpay_monthly_renew_agreement);
            String packageCardAgreement = this.f17104I.getPackageCardAgreement();
            string2 = this.f17121b.getString(R$string.cloudpay_user_agreement);
            strReplace = String.format(packageCardAgreement, string2, string);
        } else {
            if (TextUtils.isEmpty(this.f17126f)) {
                C1442a.m8289e("GradePackageCardView", "renewChooseDesc is null, no need to show");
                ImageView imageView = this.f17144x;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            string = this.f17121b.getString(R$string.cloudpay_continuous_monthly_agreement_new);
            if (this.f17126f.contains("SSS%")) {
                String strReplaceAll = this.f17126f.replaceAll("SSS%", string);
                String strM1636n = C0234s.m1636n();
                if (TextUtils.isEmpty(strM1636n) || !strM1636n.equals(Constants.AR_CACHE)) {
                    strReplace = strReplaceAll + "  ";
                } else {
                    strReplace = strReplaceAll + "   ";
                }
                z10 = true;
            } else {
                strReplace = this.f17126f;
            }
            if (m23549K(strReplace)) {
                String strM23539t = m23539t(getMonthList());
                if (!TextUtils.isEmpty(strM23539t)) {
                    strReplace = strReplace.replace("DDD%", strM23539t);
                }
            }
            string2 = "";
        }
        m23565a0(string2, string, strReplace, z10);
    }

    /* renamed from: S */
    public final void m23557S() {
        this.f17137q.setVisibility(0);
        this.f17140t.setVisibility(8);
        this.f17139s.setText(this.f17121b.getString(R$string.cloudpay_cloumn_discount, C11290m.m67749j(this.f17117V, this.f17110O.getCurrency(), this.f17110O.getSymbol())));
        GetClientUIConfigResp getClientUIConfigResp = this.f17104I;
        if (getClientUIConfigResp != null) {
            this.f17138r.setText(getClientUIConfigResp.getTariffDeductionTitle());
        }
    }

    /* renamed from: T */
    public void m23558T() {
        LinearLayout linearLayout = this.f17132l;
        if (linearLayout == null) {
            return;
        }
        linearLayout.post(this.f17120a0);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: U */
    public void mo23559U(BigDecimal bigDecimal, String str, List<Voucher> list) {
        CloudPackage cloudPackage;
        CloudPackage cloudPackage2;
        CloudPackage cloudPackage3 = this.f17110O;
        if (cloudPackage3 == null) {
            C1442a.m8289e("GradePackageCardView", "updatePrice currentSelectedPackage is null.");
            return;
        }
        String id2 = cloudPackage3.getId();
        if (id2 == null) {
            C1442a.m8289e("GradePackageCardView", "updatePrice currentPackageId is null.");
            return;
        }
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        this.f17117V = bigDecimal2;
        if (!C11296s.m67785I(this.f17116U, this.f17110O.getProductType())) {
            this.f17137q.setVisibility(8);
            this.f17140t.setVisibility(8);
        } else if (list != null && !list.isEmpty()) {
            Voucher voucher = list.get(0);
            String feeMode = voucher.getFeeMode();
            BigDecimal bigDecimalM67838v = C11296s.m67838v(this.f17110O);
            if ("0".equals(feeMode)) {
                BigDecimal bigDecimalSubtract = bigDecimalM67838v.subtract(bigDecimal);
                if (bigDecimalSubtract.compareTo(bigDecimal2) == 1) {
                    if (this.f17116U.compareTo(bigDecimalSubtract) > -1) {
                        this.f17117V = bigDecimalM67838v.subtract(bigDecimal);
                    } else {
                        this.f17117V = this.f17116U;
                    }
                    this.f17137q.setVisibility(0);
                    this.f17135o.setVisibility(0);
                    this.f17138r.setText(this.f17104I.getTariffDeductionTitle());
                    this.f17139s.setText(this.f17121b.getString(R$string.cloudpay_cloumn_discount, C11290m.m67749j(this.f17117V, this.f17110O.getCurrency(), this.f17110O.getSymbol())));
                    this.f17140t.setVisibility(0);
                } else {
                    this.f17117V = bigDecimal2;
                }
            } else if ("1".equals(feeMode)) {
                BigDecimal bigDecimalSubtract2 = bigDecimalM67838v.subtract(voucher.getMinFee());
                if (this.f17116U.compareTo(bigDecimalSubtract2) < 1) {
                    this.f17117V = this.f17116U;
                } else {
                    this.f17117V = bigDecimalSubtract2;
                }
                this.f17139s.setText(this.f17121b.getString(R$string.cloudpay_cloumn_discount, C11290m.m67749j(this.f17117V, this.f17110O.getCurrency(), this.f17110O.getSymbol())));
                this.f17138r.setText(this.f17104I.getTariffDeductionTitle());
                this.f17135o.setVisibility(0);
                this.f17137q.setVisibility(0);
                this.f17140t.setVisibility(0);
            } else if ("2".equals(feeMode)) {
                if (this.f17116U.compareTo(bigDecimalM67838v) == -1) {
                    this.f17117V = this.f17116U;
                } else {
                    this.f17117V = bigDecimalM67838v;
                    bigDecimal = bigDecimal2;
                }
                this.f17135o.setVisibility(0);
                this.f17137q.setVisibility(0);
                this.f17139s.setText(this.f17121b.getString(R$string.cloudpay_cloumn_discount, C11290m.m67749j(this.f17117V, this.f17110O.getCurrency(), this.f17110O.getSymbol())));
                this.f17140t.setVisibility(0);
                this.f17138r.setText(this.f17104I.getTariffDeductionTitle());
            } else {
                C1442a.m8289e("GradePackageCardView", "updatePrice invalid voucher type = " + feeMode);
                this.f17117V = bigDecimal2;
                bigDecimal = bigDecimal2;
            }
        }
        if (this.f17117V.compareTo(bigDecimal2) == 0) {
            this.f17137q.setVisibility(8);
            this.f17140t.setVisibility(8);
        }
        PackageCardView packageCardView = this.f17134n;
        if (packageCardView != null && (cloudPackage2 = packageCardView.getPackage()) != null && id2.equals(cloudPackage2.getId())) {
            m23562X(cloudPackage2, bigDecimal.add(this.f17117V));
        }
        PackageCardView packageCardView2 = this.f17133m;
        if (packageCardView2 != null && (cloudPackage = packageCardView2.getPackage()) != null && id2.equals(cloudPackage.getId())) {
            m23562X(cloudPackage, bigDecimal.add(this.f17117V));
        }
        m23555Q();
    }

    /* renamed from: V */
    public final void m23560V(CloudPackage cloudPackage) {
        if (cloudPackage == null) {
            return;
        }
        List<CloudPackage> basicPackageList = getBasicPackageList();
        List<CloudPackage> monthList = getMonthList();
        if (basicPackageList.size() <= 0 || monthList.size() <= 0) {
            return;
        }
        int productType = cloudPackage.getProductType();
        if (productType == 6 || productType == 8) {
            this.f17125e = 1;
        } else {
            this.f17125e = 2;
        }
    }

    /* renamed from: W */
    public final void m23561W(String str, String str2) throws Resources.NotFoundException {
        if (m23581r(getMonthList(), str, str2) || m23581r(getBasicPackageList(), str, str2)) {
            return;
        }
        setRenewChooseStatusByType(this.f17125e);
        m23550L(1);
    }

    /* renamed from: X */
    public final void m23562X(CloudPackage cloudPackage, BigDecimal bigDecimal) {
        if (this.f17111P == null) {
            C1442a.m8289e("GradePackageCardView", "setBuyBtnText mBuyBtn is null.");
            return;
        }
        if (this.f17121b == null) {
            C1442a.m8289e("GradePackageCardView", "setBuyBtnText mContext is null.");
            return;
        }
        if (bigDecimal != null) {
            BigDecimal bigDecimal2 = BigDecimal.ZERO;
            if (bigDecimal.compareTo(bigDecimal2) != 0) {
                if (cloudPackage == null) {
                    C1442a.m8289e("GradePackageCardView", "setBuyBtnText cloudPackage is null.");
                    return;
                }
                int productType = cloudPackage.getProductType();
                BigDecimal bigDecimalSubtract = ((productType == 7 || productType == 8 || productType == 12) ? cloudPackage.getSpPrice() : (cloudPackage.getSpPrice() == null || cloudPackage.getSpPrice().compareTo(cloudPackage.getPrice()) >= 0) ? cloudPackage.getPrice() : cloudPackage.getSpPrice()).subtract(bigDecimal);
                if (bigDecimalSubtract.compareTo(bigDecimal2) >= 0) {
                    bigDecimal2 = bigDecimalSubtract;
                }
                String strM1631i = C0234s.m1631i();
                this.f17111P.setText((FeedbackConst.SDK.EMUI_LANGUAGE.equals(strM1631i) || (HNConstants.Language.CN_STANDARD.equals(strM1631i) && "CNY".equals(cloudPackage.getCurrency()))) ? this.f17121b.getString(R$string.cloudpay_buy_btn_cn, bigDecimal2.toString()) : this.f17121b.getString(R$string.cloudpay_buy_btn_text, C11290m.m67749j(bigDecimal2, cloudPackage.getCurrency(), cloudPackage.getCurrencySymbol())));
                return;
            }
        }
        HashMap<String, String> extendTagMap = cloudPackage.getExtendTagMap();
        if (extendTagMap == null) {
            this.f17111P.setText(getUpdateBtnText());
            return;
        }
        String str = extendTagMap.get("buttonTag");
        if (TextUtils.isEmpty(str)) {
            this.f17111P.setText(getUpdateBtnText());
        } else {
            this.f17111P.setText(str);
        }
    }

    /* renamed from: Y */
    public final void m23563Y() {
        this.f17128h.setMaxWidth(((this.f17121b instanceof Activity) && C11842p.m70771U0() && C11842p.m70774V0((Activity) this.f17121b)) ? C11842p.m70776W() : C11842p.m70743L());
    }

    /* renamed from: Z */
    public final int m23564Z(int i10) {
        int size = getIncrementList().size();
        int size2 = getBasicPackageList().size();
        int size3 = getMonthList().size();
        if (size >= 1) {
            return 4;
        }
        if (size2 <= 0 && size3 > 0) {
            return 0;
        }
        if (size3 > 0 || size2 <= 0) {
            return i10;
        }
        return 3;
    }

    /* renamed from: a0 */
    public final void m23565a0(String str, String str2, String str3, boolean z10) throws Resources.NotFoundException {
        if (m23547H()) {
            this.f17098C.setTextColor(getResources().getColor(R$color.view_details_text_color));
            this.f17098C.setVisibility(0);
            Activity activity = this.f17123c;
            if (activity == null) {
                C1442a.m8289e("GradePackageCardView", "setSpannableString, mActivity is null.");
                return;
            } else {
                this.f17098C.m25806w(str3, str, str2, activity, this);
                return;
            }
        }
        SpannableString spannableString = new SpannableString(str3);
        if (z10) {
            int iIndexOf = str3.indexOf(str2);
            if (iIndexOf > -1) {
                this.f17098C.setmActivity(this.f17123c);
                spannableString.setSpan(new RenewAgreementTextview.C4290c(getContext(), new RenewAgreementTextview.HandlerC4291d(this.f17098C), 2), iIndexOf, str2.length() + iIndexOf, 33);
            }
            Drawable drawable = getResources().getDrawable(R$drawable.auto_renew_rule_pic);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            ImageSpan imageSpan = new ImageSpan(drawable);
            C3634c c3634c = new C3634c();
            spannableString.setSpan(imageSpan, spannableString.length() - 2, spannableString.length() - 1, 33);
            spannableString.setSpan(c3634c, spannableString.length() - 2, spannableString.length() - 1, 33);
        }
        this.f17097B.setVisibility(0);
        this.f17097B.setText(spannableString);
        this.f17097B.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: c0 */
    public final void m23566c0() {
        View view = this.f17146z;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* renamed from: e0 */
    public final void m23567e0() {
        FilterAvailabalGradePackage filterAvailabalGradePackage = this.f17108M;
        if (filterAvailabalGradePackage == null || AbstractC14026a.m84159a(filterAvailabalGradePackage.getIncrementList())) {
            return;
        }
        String productName = this.f17108M.getIncrementList().get(0).getProductName();
        m23563Y();
        this.f17128h.setText(productName);
        setMemberGradeImageView(productName);
        this.f17129i.setVisibility(8);
        this.f17131k.setVisibility(8);
        this.f17130j.setText(m23585w(this.f17108M.getIncrementList().get(0)));
    }

    /* renamed from: f0 */
    public void m23568f0(boolean z10) {
        BigDecimal bigDecimal;
        CloudPackage cloudPackage;
        CloudPackage cloudPackage2;
        CloudPackage cloudPackage3 = this.f17110O;
        if (cloudPackage3 == null) {
            C1442a.m8289e("GradePackageCardView", "updateHavaNoVoucher updateSelectNoVoucher is null.");
            return;
        }
        String id2 = cloudPackage3.getId();
        if (id2 == null) {
            C1442a.m8289e("GradePackageCardView", "updateHavaNoVoucher currentPackageId is null.");
            return;
        }
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        this.f17117V = bigDecimal2;
        if (C11296s.m67785I(this.f17116U, this.f17110O.getProductType())) {
            BigDecimal bigDecimalM67838v = C11296s.m67838v(this.f17110O);
            if (this.f17116U.compareTo(bigDecimalM67838v) == 1) {
                this.f17117V = bigDecimalM67838v;
            } else {
                this.f17117V = this.f17116U;
            }
            this.f17139s.setText(this.f17121b.getString(R$string.cloudpay_cloumn_discount, C11290m.m67749j(this.f17117V, this.f17110O.getCurrency(), this.f17110O.getSymbol())));
            this.f17138r.setText(this.f17104I.getTariffDeductionTitle());
            bigDecimal = this.f17117V;
            if (z10) {
                this.f17140t.setVisibility(0);
            }
            this.f17135o.setVisibility(0);
            this.f17137q.setVisibility(0);
        } else {
            bigDecimal = null;
        }
        PackageCardView packageCardView = this.f17133m;
        if (packageCardView != null && (cloudPackage2 = packageCardView.getPackage()) != null && id2.equals(cloudPackage2.getId())) {
            m23562X(cloudPackage2, bigDecimal);
        }
        PackageCardView packageCardView2 = this.f17134n;
        if (packageCardView2 != null && (cloudPackage = packageCardView2.getPackage()) != null && id2.equals(cloudPackage.getId())) {
            m23562X(cloudPackage, bigDecimal);
        }
        if (bigDecimal2.compareTo(this.f17117V) == 0) {
            this.f17140t.setVisibility(8);
            this.f17137q.setVisibility(8);
        }
    }

    /* renamed from: g */
    public final BigDecimal m23569g(CloudPackage cloudPackage) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        int productType = cloudPackage.getProductType();
        if (productType != 7 && productType != 8) {
            return bigDecimal;
        }
        BigDecimal price = cloudPackage.getPrice();
        BigDecimal spPrice = cloudPackage.getSpPrice();
        return price.compareTo(spPrice) >= 0 ? price.subtract(spPrice) : bigDecimal;
    }

    /* renamed from: g0 */
    public final void m23570g0(String str) {
        List<Voucher> list;
        if (this.f17136p == null || (list = this.f17112Q) == null || list.isEmpty() || !C11296s.m67787K() || !C11296s.m67789M(this.f17121b)) {
            m23568f0(false);
        } else if (TextUtils.isEmpty(str)) {
            this.f17136p.m23842l(m23583u(this.f17112Q), this.f17110O, true, this.f17116U);
        } else {
            this.f17136p.m23841k(m23583u(this.f17112Q), this.f17110O, true, str, this.f17116U);
        }
        m23555Q();
    }

    public BigDecimal getFinalDeductAmount() {
        return this.f17117V;
    }

    public List<PackageGradeRight> getGradeRightList() {
        return this.f17103H;
    }

    public boolean getIsHasWorryFreeMonth() {
        return this.f17114S;
    }

    public PurchaseNeedData getPurchaseData() {
        return getPurchaseNeedData();
    }

    public PurchaseNeedData getPurchaseNeedData() {
        PurchaseNeedData purchaseNeedData = new PurchaseNeedData();
        purchaseNeedData.setSelectPackage(this.f17110O);
        purchaseNeedData.setPackageGrades(this.f17124d);
        VoucherColumnView voucherColumnView = this.f17136p;
        if (voucherColumnView != null) {
            purchaseNeedData.setSelectVouchers(voucherColumnView.getSelectVouchers());
            purchaseNeedData.setReportVoucherInfo(this.f17136p.getReportVoucherInfo());
        }
        return purchaseNeedData;
    }

    public String getmGradeCode() {
        return this.f17100E;
    }

    public String getmGradeName() {
        return this.f17101F;
    }

    /* renamed from: i */
    public final void m23571i() {
        ReportVoucherInfo reportVoucherInfo;
        if (this.f17105J == null) {
            C1442a.m8289e("GradePackageCardView", "clickBuyBtn sendMessage is null.");
            return;
        }
        if (this.f17110O == null) {
            C1442a.m8289e("GradePackageCardView", "clickBuyBtn currentSelectedPackage is null.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        VoucherColumnView voucherColumnView = this.f17136p;
        if (voucherColumnView != null) {
            arrayList.addAll(voucherColumnView.getSelectVouchers());
            reportVoucherInfo = this.f17136p.getReportVoucherInfo();
        } else {
            reportVoucherInfo = null;
        }
        ReportVoucherInfo reportVoucherInfo2 = reportVoucherInfo;
        if (!m23547H() || this.f17096A) {
            this.f17105J.mo23205q0(this.f17110O, this.f17124d, arrayList, reportVoucherInfo2);
        } else {
            this.f17105J.mo23180P(this.f17110O, this.f17124d, arrayList, reportVoucherInfo2, this);
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("select_package_id", this.f17110O.getId());
        this.f17105J.mo23208t("UNIFORM_CLOUDPAY_CLICK_PACKAGE_CARD_PAY_BUTTON", linkedHashMap);
    }

    /* renamed from: j */
    public final void m23572j() {
        if (this.f17114S) {
            if (C0209d.m1226Y0()) {
                return;
            }
            C11841o.m70708d(getContext(), getContext().getString(R$string.cloudpay_worry_free_Ordered), 0);
        } else {
            m23550L(1);
            if (this.f17105J == null || this.f17133m == null) {
                return;
            }
            VoucherColumnView voucherColumnView = this.f17136p;
            this.f17105J.mo23213y(this.f17133m.getPackage(), this.f17124d, voucherColumnView != null ? voucherColumnView.getColumnState() : -1);
        }
    }

    @Override // com.huawei.android.hicloud.ui.views.RenewAgreementTextview.RenewAgreementTVCallback
    /* renamed from: j0 */
    public void mo18858j0(boolean z10) {
        SendMessageCommunicator sendMessageCommunicator = this.f17105J;
        if (sendMessageCommunicator == null) {
            C1442a.m8289e("GradePackageCardView", "dealOpenedAgreementH5, sendMessage is null.");
        } else {
            sendMessageCommunicator.mo23196i0(z10);
        }
    }

    /* renamed from: k */
    public final void m23573k() {
        m23550L(2);
        if (this.f17105J == null || this.f17134n == null) {
            return;
        }
        VoucherColumnView voucherColumnView = this.f17136p;
        this.f17105J.mo23213y(this.f17134n.getPackage(), this.f17124d, voucherColumnView != null ? voucherColumnView.getColumnState() : -1);
    }

    /* renamed from: l */
    public final void m23574l() {
        VoucherColumnView voucherColumnView = this.f17136p;
        if (voucherColumnView == null) {
            C1442a.m8289e("GradePackageCardView", "click card_voucher_column,but mVoucherColumnView is null.");
        } else if (this.f17110O != null) {
            voucherColumnView.m23850t(m23583u(this.f17112Q), this.f17110O, this.f17116U);
        } else {
            C1442a.m8289e("GradePackageCardView", "click card_voucher_column,but currentSelectedPackage is null.");
        }
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: m */
    public void mo23575m() {
        m23568f0(true);
    }

    /* renamed from: n */
    public void m23576n() {
        m23532b0();
        m23567e0();
        VoucherColumnView voucherColumnView = this.f17136p;
        if (voucherColumnView != null) {
            voucherColumnView.m23833c();
        }
        Context context = this.f17121b;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        C11842p.m70711A1((Activity) context, this.f17111P);
    }

    @Override // com.huawei.android.hicloud.ui.activity.cloudpay.VoucherColumnView.UpdatePackagePriceCallback
    /* renamed from: n0 */
    public void mo23577n0(String str) {
        CloudPackage cloudPackage;
        CloudPackage cloudPackage2;
        CloudPackage cloudPackage3 = this.f17110O;
        if (cloudPackage3 == null) {
            C1442a.m8289e("GradePackageCardView", "updateSelectNoVoucher updateSelectNoVoucher is null.");
            return;
        }
        String id2 = cloudPackage3.getId();
        if (id2 == null) {
            C1442a.m8289e("GradePackageCardView", "updateSelectNoVoucher currentPackageId is null.");
            return;
        }
        BigDecimal bigDecimal = BigDecimal.ZERO;
        this.f17117V = bigDecimal;
        if (C11296s.m67785I(this.f17116U, this.f17110O.getProductType())) {
            BigDecimal bigDecimalM67838v = C11296s.m67838v(this.f17110O);
            if (this.f17116U.compareTo(bigDecimalM67838v) == 1) {
                this.f17117V = bigDecimalM67838v;
            } else {
                this.f17117V = this.f17116U;
            }
            this.f17140t.setVisibility(0);
            this.f17137q.setVisibility(0);
            this.f17139s.setText(this.f17121b.getString(R$string.cloudpay_cloumn_discount, C11290m.m67749j(this.f17117V, this.f17110O.getCurrency(), this.f17110O.getSymbol())));
            this.f17138r.setText(this.f17104I.getTariffDeductionTitle());
        }
        PackageCardView packageCardView = this.f17133m;
        if (packageCardView != null && (cloudPackage2 = packageCardView.getPackage()) != null && id2.equals(cloudPackage2.getId())) {
            m23562X(cloudPackage2, this.f17117V);
        }
        if (bigDecimal.compareTo(this.f17117V) == 0) {
            this.f17140t.setVisibility(8);
            this.f17137q.setVisibility(8);
        }
        PackageCardView packageCardView2 = this.f17134n;
        if (packageCardView2 == null || (cloudPackage = packageCardView2.getPackage()) == null || !id2.equals(cloudPackage.getId())) {
            return;
        }
        m23562X(cloudPackage, this.f17117V);
    }

    /* renamed from: o */
    public final void m23578o() {
        if (m23547H()) {
            if (this.f17096A) {
                this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
                this.f17096A = false;
            } else {
                this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
                this.f17096A = true;
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put("renew_checkbox_status", String.valueOf(this.f17096A));
            this.f17105J.mo23208t("UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", linkedHashMap);
            return;
        }
        if (this.f17096A) {
            setPackageCardData(getBasicPackageList());
            this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
            this.f17096A = false;
        } else {
            setPackageCardData(getMonthList());
            this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
            this.f17096A = true;
        }
        this.f17145y.setAccessibilityDelegate(C2783d.m16128b1(this.f17096A));
        m23579p();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.payment_Text) {
            C1442a.m8290i("GradePackageCardView", "show continuous monthly service agreement");
            Context contextM1377a = C0213f.m1377a();
            if (contextM1377a instanceof CloudSpaceUpgradeActivity) {
                ((CloudSpaceUpgradeActivity) contextM1377a).m23414h9();
                return;
            }
            return;
        }
        if (id2 == R$id.renew_tip_check_hot_region) {
            m23578o();
            return;
        }
        if (id2 == R$id.package_card_left) {
            m23572j();
            return;
        }
        if (id2 == R$id.package_card_right) {
            m23573k();
            return;
        }
        if (id2 != R$id.order_now_btn) {
            if (id2 == R$id.card_voucher_column) {
                m23574l();
            }
        } else if (C0209d.m1226Y0()) {
            C1442a.m8291w("GradePackageCardView", "order_now_btn click too fast");
        } else {
            m23571i();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m23558T();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* renamed from: p */
    public final void m23579p() {
        PackageCardView packageCardView = this.f17133m;
        boolean z10 = false;
        boolean z11 = (packageCardView == null || packageCardView.getPackage() == null) ? false : true;
        PackageCardView packageCardView2 = this.f17134n;
        if (packageCardView2 != null && packageCardView2.getPackage() != null) {
            z10 = true;
        }
        if (z11 && z10) {
            if (this.f17133m.getPackage().getMatchPriority() >= this.f17134n.getPackage().getMatchPriority()) {
                m23550L(1);
                return;
            } else {
                m23550L(2);
                return;
            }
        }
        if (!z11 || z10) {
            C1442a.m8291w("GradePackageCardView", "packageCardLeft and packageCardRight is null.");
        } else {
            m23550L(1);
        }
    }

    /* renamed from: q */
    public void m23580q() {
        postDelayed(new RunnableC3633b(), 500L);
    }

    /* renamed from: r */
    public final boolean m23581r(List<CloudPackage> list, String str, String str2) throws Resources.NotFoundException {
        if (list != null && !list.isEmpty()) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                CloudPackage cloudPackage = list.get(i10);
                if (str.equals(cloudPackage.getId())) {
                    if (i10 == 0) {
                        m23560V(cloudPackage);
                        setRenewChooseStatusByType(this.f17125e);
                        m23551M(1, str2);
                        return true;
                    }
                    if (i10 == 1) {
                        m23560V(cloudPackage);
                        setRenewChooseStatusByType(this.f17125e);
                        m23551M(2, str2);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void refreshCheckboxStatus(boolean z10) {
        this.f17145y.setVisibility(0);
        m23587y();
        if (z10) {
            this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
        } else {
            this.f17144x.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
        }
        this.f17096A = z10;
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        SendMessageCommunicator sendMessageCommunicator = this.f17105J;
        if (sendMessageCommunicator == null) {
            C1442a.m8289e("GradePackageCardView", "reportRenewDlgEvent, sendMessage is null.");
        } else {
            sendMessageCommunicator.mo23208t(str, linkedHashMap);
        }
    }

    /* renamed from: s */
    public final String m23582s(long j10) {
        return C0209d.m1278l2("et") ? C11290m.m67742c(getContext(), j10, "dd.MM.yyyy") : C0209d.m1278l2(Constants.URDU_LANG) ? C11290m.m67742c(getContext(), j10, "dd/MM/yyyy") : C11290m.m67743d(getContext(), j10);
    }

    public void setIsHasWorryFreeMonth(boolean z10) {
        this.f17114S = z10;
    }

    public void setUser(UserPackage userPackage) {
        this.f17115T = userPackage;
    }

    @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
    public void startPaymentProcess(C0079a c0079a) {
        if (c0079a == null) {
            C1442a.m8289e("GradePackageCardView", "startPaymentProcess, agreementDialogNeedData is null.");
            return;
        }
        SendMessageCommunicator sendMessageCommunicator = this.f17105J;
        if (sendMessageCommunicator == null) {
            C1442a.m8289e("GradePackageCardView", "startPaymentProcess, sendMessage is null.");
        } else {
            sendMessageCommunicator.mo23205q0(c0079a.m649f(), c0079a.m646c(), c0079a.m650g(), c0079a.m648e());
        }
    }

    /* renamed from: u */
    public final List<Voucher> m23583u(List<Voucher> list) {
        return !C11296s.m67785I(this.f17116U, this.f17110O.getProductType()) ? list : m23584v(list);
    }

    /* renamed from: v */
    public final List<Voucher> m23584v(List<Voucher> list) {
        if (this.f17116U.compareTo(C11296s.m67838v(this.f17110O)) <= -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Voucher voucher : list) {
            if (!"2".equals(voucher.getFeeMode())) {
                arrayList.add(voucher);
            }
        }
        return arrayList;
    }

    /* renamed from: w */
    public final String m23585w(CloudPackage cloudPackage) {
        if (this.f17114S) {
            return getContext().getString(R$string.auto_pay_member_tip, m23582s(cloudPackage.getEffectEndTime()));
        }
        CloudSpace cloudSpaceM67758b = C11293p.m67758b(this.f17115T);
        if (cloudSpaceM67758b == null || cloudSpaceM67758b.getIsAutoPay() == 1) {
            return this.f17102G;
        }
        return getContext().getString(R$string.accept_success_dialog_end_time_text, m23582s(cloudSpaceM67758b.getEndTime()));
    }

    /* renamed from: x */
    public final boolean m23586x() {
        CloudPackage cloudPackage = this.f17110O;
        return (cloudPackage == null || cloudPackage.getGiftRight() == null) ? false : true;
    }

    /* renamed from: y */
    public final void m23587y() {
        View view = this.f17146z;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public GradePackageCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17107L = false;
        this.f17109N = 0;
        this.f17110O = null;
        this.f17117V = BigDecimal.ZERO;
        this.f17118W = 0;
        this.f17120a0 = new RunnableC3632a();
        this.f17122b0 = C9433j.m59164c().m59165b();
        this.f17121b = context;
        m23528C();
    }
}
