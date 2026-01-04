package com.huawei.animation.physical2;

/* renamed from: com.huawei.animation.physical2.h */
/* loaded from: classes4.dex */
public class C4559h {

    /* renamed from: a */
    public float f20929a = 0.0f;

    /* renamed from: b */
    public float f20930b = 0.0f;

    /* renamed from: c */
    public float f20931c = 1.0f;

    /* renamed from: d */
    public float f20932d = 0.001f;

    /* renamed from: e */
    public float f20933e = 228.0f;

    /* renamed from: f */
    public float f20934f = 30.0f;

    /* renamed from: g */
    public float f20935g = 1.0f;

    /* renamed from: h */
    public float f20936h = 0.001f;

    /* renamed from: i */
    public c f20937i = new e();

    /* renamed from: j */
    public float f20938j = this.f20932d * 62.5f;

    /* renamed from: com.huawei.animation.physical2.h$a */
    public static class a implements c {

        /* renamed from: a */
        public float f20939a;

        /* renamed from: b */
        public float f20940b;

        /* renamed from: c */
        public float f20941c;

        public a(float f10, float f11, float f12) {
            this.f20939a = f10;
            this.f20940b = f11;
            this.f20941c = f12;
        }

        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: a */
        public float mo28019a(float f10) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f20941c * f10);
            float f11 = this.f20941c;
            float f12 = this.f20939a;
            float f13 = this.f20940b;
            return (f11 * (f12 + (f10 * f13)) * fPow) + (f13 * fPow);
        }

        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: b */
        public float mo28020b(float f10) {
            return (float) ((this.f20939a + (this.f20940b * f10)) * Math.pow(2.718281828459045d, this.f20941c * f10));
        }
    }

    /* renamed from: com.huawei.animation.physical2.h$b */
    public static class b implements c {

        /* renamed from: a */
        public float f20942a;

        /* renamed from: b */
        public float f20943b;

        /* renamed from: c */
        public float f20944c;

        /* renamed from: d */
        public float f20945d;

        public b(float f10, float f11, float f12, float f13) {
            this.f20942a = f10;
            this.f20943b = f11;
            this.f20944c = f12;
            this.f20945d = f13;
        }

        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: a */
        public float mo28019a(float f10) {
            return (this.f20942a * this.f20944c * ((float) Math.pow(2.718281828459045d, r1 * f10))) + (this.f20943b * this.f20945d * ((float) Math.pow(2.718281828459045d, r5 * f10)));
        }

        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: b */
        public float mo28020b(float f10) {
            return (this.f20942a * ((float) Math.pow(2.718281828459045d, this.f20944c * f10))) + (this.f20943b * ((float) Math.pow(2.718281828459045d, this.f20945d * f10)));
        }
    }

    /* renamed from: com.huawei.animation.physical2.h$c */
    public interface c {
        /* renamed from: a */
        float mo28019a(float f10);

        /* renamed from: b */
        float mo28020b(float f10);
    }

    /* renamed from: com.huawei.animation.physical2.h$d */
    public static class d implements c {

        /* renamed from: a */
        public float f20946a;

        /* renamed from: b */
        public float f20947b;

        /* renamed from: c */
        public float f20948c;

        /* renamed from: d */
        public float f20949d;

        public d(float f10, float f11, float f12, float f13) {
            this.f20946a = f10;
            this.f20947b = f11;
            this.f20948c = f12;
            this.f20949d = f13;
        }

        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: a */
        public float mo28019a(float f10) {
            float fPow = (float) Math.pow(2.718281828459045d, this.f20949d * f10);
            float fCos = (float) Math.cos(this.f20948c * f10);
            float fSin = (float) Math.sin(this.f20948c * f10);
            float f11 = this.f20947b;
            float f12 = this.f20948c;
            float f13 = this.f20946a;
            return ((((f11 * f12) * fCos) - ((f12 * f13) * fSin)) * fPow) + (this.f20949d * fPow * ((f11 * fSin) + (f13 * fCos)));
        }

        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: b */
        public float mo28020b(float f10) {
            return ((float) Math.pow(2.718281828459045d, this.f20949d * f10)) * ((this.f20946a * ((float) Math.cos(this.f20948c * f10))) + (this.f20947b * ((float) Math.sin(this.f20948c * f10))));
        }
    }

    /* renamed from: com.huawei.animation.physical2.h$e */
    public static class e implements c {
        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: a */
        public float mo28019a(float f10) {
            return 0.0f;
        }

        @Override // com.huawei.animation.physical2.C4559h.c
        /* renamed from: b */
        public float mo28020b(float f10) {
            return 0.0f;
        }
    }

    /* renamed from: a */
    public final c m28007a() {
        c dVar;
        float f10 = this.f20935g;
        if (f10 == 0.0f) {
            return this.f20937i;
        }
        float f11 = this.f20929a - this.f20931c;
        float f12 = this.f20934f;
        float f13 = (f12 * f12) - ((4.0f * f10) * this.f20933e);
        if (f13 == 0.0f) {
            float f14 = (-f12) / (f10 * 2.0f);
            return new a(f11, this.f20930b - (f14 * f11), f14);
        }
        if (f13 > 0.0f) {
            double d10 = -f12;
            double d11 = f13;
            float fSqrt = (float) ((d10 - Math.sqrt(d11)) / (this.f20935g * 2.0f));
            float fSqrt2 = (float) (((-this.f20934f) + Math.sqrt(d11)) / (this.f20935g * 2.0f));
            float f15 = fSqrt2 - fSqrt;
            if (Math.abs(f15) < 1.0E-6f) {
                return this.f20937i;
            }
            float f16 = (this.f20930b - (fSqrt * f11)) / f15;
            dVar = new b(f11 - f16, f16, fSqrt, fSqrt2);
        } else {
            double dSqrt = Math.sqrt(-f13);
            float f17 = (float) (dSqrt / (r3 * 2.0f));
            float f18 = (-this.f20934f) / (this.f20935g * 2.0f);
            dVar = new d(f11, (this.f20930b - (f18 * f11)) / f17, f17, f18);
        }
        return dVar;
    }

    /* renamed from: b */
    public float m28008b() {
        return this.f20931c;
    }

    /* renamed from: c */
    public float m28009c(long j10) {
        return this.f20937i.mo28020b(j10 / 1000.0f) + this.f20931c;
    }

    /* renamed from: d */
    public float m28010d(long j10) {
        return this.f20937i.mo28019a(j10 / 1000.0f);
    }

    /* renamed from: e */
    public C4559h m28011e() {
        this.f20937i = m28007a();
        return this;
    }

    /* renamed from: f */
    public boolean m28012f(float f10, float f11) {
        return ((double) Math.abs(f11)) < ((double) this.f20938j) && ((double) Math.abs(f10 - this.f20931c)) < ((double) this.f20932d);
    }

    /* renamed from: g */
    public C4559h m28013g(float f10) {
        this.f20934f = f10;
        return this;
    }

    /* renamed from: h */
    public C4559h m28014h(float f10) {
        this.f20931c = f10;
        return this;
    }

    /* renamed from: i */
    public C4559h m28015i(float f10) {
        this.f20929a = f10;
        return this;
    }

    /* renamed from: j */
    public C4559h m28016j(float f10) {
        this.f20930b = f10;
        return this;
    }

    /* renamed from: k */
    public C4559h m28017k(float f10) {
        this.f20933e = f10;
        return this;
    }

    /* renamed from: l */
    public C4559h m28018l(float f10) {
        this.f20932d = f10;
        this.f20938j = f10 * 62.5f;
        return this;
    }

    public String toString() {
        return "Spring{startValue=" + this.f20929a + ", startVelocity=" + this.f20930b + ", endValue=" + this.f20931c + ", valueAccuracy=" + this.f20932d + ", stiffness=" + this.f20933e + ", damping=" + this.f20934f + ", mass=" + this.f20935g + ", timeEstimateSpan=" + this.f20936h + ", calcSpring=" + this.f20937i + ", velocityAccuracy=" + this.f20938j + '}';
    }
}
