package p384j4;

import java.util.Locale;
import java.util.regex.Pattern;
import p405jt.AbstractC10915a;

/* renamed from: j4.f */
/* loaded from: classes.dex */
public abstract class AbstractC10707f {

    /* renamed from: a */
    public static final Pattern f51357a = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

    /* renamed from: a */
    public static String m65376a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    /* renamed from: b */
    public static String m65377b(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    /* renamed from: c */
    public static String m65378c(String str, Object[] objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Throwable unused) {
            return str;
        }
    }

    /* renamed from: d */
    public static boolean m65379d(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: e */
    public static String m65380e(String[] strArr) {
        if (AbstractC10706e.m65375b(strArr)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        int length = strArr.length;
        boolean z10 = true;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            if (!z10) {
                sb2.append(",");
            }
            sb2.append("'");
            sb2.append(str);
            sb2.append("'");
            i10++;
            z10 = false;
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* renamed from: f */
    public static Byte m65381f(String str) {
        if (m65379d(str)) {
            return null;
        }
        try {
            return Byte.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC10915a.m65970b("StringUtils", "toByte " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: g */
    public static Double m65382g(String str) {
        if (m65379d(str)) {
            return null;
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC10915a.m65970b("StringUtils", "toDouble " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: h */
    public static Float m65383h(String str) {
        if (m65379d(str)) {
            return null;
        }
        try {
            return Float.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC10915a.m65970b("StringUtils", "toFloat " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: i */
    public static Integer m65384i(String str) {
        if (m65379d(str)) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC10915a.m65970b("StringUtils", "toInteger " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: j */
    public static Long m65385j(String str) {
        if (m65379d(str)) {
            return null;
        }
        try {
            return Long.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC10915a.m65970b("StringUtils", "toLong " + e10.getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: k */
    public static Short m65386k(String str) {
        if (m65379d(str)) {
            return null;
        }
        try {
            return Short.valueOf(str);
        } catch (NumberFormatException e10) {
            AbstractC10915a.m65970b("StringUtils", "toShort " + e10.getClass().getSimpleName());
            return null;
        }
    }
}
