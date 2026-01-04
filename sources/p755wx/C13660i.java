package p755wx;

import com.huawei.hms.network.embedded.C6168y9;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import okhttp3.C11955v;
import p022ay.C1050a0;
import p022ay.C1053c;
import p022ay.C1054d;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;
import sx.C12875e;

/* renamed from: wx.i */
/* loaded from: classes9.dex */
public final class C13660i {

    /* renamed from: a */
    public long f61499a = 0;

    /* renamed from: b */
    public long f61500b;

    /* renamed from: c */
    public final int f61501c;

    /* renamed from: d */
    public final C13657f f61502d;

    /* renamed from: e */
    public final Deque<C11955v> f61503e;

    /* renamed from: f */
    public boolean f61504f;

    /* renamed from: g */
    public final b f61505g;

    /* renamed from: h */
    public final a f61506h;

    /* renamed from: i */
    public final c f61507i;

    /* renamed from: j */
    public final c f61508j;

    /* renamed from: k */
    public EnumC13653b f61509k;

    /* renamed from: l */
    public IOException f61510l;

    /* renamed from: wx.i$a */
    public final class a implements InterfaceC1074x {

        /* renamed from: a */
        public final C1054d f61511a = new C1054d();

        /* renamed from: b */
        public C11955v f61512b;

        /* renamed from: c */
        public boolean f61513c;

