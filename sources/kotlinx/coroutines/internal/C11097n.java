package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import p040bx.AbstractC1301c1;
import zw.C14397f;
import zw.C14399h;

/* renamed from: kotlinx.coroutines.internal.n */
/* loaded from: classes9.dex */
public final class C11097n {

    /* renamed from: a */
    public static final C11097n f52328a;

    /* renamed from: b */
    public static final AbstractC1301c1 f52329b;

    static {
        C11097n c11097n = new C11097n();
        f52328a = c11097n;
        C11105v.m66807e("kotlinx.coroutines.fast.service.loader", true);
        f52329b = c11097n.m66793a();
    }

    /* renamed from: a */
    public final AbstractC1301c1 m66793a() {
        Object next;
        try {
            List listM85628e = C14399h.m85628e(C14397f.m85624a(ServiceLoader.load(InterfaceC11096m.class, InterfaceC11096m.class.getClassLoader()).iterator()));
            Iterator it = listM85628e.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((InterfaceC11096m) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((InterfaceC11096m) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            InterfaceC11096m interfaceC11096m = (InterfaceC11096m) next;
            AbstractC1301c1 abstractC1301c1M66798e = interfaceC11096m == null ? null : C11098o.m66798e(interfaceC11096m, listM85628e);
            return abstractC1301c1M66798e == null ? C11098o.m66795b(null, null, 3, null) : abstractC1301c1M66798e;
        } catch (Throwable th2) {
            return C11098o.m66795b(th2, null, 2, null);
        }
    }
}
