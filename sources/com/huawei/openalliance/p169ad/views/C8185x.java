package com.huawei.openalliance.p169ad.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7019dh;
import com.huawei.openalliance.p169ad.C7022dk;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7542oj;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;
import com.huawei.openalliance.p169ad.utils.AbstractC7811dd;
import com.huawei.openalliance.p169ad.utils.AbstractC7817dj;
import com.huawei.openalliance.p169ad.utils.AbstractC7819dl;
import com.huawei.openalliance.p169ad.utils.C7824dq;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8130w;
import com.huawei.openalliance.p169ad.views.web.C8181d;
import com.huawei.uikit.phone.hwprogressbar.widget.HwProgressBar;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* renamed from: com.huawei.openalliance.ad.views.x */
/* loaded from: classes2.dex */
class C8185x extends C8181d {

    /* renamed from: a */
    private boolean f38376a = false;

    /* renamed from: b */
    private boolean f38377b = false;

    /* renamed from: c */
    private View f38378c;

    /* renamed from: d */
    private InterfaceC7542oj f38379d;

    /* renamed from: e */
    private WebViewClient f38380e;

    /* renamed from: f */
    private InterfaceC8130w f38381f;

    /* renamed from: g */
    private boolean f38382g;

    /* renamed from: h */
    private long f38383h;

    /* renamed from: i */
    private final C7022dk f38384i;

    public C8185x(InterfaceC8130w interfaceC8130w) {
        this.f38381f = interfaceC8130w;
        this.f38384i = C7019dh.m41937a(interfaceC8130w.getContext(), Constants.WEBVIEW_CACHE);
    }

