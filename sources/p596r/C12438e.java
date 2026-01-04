package p596r;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p561q.C12257d;
import p561q.C12258e;
import p561q.C12259f;
import p561q.C12261h;
import p561q.C12263j;
import p596r.C12435b;

/* renamed from: r.e */
/* loaded from: classes.dex */
public class C12438e {

    /* renamed from: a */
    public C12259f f57296a;

    /* renamed from: d */
    public C12259f f57299d;

    /* renamed from: b */
    public boolean f57297b = true;

    /* renamed from: c */
    public boolean f57298c = true;

    /* renamed from: e */
    public ArrayList<AbstractC12449p> f57300e = new ArrayList<>();

    /* renamed from: f */
    public ArrayList<C12446m> f57301f = new ArrayList<>();

    /* renamed from: g */
    public C12435b.b f57302g = null;

    /* renamed from: h */
    public C12435b.a f57303h = new C12435b.a();

    /* renamed from: i */
    public ArrayList<C12446m> f57304i = new ArrayList<>();

    public C12438e(C12259f c12259f) {
        this.f57296a = c12259f;
        this.f57299d = c12259f;
    }

    /* renamed from: a */
    public final void m74643a(C12439f c12439f, int i10, int i11, C12439f c12439f2, ArrayList<C12446m> arrayList, C12446m c12446m) {
        AbstractC12449p abstractC12449p = c12439f.f57308d;
        if (abstractC12449p.f57359c == null) {
            C12259f c12259f = this.f57296a;
            if (abstractC12449p == c12259f.f56756e || abstractC12449p == c12259f.f56758f) {
                return;
            }
            if (c12446m == null) {
                c12446m = new C12446m(abstractC12449p, i11);
                arrayList.add(c12446m);
            }
            abstractC12449p.f57359c = c12446m;
            c12446m.m74678a(abstractC12449p);
            for (InterfaceC12437d interfaceC12437d : abstractC12449p.f57364h.f57315k) {
                if (interfaceC12437d instanceof C12439f) {
                    m74643a((C12439f) interfaceC12437d, i10, 0, c12439f2, arrayList, c12446m);
                }
            }
            for (InterfaceC12437d interfaceC12437d2 : abstractC12449p.f57365i.f57315k) {
                if (interfaceC12437d2 instanceof C12439f) {
                    m74643a((C12439f) interfaceC12437d2, i10, 1, c12439f2, arrayList, c12446m);
                }
            }
            if (i10 == 1 && (abstractC12449p instanceof C12447n)) {
                for (InterfaceC12437d interfaceC12437d3 : ((C12447n) abstractC12449p).f57340k.f57315k) {
                    if (interfaceC12437d3 instanceof C12439f) {
                        m74643a((C12439f) interfaceC12437d3, i10, 2, c12439f2, arrayList, c12446m);
                    }
                }
            }
            for (C12439f c12439f3 : abstractC12449p.f57364h.f57316l) {
                if (c12439f3 == c12439f2) {
                    c12446m.f57334b = true;
                }
                m74643a(c12439f3, i10, 0, c12439f2, arrayList, c12446m);
            }
            for (C12439f c12439f4 : abstractC12449p.f57365i.f57316l) {
                if (c12439f4 == c12439f2) {
                    c12446m.f57334b = true;
                }
                m74643a(c12439f4, i10, 1, c12439f2, arrayList, c12446m);
            }
            if (i10 == 1 && (abstractC12449p instanceof C12447n)) {
                Iterator<C12439f> it = ((C12447n) abstractC12449p).f57340k.f57316l.iterator();
                while (it.hasNext()) {
                    m74643a(it.next(), i10, 2, c12439f2, arrayList, c12446m);
                }
            }
        }
    }

