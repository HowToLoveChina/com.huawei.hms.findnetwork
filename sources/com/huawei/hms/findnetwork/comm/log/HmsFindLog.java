package com.huawei.hms.findnetwork.comm.log;

/* loaded from: classes8.dex */
public class HmsFindLog {
    private static final ApkLogImpl APK_LOG_IMPL = new ApkLogImpl();

    private HmsFindLog() {
    }

    /* renamed from: d */
    public static void m31927d(String str, String str2) {
        APK_LOG_IMPL.m31918d(str, str2);
    }

    /* renamed from: e */
    public static void m31928e(String str, String str2) {
        APK_LOG_IMPL.m31919e(str, str2);
    }

    /* renamed from: i */
    public static void m31930i(String str, String str2) {
        APK_LOG_IMPL.m31921i(str, str2);
    }

    public static void setCommonTag(String str) {
        APK_LOG_IMPL.init(str);
    }

    /* renamed from: w */
    public static void m31931w(String str, String str2) {
        APK_LOG_IMPL.m31922w(str, str2);
    }

    /* renamed from: e */
    public static void m31929e(String str, String str2, Throwable th2) {
        APK_LOG_IMPL.m31920e(str, str2, th2);
    }
}
