package p348hw;

/* renamed from: hw.d */
/* loaded from: classes9.dex */
public class C10349d {

    /* renamed from: a */
    public int f50046a;

    /* renamed from: b */
    public double[] f50047b;

    /* renamed from: c */
    public double[] f50048c;

    /* renamed from: a */
    public final double[] m63724a(double[] dArr) {
        if (dArr.length < 2) {
            return new double[0];
        }
        int length = dArr.length / 2;
        double[] dArr2 = new double[length * 2];
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = i10; i11 > 0; i11--) {
                int i12 = i11 * 2;
                int i13 = i10 * 2;
                int i14 = (i11 - 1) * 2;
                int i15 = i13 + 1;
                int i16 = i14 + 1;
                dArr2[i12] = dArr2[i12] + ((dArr[i13] * dArr2[i14]) - (dArr[i15] * dArr2[i16]));
                int i17 = i12 + 1;
                dArr2[i17] = dArr2[i17] + (dArr[i13] * dArr2[i16]) + (dArr[i15] * dArr2[i14]);
            }
            int i18 = i10 * 2;
            dArr2[0] = dArr2[0] + dArr[i18];
            dArr2[1] = dArr2[1] + dArr[i18 + 1];
        }
        return dArr2;
    }

    /* renamed from: b */
    public final double[] m63725b(int i10, double d10) {
        if (i10 <= 2) {
            return new double[0];
        }
        int i11 = i10 * 2;
        double[] dArr = new double[i11];
        double d11 = 3.141592653589793d;
        double d12 = d10 * 3.141592653589793d;
        double dSin = Math.sin(d12);
        double dCos = Math.cos(d12);
        double d13 = 0.0d;
        int i12 = 0;
        while (i12 < i10) {
            if (i10 > 0) {
                d13 = (((i12 * 2) + 1) * d11) / i11;
            }
            double dSin2 = Math.sin(d13);
            double dCos2 = Math.cos(d13);
            double d14 = (dSin2 * dSin) + 1.0d;
            int i13 = i12 * 2;
            dArr[i13] = (-dCos) / d14;
            dArr[i13 + 1] = ((-dSin) * dCos2) / d14;
            i12++;
            i11 = i11;
            d11 = 3.141592653589793d;
        }
        double[] dArrM63724a = m63724a(dArr);
        int i14 = i10 + 1;
        double[] dArr2 = new double[i14];
        dArr2[0] = 1.0d;
        dArr2[1] = dArrM63724a[0];
        dArr2[2] = dArrM63724a[2];
        for (int i15 = 3; i15 < i14; i15++) {
            dArr2[i15] = dArrM63724a[(i15 * 2) - 2];
        }
        return dArr2;
    }

    /* renamed from: c */
    public final double[] m63726c(int i10, double d10, double d11, boolean z10) {
        double d12;
        int i11 = i10;
        int i12 = 0;
        if (i11 <= 2) {
            return new double[0];
        }
        double d13 = 3.141592653589793d;
        double dCos = Math.cos(((d11 + d10) * 3.141592653589793d) / 2.0d);
        double d14 = ((d11 - d10) * 3.141592653589793d) / 2.0d;
        double dSin = Math.sin(d14);
        double dCos2 = Math.cos(d14);
        double d15 = dSin * 2.0d * dCos2;
        double d16 = ((dCos2 * 2.0d) * dCos2) - 1.0d;
        int i13 = i11 * 2;
        double[] dArr = new double[i13];
        double[] dArr2 = new double[i13];
        double d17 = 0.0d;
        while (i12 < i11) {
            if (i11 > 0) {
                d12 = dCos2;
                d17 = (((i12 * 2) + 1) * d13) / i13;
            } else {
                d12 = dCos2;
            }
            double dSin2 = Math.sin(d17);
            double dCos3 = Math.cos(d17);
            double d18 = (d15 * dSin2) + 1.0d;
            int i14 = i12 * 2;
            dArr[i14] = d16 / d18;
            int i15 = i14 + 1;
            dArr[i15] = (((z10 ? 1.0d : -1.0d) * d15) * dCos3) / d18;
            double d19 = -2.0d;
            double d20 = d12;
            dArr2[i14] = ((dCos * (-2.0d)) * (d20 + (dSin2 * dSin))) / d18;
            if (!z10) {
                d19 = 2.0d;
            }
            dArr2[i15] = (((d19 * dCos) * dSin) * dCos3) / d18;
            i12++;
            i11 = i10;
            dCos2 = d20;
            d13 = 3.141592653589793d;
        }
        double[] dArrM63735l = m63735l(dArr2, dArr);
        int i16 = i13 + 1;
        double[] dArr3 = new double[i16];
        dArr3[0] = 1.0d;
        dArr3[1] = dArrM63735l[0];
        dArr3[2] = dArrM63735l[2];
        for (int i17 = 3; i17 < i16; i17++) {
            dArr3[i17] = dArrM63735l[(i17 * 2) - 2];
        }
        return dArr3;
    }

    /* renamed from: d */
    public final double[] m63727d(int i10, double d10, double d11, boolean z10) {
        if (i10 <= 0) {
            return new double[0];
        }
        int i11 = i10 * 2;
        double[] dArr = new double[i11 + 1];
        if (z10) {
            double[] dArrM63728e = m63728e(i10, false);
            for (int i12 = 0; i12 < i10; i12++) {
                int i13 = i12 * 2;
                dArr[i13] = dArrM63728e[i12];
                dArr[i13 + 1] = 0.0d;
            }
            dArr[i11] = dArrM63728e[i10];
        } else {
            double dCos = Math.cos(((d11 - d10) * 3.141592653589793d) / 2.0d);
            double dCos2 = Math.abs(dCos - 0.0d) > 1.0E-5d ? (Math.cos(((d11 + d10) * 3.141592653589793d) / 2.0d) * (-2.0d)) / dCos : 0.0d;
            dArr[0] = 1.0d;
            dArr[1] = dCos2;
            dArr[2] = 1.0d;
            for (int i14 = 1; i14 < i10; i14++) {
                int i15 = i14 * 2;
                int i16 = i15 + 2;
                dArr[i16] = dArr[i16] + dArr[i15];
                while (i15 > 1) {
                    int i17 = i15 + 1;
                    dArr[i17] = dArr[i17] + (dArr[i15] * dCos2) + dArr[i15 - 1];
                    i15--;
                }
                double d12 = dArr[2];
                double d13 = dArr[1];
                dArr[2] = d12 + (dCos2 * d13) + 1.0d;
                dArr[1] = d13 + dCos2;
            }
        }
        return dArr;
    }

    /* renamed from: e */
    public final double[] m63728e(int i10, boolean z10) {
        if (i10 <= 3) {
            return new double[0];
        }
        int i11 = i10 + 1;
        double[] dArr = new double[i11];
        dArr[0] = 1.0d;
        double d10 = i10;
        dArr[1] = d10;
        for (int i12 = 2; i12 < (i10 / 2) + 1; i12++) {
            double d11 = ((r7 + 1) * dArr[i12 - 1]) / i12;
            dArr[i12] = d11;
            dArr[i10 - i12] = d11;
        }
        dArr[i10 - 1] = d10;
        dArr[i10] = 1.0d;
        if (!z10) {
            for (int i13 = 1; i13 < i11; i13 += 2) {
                dArr[i13] = -dArr[i13];
            }
        }
        return dArr;
    }

    /* renamed from: f */
    public final double m63729f(int i10, double d10, double d11, boolean z10) {
        double dTan = Math.tan(((d11 - d10) * 3.141592653589793d) / 2.0d);
        if (z10) {
            dTan = 1.0d / dTan;
        }
        double d12 = 0.0d;
        double d13 = 1.0d;
        int i11 = 0;
        double d14 = 0.0d;
        while (i11 < i10) {
            if (i10 != 0) {
                d12 = (((i11 * 2) + 1) * 3.141592653589793d) / (i10 * 2);
            }
            double dSin = Math.sin(d12) + dTan;
            double dCos = Math.cos(d12);
            double d15 = (d13 + d14) * (dSin - dCos);
            double d16 = d13 * dSin;
            double d17 = (-d14) * dCos;
            double d18 = d16 - d17;
            d14 = (d15 - d16) - d17;
            i11++;
            d13 = d18;
        }
        return 1.0d / d13;
    }

    /* renamed from: g */
    public final double m63730g(int i10, double d10, boolean z10) {
        if (i10 <= 2) {
            return 0.0d;
        }
        double d11 = d10 * 3.141592653589793d;
        double dSin = Math.sin(d11);
        double d12 = 3.141592653589793d / (i10 * 2);
        double dCos = 1.0d;
        for (int i11 = 0; i11 < i10 / 2; i11++) {
            dCos *= (Math.sin(((i11 * 2) + 1) * d12) * dSin) + 1.0d;
        }
        double d13 = d11 / 2.0d;
        double dSin2 = z10 ? Math.sin(d13) : Math.cos(d13);
        if (i10 % 2 == 1) {
            double d14 = d11 / 2.0d;
            dCos *= (z10 ? Math.cos(d14) : Math.sin(d14)) + dSin2;
        }
        return Math.pow(dSin2, i10) / dCos;
    }

    /* renamed from: h */
    public double[] m63731h() {
        return this.f50048c;
    }

    /* renamed from: i */
    public double[] m63732i() {
        return this.f50047b;
    }

    /* renamed from: j */
    public void m63733j(int i10, double d10, double d11, double d12, boolean z10) {
        double d13;
        this.f50046a = i10;
        double d14 = 0.0d;
        if (Math.abs(d10 - 0.0d) > 1.0E-5d) {
            d14 = (d11 * 2.0d) / d10;
            d13 = (2.0d * d12) / d10;
        } else {
            d13 = 0.0d;
        }
        double d15 = d14;
        double d16 = d13;
        double dM63729f = m63729f(this.f50046a, d15, d16, z10);
        this.f50047b = m63727d(this.f50046a, d15, d16, z10);
        int i11 = 0;
        while (true) {
            double[] dArr = this.f50047b;
            if (i11 >= dArr.length) {
                this.f50048c = m63726c(this.f50046a, d14, d13, z10);
                return;
            } else {
                dArr[i11] = dArr[i11] * dM63729f;
                i11++;
            }
        }
    }

    /* renamed from: k */
    public void m63734k(int i10, double d10, double d11, boolean z10) {
        this.f50046a = i10;
        double d12 = Math.abs(d10 - 0.0d) > 1.0E-5d ? (d11 * 2.0d) / d10 : 0.0d;
        double dM63730g = m63730g(this.f50046a, d12, z10);
        this.f50047b = m63728e(this.f50046a, z10);
        int i11 = 0;
        while (true) {
            double[] dArr = this.f50047b;
            if (i11 >= dArr.length) {
                this.f50048c = m63725b(this.f50046a, d12);
                return;
            } else {
                dArr[i11] = dArr[i11] * dM63730g;
                i11++;
            }
        }
    }

    /* renamed from: l */
    public final double[] m63735l(double[] dArr, double[] dArr2) {
        int length = dArr.length / 2;
        double[] dArr3 = new double[length * 4];
        dArr3[0] = dArr[0];
        dArr3[1] = dArr[1];
        dArr3[2] = dArr2[0];
        dArr3[3] = dArr2[1];
        for (int i10 = 1; i10 < length; i10++) {
            int i11 = i10 * 2;
            int i12 = i11 + 1;
            int i13 = i12 * 2;
            int i14 = (i11 - 1) * 2;
            int i15 = i14 + 1;
            dArr3[i13] = dArr3[i13] + ((dArr2[i11] * dArr3[i14]) - (dArr2[i12] * dArr3[i15]));
            int i16 = i13 + 1;
            dArr3[i16] = dArr3[i16] + (dArr2[i11] * dArr3[i15]) + (dArr2[i12] * dArr3[i14]);
            for (int i17 = i11; i17 > 1; i17--) {
                int i18 = i17 * 2;
                int i19 = (i17 - 1) * 2;
                int i20 = i19 + 1;
                int i21 = (i17 - 2) * 2;
                int i22 = i21 + 1;
                dArr3[i18] = dArr3[i18] + ((((dArr[i11] * dArr3[i19]) - (dArr[i12] * dArr3[i20])) + (dArr2[i11] * dArr3[i21])) - (dArr2[i12] * dArr3[i22]));
                int i23 = i18 + 1;
                dArr3[i23] = dArr3[i23] + (dArr[i11] * dArr3[i20]) + (dArr[i12] * dArr3[i19]) + (dArr2[i11] * dArr3[i22]) + (dArr2[i12] * dArr3[i21]);
            }
            double d10 = dArr3[2];
            double d11 = dArr[i11];
            double d12 = dArr3[0];
            double d13 = dArr[i12];
            double d14 = dArr3[1];
            dArr3[2] = d10 + ((d11 * d12) - (d13 * d14)) + dArr2[i11];
            dArr3[3] = dArr3[3] + (dArr[i11] * d14) + (dArr[i12] * d12) + dArr2[i12];
            dArr3[0] = d12 + dArr[i11];
            dArr3[1] = d14 + dArr[i12];
        }
        return dArr3;
    }
}