    /* renamed from: b */
    public final boolean m74644b(C12259f c12259f) {
        int iM73594Y;
        C12258e.b bVar;
        int iM73662z;
        C12258e.b bVar2;
        C12258e.b bVar3;
        C12258e.b bVar4;
        Iterator<C12258e> it = c12259f.f56904V0.iterator();
        while (it.hasNext()) {
            C12258e next = it.next();
            C12258e.b[] bVarArr = next.f56751b0;
            C12258e.b bVar5 = bVarArr[0];
            C12258e.b bVar6 = bVarArr[1];
            if (next.m73592X() == 8) {
                next.f56748a = true;
            } else {
                if (next.f56704B < 1.0f && bVar5 == C12258e.b.MATCH_CONSTRAINT) {
                    next.f56792w = 2;
                }
                if (next.f56710E < 1.0f && bVar6 == C12258e.b.MATCH_CONSTRAINT) {
                    next.f56794x = 2;
                }
                if (next.m73658x() > 0.0f) {
                    C12258e.b bVar7 = C12258e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == C12258e.b.WRAP_CONTENT || bVar6 == C12258e.b.FIXED)) {
                        next.f56792w = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == C12258e.b.WRAP_CONTENT || bVar5 == C12258e.b.FIXED)) {
                        next.f56794x = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (next.f56792w == 0) {
                            next.f56792w = 3;
                        }
                        if (next.f56794x == 0) {
                            next.f56794x = 3;
                        }
                    }
                }
                C12258e.b bVar8 = C12258e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && next.f56792w == 1 && (next.f56734Q.f56687f == null || next.f56738S.f56687f == null)) {
                    bVar5 = C12258e.b.WRAP_CONTENT;
                }
                C12258e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && next.f56794x == 1 && (next.f56736R.f56687f == null || next.f56740T.f56687f == null)) {
                    bVar6 = C12258e.b.WRAP_CONTENT;
                }
                C12258e.b bVar10 = bVar6;
                C12445l c12445l = next.f56756e;
                c12445l.f57360d = bVar9;
                int i10 = next.f56792w;
                c12445l.f57357a = i10;
                C12447n c12447n = next.f56758f;
                c12447n.f57360d = bVar10;
                int i11 = next.f56794x;
                c12447n.f57357a = i11;
                C12258e.b bVar11 = C12258e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == C12258e.b.FIXED || bVar9 == C12258e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == C12258e.b.FIXED || bVar10 == C12258e.b.WRAP_CONTENT)) {
                    int iM73594Y2 = next.m73594Y();
                    if (bVar9 == bVar11) {
                        iM73594Y = (c12259f.m73594Y() - next.f56734Q.f56688g) - next.f56738S.f56688g;
                        bVar = C12258e.b.FIXED;
                    } else {
                        iM73594Y = iM73594Y2;
                        bVar = bVar9;
                    }
                    int iM73662z2 = next.m73662z();
                    if (bVar10 == bVar11) {
                        iM73662z = (c12259f.m73662z() - next.f56736R.f56688g) - next.f56740T.f56688g;
                        bVar2 = C12258e.b.FIXED;
                    } else {
                        iM73662z = iM73662z2;
                        bVar2 = bVar10;
                    }
                    m74654l(next, bVar, iM73594Y, bVar2, iM73662z);
                    next.f56756e.f57361e.mo74659d(next.m73594Y());
                    next.f56758f.f57361e.mo74659d(next.m73662z());
                    next.f56748a = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = C12258e.b.WRAP_CONTENT) || bVar10 == C12258e.b.FIXED)) {
                        if (i10 == 3) {
                            if (bVar10 == bVar4) {
                                m74654l(next, bVar4, 0, bVar4, 0);
                            }
                            int iM73662z3 = next.m73662z();
                            int i12 = (int) ((iM73662z3 * next.f56759f0) + 0.5f);
                            C12258e.b bVar12 = C12258e.b.FIXED;
                            m74654l(next, bVar12, i12, bVar12, iM73662z3);
                            next.f56756e.f57361e.mo74659d(next.m73594Y());
                            next.f56758f.f57361e.mo74659d(next.m73662z());
                            next.f56748a = true;
                        } else if (i10 == 1) {
                            m74654l(next, bVar4, 0, bVar10, 0);
                            next.f56756e.f57361e.f57326m = next.m73594Y();
                        } else if (i10 == 2) {
                            C12258e.b bVar13 = c12259f.f56751b0[0];
                            C12258e.b bVar14 = C12258e.b.FIXED;
                            if (bVar13 == bVar14 || bVar13 == bVar11) {
                                m74654l(next, bVar14, (int) ((next.f56704B * c12259f.m73594Y()) + 0.5f), bVar10, next.m73662z());
                                next.f56756e.f57361e.mo74659d(next.m73594Y());
                                next.f56758f.f57361e.mo74659d(next.m73662z());
                                next.f56748a = true;
                            }
                        } else {
                            C12257d[] c12257dArr = next.f56746Y;
                            if (c12257dArr[0].f56687f == null || c12257dArr[1].f56687f == null) {
                                m74654l(next, bVar4, 0, bVar10, 0);
                                next.f56756e.f57361e.mo74659d(next.m73594Y());
                                next.f56758f.f57361e.mo74659d(next.m73662z());
                                next.f56748a = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = C12258e.b.WRAP_CONTENT) || bVar9 == C12258e.b.FIXED)) {
                        if (i11 == 3) {
                            if (bVar9 == bVar3) {
                                m74654l(next, bVar3, 0, bVar3, 0);
                            }
                            int iM73594Y3 = next.m73594Y();
                            float f10 = next.f56759f0;
                            if (next.m73660y() == -1) {
                                f10 = 1.0f / f10;
                            }
                            C12258e.b bVar15 = C12258e.b.FIXED;
                            m74654l(next, bVar15, iM73594Y3, bVar15, (int) ((iM73594Y3 * f10) + 0.5f));
                            next.f56756e.f57361e.mo74659d(next.m73594Y());
                            next.f56758f.f57361e.mo74659d(next.m73662z());
                            next.f56748a = true;
                        } else if (i11 == 1) {
                            m74654l(next, bVar9, 0, bVar3, 0);
                            next.f56758f.f57361e.f57326m = next.m73662z();
                        } else if (i11 == 2) {
                            C12258e.b bVar16 = c12259f.f56751b0[1];
                            C12258e.b bVar17 = C12258e.b.FIXED;
                            if (bVar16 == bVar17 || bVar16 == bVar11) {
                                m74654l(next, bVar9, next.m73594Y(), bVar17, (int) ((next.f56710E * c12259f.m73662z()) + 0.5f));
                                next.f56756e.f57361e.mo74659d(next.m73594Y());
                                next.f56758f.f57361e.mo74659d(next.m73662z());
                                next.f56748a = true;
                            }
                        } else {
                            C12257d[] c12257dArr2 = next.f56746Y;
                            if (c12257dArr2[2].f56687f == null || c12257dArr2[3].f56687f == null) {
                                m74654l(next, bVar3, 0, bVar10, 0);
                                next.f56756e.f57361e.mo74659d(next.m73594Y());
                                next.f56758f.f57361e.mo74659d(next.m73662z());
                                next.f56748a = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i10 == 1 || i11 == 1) {
                            C12258e.b bVar18 = C12258e.b.WRAP_CONTENT;
                            m74654l(next, bVar18, 0, bVar18, 0);
                            next.f56756e.f57361e.f57326m = next.m73594Y();
                            next.f56758f.f57361e.f57326m = next.m73662z();
                        } else if (i11 == 2 && i10 == 2) {
                            C12258e.b[] bVarArr2 = c12259f.f56751b0;
                            C12258e.b bVar19 = bVarArr2[0];
                            C12258e.b bVar20 = C12258e.b.FIXED;
                            if (bVar19 == bVar20 && bVarArr2[1] == bVar20) {
                                m74654l(next, bVar20, (int) ((next.f56704B * c12259f.m73594Y()) + 0.5f), bVar20, (int) ((next.f56710E * c12259f.m73662z()) + 0.5f));
                                next.f56756e.f57361e.mo74659d(next.m73594Y());
                                next.f56758f.f57361e.mo74659d(next.m73662z());
                                next.f56748a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m74645c() {
        m74646d(this.f57300e);
        this.f57304i.clear();
        C12446m.f57332h = 0;
        m74651i(this.f57296a.f56756e, 0, this.f57304i);
        m74651i(this.f57296a.f56758f, 1, this.f57304i);
        this.f57297b = false;
    }

    /* renamed from: d */
    public void m74646d(ArrayList<AbstractC12449p> arrayList) {
        arrayList.clear();
        this.f57299d.f56756e.mo74637f();
        this.f57299d.f56758f.mo74637f();
        arrayList.add(this.f57299d.f56756e);
        arrayList.add(this.f57299d.f56758f);
        Iterator<C12258e> it = this.f57299d.f56904V0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            C12258e next = it.next();
            if (next instanceof C12261h) {
                arrayList.add(new C12443j(next));
            } else {
                if (next.m73624k0()) {
                    if (next.f56752c == null) {
                        next.f56752c = new C12436c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f56752c);
                } else {
                    arrayList.add(next.f56756e);
                }
                if (next.m73630m0()) {
                    if (next.f56754d == null) {
                        next.f56754d = new C12436c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f56754d);
                } else {
                    arrayList.add(next.f56758f);
                }
                if (next instanceof C12263j) {
                    arrayList.add(new C12444k(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<AbstractC12449p> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().mo74637f();
        }
        Iterator<AbstractC12449p> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            AbstractC12449p next2 = it3.next();
            if (next2.f57358b != this.f57299d) {
                next2.mo74635d();
            }
        }
    }

    /* renamed from: e */
    public final int m74647e(C12259f c12259f, int i10) {
        int size = this.f57304i.size();
        long jMax = 0;
        for (int i11 = 0; i11 < size; i11++) {
            jMax = Math.max(jMax, this.f57304i.get(i11).m74679b(c12259f, i10));
        }
        return (int) jMax;
    }

    /* renamed from: f */
    public boolean m74648f(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        if (this.f57297b || this.f57298c) {
            Iterator<C12258e> it = this.f57296a.f56904V0.iterator();
            while (it.hasNext()) {
                C12258e next = it.next();
                next.m73637p();
                next.f56748a = false;
                next.f56756e.m74677r();
                next.f56758f.m74682q();
            }
            this.f57296a.m73637p();
            C12259f c12259f = this.f57296a;
            c12259f.f56748a = false;
            c12259f.f56756e.m74677r();
            this.f57296a.f56758f.m74682q();
            this.f57298c = false;
        }
        if (m74644b(this.f57299d)) {
            return false;
        }
        this.f57296a.m73643r1(0);
        this.f57296a.m73646s1(0);
        C12258e.b bVarM73656w = this.f57296a.m73656w(0);
        C12258e.b bVarM73656w2 = this.f57296a.m73656w(1);
        if (this.f57297b) {
            m74645c();
        }
        int iM73596Z = this.f57296a.m73596Z();
        int iM73598a0 = this.f57296a.m73598a0();
        this.f57296a.f56756e.f57364h.mo74659d(iM73596Z);
        this.f57296a.f56758f.f57364h.mo74659d(iM73598a0);
        m74655m();
        C12258e.b bVar = C12258e.b.WRAP_CONTENT;
        if (bVarM73656w == bVar || bVarM73656w2 == bVar) {
            if (z13) {
                Iterator<AbstractC12449p> it2 = this.f57300e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().mo74639m()) {
                        z13 = false;
                        break;
                    }
                }
            }
            if (z13 && bVarM73656w == C12258e.b.WRAP_CONTENT) {
                this.f57296a.m73587U0(C12258e.b.FIXED);
                C12259f c12259f2 = this.f57296a;
                c12259f2.m73638p1(m74647e(c12259f2, 0));
                C12259f c12259f3 = this.f57296a;
                c12259f3.f56756e.f57361e.mo74659d(c12259f3.m73594Y());
            }
            if (z13 && bVarM73656w2 == C12258e.b.WRAP_CONTENT) {
                this.f57296a.m73628l1(C12258e.b.FIXED);
                C12259f c12259f4 = this.f57296a;
                c12259f4.m73579Q0(m74647e(c12259f4, 1));
                C12259f c12259f5 = this.f57296a;
                c12259f5.f56758f.f57361e.mo74659d(c12259f5.m73662z());
            }
        }
        C12259f c12259f6 = this.f57296a;
        C12258e.b bVar2 = c12259f6.f56751b0[0];
        C12258e.b bVar3 = C12258e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == C12258e.b.MATCH_PARENT) {
            int iM73594Y = c12259f6.m73594Y() + iM73596Z;
            this.f57296a.f56756e.f57365i.mo74659d(iM73594Y);
            this.f57296a.f56756e.f57361e.mo74659d(iM73594Y - iM73596Z);
            m74655m();
            C12259f c12259f7 = this.f57296a;
            C12258e.b bVar4 = c12259f7.f56751b0[1];
            if (bVar4 == bVar3 || bVar4 == C12258e.b.MATCH_PARENT) {
                int iM73662z = c12259f7.m73662z() + iM73598a0;
                this.f57296a.f56758f.f57365i.mo74659d(iM73662z);
                this.f57296a.f56758f.f57361e.mo74659d(iM73662z - iM73598a0);
            }
            m74655m();
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<AbstractC12449p> it3 = this.f57300e.iterator();
        while (it3.hasNext()) {
            AbstractC12449p next2 = it3.next();
            if (next2.f57358b != this.f57296a || next2.f57363g) {
                next2.mo74636e();
            }
        }
        Iterator<AbstractC12449p> it4 = this.f57300e.iterator();
        while (it4.hasNext()) {
            AbstractC12449p next3 = it4.next();
            if (z11 || next3.f57358b != this.f57296a) {
                if (!next3.f57364h.f57314j || ((!next3.f57365i.f57314j && !(next3 instanceof C12443j)) || (!next3.f57361e.f57314j && !(next3 instanceof C12436c) && !(next3 instanceof C12443j)))) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f57296a.m73587U0(bVarM73656w);
        this.f57296a.m73628l1(bVarM73656w2);
        return z12;
    }

    /* renamed from: g */
    public boolean m74649g(boolean z10) {
        if (this.f57297b) {
            Iterator<C12258e> it = this.f57296a.f56904V0.iterator();
            while (it.hasNext()) {
                C12258e next = it.next();
                next.m73637p();
                next.f56748a = false;
                C12445l c12445l = next.f56756e;
                c12445l.f57361e.f57314j = false;
                c12445l.f57363g = false;
                c12445l.m74677r();
                C12447n c12447n = next.f56758f;
                c12447n.f57361e.f57314j = false;
                c12447n.f57363g = false;
                c12447n.m74682q();
            }
            this.f57296a.m73637p();
            C12259f c12259f = this.f57296a;
            c12259f.f56748a = false;
            C12445l c12445l2 = c12259f.f56756e;
            c12445l2.f57361e.f57314j = false;
            c12445l2.f57363g = false;
            c12445l2.m74677r();
            C12447n c12447n2 = this.f57296a.f56758f;
            c12447n2.f57361e.f57314j = false;
            c12447n2.f57363g = false;
            c12447n2.m74682q();
            m74645c();
        }
        if (m74644b(this.f57299d)) {
            return false;
        }
        this.f57296a.m73643r1(0);
        this.f57296a.m73646s1(0);
        this.f57296a.f56756e.f57364h.mo74659d(0);
        this.f57296a.f56758f.f57364h.mo74659d(0);
        return true;
    }

    /* renamed from: h */
    public boolean m74650h(boolean z10, int i10) {
        boolean z11;
        C12258e.b bVar;
        boolean z12 = true;
        boolean z13 = z10 & true;
        C12258e.b bVarM73656w = this.f57296a.m73656w(0);
        C12258e.b bVarM73656w2 = this.f57296a.m73656w(1);
        int iM73596Z = this.f57296a.m73596Z();
        int iM73598a0 = this.f57296a.m73598a0();
        if (z13 && (bVarM73656w == (bVar = C12258e.b.WRAP_CONTENT) || bVarM73656w2 == bVar)) {
            Iterator<AbstractC12449p> it = this.f57300e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC12449p next = it.next();
                if (next.f57362f == i10 && !next.mo74639m()) {
                    z13 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z13 && bVarM73656w == C12258e.b.WRAP_CONTENT) {
                    this.f57296a.m73587U0(C12258e.b.FIXED);
                    C12259f c12259f = this.f57296a;
                    c12259f.m73638p1(m74647e(c12259f, 0));
                    C12259f c12259f2 = this.f57296a;
                    c12259f2.f56756e.f57361e.mo74659d(c12259f2.m73594Y());
                }
            } else if (z13 && bVarM73656w2 == C12258e.b.WRAP_CONTENT) {
                this.f57296a.m73628l1(C12258e.b.FIXED);
                C12259f c12259f3 = this.f57296a;
                c12259f3.m73579Q0(m74647e(c12259f3, 1));
                C12259f c12259f4 = this.f57296a;
                c12259f4.f56758f.f57361e.mo74659d(c12259f4.m73662z());
            }
        }
        if (i10 == 0) {
            C12259f c12259f5 = this.f57296a;
            C12258e.b bVar2 = c12259f5.f56751b0[0];
            if (bVar2 == C12258e.b.FIXED || bVar2 == C12258e.b.MATCH_PARENT) {
                int iM73594Y = c12259f5.m73594Y() + iM73596Z;
                this.f57296a.f56756e.f57365i.mo74659d(iM73594Y);
                this.f57296a.f56756e.f57361e.mo74659d(iM73594Y - iM73596Z);
                z11 = true;
            }
            z11 = false;
        } else {
            C12259f c12259f6 = this.f57296a;
            C12258e.b bVar3 = c12259f6.f56751b0[1];
            if (bVar3 == C12258e.b.FIXED || bVar3 == C12258e.b.MATCH_PARENT) {
                int iM73662z = c12259f6.m73662z() + iM73598a0;
                this.f57296a.f56758f.f57365i.mo74659d(iM73662z);
                this.f57296a.f56758f.f57361e.mo74659d(iM73662z - iM73598a0);
                z11 = true;
            }
            z11 = false;
        }
        m74655m();
        Iterator<AbstractC12449p> it2 = this.f57300e.iterator();
        while (it2.hasNext()) {
            AbstractC12449p next2 = it2.next();
            if (next2.f57362f == i10 && (next2.f57358b != this.f57296a || next2.f57363g)) {
                next2.mo74636e();
            }
        }
        Iterator<AbstractC12449p> it3 = this.f57300e.iterator();
        while (it3.hasNext()) {
            AbstractC12449p next3 = it3.next();
            if (next3.f57362f == i10 && (z11 || next3.f57358b != this.f57296a)) {
                if (!next3.f57364h.f57314j || !next3.f57365i.f57314j || (!(next3 instanceof C12436c) && !next3.f57361e.f57314j)) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f57296a.m73587U0(bVarM73656w);
        this.f57296a.m73628l1(bVarM73656w2);
        return z12;
    }

    /* renamed from: i */
    public final void m74651i(AbstractC12449p abstractC12449p, int i10, ArrayList<C12446m> arrayList) {
        for (InterfaceC12437d interfaceC12437d : abstractC12449p.f57364h.f57315k) {
            if (interfaceC12437d instanceof C12439f) {
                m74643a((C12439f) interfaceC12437d, i10, 0, abstractC12449p.f57365i, arrayList, null);
            } else if (interfaceC12437d instanceof AbstractC12449p) {
                m74643a(((AbstractC12449p) interfaceC12437d).f57364h, i10, 0, abstractC12449p.f57365i, arrayList, null);
            }
        }
        for (InterfaceC12437d interfaceC12437d2 : abstractC12449p.f57365i.f57315k) {
            if (interfaceC12437d2 instanceof C12439f) {
                m74643a((C12439f) interfaceC12437d2, i10, 1, abstractC12449p.f57364h, arrayList, null);
            } else if (interfaceC12437d2 instanceof AbstractC12449p) {
                m74643a(((AbstractC12449p) interfaceC12437d2).f57365i, i10, 1, abstractC12449p.f57364h, arrayList, null);
            }
        }
        if (i10 == 1) {
            for (InterfaceC12437d interfaceC12437d3 : ((C12447n) abstractC12449p).f57340k.f57315k) {
                if (interfaceC12437d3 instanceof C12439f) {
                    m74643a((C12439f) interfaceC12437d3, i10, 2, null, arrayList, null);
                }
            }
        }
    }

    /* renamed from: j */
    public void m74652j() {
        this.f57297b = true;
    }

    /* renamed from: k */
    public void m74653k() {
        this.f57298c = true;
    }

    /* renamed from: l */
    public final void m74654l(C12258e c12258e, C12258e.b bVar, int i10, C12258e.b bVar2, int i11) {
        C12435b.a aVar = this.f57303h;
        aVar.f57284a = bVar;
        aVar.f57285b = bVar2;
        aVar.f57286c = i10;
        aVar.f57287d = i11;
        this.f57302g.mo3572b(c12258e, aVar);
        c12258e.m73638p1(this.f57303h.f57288e);
        c12258e.m73579Q0(this.f57303h.f57289f);
        c12258e.m73577P0(this.f57303h.f57291h);
        c12258e.m73557F0(this.f57303h.f57290g);
    }

    /* renamed from: m */
    public void m74655m() {
        C12440g c12440g;
        Iterator<C12258e> it = this.f57296a.f56904V0.iterator();
        while (it.hasNext()) {
            C12258e next = it.next();
            if (!next.f56748a) {
                C12258e.b[] bVarArr = next.f56751b0;
                boolean z10 = false;
                C12258e.b bVar = bVarArr[0];
                C12258e.b bVar2 = bVarArr[1];
                int i10 = next.f56792w;
                int i11 = next.f56794x;
                C12258e.b bVar3 = C12258e.b.WRAP_CONTENT;
                boolean z11 = bVar == bVar3 || (bVar == C12258e.b.MATCH_CONSTRAINT && i10 == 1);
                if (bVar2 == bVar3 || (bVar2 == C12258e.b.MATCH_CONSTRAINT && i11 == 1)) {
                    z10 = true;
                }
                C12440g c12440g2 = next.f56756e.f57361e;
                boolean z12 = c12440g2.f57314j;
                C12440g c12440g3 = next.f56758f.f57361e;
                boolean z13 = c12440g3.f57314j;
                if (z12 && z13) {
                    C12258e.b bVar4 = C12258e.b.FIXED;
                    m74654l(next, bVar4, c12440g2.f57311g, bVar4, c12440g3.f57311g);
                    next.f56748a = true;
                } else if (z12 && z10) {
                    m74654l(next, C12258e.b.FIXED, c12440g2.f57311g, bVar3, c12440g3.f57311g);
                    if (bVar2 == C12258e.b.MATCH_CONSTRAINT) {
                        next.f56758f.f57361e.f57326m = next.m73662z();
                    } else {
                        next.f56758f.f57361e.mo74659d(next.m73662z());
                        next.f56748a = true;
                    }
                } else if (z13 && z11) {
                    m74654l(next, bVar3, c12440g2.f57311g, C12258e.b.FIXED, c12440g3.f57311g);
                    if (bVar == C12258e.b.MATCH_CONSTRAINT) {
                        next.f56756e.f57361e.f57326m = next.m73594Y();
                    } else {
                        next.f56756e.f57361e.mo74659d(next.m73594Y());
                        next.f56748a = true;
                    }
                }
                if (next.f56748a && (c12440g = next.f56758f.f57341l) != null) {
                    c12440g.mo74659d(next.m73641r());
                }
            }
        }
    }

    /* renamed from: n */
    public void m74656n(C12435b.b bVar) {
        this.f57302g = bVar;
    }
}
