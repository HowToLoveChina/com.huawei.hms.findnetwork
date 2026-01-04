package p040bx;

import java.util.concurrent.locks.LockSupport;
import p040bx.AbstractC1324k0;

/* renamed from: bx.l0 */
/* loaded from: classes9.dex */
public abstract class AbstractC1327l0 extends AbstractC1321j0 {
    /* renamed from: F */
    public abstract Thread mo7739F();

    /* renamed from: G */
    public void mo7812G(long j10, AbstractC1324k0.a aVar) {
        RunnableC1356z.f5850g.m7799i0(j10, aVar);
    }

    /* renamed from: H */
    public final void m7813H() {
        Thread threadMo7739F = mo7739F();
        if (Thread.currentThread() != threadMo7739F) {
            C1299c.m7736a();
            LockSupport.unpark(threadMo7739F);
        }
    }
}
