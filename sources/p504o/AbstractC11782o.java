package p504o;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* renamed from: o.o */
/* loaded from: classes.dex */
public abstract class AbstractC11782o {

    /* renamed from: k */
    public static float f54483k = 6.2831855f;

    /* renamed from: a */
    public AbstractC11769b f54484a;

    /* renamed from: e */
    public int f54488e;

    /* renamed from: f */
    public String f54489f;

    /* renamed from: i */
    public long f54492i;

    /* renamed from: b */
    public int f54485b = 0;

    /* renamed from: c */
    public int[] f54486c = new int[10];

    /* renamed from: d */
    public float[][] f54487d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* renamed from: g */
    public float[] f54490g = new float[3];

    /* renamed from: h */
    public boolean f54491h = false;

    /* renamed from: j */
    public float f54493j = Float.NaN;

    /* renamed from: o.o$a */
    public static class a {
        /* renamed from: a */
        public static void m70171a(int[] iArr, float[][] fArr, int i10, int i11) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i11;
            iArr2[1] = i10;
            int i12 = 2;
            while (i12 > 0) {
                int i13 = iArr2[i12 - 1];
                int i14 = i12 - 2;
                int i15 = iArr2[i14];
                if (i13 < i15) {
                    int iM70172b = m70172b(iArr, fArr, i13, i15);
                    iArr2[i14] = iM70172b - 1;
                    iArr2[i12 - 1] = i13;
                    int i16 = i12 + 1;
                    iArr2[i12] = i15;
                    i12 += 2;
                    iArr2[i16] = iM70172b + 1;
                } else {
                    i12 = i14;
                }
            }
        }

        /* renamed from: b */
        public static int m70172b(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i11];
            int i13 = i10;
            while (i10 < i11) {
                if (iArr[i10] <= i12) {
                    m70173c(iArr, fArr, i13, i10);
                    i13++;
                }
                i10++;
            }
            m70173c(iArr, fArr, i13, i11);
            return i13;
        }

        /* renamed from: c */
        public static void m70173c(int[] iArr, float[][] fArr, int i10, int i11) {
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
            float[] fArr2 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = fArr2;
        }
    }

    /* renamed from: a */
    public float m70166a(float f10) {
        switch (this.f54485b) {
            case 1:
                return Math.signum(f10 * f54483k);
            case 2:
                return 1.0f - Math.abs(f10);
            case 3:
                return (((f10 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                return 1.0f - (((f10 * 2.0f) + 1.0f) % 2.0f);
            case 5:
                return (float) Math.cos(f10 * f54483k);
            case 6:
                float fAbs = 1.0f - Math.abs(((f10 * 4.0f) % 4.0f) - 2.0f);
                return 1.0f - (fAbs * fAbs);
            default:
                return (float) Math.sin(f10 * f54483k);
        }
    }

    /* renamed from: b */
    public void mo70167b(int i10, float f10, float f11, int i11, float f12) {
        int[] iArr = this.f54486c;
        int i12 = this.f54488e;
        iArr[i12] = i10;
        float[] fArr = this.f54487d[i12];
        fArr[0] = f10;
        fArr[1] = f11;
        fArr[2] = f12;
        this.f54485b = Math.max(this.f54485b, i11);
        this.f54488e++;
    }

    /* renamed from: c */
    public void m70168c(long j10) {
        this.f54492i = j10;
    }

    /* renamed from: d */
    public void m70169d(String str) {
        this.f54489f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo70170e(int r12) {
        /*
            r11 = this;
            int r0 = r11.f54488e
            if (r0 != 0) goto L1d
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error no points added to "
            r0.append(r1)
            java.lang.String r11 = r11.f54489f
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r12.println(r11)
            return
        L1d:
            int[] r1 = r11.f54486c
            float[][] r2 = r11.f54487d
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            p504o.AbstractC11782o.a.m70171a(r1, r2, r4, r0)
            r0 = r3
            r1 = r4
        L29:
            int[] r2 = r11.f54486c
            int r5 = r2.length
            if (r0 >= r5) goto L3b
            r5 = r2[r0]
            int r6 = r0 + (-1)
            r2 = r2[r6]
            if (r5 == r2) goto L38
            int r1 = r1 + 1
        L38:
            int r0 = r0 + 1
            goto L29
        L3b:
            if (r1 != 0) goto L3e
            r1 = r3
        L3e:
            double[] r0 = new double[r1]
            r2 = 3
            int[] r1 = new int[]{r1, r2}
            java.lang.Class r2 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r2, r1)
            double[][] r1 = (double[][]) r1
            r2 = r4
            r5 = r2
        L4f:
            int r6 = r11.f54488e
            if (r2 >= r6) goto L88
            if (r2 <= 0) goto L60
            int[] r6 = r11.f54486c
            r7 = r6[r2]
            int r8 = r2 + (-1)
            r6 = r6[r8]
            if (r7 != r6) goto L60
            goto L85
        L60:
            int[] r6 = r11.f54486c
            r6 = r6[r2]
            double r6 = (double) r6
            r8 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r6 = r6 * r8
            r0[r5] = r6
            r6 = r1[r5]
            float[][] r7 = r11.f54487d
            r7 = r7[r2]
            r8 = r7[r4]
            double r8 = (double) r8
            r6[r4] = r8
            r8 = r7[r3]
            double r8 = (double) r8
            r6[r3] = r8
            r8 = 2
            r7 = r7[r8]
            double r9 = (double) r7
            r6[r8] = r9
            int r5 = r5 + 1
        L85:
            int r2 = r2 + 1
            goto L4f
        L88:
            o.b r12 = p504o.AbstractC11769b.m70114a(r12, r0, r1)
            r11.f54484a = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p504o.AbstractC11782o.mo70170e(int):void");
    }

    public String toString() {
        String str = this.f54489f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i10 = 0; i10 < this.f54488e; i10++) {
            str = str + "[" + this.f54486c[i10] + " , " + decimalFormat.format(this.f54487d[i10]) + "] ";
        }
        return str;
    }
}
