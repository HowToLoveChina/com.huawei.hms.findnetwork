package mt;

import java.util.Objects;

/* renamed from: mt.h */
/* loaded from: classes5.dex */
public class C11521h<K, V> {

    /* renamed from: a */
    public final K f53459a;

    /* renamed from: b */
    public final V f53460b;

    public C11521h(K k10, V v10) {
        this.f53459a = k10;
        this.f53460b = v10;
    }

    /* renamed from: a */
    public K m68763a() {
        return this.f53459a;
    }

    /* renamed from: b */
    public V m68764b() {
        return this.f53460b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11521h)) {
            return false;
        }
        C11521h c11521h = (C11521h) obj;
        return Objects.equals(this.f53459a, c11521h.f53459a) && Objects.equals(this.f53460b, c11521h.f53460b);
    }

    public int hashCode() {
        return Objects.hash(this.f53459a, this.f53460b);
    }

    public String toString() {
        return this.f53459a + "=" + this.f53460b;
    }
}
