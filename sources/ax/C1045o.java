package ax;

import kw.AbstractC11165b;
import p692uw.C13267j;
import p790xw.C13885n;

/* renamed from: ax.o */
/* loaded from: classes9.dex */
public class C1045o extends C1044n {
    /* renamed from: d */
    public static String m6259d(char[] cArr) {
        C13267j.m79677e(cArr, "<this>");
        return new String(cArr);
    }

    /* renamed from: e */
    public static String m6260e(char[] cArr, int i10, int i11) {
        C13267j.m79677e(cArr, "<this>");
        AbstractC11165b.f52506a.m67108a(i10, i11, cArr.length);
        return new String(cArr, i10, i11 - i10);
    }

    /* renamed from: f */
    public static final boolean m6261f(String str, int i10, String str2, int i11, int i12, boolean z10) {
        C13267j.m79677e(str, "<this>");
        C13267j.m79677e(str2, "other");
        return !z10 ? str.regionMatches(i10, str2, i11, i12) : str.regionMatches(z10, i10, str2, i11, i12);
    }

    /* renamed from: g */
    public static final String m6262g(String str, String str2, String str3, boolean z10) {
        C13267j.m79677e(str, "<this>");
        C13267j.m79677e(str2, "oldValue");
        C13267j.m79677e(str3, "newValue");
        int i10 = 0;
        int iM6275n = C1046p.m6275n(str, str2, 0, z10);
        if (iM6275n < 0) {
            return str;
        }
        int length = str2.length();
        int iM83236a = C13885n.m83236a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb2 = new StringBuilder(length2);
        do {
            sb2.append((CharSequence) str, i10, iM6275n);
            sb2.append(str3);
            i10 = iM6275n + length;
            if (iM6275n >= str.length()) {
                break;
            }
            iM6275n = C1046p.m6275n(str, str2, iM6275n + iM83236a, z10);
        } while (iM6275n > 0);
        sb2.append((CharSequence) str, i10, str.length());
        String string = sb2.toString();
        C13267j.m79676d(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    /* renamed from: h */
    public static /* synthetic */ String m6263h(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return m6262g(str, str2, str3, z10);
    }
}
