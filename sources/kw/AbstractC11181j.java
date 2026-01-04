package kw;

import java.util.Iterator;

/* renamed from: kw.j */
/* loaded from: classes9.dex */
public abstract class AbstractC11181j implements Iterator<Character> {
    /* renamed from: b */
    public abstract char mo67158b();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(mo67158b());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
