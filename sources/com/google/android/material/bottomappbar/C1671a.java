package com.google.android.material.bottomappbar;

import p356i3.C10425f;
import p356i3.C10434o;

/* renamed from: com.google.android.material.bottomappbar.a */
/* loaded from: classes.dex */
public class C1671a extends C10425f implements Cloneable {

    /* renamed from: a */
    public float f7568a;

    /* renamed from: b */
    public float f7569b;

    /* renamed from: c */
    public float f7570c;

    /* renamed from: d */
    public float f7571d;

    /* renamed from: e */
    public float f7572e;

    /* renamed from: f */
    public float f7573f = -1.0f;

    public C1671a(float f10, float f11, float f12) {
        this.f7569b = f10;
        this.f7568a = f11;
        m9806m(f12);
        this.f7572e = 0.0f;
    }

    @Override // p356i3.C10425f
    /* renamed from: d */
    public void mo9799d(float f10, float f11, float f12, C10434o c10434o) {
        float f13;
        float f14;
        float f15 = this.f7570c;
        if (f15 == 0.0f) {
            c10434o.m64132m(f10, 0.0f);
            return;
        }
        float f16 = ((this.f7569b * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.f7568a;
        float f18 = f11 + this.f7572e;
        float f19 = (this.f7571d * f12) + ((1.0f - f12) * f16);
        if (f19 / f16 >= 1.0f) {
            c10434o.m64132m(f10, 0.0f);
            return;
        }
        float f20 = this.f7573f;
        float f21 = f20 * f12;
        boolean z10 = f20 == -1.0f || Math.abs((f20 * 2.0f) - f15) < 0.1f;
        if (z10) {
            f13 = f19;
            f14 = 0.0f;
        } else {
            f14 = 1.75f;
            f13 = 0.0f;
        }
        float f22 = f16 + f17;
        float f23 = f13 + f17;
        float fSqrt = (float) Math.sqrt((f22 * f22) - (f23 * f23));
        float f24 = f18 - fSqrt;
        float f25 = f18 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f23));
        float f26 = (90.0f - degrees) + f14;
        c10434o.m64132m(f24, 0.0f);
        float f27 = f17 * 2.0f;
        c10434o.m64120a(f24 - f17, 0.0f, f24 + f17, f27, 270.0f, degrees);
        if (z10) {
            c10434o.m64120a(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f26, (f26 * 2.0f) - 180.0f);
        } else {
            float f28 = this.f7569b;
            float f29 = f21 * 2.0f;
            float f30 = f18 - f16;
            c10434o.m64120a(f30, -(f21 + f28), f30 + f28 + f29, f28 + f21, 180.0f - f26, ((f26 * 2.0f) - 180.0f) / 2.0f);
            float f31 = f18 + f16;
            float f32 = this.f7569b;
            c10434o.m64132m(f31 - ((f32 / 2.0f) + f21), f32 + f21);
            float f33 = this.f7569b;
            c10434o.m64120a(f31 - (f29 + f33), -(f21 + f33), f31, f33 + f21, 90.0f, f26 - 90.0f);
        }
        c10434o.m64120a(f25 - f17, 0.0f, f25 + f17, f27, 270.0f - degrees, degrees);
        c10434o.m64132m(f10, 0.0f);
    }

    /* renamed from: f */
    public float m9800f() {
        return this.f7571d;
    }

    /* renamed from: g */
    public float m9801g() {
        return this.f7573f;
    }

    /* renamed from: i */
    public float m9802i() {
        return this.f7569b;
    }

    /* renamed from: j */
    public float m9803j() {
        return this.f7568a;
    }

    /* renamed from: k */
    public float m9804k() {
        return this.f7570c;
    }

    /* renamed from: l */
    public float m9805l() {
        return this.f7572e;
    }

    /* renamed from: m */
    public void m9806m(float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f7571d = f10;
    }

    /* renamed from: n */
    public void m9807n(float f10) {
        this.f7573f = f10;
    }

    /* renamed from: o */
    public void m9808o(float f10) {
        this.f7569b = f10;
    }

    /* renamed from: p */
    public void m9809p(float f10) {
        this.f7568a = f10;
    }

    /* renamed from: q */
    public void m9810q(float f10) {
        this.f7570c = f10;
    }

    /* renamed from: r */
    public void m9811r(float f10) {
        this.f7572e = f10;
    }
}
