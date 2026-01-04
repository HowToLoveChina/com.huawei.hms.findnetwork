package com.huawei.android.remotecontrol.p093ui.webview.client;

import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import kg.InterfaceC11053d;

/* loaded from: classes4.dex */
public class WebWapChromeClient extends WebChromeClient {
    private final InterfaceC11053d webChromeClientDelegate;

    public WebWapChromeClient(InterfaceC11053d interfaceC11053d) {
        this.webChromeClientDelegate = interfaceC11053d;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        super.onGeolocationPermissionsShowPrompt(str, callback);
        InterfaceC11053d interfaceC11053d = this.webChromeClientDelegate;
        if (interfaceC11053d != null) {
            interfaceC11053d.mo27865v(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i10) {
        super.onProgressChanged(webView, i10);
        InterfaceC11053d interfaceC11053d = this.webChromeClientDelegate;
        if (interfaceC11053d != null) {
            interfaceC11053d.mo27794E(webView, i10);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        InterfaceC11053d interfaceC11053d = this.webChromeClientDelegate;
        if (interfaceC11053d != null) {
            interfaceC11053d.mo27847l(webView, str);
        }
    }
}
