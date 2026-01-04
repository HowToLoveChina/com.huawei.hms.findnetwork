package sy;

import java.io.IOException;
import java.math.BigInteger;
import p271ez.C9575a;

/* renamed from: sy.d */
/* loaded from: classes9.dex */
public class C12880d extends AbstractC12885i {

    /* renamed from: c */
    public static final AbstractC12890n f58659c = new a(C12880d.class, 2);

    /* renamed from: a */
    public final byte[] f58660a;

    /* renamed from: b */
    public final int f58661b = 0;

    /* renamed from: sy.d$a */
    public static class a extends AbstractC12890n {
        public a(Class cls, int i10) {
            super(cls, i10);
        }
    }

    public C12880d(BigInteger bigInteger) {
        this.f58660a = bigInteger.toByteArray();
    }

    @Override // sy.AbstractC12885i
    /* renamed from: c */
    public boolean mo77271c(AbstractC12885i abstractC12885i) {
        if (abstractC12885i instanceof C12880d) {
            return C9575a.m59758a(this.f58660a, ((C12880d) abstractC12885i).f58660a);
        }
        return false;
    }

    @Override // sy.AbstractC12885i
    /* renamed from: d */
    public void mo77279d(C12883g c12883g, boolean z10) throws IOException {
        c12883g.m77298i(z10, 2, this.f58660a);
    }

    @Override // sy.AbstractC12885i
    /* renamed from: f */
    public int mo77280f(boolean z10) {
        return C12883g.m77292e(z10, this.f58660a.length);
    }

    @Override // sy.AbstractC12885i, sy.AbstractC12881e
    public int hashCode() {
        return C9575a.m59763f(this.f58660a);
    }

    /* renamed from: i */
    public BigInteger m77281i() {
        return new BigInteger(this.f58660a);
    }

    public String toString() {
        return m77281i().toString();
    }
}
