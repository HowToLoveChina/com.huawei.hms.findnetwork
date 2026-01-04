package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huawei.android.hicloud.cloudbackup.util.PackageParamUtil;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.GradePackageCardView;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ConfirmRenewAgreementDialog;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.FilterAvailabalGradePackage;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.PackageGrades;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import p010a9.C0079a;
import p015ak.C0209d;
import p054cj.C1442a;
import p292fn.C9733f;
import p454lj.C11290m;
import p454lj.C11296s;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class WorryFreeGradePackageCardView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    public Context f17513a;

    /* renamed from: b */
    public View f17514b;

    /* renamed from: c */
    public TextView f17515c;

    /* renamed from: d */
    public SpanClickText f17516d;

    /* renamed from: e */
    public TextView f17517e;

    /* renamed from: f */
    public TextView f17518f;

    /* renamed from: g */
    public View f17519g;

    /* renamed from: h */
    public View f17520h;

    /* renamed from: i */
    public View f17521i;

    /* renamed from: j */
    public LinearLayout f17522j;

    /* renamed from: k */
    public ImageView f17523k;

    /* renamed from: l */
    public RenewAgreementTextview f17524l;

    /* renamed from: m */
    public boolean f17525m;

    /* renamed from: n */
    public GradePackageCardView.SendMessageCommunicator f17526n;

    /* renamed from: o */
    public CloudPackage f17527o;

    /* renamed from: p */
    public PackageGrades f17528p;

    /* renamed from: q */
    public String f17529q;

    /* renamed from: r */
    public Activity f17530r;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.WorryFreeGradePackageCardView$a */
    public class C3660a implements ConfirmRenewAgreementDialog.AgreementDlgCallback {
        public C3660a() {
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void refreshCheckboxStatus(boolean z10) {
            if (z10) {
                WorryFreeGradePackageCardView.this.f17523k.setBackground(WorryFreeGradePackageCardView.this.getContext().getDrawable(R$drawable.renew_check_icon_on));
            } else {
                WorryFreeGradePackageCardView.this.f17523k.setBackground(WorryFreeGradePackageCardView.this.getContext().getDrawable(R$drawable.renew_check_icon_off));
            }
            WorryFreeGradePackageCardView.this.f17525m = z10;
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void reportRenewDlgEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
            WorryFreeGradePackageCardView.this.m23901j(str, linkedHashMap);
        }

        @Override // com.huawei.android.hicloud.ui.uiextend.dialog.ConfirmRenewAgreementDialog.AgreementDlgCallback
        public void startPaymentProcess(C0079a c0079a) {
            WorryFreeGradePackageCardView.this.m23903l();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.WorryFreeGradePackageCardView$b */
    public class C3661b implements RenewAgreementTextview.RenewAgreementTVCallback {
        public C3661b() {
        }

        @Override // com.huawei.android.hicloud.ui.views.RenewAgreementTextview.RenewAgreementTVCallback
        /* renamed from: j0 */
        public void mo18858j0(boolean z10) {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("way_of_purchase", "recommend_purchase");
            String str = z10 ? "UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT" : "UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT";
            C13227f.m79492i1().m79591l0(str, linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMapM79497A);
        }
    }

    public WorryFreeGradePackageCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17513a = context;
        m23897f();
    }

    /* renamed from: d */
    public final void m23895d() {
        if (this.f17522j.getVisibility() != 0 || this.f17525m) {
            m23903l();
            return;
        }
        C0079a c0079a = new C0079a();
        c0079a.m652i(this.f17529q);
        c0079a.m651h(new C3660a());
        ConfirmRenewAgreementDialog confirmRenewAgreementDialog = new ConfirmRenewAgreementDialog(this.f17530r, c0079a);
        confirmRenewAgreementDialog.setCanceledOnTouchOutside(false);
        confirmRenewAgreementDialog.show();
    }

    /* renamed from: e */
    public final void m23896e() {
        if (this.f17525m) {
            this.f17523k.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
            this.f17525m = false;
        } else {
            this.f17523k.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
            this.f17525m = true;
        }
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("renew_checkbox_status", String.valueOf(this.f17525m));
        linkedHashMapM79499C.put("way_of_purchase", "recommend_purchase");
        C13227f.m79492i1().m79591l0("UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_RENEW_CHECKBOX", "1", "31", linkedHashMapM79499C);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public final void m23897f() {
        Context context = this.f17513a;
        if (context == 0) {
            C1442a.m8289e("GradePackageCardView", "initView error: context is null");
            return;
        }
        if (context instanceof GradePackageCardView.SendMessageCommunicator) {
            this.f17526n = (GradePackageCardView.SendMessageCommunicator) context;
        }
        View viewInflate = LayoutInflater.from(this.f17513a).inflate((C0209d.m1195O(context) > 1.75f ? 1 : (C0209d.m1195O(context) == 1.75f ? 0 : -1)) >= 0 ? R$layout.worry_free_member_card_fragment_scale : R$layout.worry_free_member_card_fragment, this);
        this.f17514b = viewInflate;
        this.f17515c = (TextView) C12809f.m76831d(viewInflate, R$id.worry_free_card_title_tv);
        this.f17517e = (TextView) C12809f.m76831d(this.f17514b, R$id.worry_free_card_msg);
        this.f17519g = C12809f.m76831d(this.f17514b, R$id.worry_free_card_buy_button);
        View view = this.f17514b;
        int i10 = R$id.price_view;
        this.f17520h = C12809f.m76831d(view, i10);
        View view2 = this.f17514b;
        int i11 = R$id.price_view_foreign;
        this.f17521i = C12809f.m76831d(view2, i11);
        this.f17522j = (LinearLayout) C12809f.m76831d(this.f17514b, R$id.recommend_worry_card_renew_check_area);
        this.f17523k = (ImageView) C12809f.m76831d(this.f17514b, R$id.recommend_worry_card_renew_check_view);
        this.f17524l = (RenewAgreementTextview) C12809f.m76831d(this.f17514b, R$id.recommend_worry_card_renew_text);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f17522j.getLayoutParams();
        if (C13843a.m83067S()) {
            this.f17520h.setVisibility(0);
            this.f17521i.setVisibility(8);
            this.f17516d = (SpanClickText) C12809f.m76831d(this.f17514b, R$id.worry_free_card_price_tv);
            this.f17518f = (TextView) C12809f.m76831d(this.f17514b, R$id.worry_free_card_duration);
            layoutParams.f2994j = i10;
        } else {
            this.f17520h.setVisibility(8);
            this.f17521i.setVisibility(0);
            this.f17516d = (SpanClickText) C12809f.m76831d(this.f17514b, R$id.worry_free_card_price_tv_foreign);
            this.f17518f = (TextView) C12809f.m76831d(this.f17514b, R$id.worry_free_card_duration_foreign);
            layoutParams.f2994j = i11;
        }
        this.f17522j.setLayoutParams(layoutParams);
        if (this.f17525m) {
            this.f17523k.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_on));
        } else {
            this.f17523k.setBackground(getContext().getDrawable(R$drawable.renew_check_icon_off));
        }
        this.f17523k.setOnClickListener(this);
        this.f17519g.setOnClickListener(this);
    }

    /* renamed from: g */
    public final void m23898g() {
        CloudPackage cloudPackage = this.f17527o;
        if (cloudPackage == null) {
            C1442a.m8290i("GradePackageCardView", "procDurationText selectPackage is null.");
        } else if (this.f17518f != null) {
            this.f17518f.setText(PackageParamUtil.procWorryFreeDurationText(this.f17513a, cloudPackage));
        }
    }

    /* renamed from: h */
    public final void m23899h() {
        CloudPackage cloudPackage = this.f17527o;
        if (cloudPackage == null) {
            C1442a.m8290i("GradePackageCardView", "procPriceText selectPackage is null.");
            return;
        }
        if (this.f17516d != null) {
            BigDecimal bigDecimalM67838v = C11296s.m67838v(cloudPackage);
            String currency = this.f17527o.getCurrency();
            String symbol = this.f17527o.getSymbol();
            String strM67750k = C11290m.m67750k(bigDecimalM67838v);
            String strM67754o = C11290m.m67754o(bigDecimalM67838v, currency, symbol, this.f17527o.getDurationMonth(), this.f17513a);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strM67754o);
            int iIndexOf = strM67754o.indexOf(strM67750k);
            if (iIndexOf > 0 && iIndexOf < strM67754o.length() && strM67750k.length() + iIndexOf <= strM67754o.length()) {
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(24, true), iIndexOf, strM67750k.length() + iIndexOf, 33);
            }
            this.f17516d.setText(spannableStringBuilder);
        }
    }

    /* renamed from: i */
    public void m23900i(FilterAvailabalGradePackage filterAvailabalGradePackage, GetClientUIConfigResp getClientUIConfigResp, Activity activity) {
        if (filterAvailabalGradePackage == null) {
            C1442a.m8290i("GradePackageCardView", "refreshData filterAvailabalGradePackage is null.");
            return;
        }
        CloudPackage cloudPackage = filterAvailabalGradePackage.getIncrementList().get(0);
        this.f17527o = cloudPackage;
        if (cloudPackage == null) {
            C1442a.m8290i("GradePackageCardView", "refreshData selectPackage is null.");
            return;
        }
        this.f17528p = filterAvailabalGradePackage.getPackageGrades();
        String productName = this.f17527o.getProductName();
        String remark = this.f17527o.getRemark();
        TextView textView = this.f17515c;
        if (textView != null) {
            textView.setText(productName);
        }
        TextView textView2 = this.f17517e;
        if (textView2 != null) {
            textView2.setText(remark);
        }
        m23899h();
        m23898g();
        m23902k(this.f17527o.getProductType(), getClientUIConfigResp, activity);
    }

    /* renamed from: j */
    public void m23901j(String str, LinkedHashMap<String, String> linkedHashMap) {
        linkedHashMap.put("way_of_purchase", "recommend_purchase");
        C13227f.m79492i1().m79591l0(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMap);
    }

    /* renamed from: k */
    public final void m23902k(int i10, GetClientUIConfigResp getClientUIConfigResp, Activity activity) {
        this.f17530r = activity;
        if (C13452e.m80781L().m80803F0().booleanValue()) {
            if (C9733f.m60705z().m60763v("userSelectsAutoRenewal") == 0) {
                C1442a.m8290i("GradePackageCardView", "showRecommendWorryRenewTV, switch is close.");
                return;
            }
            if (i10 == 12) {
                if (getClientUIConfigResp == null) {
                    C1442a.m8289e("GradePackageCardView", "showRecommendWorryRenewTV, params is null.");
                    return;
                }
                String packageCardAgreement = getClientUIConfigResp.getPackageCardAgreement();
                this.f17529q = getClientUIConfigResp.getCheckDialogRenewAgreement();
                if (TextUtils.isEmpty(packageCardAgreement)) {
                    C1442a.m8289e("GradePackageCardView", "showRecommendWorryRenewTV, packageCardRenewAgreementText is null.");
                    return;
                }
                if (TextUtils.isEmpty(this.f17529q)) {
                    C1442a.m8290i("GradePackageCardView", "showRecommendWorryRenewTV, checkDialogRenewAgreementText is null.");
                    return;
                }
                this.f17522j.setVisibility(0);
                String string = getContext().getString(R$string.cloudpay_monthly_renew_agreement);
                String string2 = getContext().getString(R$string.cloudpay_user_agreement);
                String str = String.format(packageCardAgreement, string2, string);
                this.f17524l.setWorryCard(true);
                this.f17524l.m25806w(str, string2, string, activity, new C3661b());
            }
        }
    }

    /* renamed from: l */
    public final void m23903l() {
        GradePackageCardView.SendMessageCommunicator sendMessageCommunicator = this.f17526n;
        if (sendMessageCommunicator == null) {
            C1442a.m8289e("GradePackageCardView", "clickBuyBtn sendMessage is null.");
            return;
        }
        CloudPackage cloudPackage = this.f17527o;
        if (cloudPackage == null) {
            C1442a.m8289e("GradePackageCardView", "clickBuyBtn currentSelectedPackage is null.");
        } else {
            sendMessageCommunicator.mo23205q0(cloudPackage, this.f17528p, new ArrayList(), null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1442a.m8289e("GradePackageCardView", "fast click.");
        } else if (view.getId() == R$id.worry_free_card_buy_button) {
            m23895d();
        } else if (view.getId() == R$id.recommend_worry_card_renew_check_view) {
            m23896e();
        }
    }
}