    /* renamed from: b */
    private WebResourceResponse m50706b(String str) {
        return new WebResourceResponse(C7824dq.m48389b(str), Constants.UTF_8, new FileInputStream(new File(this.f38384i.m41968c(C7022dk.m41953d(str)))));
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z10) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(webView, str, z10);
        } else {
            super.doUpdateVisitedHistory(webView, str, z10);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onFormResubmission(webView, message, message2);
        } else {
            super.onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onLoadResource(webView, str);
        } else {
            super.onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onPageCommitVisible(WebView webView, String str) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onPageCommitVisible(webView, str);
        } else {
            super.onPageCommitVisible(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (!webView.getSettings().getLoadsImagesAutomatically()) {
            webView.getSettings().setLoadsImagesAutomatically(true);
        }
        View view = this.f38378c;
        if (view != null) {
            view.setVisibility(8);
            if (this.f38382g) {
                ((HwProgressBar) this.f38378c).setProgress(100, true);
            } else {
                ((C8084e) this.f38378c).setProgress(100);
            }
        }
        if (this.f38379d != null && m50704a(str)) {
            if (AbstractC7185ho.m43819a()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                AbstractC7185ho.m43818a("PPSWebViewClient", "onPageFinished, load finish time is: %d", Long.valueOf(jCurrentTimeMillis));
                AbstractC7185ho.m43818a("PPSWebViewClient", "onPageFinished, load time is: %d", Long.valueOf(jCurrentTimeMillis - this.f38383h));
            }
            this.f38379d.mo46247b();
        }
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f38383h = jCurrentTimeMillis;
        AbstractC7185ho.m43818a("PPSWebViewClient", "onPageFinished, load start time is: %d", Long.valueOf(jCurrentTimeMillis));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InterfaceC8130w interfaceC8130w = this.f38381f;
        if (interfaceC8130w != null) {
            interfaceC8130w.mo49763b(str);
        }
        if (Uri.parse(str) != null) {
            String strM48182k = AbstractC7806cz.m48182k(str);
            if (!TextUtils.isEmpty(strM48182k) && C7124fh.m43316b(webView.getContext()).mo43467j(strM48182k)) {
                if (this.f38379d != null) {
                    AbstractC7185ho.m43823c("PPSWebViewClient", "url is blocked");
                    this.f38379d.mo46250c();
                }
                InterfaceC8130w interfaceC8130w2 = this.f38381f;
                if (interfaceC8130w2 != null) {
                    interfaceC8130w2.mo49762b();
                    return;
                }
                return;
            }
        }
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
            return;
        }
        View view = this.f38378c;
        if (view != null) {
            view.setVisibility(0);
            boolean z10 = this.f38382g;
            View view2 = this.f38378c;
            if (z10) {
                ((HwProgressBar) view2).setProgress(0);
            } else {
                ((C8084e) view2).m50110a();
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
        } else {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, final int i10, final String str, final String str2) {
        AbstractC7185ho.m43824c("PPSWebViewClient", "onReceivedError, errorCode: %d description: %s", Integer.valueOf(i10), str);
        m50707b(webView);
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, i10, str, str2);
        } else {
            m50703a(webView, true);
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.x.1
            @Override // java.lang.Runnable
            public void run() {
                if (C8185x.this.f38381f != null) {
                    C8185x.this.f38381f.mo49761a(str2, "onReceivedError", "mainframe:true, errorCode:" + i10 + ", desc:" + str);
                }
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedHttpError(WebView webView, final WebResourceRequest webResourceRequest, final WebResourceResponse webResourceResponse) {
        final boolean zIsForMainFrame = webResourceRequest.isForMainFrame();
        AbstractC7185ho.m43823c("PPSWebViewClient", "onReceivedHttpError, isForMainFrame:" + zIsForMainFrame + ", ReasonPhrase:" + webResourceResponse.getReasonPhrase());
        if (zIsForMainFrame) {
            m50707b(webView);
        }
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        } else if (zIsForMainFrame) {
            m50703a(webView, zIsForMainFrame);
        } else {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.x.3
            @Override // java.lang.Runnable
            public void run() {
                if (C8185x.this.f38381f != null) {
                    C8185x.this.f38381f.mo49761a(String.valueOf(webResourceRequest.getUrl()), "onReceivedHttpError", "mainframe:" + String.valueOf(zIsForMainFrame) + ", statusCode:" + webResourceResponse.getStatusCode() + ", reasonPhrase:" + webResourceResponse.getReasonPhrase());
                }
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
        } else {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // com.huawei.openalliance.p169ad.views.web.C8181d, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return true;
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f10, float f11) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onScaleChanged(webView, f10, f11);
        } else {
            super.onScaleChanged(webView, f10, f11);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(webView, message, message2);
        } else {
            super.onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(webView, keyEvent);
        } else {
            super.onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String string = webResourceRequest.getUrl().toString();
        AbstractC7185ho.m43818a("PPSWebViewClient", "url is : %s, diskCache url is : %s", string, C7022dk.m41953d(string));
        try {
        } catch (IOException unused) {
            AbstractC7185ho.m43824c("PPSWebViewClient", "getLocalCacheFile io exception: %s", AbstractC7819dl.m48375a(string));
        } catch (Exception unused2) {
            AbstractC7185ho.m43824c("PPSWebViewClient", "getLocalCacheFile exception: %s", AbstractC7819dl.m48375a(string));
        }
        if (C7824dq.m48388a(string) && this.f38384i.m41973f(C7022dk.m41953d(string))) {
            AbstractC7185ho.m43818a("PPSWebViewClient", "url cache: %s", string);
            return m50706b(string);
        }
        AbstractC7185ho.m43818a("PPSWebViewClient", "url not cache: %s", string);
        WebViewClient webViewClient = this.f38380e;
        return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, webResourceRequest) : super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        WebViewClient webViewClient = this.f38380e;
        return webViewClient != null ? webViewClient.shouldOverrideKeyEvent(webView, keyEvent) : super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterfaceC7542oj interfaceC7542oj;
        if (this.f38381f != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
            if (m50705a(webResourceRequest.getUrl().toString(), webView.getContext())) {
                return true;
            }
            this.f38381f.mo49763b(webResourceRequest.getUrl().toString());
        }
        if (webResourceRequest != null && (interfaceC7542oj = this.f38379d) != null && interfaceC7542oj.mo46245a(webView, webResourceRequest.getUrl())) {
            return true;
        }
        WebViewClient webViewClient = this.f38380e;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest) : super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    /* renamed from: b */
    private void m50707b(WebView webView) {
        AbstractC7185ho.m43820b("PPSWebViewClient", "processError");
        this.f38377b = true;
        View view = this.f38378c;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.f38378c.setVisibility(8);
        boolean z10 = this.f38382g;
        View view2 = this.f38378c;
        if (z10) {
            ((HwProgressBar) view2).setProgress(0);
        } else {
            ((C8084e) view2).m50110a();
        }
    }

    /* renamed from: a */
    public void m50708a(View view, boolean z10) {
        this.f38378c = view;
        this.f38382g = z10;
        if (AbstractC7811dd.m48315c()) {
            AbstractC7185ho.m43820b("PPSWebViewClient", "rtl language, set rtl direction.");
            if (z10) {
                view.setRotation(180.0f);
            } else {
                view.setLayoutDirection(1);
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        final boolean zIsForMainFrame = webResourceRequest.isForMainFrame();
        AbstractC7185ho.m43823c("PPSWebViewClient", "onReceivedError, isForMainFrame:" + zIsForMainFrame + ", description:" + ((Object) webResourceError.getDescription()));
        if (zIsForMainFrame) {
            m50707b(webView);
        }
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
        } else if (zIsForMainFrame) {
            m50703a(webView, zIsForMainFrame);
        } else {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.x.2
            @Override // java.lang.Runnable
            public void run() {
                if (C8185x.this.f38381f != null) {
                    C8185x.this.f38381f.mo49761a(String.valueOf(webResourceRequest.getUrl()), "onReceivedError", "mainframe:" + String.valueOf(zIsForMainFrame) + ", errorCode:" + webResourceError.getErrorCode() + ", desc:" + String.valueOf(webResourceError.getDescription()));
                }
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        AbstractC7185ho.m43818a("PPSWebViewClient", "url is : %s, diskCache url is : %s", str, C7022dk.m41953d(str));
        try {
        } catch (Exception unused) {
            AbstractC7185ho.m43824c("PPSWebViewClient", "getLocalCacheFile error: %s", AbstractC7819dl.m48375a(str));
        }
        if (C7824dq.m48388a(str) && this.f38384i.m41973f(C7022dk.m41953d(str))) {
            return m50706b(str);
        }
        AbstractC7185ho.m43818a("PPSWebViewClient", "url not cache: %s", str);
        WebViewClient webViewClient = this.f38380e;
        return webViewClient != null ? webViewClient.shouldInterceptRequest(webView, str) : super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.f38381f != null) {
            if (m50705a(str, webView.getContext())) {
                return true;
            }
            this.f38381f.mo49763b(str);
        }
        try {
            InterfaceC7542oj interfaceC7542oj = this.f38379d;
            if (interfaceC7542oj != null) {
                if (interfaceC7542oj.mo46245a(webView, Uri.parse(str))) {
                    return true;
                }
            }
        } catch (Exception unused) {
            AbstractC7185ho.m43823c("PPSWebViewClient", "shouldOverrideUrlLoading Exception");
        }
        WebViewClient webViewClient = this.f38380e;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.huawei.openalliance.p169ad.views.web.C8181d
    /* renamed from: a */
    public void mo50686a(WebView webView, SslErrorHandler sslErrorHandler, final SslError sslError) {
        final boolean zEquals;
        if (this.f38381f != null) {
            zEquals = TextUtils.equals(AbstractC7806cz.m48169c(sslError.getUrl(), "/"), AbstractC7806cz.m48169c(this.f38381f.getCurrentPageUrl(), "/"));
            if (zEquals) {
                m50707b(webView);
            }
        } else {
            zEquals = false;
        }
        WebViewClient webViewClient = this.f38380e;
        if (webViewClient != null) {
            webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
        } else if (zEquals) {
            m50703a(webView, true);
        }
        AbstractC7817dj.m48363a(new Runnable() { // from class: com.huawei.openalliance.ad.views.x.4
            @Override // java.lang.Runnable
            public void run() {
                if (C8185x.this.f38381f != null) {
                    C8185x.this.f38381f.mo49761a(sslError.getUrl(), "onReceivedSslError", "mainframe:" + zEquals + ", SSL error: " + String.valueOf(sslError));
                }
            }
        });
    }

    /* renamed from: a */
    private void m50703a(WebView webView, boolean z10) {
        if (z10) {
            webView.loadUrl("about:blank");
            InterfaceC8130w interfaceC8130w = this.f38381f;
            if (interfaceC8130w != null) {
                interfaceC8130w.mo49759a();
            }
        }
    }

    /* renamed from: a */
    public void m50709a(WebViewClient webViewClient) {
        this.f38380e = webViewClient;
    }

    /* renamed from: a */
    public void m50710a(InterfaceC7542oj interfaceC7542oj) {
        this.f38379d = interfaceC7542oj;
    }

    /* renamed from: a */
    private boolean m50704a(String str) {
        if (this.f38379d == null || str == null || TextUtils.equals("about:blank", str)) {
            return false;
        }
        if (this.f38377b) {
            this.f38377b = false;
            return false;
        }
        if (this.f38376a) {
            return false;
        }
        this.f38376a = true;
        return true;
    }

    /* renamed from: a */
    private boolean m50705a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!C7124fh.m43316b(context).mo43467j(AbstractC7806cz.m48182k(str))) {
            return false;
        }
        AbstractC7185ho.m43820b("PPSWebViewClient", "url is blocked");
        InterfaceC7542oj interfaceC7542oj = this.f38379d;
        if (interfaceC7542oj == null) {
            return true;
        }
        interfaceC7542oj.mo46250c();
        return true;
    }
}
