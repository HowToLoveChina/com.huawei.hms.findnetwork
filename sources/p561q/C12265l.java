package p561q;

import p479n.C11574d;
import p561q.C12257d;

/* renamed from: q.l */
/* loaded from: classes.dex */
public class C12265l extends C12266m {
    @Override // p561q.C12266m
    /* renamed from: H1 */
    public void mo73726H1(int i10, int i11, int i12, int i13) {
        int iM73777E1 = m73777E1() + m73778F1();
        int iM73779G1 = m73779G1() + m73776D1();
        if (this.f56889W0 > 0) {
            iM73777E1 += this.f56888V0[0].m73594Y();
            iM73779G1 += this.f56888V0[0].m73662z();
        }
        int iMax = Math.max(m73566K(), iM73777E1);
        int iMax2 = Math.max(m73564J(), iM73779G1);
        if (i10 != 1073741824) {
            i11 = i10 == Integer.MIN_VALUE ? Math.min(iMax, i11) : i10 == 0 ? iMax : 0;
        }
        if (i12 != 1073741824) {
            i13 = i12 == Integer.MIN_VALUE ? Math.min(iMax2, i13) : i12 == 0 ? iMax2 : 0;
        }
        m73784M1(i11, i13);
        m73638p1(i11);
        m73579Q0(i13);
        m73783L1(this.f56889W0 > 0);
    }

    @Override // p561q.C12258e
    /* renamed from: g */
    public void mo73512g(C11574d c11574d, boolean z10) {
        super.mo73512g(c11574d, z10);
        if (this.f56889W0 > 0) {
            C12258e c12258e = this.f56888V0[0];
            c12258e.m73657w0();
            C12257d.a aVar = C12257d.a.LEFT;
            c12258e.m73620j(aVar, this, aVar);
            C12257d.a aVar2 = C12257d.a.RIGHT;
            c12258e.m73620j(aVar2, this, aVar2);
            C12257d.a aVar3 = C12257d.a.TOP;
            c12258e.m73620j(aVar3, this, aVar3);
            C12257d.a aVar4 = C12257d.a.BOTTOM;
            c12258e.m73620j(aVar4, this, aVar4);
        }
    }
}
