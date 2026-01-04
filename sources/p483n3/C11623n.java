package p483n3;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p468m3.C11396b;
import p468m3.C11397c;
import p483n3.C11630u;

/* renamed from: n3.n */
/* loaded from: classes.dex */
public final class C11623n {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* renamed from: n3.n$a */
    public class a<K, V> extends AbstractC11631v<Map.Entry<K, V>, V> {
        public a(Iterator it) {
            super(it);
        }

        @Override // p483n3.AbstractC11631v
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public V mo69479b(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* renamed from: n3.n$b */
    public static abstract class b<K, V> extends C11630u.a<Map.Entry<K, V>> {
        /* renamed from: a */
        public abstract Map<K, V> mo69382a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            mo69382a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return mo69382a().isEmpty();
        }

        @Override // p483n3.C11630u.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) C11397c.m68310g(collection));
            } catch (UnsupportedOperationException unused) {
                return C11630u.m69495d(this, collection.iterator());
            }
        }

        @Override // p483n3.C11630u.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) C11397c.m68310g(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetM69493b = C11630u.m69493b(collection.size());
                for (Object obj : collection) {
                    if (this.contains(obj) && (obj instanceof Map.Entry)) {
                        hashSetM69493b.add(((Map.Entry) obj).getKey());
                    }
                }
                return this.mo69382a().keySet().retainAll(hashSetM69493b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return mo69382a().size();
        }
    }

    /* renamed from: n3.n$c */
    public static class c<K, V> extends C11630u.a<K> {

        /* renamed from: a */
        public final Map<K, V> f53958a;

        public c(Map<K, V> map) {
            this.f53958a = (Map) C11397c.m68310g(map);
        }

        /* renamed from: a */
        public Map<K, V> m69481a() {
            return this.f53958a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return m69481a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return m69481a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m69481a().size();
        }
    }

    /* renamed from: n3.n$d */
    public static class d<K, V> extends AbstractCollection<V> {

        /* renamed from: a */
        public final Map<K, V> f53959a;

        public d(Map<K, V> map) {
            this.f53959a = (Map) C11397c.m68310g(map);
        }

        /* renamed from: a */
        public final Map<K, V> m69482a() {
            return this.f53959a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            m69482a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return m69482a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return m69482a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return C11623n.m69478f(m69482a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : this.m69482a().entrySet()) {
                    if (C11396b.m68302a(obj, entry.getValue())) {
                        this.m69482a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) C11397c.m68310g(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetM69492a = C11630u.m69492a();
                for (Map.Entry<K, V> entry : this.m69482a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetM69492a.add(entry.getKey());
                    }
                }
                return this.m69482a().keySet().removeAll(hashSetM69492a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) C11397c.m68310g(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetM69492a = C11630u.m69492a();
                for (Map.Entry<K, V> entry : this.m69482a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetM69492a.add(entry.getKey());
                    }
                }
                return this.m69482a().keySet().retainAll(hashSetM69492a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return m69482a().size();
        }
    }

    /* renamed from: n3.n$e */
    public static abstract class e<K, V> extends AbstractMap<K, V> {

        /* renamed from: a */
        public transient Set<Map.Entry<K, V>> f53960a;

        /* renamed from: b */
        public transient Collection<V> f53961b;

        /* renamed from: a */
        public abstract Set<Map.Entry<K, V>> mo69378a();

        /* renamed from: b */
        public Collection<V> m69483b() {
            return new d(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f53960a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setMo69378a = mo69378a();
            this.f53960a = setMo69378a;
            return setMo69378a;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f53961b;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionM69483b = m69483b();
            this.f53961b = collectionM69483b;
            return collectionM69483b;
        }
    }

    /* renamed from: a */
    public static int m69473a(int i10) {
        if (i10 < 3) {
            C11616g.m69398a(i10, "expectedSize");
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: b */
    public static <K, V> Map.Entry<K, V> m69474b(K k10, V v10) {
        return new C11621l(k10, v10);
    }

    /* renamed from: c */
    public static boolean m69475c(Map<?, ?> map, Object obj) {
        C11397c.m68310g(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* renamed from: d */
    public static <V> V m69476d(Map<?, V> map, Object obj) {
        C11397c.m68310g(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* renamed from: e */
    public static <V> V m69477e(Map<?, V> map, Object obj) {
        C11397c.m68310g(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static <K, V> Iterator<V> m69478f(Iterator<Map.Entry<K, V>> it) {
        return new a(it);
    }
}
