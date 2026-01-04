package com.huawei.hms.ads.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.huawei.hms.ads.jsb.IWebView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.huawei.hms.ads.jsbridge.a */
/* loaded from: classes8.dex */
public class C5094a {

    /* renamed from: a */
    private volatile String f23277a;

    /* renamed from: com.huawei.hms.ads.jsbridge.a$a */
    public static class a implements Callable<String> {

        /* renamed from: a */
        private IWebView f23278a;

        /* renamed from: b */
        private WebView f23279b;

        /* renamed from: c */
        private boolean f23280c;

        public a(WebView webView) {
            this.f23279b = webView;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            if (this.f23280c) {
                IWebView iWebView = this.f23278a;
                if (iWebView != null) {
                    return iWebView.getUrl();
                }
                return null;
            }
            WebView webView = this.f23279b;
            if (webView != null) {
                return webView.getUrl();
            }
            return null;
        }

        public a(IWebView iWebView) {
            this.f23280c = true;
            this.f23278a = iWebView;
        }
    }

    /* renamed from: b */
    private static String m30392b(WebView webView) {
        try {
            return m30390a(new FutureTask(new a(webView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            C5095b.m30398b("Exception will waiting: " + e10.getMessage());
            C5095b.m30398b("exception or timeout while waiting for url");
            return null;
        }
    }

    /* renamed from: a */
    public String m30394a(WebView webView) {
        if (webView == null) {
            return null;
        }
        String str = this.f23277a;
        if (str != null) {
            return str;
        }
        C5095b.m30397a("securityExtSetFrameUrl is null ,get url from native");
        return m30392b(webView);
    }

    /* renamed from: b */
    private static String m30393b(IWebView iWebView) {
        try {
            return m30390a(new FutureTask(new a(iWebView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            C5095b.m30398b("Exception will waiting: " + e10.getMessage());
            C5095b.m30398b("exception or timeout while waiting for url");
            return null;
        }
    }

    /* renamed from: a */
    public String m30395a(IWebView iWebView) {
        if (iWebView == null) {
            return null;
        }
        String str = this.f23277a;
        return str != null ? str : m30393b(iWebView);
    }

    /* renamed from: a */
    private static Future<String> m30390a(FutureTask futureTask) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            futureTask.run();
        } else {
            new Handler(Looper.getMainLooper()).post(futureTask);
        }
        return futureTask;
    }

    /* renamed from: a */
    public static void m30391a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
