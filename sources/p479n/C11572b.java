package p479n;

import java.util.ArrayList;
import p479n.C11574d;
import p479n.C11579i;

/* renamed from: n.b */
/* loaded from: classes.dex */
public class C11572b implements C11574d.a {

    /* renamed from: e */
    public a f53654e;

    /* renamed from: a */
    public C11579i f53650a = null;

    /* renamed from: b */
    public float f53651b = 0.0f;

    /* renamed from: c */
    public boolean f53652c = false;

    /* renamed from: d */
    public ArrayList<C11579i> f53653d = new ArrayList<>();

    /* renamed from: f */
    public boolean f53655f = false;

    /* renamed from: n.b$a */
    public interface a {
        /* renamed from: a */
        void mo69044a(C11579i c11579i, float f10, boolean z10);

        /* renamed from: b */
        float mo69045b(C11572b c11572b, boolean z10);

        /* renamed from: c */
        void mo69046c(C11579i c11579i, float f10);

        void clear();

        /* renamed from: d */
        int mo69047d();

        /* renamed from: e */
        float mo69048e(C11579i c11579i);

        /* renamed from: f */
        C11579i mo69049f(int i10);

        /* renamed from: g */
        void mo69050g();

        /* renamed from: h */
        float mo69051h(int i10);

        /* renamed from: i */
        boolean mo69052i(C11579i c11579i);

        /* renamed from: j */
        void mo69053j(float f10);

        /* renamed from: k */
        float mo69054k(C11579i c11579i, boolean z10);
    }

    public C11572b() {
    }

    /* renamed from: A */
    public void m69055A(C11574d c11574d, C11579i c11579i, boolean z10) {
        if (c11579i == null || !c11579i.f53704g) {
            return;
        }
        this.f53651b += c11579i.f53703f * this.f53654e.mo69048e(c11579i);
        this.f53654e.mo69054k(c11579i, z10);
        if (z10) {
            c11579i.m69131f(this);
        }
        if (C11574d.f53662u && this.f53654e.mo69047d() == 0) {
            this.f53655f = true;
            c11574d.f53668b = true;
        }
    }

    /* renamed from: B */
    public void mo69056B(C11574d c11574d, C11572b c11572b, boolean z10) {
        this.f53651b += c11572b.f53651b * this.f53654e.mo69045b(c11572b, z10);
        if (z10) {
            c11572b.f53650a.m69131f(this);
        }
        if (C11574d.f53662u && this.f53650a != null && this.f53654e.mo69047d() == 0) {
            this.f53655f = true;
            c11574d.f53668b = true;
        }
    }

    /* renamed from: C */
    public void m69057C(C11574d c11574d, C11579i c11579i, boolean z10) {
        if (c11579i == null || !c11579i.f53711n) {
            return;
        }
        float fMo69048e = this.f53654e.mo69048e(c11579i);
        this.f53651b += c11579i.f53713p * fMo69048e;
        this.f53654e.mo69054k(c11579i, z10);
        if (z10) {
            c11579i.m69131f(this);
        }
        this.f53654e.mo69044a(c11574d.f53681o.f53659d[c11579i.f53712o], fMo69048e, z10);
        if (C11574d.f53662u && this.f53654e.mo69047d() == 0) {
            this.f53655f = true;
            c11574d.f53668b = true;
        }
    }

