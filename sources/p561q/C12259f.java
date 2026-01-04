package p561q;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import p479n.C11574d;
import p479n.C11575e;
import p479n.C11579i;
import p561q.C12258e;
import p596r.C12435b;
import p596r.C12438e;

/* renamed from: q.f */
/* loaded from: classes.dex */
public class C12259f extends C12267n {

    /* renamed from: Y0 */
    public int f56808Y0;

    /* renamed from: c1 */
    public int f56812c1;

    /* renamed from: d1 */
    public int f56813d1;

    /* renamed from: e1 */
    public int f56814e1;

    /* renamed from: f1 */
    public int f56815f1;

    /* renamed from: W0 */
    public C12435b f56806W0 = new C12435b(this);

    /* renamed from: X0 */
    public C12438e f56807X0 = new C12438e(this);

    /* renamed from: Z0 */
    public C12435b.b f56809Z0 = null;

    /* renamed from: a1 */
    public boolean f56810a1 = false;

    /* renamed from: b1 */
    public C11574d f56811b1 = new C11574d();

    /* renamed from: g1 */
    public int f56816g1 = 0;

    /* renamed from: h1 */
    public int f56817h1 = 0;

    /* renamed from: i1 */
    public C12256c[] f56818i1 = new C12256c[4];

    /* renamed from: j1 */
    public C12256c[] f56819j1 = new C12256c[4];

    /* renamed from: k1 */
    public boolean f56820k1 = false;

    /* renamed from: l1 */
    public boolean f56821l1 = false;

    /* renamed from: m1 */
    public boolean f56822m1 = false;

    /* renamed from: n1 */
    public int f56823n1 = 0;

    /* renamed from: o1 */
    public int f56824o1 = 0;

    /* renamed from: p1 */
    public int f56825p1 = 257;

    /* renamed from: q1 */
    public boolean f56826q1 = false;

    /* renamed from: r1 */
    public boolean f56827r1 = false;

    /* renamed from: s1 */
    public boolean f56828s1 = false;

    /* renamed from: t1 */
    public int f56829t1 = 0;

    /* renamed from: u1 */
    public WeakReference<C12257d> f56830u1 = null;

    /* renamed from: v1 */
    public WeakReference<C12257d> f56831v1 = null;

    /* renamed from: w1 */
    public WeakReference<C12257d> f56832w1 = null;

    /* renamed from: x1 */
    public WeakReference<C12257d> f56833x1 = null;

    /* renamed from: y1 */
    public HashSet<C12258e> f56834y1 = new HashSet<>();

    /* renamed from: z1 */
    public C12435b.a f56835z1 = new C12435b.a();

