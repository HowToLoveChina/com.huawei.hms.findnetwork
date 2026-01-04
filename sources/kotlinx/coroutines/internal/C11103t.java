package kotlinx.coroutines.internal;

import mw.InterfaceC11537d;
import p040bx.AbstractC1293a;
import p040bx.C1340r;
import p501nw.C11759c;
import p536ow.InterfaceC12051d;

/* renamed from: kotlinx.coroutines.internal.t */
/* loaded from: classes9.dex */
public class C11103t<T> extends AbstractC1293a<T> implements InterfaceC12051d {

    /* renamed from: c */
    public final InterfaceC11537d<T> f52331c;

    @Override // p040bx.C1295a1
    /* renamed from: L */
    public final boolean mo7678L() {
        return true;
    }

    @Override // p536ow.InterfaceC12051d
    /* renamed from: c */
    public final InterfaceC12051d mo7759c() {
        InterfaceC11537d<T> interfaceC11537d = this.f52331c;
        if (interfaceC11537d instanceof InterfaceC12051d) {
            return (InterfaceC12051d) interfaceC11537d;
        }
        return null;
    }

    @Override // p040bx.AbstractC1293a
    /* renamed from: i0 */
    public void mo7658i0(Object obj) {
        InterfaceC11537d<T> interfaceC11537d = this.f52331c;
        interfaceC11537d.mo7657d(C1340r.m7824a(obj, interfaceC11537d));
    }

    @Override // p040bx.C1295a1
    /* renamed from: l */
    public void mo7701l(Object obj) {
        C11088e.m66754c(C11759c.m70083a(this.f52331c), C1340r.m7824a(obj, this.f52331c), null, 2, null);
    }
}
