package p561q;

import java.util.HashSet;
import p561q.C12258e;
import p596r.C12435b;

/* renamed from: q.m */
/* loaded from: classes.dex */
public class C12266m extends C12263j {

    /* renamed from: X0 */
    public int f56891X0 = 0;

    /* renamed from: Y0 */
    public int f56892Y0 = 0;

    /* renamed from: Z0 */
    public int f56893Z0 = 0;

    /* renamed from: a1 */
    public int f56894a1 = 0;

    /* renamed from: b1 */
    public int f56895b1 = 0;

    /* renamed from: c1 */
    public int f56896c1 = 0;

    /* renamed from: d1 */
    public int f56897d1 = 0;

    /* renamed from: e1 */
    public int f56898e1 = 0;

    /* renamed from: f1 */
    public boolean f56899f1 = false;

    /* renamed from: g1 */
    public int f56900g1 = 0;

    /* renamed from: h1 */
    public int f56901h1 = 0;

    /* renamed from: i1 */
    public C12435b.a f56902i1 = new C12435b.a();

    /* renamed from: j1 */
    public C12435b.b f56903j1 = null;

    /* renamed from: A1 */
    public boolean m73773A1(HashSet<C12258e> hashSet) {
        for (int i10 = 0; i10 < this.f56889W0; i10++) {
            if (hashSet.contains(this.f56888V0[i10])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: B1 */
    public int m73774B1() {
        return this.f56901h1;
    }

    /* renamed from: C1 */
    public int m73775C1() {
        return this.f56900g1;
    }

    /* renamed from: D1 */
    public int m73776D1() {
        return this.f56892Y0;
    }

    /* renamed from: E1 */
    public int m73777E1() {
        return this.f56897d1;
    }

    /* renamed from: F1 */
    public int m73778F1() {
        return this.f56898e1;
    }

    /* renamed from: G1 */
    public int m73779G1() {
        return this.f56891X0;
    }

    /* renamed from: H1 */
    public void mo73726H1(int i10, int i11, int i12, int i13) {
    }

    /* renamed from: I1 */
    public void m73780I1(C12258e c12258e, C12258e.b bVar, int i10, C12258e.b bVar2, int i11) {
        while (this.f56903j1 == null && m73570M() != null) {
            this.f56903j1 = ((C12259f) m73570M()).m73680O1();
        }
        C12435b.a aVar = this.f56902i1;
        aVar.f57284a = bVar;
        aVar.f57285b = bVar2;
        aVar.f57286c = i10;
        aVar.f57287d = i11;
        this.f56903j1.mo3572b(c12258e, aVar);
        c12258e.m73638p1(this.f56902i1.f57288e);
        c12258e.m73579Q0(this.f56902i1.f57289f);
        c12258e.m73577P0(this.f56902i1.f57291h);
        c12258e.m73557F0(this.f56902i1.f57290g);
    }

    /* renamed from: J1 */
    public boolean m73781J1() {
        C12258e c12258e = this.f56753c0;
        C12435b.b bVarM73680O1 = c12258e != null ? ((C12259f) c12258e).m73680O1() : null;
        if (bVarM73680O1 == null) {
            return false;
        }
        for (int i10 = 0; i10 < this.f56889W0; i10++) {
            C12258e c12258e2 = this.f56888V0[i10];
            if (c12258e2 != null && !(c12258e2 instanceof C12261h)) {
                C12258e.b bVarM73656w = c12258e2.m73656w(0);
                C12258e.b bVarM73656w2 = c12258e2.m73656w(1);
                C12258e.b bVar = C12258e.b.MATCH_CONSTRAINT;
                if (bVarM73656w != bVar || c12258e2.f56792w == 1 || bVarM73656w2 != bVar || c12258e2.f56794x == 1) {
                    if (bVarM73656w == bVar) {
                        bVarM73656w = C12258e.b.WRAP_CONTENT;
                    }
                    if (bVarM73656w2 == bVar) {
                        bVarM73656w2 = C12258e.b.WRAP_CONTENT;
                    }
                    C12435b.a aVar = this.f56902i1;
                    aVar.f57284a = bVarM73656w;
                    aVar.f57285b = bVarM73656w2;
                    aVar.f57286c = c12258e2.m73594Y();
                    this.f56902i1.f57287d = c12258e2.m73662z();
                    bVarM73680O1.mo3572b(c12258e2, this.f56902i1);
                    c12258e2.m73638p1(this.f56902i1.f57288e);
                    c12258e2.m73579Q0(this.f56902i1.f57289f);
                    c12258e2.m73557F0(this.f56902i1.f57290g);
                }
            }
        }
        return true;
    }

    /* renamed from: K1 */
    public boolean m73782K1() {
        return this.f56899f1;
    }

    /* renamed from: L1 */
    public void m73783L1(boolean z10) {
        this.f56899f1 = z10;
    }

    /* renamed from: M1 */
    public void m73784M1(int i10, int i11) {
        this.f56900g1 = i10;
        this.f56901h1 = i11;
    }

    /* renamed from: N1 */
    public void m73785N1(int i10) {
        this.f56893Z0 = i10;
        this.f56891X0 = i10;
        this.f56894a1 = i10;
        this.f56892Y0 = i10;
        this.f56895b1 = i10;
        this.f56896c1 = i10;
    }

    /* renamed from: O1 */
    public void m73786O1(int i10) {
        this.f56892Y0 = i10;
    }

    /* renamed from: P1 */
    public void m73787P1(int i10) {
        this.f56896c1 = i10;
    }

    /* renamed from: Q1 */
    public void m73788Q1(int i10) {
        this.f56893Z0 = i10;
        this.f56897d1 = i10;
    }

    /* renamed from: R1 */
    public void m73789R1(int i10) {
        this.f56894a1 = i10;
        this.f56898e1 = i10;
    }

    /* renamed from: S1 */
    public void m73790S1(int i10) {
        this.f56895b1 = i10;
        this.f56897d1 = i10;
        this.f56898e1 = i10;
    }

    /* renamed from: T1 */
    public void m73791T1(int i10) {
        this.f56891X0 = i10;
    }

    @Override // p561q.C12263j, p561q.InterfaceC12262i
    /* renamed from: c */
    public void mo73768c(C12259f c12259f) {
        m73793z1();
    }

    /* renamed from: y1 */
    public void m73792y1(boolean z10) {
        int i10 = this.f56895b1;
        if (i10 > 0 || this.f56896c1 > 0) {
            if (z10) {
                this.f56897d1 = this.f56896c1;
                this.f56898e1 = i10;
            } else {
                this.f56897d1 = i10;
                this.f56898e1 = this.f56896c1;
            }
        }
    }

    /* renamed from: z1 */
    public void m73793z1() {
        for (int i10 = 0; i10 < this.f56889W0; i10++) {
            C12258e c12258e = this.f56888V0[i10];
            if (c12258e != null) {
                c12258e.m73597Z0(true);
            }
        }
    }
}
