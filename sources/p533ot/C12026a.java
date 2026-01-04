package p533ot;

import java.util.Iterator;
import java.util.List;
import mt.C11518e;
import mt.C11522i;
import p590qt.C12410r;

/* renamed from: ot.a */
/* loaded from: classes5.dex */
public class C12026a {
    /* renamed from: a */
    public static boolean m72156a(List<C11518e> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "DistanceUtils: points is null or empty");
        return false;
    }

    /* renamed from: b */
    public static double m72157b(C11518e c11518e, C11518e c11518e2) {
        if (c11518e != null && c11518e2 != null) {
            return m72160e(new double[]{c11518e.m68734n().m68750j(), c11518e.m68734n().m68747g()}, new double[]{c11518e2.m68734n().m68750j(), c11518e2.m68734n().m68747g()});
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "distSquare(): point is null or illegal");
        return 0.0d;
    }

    /* renamed from: c */
    public static double m72158c(C11518e c11518e, C11522i c11522i) {
        if (c11518e != null && c11522i != null) {
            return m72160e(new double[]{c11518e.m68734n().m68750j(), c11518e.m68734n().m68747g()}, new double[]{c11522i.m68771g(), c11522i.m68770f()});
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "distSquare(): point is null or illegal");
        return 0.0d;
    }

    /* renamed from: d */
    public static double m72159d(C11518e c11518e, double[] dArr) {
        if (c11518e != null) {
            return m72160e(new double[]{c11518e.m68734n().m68750j(), c11518e.m68734n().m68747g()}, dArr);
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "distSquare(): point is null or illegal");
        return 0.0d;
    }

    /* renamed from: e */
    public static double m72160e(double[] dArr, double[] dArr2) {
        if (dArr != null && dArr2 != null && dArr.length == 2 && dArr2.length == 2) {
            return Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d);
        }
        C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "distSquare(): point is null or illegal");
        return 0.0d;
    }

    /* renamed from: f */
    public static double[] m72161f(List<C11518e> list) {
        if (!m72156a(list)) {
            return new double[2];
        }
        double dM68750j = 0.0d;
        double dM68747g = 0.0d;
        for (C11518e c11518e : list) {
            dM68750j += c11518e.m68734n().m68750j();
            dM68747g += c11518e.m68734n().m68747g();
        }
        return new double[]{dM68750j / list.size(), dM68747g / list.size()};
    }

    /* renamed from: g */
    public static double m72162g(List<C11518e> list) {
        double dM72159d = 0.0d;
        if (!m72156a(list)) {
            return 0.0d;
        }
        double[] dArrM72161f = m72161f(list);
        Iterator<C11518e> it = list.iterator();
        while (it.hasNext()) {
            dM72159d += m72159d(it.next(), dArrM72161f);
        }
        return Math.sqrt(dM72159d / list.size());
    }
}
