package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.o1 */
/* loaded from: classes.dex */
public abstract class AbstractC1940o1<T, B> {
    /* renamed from: a */
    public abstract void mo12060a(B b10, int i10, int i11);

    /* renamed from: b */
    public abstract void mo12061b(B b10, int i10, long j10);

    /* renamed from: c */
    public abstract void mo12062c(B b10, int i10, T t10);

    /* renamed from: d */
    public abstract void mo12063d(B b10, int i10, AbstractC1920i abstractC1920i);

    /* renamed from: e */
    public abstract void mo12064e(B b10, int i10, long j10);

    /* renamed from: f */
    public abstract B mo12065f(Object obj);

    /* renamed from: g */
    public abstract T mo12066g(Object obj);

    /* renamed from: h */
    public abstract int mo12067h(T t10);

    /* renamed from: i */
    public abstract int mo12068i(T t10);

    /* renamed from: j */
    public abstract void mo12069j(Object obj);

    /* renamed from: k */
    public abstract T mo12070k(T t10, T t11);

    /* renamed from: l */
    public final void m12071l(B b10, InterfaceC1916g1 interfaceC1916g1) throws IOException {
        while (interfaceC1916g1.mo11571B() != Integer.MAX_VALUE && m12072m(b10, interfaceC1916g1)) {
        }
    }

    /* renamed from: m */
    public final boolean m12072m(B b10, InterfaceC1916g1 interfaceC1916g1) throws IOException {
        int iMo11595a = interfaceC1916g1.mo11595a();
        int iM12257a = C1958u1.m12257a(iMo11595a);
        int iM12258b = C1958u1.m12258b(iMo11595a);
        if (iM12258b == 0) {
            mo12064e(b10, iM12257a, interfaceC1916g1.mo11583N());
            return true;
        }
        if (iM12258b == 1) {
            mo12061b(b10, iM12257a, interfaceC1916g1.mo11601d());
            return true;
        }
        if (iM12258b == 2) {
            mo12063d(b10, iM12257a, interfaceC1916g1.mo11574E());
            return true;
        }
        if (iM12258b != 3) {
            if (iM12258b == 4) {
                return false;
            }
            if (iM12258b != 5) {
                throw C1903c0.m11505e();
            }
            mo12060a(b10, iM12257a, interfaceC1916g1.mo11611i());
            return true;
        }
        B bMo12073n = mo12073n();
        int iM12259c = C1958u1.m12259c(iM12257a, 4);
        m12071l(bMo12073n, interfaceC1916g1);
        if (iM12259c != interfaceC1916g1.mo11595a()) {
            throw C1903c0.m11502b();
        }
        mo12062c(b10, iM12257a, mo12077r(bMo12073n));
        return true;
    }

    /* renamed from: n */
    public abstract B mo12073n();

    /* renamed from: o */
    public abstract void mo12074o(Object obj, B b10);

    /* renamed from: p */
    public abstract void mo12075p(Object obj, T t10);

    /* renamed from: q */
    public abstract boolean mo12076q(InterfaceC1916g1 interfaceC1916g1);

    /* renamed from: r */
    public abstract T mo12077r(B b10);

    /* renamed from: s */
    public abstract void mo12078s(T t10, InterfaceC1961v1 interfaceC1961v1) throws IOException;

    /* renamed from: t */
    public abstract void mo12079t(T t10, InterfaceC1961v1 interfaceC1961v1) throws IOException;
}