        /* renamed from: d */
        public boolean f61514d;

        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:75:0x005c  */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m82159b(boolean r12) throws java.io.IOException {
            /*
                r11 = this;
                wx.i r0 = p755wx.C13660i.this
                monitor-enter(r0)
                wx.i r1 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L79
                wx.i$c r1 = r1.f61508j     // Catch: java.lang.Throwable -> L79
                r1.enter()     // Catch: java.lang.Throwable -> L79
            La:
                wx.i r1 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L24
                long r2 = r1.f61500b     // Catch: java.lang.Throwable -> L24
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 > 0) goto L26
                boolean r2 = r11.f61514d     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                boolean r2 = r11.f61513c     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                wx.b r2 = r1.f61509k     // Catch: java.lang.Throwable -> L24
                if (r2 != 0) goto L26
                r1.m82157q()     // Catch: java.lang.Throwable -> L24
                goto La
            L24:
                r12 = move-exception
                goto L7b
            L26:
                wx.i$c r1 = r1.f61508j     // Catch: java.lang.Throwable -> L79
                r1.m82163b()     // Catch: java.lang.Throwable -> L79
                wx.i r1 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L79
                r1.m82143c()     // Catch: java.lang.Throwable -> L79
                wx.i r1 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L79
                long r1 = r1.f61500b     // Catch: java.lang.Throwable -> L79
                ay.d r3 = r11.f61511a     // Catch: java.lang.Throwable -> L79
                long r3 = r3.m6322J()     // Catch: java.lang.Throwable -> L79
                long r9 = java.lang.Math.min(r1, r3)     // Catch: java.lang.Throwable -> L79
                wx.i r1 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L79
                long r2 = r1.f61500b     // Catch: java.lang.Throwable -> L79
                long r2 = r2 - r9
                r1.f61500b = r2     // Catch: java.lang.Throwable -> L79
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                wx.i$c r0 = r1.f61508j
                r0.enter()
                if (r12 == 0) goto L5c
                ay.d r12 = r11.f61511a     // Catch: java.lang.Throwable -> L5a
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
                wx.i r12 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L5a
                wx.f r5 = r12.f61502d     // Catch: java.lang.Throwable -> L5a
                int r6 = r12.f61501c     // Catch: java.lang.Throwable -> L5a
                ay.d r8 = r11.f61511a     // Catch: java.lang.Throwable -> L5a
                r5.m82098b0(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L5a
                wx.i r11 = p755wx.C13660i.this
                wx.i$c r11 = r11.f61508j
                r11.m82163b()
                return
            L71:
                wx.i r11 = p755wx.C13660i.this
                wx.i$c r11 = r11.f61508j
                r11.m82163b()
                throw r12
            L79:
                r11 = move-exception
                goto L83
            L7b:
                wx.i r11 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L79
                wx.i$c r11 = r11.f61508j     // Catch: java.lang.Throwable -> L79
                r11.m82163b()     // Catch: java.lang.Throwable -> L79
                throw r12     // Catch: java.lang.Throwable -> L79
            L83:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: p755wx.C13660i.a.m82159b(boolean):void");
        }

        @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (C13660i.this) {
                try {
                    if (this.f61513c) {
                        return;
                    }
                    if (!C13660i.this.f61506h.f61514d) {
                        boolean z10 = this.f61511a.m6322J() > 0;
                        if (this.f61512b != null) {
                            while (this.f61511a.m6322J() > 0) {
                                m82159b(false);
                            }
                            C13660i c13660i = C13660i.this;
                            c13660i.f61502d.m82099c0(c13660i.f61501c, true, C12875e.m77240K(this.f61512b));
                        } else if (z10) {
                            while (this.f61511a.m6322J() > 0) {
                                m82159b(true);
                            }
                        } else {
                            C13660i c13660i2 = C13660i.this;
                            c13660i2.f61502d.m82098b0(c13660i2.f61501c, true, null, 0L);
                        }
                    }
                    synchronized (C13660i.this) {
                        this.f61513c = true;
                    }
                    C13660i.this.f61502d.flush();
                    C13660i.this.m82142b();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // p022ay.InterfaceC1074x, java.io.Flushable
        public void flush() throws IOException {
            synchronized (C13660i.this) {
                C13660i.this.m82143c();
            }
            while (this.f61511a.m6322J() > 0) {
                m82159b(false);
                C13660i.this.f61502d.flush();
            }
        }

        @Override // p022ay.InterfaceC1074x
        public C1050a0 timeout() {
            return C13660i.this.f61508j;
        }

        @Override // p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            this.f61511a.write(c1054d, j10);
            while (this.f61511a.m6322J() >= C6168y9.a.f29190f) {
                m82159b(false);
            }
        }
    }

    /* renamed from: wx.i$b */
    public final class b implements InterfaceC1076z {

        /* renamed from: a */
        public final C1054d f61516a = new C1054d();

        /* renamed from: b */
        public final C1054d f61517b = new C1054d();

        /* renamed from: c */
        public final long f61518c;

        /* renamed from: d */
        public C11955v f61519d;

        /* renamed from: e */
        public boolean f61520e;

        /* renamed from: f */
        public boolean f61521f;

        public b(long j10) {
            this.f61518c = j10;
        }

        /* renamed from: c */
        public void m82161c(InterfaceC1056f interfaceC1056f, long j10) throws IOException {
            boolean z10;
            boolean z11;
            long jM6322J;
            while (j10 > 0) {
                synchronized (C13660i.this) {
                    z10 = this.f61521f;
                    z11 = this.f61517b.m6322J() + j10 > this.f61518c;
                }
                if (z11) {
                    interfaceC1056f.skip(j10);
                    C13660i.this.m82146f(EnumC13653b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z10) {
                    interfaceC1056f.skip(j10);
                    return;
                }
                long j11 = interfaceC1056f.read(this.f61516a, j10);
                if (j11 == -1) {
                    throw new EOFException();
                }
                j10 -= j11;
                synchronized (C13660i.this) {
                    try {
                        if (this.f61520e) {
                            jM6322J = this.f61516a.m6322J();
                            this.f61516a.m6352s();
                        } else {
                            boolean z12 = this.f61517b.m6322J() == 0;
                            this.f61517b.mo6328P(this.f61516a);
                            if (z12) {
                                C13660i.this.notifyAll();
                            }
                            jM6322J = 0;
                        }
                    } finally {
                    }
                }
                if (jM6322J > 0) {
                    m82162j(jM6322J);
                }
            }
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long jM6322J;
            synchronized (C13660i.this) {
                this.f61520e = true;
                jM6322J = this.f61517b.m6322J();
                this.f61517b.m6352s();
                C13660i.this.notifyAll();
            }
            if (jM6322J > 0) {
                m82162j(jM6322J);
            }
            C13660i.this.m82142b();
        }

        /* renamed from: j */
        public final void m82162j(long j10) {
            C13660i.this.f61502d.m82097a0(j10);
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
                wx.i r2 = p755wx.C13660i.this
                monitor-enter(r2)
                wx.i r3 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L83
                wx.i$c r3 = r3.f61507i     // Catch: java.lang.Throwable -> L83
                r3.enter()     // Catch: java.lang.Throwable -> L83
                wx.i r3 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L25
                wx.b r4 = r3.f61509k     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L28
                java.io.IOException r3 = r3.f61510l     // Catch: java.lang.Throwable -> L25
                if (r3 == 0) goto L1b
                goto L29
            L1b:
                wx.n r3 = new wx.n     // Catch: java.lang.Throwable -> L25
                wx.i r4 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L25
                wx.b r4 = r4.f61509k     // Catch: java.lang.Throwable -> L25
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
                goto L29
            L25:
                r12 = move-exception
                goto La2
            L28:
                r3 = 0
            L29:
                boolean r4 = r11.f61520e     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L9a
                ay.d r4 = r11.f61517b     // Catch: java.lang.Throwable -> L25
                long r4 = r4.m6322J()     // Catch: java.lang.Throwable -> L25
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                r5 = -1
                if (r4 <= 0) goto L6f
                ay.d r4 = r11.f61517b     // Catch: java.lang.Throwable -> L25
                long r7 = r4.m6322J()     // Catch: java.lang.Throwable -> L25
                long r13 = java.lang.Math.min(r13, r7)     // Catch: java.lang.Throwable -> L25
                long r12 = r4.read(r12, r13)     // Catch: java.lang.Throwable -> L25
                wx.i r14 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L25
                long r7 = r14.f61499a     // Catch: java.lang.Throwable -> L25
                long r7 = r7 + r12
                r14.f61499a = r7     // Catch: java.lang.Throwable -> L25
                if (r3 != 0) goto L86
                wx.f r14 = r14.f61502d     // Catch: java.lang.Throwable -> L25
                wx.m r14 = r14.f61430t     // Catch: java.lang.Throwable -> L25
                int r14 = r14.m82192d()     // Catch: java.lang.Throwable -> L25
                int r14 = r14 / 2
                long r9 = (long) r14     // Catch: java.lang.Throwable -> L25
                int r14 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r14 < 0) goto L86
                wx.i r14 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L25
                wx.f r4 = r14.f61502d     // Catch: java.lang.Throwable -> L25
                int r7 = r14.f61501c     // Catch: java.lang.Throwable -> L25
                long r8 = r14.f61499a     // Catch: java.lang.Throwable -> L25
                r4.m82103m0(r7, r8)     // Catch: java.lang.Throwable -> L25
                wx.i r14 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L25
                r14.f61499a = r0     // Catch: java.lang.Throwable -> L25
                goto L86
            L6f:
                boolean r4 = r11.f61521f     // Catch: java.lang.Throwable -> L25
                if (r4 != 0) goto L85
                if (r3 != 0) goto L85
                wx.i r3 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L25
                r3.m82157q()     // Catch: java.lang.Throwable -> L25
                wx.i r3 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L83
                wx.i$c r3 = r3.f61507i     // Catch: java.lang.Throwable -> L83
                r3.m82163b()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                goto L6
            L83:
                r11 = move-exception
                goto Laa
            L85:
                r12 = r5
            L86:
                wx.i r14 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L83
                wx.i$c r14 = r14.f61507i     // Catch: java.lang.Throwable -> L83
                r14.m82163b()     // Catch: java.lang.Throwable -> L83
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L83
                int r14 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r14 == 0) goto L96
                r11.m82162j(r12)
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
                wx.i r11 = p755wx.C13660i.this     // Catch: java.lang.Throwable -> L83
                wx.i$c r11 = r11.f61507i     // Catch: java.lang.Throwable -> L83
                r11.m82163b()     // Catch: java.lang.Throwable -> L83
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
            throw new UnsupportedOperationException("Method not decompiled: p755wx.C13660i.b.read(ay.d, long):long");
        }

        @Override // p022ay.InterfaceC1076z
        public C1050a0 timeout() {
            return C13660i.this.f61507i;
        }
    }

