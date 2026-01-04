package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.za */
/* loaded from: classes8.dex */
public class C6182za extends C5855ac {

    /* renamed from: h */
    public static final int f29245h = 65536;

    /* renamed from: i */
    public static final long f29246i;

    /* renamed from: j */
    public static final long f29247j;

    /* renamed from: k */
    public static C6182za f29248k;

    /* renamed from: e */
    public boolean f29249e;

    /* renamed from: f */
    public C6182za f29250f;

    /* renamed from: g */
    public long f29251g;

    /* renamed from: com.huawei.hms.network.embedded.za$a */
    public class a implements InterfaceC6170yb {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC6170yb f29252a;

        public a(InterfaceC6170yb interfaceC6170yb) {
            this.f29252a = interfaceC6170yb;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            C6182za.this.m35960f();
            try {
                try {
                    this.f29252a.close();
                    C6182za.this.m35959a(true);
                } catch (IOException e10) {
                    throw C6182za.this.m35958a(e10);
                }
            } catch (Throwable th2) {
                C6182za.this.m35959a(false);
                throw th2;
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
            C6182za.this.m35960f();
            try {
                try {
                    this.f29252a.flush();
                    C6182za.this.m35959a(true);
                } catch (IOException e10) {
                    throw C6182za.this.m35958a(e10);
                }
            } catch (Throwable th2) {
                C6182za.this.m35959a(false);
                throw th2;
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return C6182za.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f29252a + ")";
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            C5883cc.m34088a(c5868bb.f26524b, 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                C6131vb c6131vb = c5868bb.f26523a;
                while (true) {
                    if (j11 >= C6144wb.f28903a) {
                        break;
                    }
                    j11 += c6131vb.f28800c - c6131vb.f28799b;
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    }
                    c6131vb = c6131vb.f28803f;
                }
                C6182za.this.m35960f();
                try {
                    try {
                        this.f29252a.write(c5868bb, j11);
                        j10 -= j11;
                        C6182za.this.m35959a(true);
                    } catch (IOException e10) {
                        throw C6182za.this.m35958a(e10);
                    }
                } catch (Throwable th2) {
                    C6182za.this.m35959a(false);
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.za$b */
    public class b implements InterfaceC6183zb {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC6183zb f29254a;

        public b(InterfaceC6183zb interfaceC6183zb) {
            this.f29254a = interfaceC6183zb;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            C6182za.this.m35960f();
            try {
                try {
                    this.f29254a.close();
                    C6182za.this.m35959a(true);
                } catch (IOException e10) {
                    throw C6182za.this.m35958a(e10);
                }
            } catch (Throwable th2) {
                C6182za.this.m35959a(false);
                throw th2;
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            C6182za.this.m35960f();
            try {
                try {
                    long j11 = this.f29254a.read(c5868bb, j10);
                    C6182za.this.m35959a(true);
                    return j11;
                } catch (IOException e10) {
                    throw C6182za.this.m35958a(e10);
                }
            } catch (Throwable th2) {
                C6182za.this.m35959a(false);
                throw th2;
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return C6182za.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f29254a + ")";
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.za$c */
    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0017, code lost:
        
            r0.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r2 = this;
            L0:
                java.lang.Class<com.huawei.hms.network.embedded.za> r2 = com.huawei.hms.network.embedded.C6182za.class
                monitor-enter(r2)     // Catch: java.lang.InterruptedException -> L0
                com.huawei.hms.network.embedded.za r0 = com.huawei.hms.network.embedded.C6182za.m35955h()     // Catch: java.lang.Throwable -> Lb
                if (r0 != 0) goto Ld
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r0 = move-exception
                goto L1b
            Ld:
                com.huawei.hms.network.embedded.za r1 = com.huawei.hms.network.embedded.C6182za.f29248k     // Catch: java.lang.Throwable -> Lb
                if (r0 != r1) goto L16
                r0 = 0
                com.huawei.hms.network.embedded.C6182za.f29248k = r0     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                return
            L16:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                r0.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L1b:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                throw r0     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6182za.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f29246i = millis;
        f29247j = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* renamed from: a */
    private long m35952a(long j10) {
        return this.f29251g - j10;
    }

    /* renamed from: h */
    public static C6182za m35955h() throws InterruptedException {
        C6182za c6182za = f29248k.f29250f;
        long jNanoTime = System.nanoTime();
        if (c6182za == null) {
            C6182za.class.wait(f29246i);
            if (f29248k.f29250f != null || System.nanoTime() - jNanoTime < f29247j) {
                return null;
            }
            return f29248k;
        }
        long jM35952a = c6182za.m35952a(jNanoTime);
        if (jM35952a > 0) {
            long j10 = jM35952a / 1000000;
            C6182za.class.wait(j10, (int) (jM35952a - (1000000 * j10)));
            return null;
        }
        f29248k.f29250f = c6182za.f29250f;
        c6182za.f29250f = null;
        return c6182za;
    }

    /* renamed from: f */
    public final void m35960f() {
        if (this.f29249e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jMo33847e = mo33847e();
        boolean zMo33846d = mo33846d();
        if (jMo33847e != 0 || zMo33846d) {
            this.f29249e = true;
            m35953a(this, jMo33847e, zMo33846d);
        }
    }

    /* renamed from: g */
    public final boolean m35961g() {
        if (!this.f29249e) {
            return false;
        }
        this.f29249e = false;
        return m35954a(this);
    }

    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void timedOut() {
    }

    /* renamed from: a */
    public final InterfaceC6170yb m35956a(InterfaceC6170yb interfaceC6170yb) {
        return new a(interfaceC6170yb);
    }

    /* renamed from: a */
    public final InterfaceC6183zb m35957a(InterfaceC6183zb interfaceC6183zb) {
        return new b(interfaceC6183zb);
    }

    /* renamed from: a */
    public final IOException m35958a(IOException iOException) throws IOException {
        return !m35961g() ? iOException : newTimeoutException(iOException);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x005d A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:41:0x0003, B:43:0x0007, B:46:0x0019, B:49:0x0025, B:50:0x002e, B:55:0x003d, B:56:0x0043, B:58:0x0047, B:61:0x0050, B:62:0x0053, B:64:0x005d, B:54:0x0037, B:67:0x0064, B:68:0x0069), top: B:71:0x0003 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void m35953a(com.huawei.hms.network.embedded.C6182za r5, long r6, boolean r8) {
        /*
            java.lang.Class<com.huawei.hms.network.embedded.za> r0 = com.huawei.hms.network.embedded.C6182za.class
            monitor-enter(r0)
            com.huawei.hms.network.embedded.za r1 = com.huawei.hms.network.embedded.C6182za.f29248k     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L19
            com.huawei.hms.network.embedded.za r1 = new com.huawei.hms.network.embedded.za     // Catch: java.lang.Throwable -> L17
            r1.<init>()     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.C6182za.f29248k = r1     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.za$c r1 = new com.huawei.hms.network.embedded.za$c     // Catch: java.lang.Throwable -> L17
            r1.<init>()     // Catch: java.lang.Throwable -> L17
            r1.start()     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r5 = move-exception
            goto L6a
        L19:
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L17
            r3 = 0
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L32
            if (r8 == 0) goto L32
            long r3 = r5.mo33845c()     // Catch: java.lang.Throwable -> L17
            long r3 = r3 - r1
            long r6 = java.lang.Math.min(r6, r3)     // Catch: java.lang.Throwable -> L17
        L2e:
            long r6 = r6 + r1
            r5.f29251g = r6     // Catch: java.lang.Throwable -> L17
            goto L3d
        L32:
            if (r3 == 0) goto L35
            goto L2e
        L35:
            if (r8 == 0) goto L64
            long r6 = r5.mo33845c()     // Catch: java.lang.Throwable -> L17
            r5.f29251g = r6     // Catch: java.lang.Throwable -> L17
        L3d:
            long r6 = r5.m35952a(r1)     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.za r8 = com.huawei.hms.network.embedded.C6182za.f29248k     // Catch: java.lang.Throwable -> L17
        L43:
            com.huawei.hms.network.embedded.za r3 = r8.f29250f     // Catch: java.lang.Throwable -> L17
            if (r3 == 0) goto L53
            long r3 = r3.m35952a(r1)     // Catch: java.lang.Throwable -> L17
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 >= 0) goto L50
            goto L53
        L50:
            com.huawei.hms.network.embedded.za r8 = r8.f29250f     // Catch: java.lang.Throwable -> L17
            goto L43
        L53:
            com.huawei.hms.network.embedded.za r6 = r8.f29250f     // Catch: java.lang.Throwable -> L17
            r5.f29250f = r6     // Catch: java.lang.Throwable -> L17
            r8.f29250f = r5     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.za r5 = com.huawei.hms.network.embedded.C6182za.f29248k     // Catch: java.lang.Throwable -> L17
            if (r8 != r5) goto L62
            java.lang.Class<com.huawei.hms.network.embedded.za> r5 = com.huawei.hms.network.embedded.C6182za.class
            r5.notify()     // Catch: java.lang.Throwable -> L17
        L62:
            monitor-exit(r0)
            return
        L64:
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L17
            r5.<init>()     // Catch: java.lang.Throwable -> L17
            throw r5     // Catch: java.lang.Throwable -> L17
        L6a:
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6182za.m35953a(com.huawei.hms.network.embedded.za, long, boolean):void");
    }

    /* renamed from: a */
    public final void m35959a(boolean z10) throws IOException {
        if (m35961g() && z10) {
            throw newTimeoutException(null);
        }
    }

    /* renamed from: a */
    public static synchronized boolean m35954a(C6182za c6182za) {
        C6182za c6182za2 = f29248k;
        while (c6182za2 != null) {
            C6182za c6182za3 = c6182za2.f29250f;
            if (c6182za3 == c6182za) {
                c6182za2.f29250f = c6182za.f29250f;
                c6182za.f29250f = null;
                return false;
            }
            c6182za2 = c6182za3;
        }
        return true;
    }
}
