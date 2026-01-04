package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1930l0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.crypto.tink.shaded.protobuf.k */
/* loaded from: classes.dex */
public final class C1926k implements InterfaceC1916g1 {

    /* renamed from: a */
    public final AbstractC1923j f9183a;

    /* renamed from: b */
    public int f9184b;

    /* renamed from: c */
    public int f9185c;

    /* renamed from: d */
    public int f9186d = 0;

    public C1926k(AbstractC1923j abstractC1923j) {
        AbstractC1923j abstractC1923j2 = (AbstractC1923j) C1900b0.m11487b(abstractC1923j, "input");
        this.f9183a = abstractC1923j2;
        abstractC1923j2.f9165d = this;
    }

    /* renamed from: Q */
    public static C1926k m11830Q(AbstractC1923j abstractC1923j) {
        C1926k c1926k = abstractC1923j.f9165d;
        return c1926k != null ? c1926k : new C1926k(abstractC1923j);
    }

    /* renamed from: R */
    private <T> T m11831R(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
        int i10 = this.f9185c;
        this.f9185c = C1958u1.m12259c(C1958u1.m12257a(this.f9184b), 4);
        try {
            T tMo11675i = interfaceC1919h1.mo11675i();
            interfaceC1919h1.mo11672f(tMo11675i, this, c1944q);
            interfaceC1919h1.mo11668b(tMo11675i);
            if (this.f9184b == this.f9185c) {
                return tMo11675i;
            }
            throw C1903c0.m11508h();
        } finally {
            this.f9185c = i10;
        }
    }

    /* renamed from: S */
    private <T> T m11832S(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
        int iMo11724A = this.f9183a.mo11724A();
        AbstractC1923j abstractC1923j = this.f9183a;
        if (abstractC1923j.f9162a >= abstractC1923j.f9163b) {
            throw C1903c0.m11509j();
        }
        int iMo11731j = abstractC1923j.mo11731j(iMo11724A);
        T tMo11675i = interfaceC1919h1.mo11675i();
        this.f9183a.f9162a++;
        interfaceC1919h1.mo11672f(tMo11675i, this, c1944q);
        interfaceC1919h1.mo11668b(tMo11675i);
        this.f9183a.mo11727a(0);
        r4.f9162a--;
        this.f9183a.mo11730i(iMo11731j);
        return tMo11675i;
    }

    /* renamed from: U */
    private void m11833U(int i10) throws IOException {
        if (this.f9183a.mo11728d() != i10) {
            throw C1903c0.m11510l();
        }
    }

    /* renamed from: V */
    private void m11834V(int i10) throws IOException {
        if (C1958u1.m12258b(this.f9184b) != i10) {
            throw C1903c0.m11505e();
        }
    }

    /* renamed from: W */
    private void m11835W(int i10) throws IOException {
        if ((i10 & 3) != 0) {
            throw C1903c0.m11508h();
        }
    }

