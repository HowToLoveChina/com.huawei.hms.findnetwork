package p352i;

import java.util.HashMap;
import java.util.Map;
import p352i.C10381b;

/* renamed from: i.a */
/* loaded from: classes.dex */
public class C10380a<K, V> extends C10381b<K, V> {

    /* renamed from: e */
    public HashMap<K, C10381b.c<K, V>> f50156e = new HashMap<>();

    @Override // p352i.C10381b
    /* renamed from: c */
    public C10381b.c<K, V> mo63815c(K k10) {
        return this.f50156e.get(k10);
    }

    public boolean contains(K k10) {
        return this.f50156e.containsKey(k10);
    }

    @Override // p352i.C10381b
    /* renamed from: g */
    public V mo63816g(K k10, V v10) {
        C10381b.c<K, V> cVarMo63815c = mo63815c(k10);
        if (cVarMo63815c != null) {
            return cVarMo63815c.f50162b;
        }
        this.f50156e.put(k10, m63823f(k10, v10));
        return null;
    }

    @Override // p352i.C10381b
    /* renamed from: h */
    public V mo63817h(K k10) {
        V v10 = (V) super.mo63817h(k10);
        this.f50156e.remove(k10);
        return v10;
    }

    /* renamed from: i */
    public Map.Entry<K, V> m63818i(K k10) {
        if (contains(k10)) {
            return this.f50156e.get(k10).f50164d;
        }
        return null;
    }
}
