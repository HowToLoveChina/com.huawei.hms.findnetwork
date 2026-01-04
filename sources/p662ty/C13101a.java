package p662ty;

import dz.AbstractC9363b;
import dz.C9362a;
import p271ez.C9575a;
import sy.AbstractC12881e;
import sy.AbstractC12885i;
import sy.C12879c;
import sy.C12882f;
import sy.C12891o;
import sy.C12893q;

/* renamed from: ty.a */
/* loaded from: classes9.dex */
public class C13101a extends AbstractC12881e implements InterfaceC13105e {

    /* renamed from: a */
    public byte[] f59503a;

    /* renamed from: b */
    public C12882f f59504b = null;

    public C13101a(AbstractC9363b abstractC9363b, byte[] bArr) {
        this.f59503a = C9575a.m59759b(bArr);
        m78862c();
    }

    @Override // sy.AbstractC12881e, sy.InterfaceC12878b
    /* renamed from: a */
    public AbstractC12885i mo77274a() {
        C12879c c12879c = new C12879c(3);
        if (this.f59504b.m77303g(InterfaceC13105e.f59548k2)) {
            throw null;
        }
        if (this.f59504b.m77303g(InterfaceC13105e.f59550l2)) {
            throw null;
        }
        if (this.f59503a != null) {
            c12879c.m77276a(new C12891o(this.f59503a));
        }
        return new C12893q(c12879c);
    }

    /* renamed from: c */
    public final void m78862c() {
        C12882f c12882f;
        if (C9362a.m58726b(null)) {
            c12882f = InterfaceC13105e.f59548k2;
        } else {
            if (!C9362a.m58725a(null)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            c12882f = InterfaceC13105e.f59550l2;
        }
        this.f59504b = c12882f;
    }
}
