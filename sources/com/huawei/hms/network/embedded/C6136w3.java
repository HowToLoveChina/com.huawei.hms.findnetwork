package com.huawei.hms.network.embedded;

import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.w3 */
/* loaded from: classes8.dex */
public class C6136w3 extends C6149x3 {

    /* renamed from: g */
    public static final long f28834g;

    /* renamed from: h */
    public static final long f28835h;

    /* renamed from: i */
    public static C6136w3 f28836i;

    /* renamed from: d */
    public boolean f28837d;

    /* renamed from: e */
    public C6136w3 f28838e;

    /* renamed from: f */
    public long f28839f;

    /* renamed from: com.huawei.hms.network.embedded.w3$a */
    public static final class a extends Thread {

        /* renamed from: a */
        public static final String f28840a = "Watchdog";

        public a() {
            super(f28840a);
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0017, code lost:
        
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
                java.lang.Class<com.huawei.hms.network.embedded.w3> r2 = com.huawei.hms.network.embedded.C6136w3.class
                monitor-enter(r2)     // Catch: java.lang.InterruptedException -> L1b
                com.huawei.hms.network.embedded.w3 r0 = com.huawei.hms.network.embedded.C6136w3.m35717a()     // Catch: java.lang.Throwable -> Lb
                if (r0 != 0) goto Ld
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                goto L0
            Lb:
                r0 = move-exception
                goto L1d
            Ld:
                com.huawei.hms.network.embedded.w3 r1 = com.huawei.hms.network.embedded.C6136w3.f28836i     // Catch: java.lang.Throwable -> Lb
                if (r0 != r1) goto L16
                r0 = 0
                com.huawei.hms.network.embedded.C6136w3.f28836i = r0     // Catch: java.lang.Throwable -> Lb
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                return
            L16:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                r0.timedOut()     // Catch: java.lang.InterruptedException -> L1b
                goto L0
            L1b:
                r2 = move-exception
                goto L1f
            L1d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb
                throw r0     // Catch: java.lang.InterruptedException -> L1b
            L1f:
                java.lang.String r2 = r2.getMessage()
                java.lang.String r0 = "Watchdog"
                com.huawei.hms.framework.common.Logger.m32141i(r0, r2)
                goto L0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6136w3.a.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f28834g = millis;
        f28835h = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* renamed from: a */
    private long m35716a(long j10) {
        return this.f28839f - j10;
    }

    public final void enter() {
        if (this.f28837d) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.f28837d = true;
            m35718a(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.f28837d) {
            return false;
        }
        this.f28837d = false;
        return m35719a(this);
    }

    public void timedOut() {
    }

    /* renamed from: a */
    public static C6136w3 m35717a() throws InterruptedException {
        C6136w3 c6136w3 = f28836i.f28838e;
        long jNanoTime = System.nanoTime();
        if (c6136w3 == null) {
            C6136w3.class.wait(f28834g);
            if (f28836i.f28838e != null || System.nanoTime() - jNanoTime < f28835h) {
                return null;
            }
            return f28836i;
        }
        long jM35716a = c6136w3.m35716a(jNanoTime);
        if (jM35716a > 0) {
            long j10 = jM35716a / 1000000;
            C6136w3.class.wait(j10, (int) (jM35716a - (1000000 * j10)));
            return null;
        }
        f28836i.f28838e = c6136w3.f28838e;
        c6136w3.f28838e = null;
        return c6136w3;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:4:0x0003, B:6:0x0007, B:9:0x0019, B:12:0x0025, B:13:0x002e, B:18:0x003d, B:19:0x0043, B:21:0x0047, B:24:0x0050, B:25:0x0053, B:27:0x005d, B:17:0x0037, B:30:0x0064, B:31:0x0069), top: B:34:0x0003 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized void m35718a(com.huawei.hms.network.embedded.C6136w3 r5, long r6, boolean r8) {
        /*
            java.lang.Class<com.huawei.hms.network.embedded.w3> r0 = com.huawei.hms.network.embedded.C6136w3.class
            monitor-enter(r0)
            com.huawei.hms.network.embedded.w3 r1 = com.huawei.hms.network.embedded.C6136w3.f28836i     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L19
            com.huawei.hms.network.embedded.w3 r1 = new com.huawei.hms.network.embedded.w3     // Catch: java.lang.Throwable -> L17
            r1.<init>()     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.C6136w3.f28836i = r1     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.w3$a r1 = new com.huawei.hms.network.embedded.w3$a     // Catch: java.lang.Throwable -> L17
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
            long r3 = r5.deadlineNanoTime()     // Catch: java.lang.Throwable -> L17
            long r3 = r3 - r1
            long r6 = java.lang.Math.min(r6, r3)     // Catch: java.lang.Throwable -> L17
        L2e:
            long r6 = r6 + r1
            r5.f28839f = r6     // Catch: java.lang.Throwable -> L17
            goto L3d
        L32:
            if (r3 == 0) goto L35
            goto L2e
        L35:
            if (r8 == 0) goto L64
            long r6 = r5.deadlineNanoTime()     // Catch: java.lang.Throwable -> L17
            r5.f28839f = r6     // Catch: java.lang.Throwable -> L17
        L3d:
            long r6 = r5.m35716a(r1)     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.w3 r8 = com.huawei.hms.network.embedded.C6136w3.f28836i     // Catch: java.lang.Throwable -> L17
        L43:
            com.huawei.hms.network.embedded.w3 r3 = r8.f28838e     // Catch: java.lang.Throwable -> L17
            if (r3 == 0) goto L53
            long r3 = r3.m35716a(r1)     // Catch: java.lang.Throwable -> L17
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 >= 0) goto L50
            goto L53
        L50:
            com.huawei.hms.network.embedded.w3 r8 = r8.f28838e     // Catch: java.lang.Throwable -> L17
            goto L43
        L53:
            com.huawei.hms.network.embedded.w3 r6 = r8.f28838e     // Catch: java.lang.Throwable -> L17
            r5.f28838e = r6     // Catch: java.lang.Throwable -> L17
            r8.f28838e = r5     // Catch: java.lang.Throwable -> L17
            com.huawei.hms.network.embedded.w3 r5 = com.huawei.hms.network.embedded.C6136w3.f28836i     // Catch: java.lang.Throwable -> L17
            if (r8 != r5) goto L62
            java.lang.Class<com.huawei.hms.network.embedded.w3> r5 = com.huawei.hms.network.embedded.C6136w3.class
            r5.notifyAll()     // Catch: java.lang.Throwable -> L17
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6136w3.m35718a(com.huawei.hms.network.embedded.w3, long, boolean):void");
    }

    /* renamed from: a */
    public static synchronized boolean m35719a(C6136w3 c6136w3) {
        C6136w3 c6136w32 = f28836i;
        while (c6136w32 != null) {
            C6136w3 c6136w33 = c6136w32.f28838e;
            if (c6136w33 == c6136w3) {
                c6136w32.f28838e = c6136w3.f28838e;
                c6136w3.f28838e = null;
                return false;
            }
            c6136w32 = c6136w33;
        }
        return true;
    }
}
