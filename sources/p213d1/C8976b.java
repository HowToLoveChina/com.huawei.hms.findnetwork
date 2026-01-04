package p213d1;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import p043c1.C1376a;

/* renamed from: d1.b */
/* loaded from: classes.dex */
public class C8976b {
    /* renamed from: a */
    public static TracingController m56790a() {
        return TracingController.getInstance();
    }

    /* renamed from: b */
    public static ClassLoader m56791b() {
        return WebView.getWebViewClassLoader();
    }

    /* renamed from: c */
    public static Looper m56792c(WebView webView) {
        return webView.getWebViewLooper();
    }

    /* renamed from: d */
    public static boolean m56793d(TracingController tracingController) {
        return tracingController.isTracing();
    }

    /* renamed from: e */
    public static void m56794e(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    /* renamed from: f */
    public static void m56795f(TracingController tracingController, C1376a c1376a) {
        new TracingConfig.Builder();
        throw null;
    }

    /* renamed from: g */
    public static boolean m56796g(TracingController tracingController, OutputStream outputStream, Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
