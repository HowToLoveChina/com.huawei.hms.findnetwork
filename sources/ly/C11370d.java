package ly;

/* renamed from: ly.d */
/* loaded from: classes9.dex */
public final class C11370d {

    /* renamed from: a */
    public static final byte[] f53098a = new byte[0];

    /* renamed from: a */
    public static void m68218a(int i10) {
        if (i10 > 8) {
            throw new IllegalArgumentException("Can't read more than eight bytes into a long value");
        }
    }

    /* renamed from: b */
    public static long m68219b(byte[] bArr, int i10, int i11) {
        m68218a(i11);
        long j10 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j10 |= (bArr[i10 + i12] & 255) << (i12 * 8);
        }
        return j10;
    }
}
