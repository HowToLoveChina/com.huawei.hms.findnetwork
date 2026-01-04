package p438l;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: l.f */
/* loaded from: classes.dex */
public abstract class AbstractC11212f<K, V> {

    /* renamed from: a */
    public AbstractC11212f<K, V>.b f52624a;

    /* renamed from: b */
    public AbstractC11212f<K, V>.c f52625b;

    /* renamed from: c */
    public AbstractC11212f<K, V>.e f52626c;

    /* renamed from: l.f$a */
    public final class a<T> implements Iterator<T> {

        /* renamed from: a */
        public final int f52627a;

        /* renamed from: b */
        public int f52628b;

        /* renamed from: c */
        public int f52629c;

        /* renamed from: d */
        public boolean f52630d = false;

        public a(int i10) {
            this.f52627a = i10;
            this.f52628b = AbstractC11212f.this.mo67273d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f52629c < this.f52628b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t10 = (T) AbstractC11212f.this.mo67271b(this.f52629c, this.f52627a);
            this.f52629c++;
            this.f52630d = true;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f52630d) {
                throw new IllegalStateException();
            }
            int i10 = this.f52629c - 1;
            this.f52629c = i10;
            this.f52628b--;
            this.f52630d = false;
            AbstractC11212f.this.mo67277h(i10);
        }
    }

    /* renamed from: l.f$b */
    public final class b implements Set<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iMo67273d = AbstractC11212f.this.mo67273d();
            for (Map.Entry<K, V> entry : collection) {
                AbstractC11212f.this.mo67276g(entry.getKey(), entry.getValue());
            }
            return iMo67273d != AbstractC11212f.this.mo67273d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC11212f.this.mo67270a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iMo67274e = AbstractC11212f.this.mo67274e(entry.getKey());
            if (iMo67274e < 0) {
                return false;
            }
            return C11209c.m67289c(AbstractC11212f.this.mo67271b(iMo67274e, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC11212f.m67313k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo67273d = AbstractC11212f.this.mo67273d() - 1; iMo67273d >= 0; iMo67273d--) {
                Object objMo67271b = AbstractC11212f.this.mo67271b(iMo67273d, 0);
                Object objMo67271b2 = AbstractC11212f.this.mo67271b(iMo67273d, 1);
                iHashCode += (objMo67271b == null ? 0 : objMo67271b.hashCode()) ^ (objMo67271b2 == null ? 0 : objMo67271b2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC11212f.this.mo67273d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC11212f.this.mo67273d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: l.f$c */
    public final class c implements Set<K> {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC11212f.this.mo67270a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC11212f.this.mo67274e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return AbstractC11212f.m67312j(AbstractC11212f.this.mo67272c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC11212f.m67313k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo67273d = AbstractC11212f.this.mo67273d() - 1; iMo67273d >= 0; iMo67273d--) {
                Object objMo67271b = AbstractC11212f.this.mo67271b(iMo67273d, 0);
                iHashCode += objMo67271b == null ? 0 : objMo67271b.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC11212f.this.mo67273d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iMo67274e = AbstractC11212f.this.mo67274e(obj);
            if (iMo67274e < 0) {
                return false;
            }
            AbstractC11212f.this.mo67277h(iMo67274e);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return AbstractC11212f.m67314o(AbstractC11212f.this.mo67272c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return AbstractC11212f.m67315p(AbstractC11212f.this.mo67272c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC11212f.this.mo67273d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC11212f.this.m67319q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC11212f.this.m67320r(tArr, 0);
        }
    }

    /* renamed from: l.f$d */
    public final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        public int f52634a;

        /* renamed from: c */
        public boolean f52636c = false;

        /* renamed from: b */
        public int f52635b = -1;

        public d() {
            this.f52634a = AbstractC11212f.this.mo67273d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f52635b++;
            this.f52636c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f52636c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return C11209c.m67289c(entry.getKey(), AbstractC11212f.this.mo67271b(this.f52635b, 0)) && C11209c.m67289c(entry.getValue(), AbstractC11212f.this.mo67271b(this.f52635b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f52636c) {
                return (K) AbstractC11212f.this.mo67271b(this.f52635b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f52636c) {
                return (V) AbstractC11212f.this.mo67271b(this.f52635b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f52635b < this.f52634a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f52636c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objMo67271b = AbstractC11212f.this.mo67271b(this.f52635b, 0);
            Object objMo67271b2 = AbstractC11212f.this.mo67271b(this.f52635b, 1);
            return (objMo67271b == null ? 0 : objMo67271b.hashCode()) ^ (objMo67271b2 != null ? objMo67271b2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f52636c) {
                throw new IllegalStateException();
            }
            AbstractC11212f.this.mo67277h(this.f52635b);
            this.f52635b--;
            this.f52634a--;
            this.f52636c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            if (this.f52636c) {
                return (V) AbstractC11212f.this.mo67278i(this.f52635b, v10);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: l.f$e */
    public final class e implements Collection<V> {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(V v10) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC11212f.this.mo67270a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC11212f.this.mo67275f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC11212f.this.mo67273d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iMo67275f = AbstractC11212f.this.mo67275f(obj);
            if (iMo67275f < 0) {
                return false;
            }
            AbstractC11212f.this.mo67277h(iMo67275f);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iMo67273d = AbstractC11212f.this.mo67273d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < iMo67273d) {
                if (collection.contains(AbstractC11212f.this.mo67271b(i10, 1))) {
                    AbstractC11212f.this.mo67277h(i10);
                    i10--;
                    iMo67273d--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iMo67273d = AbstractC11212f.this.mo67273d();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < iMo67273d) {
                if (!collection.contains(AbstractC11212f.this.mo67271b(i10, 1))) {
                    AbstractC11212f.this.mo67277h(i10);
                    i10--;
                    iMo67273d--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC11212f.this.mo67273d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC11212f.this.m67319q(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC11212f.this.m67320r(tArr, 1);
        }
    }

    /* renamed from: j */
    public static <K, V> boolean m67312j(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public static <T> boolean m67313k(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: o */
    public static <K, V> boolean m67314o(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: p */
    public static <K, V> boolean m67315p(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: a */
    public abstract void mo67270a();

    /* renamed from: b */
    public abstract Object mo67271b(int i10, int i11);

    /* renamed from: c */
    public abstract Map<K, V> mo67272c();

    /* renamed from: d */
    public abstract int mo67273d();

    /* renamed from: e */
    public abstract int mo67274e(Object obj);

    /* renamed from: f */
    public abstract int mo67275f(Object obj);

    /* renamed from: g */
    public abstract void mo67276g(K k10, V v10);

    /* renamed from: h */
    public abstract void mo67277h(int i10);

    /* renamed from: i */
    public abstract V mo67278i(int i10, V v10);

    /* renamed from: l */
    public Set<Map.Entry<K, V>> m67316l() {
        if (this.f52624a == null) {
            this.f52624a = new b();
        }
        return this.f52624a;
    }

    /* renamed from: m */
    public Set<K> m67317m() {
        if (this.f52625b == null) {
            this.f52625b = new c();
        }
        return this.f52625b;
    }

    /* renamed from: n */
    public Collection<V> m67318n() {
        if (this.f52626c == null) {
            this.f52626c = new e();
        }
        return this.f52626c;
    }

    /* renamed from: q */
    public Object[] m67319q(int i10) {
        int iMo67273d = mo67273d();
        Object[] objArr = new Object[iMo67273d];
        for (int i11 = 0; i11 < iMo67273d; i11++) {
            objArr[i11] = mo67271b(i11, i10);
        }
        return objArr;
    }

    /* renamed from: r */
    public <T> T[] m67320r(T[] tArr, int i10) {
        int iMo67273d = mo67273d();
        if (tArr.length < iMo67273d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iMo67273d));
        }
        for (int i11 = 0; i11 < iMo67273d; i11++) {
            tArr[i11] = mo67271b(i11, i10);
        }
        if (tArr.length > iMo67273d) {
            tArr[iMo67273d] = null;
        }
        return tArr;
    }
}
