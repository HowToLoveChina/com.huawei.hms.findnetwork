package p596r;

import java.util.ArrayList;
import java.util.Iterator;
import p561q.C12254a;
import p561q.C12257d;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12261h;
import p596r.C12435b;

/* renamed from: r.h */
/* loaded from: classes.dex */
public class C12441h {

    /* renamed from: a */
    public static C12435b.a f57327a = new C12435b.a();

    /* renamed from: b */
    public static int f57328b = 0;

    /* renamed from: c */
    public static int f57329c = 0;

    /* renamed from: a */
    public static boolean m74661a(int i10, C12258e c12258e) {
        C12258e.b bVar;
        C12258e.b bVar2;
        C12258e.b bVarM73550C = c12258e.m73550C();
        C12258e.b bVarM73588V = c12258e.m73588V();
        C12259f c12259f = c12258e.m73570M() != null ? (C12259f) c12258e.m73570M() : null;
        if (c12259f != null) {
            c12259f.m73550C();
            C12258e.b bVar3 = C12258e.b.FIXED;
        }
        if (c12259f != null) {
            c12259f.m73588V();
            C12258e.b bVar4 = C12258e.b.FIXED;
        }
        C12258e.b bVar5 = C12258e.b.FIXED;
        boolean z10 = bVarM73550C == bVar5 || c12258e.mo73515p0() || bVarM73550C == C12258e.b.WRAP_CONTENT || (bVarM73550C == (bVar2 = C12258e.b.MATCH_CONSTRAINT) && c12258e.f56792w == 0 && c12258e.f56759f0 == 0.0f && c12258e.m73602c0(0)) || (bVarM73550C == bVar2 && c12258e.f56792w == 1 && c12258e.m73611f0(0, c12258e.m73594Y()));
        boolean z11 = bVarM73588V == bVar5 || c12258e.mo73516q0() || bVarM73588V == C12258e.b.WRAP_CONTENT || (bVarM73588V == (bVar = C12258e.b.MATCH_CONSTRAINT) && c12258e.f56794x == 0 && c12258e.f56759f0 == 0.0f && c12258e.m73602c0(1)) || (bVarM73588V == bVar && c12258e.f56794x == 1 && c12258e.m73611f0(1, c12258e.m73662z()));
        if (c12258e.f56759f0 <= 0.0f || !(z10 || z11)) {
            return z10 && z11;
        }
        return true;
    }

