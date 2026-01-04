package p015ak;

import p399jk.AbstractC10896a;

/* renamed from: ak.z */
/* loaded from: classes6.dex */
public class C0241z {
    /* renamed from: a */
    public static Double m1683a(String str, Double d10) {
        if (str != null && !str.isEmpty()) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException e10) {
                AbstractC10896a.m65886e("ParseUtil", "parseDouble error " + e10.toString());
            }
        }
        return d10;
    }

    /* renamed from: b */
    public static float m1684b(String str) {
        if (str == null || str.isEmpty()) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e10) {
            AbstractC10896a.m65886e("ParseUtil", "parseFloat error " + e10.toString());
            return 0.0f;
        }
    }

    /* renamed from: c */
    public static int m1685c(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            AbstractC10896a.m65886e("ParseUtil", "parseInt error " + e10.toString());
            return 0;
        }
    }

    /* renamed from: d */
    public static int m1686d(String str, int i10) {
        if (str != null && !str.isEmpty()) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e10) {
                AbstractC10896a.m65886e("ParseUtil", "parseInt error " + e10.toString());
            }
        }
        return i10;
    }

    /* renamed from: e */
    public static int m1687e(String str, int i10, int i11) {
        if (str != null && !str.isEmpty()) {
            try {
                return Integer.parseInt(str, i10);
            } catch (NumberFormatException e10) {
                AbstractC10896a.m65886e("ParseUtil", "parseInt error " + e10.toString());
            }
        }
        return i11;
    }

    /* renamed from: f */
    public static long m1688f(String str) {
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e10) {
            AbstractC10896a.m65888w("ParseUtil", "parseLong error " + e10.toString());
            return 0L;
        }
    }

    /* renamed from: g */
    public static long m1689g(String str, long j10) {
        if (str != null && !str.isEmpty()) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e10) {
                AbstractC10896a.m65886e("ParseUtil", "parseLong error " + e10.toString());
            }
        }
        return j10;
    }
}
