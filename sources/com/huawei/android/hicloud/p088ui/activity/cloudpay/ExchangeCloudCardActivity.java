package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import ca.C1399b;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.GradeCardView;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.LearnMorePayClickListener;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.PayResultErrorDialog;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$plurals;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.ChannelInfo;
import com.huawei.cloud.pay.model.CloudCardGiftInfo;
import com.huawei.cloud.pay.model.CloudPackage;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.ConvertInfo;
import com.huawei.cloud.pay.model.EstimateResp;
import com.huawei.cloud.pay.model.ExchangePackageResp;
import com.huawei.cloud.pay.model.GradeCardDisplayBean;
import com.huawei.cloud.pay.model.InAppPurchaseData;
import com.huawei.cloud.pay.model.OrderResult;
import com.huawei.cloud.pay.model.QuerySubOrderStatusResp;
import com.huawei.cloud.pay.model.SignPurchaseResp;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.hms.iap.Iap;
import com.huawei.hms.iap.entity.PurchaseResultInfo;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import com.huawei.secure.android.common.intent.SafeIntent;
import dj.C9158a;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0223k;
import p054cj.C1442a;
import p252e9.C9433j;
import p429kk.C11058a;
import p429kk.C11060c;
import p454lj.C11290m;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11839m;
import p514o9.C11842p;
import p664u0.C13108a;
import p709vj.C13452e;
import p746wn.C13622a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class ExchangeCloudCardActivity extends BuyPackageBaseActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    /* renamed from: A1 */
    public RelativeLayout f17048A1;

    /* renamed from: B1 */
    public CheckBox f17049B1;

    /* renamed from: C1 */
    public SpanClickText f17050C1;

    /* renamed from: D1 */
    public AutoSizeButton f17051D1;

    /* renamed from: E1 */
    public View f17052E1;

    /* renamed from: F1 */
    public TextView f17053F1;

    /* renamed from: G1 */
    public AutoSizeButton f17054G1;

    /* renamed from: H1 */
    public View f17055H1;

    /* renamed from: I1 */
    public View f17056I1;

    /* renamed from: J1 */
    public String f17057J1;

    /* renamed from: K1 */
    public String f17058K1;

    /* renamed from: L1 */
    public int f17059L1;

    /* renamed from: M1 */
    public int f17060M1;

    /* renamed from: N1 */
    public long f17061N1;

    /* renamed from: O1 */
    public String f17062O1;

    /* renamed from: P1 */
    public EstimateResp f17063P1;

    /* renamed from: Q1 */
    public int f17064Q1;

    /* renamed from: R1 */
    public ExchangePackageResp f17065R1;

    /* renamed from: S1 */
    public NotchTopFitLinearLayout f17066S1;

    /* renamed from: T1 */
    public ScrollView f17067T1;

    /* renamed from: U1 */
    public RelativeLayout f17068U1;

    /* renamed from: V1 */
    public LinearLayout f17069V1;

    /* renamed from: W1 */
    public CloudSpace f17070W1;

    /* renamed from: X1 */
    public Handler f17071X1 = new HandlerC3629a();

    /* renamed from: h1 */
    public View f17072h1;

    /* renamed from: i1 */
    public GradeCardView f17073i1;

    /* renamed from: j1 */
    public TextView f17074j1;

    /* renamed from: k1 */
    public TextView f17075k1;

    /* renamed from: l1 */
    public TextView f17076l1;

    /* renamed from: m1 */
    public TextView f17077m1;

    /* renamed from: n1 */
    public TextView f17078n1;

    /* renamed from: o1 */
    public TextView f17079o1;

    /* renamed from: p1 */
    public TextView f17080p1;

    /* renamed from: q1 */
    public TextView f17081q1;

    /* renamed from: r1 */
    public TextView f17082r1;

    /* renamed from: s1 */
    public TextView f17083s1;

    /* renamed from: t1 */
    public TextView f17084t1;

    /* renamed from: u1 */
    public TextView f17085u1;

    /* renamed from: v1 */
    public TextView f17086v1;

    /* renamed from: w1 */
    public TextView f17087w1;

    /* renamed from: x1 */
    public TextView f17088x1;

    /* renamed from: y1 */
    public TextView f17089y1;

    /* renamed from: z1 */
    public TextView f17090z1;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.ExchangeCloudCardActivity$a */
    public class HandlerC3629a extends Handler {
        public HandlerC3629a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 7046) {
                ExchangeCloudCardActivity.this.m23512U5(message.obj);
                return;
            }
            if (i10 == 7047) {
                C1442a.m8289e("ExchangeCloudCardActivity", "EXCHANGE_PACKAGE_FAIL , errCode = " + message.arg1);
                ExchangeCloudCardActivity.this.m23506L5(message.arg1);
                return;
            }
            C1442a.m8290i("ExchangeCloudCardActivity", "default show no data. msg.what = " + message.what + " msg.arg1 = " + message.arg1);
            ExchangeCloudCardActivity.this.mo19477k5();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.ExchangeCloudCardActivity$b */
    public class RunnableC3630b implements Runnable {
        public RunnableC3630b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExchangeCloudCardActivity.this.finish();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.ExchangeCloudCardActivity$c */
    public class DialogInterfaceOnClickListenerC3631c implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3631c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ExchangeCloudCardActivity.this.f16528Q.dismiss();
            ExchangeCloudCardActivity.this.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* renamed from: O5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m23489O5() {
        /*
            r13 = this;
            com.huawei.cloud.pay.model.UserPackage r0 = r13.f21452m
            com.huawei.cloud.pay.model.CloudSpace r0 = p454lj.C11293p.m67757a(r0)
            long r1 = r13.f17061N1
            long r3 = r0.getCapacity()
            int r5 = r0.getType()
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 != 0) goto L37
            long r9 = r0.getCapacity()
            r11 = 0
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L37
            com.huawei.cloud.pay.model.EstimateResp r3 = r13.f17063P1
            java.lang.Long r3 = r3.getCapacity()
            long r4 = r3.longValue()
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 <= 0) goto L2e
            goto L3b
        L2e:
            long r3 = r3.longValue()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L40
            goto L3f
        L37:
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 <= 0) goto L3d
        L3b:
            r8 = r7
            goto L40
        L3d:
            if (r1 >= 0) goto L40
        L3f:
            r8 = r6
        L40:
            if (r8 != r7) goto L53
            com.huawei.cloud.pay.model.EstimateResp r0 = r13.f17063P1
            com.huawei.cloud.pay.model.ConvertInfo r0 = r0.getConvertInfo()
            int r0 = r0.getDurationMonth()
            com.huawei.cloud.pay.model.EstimateResp r1 = r13.f17063P1
            java.lang.String r13 = r13.m23503I5(r0, r1)
            goto L65
        L53:
            if (r8 != r6) goto L5c
            com.huawei.cloud.pay.model.EstimateResp r1 = r13.f17063P1
            java.lang.String r13 = r13.m23504J5(r0, r1)
            goto L65
        L5c:
            java.lang.String r13 = "ExchangeCloudCardActivity"
            java.lang.String r0 = "capacity is same, no need show estimate hint, error"
            p054cj.C1442a.m8289e(r13, r0)
            java.lang.String r13 = ""
        L65:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.activity.cloudpay.ExchangeCloudCardActivity.m23489O5():java.lang.String");
    }

    /* renamed from: P5 */
    private void m23490P5() {
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f17058K1 = safeIntent.getStringExtra("reward_id");
        this.f17057J1 = safeIntent.getStringExtra("product_id");
        this.f17059L1 = safeIntent.getIntExtra("reward_duration_month", -1);
        this.f17060M1 = safeIntent.getIntExtra("reward_duration_unit", -1);
        this.f17064Q1 = safeIntent.getIntExtra("rewad_support_sub", -1);
        this.f17061N1 = safeIntent.getLongExtra("rewad_package_capacity", -1L);
        this.f17062O1 = safeIntent.getStringExtra("reward_pomid");
    }

    /* renamed from: R5 */
    private String m23491R5(CloudSpace cloudSpace, boolean z10, String str) {
        String strM67766j = C11293p.m67766j(this.f21452m);
        return z10 ? cloudSpace != null ? getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time, strM67766j, str)) : getString(R$string.cloudpay_parenthesis, getString(R$string.auto_pay_member_tip, str)) : cloudSpace != null ? getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, strM67766j, str)) : getString(R$string.package_info_capacity_package, str);
    }

    /* renamed from: Y5 */
    private void m23492Y5() {
        this.f17066S1 = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.main_notch_fit_layout);
        this.f17067T1 = (ScrollView) C12809f.m76829b(this, R$id.pay_detail_scroll_view);
        this.f17068U1 = (RelativeLayout) C12809f.m76829b(this, R$id.pay_detail_bottom_view);
        this.f17069V1 = (LinearLayout) C12809f.m76829b(this, R$id.exchanged_view);
        this.f17055H1 = C12809f.m76829b(this, R$id.layout_loading);
        View viewM76829b = C12809f.m76829b(this, R$id.layout_nodata);
        this.f17056I1 = viewM76829b;
        viewM76829b.setOnClickListener(this);
        this.f17072h1 = C12809f.m76829b(this, R$id.layout_card_detail);
        this.f17073i1 = (GradeCardView) C12809f.m76829b(this, R$id.grade_card_view);
        LinearLayout linearLayout = (LinearLayout) C12809f.m76829b(this, R$id.now_detail);
        int i10 = R$id.current_title;
        this.f17074j1 = (TextView) C12809f.m76831d(linearLayout, i10);
        int i11 = R$id.current_title_value;
        this.f17075k1 = (TextView) C12809f.m76831d(linearLayout, i11);
        int i12 = R$id.used_capacity_title;
        this.f17076l1 = (TextView) C12809f.m76831d(linearLayout, i12);
        int i13 = R$id.base_capacity_title;
        this.f17077m1 = (TextView) C12809f.m76831d(linearLayout, i13);
        int i14 = R$id.pay_capacity_title;
        this.f17078n1 = (TextView) C12809f.m76831d(linearLayout, i14);
        int i15 = R$id.used_capacity_value;
        this.f17079o1 = (TextView) C12809f.m76831d(linearLayout, i15);
        int i16 = R$id.base_capacity_value;
        this.f17080p1 = (TextView) C12809f.m76831d(linearLayout, i16);
        int i17 = R$id.pay_capacity_value;
        this.f17081q1 = (TextView) C12809f.m76831d(linearLayout, i17);
        LinearLayout linearLayout2 = (LinearLayout) C12809f.m76829b(this, R$id.after_detail);
        this.f17082r1 = (TextView) C12809f.m76831d(linearLayout2, i10);
        this.f17083s1 = (TextView) C12809f.m76831d(linearLayout2, i11);
        this.f17084t1 = (TextView) C12809f.m76831d(linearLayout2, i12);
        this.f17085u1 = (TextView) C12809f.m76831d(linearLayout2, i13);
        this.f17086v1 = (TextView) C12809f.m76831d(linearLayout2, i14);
        this.f17087w1 = (TextView) C12809f.m76831d(linearLayout2, i15);
        this.f17088x1 = (TextView) C12809f.m76831d(linearLayout2, i16);
        this.f17089y1 = (TextView) C12809f.m76831d(linearLayout2, i17);
        this.f17090z1 = (TextView) C12809f.m76829b(this, R$id.estimate_hint);
        this.f17048A1 = (RelativeLayout) C12809f.m76829b(this, R$id.estimate_rule_layout);
        CheckBox checkBox = (CheckBox) C12809f.m76829b(this, R$id.estimate_rule_checkbox);
        this.f17049B1 = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        this.f17050C1 = (SpanClickText) C12809f.m76829b(this, R$id.estimate_rule_text);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.card_submit);
        this.f17051D1 = autoSizeButton;
        autoSizeButton.setOnClickListener(this);
        this.f17052E1 = C12809f.m76829b(this, R$id.layout_exchanged);
        this.f17053F1 = (TextView) C12809f.m76829b(this, R$id.card_exchanged_hint);
        AutoSizeButton autoSizeButton2 = (AutoSizeButton) C12809f.m76829b(this, R$id.card_ok_btn);
        this.f17054G1 = autoSizeButton2;
        autoSizeButton2.setOnClickListener(this);
        C11842p.m70866t1(this, this.f17051D1);
        C11842p.m70866t1(this, this.f17054G1);
        m23498h6();
    }

    /* renamed from: Z5 */
    private boolean m23493Z5() {
        if (this.f21452m.getUserPayType() == 0) {
            C11839m.m70688i("ExchangeCloudCardActivity", "free user, no need show estimate rule");
            return false;
        }
        if (C11293p.m67757a(this.f21452m).getCapacity() != this.f17063P1.getCapacity().longValue()) {
            return true;
        }
        C11839m.m70688i("ExchangeCloudCardActivity", "same capacity, no need show estimate rule");
        return false;
    }

    /* renamed from: c6 */
    private void m23494c6(CloudSpace cloudSpace) {
        String gradeName = this.f17063P1.getGrade().getGradeName();
        String productName = cloudSpace != null ? cloudSpace.getProductName() : "";
        if (!TextUtils.isEmpty(productName)) {
            gradeName = gradeName + " + " + productName;
        }
        this.f17083s1.setText(gradeName);
    }

    /* renamed from: d6 */
    private void m23495d6(boolean z10) {
        AutoSizeButton autoSizeButton = this.f17051D1;
        if (autoSizeButton == null) {
            return;
        }
        if (z10) {
            autoSizeButton.setClickable(true);
            this.f17051D1.setAlpha(1.0f);
        } else {
            autoSizeButton.setClickable(false);
            this.f17051D1.setAlpha(0.62f);
        }
    }

    /* renamed from: e6 */
    private void m23496e6(CloudSpace cloudSpace) {
        long jM67765i = C11293p.m67765i(this.f21452m);
        if (jM67765i > 0) {
            String strM67741b = C11290m.m67741b(this, cloudSpace.getEndTime());
            String strM23491R5 = (!m28589p1() || m28590q1()) ? m23491R5(this.f17070W1, false, strM67741b) : m23491R5(this.f17070W1, true, strM67741b);
            if (!C11293p.m67774r(this.f21452m)) {
                this.f17081q1.setText(getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, jM67765i), strM23491R5));
            } else if (this.f17070W1 != null) {
                this.f17081q1.setText(C0223k.m1524g(this, jM67765i));
            }
        }
    }

    /* renamed from: g6 */
    private void m23497g6(LearnMorePayClickListener learnMorePayClickListener, String str, String str2) {
        this.f17050C1.m15931c(str, learnMorePayClickListener);
        this.f17050C1.m15934g(str2, false);
    }

    /* renamed from: h6 */
    private void m23498h6() {
        int iM70841n0 = (C11842p.m70771U0() && C11842p.m70774V0(this)) ? C11842p.m70841n0() : C11842p.m70837m0();
        this.f17074j1.setMaxWidth(iM70841n0);
        this.f17082r1.setMaxWidth(iM70841n0);
    }

    /* renamed from: i6 */
    private void m23499i6() {
        C1442a.m8290i("ExchangeCloudCardActivity", "showDetailView()");
        this.f17055H1.setVisibility(8);
        this.f17056I1.setVisibility(8);
        this.f17072h1.setVisibility(0);
        this.f17052E1.setVisibility(8);
        if (getActionBar() != null) {
            getActionBar().setTitle(R$string.cloudpay_card_detail_title);
        }
        if (this.f17063P1 == null) {
            C1442a.m8289e("ExchangeCloudCardActivity", "showDetailView estimateResp is null.");
            setResult(0, null);
            finish();
            return;
        }
        this.f17073i1.setData(new GradeCardDisplayBean(m23510S5(), this.f17063P1.getPackageGrade()), this.f16538V.getRightTitle(), C9433j.m59164c().m59165b(), false, false, this.f17063P1.getConvertInfo().getSupportAutoPay(), 1, false);
        this.f17070W1 = null;
        UserPackage userPackage = this.f21452m;
        if (userPackage != null) {
            this.f17070W1 = C11293p.m67760d(userPackage.getEffectivePackages(), 2);
        }
        CloudSpace cloudSpaceM67757a = C11293p.m67757a(this.f21452m);
        m23515X5(cloudSpaceM67757a);
        ConvertInfo convertInfo = this.f17063P1.getConvertInfo();
        int supportAutoPay = convertInfo.getSupportAutoPay();
        m23514W5(cloudSpaceM67757a, convertInfo, supportAutoPay);
        if (this.f17064Q1 == 1) {
            if (supportAutoPay == 1) {
                m23500j6();
            } else {
                m23502l6();
            }
        } else if (m23493Z5()) {
            m23495d6(false);
            m23502l6();
        } else {
            this.f17048A1.setVisibility(8);
            m23495d6(true);
        }
        m23501k6();
    }

    /* renamed from: j6 */
    private void m23500j6() {
        if (this.f17048A1.getVisibility() != 0) {
            this.f17048A1.setVisibility(0);
            if (this.f17049B1.isChecked()) {
                this.f17049B1.setChecked(true);
            } else {
                this.f17049B1.setChecked(false);
                m23495d6(false);
            }
        }
        String string = getString(R$string.cloudpay_upgrade_instruction_new);
        String string2 = getString(R$string.cloudpay_continuous_monthly_agreement_new);
        String string3 = getString(R$string.cloudpay_exchange_rule_text, string, string2);
        LearnMorePayClickListener learnMorePayClickListener = new LearnMorePayClickListener(this, m23509Q5());
        LearnMorePayClickListener learnMorePayClickListener2 = new LearnMorePayClickListener(this, "/payagreement?lang=");
        this.f17050C1.m15931c(string, learnMorePayClickListener);
        this.f17050C1.m15931c(string2, learnMorePayClickListener2);
        this.f17050C1.m15934g(string3, false);
    }

    /* renamed from: k6 */
    private void m23501k6() {
        if (this.f17090z1 == null) {
            C1442a.m8290i("ExchangeCloudCardActivity", "showEstimateHintText() estimateHintText is null.");
            return;
        }
        String strM23489O5 = m23489O5();
        if (TextUtils.isEmpty(strM23489O5)) {
            this.f17090z1.setVisibility(8);
        } else {
            this.f17090z1.setVisibility(0);
            this.f17090z1.setText(strM23489O5);
        }
    }

    /* renamed from: l6 */
    private void m23502l6() {
        if (this.f17048A1.getVisibility() != 0) {
            this.f17048A1.setVisibility(0);
            if (this.f17049B1.isChecked()) {
                this.f17049B1.setChecked(true);
            } else {
                this.f17049B1.setChecked(false);
                m23495d6(false);
            }
        }
        String string = getString(R$string.cloudpay_upgrade_instruction_new);
        m23497g6(new LearnMorePayClickListener(this, m23509Q5()), string, getString(R$string.cloudpay_card_estimate_rule_text, string));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f17067T1, this.f17068U1, this.f17069V1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f17067T1, this.f17068U1, this.f17069V1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f17067T1, this.f17068U1, this.f17069V1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f17067T1, this.f17068U1, this.f17069V1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f17067T1, this.f17068U1, this.f17069V1);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f17067T1, this.f17068U1, this.f17069V1);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: H3 */
    public void mo19451H3(Bundle bundle) {
    }

    /* renamed from: I5 */
    public final String m23503I5(int i10, EstimateResp estimateResp) throws Resources.NotFoundException {
        ConvertInfo convertInfo = estimateResp.getConvertInfo();
        NumberFormat numberFormat = NumberFormat.getInstance();
        String quantityString = getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_month, i10, numberFormat.format(i10));
        int packageConvertDays = convertInfo.getPackageConvertDays();
        String quantityString2 = getResources().getQuantityString(R$plurals.cloudpay_package_duration_time_unit_day, packageConvertDays, numberFormat.format(packageConvertDays));
        String gradeName = estimateResp.getPackageGrade().getGradeName();
        return getString(R$string.cloudpay_card_estimate_hint_big_buy_small, this.f17064Q1 == 1 ? m23508N5(gradeName) : getString(R$string.cloudpay_package_urse_space_detail, gradeName, getString(R$string.cloudpay_parenthesis, quantityString)), getString(R$string.cloudpay_package_urse_space_detail, estimateResp.getGrade().getGradeName(), getString(R$string.cloudpay_parenthesis, quantityString2)));
    }

    /* renamed from: J5 */
    public final String m23504J5(CloudSpace cloudSpace, EstimateResp estimateResp) throws Resources.NotFoundException {
        ConvertInfo convertInfo = estimateResp.getConvertInfo();
        NumberFormat numberFormat = NumberFormat.getInstance();
        int remainDays = convertInfo.getRemainDays();
        Resources resources = getResources();
        int i10 = R$plurals.cloudpay_package_duration_time_unit_day;
        String quantityString = resources.getQuantityString(i10, remainDays, numberFormat.format(remainDays));
        int convertDays = convertInfo.getConvertDays();
        String quantityString2 = getResources().getQuantityString(i10, convertDays, numberFormat.format(convertDays));
        String gradeName = C11293p.m67757a(this.f21452m).getGradeName();
        String gradeName2 = estimateResp.getGrade().getGradeName();
        int i11 = R$string.cloudpay_package_urse_space_detail;
        int i12 = R$string.cloudpay_parenthesis;
        String string = getString(i11, gradeName, getString(i12, quantityString));
        String string2 = getString(i11, gradeName2, getString(i12, quantityString2));
        return this.f17064Q1 == 1 ? getString(R$string.cloudpay_card_estimate_hint_small_buy_big, string, string2) : (m28589p1() && convertInfo.getSupportAutoPay() == 0) ? getString(R$string.cloudpay_card_estimate_hint_monthly_small_buy_big, gradeName, string, string2) : getString(R$string.cloudpay_card_estimate_hint_small_buy_big, string, string2);
    }

    /* renamed from: K5 */
    public final void m23505K5() {
        m28583a1();
    }

    /* renamed from: L5 */
    public final void m23506L5(int i10) {
        m23505K5();
        if (i10 == 121) {
            m23511T5();
            m23516a6();
        } else if (i10 == 4) {
            m22786N3(4);
        } else {
            m22786N3(799);
        }
    }

    /* renamed from: M5 */
    public final ChannelInfo m23507M5() {
        ChannelInfo channelInfo = new ChannelInfo();
        channelInfo.setSalChannel("1");
        channelInfo.setSrcChannel("0");
        return channelInfo;
    }

    /* renamed from: N5 */
    public final String m23508N5(String str) throws Resources.NotFoundException {
        int i10 = this.f17060M1;
        if (i10 == 1) {
            Resources resources = getResources();
            int i11 = R$plurals.cloudpay_cloud_card_day;
            int i12 = this.f17059L1;
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, resources.getQuantityString(i11, i12, Integer.valueOf(i12))));
        }
        if (i10 == 2) {
            Resources resources2 = getResources();
            int i13 = R$plurals.cloudpay_cloud_card_month;
            int i14 = this.f17059L1;
            return getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, resources2.getQuantityString(i13, i14, Integer.valueOf(i14))));
        }
        if (i10 != 3) {
            return "";
        }
        Resources resources3 = getResources();
        int i15 = R$plurals.cloudpay_cloud_card_year;
        int i16 = this.f17059L1;
        return getResources().getString(R$string.cloudpay_package_urse_space_detail, str, getResources().getString(R$string.cloudpay_parenthesis, resources3.getQuantityString(i15, i16, Integer.valueOf(i16))));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: O2 */
    public void mo22788O2(int i10) {
        C1442a.m8289e("ExchangeCloudCardActivity", "GET_ESTIMATE_FAILED , errCode = " + i10);
        if (i10 == 107) {
            mo22716i5();
            return;
        }
        if (i10 == 27 || i10 == 108) {
            m23513V5(i10);
            return;
        }
        if (i10 != 11 && i10 != 16 && i10 != 17 && i10 != 18) {
            m22786N3(i10);
        } else {
            Toast.makeText(this, getString(com.huawei.cloud.pay.R$string.cloudpay_package_released), 0).show();
            this.f16524O.postDelayed(new RunnableC3630b(), 1500L);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: P3 */
    public void mo22790P3(Intent intent) {
        if (intent == null) {
            C1442a.m8289e("ExchangeCloudCardActivity", "handleIAP4PayResult , data is null");
            m28583a1();
            return;
        }
        PurchaseResultInfo purchaseResultInfoFromIntent = Iap.getIapClient((Activity) this).parsePurchaseResultInfoFromIntent(intent);
        int returnCode = purchaseResultInfoFromIntent.getReturnCode();
        C1442a.m8290i("ExchangeCloudCardActivity", "handleIAP4PayResult , returnCode = " + returnCode);
        if (returnCode == -1) {
            m22786N3(4002);
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            m28583a1();
            return;
        }
        if (returnCode == 0) {
            String inAppPurchaseData = purchaseResultInfoFromIntent.getInAppPurchaseData();
            C1442a.m8288d("ExchangeCloudCardActivity", "handleIAP4PayResult inAppPurchaseDataStr = " + inAppPurchaseData);
            C1442a.m8288d("ExchangeCloudCardActivity", "handleIAP4PayResult inAppPurchaseDataSignature = " + purchaseResultInfoFromIntent.getInAppDataSignature());
            try {
                InAppPurchaseData inAppPurchaseData2 = (InAppPurchaseData) new Gson().fromJson(inAppPurchaseData, InAppPurchaseData.class);
                C11296s.m67816g0(this);
                m22762F3(inAppPurchaseData2);
                return;
            } catch (JsonSyntaxException e10) {
                C1442a.m8289e("ExchangeCloudCardActivity", "handleIAP4PayResult e : " + e10.getMessage());
                return;
            }
        }
        if (returnCode == 60000) {
            m23505K5();
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        if (returnCode == 60003) {
            C1442a.m8290i("ExchangeCloudCardActivity", "handleIAP4PayResult err,ORDER_STATE_PRODUCT_INVALID");
            m22864q3(this.f17065R1.getSignInfo());
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        if (returnCode == 60051) {
            m22823b4();
            m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
            return;
        }
        m23505K5();
        m22751C4("iap_4_pay_result_hwpay_callback_result_" + returnCode);
        m22786N3(4002);
    }

    /* renamed from: Q5 */
    public final String m23509Q5() {
        return C13452e.m80781L().m80887a1() ? "/changespace3?lang=" : "/changespace?lang=";
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: R3 */
    public void mo22795R3(Object obj) {
        this.f17063P1 = (EstimateResp) obj;
        mo19479s5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: S4 */
    public boolean mo19458S4() {
        return false;
    }

    /* renamed from: S5 */
    public final CloudPackage m23510S5() {
        CloudPackage cloudPackage = new CloudPackage();
        if (this.f17063P1 == null) {
            C1442a.m8289e("ExchangeCloudCardActivity", "geteCloudPackage() estimateResp is null.");
            return cloudPackage;
        }
        cloudPackage.setDurationMonth(this.f17059L1);
        cloudPackage.setDurationUnit(this.f17060M1);
        cloudPackage.setCapacity(this.f17061N1);
        return cloudPackage;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: T3 */
    public void mo19460T3() {
        C1442a.m8290i("ExchangeCloudCardActivity", "initData()");
        mo19474g5();
        this.f17057J1 = "";
        this.f17058K1 = "";
        this.f21452m = null;
        this.f16538V = null;
        this.f17063P1 = null;
        this.f17065R1 = null;
        m23490P5();
        this.f21448i = C11058a.m66626a(C11058a.m66627b("06018"), "/exchangePackage", C13452e.m80781L().m80971t0());
        C9158a.m57503F().m57505B(this.f16524O, this.f21448i, true);
        C9158a.m57503F().m57517O(this.f16524O, this.f21448i, true, true, "ExchangeCloudCardActivity");
        C9158a.m57503F().m57549n(this.f16524O, this.f17057J1, 11, this.f21448i, null, Integer.valueOf(this.f17064Q1), this.f17062O1);
    }

    /* renamed from: T5 */
    public final void m23511T5() {
        Intent intent = new Intent();
        intent.setClass(this, CloudSpaceUpgradeActivity.class);
        startActivity(intent);
        finish();
    }

    /* renamed from: U5 */
    public final void m23512U5(Object obj) {
        if (obj == null || !(obj instanceof ExchangePackageResp)) {
            C1442a.m8289e("ExchangeCloudCardActivity", "handExchangePackageSuccess ExchangePackageResp is null.");
            m28583a1();
            m22786N3(4004);
            return;
        }
        ExchangePackageResp exchangePackageResp = (ExchangePackageResp) obj;
        this.f17065R1 = exchangePackageResp;
        CloudCardGiftInfo gift = exchangePackageResp.getGift();
        this.f16536U.setId(gift.getId());
        this.f16536U.setRequestId(gift.getRequestId());
        CloudSpace cloudSpace = new CloudSpace();
        this.f16520M = cloudSpace;
        cloudSpace.setId(gift.getBaseId());
        if (this.f17065R1.getSignStatus() != 0) {
            C1442a.m8290i("ExchangeCloudCardActivity", "handExchangePackageSuccess getNotify");
            m22758E3();
            return;
        }
        int signMode = this.f17065R1.getSignMode();
        if (signMode == 2) {
            C1442a.m8290i("ExchangeCloudCardActivity", "handExchangePackageSuccess dealSignPurchaseSuccess");
            SignPurchaseResp purchaseInfo = this.f17065R1.getPurchaseInfo();
            this.f16509G0 = purchaseInfo.getPayload();
            m22878u3(purchaseInfo, 7034);
            return;
        }
        if (signMode == 1) {
            C1442a.m8290i("ExchangeCloudCardActivity", "handExchangePackageSuccess dealQuerySignStatusSuccess");
            m22864q3(this.f17065R1.getSignInfo());
            return;
        }
        C1442a.m8289e("ExchangeCloudCardActivity", "handExchangePackageSuccess invalid signMode = " + signMode);
        m28583a1();
        m22786N3(4004);
    }

    /* renamed from: V5 */
    public final void m23513V5(int i10) {
        PayResultErrorDialog payResultErrorDialog = this.f16528Q;
        if (payResultErrorDialog != null && payResultErrorDialog.isShowing()) {
            this.f16528Q.dismiss();
        }
        this.f16528Q = null;
        PayResultErrorDialog payResultErrorDialog2 = new PayResultErrorDialog(this, false);
        this.f16528Q = payResultErrorDialog2;
        payResultErrorDialog2.show(i10);
        this.f16528Q.setButton(-2, getString(R$string.cloudpay_payment_result_dialog_agree), new DialogInterfaceOnClickListenerC3631c());
    }

    /* renamed from: W5 */
    public final void m23514W5(CloudSpace cloudSpace, ConvertInfo convertInfo, int i10) {
        this.f17082r1.setText(getString(R$string.cloudpay_card_title_after_exchange));
        this.f17084t1.setText(this.f16538V.getPlanDetailUesdSpaceTile());
        this.f17085u1.setText(this.f16538V.getPlanDetailFreeSpaceTile());
        this.f17086v1.setText(this.f16538V.getPlanDetailPaySpaceTile());
        m23494c6(this.f17070W1);
        this.f17087w1.setText(C11290m.m67751l(this, this.f21452m.getUsed(), convertInfo.getTotalCapacity()));
        this.f17088x1.setText(C0223k.m1524g(this, cloudSpace.getBaseCapacity()));
        m23517b6(convertInfo, i10);
    }

    /* renamed from: X5 */
    public final void m23515X5(CloudSpace cloudSpace) {
        this.f17074j1.setText(getString(R$string.cloudpay_card_title_before_exchange));
        this.f17076l1.setText(this.f16538V.getPlanDetailUesdSpaceTile());
        this.f17077m1.setText(this.f16538V.getPlanDetailFreeSpaceTile());
        this.f17078n1.setText(this.f16538V.getPlanDetailPaySpaceTile());
        m23518f6();
        this.f17079o1.setText(C11290m.m67751l(this, this.f21452m.getUsed(), this.f21452m.getTotalCapacity()));
        this.f17080p1.setText(C0223k.m1524g(this, cloudSpace.getBaseCapacity()));
        m23496e6(cloudSpace);
    }

    /* renamed from: a6 */
    public void m23516a6() {
        C1442a.m8290i("ExchangeCloudCardActivity", "sendRefreshBroadCase");
        Intent intent = new Intent();
        intent.setAction("com.huawei.hicloud.coupon.center.refresh");
        C13108a.m78878b(this).m78881d(intent);
    }

    /* renamed from: b6 */
    public final void m23517b6(ConvertInfo convertInfo, int i10) {
        String string;
        String strM67741b = C11290m.m67741b(this, this.f17063P1.getEndtime().longValue());
        if (this.f17064Q1 == 1) {
            if (this.f21452m.getIsAutoPay() == 0) {
                if (i10 == 1) {
                    if (this.f17070W1 != null) {
                        string = getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time_and_price, this.f17063P1.getGrade().getGradeName(), strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this)));
                    } else {
                        string = getString(R$string.cloudpay_exchange_month_package_with_price, strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this));
                    }
                } else if (this.f17070W1 != null) {
                    string = getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, this.f17063P1.getGrade().getGradeName(), strM67741b));
                } else {
                    string = getString(R$string.package_info_capacity_package, strM67741b);
                }
            } else if (i10 == 1) {
                if (this.f17070W1 != null) {
                    string = getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time_and_price, this.f17063P1.getGrade().getGradeName(), strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this)));
                } else {
                    string = getString(R$string.cloudpay_exchange_month_package_with_price, strM67741b, C11290m.m67754o(convertInfo.getBasePrice(), convertInfo.getCurrency(), convertInfo.getSymbol(), convertInfo.getDurationMonth(), this));
                }
            } else if (this.f17063P1.getIsAutoPay() == 1) {
                if (this.f17070W1 != null) {
                    string = getString(R$string.cloudpay_parenthesis, getString(R$string.next_renewal_time, this.f17063P1.getGrade().getGradeName(), strM67741b));
                } else {
                    string = getString(R$string.cloudpay_exchange_month_package, strM67741b);
                }
            } else if (this.f17070W1 != null) {
                string = getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, this.f17063P1.getGrade().getGradeName(), strM67741b));
            } else {
                string = getString(R$string.package_info_capacity_package, strM67741b);
            }
        } else if (m28589p1()) {
            if (this.f17070W1 != null) {
                string = getString(R$string.cloudpay_parenthesis, getString(R$string.auto_pay_and_date, this.f17063P1.getGrade().getGradeName(), strM67741b));
            } else {
                string = getString(R$string.cloudpay_monthly_expire_upd, strM67741b);
            }
        } else if (this.f17070W1 != null) {
            string = getString(R$string.cloudpay_parenthesis, getString(R$string.valid_until, this.f17063P1.getGrade().getGradeName(), strM67741b));
        } else {
            string = getString(R$string.package_info_capacity_package, strM67741b);
        }
        Long capacity = this.f17063P1.getCapacity();
        if (this.f17070W1 != null) {
            capacity = Long.valueOf(capacity.longValue() + this.f17070W1.getCapacity());
        }
        String string2 = getString(R$string.cloudpay_package_urse_space_detail, C0223k.m1524g(this, capacity.longValue()), string);
        SpannableString spannableString = new SpannableString(string2);
        try {
            int iIndexOf = string2.indexOf(string);
            spannableString.setSpan(new ForegroundColorSpan(getColor(R$color.emui_functional_red)), iIndexOf, string.length() + iIndexOf, 33);
        } catch (IndexOutOfBoundsException e10) {
            C1442a.m8289e("ExchangeCloudCardActivity", "showDetailView error: " + e10.toString());
        }
        this.f17089y1.setText(spannableString);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: d4 */
    public void mo22829d4(Intent intent) throws JSONException {
        if (intent == null) {
            C1442a.m8291w("ExchangeCloudCardActivity", "payResult data is null.");
            m23505K5();
            m22786N3(4002);
            m22751C4("failed_by_data_null");
            return;
        }
        try {
            int intExtra = intent.getIntExtra("returnCode", -1);
            C1442a.m8290i("ExchangeCloudCardActivity", "payResult resultCode = " + intExtra);
            C11060c c11060c = this.f21448i;
            if (c11060c != null) {
                c11060c.m66635A(intent.getStringExtra("errMsg"));
                this.f21448i.m66665u("114_" + intExtra);
            }
            String stringExtra = intent.getStringExtra("withholdID");
            m22819a4(stringExtra);
            if (intExtra != -1) {
                if (intExtra == 0) {
                    mo20372m3(intent, stringExtra);
                    return;
                }
                if (intExtra != 30005 && intExtra != 30006) {
                    if (intExtra == 30031 || intExtra == 30032) {
                        m22751C4("pay_result_hwpay_callback_result_" + intExtra);
                        Toast.makeText(this, getString(com.huawei.cloud.pay.R$string.cloudpay_subscribe_later_try_again), 1).show();
                        m23505K5();
                        return;
                    }
                    if (intExtra != 30099 && intExtra != 907135005) {
                        switch (intExtra) {
                            case 30000:
                                m22849m4();
                                m23505K5();
                                return;
                            case PayStatusCodes.PAY_STATE_PARAM_ERROR /* 30001 */:
                                break;
                            case PayStatusCodes.PAY_STATE_TIME_OUT /* 30002 */:
                                m22751C4("pay_result_hwpay_callback_result_" + intExtra);
                                m22786N3(PayStatusCodes.PAY_STATE_TIME_OUT);
                                m23505K5();
                                return;
                            default:
                                switch (intExtra) {
                                    case PayStatusCodes.PRODUCT_NOT_EXIST /* 40001 */:
                                    case PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED /* 40002 */:
                                    case PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION /* 40003 */:
                                        break;
                                    default:
                                        m22751C4("pay_result_hwpay_callback_result_" + intExtra);
                                        m22786N3(4002);
                                        m23505K5();
                                        break;
                                }
                                return;
                        }
                    }
                }
            }
            m23505K5();
            m22786N3(4002);
            m22751C4("pay_result_hwpay_callback_result_" + intExtra);
        } catch (RuntimeException e10) {
            m22786N3(4002);
            m23505K5();
            m22751C4("pay_result_hwpay_callback_result_" + e10.getMessage());
            C1442a.m8290i("ExchangeCloudCardActivity", "payResult err = " + e10.getMessage());
        }
    }

    /* renamed from: f6 */
    public final void m23518f6() {
        String strM67763g = C11293p.m67763g(this.f21452m);
        CloudSpace cloudSpace = this.f17070W1;
        String productName = cloudSpace != null ? cloudSpace.getProductName() : "";
        if (!TextUtils.isEmpty(productName)) {
            if (C11293p.m67774r(this.f21452m)) {
                strM67763g = C11293p.m67766j(this.f21452m);
            } else {
                strM67763g = strM67763g + " + " + productName;
            }
        }
        this.f17075k1.setText(strM67763g);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: g5 */
    public void mo19474g5() {
        this.f17055H1.setVisibility(0);
        this.f17056I1.setVisibility(8);
        this.f17072h1.setVisibility(8);
        this.f17052E1.setVisibility(8);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f17066S1);
        arrayList.add(this.f17072h1);
        arrayList.add(this.f17052E1);
        return arrayList;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: h5 */
    public void mo19476h5() {
        C1442a.m8290i("ExchangeCloudCardActivity", "showMain");
        mo19479s5();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k3 */
    public void mo22844k3(int i10) {
        super.mo22844k3(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: k5 */
    public void mo19477k5() {
        C1442a.m8289e("ExchangeCloudCardActivity", "showNodata");
        this.f17055H1.setVisibility(8);
        this.f17056I1.setVisibility(0);
        this.f17072h1.setVisibility(8);
        this.f17052E1.setVisibility(8);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l3 */
    public void mo22846l3(Object obj) {
        OrderResult orderResult = (OrderResult) obj;
        String status = orderResult.getStatus();
        if ("Valid".equals(status)) {
            this.f21448i.m66668x("1");
            C13622a.m81968n(this, this.f21448i);
            m28583a1();
            m23519m6(orderResult.getIsAutoPay(), orderResult.getEndTime());
            C1442a.m8288d("ExchangeCloudCardActivity", "dealNotifySuccess, card get notify success, backup frequency is " + this.f16562i0);
            C11296s.m67818h0(this, orderResult.getGradeRights(), this.f16562i0);
            m22816Z3();
            C1399b.m8034o().m8053t(false);
            C13108a.m78878b(this).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
            return;
        }
        C1442a.m8291w("ExchangeCloudCardActivity", "dealNotifySuccess status = " + status);
        m23505K5();
        if ("Initial".equals(status)) {
            m22786N3(4);
            m22751C4("failed_by_get_notify_still_initial");
        } else if ("Invalid".equals(status)) {
            m22786N3(4002);
            m22751C4("failed_by_get_notify_invalid");
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: l5 */
    public void mo19478l5() {
    }

    /* renamed from: m6 */
    public final void m23519m6(int i10, long j10) {
        this.f17055H1.setVisibility(8);
        this.f17056I1.setVisibility(8);
        this.f17072h1.setVisibility(8);
        this.f17052E1.setVisibility(0);
        if (getActionBar() != null) {
            getActionBar().setTitle(R$string.cloudpay_upgrade_storage);
        }
        EstimateResp estimateResp = this.f17063P1;
        long jLongValue = estimateResp != null ? estimateResp.getCapacity().longValue() : 0L;
        if (1 == i10) {
            C1442a.m8290i("ExchangeCloudCardActivity", "showExchangedView AUTOPAY_MONTH.");
            String strM1157C0 = C0209d.m1157C0(C0223k.m1524g(this, this.f21452m.getBaseCapacity() + jLongValue));
            if (this.f17070W1 != null) {
                this.f17053F1.setText(getString(R$string.card_num_next, strM1157C0, this.f17063P1.getGrade().getGradeName(), C11290m.m67741b(this, j10)));
            } else {
                this.f17053F1.setText(getString(R$string.cloudpay_card_exchanged_month_hint, strM1157C0, C11290m.m67741b(this, j10)));
            }
        } else {
            C1442a.m8290i("ExchangeCloudCardActivity", "showExchangedView Fixed Time.");
            if (this.f17070W1 != null) {
                this.f17053F1.setText(getString(R$string.card_num_valid, C0223k.m1524g(this, this.f21452m.getBaseCapacity() + jLongValue), this.f17063P1.getGrade().getGradeName(), C11290m.m67741b(this, j10)));
            } else {
                this.f17053F1.setText(getString(R$string.cloudpay_card_exchanged_hint, C0223k.m1524g(this, this.f21452m.getBaseCapacity() + jLongValue), C11290m.m67741b(this, j10)));
            }
        }
        m23516a6();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) throws JSONException {
        C1442a.m8290i("ExchangeCloudCardActivity", "onActivityResult requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 == 10001 || i10 == 10007) {
            mo22829d4(intent);
        } else if (i10 == 10013) {
            mo22790P3(intent);
        } else {
            C1442a.m8291w("ExchangeCloudCardActivity", "onActivityResult invalid requestCode");
            m23505K5();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        if (compoundButton.getId() == R$id.estimate_rule_checkbox) {
            m23495d6(z10);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.card_submit != id2) {
            if (R$id.card_ok_btn == id2) {
                m23511T5();
                return;
            } else {
                if (R$id.layout_nodata == id2) {
                    mo19460T3();
                    return;
                }
                return;
            }
        }
        if (!C11296s.m67786J(this)) {
            C1442a.m8288d("ExchangeCloudCardActivity", "card_submit createCard no network!");
            m22786N3(4004);
        } else {
            if (C0209d.m1226Y0()) {
                C1442a.m8291w("ExchangeCloudCardActivity", "card_submit click too fast");
                return;
            }
            m28579M1(getString(R$string.cloudpay_card_exchanging));
            if (C11296s.m67798V()) {
                C9158a.m57503F().m57551p(this.f17071X1, this.f17058K1, m23507M5(), C11296s.m67834r(), 2);
            } else {
                C9158a.m57503F().m57551p(this.f17071X1, this.f17058K1, m23507M5(), C11296s.m67834r(), 1);
            }
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70866t1(this, this.f17051D1);
        C11842p.m70866t1(this, this.f17054G1);
        m23498h6();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C1442a.m8290i("ExchangeCloudCardActivity", "onCreate");
        setContentView(R$layout.exchange_cloud_card_layout);
        m23492Y5();
        m28587n1();
        mo23770l1();
        mo19460T3();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity, com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: r3 */
    public void mo22868r3(int i10) {
        C1442a.m8290i("ExchangeCloudCardActivity", "dealQuerySubOrderStatusFail code = " + i10);
        m22751C4("failed_by_sub_order_query_exception_" + i10);
        m22786N3(i10);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s3 */
    public void mo22871s3(Object obj) {
        if (obj == null || !(obj instanceof QuerySubOrderStatusResp)) {
            C1442a.m8291w("ExchangeCloudCardActivity", "dealQuerySubOrderStatusSuccess object is null.");
            m23505K5();
            m22786N3(4002);
            m22751C4("failed_by_sign_check_failed");
            return;
        }
        QuerySubOrderStatusResp querySubOrderStatusResp = (QuerySubOrderStatusResp) obj;
        this.f21448i.m66668x("1");
        C13622a.m81968n(this, this.f21448i);
        m28583a1();
        m23519m6(1, querySubOrderStatusResp.getEndTime());
        C1442a.m8288d("ExchangeCloudCardActivity", "sendPaySuccessBroadcast, card get notify success, backup frequency is " + this.f16562i0);
        C11296s.m67818h0(this, querySubOrderStatusResp.getGradeRights(), this.f16562i0);
        m22816Z3();
        C1399b.m8034o().m8053t(false);
        C13108a.m78878b(this).m78881d(new Intent("com.huawei.hicloud.intent.action.ACTION_START_SPACE_USING_TRACK_REPROT_IMMEDIATELY"));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity
    /* renamed from: s5 */
    public void mo19479s5() {
        if (this.f21452m == null) {
            C1442a.m8291w("ExchangeCloudCardActivity", "showView() user is null.");
            return;
        }
        if (this.f16538V == null) {
            C1442a.m8291w("ExchangeCloudCardActivity", "showView() params is null.");
        } else if (this.f17063P1 == null) {
            C1442a.m8291w("ExchangeCloudCardActivity", "showView() estimateResp is null.");
        } else {
            C1442a.m8290i("ExchangeCloudCardActivity", "showView()");
            m23499i6();
        }
    }
}
