package p597r0;

import p597r0.AbstractC12450a;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: r0.d */
/* loaded from: classes.dex */
public final class C12453d extends AbstractC12450a {
    public C12453d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // p597r0.AbstractC12450a
    /* renamed from: a */
    public <T> T mo74704a(AbstractC12450a.b<T> bVar) {
        C13267j.m79677e(bVar, "key");
        return (T) m74705b().get(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public final <T> void m74708c(AbstractC12450a.b<T> bVar, T t10) {
        C13267j.m79677e(bVar, "key");
        m74705b().put(bVar, t10);
    }

    public C12453d(AbstractC12450a abstractC12450a) {
        C13267j.m79677e(abstractC12450a, "initialExtras");
        m74705b().putAll(abstractC12450a.m74705b());
    }

    public /* synthetic */ C12453d(AbstractC12450a abstractC12450a, int i10, C13264g c13264g) {
        this((i10 & 1) != 0 ? AbstractC12450a.a.f57374b : abstractC12450a);
    }
}
