package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.l2 */
/* loaded from: classes8.dex */
public class ExecutorC5992l2 implements Executor {

    /* renamed from: i */
    public static final String f27357i = "MessageLoop";

    /* renamed from: j */
    public static final long f27358j = -1;

    /* renamed from: k */
    public static final /* synthetic */ boolean f27359k = true;

    /* renamed from: b */
    public boolean f27361b;

    /* renamed from: c */
    public boolean f27362c;

    /* renamed from: d */
    public InterruptedIOException f27363d;

    /* renamed from: e */
    public RuntimeException f27364e;

    /* renamed from: f */
    public long f27365f = -1;

    /* renamed from: g */
    public boolean f27366g = false;

    /* renamed from: h */
    public long f27367h = 0;

    /* renamed from: a */
    public final BlockingQueue<Runnable> f27360a = new LinkedBlockingQueue();

    /* renamed from: a */
    private Runnable m34648a(boolean z10, long j10) throws InterruptedIOException {
        try {
            Runnable runnableTake = !z10 ? this.f27360a.take() : this.f27360a.poll(j10, TimeUnit.NANOSECONDS);
            if (runnableTake != null) {
                return runnableTake;
            }
            throw new SocketTimeoutException("loop timeout");
        } catch (InterruptedException e10) {
            InterruptedIOException interruptedIOException = new InterruptedIOException();
            interruptedIOException.initCause(e10);
            throw interruptedIOException;
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) throws RejectedExecutionException, InterruptedException {
        if (runnable == null) {
            throw new IllegalArgumentException();
        }
        try {
            this.f27360a.put(runnable);
        } catch (InterruptedException e10) {
            throw new RejectedExecutionException(e10);
        }
    }

    public void loop(int i10) throws IOException {
        Runnable runnableM34648a;
        if (!f27359k && !m34649a()) {
            throw new AssertionError();
        }
        long jNanoTime = System.nanoTime();
        long jConvert = TimeUnit.NANOSECONDS.convert(i10, TimeUnit.MILLISECONDS);
        if (this.f27362c) {
            InterruptedIOException interruptedIOException = this.f27363d;
            if (interruptedIOException == null) {
                throw this.f27364e;
            }
            throw interruptedIOException;
        }
        if (this.f27361b) {
            throw new IllegalStateException("Cannot run loop when it is already running.");
        }
        this.f27361b = true;
        while (this.f27361b) {
            if (i10 == 0) {
                try {
                    runnableM34648a = m34648a(false, 0L);
                } catch (InterruptedIOException e10) {
                    Logger.m32136d(f27357i, e10.getMessage());
                    if (this.f27366g) {
                        long jConvert2 = TimeUnit.NANOSECONDS.convert(this.f27367h - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
                        Logger.m32137d(f27357i, "loop updateWriteTimer : %d", Long.valueOf(jConvert2));
                        if (jConvert2 > 0) {
                            jNanoTime = System.nanoTime();
                            this.f27366g = false;
                            jConvert = jConvert2;
                        }
                    }
                    this.f27361b = false;
                    this.f27362c = true;
                    this.f27363d = e10;
                    throw e10;
                } catch (RuntimeException e11) {
                    this.f27361b = false;
                    this.f27362c = true;
                    this.f27364e = e11;
                    throw e11;
                }
            } else {
                runnableM34648a = m34648a(true, (jConvert - System.nanoTime()) + jNanoTime);
            }
            runnableM34648a.run();
        }
    }

    public void quit() {
        if (!f27359k && !m34649a()) {
            throw new AssertionError();
        }
        this.f27361b = false;
    }

    public void updateLoopTimer(long j10) {
        this.f27366g = true;
        long jCurrentTimeMillis = j10 + System.currentTimeMillis();
        this.f27367h = jCurrentTimeMillis;
        Logger.m32137d(f27357i, "updateWriteTimer : %d", Long.valueOf(jCurrentTimeMillis));
    }

    /* renamed from: a */
    private boolean m34649a() {
        long j10 = this.f27365f;
        if (j10 != -1) {
            return j10 == Thread.currentThread().getId();
        }
        this.f27365f = Thread.currentThread().getId();
        return true;
    }
}
