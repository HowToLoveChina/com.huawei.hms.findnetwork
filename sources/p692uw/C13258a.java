package p692uw;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: uw.a */
/* loaded from: classes9.dex */
public final class C13258a<T> implements Iterator<T> {

    /* renamed from: a */
    public final T[] f59957a;

    /* renamed from: b */
    public int f59958b;

    public C13258a(T[] tArr) {
        C13267j.m79677e(tArr, "array");
        this.f59957a = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f59958b < this.f59957a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f59957a;
            int i10 = this.f59958b;
            this.f59958b = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f59958b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
