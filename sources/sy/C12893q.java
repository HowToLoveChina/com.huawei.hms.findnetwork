package sy;

import java.io.IOException;

/* renamed from: sy.q */
/* loaded from: classes9.dex */
public class C12893q extends AbstractC12887k {

    /* renamed from: c */
    public int f58678c;

    public C12893q(C12879c c12879c) {
        super(c12879c);
        this.f58678c = -1;
    }

    @Override // sy.AbstractC12885i
    /* renamed from: d */
    public void mo77279d(C12883g c12883g, boolean z10) throws IOException {
        c12883g.m77300k(z10, 48);
        C12892p c12892pMo77294c = c12883g.mo77294c();
        int length = this.f58673a.length;
        int i10 = 0;
        if (this.f58678c >= 0 || length > 16) {
            c12883g.m77297h(m77312i());
            while (i10 < length) {
                this.f58673a[i10].mo77274a().mo77272h().mo77279d(c12892pMo77294c, true);
                i10++;
            }
            return;
        }
        AbstractC12885i[] abstractC12885iArr = new AbstractC12885i[length];
        int iMo77280f = 0;
        for (int i11 = 0; i11 < length; i11++) {
            AbstractC12885i abstractC12885iMo77272h = this.f58673a[i11].mo77274a().mo77272h();
            abstractC12885iArr[i11] = abstractC12885iMo77272h;
            iMo77280f += abstractC12885iMo77272h.mo77280f(true);
        }
        this.f58678c = iMo77280f;
        c12883g.m77297h(iMo77280f);
        while (i10 < length) {
            abstractC12885iArr[i10].mo77279d(c12892pMo77294c, true);
            i10++;
        }
    }

    @Override // sy.AbstractC12885i
    /* renamed from: f */
    public int mo77280f(boolean z10) throws IOException {
        return C12883g.m77292e(z10, m77312i());
    }

    @Override // sy.AbstractC12887k, sy.AbstractC12885i
    /* renamed from: h */
    public AbstractC12885i mo77272h() {
        return this;
    }

    /* renamed from: i */
    public final int m77312i() throws IOException {
        if (this.f58678c < 0) {
            int length = this.f58673a.length;
            int iMo77280f = 0;
            for (int i10 = 0; i10 < length; i10++) {
                iMo77280f += this.f58673a[i10].mo77274a().mo77272h().mo77280f(true);
            }
            this.f58678c = iMo77280f;
        }
        return this.f58678c;
    }

    public C12893q(InterfaceC12878b[] interfaceC12878bArr, boolean z10) {
        super(interfaceC12878bArr, z10);
        this.f58678c = -1;
    }
}
