package th;

import android.util.Log;

/* renamed from: th.a */
/* loaded from: classes4.dex */
public class C13012a {
    /* renamed from: a */
    public static int m78315a(String str, String str2) {
        if (!C13013b.m78320a()) {
            return -1;
        }
        return Log.d("MarketInstallService", str + ":" + str2);
    }

    /* renamed from: b */
    public static int m78316b(String str, String str2, Throwable th2) {
        if (!C13013b.m78322c()) {
            return -1;
        }
        return Log.e("MarketInstallService", str + ":" + str2, th2);
    }

    /* renamed from: c */
    public static int m78317c(String str, String str2) {
        if (!C13013b.m78322c()) {
            return -1;
        }
        return Log.e("MarketInstallService", str + ":" + str2);
    }

    /* renamed from: d */
    public static int m78318d(String str, String str2) {
        if (!C13013b.m78321b()) {
            return -1;
        }
        return Log.i("MarketInstallService", str + ":" + str2);
    }

    /* renamed from: e */
    public static int m78319e(String str, String str2) {
        if (!C13013b.m78322c()) {
            return -1;
        }
        return Log.w("MarketInstallService", str + ":" + str2);
    }
}
