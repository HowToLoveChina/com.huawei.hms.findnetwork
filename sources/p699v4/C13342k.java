package p699v4;

import com.huawei.android.backup.filelogic.utils.C2111d;

/* renamed from: v4.k */
/* loaded from: classes.dex */
public class C13342k {
    /* renamed from: a */
    public static byte m80052a(String str) {
        if (str == null) {
            return (byte) 0;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ParseNumberUtil", "parse byte catch NumberFormatException");
            return (byte) 0;
        }
    }

    /* renamed from: b */
    public static double m80053b(String str) {
        if (str == null) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ParseNumberUtil", "parseDouble catch NumberFormatException");
            return 0.0d;
        }
    }

    /* renamed from: c */
    public static float m80054c(String str) {
        if (str == null) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ParseNumberUtil", "parseFloat catch NumberFormatException");
            return 0.0f;
        }
    }

    /* renamed from: d */
    public static int m80055d(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ParseNumberUtil", "parseInt catch NumberFormatException");
            return 0;
        }
    }

    /* renamed from: e */
    public static int m80056e(String str, int i10) {
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str, i10);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ParseNumberUtil", "parse int catch NumberFormatException");
            return 0;
        }
    }

    /* renamed from: f */
    public static long m80057f(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ParseNumberUtil", "parseLong catch NumberFormatException");
            return 0L;
        }
    }

    /* renamed from: g */
    public static short m80058g(String str) {
        if (str == null) {
            return (short) 0;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            C2111d.m12648d("ParseNumberUtil", "parse short catch NumberFormatException");
            return (short) 0;
        }
    }
}
