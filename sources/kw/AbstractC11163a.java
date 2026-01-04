package kw;

import java.util.Collection;
import java.util.Iterator;
import p692uw.AbstractC13268k;
import p692uw.C13263f;
import p692uw.C13267j;
import tw.InterfaceC13086l;

/* renamed from: kw.a */
/* loaded from: classes9.dex */
public abstract class AbstractC11163a<E> implements Collection<E> {

    /* renamed from: kw.a$a */
    public static final class a extends AbstractC13268k implements InterfaceC13086l<E, CharSequence> {

        /* renamed from: b */
        public final /* synthetic */ AbstractC11163a<E> f52505b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(AbstractC11163a<? extends E> abstractC11163a) {
            super(1);
            this.f52505b = abstractC11163a;
        }

        @Override // tw.InterfaceC13086l
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public final CharSequence mo5000c(E e10) {
            return e10 == this.f52505b ? "(this Collection)" : String.valueOf(e10);
        }
    }

    /* renamed from: a */
    public abstract int mo6418a();

    @Override // java.util.Collection
    public boolean add(E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean contains(E e10) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (C13267j.m79673a(it.next(), e10)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        C13267j.m79677e(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return mo6418a();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C13267j.m79677e(tArr, "array");
        return (T[]) C13263f.m79670b(this, tArr);
    }

    public String toString() {
        return C11194u.m67188r(this, ", ", "[", "]", 0, null, new a(this), 24, null);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return C13263f.m79669a(this);
    }
}
