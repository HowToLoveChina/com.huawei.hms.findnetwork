package p022ay;

import com.huawei.hms.network.embedded.C5929g4;
import com.huawei.hms.network.embedded.C6144wb;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import p408jw.C10951q;
import p692uw.C13264g;
import p692uw.C13266i;
import p692uw.C13267j;
import tw.InterfaceC13075a;

/* renamed from: ay.c */
/* loaded from: classes9.dex */
public class C1053c extends C1050a0 {
    public static final a Companion = new a(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final Condition condition;
    private static C1053c head;
    private static final ReentrantLock lock;
    private boolean inQueue;
    private C1053c next;
    private long timeoutAt;

    /* renamed from: ay.c$a */
    public static final class a {
        public /* synthetic */ a(C13264g c13264g) {
            this();
        }

        /* renamed from: c */
        public final C1053c m6304c() throws InterruptedException {
            C1053c c1053c = C1053c.head;
            C13267j.m79674b(c1053c);
            C1053c c1053c2 = c1053c.next;
            if (c1053c2 == null) {
                long jNanoTime = System.nanoTime();
                m6306e().await(C1053c.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                C1053c c1053c3 = C1053c.head;
                C13267j.m79674b(c1053c3);
                if (c1053c3.next != null || System.nanoTime() - jNanoTime < C1053c.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return C1053c.head;
            }
            long jRemainingNanos = c1053c2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                m6306e().await(jRemainingNanos, TimeUnit.NANOSECONDS);
                return null;
            }
            C1053c c1053c4 = C1053c.head;
            C13267j.m79674b(c1053c4);
            c1053c4.next = c1053c2.next;
            c1053c2.next = null;
            return c1053c2;
        }

        /* renamed from: d */
        public final boolean m6305d(C1053c c1053c) {
            ReentrantLock reentrantLockM6307f = C1053c.Companion.m6307f();
            reentrantLockM6307f.lock();
            try {
                if (!c1053c.inQueue) {
                    return false;
                }
                c1053c.inQueue = false;
                for (C1053c c1053c2 = C1053c.head; c1053c2 != null; c1053c2 = c1053c2.next) {
                    if (c1053c2.next == c1053c) {
                        c1053c2.next = c1053c.next;
                        c1053c.next = null;
                        return false;
                    }
                }
                reentrantLockM6307f.unlock();
                return true;
            } finally {
                reentrantLockM6307f.unlock();
            }
        }

        /* renamed from: e */
        public final Condition m6306e() {
            return C1053c.condition;
        }

        /* renamed from: f */
        public final ReentrantLock m6307f() {
            return C1053c.lock;
        }

        /* renamed from: g */
        public final void m6308g(C1053c c1053c, long j10, boolean z10) {
            ReentrantLock reentrantLockM6307f = C1053c.Companion.m6307f();
            reentrantLockM6307f.lock();
            try {
                if (!(!c1053c.inQueue)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                c1053c.inQueue = true;
                if (C1053c.head == null) {
                    C1053c.head = new C1053c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j10 != 0 && z10) {
                    c1053c.timeoutAt = Math.min(j10, c1053c.deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (j10 != 0) {
                    c1053c.timeoutAt = j10 + jNanoTime;
                } else {
                    if (!z10) {
                        throw new AssertionError();
                    }
                    c1053c.timeoutAt = c1053c.deadlineNanoTime();
                }
                long jRemainingNanos = c1053c.remainingNanos(jNanoTime);
                C1053c c1053c2 = C1053c.head;
                C13267j.m79674b(c1053c2);
                while (c1053c2.next != null) {
                    C1053c c1053c3 = c1053c2.next;
                    C13267j.m79674b(c1053c3);
                    if (jRemainingNanos < c1053c3.remainingNanos(jNanoTime)) {
                        break;
                    }
                    c1053c2 = c1053c2.next;
                    C13267j.m79674b(c1053c2);
                }
                c1053c.next = c1053c2.next;
                c1053c2.next = c1053c;
                if (c1053c2 == C1053c.head) {
                    C1053c.Companion.m6306e().signal();
                }
                C10951q c10951q = C10951q.f51861a;
                reentrantLockM6307f.unlock();
            } catch (Throwable th2) {
                reentrantLockM6307f.unlock();
                throw th2;
            }
        }

        public a() {
        }
    }

    /* renamed from: ay.c$b */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockM6307f;
            C1053c c1053cM6304c;
            while (true) {
                try {
                    a aVar = C1053c.Companion;
                    reentrantLockM6307f = aVar.m6307f();
                    reentrantLockM6307f.lock();
                    try {
                        c1053cM6304c = aVar.m6304c();
                    } finally {
                        reentrantLockM6307f.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (c1053cM6304c == C1053c.head) {
                    C1053c.head = null;
                    return;
                }
                C10951q c10951q = C10951q.f51861a;
                reentrantLockM6307f.unlock();
                if (c1053cM6304c != null) {
                    c1053cM6304c.timedOut();
                }
            }
        }
    }

    /* renamed from: ay.c$c */
    public static final class c implements InterfaceC1074x {

        /* renamed from: b */
        public final /* synthetic */ InterfaceC1074x f5122b;

        public c(InterfaceC1074x interfaceC1074x) {
            this.f5122b = interfaceC1074x;
        }

        @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C1053c c1053c = C1053c.this;
            InterfaceC1074x interfaceC1074x = this.f5122b;
            c1053c.enter();
            try {
                interfaceC1074x.close();
                C10951q c10951q = C10951q.f51861a;
                if (c1053c.exit()) {
                    throw c1053c.access$newTimeoutException(null);
                }
            } catch (IOException e10) {
                if (!c1053c.exit()) {
                    throw e10;
                }
                throw c1053c.access$newTimeoutException(e10);
            } finally {
                c1053c.exit();
            }
        }

        @Override // p022ay.InterfaceC1074x, java.io.Flushable
        public void flush() throws IOException {
            C1053c c1053c = C1053c.this;
            InterfaceC1074x interfaceC1074x = this.f5122b;
            c1053c.enter();
            try {
                interfaceC1074x.flush();
                C10951q c10951q = C10951q.f51861a;
                if (c1053c.exit()) {
                    throw c1053c.access$newTimeoutException(null);
                }
            } catch (IOException e10) {
                if (!c1053c.exit()) {
                    throw e10;
                }
                throw c1053c.access$newTimeoutException(e10);
            } finally {
                c1053c.exit();
            }
        }

        @Override // p022ay.InterfaceC1074x
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public C1053c timeout() {
            return C1053c.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f5122b + C5929g4.f26850l;
        }

        @Override // p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            C13267j.m79677e(c1054d, "source");
            C1051b.m6294b(c1054d.m6322J(), 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                C1071u c1071u = c1054d.f5125a;
                C13267j.m79674b(c1071u);
                while (true) {
                    if (j11 >= C6144wb.f28903a) {
                        break;
                    }
                    j11 += c1071u.f5169c - c1071u.f5168b;
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    } else {
                        c1071u = c1071u.f5172f;
                        C13267j.m79674b(c1071u);
                    }
                }
                C1053c c1053c = C1053c.this;
                InterfaceC1074x interfaceC1074x = this.f5122b;
                c1053c.enter();
                try {
                    interfaceC1074x.write(c1054d, j11);
                    C10951q c10951q = C10951q.f51861a;
                    if (c1053c.exit()) {
                        throw c1053c.access$newTimeoutException(null);
                    }
                    j10 -= j11;
                } catch (IOException e10) {
                    if (!c1053c.exit()) {
                        throw e10;
                    }
                    throw c1053c.access$newTimeoutException(e10);
                } finally {
                    c1053c.exit();
                }
            }
        }
    }

    /* renamed from: ay.c$d */
    public static final class d implements InterfaceC1076z {

        /* renamed from: b */
        public final /* synthetic */ InterfaceC1076z f5124b;

        public d(InterfaceC1076z interfaceC1076z) {
            this.f5124b = interfaceC1076z;
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C1053c c1053c = C1053c.this;
            InterfaceC1076z interfaceC1076z = this.f5124b;
            c1053c.enter();
            try {
                interfaceC1076z.close();
                C10951q c10951q = C10951q.f51861a;
                if (c1053c.exit()) {
                    throw c1053c.access$newTimeoutException(null);
                }
            } catch (IOException e10) {
                if (!c1053c.exit()) {
                    throw e10;
                }
                throw c1053c.access$newTimeoutException(e10);
            } finally {
                c1053c.exit();
            }
        }

        @Override // p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            C13267j.m79677e(c1054d, "sink");
            C1053c c1053c = C1053c.this;
            InterfaceC1076z interfaceC1076z = this.f5124b;
            c1053c.enter();
            try {
                long j11 = interfaceC1076z.read(c1054d, j10);
                if (c1053c.exit()) {
                    throw c1053c.access$newTimeoutException(null);
                }
                return j11;
            } catch (IOException e10) {
                if (c1053c.exit()) {
                    throw c1053c.access$newTimeoutException(e10);
                }
                throw e10;
            } finally {
                c1053c.exit();
            }
        }

        @Override // p022ay.InterfaceC1076z
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public C1053c timeout() {
            return C1053c.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f5124b + C5929g4.f26850l;
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        C13267j.m79676d(conditionNewCondition, "lock.newCondition()");
        condition = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j10) {
        return this.timeoutAt - j10;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            Companion.m6308g(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.m6305d(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final InterfaceC1074x sink(InterfaceC1074x interfaceC1074x) {
        C13267j.m79677e(interfaceC1074x, "sink");
        return new c(interfaceC1074x);
    }

    public final InterfaceC1076z source(InterfaceC1076z interfaceC1076z) {
        C13267j.m79677e(interfaceC1076z, "source");
        return new d(interfaceC1076z);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(InterfaceC13075a<? extends T> interfaceC13075a) throws IOException {
        C13267j.m79677e(interfaceC13075a, "block");
        enter();
        try {
            try {
                T tMo5005b = interfaceC13075a.mo5005b();
                C13266i.m79672b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                C13266i.m79671a(1);
                return tMo5005b;
            } catch (IOException e10) {
                if (exit()) {
                    throw access$newTimeoutException(e10);
                }
                throw e10;
            }
        } catch (Throwable th2) {
            C13266i.m79672b(1);
            exit();
            C13266i.m79671a(1);
            throw th2;
        }
    }
}
