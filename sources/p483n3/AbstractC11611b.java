package p483n3;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import p468m3.C11397c;
import p483n3.C11623n;

/* renamed from: n3.b */
/* loaded from: classes.dex */
public abstract class AbstractC11611b<K, V> extends AbstractC11613d<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: c */
    public transient Map<K, Collection<V>> f53908c;

    /* renamed from: d */
    public transient int f53909d;

    /* renamed from: n3.b$a */
    public class a extends C11623n.e<K, Collection<V>> {

        /* renamed from: c */
        public final transient Map<K, Collection<V>> f53910c;

        /* renamed from: n3.b$a$a */
        public class C14509a extends C11623n.b<K, Collection<V>> {
            public C14509a() {
            }

            @Override // p483n3.C11623n.b
            /* renamed from: a */
            public Map<K, Collection<V>> mo69382a() {
                return a.this;
            }

            @Override // p483n3.C11623n.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return C11617h.m69400a(a.this.f53910c.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return a.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractC11611b.this.m69375t(entry.getKey());
                return true;
            }
        }

        /* renamed from: n3.b$a$b */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a */
            public final Iterator<Map.Entry<K, Collection<V>>> f53913a;

            /* renamed from: b */
            public Collection<V> f53914b;

            public b() {
                this.f53913a = a.this.f53910c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f53913a.next();
                this.f53914b = next.getValue();
                return a.this.m69381e(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f53913a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                C11397c.m68311h(this.f53914b != null, "no calls to next() since the last call to remove()");
                this.f53913a.remove();
                AbstractC11611b.m69367m(AbstractC11611b.this, this.f53914b.size());
                this.f53914b.clear();
                this.f53914b = null;
            }
        }

        public a(Map<K, Collection<V>> map) {
            this.f53910c = map;
        }

        @Override // p483n3.C11623n.e
        /* renamed from: a */
        public Set<Map.Entry<K, Collection<V>>> mo69378a() {
            return new C14509a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: c */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) C11623n.m69476d(this.f53910c, obj);
            if (collection == null) {
                return null;
            }
            return AbstractC11611b.this.mo69360v(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f53910c == AbstractC11611b.this.f53908c) {
                AbstractC11611b.this.mo69372o();
            } else {
                C11622m.m69471b(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return C11623n.m69475c(this.f53910c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.f53910c.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionMo69373p = AbstractC11611b.this.mo69373p();
            collectionMo69373p.addAll(collectionRemove);
            AbstractC11611b.m69367m(AbstractC11611b.this, collectionRemove.size());
            collectionRemove.clear();
            return collectionMo69373p;
        }

        /* renamed from: e */
        public Map.Entry<K, Collection<V>> m69381e(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return C11623n.m69474b(key, AbstractC11611b.this.mo69360v(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f53910c.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f53910c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractC11611b.this.mo69394e();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f53910c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f53910c.toString();
        }
    }

    /* renamed from: n3.b$b */
    public class b extends C11623n.c<K, Collection<V>> {

        /* renamed from: n3.b$b$a */
        public class a implements Iterator<K> {

            /* renamed from: a */
            public Map.Entry<K, Collection<V>> f53917a;

            /* renamed from: b */
            public final /* synthetic */ Iterator f53918b;

            public a(Iterator it) {
                this.f53918b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f53918b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f53918b.next();
                this.f53917a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                C11397c.m68311h(this.f53917a != null, "no calls to next() since the last call to remove()");
                Collection<V> value = this.f53917a.getValue();
                this.f53918b.remove();
                AbstractC11611b.m69367m(AbstractC11611b.this, value.size());
                value.clear();
                this.f53917a = null;
            }
        }

        public b(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C11622m.m69471b(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return m69481a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || m69481a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return m69481a().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(m69481a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Collection<V> collectionRemove = m69481a().remove(obj);
            if (collectionRemove != null) {
                int size = collectionRemove.size();
                collectionRemove.clear();
                AbstractC11611b.m69367m(AbstractC11611b.this, size);
                if (size > 0) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: n3.b$c */
    public class c extends AbstractC11611b<K, V>.e implements RandomAccess {
        public c(AbstractC11611b abstractC11611b, K k10, List<V> list, AbstractC11611b<K, V>.d dVar) {
            super(k10, list, dVar);
        }
    }

    public AbstractC11611b(Map<K, Collection<V>> map) {
        C11397c.m68304a(map.isEmpty());
        this.f53908c = map;
    }

    /* renamed from: j */
    public static /* synthetic */ int m69364j(AbstractC11611b abstractC11611b) {
        int i10 = abstractC11611b.f53909d;
        abstractC11611b.f53909d = i10 + 1;
        return i10;
    }

    /* renamed from: k */
    public static /* synthetic */ int m69365k(AbstractC11611b abstractC11611b) {
        int i10 = abstractC11611b.f53909d;
        abstractC11611b.f53909d = i10 - 1;
        return i10;
    }

    /* renamed from: l */
    public static /* synthetic */ int m69366l(AbstractC11611b abstractC11611b, int i10) {
        int i11 = abstractC11611b.f53909d + i10;
        abstractC11611b.f53909d = i11;
        return i11;
    }

    /* renamed from: m */
    public static /* synthetic */ int m69367m(AbstractC11611b abstractC11611b, int i10) {
        int i11 = abstractC11611b.f53909d - i10;
        abstractC11611b.f53909d = i11;
        return i11;
    }

    /* renamed from: r */
    public static <E> Iterator<E> m69369r(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // p483n3.AbstractC11613d
    /* renamed from: c */
    public Map<K, Collection<V>> mo69370c() {
        return new a(this.f53908c);
    }

    @Override // p483n3.AbstractC11613d
    /* renamed from: d */
    public Set<K> mo69371d() {
        return new b(this.f53908c);
    }

    @Override // p483n3.InterfaceC11624o
    public Collection<V> get(K k10) {
        Collection<V> collectionM69374q = this.f53908c.get(k10);
        if (collectionM69374q == null) {
            collectionM69374q = m69374q(k10);
        }
        return mo69360v(k10, collectionM69374q);
    }

    /* renamed from: o */
    public void mo69372o() {
        Iterator<Collection<V>> it = this.f53908c.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f53908c.clear();
        this.f53909d = 0;
    }

    /* renamed from: p */
    public abstract Collection<V> mo69373p();

    /* renamed from: q */
    public Collection<V> m69374q(K k10) {
        return mo69373p();
    }

    /* renamed from: s */
    public boolean mo69359s(K k10, V v10) {
        Collection<V> collection = this.f53908c.get(k10);
        if (collection != null) {
            if (!collection.add(v10)) {
                return false;
            }
            this.f53909d++;
            return true;
        }
        Collection<V> collectionM69374q = m69374q(k10);
        if (!collectionM69374q.add(v10)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f53909d++;
        this.f53908c.put(k10, collectionM69374q);
        return true;
    }

    /* renamed from: t */
    public final void m69375t(Object obj) {
        Collection collection = (Collection) C11623n.m69477e(this.f53908c, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f53909d -= size;
        }
    }

    /* renamed from: u */
    public final void m69376u(Map<K, Collection<V>> map) {
        this.f53908c = map;
        this.f53909d = 0;
        for (Collection<V> collection : map.values()) {
            C11397c.m68304a(!collection.isEmpty());
            this.f53909d += collection.size();
        }
    }

    /* renamed from: v */
    public abstract Collection<V> mo69360v(K k10, Collection<V> collection);

    /* renamed from: w */
    public final List<V> m69377w(K k10, List<V> list, AbstractC11611b<K, V>.d dVar) {
        return list instanceof RandomAccess ? new c(this, k10, list, dVar) : new e(k10, list, dVar);
    }

    /* renamed from: n3.b$d */
    public class d extends AbstractCollection<V> {

        /* renamed from: a */
        public final K f53920a;

        /* renamed from: b */
        public Collection<V> f53921b;

        /* renamed from: c */
        public final AbstractC11611b<K, V>.d f53922c;

        /* renamed from: d */
        public final Collection<V> f53923d;

        public d(K k10, Collection<V> collection, AbstractC11611b<K, V>.d dVar) {
            this.f53920a = k10;
            this.f53921b = collection;
            this.f53922c = dVar;
            this.f53923d = dVar == null ? null : dVar.m69386c();
        }

        /* renamed from: a */
        public void m69384a() {
            AbstractC11611b<K, V>.d dVar = this.f53922c;
            if (dVar != null) {
                dVar.m69384a();
            } else {
                AbstractC11611b.this.f53908c.put(this.f53920a, this.f53921b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v10) {
            m69388e();
            boolean zIsEmpty = this.f53921b.isEmpty();
            boolean zAdd = this.f53921b.add(v10);
            if (zAdd) {
                AbstractC11611b.m69364j(AbstractC11611b.this);
                if (zIsEmpty) {
                    m69384a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f53921b.addAll(collection);
            if (zAddAll) {
                AbstractC11611b.m69366l(AbstractC11611b.this, this.f53921b.size() - size);
                if (size == 0) {
                    m69384a();
                }
            }
            return zAddAll;
        }

        /* renamed from: b */
        public AbstractC11611b<K, V>.d m69385b() {
            return this.f53922c;
        }

        /* renamed from: c */
        public Collection<V> m69386c() {
            return this.f53921b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f53921b.clear();
            AbstractC11611b.m69367m(AbstractC11611b.this, size);
            m69389f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            m69388e();
            return this.f53921b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            m69388e();
            return this.f53921b.containsAll(collection);
        }

        /* renamed from: d */
        public K m69387d() {
            return this.f53920a;
        }

        /* renamed from: e */
        public void m69388e() {
            Collection<V> collection;
            AbstractC11611b<K, V>.d dVar = this.f53922c;
            if (dVar != null) {
                dVar.m69388e();
                if (this.f53922c.m69386c() != this.f53923d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f53921b.isEmpty() || (collection = (Collection) AbstractC11611b.this.f53908c.get(this.f53920a)) == null) {
                    return;
                }
                this.f53921b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            m69388e();
            return this.f53921b.equals(obj);
        }

        /* renamed from: f */
        public void m69389f() {
            AbstractC11611b<K, V>.d dVar = this.f53922c;
            if (dVar != null) {
                dVar.m69389f();
            } else if (this.f53921b.isEmpty()) {
                AbstractC11611b.this.f53908c.remove(this.f53920a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            m69388e();
            return this.f53921b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            m69388e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            m69388e();
            boolean zRemove = this.f53921b.remove(obj);
            if (zRemove) {
                AbstractC11611b.m69365k(AbstractC11611b.this);
                m69389f();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f53921b.removeAll(collection);
            if (zRemoveAll) {
                AbstractC11611b.m69366l(AbstractC11611b.this, this.f53921b.size() - size);
                m69389f();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            C11397c.m68310g(collection);
            int size = size();
            boolean zRetainAll = this.f53921b.retainAll(collection);
            if (zRetainAll) {
                AbstractC11611b.m69366l(AbstractC11611b.this, this.f53921b.size() - size);
                m69389f();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            m69388e();
            return this.f53921b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            m69388e();
            return this.f53921b.toString();
        }

        /* renamed from: n3.b$d$a */
        public class a implements Iterator<V> {

            /* renamed from: a */
            public final Iterator<V> f53925a;

            /* renamed from: b */
            public final Collection<V> f53926b;

            public a() {
                Collection<V> collection = d.this.f53921b;
                this.f53926b = collection;
                this.f53925a = AbstractC11611b.m69369r(collection);
            }

            /* renamed from: b */
            public Iterator<V> m69390b() {
                m69391c();
                return this.f53925a;
            }

            /* renamed from: c */
            public void m69391c() {
                d.this.m69388e();
                if (d.this.f53921b != this.f53926b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                m69391c();
                return this.f53925a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                m69391c();
                return this.f53925a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f53925a.remove();
                AbstractC11611b.m69365k(AbstractC11611b.this);
                d.this.m69389f();
            }

            public a(Iterator<V> it) {
                this.f53926b = d.this.f53921b;
                this.f53925a = it;
            }
        }
    }

    /* renamed from: n3.b$e */
    public class e extends AbstractC11611b<K, V>.d implements List<V> {

        /* renamed from: n3.b$e$a */
        public class a extends AbstractC11611b<K, V>.d.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(V v10) {
                boolean zIsEmpty = e.this.isEmpty();
                m69393d().add(v10);
                AbstractC11611b.m69364j(AbstractC11611b.this);
                if (zIsEmpty) {
                    e.this.m69384a();
                }
            }

            /* renamed from: d */
            public final ListIterator<V> m69393d() {
                return (ListIterator) m69390b();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return m69393d().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return m69393d().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return m69393d().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return m69393d().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v10) {
                m69393d().set(v10);
            }

            public a(int i10) {
                super(e.this.m69392g().listIterator(i10));
            }
        }

        public e(K k10, List<V> list, AbstractC11611b<K, V>.d dVar) {
            super(k10, list, dVar);
        }

        @Override // java.util.List
        public void add(int i10, V v10) {
            m69388e();
            boolean zIsEmpty = m69386c().isEmpty();
            m69392g().add(i10, v10);
            AbstractC11611b.m69364j(AbstractC11611b.this);
            if (zIsEmpty) {
                m69384a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = m69392g().addAll(i10, collection);
            if (zAddAll) {
                AbstractC11611b.m69366l(AbstractC11611b.this, m69386c().size() - size);
                if (size == 0) {
                    m69384a();
                }
            }
            return zAddAll;
        }

        /* renamed from: g */
        public List<V> m69392g() {
            return (List) m69386c();
        }

        @Override // java.util.List
        public V get(int i10) {
            m69388e();
            return m69392g().get(i10);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            m69388e();
            return m69392g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            m69388e();
            return m69392g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            m69388e();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i10) {
            m69388e();
            V vRemove = m69392g().remove(i10);
            AbstractC11611b.m69365k(AbstractC11611b.this);
            m69389f();
            return vRemove;
        }

        @Override // java.util.List
        public V set(int i10, V v10) {
            m69388e();
            return m69392g().set(i10, v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [n3.b] */
        /* JADX WARN: Type inference failed for: r3v1, types: [n3.b$d] */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        @Override // java.util.List
        public List<V> subList(int i10, int i11) {
            m69388e();
            ?? r02 = AbstractC11611b.this;
            Object objM69387d = m69387d();
            List<V> listSubList = m69392g().subList(i10, i11);
            AbstractC11611b<K, V>.d dVarM69385b = m69385b();
            ?? M69385b = this;
            if (dVarM69385b != null) {
                M69385b = m69385b();
            }
            return r02.m69377w(objM69387d, listSubList, M69385b);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i10) {
            m69388e();
            return new a(i10);
        }
    }
}