    /* renamed from: Y1 */
    public static boolean m73665Y1(int i10, C12258e c12258e, C12435b.b bVar, C12435b.a aVar, int i11) {
        int i12;
        int i13;
        if (bVar == null) {
            return false;
        }
        if (c12258e.m73592X() == 8 || (c12258e instanceof C12261h) || (c12258e instanceof C12254a)) {
            aVar.f57288e = 0;
            aVar.f57289f = 0;
            return false;
        }
        aVar.f57284a = c12258e.m73550C();
        aVar.f57285b = c12258e.m73588V();
        aVar.f57286c = c12258e.m73594Y();
        aVar.f57287d = c12258e.m73662z();
        aVar.f57292i = false;
        aVar.f57293j = i11;
        C12258e.b bVar2 = aVar.f57284a;
        C12258e.b bVar3 = C12258e.b.MATCH_CONSTRAINT;
        boolean z10 = bVar2 == bVar3;
        boolean z11 = aVar.f57285b == bVar3;
        boolean z12 = z10 && c12258e.f56759f0 > 0.0f;
        boolean z13 = z11 && c12258e.f56759f0 > 0.0f;
        if (z10 && c12258e.m73602c0(0) && c12258e.f56792w == 0 && !z12) {
            aVar.f57284a = C12258e.b.WRAP_CONTENT;
            if (z11 && c12258e.f56794x == 0) {
                aVar.f57284a = C12258e.b.FIXED;
            }
            z10 = false;
        }
        if (z11 && c12258e.m73602c0(1) && c12258e.f56794x == 0 && !z13) {
            aVar.f57285b = C12258e.b.WRAP_CONTENT;
            if (z10 && c12258e.f56792w == 0) {
                aVar.f57285b = C12258e.b.FIXED;
            }
            z11 = false;
        }
        if (c12258e.mo73515p0()) {
            aVar.f57284a = C12258e.b.FIXED;
            z10 = false;
        }
        if (c12258e.mo73516q0()) {
            aVar.f57285b = C12258e.b.FIXED;
            z11 = false;
        }
        if (z12) {
            if (c12258e.f56796y[0] == 4) {
                aVar.f57284a = C12258e.b.FIXED;
            } else if (!z11) {
                C12258e.b bVar4 = aVar.f57285b;
                C12258e.b bVar5 = C12258e.b.FIXED;
                if (bVar4 == bVar5) {
                    i13 = aVar.f57287d;
                } else {
                    aVar.f57284a = C12258e.b.WRAP_CONTENT;
                    bVar.mo3572b(c12258e, aVar);
                    i13 = aVar.f57289f;
                }
                aVar.f57284a = bVar5;
                aVar.f57286c = (int) (c12258e.m73658x() * i13);
            }
        }
        if (z13) {
            if (c12258e.f56796y[1] == 4) {
                aVar.f57285b = C12258e.b.FIXED;
            } else if (!z10) {
                C12258e.b bVar6 = aVar.f57284a;
                C12258e.b bVar7 = C12258e.b.FIXED;
                if (bVar6 == bVar7) {
                    i12 = aVar.f57286c;
                } else {
                    aVar.f57285b = C12258e.b.WRAP_CONTENT;
                    bVar.mo3572b(c12258e, aVar);
                    i12 = aVar.f57288e;
                }
                aVar.f57285b = bVar7;
                if (c12258e.m73660y() == -1) {
                    aVar.f57287d = (int) (i12 / c12258e.m73658x());
                } else {
                    aVar.f57287d = (int) (c12258e.m73658x() * i12);
                }
            }
        }
        bVar.mo3572b(c12258e, aVar);
        c12258e.m73638p1(aVar.f57288e);
        c12258e.m73579Q0(aVar.f57289f);
        c12258e.m73577P0(aVar.f57291h);
        c12258e.m73557F0(aVar.f57290g);
        aVar.f57293j = C12435b.a.f57281k;
        return aVar.f57292i;
    }

    /* renamed from: A1 */
    public void m73666A1(C12258e c12258e, int i10) {
        if (i10 == 0) {
            m73668C1(c12258e);
        } else if (i10 == 1) {
            m73673H1(c12258e);
        }
    }

