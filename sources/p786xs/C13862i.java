package p786xs;

/* renamed from: xs.i */
/* loaded from: classes8.dex */
public final class C13862i {
    /* renamed from: a */
    public static long m83183a(double d10, double d11) {
        double d12 = -90.0d;
        double d13 = 90.0d;
        double d14 = -180.0d;
        double d15 = 180.0d;
        long j10 = 0;
        boolean z10 = true;
        for (long j11 = Long.MIN_VALUE; j11 != 4294967296L; j11 >>>= 1) {
            if (z10) {
                double d16 = (d14 + d15) / 2.0d;
                if (d10 >= d16) {
                    j10 |= j11;
                    d14 = d16;
                } else {
                    d15 = d16;
                }
            } else {
                double d17 = (d12 + d13) / 2.0d;
                if (d11 >= d17) {
                    j10 |= j11;
                    d12 = d17;
                } else {
                    d13 = d17;
                }
            }
            z10 = !z10;
        }
        return (15 << 59) | (j10 >>> 5);
    }
}
