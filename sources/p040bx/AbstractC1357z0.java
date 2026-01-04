package p040bx;

import p692uw.C13267j;

/* renamed from: bx.z0 */
/* loaded from: classes9.dex */
public abstract class AbstractC1357z0 extends AbstractC1336p implements InterfaceC1315h0, InterfaceC1339q0 {

    /* renamed from: d */
    public C1295a1 f5852d;

    @Override // p040bx.InterfaceC1315h0
    /* renamed from: i */
    public void mo7748i() {
        m7854r().m7688X(this);
    }

    /* renamed from: r */
    public final C1295a1 m7854r() {
        C1295a1 c1295a1 = this.f5852d;
        if (c1295a1 != null) {
            return c1295a1;
        }
        C13267j.m79690r("job");
        return null;
    }

    @Override // p040bx.InterfaceC1339q0
    /* renamed from: s */
    public boolean mo7726s() {
        return true;
    }

    @Override // p040bx.InterfaceC1339q0
    /* renamed from: t */
    public C1304d1 mo7727t() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.C11093j
    public String toString() {
        return C1354y.m7844a(this) + '@' + C1354y.m7845b(this) + "[job@" + C1354y.m7845b(m7854r()) + ']';
    }

    /* renamed from: u */
    public final void m7855u(C1295a1 c1295a1) {
        this.f5852d = c1295a1;
    }
}
