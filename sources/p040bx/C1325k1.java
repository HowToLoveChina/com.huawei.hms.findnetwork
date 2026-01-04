package p040bx;

import kotlinx.coroutines.internal.C11103t;
import kotlinx.coroutines.internal.C11108y;
import mw.InterfaceC11537d;
import mw.InterfaceC11539f;
import p408jw.C10944j;
import p408jw.C10948n;
import p408jw.C10951q;

/* renamed from: bx.k1 */
/* loaded from: classes9.dex */
public final class C1325k1<T> extends C11103t<T> {

    /* renamed from: d */
    public ThreadLocal<C10944j<InterfaceC11539f, Object>> f5820d;

    @Override // kotlinx.coroutines.internal.C11103t, p040bx.AbstractC1293a
    /* renamed from: i0 */
    public void mo7658i0(Object obj) {
        C10944j<InterfaceC11539f, Object> c10944j = this.f5820d.get();
        if (c10944j != null) {
            C11108y.m66817a(c10944j.m66066b(), c10944j.m66067c());
            this.f5820d.set(null);
        }
        Object objM7824a = C1340r.m7824a(obj, this.f52331c);
        InterfaceC11537d<T> interfaceC11537d = this.f52331c;
        InterfaceC11539f context = interfaceC11537d.getContext();
        Object objM66819c = C11108y.m66819c(context, null);
        C1325k1<?> c1325k1M7830c = objM66819c != C11108y.f52334a ? C1342s.m7830c(interfaceC11537d, context, objM66819c) : null;
        try {
            this.f52331c.mo7657d(objM7824a);
            C10951q c10951q = C10951q.f51861a;
        } finally {
            if (c1325k1M7830c == null || c1325k1M7830c.m7810l0()) {
                C11108y.m66817a(context, objM66819c);
            }
        }
    }

    /* renamed from: l0 */
    public final boolean m7810l0() {
        if (this.f5820d.get() == null) {
            return false;
        }
        this.f5820d.set(null);
        return true;
    }

    /* renamed from: m0 */
    public final void m7811m0(InterfaceC11539f interfaceC11539f, Object obj) {
        this.f5820d.set(C10948n.m66075a(interfaceC11539f, obj));
    }
}