    /* renamed from: b */
    public static void m74662b(int i10, C12258e c12258e, C12435b.b bVar, boolean z10) {
        C12257d c12257d;
        C12257d c12257d2;
        C12257d c12257d3;
        C12257d c12257d4;
        if (c12258e.m73618i0()) {
            return;
        }
        boolean z11 = true;
        f57328b++;
        if (!(c12258e instanceof C12259f) && c12258e.m73635o0()) {
            int i11 = i10 + 1;
            if (m74661a(i11, c12258e)) {
                C12259f.m73665Y1(i11, c12258e, bVar, new C12435b.a(), C12435b.a.f57281k);
            }
        }
        C12257d c12257dMo73639q = c12258e.mo73639q(C12257d.a.LEFT);
        C12257d c12257dMo73639q2 = c12258e.mo73639q(C12257d.a.RIGHT);
        int iM73528e = c12257dMo73639q.m73528e();
        int iM73528e2 = c12257dMo73639q2.m73528e();
        if (c12257dMo73639q.m73527d() != null && c12257dMo73639q.m73537n()) {
            Iterator<C12257d> it = c12257dMo73639q.m73527d().iterator();
            while (it.hasNext()) {
                C12257d next = it.next();
                C12258e c12258e2 = next.f56685d;
                int i12 = i10 + 1;
                boolean zM74661a = m74661a(i12, c12258e2);
                if (c12258e2.m73635o0() && zM74661a) {
                    C12259f.m73665Y1(i12, c12258e2, bVar, new C12435b.a(), C12435b.a.f57281k);
                }
                boolean z12 = ((next == c12258e2.f56734Q && (c12257d4 = c12258e2.f56738S.f56687f) != null && c12257d4.m73537n()) || (next == c12258e2.f56738S && (c12257d3 = c12258e2.f56734Q.f56687f) != null && c12257d3.m73537n())) ? z11 : false;
                C12258e.b bVarM73550C = c12258e2.m73550C();
                C12258e.b bVar2 = C12258e.b.MATCH_CONSTRAINT;
                if (bVarM73550C != bVar2 || zM74661a) {
                    if (!c12258e2.m73635o0()) {
                        C12257d c12257d5 = c12258e2.f56734Q;
                        if (next == c12257d5 && c12258e2.f56738S.f56687f == null) {
                            int iM73529f = c12257d5.m73529f() + iM73528e;
                            c12258e2.m73567K0(iM73529f, c12258e2.m73594Y() + iM73529f);
                            m74662b(i12, c12258e2, bVar, z10);
                        } else {
                            C12257d c12257d6 = c12258e2.f56738S;
                            if (next == c12257d6 && c12257d5.f56687f == null) {
                                int iM73529f2 = iM73528e - c12257d6.m73529f();
                                c12258e2.m73567K0(iM73529f2 - c12258e2.m73594Y(), iM73529f2);
                                m74662b(i12, c12258e2, bVar, z10);
                            } else if (z12 && !c12258e2.m73624k0()) {
                                m74664d(i12, bVar, c12258e2, z10);
                            }
                        }
                    }
                } else if (c12258e2.m73550C() == bVar2 && c12258e2.f56702A >= 0 && c12258e2.f56798z >= 0 && ((c12258e2.m73592X() == 8 || (c12258e2.f56792w == 0 && c12258e2.m73658x() == 0.0f)) && !c12258e2.m73624k0() && !c12258e2.m73632n0() && z12 && !c12258e2.m73624k0())) {
                    m74665e(i12, c12258e, bVar, c12258e2, z10);
                }
                z11 = true;
            }
        }
        if (c12258e instanceof C12261h) {
            return;
        }
        if (c12257dMo73639q2.m73527d() != null && c12257dMo73639q2.m73537n()) {
            Iterator<C12257d> it2 = c12257dMo73639q2.m73527d().iterator();
            while (it2.hasNext()) {
                C12257d next2 = it2.next();
                C12258e c12258e3 = next2.f56685d;
                int i13 = i10 + 1;
                boolean zM74661a2 = m74661a(i13, c12258e3);
                if (c12258e3.m73635o0() && zM74661a2) {
                    C12259f.m73665Y1(i13, c12258e3, bVar, new C12435b.a(), C12435b.a.f57281k);
                }
                boolean z13 = (next2 == c12258e3.f56734Q && (c12257d2 = c12258e3.f56738S.f56687f) != null && c12257d2.m73537n()) || (next2 == c12258e3.f56738S && (c12257d = c12258e3.f56734Q.f56687f) != null && c12257d.m73537n());
                C12258e.b bVarM73550C2 = c12258e3.m73550C();
                C12258e.b bVar3 = C12258e.b.MATCH_CONSTRAINT;
                if (bVarM73550C2 != bVar3 || zM74661a2) {
                    if (!c12258e3.m73635o0()) {
                        C12257d c12257d7 = c12258e3.f56734Q;
                        if (next2 == c12257d7 && c12258e3.f56738S.f56687f == null) {
                            int iM73529f3 = c12257d7.m73529f() + iM73528e2;
                            c12258e3.m73567K0(iM73529f3, c12258e3.m73594Y() + iM73529f3);
                            m74662b(i13, c12258e3, bVar, z10);
                        } else {
                            C12257d c12257d8 = c12258e3.f56738S;
                            if (next2 == c12257d8 && c12257d7.f56687f == null) {
                                int iM73529f4 = iM73528e2 - c12257d8.m73529f();
                                c12258e3.m73567K0(iM73529f4 - c12258e3.m73594Y(), iM73529f4);
                                m74662b(i13, c12258e3, bVar, z10);
                            } else if (z13 && !c12258e3.m73624k0()) {
                                m74664d(i13, bVar, c12258e3, z10);
                            }
                        }
                    }
                } else if (c12258e3.m73550C() == bVar3 && c12258e3.f56702A >= 0 && c12258e3.f56798z >= 0 && (c12258e3.m73592X() == 8 || (c12258e3.f56792w == 0 && c12258e3.m73658x() == 0.0f))) {
                    if (!c12258e3.m73624k0() && !c12258e3.m73632n0() && z13 && !c12258e3.m73624k0()) {
                        m74665e(i13, c12258e, bVar, c12258e3, z10);
                    }
                }
            }
        }
        c12258e.m73645s0();
    }

