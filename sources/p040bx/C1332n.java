package p040bx;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p692uw.C13264g;

/* renamed from: bx.n */
/* loaded from: classes9.dex */
public class C1332n {

    /* renamed from: b */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5829b = AtomicIntegerFieldUpdater.newUpdater(C1332n.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a */
    public final Throwable f5830a;

    public /* synthetic */ C1332n(Throwable th2, boolean z10, int i10, C13264g c13264g) {
        this(th2, (i10 & 2) != 0 ? false : z10);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    /* renamed from: a */
    public final boolean m7819a() {
        return this._handled;
    }

    /* renamed from: b */
    public final boolean m7820b() {
        return f5829b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return C1354y.m7844a(this) + '[' + this.f5830a + ']';
    }

    public C1332n(Throwable th2, boolean z10) {
        this.f5830a = th2;
        this._handled = z10 ? 1 : 0;
    }
}
