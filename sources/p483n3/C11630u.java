package p483n3;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p468m3.C11397c;

/* renamed from: n3.u */
/* loaded from: classes.dex */
public final class C11630u {

    /* renamed from: n3.u$a */
    public static abstract class a<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return C11630u.m69494c(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) C11397c.m68310g(collection));
        }
    }

    /* renamed from: a */
    public static <E> HashSet<E> m69492a() {
        return new HashSet<>();
    }

    /* renamed from: b */
    public static <E> HashSet<E> m69493b(int i10) {
        return new HashSet<>(C11623n.m69473a(i10));
    }

    /* renamed from: c */
    public static boolean m69494c(Set<?> set, Collection<?> collection) {
        C11397c.m68310g(collection);
        if (collection instanceof InterfaceC11626q) {
            collection = ((InterfaceC11626q) collection).m69485t();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? m69495d(set, collection.iterator()) : C11622m.m69472c(set.iterator(), collection);
    }

    /* renamed from: d */
    public static boolean m69495d(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
