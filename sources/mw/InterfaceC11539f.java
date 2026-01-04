package mw;

import com.huawei.openalliance.p169ad.constant.ParamConstants;
import mw.InterfaceC11538e;
import p692uw.AbstractC13268k;
import p692uw.C13267j;
import tw.InterfaceC13090p;

/* renamed from: mw.f */
/* loaded from: classes9.dex */
public interface InterfaceC11539f {

    /* renamed from: mw.f$a */
    public static final class a {

        /* renamed from: mw.f$a$a */
        public static final class C14508a extends AbstractC13268k implements InterfaceC13090p<InterfaceC11539f, b, InterfaceC11539f> {

            /* renamed from: b */
            public static final C14508a f53496b = new C14508a();

            public C14508a() {
                super(2);
            }

            @Override // tw.InterfaceC13090p
            /* renamed from: e */
            public final InterfaceC11539f mo6288d(InterfaceC11539f interfaceC11539f, b bVar) {
                C11536c c11536c;
                C13267j.m79677e(interfaceC11539f, "acc");
                C13267j.m79677e(bVar, "element");
                InterfaceC11539f interfaceC11539fMinusKey = interfaceC11539f.minusKey(bVar.getKey());
                C11540g c11540g = C11540g.f53497a;
                if (interfaceC11539fMinusKey == c11540g) {
                    return bVar;
                }
                InterfaceC11538e.b bVar2 = InterfaceC11538e.f53494h2;
                InterfaceC11538e interfaceC11538e = (InterfaceC11538e) interfaceC11539fMinusKey.get(bVar2);
                if (interfaceC11538e == null) {
                    c11536c = new C11536c(interfaceC11539fMinusKey, bVar);
                } else {
                    InterfaceC11539f interfaceC11539fMinusKey2 = interfaceC11539fMinusKey.minusKey(bVar2);
                    if (interfaceC11539fMinusKey2 == c11540g) {
                        return new C11536c(bVar, interfaceC11538e);
                    }
                    c11536c = new C11536c(new C11536c(interfaceC11539fMinusKey2, bVar), interfaceC11538e);
                }
                return c11536c;
            }
        }

        /* renamed from: a */
        public static InterfaceC11539f m68837a(InterfaceC11539f interfaceC11539f, InterfaceC11539f interfaceC11539f2) {
            C13267j.m79677e(interfaceC11539f2, ParamConstants.Param.CONTEXT);
            return interfaceC11539f2 == C11540g.f53497a ? interfaceC11539f : (InterfaceC11539f) interfaceC11539f2.fold(interfaceC11539f, C14508a.f53496b);
        }
    }

    /* renamed from: mw.f$b */
    public interface b extends InterfaceC11539f {

        /* renamed from: mw.f$b$a */
        public static final class a {
            /* renamed from: a */
            public static <R> R m68839a(b bVar, R r10, InterfaceC13090p<? super R, ? super b, ? extends R> interfaceC13090p) {
                C13267j.m79677e(interfaceC13090p, "operation");
                return interfaceC13090p.mo6288d(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: b */
            public static <E extends b> E m68840b(b bVar, c<E> cVar) {
                C13267j.m79677e(cVar, "key");
                if (!C13267j.m79673a(bVar.getKey(), cVar)) {
                    return null;
                }
                C13267j.m79675c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            /* renamed from: c */
            public static InterfaceC11539f m68841c(b bVar, c<?> cVar) {
                C13267j.m79677e(cVar, "key");
                return C13267j.m79673a(bVar.getKey(), cVar) ? C11540g.f53497a : bVar;
            }

            /* renamed from: d */
            public static InterfaceC11539f m68842d(b bVar, InterfaceC11539f interfaceC11539f) {
                C13267j.m79677e(interfaceC11539f, ParamConstants.Param.CONTEXT);
                return a.m68837a(bVar, interfaceC11539f);
            }
        }

        @Override // mw.InterfaceC11539f
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* renamed from: mw.f$c */
    public interface c<E extends b> {
    }

    <R> R fold(R r10, InterfaceC13090p<? super R, ? super b, ? extends R> interfaceC13090p);

    <E extends b> E get(c<E> cVar);

    InterfaceC11539f minusKey(c<?> cVar);

    InterfaceC11539f plus(InterfaceC11539f interfaceC11539f);
}
