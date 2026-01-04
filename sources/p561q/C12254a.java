package p561q;

import java.util.HashMap;
import p479n.C11574d;
import p479n.C11579i;
import p561q.C12257d;
import p561q.C12258e;

/* renamed from: q.a */
/* loaded from: classes.dex */
public class C12254a extends C12263j {

    /* renamed from: X0 */
    public int f56656X0 = 0;

    /* renamed from: Y0 */
    public boolean f56657Y0 = true;

    /* renamed from: Z0 */
    public int f56658Z0 = 0;

    /* renamed from: a1 */
    public boolean f56659a1 = false;

    /* renamed from: A1 */
    public int m73505A1() {
        return this.f56656X0;
    }

    /* renamed from: B1 */
    public int m73506B1() {
        return this.f56658Z0;
    }

    /* renamed from: C1 */
    public int m73507C1() {
        int i10 = this.f56656X0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    /* renamed from: D1 */
    public void m73508D1() {
        for (int i10 = 0; i10 < this.f56889W0; i10++) {
            C12258e c12258e = this.f56888V0[i10];
            if (this.f56657Y0 || c12258e.mo73513h()) {
                int i11 = this.f56656X0;
                if (i11 == 0 || i11 == 1) {
                    c12258e.m73593X0(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    c12258e.m73593X0(1, true);
                }
            }
        }
    }

    /* renamed from: E1 */
    public void m73509E1(boolean z10) {
        this.f56657Y0 = z10;
    }

    /* renamed from: F1 */
    public void m73510F1(int i10) {
        this.f56656X0 = i10;
    }

    /* renamed from: G1 */
    public void m73511G1(int i10) {
        this.f56658Z0 = i10;
    }

    @Override // p561q.C12258e
    /* renamed from: g */
    public void mo73512g(C11574d c11574d, boolean z10) {
        C12257d[] c12257dArr;
        boolean z11;
        int i10;
        int i11;
        int i12;
        C12257d[] c12257dArr2 = this.f56746Y;
        c12257dArr2[0] = this.f56734Q;
        c12257dArr2[2] = this.f56736R;
        c12257dArr2[1] = this.f56738S;
        c12257dArr2[3] = this.f56740T;
        int i13 = 0;
        while (true) {
            c12257dArr = this.f56746Y;
            if (i13 >= c12257dArr.length) {
                break;
            }
            C12257d c12257d = c12257dArr[i13];
            c12257d.f56690i = c11574d.m69108q(c12257d);
            i13++;
        }
        int i14 = this.f56656X0;
        if (i14 < 0 || i14 >= 4) {
            return;
        }
        C12257d c12257d2 = c12257dArr[i14];
        if (!this.f56659a1) {
            m73517y1();
        }
        if (this.f56659a1) {
            this.f56659a1 = false;
            int i15 = this.f56656X0;
            if (i15 == 0 || i15 == 1) {
                c11574d.m69097f(this.f56734Q.f56690i, this.f56763h0);
                c11574d.m69097f(this.f56738S.f56690i, this.f56763h0);
                return;
            } else {
                if (i15 == 2 || i15 == 3) {
                    c11574d.m69097f(this.f56736R.f56690i, this.f56765i0);
                    c11574d.m69097f(this.f56740T.f56690i, this.f56765i0);
                    return;
                }
                return;
            }
        }
        for (int i16 = 0; i16 < this.f56889W0; i16++) {
            C12258e c12258e = this.f56888V0[i16];
            if ((this.f56657Y0 || c12258e.mo73513h()) && ((((i11 = this.f56656X0) == 0 || i11 == 1) && c12258e.m73550C() == C12258e.b.MATCH_CONSTRAINT && c12258e.f56734Q.f56687f != null && c12258e.f56738S.f56687f != null) || (((i12 = this.f56656X0) == 2 || i12 == 3) && c12258e.m73588V() == C12258e.b.MATCH_CONSTRAINT && c12258e.f56736R.f56687f != null && c12258e.f56740T.f56687f != null))) {
                z11 = true;
                break;
            }
        }
        z11 = false;
        boolean z12 = this.f56734Q.m73535l() || this.f56738S.m73535l();
        boolean z13 = this.f56736R.m73535l() || this.f56740T.m73535l();
        int i17 = !(!z11 && (((i10 = this.f56656X0) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13))))) ? 4 : 5;
        for (int i18 = 0; i18 < this.f56889W0; i18++) {
            C12258e c12258e2 = this.f56888V0[i18];
            if (this.f56657Y0 || c12258e2.mo73513h()) {
                C11579i c11579iM69108q = c11574d.m69108q(c12258e2.f56746Y[this.f56656X0]);
                C12257d[] c12257dArr3 = c12258e2.f56746Y;
                int i19 = this.f56656X0;
                C12257d c12257d3 = c12257dArr3[i19];
                c12257d3.f56690i = c11579iM69108q;
                C12257d c12257d4 = c12257d3.f56687f;
                int i20 = (c12257d4 == null || c12257d4.f56685d != this) ? 0 : c12257d3.f56688g;
                if (i19 == 0 || i19 == 2) {
                    c11574d.m69100i(c12257d2.f56690i, c11579iM69108q, this.f56658Z0 - i20, z11);
                } else {
                    c11574d.m69098g(c12257d2.f56690i, c11579iM69108q, this.f56658Z0 + i20, z11);
                }
                c11574d.m69096e(c12257d2.f56690i, c11579iM69108q, this.f56658Z0 + i20, i17);
            }
        }
        int i21 = this.f56656X0;
        if (i21 == 0) {
            c11574d.m69096e(this.f56738S.f56690i, this.f56734Q.f56690i, 0, 8);
            c11574d.m69096e(this.f56734Q.f56690i, this.f56753c0.f56738S.f56690i, 0, 4);
            c11574d.m69096e(this.f56734Q.f56690i, this.f56753c0.f56734Q.f56690i, 0, 0);
            return;
        }
        if (i21 == 1) {
            c11574d.m69096e(this.f56734Q.f56690i, this.f56738S.f56690i, 0, 8);
            c11574d.m69096e(this.f56734Q.f56690i, this.f56753c0.f56734Q.f56690i, 0, 4);
            c11574d.m69096e(this.f56734Q.f56690i, this.f56753c0.f56738S.f56690i, 0, 0);
        } else if (i21 == 2) {
            c11574d.m69096e(this.f56740T.f56690i, this.f56736R.f56690i, 0, 8);
            c11574d.m69096e(this.f56736R.f56690i, this.f56753c0.f56740T.f56690i, 0, 4);
            c11574d.m69096e(this.f56736R.f56690i, this.f56753c0.f56736R.f56690i, 0, 0);
        } else if (i21 == 3) {
            c11574d.m69096e(this.f56736R.f56690i, this.f56740T.f56690i, 0, 8);
            c11574d.m69096e(this.f56736R.f56690i, this.f56753c0.f56736R.f56690i, 0, 4);
            c11574d.m69096e(this.f56736R.f56690i, this.f56753c0.f56740T.f56690i, 0, 0);
        }
    }

