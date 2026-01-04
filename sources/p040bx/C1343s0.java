package p040bx;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p408jw.C10951q;
import tw.InterfaceC13086l;

/* renamed from: bx.s0 */
/* loaded from: classes9.dex */
public final class C1343s0 extends AbstractC1351w0 {

    /* renamed from: f */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f5839f = AtomicIntegerFieldUpdater.newUpdater(C1343s0.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e */
    public final InterfaceC13086l<Throwable, C10951q> f5840e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1343s0(InterfaceC13086l<? super Throwable, C10951q> interfaceC13086l) {
        this.f5840e = interfaceC13086l;
    }

    @Override // tw.InterfaceC13086l
    /* renamed from: c */
    public /* bridge */ /* synthetic */ C10951q mo5000c(Throwable th2) {
        mo7714q(th2);
        return C10951q.f51861a;
    }

    @Override // p040bx.AbstractC1336p
    /* renamed from: q */
    public void mo7714q(Throwable th2) {
        if (f5839f.compareAndSet(this, 0, 1)) {
            this.f5840e.mo5000c(th2);
        }
    }
}
