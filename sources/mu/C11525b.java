package mu;

import android.webkit.WebSettings;
import android.webkit.WebView;

/* renamed from: mu.b */
/* loaded from: classes5.dex */
public class C11525b {
    /* renamed from: a */
    public static void m68797a(WebSettings webSettings) {
        webSettings.setAllowContentAccess(false);
    }

    /* renamed from: b */
    public static void m68798b(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

    /* renamed from: c */
    public static void m68799c(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    /* renamed from: d */
    public static void m68800d(WebSettings webSettings) {
        webSettings.setMixedContentMode(1);
    }

    /* renamed from: e */
    public static void m68801e(WebSettings webSettings) {
    }

    /* renamed from: f */
    public static void m68802f(WebView webView) {
        WebSettings settings = webView.getSettings();
        m68798b(settings);
        m68803g(webView);
        m68801e(settings);
        m68799c(settings);
        m68800d(settings);
        m68797a(settings);
    }

    /* renamed from: g */
    public static void m68803g(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }
}
