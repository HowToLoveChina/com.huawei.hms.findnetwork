package p040bx;

import mw.InterfaceC11539f;

/* renamed from: bx.j1 */
/* loaded from: classes9.dex */
public final class C1322j1 extends AbstractC1344t {

    /* renamed from: b */
    public static final C1322j1 f5812b = new C1322j1();

    @Override // p040bx.AbstractC1344t
    /* renamed from: c */
    public void mo7787c(InterfaceC11539f interfaceC11539f, Runnable runnable) {
        C1331m1 c1331m1 = (C1331m1) interfaceC11539f.get(C1331m1.f5827b);
        if (c1331m1 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        c1331m1.f5828a = true;
    }

    @Override // p040bx.AbstractC1344t
    /* renamed from: d */
    public boolean mo7788d(InterfaceC11539f interfaceC11539f) {
        return false;
    }

    @Override // p040bx.AbstractC1344t
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
