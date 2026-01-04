package p504o;

/* renamed from: o.f */
/* loaded from: classes.dex */
public class C11773f extends AbstractC11769b {

    /* renamed from: a */
    public double[] f54430a;

    /* renamed from: b */
    public double[][] f54431b;

    /* renamed from: c */
    public double f54432c;

    /* renamed from: d */
    public boolean f54433d = true;

    /* renamed from: e */
    public double[] f54434e;

    public C11773f(double[] dArr, double[][] dArr2) {
        this.f54432c = Double.NaN;
        int length = dArr2[0].length;
        this.f54434e = new double[length];
        this.f54430a = dArr;
        this.f54431b = dArr2;
        if (length <= 2) {
            return;
        }
        int i10 = 0;
        double d10 = 0.0d;
        while (true) {
            double d11 = d10;
            if (i10 >= dArr.length) {
                this.f54432c = 0.0d;
                return;
            }
            double d12 = dArr2[i10][0];
            if (i10 > 0) {
                Math.hypot(d12 - d10, d12 - d11);
            }
            i10++;
            d10 = d12;
        }
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: c */
    public double mo70097c(double d10, int i10) {
        double[] dArr = this.f54430a;
        int length = dArr.length;
        int i11 = 0;
        if (this.f54433d) {
            double d11 = dArr[0];
            if (d10 <= d11) {
                return this.f54431b[0][i10] + ((d10 - d11) * mo70100f(d11, i10));
            }
            int i12 = length - 1;
            double d12 = dArr[i12];
            if (d10 >= d12) {
                return this.f54431b[i12][i10] + ((d10 - d12) * mo70100f(d12, i10));
            }
        } else {
            if (d10 <= dArr[0]) {
                return this.f54431b[0][i10];
            }
            int i13 = length - 1;
            if (d10 >= dArr[i13]) {
                return this.f54431b[i13][i10];
            }
        }
        while (i11 < length - 1) {
            double[] dArr2 = this.f54430a;
            double d13 = dArr2[i11];
            if (d10 == d13) {
                return this.f54431b[i11][i10];
            }
            int i14 = i11 + 1;
            double d14 = dArr2[i14];
            if (d10 < d14) {
                double d15 = (d10 - d13) / (d14 - d13);
                double[][] dArr3 = this.f54431b;
                return (dArr3[i11][i10] * (1.0d - d15)) + (dArr3[i14][i10] * d15);
            }
            i11 = i14;
        }
        return 0.0d;
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: d */
    public void mo70098d(double d10, double[] dArr) {
        double[] dArr2 = this.f54430a;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.f54431b[0].length;
        if (this.f54433d) {
            double d11 = dArr2[0];
            if (d10 <= d11) {
                mo70101g(d11, this.f54434e);
                for (int i11 = 0; i11 < length2; i11++) {
                    dArr[i11] = this.f54431b[0][i11] + ((d10 - this.f54430a[0]) * this.f54434e[i11]);
                }
                return;
            }
            int i12 = length - 1;
            double d12 = dArr2[i12];
            if (d10 >= d12) {
                mo70101g(d12, this.f54434e);
                while (i10 < length2) {
                    dArr[i10] = this.f54431b[i12][i10] + ((d10 - this.f54430a[i12]) * this.f54434e[i10]);
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr2[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    dArr[i13] = this.f54431b[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr2[i14]) {
                while (i10 < length2) {
                    dArr[i10] = this.f54431b[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f54430a[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    dArr[i16] = this.f54431b[i15][i16];
                }
            }
            double[] dArr3 = this.f54430a;
            int i17 = i15 + 1;
            double d13 = dArr3[i17];
            if (d10 < d13) {
                double d14 = dArr3[i15];
                double d15 = (d10 - d14) / (d13 - d14);
                while (i10 < length2) {
                    double[][] dArr4 = this.f54431b;
                    dArr[i10] = (dArr4[i15][i10] * (1.0d - d15)) + (dArr4[i17][i10] * d15);
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: e */
    public void mo70099e(double d10, float[] fArr) {
        double[] dArr = this.f54430a;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.f54431b[0].length;
        if (this.f54433d) {
            double d11 = dArr[0];
            if (d10 <= d11) {
                mo70101g(d11, this.f54434e);
                for (int i11 = 0; i11 < length2; i11++) {
                    fArr[i11] = (float) (this.f54431b[0][i11] + ((d10 - this.f54430a[0]) * this.f54434e[i11]));
                }
                return;
            }
            int i12 = length - 1;
            double d12 = dArr[i12];
            if (d10 >= d12) {
                mo70101g(d12, this.f54434e);
                while (i10 < length2) {
                    fArr[i10] = (float) (this.f54431b[i12][i10] + ((d10 - this.f54430a[i12]) * this.f54434e[i10]));
                    i10++;
                }
                return;
            }
        } else {
            if (d10 <= dArr[0]) {
                for (int i13 = 0; i13 < length2; i13++) {
                    fArr[i13] = (float) this.f54431b[0][i13];
                }
                return;
            }
            int i14 = length - 1;
            if (d10 >= dArr[i14]) {
                while (i10 < length2) {
                    fArr[i10] = (float) this.f54431b[i14][i10];
                    i10++;
                }
                return;
            }
        }
        int i15 = 0;
        while (i15 < length - 1) {
            if (d10 == this.f54430a[i15]) {
                for (int i16 = 0; i16 < length2; i16++) {
                    fArr[i16] = (float) this.f54431b[i15][i16];
                }
            }
            double[] dArr2 = this.f54430a;
            int i17 = i15 + 1;
            double d13 = dArr2[i17];
            if (d10 < d13) {
                double d14 = dArr2[i15];
                double d15 = (d10 - d14) / (d13 - d14);
                while (i10 < length2) {
                    double[][] dArr3 = this.f54431b;
                    fArr[i10] = (float) ((dArr3[i15][i10] * (1.0d - d15)) + (dArr3[i17][i10] * d15));
                    i10++;
                }
                return;
            }
            i15 = i17;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r3
  0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p504o.AbstractC11769b
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double mo70100f(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.f54430a
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.f54430a
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r7 = r7.f54431b
            r8 = r7[r2]
            r8 = r8[r10]
            r7 = r7[r3]
            r0 = r7[r10]
            double r0 = r0 - r8
            double r0 = r0 / r4
            return r0
        L33:
            r2 = r3
            goto L15
        L35:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p504o.C11773f.mo70100f(double, int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r4
  0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p504o.AbstractC11769b
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo70101g(double r11, double[] r13) {
        /*
            r10 = this;
            double[] r0 = r10.f54430a
            int r1 = r0.length
            double[][] r2 = r10.f54431b
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r11 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r10.f54430a
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r11 = r4[r0]
            double r6 = r6 - r11
        L2c:
            if (r3 >= r2) goto L41
            double[][] r11 = r10.f54431b
            r12 = r11[r0]
            r8 = r12[r3]
            r11 = r11[r5]
            r11 = r11[r3]
            double r11 = r11 - r8
            double r11 = r11 / r6
            r13[r3] = r11
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p504o.C11773f.mo70101g(double, double[]):void");
    }

    @Override // p504o.AbstractC11769b
    /* renamed from: h */
    public double[] mo70102h() {
        return this.f54430a;
    }
}
