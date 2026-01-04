package com.huawei.hms.network.embedded;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.y9 */
/* loaded from: classes8.dex */
public final class C6168y9 {

    /* renamed from: m */
    public static final /* synthetic */ boolean f29177m = true;

    /* renamed from: a */
    public long f29178a = 0;

    /* renamed from: b */
    public long f29179b;

    /* renamed from: c */
    public final int f29180c;

    /* renamed from: d */
    public final C6129v9 f29181d;

    /* renamed from: e */
    public final Deque<C5971j7> f29182e;

    /* renamed from: f */
    public boolean f29183f;

    /* renamed from: g */
    public final b f29184g;

    /* renamed from: h */
    public final a f29185h;

    /* renamed from: i */
    public final c f29186i;

    /* renamed from: j */
    public final c f29187j;

    /* renamed from: k */
    public EnumC6077r9 f29188k;

    /* renamed from: l */
    public IOException f29189l;

    /* renamed from: com.huawei.hms.network.embedded.y9$a */
    public final class a implements InterfaceC6170yb {

        /* renamed from: f */
        public static final long f29190f = 16384;

        /* renamed from: g */
        public static final /* synthetic */ boolean f29191g = true;

        /* renamed from: a */
        public final C5868bb f29192a = new C5868bb();

        /* renamed from: b */
        public C5971j7 f29193b;

        /* renamed from: c */
        public boolean f29194c;

        /* renamed from: d */
        public boolean f29195d;

