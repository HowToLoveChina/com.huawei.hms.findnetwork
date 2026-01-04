package com.huawei.android.hicloud.p088ui.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;
import ca.C1398a;
import ca.C1403f;
import com.huawei.android.hicloud.complexutil.C2783d;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.utils.C4308a;
import com.huawei.android.hicloud.utils.WebViewManager;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.messagecenter.manager.MessageCenterManager;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.constants.RecommendCardConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.GuideH5ReportUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hicloud.sync.R$string;
import com.huawei.hidisk.common.util.javautil.StringUtil;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.phone.hwcolumnlayout.widget.HwColumnLinearLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import je.C10797k0;
import je.C10804r;
import p015ak.C0209d;
import p015ak.C0213f;
import p336he.C10151b;
import p373iu.C10620h;
import p391jb.C10772e;
import p399jk.AbstractC10896a;
import p424kb.C11024a;
import p429kk.C11058a;
import p450le.C11273b;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p651t8.C12998f;
import p684un.C13227f;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;
import sm.C12817a;

/* loaded from: classes3.dex */
public class GuideWebViewActivity extends HiCloudBaseWebViewActivity implements WebViewManager.WebViewManagerCallback {

    /* renamed from: q0 */
    public static C10804r f14889q0;

    /* renamed from: a0 */
    public ValueCallback<Uri[]> f14890a0;

    /* renamed from: b0 */
    public C10797k0 f14891b0;

    /* renamed from: c0 */
    public Toast f14892c0;

    /* renamed from: l0 */
    public boolean f14901l0;

    /* renamed from: o0 */
    public TextView f14904o0;

    /* renamed from: p0 */
    public View f14905p0;

    /* renamed from: d0 */
    public Long f14893d0 = 0L;

    /* renamed from: e0 */
    public String f14894e0 = "";

    /* renamed from: f0 */
    public String f14895f0 = "";

    /* renamed from: g0 */
    public String f14896g0 = "";

    /* renamed from: h0 */
    public String f14897h0 = "";

    /* renamed from: i0 */
    public int f14898i0 = -1;

    /* renamed from: j0 */
    public String f14899j0 = "";

    /* renamed from: k0 */
    public String f14900k0 = "";

    /* renamed from: m0 */
    public String f14902m0 = "hicloud://cloudDrive/startWeb?path=OperationWebViewActivity&url=";

    /* renamed from: n0 */
    public Handler f14903n0 = new HandlerC3311b();

    /* renamed from: com.huawei.android.hicloud.ui.activity.GuideWebViewActivity$a */
    public class C3310a extends WebViewManager {
        public C3310a(WebView webView, String[] strArr, Activity activity, String str, Handler handler, Handler handler2, int i10, WebViewManager.WebViewManagerCallback webViewManagerCallback) {
            super(webView, strArr, activity, str, handler, handler2, i10, webViewManagerCallback);
        }

        @Override // com.huawei.android.hicloud.utils.WebViewManager
        @JavascriptInterface
        public void finishWebview() throws InterruptedException {
            String strM68794b = m68794b();
            if (C11829c.m70583i(strM68794b, GuideWebViewActivity.this.f14930T, "finishWebview")) {
                C1398a.m8015h();
            } else {
                C11839m.m70687e("GuideWebViewActivity", "finishWebview, url is invalid");
                GuideWebViewActivity.this.f14891b0.m65707p(C11829c.m70560a0(strM68794b), Arrays.toString(GuideWebViewActivity.this.f14930T));
            }
        }