    /* renamed from: X */
    private void m11836X(int i10) throws IOException {
        if ((i10 & 7) != 0) {
            throw C1903c0.m11508h();
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: A */
    public <T> T mo11570A(Class<T> cls, C1944q c1944q) throws IOException {
        m11834V(2);
        return (T) m11832S(C1907d1.m11516a().m11519d(cls), c1944q);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: B */
    public int mo11571B() throws IOException {
        int i10 = this.f9186d;
        if (i10 != 0) {
            this.f9184b = i10;
            this.f9186d = 0;
        } else {
            this.f9184b = this.f9183a.mo11747z();
        }
        int i11 = this.f9184b;
        if (i11 == 0 || i11 == this.f9185c) {
            return Integer.MAX_VALUE;
        }
        return C1958u1.m12257a(i11);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: C */
    public void mo11572C(List<String> list) throws IOException {
        m11837T(list, false);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: D */
    public void mo11573D(List<String> list) throws IOException {
        m11837T(list, true);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: E */
    public AbstractC1920i mo11574E() throws IOException {
        m11834V(2);
        return this.f9183a.mo11733l();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: F */
    public void mo11575F(List<Float> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1964x)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 2) {
                int iMo11724A = this.f9183a.mo11724A();
                m11835W(iMo11724A);
                int iMo11728d = this.f9183a.mo11728d() + iMo11724A;
                do {
                    list.add(Float.valueOf(this.f9183a.mo11738q()));
                } while (this.f9183a.mo11728d() < iMo11728d);
                return;
            }
            if (iM12258b != 5) {
                throw C1903c0.m11505e();
            }
            do {
                list.add(Float.valueOf(this.f9183a.mo11738q()));
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z = this.f9183a.mo11747z();
                }
            } while (iMo11747z == this.f9184b);
            this.f9186d = iMo11747z;
            return;
        }
        C1964x c1964x = (C1964x) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 2) {
            int iMo11724A2 = this.f9183a.mo11724A();
            m11835W(iMo11724A2);
            int iMo11728d2 = this.f9183a.mo11728d() + iMo11724A2;
            do {
                c1964x.m12367d(this.f9183a.mo11738q());
            } while (this.f9183a.mo11728d() < iMo11728d2);
            return;
        }
        if (iM12258b2 != 5) {
            throw C1903c0.m11505e();
        }
        do {
            c1964x.m12367d(this.f9183a.mo11738q());
            if (this.f9183a.mo11729e()) {
                return;
            } else {
                iMo11747z2 = this.f9183a.mo11747z();
            }
        } while (iMo11747z2 == this.f9184b);
        this.f9186d = iMo11747z2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: G */
    public int mo11576G() throws IOException {
        m11834V(0);
        return this.f9183a.mo11739r();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: H */
    public boolean mo11577H() throws IOException {
        int i10;
        if (this.f9183a.mo11729e() || (i10 = this.f9184b) == this.f9185c) {
            return false;
        }
        return this.f9183a.mo11726C(i10);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: I */
    public int mo11578I() throws IOException {
        m11834V(5);
        return this.f9183a.mo11741t();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: J */
    public void mo11579J(List<AbstractC1920i> list) throws IOException {
        int iMo11747z;
        if (C1958u1.m12258b(this.f9184b) != 2) {
            throw C1903c0.m11505e();
        }
        do {
            list.add(mo11574E());
            if (this.f9183a.mo11729e()) {
                return;
            } else {
                iMo11747z = this.f9183a.mo11747z();
            }
        } while (iMo11747z == this.f9184b);
        this.f9186d = iMo11747z;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: K */
    public <K, V> void mo11580K(Map<K, V> map, C1930l0.a<K, V> aVar, C1944q c1944q) throws IOException {
        m11834V(2);
        this.f9183a.mo11731j(this.f9183a.mo11724A());
        throw null;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: L */
    public void mo11581L(List<Double> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1935n)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 1) {
                do {
                    list.add(Double.valueOf(this.f9183a.mo11734m()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11724A = this.f9183a.mo11724A();
            m11836X(iMo11724A);
            int iMo11728d = this.f9183a.mo11728d() + iMo11724A;
            do {
                list.add(Double.valueOf(this.f9183a.mo11734m()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            return;
        }
        C1935n c1935n = (C1935n) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 1) {
            do {
                c1935n.m12041d(this.f9183a.mo11734m());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11724A2 = this.f9183a.mo11724A();
        m11836X(iMo11724A2);
        int iMo11728d2 = this.f9183a.mo11728d() + iMo11724A2;
        do {
            c1935n.m12041d(this.f9183a.mo11734m());
        } while (this.f9183a.mo11728d() < iMo11728d2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: M */
    public <T> void mo11582M(List<T> list, InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
        int iMo11747z;
        if (C1958u1.m12258b(this.f9184b) != 3) {
            throw C1903c0.m11505e();
        }
        int i10 = this.f9184b;
        do {
            list.add(m11831R(interfaceC1919h1, c1944q));
            if (this.f9183a.mo11729e() || this.f9186d != 0) {
                return;
            } else {
                iMo11747z = this.f9183a.mo11747z();
            }
        } while (iMo11747z == i10);
        this.f9186d = iMo11747z;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: N */
    public long mo11583N() throws IOException {
        m11834V(0);
        return this.f9183a.mo11740s();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: O */
    public String mo11584O() throws IOException {
        m11834V(2);
        return this.f9183a.mo11746y();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: P */
    public void mo11585P(List<Long> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1924j0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 1) {
                do {
                    list.add(Long.valueOf(this.f9183a.mo11737p()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11724A = this.f9183a.mo11724A();
            m11836X(iMo11724A);
            int iMo11728d = this.f9183a.mo11728d() + iMo11724A;
            do {
                list.add(Long.valueOf(this.f9183a.mo11737p()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            return;
        }
        C1924j0 c1924j0 = (C1924j0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 1) {
            do {
                c1924j0.m11766e(this.f9183a.mo11737p());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11724A2 = this.f9183a.mo11724A();
        m11836X(iMo11724A2);
        int iMo11728d2 = this.f9183a.mo11728d() + iMo11724A2;
        do {
            c1924j0.m11766e(this.f9183a.mo11737p());
        } while (this.f9183a.mo11728d() < iMo11728d2);
    }

    /* renamed from: T */
    public void m11837T(List<String> list, boolean z10) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (C1958u1.m12258b(this.f9184b) != 2) {
            throw C1903c0.m11505e();
        }
        if (!(list instanceof InterfaceC1918h0) || z10) {
            do {
                list.add(z10 ? mo11584O() : mo11633z());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z = this.f9183a.mo11747z();
                }
            } while (iMo11747z == this.f9184b);
            this.f9186d = iMo11747z;
            return;
        }
        InterfaceC1918h0 interfaceC1918h0 = (InterfaceC1918h0) list;
        do {
            interfaceC1918h0.mo11658V(mo11574E());
            if (this.f9183a.mo11729e()) {
                return;
            } else {
                iMo11747z2 = this.f9183a.mo11747z();
            }
        } while (iMo11747z2 == this.f9184b);
        this.f9186d = iMo11747z2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: a */
    public int mo11595a() {
        return this.f9184b;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: b */
    public void mo11597b(List<Integer> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1897a0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Integer.valueOf(this.f9183a.mo11743v()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Integer.valueOf(this.f9183a.mo11743v()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1897a0 c1897a0 = (C1897a0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1897a0.m11471d(this.f9183a.mo11743v());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1897a0.m11471d(this.f9183a.mo11743v());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: c */
    public long mo11599c() throws IOException {
        m11834V(0);
        return this.f9183a.mo11725B();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: d */
    public long mo11601d() throws IOException {
        m11834V(1);
        return this.f9183a.mo11737p();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: e */
    public void mo11603e(List<Integer> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1897a0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 2) {
                int iMo11724A = this.f9183a.mo11724A();
                m11835W(iMo11724A);
                int iMo11728d = this.f9183a.mo11728d() + iMo11724A;
                do {
                    list.add(Integer.valueOf(this.f9183a.mo11741t()));
                } while (this.f9183a.mo11728d() < iMo11728d);
                return;
            }
            if (iM12258b != 5) {
                throw C1903c0.m11505e();
            }
            do {
                list.add(Integer.valueOf(this.f9183a.mo11741t()));
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z = this.f9183a.mo11747z();
                }
            } while (iMo11747z == this.f9184b);
            this.f9186d = iMo11747z;
            return;
        }
        C1897a0 c1897a0 = (C1897a0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 2) {
            int iMo11724A2 = this.f9183a.mo11724A();
            m11835W(iMo11724A2);
            int iMo11728d2 = this.f9183a.mo11728d() + iMo11724A2;
            do {
                c1897a0.m11471d(this.f9183a.mo11741t());
            } while (this.f9183a.mo11728d() < iMo11728d2);
            return;
        }
        if (iM12258b2 != 5) {
            throw C1903c0.m11505e();
        }
        do {
            c1897a0.m11471d(this.f9183a.mo11741t());
            if (this.f9183a.mo11729e()) {
                return;
            } else {
                iMo11747z2 = this.f9183a.mo11747z();
            }
        } while (iMo11747z2 == this.f9184b);
        this.f9186d = iMo11747z2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: f */
    public void mo11605f(List<Long> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1924j0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Long.valueOf(this.f9183a.mo11744w()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Long.valueOf(this.f9183a.mo11744w()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1924j0 c1924j0 = (C1924j0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1924j0.m11766e(this.f9183a.mo11744w());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1924j0.m11766e(this.f9183a.mo11744w());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: g */
    public void mo11607g(List<Integer> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1897a0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Integer.valueOf(this.f9183a.mo11724A()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Integer.valueOf(this.f9183a.mo11724A()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1897a0 c1897a0 = (C1897a0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1897a0.m11471d(this.f9183a.mo11724A());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1897a0.m11471d(this.f9183a.mo11724A());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: h */
    public <T> void mo11609h(List<T> list, InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
        int iMo11747z;
        if (C1958u1.m12258b(this.f9184b) != 2) {
            throw C1903c0.m11505e();
        }
        int i10 = this.f9184b;
        do {
            list.add(m11832S(interfaceC1919h1, c1944q));
            if (this.f9183a.mo11729e() || this.f9186d != 0) {
                return;
            } else {
                iMo11747z = this.f9183a.mo11747z();
            }
        } while (iMo11747z == i10);
        this.f9186d = iMo11747z;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: i */
    public int mo11611i() throws IOException {
        m11834V(5);
        return this.f9183a.mo11736o();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: j */
    public boolean mo11613j() throws IOException {
        m11834V(0);
        return this.f9183a.mo11732k();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: k */
    public long mo11615k() throws IOException {
        m11834V(1);
        return this.f9183a.mo11742u();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: l */
    public void mo11617l(List<Long> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1924j0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Long.valueOf(this.f9183a.mo11725B()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Long.valueOf(this.f9183a.mo11725B()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1924j0 c1924j0 = (C1924j0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1924j0.m11766e(this.f9183a.mo11725B());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1924j0.m11766e(this.f9183a.mo11725B());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: m */
    public int mo11619m() throws IOException {
        m11834V(0);
        return this.f9183a.mo11724A();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: n */
    public void mo11621n(List<Long> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1924j0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Long.valueOf(this.f9183a.mo11740s()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Long.valueOf(this.f9183a.mo11740s()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1924j0 c1924j0 = (C1924j0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1924j0.m11766e(this.f9183a.mo11740s());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1924j0.m11766e(this.f9183a.mo11740s());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: o */
    public void mo11622o(List<Long> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1924j0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 1) {
                do {
                    list.add(Long.valueOf(this.f9183a.mo11742u()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11724A = this.f9183a.mo11724A();
            m11836X(iMo11724A);
            int iMo11728d = this.f9183a.mo11728d() + iMo11724A;
            do {
                list.add(Long.valueOf(this.f9183a.mo11742u()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            return;
        }
        C1924j0 c1924j0 = (C1924j0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 1) {
            do {
                c1924j0.m11766e(this.f9183a.mo11742u());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11724A2 = this.f9183a.mo11724A();
        m11836X(iMo11724A2);
        int iMo11728d2 = this.f9183a.mo11728d() + iMo11724A2;
        do {
            c1924j0.m11766e(this.f9183a.mo11742u());
        } while (this.f9183a.mo11728d() < iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: p */
    public void mo11623p(List<Integer> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1897a0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Integer.valueOf(this.f9183a.mo11739r()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Integer.valueOf(this.f9183a.mo11739r()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1897a0 c1897a0 = (C1897a0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1897a0.m11471d(this.f9183a.mo11739r());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1897a0.m11471d(this.f9183a.mo11739r());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: q */
    public void mo11624q(List<Integer> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1897a0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Integer.valueOf(this.f9183a.mo11735n()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Integer.valueOf(this.f9183a.mo11735n()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1897a0 c1897a0 = (C1897a0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1897a0.m11471d(this.f9183a.mo11735n());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1897a0.m11471d(this.f9183a.mo11735n());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: r */
    public <T> T mo11625r(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
        m11834V(3);
        return (T) m11831R(interfaceC1919h1, c1944q);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    public double readDouble() throws IOException {
        m11834V(1);
        return this.f9183a.mo11734m();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    public float readFloat() throws IOException {
        m11834V(5);
        return this.f9183a.mo11738q();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: s */
    public int mo11626s() throws IOException {
        m11834V(0);
        return this.f9183a.mo11735n();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: t */
    public <T> T mo11627t(InterfaceC1919h1<T> interfaceC1919h1, C1944q c1944q) throws IOException {
        m11834V(2);
        return (T) m11832S(interfaceC1919h1, c1944q);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: u */
    public void mo11628u(List<Integer> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1897a0)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 2) {
                int iMo11724A = this.f9183a.mo11724A();
                m11835W(iMo11724A);
                int iMo11728d = this.f9183a.mo11728d() + iMo11724A;
                do {
                    list.add(Integer.valueOf(this.f9183a.mo11736o()));
                } while (this.f9183a.mo11728d() < iMo11728d);
                return;
            }
            if (iM12258b != 5) {
                throw C1903c0.m11505e();
            }
            do {
                list.add(Integer.valueOf(this.f9183a.mo11736o()));
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z = this.f9183a.mo11747z();
                }
            } while (iMo11747z == this.f9184b);
            this.f9186d = iMo11747z;
            return;
        }
        C1897a0 c1897a0 = (C1897a0) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 2) {
            int iMo11724A2 = this.f9183a.mo11724A();
            m11835W(iMo11724A2);
            int iMo11728d2 = this.f9183a.mo11728d() + iMo11724A2;
            do {
                c1897a0.m11471d(this.f9183a.mo11736o());
            } while (this.f9183a.mo11728d() < iMo11728d2);
            return;
        }
        if (iM12258b2 != 5) {
            throw C1903c0.m11505e();
        }
        do {
            c1897a0.m11471d(this.f9183a.mo11736o());
            if (this.f9183a.mo11729e()) {
                return;
            } else {
                iMo11747z2 = this.f9183a.mo11747z();
            }
        } while (iMo11747z2 == this.f9184b);
        this.f9186d = iMo11747z2;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: v */
    public int mo11629v() throws IOException {
        m11834V(0);
        return this.f9183a.mo11743v();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: w */
    public long mo11630w() throws IOException {
        m11834V(0);
        return this.f9183a.mo11744w();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: x */
    public <T> T mo11631x(Class<T> cls, C1944q c1944q) throws IOException {
        m11834V(3);
        return (T) m11831R(C1907d1.m11516a().m11519d(cls), c1944q);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: y */
    public void mo11632y(List<Boolean> list) throws IOException {
        int iMo11747z;
        int iMo11747z2;
        if (!(list instanceof C1914g)) {
            int iM12258b = C1958u1.m12258b(this.f9184b);
            if (iM12258b == 0) {
                do {
                    list.add(Boolean.valueOf(this.f9183a.mo11732k()));
                    if (this.f9183a.mo11729e()) {
                        return;
                    } else {
                        iMo11747z = this.f9183a.mo11747z();
                    }
                } while (iMo11747z == this.f9184b);
                this.f9186d = iMo11747z;
                return;
            }
            if (iM12258b != 2) {
                throw C1903c0.m11505e();
            }
            int iMo11728d = this.f9183a.mo11728d() + this.f9183a.mo11724A();
            do {
                list.add(Boolean.valueOf(this.f9183a.mo11732k()));
            } while (this.f9183a.mo11728d() < iMo11728d);
            m11833U(iMo11728d);
            return;
        }
        C1914g c1914g = (C1914g) list;
        int iM12258b2 = C1958u1.m12258b(this.f9184b);
        if (iM12258b2 == 0) {
            do {
                c1914g.m11647e(this.f9183a.mo11732k());
                if (this.f9183a.mo11729e()) {
                    return;
                } else {
                    iMo11747z2 = this.f9183a.mo11747z();
                }
            } while (iMo11747z2 == this.f9184b);
            this.f9186d = iMo11747z2;
            return;
        }
        if (iM12258b2 != 2) {
            throw C1903c0.m11505e();
        }
        int iMo11728d2 = this.f9183a.mo11728d() + this.f9183a.mo11724A();
        do {
            c1914g.m11647e(this.f9183a.mo11732k());
        } while (this.f9183a.mo11728d() < iMo11728d2);
        m11833U(iMo11728d2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.InterfaceC1916g1
    /* renamed from: z */
    public String mo11633z() throws IOException {
        m11834V(2);
        return this.f9183a.mo11745x();
    }
}
