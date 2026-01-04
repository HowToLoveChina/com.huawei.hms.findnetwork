package com.huawei.hms.support.log;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.AndroidException;
import com.huawei.hms.base.log.C5129a;
import com.huawei.hms.base.log.C5130b;

/* loaded from: classes8.dex */
public class HMSLog {

    /* renamed from: a */
    private static final C5130b f30118a = new C5130b();

    /* renamed from: a */
    private static String m36982a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 16384);
                return "HMS-" + packageInfo.versionName + "(" + packageInfo.versionCode + ")";
            } catch (AndroidException | RuntimeException unused) {
            }
        }
        return "HMS-[unknown-version]";
    }

    /* renamed from: d */
    public static void m36983d(String str, String str2) {
        f30118a.m30618a(3, str, str2);
    }

    /* renamed from: e */
    public static void m36986e(String str, String str2) {
        f30118a.m30618a(6, str, str2);
    }

    /* renamed from: i */
    public static void m36988i(String str, String str2) {
        f30118a.m30618a(4, str, str2);
    }

    public static void init(Context context, int i10, String str) {
        C5130b c5130b = f30118a;
        c5130b.m30619a(context, i10, str);
        c5130b.m30621a(str, "============================================================================\n====== " + m36982a(context) + "\n============================================================================");
    }

    public static boolean isErrorEnable() {
        return f30118a.m30622a(6);
    }

    public static boolean isInfoEnable() {
        return f30118a.m30622a(4);
    }

    public static boolean isWarnEnable() {
        return f30118a.m30622a(5);
    }

    public static void setExtLogger(HMSExtLogger hMSExtLogger, boolean z10) throws IllegalArgumentException {
        if (hMSExtLogger == null) {
            throw new IllegalArgumentException("extLogger is not able to be null");
        }
        C5129a c5129a = new C5129a(hMSExtLogger);
        if (z10) {
            f30118a.m30620a(c5129a);
        } else {
            f30118a.m30617a().mo30613a(c5129a);
        }
    }

    /* renamed from: w */
    public static void m36989w(String str, String str2) {
        f30118a.m30618a(5, str, str2);
    }

    /* renamed from: e */
    public static void m36987e(String str, String str2, Throwable th2) {
        f30118a.m30623b(6, str, str2, th2);
    }

    /* renamed from: e */
    public static void m36984e(String str, long j10, String str2) {
        f30118a.m30618a(6, str, "[" + j10 + "] " + str2);
    }

    /* renamed from: e */
    public static void m36985e(String str, long j10, String str2, Throwable th2) {
        f30118a.m30623b(6, str, "[" + j10 + "] " + str2, th2);
    }
}
