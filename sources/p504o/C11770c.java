package p504o;

import java.util.Arrays;

/* renamed from: o.c */
/* loaded from: classes.dex */
public class C11770c {

    /* renamed from: b */
    public static C11770c f54391b = new C11770c();

    /* renamed from: c */
    public static String[] f54392c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a */
    public String f54393a = "identity";

    /* renamed from: o.c$a */
    public static class a extends C11770c {

        /* renamed from: h */
        public static double f54394h = 0.01d;

        /* renamed from: i */
        public static double f54395i = 1.0E-4d;

        /* renamed from: d */
        public double f54396d;

        /* renamed from: e */
        public double f54397e;

        /* renamed from: f */
        public double f54398f;

        /* renamed from: g */
        public double f54399g;

        public a(String str) {
            this.f54393a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f54396d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i10 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i10);
            this.f54397e = Double.parseDouble(str.substring(i10, iIndexOf3).trim());
            int i11 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i11);
            this.f54398f = Double.parseDouble(str.substring(i11, iIndexOf4).trim());
            int i12 = iIndexOf4 + 1;
            this.f54399g = Double.parseDouble(str.substring(i12, str.indexOf(41, i12)).trim());
        }

        @Override // p504o.C11770c
        /* renamed from: a */
        public double mo70117a(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f54394h) {
                d11 *= 0.5d;
                d12 = m70119d(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double dM70119d = m70119d(d13);
            double d14 = d12 + d11;
            double dM70119d2 = m70119d(d14);
            double dM70120e = m70120e(d13);
            return (((m70120e(d14) - dM70120e) * (d10 - dM70119d)) / (dM70119d2 - dM70119d)) + dM70120e;
        }

        @Override // p504o.C11770c
        /* renamed from: b */
        public double mo70118b(double d10) {
            double d11 = 0.5d;
            double d12 = 0.5d;
            while (d11 > f54395i) {
                d11 *= 0.5d;
                d12 = m70119d(d12) < d10 ? d12 + d11 : d12 - d11;
            }
            double d13 = d12 - d11;
            double d14 = d12 + d11;
            return (m70120e(d14) - m70120e(d13)) / (m70119d(d14) - m70119d(d13));
        }

        /* renamed from: d */
        public final double m70119d(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f54396d * d11 * d12 * d10) + (this.f54398f * d12 * d10 * d10) + (d10 * d10 * d10);
        }

        /* renamed from: e */
        public final double m70120e(double d10) {
            double d11 = 1.0d - d10;
            double d12 = 3.0d * d11;
            return (this.f54397e * d11 * d12 * d10) + (this.f54399g * d12 * d10 * d10) + (d10 * d10 * d10);
        }
    }

    /* renamed from: c */
    public static C11770c m70116c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new C11779l(str);
        }
        if (str.startsWith("Schlick")) {
            return new C11776i(str);
        }
        switch (str) {
            case "accelerate":
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case "decelerate":
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case "anticipate":
                return new a("cubic(0.36, 0, 0.66, -0.56)");
            case "linear":
                return new a("cubic(1, 1, 0, 0)");
            case "overshoot":
                return new a("cubic(0.34, 1.56, 0.64, 1)");
            case "standard":
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f54392c));
                return f54391b;
        }
    }

    /* renamed from: a */
    public double mo70117a(double d10) {
        return d10;
    }

    /* renamed from: b */
    public double mo70118b(double d10) {
        return 1.0d;
    }

    public String toString() {
        return this.f54393a;
    }
}
