package st;

import tt.C13069b;

/* renamed from: st.b */
/* loaded from: classes5.dex */
public class C12852b {

    /* renamed from: a */
    public final int f58593a;

    /* renamed from: b */
    public final double[] f58594b;

    /* renamed from: c */
    public final double[][] f58595c;

    /* renamed from: d */
    public final double[] f58596d;

    /* renamed from: e */
    public final double[] f58597e;

    public C12852b(double[] dArr, double[][] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        if (dArr == null || dArr2 == null || dArr3 == null) {
            throw new C13069b("Evaluation input (values or jacobian or target) error", new Object[0]);
        }
        if (dArr4 == null || dArr5 == null) {
            throw new C13069b("Evaluation input (point or weightSqrt) error", new Object[0]);
        }
        if (dArr3.length == 0 || dArr3.length != dArr.length) {
            throw new C13069b("checkVectorDimensions %d,%d", Integer.valueOf(dArr3.length), Integer.valueOf(dArr.length));
        }
        this.f58593a = dArr3.length;
        this.f58595c = dArr2;
        this.f58594b = dArr4;
        this.f58597e = dArr5;
        this.f58596d = m77160a(dArr3, dArr);
    }

    /* renamed from: a */
    public final double[] m77160a(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        double[] dArr3 = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr3[i10] = dArr[i10] - dArr2[i10];
        }
        return dArr3;
    }

    /* renamed from: b */
    public double m77161b() {
        double d10 = 0.0d;
        for (double d11 : m77165f()) {
            d10 += d11 * d11;
        }
        return Math.sqrt(d10);
    }

    /* renamed from: c */
    public double[][] m77162c() {
        double[][] dArr = (double[][]) this.f58595c.clone();
        for (int i10 = 0; i10 < dArr.length; i10++) {
            int i11 = 0;
            while (true) {
                double[] dArr2 = dArr[i10];
                if (i11 < dArr2.length) {
                    dArr2[i11] = dArr2[i11] * this.f58597e[i10];
                    i11++;
                }
            }
        }
        return dArr;
    }

    /* renamed from: d */
    public double[] m77163d() {
        return this.f58594b;
    }

    /* renamed from: e */
    public double m77164e() {
        double dM77161b = m77161b();
        return Math.sqrt((dM77161b * dM77161b) / this.f58593a);
    }

    /* renamed from: f */
    public double[] m77165f() {
        double[] dArr = (double[]) this.f58596d.clone();
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr[i10] = dArr[i10] * this.f58597e[i10];
        }
        return dArr;
    }
}