    @Override // p561q.C12258e
    /* renamed from: h */
    public boolean mo73513h() {
        return true;
    }

    @Override // p561q.C12263j, p561q.C12258e
    /* renamed from: n */
    public void mo73514n(C12258e c12258e, HashMap<C12258e, C12258e> map) {
        super.mo73514n(c12258e, map);
        C12254a c12254a = (C12254a) c12258e;
        this.f56656X0 = c12254a.f56656X0;
        this.f56657Y0 = c12254a.f56657Y0;
        this.f56658Z0 = c12254a.f56658Z0;
    }

    @Override // p561q.C12258e
    /* renamed from: p0 */
    public boolean mo73515p0() {
        return this.f56659a1;
    }

    @Override // p561q.C12258e
    /* renamed from: q0 */
    public boolean mo73516q0() {
        return this.f56659a1;
    }

    @Override // p561q.C12258e
    public String toString() {
        String str = "[Barrier] " + m73653v() + " {";
        for (int i10 = 0; i10 < this.f56889W0; i10++) {
            C12258e c12258e = this.f56888V0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + c12258e.m73653v();
        }
        return str + "}";
    }

    /* renamed from: y1 */
    public boolean m73517y1() {
        int i10;
        int i11;
        int i12;
        boolean z10 = true;
        int i13 = 0;
        while (true) {
            i10 = this.f56889W0;
            if (i13 >= i10) {
                break;
            }
            C12258e c12258e = this.f56888V0[i13];
            if ((this.f56657Y0 || c12258e.mo73513h()) && ((((i11 = this.f56656X0) == 0 || i11 == 1) && !c12258e.mo73515p0()) || (((i12 = this.f56656X0) == 2 || i12 == 3) && !c12258e.mo73516q0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z11 = false;
        for (int i14 = 0; i14 < this.f56889W0; i14++) {
            C12258e c12258e2 = this.f56888V0[i14];
            if (this.f56657Y0 || c12258e2.mo73513h()) {
                if (!z11) {
                    int i15 = this.f56656X0;
                    if (i15 == 0) {
                        iMax = c12258e2.mo73639q(C12257d.a.LEFT).m73528e();
                    } else if (i15 == 1) {
                        iMax = c12258e2.mo73639q(C12257d.a.RIGHT).m73528e();
                    } else if (i15 == 2) {
                        iMax = c12258e2.mo73639q(C12257d.a.TOP).m73528e();
                    } else if (i15 == 3) {
                        iMax = c12258e2.mo73639q(C12257d.a.BOTTOM).m73528e();
                    }
                    z11 = true;
                }
                int i16 = this.f56656X0;
                if (i16 == 0) {
                    iMax = Math.min(iMax, c12258e2.mo73639q(C12257d.a.LEFT).m73528e());
                } else if (i16 == 1) {
                    iMax = Math.max(iMax, c12258e2.mo73639q(C12257d.a.RIGHT).m73528e());
                } else if (i16 == 2) {
                    iMax = Math.min(iMax, c12258e2.mo73639q(C12257d.a.TOP).m73528e());
                } else if (i16 == 3) {
                    iMax = Math.max(iMax, c12258e2.mo73639q(C12257d.a.BOTTOM).m73528e());
                }
            }
        }
        int i17 = iMax + this.f56658Z0;
        int i18 = this.f56656X0;
        if (i18 == 0 || i18 == 1) {
            m73567K0(i17, i17);
        } else {
            m73573N0(i17, i17);
        }
        this.f56659a1 = true;
        return true;
    }

    /* renamed from: z1 */
    public boolean m73518z1() {
        return this.f56657Y0;
    }
}
