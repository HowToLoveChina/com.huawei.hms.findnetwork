package p504o;

import java.text.DecimalFormat;
import java.util.Arrays;

/* renamed from: o.j */
/* loaded from: classes.dex */
public abstract class AbstractC11777j {

    /* renamed from: a */
    public AbstractC11769b f54450a;

    /* renamed from: b */
    public int[] f54451b = new int[10];

    /* renamed from: c */
    public float[] f54452c = new float[10];

    /* renamed from: d */
    public int f54453d;

    /* renamed from: e */
    public String f54454e;

    /* renamed from: o.j$a */
    public static class a {
        /* renamed from: a */
        public static void m70154a(int[] iArr, float[] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int iM70155b = m70155b(iArr, fArr, i13, i15);
                    iArr2[i14] = iM70155b - 1;
                    iArr2[i12 - 1] = i13;
                    int i16 = i12 + 1;
                    iArr2[i12] = i15;
                    i12 += 2;
                    iArr2[i16] = iM70155b + 1;
                } else {
                    i12 = i14;
                }
            }
        }

        /* renamed from: b */
        public static int m70155b(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    m70156c(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            m70156c(iArr, fArr, i13, i11);
            return i13;
        }

        /* renamed from: c */
        public static void m70156c(int[] iArr, float[] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
        }
    }

    /* renamed from: a */
    public float m70149a(float f10) {
        return (float) this.f54450a.mo70097c(f10, 0);
    }

    /* renamed from: b */
    public float m70150b(float f10) {
        return (float) this.f54450a.mo70100f(f10, 0);
    }

    /* renamed from: c */
    public void mo70151c(int i10, float f10) {
        int[] iArr = this.f54451b;
        if (iArr.length < this.f54453d + 1) {
            this.f54451b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f54452c;
            this.f54452c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f54451b;
        int i11 = this.f54453d;
        iArr2[i11] = i10;
        this.f54452c[i11] = f10;
        this.f54453d = i11 + 1;
    }

    /* renamed from: d */
    public void m70152d(String str) {
        this.f54454e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo70153e(int r10) {
        /*
            r9 = this;
            int r0 = r9.f54453d
            if (r0 != 0) goto L5
            return
        L5:
            int[] r1 = r9.f54451b
            float[] r2 = r9.f54452c
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            p504o.AbstractC11777j.a.m70154a(r1, r2, r4, r0)
            r0 = r3
            r1 = r0
        L11:
            int r2 = r9.f54453d
            if (r0 >= r2) goto L24
            int[] r2 = r9.f54451b
            int r5 = r0 + (-1)
            r5 = r2[r5]
            r2 = r2[r0]
            if (r5 == r2) goto L21
            int r1 = r1 + 1
        L21:
            int r0 = r0 + 1
            goto L11
        L24:
            double[] r0 = new double[r1]
            int[] r1 = new int[]{r1, r3}
            java.lang.Class r2 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r2, r1)
            double[][] r1 = (double[][]) r1
            r2 = r4
            r3 = r2
        L34:
            int r5 = r9.f54453d
            if (r2 >= r5) goto L60
            if (r2 <= 0) goto L45
            int[] r5 = r9.f54451b
            r6 = r5[r2]
            int r7 = r2 + (-1)
            r5 = r5[r7]
            if (r6 != r5) goto L45
            goto L5d
        L45:
            int[] r5 = r9.f54451b
            r5 = r5[r2]
            double r5 = (double) r5
            r7 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r5 = r5 * r7
            r0[r3] = r5
            r5 = r1[r3]
            float[] r6 = r9.f54452c
            r6 = r6[r2]
            double r6 = (double) r6
            r5[r4] = r6
            int r3 = r3 + 1
        L5d:
            int r2 = r2 + 1
            goto L34
        L60:
            o.b r10 = p504o.AbstractC11769b.m70114a(r10, r0, r1)
            r9.f54450a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p504o.AbstractC11777j.mo70153e(int):void");
    }

    public String toString() {
        String str = this.f54454e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f54453d; i10++) {
            str = str + "[" + this.f54451b[i10] + " , " + decimalFormat.format(this.f54452c[i10]) + "] ";
        }
        return str;
    }
}
