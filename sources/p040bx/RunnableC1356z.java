package p040bx;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import p040bx.AbstractC1324k0;
import p790xw.C13885n;

/* renamed from: bx.z */
/* loaded from: classes9.dex */
public final class RunnableC1356z extends AbstractC1324k0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: g */
    public static final RunnableC1356z f5850g;

    /* renamed from: h */
    public static final long f5851h;

    static {
        Long l10;
        RunnableC1356z runnableC1356z = new RunnableC1356z();
        f5850g = runnableC1356z;
        AbstractC1321j0.m7778B(runnableC1356z, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f5851h = timeUnit.toNanos(l10.longValue());
    }

    @Override // p040bx.AbstractC1327l0
    /* renamed from: F */
    public Thread mo7739F() {
        Thread thread = _thread;
        return thread == null ? m7849q0() : thread;
    }

    @Override // p040bx.AbstractC1327l0
    /* renamed from: G */
    public void mo7812G(long j10, AbstractC1324k0.a aVar) {
        m7853u0();
    }

    @Override // p040bx.AbstractC1324k0
    /* renamed from: X */
    public void mo7792X(Runnable runnable) {
        if (m7850r0()) {
            m7853u0();
        }
        super.mo7792X(runnable);
    }

    /* renamed from: o0 */
    public final synchronized void m7848o0() {
        if (m7851s0()) {
            debugStatus = 3;
            m7798g0();
            notifyAll();
        }
    }

    /* renamed from: q0 */
    public final synchronized Thread m7849q0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* renamed from: r0 */
    public final boolean m7850r0() {
        return debugStatus == 4;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zM7795a0;
        C1319i1.f5807a.m7777c(this);
        C1299c.m7736a();
        try {
            if (!m7852t0()) {
                if (zM7795a0) {
                    return;
                } else {
                    return;
                }
            }
            long j10 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jM7796b0 = m7796b0();
                if (jM7796b0 == Long.MAX_VALUE) {
                    C1299c.m7736a();
                    long jNanoTime = System.nanoTime();
                    if (j10 == Long.MAX_VALUE) {
                        j10 = f5851h + jNanoTime;
                    }
                    long j11 = j10 - jNanoTime;
                    if (j11 <= 0) {
                        _thread = null;
                        m7848o0();
                        C1299c.m7736a();
                        if (m7795a0()) {
                            return;
                        }
                        mo7739F();
                        return;
                    }
                    jM7796b0 = C13885n.m83239d(jM7796b0, j11);
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (jM7796b0 > 0) {
                    if (m7851s0()) {
                        _thread = null;
                        m7848o0();
                        C1299c.m7736a();
                        if (m7795a0()) {
                            return;
                        }
                        mo7739F();
                        return;
                    }
                    C1299c.m7736a();
                    LockSupport.parkNanos(this, jM7796b0);
                }
            }
        } finally {
            _thread = null;
            m7848o0();
            C1299c.m7736a();
            if (!m7795a0()) {
                mo7739F();
            }
        }
    }

    /* renamed from: s0 */
    public final boolean m7851s0() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    @Override // p040bx.AbstractC1324k0, p040bx.AbstractC1321j0
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    /* renamed from: t0 */
    public final synchronized boolean m7852t0() {
        if (m7851s0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    /* renamed from: u0 */
    public final void m7853u0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }
}
