package kotlinx.coroutines.internal;

import mw.InterfaceC11539f;
import p040bx.AbstractC1344t;
import p040bx.C1294a0;
import p040bx.InterfaceC1297b0;

/* renamed from: kotlinx.coroutines.internal.f */
/* loaded from: classes9.dex */
public final class RunnableC11089f extends AbstractC1344t implements Runnable, InterfaceC1297b0 {

    /* renamed from: b */
    public final AbstractC1344t f52306b;

    /* renamed from: c */
    public final int f52307c;

    /* renamed from: d */
    public final /* synthetic */ InterfaceC1297b0 f52308d;

    /* renamed from: e */
    public final C11094k<Runnable> f52309e;

    /* renamed from: f */
    public final Object f52310f;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public RunnableC11089f(AbstractC1344t abstractC1344t, int i10) {
        this.f52306b = abstractC1344t;
        this.f52307c = i10;
        InterfaceC1297b0 interfaceC1297b0 = abstractC1344t instanceof InterfaceC1297b0 ? (InterfaceC1297b0) abstractC1344t : null;
        this.f52308d = interfaceC1297b0 == null ? C1294a0.m7663a() : interfaceC1297b0;
        this.f52309e = new C11094k<>(false);
        this.f52310f = new Object();
    }

    @Override // p040bx.AbstractC1344t
    /* renamed from: c */
    public void mo7787c(InterfaceC11539f interfaceC11539f, Runnable runnable) {
        if (!m66755k(runnable) && m66756z()) {
            this.f52306b.mo7787c(this, this);
        }
    }

    /* renamed from: k */
    public final boolean m66755k(Runnable runnable) {
        this.f52309e.m66774a(runnable);
        return this.runningWorkers >= this.f52307c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r1 = r4.f52310f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r4.f52309e.m66776c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = p408jw.C10951q.f51861a;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            kotlinx.coroutines.internal.k<java.lang.Runnable> r2 = r4.f52309e
            java.lang.Object r2 = r2.m66777d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            mw.g r3 = mw.C11540g.f53497a
            p040bx.C1350w.m7841a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            bx.t r2 = r4.f52306b
            boolean r2 = r2.mo7788d(r4)
            if (r2 == 0) goto L2
            bx.t r0 = r4.f52306b
            r0.mo7787c(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.f52310f
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.k<java.lang.Runnable> r2 = r4.f52309e     // Catch: java.lang.Throwable -> L47
            int r2 = r2.m66776c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            jw.q r2 = p408jw.C10951q.f51861a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.RunnableC11089f.run():void");
    }

    /* renamed from: z */
    public final boolean m66756z() {
        synchronized (this.f52310f) {
            if (this.runningWorkers >= this.f52307c) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }
}
