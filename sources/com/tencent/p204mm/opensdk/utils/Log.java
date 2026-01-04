package com.tencent.p204mm.opensdk.utils;

/* loaded from: classes9.dex */
public class Log {
    private static ILog logImpl;

    /* renamed from: d */
    public static void m56638d(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.d(str, str2);
        } else {
            iLog.m56633d(str, str2);
        }
    }

    /* renamed from: e */
    public static void m56639e(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.e(str, str2);
        } else {
            iLog.m56634e(str, str2);
        }
    }

    /* renamed from: i */
    public static void m56640i(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.i(str, str2);
        } else {
            iLog.m56635i(str, str2);
        }
    }

    public static void setLogImpl(ILog iLog) {
        logImpl = iLog;
    }

    /* renamed from: v */
    public static void m56641v(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.v(str, str2);
        } else {
            iLog.m56636v(str, str2);
        }
    }

    /* renamed from: w */
    public static void m56642w(String str, String str2) {
        ILog iLog = logImpl;
        if (iLog == null) {
            android.util.Log.w(str, str2);
        } else {
            iLog.m56637w(str, str2);
        }
    }
}
