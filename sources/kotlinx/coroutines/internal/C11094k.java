package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p464m.C11384b;

/* renamed from: kotlinx.coroutines.internal.k */
/* loaded from: classes9.dex */
public class C11094k<E> {

    /* renamed from: a */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52318a = AtomicReferenceFieldUpdater.newUpdater(C11094k.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public C11094k(boolean z10) {
        this._cur = new C11095l(8, z10);
    }

    /* renamed from: a */
    public final boolean m66774a(E e10) {
        while (true) {
            C11095l c11095l = (C11095l) this._cur;
            int iM66778a = c11095l.m66778a(e10);
            if (iM66778a == 0) {
                return true;
            }
            if (iM66778a == 1) {
                C11384b.m68273a(f52318a, this, c11095l, c11095l.m66786i());
            } else if (iM66778a == 2) {
                return false;
            }
        }
    }

    /* renamed from: b */
    public final void m66775b() {
        while (true) {
            C11095l c11095l = (C11095l) this._cur;
            if (c11095l.m66781d()) {
                return;
            } else {
                C11384b.m68273a(f52318a, this, c11095l, c11095l.m66786i());
            }
        }
    }

    /* renamed from: c */
    public final int m66776c() {
        return ((C11095l) this._cur).m66783f();
    }

    /* renamed from: d */
    public final E m66777d() {
        while (true) {
            C11095l c11095l = (C11095l) this._cur;
            E e10 = (E) c11095l.m66787j();
            if (e10 != C11095l.f52322h) {
                return e10;
            }
            C11384b.m68273a(f52318a, this, c11095l, c11095l.m66786i());
        }
    }
}