    /* renamed from: c */
    public static void m74663c(int i10, C12254a c12254a, C12435b.b bVar, int i11, boolean z10) {
        if (c12254a.m73517y1()) {
            if (i11 == 0) {
                m74662b(i10 + 1, c12254a, bVar, z10);
            } else {
                m74669i(i10 + 1, c12254a, bVar);
            }
        }
    }

    /* renamed from: d */
    public static void m74664d(int i10, C12435b.b bVar, C12258e c12258e, boolean z10) {
        float fM73546A = c12258e.m73546A();
        int iM73528e = c12258e.f56734Q.f56687f.m73528e();
        int iM73528e2 = c12258e.f56738S.f56687f.m73528e();
        int iM73529f = c12258e.f56734Q.m73529f() + iM73528e;
        int iM73529f2 = iM73528e2 - c12258e.f56738S.m73529f();
        if (iM73528e == iM73528e2) {
            fM73546A = 0.5f;
        } else {
            iM73528e = iM73529f;
            iM73528e2 = iM73529f2;
        }
        int iM73594Y = c12258e.m73594Y();
        int i11 = (iM73528e2 - iM73528e) - iM73594Y;
        if (iM73528e > iM73528e2) {
            i11 = (iM73528e - iM73528e2) - iM73594Y;
        }
        int i12 = ((int) (i11 > 0 ? (fM73546A * i11) + 0.5f : fM73546A * i11)) + iM73528e;
        int i13 = i12 + iM73594Y;
        if (iM73528e > iM73528e2) {
            i13 = i12 - iM73594Y;
        }
        c12258e.m73567K0(i12, i13);
        m74662b(i10 + 1, c12258e, bVar, z10);
    }

    /* renamed from: e */
    public static void m74665e(int i10, C12258e c12258e, C12435b.b bVar, C12258e c12258e2, boolean z10) {
        float fM73546A = c12258e2.m73546A();
        int iM73528e = c12258e2.f56734Q.f56687f.m73528e() + c12258e2.f56734Q.m73529f();
        int iM73528e2 = c12258e2.f56738S.f56687f.m73528e() - c12258e2.f56738S.m73529f();
        if (iM73528e2 >= iM73528e) {
            int iM73594Y = c12258e2.m73594Y();
            if (c12258e2.m73592X() != 8) {
                int i11 = c12258e2.f56792w;
                if (i11 == 2) {
                    iM73594Y = (int) (c12258e2.m73546A() * 0.5f * (c12258e instanceof C12259f ? c12258e.m73594Y() : c12258e.m73570M().m73594Y()));
                } else if (i11 == 0) {
                    iM73594Y = iM73528e2 - iM73528e;
                }
                iM73594Y = Math.max(c12258e2.f56798z, iM73594Y);
                int i12 = c12258e2.f56702A;
                if (i12 > 0) {
                    iM73594Y = Math.min(i12, iM73594Y);
                }
            }
            int i13 = iM73528e + ((int) ((fM73546A * ((iM73528e2 - iM73528e) - iM73594Y)) + 0.5f));
            c12258e2.m73567K0(i13, iM73594Y + i13);
            m74662b(i10 + 1, c12258e2, bVar, z10);
        }
    }

    /* renamed from: f */
    public static void m74666f(int i10, C12435b.b bVar, C12258e c12258e) {
        float fM73584T = c12258e.m73584T();
        int iM73528e = c12258e.f56736R.f56687f.m73528e();
        int iM73528e2 = c12258e.f56740T.f56687f.m73528e();
        int iM73529f = c12258e.f56736R.m73529f() + iM73528e;
        int iM73529f2 = iM73528e2 - c12258e.f56740T.m73529f();
        if (iM73528e == iM73528e2) {
            fM73584T = 0.5f;
        } else {
            iM73528e = iM73529f;
            iM73528e2 = iM73529f2;
        }
        int iM73662z = c12258e.m73662z();
        int i11 = (iM73528e2 - iM73528e) - iM73662z;
        if (iM73528e > iM73528e2) {
            i11 = (iM73528e - iM73528e2) - iM73662z;
        }
        int i12 = (int) (i11 > 0 ? (fM73584T * i11) + 0.5f : fM73584T * i11);
        int i13 = iM73528e + i12;
        int i14 = i13 + iM73662z;
        if (iM73528e > iM73528e2) {
            i13 = iM73528e - i12;
            i14 = i13 - iM73662z;
        }
        c12258e.m73573N0(i13, i14);
        m74669i(i10 + 1, c12258e, bVar);
    }