    /* renamed from: B1 */
    public boolean m73667B1(C11574d c11574d) {
        boolean zM73690Z1 = m73690Z1(64);
        mo73512g(c11574d, zM73690Z1);
        int size = this.f56904V0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            C12258e c12258e = this.f56904V0.get(i10);
            c12258e.m73593X0(0, false);
            c12258e.m73593X0(1, false);
            if (c12258e instanceof C12254a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                C12258e c12258e2 = this.f56904V0.get(i11);
                if (c12258e2 instanceof C12254a) {
                    ((C12254a) c12258e2).m73508D1();
                }
            }
        }
        this.f56834y1.clear();
        for (int i12 = 0; i12 < size; i12++) {
            C12258e c12258e3 = this.f56904V0.get(i12);
            if (c12258e3.m73610f()) {
                if (c12258e3 instanceof C12266m) {
                    this.f56834y1.add(c12258e3);
                } else {
                    c12258e3.mo73512g(c11574d, zM73690Z1);
                }
            }
        }
        while (this.f56834y1.size() > 0) {
            int size2 = this.f56834y1.size();
            Iterator<C12258e> it = this.f56834y1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C12266m c12266m = (C12266m) it.next();
                if (c12266m.m73773A1(this.f56834y1)) {
                    c12266m.mo73512g(c11574d, zM73690Z1);
                    this.f56834y1.remove(c12266m);
                    break;
                }
            }
            if (size2 == this.f56834y1.size()) {
                Iterator<C12258e> it2 = this.f56834y1.iterator();
                while (it2.hasNext()) {
                    it2.next().mo73512g(c11574d, zM73690Z1);
                }
                this.f56834y1.clear();
            }
        }
        if (C11574d.f53660s) {
            HashSet<C12258e> hashSet = new HashSet<>();
            for (int i13 = 0; i13 < size; i13++) {
                C12258e c12258e4 = this.f56904V0.get(i13);
                if (!c12258e4.m73610f()) {
                    hashSet.add(c12258e4);
                }
            }
            m73607e(this, c11574d, hashSet, m73550C() == C12258e.b.WRAP_CONTENT ? 0 : 1, false);
            Iterator<C12258e> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                C12258e next = it3.next();
                C12264k.m73771a(this, c11574d, next);
                next.mo73512g(c11574d, zM73690Z1);
            }
        } else {
            for (int i14 = 0; i14 < size; i14++) {
                C12258e c12258e5 = this.f56904V0.get(i14);
                if (c12258e5 instanceof C12259f) {
                    C12258e.b[] bVarArr = c12258e5.f56751b0;
                    C12258e.b bVar = bVarArr[0];
                    C12258e.b bVar2 = bVarArr[1];
                    C12258e.b bVar3 = C12258e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        c12258e5.m73587U0(C12258e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        c12258e5.m73628l1(C12258e.b.FIXED);
                    }
                    c12258e5.mo73512g(c11574d, zM73690Z1);
                    if (bVar == bVar3) {
                        c12258e5.m73587U0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        c12258e5.m73628l1(bVar2);
                    }
                } else {
                    C12264k.m73771a(this, c11574d, c12258e5);
                    if (!c12258e5.m73610f()) {
                        c12258e5.mo73512g(c11574d, zM73690Z1);
                    }
                }
            }
        }
        if (this.f56816g1 > 0) {
            C12255b.m73520b(this, c11574d, null, 0);
        }
        if (this.f56817h1 > 0) {
            C12255b.m73520b(this, c11574d, null, 1);
        }
        return true;
    }

    /* renamed from: C1 */
    public final void m73668C1(C12258e c12258e) {
        int i10 = this.f56816g1 + 1;
        C12256c[] c12256cArr = this.f56819j1;
        if (i10 >= c12256cArr.length) {
            this.f56819j1 = (C12256c[]) Arrays.copyOf(c12256cArr, c12256cArr.length * 2);
        }
        this.f56819j1[this.f56816g1] = new C12256c(c12258e, 0, m73687V1());
        this.f56816g1++;
    }

    /* renamed from: D1 */
    public void m73669D1(C12257d c12257d) {
        WeakReference<C12257d> weakReference = this.f56833x1;
        if (weakReference == null || weakReference.get() == null || c12257d.m73528e() > this.f56833x1.get().m73528e()) {
            this.f56833x1 = new WeakReference<>(c12257d);
        }
    }

    /* renamed from: E1 */
    public void m73670E1(C12257d c12257d) {
        WeakReference<C12257d> weakReference = this.f56831v1;
        if (weakReference == null || weakReference.get() == null || c12257d.m73528e() > this.f56831v1.get().m73528e()) {
            this.f56831v1 = new WeakReference<>(c12257d);
        }
    }

    /* renamed from: F1 */
    public final void m73671F1(C12257d c12257d, C11579i c11579i) {
        this.f56811b1.m69099h(c11579i, this.f56811b1.m69108q(c12257d), 0, 5);
    }

    /* renamed from: G1 */
    public final void m73672G1(C12257d c12257d, C11579i c11579i) {
        this.f56811b1.m69099h(this.f56811b1.m69108q(c12257d), c11579i, 0, 5);
    }

    /* renamed from: H1 */
    public final void m73673H1(C12258e c12258e) {
        int i10 = this.f56817h1 + 1;
        C12256c[] c12256cArr = this.f56818i1;
        if (i10 >= c12256cArr.length) {
            this.f56818i1 = (C12256c[]) Arrays.copyOf(c12256cArr, c12256cArr.length * 2);
        }
        this.f56818i1[this.f56817h1] = new C12256c(c12258e, 1, m73687V1());
        this.f56817h1++;
    }

    /* renamed from: I1 */
    public void m73674I1(C12257d c12257d) {
        WeakReference<C12257d> weakReference = this.f56832w1;
        if (weakReference == null || weakReference.get() == null || c12257d.m73528e() > this.f56832w1.get().m73528e()) {
            this.f56832w1 = new WeakReference<>(c12257d);
        }
    }

    /* renamed from: J1 */
    public void m73675J1(C12257d c12257d) {
        WeakReference<C12257d> weakReference = this.f56830u1;
        if (weakReference == null || weakReference.get() == null || c12257d.m73528e() > this.f56830u1.get().m73528e()) {
            this.f56830u1 = new WeakReference<>(c12257d);
        }
    }

    /* renamed from: K1 */
    public boolean m73676K1(boolean z10) {
        return this.f56807X0.m74648f(z10);
    }

    /* renamed from: L1 */
    public boolean m73677L1(boolean z10) {
        return this.f56807X0.m74649g(z10);
    }

    /* renamed from: M1 */
    public boolean m73678M1(boolean z10, int i10) {
        return this.f56807X0.m74650h(z10, i10);
    }

    /* renamed from: N1 */
    public void m73679N1(C11575e c11575e) {
        this.f56811b1.m69112v(c11575e);
    }

    /* renamed from: O1 */
    public C12435b.b m73680O1() {
        return this.f56809Z0;
    }

    /* renamed from: P1 */
    public int m73681P1() {
        return this.f56825p1;
    }

    @Override // p561q.C12258e
    /* renamed from: Q */
    public void mo73578Q(StringBuilder sb2) {
        sb2.append(this.f56776o + ":{\n");
        sb2.append("  actualWidth:" + this.f56755d0);
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.f56757e0);
        sb2.append("\n");
        Iterator<C12258e> it = m73795w1().iterator();
        while (it.hasNext()) {
            it.next().mo73578Q(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    /* renamed from: Q1 */
    public C11574d m73682Q1() {
        return this.f56811b1;
    }

    /* renamed from: R1 */
    public boolean m73683R1() {
        return false;
    }

    /* renamed from: S1 */
    public void m73684S1() {
        this.f56807X0.m74652j();
    }

    /* renamed from: T1 */
    public void m73685T1() {
        this.f56807X0.m74653k();
    }

    /* renamed from: U1 */
    public boolean m73686U1() {
        return this.f56828s1;
    }

    /* renamed from: V1 */
    public boolean m73687V1() {
        return this.f56810a1;
    }

    /* renamed from: W1 */
    public boolean m73688W1() {
        return this.f56827r1;
    }

    /* renamed from: X1 */
    public long m73689X1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f56812c1 = i17;
        this.f56813d1 = i18;
        return this.f56806W0.m74632d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    /* renamed from: Z1 */
    public boolean m73690Z1(int i10) {
        return (this.f56825p1 & i10) == i10;
    }

    /* renamed from: a2 */
    public final void m73691a2() {
        this.f56816g1 = 0;
        this.f56817h1 = 0;
    }

    /* renamed from: b2 */
    public void m73692b2(C12435b.b bVar) {
        this.f56809Z0 = bVar;
        this.f56807X0.m74656n(bVar);
    }

    /* renamed from: c2 */
    public void m73693c2(int i10) {
        this.f56825p1 = i10;
        C11574d.f53660s = m73690Z1(512);
    }

    /* renamed from: d2 */
    public void m73694d2(int i10) {
        this.f56808Y0 = i10;
    }

    /* renamed from: e2 */
    public void m73695e2(boolean z10) {
        this.f56810a1 = z10;
    }

    /* renamed from: f2 */
    public boolean m73696f2(C11574d c11574d, boolean[] zArr) {
        zArr[2] = false;
        boolean zM73690Z1 = m73690Z1(64);
        mo73655v1(c11574d, zM73690Z1);
        int size = this.f56904V0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            C12258e c12258e = this.f56904V0.get(i10);
            c12258e.mo73655v1(c11574d, zM73690Z1);
            if (c12258e.m73608e0()) {
                z10 = true;
            }
        }
        return z10;
    }

    /* renamed from: g2 */
    public void m73697g2() {
        this.f56806W0.m74633e(this);
    }

    @Override // p561q.C12258e
    /* renamed from: u1 */
    public void mo73652u1(boolean z10, boolean z11) {
        super.mo73652u1(z10, z11);
        int size = this.f56904V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f56904V0.get(i10).mo73652u1(z10, z11);
        }
    }

    @Override // p561q.C12267n, p561q.C12258e
    /* renamed from: v0 */
    public void mo73654v0() {
        this.f56811b1.m69091E();
        this.f56812c1 = 0;
        this.f56814e1 = 0;
        this.f56813d1 = 0;
        this.f56815f1 = 0;
        this.f56826q1 = false;
        super.mo73654v0();
    }

    /* JADX WARN: Removed duplicated region for block: B:331:0x0307 A[PHI: r2 r16
  0x0307: PHI (r2v15 boolean) = (r2v14 boolean), (r2v19 boolean), (r2v19 boolean), (r2v19 boolean) binds: [B:318:0x02c8, B:326:0x02ed, B:327:0x02ef, B:329:0x02f5] A[DONT_GENERATE, DONT_INLINE]
  0x0307: PHI (r16v4 boolean) = (r16v3 boolean), (r16v5 boolean), (r16v5 boolean), (r16v5 boolean) binds: [B:318:0x02c8, B:326:0x02ed, B:327:0x02ef, B:329:0x02f5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // p561q.C12267n
    /* renamed from: x1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo73698x1() {
        /*
            Method dump skipped, instructions count: 813
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p561q.C12259f.mo73698x1():void");
    }
}