    /* renamed from: wx.i$c */
    public class c extends C1053c {
        public c() {
        }

        /* renamed from: b */
        public void m82163b() throws IOException {
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
            C13660i.this.m82146f(EnumC13653b.CANCEL);
            C13660i.this.f61502d.m82093V();
        }
    }

    public C13660i(int i10, C13657f c13657f, boolean z10, boolean z11, C11955v c11955v) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f61503e = arrayDeque;
        this.f61507i = new c();
        this.f61508j = new c();
        if (c13657f == null) {
            throw new NullPointerException("connection == null");
        }
        this.f61501c = i10;
        this.f61502d = c13657f;
        this.f61500b = c13657f.f61431u.m82192d();
        b bVar = new b(c13657f.f61430t.m82192d());
        this.f61505g = bVar;
        a aVar = new a();
        this.f61506h = aVar;
        bVar.f61521f = z11;
        aVar.f61514d = z10;
        if (c11955v != null) {
            arrayDeque.add(c11955v);
        }
        if (m82150j() && c11955v != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!m82150j() && c11955v == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    /* renamed from: a */
    public void m82141a(long j10) {
        this.f61500b += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x001a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m82142b() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            wx.i$b r0 = r2.f61505g     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.f61521f     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L1a
            boolean r0 = r0.f61520e     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            wx.i$a r0 = r2.f61506h     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.f61514d     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L18
            boolean r0 = r0.f61513c     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            goto L18
        L16:
            r0 = move-exception
            goto L33
        L18:
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            boolean r1 = r2.m82151k()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L29
            wx.b r0 = p755wx.EnumC13653b.CANCEL
            r1 = 0
            r2.m82144d(r0, r1)
            goto L32
        L29:
            if (r1 != 0) goto L32
            wx.f r0 = r2.f61502d
            int r2 = r2.f61501c
            r0.m82092J(r2)
        L32:
            return
        L33:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p755wx.C13660i.m82142b():void");
    }

    /* renamed from: c */
    public void m82143c() throws IOException {
        a aVar = this.f61506h;
        if (aVar.f61513c) {
            throw new IOException("stream closed");
        }
        if (aVar.f61514d) {
            throw new IOException("stream finished");
        }
        if (this.f61509k != null) {
            IOException iOException = this.f61510l;
            if (iOException == null) {
                throw new C13665n(this.f61509k);
            }
        }
    }

    /* renamed from: d */
    public void m82144d(EnumC13653b enumC13653b, IOException iOException) throws IOException {
        if (m82145e(enumC13653b, iOException)) {
            this.f61502d.m82101i0(this.f61501c, enumC13653b);
        }
    }

    /* renamed from: e */
    public final boolean m82145e(EnumC13653b enumC13653b, IOException iOException) {
        synchronized (this) {
            try {
                if (this.f61509k != null) {
                    return false;
                }
                if (this.f61505g.f61521f && this.f61506h.f61514d) {
                    return false;
                }
                this.f61509k = enumC13653b;
                this.f61510l = iOException;
                notifyAll();
                this.f61502d.m82092J(this.f61501c);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: f */
    public void m82146f(EnumC13653b enumC13653b) {
        if (m82145e(enumC13653b, null)) {
            this.f61502d.m82102j0(this.f61501c, enumC13653b);
        }
    }

    /* renamed from: g */
    public int m82147g() {
        return this.f61501c;
    }

    /* renamed from: h */
    public InterfaceC1074x m82148h() {
        synchronized (this) {
            try {
                if (!this.f61504f && !m82150j()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f61506h;
    }

    /* renamed from: i */
    public InterfaceC1076z m82149i() {
        return this.f61505g;
    }

    /* renamed from: j */
    public boolean m82150j() {
        return this.f61502d.f61411a == ((this.f61501c & 1) == 1);
    }

    /* renamed from: k */
    public synchronized boolean m82151k() {
        try {
            if (this.f61509k != null) {
                return false;
            }
            b bVar = this.f61505g;
            if (bVar.f61521f || bVar.f61520e) {
                a aVar = this.f61506h;
                if (aVar.f61514d || aVar.f61513c) {
                    if (this.f61504f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: l */
    public C1050a0 m82152l() {
        return this.f61507i;
    }

    /* renamed from: m */
    public void m82153m(InterfaceC1056f interfaceC1056f, int i10) throws IOException {
        this.f61505g.m82161c(interfaceC1056f, i10);
    }

    /* renamed from: n */
    public void m82154n(C11955v c11955v, boolean z10) {
        boolean zM82151k;
        synchronized (this) {
            try {
                if (this.f61504f && z10) {
                    this.f61505g.f61519d = c11955v;
                } else {
                    this.f61504f = true;
                    this.f61503e.add(c11955v);
                }
                if (z10) {
                    this.f61505g.f61521f = true;
                }
                zM82151k = m82151k();
                notifyAll();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (zM82151k) {
            return;
        }
        this.f61502d.m82092J(this.f61501c);
    }

    /* renamed from: o */
    public synchronized void m82155o(EnumC13653b enumC13653b) {
        if (this.f61509k == null) {
            this.f61509k = enumC13653b;
            notifyAll();
        }
    }

    /* renamed from: p */
    public synchronized C11955v m82156p() throws IOException {
        this.f61507i.enter();
        while (this.f61503e.isEmpty() && this.f61509k == null) {
            try {
                m82157q();
            } catch (Throwable th2) {
                this.f61507i.m82163b();
                throw th2;
            }
        }
        this.f61507i.m82163b();
        if (this.f61503e.isEmpty()) {
            IOException iOException = this.f61510l;
            if (iOException != null) {
                throw iOException;
            }
            throw new C13665n(this.f61509k);
        }
        return this.f61503e.removeFirst();
    }

    /* renamed from: q */
    public void m82157q() throws InterruptedException, InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: r */
    public C1050a0 m82158r() {
        return this.f61508j;
    }
}
