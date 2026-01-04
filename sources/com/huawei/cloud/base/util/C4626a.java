package com.huawei.cloud.base.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: com.huawei.cloud.base.util.a */
/* loaded from: classes.dex */
public class C4626a<K, V> extends AbstractMap<K, V> implements Cloneable {

    /* renamed from: a */
    public int f21251a;

    /* renamed from: b */
    public Object[] f21252b;

    /* renamed from: com.huawei.cloud.base.util.a$a */
    public final class a implements Map.Entry<K, V> {

        /* renamed from: a */
        public int f21253a;

        public a(int i10) {
            this.f21253a = i10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return C4658z.m28496a(getKey(), entry.getKey()) && C4658z.m28496a(getValue(), entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) C4626a.this.m28378j(this.f21253a);
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) C4626a.this.m28379k(this.f21253a);
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            Object value = getValue();
            return (key != null ? key.hashCode() : 0) ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            return (V) C4626a.this.m28382n(this.f21253a, v10);
        }
    }

    /* renamed from: com.huawei.cloud.base.util.a$b */
    public final class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        public boolean f21255a;

        /* renamed from: b */
        public int f21256b;

        public b() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            int i10 = this.f21256b;
            C4626a c4626a = C4626a.this;
            if (i10 == c4626a.f21251a) {
                throw new NoSuchElementException();
            }
            this.f21256b = i10 + 1;
            return new a(i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21256b < C4626a.this.f21251a;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i10 = this.f21256b - 1;
            if (this.f21255a || i10 < 0) {
                throw new IllegalArgumentException();
            }
            C4626a.this.m28380l(i10);
            this.f21255a = true;
        }
    }

    /* renamed from: com.huawei.cloud.base.util.a$c */
    public final class c extends AbstractSet<Map.Entry<K, V>> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C4626a.this.f21251a;
        }
    }

    /* renamed from: d */
    public static <K, V> C4626a<K, V> m28373d() {
        return new C4626a<>();
    }

    @Override // java.util.AbstractMap
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C4626a<K, V> clone() {
        try {
            C4626a<K, V> c4626a = (C4626a) super.clone();
            Object[] objArr = this.f21252b;
            if (objArr != null) {
                int length = objArr.length;
                Object[] objArr2 = new Object[length];
                c4626a.f21252b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
            }
            return c4626a;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f21251a = 0;
        this.f21252b = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return -2 != m28376g(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        int i10 = this.f21251a << 1;
        Object[] objArr = this.f21252b;
        for (int i11 = 1; i11 < i10; i11 += 2) {
            Object obj2 = objArr[i11];
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
            } else {
                if (obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new c();
    }

    /* renamed from: f */
    public final void m28375f(int i10) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] objArr = this.f21252b;
        int i11 = i10 << 1;
        int length = objArr == null ? 0 : objArr.length;
        if (i11 > length) {
            int i12 = (length / 2) * 3;
            int i13 = i12 + 1;
            if (i13 % 2 != 0) {
                i13 = i12 + 2;
            }
            if (i13 >= i11) {
                i11 = i13;
            }
            m28385q(i11);
        }
    }

    /* renamed from: g */
    public final int m28376g(Object obj) {
        int i10 = this.f21251a << 1;
        Object[] objArr = this.f21252b;
        for (int i11 = 0; i11 < i10; i11 += 2) {
            Object obj2 = objArr[i11];
            if (obj == null) {
                if (obj2 == null) {
                    return i11;
                }
            } else {
                if (obj.equals(obj2)) {
                    return i11;
                }
            }
        }
        return -2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        return m28386r(m28376g(obj) + 1);
    }

    /* renamed from: i */
    public final int m28377i(K k10) {
        return m28376g(k10) >> 1;
    }

    /* renamed from: j */
    public final K m28378j(int i10) {
        if (i10 < 0 || i10 >= this.f21251a) {
            return null;
        }
        return (K) this.f21252b[i10 << 1];
    }

    /* renamed from: k */
    public final V m28379k(int i10) {
        if (i10 < 0 || i10 >= this.f21251a) {
            return null;
        }
        return m28386r((i10 << 1) + 1);
    }

    /* renamed from: l */
    public final V m28380l(int i10) {
        return m28381m(i10 << 1);
    }

    /* renamed from: m */
    public final V m28381m(int i10) {
        int i11 = this.f21251a << 1;
        if (i10 < 0 || i10 >= i11) {
            return null;
        }
        V vM28386r = m28386r(i10 + 1);
        Object[] objArr = this.f21252b;
        int i12 = (i11 - i10) - 2;
        if (i12 != 0) {
            System.arraycopy(objArr, i10 + 2, objArr, i10, i12);
        }
        this.f21251a--;
        m28384p(i11 - 2, null, null);
        return vM28386r;
    }

    /* renamed from: n */
    public final V m28382n(int i10, V v10) {
        int i11 = this.f21251a;
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException();
        }
        int i12 = (i10 << 1) + 1;
        V vM28386r = m28386r(i12);
        this.f21252b[i12] = v10;
        return vM28386r;
    }

    /* renamed from: o */
    public final V m28383o(int i10, K k10, V v10) {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i11 = i10 + 1;
        m28375f(i11);
        int i12 = i10 << 1;
        V vM28386r = m28386r(i12 + 1);
        m28384p(i12, k10, v10);
        if (i11 > this.f21251a) {
            this.f21251a = i11;
        }
        return vM28386r;
    }

    /* renamed from: p */
    public final void m28384p(int i10, K k10, V v10) {
        Object[] objArr = this.f21252b;
        objArr[i10] = k10;
        objArr[i10 + 1] = v10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V put(K k10, V v10) {
        int iM28377i = m28377i(k10);
        if (iM28377i == -1) {
            iM28377i = this.f21251a;
        }
        return m28383o(iM28377i, k10, v10);
    }

    /* renamed from: q */
    public final void m28385q(int i10) {
        if (i10 == 0) {
            this.f21252b = null;
            return;
        }
        int i11 = this.f21251a;
        Object[] objArr = this.f21252b;
        if (i11 == 0 || i10 != objArr.length) {
            Object[] objArr2 = new Object[i10];
            this.f21252b = objArr2;
            if (i11 != 0) {
                System.arraycopy(objArr, 0, objArr2, 0, i11 << 1);
            }
        }
    }

    /* renamed from: r */
    public final V m28386r(int i10) {
        if (i10 < 0) {
            return null;
        }
        return (V) this.f21252b[i10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        return m28381m(m28376g(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f21251a;
    }
}
