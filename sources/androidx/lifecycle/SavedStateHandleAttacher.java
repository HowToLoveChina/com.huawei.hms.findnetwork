package androidx.lifecycle;

import androidx.lifecycle.AbstractC0791h;
import p692uw.C13267j;

/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements InterfaceC0794j {

    /* renamed from: a */
    public final C0808x f4133a;

    public SavedStateHandleAttacher(C0808x c0808x) {
        C13267j.m79677e(c0808x, "provider");
        this.f4133a = c0808x;
    }

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
        C13267j.m79677e(interfaceC0796l, "source");
        C13267j.m79677e(bVar, "event");
        if (bVar == AbstractC0791h.b.ON_CREATE) {
            interfaceC0796l.mo1915g().mo4950c(this);
            this.f4133a.m5004d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + bVar).toString());
        }
    }
}
