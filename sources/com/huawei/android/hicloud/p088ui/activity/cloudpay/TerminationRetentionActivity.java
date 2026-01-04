package com.huawei.android.hicloud.p088ui.activity.cloudpay;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import ca.C1398a;
import com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity;
import com.huawei.android.hicloud.p088ui.extend.AutoStyleButtonAnnotation;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.uiextend.cloudpay.dialog.CancelSubscriptionDlg;
import com.huawei.android.hicloud.utils.C4308a;
import com.huawei.android.hicloud.utils.WebViewManager;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.cloud.pay.R$string;
import com.huawei.cloud.pay.model.CloudSpace;
import com.huawei.cloud.pay.model.MonthDetail;
import com.huawei.cloud.pay.model.TerminationRetentionData;
import com.huawei.cloud.pay.model.UserPackage;
import com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.bean.IapUnsubscribeRetention;
import com.huawei.hicloud.bean.RetentionH5Result;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import fk.C9721b;
import hu.C10344c;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0234s;
import p015ak.C0239x;
import p054cj.C1442a;
import p292fn.C9733f;
import p336he.C10151b;
import p336he.C10155f;
import p341hj.C10226f0;
import p371ik.C10527a;
import p373iu.C10620h;
import p429kk.C11058a;
import p429kk.C11060c;
import p450le.C11273b;
import p454lj.C11293p;
import p454lj.C11296s;
import p459lp.C11326d;
import p514o9.C11829c;
import p514o9.C11842p;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p681uj.C13195l;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import p709vj.InterfaceC13450c;
import p746wn.C13622a;
import sk.C12809f;
import sm.C12817a;
import uk.C13206d;

@AutoStyleButtonAnnotation
/* loaded from: classes3.dex */
public class TerminationRetentionActivity extends HiCloudBaseWebViewActivity implements WelfarePickAndCancelRenewalInterface, WebViewManager.WebViewManagerCallback {

    /* renamed from: a0 */
    public AlertDialog f17384a0;

    /* renamed from: b0 */
    public C11060c f17385b0;

    /* renamed from: c0 */
    public String f17386c0;

    /* renamed from: d0 */
    public String f17387d0;

    /* renamed from: e0 */
    public TerminationRetentionData f17388e0;

    /* renamed from: f0 */
    public IapUnsubscribeRetention f17389f0;

    /* renamed from: g0 */
    public ProgressDialog f17390g0;

    /* renamed from: h0 */
    public final C3650b f17391h0 = new C3650b(this);

    /* renamed from: i0 */
    public boolean f17392i0 = true;

    /* renamed from: j0 */
    public boolean f17393j0 = false;

    /* renamed from: k0 */
    public final Handler f17394k0 = new HandlerC3652d(this);

    /* renamed from: l0 */
    public final Handler f17395l0 = new HandlerC3651c(this);

    /* renamed from: m0 */
    public TextView f17396m0;

    /* renamed from: n0 */
    public View f17397n0;

    /* renamed from: o0 */
    public CloudSpace f17398o0;

    /* renamed from: p0 */
    public UserPackage f17399p0;

    /* renamed from: q0 */
    public String f17400q0;

    public class MyWebChromeClient extends WebChromeClient {
        private MyWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) throws IllegalAccessException, Resources.NotFoundException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            super.onProgressChanged(webView, i10);
            TerminationRetentionActivity.this.mo20613M1();
            C1442a.m8290i("TerminationRetentionActivity", "onProgressChanged Progress:" + i10);
            if (i10 != 100) {
                TerminationRetentionActivity.this.m23816a3();
                return;
            }
            C1442a.m8290i("TerminationRetentionActivity", "LoadH5 :isNewBm = " + C13452e.m80781L().m80887a1());
            TerminationRetentionActivity.this.m23797G2();
            TerminationRetentionActivity.this.mo13327n1();
            TerminationRetentionActivity.this.m23812W2(NotifyConstants.H5GuideDialog.CANCEL_SUB_WEB_VIEW_OK, "onProgressChanged_100%");
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            C1442a.m8290i("TerminationRetentionActivity", "onReceivedTitle  title： " + str);
            super.onReceivedTitle(webView, str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            C1442a.m8290i("TerminationRetentionActivity", "onShowFileChooser");
            return true;
        }

