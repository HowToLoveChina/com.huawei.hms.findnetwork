package p295fs;

import as.C1016d;

/* renamed from: fs.b */
/* loaded from: classes8.dex */
public class C9768b {
    /* renamed from: a */
    public static C9769c m60797a(double d10, double d11, int i10) {
        if (i10 == 1) {
            return m60798b(d10, d11);
        }
        C1016d.m6183c("CoordinateUtil", "coordType is not 84");
        return null;
    }

    /* renamed from: b */
    public static C9769c m60798b(double d10, double d11) {
        return m60800d(d10, d11, 1);
    }

    /* renamed from: c */
    public static boolean m60799c(double d10, double d11) {
        return d10 >= -90.0d && d10 <= 90.0d && d11 >= -180.0d && d11 <= 180.0d;
    }

    /* renamed from: d */
    public static C9769c m60800d(double d10, double d11, int i10) {
        if (i10 != 1 || m60799c(d10, d11)) {
            return C9767a.m60794a(d10, d11, 1);
        }
        C1016d.m6183c("CoordinateUtil", "transform latLon is not Valid Coordinates");
        return null;
    }
}
