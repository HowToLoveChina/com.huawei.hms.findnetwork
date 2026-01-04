package p483n3;

import java.io.Serializable;

/* renamed from: n3.l */
/* loaded from: classes.dex */
public class C11621l<K, V> extends AbstractC11612c<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final K f53956a;

    /* renamed from: b */
    public final V f53957b;

    public C11621l(K k10, V v10) {
        this.f53956a = k10;
        this.f53957b = v10;
    }

    @Override // p483n3.AbstractC11612c, java.util.Map.Entry
    public final K getKey() {
        return this.f53956a;
    }

    @Override // p483n3.AbstractC11612c, java.util.Map.Entry
    public final V getValue() {
        return this.f53957b;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v10) {
        throw new UnsupportedOperationException();
    }
}
