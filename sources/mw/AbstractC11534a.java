package mw;

import mw.InterfaceC11539f;
import p692uw.C13267j;
import tw.InterfaceC13090p;

/* renamed from: mw.a */
/* loaded from: classes9.dex */
public abstract class AbstractC11534a implements InterfaceC11539f.b {
    private final InterfaceC11539f.c<?> key;

    public AbstractC11534a(InterfaceC11539f.c<?> cVar) {
        C13267j.m79677e(cVar, "key");
        this.key = cVar;
    }

    @Override // mw.InterfaceC11539f
    public <R> R fold(R r10, InterfaceC13090p<? super R, ? super InterfaceC11539f.b, ? extends R> interfaceC13090p) {
        return (R) InterfaceC11539f.b.a.m68839a(this, r10, interfaceC13090p);
    }

    @Override // mw.InterfaceC11539f.b, mw.InterfaceC11539f
    public <E extends InterfaceC11539f.b> E get(InterfaceC11539f.c<E> cVar) {
        return (E) InterfaceC11539f.b.a.m68840b(this, cVar);
    }

    @Override // mw.InterfaceC11539f.b
    public InterfaceC11539f.c<?> getKey() {
        return this.key;
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f minusKey(InterfaceC11539f.c<?> cVar) {
        return InterfaceC11539f.b.a.m68841c(this, cVar);
    }

    @Override // mw.InterfaceC11539f
    public InterfaceC11539f plus(InterfaceC11539f interfaceC11539f) {
        return InterfaceC11539f.b.a.m68842d(this, interfaceC11539f);
    }
}
