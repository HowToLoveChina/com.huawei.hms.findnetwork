package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1909e0;
import com.google.crypto.tink.shaded.protobuf.C1958u1;
import com.google.crypto.tink.shaded.protobuf.C1959v;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.w0 */
/* loaded from: classes.dex */
public final class C1963w0<T> implements InterfaceC1919h1<T> {

    /* renamed from: a */
    public final InterfaceC1951s0 f9414a;

    /* renamed from: b */
    public final AbstractC1940o1<?, ?> f9415b;

    /* renamed from: c */
    public final boolean f9416c;

    /* renamed from: d */
    public final AbstractC1947r<?> f9417d;

    public C1963w0(AbstractC1940o1<?, ?> abstractC1940o1, AbstractC1947r<?> abstractC1947r, InterfaceC1951s0 interfaceC1951s0) {
        this.f9415b = abstractC1940o1;
        this.f9416c = abstractC1947r.mo12125e(interfaceC1951s0);
        this.f9417d = abstractC1947r;
        this.f9414a = interfaceC1951s0;
    }

    /* renamed from: k */
    private <UT, UB> int m12358k(AbstractC1940o1<UT, UB> abstractC1940o1, T t10) {
        return abstractC1940o1.mo12068i(abstractC1940o1.mo12066g(t10));
    }

