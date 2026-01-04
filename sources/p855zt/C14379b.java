package p855zt;

/* renamed from: zt.b */
/* loaded from: classes5.dex */
public class C14379b {
    /* renamed from: a */
    public static String m85598a(String str, char c10) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = c10;
        }
        return new String(cArr);
    }

    /* renamed from: b */
    public static String m85599b(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(strArr[0]);
        for (int i10 = 1; i10 < strArr.length; i10++) {
            if (strArr[i10] != null) {
                sb2.append(str);
                sb2.append(strArr[i10]);
            }
        }
        return sb2.toString();
    }

    /* renamed from: c */
    public static String m85600c(String[] strArr, int i10) {
        return (strArr == null || strArr.length <= 0 || i10 < 0 || i10 >= strArr.length) ? "" : strArr[i10];
    }

    /* renamed from: d */
    public static String[] m85601d(String str, int i10) {
        return str == null ? new String[]{"", ""} : (i10 < 0 || i10 > str.length()) ? new String[]{str, ""} : new String[]{str.substring(0, i10), str.substring(i10)};
    }

    /* renamed from: e */
    public static String[] m85602e(String str, int i10, int i11) {
        String[] strArrM85601d = m85601d(str, i10);
        return m85604g(m85600c(strArrM85601d, 0), m85601d(m85600c(strArrM85601d, 1), i11 - i10));
    }

    /* renamed from: f */
    public static String[] m85603f(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        }
        if (strArr2.length <= 0) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    /* renamed from: g */
    public static String[] m85604g(String str, String[] strArr) {
        return m85603f(new String[]{str}, strArr);
    }
}
