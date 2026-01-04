package p375iw;

import android.util.Log;
import p348hw.C10347b;

/* renamed from: iw.b */
/* loaded from: classes9.dex */
public class C10629b {

    /* renamed from: a */
    public static int f51070a;

    /* renamed from: a */
    public static C10347b[] m65106a(C10347b[] c10347bArr) {
        f51070a++;
        int length = c10347bArr.length;
        if (length == 1) {
            return new C10347b[]{c10347bArr[0]};
        }
        if (((length - 1) & length) != 0) {
            Log.e("UltraAlg", "FFT: num is not a power of 2");
            return new C10347b[]{c10347bArr[0]};
        }
        int i10 = length / 2;
        C10347b[] c10347bArr2 = new C10347b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            c10347bArr2[i11] = c10347bArr[i11 * 2];
        }
        C10347b[] c10347bArrM65106a = m65106a(c10347bArr2);
        for (int i12 = 0; i12 < i10; i12++) {
            c10347bArr2[i12] = c10347bArr[(i12 * 2) + 1];
        }
        C10347b[] c10347bArrM65106a2 = m65106a(c10347bArr2);
        C10347b[] c10347bArr3 = new C10347b[length];
        double d10 = (-6.283185307179586d) / length;
        for (int i13 = 0; i13 < i10; i13++) {
            double d11 = i13 * d10;
            C10347b c10347b = new C10347b(Math.cos(d11), Math.sin(d11));
            c10347bArr3[i13] = c10347bArrM65106a[i13].m63714b(c10347b.m63718f(c10347bArrM65106a2[i13]));
            c10347bArr3[i13 + i10] = c10347bArrM65106a[i13].m63720h(c10347b.m63718f(c10347bArrM65106a2[i13]));
        }
        return c10347bArr3;
    }

    /* renamed from: b */
    public static C10347b[] m65107b(C10347b[] c10347bArr) {
        int length = c10347bArr.length;
        C10347b[] c10347bArr2 = new C10347b[length];
        for (int i10 = 0; i10 < length; i10++) {
            c10347bArr2[i10] = c10347bArr[i10].m63715c();
        }
        C10347b[] c10347bArrM65106a = m65106a(c10347bArr2);
        for (int i11 = 0; i11 < length; i11++) {
            c10347bArrM65106a[i11] = c10347bArrM65106a[i11].m63715c();
        }
        for (int i12 = 0; i12 < length; i12++) {
            c10347bArrM65106a[i12] = c10347bArrM65106a[i12].m63719g(1.0d / length);
        }
        return c10347bArrM65106a;
    }

    /* renamed from: c */
    public static double[] m65108c(C10347b[] c10347bArr, C10347b[] c10347bArr2, int i10, int i11, double d10) {
        int i12;
        double dMax;
        int i13 = 1;
        int i14 = 0;
        if (c10347bArr.length != c10347bArr2.length) {
            Log.i("UltraAlg", "length of x and y are not the same");
            return new double[]{c10347bArr[0].m63717e()};
        }
        int length = c10347bArr2.length;
        C10347b[] c10347bArrM65106a = m65106a(c10347bArr2);
        C10347b[] c10347bArr3 = new C10347b[length];
        for (int i15 = 0; i15 < length; i15++) {
            c10347bArr3[i15] = c10347bArr[i15].m63715c().m63718f(c10347bArrM65106a[i15]);
        }
        C10347b[] c10347bArrM65107b = m65107b(c10347bArr3);
        int i16 = i11 - i10;
        double[] dArr = new double[i16];
        double d11 = 3.0d * d10;
        int i17 = 0;
        double d12 = 0.0d;
        double dM63713a = 0.0d;
        double d13 = 0.0d;
        while (i17 < i16) {
            if (i17 == 0) {
                for (int i18 = i14; i18 < i10; i18 += i13) {
                    int i19 = i18 + i17;
                    if (i19 < c10347bArr2.length) {
                        C10347b c10347b = c10347bArr2[i19];
                        double dM63713a2 = c10347b.m63713a(c10347b);
                        d13 += dM63713a2;
                        if (dM63713a2 > d12) {
                            d12 = dM63713a2;
                        }
                    }
                }
                C10347b c10347b2 = c10347bArr2[i17];
                dM63713a = c10347b2.m63713a(c10347b2);
            } else {
                int i20 = (i10 - 1) + i17;
                if (i20 < c10347bArr2.length) {
                    C10347b c10347b3 = c10347bArr2[i20];
                    double dM63713a3 = c10347b3.m63713a(c10347b3);
                    if (dM63713a3 > d12) {
                        d12 = dM63713a3;
                    }
                    d13 = (d13 - dM63713a) + dM63713a3;
                    C10347b c10347b4 = c10347bArr2[i17];
                    dM63713a = c10347b4.m63713a(c10347b4);
                }
            }
            if (i10 != 0) {
                i12 = i16;
                dMax = Math.max(d13 / i10, d12 * 0.125d);
            } else {
                i12 = i16;
                dMax = 0.0d;
            }
            C10347b c10347b5 = c10347bArrM65107b[i17];
            dArr[i17] = c10347b5.m63713a(c10347b5) / Math.max(dMax, d11);
            i13 = 1;
            i17++;
            i16 = i12;
            i14 = 0;
        }
        return dArr;
    }

    /* renamed from: d */
    public static C10347b[] m65109d(C10347b[] c10347bArr, C10347b[] c10347bArr2, int i10, int i11, double d10) {
        C10347b[] c10347bArr3 = c10347bArr2;
        int i12 = i10;
        int i13 = 0;
        if (c10347bArr.length != c10347bArr3.length) {
            Log.i("UltraAlg", "length of x and y are not the same");
            return new C10347b[]{c10347bArr[0]};
        }
        int length = c10347bArr3.length;
        C10347b[] c10347bArrM65106a = m65106a(c10347bArr2);
        C10347b[] c10347bArr4 = new C10347b[length];
        for (int i14 = 0; i14 < length; i14++) {
            c10347bArr4[i14] = c10347bArr[i14].m63715c().m63718f(c10347bArrM65106a[i14]);
        }
        C10347b[] c10347bArrM65107b = m65107b(c10347bArr4);
        int i15 = i11 - i12;
        C10347b[] c10347bArr5 = new C10347b[i15];
        int i16 = 0;
        double d11 = 0.0d;
        double dM63713a = 0.0d;
        double d12 = 0.0d;
        while (i16 < i15) {
            if (i16 == 0) {
                for (int i17 = i13; i17 < i12; i17++) {
                    int i18 = i17 + i16;
                    if (i18 < c10347bArr3.length) {
                        C10347b c10347b = c10347bArr3[i18];
                        double dM63713a2 = c10347b.m63713a(c10347b);
                        d12 += dM63713a2;
                        if (dM63713a2 > d11) {
                            d11 = dM63713a2;
                        }
                    }
                }
                C10347b c10347b2 = c10347bArr3[i16];
                dM63713a = c10347b2.m63713a(c10347b2);
            } else {
                int i19 = (i12 - 1) + i16;
                if (i19 < c10347bArr3.length) {
                    C10347b c10347b3 = c10347bArr3[i19];
                    double dM63713a3 = c10347b3.m63713a(c10347b3);
                    if (dM63713a3 > d11) {
                        d11 = dM63713a3;
                    }
                    d12 = (d12 - dM63713a) + dM63713a3;
                    C10347b c10347b4 = c10347bArr3[i16];
                    dM63713a = c10347b4.m63713a(c10347b4);
                }
            }
            c10347bArr5[i16] = c10347bArrM65107b[i16].m63716d(Math.max(i12 != 0 ? Math.max(d12 / i12, d11 * 0.125d) : 0.0d, 3.0d));
            i16++;
            c10347bArr3 = c10347bArr2;
            i12 = i10;
            i13 = 0;
        }
        return c10347bArr5;
    }
}
