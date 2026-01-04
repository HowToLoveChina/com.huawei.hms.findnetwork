package p040bx;

import mw.InterfaceC11537d;
import mw.InterfaceC11539f;
import p692uw.C13267j;

/* renamed from: bx.a */
/* loaded from: classes9.dex */
public abstract class AbstractC1293a<T> extends C1295a1 implements InterfaceC1347u0, InterfaceC11537d<T> {

    /* renamed from: b */
    public final InterfaceC11539f f5772b;

    @Override // p040bx.C1295a1
    /* renamed from: K */
    public final void mo7654K(Throwable th2) {
        C1350w.m7841a(this.f5772b, th2);
    }

    @Override // p040bx.C1295a1
    /* renamed from: P */
    public String mo7655P() {
        String strM7828a = C1342s.m7828a(this.f5772b);
        if (strM7828a == null) {
            return super.mo7655P();
        }
        return '\"' + strM7828a + "\":" + super.mo7655P();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p040bx.C1295a1
    /* renamed from: U */
    public final void mo7656U(Object obj) {
        if (!(obj instanceof C1332n)) {
            m7660k0(obj);
        } else {
            C1332n c1332n = (C1332n) obj;
            m7659j0(c1332n.f5830a, c1332n.m7819a());
        }
    }

    @Override // mw.InterfaceC11537d
    /* renamed from: d */
    public final void mo7657d(Object obj) {
        Object objM7680N = m7680N(C1340r.m7827d(obj, null, 1, null));
        if (objM7680N == C1298b1.f5785b) {
            return;
        }
        mo7658i0(objM7680N);
    }

    @Override // mw.InterfaceC11537d
    public final InterfaceC11539f getContext() {
        return this.f5772b;
    }

    /* renamed from: i0 */
    public void mo7658i0(Object obj) {
        mo7701l(obj);
    }

    /* renamed from: j0 */
    public void m7659j0(Throwable th2, boolean z10) {
    }

    /* renamed from: k0 */
    public void m7660k0(T t10) {
    }

    @Override // p040bx.C1295a1
    /* renamed from: q */
    public String mo7661q() {
        return C13267j.m79683k(C1354y.m7844a(this), " was cancelled");
    }

    @Override // p040bx.C1295a1, p040bx.InterfaceC1347u0
    /* renamed from: s */
    public boolean mo7662s() {
        return super.mo7662s();
    }
}
