package p596r;

import java.util.ArrayList;
import p479n.C11574d;
import p561q.C12257d;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12261h;
import p561q.C12264k;
import p561q.C12266m;
import p561q.InterfaceC12262i;

/* renamed from: r.b */
/* loaded from: classes.dex */
public class C12435b {

    /* renamed from: a */
    public final ArrayList<C12258e> f57278a = new ArrayList<>();

    /* renamed from: b */
    public a f57279b = new a();

    /* renamed from: c */
    public C12259f f57280c;

    /* renamed from: r.b$a */
    public static class a {

        /* renamed from: k */
        public static int f57281k = 0;

        /* renamed from: l */
        public static int f57282l = 1;

        /* renamed from: m */
        public static int f57283m = 2;

        /* renamed from: a */
        public C12258e.b f57284a;

        /* renamed from: b */
        public C12258e.b f57285b;

        /* renamed from: c */
        public int f57286c;

        /* renamed from: d */
        public int f57287d;

        /* renamed from: e */
        public int f57288e;

        /* renamed from: f */
        public int f57289f;

        /* renamed from: g */
        public int f57290g;

        /* renamed from: h */
        public boolean f57291h;

        /* renamed from: i */
        public boolean f57292i;

        /* renamed from: j */
        public int f57293j;
    }

    /* renamed from: r.b$b */
    public interface b {
        /* renamed from: a */
        void mo3571a();

        /* renamed from: b */
        void mo3572b(C12258e c12258e, a aVar);
    }

    public C12435b(C12259f c12259f) {
        this.f57280c = c12259f;
    }

