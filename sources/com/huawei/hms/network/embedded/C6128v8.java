package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C6117ua;
import com.huawei.hms.network.embedded.C6127v7;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;

/* renamed from: com.huawei.hms.network.embedded.v8 */
/* loaded from: classes8.dex */
public final class C6128v8 {

    /* renamed from: a */
    public final C5894d9 f28682a;

    /* renamed from: b */
    public final InterfaceC6100t6 f28683b;

    /* renamed from: c */
    public final AbstractC5932g7 f28684c;

    /* renamed from: d */
    public final C6141w8 f28685d;

    /* renamed from: e */
    public final InterfaceC5934g9 f28686e;

    /* renamed from: f */
    public boolean f28687f;

    /* renamed from: com.huawei.hms.network.embedded.v8$a */
    public final class a extends AbstractC5936gb {

        /* renamed from: b */
        public boolean f28688b;

        /* renamed from: c */
        public long f28689c;

        /* renamed from: d */
        public long f28690d;

        /* renamed from: e */
        public boolean f28691e;

        public a(InterfaceC6170yb interfaceC6170yb, long j10) {
            super(interfaceC6170yb);
            this.f28689c = j10;
        }

        /* renamed from: a */
        private IOException m35632a(IOException iOException) {
            if (this.f28688b) {
                return iOException;
            }
            this.f28688b = true;
            return C6128v8.this.m35615a(this.f28690d, false, true, iOException);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.f28691e) {
                return;
            }
            this.f28691e = true;
            long j10 = this.f28689c;
            if (j10 != -1 && this.f28690d != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m35632a(null);
            } catch (IOException e10) {
                throw m35632a(e10);
            }
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw m35632a(e10);
            }
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5936gb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            if (this.f28691e) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f28689c;
            if (j11 == -1 || this.f28690d + j10 <= j11) {
                try {
                    super.write(c5868bb, j10);
                    this.f28690d += j10;
                    return;
                } catch (IOException e10) {
                    throw m35632a(e10);
                }
            }
            throw new ProtocolException("expected " + this.f28689c + " bytes but received " + (this.f28690d + j10));
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.v8$b */
    public final class b extends AbstractC5949hb {

        /* renamed from: b */
        public final long f28693b;

        /* renamed from: c */
        public long f28694c;

        /* renamed from: d */
        public boolean f28695d;

        /* renamed from: e */
        public boolean f28696e;

        public b(InterfaceC6183zb interfaceC6183zb, long j10) {
            super(interfaceC6183zb);
            this.f28693b = j10;
            if (j10 == 0) {
                m35633a(null);
            }
        }

        /* renamed from: a */
        public IOException m35633a(IOException iOException) {
            if (this.f28695d) {
                return iOException;
            }
            this.f28695d = true;
            return C6128v8.this.m35615a(this.f28694c, true, false, iOException);
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5949hb, com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            if (this.f28696e) {
                return;
            }
            this.f28696e = true;
            try {
                super.close();
                m35633a(null);
            } catch (IOException e10) {
                throw m35633a(e10);
            }
        }

