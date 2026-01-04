package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.v */
/* loaded from: classes8.dex */
public class C5571v {

    /* renamed from: a */
    private static C5550m0 f25317a = new C5550m0();

    /* renamed from: a */
    public static void m32785a(int i10) {
        f25317a.m32638a(i10);
    }

    /* renamed from: b */
    public static void m32789b(String str, String str2) {
        if (!m32791b() || str == null || str2 == null) {
            return;
        }
        f25317a.m32640b(6, str, str2);
    }

    /* renamed from: c */
    public static void m32792c(String str, String str2) {
        if (!m32793c() || str == null || str2 == null) {
            return;
        }
        f25317a.m32640b(4, str, str2);
    }

    /* renamed from: d */
    public static void m32794d(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f25317a.m32640b(4, str, str2);
    }

    /* renamed from: e */
    public static void m32796e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f25317a.m32640b(5, str, str2);
    }

    /* renamed from: f */
    public static void m32797f(String str, String str2) {
        if (!m32795d() || str == null || str2 == null) {
            return;
        }
        f25317a.m32640b(5, str, str2);
    }

    /* renamed from: a */
    public static void m32786a(String str, String str2) {
        if (!m32788a() || str == null || str2 == null) {
            return;
        }
        f25317a.m32640b(3, str, str2);
    }

    /* renamed from: b */
    public static void m32790b(String str, String str2, Object... objArr) {
        m32794d(str, String.format(str2, objArr));
    }

    /* renamed from: c */
    private static boolean m32793c() {
        return f25317a.m32641b(4);
    }

    /* renamed from: d */
    private static boolean m32795d() {
        return f25317a.m32641b(5);
    }

    /* renamed from: a */
    public static void m32787a(String str, String str2, Object... objArr) {
        if (!m32793c() || str == null || str2 == null) {
            return;
        }
        f25317a.m32640b(4, str, String.format(str2, objArr));
    }

    /* renamed from: b */
    private static boolean m32791b() {
        return f25317a.m32641b(6);
    }

    /* renamed from: a */
    private static boolean m32788a() {
        return f25317a.m32641b(3);
    }
}
