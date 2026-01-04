package kw;

import java.util.Iterator;

/* renamed from: kw.z */
/* loaded from: classes9.dex */
public abstract class AbstractC11199z implements Iterator<Integer> {
    /* renamed from: b */
    public abstract int mo67208b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(mo67208b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