    /* renamed from: g */
    public static void m74667g(int i10, C12258e c12258e, C12435b.b bVar, C12258e c12258e2) {
        float fM73584T = c12258e2.m73584T();
        int iM73528e = c12258e2.f56736R.f56687f.m73528e() + c12258e2.f56736R.m73529f();
        int iM73528e2 = c12258e2.f56740T.f56687f.m73528e() - c12258e2.f56740T.m73529f();
        if (iM73528e2 >= iM73528e) {
            int iM73662z = c12258e2.m73662z();
            if (c12258e2.m73592X() != 8) {
                int i11 = c12258e2.f56794x;
                if (i11 == 2) {
                    iM73662z = (int) (fM73584T * 0.5f * (c12258e instanceof C12259f ? c12258e.m73662z() : c12258e.m73570M().m73662z()));
                } else if (i11 == 0) {
                    iM73662z = iM73528e2 - iM73528e;
                }
                iM73662z = Math.max(c12258e2.f56706C, iM73662z);
                int i12 = c12258e2.f56708D;
                if (i12 > 0) {
                    iM73662z = Math.min(i12, iM73662z);
                }
            }
            int i13 = iM73528e + ((int) ((fM73584T * ((iM73528e2 - iM73528e) - iM73662z)) + 0.5f));
            c12258e2.m73573N0(i13, iM73662z + i13);
            m74669i(i10 + 1, c12258e2, bVar);
        }
    }

