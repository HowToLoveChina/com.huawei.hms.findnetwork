package p415k2;

import p355i2.AbstractC10417c;
import p829z1.InterfaceC14079r;

/* renamed from: k2.d */
/* loaded from: classes.dex */
public class C10975d extends AbstractC10417c<C10973b> implements InterfaceC14079r {
    public C10975d(C10973b c10973b) {
        super(c10973b);
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: a */
    public void mo60254a() {
        ((C10973b) this.f50252a).stop();
        ((C10973b) this.f50252a).m66313k();
    }

    @Override // p355i2.AbstractC10417c, p829z1.InterfaceC14079r
    /* renamed from: b */
    public void mo61233b() {
        ((C10973b) this.f50252a).m66307e().prepareToDraw();
    }

    @Override // p829z1.InterfaceC14083v
    /* renamed from: c */
    public Class<C10973b> mo60255c() {
        return C10973b.class;
    }

    @Override // p829z1.InterfaceC14083v
    public int getSize() {
        return ((C10973b) this.f50252a).m66311i();
    }
}