    /* renamed from: l */
    private <UT, UB, ET extends C1959v.b<ET>> void m12359l(AbstractC1940o1<UT, UB> abstractC1940o1, AbstractC1947r<ET> abstractC1947r, T t10, InterfaceC1916g1 interfaceC1916g1, C1944q c1944q) throws IOException {
        UB ubMo12065f = abstractC1940o1.mo12065f(t10);
        C1959v<ET> c1959vMo12124d = abstractC1947r.mo12124d(t10);
        do {
            try {
                if (interfaceC1916g1.mo11571B() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                abstractC1940o1.mo12074o(t10, ubMo12065f);
            }
        } while (m12361n(interfaceC1916g1, c1944q, abstractC1947r, c1959vMo12124d, abstractC1940o1, ubMo12065f));
    }

    /* renamed from: m */
    public static <T> C1963w0<T> m12360m(AbstractC1940o1<?, ?> abstractC1940o1, AbstractC1947r<?> abstractC1947r, InterfaceC1951s0 interfaceC1951s0) {
        return new C1963w0<>(abstractC1940o1, abstractC1947r, interfaceC1951s0);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: a */
    public void mo11667a(T t10, T t11) {
        C1925j1.m11779G(this.f9415b, t10, t11);
        if (this.f9416c) {
            C1925j1.m11777E(this.f9417d, t10, t11);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: b */
    public void mo11668b(T t10) {
        this.f9415b.mo12069j(t10);
        this.f9417d.mo12126f(t10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: c */
    public final boolean mo11669c(T t10) {
        return this.f9417d.mo12123c(t10).m12278o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00cb A[EDGE_INSN: B:122:0x00cb->B:100:0x00cb BREAK  A[LOOP:1: B:84:0x006d->B:127:0x006d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c6  */
    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo11670d(T r11, byte[] r12, int r13, int r14, com.google.crypto.tink.shaded.protobuf.C1908e.b r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.crypto.tink.shaded.protobuf.z r0 = (com.google.crypto.tink.shaded.protobuf.AbstractC1968z) r0
            com.google.crypto.tink.shaded.protobuf.p1 r1 = r0.unknownFields
            com.google.crypto.tink.shaded.protobuf.p1 r2 = com.google.crypto.tink.shaded.protobuf.C1943p1.m12088e()
            if (r1 != r2) goto L11
            com.google.crypto.tink.shaded.protobuf.p1 r1 = com.google.crypto.tink.shaded.protobuf.C1943p1.m12092l()
            r0.unknownFields = r1
        L11:
            com.google.crypto.tink.shaded.protobuf.z$c r11 = (com.google.crypto.tink.shaded.protobuf.AbstractC1968z.c) r11
            com.google.crypto.tink.shaded.protobuf.v r11 = r11.m12409M()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.crypto.tink.shaded.protobuf.C1908e.m11529I(r12, r13, r15)
            int r13 = r15.f9115a
            int r3 = com.google.crypto.tink.shaded.protobuf.C1958u1.f9283a
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.crypto.tink.shaded.protobuf.C1958u1.m12258b(r13)
            if (r3 != r5) goto L66
            com.google.crypto.tink.shaded.protobuf.r<?> r2 = r10.f9417d
            com.google.crypto.tink.shaded.protobuf.q r3 = r15.f9118d
            com.google.crypto.tink.shaded.protobuf.s0 r5 = r10.f9414a
            int r6 = com.google.crypto.tink.shaded.protobuf.C1958u1.m12257a(r13)
            java.lang.Object r2 = r2.mo12122b(r3, r5, r6)
            r8 = r2
            com.google.crypto.tink.shaded.protobuf.z$e r8 = (com.google.crypto.tink.shaded.protobuf.AbstractC1968z.e) r8
            if (r8 == 0) goto L5c
            com.google.crypto.tink.shaded.protobuf.d1 r13 = com.google.crypto.tink.shaded.protobuf.C1907d1.m11516a()
            com.google.crypto.tink.shaded.protobuf.s0 r2 = r8.m12413b()
            java.lang.Class r2 = r2.getClass()
            com.google.crypto.tink.shaded.protobuf.h1 r13 = r13.m11519d(r2)
            int r13 = com.google.crypto.tink.shaded.protobuf.C1908e.m11550p(r13, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.z$d r2 = r8.f9432b
            java.lang.Object r3 = r15.f9117c
            r11.m12283w(r2, r3)
        L5a:
            r2 = r8
            goto L19
        L5c:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.crypto.tink.shaded.protobuf.C1908e.m11527G(r2, r3, r4, r5, r6, r7)
            goto L5a
        L66:
            int r13 = com.google.crypto.tink.shaded.protobuf.C1908e.m11534N(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.crypto.tink.shaded.protobuf.C1908e.m11529I(r12, r4, r15)
            int r6 = r15.f9115a
            int r7 = com.google.crypto.tink.shaded.protobuf.C1958u1.m12257a(r6)
            int r8 = com.google.crypto.tink.shaded.protobuf.C1958u1.m12258b(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.crypto.tink.shaded.protobuf.d1 r6 = com.google.crypto.tink.shaded.protobuf.C1907d1.m11516a()
            com.google.crypto.tink.shaded.protobuf.s0 r7 = r2.m12413b()
            java.lang.Class r7 = r7.getClass()
            com.google.crypto.tink.shaded.protobuf.h1 r6 = r6.m11519d(r7)
            int r4 = com.google.crypto.tink.shaded.protobuf.C1908e.m11550p(r6, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.z$d r6 = r2.f9432b
            java.lang.Object r7 = r15.f9117c
            r11.m12283w(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.crypto.tink.shaded.protobuf.C1908e.m11536b(r12, r4, r15)
            java.lang.Object r3 = r15.f9117c
            com.google.crypto.tink.shaded.protobuf.i r3 = (com.google.crypto.tink.shaded.protobuf.AbstractC1920i) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.crypto.tink.shaded.protobuf.C1908e.m11529I(r12, r4, r15)
            int r13 = r15.f9115a
            com.google.crypto.tink.shaded.protobuf.r<?> r2 = r10.f9417d
            com.google.crypto.tink.shaded.protobuf.q r6 = r15.f9118d
            com.google.crypto.tink.shaded.protobuf.s0 r7 = r10.f9414a
            java.lang.Object r2 = r2.mo12122b(r6, r7, r13)
            com.google.crypto.tink.shaded.protobuf.z$e r2 = (com.google.crypto.tink.shaded.protobuf.AbstractC1968z.e) r2
            goto L6d
        Lc1:
            int r7 = com.google.crypto.tink.shaded.protobuf.C1958u1.f9284b
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.crypto.tink.shaded.protobuf.C1908e.m11534N(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.crypto.tink.shaded.protobuf.C1958u1.m12259c(r13, r5)
            r1.m12100n(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.crypto.tink.shaded.protobuf.c0 r10 = com.google.crypto.tink.shaded.protobuf.C1903c0.m11508h()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1963w0.mo11670d(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.e$b):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: e */
    public void mo11671e(T t10, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        Iterator itM12279r = this.f9417d.mo12123c(t10).m12279r();
        while (itM12279r.hasNext()) {
            Map.Entry entry = (Map.Entry) itM12279r.next();
            C1959v.b bVar = (C1959v.b) entry.getKey();
            if (bVar.mo12289l0() != C1958u1.c.MESSAGE || bVar.mo12286b0() || bVar.mo12290o0()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof C1909e0.b) {
                interfaceC1961v1.mo11998c(bVar.mo12285a0(), ((C1909e0.b) entry).m11562a().m11638e());
            } else {
                interfaceC1961v1.mo11998c(bVar.mo12285a0(), entry.getValue());
            }
        }
        m12362o(this.f9415b, t10, interfaceC1961v1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: f */
    public void mo11672f(T t10, InterfaceC1916g1 interfaceC1916g1, C1944q c1944q) throws IOException {
        m12359l(this.f9415b, this.f9417d, t10, interfaceC1916g1, c1944q);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: g */
    public boolean mo11673g(T t10, T t11) {
        if (!this.f9415b.mo12066g(t10).equals(this.f9415b.mo12066g(t11))) {
            return false;
        }
        if (this.f9416c) {
            return this.f9417d.mo12123c(t10).equals(this.f9417d.mo12123c(t11));
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: h */
    public int mo11674h(T t10) {
        int iM12358k = m12358k(this.f9415b, t10);
        return this.f9416c ? iM12358k + this.f9417d.mo12123c(t10).m12273j() : iM12358k;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: i */
    public T mo11675i() {
        return (T) this.f9414a.mo12141k().mo12143I();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1919h1
    /* renamed from: j */
    public int mo11676j(T t10) {
        int iHashCode = this.f9415b.mo12066g(t10).hashCode();
        return this.f9416c ? (iHashCode * 53) + this.f9417d.mo12123c(t10).hashCode() : iHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: n */
    public final <UT, UB, ET extends C1959v.b<ET>> boolean m12361n(InterfaceC1916g1 interfaceC1916g1, C1944q c1944q, AbstractC1947r<ET> abstractC1947r, C1959v<ET> c1959v, AbstractC1940o1<UT, UB> abstractC1940o1, UB ub2) throws IOException {
        int iMo11595a = interfaceC1916g1.mo11595a();
        if (iMo11595a != C1958u1.f9283a) {
            if (C1958u1.m12258b(iMo11595a) != 2) {
                return interfaceC1916g1.mo11577H();
            }
            Object objMo12122b = abstractC1947r.mo12122b(c1944q, this.f9414a, C1958u1.m12257a(iMo11595a));
            if (objMo12122b == null) {
                return abstractC1940o1.m12072m(ub2, interfaceC1916g1);
            }
            abstractC1947r.mo12128h(interfaceC1916g1, objMo12122b, c1944q, c1959v);
            return true;
        }
        Object objMo12122b2 = null;
        int iMo11619m = 0;
        AbstractC1920i abstractC1920iMo11574E = null;
        while (interfaceC1916g1.mo11571B() != Integer.MAX_VALUE) {
            int iMo11595a2 = interfaceC1916g1.mo11595a();
            if (iMo11595a2 == C1958u1.f9285c) {
                iMo11619m = interfaceC1916g1.mo11619m();
                objMo12122b2 = abstractC1947r.mo12122b(c1944q, this.f9414a, iMo11619m);
            } else if (iMo11595a2 == C1958u1.f9286d) {
                if (objMo12122b2 != null) {
                    abstractC1947r.mo12128h(interfaceC1916g1, objMo12122b2, c1944q, c1959v);
                } else {
                    abstractC1920iMo11574E = interfaceC1916g1.mo11574E();
                }
            } else if (!interfaceC1916g1.mo11577H()) {
                break;
            }
        }
        if (interfaceC1916g1.mo11595a() != C1958u1.f9284b) {
            throw C1903c0.m11502b();
        }
        if (abstractC1920iMo11574E != null) {
            if (objMo12122b2 != null) {
                abstractC1947r.mo12129i(abstractC1920iMo11574E, objMo12122b2, c1944q, c1959v);
            } else {
                abstractC1940o1.mo12063d(ub2, iMo11619m, abstractC1920iMo11574E);
            }
        }
        return true;
    }

    /* renamed from: o */
    public final <UT, UB> void m12362o(AbstractC1940o1<UT, UB> abstractC1940o1, T t10, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        abstractC1940o1.mo12078s(abstractC1940o1.mo12066g(t10), interfaceC1961v1);
    }
}
