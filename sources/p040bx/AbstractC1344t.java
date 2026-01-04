package p040bx;

import kotlinx.coroutines.internal.C11087d;
import kotlinx.coroutines.internal.C11090g;
import kotlinx.coroutines.internal.RunnableC11089f;
import mw.AbstractC11534a;
import mw.AbstractC11535b;
import mw.InterfaceC11537d;
import mw.InterfaceC11538e;
import mw.InterfaceC11539f;
import p692uw.AbstractC13268k;
import p692uw.C13264g;
import tw.InterfaceC13086l;

/* renamed from: bx.t */
/* loaded from: classes9.dex */
public abstract class AbstractC1344t extends AbstractC11534a implements InterfaceC11538e {

    /* renamed from: a */
    public static final a f5841a = new a(null);

    /* renamed from: bx.t$a */
    public static final class a extends AbstractC11535b<InterfaceC11538e, AbstractC1344t> {

        /* renamed from: bx.t$a$a */
        public static final class C14414a extends AbstractC13268k implements InterfaceC13086l<InterfaceC11539f.b, AbstractC1344t> {

            /* renamed from: b */
            public static final C14414a f5842b = new C14414a();

            public C14414a() {
                super(1);
            }

            @Override // tw.InterfaceC13086l
            /* renamed from: e */
            public final AbstractC1344t mo5000c(InterfaceC11539f.b bVar) {
                if (bVar instanceof AbstractC1344t) {
                    return (AbstractC1344t) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        public a() {
            super(InterfaceC11538e.f53494h2, C14414a.f5842b);
        }
    }

    public AbstractC1344t() {
        super(InterfaceC11538e.f53494h2);
    }

    /* renamed from: c */
    public abstract void mo7787c(InterfaceC11539f interfaceC11539f, Runnable runnable);

    /* renamed from: d */
    public boolean mo7788d(InterfaceC11539f interfaceC11539f) {
        return true;
    }

    @Override // mw.InterfaceC11538e
    /* renamed from: g */
    public final void mo7831g(InterfaceC11537d<?> interfaceC11537d) {
        ((C11087d) interfaceC11537d).m66751m();
    }

    @Override // mw.AbstractC11534a, mw.InterfaceC11539f.b, mw.InterfaceC11539f
    public <E extends InterfaceC11539f.b> E get(InterfaceC11539f.c<E> cVar) {
        return (E) InterfaceC11538e.a.m68835a(this, cVar);
    }

    @Override // mw.InterfaceC11538e
    /* renamed from: h */
    public final <T> InterfaceC11537d<T> mo7832h(InterfaceC11537d<? super T> interfaceC11537d) {
        return new C11087d(this, interfaceC11537d);
    }

    /* renamed from: i */
    public AbstractC1344t m7833i(int i10) {
        C11090g.m66757a(i10);
        return new RunnableC11089f(this, i10);
    }

    @Override // mw.AbstractC11534a, mw.InterfaceC11539f
    public InterfaceC11539f minusKey(InterfaceC11539f.c<?> cVar) {
        return InterfaceC11538e.a.m68836b(this, cVar);
    }

    public String toString() {
        return C1354y.m7844a(this) + '@' + C1354y.m7845b(this);
    }
}
