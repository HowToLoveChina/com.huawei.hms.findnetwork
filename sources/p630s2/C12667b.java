package p630s2;

import p438l.C11207a;
import p438l.C11213g;

/* renamed from: s2.b */
/* loaded from: classes.dex */
public final class C12667b<K, V> extends C11207a<K, V> {

    /* renamed from: i */
    public int f58167i;

    @Override // p438l.C11213g, java.util.Map
    public void clear() {
        this.f58167i = 0;
        super.clear();
    }

    @Override // p438l.C11213g, java.util.Map
    public int hashCode() {
        if (this.f58167i == 0) {
            this.f58167i = super.hashCode();
        }
        return this.f58167i;
    }

    @Override // p438l.C11213g
    /* renamed from: j */
    public void mo67332j(C11213g<? extends K, ? extends V> c11213g) {
        this.f58167i = 0;
        super.mo67332j(c11213g);
    }

    @Override // p438l.C11213g
    /* renamed from: k */
    public V mo67333k(int i10) {
        this.f58167i = 0;
        return (V) super.mo67333k(i10);
    }

    @Override // p438l.C11213g
    /* renamed from: l */
    public V mo67334l(int i10, V v10) {
        this.f58167i = 0;
        return (V) super.mo67334l(i10, v10);
    }

    @Override // p438l.C11213g, java.util.Map
    public V put(K k10, V v10) {
        this.f58167i = 0;
        return (V) super.put(k10, v10);
    }
}
