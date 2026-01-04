package p561q;

import java.util.ArrayList;
import java.util.HashMap;
import p479n.C11574d;
import p561q.C12258e;

/* renamed from: q.g */
/* loaded from: classes.dex */
public class C12260g extends C12266m {

    /* renamed from: H1 */
    public C12258e[] f56843H1;

    /* renamed from: k1 */
    public int f56845k1 = -1;

    /* renamed from: l1 */
    public int f56846l1 = -1;

    /* renamed from: m1 */
    public int f56847m1 = -1;

    /* renamed from: n1 */
    public int f56848n1 = -1;

    /* renamed from: o1 */
    public int f56849o1 = -1;

    /* renamed from: p1 */
    public int f56850p1 = -1;

    /* renamed from: q1 */
    public float f56851q1 = 0.5f;

    /* renamed from: r1 */
    public float f56852r1 = 0.5f;

    /* renamed from: s1 */
    public float f56853s1 = 0.5f;

    /* renamed from: t1 */
    public float f56854t1 = 0.5f;

    /* renamed from: u1 */
    public float f56855u1 = 0.5f;

    /* renamed from: v1 */
    public float f56856v1 = 0.5f;

    /* renamed from: w1 */
    public int f56857w1 = 0;

    /* renamed from: x1 */
    public int f56858x1 = 0;

    /* renamed from: y1 */
    public int f56859y1 = 2;

    /* renamed from: z1 */
    public int f56860z1 = 2;

    /* renamed from: A1 */
    public int f56836A1 = 0;

    /* renamed from: B1 */
    public int f56837B1 = -1;

    /* renamed from: C1 */
    public int f56838C1 = 0;

    /* renamed from: D1 */
    public ArrayList<a> f56839D1 = new ArrayList<>();

    /* renamed from: E1 */
    public C12258e[] f56840E1 = null;

    /* renamed from: F1 */
    public C12258e[] f56841F1 = null;

    /* renamed from: G1 */
    public int[] f56842G1 = null;

    /* renamed from: I1 */
    public int f56844I1 = 0;

    /* renamed from: q.g$a */
    public class a {

        /* renamed from: a */
        public int f56861a;

        /* renamed from: d */
        public C12257d f56864d;

        /* renamed from: e */
        public C12257d f56865e;

        /* renamed from: f */
        public C12257d f56866f;

        /* renamed from: g */
        public C12257d f56867g;

        /* renamed from: h */
        public int f56868h;

        /* renamed from: i */
        public int f56869i;

        /* renamed from: j */
        public int f56870j;

        /* renamed from: k */
        public int f56871k;

        /* renamed from: q */
        public int f56877q;

        /* renamed from: b */
        public C12258e f56862b = null;

        /* renamed from: c */
        public int f56863c = 0;

        /* renamed from: l */
        public int f56872l = 0;

        /* renamed from: m */
        public int f56873m = 0;

        /* renamed from: n */
        public int f56874n = 0;

        /* renamed from: o */
        public int f56875o = 0;

        /* renamed from: p */
        public int f56876p = 0;

        public a(int i10, C12257d c12257d, C12257d c12257d2, C12257d c12257d3, C12257d c12257d4, int i11) {
            this.f56868h = 0;
            this.f56869i = 0;
            this.f56870j = 0;
            this.f56871k = 0;
            this.f56877q = 0;
            this.f56861a = i10;
            this.f56864d = c12257d;
            this.f56865e = c12257d2;
            this.f56866f = c12257d3;
            this.f56867g = c12257d4;
            this.f56868h = C12260g.this.m73777E1();
            this.f56869i = C12260g.this.m73779G1();
            this.f56870j = C12260g.this.m73778F1();
            this.f56871k = C12260g.this.m73776D1();
            this.f56877q = i11;
        }

        /* renamed from: b */
        public void m73747b(C12258e c12258e) {
            if (this.f56861a == 0) {
                int iM73736q2 = C12260g.this.m73736q2(c12258e, this.f56877q);
                if (c12258e.m73550C() == C12258e.b.MATCH_CONSTRAINT) {
                    this.f56876p++;
                    iM73736q2 = 0;
                }
                this.f56872l += iM73736q2 + (c12258e.m73592X() != 8 ? C12260g.this.f56857w1 : 0);
                int iM73735p2 = C12260g.this.m73735p2(c12258e, this.f56877q);
                if (this.f56862b == null || this.f56863c < iM73735p2) {
                    this.f56862b = c12258e;
                    this.f56863c = iM73735p2;
                    this.f56873m = iM73735p2;
                }
            } else {
                int iM73736q22 = C12260g.this.m73736q2(c12258e, this.f56877q);
                int iM73735p22 = C12260g.this.m73735p2(c12258e, this.f56877q);
                if (c12258e.m73588V() == C12258e.b.MATCH_CONSTRAINT) {
                    this.f56876p++;
                    iM73735p22 = 0;
                }
                this.f56873m += iM73735p22 + (c12258e.m73592X() != 8 ? C12260g.this.f56858x1 : 0);
                if (this.f56862b == null || this.f56863c < iM73736q22) {
                    this.f56862b = c12258e;
                    this.f56863c = iM73736q22;
                    this.f56872l = iM73736q22;
                }
            }
            this.f56875o++;
        }

        /* renamed from: c */
        public void m73748c() {
            this.f56863c = 0;
            this.f56862b = null;
            this.f56872l = 0;
            this.f56873m = 0;
            this.f56874n = 0;
            this.f56875o = 0;
            this.f56876p = 0;
        }

