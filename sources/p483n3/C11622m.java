package p483n3;

import java.util.Collection;
import java.util.Iterator;
import p468m3.C11397c;

/* renamed from: n3.m */
/* loaded from: classes.dex */
public final class C11622m {
    /* renamed from: a */
    public static <T> boolean m69470a(Collection<T> collection, Iterator<? extends T> it) {
        C11397c.m68310g(collection);
        C11397c.m68310g(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    /* renamed from: b */
    public static void m69471b(Iterator<?> it) {
        C11397c.m68310g(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    /* renamed from: c */
    public static boolean m69472c(Iterator<?> it, Collection<?> collection) {
        C11397c.m68310g(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }
}
