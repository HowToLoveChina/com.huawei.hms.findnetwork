package p499nt;

import java.util.List;
import java.util.Locale;
import mt.C11518e;
import p533ot.C12030e;
import p590qt.C12410r;

/* renamed from: nt.a */
/* loaded from: classes5.dex */
public class C11747a {

    /* renamed from: a */
    public double[] f54313a = new double[0];

    /* renamed from: a */
    public final double m70059a(double[] dArr) {
        double d10 = 0.0d;
        if (dArr == null || dArr.length == 0) {
            return 0.0d;
        }
        for (double d11 : dArr) {
            d10 += d11;
        }
        return d10 / dArr.length;
    }

    /* renamed from: b */
    public final void m70060b() {
        double dMax = 0.0d;
        int i10 = 0;
        for (double d10 : this.f54313a) {
            dMax = Math.max(dMax, d10);
        }
        if (dMax <= 1.0E-4d) {
            return;
        }
        while (true) {
            double[] dArr = this.f54313a;
            if (i10 >= dArr.length) {
                return;
            }
            dArr[i10] = dArr[i10] / dMax;
            i10++;
        }
    }

    /* renamed from: c */
    public final double m70061c(C11518e c11518e) {
        double dM68738a = c11518e.m68730j().m68738a();
        double[] dArr = {-40.0d, -60.0d, -80.0d, -100.0d, -120.0d};
        double[] dArr2 = {100.0d, 80.0d, 60.0d, 40.0d, 20.0d};
        if (dM68738a >= dArr[0]) {
            return dArr2[0];
        }
        for (int i10 = 1; i10 < 5; i10++) {
            double d10 = dArr[i10];
            if (dM68738a >= d10) {
                double d11 = dArr2[i10];
                int i11 = i10 - 1;
                double d12 = dArr2[i11];
                double d13 = dArr[i11];
                return (((d11 - d12) / (d10 - d13)) * (dM68738a - d13)) + d12;
            }
        }
        return 0.0d;
    }

    /* renamed from: d */
    public final double m70062d(double[] dArr) {
        double d10 = 0.0d;
        if (dArr == null || dArr.length == 0) {
            return 0.0d;
        }
        double dM70059a = m70059a(dArr);
        for (double d11 : dArr) {
            double d12 = d11 - dM70059a;
            d10 += d12 * d12;
        }
        return d10 / dArr.length;
    }

    /* renamed from: e */
    public final double m70063e(C11518e c11518e) {
        return c11518e.m68731k();
    }

    /* renamed from: f */
    public void m70064f(List<C11518e> list) {
        if (list == null || list.isEmpty()) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", "infos is null or empty!");
            return;
        }
        if (list.size() > 5000) {
            C12410r.m74523d().mo57439a("ALG-PolarisTagPosition", String.format(Locale.ENGLISH, "infos size > %d", 5000));
            return;
        }
        this.f54313a = new double[list.size()];
        double[] dArr = new double[list.size()];
        double[] dArr2 = new double[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            C11518e c11518e = list.get(i10);
            dArr[i10] = m70061c(c11518e) / 100.0d;
            dArr2[i10] = m70063e(c11518e);
        }
        double dM70062d = m70062d(dArr2) / 0.25d;
        boolean zM72169d = C12030e.m72169d(C12030e.m72173h(list));
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f54313a[i11] = (dArr[i11] * 0.2d) + (dArr2[i11] * dM70062d * 0.8d);
            if (list.get(i11).m68734n().m68749i() == 1 && zM72169d) {
                double[] dArr3 = this.f54313a;
                dArr3[i11] = dArr3[i11] * 4.0d;
            }
            if (list.get(i11).m68731k() >= 0.98d) {
                double[] dArr4 = this.f54313a;
                dArr4[i11] = dArr4[i11] * 2.0d;
            }
        }
        m70060b();
    }

    /* renamed from: g */
    public double m70065g(int i10) {
        if (i10 < 0) {
            return 0.0d;
        }
        double[] dArr = this.f54313a;
        if (i10 < dArr.length) {
            return dArr[i10];
        }
        return 0.0d;
    }
}