        /* renamed from: d */
        public void m73749d(boolean z10, int i10, boolean z11) {
            C12258e c12258e;
            char c10;
            float f10;
            float f11;
            int i11 = this.f56875o;
            for (int i12 = 0; i12 < i11 && this.f56874n + i12 < C12260g.this.f56844I1; i12++) {
                C12258e c12258e2 = C12260g.this.f56843H1[this.f56874n + i12];
                if (c12258e2 != null) {
                    c12258e2.m73659x0();
                }
            }
            if (i11 == 0 || this.f56862b == null) {
                return;
            }
            boolean z12 = z11 && i10 == 0;
            int i13 = -1;
            int i14 = -1;
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = z10 ? (i11 - 1) - i15 : i15;
                if (this.f56874n + i16 >= C12260g.this.f56844I1) {
                    break;
                }
                C12258e c12258e3 = C12260g.this.f56843H1[this.f56874n + i16];
                if (c12258e3 != null && c12258e3.m73592X() == 0) {
                    if (i13 == -1) {
                        i13 = i15;
                    }
                    i14 = i15;
                }
            }
            C12258e c12258e4 = null;
            if (this.f56861a != 0) {
                C12258e c12258e5 = this.f56862b;
                c12258e5.m73583S0(C12260g.this.f56845k1);
                int i17 = this.f56868h;
                if (i10 > 0) {
                    i17 += C12260g.this.f56857w1;
                }
                if (z10) {
                    c12258e5.f56738S.m73524a(this.f56866f, i17);
                    if (z11) {
                        c12258e5.f56734Q.m73524a(this.f56864d, this.f56870j);
                    }
                    if (i10 > 0) {
                        this.f56866f.f56685d.f56734Q.m73524a(c12258e5.f56738S, 0);
                    }
                } else {
                    c12258e5.f56734Q.m73524a(this.f56864d, i17);
                    if (z11) {
                        c12258e5.f56738S.m73524a(this.f56866f, this.f56870j);
                    }
                    if (i10 > 0) {
                        this.f56864d.f56685d.f56738S.m73524a(c12258e5.f56734Q, 0);
                    }
                }
                for (int i18 = 0; i18 < i11 && this.f56874n + i18 < C12260g.this.f56844I1; i18++) {
                    C12258e c12258e6 = C12260g.this.f56843H1[this.f56874n + i18];
                    if (c12258e6 != null) {
                        if (i18 == 0) {
                            c12258e6.m73626l(c12258e6.f56736R, this.f56865e, this.f56869i);
                            int i19 = C12260g.this.f56846l1;
                            float f12 = C12260g.this.f56852r1;
                            if (this.f56874n == 0 && C12260g.this.f56848n1 != -1) {
                                i19 = C12260g.this.f56848n1;
                                f12 = C12260g.this.f56854t1;
                            } else if (z11 && C12260g.this.f56850p1 != -1) {
                                i19 = C12260g.this.f56850p1;
                                f12 = C12260g.this.f56856v1;
                            }
                            c12258e6.m73622j1(i19);
                            c12258e6.m73619i1(f12);
                        }
                        if (i18 == i11 - 1) {
                            c12258e6.m73626l(c12258e6.f56740T, this.f56867g, this.f56871k);
                        }
                        if (c12258e4 != null) {
                            c12258e6.f56736R.m73524a(c12258e4.f56740T, C12260g.this.f56858x1);
                            if (i18 == i13) {
                                c12258e6.f56736R.m73544u(this.f56869i);
                            }
                            c12258e4.f56740T.m73524a(c12258e6.f56736R, 0);
                            if (i18 == i14 + 1) {
                                c12258e4.f56740T.m73544u(this.f56871k);
                            }
                        }
                        if (c12258e6 == c12258e5) {
                            c12258e4 = c12258e6;
                        } else if (z10) {
                            int i20 = C12260g.this.f56859y1;
                            if (i20 == 0) {
                                c12258e6.f56738S.m73524a(c12258e5.f56738S, 0);
                            } else if (i20 == 1) {
                                c12258e6.f56734Q.m73524a(c12258e5.f56734Q, 0);
                            } else if (i20 == 2) {
                                c12258e6.f56734Q.m73524a(c12258e5.f56734Q, 0);
                                c12258e6.f56738S.m73524a(c12258e5.f56738S, 0);
                            }
                            c12258e4 = c12258e6;
                        } else {
                            int i21 = C12260g.this.f56859y1;
                            if (i21 == 0) {
                                c12258e6.f56734Q.m73524a(c12258e5.f56734Q, 0);
                            } else if (i21 == 1) {
                                c12258e6.f56738S.m73524a(c12258e5.f56738S, 0);
                            } else if (i21 == 2) {
                                if (z12) {
                                    c12258e6.f56734Q.m73524a(this.f56864d, this.f56868h);
                                    c12258e6.f56738S.m73524a(this.f56866f, this.f56870j);
                                } else {
                                    c12258e6.f56734Q.m73524a(c12258e5.f56734Q, 0);
                                    c12258e6.f56738S.m73524a(c12258e5.f56738S, 0);
                                }
                            }
                            c12258e4 = c12258e6;
                        }
                    }
                }
                return;
            }
            C12258e c12258e7 = this.f56862b;
            c12258e7.m73622j1(C12260g.this.f56846l1);
            int i22 = this.f56869i;
            if (i10 > 0) {
                i22 += C12260g.this.f56858x1;
            }
            c12258e7.f56736R.m73524a(this.f56865e, i22);
            if (z11) {
                c12258e7.f56740T.m73524a(this.f56867g, this.f56871k);
            }
            if (i10 > 0) {
                this.f56865e.f56685d.f56740T.m73524a(c12258e7.f56736R, 0);
            }
            char c11 = 3;
            if (C12260g.this.f56860z1 != 3 || c12258e7.m73600b0()) {
                c12258e = c12258e7;
            } else {
                for (int i23 = 0; i23 < i11; i23++) {
                    int i24 = z10 ? (i11 - 1) - i23 : i23;
                    if (this.f56874n + i24 >= C12260g.this.f56844I1) {
                        break;
                    }
                    c12258e = C12260g.this.f56843H1[this.f56874n + i24];
                    if (c12258e.m73600b0()) {
                        break;
                    }
                }
                c12258e = c12258e7;
            }
            int i25 = 0;
            while (i25 < i11) {
                int i26 = z10 ? (i11 - 1) - i25 : i25;
                if (this.f56874n + i26 >= C12260g.this.f56844I1) {
                    return;
                }
                C12258e c12258e8 = C12260g.this.f56843H1[this.f56874n + i26];
                if (c12258e8 == null) {
                    c12258e8 = c12258e4;
                    c10 = c11;
                } else {
                    if (i25 == 0) {
                        c12258e8.m73626l(c12258e8.f56734Q, this.f56864d, this.f56868h);
                    }
                    if (i26 == 0) {
                        int i27 = C12260g.this.f56845k1;
                        float f13 = C12260g.this.f56851q1;
                        if (z10) {
                            f13 = 1.0f - f13;
                        }
                        if (this.f56874n != 0 || C12260g.this.f56847m1 == -1) {
                            if (z11 && C12260g.this.f56849o1 != -1) {
                                i27 = C12260g.this.f56849o1;
                                if (z10) {
                                    f11 = C12260g.this.f56855u1;
                                    f10 = 1.0f - f11;
                                    f13 = f10;
                                } else {
                                    f10 = C12260g.this.f56855u1;
                                    f13 = f10;
                                }
                            }
                            c12258e8.m73583S0(i27);
                            c12258e8.m73581R0(f13);
                        } else {
                            i27 = C12260g.this.f56847m1;
                            if (z10) {
                                f11 = C12260g.this.f56853s1;
                                f10 = 1.0f - f11;
                                f13 = f10;
                                c12258e8.m73583S0(i27);
                                c12258e8.m73581R0(f13);
                            } else {
                                f10 = C12260g.this.f56853s1;
                                f13 = f10;
                                c12258e8.m73583S0(i27);
                                c12258e8.m73581R0(f13);
                            }
                        }
                    }
                    if (i25 == i11 - 1) {
                        c12258e8.m73626l(c12258e8.f56738S, this.f56866f, this.f56870j);
                    }
                    if (c12258e4 != null) {
                        c12258e8.f56734Q.m73524a(c12258e4.f56738S, C12260g.this.f56857w1);
                        if (i25 == i13) {
                            c12258e8.f56734Q.m73544u(this.f56868h);
                        }
                        c12258e4.f56738S.m73524a(c12258e8.f56734Q, 0);
                        if (i25 == i14 + 1) {
                            c12258e4.f56738S.m73544u(this.f56870j);
                        }
                    }
                    if (c12258e8 != c12258e7) {
                        c10 = 3;
                        if (C12260g.this.f56860z1 == 3 && c12258e.m73600b0() && c12258e8 != c12258e && c12258e8.m73600b0()) {
                            c12258e8.f56742U.m73524a(c12258e.f56742U, 0);
                        } else {
                            int i28 = C12260g.this.f56860z1;
                            if (i28 == 0) {
                                c12258e8.f56736R.m73524a(c12258e7.f56736R, 0);
                            } else if (i28 == 1) {
                                c12258e8.f56740T.m73524a(c12258e7.f56740T, 0);
                            } else if (z12) {
                                c12258e8.f56736R.m73524a(this.f56865e, this.f56869i);
                                c12258e8.f56740T.m73524a(this.f56867g, this.f56871k);
                            } else {
                                c12258e8.f56736R.m73524a(c12258e7.f56736R, 0);
                                c12258e8.f56740T.m73524a(c12258e7.f56740T, 0);
                            }
                        }
                    } else {
                        c10 = 3;
                    }
                }
                i25++;
                c11 = c10;
                c12258e4 = c12258e8;
            }
        }

