package com.huawei.hwcloudjs.p164f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Looper;
import android.webkit.WebView;
import com.huawei.hwcloudjs.p151b.C6617a;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hwcloudjs.f.b */
/* loaded from: classes8.dex */
public class C6657b {

    /* renamed from: a */
    private static final String f30877a = "DeviceUtils";

    /* renamed from: a */
    public static String m37871a() {
        return Locale.getDefault().getCountry();
    }

    /* renamed from: b */
    public static String m37873b() {
        return Locale.getDefault().getLanguage();
    }

    /* renamed from: c */
    public static String m37875c() {
        return Build.MODEL;
    }

    /* renamed from: d */
    public static String m37876d() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: e */
    public static String m37877e() {
        return Build.DISPLAY;
    }

    /* renamed from: f */
    public static boolean m37878f() {
        Context contextM37753a = C6617a.m37753a();
        if (contextM37753a == null || !(contextM37753a.getSystemService("connectivity") instanceof ConnectivityManager)) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) contextM37753a.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }

    /* renamed from: a */
    public static String m37872a(WebView webView) {
        if (webView == null) {
            return "";
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return m37874b(webView);
        }
        try {
            return webView.getUrl();
        } catch (Exception e10) {
            C6659d.m37881b(f30877a, "getWebViewUrl myLooper Exception:" + e10.getClass().getSimpleName(), true);
            return "";
        }
    }

    /* renamed from: b */
    private static String m37874b(WebView webView) {
        StringBuilder sb2;
        String str;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String[] strArr = {null};
        try {
            C6659d.m37882c(f30877a, "webView post", true);
            webView.post(new RunnableC6656a(strArr, webView, countDownLatch));
            C6659d.m37882c(f30877a, "webView await", true);
            if (!countDownLatch.await(500L, TimeUnit.MILLISECONDS)) {
                C6659d.m37882c(f30877a, "webView await false", true);
            }
        } catch (InterruptedException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "latch.await InterruptedException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30877a, sb2.toString(), true);
            return strArr[0];
        } catch (Exception e11) {
            e = e11;
            sb2 = new StringBuilder();
            str = "getWebViewUrl Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            C6659d.m37881b(f30877a, sb2.toString(), true);
            return strArr[0];
        }
        return strArr[0];
    }
}
