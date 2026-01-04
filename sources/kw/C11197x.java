package kw;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import p692uw.C13267j;

/* renamed from: kw.x */
/* loaded from: classes9.dex */
public final class C11197x implements Map, Serializable {

    /* renamed from: a */
    public static final C11197x f52517a = new C11197x();
    private static final long serialVersionUID = 8246714829545688274L;

    private final Object readResolve() {
        return f52517a;
    }

    /* renamed from: b */
    public boolean m67199b(Void r12) {
        C13267j.m79677e(r12, "value");
        return false;
    }

    @Override // java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Void get(Object obj) {
        return null;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return m67199b((Void) obj);
        }
        return false;
    }

    /* renamed from: d */
    public Set<Map.Entry> m67201d() {
        return C11198y.f52518a;
    }

    /* renamed from: e */
    public Set<Object> m67202e() {
        return C11198y.f52518a;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry> entrySet() {
        return m67201d();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    /* renamed from: f */
    public int m67203f() {
        return 0;
    }

    /* renamed from: g */
    public Collection m67204g() {
        return C11196w.f52516a;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Void remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Object> keySet() {
        return m67202e();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return m67203f();
    }

    public String toString() {
        return "{}";
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return m67204g();
    }
}