        public /* synthetic */ MyWebChromeClient(TerminationRetentionActivity terminationRetentionActivity, C3649a c3649a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.TerminationRetentionActivity$a */
    public class C3649a extends AbstractC12367d {
        public C3649a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            IapUnsubscribeRetention iapUnsubscribeRetentionM68047i = C11326d.m68047i();
            Message messageObtainMessage = TerminationRetentionActivity.this.f17394k0.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = iapUnsubscribeRetentionM68047i;
            TerminationRetentionActivity.this.f17394k0.sendMessage(messageObtainMessage);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.TerminationRetentionActivity$b */
    public static class C3650b implements InterfaceC13450c {

        /* renamed from: a */
        public final WeakReference<TerminationRetentionActivity> f17402a;

        public C3650b(TerminationRetentionActivity terminationRetentionActivity) {
            this.f17402a = new WeakReference<>(terminationRetentionActivity);
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: a */
        public void mo20330a(ErrorStatus errorStatus) {
            TerminationRetentionActivity terminationRetentionActivity = this.f17402a.get();
            if (m23817c(terminationRetentionActivity)) {
                C1442a.m8291w("TerminationRetentionActivity", "activity invalid");
                return;
            }
            if (errorStatus == null) {
                C1442a.m8291w("TerminationRetentionActivity", "errorStatus is null");
                terminationRetentionActivity.m23800J2();
                return;
            }
            int errorCode = errorStatus.getErrorCode();
            String errorReason = errorStatus.getErrorReason();
            if (errorCode == 3002) {
                terminationRetentionActivity.m23798H2();
            } else {
                terminationRetentionActivity.m23800J2();
            }
            C1442a.m8290i("TerminationRetentionActivity", "onError, error code = " + errorCode + ", error reason = " + errorReason);
        }

        @Override // p709vj.InterfaceC13450c
        /* renamed from: b */
        public void mo20331b() {
            TerminationRetentionActivity terminationRetentionActivity = this.f17402a.get();
            if (m23817c(terminationRetentionActivity)) {
                C1442a.m8291w("TerminationRetentionActivity", "activity invalid");
            } else if (C11296s.m67786J(terminationRetentionActivity)) {
                terminationRetentionActivity.m23799I2();
            } else {
                terminationRetentionActivity.m23803M2();
                Toast.makeText(terminationRetentionActivity, R$string.cloudpay_net_disconnect_alert, 0).show();
            }
        }

        /* renamed from: c */
        public final boolean m23817c(TerminationRetentionActivity terminationRetentionActivity) {
            return terminationRetentionActivity == null || terminationRetentionActivity.isFinishing();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.TerminationRetentionActivity$c */
    public static class HandlerC3651c extends Handler {

        /* renamed from: a */
        public final WeakReference<TerminationRetentionActivity> f17403a;

        public HandlerC3651c(TerminationRetentionActivity terminationRetentionActivity) {
            super(Looper.getMainLooper());
            this.f17403a = new WeakReference<>(terminationRetentionActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            super.handleMessage(message);
            TerminationRetentionActivity terminationRetentionActivity = this.f17403a.get();
            if (terminationRetentionActivity == null || terminationRetentionActivity.isFinishing()) {
                C1442a.m8291w("TerminationRetentionActivity", "activity invalid,what =  " + message.what);
                return;
            }
            int i10 = message.what;
            if (i10 == 100) {
                Bundle data = message.getData();
                if (data != null) {
                    C4308a.m25905d(data.getString("javascript"), terminationRetentionActivity.f14938q);
                    return;
                }
                return;
            }
            if (i10 == 103) {
                terminationRetentionActivity.retentionSuccessIAP();
                terminationRetentionActivity.m23810U2(1, "cancel_auto_renewal_result_h5_home_backup");
                return;
            }
            if (i10 == 104) {
                Bundle data2 = message.getData();
                if (data2 != null) {
                    terminationRetentionActivity.f14928R = data2.getBoolean("exit_flag", false);
                    return;
                }
                return;
            }
            if (i10 == 111) {
                C11842p.m70710A0(terminationRetentionActivity, ((Boolean) message.obj).booleanValue());
            } else {
                if (i10 != 112) {
                    return;
                }
                terminationRetentionActivity.m23814Y2();
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.TerminationRetentionActivity$d */
    public static class HandlerC3652d extends Handler {

        /* renamed from: a */
        public final WeakReference<TerminationRetentionActivity> f17404a;

        public HandlerC3652d(TerminationRetentionActivity terminationRetentionActivity) {
            super(Looper.getMainLooper());
            this.f17404a = new WeakReference<>(terminationRetentionActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            TerminationRetentionActivity terminationRetentionActivity = this.f17404a.get();
            if (terminationRetentionActivity == null || terminationRetentionActivity.isFinishing()) {
                C1442a.m8291w("TerminationRetentionActivity", "activity invalid,what =  " + message.what);
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                C1442a.m8290i("TerminationRetentionActivity", "MSG_GET_IAP_OM");
                terminationRetentionActivity.m23802L2(message.obj);
                return;
            }
            if (i10 == 7060) {
                C1442a.m8291w("TerminationRetentionActivity", "IAP_TERMINATION_RETENTION_GET_INFO_ERR");
                terminationRetentionActivity.m23801K2(message.obj);
            } else {
                if (i10 == 7061) {
                    C1442a.m8290i("TerminationRetentionActivity", "IAP_TERMINATION_RETENTION_GET_INFO_SUC");
                    terminationRetentionActivity.m23801K2(message.obj);
                    return;
                }
                C1442a.m8291w("TerminationRetentionActivity", "handler, invalid what = " + message.what);
                terminationRetentionActivity.m23801K2(message.obj);
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.TerminationRetentionActivity$e */
    public class C3653e extends C12817a {
        public C3653e() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            C1442a.m8290i("TerminationRetentionActivity", "onPageFinished end");
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            C1442a.m8288d("TerminationRetentionActivity", "onPageStarted: " + str + ",mIsUseMargin," + TerminationRetentionActivity.this.f14911A);
            if (!C11829c.m70580h(str, TerminationRetentionActivity.this.f14930T)) {
                C1442a.m8291w("TerminationRetentionActivity", "onPageStarted check url host invalid, return");
                TerminationRetentionActivity terminationRetentionActivity = TerminationRetentionActivity.this;
                terminationRetentionActivity.mo20592U1(C11829c.m70560a0(terminationRetentionActivity.f14912B), Arrays.toString(TerminationRetentionActivity.this.f14930T));
                TerminationRetentionActivity.this.mo20596f2();
                return;
            }
            TerminationRetentionActivity terminationRetentionActivity2 = TerminationRetentionActivity.this;
            if (terminationRetentionActivity2.m20617T1(terminationRetentionActivity2.f14912B) || TerminationRetentionActivity.this.f14938q == null) {
                C1442a.m8290i("TerminationRetentionActivity", "onPageStarted");
                super.onPageStarted(webView, str, bitmap);
            } else {
                C1442a.m8291w("TerminationRetentionActivity", "onPageStarted url is invalid");
                TerminationRetentionActivity.this.mo20596f2();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            C1442a.m8290i("TerminationRetentionActivity", "onReceivedError :des: " + ((Object) webResourceError.getDescription()) + " ; code:" + webResourceError.getErrorCode());
            TerminationRetentionActivity.this.m23812W2(NotifyConstants.H5GuideDialog.CANCEL_SUB_WEB_VIEW_LOAD_FAIL, "onReceivedError");
            TerminationRetentionActivity.this.mo20596f2();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            C1442a.m8290i("TerminationRetentionActivity", "onReceivedHttpError statusCode: " + webResourceResponse.getStatusCode() + "  data: " + webResourceResponse.getData() + " ; isEnableJs = " + TerminationRetentionActivity.this.f14922L);
            if (!webResourceRequest.isForMainFrame()) {
                C1442a.m8291w("TerminationRetentionActivity", "onReceivedHttpError  is not from mainFrame");
                return;
            }
            int statusCode = webResourceResponse.getStatusCode();
            C1442a.m8290i("TerminationRetentionActivity", "onReceivedHttpError httpCode: " + statusCode);
            TerminationRetentionActivity.this.m23812W2(NotifyConstants.H5GuideDialog.CANCEL_SUB_WEB_VIEW_LOAD_FAIL, "onReceivedHttpError_httpCode: " + statusCode);
            TerminationRetentionActivity.this.mo20596f2();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C1442a.m8290i("TerminationRetentionActivity", "onReceivedSslError");
            try {
                C10620h.m65082a(sslErrorHandler, sslError, TerminationRetentionActivity.this);
                TerminationRetentionActivity.this.m23812W2(NotifyConstants.H5GuideDialog.CANCEL_SUB_WEB_VIEW_LOAD_FAIL, "onReceivedSslError");
            } catch (Exception e10) {
                C1442a.m8289e("TerminationRetentionActivity", "MyWebViewClient onReceivedSslError exception : " + e10.getMessage());
                sslErrorHandler.cancel();
            }
            TerminationRetentionActivity.this.mo20596f2();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C11829c.m70580h(str, TerminationRetentionActivity.this.f14930T)) {
                C1442a.m8291w("TerminationRetentionActivity", "shouldOverrideUrlLoading check url host invalid, return");
                TerminationRetentionActivity terminationRetentionActivity = TerminationRetentionActivity.this;
                terminationRetentionActivity.mo20592U1(C11829c.m70560a0(terminationRetentionActivity.f14947z), Arrays.toString(TerminationRetentionActivity.this.f14930T));
                TerminationRetentionActivity.this.mo20596f2();
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                C1442a.m8291w("TerminationRetentionActivity", "shouldOverrideUrlLoading, url is empty");
                TerminationRetentionActivity.this.mo20596f2();
                return false;
            }
            if (webView == null) {
                C1442a.m8291w("TerminationRetentionActivity", "shouldOverrideUrlLoading, view is null");
                TerminationRetentionActivity.this.mo20596f2();
                return false;
            }
            if (!str.startsWith("https") && !str.startsWith("http")) {
                return true;
            }
            TerminationRetentionActivity.this.mo20596f2();
            C1442a.m8291w("TerminationRetentionActivity", "shouldOverrideUrlLoading, url is illegal");
            return false;
        }

        public /* synthetic */ C3653e(TerminationRetentionActivity terminationRetentionActivity, C3649a c3649a) {
            this();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.cloudpay.TerminationRetentionActivity$f */
    public class C3654f extends WebViewManager {
        public C3654f(WebView webView, String[] strArr, Activity activity, String str, Handler handler, Handler handler2, int i10, WebViewManager.WebViewManagerCallback webViewManagerCallback) {
            super(webView, strArr, activity, str, handler, handler2, i10, webViewManagerCallback);
        }

        @JavascriptInterface
        public void dialogConfirm(String str, String str2) {
            C1442a.m8290i("TerminationRetentionActivity", "dialogConfirm:" + str + " ; " + str2 + " ; oldTransactionId = " + str);
            RetentionH5Result retentionH5Result = (RetentionH5Result) C10527a.m64629g(str2, RetentionH5Result.class);
            if (retentionH5Result == null || retentionH5Result.getCode() != 0) {
                TerminationRetentionActivity.this.retentionSuccessIAP();
                TerminationRetentionActivity.this.m23810U2(1, "cancel_auto_renewal_result_confirm_h5_negative");
            } else {
                TerminationRetentionActivity.this.checkConfirmCancelPassword();
                TerminationRetentionActivity.this.m23810U2(0, "CLICK_CANCEL_AUTO_RENEWAL_CONFIRM_H5_POSITIVE_NEW");
            }
        }
    }

    /* renamed from: B1 */
    private void m23772B1() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C1442a.m8290i("TerminationRetentionActivity", "getActionBar is empty");
        } else {
            actionBar.hide();
        }
    }

    /* renamed from: D2 */
    private void m23775D2(String str) {
        this.f14912B = C0234s.m1623a(this.f14912B, str, C0234s.m1644v(this.f14947z, str, false));
    }

    /* renamed from: R2 */
    private void m23776R2() {
        try {
            mo20590Q1();
            this.f17400q0 = StringUtil.randomString();
            HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
            boolean booleanExtra = hiCloudSafeIntent.getBooleanExtra("fromIap", true);
            this.f17392i0 = booleanExtra;
            if (booleanExtra) {
                return;
            }
            Serializable serializableExtra = hiCloudSafeIntent.getSerializableExtra("user");
            UserPackage userPackage = serializableExtra instanceof UserPackage ? (UserPackage) serializableExtra : null;
            Serializable serializableExtra2 = hiCloudSafeIntent.getSerializableExtra("user_worry_free");
            if (serializableExtra2 instanceof UserPackage) {
                this.f17393j0 = true;
                userPackage = (UserPackage) serializableExtra2;
            }
            TerminationRetentionData terminationRetentionData = new TerminationRetentionData();
            this.f17388e0 = terminationRetentionData;
            terminationRetentionData.setFromIAP(false);
            this.f17388e0.setUserPackage(userPackage);
        } catch (Exception e10) {
            C1442a.m8289e("TerminationRetentionActivity", "initIntentData error " + e10.getMessage());
        }
    }

    /* renamed from: E2 */
    public final void m23795E2() {
        IapUnsubscribeRetention iapUnsubscribeRetention = this.f17389f0;
        if (iapUnsubscribeRetention == null || iapUnsubscribeRetention.getPasswordVerification() == 1) {
            C1442a.m8290i("TerminationRetentionActivity", "Begin password verification");
            C13195l.m79272J().m79324o(this, C13452e.m80781L().m80905e(), 8905, this.f17391h0);
        } else {
            C1442a.m8291w("TerminationRetentionActivity", "The obtained configuration indicates that no password verification is required, and the unsubscription process can proceed directly.");
            m23804N2(-1);
        }
    }

    /* renamed from: F2 */
    public final boolean m23796F2() {
        if (C9733f.m60705z().m60763v("businessTerminationRetention") != 1) {
            C1442a.m8291w("TerminationRetentionActivity", "onCreate, BUSINESS_TERMINATION_RETENTION switch is close.");
            return false;
        }
        if (!C13452e.m80781L().m80842P0()) {
            C1442a.m8289e("TerminationRetentionActivity", "onCreate is not Login");
            return false;
        }
        if (!C11296s.m67786J(this)) {
            C1442a.m8289e("TerminationRetentionActivity", "onCreate network is not ok.");
            return false;
        }
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("subscriptionId");
        this.f17386c0 = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            C1442a.m8291w("TerminationRetentionActivity", "onCreate subscriptionId is empty.");
            return false;
        }
        this.f17387d0 = C10344c.m63704b(safeIntent.getData(), "srcChannel");
        return true;
    }

    /* renamed from: G2 */
    public void m23797G2() {
        ProgressDialog progressDialog;
        if (isFinishing() || (progressDialog = this.f17390g0) == null || !progressDialog.isShowing()) {
            return;
        }
        this.f17390g0.dismiss();
        this.f17390g0 = null;
    }

    /* renamed from: H2 */
    public void m23798H2() {
        C1442a.m8290i("TerminationRetentionActivity", "dealCancel");
        reportEventByID("CANCEL_AUTO_RENEWAL_CHECK_PASSWORD_CANCEL", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        m23804N2(0);
    }

    /* renamed from: I2 */
    public void m23799I2() {
        C1442a.m8290i("TerminationRetentionActivity", "Password verification successful, ending retention and executing unsubscription process.");
        reportEventByID("CANCEL_AUTO_RENEWAL_CHECK_PASSWORD_SUCCESS", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        m23804N2(-1);
    }

    /* renamed from: J2 */
    public void m23800J2() {
        C1442a.m8290i("TerminationRetentionActivity", "dealErrStatusNull");
        reportEventByID("CANCEL_AUTO_RENEWAL_CHECK_PASSWORD_CANCEL", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        m23804N2(0);
    }

    /* renamed from: K2 */
    public final void m23801K2(Object obj) {
        C1442a.m8290i("TerminationRetentionActivity", "dealGetInfoSuccess");
        if (obj instanceof TerminationRetentionData) {
            TerminationRetentionData terminationRetentionData = (TerminationRetentionData) obj;
            this.f17388e0 = terminationRetentionData;
            terminationRetentionData.setSrcChannel(this.f17387d0);
            this.f17388e0.setFromIAP(true);
        }
        m23806P2();
    }

    /* renamed from: L2 */
    public final void m23802L2(Object obj) {
        IapUnsubscribeRetention iapUnsubscribeRetention;
        if (obj instanceof IapUnsubscribeRetention) {
            this.f17389f0 = (IapUnsubscribeRetention) obj;
        }
        if (mo20613M1()) {
            C1442a.m8290i("TerminationRetentionActivity", "dealGetOm:The network is not connected.");
            return;
        }
        if (this.f17388e0 == null && ((iapUnsubscribeRetention = this.f17389f0) == null || TextUtils.isEmpty(iapUnsubscribeRetention.getUrl()))) {
            C1442a.m8290i("TerminationRetentionActivity", "dealGetOm:retentionData and om is invalid");
            m23815Z2();
        } else if (m23807Q2()) {
            if (m23809T2()) {
                return;
            }
            mo20596f2();
        } else {
            C1442a.m8291w("TerminationRetentionActivity", "stop:isWorryFree = " + this.f17393j0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: M1 */
    public boolean mo20613M1() {
        if (C0209d.m1333z1(this)) {
            return false;
        }
        C1442a.m8291w("TerminationRetentionActivity", "net is not connected");
        Toast.makeText(this, R$string.cloudpay_net_disconnect_alert, 0).show();
        m23804N2(0);
        return true;
    }

    /* renamed from: M2 */
    public void m23803M2() {
        C1442a.m8290i("TerminationRetentionActivity", "dealNoNet");
        reportEventByID("cancel_auto_renewal_failed_by_check_password_no_net", C13230i.m79497A(C13452e.m80781L().m80971t0()));
        m23804N2(0);
    }

    /* renamed from: N2 */
    public void m23804N2(int i10) {
        setResult(i10);
        super.finish();
    }

    /* renamed from: O2 */
    public void m23805O2() {
        C1442a.m8290i("TerminationRetentionActivity", "getRetentionInfo");
        new C10226f0(this.f17385b0, this.f17394k0, this.f17386c0).m63381g();
        m23816a3();
    }

    /* renamed from: P2 */
    public void m23806P2() {
        m23816a3();
        C12515a.m75110o().m75172d(new C3649a());
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Q1 */
    public void mo20590Q1() {
        super.mo20590Q1();
        this.f14922L = true;
    }

    /* renamed from: Q2 */
    public final boolean m23807Q2() {
        this.f17398o0 = null;
        TerminationRetentionData terminationRetentionData = this.f17388e0;
        if (terminationRetentionData == null) {
            C1442a.m8291w("TerminationRetentionActivity", "getCloudSpace:retentionData is null");
            return true;
        }
        UserPackage userPackage = terminationRetentionData.getUserPackage();
        this.f17399p0 = userPackage;
        if (userPackage == null) {
            C1442a.m8291w("TerminationRetentionActivity", "getCloudSpace:user is null");
            return true;
        }
        if (this.f17392i0) {
            List<CloudSpace> effectivePackages = userPackage.getEffectivePackages();
            MonthDetail monthDetail = this.f17388e0.getMonthDetail();
            if (effectivePackages == null || effectivePackages.isEmpty() || monthDetail == null) {
                C1442a.m8291w("TerminationRetentionActivity", "getCloudSpace:cloudSpaceList or  monthDetail is null");
                return true;
            }
            for (CloudSpace cloudSpace : effectivePackages) {
                if (TextUtils.equals(cloudSpace.getId(), monthDetail.getCurPackageId())) {
                    this.f17398o0 = cloudSpace;
                    this.f17393j0 = cloudSpace.getScheme() == 2;
                }
            }
        } else if (this.f17393j0) {
            this.f17398o0 = C11293p.m67758b(userPackage);
        } else {
            this.f17398o0 = C11293p.m67757a(userPackage);
        }
        if (!this.f17393j0) {
            return true;
        }
        C1442a.m8291w("TerminationRetentionActivity", "getCloudSpace:The incremental package directly follows the exit process without the need for password verification.");
        m23810U2(0, "WORRY_FREE_PACKAGE_DIRECTLY_EXIT_NO_NEED_CHECK_PWD");
        m23804N2(-1);
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: S1 */
    public boolean mo20591S1() {
        C1442a.m8290i("TerminationRetentionActivity", "initView");
        this.f17396m0 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        this.f14938q = (SafeWebView) C12809f.m76829b(this, R$id.guid_webview);
        View viewM76829b = C12809f.m76829b(this, R$id.guide_webview_progress);
        this.f17397n0 = viewM76829b;
        viewM76829b.setVisibility(8);
        this.f17396m0.setVisibility(8);
        this.f14944w = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.guid_loading);
        mo20597g2();
        return true;
    }

    /* renamed from: S2 */
    public void m23808S2(String str) {
        C11060c c11060c = new C11060c();
        this.f17385b0 = c11060c;
        c11060c.m66636B(str);
        this.f17385b0.m66643I(C11058a.m66627b(str));
        this.f17385b0.m66637C("com.huawei.hidisk\u0001_cloudspace");
        this.f17385b0.m66670z("2.0");
    }

    /* renamed from: T2 */
    public final boolean m23809T2() {
        IapUnsubscribeRetention iapUnsubscribeRetention = this.f17389f0;
        if (iapUnsubscribeRetention == null || TextUtils.isEmpty(iapUnsubscribeRetention.getUrl())) {
            return false;
        }
        this.f14947z = this.f17389f0.getUrl();
        m20616R1();
        if (!C11829c.m70580h(this.f14947z, this.f14930T)) {
            C1442a.m8291w("TerminationRetentionActivity", "check url host invalid, return");
            mo20592U1(C11829c.m70560a0(this.f14947z), Arrays.toString(this.f14930T));
            return false;
        }
        this.f14912B = mo20620X1();
        mo20594b2();
        m23772B1();
        mo20598h2();
        C1442a.m8290i("TerminationRetentionActivity", "AndroidBug5497Workaround in ");
        new C10151b(this, R$id.bc_check_mark_view);
        return true;
    }

    /* renamed from: U2 */
    public final void m23810U2(int i10, String str) {
        try {
            LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
            CloudSpace cloudSpace = this.f17398o0;
            if (cloudSpace != null) {
                linkedHashMapM79497A.put("effective_package_id", cloudSpace.getId());
                linkedHashMapM79497A.put("effective_capacity", String.valueOf(this.f17398o0.getCapacity()));
            }
            linkedHashMapM79497A.put("cancel_auto_renewal_confirm_type", "NO_WELFARE");
            linkedHashMapM79497A.put("cancel_auto_renewal_src_channel", this.f17387d0);
            linkedHashMapM79497A.put("cancel_auto_renewal_result", String.valueOf(i10));
            linkedHashMapM79497A.put("cancel_auto_renewal_result_description", str);
            C13227f.m79492i1().m79567R("UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_RESULT_NEW", linkedHashMapM79497A);
            UBAAnalyze.m29947H("CKC", "UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_RESULT_NEW", linkedHashMapM79497A);
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06011"), "06011", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B("UNIFORM_CLOUDPAY_CLICK_CANCEL_AUTO_RENEWAL_RESULT_NEW");
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(this, c11060cM66626a, linkedHashMapM79497A);
        } catch (Exception e10) {
            C1442a.m8289e("TerminationRetentionActivity", "reportCancelAutoRenewalResult" + i10 + ", error occur:" + e10.getMessage());
        }
    }

    /* renamed from: V2 */
    public final void m23811V2(String str, String str2) {
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            linkedHashMap.put(str, str2);
            C13227f.m79492i1().m79567R(str, linkedHashMap);
            UBAAnalyze.m29947H("PVC", str, linkedHashMap);
        } catch (Exception e10) {
            C1442a.m8289e("TerminationRetentionActivity", "reportBI exception:" + e10);
        }
    }

    /* renamed from: W2 */
    public final void m23812W2(String str, String str2) {
        try {
            HashMap map = new HashMap();
            map.put(NotifyConstants.NotificationReport.KEY_EVENT_NAME, str);
            map.put("result", str2);
            map.put(NotifyConstants.NotificationReport.MAIN_PROCESS_ID, C0239x.m1671c().m1674d());
            C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("07073"), "07073", C13452e.m80781L().m80971t0());
            c11060cM66626a.m66636B(NotifyConstants.NotificationReport.OPERATION_NAME_H5_CANCEL_SUBSCRIPTION_OPERATION);
            c11060cM66626a.m66665u("0");
            C13622a.m81969o(C0213f.m1377a(), c11060cM66626a, map);
            m23811V2(str, str2);
        } catch (Exception e10) {
            C1442a.m8289e("TerminationRetentionActivity", "reportOperation exception:" + e10);
        }
    }

    /* renamed from: X2 */
    public final void m23813X2(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null) {
            try {
                linkedHashMap = C13230i.m79497A(C13452e.m80781L().m80971t0());
            } catch (Exception e10) {
                C1442a.m8289e("TerminationRetentionActivity", "reportClickCancelAutoRenewal error occur:" + e10.getMessage());
                return;
            }
        }
        linkedHashMap.put("cancel_auto_renewal_src_channel", this.f17387d0);
        C13227f.m79492i1().m79567R(str, linkedHashMap);
        UBAAnalyze.m29958S("PVC", str, "1", "32", linkedHashMap);
        C11060c c11060cM66626a = C11058a.m66626a(C11058a.m66627b("06011"), "06011", C13452e.m80781L().m80971t0());
        c11060cM66626a.m66636B(str);
        c11060cM66626a.m66665u("0");
        C13622a.m81969o(this, c11060cM66626a, linkedHashMap);
    }

    /* renamed from: Y2 */
    public void m23814Y2() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (getActionBar() != null) {
            ActionBar actionBar = getActionBar();
            int i10 = R$color.pay_activity_harmony_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            getActionBar().setBackgroundDrawable(new ColorDrawable(getColor(i10)));
        }
    }

    /* renamed from: Z2 */
    public final void m23815Z2() {
        m23797G2();
        if (this.f17384a0 == null) {
            this.f17384a0 = new CancelSubscriptionDlg(this, C10155f.m63293q(500L), this, this.f17399p0, this.f17398o0);
        }
        C1442a.m8290i("TerminationRetentionActivity", "showCancelRenewalConfirmDialog :isNewBm = " + C13452e.m80781L().m80887a1());
        this.f17384a0.setCanceledOnTouchOutside(false);
        this.f17384a0.show();
        reportEventByID("SHOW_CANCEL_AUTO_RENEWAL_CONFIRM_DIALOG", C13230i.m79497A(C13452e.m80781L().m80971t0()));
    }

    /* renamed from: a3 */
    public void m23816a3() {
        if (this.f17390g0 == null) {
            ProgressDialog progressDialog = new ProgressDialog(this);
            this.f17390g0 = progressDialog;
            progressDialog.setMessage(getString(R$string.cloudpay_loading));
            this.f17390g0.setCancelable(false);
        }
        if (this.f17390g0.isShowing()) {
            return;
        }
        this.f17390g0.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: b2 */
    public void mo20594b2() {
        super.mo20594b2();
        mo20593Z1(this.f14938q);
        String[] strArr = this.f14930T;
        if (strArr == null || strArr.length == 0) {
            this.f14938q.setWhitelistWithPath(new String[]{this.f14912B});
        } else {
            this.f14938q.setWhitelist(strArr);
        }
        this.f14938q.addJavascriptInterface(new C3654f(this.f14938q, this.f14930T, this, null, this.f17395l0, null, 6, this), "hidiskOperation");
        C3649a c3649a = null;
        this.f14938q.setWebChromeClient(new MyWebChromeClient(this, c3649a));
        this.f14938q.m53596e(new C3653e(this, c3649a), false);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void backPressEvent(String str) {
        C1442a.m8290i("TerminationRetentionActivity", "backPressEvent, eventId = " + str);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("cancel_auto_renewal_src_channel", this.f17387d0);
        m23813X2(str, linkedHashMapM79497A);
        m23804N2(0);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void cancelRenewal() {
        C1442a.m8290i("TerminationRetentionActivity", "cancelRenewal");
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void checkConfirmCancelPassword() {
        C1442a.m8290i("TerminationRetentionActivity", "checkConfirmCancelPassword");
        m23795E2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: f2 */
    public void mo20596f2() {
        super.mo20596f2();
        View view = this.f17397n0;
        if (view != null && this.f17396m0 != null) {
            view.setVisibility(8);
            this.f17396m0.setVisibility(8);
        }
        m23815Z2();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: g2 */
    public void mo20597g2() {
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(0);
            this.f14938q.setBackgroundColor(0);
            this.f14938q.getBackground().setAlpha(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: h2 */
    public void mo20598h2() {
        if (StringUtil.isBlank(this.f14912B)) {
            C1442a.m8291w("TerminationRetentionActivity", "startLoadWebView url is invalid.");
            mo20596f2();
            return;
        }
        this.f14912B = C13206d.m79403c(this.f14912B, "transactionId", this.f17400q0);
        m23775D2(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL);
        m23775D2(FaqConstants.FAQ_EMUI_LANGUAGE);
        this.f14938q.loadUrl(this.f14912B);
        m23812W2(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_DATA, "mUrl=" + this.f14912B);
        C11273b.m67661p(this, NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_DATA, new LinkedHashMap());
        C1442a.m8290i("TerminationRetentionActivity", "loadUrl end");
    }

    @Override // com.huawei.android.hicloud.utils.WebViewManager.WebViewManagerCallback
    /* renamed from: i */
    public void mo20599i(boolean z10) {
        C1442a.m8290i("TerminationRetentionActivity", "setExitFlag = " + z10);
        this.f14928R = z10;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 8905) {
            C13195l.m79272J().m79297M(this, this.f17391h0, i11, intent);
        } else if (i10 == 8801) {
            C13195l.m79272J().m79301Q(this, i10, i11, intent);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        C1442a.m8290i("TerminationRetentionActivity", "onBackPressed :" + this.f14928R);
        if (!this.f14928R) {
            super.onBackPressed();
        } else {
            m23810U2(1, "cancel_auto_renewal_result_backup_press");
            m23804N2(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14946y);
        C11842p.m70760Q1(this, this.f14943v);
        if (getActionBar() == null || !getActionBar().isShowing()) {
            return;
        }
        C11842p.m70710A0(this, C11842p.m70732H0(this));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1442a.m8290i("TerminationRetentionActivity", "onCreate start");
        setContentView(R$layout.activity_cancel_sub_webview);
        m23776R2();
        mo20591S1();
        m23808S2("06008");
        if (!this.f17392i0) {
            m23806P2();
        } else {
            if (!m23796F2()) {
                m23804N2(1);
                return;
            }
            m23805O2();
        }
        C1442a.m8290i("TerminationRetentionActivity", "onCreate end");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        C1442a.m8290i("TerminationRetentionActivity", "onDestroy");
        AlertDialog alertDialog = this.f17384a0;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f17384a0 = null;
        }
        m23797G2();
        this.f17394k0.removeCallbacksAndMessages(null);
        this.f17395l0.removeCallbacksAndMessages(null);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            C1442a.m8290i("TerminationRetentionActivity", "onOptionsItemSelected :" + this.f14928R);
            m23810U2(1, "cancel_auto_renewal_result_home_backup");
            if (this.f14928R) {
                m23804N2(0);
                return true;
            }
            NotchFitLinearLayout notchFitLinearLayout = this.f14941t;
            if ((notchFitLinearLayout != null && notchFitLinearLayout.getVisibility() == 0) || this.f14944w.getVisibility() == 0) {
                this.f14944w.setVisibility(8);
                this.f14938q.setVisibility(8);
                m23804N2(0);
                return true;
            }
            SafeWebView safeWebView = this.f14938q;
            if (safeWebView != null && safeWebView.canGoBack()) {
                this.f14938q.goBack();
                return true;
            }
            m23804N2(0);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String strM8022o = C1398a.m8022o();
        if (TextUtils.isEmpty(strM8022o)) {
            return;
        }
        if (isFinishing() || isDestroyed() || !C0209d.m1245d1(this, TerminationRetentionActivity.class.getName())) {
            C1442a.m8289e("TerminationRetentionActivity", "isFinishing()");
        } else {
            m20614N1(String.format(Locale.ENGLISH, "%s()", strM8022o));
        }
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void pickWelfare(String str) {
        C1442a.m8290i("TerminationRetentionActivity", "pickWelfare");
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportButtonPositiveClicked() {
        C1442a.m8290i("TerminationRetentionActivity", "reportButtonPositiveClicked");
        m23810U2(0, "CLICK_CANCEL_AUTO_RENEWAL_CONFIRM_DIALOG_POSITIVE_NEW");
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportCancelAutoRenewalResultFailed(String str) {
        C1442a.m8290i("TerminationRetentionActivity", "reportCancelAutoRenewalResultFailed");
        m23810U2(1, str);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportEventByID(String str, LinkedHashMap<String, String> linkedHashMap) {
        m23813X2(str, linkedHashMap);
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void reportWelfare(String str) {
        C1442a.m8290i("TerminationRetentionActivity", "reportWelfare");
    }

    @Override // com.huawei.cloud.pay.model.WelfarePickAndCancelRenewalInterface
    public void retentionSuccessIAP() {
        C1442a.m8290i("TerminationRetentionActivity", "retentionSuccessIAP");
        m23804N2(0);
    }
}
