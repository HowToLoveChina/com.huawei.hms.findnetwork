package mw;

import mw.InterfaceC11539f;
import mw.InterfaceC11539f.b;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* renamed from: mw.b */
/* loaded from: classes9.dex */
public abstract class AbstractC11535b<B extends InterfaceC11539f.b, E extends B> implements InterfaceC11539f.c<E> {

    /* renamed from: a */
    public final InterfaceC13086l<InterfaceC11539f.b, E> f53485a;

    /* renamed from: b */
    public final InterfaceC11539f.c<?> f53486b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [mw.f$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, tw.l<? super mw.f$b, ? extends E extends B>, tw.l<mw.f$b, E extends B>] */
    public AbstractC11535b(InterfaceC11539f.c<B> cVar, InterfaceC13086l<? super InterfaceC11539f.b, ? extends E> interfaceC13086l) {
        C13267j.m79677e(cVar, "baseKey");
        C13267j.m79677e(interfaceC13086l, "safeCast");
        this.f53485a = interfaceC13086l;
        this.f53486b = cVar instanceof AbstractC11535b ? (InterfaceC11539f.c<B>) ((AbstractC11535b) cVar).f53486b : cVar;
    }

    /* renamed from: a */
    public final boolean m68828a(InterfaceC11539f.c<?> cVar) {
        C13267j.m79677e(cVar, "key");
        return cVar == this || this.f53486b == cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lmw/f$b;)TE; */
    /* renamed from: b */
    public final InterfaceC11539f.b m68829b(InterfaceC11539f.b bVar) {
        C13267j.m79677e(bVar, "element");
        return (InterfaceC11539f.b) this.f53485a.mo5000c(bVar);
    }
}
