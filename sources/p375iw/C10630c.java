package p375iw;

import java.util.Arrays;
import java.util.HashSet;
import p348hw.C10347b;

/* renamed from: iw.c */
/* loaded from: classes9.dex */
public class C10630c {

    /* renamed from: iw.c$a */
    public static class a {

        /* renamed from: a */
        public int f51071a = 0;

        /* renamed from: b */
        public int f51072b = 0;

        /* renamed from: c */
        public int f51073c = 0;

        /* renamed from: d */
        public double f51074d = 0.0d;

        /* renamed from: e */
        public int f51075e = 0;
    }

    /* renamed from: iw.c$b */
    public static class b {

        /* renamed from: a */
        public int f51076a;

        /* renamed from: b */
        public int f51077b;
    }

    /* renamed from: iw.c$c */
    public static class c {

        /* renamed from: a */
        public int f51078a;

        /* renamed from: b */
        public double f51079b;
    }

    /* renamed from: iw.c$d */
    public static class d {

        /* renamed from: a */
        public float f51080a;

        /* renamed from: b */
        public int f51081b;
    }

    /* renamed from: iw.c$e */
    public static class e {

        /* renamed from: a */
        public double f51082a;

        /* renamed from: b */
        public int[] f51083b;

        /* renamed from: c */
        public double[] f51084c;

        /* renamed from: d */
        public int f51085d;
    }

