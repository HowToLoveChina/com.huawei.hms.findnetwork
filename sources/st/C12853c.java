package st;

import java.lang.reflect.Array;
import java.util.Arrays;
import tt.C13069b;

/* renamed from: st.c */
/* loaded from: classes5.dex */
public class C12853c implements InterfaceC12855e {

    /* renamed from: f */
    public static final double f58598f;

    /* renamed from: g */
    public static final double f58599g;

    /* renamed from: h */
    public static final double f58600h;

    /* renamed from: a */
    public final double f58601a;

    /* renamed from: b */
    public final double f58602b;

    /* renamed from: c */
    public final double f58603c;

    /* renamed from: d */
    public final double f58604d;

    /* renamed from: e */
    public final double f58605e;

    /* renamed from: st.c$a */
    public static class a {

        /* renamed from: a */
        public final double[][] f58606a;

        /* renamed from: b */
        public final int[] f58607b;

        /* renamed from: c */
        public final int f58608c;

        /* renamed from: d */
        public final double[] f58609d;

        /* renamed from: e */
        public final double[] f58610e;

        /* renamed from: f */
        public final double[] f58611f;

        public a(double[][] dArr, int[] iArr, int i10, double[] dArr2, double[] dArr3, double[] dArr4) {
            this.f58606a = dArr;
            this.f58607b = iArr;
            this.f58608c = i10;
            this.f58609d = dArr2;
            this.f58610e = dArr3;
            this.f58611f = dArr4;
        }
    }

    static {
        double dLongBitsToDouble = Double.longBitsToDouble(4368491638549381120L);
        f58598f = dLongBitsToDouble;
        f58599g = Double.longBitsToDouble(4503599627370496L);
        f58600h = dLongBitsToDouble * 2.0d;
    }