        public a() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (!f29191g && Thread.holdsLock(C6168y9.this)) {
                throw new AssertionError();
            }
            synchronized (C6168y9.this) {
                try {
                    if (this.f29194c) {
                        return;
                    }
                    if (!C6168y9.this.f29185h.f29195d) {
                        boolean z10 = this.f29192a.m33913B() > 0;
                        if (this.f29193b != null) {
                            while (this.f29192a.m33913B() > 0) {
                                m35889a(false);
                            }
                            C6168y9 c6168y9 = C6168y9.this;
                            c6168y9.f29181d.m35655a(c6168y9.f29180c, true, C5920f8.m34241a(this.f29193b));
                        } else if (z10) {
                            while (this.f29192a.m33913B() > 0) {
                                m35889a(true);
                            }
                        } else {
                            C6168y9 c6168y92 = C6168y9.this;
                            c6168y92.f29181d.m35654a(c6168y92.f29180c, true, (C5868bb) null, 0L);
                        }
                    }
                    synchronized (C6168y9.this) {
                        this.f29194c = true;
                    }
                    C6168y9.this.f29181d.flush();
                    C6168y9.this.m35866a();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
            if (!f29191g && Thread.holdsLock(C6168y9.this)) {
                throw new AssertionError();
            }
            synchronized (C6168y9.this) {
                C6168y9.this.m35874b();
            }
            while (this.f29192a.m33913B() > 0) {
                m35889a(false);
                C6168y9.this.f29181d.flush();
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return C6168y9.this.f29187j;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            if (!f29191g && Thread.holdsLock(C6168y9.this)) {
                throw new AssertionError();
            }
            this.f29192a.write(c5868bb, j10);
            while (this.f29192a.m33913B() >= f29190f) {
                m35889a(false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:75:0x005c  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m35889a(boolean r12) throws java.io.IOException {
            /*
                r11 = this;
                com.huawei.hms.network.embedded.y9 r0 = com.huawei.hms.network.embedded.C6168y9.this
                monitor-enter(r0)
                com.huawei.hms.network.embedded.y9 r1 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.network.embedded.y9$c r1 = r1.f29187j     // Catch: java.lang.Throwable -> L79
                r1.m35960f()     // Catch: java.lang.Throwable -> L79
            La:
                com.huawei.hms.network.embedded.y9 r1 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L24
                long r2 = r1.f29179b     // Catch: java.lang.Throwable -> L24
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L26
                boolean r2 = r11.f29195d     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                boolean r2 = r11.f29194c     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                com.huawei.hms.network.embedded.r9 r2 = r1.f29188k     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                r1.m35886m()     // Catch: java.lang.Throwable -> L24
                goto La
            L24:
                r12 = move-exception
                goto L7b
            L26:
                com.huawei.hms.network.embedded.y9$c r1 = r1.f29187j     // Catch: java.lang.Throwable -> L79
                r1.m35896i()     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.network.embedded.y9 r1 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L79
                r1.m35874b()     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.network.embedded.y9 r1 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L79
                long r1 = r1.f29179b     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.network.embedded.bb r3 = r11.f29192a     // Catch: java.lang.Throwable -> L79
                long r3 = r3.m33913B()     // Catch: java.lang.Throwable -> L79
                long r9 = java.lang.Math.min(r1, r3)     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.network.embedded.y9 r1 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L79
                long r2 = r1.f29179b     // Catch: java.lang.Throwable -> L79
                long r2 = r2 - r9
                r1.f29179b = r2     // Catch: java.lang.Throwable -> L79
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.network.embedded.y9$c r0 = r1.f29187j
                r0.m35960f()
                if (r12 == 0) goto L5c
                com.huawei.hms.network.embedded.bb r12 = r11.f29192a     // Catch: java.lang.Throwable -> L5a
                long r0 = r12.m33913B()     // Catch: java.lang.Throwable -> L5a
                int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r12 != 0) goto L5c
                r12 = 1
            L58:
                r7 = r12
                goto L5e
            L5a:
                r12 = move-exception
                goto L71
            L5c:
                r12 = 0
                goto L58
            L5e:
                com.huawei.hms.network.embedded.y9 r12 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L5a
                com.huawei.hms.network.embedded.v9 r5 = r12.f29181d     // Catch: java.lang.Throwable -> L5a
                int r6 = r12.f29180c     // Catch: java.lang.Throwable -> L5a
                com.huawei.hms.network.embedded.bb r8 = r11.f29192a     // Catch: java.lang.Throwable -> L5a
                r5.m35654a(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5a
                com.huawei.hms.network.embedded.y9 r11 = com.huawei.hms.network.embedded.C6168y9.this
                com.huawei.hms.network.embedded.y9$c r11 = r11.f29187j
                r11.m35896i()
                return
            L71:
                com.huawei.hms.network.embedded.y9 r11 = com.huawei.hms.network.embedded.C6168y9.this
                com.huawei.hms.network.embedded.y9$c r11 = r11.f29187j
                r11.m35896i()
                throw r12
            L79:
                r11 = move-exception
                goto L83
            L7b:
                com.huawei.hms.network.embedded.y9 r11 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.network.embedded.y9$c r11 = r11.f29187j     // Catch: java.lang.Throwable -> L79
                r11.m35896i()     // Catch: java.lang.Throwable -> L79
                throw r12     // Catch: java.lang.Throwable -> L79
            L83:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6168y9.a.m35889a(boolean):void");
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.y9$b */
    public final class b implements InterfaceC6183zb {

        /* renamed from: h */
        public static final /* synthetic */ boolean f29197h = true;

        /* renamed from: a */
        public final C5868bb f29198a = new C5868bb();

        /* renamed from: b */
        public final C5868bb f29199b = new C5868bb();

        /* renamed from: c */
        public final long f29200c;

        /* renamed from: d */
        public C5971j7 f29201d;

        /* renamed from: e */
        public boolean f29202e;

        /* renamed from: f */
        public boolean f29203f;

        public b(long j10) {
            this.f29200c = j10;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            long jM33913B;
            synchronized (C6168y9.this) {
                this.f29202e = true;
                jM33913B = this.f29199b.m33913B();
                this.f29199b.m33983s();
                C6168y9.this.notifyAll();
            }
            if (jM33913B > 0) {
                m35892a(jM33913B);
            }
            C6168y9.this.m35866a();
        }

        /* JADX WARN: Removed duplicated region for block: B:97:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0096  */
        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(com.huawei.hms.network.embedded.C5868bb r12, long r13) throws java.lang.Throwable {
            /*
                r11 = this;
                r0 = 0
                int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r2 < 0) goto Lac
            L6:
                com.huawei.hms.network.embedded.y9 r2 = com.huawei.hms.network.embedded.C6168y9.this
                monitor-enter(r2)
                com.huawei.hms.network.embedded.y9 r3 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.network.embedded.y9$c r3 = r3.f29186i     // Catch: java.lang.Throwable -> L83
                r3.m35960f()     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.network.embedded.y9 r3 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.r9 r4 = r3.f29188k     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L28
                java.io.IOException r3 = r3.f29189l     // Catch: java.lang.Throwable -> L25
                if (r3 == 0) goto L1b
                goto L29
            L1b:
                com.huawei.hms.network.embedded.da r3 = new com.huawei.hms.network.embedded.da     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.y9 r4 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.r9 r4 = r4.f29188k     // Catch: java.lang.Throwable -> L25
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
                goto L29
            L25:
                r12 = move-exception
                goto La2
            L28:
                r3 = 0
            L29:
                boolean r4 = r11.f29202e     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L9a
                com.huawei.hms.network.embedded.bb r4 = r11.f29199b     // Catch: java.lang.Throwable -> L25
                long r4 = r4.m33913B()     // Catch: java.lang.Throwable -> L25
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                r5 = -1
                if (r4 <= 0) goto L6f
                com.huawei.hms.network.embedded.bb r4 = r11.f29199b     // Catch: java.lang.Throwable -> L25
                long r7 = r4.m33913B()     // Catch: java.lang.Throwable -> L25
                long r13 = java.lang.Math.min(r13, r7)     // Catch: java.lang.Throwable -> L25
                long r12 = r4.read(r12, r13)     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.y9 r14 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L25
                long r7 = r14.f29178a     // Catch: java.lang.Throwable -> L25
                long r7 = r7 + r12
                r14.f29178a = r7     // Catch: java.lang.Throwable -> L25
                if (r3 != 0) goto L86
                com.huawei.hms.network.embedded.v9 r14 = r14.f29181d     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.ca r14 = r14.f28724t     // Catch: java.lang.Throwable -> L25
                int r14 = r14.m34080c()     // Catch: java.lang.Throwable -> L25
                int r14 = r14 / 2
                long r9 = (long) r14     // Catch: java.lang.Throwable -> L25
                int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r14 < 0) goto L86
                com.huawei.hms.network.embedded.y9 r14 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.v9 r4 = r14.f29181d     // Catch: java.lang.Throwable -> L25
                int r7 = r14.f29180c     // Catch: java.lang.Throwable -> L25
                long r8 = r14.f29178a     // Catch: java.lang.Throwable -> L25
                r4.m35649a(r7, r8)     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.y9 r14 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L25
                r14.f29178a = r0     // Catch: java.lang.Throwable -> L25
                goto L86
            L6f:
                boolean r4 = r11.f29203f     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L85
                if (r3 != 0) goto L85
                com.huawei.hms.network.embedded.y9 r3 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L25
                r3.m35886m()     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.network.embedded.y9 r3 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.network.embedded.y9$c r3 = r3.f29186i     // Catch: java.lang.Throwable -> L83
                r3.m35896i()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                goto L6
            L83:
                r11 = move-exception
                goto Laa
            L85:
                r12 = r5
            L86:
                com.huawei.hms.network.embedded.y9 r14 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.network.embedded.y9$c r14 = r14.f29186i     // Catch: java.lang.Throwable -> L83
                r14.m35896i()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r14 == 0) goto L96
                r11.m35892a(r12)
                return r12
            L96:
                if (r3 != 0) goto L99
                return r5
            L99:
                throw r3
            L9a:
                java.io.IOException r12 = new java.io.IOException     // Catch: java.lang.Throwable -> L25
                java.lang.String r13 = "stream closed"
                r12.<init>(r13)     // Catch: java.lang.Throwable -> L25
                throw r12     // Catch: java.lang.Throwable -> L25
            La2:
                com.huawei.hms.network.embedded.y9 r11 = com.huawei.hms.network.embedded.C6168y9.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.network.embedded.y9$c r11 = r11.f29186i     // Catch: java.lang.Throwable -> L83
                r11.m35896i()     // Catch: java.lang.Throwable -> L83
                throw r12     // Catch: java.lang.Throwable -> L83
            Laa:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                throw r11
            Lac:
                java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "byteCount < 0: "
                r12.append(r0)
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6168y9.b.read(com.huawei.hms.network.embedded.bb, long):long");
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return C6168y9.this.f29186i;
        }

        /* renamed from: a */
        private void m35892a(long j10) {
            if (!f29197h && Thread.holdsLock(C6168y9.this)) {
                throw new AssertionError();
            }
            C6168y9.this.f29181d.m35668k(j10);
        }

        /* renamed from: a */
        public void m35895a(InterfaceC5896db interfaceC5896db, long j10) throws IOException {
            boolean z10;
            boolean z11;
            long jM33913B;
            if (!f29197h && Thread.holdsLock(C6168y9.this)) {
                throw new AssertionError();
            }
            while (j10 > 0) {
                synchronized (C6168y9.this) {
                    z10 = this.f29203f;
                    z11 = this.f29199b.m33913B() + j10 > this.f29200c;
                }
                if (z11) {
                    interfaceC5896db.skip(j10);
                    C6168y9.this.m35871a(EnumC6077r9.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    interfaceC5896db.skip(j10);
                    return;
                }
                long j11 = interfaceC5896db.read(this.f29198a, j10);
                if (j11 == -1) {
                    throw new EOFException();
                }
                j10 -= j11;
                synchronized (C6168y9.this) {
                    try {
                        if (this.f29202e) {
                            jM33913B = this.f29198a.m33913B();
                            this.f29198a.m33983s();
                        } else {
                            boolean z12 = this.f29199b.m33913B() == 0;
                            this.f29199b.mo33922a((InterfaceC6183zb) this.f29198a);
                            if (z12) {
                                C6168y9.this.notifyAll();
                            }
                            jM33913B = 0;
                        }
                    } finally {
                    }
                }
                if (jM33913B > 0) {
                    m35892a(jM33913B);
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.y9$c */
    public class c extends C6182za {
        public c() {
        }

        /* renamed from: i */
        public void m35896i() throws IOException {
            if (m35961g()) {
                throw newTimeoutException(null);
            }
        }

        @Override // com.huawei.hms.network.embedded.C6182za
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.huawei.hms.network.embedded.C6182za
        public void timedOut() {
            C6168y9.this.m35871a(EnumC6077r9.CANCEL);
            C6168y9.this.f29181d.m35672v();
        }
    }

    public C6168y9(int i10, C6129v9 c6129v9, boolean z10, boolean z11, C5971j7 c5971j7) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f29182e = arrayDeque;
        this.f29186i = new c();
        this.f29187j = new c();
        if (c6129v9 == null) {
            throw new NullPointerException("connection == null");
        }
        this.f29180c = i10;
        this.f29181d = c6129v9;
        this.f29179b = c6129v9.f28725u.m34080c();
        b bVar = new b(c6129v9.f28724t.m34080c());
        this.f29184g = bVar;
        a aVar = new a();
        this.f29185h = aVar;
        bVar.f29203f = z11;
        aVar.f29195d = z10;
        if (c5971j7 != null) {
            arrayDeque.add(c5971j7);
        }
        if (m35881h() && c5971j7 != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!m35881h() && c5971j7 == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x002b  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m35866a() throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = com.huawei.hms.network.embedded.C6168y9.f29177m
            if (r0 != 0) goto L11
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto Lb
            goto L11
        Lb:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L11:
            monitor-enter(r2)
            com.huawei.hms.network.embedded.y9$b r0 = r2.f29184g     // Catch: java.lang.Throwable -> L27
            boolean r1 = r0.f29203f     // Catch: java.lang.Throwable -> L27
            if (r1 != 0) goto L2b
            boolean r0 = r0.f29202e     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L2b
            com.huawei.hms.network.embedded.y9$a r0 = r2.f29185h     // Catch: java.lang.Throwable -> L27
            boolean r1 = r0.f29195d     // Catch: java.lang.Throwable -> L27
            if (r1 != 0) goto L29
            boolean r0 = r0.f29194c     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L2b
            goto L29
        L27:
            r0 = move-exception
            goto L44
        L29:
            r0 = 1
            goto L2c
        L2b:
            r0 = 0
        L2c:
            boolean r1 = r2.m35882i()     // Catch: java.lang.Throwable -> L27
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L3a
            com.huawei.hms.network.embedded.r9 r0 = com.huawei.hms.network.embedded.EnumC6077r9.CANCEL
            r1 = 0
            r2.m35872a(r0, r1)
            goto L43
        L3a:
            if (r1 != 0) goto L43
            com.huawei.hms.network.embedded.v9 r0 = r2.f29181d
            int r2 = r2.f29180c
            r0.m35666f(r2)
        L43:
            return
        L44:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6168y9.m35866a():void");
    }

    /* renamed from: b */
    public void m35874b() throws IOException {
        a aVar = this.f29185h;
        if (aVar.f29194c) {
            throw new IOException("stream closed");
        }
        if (aVar.f29195d) {
            throw new IOException("stream finished");
        }
        EnumC6077r9 enumC6077r9 = this.f29188k;
        if (enumC6077r9 != null) {
            IOException iOException = this.f29189l;
            if (iOException == null) {
                throw new C5895da(enumC6077r9);
            }
        }
    }

    /* renamed from: c */
    public C6129v9 m35876c() {
        return this.f29181d;
    }

    /* renamed from: d */
    public synchronized EnumC6077r9 m35877d() {
        return this.f29188k;
    }

    /* renamed from: e */
    public int m35878e() {
        return this.f29180c;
    }

    /* renamed from: f */
    public InterfaceC6170yb m35879f() {
        synchronized (this) {
            try {
                if (!this.f29183f && !m35881h()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f29185h;
    }

    /* renamed from: g */
    public InterfaceC6183zb m35880g() {
        return this.f29184g;
    }

    /* renamed from: h */
    public boolean m35881h() {
        return this.f29181d.f28705a == ((this.f29180c & 1) == 1);
    }

    /* renamed from: i */
    public synchronized boolean m35882i() {
        try {
            if (this.f29188k != null) {
                return false;
            }
            b bVar = this.f29184g;
            if (bVar.f29203f || bVar.f29202e) {
                a aVar = this.f29185h;
                if (aVar.f29195d || aVar.f29194c) {
                    if (this.f29183f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: j */
    public C5855ac m35883j() {
        return this.f29186i;
    }

    /* renamed from: k */
    public synchronized C5971j7 m35884k() throws IOException {
        this.f29186i.m35960f();
        while (this.f29182e.isEmpty() && this.f29188k == null) {
            try {
                m35886m();
            } catch (Throwable th2) {
                this.f29186i.m35896i();
                throw th2;
            }
        }
        this.f29186i.m35896i();
        if (this.f29182e.isEmpty()) {
            IOException iOException = this.f29189l;
            if (iOException != null) {
                throw iOException;
            }
            throw new C5895da(this.f29188k);
        }
        return this.f29182e.removeFirst();
    }

    /* renamed from: l */
    public synchronized C5971j7 m35885l() throws IOException {
        try {
            EnumC6077r9 enumC6077r9 = this.f29188k;
            if (enumC6077r9 != null) {
                IOException iOException = this.f29189l;
                if (iOException != null) {
                    throw iOException;
                }
                throw new C5895da(enumC6077r9);
            }
            b bVar = this.f29184g;
            if (!bVar.f29203f || !bVar.f29198a.mo33971i() || !this.f29184g.f29199b.mo33971i()) {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
        } finally {
        }
        return this.f29184g.f29201d != null ? this.f29184g.f29201d : C5920f8.f26771c;
    }

    /* renamed from: m */
    public void m35886m() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: n */
    public C5855ac m35887n() {
        return this.f29187j;
    }

    /* renamed from: a */
    public void m35867a(long j10) {
        this.f29179b += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    /* renamed from: b */
    public synchronized void m35875b(EnumC6077r9 enumC6077r9) {
        if (this.f29188k == null) {
            this.f29188k = enumC6077r9;
            notifyAll();
        }
    }

    /* renamed from: b */
    private boolean m35865b(EnumC6077r9 enumC6077r9, IOException iOException) {
        if (!f29177m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.f29188k != null) {
                    return false;
                }
                if (this.f29184g.f29203f && this.f29185h.f29195d) {
                    return false;
                }
                this.f29188k = enumC6077r9;
                this.f29189l = iOException;
                notifyAll();
                this.f29181d.m35666f(this.f29180c);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m35868a(InterfaceC5896db interfaceC5896db, int i10) throws IOException {
        if (!f29177m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f29184g.m35895a(interfaceC5896db, i10);
    }

    /* renamed from: a */
    public void m35869a(C5971j7 c5971j7) {
        synchronized (this) {
            try {
                if (this.f29185h.f29195d) {
                    throw new IllegalStateException("already finished");
                }
                if (c5971j7.m34527d() == 0) {
                    throw new IllegalArgumentException("trailers.size() == 0");
                }
                this.f29185h.f29193b = c5971j7;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m35870a(C5971j7 c5971j7, boolean z10) {
        boolean zM35882i;
        if (!f29177m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.f29183f && z10) {
                    this.f29184g.f29201d = c5971j7;
                } else {
                    this.f29183f = true;
                    this.f29182e.add(c5971j7);
                }
                if (z10) {
                    this.f29184g.f29203f = true;
                }
                zM35882i = m35882i();
                notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zM35882i) {
            return;
        }
        this.f29181d.m35666f(this.f29180c);
    }

    /* renamed from: a */
    public void m35871a(EnumC6077r9 enumC6077r9) {
        if (m35865b(enumC6077r9, null)) {
            this.f29181d.m35663c(this.f29180c, enumC6077r9);
        }
    }

    /* renamed from: a */
    public void m35872a(EnumC6077r9 enumC6077r9, IOException iOException) throws IOException {
        if (m35865b(enumC6077r9, iOException)) {
            this.f29181d.m35662b(this.f29180c, enumC6077r9);
        }
    }

    /* renamed from: a */
    public void m35873a(List<C6090s9> list, boolean z10, boolean z11) throws IOException {
        if (!f29177m && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (list == null) {
            throw new NullPointerException("headers == null");
        }
        synchronized (this) {
            try {
                this.f29183f = true;
                if (z10) {
                    this.f29185h.f29195d = true;
                }
            } finally {
            }
        }
        if (!z11) {
            synchronized (this.f29181d) {
                z11 = this.f29181d.f28723s == 0;
            }
        }
        this.f29181d.m35655a(this.f29180c, z10, list);
        if (z11) {
            this.f29181d.flush();
        }
    }
}