        @Override // com.huawei.hms.network.embedded.AbstractC5949hb, com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            if (this.f28696e) {
                throw new IllegalStateException("closed");
            }
            try {
                long j11 = m34374b().read(c5868bb, j10);
                if (j11 == -1) {
                    m35633a(null);
                    return -1L;
                }
                long j12 = this.f28694c + j11;
                long j13 = this.f28693b;
                if (j13 != -1 && j12 > j13) {
                    throw new ProtocolException("expected " + this.f28693b + " bytes but received " + j12);
                }
                this.f28694c = j12;
                if (j12 == j13) {
                    m35633a(null);
                }
                return j11;
            } catch (IOException e10) {
                throw m35633a(e10);
            }
        }
    }

    public C6128v8(C5894d9 c5894d9, InterfaceC6100t6 interfaceC6100t6, AbstractC5932g7 abstractC5932g7, C6141w8 c6141w8, InterfaceC5934g9 interfaceC5934g9) {
        this.f28682a = c5894d9;
        this.f28683b = interfaceC6100t6;
        this.f28684c = abstractC5932g7;
        this.f28685d = c6141w8;
        this.f28686e = interfaceC5934g9;
    }

    /* renamed from: a */
    public C6127v7.a m35612a(boolean z10) throws IOException {
        try {
            C6127v7.a aVarMo34316a = this.f28686e.mo34316a(z10);
            if (aVarMo34316a != null) {
                AbstractC5879c8.f26567a.mo34049a(aVarMo34316a, this);
            }
            return aVarMo34316a;
        } catch (IOException e10) {
            this.f28684c.responseFailed(this.f28683b, e10);
            m35618a(e10);
            throw e10;
        }
    }

    /* renamed from: b */
    public C6167y8 m35619b() {
        return this.f28686e.mo34317a();
    }

    /* renamed from: c */
    public void m35621c() {
        this.f28686e.cancel();
        this.f28682a.exchangeMessageDone(this, true, true, null);
    }

    /* renamed from: d */
    public void m35622d() throws IOException {
        try {
            this.f28686e.mo34322c();
        } catch (IOException e10) {
            this.f28684c.requestFailed(this.f28683b, e10);
            m35618a(e10);
            throw e10;
        }
    }

    /* renamed from: e */
    public void m35623e() throws IOException {
        try {
            this.f28686e.mo34323d();
        } catch (IOException e10) {
            this.f28684c.requestFailed(this.f28683b, e10);
            m35618a(e10);
            throw e10;
        }
    }

    /* renamed from: f */
    public boolean m35624f() {
        return this.f28687f;
    }

    /* renamed from: g */
    public C6117ua.f m35625g() throws SocketException {
        this.f28682a.timeoutEarlyExit();
        return this.f28686e.mo34317a().m35853a(this);
    }

    /* renamed from: h */
    public void m35626h() {
        this.f28686e.mo34317a().m35864h();
    }

    /* renamed from: i */
    public void m35627i() {
        this.f28682a.exchangeMessageDone(this, true, false, null);
    }

    /* renamed from: j */
    public void m35628j() {
        this.f28684c.responseHeadersStart(this.f28683b);
    }

    /* renamed from: k */
    public void m35629k() {
        this.f28682a.timeoutEarlyExit();
    }

    /* renamed from: l */
    public C5971j7 m35630l() throws IOException {
        return this.f28686e.mo34320b();
    }

    /* renamed from: m */
    public void m35631m() {
        m35615a(-1L, true, true, null);
    }

    /* renamed from: a */
    public AbstractC6140w7 m35613a(C6127v7 c6127v7) throws IOException {
        try {
            this.f28684c.responseBodyStart(this.f28683b);
            String strM35582b = c6127v7.m35582b("Content-Type");
            long jMo34315a = this.f28686e.mo34315a(c6127v7);
            return new C5999l9(strM35582b, jMo34315a, C6040ob.m34934a(new b(this.f28686e.mo34321b(c6127v7), jMo34315a)));
        } catch (IOException e10) {
            this.f28684c.responseFailed(this.f28683b, e10);
            m35618a(e10);
            throw e10;
        }
    }

    /* renamed from: b */
    public void m35620b(C6127v7 c6127v7) {
        this.f28684c.responseHeadersEnd(this.f28683b, c6127v7);
    }

    /* renamed from: a */
    public InterfaceC6170yb m35614a(C6101t7 c6101t7, boolean z10) throws IOException {
        this.f28687f = z10;
        long jContentLength = c6101t7.m35413b().contentLength();
        this.f28684c.requestBodyStart(this.f28683b);
        return new a(this.f28686e.mo34318a(c6101t7, jContentLength), jContentLength);
    }

    /* renamed from: a */
    public IOException m35615a(long j10, boolean z10, boolean z11, IOException iOException) {
        if (iOException != null) {
            m35618a(iOException);
        }
        if (z11) {
            AbstractC5932g7 abstractC5932g7 = this.f28684c;
            InterfaceC6100t6 interfaceC6100t6 = this.f28683b;
            if (iOException != null) {
                abstractC5932g7.requestFailed(interfaceC6100t6, iOException);
            } else {
                abstractC5932g7.requestBodyEnd(interfaceC6100t6, j10);
            }
        }
        if (z10) {
            if (iOException != null) {
                this.f28684c.responseFailed(this.f28683b, iOException);
            } else {
                this.f28684c.responseBodyEnd(this.f28683b, j10);
            }
        }
        return this.f28682a.exchangeMessageDone(this, z11, z10, iOException);
    }

    /* renamed from: a */
    public void m35616a() {
        this.f28686e.cancel();
    }

    /* renamed from: a */
    public void m35617a(C6101t7 c6101t7) throws IOException {
        try {
            this.f28684c.requestHeadersStart(this.f28683b);
            this.f28686e.mo34319a(c6101t7);
            this.f28684c.requestHeadersEnd(this.f28683b, c6101t7);
        } catch (IOException e10) {
            this.f28684c.requestFailed(this.f28683b, e10);
            m35618a(e10);
            throw e10;
        }
    }

    /* renamed from: a */
    public void m35618a(IOException iOException) {
        this.f28685d.m35749e();
        this.f28686e.mo34317a().m35856a(iOException);
    }
}
