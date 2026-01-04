package androidx.appcompat.app;

/* renamed from: androidx.appcompat.app.p */
/* loaded from: classes.dex */
public class C0391p {

    /* renamed from: d */
    public static C0391p f1390d;

    /* renamed from: a */
    public long f1391a;

    /* renamed from: b */
    public long f1392b;

    /* renamed from: c */
    public int f1393c;

    /* renamed from: b */
    public static C0391p m2252b() {
        if (f1390d == null) {
            f1390d = new C0391p();
        }
        return f1390d;
    }

    /* renamed from: a */
    public void m2253a(long j10, double d10, double d11) {
        double d12 = (0.01720197f * ((j10 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double dSin = (Math.sin(d12) * 0.03341960161924362d) + d12 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double dRound = Math.round((r3 - 9.0E-4f) - r7) + 9.0E-4f + ((-d11) / 360.0d) + (Math.sin(d12) * 0.0053d) + (Math.sin(2.0d * dSin) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin) * Math.sin(0.4092797040939331d));
        double d13 = 0.01745329238474369d * d10;
        double dSin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d13) * Math.sin(dAsin))) / (Math.cos(d13) * Math.cos(dAsin));
        if (dSin2 >= 1.0d) {
            this.f1393c = 1;
            this.f1391a = -1L;
            this.f1392b = -1L;
        } else {
            if (dSin2 <= -1.0d) {
                this.f1393c = 0;
                this.f1391a = -1L;
                this.f1392b = -1L;
                return;
            }
            double dAcos = (float) (Math.acos(dSin2) / 6.283185307179586d);
            this.f1391a = Math.round((dRound + dAcos) * 8.64E7d) + 946728000000L;
            long jRound = Math.round((dRound - dAcos) * 8.64E7d) + 946728000000L;
            this.f1392b = jRound;
            if (jRound >= j10 || this.f1391a <= j10) {
                this.f1393c = 1;
            } else {
                this.f1393c = 0;
            }
        }
    }
}
