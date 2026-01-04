package com.huawei.hms.drive;

import com.huawei.hms.network.embedded.C6168y9;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import p022ay.C1050a0;
import p022ay.C1053c;
import p022ay.C1054d;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;

/* renamed from: com.huawei.hms.drive.dd */
/* loaded from: classes8.dex */
public final class C5255dd {

    /* renamed from: j */
    static final /* synthetic */ boolean f24404j = true;

    /* renamed from: a */
    long f24405a = 0;

    /* renamed from: b */
    long f24406b;

    /* renamed from: c */
    final int f24407c;

    /* renamed from: d */
    final C5252da f24408d;

    /* renamed from: e */
    final a f24409e;

    /* renamed from: f */
    final c f24410f;

    /* renamed from: g */
    final c f24411g;

    /* renamed from: h */
    EnumC5246cw f24412h;

    /* renamed from: i */
    IOException f24413i;

    /* renamed from: k */
    private final Deque<C5190aw> f24414k;

    /* renamed from: l */
    private boolean f24415l;

    /* renamed from: m */
    private final b f24416m;

    /* renamed from: com.huawei.hms.drive.dd$a */
    public final class a implements InterfaceC1074x {

        /* renamed from: c */
        static final /* synthetic */ boolean f24417c = true;

        /* renamed from: a */
        boolean f24418a;

        /* renamed from: b */
        boolean f24419b;

        /* renamed from: e */
        private final C1054d f24421e = new C1054d();