    public C12853c() {
        this(100.0d, 1.0E-10d, 1.0E-10d, 1.0E-10d, f58599g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x0293, code lost:
    
        return new st.C12856f(r1, r28.m78835b(), r36.m78835b());
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x025a  */
    @Override // st.InterfaceC12855e
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public st.C12856f mo77166a(st.C12854d r62) throws tt.C13069b {
        /*
            Method dump skipped, instructions count: 776
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: st.C12853c.mo77166a(st.d):st.f");
    }

    /* renamed from: b */
    public final double m77167b(int i10, double[] dArr, double d10, double[][] dArr2, int[] iArr, double[] dArr3) {
        double dMax = 0.0d;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            double d11 = dArr3[i12];
            if (d11 != 0.0d) {
                double d12 = 0.0d;
                for (int i13 = 0; i13 <= i11; i13++) {
                    d12 += dArr2[i13][i12] * dArr[i13];
                }
                dMax = Math.max(dMax, Math.abs(d12) / (d11 * d10));
            }
        }
        return dMax;
    }

    /* renamed from: c */
    public final double m77168c(int i10, double[] dArr, double[] dArr2, double[] dArr3) {
        double d10 = 0.0d;
        for (int i11 = 0; i11 < i10; i11++) {
            double d11 = dArr3[i11];
            if (d11 == 0.0d) {
                d11 = 1.0d;
            }
            double d12 = dArr2[i11] * d11;
            d10 += d12 * d12;
            dArr[i11] = d11;
        }
        return Math.sqrt(d10);
    }

    /* renamed from: d */
    public final double m77169d(double[] dArr, double d10, double[] dArr2, a aVar, int i10, double[] dArr3, double[] dArr4, double[] dArr5, double[] dArr6, double d11) {
        double d12;
        double d13;
        double dMin;
        double[][] dArr7 = aVar.f58606a;
        int[] iArr = aVar.f58607b;
        int i11 = aVar.f58608c;
        double[] dArr8 = aVar.f58609d;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            dArr6[iArr[i13]] = dArr[i13];
        }
        for (int i14 = i11; i14 < dArr7[0].length; i14++) {
            dArr6[iArr[i14]] = 0.0d;
        }
        for (int i15 = i11 - 1; i15 >= 0; i15--) {
            int i16 = iArr[i15];
            double d14 = dArr6[i16] / dArr8[i16];
            for (int i17 = 0; i17 < i15; i17++) {
                int i18 = iArr[i17];
                dArr6[i18] = dArr6[i18] - (dArr7[i17][i16] * d14);
            }
            dArr6[i16] = d14;
        }
        double dM77170e = m77170e(dArr2, i10, dArr3, dArr6, iArr);
        double d15 = dM77170e - d10;
        double d16 = d10 * 0.1d;
        if (d15 <= d16) {
            return 0.0d;
        }
        if (i11 == i10) {
            for (int i19 = 0; i19 < i10; i19++) {
                int i20 = iArr[i19];
                dArr3[i20] = dArr3[i20] * (dArr2[i20] / dM77170e);
            }
            int i21 = 0;
            double d17 = 0.0d;
            while (i21 < i10) {
                int i22 = iArr[i21];
                double d18 = 0.0d;
                while (i12 < i21) {
                    d18 += dArr7[i12][i22] * dArr3[iArr[i12]];
                    i12++;
                }
                double d19 = (dArr3[i22] - d18) / dArr8[i22];
                dArr3[i22] = d19;
                d17 += d19 * d19;
                i21++;
                i12 = 0;
            }
            d12 = d15 / (d10 * d17);
        } else {
            d12 = 0.0d;
        }
        double d20 = 0.0d;
        for (int i23 = 0; i23 < i10; i23++) {
            int i24 = iArr[i23];
            double d21 = 0.0d;
            for (int i25 = 0; i25 <= i23; i25++) {
                d21 += dArr7[i25][i24] * dArr[i25];
            }
            double d22 = d21 / dArr2[i24];
            d20 += d22 * d22;
        }
        double dSqrt = Math.sqrt(d20);
        double dMin2 = dSqrt / d10;
        if (dMin2 == 0.0d) {
            dMin2 = f58599g / Math.min(d10, 0.1d);
        }
        double d23 = dMin2;
        double d24 = d15;
        double dMin3 = Math.min(d23, Math.max(d11, d12));
        double d25 = 0.0d;
        if (dMin3 == 0.0d) {
            dMin3 = dSqrt / dM77170e;
        }
        int i26 = 10;
        double dMax = d12;
        double d26 = d23;
        while (i26 >= 0) {
            if (dMin3 == d25) {
                dMin3 = Math.max(f58599g, 0.001d * d26);
            }
            double d27 = dMin3;
            double dSqrt2 = Math.sqrt(d27);
            for (int i27 = 0; i27 < i10; i27++) {
                int i28 = iArr[i27];
                dArr3[i28] = dArr2[i28] * dSqrt2;
            }
            double d28 = d26;
            m77173h(dArr, dArr3, dArr4, aVar, i10, dArr5, dArr6);
            double dM77170e2 = m77170e(dArr2, i10, dArr5, dArr6, iArr);
            double d29 = dM77170e2 - d10;
            if (Math.abs(d29) <= d16 || (dMax == 0.0d && d29 <= d24 && d24 < 0.0d)) {
                return d27;
            }
            for (int i29 = 0; i29 < i10; i29++) {
                int i30 = iArr[i29];
                dArr3[i30] = (dArr5[i30] * dArr2[i30]) / dM77170e2;
            }
            int i31 = 0;
            while (i31 < i10) {
                int i32 = iArr[i31];
                double d30 = dArr3[i32] / dArr4[i31];
                dArr3[i32] = d30;
                i31++;
                for (int i33 = i31; i33 < i10; i33++) {
                    int i34 = iArr[i33];
                    dArr3[i34] = dArr3[i34] - (dArr7[i33][i32] * d30);
                }
            }
            double d31 = 0.0d;
            for (int i35 = 0; i35 < i10; i35++) {
                double d32 = dArr3[iArr[i35]];
                d31 += d32 * d32;
            }
            double d33 = d29 / (d10 * d31);
            if (d29 > 0.0d) {
                d13 = d27;
                dMax = Math.max(dMax, d13);
                dMin = d28;
            } else {
                d13 = d27;
                dMin = d28;
                if (d29 < 0.0d) {
                    dMin = Math.min(dMin, d13);
                }
            }
            double dMax2 = Math.max(dMax, d33 + d13);
            i26--;
            d24 = d29;
            d26 = dMin;
            d25 = 0.0d;
            dMin3 = dMax2;
        }
        return dMin3;
    }

    /* renamed from: e */
    public final double m77170e(double[] dArr, int i10, double[] dArr2, double[] dArr3, int[] iArr) {
        double d10 = 0.0d;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            double d11 = dArr[i12] * dArr3[i12];
            dArr2[i12] = d11;
            d10 += d11 * d11;
        }
        return Math.sqrt(d10);
    }

