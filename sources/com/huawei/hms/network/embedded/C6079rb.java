package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.rb */
/* loaded from: classes8.dex */
public final class C6079rb {

    /* renamed from: a */
    public final long f28129a;

    /* renamed from: c */
    public boolean f28131c;

    /* renamed from: d */
    public boolean f28132d;

    /* renamed from: g */
    public InterfaceC6170yb f28135g;

    /* renamed from: b */
    public final C5868bb f28130b = new C5868bb();

    /* renamed from: e */
    public final InterfaceC6170yb f28133e = new a();

    /* renamed from: f */
    public final InterfaceC6183zb f28134f = new b();

    /* renamed from: com.huawei.hms.network.embedded.rb$a */
    public final class a implements InterfaceC6170yb {

        /* renamed from: a */
        public final C6092sb f28136a = new C6092sb();

        public a() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            InterfaceC6170yb interfaceC6170yb;
            synchronized (C6079rb.this.f28130b) {
                try {
                    C6079rb c6079rb = C6079rb.this;
                    if (c6079rb.f28131c) {
                        return;
                    }
                    if (c6079rb.f28135g != null) {
                        interfaceC6170yb = C6079rb.this.f28135g;
                    } else {
                        C6079rb c6079rb2 = C6079rb.this;
                        if (c6079rb2.f28132d && c6079rb2.f28130b.m33913B() > 0) {
                            throw new IOException("source is closed");
                        }
                        C6079rb c6079rb3 = C6079rb.this;
                        c6079rb3.f28131c = true;
                        c6079rb3.f28130b.notifyAll();
                        interfaceC6170yb = null;
                    }
                    if (interfaceC6170yb != null) {
                        this.f28136a.m35311a(interfaceC6170yb.timeout());
                        try {
                            interfaceC6170yb.close();
                        } finally {
                            this.f28136a.m35312f();
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
            InterfaceC6170yb interfaceC6170yb;
            synchronized (C6079rb.this.f28130b) {
                try {
                    C6079rb c6079rb = C6079rb.this;
                    if (c6079rb.f28131c) {
                        throw new IllegalStateException("closed");
                    }
                    if (c6079rb.f28135g != null) {
                        interfaceC6170yb = C6079rb.this.f28135g;
                    } else {
                        C6079rb c6079rb2 = C6079rb.this;
                        if (c6079rb2.f28132d && c6079rb2.f28130b.m33913B() > 0) {
                            throw new IOException("source is closed");
                        }
                        interfaceC6170yb = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (interfaceC6170yb != null) {
                this.f28136a.m35311a(interfaceC6170yb.timeout());
                try {
                    interfaceC6170yb.flush();
                } finally {
                    this.f28136a.m35312f();
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f28136a;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            InterfaceC6170yb interfaceC6170yb;
            synchronized (C6079rb.this.f28130b) {
                try {
                    if (!C6079rb.this.f28131c) {
                        while (true) {
                            if (j10 <= 0) {
                                interfaceC6170yb = null;
                                break;
                            }
                            if (C6079rb.this.f28135g != null) {
                                interfaceC6170yb = C6079rb.this.f28135g;
                                break;
                            }
                            C6079rb c6079rb = C6079rb.this;
                            if (c6079rb.f28132d) {
                                throw new IOException("source is closed");
                            }
                            long jM33913B = c6079rb.f28129a - c6079rb.f28130b.m33913B();
                            if (jM33913B == 0) {
                                this.f28136a.m33843a(C6079rb.this.f28130b);
                            } else {
                                long jMin = Math.min(jM33913B, j10);
                                C6079rb.this.f28130b.write(c5868bb, jMin);
                                j10 -= jMin;
                                C6079rb.this.f28130b.notifyAll();
                            }
                        }
                    } else {
                        throw new IllegalStateException("closed");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (interfaceC6170yb != null) {
                this.f28136a.m35311a(interfaceC6170yb.timeout());
                try {
                    interfaceC6170yb.write(c5868bb, j10);
                } finally {
                    this.f28136a.m35312f();
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.rb$b */
    public final class b implements InterfaceC6183zb {

        /* renamed from: a */
        public final C5855ac f28138a = new C5855ac();

        public b() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            synchronized (C6079rb.this.f28130b) {
                C6079rb c6079rb = C6079rb.this;
                c6079rb.f28132d = true;
                c6079rb.f28130b.notifyAll();
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            synchronized (C6079rb.this.f28130b) {
                try {
                    if (C6079rb.this.f28132d) {
                        throw new IllegalStateException("closed");
                    }
                    while (C6079rb.this.f28130b.m33913B() == 0) {
                        C6079rb c6079rb = C6079rb.this;
                        if (c6079rb.f28131c) {
                            return -1L;
                        }
                        this.f28138a.m33843a(c6079rb.f28130b);
                    }
                    long j11 = C6079rb.this.f28130b.read(c5868bb, j10);
                    C6079rb.this.f28130b.notifyAll();
                    return j11;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f28138a;
        }
    }

    public C6079rb(long j10) {
        if (j10 >= 1) {
            this.f28129a = j10;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j10);
    }

    /* renamed from: a */
    public final InterfaceC6170yb m35240a() {
        return this.f28133e;
    }

    /* renamed from: b */
    public final InterfaceC6183zb m35242b() {
        return this.f28134f;
    }

    /* renamed from: a */
    public void m35241a(InterfaceC6170yb interfaceC6170yb) throws IOException {
        boolean z10;
        C5868bb c5868bb;
        while (true) {
            synchronized (this.f28130b) {
                try {
                    if (this.f28135g != null) {
                        throw new IllegalStateException("sink already folded");
                    }
                    if (this.f28130b.mo33971i()) {
                        this.f28132d = true;
                        this.f28135g = interfaceC6170yb;
                        return;
                    } else {
                        z10 = this.f28131c;
                        c5868bb = new C5868bb();
                        C5868bb c5868bb2 = this.f28130b;
                        c5868bb.write(c5868bb2, c5868bb2.f26524b);
                        this.f28130b.notifyAll();
                    }
                } finally {
                }
            }
            try {
                interfaceC6170yb.write(c5868bb, c5868bb.f26524b);
                if (z10) {
                    interfaceC6170yb.close();
                } else {
                    interfaceC6170yb.flush();
                }
            } catch (Throwable th2) {
                synchronized (this.f28130b) {
                    this.f28132d = true;
                    this.f28130b.notifyAll();
                    throw th2;
                }
            }
        }
    }
}
