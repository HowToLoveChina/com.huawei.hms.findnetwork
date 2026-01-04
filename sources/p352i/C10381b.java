package p352i;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: i.b */
/* loaded from: classes.dex */
public class C10381b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    public c<K, V> f50157a;

    /* renamed from: b */
    public c<K, V> f50158b;

    /* renamed from: c */
    public WeakHashMap<f<K, V>, Boolean> f50159c = new WeakHashMap<>();

    /* renamed from: d */
    public int f50160d = 0;

    /* renamed from: i.b$a */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // p352i.C10381b.e
        /* renamed from: c */
        public c<K, V> mo63824c(c<K, V> cVar) {
            return cVar.f50164d;
        }

        @Override // p352i.C10381b.e
        /* renamed from: d */
        public c<K, V> mo63825d(c<K, V> cVar) {
            return cVar.f50163c;
        }
    }

    /* renamed from: i.b$b */
    public static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // p352i.C10381b.e
        /* renamed from: c */
        public c<K, V> mo63824c(c<K, V> cVar) {
            return cVar.f50163c;
        }

        @Override // p352i.C10381b.e
        /* renamed from: d */
        public c<K, V> mo63825d(c<K, V> cVar) {
            return cVar.f50164d;
        }
    }

    /* renamed from: i.b$c */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        public final K f50161a;

        /* renamed from: b */
        public final V f50162b;

        /* renamed from: c */
        public c<K, V> f50163c;

        /* renamed from: d */
        public c<K, V> f50164d;

        public c(K k10, V v10) {
            this.f50161a = k10;
            this.f50162b = v10;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f50161a.equals(cVar.f50161a) && this.f50162b.equals(cVar.f50162b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f50161a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f50162b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f50162b.hashCode() ^ this.f50161a.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f50161a + "=" + this.f50162b;
        }
    }

    /* renamed from: i.b$d */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a */
        public c<K, V> f50165a;

        /* renamed from: b */
        public boolean f50166b = true;

        public d() {
        }

        @Override // p352i.C10381b.f
        /* renamed from: b */
        public void mo63826b(c<K, V> cVar) {
            c<K, V> cVar2 = this.f50165a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f50164d;
                this.f50165a = cVar3;
                this.f50166b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f50166b) {
                this.f50166b = false;
                this.f50165a = C10381b.this.f50157a;
            } else {
                c<K, V> cVar = this.f50165a;
                this.f50165a = cVar != null ? cVar.f50163c : null;
            }
            return this.f50165a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f50166b) {
                return C10381b.this.f50157a != null;
            }
            c<K, V> cVar = this.f50165a;
            return (cVar == null || cVar.f50163c == null) ? false : true;
        }
    }

    /* renamed from: i.b$e */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: a */
        public c<K, V> f50168a;

        /* renamed from: b */
        public c<K, V> f50169b;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f50168a = cVar2;
            this.f50169b = cVar;
        }

        @Override // p352i.C10381b.f
        /* renamed from: b */
        public void mo63826b(c<K, V> cVar) {
            if (this.f50168a == cVar && cVar == this.f50169b) {
                this.f50169b = null;
                this.f50168a = null;
            }
            c<K, V> cVar2 = this.f50168a;
            if (cVar2 == cVar) {
                this.f50168a = mo63824c(cVar2);
            }
            if (this.f50169b == cVar) {
                this.f50169b = m63829f();
            }
        }

        /* renamed from: c */
        public abstract c<K, V> mo63824c(c<K, V> cVar);

        /* renamed from: d */
        public abstract c<K, V> mo63825d(c<K, V> cVar);

        @Override // java.util.Iterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f50169b;
            this.f50169b = m63829f();
            return cVar;
        }

        /* renamed from: f */
        public final c<K, V> m63829f() {
            c<K, V> cVar = this.f50169b;
            c<K, V> cVar2 = this.f50168a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo63825d(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f50169b != null;
        }
    }

    /* renamed from: i.b$f */
    public interface f<K, V> {
        /* renamed from: b */
        void mo63826b(c<K, V> cVar);
    }

    /* renamed from: a */
    public Iterator<Map.Entry<K, V>> m63819a() {
        b bVar = new b(this.f50158b, this.f50157a);
        this.f50159c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    /* renamed from: b */
    public Map.Entry<K, V> m63820b() {
        return this.f50157a;
    }

    /* renamed from: c */
    public c<K, V> mo63815c(K k10) {
        c<K, V> cVar = this.f50157a;
        while (cVar != null && !cVar.f50161a.equals(k10)) {
            cVar = cVar.f50163c;
        }
        return cVar;
    }

    /* renamed from: d */
    public C10381b<K, V>.d m63821d() {
        C10381b<K, V>.d dVar = new d();
        this.f50159c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    /* renamed from: e */
    public Map.Entry<K, V> m63822e() {
        return this.f50158b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C10381b)) {
            return false;
        }
        C10381b c10381b = (C10381b) obj;
        if (size() != c10381b.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c10381b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* renamed from: f */
    public c<K, V> m63823f(K k10, V v10) {
        c<K, V> cVar = new c<>(k10, v10);
        this.f50160d++;
        c<K, V> cVar2 = this.f50158b;
        if (cVar2 == null) {
            this.f50157a = cVar;
            this.f50158b = cVar;
            return cVar;
        }
        cVar2.f50163c = cVar;
        cVar.f50164d = cVar2;
        this.f50158b = cVar;
        return cVar;
    }

    /* renamed from: g */
    public V mo63816g(K k10, V v10) {
        c<K, V> cVarMo63815c = mo63815c(k10);
        if (cVarMo63815c != null) {
            return cVarMo63815c.f50162b;
        }
        m63823f(k10, v10);
        return null;
    }

    /* renamed from: h */
    public V mo63817h(K k10) {
        c<K, V> cVarMo63815c = mo63815c(k10);
        if (cVarMo63815c == null) {
            return null;
        }
        this.f50160d--;
        if (!this.f50159c.isEmpty()) {
            Iterator<f<K, V>> it = this.f50159c.keySet().iterator();
            while (it.hasNext()) {
                it.next().mo63826b(cVarMo63815c);
            }
        }
        c<K, V> cVar = cVarMo63815c.f50164d;
        if (cVar != null) {
            cVar.f50163c = cVarMo63815c.f50163c;
        } else {
            this.f50157a = cVarMo63815c.f50163c;
        }
        c<K, V> cVar2 = cVarMo63815c.f50163c;
        if (cVar2 != null) {
            cVar2.f50164d = cVar;
        } else {
            this.f50158b = cVar;
        }
        cVarMo63815c.f50163c = null;
        cVarMo63815c.f50164d = null;
        return cVarMo63815c.f50162b;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f50157a, this.f50158b);
        this.f50159c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f50160d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb2.append(it.next().toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
