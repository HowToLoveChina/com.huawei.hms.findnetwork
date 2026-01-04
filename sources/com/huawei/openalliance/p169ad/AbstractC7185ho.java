package com.huawei.openalliance.p169ad;

import android.os.Build;
import java.util.Locale;

/* renamed from: com.huawei.openalliance.ad.ho */
/* loaded from: classes8.dex */
public abstract class AbstractC7185ho {

    /* renamed from: a */
    private static C7186hp f33088a = new C7186hp();

    /* renamed from: a */
    private static String m43811a(String str, Object[] objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: b */
    public static void m43820b(String str, String str2) {
        f33088a.m43837b(4, str, str2);
    }

    /* renamed from: c */
    public static void m43823c(String str, String str2) {
        f33088a.m43837b(5, str, str2);
    }

    /* renamed from: d */
    public static void m43826d(String str, String str2) {
        f33088a.m43837b(6, str, str2);
    }

    /* renamed from: e */
    private static String m43829e() {
        return "HiAd-3.4.76.300";
    }

    /* renamed from: a */
    public static void m43812a(int i10, String str, String str2) {
        f33088a.m43831a(i10, str, str2);
        f33088a.m43835a(str2, "\n============================================================================\n====== " + m43829e() + "\n====== Brand: " + Build.BRAND + " Model: " + Build.MODEL + " Release: " + Build.VERSION.RELEASE + " API: " + Build.VERSION.SDK_INT + "\n============================================================================");
    }

    /* renamed from: b */
    public static void m43821b(String str, String str2, Object... objArr) {
        if (!m43822b() || str2 == null) {
            return;
        }
        m43820b(str, m43811a(str2, objArr));
    }

    /* renamed from: c */
    public static void m43824c(String str, String str2, Object... objArr) {
        if (!m43825c() || str2 == null) {
            return;
        }
        m43823c(str, m43811a(str2, objArr));
    }

    /* renamed from: d */
    public static void m43827d(String str, String str2, Object... objArr) {
        if (!m43828d() || str2 == null) {
            return;
        }
        m43826d(str, m43811a(str2, objArr));
    }

    /* renamed from: a */
    public static void m43813a(int i10, String str, String str2, Throwable th2) {
        f33088a.m43832a(i10, str, str2, th2);
    }

    /* renamed from: b */
    public static boolean m43822b() {
        return f33088a.m43836a(4);
    }

    /* renamed from: c */
    public static boolean m43825c() {
        return f33088a.m43836a(5);
    }

    /* renamed from: d */
    public static boolean m43828d() {
        return f33088a.m43836a(6);
    }

    /* renamed from: a */
    public static void m43814a(int i10, String str, Throwable th2) {
        f33088a.m43833a(i10, str, th2);
    }

    /* renamed from: a */
    public static void m43815a(int i10, Throwable th2) {
        f33088a.m43833a(i10, "", th2);
    }

    /* renamed from: a */
    public static void m43816a(Integer num) {
        f33088a.m43834a(num);
    }

    /* renamed from: a */
    public static void m43817a(String str, String str2) {
        f33088a.m43837b(3, str, str2);
    }

    /* renamed from: a */
    public static void m43818a(String str, String str2, Object... objArr) {
        if (!m43819a() || str2 == null) {
            return;
        }
        m43817a(str, m43811a(str2, objArr));
    }

    /* renamed from: a */
    public static boolean m43819a() {
        return f33088a.m43836a(3);
    }
}
