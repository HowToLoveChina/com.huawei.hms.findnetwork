package com.huawei.android.hicloud.p088ui.activity;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.hicloud.p088ui.webview.ToolEcologyWapExternal;
import com.huawei.android.p073ds.R$id;
import com.huawei.hms.identity.AddressConstants;
import com.huawei.hwcloudjs.JsClientApi;
import com.huawei.hwcloudjs.service.hms.HmsCoreApi;
import com.huawei.secure.android.common.intent.SafeIntent;
import com.huawei.secure.android.common.webview.SafeWebView;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import je.C10794j;
import p015ak.C0209d;
import p336he.C10151b;
import p373iu.C10620h;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p684un.C13230i;
import sm.C12817a;
import tm.C13040c;

/* loaded from: classes3.dex */
public class ToolEcologyActivity extends HiCloudBaseWebViewActivity {

    /* renamed from: a0 */
    public String f16156a0;

    /* renamed from: b0 */
    public String f16157b0;

    /* renamed from: c0 */
    public ValueCallback<Uri[]> f16158c0;

    /* renamed from: d0 */
    public String f16159d0 = "";

    /* renamed from: e0 */
    public String f16160e0 = "";

    /* renamed from: f0 */
    public String f16161f0 = "";

    /* renamed from: g0 */
    public boolean f16162g0 = false;

