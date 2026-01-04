package kw;

import com.huawei.hms.network.embedded.C6010m7;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import p692uw.C13263f;
import p692uw.C13267j;

/* renamed from: kw.y */
/* loaded from: classes9.dex */
public final class C11198y implements Set, Serializable {

    /* renamed from: a */
    public static final C11198y f52518a = new C11198y();
    private static final long serialVersionUID = 3406603774387020532L;

    private final Object readResolve() {
        return f52518a;
    }

    @Override // java.util.Set, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: b */
    public boolean m67206b(Void r12) {
        C13267j.m79677e(r12, "element");
        return false;
    }

    /* renamed from: c */
    public int m67207c() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return m67206b((Void) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        C13267j.m79677e(collection, "elements");
        return collection.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return C11195v.f52515a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return m67207c();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return C13263f.m79669a(this);
    }

    public String toString() {
        return C6010m7.f27500n;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C13267j.m79677e(tArr, "array");
        return (T[]) C13263f.m79670b(this, tArr);
    }
}
