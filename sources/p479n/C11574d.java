package p479n;

import java.util.Arrays;
import java.util.HashMap;
import p479n.C11579i;
import p561q.C12257d;
import p561q.C12258e;

/* renamed from: n.d */
/* loaded from: classes.dex */
public class C11574d {

    /* renamed from: s */
    public static boolean f53660s = false;

    /* renamed from: t */
    public static boolean f53661t = true;

    /* renamed from: u */
    public static boolean f53662u = true;

    /* renamed from: v */
    public static boolean f53663v = true;

    /* renamed from: w */
    public static boolean f53664w = false;

    /* renamed from: x */
    public static long f53665x;

    /* renamed from: y */
    public static long f53666y;

    /* renamed from: e */
    public a f53671e;

    /* renamed from: o */
    public final C11573c f53681o;

    /* renamed from: r */
    public a f53684r;

    /* renamed from: a */
    public int f53667a = 1000;

    /* renamed from: b */
    public boolean f53668b = false;

    /* renamed from: c */
    public int f53669c = 0;

    /* renamed from: d */
    public HashMap<String, C11579i> f53670d = null;

    /* renamed from: f */
    public int f53672f = 32;

    /* renamed from: g */
    public int f53673g = 32;

    /* renamed from: i */
    public boolean f53675i = false;

    /* renamed from: j */
    public boolean f53676j = false;

    /* renamed from: k */
    public boolean[] f53677k = new boolean[32];

    /* renamed from: l */
    public int f53678l = 1;

    /* renamed from: m */
    public int f53679m = 0;

    /* renamed from: n */
    public int f53680n = 32;

    /* renamed from: p */
    public C11579i[] f53682p = new C11579i[1000];

    /* renamed from: q */
    public int f53683q = 0;

    /* renamed from: h */
    public C11572b[] f53674h = new C11572b[32];

    /* renamed from: n.d$a */
    public interface a {
        /* renamed from: a */
        void mo69059a(C11579i c11579i);

        /* renamed from: b */
        C11579i mo69060b(C11574d c11574d, boolean[] zArr);

        /* renamed from: c */
        void mo69061c(a aVar);

        void clear();

        C11579i getKey();

        boolean isEmpty();
    }

    /* renamed from: n.d$b */
    public static class b extends C11572b {
        public b(C11573c c11573c) {
            this.f53654e = new C11580j(this, c11573c);
        }
    }

    public C11574d() {
        m69090D();
        C11573c c11573c = new C11573c();
        this.f53681o = c11573c;
        this.f53671e = new C11578h(c11573c);
        if (f53664w) {
            this.f53684r = new b(c11573c);
        } else {
            this.f53684r = new C11572b(c11573c);
        }
    }

    /* renamed from: s */
    public static C11572b m69085s(C11574d c11574d, C11579i c11579i, C11579i c11579i2, float f10) {
        return c11574d.m69109r().m69068j(c11579i, c11579i2, f10);
    }

    /* renamed from: x */
    public static C11575e m69086x() {
        return null;
    }

    /* renamed from: A */
    public void m69087A() throws Exception {
        if (this.f53671e.isEmpty()) {
            m69105n();
            return;
        }
        if (!this.f53675i && !this.f53676j) {
            m69088B(this.f53671e);
            return;
        }
        for (int i10 = 0; i10 < this.f53679m; i10++) {
            if (!this.f53674h[i10].f53655f) {
                m69088B(this.f53671e);
                return;
            }
        }
        m69105n();
    }

    /* renamed from: B */
    public void m69088B(a aVar) throws Exception {
        m69111u(aVar);
        m69089C(aVar, false);
        m69105n();
    }

