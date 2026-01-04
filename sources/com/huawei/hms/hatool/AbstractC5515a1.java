package com.huawei.hms.hatool;

import java.util.Map;

/* renamed from: com.huawei.hms.hatool.a1 */
/* loaded from: classes8.dex */
public abstract class AbstractC5515a1 {
    /* renamed from: a */
    public static void m32425a(String str, String str2, long j10) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            c5566s0M32433h.m32740a(j10);
        }
    }

    /* renamed from: b */
    public static int m32427b(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            return c5566s0M32433h.m32752d();
        }
        return 7;
    }

    /* renamed from: c */
    public static boolean m32428c(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            return c5566s0M32433h.m32761g();
        }
        return true;
    }

    /* renamed from: d */
    public static String m32429d(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        return c5566s0M32433h != null ? c5566s0M32433h.m32758f() : "";
    }

    /* renamed from: e */
    public static boolean m32430e(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            return c5566s0M32433h.m32763i();
        }
        return false;
    }

    /* renamed from: f */
    public static String m32431f(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        return c5566s0M32433h != null ? c5566s0M32433h.m32762h() : "";
    }

    /* renamed from: g */
    public static String m32432g(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        return c5566s0M32433h != null ? c5566s0M32433h.m32768n() : "";
    }

    /* renamed from: h */
    private static C5566s0 m32433h(String str, String str2) {
        C5548l1 c5548l1M32735a = C5565s.m32733c().m32735a(str);
        if (c5548l1M32735a == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return c5548l1M32735a.m32627a(str2);
        }
        C5566s0 c5566s0M32627a = c5548l1M32735a.m32627a("oper");
        return c5566s0M32627a == null ? c5548l1M32735a.m32627a("maint") : c5566s0M32627a;
    }

    /* renamed from: i */
    public static Map<String, String> m32434i(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            return c5566s0M32433h.m32765k();
        }
        return null;
    }

    /* renamed from: j */
    public static long m32435j(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            return c5566s0M32433h.m32766l();
        }
        return 0L;
    }

    /* renamed from: k */
    public static int m32436k(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            return c5566s0M32433h.m32745b();
        }
        return 10;
    }

    /* renamed from: l */
    public static String m32437l(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        return c5566s0M32433h != null ? c5566s0M32433h.m32769o() : "";
    }

    /* renamed from: m */
    public static String m32438m(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        return c5566s0M32433h != null ? c5566s0M32433h.m32771q() : "";
    }

    /* renamed from: n */
    public static String m32439n(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        return c5566s0M32433h != null ? c5566s0M32433h.m32767m() : "";
    }

    /* renamed from: o */
    public static String m32440o(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        return c5566s0M32433h != null ? c5566s0M32433h.m32770p() : "";
    }

    /* renamed from: a */
    public static boolean m32426a(String str, String str2) {
        C5566s0 c5566s0M32433h = m32433h(str, str2);
        if (c5566s0M32433h != null) {
            return c5566s0M32433h.m32744a();
        }
        return true;
    }
}
