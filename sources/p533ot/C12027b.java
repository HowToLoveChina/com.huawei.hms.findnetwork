package p533ot;

import mt.C11520g;
import p590qt.C12410r;

/* renamed from: ot.b */
/* loaded from: classes5.dex */
public class C12027b {
    /* renamed from: a */
    public static double m72163a(C11520g c11520g, C11520g c11520g2) {
        double dM68747g = c11520g.m68747g() * 0.017453292519943295d;
        double dM68747g2 = c11520g2.m68747g() * 0.017453292519943295d;
        double dM68747g3 = (c11520g2.m68747g() - c11520g.m68747g()) * 0.017453292519943295d;
        double d10 = dM68747g3 / 2.0d;
        double dM68750j = ((c11520g2.m68750j() - c11520g.m68750j()) * 0.017453292519943295d) / 2.0d;
        double dSin = (Math.sin(d10) * Math.sin(d10)) + (Math.cos(dM68747g) * Math.cos(dM68747g2) * Math.sin(dM68750j) * Math.sin(dM68750j));
        return Math.atan2(Math.sqrt(dSin), Math.sqrt(1.0d - dSin)) * 2.0d * 6371000.0d;
    }

    /* renamed from: b */
    public static boolean m72164b(double[] dArr) {
        if (dArr == null || dArr.length != 2) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "pos is null or dimension != 2");
            return false;
        }
        double d10 = dArr[0];
        if (d10 < -180.0d || d10 > 180.0d) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "Longitude illegal");
            return false;
        }
        double d11 = dArr[1];
        if (d11 >= -90.0d && d11 <= 90.0d) {
            return true;
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "Latitude illegal");
        return false;
    }

    /* renamed from: c */
    public static double m72165c(double[] dArr, double[] dArr2) {
        if (m72164b(dArr) && m72164b(dArr2)) {
            return m72163a(new C11520g(dArr[0], dArr[1]), new C11520g(dArr2[0], dArr2[1]));
        }
        return 0.0d;
    }
}