    /* renamed from: D */
    public void m69058D(C11574d c11574d) {
        if (c11574d.f53674h.length == 0) {
            return;
        }
        boolean z10 = false;
        while (!z10) {
            int iMo69047d = this.f53654e.mo69047d();
            for (int i10 = 0; i10 < iMo69047d; i10++) {
                C11579i c11579iMo69049f = this.f53654e.mo69049f(i10);
                if (c11579iMo69049f.f53701d != -1 || c11579iMo69049f.f53704g || c11579iMo69049f.f53711n) {
                    this.f53653d.add(c11579iMo69049f);
                }
            }
            int size = this.f53653d.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    C11579i c11579i = this.f53653d.get(i11);
                    if (c11579i.f53704g) {
                        m69055A(c11574d, c11579i, true);
                    } else if (c11579i.f53711n) {
                        m69057C(c11574d, c11579i, true);
                    } else {
                        mo69056B(c11574d, c11574d.f53674h[c11579i.f53701d], true);
                    }
                }
                this.f53653d.clear();
            } else {
                z10 = true;
            }
        }
        if (C11574d.f53662u && this.f53650a != null && this.f53654e.mo69047d() == 0) {
            this.f53655f = true;
            c11574d.f53668b = true;
        }
    }

    @Override // p479n.C11574d.a
    /* renamed from: a */
    public void mo69059a(C11579i c11579i) {
        int i10 = c11579i.f53702e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f53654e.mo69046c(c11579i, f10);
    }

    @Override // p479n.C11574d.a
    /* renamed from: b */
    public C11579i mo69060b(C11574d c11574d, boolean[] zArr) {
        return m69081w(zArr, null);
    }

    @Override // p479n.C11574d.a
    /* renamed from: c */
    public void mo69061c(C11574d.a aVar) {
        if (aVar instanceof C11572b) {
            C11572b c11572b = (C11572b) aVar;
            this.f53650a = null;
            this.f53654e.clear();
            for (int i10 = 0; i10 < c11572b.f53654e.mo69047d(); i10++) {
                this.f53654e.mo69044a(c11572b.f53654e.mo69049f(i10), c11572b.f53654e.mo69051h(i10), true);
            }
        }
    }

    @Override // p479n.C11574d.a
    public void clear() {
        this.f53654e.clear();
        this.f53650a = null;
        this.f53651b = 0.0f;
    }

    /* renamed from: d */
    public C11572b m69062d(C11574d c11574d, int i10) {
        this.f53654e.mo69046c(c11574d.m69106o(i10, "ep"), 1.0f);
        this.f53654e.mo69046c(c11574d.m69106o(i10, "em"), -1.0f);
        return this;
    }

    /* renamed from: e */
    public C11572b m69063e(C11579i c11579i, int i10) {
        this.f53654e.mo69046c(c11579i, i10);
        return this;
    }

    /* renamed from: f */
    public boolean m69064f(C11574d c11574d) {
        boolean z10;
        C11579i c11579iM69065g = m69065g(c11574d);
        if (c11579iM69065g == null) {
            z10 = true;
        } else {
            m69082x(c11579iM69065g);
            z10 = false;
        }
        if (this.f53654e.mo69047d() == 0) {
            this.f53655f = true;
        }
        return z10;
    }

    /* renamed from: g */
    public C11579i m69065g(C11574d c11574d) {
        int iMo69047d = this.f53654e.mo69047d();
        C11579i c11579i = null;
        float f10 = 0.0f;
        float f11 = 0.0f;
        boolean z10 = false;
        boolean z11 = false;
        C11579i c11579i2 = null;
        for (int i10 = 0; i10 < iMo69047d; i10++) {
            float fMo69051h = this.f53654e.mo69051h(i10);
            C11579i c11579iMo69049f = this.f53654e.mo69049f(i10);
            if (c11579iMo69049f.f53707j == C11579i.a.UNRESTRICTED) {
                if (c11579i == null || f10 > fMo69051h) {
                    boolean zM69079u = m69079u(c11579iMo69049f, c11574d);
                    z10 = zM69079u;
                    f10 = fMo69051h;
                    c11579i = c11579iMo69049f;
                } else if (!z10 && m69079u(c11579iMo69049f, c11574d)) {
                    f10 = fMo69051h;
                    c11579i = c11579iMo69049f;
                    z10 = true;
                }
            } else if (c11579i == null && fMo69051h < 0.0f) {
                if (c11579i2 == null || f11 > fMo69051h) {
                    boolean zM69079u2 = m69079u(c11579iMo69049f, c11574d);
                    z11 = zM69079u2;
                    f11 = fMo69051h;
                    c11579i2 = c11579iMo69049f;
                } else if (!z11 && m69079u(c11579iMo69049f, c11574d)) {
                    f11 = fMo69051h;
                    c11579i2 = c11579iMo69049f;
                    z11 = true;
                }
            }
        }
        return c11579i != null ? c11579i : c11579i2;
    }

    @Override // p479n.C11574d.a
    public C11579i getKey() {
        return this.f53650a;
    }

    /* renamed from: h */
    public C11572b m69066h(C11579i c11579i, C11579i c11579i2, int i10, float f10, C11579i c11579i3, C11579i c11579i4, int i11) {
        if (c11579i2 == c11579i3) {
            this.f53654e.mo69046c(c11579i, 1.0f);
            this.f53654e.mo69046c(c11579i4, 1.0f);
            this.f53654e.mo69046c(c11579i2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f53654e.mo69046c(c11579i, 1.0f);
            this.f53654e.mo69046c(c11579i2, -1.0f);
            this.f53654e.mo69046c(c11579i3, -1.0f);
            this.f53654e.mo69046c(c11579i4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f53651b = (-i10) + i11;
            }
        } else if (f10 <= 0.0f) {
            this.f53654e.mo69046c(c11579i, -1.0f);
            this.f53654e.mo69046c(c11579i2, 1.0f);
            this.f53651b = i10;
        } else if (f10 >= 1.0f) {
            this.f53654e.mo69046c(c11579i4, -1.0f);
            this.f53654e.mo69046c(c11579i3, 1.0f);
            this.f53651b = -i11;
        } else {
            float f11 = 1.0f - f10;
            this.f53654e.mo69046c(c11579i, f11 * 1.0f);
            this.f53654e.mo69046c(c11579i2, f11 * (-1.0f));
            this.f53654e.mo69046c(c11579i3, (-1.0f) * f10);
            this.f53654e.mo69046c(c11579i4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f53651b = ((-i10) * f11) + (i11 * f10);
            }
        }
        return this;
    }

    /* renamed from: i */
    public C11572b m69067i(C11579i c11579i, int i10) {
        this.f53650a = c11579i;
        float f10 = i10;
        c11579i.f53703f = f10;
        this.f53651b = f10;
        this.f53655f = true;
        return this;
    }

    @Override // p479n.C11574d.a
    public boolean isEmpty() {
        return this.f53650a == null && this.f53651b == 0.0f && this.f53654e.mo69047d() == 0;
    }

    /* renamed from: j */
    public C11572b m69068j(C11579i c11579i, C11579i c11579i2, float f10) {
        this.f53654e.mo69046c(c11579i, -1.0f);
        this.f53654e.mo69046c(c11579i2, f10);
        return this;
    }

    /* renamed from: k */
    public C11572b m69069k(C11579i c11579i, C11579i c11579i2, C11579i c11579i3, C11579i c11579i4, float f10) {
        this.f53654e.mo69046c(c11579i, -1.0f);
        this.f53654e.mo69046c(c11579i2, 1.0f);
        this.f53654e.mo69046c(c11579i3, f10);
        this.f53654e.mo69046c(c11579i4, -f10);
        return this;
    }

    /* renamed from: l */
    public C11572b m69070l(float f10, float f11, float f12, C11579i c11579i, C11579i c11579i2, C11579i c11579i3, C11579i c11579i4) {
        this.f53651b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f53654e.mo69046c(c11579i, 1.0f);
            this.f53654e.mo69046c(c11579i2, -1.0f);
            this.f53654e.mo69046c(c11579i4, 1.0f);
            this.f53654e.mo69046c(c11579i3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f53654e.mo69046c(c11579i, 1.0f);
            this.f53654e.mo69046c(c11579i2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f53654e.mo69046c(c11579i3, 1.0f);
            this.f53654e.mo69046c(c11579i4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f53654e.mo69046c(c11579i, 1.0f);
            this.f53654e.mo69046c(c11579i2, -1.0f);
            this.f53654e.mo69046c(c11579i4, f13);
            this.f53654e.mo69046c(c11579i3, -f13);
        }
        return this;
    }

    /* renamed from: m */
    public C11572b m69071m(C11579i c11579i, int i10) {
        if (i10 < 0) {
            this.f53651b = i10 * (-1);
            this.f53654e.mo69046c(c11579i, 1.0f);
        } else {
            this.f53651b = i10;
            this.f53654e.mo69046c(c11579i, -1.0f);
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x001e  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p479n.C11572b m69072n(p479n.C11579i r4, p479n.C11579i r5, int r6) {
        /*
            r3 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r6 == 0) goto L1e
            if (r6 >= 0) goto Lc
            int r6 = r6 * (-1)
            r2 = 1
            goto Ld
        Lc:
            r2 = 0
        Ld:
            float r6 = (float) r6
            r3.f53651b = r6
            if (r2 != 0) goto L13
            goto L1e
        L13:
            n.b$a r6 = r3.f53654e
            r6.mo69046c(r4, r0)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r5, r1)
            goto L28
        L1e:
            n.b$a r6 = r3.f53654e
            r6.mo69046c(r4, r1)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r5, r0)
        L28:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p479n.C11572b.m69072n(n.i, n.i, int):n.b");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0023  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p479n.C11572b m69073o(p479n.C11579i r4, p479n.C11579i r5, p479n.C11579i r6, int r7) {
        /*
            r3 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r7 == 0) goto L23
            if (r7 >= 0) goto Lc
            int r7 = r7 * (-1)
            r2 = 1
            goto Ld
        Lc:
            r2 = 0
        Ld:
            float r7 = (float) r7
            r3.f53651b = r7
            if (r2 != 0) goto L13
            goto L23
        L13:
            n.b$a r7 = r3.f53654e
            r7.mo69046c(r4, r0)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r5, r1)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r6, r1)
            goto L32
        L23:
            n.b$a r7 = r3.f53654e
            r7.mo69046c(r4, r1)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r5, r0)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r6, r0)
        L32:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p479n.C11572b.m69073o(n.i, n.i, n.i, int):n.b");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0023  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p479n.C11572b m69074p(p479n.C11579i r4, p479n.C11579i r5, p479n.C11579i r6, int r7) {
        /*
            r3 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r7 == 0) goto L23
            if (r7 >= 0) goto Lc
            int r7 = r7 * (-1)
            r2 = 1
            goto Ld
        Lc:
            r2 = 0
        Ld:
            float r7 = (float) r7
            r3.f53651b = r7
            if (r2 != 0) goto L13
            goto L23
        L13:
            n.b$a r7 = r3.f53654e
            r7.mo69046c(r4, r0)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r5, r1)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r6, r0)
            goto L32
        L23:
            n.b$a r7 = r3.f53654e
            r7.mo69046c(r4, r1)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r5, r0)
            n.b$a r4 = r3.f53654e
            r4.mo69046c(r6, r1)
        L32:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p479n.C11572b.m69074p(n.i, n.i, n.i, int):n.b");
    }

    /* renamed from: q */
    public C11572b m69075q(C11579i c11579i, C11579i c11579i2, C11579i c11579i3, C11579i c11579i4, float f10) {
        this.f53654e.mo69046c(c11579i3, 0.5f);
        this.f53654e.mo69046c(c11579i4, 0.5f);
        this.f53654e.mo69046c(c11579i, -0.5f);
        this.f53654e.mo69046c(c11579i2, -0.5f);
        this.f53651b = -f10;
        return this;
    }

    /* renamed from: r */
    public void m69076r() {
        float f10 = this.f53651b;
        if (f10 < 0.0f) {
            this.f53651b = f10 * (-1.0f);
            this.f53654e.mo69050g();
        }
    }

    /* renamed from: s */
    public boolean m69077s() {
        C11579i c11579i = this.f53650a;
        return c11579i != null && (c11579i.f53707j == C11579i.a.UNRESTRICTED || this.f53651b >= 0.0f);
    }

    /* renamed from: t */
    public boolean m69078t(C11579i c11579i) {
        return this.f53654e.mo69052i(c11579i);
    }

    public String toString() {
        return m69084z();
    }

    /* renamed from: u */
    public final boolean m69079u(C11579i c11579i, C11574d c11574d) {
        return c11579i.f53710m <= 1;
    }

    /* renamed from: v */
    public C11579i m69080v(C11579i c11579i) {
        return m69081w(null, c11579i);
    }

    /* renamed from: w */
    public final C11579i m69081w(boolean[] zArr, C11579i c11579i) {
        C11579i.a aVar;
        int iMo69047d = this.f53654e.mo69047d();
        C11579i c11579i2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < iMo69047d; i10++) {
            float fMo69051h = this.f53654e.mo69051h(i10);
            if (fMo69051h < 0.0f) {
                C11579i c11579iMo69049f = this.f53654e.mo69049f(i10);
                if ((zArr == null || !zArr[c11579iMo69049f.f53700c]) && c11579iMo69049f != c11579i && (((aVar = c11579iMo69049f.f53707j) == C11579i.a.SLACK || aVar == C11579i.a.ERROR) && fMo69051h < f10)) {
                    f10 = fMo69051h;
                    c11579i2 = c11579iMo69049f;
                }
            }
        }
        return c11579i2;
    }

    /* renamed from: x */
    public void m69082x(C11579i c11579i) {
        C11579i c11579i2 = this.f53650a;
        if (c11579i2 != null) {
            this.f53654e.mo69046c(c11579i2, -1.0f);
            this.f53650a.f53701d = -1;
            this.f53650a = null;
        }
        float fMo69054k = this.f53654e.mo69054k(c11579i, true) * (-1.0f);
        this.f53650a = c11579i;
        if (fMo69054k == 1.0f) {
            return;
        }
        this.f53651b /= fMo69054k;
        this.f53654e.mo69053j(fMo69054k);
    }

    /* renamed from: y */
    public void m69083y() {
        this.f53650a = null;
        this.f53654e.clear();
        this.f53651b = 0.0f;
        this.f53655f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d0  */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m69084z() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p479n.C11572b.m69084z():java.lang.String");
    }

    public C11572b(C11573c c11573c) {
        this.f53654e = new C11571a(this, c11573c);
    }
}
