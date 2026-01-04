package com.huawei.cloud.base.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: com.huawei.cloud.base.util.k */
/* loaded from: classes.dex */
public final class C4643k extends AbstractMap<String, Object> {

    /* renamed from: a */
    public final Object f21302a;

    /* renamed from: b */
    public final C4638g f21303b;

    /* renamed from: com.huawei.cloud.base.util.k$a */
    public final class a implements Map.Entry<String, Object> {

        /* renamed from: a */
        public final C4645m f21304a;

        /* renamed from: b */
        public Object f21305b;

        public a(C4645m c4645m, Object obj) {
            this.f21304a = c4645m;
            this.f21305b = C4627a0.m28391d(obj);
        }

        @Override // java.util.Map.Entry
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getKey() {
            String strM28467e = this.f21304a.m28467e();
            return C4643k.this.f21303b.m28432d() ? strM28467e.toLowerCase(Locale.US) : strM28467e;
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
            return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f21305b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getValue().hashCode() ^ getKey().hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.f21305b;
            this.f21305b = C4627a0.m28391d(obj);
            this.f21304a.m28472m(C4643k.this.f21302a, obj);
            return obj2;
        }
    }

    /* renamed from: com.huawei.cloud.base.util.k$b */
    public final class b implements Iterator<Map.Entry<String, Object>> {

        /* renamed from: a */
        public int f21307a = -1;

        /* renamed from: b */
        public C4645m f21308b;

        /* renamed from: c */
        public Object f21309c;

        /* renamed from: d */
        public boolean f21310d;

        /* renamed from: e */
        public boolean f21311e;

        /* renamed from: f */
        public C4645m f21312f;

        public b() {
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<String, Object> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            C4645m c4645m = this.f21308b;
            this.f21312f = c4645m;
            Object obj = this.f21309c;
            this.f21311e = false;
            this.f21310d = false;
            this.f21308b = null;
            this.f21309c = null;
            return C4643k.this.new a(c4645m, obj);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f21311e) {
                this.f21311e = true;
                this.f21309c = null;
                while (this.f21309c == null) {
                    int i10 = this.f21307a + 1;
                    this.f21307a = i10;
                    if (i10 >= C4643k.this.f21303b.f21280a.size()) {
                        break;
                    }
                    C4638g c4638g = C4643k.this.f21303b;
                    C4645m c4645mM28430b = c4638g.m28430b(c4638g.f21280a.get(this.f21307a));
                    this.f21308b = c4645mM28430b;
                    this.f21309c = c4645mM28430b.m28469g(C4643k.this.f21302a);
                }
            }
            return this.f21309c != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            C4627a0.m28394g((this.f21312f == null || this.f21310d) ? false : true);
            this.f21310d = true;
            this.f21312f.m28472m(C4643k.this.f21302a, null);
        }
    }

    /* renamed from: com.huawei.cloud.base.util.k$c */
    public final class c extends AbstractSet<Map.Entry<String, Object>> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b iterator() {
            return C4643k.this.new b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterator<String> it = C4643k.this.f21303b.f21280a.iterator();
            while (it.hasNext()) {
                C4643k.this.f21303b.m28430b(it.next()).m28472m(C4643k.this.f21302a, null);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            Iterator<String> it = C4643k.this.f21303b.f21280a.iterator();
            while (it.hasNext()) {
                if (C4643k.this.f21303b.m28430b(it.next()).m28469g(C4643k.this.f21302a) != null) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<String> it = C4643k.this.f21303b.f21280a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (C4643k.this.f21303b.m28430b(it.next()).m28469g(C4643k.this.f21302a) != null) {
                    i10++;
                }
            }
            return i10;
        }
    }

    public C4643k(Object obj, boolean z10) {
        this.f21302a = obj;
        this.f21303b = C4638g.m28428g(obj.getClass(), z10);
        C4627a0.m28388a(!r1.m28433e());
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c entrySet() {
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Object put(String str, Object obj) {
        C4645m c4645mM28430b = this.f21303b.m28430b(str);
        C4627a0.m28392e(c4645mM28430b, "no field of key " + str);
        Object objM28469g = c4645mM28430b.m28469g(this.f21302a);
        c4645mM28430b.m28472m(this.f21302a, C4627a0.m28391d(obj));
        return objM28469g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        C4645m c4645mM28430b;
        if ((obj instanceof String) && (c4645mM28430b = this.f21303b.m28430b((String) obj)) != null) {
            return c4645mM28430b.m28469g(this.f21302a);
        }
        return null;
    }
}
