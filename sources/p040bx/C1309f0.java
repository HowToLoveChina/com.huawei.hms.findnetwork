package p040bx;

import kotlinx.coroutines.internal.C11087d;
import kotlinx.coroutines.internal.C11108y;
import mw.InterfaceC11537d;
import mw.InterfaceC11539f;
import p408jw.C10945k;
import p408jw.C10946l;
import p408jw.C10951q;

/* renamed from: bx.f0 */
/* loaded from: classes9.dex */
public final class C1309f0 {
    /* renamed from: a */
    public static final <T> void m7750a(AbstractC1306e0<? super T> abstractC1306e0, int i10) {
        InterfaceC11537d<? super T> interfaceC11537dMo7742e = abstractC1306e0.mo7742e();
        boolean z10 = i10 == 4;
        if (z10 || !(interfaceC11537dMo7742e instanceof C11087d) || m7751b(i10) != m7751b(abstractC1306e0.f5794c)) {
            m7753d(abstractC1306e0, interfaceC11537dMo7742e, z10);
            return;
        }
        AbstractC1344t abstractC1344t = ((C11087d) interfaceC11537dMo7742e).f52300d;
        InterfaceC11539f context = interfaceC11537dMo7742e.getContext();
        if (abstractC1344t.mo7788d(context)) {
            abstractC1344t.mo7787c(context, abstractC1306e0);
        } else {
            m7754e(abstractC1306e0);
        }
    }

    /* renamed from: b */
    public static final boolean m7751b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    /* renamed from: c */
    public static final boolean m7752c(int i10) {
        return i10 == 2;
    }

    /* renamed from: d */
    public static final <T> void m7753d(AbstractC1306e0<? super T> abstractC1306e0, InterfaceC11537d<? super T> interfaceC11537d, boolean z10) {
        Object objMo7744g;
        Object objMo7746i = abstractC1306e0.mo7746i();
        Throwable thMo7743f = abstractC1306e0.mo7743f(objMo7746i);
        if (thMo7743f != null) {
            C10945k.a aVar = C10945k.f51855a;
            objMo7744g = C10946l.m66073a(thMo7743f);
        } else {
            C10945k.a aVar2 = C10945k.f51855a;
            objMo7744g = abstractC1306e0.mo7744g(objMo7746i);
        }
        Object objM66070b = C10945k.m66070b(objMo7744g);
        if (!z10) {
            interfaceC11537d.mo7657d(objM66070b);
            return;
        }
        C11087d c11087d = (C11087d) interfaceC11537d;
        InterfaceC11537d<T> interfaceC11537d2 = c11087d.f52301e;
        Object obj = c11087d.f52303g;
        InterfaceC11539f context = interfaceC11537d2.getContext();
        Object objM66819c = C11108y.m66819c(context, obj);
        C1325k1<?> c1325k1M7830c = objM66819c != C11108y.f52334a ? C1342s.m7830c(interfaceC11537d2, context, objM66819c) : null;
        try {
            c11087d.f52301e.mo7657d(objM66070b);
            C10951q c10951q = C10951q.f51861a;
        } finally {
            if (c1325k1M7830c == null || c1325k1M7830c.m7810l0()) {
                C11108y.m66817a(context, objM66819c);
            }
        }
    }

    /* renamed from: e */
    public static final void m7754e(AbstractC1306e0<?> abstractC1306e0) {
        AbstractC1321j0 abstractC1321j0M7775a = C1319i1.f5807a.m7775a();
        if (abstractC1321j0M7775a.m7780C()) {
            abstractC1321j0M7775a.m7785n(abstractC1306e0);
            return;
        }
        abstractC1321j0M7775a.m7779A(true);
        try {
            m7753d(abstractC1306e0, abstractC1306e0.mo7742e(), true);
            do {
            } while (abstractC1321j0M7775a.m7782E());
        } finally {
            try {
            } finally {
            }
        }
    }
}
