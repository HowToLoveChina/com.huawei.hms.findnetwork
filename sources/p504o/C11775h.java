package p504o;

import java.util.Arrays;

/* renamed from: o.h */
/* loaded from: classes.dex */
public class C11775h {

    /* renamed from: c */
    public double[] f54442c;

    /* renamed from: d */
    public String f54443d;

    /* renamed from: e */
    public C11774g f54444e;

    /* renamed from: f */
    public int f54445f;

    /* renamed from: a */
    public float[] f54440a = new float[0];

    /* renamed from: b */
    public double[] f54441b = new double[0];

    /* renamed from: g */
    public double f54446g = 6.283185307179586d;

    /* renamed from: h */
    public boolean f54447h = false;

    /* renamed from: a */
    public void m70140a(double d10, float f10) {
        int length = this.f54440a.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.f54441b, d10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.f54441b = Arrays.copyOf(this.f54441b, length);
        this.f54440a = Arrays.copyOf(this.f54440a, length);
        this.f54442c = new double[length];
        double[] dArr = this.f54441b;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.f54441b[iBinarySearch] = d10;
        this.f54440a[iBinarySearch] = f10;
        this.f54447h = false;
    }

    /* renamed from: b */
    public double m70141b(double d10) {
        if (d10 <= 0.0d) {
            return 0.0d;
        }
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f54441b, d10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.f54440a;
        float f10 = fArr[iBinarySearch];
        int i10 = iBinarySearch - 1;
        float f11 = fArr[i10];
        double d11 = f10 - f11;
        double[] dArr = this.f54441b;
        double d12 = dArr[iBinarySearch];
        double d13 = dArr[i10];
        double d14 = d11 / (d12 - d13);
        return (d10 * d14) + (f11 - (d14 * d13));
    }

    /* renamed from: c */
    public double m70142c(double d10) {
        if (d10 <= 0.0d) {
            return 0.0d;
        }
        if (d10 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f54441b, d10);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.f54440a;
        float f10 = fArr[iBinarySearch];
        int i10 = iBinarySearch - 1;
        float f11 = fArr[i10];
        double d11 = f10 - f11;
        double[] dArr = this.f54441b;
        double d12 = dArr[iBinarySearch];
        double d13 = dArr[i10];
        double d14 = d11 / (d12 - d13);
        return this.f54442c[i10] + ((f11 - (d14 * d13)) * (d10 - d13)) + ((d14 * ((d10 * d10) - (d13 * d13))) / 2.0d);
    }

    /* renamed from: d */
    public double m70143d(double d10, double d11, double d12) {
        double d13;
        double dSignum;
        double dM70142c = d11 + m70142c(d10);
        double dM70141b = m70141b(d10) + d12;
        switch (this.f54445f) {
            case 1:
                return 0.0d;
            case 2:
                d13 = dM70141b * 4.0d;
                dSignum = Math.signum((((dM70142c * 4.0d) + 3.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return dM70141b * 2.0d;
            case 4:
                return (-dM70141b) * 2.0d;
            case 5:
                double d14 = this.f54446g;
                return (-d14) * dM70141b * Math.sin(d14 * dM70142c);
            case 6:
                d13 = dM70141b * 4.0d;
                dSignum = (((dM70142c * 4.0d) + 2.0d) % 4.0d) - 2.0d;
                break;
            case 7:
                return this.f54444e.mo70100f(dM70142c % 1.0d, 0);
            default:
                double d15 = this.f54446g;
                d13 = dM70141b * d15;
                dSignum = Math.cos(d15 * dM70142c);
                break;
        }
        return d13 * dSignum;
    }

    /* renamed from: e */
    public double m70144e(double d10, double d11) {
        double dM70142c = m70142c(d10) + d11;
        switch (this.f54445f) {
            case 1:
                return Math.signum(0.5d - (dM70142c % 1.0d));
            case 2:
                return 1.0d - Math.abs((((dM70142c * 4.0d) + 1.0d) % 4.0d) - 2.0d);
            case 3:
                return (((dM70142c * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                return 1.0d - (((dM70142c * 2.0d) + 1.0d) % 2.0d);
            case 5:
                return Math.cos(this.f54446g * (d11 + dM70142c));
            case 6:
                double dAbs = 1.0d - Math.abs(((dM70142c * 4.0d) % 4.0d) - 2.0d);
                return 1.0d - (dAbs * dAbs);
            case 7:
                return this.f54444e.mo70097c(dM70142c % 1.0d, 0);
            default:
                return Math.sin(this.f54446g * dM70142c);
        }
    }

    /* renamed from: f */
    public void m70145f() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f54440a.length) {
                break;
            }
            d10 += r6[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr = this.f54440a;
            if (i11 >= fArr.length) {
                break;
            }
            int i12 = i11 - 1;
            float f10 = (fArr[i12] + fArr[i11]) / 2.0f;
            double[] dArr = this.f54441b;
            d11 += (dArr[i11] - dArr[i12]) * f10;
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr2 = this.f54440a;
            if (i13 >= fArr2.length) {
                break;
            }
            fArr2[i13] = fArr2[i13] * ((float) (d10 / d11));
            i13++;
        }
        this.f54442c[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr3 = this.f54440a;
            if (i14 >= fArr3.length) {
                this.f54447h = true;
                return;
            }
            int i15 = i14 - 1;
            float f11 = (fArr3[i15] + fArr3[i14]) / 2.0f;
            double[] dArr2 = this.f54441b;
            double d12 = dArr2[i14] - dArr2[i15];
            double[] dArr3 = this.f54442c;
            dArr3[i14] = dArr3[i15] + (d12 * f11);
            i14++;
        }
    }

    /* renamed from: g */
    public void m70146g(int i10, String str) {
        this.f54445f = i10;
        this.f54443d = str;
        if (str != null) {
            this.f54444e = C11774g.m70136i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f54441b) + " period=" + Arrays.toString(this.f54440a);
    }
}
