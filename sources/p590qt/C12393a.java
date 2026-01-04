package p590qt;

import java.math.BigDecimal;
import java.util.List;
import mt.C11518e;
import mt.C11522i;

/* renamed from: qt.a */
/* loaded from: classes5.dex */
public class C12393a {

    /* renamed from: a */
    public static final double f57228a = new BigDecimal(Double.toString(3.141592653589793d)).divide(new BigDecimal(Double.toString(180.0d)), 10, 4).doubleValue();

    /* renamed from: a */
    public static double[] m74475a(double d10, double d11, double[] dArr) {
        double d12 = d10 - dArr[0];
        double d13 = d11 - dArr[1];
        double d14 = f57228a;
        return new double[]{d12 * d14 * 6378137.0d * Math.cos(d14 * d11), d13 * d14 * 6378137.0d};
    }

    /* renamed from: b */
    public static double[] m74476b(double d10, double d11, double[] dArr) {
        double d12 = dArr[1];
        double d13 = f57228a;
        double d14 = d12 + ((d11 / 6378137.0d) / d13);
        return new double[]{dArr[0] + (((d10 / 6378137.0d) / d13) / Math.cos(d13 * d14)), d14};
    }

    /* renamed from: c */
    public static void m74477c(List<C11518e> list, double[] dArr) {
        if (dArr == null || dArr.length != 2) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "refPos size != 2 error");
            return;
        }
        for (C11518e c11518e : list) {
            if (c11518e.m68734n().m68753m()) {
                double[] dArrM74476b = m74476b(c11518e.m68734n().m68750j(), c11518e.m68734n().m68747g(), dArr);
                c11518e.m68734n().m68762v(dArrM74476b[0]);
                c11518e.m68734n().m68761u(dArrM74476b[1]);
                c11518e.m68734n().m68757q(false);
            } else {
                C12410r.m74523d().mo57440b("ALG-PolarisTagPosition", c11518e.m68730j().m68739b() + " isEnu == False, bypass convert");
            }
        }
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "convert to GNSS done.");
    }

    /* renamed from: d */
    public static void m74478d(C11522i c11522i, double[] dArr) {
        if (dArr == null || dArr.length != 2) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "refPos size != 2 error");
            return;
        }
        double[] dArrM74476b = m74476b(c11522i.m68771g(), c11522i.m68770f(), dArr);
        c11522i.m68784t(dArrM74476b[0]);
        c11522i.m68783s(dArrM74476b[1]);
    }

    /* renamed from: e */
    public static void m74479e(List<C11518e> list, double[] dArr) {
        if (dArr == null || dArr.length != 2) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "refPos size != 2 error");
            return;
        }
        for (C11518e c11518e : list) {
            if (c11518e.m68734n().m68753m()) {
                C12410r.m74523d().mo57440b("ALG-PolarisTagPosition", c11518e.m68730j().m68739b() + " isEnu == True, bypass convert");
            } else {
                double[] dArrM74475a = m74475a(c11518e.m68734n().m68750j(), c11518e.m68734n().m68747g(), dArr);
                c11518e.m68734n().m68762v(dArrM74475a[0]);
                c11518e.m68734n().m68761u(dArrM74475a[1]);
                c11518e.m68734n().m68757q(true);
            }
        }
        C12410r.m74523d().mo57441c("ALG-PolarisTagPosition", "convert to ENU done.");
    }
}
