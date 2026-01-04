package p483n3;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: n3.a */
/* loaded from: classes.dex */
public abstract class AbstractC11610a<K, V> extends AbstractC11611b<K, V> implements InterfaceC11624o {
    private static final long serialVersionUID = 6588350623831699109L;

    public AbstractC11610a(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // p483n3.AbstractC11613d, p483n3.InterfaceC11624o
    /* renamed from: b */
    public Map<K, Collection<V>> mo69358b() {
        return super.mo69358b();
    }

    @Override // p483n3.AbstractC11613d
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // p483n3.AbstractC11611b
    /* renamed from: s */
    public boolean mo69359s(K k10, V v10) {
        return super.mo69359s(k10, v10);
    }

    @Override // p483n3.AbstractC11611b
    /* renamed from: v */
    public Collection<V> mo69360v(K k10, Collection<V> collection) {
        return m69377w(k10, (List) collection, null);
    }

    @Override // p483n3.AbstractC11611b, p483n3.InterfaceC11624o
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public List<V> get(K k10) {
        return (List) super.get(k10);
    }
}
