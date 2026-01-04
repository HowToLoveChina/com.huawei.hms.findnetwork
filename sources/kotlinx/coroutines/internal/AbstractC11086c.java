package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p464m.C11384b;

/* renamed from: kotlinx.coroutines.internal.c */
/* loaded from: classes9.dex */
public abstract class AbstractC11086c<T> extends AbstractC11100q {

    /* renamed from: a */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f52298a = AtomicReferenceFieldUpdater.newUpdater(AbstractC11086c.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = C11084b.f52292a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.AbstractC11100q
    /* renamed from: a */
    public AbstractC11086c<?> mo66743a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.AbstractC11100q
    /* renamed from: c */
    public final Object mo66744c(Object obj) {
        Object objM66746e = this._consensus;
        if (objM66746e == C11084b.f52292a) {
            objM66746e = m66746e(mo7728g(obj));
        }
        mo66745d(obj, objM66746e);
        return objM66746e;
    }

    /* renamed from: d */
    public abstract void mo66745d(T t10, Object obj);

    /* renamed from: e */
    public final Object m66746e(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = C11084b.f52292a;
        return obj2 != obj3 ? obj2 : C11384b.m68273a(f52298a, this, obj3, obj) ? obj : this._consensus;
    }

    /* renamed from: f */
    public long m66747f() {
        return 0L;
    }

    /* renamed from: g */
    public abstract Object mo7728g(T t10);
}
