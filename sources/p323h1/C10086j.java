package p323h1;

import p244e1.AbstractC9377a;

/* renamed from: h1.j */
/* loaded from: classes.dex */
public class C10086j {

    /* renamed from: a */
    public final String[] f49260a;

    /* renamed from: b */
    public final int f49261b;

    public C10086j(int i10) {
        this.f49261b = i10 - 1;
        this.f49260a = new String[i10];
        m62877a("$ref", 0, 4, 1185263);
        String str = AbstractC9377a.f46780c;
        m62877a(str, 0, str.length(), AbstractC9377a.f46780c.hashCode());
    }

    /* renamed from: d */
    public static String m62876d(String str, int i10, int i11) {
        char[] cArr = new char[i11];
        str.getChars(i10, i11 + i10, cArr, 0);
        return new String(cArr);
    }

    /* renamed from: a */
    public String m62877a(String str, int i10, int i11, int i12) {
        return m62878b(str, i10, i11, i12, false);
    }

    /* renamed from: b */
    public String m62878b(String str, int i10, int i11, int i12, boolean z10) {
        int i13 = this.f49261b & i12;
        String str2 = this.f49260a[i13];
        if (str2 == null) {
            if (i11 != str.length()) {
                str = m62876d(str, i10, i11);
            }
            String strIntern = str.intern();
            this.f49260a[i13] = strIntern;
            return strIntern;
        }
        if (i12 == str2.hashCode() && i11 == str2.length() && str.startsWith(str2, i10)) {
            return str2;
        }
        String strM62876d = m62876d(str, i10, i11);
        if (z10) {
            this.f49260a[i13] = strM62876d;
        }
        return strM62876d;
    }

    /* renamed from: c */
    public String m62879c(char[] cArr, int i10, int i11, int i12) {
        int i13 = this.f49261b & i12;
        String str = this.f49260a[i13];
        if (str == null) {
            String strIntern = new String(cArr, i10, i11).intern();
            this.f49260a[i13] = strIntern;
            return strIntern;
        }
        if (i12 == str.hashCode() && i11 == str.length()) {
            for (int i14 = 0; i14 < i11; i14++) {
                if (cArr[i10 + i14] == str.charAt(i14)) {
                }
            }
            return str;
        }
        return new String(cArr, i10, i11);
    }
}
