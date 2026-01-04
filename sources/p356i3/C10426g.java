package p356i3;

/* renamed from: i3.g */
/* loaded from: classes.dex */
public final class C10426g extends C10425f {

    /* renamed from: a */
    public final float f50257a;

    public C10426g(float f10) {
        this.f50257a = f10 - 0.001f;
    }

    @Override // p356i3.C10425f
    /* renamed from: c */
    public boolean mo63969c() {
        return true;
    }

    @Override // p356i3.C10425f
    /* renamed from: d */
    public void mo9799d(float f10, float f11, float f12, C10434o c10434o) {
        float fSqrt = (float) ((this.f50257a * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.f50257a, 2.0d) - Math.pow(fSqrt, 2.0d));
        c10434o.m64133n(f11 - fSqrt, ((float) (-((this.f50257a * Math.sqrt(2.0d)) - this.f50257a))) + fSqrt2);
        c10434o.m64132m(f11, (float) (-((this.f50257a * Math.sqrt(2.0d)) - this.f50257a)));
        c10434o.m64132m(f11 + fSqrt, ((float) (-((this.f50257a * Math.sqrt(2.0d)) - this.f50257a))) + fSqrt2);
    }
}
