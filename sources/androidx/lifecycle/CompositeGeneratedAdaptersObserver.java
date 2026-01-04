package androidx.lifecycle;

import androidx.lifecycle.AbstractC0791h;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements InterfaceC0794j {

    /* renamed from: a */
    public final InterfaceC0787f[] f4104a;

    public CompositeGeneratedAdaptersObserver(InterfaceC0787f[] interfaceC0787fArr) {
        this.f4104a = interfaceC0787fArr;
    }

    @Override // androidx.lifecycle.InterfaceC0794j
    /* renamed from: d */
    public void mo1925d(InterfaceC0796l interfaceC0796l, AbstractC0791h.b bVar) {
        C0800p c0800p = new C0800p();
        for (InterfaceC0787f interfaceC0787f : this.f4104a) {
            interfaceC0787f.m4946a(interfaceC0796l, bVar, false, c0800p);
        }
        for (InterfaceC0787f interfaceC0787f2 : this.f4104a) {
            interfaceC0787f2.m4946a(interfaceC0796l, bVar, true, c0800p);
        }
    }
}
