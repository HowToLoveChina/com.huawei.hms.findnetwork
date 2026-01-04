package p483n3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p468m3.C11397c;

/* renamed from: n3.d */
/* loaded from: classes.dex */
public abstract class AbstractC11613d<K, V> implements InterfaceC11624o<K, V> {

    /* renamed from: a */
    public transient Set<K> f53930a;

    /* renamed from: b */
    public transient Map<K, Collection<V>> f53931b;

    @Override // p483n3.InterfaceC11624o
    /* renamed from: b */
    public Map<K, Collection<V>> mo69358b() {
        Map<K, Collection<V>> map = this.f53931b;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapMo69370c = mo69370c();
        this.f53931b = mapMo69370c;
        return mapMo69370c;
    }

    /* renamed from: c */
    public abstract Map<K, Collection<V>> mo69370c();

    /* renamed from: d */
    public abstract Set<K> mo69371d();

    /* renamed from: e */
    public Set<K> mo69394e() {
        Set<K> set = this.f53930a;
        if (set != null) {
            return set;
        }
        Set<K> setMo69371d = mo69371d();
        this.f53930a = setMo69371d;
        return setMo69371d;
    }

    public boolean equals(Object obj) {
        return C11625p.m69484a(this, obj);
    }

    /* renamed from: f */
    public boolean mo69395f(K k10, Iterable<? extends V> iterable) {
        C11397c.m68310g(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k10).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && C11622m.m69470a(get(k10), it);
    }

    public int hashCode() {
        return mo69358b().hashCode();
    }

    public String toString() {
        return mo69358b().toString();
    }
}