    /* renamed from: a */
    public static int[] m65110a(int[] iArr, int[] iArr2) {
        int length = iArr.length + iArr2.length;
        int[] iArr3 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 < iArr.length) {
                iArr3[i10] = iArr[i10];
            } else {
                iArr3[i10] = iArr2[i10 - iArr.length];
            }
        }
        return iArr3;
    }

    /* renamed from: b */
    public static double[] m65111b(double[] dArr, double[] dArr2, int[] iArr) {
        int length = dArr.length + dArr2.length;
        double[] dArr3 = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 < dArr.length) {
                dArr3[i10] = dArr[i10];
            } else {
                dArr3[i10] = dArr2[i10 - dArr.length];
            }
        }
        double[] dArr4 = new double[length];
        for (int i11 = 0; i11 < length; i11++) {
            dArr4[i11] = dArr3[iArr[i11]];
        }
        return dArr4;
    }

    /* renamed from: c */
    public static int[] m65112c(int[] iArr, int i10) {
        if (iArr == null) {
            return new int[0];
        }
        int[] iArr2 = new int[iArr.length];
        if (iArr.length >= 0) {
            for (int i11 = 0; i11 < iArr.length; i11++) {
                iArr2[i11] = iArr[i11] + i10;
            }
        }
        return iArr2;
    }

    /* renamed from: d */
    public static double m65113d(double[] dArr) {
        int length = dArr.length;
        double dAbs = 0.0d;
        for (double d10 : dArr) {
            dAbs += Math.abs(d10);
        }
        return dAbs / length;
    }

    /* renamed from: e */
    public static d m65114e(float[] fArr, float f10) {
        d dVar = new d();
        dVar.f51080a = 500.0f;
        dVar.f51081b = 0;
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            float f11 = fArr[i10];
            if (f11 > f10 && f11 < dVar.f51080a) {
                dVar.f51080a = f11;
                dVar.f51081b = i10;
            }
        }
        return dVar;
    }

    /* renamed from: f */
    public static float m65115f(float[] fArr) {
        int length = fArr.length;
        float f10 = 0.0f;
        for (float f11 : fArr) {
            f10 += f11;
        }
        return f10 / length;
    }

    /* renamed from: g */
    public static double m65116g(double[] dArr) {
        double d10 = dArr[0];
        int length = dArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            double d11 = dArr[i10];
            if (d11 > d10) {
                d10 = d11;
            }
        }
        return d10;
    }

    /* renamed from: h */
    public static float m65117h(float[] fArr) {
        int length = fArr.length;
        float f10 = 0.0f;
        for (float f11 : fArr) {
            f10 += f11 * f11;
        }
        return f10 / length;
    }

    /* renamed from: i */
    public static float m65118i(float[] fArr) {
        float f10 = 0.0f;
        for (float f11 : fArr) {
            f10 += f11;
        }
        return f10;
    }

    /* renamed from: j */
    public static c[] m65119j(double[] dArr) {
        int length = dArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = i10;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            int i12 = 0;
            while (i12 < (dArr.length - i11) - 1) {
                double d10 = dArr[i12];
                int i13 = i12 + 1;
                double d11 = dArr[i13];
                if (d10 < d11) {
                    dArr[i12] = d11;
                    dArr[i13] = d10;
                    int i14 = iArr[i12];
                    iArr[i12] = iArr[i13];
                    iArr[i13] = i14;
                }
                i12 = i13;
            }
        }
        c[] cVarArr = new c[length];
        for (int i15 = 0; i15 < length; i15++) {
            cVarArr[i15] = new c();
        }
        for (int i16 = 0; i16 < length; i16++) {
            c cVar = cVarArr[i16];
            cVar.f51078a = iArr[i16];
            cVar.f51079b = dArr[i16];
        }
        return cVarArr;
    }

    /* renamed from: k */
    public static double[] m65120k(byte[] bArr) {
        int length = bArr.length / 2;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            dArr[i10] = (short) (((bArr[i11 + 1] & 255) << 8) | (bArr[i11] & 255));
        }
        return dArr;
    }

    /* renamed from: l */
    public static a m65121l(int[] iArr, double[] dArr, double d10, int[] iArr2, double[] dArr2, double d11, int i10, int i11) {
        int i12;
        int[] iArr3;
        int i13;
        int i14;
        int[] iArr4;
        int i15;
        int i16;
        double d12;
        a aVar;
        double d13;
        boolean z10;
        int i17;
        double d14;
        a aVar2;
        int length = iArr.length;
        int length2 = iArr2.length;
        double d15 = i11 == 6000 ? 110.0d : 130.0d;
        int[] iArrM65110a = m65110a(iArr, iArr2);
        b[] bVarArrM65126q = m65126q(iArrM65110a);
        int[] iArr5 = new int[iArrM65110a.length];
        int[] iArr6 = new int[iArrM65110a.length];
        for (int i18 = 0; i18 < iArrM65110a.length; i18++) {
            b bVar = bVarArrM65126q[i18];
            iArr5[i18] = bVar.f51076a;
            iArr6[i18] = bVar.f51077b;
        }
        double[] dArrM65111b = m65111b(dArr, dArr2, iArr6);
        a aVar3 = new a();
        double dMax = Math.max(Math.min(d10 * 0.25d, 300.0d), d15);
        a aVar4 = aVar3;
        double dMax2 = Math.max(Math.min(d11 * 0.25d, 300.0d), d15);
        boolean z11 = true;
        int i19 = 0;
        while (true) {
            i12 = length + length2;
            if (i19 >= i12) {
                break;
            }
            if (iArr6[i19] < length) {
                int i20 = 0;
                while (i20 < length2) {
                    if (z11 && dArrM65111b[i19] > dMax && dArr2[i20] > dMax2) {
                        z10 = z11;
                        if (Math.abs(iArr5[i19] - iArr2[i20]) < i10) {
                            int i21 = iArr5[i19];
                            d14 = d15;
                            int i22 = iArr2[i20];
                            i17 = length2;
                            aVar2 = aVar4;
                            aVar2.f51071a = i21 - i22;
                            aVar2.f51072b = i21;
                            aVar2.f51073c = i22;
                            aVar2.f51074d = Math.sqrt(dArrM65111b[i19] * dArr2[i20]);
                            aVar2.f51075e = Math.max(iArr5[i19], iArr2[i20]);
                            z11 = false;
                            i20++;
                            aVar4 = aVar2;
                            length2 = i17;
                            d15 = d14;
                        } else {
                            i17 = length2;
                            d14 = d15;
                        }
                    } else {
                        i17 = length2;
                        d14 = d15;
                        z10 = z11;
                    }
                    aVar2 = aVar4;
                    z11 = z10;
                    i20++;
                    aVar4 = aVar2;
                    length2 = i17;
                    d15 = d14;
                }
                i16 = length2;
                d12 = d15;
                aVar = aVar4;
            } else {
                i16 = length2;
                d12 = d15;
                aVar = aVar4;
                int i23 = 0;
                while (i23 < length) {
                    if (z11 && dArr[i23] > dMax && dArrM65111b[i19] > dMax2 && Math.abs(iArr[i23] - iArr5[i19]) < i10) {
                        int i24 = iArr[i23];
                        int i25 = iArr5[i19];
                        aVar.f51071a = i24 - i25;
                        aVar.f51072b = i24;
                        aVar.f51073c = i25;
                        d13 = dMax;
                        aVar.f51074d = Math.sqrt(dArr[i23] * dArrM65111b[i19]);
                        aVar.f51075e = Math.max(iArr[i23], iArr5[i19]);
                        z11 = false;
                    } else {
                        d13 = dMax;
                    }
                    i23++;
                    dMax = d13;
                }
            }
            i19++;
            aVar4 = aVar;
            length2 = i16;
            d15 = d12;
            dMax = dMax;
        }
        int i26 = length2;
        double d16 = d15;
        a aVar5 = aVar4;
        int i27 = 0;
        while (i27 < i12) {
            if (iArr6[i27] < length) {
                i13 = i26;
                int i28 = 0;
                while (i28 < i13) {
                    if (z11 && Math.abs(iArr5[i27] - iArr2[i28]) < i10) {
                        double d17 = dArrM65111b[i27];
                        iArr4 = iArr6;
                        if (d17 > d10 * 0.1d) {
                            i15 = i12;
                            double d18 = dArr2[i28];
                            if (d18 > d11 * 0.1d && Math.max(d17, d18) > d16 && Math.abs(iArr5[i27] - iArr2[i28]) < i10 && z11) {
                                int i29 = iArr5[i27];
                                int i30 = iArr2[i28];
                                aVar5.f51071a = i29 - i30;
                                aVar5.f51072b = i29;
                                aVar5.f51073c = i30;
                                aVar5.f51074d = Math.sqrt(dArrM65111b[i27] * dArr2[i28]);
                                aVar5.f51075e = Math.max(iArr5[i27], iArr2[i28]);
                                z11 = false;
                            }
                        }
                        i28++;
                        i12 = i15;
                        iArr6 = iArr4;
                    } else {
                        iArr4 = iArr6;
                    }
                    i15 = i12;
                    i28++;
                    i12 = i15;
                    iArr6 = iArr4;
                }
                iArr3 = iArr6;
                i14 = i12;
            } else {
                iArr3 = iArr6;
                i13 = i26;
                i14 = i12;
                for (int i31 = 0; i31 < length; i31++) {
                    if (z11 && Math.abs(iArr[i31] - iArr5[i27]) < i10) {
                        double d19 = dArr[i31];
                        if (d19 > d10 * 0.1d) {
                            double d20 = dArrM65111b[i27];
                            if (d20 > d11 * 0.1d && Math.max(d19, d20) > d16 && Math.abs(iArr[i31] - iArr5[i27]) < i10 && z11) {
                                int i32 = iArr[i31];
                                int i33 = iArr5[i27];
                                aVar5.f51071a = i32 - i33;
                                aVar5.f51072b = i32;
                                aVar5.f51073c = i33;
                                aVar5.f51074d = Math.sqrt(dArr[i31] * dArrM65111b[i27]);
                                aVar5.f51075e = Math.max(iArr[i31], iArr5[i27]);
                                z11 = false;
                            }
                        }
                    }
                }
            }
            i27++;
            i12 = i14;
            iArr6 = iArr3;
            i26 = i13;
        }
        if (!z11) {
            return aVar5;
        }
        aVar5.f51072b = m65125p(aVar5.f51072b, iArr, dArr, d10, 0.3d);
        int iM65125p = m65125p(aVar5.f51073c, iArr2, dArr2, d11, 0.3d);
        aVar5.f51073c = iM65125p;
        aVar5.f51071a = aVar5.f51072b - iM65125p;
        return aVar5;
    }

    /* renamed from: m */
    public static double[] m65122m(double[] dArr) {
        double[] dArr2 = new double[2];
        boolean z10 = true;
        for (int length = dArr.length - 2; length >= 1; length--) {
            double d10 = dArr[length];
            if (d10 >= dArr[length - 1] && d10 > dArr[length + 1] && z10 && d10 > 55.0d) {
                dArr2[0] = length;
                dArr2[1] = dArr[length];
                z10 = false;
            }
        }
        return dArr2;
    }

    /* renamed from: n */
    public static e m65123n(double[] dArr) {
        int i10;
        c cVarM65127r = m65127r(dArr);
        int[] iArr = new int[400];
        double[] dArr2 = new double[400];
        e eVar = new e();
        eVar.f51082a = cVarM65127r.f51079b;
        int i11 = 1;
        boolean z10 = true;
        int i12 = 0;
        while (true) {
            i10 = cVarM65127r.f51078a;
            if (i11 >= i10) {
                break;
            }
            double d10 = dArr[i11];
            if (d10 >= dArr[i11 - 1] && d10 > dArr[i11 + 1] && z10 && d10 > 60.0d) {
                if (d10 >= cVarM65127r.f51079b * 0.6d || d10 >= 400.0d) {
                    if (i12 < 400) {
                        iArr[i12] = i11;
                        dArr2[i12] = d10;
                    }
                    z10 = false;
                } else {
                    if (i12 < 400) {
                        iArr[i12] = i11;
                        dArr2[i12] = d10;
                    }
                    i12++;
                }
            }
            i11++;
        }
        if (z10 && i12 < 400) {
            iArr[i12] = i10;
            dArr2[i12] = cVarM65127r.f51079b;
        }
        int i13 = i12 + 1;
        double[] dArr3 = new double[i13];
        int[] iArr2 = new int[i13];
        if (i12 <= 399) {
            System.arraycopy(dArr2, 0, dArr3, 0, i13);
            System.arraycopy(iArr, 0, iArr2, 0, i13);
        }
        eVar.f51082a = m65116g(dArr2);
        c[] cVarArrM65119j = m65119j(dArr3);
        int[] iArr3 = new int[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            iArr3[i14] = iArr2[cVarArrM65119j[i14].f51078a];
        }
        int iMin = Math.min(50, i13);
        int[] iArr4 = new int[iMin];
        System.arraycopy(iArr3, 0, iArr4, 0, iMin);
        int[] iArrM65130u = m65130u(iArr4);
        eVar.f51083b = iArrM65130u;
        eVar.f51085d = iArrM65130u[iMin - 1];
        int i15 = 1;
        while (true) {
            if (i15 >= cVarM65127r.f51078a) {
                break;
            }
            double d11 = dArr[i15];
            if (d11 >= dArr[i15 - 1] && d11 > dArr[i15 + 1] && d11 >= cVarM65127r.f51079b * 0.6d) {
                eVar.f51085d = i15;
                break;
            }
            i15++;
        }
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0287  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p375iw.C10630c.e m65124o(p348hw.C10347b[] r28, p348hw.C10347b[] r29, int r30) {
        /*
            Method dump skipped, instructions count: 775
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p375iw.C10630c.m65124o(hw.b[], hw.b[], int):iw.c$e");
    }

    /* renamed from: p */
    public static int m65125p(int i10, int[] iArr, double[] dArr, double d10, double d11) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (dArr[i11] >= d11 * d10) {
                return iArr[i11];
            }
        }
        return i10;
    }

    /* renamed from: q */
    public static b[] m65126q(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr2[i10] = i10;
        }
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = 0;
            while (i12 < (length - i11) - 1) {
                int i13 = iArr[i12];
                int i14 = i12 + 1;
                int i15 = iArr[i14];
                if (i13 > i15) {
                    iArr[i12] = i15;
                    iArr[i14] = i13;
                    int i16 = iArr2[i12];
                    iArr2[i12] = iArr2[i14];
                    iArr2[i14] = i16;
                }
                i12 = i14;
            }
        }
        b[] bVarArr = new b[length];
        for (int i17 = 0; i17 < length; i17++) {
            bVarArr[i17] = new b();
        }
        for (int i18 = 0; i18 < length; i18++) {
            b bVar = bVarArr[i18];
            bVar.f51077b = iArr2[i18];
            bVar.f51076a = iArr[i18];
        }
        return bVarArr;
    }

    /* renamed from: r */
    public static c m65127r(double[] dArr) {
        c cVar = new c();
        int i10 = 0;
        double d10 = dArr[0];
        for (int i11 = 1; i11 < dArr.length; i11++) {
            double d11 = dArr[i11];
            if (d11 > d10) {
                i10 = i11;
                d10 = d11;
            }
        }
        cVar.f51078a = i10;
        cVar.f51079b = d10;
        return cVar;
    }

    /* renamed from: s */
    public static C10347b[] m65128s(int i10) {
        C10347b[] c10347bArr = new C10347b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            c10347bArr[i11] = new C10347b(0.0d, 0.0d);
        }
        return c10347bArr;
    }

    /* renamed from: t */
    public static double[] m65129t(double[] dArr, double[] dArr2, double d10, double[] dArr3) {
        double d11;
        double[] dArr4 = dArr;
        double[] dArr5 = dArr2;
        int length = dArr4.length;
        int length2 = dArr5.length - dArr4.length;
        double[] dArr6 = new double[length2];
        double d12 = 3.0d * d10;
        int i10 = 0;
        double d13 = 0.0d;
        double dAbs = 0.0d;
        while (i10 < length2) {
            double d14 = 0.0d;
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = i11 + i10;
                if (i12 < dArr5.length) {
                    d14 += dArr4[i11] * dArr5[i12];
                }
            }
            if (i10 == 0) {
                d11 = 0.0d;
                for (int i13 = 0; i13 < length; i13++) {
                    int i14 = i13 + i10;
                    if (i14 < dArr5.length) {
                        double dAbs2 = Math.abs(dArr5[i14]);
                        d13 += dAbs2;
                        if (dAbs2 > d11) {
                            d11 = dAbs2;
                        }
                    }
                }
                dAbs = Math.abs(dArr5[i10]);
            } else {
                int i15 = (length - 1) + i10;
                if (i15 < dArr5.length) {
                    double dAbs3 = Math.abs(dArr5[i15]);
                    double d15 = dAbs3 > 0.0d ? dAbs3 : 0.0d;
                    d13 = (d13 - dAbs) + dAbs3;
                    dAbs = Math.abs(dArr5[i10]);
                    d11 = d15;
                } else {
                    d11 = 0.0d;
                }
            }
            double dMax = Math.max(d13 / length, d11 / 8.0d);
            dArr3[i10] = Math.abs(d14);
            dArr6[i10] = Math.abs(d14) / Math.max(dMax, d12);
            i10++;
            dArr4 = dArr;
            dArr5 = dArr2;
        }
        return dArr6;
    }

    /* renamed from: u */
    public static int[] m65130u(int[] iArr) {
        HashSet hashSet = new HashSet();
        for (int i10 : iArr) {
            hashSet.add(Integer.valueOf(i10));
        }
        Object[] array = hashSet.toArray();
        Arrays.sort(array);
        int[] iArr2 = new int[array.length];
        for (int i11 = 0; i11 < array.length; i11++) {
            iArr2[i11] = Integer.parseInt(String.valueOf(array[i11]));
        }
        return iArr2;
    }
}
