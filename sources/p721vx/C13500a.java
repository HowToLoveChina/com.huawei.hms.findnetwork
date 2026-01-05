package p721vx;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import okhttp3.C11955v;
import okhttp3.C11958y;
import okhttp3.internal.connection.C11935i;
import p022ay.C1050a0;
import p022ay.C1054d;
import p022ay.C1060j;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;
import p693ux.C13280e;
import p693ux.C13284i;
import p693ux.C13286k;
import p693ux.InterfaceC13278c;
import sx.AbstractC12871a;
import sx.C12875e;

/* renamed from: vx.a */
/* loaded from: classes9.dex */
public final class C13500a implements InterfaceC13278c {

    /* renamed from: a */
    public final C11912b0 f60740a;

    /* renamed from: b */
    public final C11935i f60741b;

    /* renamed from: c */
    public final InterfaceC1056f f60742c;

    /* renamed from: d */
    public final InterfaceC1055e f60743d;

    /* renamed from: e */
    public int f60744e = 0;

    /* renamed from: f */
    public long f60745f = 262144;

    /* renamed from: g */
    public C11955v f60746g;

    /* renamed from: vx.a$b */
    public abstract class b implements InterfaceC1076z {

        /* renamed from: a */
        public final C1060j f60747a;

        /* renamed from: b */
        public boolean f60748b;

        public b() {
            this.f60747a = new C1060j(C13500a.this.f60742c.timeout());
        }