    /* renamed from: C */
    public final int m69089C(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f53678l; i10++) {
            this.f53677k[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f53678l * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f53677k[aVar.getKey().f53700c] = true;
            }
            C11579i c11579iMo69060b = aVar.mo69060b(this, this.f53677k);
            if (c11579iMo69060b != null) {
                boolean[] zArr = this.f53677k;
                int i12 = c11579iMo69060b.f53700c;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (c11579iMo69060b != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f53679m; i14++) {
                    C11572b c11572b = this.f53674h[i14];
                    if (c11572b.f53650a.f53707j != C11579i.a.UNRESTRICTED && !c11572b.f53655f && c11572b.m69078t(c11579iMo69060b)) {
                        float fMo69048e = c11572b.f53654e.mo69048e(c11579iMo69060b);
                        if (fMo69048e < 0.0f) {
                            float f11 = (-c11572b.f53651b) / fMo69048e;
                            if (f11 < f10) {
                                i13 = i14;
                                f10 = f11;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    C11572b c11572b2 = this.f53674h[i13];
                    c11572b2.f53650a.f53701d = -1;
                    c11572b2.m69082x(c11579iMo69060b);
                    C11579i c11579i = c11572b2.f53650a;
                    c11579i.f53701d = i13;
                    c11579i.m69135p(this, c11572b2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    /* renamed from: D */
    public final void m69090D() {
        int i10 = 0;
        if (f53664w) {
            while (i10 < this.f53679m) {
                C11572b c11572b = this.f53674h[i10];
                if (c11572b != null) {
                    this.f53681o.f53656a.mo69116a(c11572b);
                }
                this.f53674h[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f53679m) {
            C11572b c11572b2 = this.f53674h[i10];
            if (c11572b2 != null) {
                this.f53681o.f53657b.mo69116a(c11572b2);
            }
            this.f53674h[i10] = null;
            i10++;
        }
    }

    /* renamed from: E */
    public void m69091E() {
        C11573c c11573c;
        int i10 = 0;
        while (true) {
            c11573c = this.f53681o;
            C11579i[] c11579iArr = c11573c.f53659d;
            if (i10 >= c11579iArr.length) {
                break;
            }
            C11579i c11579i = c11579iArr[i10];
            if (c11579i != null) {
                c11579i.m69132h();
            }
            i10++;
        }
        c11573c.f53658c.mo69118c(this.f53682p, this.f53683q);
        this.f53683q = 0;
        Arrays.fill(this.f53681o.f53659d, (Object) null);
        HashMap<String, C11579i> map = this.f53670d;
        if (map != null) {
            map.clear();
        }
        this.f53669c = 0;
        this.f53671e.clear();
        this.f53678l = 1;
        for (int i11 = 0; i11 < this.f53679m; i11++) {
            C11572b c11572b = this.f53674h[i11];
            if (c11572b != null) {
                c11572b.f53652c = false;
            }
        }
        m69090D();
        this.f53679m = 0;
        if (f53664w) {
            this.f53684r = new b(this.f53681o);
        } else {
            this.f53684r = new C11572b(this.f53681o);
        }
    }

    /* renamed from: a */
    public final C11579i m69092a(C11579i.a aVar, String str) {
        C11579i c11579iMo69117b = this.f53681o.f53658c.mo69117b();
        if (c11579iMo69117b == null) {
            c11579iMo69117b = new C11579i(aVar, str);
            c11579iMo69117b.m69134k(aVar, str);
        } else {
            c11579iMo69117b.m69132h();
            c11579iMo69117b.m69134k(aVar, str);
        }
        int i10 = this.f53683q;
        int i11 = this.f53667a;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            this.f53667a = i12;
            this.f53682p = (C11579i[]) Arrays.copyOf(this.f53682p, i12);
        }
        C11579i[] c11579iArr = this.f53682p;
        int i13 = this.f53683q;
        this.f53683q = i13 + 1;
        c11579iArr[i13] = c11579iMo69117b;
        return c11579iMo69117b;
    }

    /* renamed from: b */
    public void m69093b(C12258e c12258e, C12258e c12258e2, float f10, int i10) {
        C12257d.a aVar = C12257d.a.LEFT;
        C11579i c11579iM69108q = m69108q(c12258e.mo73639q(aVar));
        C12257d.a aVar2 = C12257d.a.TOP;
        C11579i c11579iM69108q2 = m69108q(c12258e.mo73639q(aVar2));
        C12257d.a aVar3 = C12257d.a.RIGHT;
        C11579i c11579iM69108q3 = m69108q(c12258e.mo73639q(aVar3));
        C12257d.a aVar4 = C12257d.a.BOTTOM;
        C11579i c11579iM69108q4 = m69108q(c12258e.mo73639q(aVar4));
        C11579i c11579iM69108q5 = m69108q(c12258e2.mo73639q(aVar));
        C11579i c11579iM69108q6 = m69108q(c12258e2.mo73639q(aVar2));
        C11579i c11579iM69108q7 = m69108q(c12258e2.mo73639q(aVar3));
        C11579i c11579iM69108q8 = m69108q(c12258e2.mo73639q(aVar4));
        C11572b c11572bM69109r = m69109r();
        double d10 = f10;
        double d11 = i10;
        c11572bM69109r.m69075q(c11579iM69108q2, c11579iM69108q4, c11579iM69108q6, c11579iM69108q8, (float) (Math.sin(d10) * d11));
        m69095d(c11572bM69109r);
        C11572b c11572bM69109r2 = m69109r();
        c11572bM69109r2.m69075q(c11579iM69108q, c11579iM69108q3, c11579iM69108q5, c11579iM69108q7, (float) (Math.cos(d10) * d11));
        m69095d(c11572bM69109r2);
    }

    /* renamed from: c */
    public void m69094c(C11579i c11579i, C11579i c11579i2, int i10, float f10, C11579i c11579i3, C11579i c11579i4, int i11, int i12) {
        C11572b c11572bM69109r = m69109r();
        c11572bM69109r.m69066h(c11579i, c11579i2, i10, f10, c11579i3, c11579i4, i11);
        if (i12 != 8) {
            c11572bM69109r.m69062d(this, i12);
        }
        m69095d(c11572bM69109r);
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x007a  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m69095d(p479n.C11572b r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L3
            return
        L3:
            int r0 = r4.f53679m
            r1 = 1
            int r0 = r0 + r1
            int r2 = r4.f53680n
            if (r0 >= r2) goto L12
            int r0 = r4.f53678l
            int r0 = r0 + r1
            int r2 = r4.f53673g
            if (r0 < r2) goto L15
        L12:
            r4.m69115z()
        L15:
            boolean r0 = r5.f53655f
            if (r0 != 0) goto L84
            r5.m69058D(r4)
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L23
            return
        L23:
            r5.m69076r()
            boolean r0 = r5.m69064f(r4)
            if (r0 == 0) goto L7a
            n.i r0 = r4.m69107p()
            r5.f53650a = r0
            int r2 = r4.f53679m
            r4.m69103l(r5)
            int r3 = r4.f53679m
            int r2 = r2 + r1
            if (r3 != r2) goto L7a
            n.d$a r2 = r4.f53684r
            r2.mo69061c(r5)
            n.d$a r2 = r4.f53684r
            r4.m69089C(r2, r1)
            int r2 = r0.f53701d
            r3 = -1
            if (r2 != r3) goto L7b
            n.i r2 = r5.f53650a
            if (r2 != r0) goto L58
            n.i r0 = r5.m69080v(r0)
            if (r0 == 0) goto L58
            r5.m69082x(r0)
        L58:
            boolean r0 = r5.f53655f
            if (r0 != 0) goto L61
            n.i r0 = r5.f53650a
            r0.m69135p(r4, r5)
        L61:
            boolean r0 = p479n.C11574d.f53664w
            if (r0 == 0) goto L6d
            n.c r0 = r4.f53681o
            n.f<n.b> r0 = r0.f53656a
            r0.mo69116a(r5)
            goto L74
        L6d:
            n.c r0 = r4.f53681o
            n.f<n.b> r0 = r0.f53657b
            r0.mo69116a(r5)
        L74:
            int r0 = r4.f53679m
            int r0 = r0 - r1
            r4.f53679m = r0
            goto L7b
        L7a:
            r1 = 0
        L7b:
            boolean r0 = r5.m69077s()
            if (r0 != 0) goto L82
            return
        L82:
            if (r1 != 0) goto L87
        L84:
            r4.m69103l(r5)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p479n.C11574d.m69095d(n.b):void");
    }

    /* renamed from: e */
    public C11572b m69096e(C11579i c11579i, C11579i c11579i2, int i10, int i11) {
        if (f53661t && i11 == 8 && c11579i2.f53704g && c11579i.f53701d == -1) {
            c11579i.m69133i(this, c11579i2.f53703f + i10);
            return null;
        }
        C11572b c11572bM69109r = m69109r();
        c11572bM69109r.m69072n(c11579i, c11579i2, i10);
        if (i11 != 8) {
            c11572bM69109r.m69062d(this, i11);
        }
        m69095d(c11572bM69109r);
        return c11572bM69109r;
    }

    /* renamed from: f */
    public void m69097f(C11579i c11579i, int i10) {
        if (f53661t && c11579i.f53701d == -1) {
            float f10 = i10;
            c11579i.m69133i(this, f10);
            for (int i11 = 0; i11 < this.f53669c + 1; i11++) {
                C11579i c11579i2 = this.f53681o.f53659d[i11];
                if (c11579i2 != null && c11579i2.f53711n && c11579i2.f53712o == c11579i.f53700c) {
                    c11579i2.m69133i(this, c11579i2.f53713p + f10);
                }
            }
            return;
        }
        int i12 = c11579i.f53701d;
        if (i12 == -1) {
            C11572b c11572bM69109r = m69109r();
            c11572bM69109r.m69067i(c11579i, i10);
            m69095d(c11572bM69109r);
            return;
        }
        C11572b c11572b = this.f53674h[i12];
        if (c11572b.f53655f) {
            c11572b.f53651b = i10;
            return;
        }
        if (c11572b.f53654e.mo69047d() == 0) {
            c11572b.f53655f = true;
            c11572b.f53651b = i10;
        } else {
            C11572b c11572bM69109r2 = m69109r();
            c11572bM69109r2.m69071m(c11579i, i10);
            m69095d(c11572bM69109r2);
        }
    }

    /* renamed from: g */
    public void m69098g(C11579i c11579i, C11579i c11579i2, int i10, boolean z10) {
        C11572b c11572bM69109r = m69109r();
        C11579i c11579iM69110t = m69110t();
        c11579iM69110t.f53702e = 0;
        c11572bM69109r.m69073o(c11579i, c11579i2, c11579iM69110t, i10);
        m69095d(c11572bM69109r);
    }

    /* renamed from: h */
    public void m69099h(C11579i c11579i, C11579i c11579i2, int i10, int i11) {
        C11572b c11572bM69109r = m69109r();
        C11579i c11579iM69110t = m69110t();
        c11579iM69110t.f53702e = 0;
        c11572bM69109r.m69073o(c11579i, c11579i2, c11579iM69110t, i10);
        if (i11 != 8) {
            m69104m(c11572bM69109r, (int) (c11572bM69109r.f53654e.mo69048e(c11579iM69110t) * (-1.0f)), i11);
        }
        m69095d(c11572bM69109r);
    }

    /* renamed from: i */
    public void m69100i(C11579i c11579i, C11579i c11579i2, int i10, boolean z10) {
        C11572b c11572bM69109r = m69109r();
        C11579i c11579iM69110t = m69110t();
        c11579iM69110t.f53702e = 0;
        c11572bM69109r.m69074p(c11579i, c11579i2, c11579iM69110t, i10);
        m69095d(c11572bM69109r);
    }

    /* renamed from: j */
    public void m69101j(C11579i c11579i, C11579i c11579i2, int i10, int i11) {
        C11572b c11572bM69109r = m69109r();
        C11579i c11579iM69110t = m69110t();
        c11579iM69110t.f53702e = 0;
        c11572bM69109r.m69074p(c11579i, c11579i2, c11579iM69110t, i10);
        if (i11 != 8) {
            m69104m(c11572bM69109r, (int) (c11572bM69109r.f53654e.mo69048e(c11579iM69110t) * (-1.0f)), i11);
        }
        m69095d(c11572bM69109r);
    }

    /* renamed from: k */
    public void m69102k(C11579i c11579i, C11579i c11579i2, C11579i c11579i3, C11579i c11579i4, float f10, int i10) {
        C11572b c11572bM69109r = m69109r();
        c11572bM69109r.m69069k(c11579i, c11579i2, c11579i3, c11579i4, f10);
        if (i10 != 8) {
            c11572bM69109r.m69062d(this, i10);
        }
        m69095d(c11572bM69109r);
    }

    /* renamed from: l */
    public final void m69103l(C11572b c11572b) {
        int i10;
        if (f53662u && c11572b.f53655f) {
            c11572b.f53650a.m69133i(this, c11572b.f53651b);
        } else {
            C11572b[] c11572bArr = this.f53674h;
            int i11 = this.f53679m;
            c11572bArr[i11] = c11572b;
            C11579i c11579i = c11572b.f53650a;
            c11579i.f53701d = i11;
            this.f53679m = i11 + 1;
            c11579i.m69135p(this, c11572b);
        }
        if (f53662u && this.f53668b) {
            int i12 = 0;
            while (i12 < this.f53679m) {
                if (this.f53674h[i12] == null) {
                    System.out.println("WTF");
                }
                C11572b c11572b2 = this.f53674h[i12];
                if (c11572b2 != null && c11572b2.f53655f) {
                    c11572b2.f53650a.m69133i(this, c11572b2.f53651b);
                    if (f53664w) {
                        this.f53681o.f53656a.mo69116a(c11572b2);
                    } else {
                        this.f53681o.f53657b.mo69116a(c11572b2);
                    }
                    this.f53674h[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f53679m;
                        if (i13 >= i10) {
                            break;
                        }
                        C11572b[] c11572bArr2 = this.f53674h;
                        int i15 = i13 - 1;
                        C11572b c11572b3 = c11572bArr2[i13];
                        c11572bArr2[i15] = c11572b3;
                        C11579i c11579i2 = c11572b3.f53650a;
                        if (c11579i2.f53701d == i13) {
                            c11579i2.f53701d = i15;
                        }
                        i14 = i13;
                        i13++;
                    }
                    if (i14 < i10) {
                        this.f53674h[i14] = null;
                    }
                    this.f53679m = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f53668b = false;
        }
    }

    /* renamed from: m */
    public void m69104m(C11572b c11572b, int i10, int i11) {
        c11572b.m69063e(m69106o(i11, null), i10);
    }

    /* renamed from: n */
    public final void m69105n() {
        for (int i10 = 0; i10 < this.f53679m; i10++) {
            C11572b c11572b = this.f53674h[i10];
            c11572b.f53650a.f53703f = c11572b.f53651b;
        }
    }

    /* renamed from: o */
    public C11579i m69106o(int i10, String str) {
        if (this.f53678l + 1 >= this.f53673g) {
            m69115z();
        }
        C11579i c11579iM69092a = m69092a(C11579i.a.ERROR, str);
        int i11 = this.f53669c + 1;
        this.f53669c = i11;
        this.f53678l++;
        c11579iM69092a.f53700c = i11;
        c11579iM69092a.f53702e = i10;
        this.f53681o.f53659d[i11] = c11579iM69092a;
        this.f53671e.mo69059a(c11579iM69092a);
        return c11579iM69092a;
    }

    /* renamed from: p */
    public C11579i m69107p() {
        if (this.f53678l + 1 >= this.f53673g) {
            m69115z();
        }
        C11579i c11579iM69092a = m69092a(C11579i.a.SLACK, null);
        int i10 = this.f53669c + 1;
        this.f53669c = i10;
        this.f53678l++;
        c11579iM69092a.f53700c = i10;
        this.f53681o.f53659d[i10] = c11579iM69092a;
        return c11579iM69092a;
    }

    /* renamed from: q */
    public C11579i m69108q(Object obj) {
        C11579i c11579iM73532i = null;
        if (obj == null) {
            return null;
        }
        if (this.f53678l + 1 >= this.f53673g) {
            m69115z();
        }
        if (obj instanceof C12257d) {
            C12257d c12257d = (C12257d) obj;
            c11579iM73532i = c12257d.m73532i();
            if (c11579iM73532i == null) {
                c12257d.m73542s(this.f53681o);
                c11579iM73532i = c12257d.m73532i();
            }
            int i10 = c11579iM73532i.f53700c;
            if (i10 == -1 || i10 > this.f53669c || this.f53681o.f53659d[i10] == null) {
                if (i10 != -1) {
                    c11579iM73532i.m69132h();
                }
                int i11 = this.f53669c + 1;
                this.f53669c = i11;
                this.f53678l++;
                c11579iM73532i.f53700c = i11;
                c11579iM73532i.f53707j = C11579i.a.UNRESTRICTED;
                this.f53681o.f53659d[i11] = c11579iM73532i;
            }
        }
        return c11579iM73532i;
    }

    /* renamed from: r */
    public C11572b m69109r() {
        C11572b c11572bMo69117b;
        if (f53664w) {
            c11572bMo69117b = this.f53681o.f53656a.mo69117b();
            if (c11572bMo69117b == null) {
                c11572bMo69117b = new b(this.f53681o);
                f53666y++;
            } else {
                c11572bMo69117b.m69083y();
            }
        } else {
            c11572bMo69117b = this.f53681o.f53657b.mo69117b();
            if (c11572bMo69117b == null) {
                c11572bMo69117b = new C11572b(this.f53681o);
                f53665x++;
            } else {
                c11572bMo69117b.m69083y();
            }
        }
        C11579i.m69128e();
        return c11572bMo69117b;
    }

    /* renamed from: t */
    public C11579i m69110t() {
        if (this.f53678l + 1 >= this.f53673g) {
            m69115z();
        }
        C11579i c11579iM69092a = m69092a(C11579i.a.SLACK, null);
        int i10 = this.f53669c + 1;
        this.f53669c = i10;
        this.f53678l++;
        c11579iM69092a.f53700c = i10;
        this.f53681o.f53659d[i10] = c11579iM69092a;
        return c11579iM69092a;
    }

    /* renamed from: u */
    public final int m69111u(a aVar) throws Exception {
        for (int i10 = 0; i10 < this.f53679m; i10++) {
            C11572b c11572b = this.f53674h[i10];
            if (c11572b.f53650a.f53707j != C11579i.a.UNRESTRICTED && c11572b.f53651b < 0.0f) {
                boolean z10 = false;
                int i11 = 0;
                while (!z10) {
                    i11++;
                    float f10 = Float.MAX_VALUE;
                    int i12 = 0;
                    int i13 = -1;
                    int i14 = -1;
                    int i15 = 0;
                    while (true) {
                        if (i12 >= this.f53679m) {
                            break;
                        }
                        C11572b c11572b2 = this.f53674h[i12];
                        if (c11572b2.f53650a.f53707j != C11579i.a.UNRESTRICTED && !c11572b2.f53655f && c11572b2.f53651b < 0.0f) {
                            int i16 = 9;
                            if (f53663v) {
                                int iMo69047d = c11572b2.f53654e.mo69047d();
                                int i17 = 0;
                                while (i17 < iMo69047d) {
                                    C11579i c11579iMo69049f = c11572b2.f53654e.mo69049f(i17);
                                    float fMo69048e = c11572b2.f53654e.mo69048e(c11579iMo69049f);
                                    if (fMo69048e > 0.0f) {
                                        int i18 = 0;
                                        while (i18 < i16) {
                                            float f11 = c11579iMo69049f.f53705h[i18] / fMo69048e;
                                            if ((f11 < f10 && i18 == i15) || i18 > i15) {
                                                i15 = i18;
                                                i14 = c11579iMo69049f.f53700c;
                                                i13 = i12;
                                                f10 = f11;
                                            }
                                            i18++;
                                            i16 = 9;
                                        }
                                    }
                                    i17++;
                                    i16 = 9;
                                }
                            } else {
                                for (int i19 = 1; i19 < this.f53678l; i19++) {
                                    C11579i c11579i = this.f53681o.f53659d[i19];
                                    float fMo69048e2 = c11572b2.f53654e.mo69048e(c11579i);
                                    if (fMo69048e2 > 0.0f) {
                                        for (int i20 = 0; i20 < 9; i20++) {
                                            float f12 = c11579i.f53705h[i20] / fMo69048e2;
                                            if ((f12 < f10 && i20 == i15) || i20 > i15) {
                                                i13 = i12;
                                                i14 = i19;
                                                i15 = i20;
                                                f10 = f12;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i12++;
                    }
                    if (i13 != -1) {
                        C11572b c11572b3 = this.f53674h[i13];
                        c11572b3.f53650a.f53701d = -1;
                        c11572b3.m69082x(this.f53681o.f53659d[i14]);
                        C11579i c11579i2 = c11572b3.f53650a;
                        c11579i2.f53701d = i13;
                        c11579i2.m69135p(this, c11572b3);
                    } else {
                        z10 = true;
                    }
                    if (i11 > this.f53678l / 2) {
                        z10 = true;
                    }
                }
                return i11;
            }
        }
        return 0;
    }

    /* renamed from: v */
    public void m69112v(C11575e c11575e) {
    }

    /* renamed from: w */
    public C11573c m69113w() {
        return this.f53681o;
    }

    /* renamed from: y */
    public int m69114y(Object obj) {
        C11579i c11579iM73532i = ((C12257d) obj).m73532i();
        if (c11579iM73532i != null) {
            return (int) (c11579iM73532i.f53703f + 0.5f);
        }
        return 0;
    }

    /* renamed from: z */
    public final void m69115z() {
        int i10 = this.f53672f * 2;
        this.f53672f = i10;
        this.f53674h = (C11572b[]) Arrays.copyOf(this.f53674h, i10);
        C11573c c11573c = this.f53681o;
        c11573c.f53659d = (C11579i[]) Arrays.copyOf(c11573c.f53659d, this.f53672f);
        int i11 = this.f53672f;
        this.f53677k = new boolean[i11];
        this.f53673g = i11;
        this.f53680n = i11;
    }
}
