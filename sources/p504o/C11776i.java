package p504o;

/* renamed from: o.i */
/* loaded from: classes.dex */
public class C11776i extends C11770c {

    /* renamed from: d */
    public double f54448d;

    /* renamed from: e */
    public double f54449e;

    public C11776i(String str) {
        this.f54393a = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.f54448d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i10 = iIndexOf2 + 1;
        this.f54449e = Double.parseDouble(str.substring(i10, str.indexOf(44, i10)).trim());
    }

    @Override // p504o.C11770c
    /* renamed from: a */
    public double mo70117a(double d10) {
        return m70148e(d10);
    }

    @Override // p504o.C11770c
    /* renamed from: b */
    public double mo70118b(double d10) {
        return m70147d(d10);
    }

    /* renamed from: d */
    public final double m70147d(double d10) {
        double d11 = this.f54449e;
        if (d10 < d11) {
            double d12 = this.f54448d;
            return ((d12 * d11) * d11) / ((((d11 - d10) * d12) + d10) * ((d12 * (d11 - d10)) + d10));
        }
        double d13 = this.f54448d;
        return (((d11 - 1.0d) * d13) * (d11 - 1.0d)) / (((((-d13) * (d11 - d10)) - d10) + 1.0d) * ((((-d13) * (d11 - d10)) - d10) + 1.0d));
    }

    /* renamed from: e */
    public final double m70148e(double d10) {
        double d11 = this.f54449e;
        return d10 < d11 ? (d11 * d10) / (d10 + (this.f54448d * (d11 - d10))) : ((1.0d - d11) * (d10 - 1.0d)) / ((1.0d - d10) - (this.f54448d * (d11 - d10)));
    }
}
