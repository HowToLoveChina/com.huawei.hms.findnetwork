package com.huawei.hwidauth.p167ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.hwcloudjs.p165g.C6664a;
import com.huawei.secure.android.common.webview.SafeWebView;
import java.util.HashMap;
import java.util.Map;
import p373iu.C10620h;
import p621rq.AbstractC12615a;
import p640sq.C12828g;
import p640sq.C12836o;
import p640sq.C12845x;
import p658tq.C13056a;

/* renamed from: com.huawei.hwidauth.ui.e */
/* loaded from: classes8.dex */
public class C6720e extends WebViewClient {

    /* renamed from: a */
    public C6723h f31119a;

    /* renamed from: b */
    public Context f31120b;

    /* renamed from: c */
    public C12828g f31121c;

    /* renamed from: d */
    public SafeWebView f31122d;

    /* renamed from: e */
    public InterfaceC6722g f31123e;

    public C6720e(C6723h c6723h, Context context, SafeWebView safeWebView, C12828g c12828g, InterfaceC6722g interfaceC6722g) {
        this.f31122d = safeWebView;
        this.f31120b = context;
        this.f31121c = c12828g;
        this.f31119a = c6723h;
        this.f31123e = interfaceC6722g;
        C12836o.m77097b("SafeWebViewClient", "SafeWebViewClient start.", true);
    }

    /* renamed from: a */
    public final WebResourceResponse m38167a(String str) {
        WebResourceResponse webResourceResponseM77055b;
        if (!this.f31121c.m77054a(str) || (webResourceResponseM77055b = this.f31121c.m77055b(str)) == null) {
            return null;
        }
        return webResourceResponseM77055b;
    }

    /* renamed from: b */
    public final void m38168b() {
        if ("from_signin".equalsIgnoreCase(this.f31119a.m38208c()) || "from_v3_signin".equalsIgnoreCase(this.f31119a.m38208c())) {
            this.f31119a.m38198S();
        }
    }

    /* renamed from: c */
    public final void m38169c(SafeWebView safeWebView, String str, Map map) {
        if (m38172f(str) && safeWebView.m53594c(str)) {
            safeWebView.loadUrl(str, map);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m38170d(android.webkit.WebView r3) {
        /*
            r2 = this;
            android.webkit.WebBackForwardList r2 = r3.copyBackForwardList()
            if (r2 == 0) goto L23
            int r3 = r2.getSize()
            if (r3 <= 0) goto L23
            java.lang.String r3 = "PersonalInfo historyList is no empty"
            r0 = 1
            java.lang.String r1 = "SafeWebViewClient"
            p640sq.C12836o.m77097b(r1, r3, r0)
            int r3 = r2.getCurrentIndex()
            android.webkit.WebHistoryItem r2 = r2.getItemAtIndex(r3)
            if (r2 == 0) goto L23
            java.lang.String r2 = r2.getUrl()
            goto L25
        L23:
            java.lang.String r2 = ""
        L25:
            java.lang.String r3 = "ticket"
            boolean r2 = r2.contains(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwidauth.p167ui.C6720e.m38170d(android.webkit.WebView):boolean");
    }

    /* renamed from: e */
    public final boolean m38171e(String str) {
        String strM77145a = C12845x.m77145a(str);
        if (!TextUtils.isEmpty(str) && ("https".equals(strM77145a) || "http".equals(strM77145a) || C6664a.f30905c.equals(strM77145a) || "mqq".equals(strM77145a) || "weixin".equals(strM77145a) || "wtloginmqq".equals(strM77145a))) {
            return this.f31122d.m53594c(str);
        }
        C12836o.m77097b("SafeWebViewClient", "is not a right url", true);
        return false;
    }

    /* renamed from: f */
    public final boolean m38172f(String str) {
        String strM77145a = C12845x.m77145a(str);
        if (!TextUtils.isEmpty(str) && ("https".equals(strM77145a) || "http".equals(strM77145a) || C6664a.f30905c.equals(strM77145a) || "mqq".equals(strM77145a) || "weixin".equals(strM77145a) || "wtloginmqq".equals(strM77145a))) {
            return true;
        }
        C12836o.m77097b("SafeWebViewClient", "is not a right url", true);
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        C12836o.m77097b("SafeWebViewClient", "onPageFinished-", true);
        super.onPageFinished(webView, str);
        this.f31123e.mo38111c(str);
        m38168b();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        C12836o.m77099d("SafeWebViewClient", "onReceivedSslError:" + sslError, false);
        C12836o.m77097b("SafeWebViewClient", "is not joint debug. check server certificate", true);
        C10620h.m65082a(sslErrorHandler, sslError, this.f31120b);
        this.f31123e.mo38103a(2015, "server certificate error");
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C12836o.m77097b("SafeWebViewClient", "shouldOverrideUrlLoading", true);
        C12836o.m77097b("SafeWebViewClient", "enter shouldOverrideUrlLoading url: " + str, false);
        if ("from_other_app_signin".equalsIgnoreCase(this.f31119a.m38208c()) && this.f31119a.m38221i0(str)) {
            C12836o.m77097b("SafeWebViewClient", "shouldOverrideUrlLoading sign contains service", false);
            C13056a.m78783c(this.f31120b, 907115001, 200, "loginSuccess", this.f31119a.m38200U(), "accountPickerH5.signIn_v3", "api_ret");
            if (this.f31119a.m38229m0(str)) {
                return true;
            }
        }
        if ("open_personal_info".equalsIgnoreCase(this.f31119a.m38208c()) && !str.contains("ticket")) {
            C12836o.m77097b("SafeWebViewClient", "PersonalInfoGoBack", true);
            if (m38170d(webView)) {
                C12836o.m77097b("SafeWebViewClient", "PersonalInfoGoBack true", true);
                return false;
            }
        }
        if (this.f31119a.m38217g0(str) || this.f31119a.m38225k0(str)) {
            return false;
        }
        HashMap<String, String> mapM38202W = this.f31119a.m38202W(str);
        if (str.contains("service/windex")) {
            mapM38202W.put("Referer", AbstractC12615a.m76116a().mo76131o());
        }
        m38169c((SafeWebView) webView, str, mapM38202W);
        C12836o.m77097b("SafeWebViewClient", "shouldOverrideUrlLoading map = " + mapM38202W.toString(), false);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponseM38167a;
        String string = webResourceRequest.getUrl().toString();
        return (!m38171e(string) || (webResourceResponseM38167a = m38167a(string)) == null) ? super.shouldInterceptRequest(webView, webResourceRequest) : webResourceResponseM38167a;
    }
}
