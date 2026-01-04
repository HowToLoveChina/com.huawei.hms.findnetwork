package com.huawei.hianalytics.core.log;

/* loaded from: classes5.dex */
public class HiLog {

    /* renamed from: a */
    public static LogAdapter f21687a = null;

    /* renamed from: b */
    public static boolean f21688b = false;

    /* renamed from: c */
    public static int f21689c = 6;

    /* renamed from: d */
    public static String f21690d = "";

    public interface ErrorCode {
        public static final String NE002 = "NE-002";
        public static final String NE003 = "NE-003";
        public static final String NE004 = "NE-004";
        public static final String NE005 = "NE-005";
        public static final String NE006 = "NE-006";
    }

    /* renamed from: a */
    public static boolean m28805a(int i10) {
        LogAdapter logAdapter = f21687a;
        if (logAdapter != null) {
            return logAdapter.isLoggable(i10);
        }
        return false;
    }

    /* renamed from: d */
    public static void m28807d(String str, String str2) {
        if (!isDebugEnable() || str == null || str2 == null) {
            return;
        }
        f21687a.println(3, str, str2);
    }

    /* renamed from: e */
    public static void m28808e(String str, String str2) {
        if (m28806a(str, str2)) {
            f21687a.println(6, str, str2);
        }
    }

    /* renamed from: i */
    public static void m28809i(String str, String str2) {
        if (!m28805a(4) || str == null || str2 == null) {
            return;
        }
        f21687a.println(4, str, str2);
    }

    public static void init(int i10, String str) {
        f21688b = true;
        f21689c = i10;
        f21690d = str;
        LogAdapter logAdapter = f21687a;
        if (logAdapter != null) {
            logAdapter.init(i10, str);
        }
    }

    public static boolean isDebugEnable() {
        return m28805a(3);
    }

    public static void setLogAdapter(LogAdapter logAdapter) {
        if (f21687a == null) {
            f21687a = logAdapter;
        }
        if (f21688b) {
            init(f21689c, f21690d);
        }
    }

    /* renamed from: si */
    public static void m28810si(String str, String str2) {
        if (m28806a(str, str2)) {
            if (f21688b && !m28805a(6)) {
                return;
            }
            f21687a.println(4, str, str2);
        }
    }

    /* renamed from: sw */
    public static void m28811sw(String str, String str2) {
        if (m28806a(str, str2)) {
            if (f21688b && !m28805a(7)) {
                return;
            }
            f21687a.println(5, str, str2);
        }
    }

    /* renamed from: w */
    public static void m28812w(String str, String str2) {
        if (!m28805a(5) || str == null || str2 == null) {
            return;
        }
        f21687a.println(5, str, str2);
    }

    /* renamed from: a */
    public static boolean m28806a(String str, String str2) {
        return (f21687a == null || str == null || str2 == null) ? false : true;
    }
}