    /* renamed from: com.huawei.android.hicloud.ui.activity.ToolEcologyActivity$2 */
    public class C35062 extends WebChromeClient {
        public C35062() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i10) {
            super.onProgressChanged(webView, i10);
            ToolEcologyActivity.this.mo20613M1();
            if (i10 == 100) {
                ToolEcologyActivity.this.m22360n2(true);
            } else {
                ToolEcologyActivity.this.m22360n2(false);
            }
            C11839m.m70689w("ToolEcologyActivity", "onProgressChanged mTitleBar is null. Progress:" + i10);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            C11839m.m70688i("ToolEcologyActivity", "onActivityResult onShowFileChooser");
            ToolEcologyActivity.this.f16158c0 = valueCallback;
            return ToolEcologyActivity.this.m22373g1();
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.ToolEcologyActivity$a */
    public class C3507a implements DownloadListener {
        public C3507a() {
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
            C11839m.m70688i("ToolEcologyActivity", "onDownloadStart");
            C10794j.m65681h(ToolEcologyActivity.this, str);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.ToolEcologyActivity$b */
    public class C3508b extends C12817a {
        public C3508b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (!C10794j.m65676c(str)) {
                C11839m.m70687e("ToolEcologyActivity", "onPageStarted check url host invalid, return");
                ToolEcologyActivity.this.mo20596f2();
                return;
            }
            NotchFitLinearLayout notchFitLinearLayout = ToolEcologyActivity.this.f14943v;
            if (notchFitLinearLayout != null && notchFitLinearLayout.getVisibility() == 0) {
                ToolEcologyActivity.this.f14943v.setVisibility(8);
            }
            ToolEcologyActivity toolEcologyActivity = ToolEcologyActivity.this;
            if (toolEcologyActivity.m20617T1(toolEcologyActivity.f16157b0) || ToolEcologyActivity.this.f14938q == null) {
                super.onPageStarted(webView, str, bitmap);
            } else {
                C11839m.m70687e("ToolEcologyActivity", "onPageStarted url is invalid");
                ToolEcologyActivity.this.f14938q.m53595d(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (!webResourceRequest.isForMainFrame()) {
                C11839m.m70687e("ToolEcologyActivity", "onReceivedHttpError is not main frame");
                return;
            }
            int statusCode = webResourceResponse.getStatusCode();
            String strM65677d = C10794j.m65677d(webResourceRequest.getUrl());
            C11839m.m70688i("ToolEcologyActivity", "onReceivedHttpError url is:" + strM65677d + ",errorCode is:" + statusCode);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(AddressConstants.Extras.EXTRA_NAME_ERR_CODE, Integer.valueOf(statusCode));
            linkedHashMap.put("errorUrl", strM65677d);
            C13230i.m79498B0(linkedHashMap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            C11839m.m70688i("ToolEcologyActivity", "onReceivedSslError");
            try {
                C10620h.m65082a(sslErrorHandler, sslError, ToolEcologyActivity.this);
            } catch (Exception e10) {
                C11839m.m70687e("ToolEcologyActivity", "MyWebViewClient onReceivedSslError exception : " + e10.getMessage());
                if (sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!C10794j.m65676c(str)) {
                C11839m.m70687e("ToolEcologyActivity", "shouldOverrideUrlLoading check url host invalid, invalid url =" + str);
                ToolEcologyActivity.this.mo20596f2();
                return false;
            }
            NotchFitLinearLayout notchFitLinearLayout = ToolEcologyActivity.this.f14943v;
            if (notchFitLinearLayout != null && notchFitLinearLayout.getVisibility() == 0) {
                ToolEcologyActivity.this.f14943v.setVisibility(8);
            }
            if (TextUtils.isEmpty(str)) {
                C11839m.m70687e("ToolEcologyActivity", "shouldOverrideUrlLoading, url is empty");
                return false;
            }
            if (webView == null) {
                C11839m.m70687e("ToolEcologyActivity", "shouldOverrideUrlLoading, view is null");
                return false;
            }
            if (str.startsWith("https") || str.startsWith("http")) {
                C11839m.m70687e("ToolEcologyActivity", "shouldOverrideUrlLoading, url is illegal");
                return false;
            }
            C10794j.m65686m(ToolEcologyActivity.this, str);
            return true;
        }

        public /* synthetic */ C3508b(ToolEcologyActivity toolEcologyActivity, C3507a c3507a) {
            this();
        }
    }

    static {
        JsClientApi.registerJsApi(HmsCoreApi.class);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Q1 */
    public void mo20590Q1() {
        super.mo20590Q1();
        SafeIntent safeIntent = new SafeIntent(getIntent());
        this.f16159d0 = safeIntent.getStringExtra("ecologyMode");
        this.f16160e0 = safeIntent.getStringExtra("ecologyType");
        this.f16161f0 = safeIntent.getStringExtra("url");
        this.f16162g0 = TextUtils.equals(this.f14916F, "0");
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: Z1 */
    public void mo20593Z1(SafeWebView safeWebView) {
        WebSettings settings = safeWebView.getSettings();
        if (settings == null) {
            C11839m.m70687e("ToolEcologyActivity", "WebSettings is null.");
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
        SafeWebView safeWebView = this.f14938q;
        safeWebView.addJavascriptInterface(new ToolEcologyWapExternal(safeWebView, this, null), "ToolEcology");
        this.f14938q.m53596e(new C3508b(this, null), false);
        this.f14938q.setDownloadListener(new C3507a());
        this.f14938q.setWebChromeClient(new WebChromeClient() { // from class: com.huawei.android.hicloud.ui.activity.ToolEcologyActivity.2
            public C35062() {
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i10) {
                super.onProgressChanged(webView, i10);
                ToolEcologyActivity.this.mo20613M1();
                if (i10 == 100) {
                    ToolEcologyActivity.this.m22360n2(true);
                } else {
                    ToolEcologyActivity.this.m22360n2(false);
                }
                C11839m.m70689w("ToolEcologyActivity", "onProgressChanged mTitleBar is null. Progress:" + i10);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                C11839m.m70688i("ToolEcologyActivity", "onActivityResult onShowFileChooser");
                ToolEcologyActivity.this.f16158c0 = valueCallback;
                return ToolEcologyActivity.this.m22373g1();
            }
        });
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity
    /* renamed from: h2 */
    public void mo20598h2() {
        super.mo20598h2();
        if (TextUtils.isEmpty(this.f16157b0)) {
            C11839m.m70687e("ToolEcologyActivity", "startLoadWebView url is invalid.");
            mo20596f2();
        } else {
            m22360n2(false);
            this.f14938q.loadUrl(this.f16157b0);
        }
    }

    /* renamed from: l2 */
    public void m22358l2() {
        mo20590Q1();
        if (!C10794j.m65676c(this.f14947z)) {
            C11839m.m70687e("ToolEcologyActivity", "check url host invalid, return");
            finish();
            return;
        }
        this.f16157b0 = mo20620X1();
        m22359m2();
        mo20594b2();
        if (C0209d.m1333z1(this)) {
            mo20598h2();
        } else {
            mo20595e2();
        }
        C11839m.m70688i("ToolEcologyActivity", "AndroidBug5497Workaround in ");
        new C10151b(this, R$id.bc_check_mark_view);
    }

    /* renamed from: m2 */
    public final void m22359m2() {
        String str;
        this.f16156a0 = JsClientApi.createApi(this.f14938q, new JsClientApi.SdkOpt.Builder().setShowAuthDlg(false).build());
        try {
            str = C13040c.m78609F().m78638b0() + "/rest.php";
        } catch (C9721b e10) {
            C11839m.m70687e("ToolEcologyActivity", "getPortalUrl error" + e10.getMessage());
            str = "";
        }
        JsClientApi.setJsUrl(str);
    }

    /* renamed from: n2 */
    public final void m22360n2(boolean z10) {
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView == null || this.f14944w == null) {
            C11839m.m70687e("ToolEcologyActivity", "mWebView or loadingLayout is null");
        } else if (z10) {
            safeWebView.setVisibility(0);
            this.f14944w.setVisibility(8);
        } else {
            safeWebView.setVisibility(4);
            this.f14944w.setVisibility(0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HMSTermsProcessBaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        Uri uri;
        super.onActivityResult(i10, i11, intent);
        try {
            if (i10 != 10043) {
                JsClientApi.handleActivityResult(i10, i11, intent);
                return;
            }
            if (this.f16158c0 == null) {
                C11839m.m70687e("ToolEcologyActivity", "onActivityResult mFilePathCallback is null.");
                return;
            }
            if (intent != null && intent.getClipData() != null) {
                ClipData clipData = intent.getClipData();
                if (clipData.getItemCount() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i12 = 0; i12 < clipData.getItemCount(); i12++) {
                        ClipData.Item itemAt = clipData.getItemAt(i12);
                        if (itemAt != null && (uri = itemAt.getUri()) != null) {
                            arrayList.add(uri);
                            C11839m.m70686d("ToolEcologyActivity", "onActivityResult uri: " + uri);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        C11839m.m70688i("ToolEcologyActivity", "onActivityResult choose count 0");
                        this.f16158c0.onReceiveValue(null);
                    } else {
                        C11839m.m70688i("ToolEcologyActivity", "onActivityResult multi choose count " + arrayList.size());
                        this.f16158c0.onReceiveValue((Uri[]) arrayList.toArray(new Uri[arrayList.size()]));
                    }
                }
                this.f16158c0 = null;
                return;
            }
            C11839m.m70687e("ToolEcologyActivity", "onActivityResult intent is null.");
            this.f16158c0.onReceiveValue(null);
            this.f16158c0 = null;
        } catch (Exception e10) {
            C11839m.m70687e("ToolEcologyActivity", "onActivityResult error: " + e10.getMessage());
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, android.app.Activity
    public void onBackPressed() {
        SafeWebView safeWebView = this.f14938q;
        if (safeWebView != null && safeWebView.canGoBack()) {
            this.f14938q.goBack();
            return;
        }
        C11839m.m70688i("ToolEcologyActivity", "toolMode = " + this.f16159d0 + ", ecologyType = " + this.f16160e0 + ", ecologyUrl = " + this.f16161f0 + ",isFromPush = " + this.f16162g0);
        if (this.f16162g0 && !TextUtils.isEmpty(this.f16159d0)) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.putExtra("ecologyMode", this.f16159d0);
            intent.putExtra("ecologyType", this.f16160e0);
            intent.putExtra("url", this.f16161f0);
            intent.setFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            startActivity(intent);
        }
        super.onBackPressed();
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C11842p.m70874v1(this, this.f14946y);
        C11842p.m70760Q1(this, this.f14943v);
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        if (mo20591S1()) {
            m22358l2();
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.activity.HiCloudBaseWebViewActivity, com.huawei.android.hicloud.p088ui.activity.BaseActivity, com.huawei.android.hicloud.p088ui.activity.UIActivity, com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        JsClientApi.destroyApi(this.f16156a0);
    }

    @Override // com.huawei.hicloud.base.p103ui.uiextend.PermissionCheckActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        JsClientApi.handleActivityPermissionResult(i10, strArr, iArr);
    }
}
