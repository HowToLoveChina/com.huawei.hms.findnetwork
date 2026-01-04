package com.huawei.hwcloudjs.p164f;

import android.text.TextUtils;
import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.huawei.hwcloudjs.f.a */
/* loaded from: classes8.dex */
public class RunnableC6656a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String[] f30874a;

    /* renamed from: b */
    final /* synthetic */ WebView f30875b;

    /* renamed from: c */
    final /* synthetic */ CountDownLatch f30876c;

    public RunnableC6656a(String[] strArr, WebView webView, CountDownLatch countDownLatch) {
        this.f30874a = strArr;
        this.f30875b = webView;
        this.f30876c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public void run() {
        C6659d.m37882c("DeviceUtils", "webView getUrl", true);
        this.f30874a[0] = this.f30875b.getUrl();
        if (TextUtils.isEmpty(this.f30874a[0])) {
            C6659d.m37881b("DeviceUtils", "webView getUrl isEmpty", true);
        }
        this.f30876c.countDown();
    }
}
