package mp;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: mp.a */
/* loaded from: classes8.dex */
public class C11503a<K1, K2, V> {

    /* renamed from: a */
    public final ConcurrentHashMap<C11503a<K1, K2, V>.a, V> f53403a;

    /* renamed from: mp.a$a */
    public class a {

        /* renamed from: a */
        public K1 f53404a;

        /* renamed from: b */
        public K2 f53405b;

        public a(K1 k12, K2 k22) {
            this.f53404a = k12;
            this.f53405b = k22;
        }

        /* renamed from: a */
        public K1 m68674a() {
            return this.f53404a;
        }

        /* renamed from: b */
        public K2 m68675b() {
            return this.f53405b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.f53404a, aVar.f53404a) && Objects.equals(this.f53405b, aVar.f53405b);
        }

        public int hashCode() {
            return Objects.hash(this.f53404a, this.f53405b);
        }
    }

    public C11503a() {
        this.f53403a = new ConcurrentHashMap<>();
    }

    /* renamed from: a */
    public void m68668a() {
        this.f53403a.clear();
    }

    /* renamed from: b */
    public boolean m68669b(K1 k12, K2 k22) {
        return this.f53403a.containsKey(new a(k12, k22));
    }

    /* renamed from: c */
    public Set<Map.Entry<C11503a<K1, K2, V>.a, V>> m68670c() {
        return this.f53403a.entrySet();
    }

    /* renamed from: d */
    public V m68671d(K1 k12, K2 k22) {
        return this.f53403a.get(new a(k12, k22));
    }

    /* renamed from: e */
    public void m68672e(K1 k12, K2 k22, V v10) {
        this.f53403a.put(new a(k12, k22), v10);
    }

    /* renamed from: f */
    public V m68673f(K1 k12, K2 k22) {
        return this.f53403a.remove(new a(k12, k22));
    }

    public C11503a(C11503a<K1, K2, V> c11503a) {
        this.f53403a = new ConcurrentHashMap<>(c11503a.f53403a);
    }
}
