package com.huawei.hwcloudjs.api;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.huawei.hwcloudjs.support.enables.NoProguard;

@NoProguard
/* loaded from: classes8.dex */
public interface IJsWebview {
    void onReceivedError(WebView webView, int i10, String str, String str2);

    void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);

    boolean overrideUrlLoading(WebView webView, String str);
}
