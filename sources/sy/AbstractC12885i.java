package sy;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: sy.i */
/* loaded from: classes9.dex */
public abstract class AbstractC12885i extends AbstractC12881e {
    @Override // sy.AbstractC12881e, sy.InterfaceC12878b
    /* renamed from: a */
    public final AbstractC12885i mo77274a() {
        return this;
    }

    /* renamed from: c */
    public abstract boolean mo77271c(AbstractC12885i abstractC12885i);

    /* renamed from: d */
    public abstract void mo77279d(C12883g c12883g, boolean z10) throws IOException;

    /* renamed from: e */
    public void m77302e(OutputStream outputStream) throws IOException {
        C12883g c12883gM77290a = C12883g.m77290a(outputStream);
        c12883gM77290a.mo77301l(this, true);
        c12883gM77290a.m77293b();
    }

    @Override // sy.AbstractC12881e
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC12878b) && mo77271c(((InterfaceC12878b) obj).mo77274a());
    }

    /* renamed from: f */
    public abstract int mo77280f(boolean z10) throws IOException;

    /* renamed from: g */
    public final boolean m77303g(AbstractC12885i abstractC12885i) {
        return this == abstractC12885i || mo77271c(abstractC12885i);
    }

    /* renamed from: h */
    public AbstractC12885i mo77272h() {
        return this;
    }

    @Override // sy.AbstractC12881e
    public abstract int hashCode();
}
