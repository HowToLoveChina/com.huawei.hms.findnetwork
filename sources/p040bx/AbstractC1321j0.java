package p040bx;

import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.internal.C11082a;

/* renamed from: bx.j0 */
/* loaded from: classes9.dex */
public abstract class AbstractC1321j0 extends AbstractC1344t {

    /* renamed from: b */
    public long f5809b;

    /* renamed from: c */
    public boolean f5810c;

    /* renamed from: d */
    public C11082a<AbstractC1306e0<?>> f5811d;

    /* renamed from: B */
    public static /* synthetic */ void m7778B(AbstractC1321j0 abstractC1321j0, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        abstractC1321j0.m7779A(z10);
    }

    /* renamed from: A */
    public final void m7779A(boolean z10) {
        this.f5809b += m7784m(z10);
        if (z10) {
            return;
        }
        this.f5810c = true;
    }

    /* renamed from: C */
    public final boolean m7780C() {
        return this.f5809b >= m7784m(true);
    }

    /* renamed from: D */
    public final boolean m7781D() {
        C11082a<AbstractC1306e0<?>> c11082a = this.f5811d;
        if (c11082a == null) {
            return true;
        }
        return c11082a.m66739c();
    }

    /* renamed from: E */
    public final boolean m7782E() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC1306e0<?> abstractC1306e0M66740d;
        C11082a<AbstractC1306e0<?>> c11082a = this.f5811d;
        if (c11082a == null || (abstractC1306e0M66740d = c11082a.m66740d()) == null) {
            return false;
        }
        abstractC1306e0M66740d.run();
        return true;
    }

    /* renamed from: k */
    public final void m7783k(boolean z10) {
        long jM7784m = this.f5809b - m7784m(z10);
        this.f5809b = jM7784m;
        if (jM7784m <= 0 && this.f5810c) {
            shutdown();
        }
    }

    /* renamed from: m */
    public final long m7784m(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    /* renamed from: n */
    public final void m7785n(AbstractC1306e0<?> abstractC1306e0) {
        C11082a<AbstractC1306e0<?>> c11082a = this.f5811d;
        if (c11082a == null) {
            c11082a = new C11082a<>();
            this.f5811d = c11082a;
        }
        c11082a.m66737a(abstractC1306e0);
    }

    public void shutdown() {
    }

    /* renamed from: z */
    public long mo7786z() {
        C11082a<AbstractC1306e0<?>> c11082a = this.f5811d;
        return (c11082a == null || c11082a.m66739c()) ? Long.MAX_VALUE : 0L;
    }
}
