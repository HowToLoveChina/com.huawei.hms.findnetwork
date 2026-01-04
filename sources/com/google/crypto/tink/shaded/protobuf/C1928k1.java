package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.C1959v;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* renamed from: com.google.crypto.tink.shaded.protobuf.k1 */
/* loaded from: classes.dex */
public class C1928k1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a */
    public final int f9190a;

    /* renamed from: b */
    public List<C1928k1<K, V>.e> f9191b;

    /* renamed from: c */
    public Map<K, V> f9192c;

    /* renamed from: d */
    public boolean f9193d;

    /* renamed from: e */
    public volatile C1928k1<K, V>.g f9194e;

    /* renamed from: f */
    public Map<K, V> f9195f;

    /* renamed from: g */
    public volatile C1928k1<K, V>.c f9196g;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$a */
    public class a<FieldDescriptorType> extends C1928k1<FieldDescriptorType, Object> {
        public a(int i10) {
            super(i10, null);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1928k1
        /* renamed from: p */
        public void mo11860p() {
            if (!m11859o()) {
                for (int i10 = 0; i10 < m11855k(); i10++) {
                    Map.Entry<FieldDescriptorType, Object> entryM11854j = m11854j(i10);
                    if (((C1959v.b) entryM11854j.getKey()).mo12286b0()) {
                        entryM11854j.setValue(Collections.unmodifiableList((List) entryM11854j.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : m11857m()) {
                    if (((C1959v.b) entry.getKey()).mo12286b0()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.mo11860p();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$c */
    public class c extends C1928k1<K, V>.g {
        public c() {
            super(C1928k1.this, null);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.C1928k1.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(C1928k1.this, null);
        }

        public /* synthetic */ c(C1928k1 c1928k1, a aVar) {
            this();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$d */
    public static class d {

        /* renamed from: a */
        public static final Iterator<Object> f9201a = new a();

        /* renamed from: b */
        public static final Iterable<Object> f9202b = new b();

        /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$d$a */
        public class a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$d$b */
        public class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return d.f9201a;
            }
        }

        /* renamed from: b */
        public static <T> Iterable<T> m11866b() {
            return (Iterable<T>) f9202b;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$e */
    public class e implements Map.Entry<K, V>, Comparable<C1928k1<K, V>.e> {

        /* renamed from: a */
        public final K f9203a;

        /* renamed from: b */
        public V f9204b;

        public e(C1928k1 c1928k1, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(C1928k1<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        /* renamed from: b */
        public final boolean m11868b(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        /* renamed from: e */
        public K getKey() {
            return this.f9203a;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return m11868b(this.f9203a, entry.getKey()) && m11868b(this.f9204b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f9204b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k10 = this.f9203a;
            int iHashCode = k10 == null ? 0 : k10.hashCode();
            V v10 = this.f9204b;
            return iHashCode ^ (v10 != null ? v10.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            C1928k1.this.m11851g();
            V v11 = this.f9204b;
            this.f9204b = v10;
            return v11;
        }

        public String toString() {
            return this.f9203a + "=" + this.f9204b;
        }

        public e(K k10, V v10) {
            this.f9203a = k10;
            this.f9204b = v10;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$g */
    public class g extends AbstractSet<Map.Entry<K, V>> {
        public g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            C1928k1.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C1928k1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = C1928k1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(C1928k1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            C1928k1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C1928k1.this.size();
        }

        public /* synthetic */ g(C1928k1 c1928k1, a aVar) {
            this();
        }
    }

    public /* synthetic */ C1928k1(int i10, a aVar) {
        this(i10);
    }

    /* renamed from: q */
    public static <FieldDescriptorType extends C1959v.b<FieldDescriptorType>> C1928k1<FieldDescriptorType, Object> m11849q(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        m11851g();
        if (!this.f9191b.isEmpty()) {
            this.f9191b.clear();
        }
        if (this.f9192c.isEmpty()) {
            return;
        }
        this.f9192c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m11850f(comparable) >= 0 || this.f9192c.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f9194e == null) {
            this.f9194e = new g(this, null);
        }
        return this.f9194e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1928k1)) {
            return super.equals(obj);
        }
        C1928k1 c1928k1 = (C1928k1) obj;
        int size = size();
        if (size != c1928k1.size()) {
            return false;
        }
        int iM11855k = m11855k();
        if (iM11855k != c1928k1.m11855k()) {
            return entrySet().equals(c1928k1.entrySet());
        }
        for (int i10 = 0; i10 < iM11855k; i10++) {
            if (!m11854j(i10).equals(c1928k1.m11854j(i10))) {
                return false;
            }
        }
        if (iM11855k != size) {
            return this.f9192c.equals(c1928k1.f9192c);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0026  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m11850f(K r5) {
        /*
            r4 = this;
            java.util.List<com.google.crypto.tink.shaded.protobuf.k1<K, V>$e> r0 = r4.f9191b
            int r0 = r0.size()
            int r1 = r0 + (-1)
            if (r1 < 0) goto L23
            java.util.List<com.google.crypto.tink.shaded.protobuf.k1<K, V>$e> r2 = r4.f9191b
            java.lang.Object r2 = r2.get(r1)
            com.google.crypto.tink.shaded.protobuf.k1$e r2 = (com.google.crypto.tink.shaded.protobuf.C1928k1.e) r2
            java.lang.Comparable r2 = r2.getKey()
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L20
            int r0 = r0 + 1
        L1e:
            int r4 = -r0
            return r4
        L20:
            if (r2 != 0) goto L23
            return r1
        L23:
            r0 = 0
        L24:
            if (r0 > r1) goto L47
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.util.List<com.google.crypto.tink.shaded.protobuf.k1<K, V>$e> r3 = r4.f9191b
            java.lang.Object r3 = r3.get(r2)
            com.google.crypto.tink.shaded.protobuf.k1$e r3 = (com.google.crypto.tink.shaded.protobuf.C1928k1.e) r3
            java.lang.Comparable r3 = r3.getKey()
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L40
            int r2 = r2 + (-1)
            r1 = r2
            goto L24
        L40:
            if (r3 <= 0) goto L46
            int r2 = r2 + 1
            r0 = r2
            goto L24
        L46:
            return r2
        L47:
            int r0 = r0 + 1
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.C1928k1.m11850f(java.lang.Comparable):int");
    }

    /* renamed from: g */
    public final void m11851g() {
        if (this.f9193d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iM11850f = m11850f(comparable);
        return iM11850f >= 0 ? this.f9191b.get(iM11850f).getValue() : this.f9192c.get(comparable);
    }

    /* renamed from: h */
    public Set<Map.Entry<K, V>> m11852h() {
        if (this.f9196g == null) {
            this.f9196g = new c(this, null);
        }
        return this.f9196g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iM11855k = m11855k();
        int iHashCode = 0;
        for (int i10 = 0; i10 < iM11855k; i10++) {
            iHashCode += this.f9191b.get(i10).hashCode();
        }
        return m11856l() > 0 ? iHashCode + this.f9192c.hashCode() : iHashCode;
    }

    /* renamed from: i */
    public final void m11853i() {
        m11851g();
        if (!this.f9191b.isEmpty() || (this.f9191b instanceof ArrayList)) {
            return;
        }
        this.f9191b = new ArrayList(this.f9190a);
    }

    /* renamed from: j */
    public Map.Entry<K, V> m11854j(int i10) {
        return this.f9191b.get(i10);
    }

    /* renamed from: k */
    public int m11855k() {
        return this.f9191b.size();
    }

    /* renamed from: l */
    public int m11856l() {
        return this.f9192c.size();
    }

    /* renamed from: m */
    public Iterable<Map.Entry<K, V>> m11857m() {
        return this.f9192c.isEmpty() ? d.m11866b() : this.f9192c.entrySet();
    }

    /* renamed from: n */
    public final SortedMap<K, V> m11858n() {
        m11851g();
        if (this.f9192c.isEmpty() && !(this.f9192c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f9192c = treeMap;
            this.f9195f = treeMap.descendingMap();
        }
        return (SortedMap) this.f9192c;
    }

    /* renamed from: o */
    public boolean m11859o() {
        return this.f9193d;
    }

    /* renamed from: p */
    public void mo11860p() {
        if (this.f9193d) {
            return;
        }
        this.f9192c = this.f9192c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f9192c);
        this.f9195f = this.f9195f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f9195f);
        this.f9193d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: r */
    public V put(K k10, V v10) {
        m11851g();
        int iM11850f = m11850f(k10);
        if (iM11850f >= 0) {
            return this.f9191b.get(iM11850f).setValue(v10);
        }
        m11853i();
        int i10 = -(iM11850f + 1);
        if (i10 >= this.f9190a) {
            return m11858n().put(k10, v10);
        }
        int size = this.f9191b.size();
        int i11 = this.f9190a;
        if (size == i11) {
            C1928k1<K, V>.e eVarRemove = this.f9191b.remove(i11 - 1);
            m11858n().put(eVarRemove.getKey(), eVarRemove.getValue());
        }
        this.f9191b.add(i10, new e(k10, v10));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        m11851g();
        Comparable comparable = (Comparable) obj;
        int iM11850f = m11850f(comparable);
        if (iM11850f >= 0) {
            return m11862s(iM11850f);
        }
        if (this.f9192c.isEmpty()) {
            return null;
        }
        return this.f9192c.remove(comparable);
    }

    /* renamed from: s */
    public final V m11862s(int i10) {
        m11851g();
        V value = this.f9191b.remove(i10).getValue();
        if (!this.f9192c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m11858n().entrySet().iterator();
            this.f9191b.add(new e(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f9191b.size() + this.f9192c.size();
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$b */
    public class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        public int f9197a;

        /* renamed from: b */
        public Iterator<Map.Entry<K, V>> f9198b;

        public b() {
            this.f9197a = C1928k1.this.f9191b.size();
        }

        /* renamed from: b */
        public final Iterator<Map.Entry<K, V>> m11863b() {
            if (this.f9198b == null) {
                this.f9198b = C1928k1.this.f9195f.entrySet().iterator();
            }
            return this.f9198b;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            if (m11863b().hasNext()) {
                return m11863b().next();
            }
            List list = C1928k1.this.f9191b;
            int i10 = this.f9197a - 1;
            this.f9197a = i10;
            return (Map.Entry) list.get(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.f9197a;
            return (i10 > 0 && i10 <= C1928k1.this.f9191b.size()) || m11863b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ b(C1928k1 c1928k1, a aVar) {
            this();
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.k1$f */
    public class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        public int f9206a;

        /* renamed from: b */
        public boolean f9207b;

        /* renamed from: c */
        public Iterator<Map.Entry<K, V>> f9208c;

        public f() {
            this.f9206a = -1;
        }

        /* renamed from: b */
        public final Iterator<Map.Entry<K, V>> m11870b() {
            if (this.f9208c == null) {
                this.f9208c = C1928k1.this.f9192c.entrySet().iterator();
            }
            return this.f9208c;
        }

        @Override // java.util.Iterator
        /* renamed from: c */
        public Map.Entry<K, V> next() {
            this.f9207b = true;
            int i10 = this.f9206a + 1;
            this.f9206a = i10;
            return i10 < C1928k1.this.f9191b.size() ? (Map.Entry) C1928k1.this.f9191b.get(this.f9206a) : m11870b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f9206a + 1 >= C1928k1.this.f9191b.size()) {
                return !C1928k1.this.f9192c.isEmpty() && m11870b().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f9207b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f9207b = false;
            C1928k1.this.m11851g();
            if (this.f9206a >= C1928k1.this.f9191b.size()) {
                m11870b().remove();
                return;
            }
            C1928k1 c1928k1 = C1928k1.this;
            int i10 = this.f9206a;
            this.f9206a = i10 - 1;
            c1928k1.m11862s(i10);
        }

        public /* synthetic */ f(C1928k1 c1928k1, a aVar) {
            this();
        }
    }

    public C1928k1(int i10) {
        this.f9190a = i10;
        this.f9191b = Collections.emptyList();
        this.f9192c = Collections.emptyMap();
        this.f9195f = Collections.emptyMap();
    }
}
