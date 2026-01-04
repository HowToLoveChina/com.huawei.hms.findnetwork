package p483n3;

import java.util.Iterator;
import p468m3.C11397c;

/* renamed from: n3.v */
/* loaded from: classes.dex */
public abstract class AbstractC11631v<F, T> implements Iterator<T> {

    /* renamed from: a */
    public final Iterator<? extends F> f53962a;

    public AbstractC11631v(Iterator<? extends F> it) {
        this.f53962a = (Iterator) C11397c.m68310g(it);
    }

    /* renamed from: b */
    public abstract T mo69479b(F f10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f53962a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return mo69479b(this.f53962a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f53962a.remove();
    }
}
