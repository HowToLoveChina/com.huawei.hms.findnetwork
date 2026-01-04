package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* renamed from: com.google.crypto.tink.shaded.protobuf.q1 */
/* loaded from: classes.dex */
public class C1946q1 extends AbstractC1940o1<C1943p1, C1943p1> {
    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C1943p1 mo12066g(Object obj) {
        return ((AbstractC1968z) obj).unknownFields;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int mo12067h(C1943p1 c1943p1) {
        return c1943p1.m12096f();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int mo12068i(C1943p1 c1943p1) {
        return c1943p1.m12097g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public C1943p1 mo12070k(C1943p1 c1943p1, C1943p1 c1943p12) {
        return c1943p12.equals(C1943p1.m12088e()) ? c1943p1 : C1943p1.m12091k(c1943p1, c1943p12);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public C1943p1 mo12073n() {
        return C1943p1.m12092l();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void mo12074o(Object obj, C1943p1 c1943p1) {
        mo12075p(obj, c1943p1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void mo12075p(Object obj, C1943p1 c1943p1) {
        ((AbstractC1968z) obj).unknownFields = c1943p1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public C1943p1 mo12077r(C1943p1 c1943p1) {
        c1943p1.m12098j();
        return c1943p1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void mo12078s(C1943p1 c1943p1, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        c1943p1.m12101o(interfaceC1961v1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void mo12079t(C1943p1 c1943p1, InterfaceC1961v1 interfaceC1961v1) throws IOException {
        c1943p1.m12102q(interfaceC1961v1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: j */
    public void mo12069j(Object obj) {
        mo12066g(obj).m12098j();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: q */
    public boolean mo12076q(InterfaceC1916g1 interfaceC1916g1) {
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void mo12060a(C1943p1 c1943p1, int i10, int i11) {
        c1943p1.m12100n(C1958u1.m12259c(i10, 5), Integer.valueOf(i11));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void mo12061b(C1943p1 c1943p1, int i10, long j10) {
        c1943p1.m12100n(C1958u1.m12259c(i10, 1), Long.valueOf(j10));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void mo12062c(C1943p1 c1943p1, int i10, C1943p1 c1943p12) {
        c1943p1.m12100n(C1958u1.m12259c(i10, 3), c1943p12);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void mo12063d(C1943p1 c1943p1, int i10, AbstractC1920i abstractC1920i) {
        c1943p1.m12100n(C1958u1.m12259c(i10, 2), abstractC1920i);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void mo12064e(C1943p1 c1943p1, int i10, long j10) {
        c1943p1.m12100n(C1958u1.m12259c(i10, 0), Long.valueOf(j10));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC1940o1
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public C1943p1 mo12065f(Object obj) {
        C1943p1 c1943p1Mo12066g = mo12066g(obj);
        if (c1943p1Mo12066g != C1943p1.m12088e()) {
            return c1943p1Mo12066g;
        }
        C1943p1 c1943p1M12092l = C1943p1.m12092l();
        mo12075p(obj, c1943p1M12092l);
        return c1943p1M12092l;
    }
}
