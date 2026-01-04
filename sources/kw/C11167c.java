package kw;

import com.huawei.hms.network.embedded.C6055q0;
import java.util.Collection;
import java.util.Iterator;
import p692uw.C13259b;
import p692uw.C13263f;
import p692uw.C13267j;

/* renamed from: kw.c */
/* loaded from: classes9.dex */
public final class C11167c<T> implements Collection<T> {

    /* renamed from: a */
    public final T[] f52513a;

    /* renamed from: b */
    public final boolean f52514b;

    public C11167c(T[] tArr, boolean z10) {
        C13267j.m79677e(tArr, C6055q0.f27803j);
        this.f52513a = tArr;
        this.f52514b = z10;
    }

    /* renamed from: a */
    public int m67120a() {
        return this.f52513a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return C11177h.m67148h(this.f52513a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        C13267j.m79677e(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f52513a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return C13259b.m79660a(this.f52513a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return m67120a();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        C13267j.m79677e(tArr, "array");
        return (T[]) C13263f.m79670b(this, tArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return C11185l.m67171a(this.f52513a, this.f52514b);
    }
}
