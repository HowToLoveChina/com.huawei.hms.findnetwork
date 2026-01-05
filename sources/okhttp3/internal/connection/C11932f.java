package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.AbstractC11924h0;
import okhttp3.AbstractC11953t;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.InterfaceC11919f;
import p022ay.AbstractC1058h;
import p022ay.AbstractC1059i;
import p022ay.C1054d;
import p022ay.C1064n;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;
import p693ux.C13283h;
import p693ux.InterfaceC13278c;
import sx.AbstractC12871a;

/* renamed from: okhttp3.internal.connection.f */
/* loaded from: classes9.dex */
public final class C11932f {

    /* renamed from: a */
    public final C11941o f55379a;

    /* renamed from: b */
    public final InterfaceC11919f f55380b;

    /* renamed from: c */
    public final AbstractC11953t f55381c;

    /* renamed from: d */
    public final C11933g f55382d;

    /* renamed from: e */
    public final InterfaceC13278c f55383e;

    /* renamed from: f */
    public boolean f55384f;

    /* renamed from: okhttp3.internal.connection.f$a */
    public final class a extends AbstractC1058h {

        /* renamed from: f */
        public boolean f55385f;

        /* renamed from: g */
        public long f55386g;

        /* renamed from: h */
        public long f55387h;

        /* renamed from: i */
        public boolean f55388i;

        public a(InterfaceC1074x interfaceC1074x, long j10) {
            super(interfaceC1074x);
            this.f55386g = j10;
        }

        /* renamed from: b */
        private IOException m71697b(IOException iOException) {
            if (this.f55385f) {
                return iOException;
            }
            this.f55385f = true;
            return C11932f.this.m71681a(this.f55387h, false, true, iOException);
        }