    /* renamed from: h */
    public static void m74668h(C12259f c12259f, C12435b.b bVar) {
        C12258e.b bVarM73550C = c12259f.m73550C();
        C12258e.b bVarM73588V = c12259f.m73588V();
        f57328b = 0;
        f57329c = 0;
        c12259f.m73661y0();
        ArrayList<C12258e> arrayListM73795w1 = c12259f.m73795w1();
        int size = arrayListM73795w1.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayListM73795w1.get(i10).m73661y0();
        }
        boolean zM73687V1 = c12259f.m73687V1();
        if (bVarM73550C == C12258e.b.FIXED) {
            c12259f.m73567K0(0, c12259f.m73594Y());
        } else {
            c12259f.m73569L0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            C12258e c12258e = arrayListM73795w1.get(i11);
            if (c12258e instanceof C12261h) {
                C12261h c12261h = (C12261h) c12258e;
                if (c12261h.m73763x1() == 1) {
                    if (c12261h.m73764y1() != -1) {
                        c12261h.m73757B1(c12261h.m73764y1());
                    } else if (c12261h.m73765z1() != -1 && c12259f.mo73515p0()) {
                        c12261h.m73757B1(c12259f.m73594Y() - c12261h.m73765z1());
                    } else if (c12259f.mo73515p0()) {
                        c12261h.m73757B1((int) ((c12261h.m73756A1() * c12259f.m73594Y()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((c12258e instanceof C12254a) && ((C12254a) c12258e).m73507C1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                C12258e c12258e2 = arrayListM73795w1.get(i12);
                if (c12258e2 instanceof C12261h) {
                    C12261h c12261h2 = (C12261h) c12258e2;
                    if (c12261h2.m73763x1() == 1) {
                        m74662b(0, c12261h2, bVar, zM73687V1);
                    }
                }
            }
        }
        m74662b(0, c12259f, bVar, zM73687V1);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                C12258e c12258e3 = arrayListM73795w1.get(i13);
                if (c12258e3 instanceof C12254a) {
                    C12254a c12254a = (C12254a) c12258e3;
                    if (c12254a.m73507C1() == 0) {
                        m74663c(0, c12254a, bVar, 0, zM73687V1);
                    }
                }
            }
        }
        if (bVarM73588V == C12258e.b.FIXED) {
            c12259f.m73573N0(0, c12259f.m73662z());
        } else {
            c12259f.m73571M0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            C12258e c12258e4 = arrayListM73795w1.get(i14);
            if (c12258e4 instanceof C12261h) {
                C12261h c12261h3 = (C12261h) c12258e4;
                if (c12261h3.m73763x1() == 0) {
                    if (c12261h3.m73764y1() != -1) {
                        c12261h3.m73757B1(c12261h3.m73764y1());
                    } else if (c12261h3.m73765z1() != -1 && c12259f.mo73516q0()) {
                        c12261h3.m73757B1(c12259f.m73662z() - c12261h3.m73765z1());
                    } else if (c12259f.mo73516q0()) {
                        c12261h3.m73757B1((int) ((c12261h3.m73756A1() * c12259f.m73662z()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((c12258e4 instanceof C12254a) && ((C12254a) c12258e4).m73507C1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                C12258e c12258e5 = arrayListM73795w1.get(i15);
                if (c12258e5 instanceof C12261h) {
                    C12261h c12261h4 = (C12261h) c12258e5;
                    if (c12261h4.m73763x1() == 0) {
                        m74669i(1, c12261h4, bVar);
                    }
                }
            }
        }
        m74669i(0, c12259f, bVar);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                C12258e c12258e6 = arrayListM73795w1.get(i16);
                if (c12258e6 instanceof C12254a) {
                    C12254a c12254a2 = (C12254a) c12258e6;
                    if (c12254a2.m73507C1() == 1) {
                        m74663c(0, c12254a2, bVar, 1, zM73687V1);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            C12258e c12258e7 = arrayListM73795w1.get(i17);
            if (c12258e7.m73635o0() && m74661a(0, c12258e7)) {
                C12259f.m73665Y1(0, c12258e7, bVar, f57327a, C12435b.a.f57281k);
                if (!(c12258e7 instanceof C12261h)) {
                    m74662b(0, c12258e7, bVar, zM73687V1);
                    m74669i(0, c12258e7, bVar);
                } else if (((C12261h) c12258e7).m73763x1() == 0) {
                    m74669i(0, c12258e7, bVar);
                } else {
                    m74662b(0, c12258e7, bVar, zM73687V1);
                }
            }
        }
    }

    /* renamed from: i */
    public static void m74669i(int i10, C12258e c12258e, C12435b.b bVar) {
        C12257d c12257d;
        C12257d c12257d2;
        C12257d c12257d3;
        C12257d c12257d4;
        if (c12258e.m73642r0()) {
            return;
        }
        f57329c++;
        if (!(c12258e instanceof C12259f) && c12258e.m73635o0()) {
            int i11 = i10 + 1;
            if (m74661a(i11, c12258e)) {
                C12259f.m73665Y1(i11, c12258e, bVar, new C12435b.a(), C12435b.a.f57281k);
            }
        }
        C12257d c12257dMo73639q = c12258e.mo73639q(C12257d.a.TOP);
        C12257d c12257dMo73639q2 = c12258e.mo73639q(C12257d.a.BOTTOM);
        int iM73528e = c12257dMo73639q.m73528e();
        int iM73528e2 = c12257dMo73639q2.m73528e();
        if (c12257dMo73639q.m73527d() != null && c12257dMo73639q.m73537n()) {
            Iterator<C12257d> it = c12257dMo73639q.m73527d().iterator();
            while (it.hasNext()) {
                C12257d next = it.next();
                C12258e c12258e2 = next.f56685d;
                int i12 = i10 + 1;
                boolean zM74661a = m74661a(i12, c12258e2);
                if (c12258e2.m73635o0() && zM74661a) {
                    C12259f.m73665Y1(i12, c12258e2, bVar, new C12435b.a(), C12435b.a.f57281k);
                }
                boolean z10 = (next == c12258e2.f56736R && (c12257d4 = c12258e2.f56740T.f56687f) != null && c12257d4.m73537n()) || (next == c12258e2.f56740T && (c12257d3 = c12258e2.f56736R.f56687f) != null && c12257d3.m73537n());
                C12258e.b bVarM73588V = c12258e2.m73588V();
                C12258e.b bVar2 = C12258e.b.MATCH_CONSTRAINT;
                if (bVarM73588V != bVar2 || zM74661a) {
                    if (!c12258e2.m73635o0()) {
                        C12257d c12257d5 = c12258e2.f56736R;
                        if (next == c12257d5 && c12258e2.f56740T.f56687f == null) {
                            int iM73529f = c12257d5.m73529f() + iM73528e;
                            c12258e2.m73573N0(iM73529f, c12258e2.m73662z() + iM73529f);
                            m74669i(i12, c12258e2, bVar);
                        } else {
                            C12257d c12257d6 = c12258e2.f56740T;
                            if (next == c12257d6 && c12257d5.f56687f == null) {
                                int iM73529f2 = iM73528e - c12257d6.m73529f();
                                c12258e2.m73573N0(iM73529f2 - c12258e2.m73662z(), iM73529f2);
                                m74669i(i12, c12258e2, bVar);
                            } else if (z10 && !c12258e2.m73630m0()) {
                                m74666f(i12, bVar, c12258e2);
                            }
                        }
                    }
                } else if (c12258e2.m73588V() == bVar2 && c12258e2.f56708D >= 0 && c12258e2.f56706C >= 0 && (c12258e2.m73592X() == 8 || (c12258e2.f56794x == 0 && c12258e2.m73658x() == 0.0f))) {
                    if (!c12258e2.m73630m0() && !c12258e2.m73632n0() && z10 && !c12258e2.m73630m0()) {
                        m74667g(i12, c12258e, bVar, c12258e2);
                    }
                }
            }
        }
        if (c12258e instanceof C12261h) {
            return;
        }
        if (c12257dMo73639q2.m73527d() != null && c12257dMo73639q2.m73537n()) {
            Iterator<C12257d> it2 = c12257dMo73639q2.m73527d().iterator();
            while (it2.hasNext()) {
                C12257d next2 = it2.next();
                C12258e c12258e3 = next2.f56685d;
                int i13 = i10 + 1;
                boolean zM74661a2 = m74661a(i13, c12258e3);
                if (c12258e3.m73635o0() && zM74661a2) {
                    C12259f.m73665Y1(i13, c12258e3, bVar, new C12435b.a(), C12435b.a.f57281k);
                }
                boolean z11 = (next2 == c12258e3.f56736R && (c12257d2 = c12258e3.f56740T.f56687f) != null && c12257d2.m73537n()) || (next2 == c12258e3.f56740T && (c12257d = c12258e3.f56736R.f56687f) != null && c12257d.m73537n());
                C12258e.b bVarM73588V2 = c12258e3.m73588V();
                C12258e.b bVar3 = C12258e.b.MATCH_CONSTRAINT;
                if (bVarM73588V2 != bVar3 || zM74661a2) {
                    if (!c12258e3.m73635o0()) {
                        C12257d c12257d7 = c12258e3.f56736R;
                        if (next2 == c12257d7 && c12258e3.f56740T.f56687f == null) {
                            int iM73529f3 = c12257d7.m73529f() + iM73528e2;
                            c12258e3.m73573N0(iM73529f3, c12258e3.m73662z() + iM73529f3);
                            m74669i(i13, c12258e3, bVar);
                        } else {
                            C12257d c12257d8 = c12258e3.f56740T;
                            if (next2 == c12257d8 && c12257d7.f56687f == null) {
                                int iM73529f4 = iM73528e2 - c12257d8.m73529f();
                                c12258e3.m73573N0(iM73529f4 - c12258e3.m73662z(), iM73529f4);
                                m74669i(i13, c12258e3, bVar);
                            } else if (z11 && !c12258e3.m73630m0()) {
                                m74666f(i13, bVar, c12258e3);
                            }
                        }
                    }
                } else if (c12258e3.m73588V() == bVar3 && c12258e3.f56708D >= 0 && c12258e3.f56706C >= 0 && (c12258e3.m73592X() == 8 || (c12258e3.f56794x == 0 && c12258e3.m73658x() == 0.0f))) {
                    if (!c12258e3.m73630m0() && !c12258e3.m73632n0() && z11 && !c12258e3.m73630m0()) {
                        m74667g(i13, c12258e, bVar, c12258e3);
                    }
                }
            }
        }
        C12257d c12257dMo73639q3 = c12258e.mo73639q(C12257d.a.BASELINE);
        if (c12257dMo73639q3.m73527d() != null && c12257dMo73639q3.m73537n()) {
            int iM73528e3 = c12257dMo73639q3.m73528e();
            Iterator<C12257d> it3 = c12257dMo73639q3.m73527d().iterator();
            while (it3.hasNext()) {
                C12257d next3 = it3.next();
                C12258e c12258e4 = next3.f56685d;
                int i14 = i10 + 1;
                boolean zM74661a3 = m74661a(i14, c12258e4);
                if (c12258e4.m73635o0() && zM74661a3) {
                    C12259f.m73665Y1(i14, c12258e4, bVar, new C12435b.a(), C12435b.a.f57281k);
                }
                if (c12258e4.m73588V() != C12258e.b.MATCH_CONSTRAINT || zM74661a3) {
                    if (!c12258e4.m73635o0() && next3 == c12258e4.f56742U) {
                        c12258e4.m73565J0(next3.m73529f() + iM73528e3);
                        m74669i(i14, c12258e4, bVar);
                    }
                }
            }
        }
        c12258e.m73648t0();
    }
}
