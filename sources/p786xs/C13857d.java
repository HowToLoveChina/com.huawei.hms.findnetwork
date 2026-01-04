package p786xs;

import as.C1016d;

/* renamed from: xs.d */
/* loaded from: classes8.dex */
public final class C13857d {

    /* renamed from: a */
    public C13861h f62140a;

    /* renamed from: b */
    public Long f62141b;

    public C13857d(Long l10, C13861h c13861h) {
        this.f62141b = l10;
        this.f62140a = c13861h;
    }

    /* renamed from: a */
    public final Long[] m83168a() {
        double[] dArr;
        C13861h c13861hM83186a = C13864k.m83186a(this.f62141b.longValue());
        C13861h c13861h = this.f62140a;
        double d10 = c13861hM83186a.f62146b;
        double d11 = c13861h.f62146b;
        double radians = Math.toRadians(c13861hM83186a.f62145a);
        double radians2 = Math.toRadians(c13861h.f62145a);
        double radians3 = Math.toRadians(d11 - d10);
        double degrees = (Math.toDegrees(Math.atan2(Math.sin(radians3) * Math.cos(radians2), (Math.sin(radians2) * Math.cos(radians)) - (Math.cos(radians3) * (Math.cos(radians2) * Math.sin(radians))))) + 360.0d) % 360.0d;
        double d12 = 0.0d;
        if (degrees < 0.0d || degrees > 360.0d) {
            C1016d.m6186f("TileIdPrediction", "illegal degree, return null");
            dArr = new double[0];
        } else {
            dArr = (0.0d > degrees || degrees >= 90.0d) ? (90.0d > degrees || degrees >= 180.0d) ? (180.0d > degrees || degrees >= 270.0d) ? new double[]{270.0d, 315.0d, 360.0d} : new double[]{180.0d, 225.0d, 270.0d} : new double[]{90.0d, 135.0d, 180.0d} : new double[]{0.0d, 45.0d, 90.0d};
        }
        int length = dArr.length;
        C13861h[] c13861hArr = new C13861h[length];
        int i10 = 0;
        while (i10 < dArr.length) {
            double d13 = c13861hM83186a.f62146b;
            double d14 = c13861hM83186a.f62145a;
            double radians4 = Math.toRadians(dArr[i10]);
            double dSin = Math.sin(radians4);
            double dCos = Math.cos(radians4);
            double dTan = Math.tan(Math.toRadians(d14)) * 0.996647189336d;
            double dSqrt = 1.0d / Math.sqrt((dTan * dTan) + 1.0d);
            double d15 = dTan * dSqrt;
            double dAtan2 = Math.atan2(dTan, dCos);
            double d16 = dSqrt * dSin;
            double d17 = d16 * d16;
            double d18 = 1.0d - d17;
            double d19 = (2.723316066819453E11d * d18) / 4.0408299984087055E13d;
            double d20 = (((((74.0d - (47.0d * d19)) * d19) - 128.0d) * d19) + 256.0d) * (d19 / 1024.0d);
            double d21 = 500.0d / ((((((((320.0d - (175.0d * d19)) * d19) - 768.0d) * d19) + 4096.0d) * (d19 / 16384.0d)) + 1.0d) * 6356752.3142d);
            double dSin2 = d12;
            double dCos2 = dSin2;
            double dCos3 = dCos2;
            double d22 = 6.283185307179586d;
            double d23 = d21;
            while (Math.abs(d23 - d22) > 1.0E-12d) {
                dCos3 = Math.cos((dAtan2 * 2.0d) + d23);
                dSin2 = Math.sin(d23);
                dCos2 = Math.cos(d23);
                d22 = d23;
                d23 = ((((((((2.0d * dCos3) * dCos3) - 1.0d) * dCos2) - ((((4.0d * dCos3) * dCos3) - 3.0d) * ((((dSin2 * 4.0d) * dSin2) - 3.0d) * ((d20 / 6.0d) * dCos3)))) * (d20 / 4.0d)) + dCos3) * d20 * dSin2) + d21;
            }
            double d24 = d15 * dSin2;
            double d25 = dSqrt * dCos2;
            double d26 = d24 - (d25 * dCos);
            double d27 = (((4.0d - (d18 * 3.0d)) * 0.003352810664d) + 4.0d) * 2.095506665E-4d * d18;
            c13861hArr[i10] = new C13861h(Math.toDegrees(Math.atan2((dSqrt * dSin2 * dCos) + (d15 * dCos2), Math.sqrt((d26 * d26) + d17) * 0.996647189336d)), Math.toDegrees(Math.atan2(dSin * dSin2, d25 - (d24 * dCos)) - ((((((((2.0d * dCos3) * dCos3) - 1.0d) * (d27 * dCos2)) + dCos3) * (dSin2 * d27)) + d23) * (((1.0d - d27) * 0.003352810664d) * d16))) + d13);
            i10++;
            dArr = dArr;
            length = length;
            d12 = 0.0d;
        }
        int i11 = length;
        Long[] lArr = new Long[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            C13861h c13861h2 = c13861hArr[i12];
            lArr[i12] = Long.valueOf(C13862i.m83183a(c13861h2.f62146b, c13861h2.f62145a));
        }
        return lArr;
    }
}