        @Override // p022ay.AbstractC1058h, p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f55388i) {
                return;
            }
            this.f55388i = true;
            long j10 = this.f55386g;
            if (j10 != -1 && this.f55387h != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m71697b(null);
            } catch (IOException e10) {
                throw m71697b(e10);
            }
        }

        @Override // p022ay.AbstractC1058h, p022ay.InterfaceC1074x, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw m71697b(e10);
            }
        }

        @Override // p022ay.AbstractC1058h, p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            if (this.f55388i) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f55386g;
            if (j11 == -1 || this.f55387h + j10 <= j11) {
                try {
                    super.write(c1054d, j10);
                    this.f55387h += j10;
                    return;
                } catch (IOException e10) {
                    throw m71697b(e10);
                }
            }
            throw new ProtocolException("expected " + this.f55386g + " bytes but received " + (this.f55387h + j10));
        }
    }

    /* renamed from: okhttp3.internal.connection.f$b */
    public final class b extends AbstractC1059i {

        /* renamed from: f */
        public final long f55390f;

        /* renamed from: g */
        public long f55391g;

        /* renamed from: h */
        public boolean f55392h;

        /* renamed from: i */
        public boolean f55393i;

        public b(InterfaceC1076z interfaceC1076z, long j10) {
            super(interfaceC1076z);
            this.f55390f = j10;
            if (j10 == 0) {
                m71698b(null);
            }
        }

        /* renamed from: b */
        public IOException m71698b(IOException iOException) {
            if (this.f55392h) {
                return iOException;
            }
            this.f55392h = true;
            return C11932f.this.m71681a(this.f55391g, true, false, iOException);
        }

        @Override // p022ay.AbstractC1059i, p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f55393i) {
                return;
            }
            this.f55393i = true;
            try {
                super.close();
                m71698b(null);
            } catch (IOException e10) {
                throw m71698b(e10);
            }
        }

        @Override // p022ay.AbstractC1059i, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (this.f55393i) {
                throw new IllegalStateException("closed");
            }
            try {
                long j11 = delegate().read(c1054d, j10);
                if (j11 == -1) {
                    m71698b(null);
                    return -1L;
                }
                long j12 = this.f55391g + j11;
                long j13 = this.f55390f;
                if (j13 != -1 && j12 > j13) {
                    throw new ProtocolException("expected " + this.f55390f + " bytes but received " + j12);
                }
                this.f55391g = j12;
                if (j12 == j13) {
                    m71698b(null);
                }
                return j11;
            } catch (IOException e10) {
                throw m71698b(e10);
            }
        }
    }

    public C11932f(C11941o c11941o, InterfaceC11919f interfaceC11919f, AbstractC11953t abstractC11953t, C11933g c11933g, InterfaceC13278c interfaceC13278c) {
        this.f55379a = c11941o;
        this.f55380b = interfaceC11919f;
        this.f55381c = abstractC11953t;
        this.f55382d = c11933g;
        this.f55383e = interfaceC13278c;
    }

    /* renamed from: a */
    public IOException m71681a(long j10, boolean z10, boolean z11, IOException iOException) {
        if (iOException != null) {
            m71695o(iOException);
        }
        if (z11) {
            if (iOException != null) {
                this.f55381c.requestFailed(this.f55380b, iOException);
            } else {
                this.f55381c.requestBodyEnd(this.f55380b, j10);
            }
        }
        if (z10) {
            if (iOException != null) {
                this.f55381c.responseFailed(this.f55380b, iOException);
            } else {
                this.f55381c.responseBodyEnd(this.f55380b, j10);
            }
        }
        return this.f55379a.exchangeMessageDone(this, z11, z10, iOException);
    }

    /* renamed from: b */
    public void m71682b() {
        this.f55383e.cancel();
    }

    /* renamed from: c */
    public C11935i m71683c() {
        return this.f55383e.mo79705e();
    }

    /* renamed from: d */
    public InterfaceC1074x m71684d(HttpRequestBuilder HttpRequestBuilder, boolean z10) throws IOException {
        this.f55384f = z10;
        long jContentLength = HttpRequestBuilder.m71562b().contentLength();
        this.f55381c.requestBodyStart(this.f55380b);
        return new a(this.f55383e.mo79708h(HttpRequestBuilder, jContentLength), jContentLength);
    }

    /* renamed from: e */
    public void m71685e() {
        this.f55383e.cancel();
        this.f55379a.exchangeMessageDone(this, true, true, null);
    }

    /* renamed from: f */
    public void m71686f() throws IOException {
        try {
            this.f55383e.mo79701a();
        } catch (IOException e10) {
            this.f55381c.requestFailed(this.f55380b, e10);
            m71695o(e10);
            throw e10;
        }
    }

    /* renamed from: g */
    public void m71687g() throws IOException {
        try {
            this.f55383e.mo79706f();
        } catch (IOException e10) {
            this.f55381c.requestFailed(this.f55380b, e10);
            m71695o(e10);
            throw e10;
        }
    }

    /* renamed from: h */
    public boolean m71688h() {
        return this.f55384f;
    }

    /* renamed from: i */
    public void m71689i() {
        this.f55383e.mo79705e().m71726r();
    }

    /* renamed from: j */
    public void m71690j() {
        this.f55379a.exchangeMessageDone(this, true, false, null);
    }

    /* renamed from: k */
    public AbstractC11924h0 m71691k(HttpResponseBuilder HttpResponseBuilder) throws IOException {
        try {
            this.f55381c.responseBodyStart(this.f55380b);
            String strM71599w = HttpResponseBuilder.m71599w("Content-Type");
            long jMo79707g = this.f55383e.mo79707g(HttpResponseBuilder);
            return new C13283h(strM71599w, jMo79707g, C1064n.m6403b(new b(this.f55383e.mo79703c(HttpResponseBuilder), jMo79707g)));
        } catch (IOException e10) {
            this.f55381c.responseFailed(this.f55380b, e10);
            m71695o(e10);
            throw e10;
        }
    }

    /* renamed from: l */
    public HttpResponseBuilder.a m71692l(boolean z10) throws IOException {
        try {
            HttpResponseBuilder.a aVarMo79704d = this.f55383e.mo79704d(z10);
            if (aVarMo79704d != null) {
                AbstractC12871a.f58633a.mo71502g(aVarMo79704d, this);
            }
            return aVarMo79704d;
        } catch (IOException e10) {
            this.f55381c.responseFailed(this.f55380b, e10);
            m71695o(e10);
            throw e10;
        }
    }

    /* renamed from: m */
    public void m71693m(HttpResponseBuilder HttpResponseBuilder) {
        this.f55381c.responseHeadersEnd(this.f55380b, HttpResponseBuilder);
    }

    /* renamed from: n */
    public void m71694n() {
        this.f55381c.responseHeadersStart(this.f55380b);
    }

    /* renamed from: o */
    public void m71695o(IOException iOException) {
        this.f55382d.m71708j();
        this.f55383e.mo79705e().m71734z(iOException);
    }

    /* renamed from: p */
    public void m71696p(HttpRequestBuilder HttpRequestBuilder) throws IOException {
        try {
            this.f55381c.requestHeadersStart(this.f55380b);
            this.f55383e.mo79702b(HttpRequestBuilder);
            this.f55381c.requestHeadersEnd(this.f55380b, HttpRequestBuilder);
        } catch (IOException e10) {
            this.f55381c.requestFailed(this.f55380b, e10);
            m71695o(e10);
            throw e10;
        }
    }
}
