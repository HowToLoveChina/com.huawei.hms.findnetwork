package p213d1;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import java.util.concurrent.Executor;
import p043c1.AbstractC1379d;

/* renamed from: d1.c */
/* loaded from: classes.dex */
public class C8977c {
    @Deprecated
    /* renamed from: a */
    public static int m56797a(WebSettings webSettings) {
        return webSettings.getForceDark();
    }

    /* renamed from: b */
    public static WebViewRenderProcess m56798b(WebView webView) {
        return webView.getWebViewRenderProcess();
    }

    /* renamed from: c */
    public static WebViewRenderProcessClient m56799c(WebView webView) {
        return webView.getWebViewRenderProcessClient();
    }

    @Deprecated
    /* renamed from: d */
    public static void m56800d(WebSettings webSettings, int i10) {
        webSettings.setForceDark(i10);
    }

    /* renamed from: e */
    public static void m56801e(WebView webView, AbstractC1379d abstractC1379d) {
        webView.setWebViewRenderProcessClient(null);
    }

    /* renamed from: f */
    public static void m56802f(WebView webView, Executor executor, AbstractC1379d abstractC1379d) {
        webView.setWebViewRenderProcessClient(executor, null);
    }

    /* renamed from: g */
    public static boolean m56803g(WebViewRenderProcess webViewRenderProcess) {
        return webViewRenderProcess.terminate();
    }
}
