package p542p2;

import p630s2.C12677l;

@Deprecated
/* renamed from: p2.g */
/* loaded from: classes.dex */
public abstract class AbstractC12080g<Z> extends AbstractC12074a<Z> {

    /* renamed from: b */
    public final int f55897b;

    /* renamed from: c */
    public final int f55898c;

    public AbstractC12080g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: b */
    public final void mo72230b(InterfaceC12081h interfaceC12081h) {
        if (C12677l.m76296s(this.f55897b, this.f55898c)) {
            interfaceC12081h.mo70289d(this.f55897b, this.f55898c);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f55897b + " and height: " + this.f55898c + ", either provide dimensions in the constructor or call override()");
    }

    @Override // p542p2.InterfaceC12082i
    /* renamed from: d */
    public void mo72231d(InterfaceC12081h interfaceC12081h) {
    }

    public AbstractC12080g(int i10, int i11) {
        this.f55897b = i10;
        this.f55898c = i11;
    }
}
