package p656ti;

/* renamed from: ti.c */
/* loaded from: classes.dex */
public class C13016c extends AbstractC13018e {

    /* renamed from: c */
    public static final char[] f59271c = {'+'};

    /* renamed from: d */
    public static final char[] f59272d = "0123456789ABCDEF".toCharArray();

    /* renamed from: a */
    public final boolean f59273a;

    /* renamed from: b */
    public final boolean[] f59274b;

    public C13016c(String str, boolean z10) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        if (z10 && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        this.f59273a = z10;
        this.f59274b = m78330g(str);
    }

    /* renamed from: g */
    public static boolean[] m78330g(String str) {
        char[] charArray = str.toCharArray();
        int iMax = 122;
        for (char c10 : charArray) {
            iMax = Math.max((int) c10, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (int i10 = 48; i10 <= 57; i10++) {
            zArr[i10] = true;
        }
        for (int i11 = 65; i11 <= 90; i11++) {
            zArr[i11] = true;
        }
        for (int i12 = 97; i12 <= 122; i12++) {
            zArr[i12] = true;
        }
        for (char c11 : charArray) {
            zArr[c11] = true;
        }
        return zArr;
    }

    @Override // p656ti.AbstractC13015b
    /* renamed from: a */
    public String mo78329a(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            boolean[] zArr = this.f59274b;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return m78337d(str, i10);
            }
        }
        return str;
    }

    @Override // p656ti.AbstractC13018e
    /* renamed from: c */
    public char[] mo78331c(int i10) {
        boolean[] zArr = this.f59274b;
        if (i10 < zArr.length && zArr[i10]) {
            return null;
        }
        if (i10 == 32 && this.f59273a) {
            return f59271c;
        }
        if (i10 <= 127) {
            char[] cArr = f59272d;
            return new char[]{'%', cArr[i10 >>> 4], cArr[i10 & 15]};
        }
        if (i10 <= 2047) {
            char[] cArr2 = f59272d;
            char c10 = cArr2[i10 & 15];
            return new char[]{'%', cArr2[(i10 >>> 10) | 12], cArr2[(i10 >>> 6) & 15], '%', cArr2[((i10 >>> 4) & 3) | 8], c10};
        }
        if (i10 <= 65535) {
            char[] cArr3 = f59272d;
            char c11 = cArr3[i10 & 15];
            char c12 = cArr3[((i10 >>> 4) & 3) | 8];
            return new char[]{'%', 'E', cArr3[i10 >>> 12], '%', cArr3[((i10 >>> 10) & 3) | 8], cArr3[(i10 >>> 6) & 15], '%', c12, c11};
        }
        if (i10 > 1114111) {
            throw new IllegalArgumentException("Invalid unicode character value " + i10);
        }
        char[] cArr4 = f59272d;
        char c13 = cArr4[i10 & 15];
        char c14 = cArr4[((i10 >>> 4) & 3) | 8];
        char c15 = cArr4[(i10 >>> 6) & 15];
        char c16 = cArr4[((i10 >>> 10) & 3) | 8];
        return new char[]{'%', 'F', cArr4[(i10 >>> 18) & 7], '%', cArr4[((i10 >>> 16) & 3) | 8], cArr4[(i10 >>> 12) & 15], '%', c16, c15, '%', c14, c13};
    }

    @Override // p656ti.AbstractC13018e
    /* renamed from: f */
    public int mo78332f(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = charSequence.charAt(i10);
            boolean[] zArr = this.f59274b;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i10++;
        }
        return i10;
    }
}
