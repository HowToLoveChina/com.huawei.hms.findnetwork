package p040bx;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.C11088e;
import kotlinx.coroutines.internal.C11103t;
import p501nw.C11759c;

/* renamed from: bx.d0 */
/* loaded from: classes9.dex */
public final class C1303d0<T> extends C11103t<T> {

    /* renamed from: d */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5793d = AtomicIntegerFieldUpdater.newUpdater(C1303d0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    /* renamed from: l0 */
    private final boolean m7740l0() {
        do {
            int i10 = this._decision;
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f5793d.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // kotlinx.coroutines.internal.C11103t, p040bx.AbstractC1293a
    /* renamed from: i0 */
    public void mo7658i0(Object obj) {
        if (m7740l0()) {
            return;
        }
        C11088e.m66754c(C11759c.m70083a(this.f52331c), C1340r.m7824a(obj, this.f52331c), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.C11103t, p040bx.C1295a1
    /* renamed from: l */
    public void mo7701l(Object obj) {
        mo7658i0(obj);
    }
}
