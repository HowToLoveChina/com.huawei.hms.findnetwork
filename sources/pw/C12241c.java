package pw;

/* renamed from: pw.c */
/* loaded from: classes9.dex */
public final class C12241c {
    /* renamed from: a */
    public static final int m73441a(int i10, int i11, int i12) {
        return m73445e(m73445e(i10, i12) - m73445e(i11, i12), i12);
    }

    /* renamed from: b */
    public static final long m73442b(long j10, long j11, long j12) {
        return m73446f(m73446f(j10, j12) - m73446f(j11, j12), j12);
    }

    /* renamed from: c */
    public static final int m73443c(int i10, int i11, int i12) {
        if (i12 > 0) {
            return i10 >= i11 ? i11 : i11 - m73441a(i11, i10, i12);
        }
        if (i12 < 0) {
            return i10 <= i11 ? i11 : i11 + m73441a(i10, i11, -i12);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: d */
    public static final long m73444d(long j10, long j11, long j12) {
        if (j12 > 0) {
            return j10 >= j11 ? j11 : j11 - m73442b(j11, j10, j12);
        }
        if (j12 < 0) {
            return j10 <= j11 ? j11 : j11 + m73442b(j10, j11, -j12);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    /* renamed from: e */
    public static final int m73445e(int i10, int i11) {
        int i12 = i10 % i11;
        return i12 >= 0 ? i12 : i12 + i11;
    }

    /* renamed from: f */
    public static final long m73446f(long j10, long j11) {
        long j12 = j10 % j11;
        return j12 >= 0 ? j12 : j12 + j11;
    }
}
