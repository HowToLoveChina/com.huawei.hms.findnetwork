package kw;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import p692uw.C13264g;
import p692uw.C13267j;

/* renamed from: kw.b */
/* loaded from: classes9.dex */
public abstract class AbstractC11165b<E> extends AbstractC11163a<E> implements List<E> {

    /* renamed from: a */
    public static final a f52506a = new a(null);

    /* renamed from: kw.b$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final void m67108a(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("startIndex: " + i10 + ", endIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("startIndex: " + i10 + " > endIndex: " + i11);
        }

        /* renamed from: b */
        public final void m67109b(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        /* renamed from: c */
        public final void m67110c(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        /* renamed from: d */
        public final void m67111d(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
        }

        /* renamed from: e */
        public final boolean m67112e(Collection<?> collection, Collection<?> collection2) {
            C13267j.m79677e(collection, "c");
            C13267j.m79677e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!C13267j.m79673a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: f */
        public final int m67113f(Collection<?> collection) {
            C13267j.m79677e(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public a() {
        }
    }

    /* renamed from: kw.b$b */
    public class b implements Iterator<E> {

        /* renamed from: a */
        public int f52507a;

        public b() {
        }

        /* renamed from: b */
        public final int m67114b() {
            return this.f52507a;
        }

        /* renamed from: c */
        public final void m67115c(int i10) {
            this.f52507a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f52507a < AbstractC11165b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC11165b<E> abstractC11165b = AbstractC11165b.this;
            int i10 = this.f52507a;
            this.f52507a = i10 + 1;
            return abstractC11165b.get(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: kw.b$c */
    public class c extends AbstractC11165b<E>.b implements ListIterator<E> {
        public c(int i10) {
            super();
            AbstractC11165b.f52506a.m67110c(i10, AbstractC11165b.this.size());
            m67115c(i10);
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return m67114b() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return m67114b();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC11165b<E> abstractC11165b = AbstractC11165b.this;
            m67115c(m67114b() - 1);
            return abstractC11165b.get(m67114b());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return m67114b() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: kw.b$d */
    public static final class d<E> extends AbstractC11165b<E> implements RandomAccess {

        /* renamed from: b */
        public final AbstractC11165b<E> f52510b;

        /* renamed from: c */
        public final int f52511c;

        /* renamed from: d */
        public int f52512d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(AbstractC11165b<? extends E> abstractC11165b, int i10, int i11) {
            C13267j.m79677e(abstractC11165b, "list");
            this.f52510b = abstractC11165b;
            this.f52511c = i10;
            AbstractC11165b.f52506a.m67111d(i10, i11, abstractC11165b.size());
            this.f52512d = i11 - i10;
        }

        @Override // kw.AbstractC11163a
        /* renamed from: a */
        public int mo6418a() {
            return this.f52512d;
        }

        @Override // kw.AbstractC11165b, java.util.List
        public E get(int i10) {
            AbstractC11165b.f52506a.m67109b(i10, this.f52512d);
            return this.f52510b.get(this.f52511c + i10);
        }
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f52506a.m67112e(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i10);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f52506a.m67113f(this);
    }

    public int indexOf(E e10) {
        Iterator<E> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (C13267j.m79673a(it.next(), e10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(E e10) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (C13267j.m79673a(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i10) {
        return new c(i10);
    }
}
