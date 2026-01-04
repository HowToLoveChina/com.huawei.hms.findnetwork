package p439l0;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import p439l0.AbstractC11216b;

/* renamed from: l0.e */
/* loaded from: classes.dex */
public final class C11219e extends AbstractC11216b<C11219e> {

    /* renamed from: A */
    public C11220f f52695A;

    /* renamed from: B */
    public float f52696B;

    /* renamed from: C */
    public boolean f52697C;

    public C11219e(C11218d c11218d) {
        super(c11218d);
        this.f52695A = null;
        this.f52696B = Float.MAX_VALUE;
        this.f52697C = false;
    }

    @Override // p439l0.AbstractC11216b
    /* renamed from: l */
    public void mo67368l() {
        m67404r();
        this.f52695A.m67413g(m67364g());
        super.mo67368l();
    }

    @Override // p439l0.AbstractC11216b
    /* renamed from: n */
    public boolean mo67370n(long j10) {
        if (this.f52697C) {
            float f10 = this.f52696B;
            if (f10 != Float.MAX_VALUE) {
                this.f52695A.m67411e(f10);
                this.f52696B = Float.MAX_VALUE;
            }
            this.f52678b = this.f52695A.m67407a();
            this.f52677a = 0.0f;
            this.f52697C = false;
            return true;
        }
        if (this.f52696B != Float.MAX_VALUE) {
            this.f52695A.m67407a();
            long j11 = j10 / 2;
            AbstractC11216b.p pVarM67414h = this.f52695A.m67414h(this.f52678b, this.f52677a, j11);
            this.f52695A.m67411e(this.f52696B);
            this.f52696B = Float.MAX_VALUE;
            AbstractC11216b.p pVarM67414h2 = this.f52695A.m67414h(pVarM67414h.f52691a, pVarM67414h.f52692b, j11);
            this.f52678b = pVarM67414h2.f52691a;
            this.f52677a = pVarM67414h2.f52692b;
        } else {
            AbstractC11216b.p pVarM67414h3 = this.f52695A.m67414h(this.f52678b, this.f52677a, j10);
            this.f52678b = pVarM67414h3.f52691a;
            this.f52677a = pVarM67414h3.f52692b;
        }
        float fMax = Math.max(this.f52678b, this.f52684h);
        this.f52678b = fMax;
        float fMin = Math.min(fMax, this.f52683g);
        this.f52678b = fMin;
        if (!m67403q(fMin, this.f52677a)) {
            return false;
        }
        this.f52678b = this.f52695A.m67407a();
        this.f52677a = 0.0f;
        return true;
    }

    /* renamed from: o */
    public void m67401o(float f10) {
        if (m67365h()) {
            this.f52696B = f10;
            return;
        }
        if (this.f52695A == null) {
            this.f52695A = new C11220f(f10);
        }
        this.f52695A.m67411e(f10);
        mo67368l();
    }

    /* renamed from: p */
    public boolean m67402p() {
        return this.f52695A.f52699b > 0.0d;
    }

    /* renamed from: q */
    public boolean m67403q(float f10, float f11) {
        return this.f52695A.m67409c(f10, f11);
    }

    /* renamed from: r */
    public final void m67404r() {
        C11220f c11220f = this.f52695A;
        if (c11220f == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double dM67407a = c11220f.m67407a();
        if (dM67407a > this.f52683g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (dM67407a < this.f52684h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    /* renamed from: s */
    public C11219e m67405s(C11220f c11220f) {
        this.f52695A = c11220f;
        return this;
    }

    /* renamed from: t */
    public void m67406t() {
        if (!m67402p()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f52682f) {
            this.f52697C = true;
        }
    }

    public <K> C11219e(K k10, AbstractC11217c<K> abstractC11217c) {
        super(k10, abstractC11217c);
        this.f52695A = null;
        this.f52696B = Float.MAX_VALUE;
        this.f52697C = false;
    }
}
