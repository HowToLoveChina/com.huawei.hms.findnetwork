package p504o;

/* renamed from: o.n */
/* loaded from: classes.dex */
public class C11781n implements InterfaceC11780m {

    /* renamed from: a */
    public float f54467a;

    /* renamed from: b */
    public float f54468b;

    /* renamed from: c */
    public float f54469c;

    /* renamed from: d */
    public float f54470d;

    /* renamed from: e */
    public float f54471e;

    /* renamed from: f */
    public float f54472f;

    /* renamed from: g */
    public float f54473g;

    /* renamed from: h */
    public float f54474h;

    /* renamed from: i */
    public float f54475i;

    /* renamed from: j */
    public int f54476j;

    /* renamed from: k */
    public String f54477k;

    /* renamed from: m */
    public float f54479m;

    /* renamed from: n */
    public float f54480n;

    /* renamed from: o */
    public float f54481o;

    /* renamed from: l */
    public boolean f54478l = false;

    /* renamed from: p */
    public boolean f54482p = false;

    @Override // p504o.InterfaceC11780m
    /* renamed from: a */
    public boolean mo70157a() {
        return mo70158b() < 1.0E-5f && Math.abs(this.f54475i - this.f54480n) < 1.0E-5f;
    }

    @Override // p504o.InterfaceC11780m
    /* renamed from: b */
    public float mo70158b() {
        return this.f54478l ? -m70164e(this.f54481o) : m70164e(this.f54481o);
    }

    /* renamed from: c */
    public final float m70162c(float f10) {
        this.f54482p = false;
        float f11 = this.f54470d;
        if (f10 <= f11) {
            float f12 = this.f54467a;
            return (f12 * f10) + ((((this.f54468b - f12) * f10) * f10) / (f11 * 2.0f));
        }
        int i10 = this.f54476j;
        if (i10 == 1) {
            return this.f54473g;
        }
        float f13 = f10 - f11;
        float f14 = this.f54471e;
        if (f13 < f14) {
            float f15 = this.f54473g;
            float f16 = this.f54468b;
            return f15 + (f16 * f13) + ((((this.f54469c - f16) * f13) * f13) / (f14 * 2.0f));
        }
        if (i10 == 2) {
            return this.f54474h;
        }
        float f17 = f13 - f14;
        float f18 = this.f54472f;
        if (f17 > f18) {
            this.f54482p = true;
            return this.f54475i;
        }
        float f19 = this.f54474h;
        float f20 = this.f54469c;
        return (f19 + (f20 * f17)) - (((f20 * f17) * f17) / (f18 * 2.0f));
    }

    /* renamed from: d */
    public void m70163d(float f10, float f11, float f12, float f13, float f14, float f15) {
        this.f54482p = false;
        this.f54479m = f10;
        boolean z10 = f10 > f11;
        this.f54478l = z10;
        if (z10) {
            m70165f(-f12, f10 - f11, f14, f15, f13);
        } else {
            m70165f(f12, f11 - f10, f14, f15, f13);
        }
    }

    /* renamed from: e */
    public float m70164e(float f10) {
        float f11;
        float f12;
        float f13 = this.f54470d;
        if (f10 <= f13) {
            f11 = this.f54467a;
            f12 = this.f54468b;
        } else {
            int i10 = this.f54476j;
            if (i10 == 1) {
                return 0.0f;
            }
            f10 -= f13;
            f13 = this.f54471e;
            if (f10 >= f13) {
                if (i10 == 2) {
                    return 0.0f;
                }
                float f14 = f10 - f13;
                float f15 = this.f54472f;
                if (f14 >= f15) {
                    return 0.0f;
                }
                float f16 = this.f54469c;
                return f16 - ((f14 * f16) / f15);
            }
            f11 = this.f54468b;
            f12 = this.f54469c;
        }
        return f11 + (((f12 - f11) * f10) / f13);
    }