        /* renamed from: f */
        private C5190aw f24422f;

        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:75:0x005c  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void m31599a(boolean r12) throws java.io.IOException {
            /*
                r11 = this;
                com.huawei.hms.drive.dd r0 = com.huawei.hms.drive.C5255dd.this
                monitor-enter(r0)
                com.huawei.hms.drive.dd r1 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.drive.dd$c r1 = r1.f24411g     // Catch: java.lang.Throwable -> L79
                r1.enter()     // Catch: java.lang.Throwable -> L79
            La:
                com.huawei.hms.drive.dd r1 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L24
                long r2 = r1.f24406b     // Catch: java.lang.Throwable -> L24
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L26
                boolean r2 = r11.f24419b     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                boolean r2 = r11.f24418a     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                com.huawei.hms.drive.cw r2 = r1.f24412h     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                r1.m31598k()     // Catch: java.lang.Throwable -> L24
                goto La
            L24:
                r12 = move-exception
                goto L7b
            L26:
                com.huawei.hms.drive.dd$c r1 = r1.f24411g     // Catch: java.lang.Throwable -> L79
                r1.m31603a()     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.drive.dd r1 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L79
                r1.m31597j()     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.drive.dd r1 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L79
                long r1 = r1.f24406b     // Catch: java.lang.Throwable -> L79
                ay.d r3 = r11.f24421e     // Catch: java.lang.Throwable -> L79
                long r3 = r3.m6322J()     // Catch: java.lang.Throwable -> L79
                long r9 = java.lang.Math.min(r1, r3)     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.drive.dd r1 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L79
                long r2 = r1.f24406b     // Catch: java.lang.Throwable -> L79
                long r2 = r2 - r9
                r1.f24406b = r2     // Catch: java.lang.Throwable -> L79
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.drive.dd$c r0 = r1.f24411g
                r0.enter()
                if (r12 == 0) goto L5c
                ay.d r12 = r11.f24421e     // Catch: java.lang.Throwable -> L5a
                long r0 = r12.m6322J()     // Catch: java.lang.Throwable -> L5a
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
                com.huawei.hms.drive.dd r12 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L5a
                com.huawei.hms.drive.da r5 = r12.f24408d     // Catch: java.lang.Throwable -> L5a
                int r6 = r12.f24407c     // Catch: java.lang.Throwable -> L5a
                ay.d r8 = r11.f24421e     // Catch: java.lang.Throwable -> L5a
                r5.m31533a(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5a
                com.huawei.hms.drive.dd r11 = com.huawei.hms.drive.C5255dd.this
                com.huawei.hms.drive.dd$c r11 = r11.f24411g
                r11.m31603a()
                return
            L71:
                com.huawei.hms.drive.dd r11 = com.huawei.hms.drive.C5255dd.this
                com.huawei.hms.drive.dd$c r11 = r11.f24411g
                r11.m31603a()
                throw r12
            L79:
                r11 = move-exception
                goto L83
            L7b:
                com.huawei.hms.drive.dd r11 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L79
                com.huawei.hms.drive.dd$c r11 = r11.f24411g     // Catch: java.lang.Throwable -> L79
                r11.m31603a()     // Catch: java.lang.Throwable -> L79
                throw r12     // Catch: java.lang.Throwable -> L79
            L83:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5255dd.a.m31599a(boolean):void");
        }

        @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f24417c && Thread.holdsLock(C5255dd.this)) {
                throw new AssertionError();
            }
            synchronized (C5255dd.this) {
                try {
                    if (this.f24418a) {
                        return;
                    }
                    if (!C5255dd.this.f24409e.f24419b) {
                        boolean z10 = this.f24421e.m6322J() > 0;
                        if (this.f24422f != null) {
                            while (this.f24421e.m6322J() > 0) {
                                m31599a(false);
                            }
                            C5255dd c5255dd = C5255dd.this;
                            c5255dd.f24408d.m31534a(c5255dd.f24407c, true, C5210bo.m31184a(this.f24422f));
                        } else if (z10) {
                            while (this.f24421e.m6322J() > 0) {
                                m31599a(true);
                            }
                        } else {
                            C5255dd c5255dd2 = C5255dd.this;
                            c5255dd2.f24408d.m31533a(c5255dd2.f24407c, true, (C1054d) null, 0L);
                        }
                    }
                    synchronized (C5255dd.this) {
                        this.f24418a = true;
                    }
                    C5255dd.this.f24408d.m31541b();
                    C5255dd.this.m31596i();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // p022ay.InterfaceC1074x, java.io.Flushable
        public void flush() throws IOException {
            if (!f24417c && Thread.holdsLock(C5255dd.this)) {
                throw new AssertionError();
            }
            synchronized (C5255dd.this) {
                C5255dd.this.m31597j();
            }
            while (this.f24421e.m6322J() > 0) {
                m31599a(false);
                C5255dd.this.f24408d.m31541b();
            }
        }

        @Override // p022ay.InterfaceC1074x
        public C1050a0 timeout() {
            return C5255dd.this.f24411g;
        }

        @Override // p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            if (!f24417c && Thread.holdsLock(C5255dd.this)) {
                throw new AssertionError();
            }
            this.f24421e.write(c1054d, j10);
            while (this.f24421e.m6322J() >= C6168y9.a.f29190f) {
                m31599a(false);
            }
        }
    }

    /* renamed from: com.huawei.hms.drive.dd$b */
    public final class b implements InterfaceC1076z {

        /* renamed from: c */
        static final /* synthetic */ boolean f24423c = true;

        /* renamed from: a */
        boolean f24424a;

        /* renamed from: b */
        boolean f24425b;

        /* renamed from: e */
        private final C1054d f24427e = new C1054d();

        /* renamed from: f */
        private final C1054d f24428f = new C1054d();

        /* renamed from: g */
        private final long f24429g;

        /* renamed from: h */
        private C5190aw f24430h;

        public b(long j10) {
            this.f24429g = j10;
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long jM6322J;
            synchronized (C5255dd.this) {
                this.f24424a = true;
                jM6322J = this.f24428f.m6322J();
                this.f24428f.m6352s();
                C5255dd.this.notifyAll();
            }
            if (jM6322J > 0) {
                m31601a(jM6322J);
            }
            C5255dd.this.m31596i();
        }

        /* JADX WARN: Removed duplicated region for block: B:97:0x0092  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0096  */
        @Override // p022ay.InterfaceC1076z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(p022ay.C1054d r12, long r13) throws java.lang.Throwable {
            /*
                r11 = this;
                r0 = 0
                int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r2 < 0) goto Lac
            L6:
                com.huawei.hms.drive.dd r2 = com.huawei.hms.drive.C5255dd.this
                monitor-enter(r2)
                com.huawei.hms.drive.dd r3 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.drive.dd$c r3 = r3.f24410f     // Catch: java.lang.Throwable -> L83
                r3.enter()     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.drive.dd r3 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.cw r4 = r3.f24412h     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L28
                java.io.IOException r3 = r3.f24413i     // Catch: java.lang.Throwable -> L25
                if (r3 == 0) goto L1b
                goto L29
            L1b:
                com.huawei.hms.drive.di r3 = new com.huawei.hms.drive.di     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.dd r4 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.cw r4 = r4.f24412h     // Catch: java.lang.Throwable -> L25
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
                goto L29
            L25:
                r12 = move-exception
                goto La2
            L28:
                r3 = 0
            L29:
                boolean r4 = r11.f24424a     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L9a
                ay.d r4 = r11.f24428f     // Catch: java.lang.Throwable -> L25
                long r4 = r4.m6322J()     // Catch: java.lang.Throwable -> L25
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                r5 = -1
                if (r4 <= 0) goto L6f
                ay.d r4 = r11.f24428f     // Catch: java.lang.Throwable -> L25
                long r7 = r4.m6322J()     // Catch: java.lang.Throwable -> L25
                long r13 = java.lang.Math.min(r13, r7)     // Catch: java.lang.Throwable -> L25
                long r12 = r4.read(r12, r13)     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.dd r14 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L25
                long r7 = r14.f24405a     // Catch: java.lang.Throwable -> L25
                long r7 = r7 + r12
                r14.f24405a = r7     // Catch: java.lang.Throwable -> L25
                if (r3 != 0) goto L86
                com.huawei.hms.drive.da r14 = r14.f24408d     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.dh r14 = r14.f24326j     // Catch: java.lang.Throwable -> L25
                int r14 = r14.m31638d()     // Catch: java.lang.Throwable -> L25
                int r14 = r14 / 2
                long r9 = (long) r14     // Catch: java.lang.Throwable -> L25
                int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r14 < 0) goto L86
                com.huawei.hms.drive.dd r14 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.da r4 = r14.f24408d     // Catch: java.lang.Throwable -> L25
                int r7 = r14.f24407c     // Catch: java.lang.Throwable -> L25
                long r8 = r14.f24405a     // Catch: java.lang.Throwable -> L25
                r4.m31528a(r7, r8)     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.dd r14 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L25
                r14.f24405a = r0     // Catch: java.lang.Throwable -> L25
                goto L86
            L6f:
                boolean r4 = r11.f24425b     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L85
                if (r3 != 0) goto L85
                com.huawei.hms.drive.dd r3 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L25
                r3.m31598k()     // Catch: java.lang.Throwable -> L25
                com.huawei.hms.drive.dd r3 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.drive.dd$c r3 = r3.f24410f     // Catch: java.lang.Throwable -> L83
                r3.m31603a()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                goto L6
            L83:
                r11 = move-exception
                goto Laa
            L85:
                r12 = r5
            L86:
                com.huawei.hms.drive.dd r14 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.drive.dd$c r14 = r14.f24410f     // Catch: java.lang.Throwable -> L83
                r14.m31603a()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r14 == 0) goto L96
                r11.m31601a(r12)
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
                com.huawei.hms.drive.dd r11 = com.huawei.hms.drive.C5255dd.this     // Catch: java.lang.Throwable -> L83
                com.huawei.hms.drive.dd$c r11 = r11.f24410f     // Catch: java.lang.Throwable -> L83
                r11.m31603a()     // Catch: java.lang.Throwable -> L83
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
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5255dd.b.read(ay.d, long):long");
        }

        @Override // p022ay.InterfaceC1076z
        public C1050a0 timeout() {
            return C5255dd.this.f24410f;
        }

        /* renamed from: a */
        private void m31601a(long j10) {
            if (!f24423c && Thread.holdsLock(C5255dd.this)) {
                throw new AssertionError();
            }
            C5255dd.this.f24408d.m31535a(j10);
        }

        /* renamed from: a */
        public void m31602a(InterfaceC1056f interfaceC1056f, long j10) throws IOException {
            boolean z10;
            boolean z11;
            long jM6322J;
            if (!f24423c && Thread.holdsLock(C5255dd.this)) {
                throw new AssertionError();
            }
            while (j10 > 0) {
                synchronized (C5255dd.this) {
                    z10 = this.f24425b;
                    z11 = this.f24428f.m6322J() + j10 > this.f24429g;
                }
                if (z11) {
                    interfaceC1056f.skip(j10);
                    C5255dd.this.m31586a(EnumC5246cw.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    interfaceC1056f.skip(j10);
                    return;
                }
                long j11 = interfaceC1056f.read(this.f24427e, j10);
                if (j11 != -1) {
                    j10 -= j11;
                    synchronized (C5255dd.this) {
                        try {
                            if (this.f24424a) {
                                jM6322J = this.f24427e.m6322J();
                                this.f24427e.m6352s();
                            } else {
                                boolean z12 = this.f24428f.m6322J() == 0;
                                this.f24428f.mo6328P(this.f24427e);
                                if (z12) {
                                    C5255dd.this.notifyAll();
                                }
                                jM6322J = 0;
                            }
                        } finally {
                        }
                    }
                    if (jM6322J > 0) {
                        m31601a(jM6322J);
                    }
                } else {
                    throw new EOFException();
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.drive.dd$c */
    public class c extends C1053c {
        public c() {
        }

        /* renamed from: a */
        public void m31603a() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // p022ay.C1053c
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p022ay.C1053c
        public void timedOut() {
            C5255dd.this.m31586a(EnumC5246cw.CANCEL);
            C5255dd.this.f24408d.m31547d();
        }
    }

    public C5255dd(int i10, C5252da c5252da, boolean z10, boolean z11, C5190aw c5190aw) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f24414k = arrayDeque;
        this.f24410f = new c();
        this.f24411g = new c();
        if (c5252da == null) {
            throw new NullPointerException("connection == null");
        }
        this.f24407c = i10;
        this.f24408d = c5252da;
        this.f24406b = c5252da.f24327k.m31638d();
        b bVar = new b(c5252da.f24326j.m31638d());
        this.f24416m = bVar;
        a aVar = new a();
        this.f24409e = aVar;
        bVar.f24425b = z11;
        aVar.f24419b = z10;
        if (c5190aw != null) {
            arrayDeque.add(c5190aw);
        }
        if (m31590c() && c5190aw != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!m31590c() && c5190aw == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    /* renamed from: a */
    public int m31582a() {
        return this.f24407c;
    }

    /* renamed from: b */
    public synchronized boolean m31589b() {
        try {
            if (this.f24412h != null) {
                return false;
            }
            b bVar = this.f24416m;
            if (bVar.f24425b || bVar.f24424a) {
                a aVar = this.f24409e;
                if (aVar.f24419b || aVar.f24418a) {
                    if (this.f24415l) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: c */
    public boolean m31590c() {
        return this.f24408d.f24317a == ((this.f24407c & 1) == 1);
    }

    /* renamed from: d */
    public synchronized C5190aw m31591d() throws IOException {
        this.f24410f.enter();
        while (this.f24414k.isEmpty() && this.f24412h == null) {
            try {
                m31598k();
            } catch (Throwable th2) {
                this.f24410f.m31603a();
                throw th2;
            }
        }
        this.f24410f.m31603a();
        if (this.f24414k.isEmpty()) {
            IOException iOException = this.f24413i;
            if (iOException != null) {
                throw iOException;
            }
            throw new C5260di(this.f24412h);
        }
        return this.f24414k.removeFirst();
    }

    /* renamed from: e */
    public C1050a0 m31592e() {
        return this.f24410f;
    }

    /* renamed from: f */
    public C1050a0 m31593f() {
        return this.f24411g;
    }

    /* renamed from: g */
    public InterfaceC1076z m31594g() {
        return this.f24416m;
    }

    /* renamed from: h */
    public InterfaceC1074x m31595h() {
        synchronized (this) {
            try {
                if (!this.f24415l && !m31590c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f24409e;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x002b  */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m31596i() throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = com.huawei.hms.drive.C5255dd.f24404j
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
            com.huawei.hms.drive.dd$b r0 = r2.f24416m     // Catch: java.lang.Throwable -> L27
            boolean r1 = r0.f24425b     // Catch: java.lang.Throwable -> L27
            if (r1 != 0) goto L2b
            boolean r0 = r0.f24424a     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L2b
            com.huawei.hms.drive.dd$a r0 = r2.f24409e     // Catch: java.lang.Throwable -> L27
            boolean r1 = r0.f24419b     // Catch: java.lang.Throwable -> L27
            if (r1 != 0) goto L29
            boolean r0 = r0.f24418a     // Catch: java.lang.Throwable -> L27
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
            boolean r1 = r2.m31589b()     // Catch: java.lang.Throwable -> L27
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L3a
            com.huawei.hms.drive.cw r0 = com.huawei.hms.drive.EnumC5246cw.CANCEL
            r1 = 0
            r2.m31587a(r0, r1)
            goto L43
        L3a:
            if (r1 != 0) goto L43
            com.huawei.hms.drive.da r0 = r2.f24408d
            int r2 = r2.f24407c
            r0.m31540b(r2)
        L43:
            return
        L44:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.drive.C5255dd.m31596i():void");
    }

    /* renamed from: j */
    public void m31597j() throws IOException {
        a aVar = this.f24409e;
        if (aVar.f24418a) {
            throw new IOException("stream closed");
        }
        if (aVar.f24419b) {
            throw new IOException("stream finished");
        }
        if (this.f24412h != null) {
            IOException iOException = this.f24413i;
            if (iOException == null) {
                throw new C5260di(this.f24412h);
            }
        }
    }

    /* renamed from: k */
    public void m31598k() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: a */
    public void m31587a(EnumC5246cw enumC5246cw, IOException iOException) throws IOException {
        if (m31581b(enumC5246cw, iOException)) {
            this.f24408d.m31542b(this.f24407c, enumC5246cw);
        }
    }

    /* renamed from: a */
    public void m31586a(EnumC5246cw enumC5246cw) {
        if (m31581b(enumC5246cw, null)) {
            this.f24408d.m31530a(this.f24407c, enumC5246cw);
        }
    }

    /* renamed from: b */
    private boolean m31581b(EnumC5246cw enumC5246cw, IOException iOException) {
        if (!f24404j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.f24412h != null) {
                    return false;
                }
                if (this.f24416m.f24425b && this.f24409e.f24419b) {
                    return false;
                }
                this.f24412h = enumC5246cw;
                this.f24413i = iOException;
                notifyAll();
                this.f24408d.m31540b(this.f24407c);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m31584a(InterfaceC1056f interfaceC1056f, int i10) throws IOException {
        if (!f24404j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f24416m.m31602a(interfaceC1056f, i10);
    }

    /* renamed from: a */
    public void m31585a(C5190aw c5190aw, boolean z10) {
        boolean zM31589b;
        if (!f24404j && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            try {
                if (this.f24415l && z10) {
                    this.f24416m.f24430h = c5190aw;
                } else {
                    this.f24415l = true;
                    this.f24414k.add(c5190aw);
                }
                if (z10) {
                    this.f24416m.f24425b = true;
                }
                zM31589b = m31589b();
                notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zM31589b) {
            return;
        }
        this.f24408d.m31540b(this.f24407c);
    }

    /* renamed from: b */
    public synchronized void m31588b(EnumC5246cw enumC5246cw) {
        if (this.f24412h == null) {
            this.f24412h = enumC5246cw;
            notifyAll();
        }
    }

    /* renamed from: a */
    public void m31583a(long j10) {
        this.f24406b += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }
}