    /* renamed from: a */
    public final boolean m74629a(b bVar, C12258e c12258e, int i10) {
        this.f57279b.f57284a = c12258e.m73550C();
        this.f57279b.f57285b = c12258e.m73588V();
        this.f57279b.f57286c = c12258e.m73594Y();
        this.f57279b.f57287d = c12258e.m73662z();
        a aVar = this.f57279b;
        aVar.f57292i = false;
        aVar.f57293j = i10;
        C12258e.b bVar2 = aVar.f57284a;
        C12258e.b bVar3 = C12258e.b.MATCH_CONSTRAINT;
        boolean z10 = bVar2 == bVar3;
        boolean z11 = aVar.f57285b == bVar3;
        boolean z12 = z10 && c12258e.f56759f0 > 0.0f;
        boolean z13 = z11 && c12258e.f56759f0 > 0.0f;
        if (z12 && c12258e.f56796y[0] == 4) {
            aVar.f57284a = C12258e.b.FIXED;
        }
        if (z13 && c12258e.f56796y[1] == 4) {
            aVar.f57285b = C12258e.b.FIXED;
        }
        bVar.mo3572b(c12258e, aVar);
        c12258e.m73638p1(this.f57279b.f57288e);
        c12258e.m73579Q0(this.f57279b.f57289f);
        c12258e.m73577P0(this.f57279b.f57291h);
        c12258e.m73557F0(this.f57279b.f57290g);
        a aVar2 = this.f57279b;
        aVar2.f57293j = a.f57281k;
        return aVar2.f57292i;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00a2 A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m74630b(p561q.C12259f r13) {
        /*
            r12 = this;
            java.util.ArrayList<q.e> r0 = r13.f56904V0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.m73690Z1(r1)
            r.b$b r2 = r13.m73680O1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto La6
            java.util.ArrayList<q.e> r5 = r13.f56904V0
            java.lang.Object r5 = r5.get(r4)
            q.e r5 = (p561q.C12258e) r5
            boolean r6 = r5 instanceof p561q.C12261h
            if (r6 == 0) goto L22
            goto La2
        L22:
            boolean r6 = r5 instanceof p561q.C12254a
            if (r6 == 0) goto L28
            goto La2
        L28:
            boolean r6 = r5.m73632n0()
            if (r6 == 0) goto L30
            goto La2
        L30:
            if (r1 == 0) goto L48
            r.l r6 = r5.f56756e
            if (r6 == 0) goto L48
            r.n r7 = r5.f56758f
            if (r7 == 0) goto L48
            r.g r6 = r6.f57361e
            boolean r6 = r6.f57314j
            if (r6 == 0) goto L48
            r.g r6 = r7.f57361e
            boolean r6 = r6.f57314j
            if (r6 == 0) goto L48
            goto La2
        L48:
            q.e$b r6 = r5.m73656w(r3)
            r7 = 1
            q.e$b r8 = r5.m73656w(r7)
            q.e$b r9 = p561q.C12258e.b.MATCH_CONSTRAINT
            if (r6 != r9) goto L61
            int r10 = r5.f56792w
            if (r10 == r7) goto L61
            if (r8 != r9) goto L61
            int r10 = r5.f56794x
            if (r10 == r7) goto L61
            r10 = r7
            goto L62
        L61:
            r10 = r3
        L62:
            if (r10 != 0) goto L9a
            boolean r11 = r13.m73690Z1(r7)
            if (r11 == 0) goto L9a
            boolean r11 = r5 instanceof p561q.C12266m
            if (r11 != 0) goto L9a
            if (r6 != r9) goto L7d
            int r11 = r5.f56792w
            if (r11 != 0) goto L7d
            if (r8 == r9) goto L7d
            boolean r11 = r5.m73624k0()
            if (r11 != 0) goto L7d
            r10 = r7
        L7d:
            if (r8 != r9) goto L8c
            int r11 = r5.f56794x
            if (r11 != 0) goto L8c
            if (r6 == r9) goto L8c
            boolean r11 = r5.m73624k0()
            if (r11 != 0) goto L8c
            goto L8d
        L8c:
            r7 = r10
        L8d:
            if (r6 == r9) goto L91
            if (r8 != r9) goto L99
        L91:
            float r6 = r5.f56759f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L99
            goto La2
        L99:
            r10 = r7
        L9a:
            if (r10 == 0) goto L9d
            goto La2
        L9d:
            int r6 = p596r.C12435b.a.f57281k
            r12.m74629a(r2, r5, r6)
        La2:
            int r4 = r4 + 1
            goto L12
        La6:
            r2.mo3571a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p596r.C12435b.m74630b(q.f):void");
    }

    /* renamed from: c */
    public final void m74631c(C12259f c12259f, String str, int i10, int i11, int i12) {
        c12259f.getClass();
        int iM73566K = c12259f.m73566K();
        int iM73564J = c12259f.m73564J();
        c12259f.m73612f1(0);
        c12259f.m73609e1(0);
        c12259f.m73638p1(i11);
        c12259f.m73579Q0(i12);
        c12259f.m73612f1(iM73566K);
        c12259f.m73609e1(iM73564J);
        this.f57280c.m73694d2(i10);
        this.f57280c.mo73698x1();
    }

    /* renamed from: d */
    public long m74632d(C12259f c12259f, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean zM73678M1;
        int i19;
        C12259f c12259f2;
        int i20;
        boolean z10;
        int i21;
        int i22;
        boolean z11;
        C12435b c12435b = this;
        b bVarM73680O1 = c12259f.m73680O1();
        int size = c12259f.f56904V0.size();
        int iM73594Y = c12259f.m73594Y();
        int iM73662z = c12259f.m73662z();
        boolean zM73772b = C12264k.m73772b(i10, 128);
        boolean z12 = zM73772b || C12264k.m73772b(i10, 64);
        if (z12) {
            for (int i23 = 0; i23 < size; i23++) {
                C12258e c12258e = c12259f.f56904V0.get(i23);
                C12258e.b bVarM73550C = c12258e.m73550C();
                C12258e.b bVar = C12258e.b.MATCH_CONSTRAINT;
                boolean z13 = (bVarM73550C == bVar) && (c12258e.m73588V() == bVar) && c12258e.m73658x() > 0.0f;
                if ((c12258e.m73624k0() && z13) || ((c12258e.m73630m0() && z13) || (c12258e instanceof C12266m) || c12258e.m73624k0() || c12258e.m73630m0())) {
                    z12 = false;
                    break;
                }
            }
        }
        if (z12) {
            boolean z14 = C11574d.f53660s;
        }
        boolean z15 = z12 & ((i13 == 1073741824 && i15 == 1073741824) || zM73772b);
        int i24 = 2;
        if (z15) {
            int iMin = Math.min(c12259f.m73562I(), i14);
            int iMin2 = Math.min(c12259f.m73560H(), i16);
            if (i13 == 1073741824 && c12259f.m73594Y() != iMin) {
                c12259f.m73638p1(iMin);
                c12259f.m73684S1();
            }
            if (i15 == 1073741824 && c12259f.m73662z() != iMin2) {
                c12259f.m73579Q0(iMin2);
                c12259f.m73684S1();
            }
            if (i13 == 1073741824 && i15 == 1073741824) {
                zM73678M1 = c12259f.m73676K1(zM73772b);
                i19 = 2;
            } else {
                boolean zM73677L1 = c12259f.m73677L1(zM73772b);
                if (i13 == 1073741824) {
                    zM73677L1 &= c12259f.m73678M1(zM73772b, 0);
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                if (i15 == 1073741824) {
                    zM73678M1 = c12259f.m73678M1(zM73772b, 1) & zM73677L1;
                    i19++;
                } else {
                    zM73678M1 = zM73677L1;
                }
            }
            if (zM73678M1) {
                c12259f.mo73652u1(i13 == 1073741824, i15 == 1073741824);
            }
        } else {
            zM73678M1 = false;
            i19 = 0;
        }
        if (zM73678M1 && i19 == 2) {
            return 0L;
        }
        int iM73681P1 = c12259f.m73681P1();
        if (size > 0) {
            m74630b(c12259f);
        }
        m74633e(c12259f);
        int size2 = c12435b.f57278a.size();
        if (size > 0) {
            m74631c(c12259f, "First pass", 0, iM73594Y, iM73662z);
        }
        if (size2 > 0) {
            C12258e.b bVarM73550C2 = c12259f.m73550C();
            C12258e.b bVar2 = C12258e.b.WRAP_CONTENT;
            boolean z16 = bVarM73550C2 == bVar2;
            boolean z17 = c12259f.m73588V() == bVar2;
            int iMax = Math.max(c12259f.m73594Y(), c12435b.f57280c.m73566K());
            int iMax2 = Math.max(c12259f.m73662z(), c12435b.f57280c.m73564J());
            int i25 = 0;
            boolean zM73782K1 = false;
            while (i25 < size2) {
                C12258e c12258e2 = c12435b.f57278a.get(i25);
                if (c12258e2 instanceof C12266m) {
                    int iM73594Y2 = c12258e2.m73594Y();
                    int iM73662z2 = c12258e2.m73662z();
                    i22 = iM73681P1;
                    boolean zM74629a = c12435b.m74629a(bVarM73680O1, c12258e2, a.f57282l) | zM73782K1;
                    int iM73594Y3 = c12258e2.m73594Y();
                    int iM73662z3 = c12258e2.m73662z();
                    if (iM73594Y3 != iM73594Y2) {
                        c12258e2.m73638p1(iM73594Y3);
                        if (z16 && c12258e2.m73574O() > iMax) {
                            iMax = Math.max(iMax, c12258e2.m73574O() + c12258e2.mo73639q(C12257d.a.RIGHT).m73529f());
                        }
                        z11 = true;
                    } else {
                        z11 = zM74629a;
                    }
                    if (iM73662z3 != iM73662z2) {
                        c12258e2.m73579Q0(iM73662z3);
                        if (z17 && c12258e2.m73647t() > iMax2) {
                            iMax2 = Math.max(iMax2, c12258e2.m73647t() + c12258e2.mo73639q(C12257d.a.BOTTOM).m73529f());
                        }
                        z11 = true;
                    }
                    zM73782K1 = z11 | ((C12266m) c12258e2).m73782K1();
                } else {
                    i22 = iM73681P1;
                }
                i25++;
                iM73681P1 = i22;
                i24 = 2;
            }
            int i26 = iM73681P1;
            int i27 = i24;
            int i28 = 0;
            while (i28 < i27) {
                int i29 = 0;
                while (i29 < size2) {
                    C12258e c12258e3 = c12435b.f57278a.get(i29);
                    if (((c12258e3 instanceof InterfaceC12262i) && !(c12258e3 instanceof C12266m)) || (c12258e3 instanceof C12261h) || c12258e3.m73592X() == 8 || ((z15 && c12258e3.f56756e.f57361e.f57314j && c12258e3.f56758f.f57361e.f57314j) || (c12258e3 instanceof C12266m))) {
                        z10 = z15;
                        i21 = size2;
                    } else {
                        int iM73594Y4 = c12258e3.m73594Y();
                        int iM73662z4 = c12258e3.m73662z();
                        z10 = z15;
                        int iM73641r = c12258e3.m73641r();
                        int i30 = a.f57282l;
                        i21 = size2;
                        if (i28 == 1) {
                            i30 = a.f57283m;
                        }
                        boolean zM74629a2 = c12435b.m74629a(bVarM73680O1, c12258e3, i30) | zM73782K1;
                        int iM73594Y5 = c12258e3.m73594Y();
                        int iM73662z5 = c12258e3.m73662z();
                        if (iM73594Y5 != iM73594Y4) {
                            c12258e3.m73638p1(iM73594Y5);
                            if (z16 && c12258e3.m73574O() > iMax) {
                                iMax = Math.max(iMax, c12258e3.m73574O() + c12258e3.mo73639q(C12257d.a.RIGHT).m73529f());
                            }
                            zM74629a2 = true;
                        }
                        if (iM73662z5 != iM73662z4) {
                            c12258e3.m73579Q0(iM73662z5);
                            if (z17 && c12258e3.m73647t() > iMax2) {
                                iMax2 = Math.max(iMax2, c12258e3.m73647t() + c12258e3.mo73639q(C12257d.a.BOTTOM).m73529f());
                            }
                            zM74629a2 = true;
                        }
                        zM73782K1 = (!c12258e3.m73600b0() || iM73641r == c12258e3.m73641r()) ? zM74629a2 : true;
                    }
                    i29++;
                    c12435b = this;
                    z15 = z10;
                    size2 = i21;
                }
                boolean z18 = z15;
                int i31 = size2;
                if (!zM73782K1) {
                    break;
                }
                i28++;
                m74631c(c12259f, "intermediate pass", i28, iM73594Y, iM73662z);
                c12435b = this;
                z15 = z18;
                size2 = i31;
                i27 = 2;
                zM73782K1 = false;
            }
            c12259f2 = c12259f;
            i20 = i26;
        } else {
            c12259f2 = c12259f;
            i20 = iM73681P1;
        }
        c12259f2.m73693c2(i20);
        return 0L;
    }

    /* renamed from: e */
    public void m74633e(C12259f c12259f) {
        this.f57278a.clear();
        int size = c12259f.f56904V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            C12258e c12258e = c12259f.f56904V0.get(i10);
            C12258e.b bVarM73550C = c12258e.m73550C();
            C12258e.b bVar = C12258e.b.MATCH_CONSTRAINT;
            if (bVarM73550C == bVar || c12258e.m73588V() == bVar) {
                this.f57278a.add(c12258e);
            }
        }
        c12259f.m73684S1();
    }
}