        @Override // com.huawei.android.hicloud.utils.WebViewManager
        @JavascriptInterface
        public int getActionBarHeight() {
            return super.getActionBarHeight() + super.getStatusBarHeight();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GuideWebViewActivity$b */
    public class HandlerC3311b extends Handler {
        public HandlerC3311b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            C11839m.m70688i("GuideWebViewActivity", "WebViewManager H5Msg.What: " + message.what);
            int i10 = message.what;
            if (i10 == 100) {
                Bundle data = message.getData();
                if (data != null) {
                    C4308a.m25905d(data.getString("javascript"), GuideWebViewActivity.this.f14938q);
                }
                return;
            }
            if (i10 == 1003) {
                GuideWebViewActivity.this.m20605w2(message.obj);
                return;
            }
            if (i10 == 1010) {
                Object obj = message.obj;
                if (obj instanceof Bundle) {
                    C4308a.m25905d(((Bundle) obj).getString("javascript"), GuideWebViewActivity.this.f14938q);
                    return;
                }
                return;
            }
            if (i10 == 111) {
                C11842p.m70710A0(GuideWebViewActivity.this, ((Boolean) message.obj).booleanValue());
                GuideWebViewActivity guideWebViewActivity = GuideWebViewActivity.this;
                C11842p.m70736I1(guideWebViewActivity.f14938q, C11842p.m70789a0(guideWebViewActivity));
                return;
            }
            if (i10 == 112) {
                GuideWebViewActivity.this.m20607y2();
                return;
            }
            switch (i10) {
                case 103:
                    GuideWebViewActivity.this.m20606x2();
                    GuideWebViewActivity.this.finish();
                    break;
                case 104:
                    Bundle data2 = message.getData();
                    if (data2 != null) {
                        GuideWebViewActivity.this.f14928R = data2.getBoolean("exit_flag", false);
                        break;
                    }
                    break;
                case 105:
                    GuideWebViewActivity.this.m20588C2(message);
                    break;
            }
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.GuideWebViewActivity$c */
    public class C3312c extends C12817a {
        public C3312c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!C11829c.m70580h(str, GuideWebViewActivity.this.f14930T)) {
                C11839m.m70687e("GuideWebViewActivity", "onPageStarted check url host invalid, return");
                GuideWebViewActivity guideWebViewActivity = GuideWebViewActivity.this;
                guideWebViewActivity.mo20592U1(C11829c.m70560a0(guideWebViewActivity.f14947z), Arrays.toString(GuideWebViewActivity.this.f14930T));
                GuideWebViewActivity.this.mo20596f2();
                return;
            }
            GuideWebViewActivity guideWebViewActivity2 = GuideWebViewActivity.this;
            if (guideWebViewActivity2.m20617T1(guideWebViewActivity2.f14947z) || GuideWebViewActivity.this.f14938q == null) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                C11839m.m70687e("GuideWebViewActivity", "onPageStarted url is invalid");
                GuideWebViewActivity.this.f14938q.m53595d(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            C11839m.m70688i("GuideWebViewActivity", "onReceivedError error.getDescription(): " + ((Object) webResourceError.getDescription()) + " error.getErrorCode():" + webResourceError.getErrorCode());
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_FAIL, "onReceivedError");
            GuideWebViewActivity.this.finish();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            C11839m.m70688i("GuideWebViewActivity", "onReceivedHttpError errorResponse.getStatusCode(): " + webResourceResponse.getStatusCode() + "  errorResponse.getData(): " + webResourceResponse.getData());
            if (!webResourceRequest.isForMainFrame()) {
                C11839m.m70688i("GuideWebViewActivity", "onReceivedHttpError !request.isForMainFrame()");
                return;
            }
            int statusCode = webResourceResponse.getStatusCode();
            C11839m.m70688i("GuideWebViewActivity", "onReceivedHttpError httpCode: " + statusCode);
            GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_FAIL, "onReceivedHttpError_httpCode: " + statusCode);
            GuideWebViewActivity.this.finish();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C11839m.m70688i("GuideWebViewActivity", "onReceivedSslError");
            try {
                C10620h.m65082a(sslErrorHandler, sslError, GuideWebViewActivity.this);
                GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_FAIL, "onReceivedSslError");
            } catch (Exception e10) {
                C11839m.m70687e("GuideWebViewActivity", "MyWebViewClient onReceivedSslError exception : " + e10.getMessage());
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C11829c.m70580h(str, GuideWebViewActivity.this.f14930T)) {
                C11839m.m70687e("GuideWebViewActivity", "shouldOverrideUrlLoading check url host invalid, return");
                GuideWebViewActivity guideWebViewActivity = GuideWebViewActivity.this;
                guideWebViewActivity.mo20592U1(C11829c.m70560a0(guideWebViewActivity.f14947z), Arrays.toString(GuideWebViewActivity.this.f14930T));
                GuideWebViewActivity.this.mo20596f2();
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                C11839m.m70687e("GuideWebViewActivity", "shouldOverrideUrlLoading, url is empty");
                return false;
            }
            if (webView == null) {
                C11839m.m70687e("GuideWebViewActivity", "shouldOverrideUrlLoading, view is null");
                return false;
            }
            if (str.startsWith("https") || str.startsWith("http")) {
                C11839m.m70687e("GuideWebViewActivity", "shouldOverrideUrlLoading, url is illegal");
                return false;
            }
            GuideWebViewActivity.m20585v2(GuideWebViewActivity.this, str);
            return true;
        }

