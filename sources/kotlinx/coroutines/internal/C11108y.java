package kotlinx.coroutines.internal;

import mw.InterfaceC11539f;
import p040bx.InterfaceC1316h1;
import p692uw.AbstractC13268k;
import p692uw.C13267j;
import tw.InterfaceC13090p;

/* renamed from: kotlinx.coroutines.internal.y */
/* loaded from: classes9.dex */
public final class C11108y {

    /* renamed from: a */
    public static final C11104u f52334a = new C11104u("NO_THREAD_ELEMENTS");

    /* renamed from: b */
    public static final InterfaceC13090p<Object, InterfaceC11539f.b, Object> f52335b = a.f52338b;

    /* renamed from: c */
    public static final InterfaceC13090p<InterfaceC1316h1<?>, InterfaceC11539f.b, InterfaceC1316h1<?>> f52336c = b.f52339b;

    /* renamed from: d */
    public static final InterfaceC13090p<C11085b0, InterfaceC11539f.b, C11085b0> f52337d = c.f52340b;

    /* renamed from: kotlinx.coroutines.internal.y$a */
    public static final class a extends AbstractC13268k implements InterfaceC13090p<Object, InterfaceC11539f.b, Object> {

        /* renamed from: b */
        public static final a f52338b = new a();

        public a() {
            super(2);
        }

        @Override // tw.InterfaceC13090p
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final Object mo6288d(Object obj, InterfaceC11539f.b bVar) {
            if (!(bVar instanceof InterfaceC1316h1)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num == null ? 1 : num.intValue();
            return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
        }
    }

    /* renamed from: kotlinx.coroutines.internal.y$b */
    public static final class b extends AbstractC13268k implements InterfaceC13090p<InterfaceC1316h1<?>, InterfaceC11539f.b, InterfaceC1316h1<?>> {

        /* renamed from: b */
        public static final b f52339b = new b();

        public b() {
            super(2);
        }

        @Override // tw.InterfaceC13090p
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final InterfaceC1316h1<?> mo6288d(InterfaceC1316h1<?> interfaceC1316h1, InterfaceC11539f.b bVar) {
            if (interfaceC1316h1 != null) {
                return interfaceC1316h1;
            }
            if (bVar instanceof InterfaceC1316h1) {
                return (InterfaceC1316h1) bVar;
            }
            return null;
        }
    }

    /* renamed from: kotlinx.coroutines.internal.y$c */
    public static final class c extends AbstractC13268k implements InterfaceC13090p<C11085b0, InterfaceC11539f.b, C11085b0> {

        /* renamed from: b */
        public static final c f52340b = new c();

        public c() {
            super(2);
        }

        @Override // tw.InterfaceC13090p
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final C11085b0 mo6288d(C11085b0 c11085b0, InterfaceC11539f.b bVar) {
            if (bVar instanceof InterfaceC1316h1) {
                InterfaceC1316h1<?> interfaceC1316h1 = (InterfaceC1316h1) bVar;
                c11085b0.m66741a(interfaceC1316h1, interfaceC1316h1.m7772e(c11085b0.f52294a));
            }
            return c11085b0;
        }
    }

    /* renamed from: a */
    public static final void m66817a(InterfaceC11539f interfaceC11539f, Object obj) {
        if (obj == f52334a) {
            return;
        }
        if (obj instanceof C11085b0) {
            ((C11085b0) obj).m66742b(interfaceC11539f);
            return;
        }
        Object objFold = interfaceC11539f.fold(null, f52336c);
        if (objFold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((InterfaceC1316h1) objFold).m7773j(interfaceC11539f, obj);
    }

    /* renamed from: b */
    public static final Object m66818b(InterfaceC11539f interfaceC11539f) {
        Object objFold = interfaceC11539f.fold(0, f52335b);
        C13267j.m79674b(objFold);
        return objFold;
    }

    /* renamed from: c */
    public static final Object m66819c(InterfaceC11539f interfaceC11539f, Object obj) {
        if (obj == null) {
            obj = m66818b(interfaceC11539f);
        }
        return obj == 0 ? f52334a : obj instanceof Integer ? interfaceC11539f.fold(new C11085b0(interfaceC11539f, ((Number) obj).intValue()), f52337d) : ((InterfaceC1316h1) obj).m7772e(interfaceC11539f);
    }
}
