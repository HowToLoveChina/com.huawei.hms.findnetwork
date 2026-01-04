package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.hicloud.p088ui.extend.AutoSizeButton;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.extend.NotchTopFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.CancelAutoRenewalConfirmDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.CancelAutoRenewalNewBusinessDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.WelfarePickDialog;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.WelfarePickSuccessDialog;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.GetClientUIConfigResp;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.Welfare;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import com.huawei.cloud.pay.p098ui.activity.BasePayActivity;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.openalliance.p169ad.constant.ErrorCode;
import dj.C9158a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import p015ak.C0209d;
import p015ak.C0234s;
import p054cj.C1442a;
import p336he.C10155f;
import p454lj.C11293p;
import p454lj.C11296s;
import p514o9.C11829c;
import p514o9.C11842p;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import sk.C12809f;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class CancelAutoRenewalActivity extends BasePayActivity implements View.OnClickListener, WelfarePickAndCancelRenewalInterface {

    /* renamed from: C */
    public NotchTopFitLinearLayout f16629C;

    /* renamed from: D */
    public NotchFitLinearLayout f16630D;

    /* renamed from: E */
    public View f16631E;

    /* renamed from: F */
    public View f16632F;

    /* renamed from: G */
    public AutoSizeButton f16633G;

    /* renamed from: H */
    public TextView f16634H;

    /* renamed from: I */
    public TextView f16635I;

    /* renamed from: J */
    public HandlerC3593b f16636J;

    /* renamed from: K */
    public AlertDialog f16637K;

    /* renamed from: L */
    public WelfarePickDialog f16638L;

    /* renamed from: M */
    public WelfarePickDialog f16639M;

    /* renamed from: N */
    public AlertDialog f16640N;

    /* renamed from: O */
    public boolean f16641O = false;

    /* renamed from: P */
    public String f16642P = "";

    /* renamed from: Q */
    public GetClientUIConfigResp f16643Q;

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CancelAutoRenewalActivity$a */
    public class DialogInterfaceOnClickListenerC3592a implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC3592a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (CancelAutoRenewalActivity.this.f16640N != null) {
                CancelAutoRenewalActivity.this.f16640N.dismiss();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.CancelAutoRenewalActivity$b */
    public class HandlerC3593b extends Handler {

        /* renamed from: a */
        public WeakReference<CancelAutoRenewalActivity> f16645a;

        public HandlerC3593b(CancelAutoRenewalActivity cancelAutoRenewalActivity) {
            this.f16645a = new WeakReference<>(cancelAutoRenewalActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CancelAutoRenewalActivity cancelAutoRenewalActivity = this.f16645a.get();
            if (cancelAutoRenewalActivity == null || cancelAutoRenewalActivity.isFinishing()) {
                C1442a.m8289e("CancelAutoRenewalActivity", " ManageMonthlyHandler error, CancelAutoRenewalActivity context is null.");
                return;
            }
            CancelAutoRenewalActivity.this.m28583a1();
            TerminationRetentionData terminationRetentionData = new TerminationRetentionData();
            terminationRetentionData.setUserPackage(CancelAutoRenewalActivity.this.f21452m);
            terminationRetentionData.setGetClientUIConfigResp(CancelAutoRenewalActivity.this.f16643Q);
            int i10 = message.what;
            if (i10 == 2019) {
                C1442a.m8288d("CancelAutoRenewalActivity", "ManageMonthlyHandler GET_MONTH_PAY_SUCCESS query success");
                CancelAutoRenewalActivity.this.f21448i.m66668x("1");
                C13622a.m81968n(cancelAutoRenewalActivity, cancelAutoRenewalActivity.f21448i);
                CancelAutoRenewalActivity.this.m23015f2("cancel_auto_renewal_success_by_cancel_month_pay_success_" + message.arg1);
                if (message.arg1 == 0) {
                    CancelAutoRenewalActivity.this.setResult(-1);
                    CancelAutoRenewalActivity.this.finish();
                }
                return;
            }
            if (i10 == 2119) {
                C1442a.m8288d("CancelAutoRenewalActivity", "ContinuousMonthlyHandler GET_MONTH_PAY_SUCCESS query failed");
                if (CancelAutoRenewalActivity.this.f16640N != null) {
                    CancelAutoRenewalActivity.this.f16640N.dismiss();
                    CancelAutoRenewalActivity.this.f16640N.setMessage(CancelAutoRenewalActivity.this.getString(R$string.cloudpay_small_problem_tips, Integer.valueOf(message.arg1)));
                    CancelAutoRenewalActivity.this.f16640N.show();
                }
                CancelAutoRenewalActivity.this.f21448i.m66668x("1");
                C13622a.m81968n(cancelAutoRenewalActivity, CancelAutoRenewalActivity.this.f21448i);
                CancelAutoRenewalActivity.this.reportCancelAutoRenewalResultFailed("cancel_auto_renewal_failed_by_cancel_month_pay_error_" + message.arg1 + "_" + message.obj.toString());
                return;
            }
            if (i10 == 2128) {
                String string = message.obj.toString();
                C1442a.m8288d("CancelAutoRenewalActivity", "QUERY_CONTINUOUS_MONTHLY_AGREEMENT_SUCCESS host = " + string);
                CancelAutoRenewalActivity.this.m23008a2(string);
                return;
            }
            switch (i10) {
                case 7052:
                    Welfare welfare = (Welfare) message.obj;
                    CancelAutoRenewalActivity cancelAutoRenewalActivity2 = CancelAutoRenewalActivity.this;
                    CancelAutoRenewalActivity cancelAutoRenewalActivity3 = CancelAutoRenewalActivity.this;
                    cancelAutoRenewalActivity2.f16638L = new WelfarePickDialog(cancelAutoRenewalActivity3, welfare, false, cancelAutoRenewalActivity3, terminationRetentionData);
                    CancelAutoRenewalActivity.this.f16638L.setCanceledOnTouchOutside(false);
                    CancelAutoRenewalActivity.this.f16638L.show();
                    CancelAutoRenewalActivity.this.f16642P = "HAVE_WELFARE_TO_PICK";
                    CancelAutoRenewalActivity.this.m23019i2("SHOW_WELFARE_PICK_DIALOG");
                    break;
                case 7053:
                    Welfare welfare2 = (Welfare) message.obj;
                    CancelAutoRenewalActivity cancelAutoRenewalActivity4 = CancelAutoRenewalActivity.this;
                    CancelAutoRenewalActivity cancelAutoRenewalActivity5 = CancelAutoRenewalActivity.this;
                    cancelAutoRenewalActivity4.f16639M = new WelfarePickDialog(cancelAutoRenewalActivity5, welfare2, true, cancelAutoRenewalActivity5, terminationRetentionData);
                    CancelAutoRenewalActivity.this.f16639M.setCanceledOnTouchOutside(false);
                    CancelAutoRenewalActivity.this.f16639M.show();
                    CancelAutoRenewalActivity.this.f16642P = "HAVE_PICKED_WELFARE";
                    CancelAutoRenewalActivity.this.m23019i2("SHOW_WELFARE_PICKED_DIALOG");
                    break;
                case 7054:
                    CancelAutoRenewalActivity.this.m23021k2();
                    break;
                case 7055:
                    Toast.makeText(cancelAutoRenewalActivity, R$string.cloudpay_server_error_later_try_again, 0).show();
                    break;
                case 7056:
                    Welfare welfare3 = (Welfare) message.obj;
                    CancelAutoRenewalActivity cancelAutoRenewalActivity6 = CancelAutoRenewalActivity.this;
                    WelfarePickSuccessDialog welfarePickSuccessDialog = new WelfarePickSuccessDialog(cancelAutoRenewalActivity6, welfare3, false, cancelAutoRenewalActivity6);
                    welfarePickSuccessDialog.setCanceledOnTouchOutside(false);
                    welfarePickSuccessDialog.show();
                    CancelAutoRenewalActivity.this.m23019i2("SHOW_PICK_WELFARE_SUCESS_DIALOG");
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    }

    /* renamed from: e2 */
    private void m23003e2(int i10, String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            UserPackage userPackage = this.f21452m;
            if (userPackage != null && C11293p.m67757a(userPackage) != null) {
                CloudSpace cloudSpaceM67758b = this.f16641O ? C11293p.m67758b(this.f21452m) : C11293p.m67757a(this.f21452m);
                if (cloudSpaceM67758b != null) {
                    m23006Y1(linkedHashMapM79497A, cloudSpaceM67758b);
                }
            }
            linkedHashMapM79497A.put("cancel_auto_renewal_confirm_type", this.f16642P);
            linkedHashMapM79497A.put("cancel_auto_renewal_result", String.valueOf(i10));
            linkedHashMapM79497A.put("cancel_auto_renewal_result_description", str);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_RESULT_NEW", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_RESULT_NEW", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_RESULT_NEW", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CancelAutoRenewalActivity", "reportCancelAutoRenewalResult" + i10 + ", error occur:" + e10.getMessage());
        }
    }

    /* renamed from: l2 */
    private void m23004l2() {
        this.f16632F.setVisibility(8);
        this.f16631E.setVisibility(0);
    }

    /* renamed from: m2 */
    private void m23005m2() {
        this.f16631E.setVisibility(8);
        this.f16632F.setVisibility(0);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: B1 */
    public void mo19444B1() {
        m28577K1(540, this.f16631E);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: C1 */
    public void mo19445C1() {
        m28577K1(472, this.f16631E);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: E1 */
    public void mo19447E1() {
        m28577K1(ErrorCode.ERROR_SIGTOOL_FAIL, this.f16631E);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: F1 */
    public void mo19448F1() {
        m28577K1(466, this.f16631E);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: G1 */
    public void mo19449G1() {
        m28577K1(472, this.f16631E);
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: H1 */
    public void mo19450H1() {
        m28576J1(this.f16631E);
    }

    /* renamed from: Y1 */
    public final void m23006Y1(LinkedHashMap<String, String> linkedHashMap, CloudSpace cloudSpace) {
        linkedHashMap.put("effective_package_id", cloudSpace.getId());
        linkedHashMap.put("effective_capacity", String.valueOf(cloudSpace.getCapacity()));
    }

    /* renamed from: Z1 */
    public int m23007Z1() {
        return R$layout.auto_renewal_cancel_layout;
    }

    /* renamed from: a2 */
    public final void m23008a2(String str) {
        if (TextUtils.isEmpty(str)) {
            C1442a.m8289e("CancelAutoRenewalActivity", "handleOpenContinuousMonthlyAgreement host is empty");
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str + "/payagreement?lang=" + C0234s.m1627e()));
        PackageManager packageManager = getPackageManager();
        if (packageManager == null || intent.resolveActivity(packageManager) == null) {
            return;
        }
        startActivity(intent);
    }

    /* renamed from: b2 */
    public final void m23009b2() {
        this.f16629C = (NotchTopFitLinearLayout) C12809f.m76829b(this, R$id.cancel_auto_renewal);
        this.f16630D = (NotchFitLinearLayout) C12809f.m76829b(this, R$id.notch_fit_monthly_layout);
        TextView textView = (TextView) C12809f.m76829b(this, R$id.auto_renewal_term_clickable_text);
        this.f16634H = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) C12809f.m76829b(this, R$id.cancel_auto_renewal_clickable_text);
        this.f16635I = textView2;
        textView2.setOnClickListener(this);
        this.f16631E = C12809f.m76829b(this, R$id.cancel_auto_renewal_main);
        AutoSizeButton autoSizeButton = (AutoSizeButton) C12809f.m76829b(this, R$id.set_no_net_btn);
        this.f16633G = autoSizeButton;
        C11842p.m70866t1(this, autoSizeButton);
        this.f16633G.setOnClickListener(this);
        this.f16632F = C12809f.m76829b(this, R$id.layout_nonetwork);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void backPressEvent(String str) {
        C1442a.m8290i("CancelAutoRenewalActivity", "backPressEvent, eventId = " + str);
        m28596z1(str, C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: c1 */
    public void mo23010c1() {
        reportCancelAutoRenewalResultFailed("cancel_auto_renewal_failed_by_cancel_check_password");
        m23019i2("CANCEL_AUTO_RENEWAL_CHECK_PASSWORD_CANCEL");
    }

    /* renamed from: c2 */
    public final void m23011c2() {
        C9158a.m57503F().m57527Y(this.f16636J);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void cancelRenewal() {
        checkConfirmCancelPassword();
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void checkConfirmCancelPassword() {
        m28582Z0();
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: d1 */
    public void mo22827d1() {
        m28588o1("06010");
        if (this.f16641O) {
            C9158a.m57503F().m57537e(this.f16636J, this.f21448i, true);
        } else {
            C9158a.m57503F().m57535d(this.f16636J, this.f21448i);
        }
        AlertDialog alertDialog = this.f16637K;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        m23019i2("CANCEL_AUTO_RENEWAL_CHECK_PASSWORD_SUCCESS");
        m28578L1();
    }

    /* renamed from: d2 */
    public final void m23012d2() {
        if (this.f16641O) {
            m23021k2();
        } else {
            m28588o1("06021");
            C9158a.m57503F().m57523U(this.f16636J, this.f21448i);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: e1 */
    public void mo23013e1() {
        C1442a.m8290i("CancelAutoRenewalActivity", "dealErrStatusNull");
        reportEventByID("CANCEL_AUTO_RENEWAL_CHECK_PASSWORD_CANCEL", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: f1 */
    public void mo23014f1() {
        reportCancelAutoRenewalResultFailed("cancel_auto_renewal_failed_by_check_password_no_net");
    }

    /* renamed from: f2 */
    public void m23015f2(String str) {
        m23003e2(0, str);
    }

    /* renamed from: g2 */
    public void m23016g2() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_CLICK_AUTO_RENEWAL_TERM", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLICK_AUTO_RENEWAL_TERM", "1", "32", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLICK_AUTO_RENEWAL_TERM", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CancelAutoRenewalActivity", "reportClickAutoRenewalTerm error occur:" + e10.getMessage());
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: h1 */
    public List<View> mo19475h1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f16629C);
        arrayList.add(this.f16630D);
        return arrayList;
    }

    /* renamed from: h2 */
    public void m23017h2() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_BUTTON", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_BUTTON", "1", "32", linkedHashMapM79497A);
            m28575A1("UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_BUTTON", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CancelAutoRenewalActivity", "reportClickCancelAutoRenewal error occur:" + e10.getMessage());
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity
    /* renamed from: i1 */
    public String mo23018i1() {
        return "CancelAutoRenewalActivity";
    }

    /* renamed from: i2 */
    public final void m23019i2(String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R(str, linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", str, "1", "32", linkedHashMapM79497A);
            m28575A1(str, linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CancelAutoRenewalActivity", "reportClickCancelAutoRenewal error occur:" + e10.getMessage());
        }
    }

    /* renamed from: j2 */
    public final void m23020j2() {
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        m28593u1(linkedHashMapM79497A);
        C13227f.m79492i1().m79567R("SHOW_CANCEL_AUTO_RENEWAL_CONFIRM_DIALOG", linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", "SHOW_CANCEL_AUTO_RENEWAL_CONFIRM_DIALOG", linkedHashMapM79497A);
    }

    /* renamed from: k2 */
    public final void m23021k2() {
        if (this.f16637K != null) {
            m23020j2();
            this.f16637K.setCanceledOnTouchOutside(false);
            this.f16637K.show();
            this.f16642P = "NO_WELFARE";
        }
    }

    /* renamed from: n2 */
    public final void m23022n2() {
        try {
            Intent intent = new Intent(this, (Class<?>) TerminationRetentionActivity.class);
            intent.putExtra("params", this.f16643Q);
            if (this.f16641O) {
                intent.putExtra("user_worry_free", this.f21452m);
            } else {
                intent.putExtra("user", this.f21452m);
            }
            intent.putExtra("fromIap", false);
            startActivityForResult(intent, 10017);
        } catch (Exception e10) {
            C1442a.m8289e("CancelAutoRenewalActivity", "startRetentionWeb error:" + e10);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10017 && i11 == -1) {
            mo22827d1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C0209d.m1226Y0()) {
            C1442a.m8291w("CancelAutoRenewalActivity", "click too fast");
            return;
        }
        if (R$id.set_no_net_btn == view.getId()) {
            mo19446D1();
            return;
        }
        if (R$id.auto_renewal_term_clickable_text == view.getId()) {
            m23016g2();
            if (C11296s.m67786J(this)) {
                m23011c2();
                return;
            } else {
                m23005m2();
                return;
            }
        }
        if (R$id.cancel_auto_renewal_clickable_text == view.getId()) {
            m23017h2();
            if (C11296s.m67786J(this)) {
                m23022n2();
            } else {
                reportCancelAutoRenewalResultFailed("cancel_auto_renewal_failed_by_no_net");
                m23005m2();
            }
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AutoSizeButton autoSizeButton = this.f16633G;
        if (autoSizeButton != null) {
            C11842p.m70874v1(this, autoSizeButton);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(m23007Z1());
        m23009b2();
        m28587n1();
        try {
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
            Serializable serializableExtra = hiCloudSafeIntent.getSerializableExtra("user");
            if (serializableExtra instanceof UserPackage) {
                this.f21452m = (UserPackage) serializableExtra;
            }
            Serializable serializableExtra2 = hiCloudSafeIntent.getSerializableExtra("user_worry_free");
            if (serializableExtra2 instanceof UserPackage) {
                this.f21452m = (UserPackage) serializableExtra2;
                this.f16641O = true;
            }
            Serializable serializableExtra3 = hiCloudSafeIntent.getSerializableExtra("params");
            if (serializableExtra3 instanceof GetClientUIConfigResp) {
                this.f16643Q = (GetClientUIConfigResp) serializableExtra3;
            }
        } catch (Exception e10) {
            C1442a.m8289e("CancelAutoRenewalActivity", "getUserParam error " + e10.getMessage());
        }
        this.f16636J = new HandlerC3593b(this);
        TerminationRetentionData terminationRetentionData = new TerminationRetentionData();
        terminationRetentionData.setFromIAP(false);
        terminationRetentionData.setUserPackage(this.f21452m);
        terminationRetentionData.setGetClientUIConfigResp(this.f16643Q);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this).create();
        this.f16640N = alertDialogCreate;
        C11829c.m70594l1(this, alertDialogCreate);
        this.f16640N.setMessage(getString(R$string.cloudpay_cancel_continuous_monthly_failed_msg));
        this.f16640N.setButton(-1, getString(R$string.cloudpay_huaweipay_sure), new DialogInterfaceOnClickListenerC3592a());
        if (bundle == null) {
            C1442a.m8290i("CancelAutoRenewalActivity", "onCreate savedInstanceState is null.");
        } else if (bundle.getBoolean("conform_dialog_state")) {
            m23012d2();
        }
        mo23770l1();
        if (C10155f.m63293q(500L)) {
            this.f16637K = new CancelAutoRenewalNewBusinessDialog(this, this, terminationRetentionData);
        } else {
            this.f16637K = new CancelAutoRenewalConfirmDialog(this, this, terminationRetentionData);
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        AlertDialog alertDialog = this.f16637K;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f16637K = null;
        }
        AlertDialog alertDialog2 = this.f16640N;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
            this.f16640N = null;
        }
        super.onDestroy();
        HandlerC3593b handlerC3593b = this.f16636J;
        if (handlerC3593b != null) {
            handlerC3593b.removeCallbacksAndMessages(null);
            this.f16636J = null;
        }
    }

    @Override // com.huawei.cloud.pay.p098ui.activity.BasePayActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        if (C11296s.m67786J(this)) {
            m23004l2();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        AlertDialog alertDialog = this.f16637K;
        if (alertDialog != null) {
            bundle.putBoolean("conform_dialog_state", alertDialog.isShowing());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void pickWelfare(String str) {
        WelfarePickDialog welfarePickDialog = this.f16638L;
        if (welfarePickDialog != null && welfarePickDialog.isShowing()) {
            this.f16638L.dismiss();
        }
        m23019i2("CLICK_PICK_WELFARE");
        m28588o1("06021");
        C9158a.m57503F().m57521S(this.f16636J, str, this.f21448i);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportButtonPositiveClicked() {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            linkedHashMapM79497A.put("cancel_auto_renewal_confirm_type", this.f16642P);
            m28593u1(linkedHashMapM79497A);
            C13227f.m79492i1().m79567R("CLICK_CANCEL_AUTO_RENEWAL_CONFIRM_DIALOG_POSITIVE_NEW", linkedHashMapM79497A);
            UBAAnalyze.m29958S("PVC", "CLICK_CANCEL_AUTO_RENEWAL_CONFIRM_DIALOG_POSITIVE_NEW", "4", "32", linkedHashMapM79497A);
            m28575A1("CLICK_CANCEL_AUTO_RENEWAL_CONFIRM_DIALOG_POSITIVE_NEW", linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("CancelAutoRenewalActivity", "reportButtonPositiveClicked error occur:" + e10.getMessage());
        }
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportCancelAutoRenewalResultFailed(String str) {
        m23003e2(1, str);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportEventByID(String str, LinkedHashMap<String, String> linkedHashMap) {
        m28596z1(str, linkedHashMap);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportWelfare(String str) {
        m23019i2(str);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void retentionSuccessIAP() {
    }
}
