package p348hw;

import android.util.Log;
import p375iw.C10630c;

/* renamed from: hw.h */
/* loaded from: classes9.dex */
public class C10353h {

    /* renamed from: hw.h$a */
    public static class a {

        /* renamed from: a */
        public double[] f50077a;

        /* renamed from: b */
        public double[] f50078b;

        public a(int i10) {
            this.f50077a = new double[i10];
            this.f50078b = new double[i10];
        }
    }

    /* renamed from: hw.h$b */
    public static class b {

        /* renamed from: a */
        public int f50079a;

        /* renamed from: b */
        public int f50080b;

        /* renamed from: c */
        public int f50081c;

        /* renamed from: d */
        public double f50082d;

        /* renamed from: e */
        public double f50083e;
    }

    /* renamed from: a */
    public static C10630c.c m63752a(int i10, int i11, int i12, C10630c.c cVar, double[] dArr, double[] dArr2, int i13) {
        C10630c.c cVar2 = new C10630c.c();
        cVar2.f51079b = cVar.f51079b;
        cVar2.f51078a = cVar.f51078a;
        double d10 = i13 >= 14000 ? 0.8d : 0.6d;
        int i14 = 0;
        if (i13 < 14000) {
            while (true) {
                if (i14 >= i10 - i11) {
                    break;
                }
                double d11 = dArr2[i14];
                if (d11 > cVar.f51079b * d10 && i14 > (cVar.f51078a - i12) - i12) {
                    cVar2.f51078a = i14;
                    cVar2.f51079b = d11;
                    break;
                }
                i14++;
            }
        } else {
            while (true) {
                if (i14 >= i10 - i11) {
                    break;
                }
                double d12 = dArr[i14];
                if (d12 > cVar.f51079b * d10 && i14 > (cVar.f51078a - i12) - i12) {
                    cVar2.f51078a = i14;
                    cVar2.f51079b = d12;
                    break;
                }
                i14++;
            }
        }
        return cVar2;
    }

    /* renamed from: b */
    public static C10347b[] m63753b(double[] dArr, double d10, double d11, double d12) {
        double[] dArr2 = new double[dArr.length];
        double[] dArr3 = new double[dArr.length];
        double[] dArr4 = new double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            if (Math.abs(d11 - 0.0d) > 1.0E-5d) {
                dArr2[i10] = i10 / d11;
            }
            double d13 = 6.283185307179586d * d10;
            dArr3[i10] = dArr[i10] * Math.cos(dArr2[i10] * d13);
            dArr4[i10] = dArr[i10] * Math.sin(d13 * dArr2[i10]);
        }
        C10349d c10349d = new C10349d();
        c10349d.m63734k(6, d11, d12, true);
        double[] dArrM63731h = c10349d.m63731h();
        double[] dArrM63732i = c10349d.m63732i();
        double[] dArrM63754c = m63754c(dArrM63732i, dArrM63731h, dArr3);
        double[] dArrM63754c2 = m63754c(dArrM63732i, dArrM63731h, dArr4);
        C10347b[] c10347bArr = new C10347b[dArr.length];
        for (int i11 = 0; i11 < dArr.length; i11++) {
            c10347bArr[i11] = new C10347b(dArrM63754c[i11], dArrM63754c2[i11]);
        }
        return c10347bArr;
    }

    /* renamed from: c */
    public static double[] m63754c(double[] dArr, double[] dArr2, double[] dArr3) {
        int length = dArr.length;
        int length2 = dArr2.length;
        int length3 = dArr3.length;
        int i10 = length - 1;
        int i11 = length2 - 1;
        double[] dArr4 = new double[length3];
        for (int i12 = 0; i12 < length3; i12++) {
            double d10 = 0.0d;
            for (int i13 = 0; i13 <= i10 && i13 <= i12; i13++) {
                d10 += dArr[i13] * dArr3[i12 - i13];
            }
            double d11 = 0.0d;
            for (int i14 = 1; i14 <= i11 && i14 <= i12; i14++) {
                d11 += dArr2[i14] * dArr4[i12 - i14];
            }
            if (Math.abs(dArr2[0] - 0.0d) > 1.0E-5d) {
                dArr4[i12] = (d10 - d11) / dArr2[0];
            }
        }
        return dArr4;
    }

    /* renamed from: d */
    public static a m63755d(double[] dArr, int i10) {
        int length = dArr.length / 2;
        a aVar = new a(length);
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == 0) {
                int i12 = i11 * 2;
                aVar.f50077a[i11] = dArr[i12];
                aVar.f50078b[i11] = dArr[i12 + 1];
            } else if (1 == i10) {
                int i13 = i11 * 2;
                aVar.f50077a[i11] = dArr[i13 + 1];
                aVar.f50078b[i11] = dArr[i13];
            }
        }
        return aVar;
    }

    /* renamed from: e */
    public static int m63756e(int i10, int i11, C10630c.a aVar, int i12, int i13, int i14, int i15) {
        return i10 == 1 ? i11 == 0 ? aVar.f51073c : i13 + i15 : i11 == 1 ? i12 + i14 : aVar.f51072b;
    }

    /* renamed from: f */
    public static int m63757f(double d10, double d11, double d12, double d13, double d14, double d15, int i10) {
        if (d10 < d13 && d11 < d12) {
            return 2;
        }
        if ((d10 < d12 && d11 < d13) || d15 < d14) {
            return 2;
        }
        if (-1 == i10) {
            return 6;
        }
        if (d10 <= d13 && (d11 >= d13 * 8.0d || d11 / d10 > 8.0d)) {
            return 9;
        }
        if ((d11 > d13 || (d10 < d13 * 8.0d && d10 / d11 <= 8.0d)) && d10 / d11 <= 10.0d && d11 / d10 <= 10.0d) {
            return (d10 <= d12 || d11 <= d12) ? 8 : 4;
        }
        return 9;
    }

    /* renamed from: g */
    public static b m63758g(int i10, int i11, double d10, double d11, double d12, double d13) {
        b bVar = new b();
        bVar.f50080b = i10;
        bVar.f50081c = i11;
        if ((i10 >= i11 || d10 + d11 <= (d12 + d13) * 0.5d) && (i10 < i11 || d10 + d11 < (d12 + d13) * 2.0d)) {
            bVar.f50079a = 1;
            bVar.f50080b = i11;
            bVar.f50082d = d12;
            bVar.f50083e = d13;
            Log.e("getFlagIndexRssi: ", "startIdxTag: right");
        } else {
            bVar.f50079a = 0;
            bVar.f50081c = i10;
            bVar.f50082d = d10;
            bVar.f50083e = d11;
            Log.e("getFlagIndexRssi: ", "startIdxTag: left");
        }
        return bVar;
    }

    /* renamed from: h */
    public static C10347b[] m63759h(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        C10347b[] c10347bArr = new C10347b[length];
        for (int i10 = 0; i10 < length; i10++) {
            c10347bArr[i10] = new C10347b(dArr[i10], dArr2[i10]);
        }
        return c10347bArr;
    }
}