        public /* synthetic */ C3312c(GuideWebViewActivity guideWebViewActivity, C3310a c3310a) {
            this();
        }
    }

    /* renamed from: B1 */
    private void m20575B1() {
        ActionBar actionBar = getActionBar();
        if (actionBar == null) {
            C11839m.m70688i("GuideWebViewActivity", "getActionBar is empty");
        } else {
            actionBar.hide();
        }
    }

    /* renamed from: B2 */
    public static void m20576B2() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            NotifyLogger.m29914e("GuideWebViewActivity", "showAppNotInstallToast, context is null");
        } else {
            Toast.makeText(contextM1377a.getApplicationContext(), contextM1377a.getString(R$string.no_app_toast), 0).show();
        }
    }

    /* renamed from: t2 */
    public static C10804r m20584t2() {
        return f14889q0;
    }

    /* renamed from: v2 */
    public static void m20585v2(Activity activity, String str) {
        if (activity == null || str == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            if (MessageCenterManager.getInstance().checkIntentAvailable(intent)) {
                activity.startActivityIfNeeded(intent, -1);
            } else {
                C11839m.m70687e("GuideWebViewActivity", "jumpThirdApp error, can't resolve intent");
                m20576B2();
            }
        } catch (ActivityNotFoundException unused) {
            AbstractC10896a.m65886e("GuideWebViewActivity", "ActivityNotFoundException:" + str);
        }
    }

    /* renamed from: z2 */
    public static void m20586z2(C10804r c10804r) {
        f14889q0 = c10804r;
    }

    /* renamed from: A2 */
    public final void m20587A2() throws Throwable {
        try {
            C10772e c10772eM66464a = new C11024a().m66464a();
            if (c10772eM66464a != null) {
                String strM65600b = c10772eM66464a.m65600b();
                C13452e.m80781L().m80801E2(true);
                C13452e.m80781L().m80805F2(strM65600b);
            } else {
                C11839m.m70688i("GuideWebViewActivity", "config is null");
            }
        } catch (Exception e10) {
            C11839m.m70687e("GuideWebViewActivity", "setSpOtherOperationShow Exception: " + e10.getMessage());
        }
    }

    /* renamed from: C2 */
    public final void m20588C2(Message message) {
        Bundle data = message.getData();
        if (data != null) {
            String string = data.getString("toast_content");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            m20589D2(string);
        }
    }

    /* renamed from: D2 */
    public final void m20589D2(CharSequence charSequence) {
        C11839m.m70686d("GuideWebViewActivity", "show H5 toast, text: " + ((Object) charSequence));
        if (this.f14892c0 != null) {
            C11839m.m70686d("GuideWebViewActivity", "mH5Toast is not null, text: " + ((Object) charSequence));
            this.f14892c0.cancel();
        }
        Toast toastMakeText = Toast.makeText(this, charSequence, 1);
        this.f14892c0 = toastMakeText;
        toastMakeText.show();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Q1 */
    public void mo20590Q1() {
        super.mo20590Q1();
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(getIntent());
        this.f14929S = hiCloudSafeIntent.m29113i("fromwhichactivity", "");
        this.f14894e0 = hiCloudSafeIntent.getStringExtra(NotifyConstants.Keys.NOTIFY_TYPE);
        this.f14895f0 = hiCloudSafeIntent.getStringExtra(NotifyConstants.Keys.NOTIFY_URI);
        this.f14897h0 = hiCloudSafeIntent.getStringExtra("packageId");
        this.f14898i0 = hiCloudSafeIntent.getIntExtra("notifyAction", -1);
        this.f14896g0 = hiCloudSafeIntent.getStringExtra("activeUri");
        this.f14899j0 = hiCloudSafeIntent.getStringExtra("gradeCode");
        this.f14900k0 = hiCloudSafeIntent.getStringExtra("expireTime");
        this.f14901l0 = hiCloudSafeIntent.getBooleanExtra("fromMessage", false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: S1 */
    public boolean mo20591S1() {
        C11839m.m70688i("GuideWebViewActivity", "initView");
        setContentView(R$layout.activity_guid_webview);
        this.f14904o0 = (TextView) C12809f.m76829b(this, R$id.cloudpay_loading_text);
        this.f14938q = (SafeWebView) C12809f.m76829b(this, R$id.guid_webview);
        this.f14905p0 = C12809f.m76829b(this, R$id.guide_webview_progress);
        this.f14944w = (HwColumnLinearLayout) C12809f.m76829b(this, R$id.guid_loading);
        if (this.f14938q != null) {
            return true;
        }
        C11839m.m70687e("GuideWebViewActivity", "initView is null");
        finish();
        return false;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: U1 */
    public void mo20592U1(String str, String str2) {
        super.mo20592U1(str, str2);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Z1 */
    public void mo20593Z1(SafeWebView safeWebView) {
        WebSettings settings = safeWebView.getSettings();
        if (settings == null) {
            C11839m.m70687e("GuideWebViewActivity", "WebSettings is null.");
            return;
        }
        String userAgentString = settings.getUserAgentString();
        String str = "HiDiskCloudService/com.huawei.hidisk/16.0.0.300 (Linux; HarmonyOS " + Build.VERSION.RELEASE + "; " + Build.MODEL + "; " + C11829c.f54755a + ") HMS/2.6.3.306 (10055832)";
        safeWebView.getSettings().setUserAgentString(userAgentString + "; " + str);
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
        if (!TextUtils.isEmpty(this.f14895f0) && !TextUtils.isEmpty(this.f14894e0)) {
            if ("web".equals(this.f14894e0)) {
                this.f14895f0 = "notifyType=" + this.f14894e0 + "?notifyUri=" + (this.f14902m0 + this.f14895f0);
            } else {
                this.f14895f0 = "notifyType=" + this.f14894e0 + "?notifyUri=" + this.f14895f0;
            }
        }
        this.f14938q.addJavascriptInterface(new C3310a(this.f14938q, this.f14930T, this, this.f14895f0, this.f14903n0, null, 1, this), "hidiskOperation");
        this.f14938q.setWebChromeClient(new WebChromeClient() { // from class: com.huawei.android.hicloud.ui.activity.GuideWebViewActivity.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                super.onProgressChanged(webView, i10);
                GuideWebViewActivity.this.mo20613M1();
                C11839m.m70688i("GuideWebViewActivity", "onProgressChanged Progress:" + i10);
                if (GuideWebViewActivity.this.f14905p0 == null || GuideWebViewActivity.this.f14904o0 == null) {
                    C11839m.m70689w("GuideWebViewActivity", "onProgressChanged ! notchFitLoadView != null && mTextView !=null");
                    return;
                }
                if (i10 != 100) {
                    GuideWebViewActivity.this.f14905p0.setVisibility(0);
                    GuideWebViewActivity.this.f14904o0.setVisibility(0);
                } else {
                    GuideWebViewActivity.this.f14905p0.setVisibility(8);
                    GuideWebViewActivity.this.f14904o0.setVisibility(8);
                    GuideWebViewActivity.this.mo13327n1();
                    GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_OK, "onProgressChanged_100%");
                }
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                C11839m.m70688i("GuideWebViewActivity", "onReceivedTitle  title： " + str);
                super.onReceivedTitle(webView, str);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                C11839m.m70688i("GuideWebViewActivity", "onShowFileChooser");
                try {
                    GuideWebViewActivity.this.f14890a0 = valueCallback;
                    Intent intent = new Intent("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                    intent.addCategory("android.intent.category.OPENABLE");
                    GuideWebViewActivity.this.startActivityForResult(intent, 1);
                    return true;
                } catch (Exception e10) {
                    C11839m.m70687e("GuideWebViewActivity", "onShowFileChooser exception: " + e10.toString());
                    return false;
                }
            }
        });
        this.f14938q.m53596e(new C3312c(this, null), false);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: e2 */
    public void mo20595e2() {
        finish();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: f2 */
    public void mo20596f2() {
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null) {
            safeWebView.setVisibility(8);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public void finish() {
        if (m20584t2() != null) {
            String stringExtra = new SafeIntent(getIntent()).getStringExtra("main_dialog_id");
            if (stringExtra == null) {
                stringExtra = "GUIDE_H5_WEBVIEW_DAILOG";
            }
            if ("GET_SPACE_H5_PAY_RESULT_DIALOG".equals(stringExtra)) {
                stringExtra = "GET_SPACE_OK_H5_DIALOG";
            }
            m20584t2().m65759f(stringExtra);
        }
        super.finish();
        overridePendingTransition(0, 0);
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
    public void mo20598h2() throws Throwable {
        super.mo20598h2();
        if (StringUtil.isBlank(this.f14912B)) {
            C11839m.m70687e("GuideWebViewActivity", "startLoadWebView url is invalid.");
            mo20596f2();
            return;
        }
        mo20597g2();
        C11839m.m70688i("GuideWebViewActivity", "loadUrl start queryH5OkNum: " + this.f14898i0);
        int i10 = this.f14898i0;
        if (i10 == 0) {
            this.f14912B = m20600p2("packageId", this.f14897h0);
        } else if (i10 == 1) {
            this.f14912B = m20600p2("dlappurl", this.f14896g0);
        }
        String str = this.f14899j0;
        if (str != null && !str.isEmpty()) {
            this.f14912B = m20603s2("gradeCode", this.f14899j0);
        }
        String str2 = this.f14900k0;
        if (str2 != null && !str2.isEmpty()) {
            this.f14912B = m20603s2("expireTime", this.f14900k0);
        }
        this.f14893d0 = Long.valueOf(System.currentTimeMillis());
        this.f14938q.loadUrl(this.f14912B);
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_DATA, "mUrl=" + this.f14912B);
        C11273b.m67661p(this, NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_LOAD_DATA, new LinkedHashMap());
        GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(NotifyConstants.H5GuideDialog.GUIDE_WEBVIEW_DIALOG_ID, String.valueOf(this.f14898i0));
        if (this.f14898i0 == 2) {
            m20587A2();
        }
        C11839m.m70688i("GuideWebViewActivity", "loadUrl end");
    }

    @Override // com.huawei.android.hicloud.utils.WebViewManager.WebViewManagerCallback
    /* renamed from: i */
    public void mo20599i(boolean z10) {
        C11839m.m70688i("GuideWebViewActivity", "setExitFlag = " + z10);
        this.f14928R = z10;
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.UIActivity
    /* renamed from: n1 */
    public void mo13327n1() {
        ActionBar actionBar = getActionBar();
        if (this.f14912B == null || this.f14938q == null || actionBar == null || TextUtils.isEmpty(this.f14935Y)) {
            return;
        }
        m20621Y1(actionBar);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        C11839m.m70688i("GuideWebViewActivity", "onActivityResult resultCode: " + i11);
        if (i10 == 1) {
            Uri data = (intent == null || i11 != -1) ? null : new SafeIntent(intent).getData();
            if (this.f14890a0 != null) {
                if (data == null || !C11829c.m70544S0(data)) {
                    this.f14890a0.onReceiveValue(null);
                } else {
                    this.f14890a0.onReceiveValue(new Uri[]{data});
                }
                this.f14890a0 = null;
            }
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f14928R) {
            m20615O1();
            return;
        }
        m20606x2();
        super.onBackPressed();
        if (m20584t2() != null) {
            m20584t2().m65759f("GUIDE_H5_WEBVIEW_DAILOG");
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
    public void onCreate(Bundle bundle) throws Throwable {
        super.onCreate(bundle);
        C11839m.m70688i("GuideWebViewActivity", "onCreate");
        C1398a.m8005E(this);
        C1398a.m8007G(this.f14903n0);
        C1403f.m8066n().m8080N(this.f14903n0);
        if (!mo20591S1()) {
            C11839m.m70687e("GuideWebViewActivity", "isInit return");
            return;
        }
        m20604u2();
        C13227f.m79492i1().m79598v0(this, new SafeIntent(getIntent()), "GuideWebViewActivity");
        m20601q2();
        this.f14891b0 = new C10797k0(C11058a.m66627b("07030"));
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ValueCallback<Uri[]> valueCallback = this.f14890a0;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.f14890a0 = null;
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f14928R = false;
        setIntent(intent);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            m20606x2();
            if (this.f14928R) {
                m20615O1();
                return true;
            }
            NotchFitLinearLayout notchFitLinearLayout = this.f14941t;
            if ((notchFitLinearLayout != null && notchFitLinearLayout.getVisibility() == 0) || this.f14944w.getVisibility() == 0) {
                this.f14944w.setVisibility(8);
                this.f14938q.setVisibility(8);
                finish();
                return true;
            }
            SafeWebView safeWebView = this.f14938q;
            if (safeWebView != null && safeWebView.canGoBack()) {
                this.f14938q.goBack();
                return true;
            }
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        C11839m.m70688i("GuideWebViewActivity", "onResume");
        if (C4308a.m25904c(this, this.f14938q, getClass().getName())) {
            C4308a.m25912k(this.f14938q);
            C4308a.m25913l(this.f14938q);
        }
    }

    /* renamed from: p2 */
    public final String m20600p2(String str, String str2) {
        if (!m20617T1(this.f14912B)) {
            C11839m.m70687e("GuideWebViewActivity", "url is invalid");
            return null;
        }
        int i10 = this.f14898i0;
        if (i10 != 0 && i10 != 1) {
            return null;
        }
        if (this.f14912B.contains(Constants.QUESTION_STR)) {
            return this.f14912B + "&" + str + "=" + str2;
        }
        return this.f14912B + Constants.QUESTION_STR + str + "=" + str2;
    }

    /* renamed from: q2 */
    public final void m20601q2() {
        C11839m.m70688i("GuideWebViewActivity", "isFromHomepage: " + this.f14929S);
        if (!this.f14929S.equals(RecommendCardConstants.Entrance.HOMEPAGE)) {
            C11839m.m70688i("GuideWebViewActivity", "QueryGuideH5Task Activity no value or not MainActivity, need to show");
            return;
        }
        C11839m.m70688i("GuideWebViewActivity", "CommonUtil.isMainActivityDestroy : " + C11829c.m70514F0());
        if (!C11829c.m70514F0()) {
            C11839m.m70688i("GuideWebViewActivity", "QueryGuideH5Task MainActivity live, need to show");
            return;
        }
        C11829c.m70606p1(false);
        C11839m.m70688i("GuideWebViewActivity", "QueryGuideH5Task MainActivity destroy, no need to show");
        finish();
    }

    /* renamed from: r2 */
    public final boolean m20602r2() throws Throwable {
        boolean z10;
        C10772e c10772eM66464a;
        boolean zM80881Z = C13452e.m80781L().m80881Z();
        String strM80886a0 = C13452e.m80781L().m80886a0();
        try {
            c10772eM66464a = new C11024a().m66464a();
        } catch (Exception e10) {
            e = e10;
            z10 = false;
        }
        if (c10772eM66464a == null) {
            C11839m.m70688i("GuideWebViewActivity", "config is null");
            return false;
        }
        String strM65600b = c10772eM66464a.m65600b();
        long j10 = Long.parseLong(strM80886a0);
        long j11 = Long.parseLong(strM65600b);
        z10 = j10 >= j11;
        try {
            C11839m.m70688i("GuideWebViewActivity", "old version: " + j10 + ", new version: " + j11);
        } catch (Exception e11) {
            e = e11;
            C11839m.m70688i("GuideWebViewActivity", "checkIsOtherOprationShown formate change Exception:" + e.getMessage());
            if (zM80881Z) {
            }
        }
        return !zM80881Z && z10;
    }

    /* renamed from: s2 */
    public final String m20603s2(String str, String str2) {
        if (!m20617T1(this.f14912B)) {
            C11839m.m70687e("GuideWebViewActivity", "url is invalid");
            return null;
        }
        if (this.f14912B.contains(Constants.QUESTION_STR)) {
            return this.f14912B + "&" + str + "=" + str2;
        }
        return this.f14912B + Constants.QUESTION_STR + str + "=" + str2;
    }

    /* renamed from: u2 */
    public void m20604u2() throws Throwable {
        mo20590Q1();
        if (!C11829c.m70580h(this.f14947z, this.f14930T)) {
            C11839m.m70687e("GuideWebViewActivity", "check url host invalid, return");
            mo20592U1(C11829c.m70560a0(this.f14947z), Arrays.toString(this.f14930T));
            finish();
            return;
        }
        if (C2783d.m16159m() != 0 && C2783d.m16159m() != -1) {
            C11839m.m70687e("GuideWebViewActivity", "current page is not home, return");
            finish();
            return;
        }
        boolean zM20602r2 = m20602r2();
        if (this.f14898i0 == 2 && zM20602r2 && !this.f14901l0) {
            C11839m.m70687e("GuideWebViewActivity", "other operation has already shown, return");
            finish();
            return;
        }
        this.f14912B = mo20620X1();
        mo20594b2();
        m20575B1();
        if (C0209d.m1333z1(this)) {
            C11839m.m70688i("GuideWebViewActivity", "startLoadWebView in");
            mo20598h2();
        } else {
            C11839m.m70688i("GuideWebViewActivity", "showNetDisconnectView in ");
            mo20595e2();
        }
        C11839m.m70688i("GuideWebViewActivity", "AndroidBug5497Workaround in ");
        new C10151b(this, R$id.bc_check_mark_view);
    }

    /* renamed from: w2 */
    public final void m20605w2(Object obj) {
        C11839m.m70688i("GuideWebViewActivity", "post activity dispatch success");
        if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("questId");
            String string2 = bundle.getString(CommonConstant.ReqAccessTokenParam.STATE_LABEL);
            int i10 = bundle.getInt("count");
            int i11 = bundle.getInt("taskAwards");
            if (C0209d.m1245d1(this, GuideWebViewActivity.class.getName())) {
                C4308a.m25915n(string, string2, i10, i11, this.f14938q);
                C12998f.m78034R().m78085V0("", "", 0, 0);
            }
        }
    }

    /* renamed from: x2 */
    public final void m20606x2() {
        if (this.f14893d0.longValue() == 0) {
            C11839m.m70688i("GuideWebViewActivity", "startTime null");
            return;
        }
        if (TextUtils.isEmpty(this.f14912B)) {
            C11839m.m70688i("GuideWebViewActivity", "mUrl null ");
            return;
        }
        Uri.parse(this.f14912B);
        LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
        linkedHashMapM79499C.put("page_time", Long.valueOf(System.currentTimeMillis() - this.f14893d0.longValue()));
        linkedHashMapM79499C.put("page_url", this.f14912B);
        C13227f.m79492i1().m79591l0("h5_page_time", linkedHashMapM79499C);
        UBAAnalyze.m29958S("PVC", "h5_page_time", "3", "47", linkedHashMapM79499C);
        C11273b.m67661p(this, "h5_page_time", linkedHashMapM79499C);
    }

    /* renamed from: y2 */
    public void m20607y2() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (getActionBar() != null) {
            ActionBar actionBar = getActionBar();
            int i10 = R$color.pay_activity_harmony_bg;
            C11842p.m70842n1(actionBar, new ColorDrawable(getColor(i10)));
            getActionBar().setBackgroundDrawable(new ColorDrawable(getColor(i10)));
        }
    }
}
