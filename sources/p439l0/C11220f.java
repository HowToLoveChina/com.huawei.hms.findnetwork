package p439l0;

import p439l0.AbstractC11216b;

/* renamed from: l0.f */
/* loaded from: classes.dex */
public final class C11220f {

    /* renamed from: a */
    public double f52698a;

    /* renamed from: b */
    public double f52699b;

    /* renamed from: c */
    public boolean f52700c;

    /* renamed from: d */
    public double f52701d;

    /* renamed from: e */
    public double f52702e;

    /* renamed from: f */
    public double f52703f;

    /* renamed from: g */
    public double f52704g;

    /* renamed from: h */
    public double f52705h;

    /* renamed from: i */
    public double f52706i;

    /* renamed from: j */
    public final AbstractC11216b.p f52707j;

    public C11220f() {
        this.f52698a = Math.sqrt(1500.0d);
        this.f52699b = 0.5d;
        this.f52700c = false;
        this.f52706i = Double.MAX_VALUE;
        this.f52707j = new AbstractC11216b.p();
    }

    /* renamed from: a */
    public float m67407a() {
        return (float) this.f52706i;
    }

    /* renamed from: b */
    public final void m67408b() {
        if (this.f52700c) {
            return;
        }
        if (this.f52706i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d10 = this.f52699b;
        if (d10 > 1.0d) {
            double d11 = this.f52698a;
            this.f52703f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
            double d12 = this.f52699b;
            double d13 = this.f52698a;
            this.f52704g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
        } else if (d10 >= 0.0d && d10 < 1.0d) {
            this.f52705h = this.f52698a * Math.sqrt(1.0d - (d10 * d10));
        }
        this.f52700c = true;
    }

    /* renamed from: c */
    public boolean m67409c(float f10, float f11) {
        return ((double) Math.abs(f11)) < this.f52702e && ((double) Math.abs(f10 - m67407a())) < this.f52701d;
    }

    /* renamed from: d */
    public C11220f m67410d(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f52699b = f10;
        this.f52700c = false;
        return this;
    }

    /* renamed from: e */
    public C11220f m67411e(float f10) {
        this.f52706i = f10;
        return this;
    }

    /* renamed from: f */
    public C11220f m67412f(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f52698a = Math.sqrt(f10);
        this.f52700c = false;
        return this;
    }

    /* renamed from: g */
    public void m67413g(double d10) {
        double dAbs = Math.abs(d10);
        this.f52701d = dAbs;
        this.f52702e = dAbs * 62.5d;
    }

    /* renamed from: h */
    public AbstractC11216b.p m67414h(double d10, double d11, long j10) {
        double dCos;
        double dPow;
        m67408b();
        double d12 = j10 / 1000.0d;
        double d13 = d10 - this.f52706i;
        double d14 = this.f52699b;
        if (d14 > 1.0d) {
            double d15 = this.f52704g;
            double d16 = this.f52703f;
            double d17 = d13 - (((d15 * d13) - d11) / (d15 - d16));
            double d18 = ((d13 * d15) - d11) / (d15 - d16);
            dPow = (Math.pow(2.718281828459045d, d15 * d12) * d17) + (Math.pow(2.718281828459045d, this.f52703f * d12) * d18);
            double d19 = this.f52704g;
            double dPow2 = d17 * d19 * Math.pow(2.718281828459045d, d19 * d12);
            double d20 = this.f52703f;
            dCos = dPow2 + (d18 * d20 * Math.pow(2.718281828459045d, d20 * d12));
        } else if (d14 == 1.0d) {
            double d21 = this.f52698a;
            double d22 = d11 + (d21 * d13);
            double d23 = d13 + (d22 * d12);
            dPow = Math.pow(2.718281828459045d, (-d21) * d12) * d23;
            double dPow3 = d23 * Math.pow(2.718281828459045d, (-this.f52698a) * d12);
            double d24 = this.f52698a;
            dCos = (d22 * Math.pow(2.718281828459045d, (-d24) * d12)) + (dPow3 * (-d24));
        } else {
            double d25 = 1.0d / this.f52705h;
            double d26 = this.f52698a;
            double d27 = d25 * ((d14 * d26 * d13) + d11);
            double dPow4 = Math.pow(2.718281828459045d, (-d14) * d26 * d12) * ((Math.cos(this.f52705h * d12) * d13) + (Math.sin(this.f52705h * d12) * d27));
            double d28 = this.f52698a;
            double d29 = this.f52699b;
            double d30 = (-d28) * dPow4 * d29;
            double dPow5 = Math.pow(2.718281828459045d, (-d29) * d28 * d12);
            double d31 = this.f52705h;
            double dSin = (-d31) * d13 * Math.sin(d31 * d12);
            double d32 = this.f52705h;
            dCos = d30 + (dPow5 * (dSin + (d27 * d32 * Math.cos(d32 * d12))));
            dPow = dPow4;
        }
        AbstractC11216b.p pVar = this.f52707j;
        pVar.f52691a = (float) (dPow + this.f52706i);
        pVar.f52692b = (float) dCos;
        return pVar;
    }

    public C11220f(float f10) {
        this.f52698a = Math.sqrt(1500.0d);
        this.f52699b = 0.5d;
        this.f52700c = false;
        this.f52706i = Double.MAX_VALUE;
        this.f52707j = new AbstractC11216b.p();
        this.f52706i = f10;
    }
}