        @Override // p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            try {
                return C13500a.this.f60742c.read(c1054d, j10);
            } catch (IOException e10) {
                C13500a.this.f60741b.m71726r();
                this.m81213s();
                throw e10;
            }
        }

        /* renamed from: s */
        public final void m81213s() {
            if (C13500a.this.f60744e == 6) {
                return;
            }
            if (C13500a.this.f60744e == 5) {
                C13500a.this.m81205s(this.f60747a);
                C13500a.this.f60744e = 6;
            } else {
                throw new IllegalStateException("state: " + C13500a.this.f60744e);
            }
        }

        @Override // p022ay.InterfaceC1076z
        public C1050a0 timeout() {
            return this.f60747a;
        }
    }

    /* renamed from: vx.a$c */
    public final class c implements InterfaceC1074x {

        /* renamed from: a */
        public final C1060j f60750a;

        /* renamed from: b */
        public boolean f60751b;

        public c() {
            this.f60750a = new C1060j(C13500a.this.f60743d.timeout());
        }

        @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f60751b) {
                return;
            }
            this.f60751b = true;
            C13500a.this.f60743d.mo6329R("0\r\n\r\n");
            C13500a.this.m81205s(this.f60750a);
            C13500a.this.f60744e = 3;
        }

        @Override // p022ay.InterfaceC1074x, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f60751b) {
                return;
            }
            C13500a.this.f60743d.flush();
        }

        @Override // p022ay.InterfaceC1074x
        public C1050a0 timeout() {
            return this.f60750a;
        }

        @Override // p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            if (this.f60751b) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            C13500a.this.f60743d.mo6333W(j10);
            C13500a.this.f60743d.mo6329R("\r\n");
            C13500a.this.f60743d.write(c1054d, j10);
            C13500a.this.f60743d.mo6329R("\r\n");
        }
    }

    /* renamed from: vx.a$d */
    public class d extends b {

        /* renamed from: d */
        public final C11958y f60753d;

        /* renamed from: e */
        public long f60754e;

        /* renamed from: f */
        public boolean f60755f;

        public d(C11958y c11958y) {
            super();
            this.f60754e = -1L;
            this.f60755f = true;
            this.f60753d = c11958y;
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f60748b) {
                return;
            }
            if (this.f60755f && !C12875e.m77259p(this, 100, TimeUnit.MILLISECONDS)) {
                C13500a.this.f60741b.m71726r();
                m81213s();
            }
            this.f60748b = true;
        }

        @Override // p721vx.C13500a.b, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f60748b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f60755f) {
                return -1L;
            }
            long j11 = this.f60754e;
            if (j11 == 0 || j11 == -1) {
                m81214t();
                if (!this.f60755f) {
                    return -1L;
                }
            }
            long j12 = super.read(c1054d, Math.min(j10, this.f60754e));
            if (j12 != -1) {
                this.f60754e -= j12;
                return j12;
            }
            C13500a.this.f60741b.m71726r();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m81213s();
            throw protocolException;
        }

        /* renamed from: t */
        public final void m81214t() throws IOException {
            if (this.f60754e != -1) {
                C13500a.this.f60742c.mo6341f0();
            }
            try {
                this.f60754e = C13500a.this.f60742c.mo6315C0();
                String strTrim = C13500a.this.f60742c.mo6341f0().trim();
                if (this.f60754e < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f60754e + strTrim + "\"");
                }
                if (this.f60754e == 0) {
                    this.f60755f = false;
                    C13500a c13500a = C13500a.this;
                    c13500a.f60746g = c13500a.m81212z();
                    C13280e.m79716e(C13500a.this.f60740a.m71481l(), this.f60753d, C13500a.this.f60746g);
                    m81213s();
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }
    }

    /* renamed from: vx.a$e */
    public class e extends b {

        /* renamed from: d */
        public long f60757d;

        public e(long j10) {
            super();
            this.f60757d = j10;
            if (j10 == 0) {
                m81213s();
            }
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f60748b) {
                return;
            }
            if (this.f60757d != 0 && !C12875e.m77259p(this, 100, TimeUnit.MILLISECONDS)) {
                C13500a.this.f60741b.m71726r();
                m81213s();
            }
            this.f60748b = true;
        }

        @Override // p721vx.C13500a.b, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f60748b) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f60757d;
            if (j11 == 0) {
                return -1L;
            }
            long j12 = super.read(c1054d, Math.min(j11, j10));
            if (j12 == -1) {
                C13500a.this.f60741b.m71726r();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m81213s();
                throw protocolException;
            }
            long j13 = this.f60757d - j12;
            this.f60757d = j13;
            if (j13 == 0) {
                m81213s();
            }
            return j12;
        }
    }

    /* renamed from: vx.a$f */
    public final class f implements InterfaceC1074x {

        /* renamed from: a */
        public final C1060j f60759a;

        /* renamed from: b */
        public boolean f60760b;

        public f() {
            this.f60759a = new C1060j(C13500a.this.f60743d.timeout());
        }

        @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f60760b) {
                return;
            }
            this.f60760b = true;
            C13500a.this.m81205s(this.f60759a);
            C13500a.this.f60744e = 3;
        }

        @Override // p022ay.InterfaceC1074x, java.io.Flushable
        public void flush() throws IOException {
            if (this.f60760b) {
                return;
            }
            C13500a.this.f60743d.flush();
        }

        @Override // p022ay.InterfaceC1074x
        public C1050a0 timeout() {
            return this.f60759a;
        }

        @Override // p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            if (this.f60760b) {
                throw new IllegalStateException("closed");
            }
            C12875e.m77249f(c1054d.m6322J(), 0L, j10);
            C13500a.this.f60743d.write(c1054d, j10);
        }
    }

    /* renamed from: vx.a$g */
    public class g extends b {

        /* renamed from: d */
        public boolean f60762d;

        public g() {
            super();
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f60748b) {
                return;
            }
            if (!this.f60762d) {
                m81213s();
            }
            this.f60748b = true;
        }

        @Override // p721vx.C13500a.b, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f60748b) {
                throw new IllegalStateException("closed");
            }
            if (this.f60762d) {
                return -1L;
            }
            long j11 = super.read(c1054d, j10);
            if (j11 != -1) {
                return j11;
            }
            this.f60762d = true;
            m81213s();
            return -1L;
        }
    }

    public C13500a(C11912b0 c11912b0, C11935i c11935i, InterfaceC1056f interfaceC1056f, InterfaceC1055e interfaceC1055e) {
        this.f60740a = c11912b0;
        this.f60741b = c11935i;
        this.f60742c = interfaceC1056f;
        this.f60743d = interfaceC1055e;
    }

    /* renamed from: A */
    public void m81203A(HttpResponseBuilder HttpResponseBuilder) throws IOException {
        long jM79713b = C13280e.m79713b(HttpResponseBuilder);
        if (jM79713b == -1) {
            return;
        }
        InterfaceC1076z interfaceC1076zM81208v = m81208v(jM79713b);
        C12875e.m77236G(interfaceC1076zM81208v, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        interfaceC1076zM81208v.close();
    }

    /* renamed from: B */
    public void m81204B(C11955v c11955v, String str) throws IOException {
        if (this.f60744e != 0) {
            throw new IllegalStateException("state: " + this.f60744e);
        }
        this.f60743d.mo6329R(str).mo6329R("\r\n");
        int iM71857j = c11955v.m71857j();
        for (int i10 = 0; i10 < iM71857j; i10++) {
            this.f60743d.mo6329R(c11955v.m71854e(i10)).mo6329R(": ").mo6329R(c11955v.m71859l(i10)).mo6329R("\r\n");
        }
        this.f60743d.mo6329R("\r\n");
        this.f60744e = 1;
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: a */
    public void mo79701a() throws IOException {
        this.f60743d.flush();
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: b */
    public void mo79702b(HttpRequestBuilder HttpRequestBuilder) throws IOException {
        m81204B(HttpRequestBuilder.m71566f(), C13284i.m79727a(HttpRequestBuilder, this.f60741b.mo71709a().m71639b().type()));
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: c */
    public InterfaceC1076z mo79703c(HttpResponseBuilder HttpResponseBuilder) {
        if (!C13280e.m79714c(HttpResponseBuilder)) {
            return m81208v(0L);
        }
        if ("chunked".equalsIgnoreCase(HttpResponseBuilder.m71599w("Transfer-Encoding"))) {
            return m81207u(HttpResponseBuilder.m71593E().m71573m());
        }
        long jM79713b = C13280e.m79713b(HttpResponseBuilder);
        return jM79713b != -1 ? m81208v(jM79713b) : m81210x();
    }

    @Override // p693ux.InterfaceC13278c
    public void cancel() throws IOException {
        C11935i c11935i = this.f60741b;
        if (c11935i != null) {
            c11935i.m71712d();
        }
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: d */
    public HttpResponseBuilder.a mo79704d(boolean z10) throws NumberFormatException, IOException {
        int i10 = this.f60744e;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.f60744e);
        }
        try {
            C13286k c13286kM79735a = C13286k.m79735a(m81211y());
            HttpResponseBuilder.a aVarM71612j = new HttpResponseBuilder.a().m71617o(c13286kM79735a.f60002a).m71609g(c13286kM79735a.f60003b).m71614l(c13286kM79735a.f60004c).m71612j(m81212z());
            if (z10 && c13286kM79735a.f60003b == 100) {
                return null;
            }
            if (c13286kM79735a.f60003b == 100) {
                this.f60744e = 3;
                return aVarM71612j;
            }
            this.f60744e = 4;
            return aVarM71612j;
        } catch (EOFException e10) {
            C11935i c11935i = this.f60741b;
            throw new IOException("unexpected end of stream on " + (c11935i != null ? c11935i.mo71709a().m71638a().m71461n().m71911z() : "unknown"), e10);
        }
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: e */
    public C11935i mo79705e() {
        return this.f60741b;
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: f */
    public void mo79706f() throws IOException {
        this.f60743d.flush();
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: g */
    public long mo79707g(HttpResponseBuilder HttpResponseBuilder) {
        if (!C13280e.m79714c(HttpResponseBuilder)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(HttpResponseBuilder.m71599w("Transfer-Encoding"))) {
            return -1L;
        }
        return C13280e.m79713b(HttpResponseBuilder);
    }

    @Override // p693ux.InterfaceC13278c
    /* renamed from: h */
    public InterfaceC1074x mo79708h(HttpRequestBuilder HttpRequestBuilder, long j10) throws IOException {
        if (HttpRequestBuilder.m71562b() != null && HttpRequestBuilder.m71562b().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(HttpRequestBuilder.m71565e("Transfer-Encoding"))) {
            return m81206t();
        }
        if (j10 != -1) {
            return m81209w();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: s */
    public final void m81205s(C1060j c1060j) {
        C1050a0 c1050a0M6393b = c1060j.m6393b();
        c1060j.m6394c(C1050a0.NONE);
        c1050a0M6393b.clearDeadline();
        c1050a0M6393b.clearTimeout();
    }

    /* renamed from: t */
    public final InterfaceC1074x m81206t() {
        if (this.f60744e == 1) {
            this.f60744e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f60744e);
    }

    /* renamed from: u */
    public final InterfaceC1076z m81207u(C11958y c11958y) {
        if (this.f60744e == 4) {
            this.f60744e = 5;
            return new d(c11958y);
        }
        throw new IllegalStateException("state: " + this.f60744e);
    }

    /* renamed from: v */
    public final InterfaceC1076z m81208v(long j10) {
        if (this.f60744e == 4) {
            this.f60744e = 5;
            return new e(j10);
        }
        throw new IllegalStateException("state: " + this.f60744e);
    }

    /* renamed from: w */
    public final InterfaceC1074x m81209w() {
        if (this.f60744e == 1) {
            this.f60744e = 2;
            return new f();
        }
        throw new IllegalStateException("state: " + this.f60744e);
    }

    /* renamed from: x */
    public final InterfaceC1076z m81210x() {
        if (this.f60744e == 4) {
            this.f60744e = 5;
            this.f60741b.m71726r();
            return new g();
        }
        throw new IllegalStateException("state: " + this.f60744e);
    }

    /* renamed from: y */
    public final String m81211y() throws IOException {
        String strMo6327O = this.f60742c.mo6327O(this.f60745f);
        this.f60745f -= strMo6327O.length();
        return strMo6327O;
    }

    /* renamed from: z */
    public final C11955v m81212z() throws IOException {
        C11955v.a aVar = new C11955v.a();
        while (true) {
            String strM81211y = m81211y();
            if (strM81211y.length() == 0) {
                return aVar.m71864d();
            }
            AbstractC12871a.f58633a.mo71496a(aVar, strM81211y);
        }
    }
}
