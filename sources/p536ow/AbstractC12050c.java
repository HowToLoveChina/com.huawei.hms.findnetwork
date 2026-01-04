package p536ow;

import mw.InterfaceC11537d;
import mw.InterfaceC11538e;
import mw.InterfaceC11539f;
import p692uw.C13267j;

/* renamed from: ow.c */
/* loaded from: classes9.dex */
public abstract class AbstractC12050c extends AbstractC12048a {

    /* renamed from: b */
    public final InterfaceC11539f f55803b;

    /* renamed from: c */
    public transient InterfaceC11537d<Object> f55804c;

    @Override // p536ow.AbstractC12048a
    /* renamed from: f */
    public void mo72179f() {
        InterfaceC11537d<?> interfaceC11537d = this.f55804c;
        if (interfaceC11537d != null && interfaceC11537d != this) {
            InterfaceC11539f.b bVar = getContext().get(InterfaceC11538e.f53494h2);
            C13267j.m79674b(bVar);
            ((InterfaceC11538e) bVar).mo7831g(interfaceC11537d);
        }
        this.f55804c = C12049b.f55802a;
    }

    /* renamed from: g */
    public final InterfaceC11537d<Object> m72180g() {
        InterfaceC11537d<Object> interfaceC11537dMo7832h = this.f55804c;
        if (interfaceC11537dMo7832h == null) {
            InterfaceC11538e interfaceC11538e = (InterfaceC11538e) getContext().get(InterfaceC11538e.f53494h2);
            if (interfaceC11538e == null || (interfaceC11537dMo7832h = interfaceC11538e.mo7832h(this)) == null) {
                interfaceC11537dMo7832h = this;
            }
            this.f55804c = interfaceC11537dMo7832h;
        }
        return interfaceC11537dMo7832h;
    }

    @Override // mw.InterfaceC11537d
    public InterfaceC11539f getContext() {
        InterfaceC11539f interfaceC11539f = this.f55803b;
        C13267j.m79674b(interfaceC11539f);
        return interfaceC11539f;
    }
}
