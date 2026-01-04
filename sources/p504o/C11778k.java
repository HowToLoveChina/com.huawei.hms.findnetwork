package p504o;

/* renamed from: o.k */
/* loaded from: classes.dex */
public class C11778k implements InterfaceC11780m {

    /* renamed from: c */
    public double f54457c;

    /* renamed from: d */
    public double f54458d;

    /* renamed from: e */
    public double f54459e;

    /* renamed from: f */
    public float f54460f;

    /* renamed from: g */
    public float f54461g;

    /* renamed from: h */
    public float f54462h;

    /* renamed from: i */
    public float f54463i;

    /* renamed from: j */
    public float f54464j;

    /* renamed from: a */
    public double f54455a = 0.5d;

    /* renamed from: b */
    public boolean f54456b = false;

    /* renamed from: k */
    public int f54465k = 0;

    @Override // p504o.InterfaceC11780m
    /* renamed from: a */
    public boolean mo70157a() {
        double d10 = this.f54461g - this.f54458d;
        double d11 = this.f54457c;
        double d12 = this.f54462h;
        return Math.sqrt((((d12 * d12) * ((double) this.f54463i)) + ((d11 * d10) * d10)) / d11) <= ((double) this.f54464j);
    }

    @Override // p504o.InterfaceC11780m
    /* renamed from: b */
    public float mo70158b() {
        return 0.0f;
    }

    /* renamed from: c */
    public final void m70159c(double d10) {
        if (d10 <= 0.0d) {
            return;
        }
        double d11 = this.f54457c;
        double d12 = this.f54455a;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d11 / this.f54463i) * d10) * 4.0d)) + 1.0d);
        double d13 = d10 / iSqrt;
        int i10 = 0;
        while (i10 < iSqrt) {
            float f10 = this.f54461g;
            double d14 = this.f54458d;
            float f11 = this.f54462h;
            double d15 = d11;
            double d16 = ((-d11) * (f10 - d14)) - (f11 * d12);
            float f12 = this.f54463i;
            double d17 = d12;
            double d18 = f11 + (((d16 / f12) * d13) / 2.0d);
            double d19 = ((((-((f10 + ((d13 * d18) / 2.0d)) - d14)) * d15) - (d18 * d17)) / f12) * d13;
            double d20 = f11 + (d19 / 2.0d);
            float f13 = f11 + ((float) d19);
            this.f54462h = f13;
            float f14 = f10 + ((float) (d20 * d13));
            this.f54461g = f14;
            int i11 = this.f54465k;
            if (i11 > 0) {
                if (f14 < 0.0f && (i11 & 1) == 1) {
                    this.f54461g = -f14;
                    this.f54462h = -f13;
                }
                float f15 = this.f54461g;
                if (f15 > 1.0f && (i11 & 2) == 2) {
                    this.f54461g = 2.0f - f15;
                    this.f54462h = -this.f54462h;
                }
            }
            i10++;
            d11 = d15;
            d12 = d17;
        }
    }

    /* renamed from: d */
    public void m70160d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, int i10) {
        this.f54458d = f11;
        this.f54455a = f15;
        this.f54456b = false;
        this.f54461g = f10;
        this.f54459e = f12;
        this.f54457c = f14;
        this.f54463i = f13;
        this.f54464j = f16;
        this.f54465k = i10;
        this.f54460f = 0.0f;
    }

    @Override // p504o.InterfaceC11780m
    public float getInterpolation(float f10) {
        m70159c(f10 - this.f54460f);
        this.f54460f = f10;
        if (mo70157a()) {
            this.f54461g = (float) this.f54458d;
        }
        return this.f54461g;
    }
}
