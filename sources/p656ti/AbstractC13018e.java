package p656ti;

/* renamed from: ti.e */
/* loaded from: classes.dex */
public abstract class AbstractC13018e extends AbstractC13015b {
    /* renamed from: b */
    public static int m78335b(CharSequence charSequence, int i10, int i11) {
        if (i10 >= i11) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i12 = i10 + 1;
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + i10);
        }
        if (i12 == i11) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i12);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i12);
    }

    /* renamed from: e */
    public static char[] m78336e(char[] cArr, int i10, int i11) {
        char[] cArr2 = new char[i11];
        if (i10 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i10);
        }
        return cArr2;
    }

    /* renamed from: c */
    public abstract char[] mo78331c(int i10);

    /* renamed from: d */
    public final String m78337d(String str, int i10) {
        int length = str.length();
        char[] cArrM78333a = C13017d.m78333a();
        int i11 = 0;
        int length2 = 0;
        while (i10 < length) {
            int iM78335b = m78335b(str, i10, length);
            if (iM78335b < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrMo78331c = mo78331c(iM78335b);
            int i12 = (Character.isSupplementaryCodePoint(iM78335b) ? 2 : 1) + i10;
            if (cArrMo78331c != null) {
                int i13 = i10 - i11;
                int i14 = length2 + i13;
                int length3 = cArrMo78331c.length + i14;
                if (cArrM78333a.length < length3) {
                    cArrM78333a = m78336e(cArrM78333a, length2, ((length3 + length) - i10) + 32);
                }
                if (i13 > 0) {
                    str.getChars(i11, i10, cArrM78333a, length2);
                    length2 = i14;
                }
                if (cArrMo78331c.length > 0) {
                    System.arraycopy(cArrMo78331c, 0, cArrM78333a, length2, cArrMo78331c.length);
                    length2 += cArrMo78331c.length;
                }
                i11 = i12;
            }
            i10 = mo78332f(str, i12, length);
        }
        int i15 = length - i11;
        if (i15 > 0) {
            int i16 = i15 + length2;
            if (cArrM78333a.length < i16) {
                cArrM78333a = m78336e(cArrM78333a, length2, i16);
            }
            str.getChars(i11, length, cArrM78333a, length2);
            length2 = i16;
        }
        return new String(cArrM78333a, 0, length2);
    }

    /* renamed from: f */
    public abstract int mo78332f(CharSequence charSequence, int i10, int i11);
}
