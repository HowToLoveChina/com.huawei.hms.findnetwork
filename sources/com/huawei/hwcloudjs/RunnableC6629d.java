package com.huawei.hwcloudjs;

import android.webkit.WebView;

/* renamed from: com.huawei.hwcloudjs.d */
/* loaded from: classes8.dex */
public class RunnableC6629d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebView f30813a;

    /* renamed from: b */
    final /* synthetic */ String f30814b;

    public RunnableC6629d(WebView webView, String str) {
        this.f30813a = webView;
        this.f30814b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f30813a.getSettings().setSavePassword(false);
        this.f30813a.loadUrl(this.f30814b);
    }
}
