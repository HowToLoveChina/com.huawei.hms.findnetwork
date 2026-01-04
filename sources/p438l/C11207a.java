package p438l;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: l.a */
/* loaded from: classes.dex */
public class C11207a<K, V> extends C11213g<K, V> implements Map<K, V> {

    /* renamed from: h */
    public AbstractC11212f<K, V> f52595h;

    /* renamed from: l.a$a */
    public class a extends AbstractC11212f<K, V> {
        public a() {
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: a */
        public void mo67270a() {
            C11207a.this.clear();
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: b */
        public Object mo67271b(int i10, int i11) {
            return C11207a.this.f52644b[(i10 << 1) + i11];
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: c */
        public Map<K, V> mo67272c() {
            return C11207a.this;
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: d */
        public int mo67273d() {
            return C11207a.this.f52645c;
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: e */
        public int mo67274e(Object obj) {
            return C11207a.this.m67328f(obj);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: f */
        public int mo67275f(Object obj) {
            return C11207a.this.m67330h(obj);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: g */
        public void mo67276g(K k10, V v10) {
            C11207a.this.put(k10, v10);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: h */
        public void mo67277h(int i10) {
            C11207a.this.mo67333k(i10);
        }

        @Override // p438l.AbstractC11212f
        /* renamed from: i */
        public V mo67278i(int i10, V v10) {
            return C11207a.this.mo67334l(i10, v10);
        }
    }

    public C11207a() {
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m67268n().m67316l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m67268n().m67317m();
    }

    /* renamed from: n */
    public final AbstractC11212f<K, V> m67268n() {
        if (this.f52595h == null) {
            this.f52595h = new a();
        }
        return this.f52595h;
    }

    /* renamed from: o */
    public boolean m67269o(Collection<?> collection) {
        return AbstractC11212f.m67315p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m67326c(this.f52645c + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m67268n().m67318n();
    }

    public C11207a(C11213g c11213g) {
        super(c11213g);
    }
}
