package kw;

import java.util.Iterator;

/* renamed from: kw.a0 */
/* loaded from: classes9.dex */
public abstract class AbstractC11164a0 implements Iterator<Long> {
    /* renamed from: b */
    public abstract long mo67107b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(mo67107b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
