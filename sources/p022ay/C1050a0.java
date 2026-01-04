package p022ay;

import com.huawei.openalliance.p169ad.constant.MapKeyNames;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import p692uw.C13264g;
import p692uw.C13266i;
import p692uw.C13267j;
import tw.InterfaceC13075a;

/* renamed from: ay.a0 */
/* loaded from: classes9.dex */
public class C1050a0 {
    public static final b Companion = new b(null);
    public static final C1050a0 NONE = new a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* renamed from: ay.a0$a */
    public static final class a extends C1050a0 {
        @Override // p022ay.C1050a0
        public C1050a0 deadlineNanoTime(long j10) {
            return this;
        }

        @Override // p022ay.C1050a0
        public void throwIfReached() {
        }

        @Override // p022ay.C1050a0
        public C1050a0 timeout(long j10, TimeUnit timeUnit) {
            C13267j.m79677e(timeUnit, "unit");
            return this;
        }
    }

    /* renamed from: ay.a0$b */
    public static final class b {
        public /* synthetic */ b(C13264g c13264g) {
            this();
        }

        /* renamed from: a */
        public final long m6292a(long j10, long j11) {
            return (j10 != 0 && (j11 == 0 || j10 < j11)) ? j10 : j11;
        }

        public b() {
        }
    }

    public final void awaitSignal(Condition condition) throws InterruptedException, InterruptedIOException {
        C13267j.m79677e(condition, "condition");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                condition.await();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                condition.await(jTimeoutNanos, TimeUnit.NANOSECONDS);
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public C1050a0 clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public C1050a0 clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final C1050a0 deadline(long j10, TimeUnit timeUnit) {
        C13267j.m79677e(timeUnit, "unit");
        if (j10 > 0) {
            return deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(j10));
        }
        throw new IllegalArgumentException(("duration <= 0: " + j10).toString());
    }

    public C1050a0 deadlineNanoTime(long j10) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j10;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(C1050a0 c1050a0, InterfaceC13075a<? extends T> interfaceC13075a) {
        C13267j.m79677e(c1050a0, "other");
        C13267j.m79677e(interfaceC13075a, "block");
        long jTimeoutNanos = timeoutNanos();
        long jM6292a = Companion.m6292a(c1050a0.timeoutNanos(), timeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(jM6292a, timeUnit);
        if (!hasDeadline()) {
            if (c1050a0.hasDeadline()) {
                deadlineNanoTime(c1050a0.deadlineNanoTime());
            }
            try {
                T tMo5005b = interfaceC13075a.mo5005b();
                C13266i.m79672b(1);
                timeout(jTimeoutNanos, timeUnit);
                if (c1050a0.hasDeadline()) {
                    clearDeadline();
                }
                C13266i.m79671a(1);
                return tMo5005b;
            } catch (Throwable th2) {
                C13266i.m79672b(1);
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (c1050a0.hasDeadline()) {
                    clearDeadline();
                }
                C13266i.m79671a(1);
                throw th2;
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (c1050a0.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), c1050a0.deadlineNanoTime()));
        }
        try {
            T tMo5005b2 = interfaceC13075a.mo5005b();
            C13266i.m79672b(1);
            timeout(jTimeoutNanos, timeUnit);
            if (c1050a0.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            C13266i.m79671a(1);
            return tMo5005b2;
        } catch (Throwable th3) {
            C13266i.m79672b(1);
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (c1050a0.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            C13266i.m79671a(1);
            throw th3;
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public C1050a0 timeout(long j10, TimeUnit timeUnit) {
        C13267j.m79677e(timeUnit, "unit");
        if (j10 >= 0) {
            this.timeoutNanos = timeUnit.toNanos(j10);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j10).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedException, InterruptedIOException {
        C13267j.m79677e(obj, MapKeyNames.THIRD_MONITORS);
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j10 = jTimeoutNanos / 1000000;
                obj.wait(j10, (int) (jTimeoutNanos - (1000000 * j10)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }
}
