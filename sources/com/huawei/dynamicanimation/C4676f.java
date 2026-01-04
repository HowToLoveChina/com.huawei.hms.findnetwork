package com.huawei.dynamicanimation;

import com.huawei.dynamicanimation.AbstractC4672b;

/* renamed from: com.huawei.dynamicanimation.f */
/* loaded from: classes5.dex */
public class C4676f extends AbstractC4672b<C4676f> {

    /* renamed from: G */
    public C4680j f21550G;

    /* renamed from: H */
    public float f21551H;

    /* renamed from: I */
    public float f21552I;

    /* renamed from: J */
    public float f21553J;

    /* renamed from: com.huawei.dynamicanimation.f$a */
    public class a extends AbstractC4674d {

        /* renamed from: b */
        public final /* synthetic */ C4675e f21554b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, C4675e c4675e) {
            super(str);
            this.f21554b = c4675e;
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: a */
        public float mo28644a(Object obj) {
            return this.f21554b.m28681a();
        }

        @Override // com.huawei.dynamicanimation.AbstractC4674d
        /* renamed from: b */
        public void mo28645b(Object obj, float f10) {
            this.f21554b.m28682b(f10);
        }
    }

    public <K> C4676f(K k10, AbstractC4674d<K> abstractC4674d, C4680j c4680j) {
        super(k10, abstractC4674d);
        this.f21551H = 0.0f;
        this.f21552I = 0.0f;
        this.f21553J = Float.MAX_VALUE;
        this.f21550G = c4680j;
        if (abstractC4674d != null) {
            this.f21551H = abstractC4674d.mo28644a(k10);
        }
        this.f21550G.setValueThreshold(m28632g()).snap(0.0f);
    }

    @Override // com.huawei.dynamicanimation.AbstractC4672b
    /* renamed from: t */
    public boolean mo28643t(long j10) {
        float f10 = this.f21553J;
        if (f10 != Float.MAX_VALUE) {
            this.f21552I = f10;
            this.f21553J = Float.MAX_VALUE;
            m28639p(this.f21524a);
            float fMo28644a = this.f21528e.mo28644a(this.f21527d);
            this.f21551H = fMo28644a;
            this.f21550G.setEndValue(this.f21552I - fMo28644a, this.f21524a);
            AbstractC4672b.o oVarM28691e = this.f21550G.m28691e(j10 / 2);
            this.f21525b = oVarM28691e.f21539a + this.f21551H;
            this.f21524a = oVarM28691e.f21540b;
            return false;
        }
        AbstractC4672b.o oVarM28691e2 = this.f21550G.m28691e(j10);
        float f11 = oVarM28691e2.f21539a;
        float f12 = this.f21551H;
        float f13 = f11 + f12;
        this.f21525b = f13;
        float f14 = oVarM28691e2.f21540b;
        this.f21524a = f14;
        if (!m28684v(f13 - f12, f14)) {
            return false;
        }
        this.f21525b = this.f21550G.getEndPosition() + this.f21551H;
        this.f21524a = 0.0f;
        return true;
    }

    /* renamed from: u */
    public C4680j m28683u() {
        return this.f21550G;
    }

    /* renamed from: v */
    public boolean m28684v(float f10, float f11) {
        return this.f21550G.isAtEquilibrium(f10, f11);
    }

    /* renamed from: w */
    public C4676f m28685w() {
        this.f21527d = null;
        this.f21528e = null;
        m28639p(0.0f);
        this.f21552I = 0.0f;
        this.f21551H = 0.0f;
        this.f21550G.m28690d().snap(0.0f).setEndPosition(1.0f, 0.0f, -1L);
        C4671a.m28615i().m28621l(this);
        return (C4676f) super.m28630e();
    }

    /* renamed from: x */
    public <K> C4676f m28686x(K k10, AbstractC4674d<K> abstractC4674d, float f10, float f11, float f12, float f13) {
        super.m28637n(k10, abstractC4674d);
        m28639p(f13);
        this.f21552I = f12;
        m28687y();
        this.f21550G.m28690d().setStiffness(f10).setDamping(f11).snap(0.0f).setEndPosition(f12 - this.f21551H, f13, -1L);
        return this;
    }

    /* renamed from: y */
    public final void m28687y() {
        AbstractC4674d abstractC4674d;
        Object obj = this.f21527d;
        if (obj != null && (abstractC4674d = this.f21528e) != null) {
            this.f21551H = abstractC4674d.mo28644a(obj);
            return;
        }
        AbstractC4674d abstractC4674d2 = this.f21528e;
        if (abstractC4674d2 == null) {
            this.f21528e = new a("FloatValueHolder", new C4675e(0.0f));
        } else {
            abstractC4674d2.mo28645b(obj, 0.0f);
        }
        this.f21551H = 0.0f;
    }
}