    /* renamed from: f */
    public final a m77171f(double[][] dArr, int i10) throws C13069b {
        double d10;
        int length = dArr.length;
        int length2 = dArr[0].length;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, length2);
        for (int i11 = 0; i11 < length; i11++) {
            for (int i12 = 0; i12 < length2; i12++) {
                dArr2[i11][i12] = dArr[i11][i12] * (-1.0d);
            }
        }
        int length3 = dArr2.length;
        int length4 = dArr2[0].length;
        int[] iArr = new int[length4];
        double[] dArr3 = new double[length4];
        double[] dArr4 = new double[length4];
        double[] dArr5 = new double[length4];
        int i13 = 0;
        while (true) {
            d10 = 0.0d;
            if (i13 >= length4) {
                break;
            }
            iArr[i13] = i13;
            for (double[] dArr6 : dArr2) {
                double d11 = dArr6[i13];
                d10 += d11 * d11;
            }
            dArr4[i13] = Math.sqrt(d10);
            i13++;
        }
        int i14 = 0;
        while (i14 < length4) {
            int i15 = -1;
            double d12 = Double.NEGATIVE_INFINITY;
            for (int i16 = i14; i16 < length4; i16++) {
                double d13 = d10;
                for (int i17 = i14; i17 < length3; i17++) {
                    double d14 = dArr2[i17][iArr[i16]];
                    d13 += d14 * d14;
                }
                if (Double.isInfinite(d13) || Double.isNaN(d13)) {
                    throw new C13069b("optimize %d,%d", Integer.valueOf(length3), Integer.valueOf(length4));
                }
                if (d13 > d12) {
                    i15 = i16;
                    d12 = d13;
                }
            }
            if (d12 <= this.f58605e) {
                return new a(dArr2, iArr, i14, dArr3, dArr4, dArr5);
            }
            int i18 = iArr[i15];
            iArr[i15] = iArr[i14];
            iArr[i14] = i18;
            double d15 = dArr2[i14][i18];
            double dSqrt = Math.sqrt(d12);
            if (d15 > d10) {
                dSqrt = -dSqrt;
            }
            double d16 = 1.0d / (d12 - (d15 * dSqrt));
            dArr5[i18] = d16;
            dArr3[i18] = dSqrt;
            double[] dArr7 = dArr2[i14];
            dArr7[i18] = dArr7[i18] - dSqrt;
            for (int i19 = (length4 - 1) - i14; i19 > 0; i19--) {
                double d17 = 0.0d;
                for (int i20 = i14; i20 < length3; i20++) {
                    double[] dArr8 = dArr2[i20];
                    d17 += dArr8[i18] * dArr8[iArr[i14 + i19]];
                }
                double d18 = d17 * d16;
                for (int i21 = i14; i21 < length3; i21++) {
                    double[] dArr9 = dArr2[i21];
                    int i22 = iArr[i14 + i19];
                    dArr9[i22] = dArr9[i22] - (dArr9[i18] * d18);
                }
            }
            i14++;
            d10 = 0.0d;
        }
        return new a(dArr2, iArr, i10, dArr3, dArr4, dArr5);
    }

    /* renamed from: g */
    public final void m77172g(double[] dArr, a aVar) {
        for (int i10 = 0; i10 < aVar.f58606a[0].length; i10++) {
            int i11 = aVar.f58607b[i10];
            double d10 = 0.0d;
            for (int i12 = i10; i12 < aVar.f58606a.length; i12++) {
                d10 += aVar.f58606a[i12][i11] * dArr[i12];
            }
            double d11 = d10 * aVar.f58611f[i11];
            for (int i13 = i10; i13 < aVar.f58606a.length; i13++) {
                dArr[i13] = dArr[i13] - (aVar.f58606a[i13][i11] * d11);
            }
        }
    }

    /* renamed from: h */
    public final void m77173h(double[] dArr, double[] dArr2, double[] dArr3, a aVar, int i10, double[] dArr4, double[] dArr5) {
        int[] iArr;
        double dSqrt;
        double d10;
        double[] dArr6 = dArr5;
        int[] iArr2 = aVar.f58607b;
        double[][] dArr7 = aVar.f58606a;
        double[] dArr8 = aVar.f58609d;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr2[i11];
            int i13 = i11 + 1;
            for (int i14 = i13; i14 < i10; i14++) {
                dArr7[i14][i12] = dArr7[i11][iArr2[i14]];
            }
            dArr6[i11] = dArr8[i12];
            dArr4[i11] = dArr[i11];
            i11 = i13;
        }
        int i15 = 0;
        while (true) {
            double d11 = 0.0d;
            if (i15 >= i10) {
                break;
            }
            double d12 = dArr2[iArr2[i15]];
            if (d12 != 0.0d) {
                Arrays.fill(dArr3, i15 + 1, dArr3.length, 0.0d);
            }
            dArr3[i15] = d12;
            int i16 = i15;
            double d13 = 0.0d;
            while (i16 < i10) {
                int i17 = iArr2[i16];
                if (dArr3[i16] != d11) {
                    double d14 = dArr7[i16][i17];
                    if (Math.abs(d14) < Math.abs(dArr3[i16])) {
                        double d15 = d14 / dArr3[i16];
                        double dSqrt2 = 1.0d / Math.sqrt((d15 * d15) + 1.0d);
                        d10 = dSqrt2;
                        dSqrt = d15 * dSqrt2;
                    } else {
                        double d16 = dArr3[i16] / d14;
                        dSqrt = 1.0d / Math.sqrt((d16 * d16) + 1.0d);
                        d10 = dSqrt * d16;
                    }
                    dArr7[i16][i17] = (d14 * dSqrt) + (dArr3[i16] * d10);
                    double d17 = dArr4[i16];
                    double d18 = (dSqrt * d17) + (d10 * d13);
                    iArr = iArr2;
                    double d19 = -d10;
                    d13 = (d13 * dSqrt) + (d17 * d19);
                    dArr4[i16] = d18;
                    for (int i18 = i16 + 1; i18 < i10; i18++) {
                        double[] dArr9 = dArr7[i18];
                        double d20 = dArr9[i17];
                        double d21 = dArr3[i18];
                        dArr3[i18] = (d20 * d19) + (d21 * dSqrt);
                        dArr9[i17] = (dSqrt * d20) + (d10 * d21);
                    }
                } else {
                    iArr = iArr2;
                }
                i16++;
                iArr2 = iArr;
                d11 = 0.0d;
            }
            int[] iArr3 = iArr2;
            double[] dArr10 = dArr7[i15];
            int i19 = iArr3[i15];
            dArr3[i15] = dArr10[i19];
            dArr10[i19] = dArr5[i15];
            i15++;
            dArr6 = dArr5;
            iArr2 = iArr3;
        }
        double[] dArr11 = dArr6;
        int[] iArr4 = iArr2;
        int i20 = i10;
        for (int i21 = 0; i21 < i10; i21++) {
            if (dArr3[i21] == 0.0d && i20 == i10) {
                i20 = i21;
            }
            if (i20 < i10) {
                dArr4[i21] = 0.0d;
            }
        }
        if (i20 > 0) {
            for (int i22 = i20 - 1; i22 >= 0; i22--) {
                int i23 = iArr4[i22];
                double d22 = 0.0d;
                for (int i24 = i22 + 1; i24 < i20; i24++) {
                    d22 += dArr7[i24][i23] * dArr4[i24];
                }
                dArr4[i22] = (dArr4[i22] - d22) / dArr3[i22];
            }
        }
        for (int i25 = 0; i25 < dArr11.length; i25++) {
            dArr11[iArr4[i25]] = dArr4[i25];
        }
    }

    public C12853c(double d10, double d11, double d12, double d13, double d14) {
        this.f58601a = d10;
        this.f58602b = d11;
        this.f58603c = d12;
        this.f58604d = d13;
        this.f58605e = d14;
    }
}
