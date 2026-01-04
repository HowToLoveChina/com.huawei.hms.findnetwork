package p504o;

/* renamed from: o.p */
/* loaded from: classes.dex */
public class C11783p {

    /* renamed from: a */
    public float f54494a;

    /* renamed from: b */
    public float f54495b;

    /* renamed from: c */
    public float f54496c;

    /* renamed from: d */
    public float f54497d;

    /* renamed from: e */
    public float f54498e;

    /* renamed from: f */
    public float f54499f;

    /* renamed from: a */
    public void m70174a(float f10, float f11, int i10, int i11, float[] fArr) {
        float f12 = fArr[0];
        float f13 = fArr[1];
        float f14 = (f11 - 0.5f) * 2.0f;
        float f15 = f12 + this.f54496c;
        float f16 = f13 + this.f54497d;
        float f17 = f15 + (this.f54494a * (f10 - 0.5f) * 2.0f);
        float f18 = f16 + (this.f54495b * f14);
        float radians = (float) Math.toRadians(this.f54499f);
        float radians2 = (float) Math.toRadians(this.f54498e);
        double d10 = radians;
        double d11 = i11 * f14;
        float fSin = f17 + (((float) ((((-i10) * r7) * Math.sin(d10)) - (Math.cos(d10) * d11))) * radians2);
        float fCos = f18 + (radians2 * ((float) (((i10 * r7) * Math.cos(d10)) - (d11 * Math.sin(d10)))));
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    /* renamed from: b */
    public void m70175b() {
        this.f54498e = 0.0f;
        this.f54497d = 0.0f;
        this.f54496c = 0.0f;
        this.f54495b = 0.0f;
        this.f54494a = 0.0f;
    }

    /* renamed from: c */
    public void m70176c(AbstractC11772e abstractC11772e, float f10) {
        if (abstractC11772e != null) {
            this.f54498e = abstractC11772e.m70124b(f10);
        }
    }

    /* renamed from: d */
    public void m70177d(AbstractC11777j abstractC11777j, float f10) {
        if (abstractC11777j != null) {
            this.f54498e = abstractC11777j.m70150b(f10);
            this.f54499f = abstractC11777j.m70149a(f10);
        }
    }

    /* renamed from: e */
    public void m70178e(AbstractC11772e abstractC11772e, AbstractC11772e abstractC11772e2, float f10) {
        if (abstractC11772e != null) {
            this.f54494a = abstractC11772e.m70124b(f10);
        }
        if (abstractC11772e2 != null) {
            this.f54495b = abstractC11772e2.m70124b(f10);
        }
    }

    /* renamed from: f */
    public void m70179f(AbstractC11777j abstractC11777j, AbstractC11777j abstractC11777j2, float f10) {
        if (abstractC11777j != null) {
            this.f54494a = abstractC11777j.m70150b(f10);
        }
        if (abstractC11777j2 != null) {
            this.f54495b = abstractC11777j2.m70150b(f10);
        }
    }

    /* renamed from: g */
    public void m70180g(AbstractC11772e abstractC11772e, AbstractC11772e abstractC11772e2, float f10) {
        if (abstractC11772e != null) {
            this.f54496c = abstractC11772e.m70124b(f10);
        }
        if (abstractC11772e2 != null) {
            this.f54497d = abstractC11772e2.m70124b(f10);
        }
    }

    /* renamed from: h */
    public void m70181h(AbstractC11777j abstractC11777j, AbstractC11777j abstractC11777j2, float f10) {
        if (abstractC11777j != null) {
            this.f54496c = abstractC11777j.m70150b(f10);
        }
        if (abstractC11777j2 != null) {
            this.f54497d = abstractC11777j2.m70150b(f10);
        }
    }
}