    /* renamed from: f */
    public final void m70165f(float f10, float f11, float f12, float f13, float f14) {
        this.f54482p = false;
        this.f54475i = f11;
        if (f10 == 0.0f) {
            f10 = 1.0E-4f;
        }
        float f15 = f10 / f12;
        float f16 = (f15 * f10) / 2.0f;
        if (f10 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f11 - ((((-f10) / f12) * f10) / 2.0f)) * f12);
            if (fSqrt < f13) {
                this.f54477k = "backward accelerate, decelerate";
                this.f54476j = 2;
                this.f54467a = f10;
                this.f54468b = fSqrt;
                this.f54469c = 0.0f;
                float f17 = (fSqrt - f10) / f12;
                this.f54470d = f17;
                this.f54471e = fSqrt / f12;
                this.f54473g = ((f10 + fSqrt) * f17) / 2.0f;
                this.f54474h = f11;
                this.f54475i = f11;
                return;
            }
            this.f54477k = "backward accelerate cruse decelerate";
            this.f54476j = 3;
            this.f54467a = f10;
            this.f54468b = f13;
            this.f54469c = f13;
            float f18 = (f13 - f10) / f12;
            this.f54470d = f18;
            float f19 = f13 / f12;
            this.f54472f = f19;
            float f20 = ((f10 + f13) * f18) / 2.0f;
            float f21 = (f19 * f13) / 2.0f;
            this.f54471e = ((f11 - f20) - f21) / f13;
            this.f54473g = f20;
            this.f54474h = f11 - f21;
            this.f54475i = f11;
            return;
        }
        if (f16 >= f11) {
            this.f54477k = "hard stop";
            this.f54476j = 1;
            this.f54467a = f10;
            this.f54468b = 0.0f;
            this.f54473g = f11;
            this.f54470d = (2.0f * f11) / f10;
            return;
        }
        float f22 = f11 - f16;
        float f23 = f22 / f10;
        if (f23 + f15 < f14) {
            this.f54477k = "cruse decelerate";
            this.f54476j = 2;
            this.f54467a = f10;
            this.f54468b = f10;
            this.f54469c = 0.0f;
            this.f54473g = f22;
            this.f54474h = f11;
            this.f54470d = f23;
            this.f54471e = f15;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f12 * f11) + ((f10 * f10) / 2.0f));
        float f24 = (fSqrt2 - f10) / f12;
        this.f54470d = f24;
        float f25 = fSqrt2 / f12;
        this.f54471e = f25;
        if (fSqrt2 < f13) {
            this.f54477k = "accelerate decelerate";
            this.f54476j = 2;
            this.f54467a = f10;
            this.f54468b = fSqrt2;
            this.f54469c = 0.0f;
            this.f54470d = f24;
            this.f54471e = f25;
            this.f54473g = ((f10 + fSqrt2) * f24) / 2.0f;
            this.f54474h = f11;
            return;
        }
        this.f54477k = "accelerate cruse decelerate";
        this.f54476j = 3;
        this.f54467a = f10;
        this.f54468b = f13;
        this.f54469c = f13;
        float f26 = (f13 - f10) / f12;
        this.f54470d = f26;
        float f27 = f13 / f12;
        this.f54472f = f27;
        float f28 = ((f10 + f13) * f26) / 2.0f;
        float f29 = (f27 * f13) / 2.0f;
        this.f54471e = ((f11 - f28) - f29) / f13;
        this.f54473g = f28;
        this.f54474h = f11 - f29;
        this.f54475i = f11;
    }

    @Override // p504o.InterfaceC11780m
    public float getInterpolation(float f10) {
        float fM70162c = m70162c(f10);
        this.f54480n = fM70162c;
        this.f54481o = f10;
        boolean z10 = this.f54478l;
        float f11 = this.f54479m;
        return z10 ? f11 - fM70162c : f11 + fM70162c;
    }
}