        /* renamed from: e */
        public int m73750e() {
            return this.f56861a == 1 ? this.f56873m - C12260g.this.f56858x1 : this.f56873m;
        }

        /* renamed from: f */
        public int m73751f() {
            return this.f56861a == 0 ? this.f56872l - C12260g.this.f56857w1 : this.f56872l;
        }

        /* renamed from: g */
        public void m73752g(int i10) {
            int i11 = this.f56876p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f56875o;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i12 && this.f56874n + i14 < C12260g.this.f56844I1; i14++) {
                C12258e c12258e = C12260g.this.f56843H1[this.f56874n + i14];
                if (this.f56861a == 0) {
                    if (c12258e != null && c12258e.m73550C() == C12258e.b.MATCH_CONSTRAINT && c12258e.f56792w == 0) {
                        C12260g.this.m73780I1(c12258e, C12258e.b.FIXED, i13, c12258e.m73588V(), c12258e.m73662z());
                    }
                } else if (c12258e != null && c12258e.m73588V() == C12258e.b.MATCH_CONSTRAINT && c12258e.f56794x == 0) {
                    C12260g.this.m73780I1(c12258e, c12258e.m73550C(), c12258e.m73594Y(), C12258e.b.FIXED, i13);
                }
            }
            m73753h();
        }

        /* renamed from: h */
        public final void m73753h() {
            this.f56872l = 0;
            this.f56873m = 0;
            this.f56862b = null;
            this.f56863c = 0;
            int i10 = this.f56875o;
            for (int i11 = 0; i11 < i10 && this.f56874n + i11 < C12260g.this.f56844I1; i11++) {
                C12258e c12258e = C12260g.this.f56843H1[this.f56874n + i11];
                if (this.f56861a == 0) {
                    int iM73594Y = c12258e.m73594Y();
                    int i12 = C12260g.this.f56857w1;
                    if (c12258e.m73592X() == 8) {
                        i12 = 0;
                    }
                    this.f56872l += iM73594Y + i12;
                    int iM73735p2 = C12260g.this.m73735p2(c12258e, this.f56877q);
                    if (this.f56862b == null || this.f56863c < iM73735p2) {
                        this.f56862b = c12258e;
                        this.f56863c = iM73735p2;
                        this.f56873m = iM73735p2;
                    }
                } else {
                    int iM73736q2 = C12260g.this.m73736q2(c12258e, this.f56877q);
                    int iM73735p22 = C12260g.this.m73735p2(c12258e, this.f56877q);
                    int i13 = C12260g.this.f56858x1;
                    if (c12258e.m73592X() == 8) {
                        i13 = 0;
                    }
                    this.f56873m += iM73735p22 + i13;
                    if (this.f56862b == null || this.f56863c < iM73736q2) {
                        this.f56862b = c12258e;
                        this.f56863c = iM73736q2;
                        this.f56872l = iM73736q2;
                    }
                }
            }
        }

        /* renamed from: i */
        public void m73754i(int i10) {
            this.f56874n = i10;
        }

        /* renamed from: j */
        public void m73755j(int i10, C12257d c12257d, C12257d c12257d2, C12257d c12257d3, C12257d c12257d4, int i11, int i12, int i13, int i14, int i15) {
            this.f56861a = i10;
            this.f56864d = c12257d;
            this.f56865e = c12257d2;
            this.f56866f = c12257d3;
            this.f56867g = c12257d4;
            this.f56868h = i11;
            this.f56869i = i12;
            this.f56870j = i13;
            this.f56871k = i14;
            this.f56877q = i15;
        }
    }

    /* renamed from: A2 */
    public void m73719A2(float f10) {
        this.f56851q1 = f10;
    }

    /* renamed from: B2 */
    public void m73720B2(int i10) {
        this.f56857w1 = i10;
    }

    /* renamed from: C2 */
    public void m73721C2(int i10) {
        this.f56845k1 = i10;
    }

    /* renamed from: D2 */
    public void m73722D2(float f10) {
        this.f56855u1 = f10;
    }

    /* renamed from: E2 */
    public void m73723E2(int i10) {
        this.f56849o1 = i10;
    }

    /* renamed from: F2 */
    public void m73724F2(float f10) {
        this.f56856v1 = f10;
    }

    /* renamed from: G2 */
    public void m73725G2(int i10) {
        this.f56850p1 = i10;
    }

    @Override // p561q.C12266m
    /* renamed from: H1 */
    public void mo73726H1(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int[] iArr;
        boolean z10;
        if (this.f56889W0 > 0 && !m73781J1()) {
            m73784M1(0, 0);
            m73783L1(false);
            return;
        }
        int iM73777E1 = m73777E1();
        int iM73778F1 = m73778F1();
        int iM73779G1 = m73779G1();
        int iM73776D1 = m73776D1();
        int[] iArr2 = new int[2];
        int i16 = (i11 - iM73777E1) - iM73778F1;
        int i17 = this.f56838C1;
        if (i17 == 1) {
            i16 = (i13 - iM73779G1) - iM73776D1;
        }
        int i18 = i16;
        if (i17 == 0) {
            if (this.f56845k1 == -1) {
                this.f56845k1 = 0;
            }
            if (this.f56846l1 == -1) {
                this.f56846l1 = 0;
            }
        } else {
            if (this.f56845k1 == -1) {
                this.f56845k1 = 0;
            }
            if (this.f56846l1 == -1) {
                this.f56846l1 = 0;
            }
        }
        C12258e[] c12258eArr = this.f56888V0;
        int i19 = 0;
        int i20 = 0;
        while (true) {
            i14 = this.f56889W0;
            if (i19 >= i14) {
                break;
            }
            if (this.f56888V0[i19].m73592X() == 8) {
                i20++;
            }
            i19++;
        }
        if (i20 > 0) {
            c12258eArr = new C12258e[i14 - i20];
            int i21 = 0;
            for (int i22 = 0; i22 < this.f56889W0; i22++) {
                C12258e c12258e = this.f56888V0[i22];
                if (c12258e.m73592X() != 8) {
                    c12258eArr[i21] = c12258e;
                    i21++;
                }
            }
            i15 = i21;
        } else {
            i15 = i14;
        }
        this.f56843H1 = c12258eArr;
        this.f56844I1 = i15;
        int i23 = this.f56836A1;
        if (i23 == 0) {
            iArr = iArr2;
            z10 = true;
            m73740u2(c12258eArr, i15, this.f56838C1, i18, iArr2);
        } else if (i23 == 1) {
            z10 = true;
            iArr = iArr2;
            m73738s2(c12258eArr, i15, this.f56838C1, i18, iArr2);
        } else if (i23 == 2) {
            z10 = true;
            iArr = iArr2;
            m73737r2(c12258eArr, i15, this.f56838C1, i18, iArr2);
        } else if (i23 != 3) {
            z10 = true;
            iArr = iArr2;
        } else {
            z10 = true;
            iArr = iArr2;
            m73739t2(c12258eArr, i15, this.f56838C1, i18, iArr2);
        }
        int iMin = iArr[0] + iM73777E1 + iM73778F1;
        int iMin2 = iArr[z10 ? 1 : 0] + iM73779G1 + iM73776D1;
        if (i10 == 1073741824) {
            iMin = i11;
        } else if (i10 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i11);
        } else if (i10 != 0) {
            iMin = 0;
        }
        if (i12 == 1073741824) {
            iMin2 = i13;
        } else if (i12 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i13);
        } else if (i12 != 0) {
            iMin2 = 0;
        }
        m73784M1(iMin, iMin2);
        m73638p1(iMin);
        m73579Q0(iMin2);
        if (this.f56889W0 <= 0) {
            z10 = false;
        }
        m73783L1(z10);
    }

    /* renamed from: H2 */
    public void m73727H2(int i10) {
        this.f56837B1 = i10;
    }

    /* renamed from: I2 */
    public void m73728I2(int i10) {
        this.f56838C1 = i10;
    }

    /* renamed from: J2 */
    public void m73729J2(int i10) {
        this.f56860z1 = i10;
    }

    /* renamed from: K2 */
    public void m73730K2(float f10) {
        this.f56852r1 = f10;
    }

    /* renamed from: L2 */
    public void m73731L2(int i10) {
        this.f56858x1 = i10;
    }

    /* renamed from: M2 */
    public void m73732M2(int i10) {
        this.f56846l1 = i10;
    }

    /* renamed from: N2 */
    public void m73733N2(int i10) {
        this.f56836A1 = i10;
    }

    @Override // p561q.C12258e
    /* renamed from: g */
    public void mo73512g(C11574d c11574d, boolean z10) {
        super.mo73512g(c11574d, z10);
        boolean z11 = m73570M() != null && ((C12259f) m73570M()).m73687V1();
        int i10 = this.f56836A1;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = this.f56839D1.size();
                int i11 = 0;
                while (i11 < size) {
                    this.f56839D1.get(i11).m73749d(z11, i11, i11 == size + (-1));
                    i11++;
                }
            } else if (i10 == 2) {
                m73734o2(z11);
            } else if (i10 == 3) {
                int size2 = this.f56839D1.size();
                int i12 = 0;
                while (i12 < size2) {
                    this.f56839D1.get(i12).m73749d(z11, i12, i12 == size2 + (-1));
                    i12++;
                }
            }
        } else if (this.f56839D1.size() > 0) {
            this.f56839D1.get(0).m73749d(z11, 0, true);
        }
        m73783L1(false);
    }

    @Override // p561q.C12263j, p561q.C12258e
    /* renamed from: n */
    public void mo73514n(C12258e c12258e, HashMap<C12258e, C12258e> map) {
        super.mo73514n(c12258e, map);
        C12260g c12260g = (C12260g) c12258e;
        this.f56845k1 = c12260g.f56845k1;
        this.f56846l1 = c12260g.f56846l1;
        this.f56847m1 = c12260g.f56847m1;
        this.f56848n1 = c12260g.f56848n1;
        this.f56849o1 = c12260g.f56849o1;
        this.f56850p1 = c12260g.f56850p1;
        this.f56851q1 = c12260g.f56851q1;
        this.f56852r1 = c12260g.f56852r1;
        this.f56853s1 = c12260g.f56853s1;
        this.f56854t1 = c12260g.f56854t1;
        this.f56855u1 = c12260g.f56855u1;
        this.f56856v1 = c12260g.f56856v1;
        this.f56857w1 = c12260g.f56857w1;
        this.f56858x1 = c12260g.f56858x1;
        this.f56859y1 = c12260g.f56859y1;
        this.f56860z1 = c12260g.f56860z1;
        this.f56836A1 = c12260g.f56836A1;
        this.f56837B1 = c12260g.f56837B1;
        this.f56838C1 = c12260g.f56838C1;
    }

    /* renamed from: o2 */
    public final void m73734o2(boolean z10) {
        C12258e c12258e;
        float f10;
        int i10;
        if (this.f56842G1 == null || this.f56841F1 == null || this.f56840E1 == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f56844I1; i11++) {
            this.f56843H1[i11].m73659x0();
        }
        int[] iArr = this.f56842G1;
        int i12 = iArr[0];
        int i13 = iArr[1];
        float f11 = this.f56851q1;
        C12258e c12258e2 = null;
        int i14 = 0;
        while (i14 < i12) {
            if (z10) {
                i10 = (i12 - i14) - 1;
                f10 = 1.0f - this.f56851q1;
            } else {
                f10 = f11;
                i10 = i14;
            }
            C12258e c12258e3 = this.f56841F1[i10];
            if (c12258e3 != null && c12258e3.m73592X() != 8) {
                if (i14 == 0) {
                    c12258e3.m73626l(c12258e3.f56734Q, this.f56734Q, m73777E1());
                    c12258e3.m73583S0(this.f56845k1);
                    c12258e3.m73581R0(f10);
                }
                if (i14 == i12 - 1) {
                    c12258e3.m73626l(c12258e3.f56738S, this.f56738S, m73778F1());
                }
                if (i14 > 0 && c12258e2 != null) {
                    c12258e3.m73626l(c12258e3.f56734Q, c12258e2.f56738S, this.f56857w1);
                    c12258e2.m73626l(c12258e2.f56738S, c12258e3.f56734Q, 0);
                }
                c12258e2 = c12258e3;
            }
            i14++;
            f11 = f10;
        }
        for (int i15 = 0; i15 < i13; i15++) {
            C12258e c12258e4 = this.f56840E1[i15];
            if (c12258e4 != null && c12258e4.m73592X() != 8) {
                if (i15 == 0) {
                    c12258e4.m73626l(c12258e4.f56736R, this.f56736R, m73779G1());
                    c12258e4.m73622j1(this.f56846l1);
                    c12258e4.m73619i1(this.f56852r1);
                }
                if (i15 == i13 - 1) {
                    c12258e4.m73626l(c12258e4.f56740T, this.f56740T, m73776D1());
                }
                if (i15 > 0 && c12258e2 != null) {
                    c12258e4.m73626l(c12258e4.f56736R, c12258e2.f56740T, this.f56858x1);
                    c12258e2.m73626l(c12258e2.f56740T, c12258e4.f56736R, 0);
                }
                c12258e2 = c12258e4;
            }
        }
        for (int i16 = 0; i16 < i12; i16++) {
            for (int i17 = 0; i17 < i13; i17++) {
                int i18 = (i17 * i12) + i16;
                if (this.f56838C1 == 1) {
                    i18 = (i16 * i13) + i17;
                }
                C12258e[] c12258eArr = this.f56843H1;
                if (i18 < c12258eArr.length && (c12258e = c12258eArr[i18]) != null && c12258e.m73592X() != 8) {
                    C12258e c12258e5 = this.f56841F1[i16];
                    C12258e c12258e6 = this.f56840E1[i17];
                    if (c12258e != c12258e5) {
                        c12258e.m73626l(c12258e.f56734Q, c12258e5.f56734Q, 0);
                        c12258e.m73626l(c12258e.f56738S, c12258e5.f56738S, 0);
                    }
                    if (c12258e != c12258e6) {
                        c12258e.m73626l(c12258e.f56736R, c12258e6.f56736R, 0);
                        c12258e.m73626l(c12258e.f56740T, c12258e6.f56740T, 0);
                    }
                }
            }
        }
    }

    /* renamed from: p2 */
    public final int m73735p2(C12258e c12258e, int i10) {
        if (c12258e == null) {
            return 0;
        }
        if (c12258e.m73588V() == C12258e.b.MATCH_CONSTRAINT) {
            int i11 = c12258e.f56794x;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (c12258e.f56710E * i10);
                if (i12 != c12258e.m73662z()) {
                    c12258e.m73606d1(true);
                    m73780I1(c12258e, c12258e.m73550C(), c12258e.m73594Y(), C12258e.b.FIXED, i12);
                }
                return i12;
            }
            if (i11 == 1) {
                return c12258e.m73662z();
            }
            if (i11 == 3) {
                return (int) ((c12258e.m73594Y() * c12258e.f56759f0) + 0.5f);
            }
        }
        return c12258e.m73662z();
    }

    /* renamed from: q2 */
    public final int m73736q2(C12258e c12258e, int i10) {
        if (c12258e == null) {
            return 0;
        }
        if (c12258e.m73550C() == C12258e.b.MATCH_CONSTRAINT) {
            int i11 = c12258e.f56792w;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (c12258e.f56704B * i10);
                if (i12 != c12258e.m73594Y()) {
                    c12258e.m73606d1(true);
                    m73780I1(c12258e, C12258e.b.FIXED, i12, c12258e.m73588V(), c12258e.m73662z());
                }
                return i12;
            }
            if (i11 == 1) {
                return c12258e.m73594Y();
            }
            if (i11 == 3) {
                return (int) ((c12258e.m73662z() * c12258e.f56759f0) + 0.5f);
            }
        }
        return c12258e.m73594Y();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* renamed from: r2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m73737r2(p561q.C12258e[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p561q.C12260g.m73737r2(q.e[], int, int, int, int[]):void");
    }

    /* renamed from: s2 */
    public final void m73738s2(C12258e[] c12258eArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14;
        int i15;
        C12257d c12257d;
        int iM73778F1;
        C12257d c12257d2;
        int iM73776D1;
        int i16;
        if (i10 == 0) {
            return;
        }
        this.f56839D1.clear();
        a aVar = new a(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, i12);
        this.f56839D1.add(aVar);
        if (i11 == 0) {
            i13 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i10) {
                C12258e c12258e = c12258eArr[i18];
                int iM73736q2 = m73736q2(c12258e, i12);
                if (c12258e.m73550C() == C12258e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i19 = i13;
                boolean z10 = (i17 == i12 || (this.f56857w1 + i17) + iM73736q2 > i12) && aVar.f56862b != null;
                if ((z10 || i18 <= 0 || (i16 = this.f56837B1) <= 0 || i18 % i16 != 0) && !z10) {
                    if (i18 > 0) {
                        i17 += this.f56857w1 + iM73736q2;
                    }
                    aVar.m73747b(c12258e);
                    i18++;
                    i13 = i19;
                } else {
                    aVar = new a(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, i12);
                    aVar.m73754i(i18);
                    this.f56839D1.add(aVar);
                }
                i17 = iM73736q2;
                aVar.m73747b(c12258e);
                i18++;
                i13 = i19;
            }
        } else {
            i13 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i21 < i10) {
                C12258e c12258e2 = c12258eArr[i21];
                int iM73735p2 = m73735p2(c12258e2, i12);
                if (c12258e2.m73588V() == C12258e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i22 = i13;
                boolean z11 = (i20 == i12 || (this.f56858x1 + i20) + iM73735p2 > i12) && aVar.f56862b != null;
                if ((z11 || i21 <= 0 || (i14 = this.f56837B1) <= 0 || i21 % i14 != 0) && !z11) {
                    if (i21 > 0) {
                        i20 += this.f56858x1 + iM73735p2;
                    }
                    aVar.m73747b(c12258e2);
                    i21++;
                    i13 = i22;
                } else {
                    aVar = new a(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, i12);
                    aVar.m73754i(i21);
                    this.f56839D1.add(aVar);
                }
                i20 = iM73735p2;
                aVar.m73747b(c12258e2);
                i21++;
                i13 = i22;
            }
        }
        int size = this.f56839D1.size();
        C12257d c12257d3 = this.f56734Q;
        C12257d c12257d4 = this.f56736R;
        C12257d c12257d5 = this.f56738S;
        C12257d c12257d6 = this.f56740T;
        int iM73777E1 = m73777E1();
        int iM73779G1 = m73779G1();
        int iM73778F12 = m73778F1();
        int iM73776D12 = m73776D1();
        C12258e.b bVarM73550C = m73550C();
        C12258e.b bVar = C12258e.b.WRAP_CONTENT;
        boolean z12 = bVarM73550C == bVar || m73588V() == bVar;
        if (i13 > 0 && z12) {
            for (int i23 = 0; i23 < size; i23++) {
                a aVar2 = this.f56839D1.get(i23);
                if (i11 == 0) {
                    aVar2.m73752g(i12 - aVar2.m73751f());
                } else {
                    aVar2.m73752g(i12 - aVar2.m73750e());
                }
            }
        }
        int i24 = iM73779G1;
        int i25 = iM73778F12;
        int iM73750e = 0;
        int iM73751f = 0;
        int i26 = 0;
        int i27 = iM73777E1;
        C12257d c12257d7 = c12257d4;
        C12257d c12257d8 = c12257d3;
        int i28 = iM73776D12;
        while (i26 < size) {
            a aVar3 = this.f56839D1.get(i26);
            if (i11 == 0) {
                if (i26 < size - 1) {
                    c12257d2 = this.f56839D1.get(i26 + 1).f56862b.f56736R;
                    iM73776D1 = 0;
                } else {
                    c12257d2 = this.f56740T;
                    iM73776D1 = m73776D1();
                }
                C12257d c12257d9 = aVar3.f56862b.f56740T;
                C12257d c12257d10 = c12257d8;
                C12257d c12257d11 = c12257d8;
                int i29 = iM73750e;
                C12257d c12257d12 = c12257d7;
                int i30 = iM73751f;
                C12257d c12257d13 = c12257d5;
                C12257d c12257d14 = c12257d5;
                i15 = i26;
                aVar3.m73755j(i11, c12257d10, c12257d12, c12257d13, c12257d2, i27, i24, i25, iM73776D1, i12);
                int iMax = Math.max(i30, aVar3.m73751f());
                iM73750e = i29 + aVar3.m73750e();
                if (i15 > 0) {
                    iM73750e += this.f56858x1;
                }
                c12257d8 = c12257d11;
                iM73751f = iMax;
                i24 = 0;
                c12257d7 = c12257d9;
                c12257d = c12257d14;
                int i31 = iM73776D1;
                c12257d6 = c12257d2;
                i28 = i31;
            } else {
                C12257d c12257d15 = c12257d8;
                int i32 = iM73750e;
                int i33 = iM73751f;
                i15 = i26;
                if (i15 < size - 1) {
                    c12257d = this.f56839D1.get(i15 + 1).f56862b.f56734Q;
                    iM73778F1 = 0;
                } else {
                    c12257d = this.f56738S;
                    iM73778F1 = m73778F1();
                }
                C12257d c12257d16 = aVar3.f56862b.f56738S;
                aVar3.m73755j(i11, c12257d15, c12257d7, c12257d, c12257d6, i27, i24, iM73778F1, i28, i12);
                iM73751f = i33 + aVar3.m73751f();
                int iMax2 = Math.max(i32, aVar3.m73750e());
                if (i15 > 0) {
                    iM73751f += this.f56857w1;
                }
                iM73750e = iMax2;
                i27 = 0;
                i25 = iM73778F1;
                c12257d8 = c12257d16;
            }
            i26 = i15 + 1;
            c12257d5 = c12257d;
        }
        iArr[0] = iM73751f;
        iArr[1] = iM73750e;
    }

    /* renamed from: t2 */
    public final void m73739t2(C12258e[] c12258eArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14;
        int i15;
        C12257d c12257d;
        int iM73778F1;
        C12257d c12257d2;
        int iM73776D1;
        int i16;
        if (i10 == 0) {
            return;
        }
        this.f56839D1.clear();
        a aVar = new a(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, i12);
        this.f56839D1.add(aVar);
        if (i11 == 0) {
            int i17 = 0;
            i13 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i10) {
                i17++;
                C12258e c12258e = c12258eArr[i19];
                int iM73736q2 = m73736q2(c12258e, i12);
                if (c12258e.m73550C() == C12258e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i20 = i13;
                boolean z10 = (i18 == i12 || (this.f56857w1 + i18) + iM73736q2 > i12) && aVar.f56862b != null;
                if ((z10 || i19 <= 0 || (i16 = this.f56837B1) <= 0 || i17 <= i16) && !z10) {
                    i18 = i19 > 0 ? i18 + this.f56857w1 + iM73736q2 : iM73736q2;
                } else {
                    aVar = new a(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, i12);
                    aVar.m73754i(i19);
                    this.f56839D1.add(aVar);
                    i18 = iM73736q2;
                    i17 = 1;
                }
                aVar.m73747b(c12258e);
                i19++;
                i13 = i20;
            }
        } else {
            int i21 = 0;
            i13 = 0;
            int i22 = 0;
            int i23 = 0;
            while (i23 < i10) {
                i21++;
                C12258e c12258e2 = c12258eArr[i23];
                int iM73735p2 = m73735p2(c12258e2, i12);
                if (c12258e2.m73588V() == C12258e.b.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i24 = i13;
                boolean z11 = (i22 == i12 || (this.f56858x1 + i22) + iM73735p2 > i12) && aVar.f56862b != null;
                if ((z11 || i23 <= 0 || (i14 = this.f56837B1) <= 0 || i21 <= i14) && !z11) {
                    i22 = i23 > 0 ? i22 + this.f56858x1 + iM73735p2 : iM73735p2;
                } else {
                    aVar = new a(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, i12);
                    aVar.m73754i(i23);
                    this.f56839D1.add(aVar);
                    i22 = iM73735p2;
                    i21 = 1;
                }
                aVar.m73747b(c12258e2);
                i23++;
                i13 = i24;
            }
        }
        int size = this.f56839D1.size();
        C12257d c12257d3 = this.f56734Q;
        C12257d c12257d4 = this.f56736R;
        C12257d c12257d5 = this.f56738S;
        C12257d c12257d6 = this.f56740T;
        int iM73777E1 = m73777E1();
        int iM73779G1 = m73779G1();
        int iM73778F12 = m73778F1();
        int iM73776D12 = m73776D1();
        C12258e.b bVarM73550C = m73550C();
        C12258e.b bVar = C12258e.b.WRAP_CONTENT;
        boolean z12 = bVarM73550C == bVar || m73588V() == bVar;
        if (i13 > 0 && z12) {
            for (int i25 = 0; i25 < size; i25++) {
                a aVar2 = this.f56839D1.get(i25);
                if (i11 == 0) {
                    aVar2.m73752g(i12 - aVar2.m73751f());
                } else {
                    aVar2.m73752g(i12 - aVar2.m73750e());
                }
            }
        }
        int i26 = iM73779G1;
        int i27 = iM73778F12;
        int iM73750e = 0;
        int iM73751f = 0;
        int i28 = 0;
        int i29 = iM73777E1;
        C12257d c12257d7 = c12257d4;
        C12257d c12257d8 = c12257d3;
        int i30 = iM73776D12;
        while (i28 < size) {
            a aVar3 = this.f56839D1.get(i28);
            if (i11 == 0) {
                if (i28 < size - 1) {
                    c12257d2 = this.f56839D1.get(i28 + 1).f56862b.f56736R;
                    iM73776D1 = 0;
                } else {
                    c12257d2 = this.f56740T;
                    iM73776D1 = m73776D1();
                }
                C12257d c12257d9 = aVar3.f56862b.f56740T;
                C12257d c12257d10 = c12257d8;
                C12257d c12257d11 = c12257d8;
                int i31 = iM73750e;
                C12257d c12257d12 = c12257d7;
                int i32 = iM73751f;
                C12257d c12257d13 = c12257d5;
                C12257d c12257d14 = c12257d5;
                i15 = i28;
                aVar3.m73755j(i11, c12257d10, c12257d12, c12257d13, c12257d2, i29, i26, i27, iM73776D1, i12);
                int iMax = Math.max(i32, aVar3.m73751f());
                iM73750e = i31 + aVar3.m73750e();
                if (i15 > 0) {
                    iM73750e += this.f56858x1;
                }
                c12257d8 = c12257d11;
                iM73751f = iMax;
                i26 = 0;
                c12257d7 = c12257d9;
                c12257d = c12257d14;
                int i33 = iM73776D1;
                c12257d6 = c12257d2;
                i30 = i33;
            } else {
                C12257d c12257d15 = c12257d8;
                int i34 = iM73750e;
                int i35 = iM73751f;
                i15 = i28;
                if (i15 < size - 1) {
                    c12257d = this.f56839D1.get(i15 + 1).f56862b.f56734Q;
                    iM73778F1 = 0;
                } else {
                    c12257d = this.f56738S;
                    iM73778F1 = m73778F1();
                }
                C12257d c12257d16 = aVar3.f56862b.f56738S;
                aVar3.m73755j(i11, c12257d15, c12257d7, c12257d, c12257d6, i29, i26, iM73778F1, i30, i12);
                iM73751f = i35 + aVar3.m73751f();
                int iMax2 = Math.max(i34, aVar3.m73750e());
                if (i15 > 0) {
                    iM73751f += this.f56857w1;
                }
                iM73750e = iMax2;
                i29 = 0;
                i27 = iM73778F1;
                c12257d8 = c12257d16;
            }
            i28 = i15 + 1;
            c12257d5 = c12257d;
        }
        iArr[0] = iM73751f;
        iArr[1] = iM73750e;
    }

    /* renamed from: u2 */
    public final void m73740u2(C12258e[] c12258eArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        if (i10 == 0) {
            return;
        }
        if (this.f56839D1.size() == 0) {
            aVar = new a(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, i12);
            this.f56839D1.add(aVar);
        } else {
            a aVar2 = this.f56839D1.get(0);
            aVar2.m73748c();
            aVar = aVar2;
            aVar.m73755j(i11, this.f56734Q, this.f56736R, this.f56738S, this.f56740T, m73777E1(), m73779G1(), m73778F1(), m73776D1(), i12);
        }
        for (int i13 = 0; i13 < i10; i13++) {
            aVar.m73747b(c12258eArr[i13]);
        }
        iArr[0] = aVar.m73751f();
        iArr[1] = aVar.m73750e();
    }

    /* renamed from: v2 */
    public void m73741v2(float f10) {
        this.f56853s1 = f10;
    }

    /* renamed from: w2 */
    public void m73742w2(int i10) {
        this.f56847m1 = i10;
    }

    /* renamed from: x2 */
    public void m73743x2(float f10) {
        this.f56854t1 = f10;
    }

    /* renamed from: y2 */
    public void m73744y2(int i10) {
        this.f56848n1 = i10;
    }

    /* renamed from: z2 */
    public void m73745z2(int i10) {
        this.f56859y1 = i10;
    }
}
