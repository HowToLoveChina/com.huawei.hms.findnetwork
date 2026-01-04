package mw;

import mw.InterfaceC11539f;
import p692uw.C13267j;

/* renamed from: mw.e */
/* loaded from: classes9.dex */
public interface InterfaceC11538e extends InterfaceC11539f.b {

    /* renamed from: h2 */
    public static final b f53494h2 = b.f53495a;

    /* renamed from: mw.e$a */
    public static final class a {
        /* renamed from: a */
        public static <E extends InterfaceC11539f.b> E m68835a(InterfaceC11538e interfaceC11538e, InterfaceC11539f.c<E> cVar) {
            C13267j.m79677e(cVar, "key");
            if (!(cVar instanceof AbstractC11535b)) {
                if (InterfaceC11538e.f53494h2 != cVar) {
                    return null;
                }
                C13267j.m79675c(interfaceC11538e, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return interfaceC11538e;
            }
            AbstractC11535b abstractC11535b = (AbstractC11535b) cVar;
            if (!abstractC11535b.m68828a(interfaceC11538e.getKey())) {
                return null;
            }
            E e10 = (E) abstractC11535b.m68829b(interfaceC11538e);
            if (e10 instanceof InterfaceC11539f.b) {
                return e10;
            }
            return null;
        }

        /* renamed from: b */
        public static InterfaceC11539f m68836b(InterfaceC11538e interfaceC11538e, InterfaceC11539f.c<?> cVar) {
            C13267j.m79677e(cVar, "key");
            if (!(cVar instanceof AbstractC11535b)) {
                return InterfaceC11538e.f53494h2 == cVar ? C11540g.f53497a : interfaceC11538e;
            }
            AbstractC11535b abstractC11535b = (AbstractC11535b) cVar;
            return (!abstractC11535b.m68828a(interfaceC11538e.getKey()) || abstractC11535b.m68829b(interfaceC11538e) == null) ? interfaceC11538e : C11540g.f53497a;
        }
    }

    /* renamed from: mw.e$b */
    public static final class b implements InterfaceC11539f.c<InterfaceC11538e> {

        /* renamed from: a */
        public static final /* synthetic */ b f53495a = new b();
    }

    /* renamed from: g */
    void mo7831g(InterfaceC11537d<?> interfaceC11537d);

    /* renamed from: h */
    <T> InterfaceC11537d<T> mo7832h(InterfaceC11537d<? super T> interfaceC11537d);
}
