package com.huawei.openalliance.p169ad.views.web;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.InterfaceC7542oj;
import com.huawei.openalliance.p169ad.views.interfaces.InterfaceC8124q;

/* renamed from: com.huawei.openalliance.ad.views.web.c */
/* loaded from: classes2.dex */
public class C8180c extends C8181d {

    /* renamed from: a */
    protected InterfaceC8124q f38352a;

    /* renamed from: b */
    private ProgressBar f38353b;

    /* renamed from: c */
    private WebViewClient f38354c;

    /* renamed from: d */
    private InterfaceC7542oj f38355d;

    public C8180c(InterfaceC8124q interfaceC8124q) {
        this.f38352a = interfaceC8124q;
    }

    /* renamed from: b */
    private void m50681b() {
        AbstractC7185ho.m43820b("PureWebViewClient", "onPageFinished");
        this.f38352a.mo49764c();
    }

    @Override // com.huawei.openalliance.p169ad.views.web.C8181d
    /* renamed from: a */
    public void mo50682a(WebView webView) {
        AbstractC7185ho.m43820b("PureWebViewClient", "onReceivedError");
        webView.loadUrl("about:blank");
        ProgressBar progressBar = this.f38353b;
        if (progressBar != null && progressBar.getVisibility() == 0) {
            this.f38353b.setVisibility(4);
        }
        InterfaceC8124q interfaceC8124q = this.f38352a;
        if (interfaceC8124q != null) {
            interfaceC8124q.mo49759a();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (!webView.getSettings().getLoadsImagesAutomatically()) {
            webView.getSettings().setLoadsImagesAutomatically(true);
        }
        ProgressBar progressBar = this.f38353b;
        if (progressBar != null) {
            progressBar.setVisibility(4);
            this.f38353b.setProgress(100);
        }
        m50681b();
        WebViewClient webViewClient = this.f38354c;
        if (webViewClient != null) {
            webViewClient.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AbstractC7185ho.m43818a("PureWebViewClient", "onPageStarted url=%s", str);
        ProgressBar progressBar = this.f38353b;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        WebViewClient webViewClient = this.f38354c;
        if (webViewClient != null) {
            webViewClient.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        super.onReceivedError(webView, i10, str, str2);
        AbstractC7185ho.m43818a("PureWebViewClient", "onReceivedError description:%s", str);
        mo50682a(webView);
    }

    @Override // com.huawei.openalliance.p169ad.views.web.C8181d, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return true;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        InterfaceC7542oj interfaceC7542oj;
        if (this.f38352a != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
            this.f38352a.mo49763b(webResourceRequest.getUrl().toString());
        }
        if (webResourceRequest != null && (interfaceC7542oj = this.f38355d) != null && interfaceC7542oj.mo46245a(webView, webResourceRequest.getUrl())) {
            return true;
        }
        WebViewClient webViewClient = this.f38354c;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest) : super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    /* renamed from: a */
    public void m50683a(WebViewClient webViewClient) {
        this.f38354c = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        AbstractC7185ho.m43818a("PureWebViewClient", "onReceivedError error:%s", webResourceError.getDescription());
        mo50682a(webView);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterfaceC8124q interfaceC8124q = this.f38352a;
        if (interfaceC8124q != null) {
            interfaceC8124q.mo49763b(str);
        }
        try {
            InterfaceC7542oj interfaceC7542oj = this.f38355d;
            if (interfaceC7542oj != null) {
                if (interfaceC7542oj.mo46245a(webView, Uri.parse(str))) {
                    return true;
                }
            }
        } catch (Exception unused) {
            AbstractC7185ho.m43823c("PureWebViewClient", "shouldOverrideUrlLoading Exception");
        }
        WebViewClient webViewClient = this.f38354c;
        return webViewClient != null ? webViewClient.shouldOverrideUrlLoading(webView, str) : super.shouldOverrideUrlLoading(webView, str);
    }

    /* renamed from: a */
    public void m50684a(InterfaceC7542oj interfaceC7542oj) {
        this.f38355d = interfaceC7542oj;
    }
}
