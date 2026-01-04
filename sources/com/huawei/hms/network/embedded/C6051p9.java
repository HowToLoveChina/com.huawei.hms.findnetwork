package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5971j7;
import com.huawei.hms.network.embedded.C6127v7;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hms.network.embedded.p9 */
/* loaded from: classes8.dex */
public final class C6051p9 implements InterfaceC5934g9 {

    /* renamed from: i */
    public static final int f27757i = 0;

    /* renamed from: j */
    public static final int f27758j = 1;

    /* renamed from: k */
    public static final int f27759k = 2;

    /* renamed from: l */
    public static final int f27760l = 3;

    /* renamed from: m */
    public static final int f27761m = 4;

    /* renamed from: n */
    public static final int f27762n = 5;

    /* renamed from: o */
    public static final int f27763o = 6;

    /* renamed from: p */
    public static final int f27764p = 262144;

    /* renamed from: b */
    public final C6062q7 f27765b;

    /* renamed from: c */
    public final C6167y8 f27766c;

    /* renamed from: d */
    public final InterfaceC5896db f27767d;

    /* renamed from: e */
    public final InterfaceC5882cb f27768e;

    /* renamed from: f */
    public int f27769f = 0;

    /* renamed from: g */
    public long f27770g = 262144;

    /* renamed from: h */
    public C5971j7 f27771h;

    /* renamed from: com.huawei.hms.network.embedded.p9$b */
    public abstract class b implements InterfaceC6183zb {

        /* renamed from: a */
        public final C5962ib f27772a;

        /* renamed from: b */
        public boolean f27773b;

        public b() {
            this.f27772a = new C5962ib(C6051p9.this.f27767d.timeout());
        }

        /* renamed from: b */
        public final void m35040b() {
            if (C6051p9.this.f27769f == 6) {
                return;
            }
            if (C6051p9.this.f27769f == 5) {
                C6051p9.this.m35024a(this.f27772a);
                C6051p9.this.f27769f = 6;
            } else {
                throw new IllegalStateException("state: " + C6051p9.this.f27769f);
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            try {
                return C6051p9.this.f27767d.read(c5868bb, j10);
            } catch (IOException e10) {
                C6051p9.this.f27766c.m35864h();
                this.m35040b();
                throw e10;
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f27772a;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.p9$c */
    public final class c implements InterfaceC6170yb {

        /* renamed from: a */
        public final C5962ib f27775a;

        /* renamed from: b */
        public boolean f27776b;

        public c() {
            this.f27775a = new C5962ib(C6051p9.this.f27768e.timeout());
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public synchronized void close() throws IOException {
            if (this.f27776b) {
                return;
            }
            this.f27776b = true;
            C6051p9.this.f27768e.mo33934a("0\r\n\r\n");
            C6051p9.this.m35024a(this.f27775a);
            C6051p9.this.f27769f = 3;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f27776b) {
                return;
            }
            C6051p9.this.f27768e.flush();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f27775a;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            if (this.f27776b) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            C6051p9.this.f27768e.mo33953c(j10);
            C6051p9.this.f27768e.mo33934a("\r\n");
            C6051p9.this.f27768e.write(c5868bb, j10);
            C6051p9.this.f27768e.mo33934a("\r\n");
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.p9$d */
    public class d extends b {

        /* renamed from: h */
        public static final long f27778h = -1;

        /* renamed from: d */
        public final C6010m7 f27779d;

        /* renamed from: e */
        public long f27780e;

        /* renamed from: f */
        public boolean f27781f;

        public d(C6010m7 c6010m7) {
            super();
            this.f27780e = -1L;
            this.f27781f = true;
            this.f27779d = c6010m7;
        }

        /* renamed from: c */
        private void m35041c() throws IOException {
            if (this.f27780e != -1) {
                C6051p9.this.f27767d.mo33978n();
            }
            try {
                this.f27780e = C6051p9.this.f27767d.mo33974k();
                String strTrim = C6051p9.this.f27767d.mo33978n().trim();
                if (this.f27780e < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f27780e + strTrim + "\"");
                }
                if (this.f27780e == 0) {
                    this.f27781f = false;
                    C6051p9 c6051p9 = C6051p9.this;
                    c6051p9.f27771h = c6051p9.m35036j();
                    C5960i9.m34409a(C6051p9.this.f27765b.m35085i(), this.f27779d, C6051p9.this.f27771h);
                    m35040b();
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            if (this.f27773b) {
                return;
            }
            if (this.f27781f && !C5920f8.m34253a(this, 100, TimeUnit.MILLISECONDS)) {
                C6051p9.this.f27766c.m35864h();
                m35040b();
            }
            this.f27773b = true;
        }

        @Override // com.huawei.hms.network.embedded.C6051p9.b, com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f27773b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f27781f) {
                return -1L;
            }
            long j11 = this.f27780e;
            if (j11 == 0 || j11 == -1) {
                m35041c();
                if (!this.f27781f) {
                    return -1L;
                }
            }
            long j12 = super.read(c5868bb, Math.min(j10, this.f27780e));
            if (j12 != -1) {
                this.f27780e -= j12;
                return j12;
            }
            C6051p9.this.f27766c.m35864h();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m35040b();
            throw protocolException;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.p9$e */
    public class e extends b {

        /* renamed from: d */
        public long f27783d;

        public e(long j10) {
            super();
            this.f27783d = j10;
            if (j10 == 0) {
                m35040b();
            }
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            if (this.f27773b) {
                return;
            }
            if (this.f27783d != 0 && !C5920f8.m34253a(this, 100, TimeUnit.MILLISECONDS)) {
                C6051p9.this.f27766c.m35864h();
                m35040b();
            }
            this.f27773b = true;
        }

        @Override // com.huawei.hms.network.embedded.C6051p9.b, com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f27773b) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f27783d;
            if (j11 == 0) {
                return -1L;
            }
            long j12 = super.read(c5868bb, Math.min(j11, j10));
            if (j12 == -1) {
                C6051p9.this.f27766c.m35864h();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m35040b();
                throw protocolException;
            }
            long j13 = this.f27783d - j12;
            this.f27783d = j13;
            if (j13 == 0) {
                m35040b();
            }
            return j12;
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.p9$f */
    public final class f implements InterfaceC6170yb {

        /* renamed from: a */
        public final C5962ib f27785a;

        /* renamed from: b */
        public boolean f27786b;

        public f() {
            this.f27785a = new C5962ib(C6051p9.this.f27768e.timeout());
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.f27786b) {
                return;
            }
            this.f27786b = true;
            C6051p9.this.m35024a(this.f27785a);
            C6051p9.this.f27769f = 3;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
            if (this.f27786b) {
                return;
            }
            C6051p9.this.f27768e.flush();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return this.f27785a;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            if (this.f27786b) {
                throw new IllegalStateException("closed");
            }
            C5920f8.m34247a(c5868bb.m33913B(), 0L, j10);
            C6051p9.this.f27768e.write(c5868bb, j10);
        }
    }

    /* renamed from: com.huawei.hms.network.embedded.p9$g */
    public class g extends b {

        /* renamed from: d */
        public boolean f27788d;

        public g() {
            super();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
        public void close() throws IOException {
            if (this.f27773b) {
                return;
            }
            if (!this.f27788d) {
                m35040b();
            }
            this.f27773b = true;
        }

        @Override // com.huawei.hms.network.embedded.C6051p9.b, com.huawei.hms.network.embedded.InterfaceC6183zb
        public long read(C5868bb c5868bb, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f27773b) {
                throw new IllegalStateException("closed");
            }
            if (this.f27788d) {
                return -1L;
            }
            long j11 = super.read(c5868bb, j10);
            if (j11 != -1) {
                return j11;
            }
            this.f27788d = true;
            m35040b();
            return -1L;
        }
    }

    public C6051p9(C6062q7 c6062q7, C6167y8 c6167y8, InterfaceC5896db interfaceC5896db, InterfaceC5882cb interfaceC5882cb) {
        this.f27765b = c6062q7;
        this.f27766c = c6167y8;
        this.f27767d = interfaceC5896db;
        this.f27768e = interfaceC5882cb;
    }

    /* renamed from: h */
    private InterfaceC6183zb m35034h() {
        if (this.f27769f == 4) {
            this.f27769f = 5;
            this.f27766c.m35864h();
            return new g();
        }
        throw new IllegalStateException("state: " + this.f27769f);
    }

    /* renamed from: i */
    private String m35035i() throws IOException {
        String strMo33962e = this.f27767d.mo33962e(this.f27770g);
        this.f27770g -= strMo33962e.length();
        return strMo33962e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public C5971j7 m35036j() throws IOException {
        C5971j7.a aVar = new C5971j7.a();
        while (true) {
            String strM35035i = m35035i();
            if (strM35035i.length() == 0) {
                return aVar.m34535a();
            }
            AbstractC5879c8.f26567a.mo34047a(aVar, strM35035i);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    public void cancel() {
        C6167y8 c6167y8 = this.f27766c;
        if (c6167y8 != null) {
            c6167y8.m35861e();
        }
    }

    /* renamed from: f */
    private InterfaceC6170yb m35031f() {
        if (this.f27769f == 1) {
            this.f27769f = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f27769f);
    }

    /* renamed from: g */
    private InterfaceC6170yb m35033g() {
        if (this.f27769f == 1) {
            this.f27769f = 2;
            return new f();
        }
        throw new IllegalStateException("state: " + this.f27769f);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public long mo34315a(C6127v7 c6127v7) {
        if (!C5960i9.m34415b(c6127v7)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(c6127v7.m35582b("Transfer-Encoding"))) {
            return -1L;
        }
        return C5960i9.m34403a(c6127v7);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: b */
    public C5971j7 mo34320b() {
        if (this.f27769f != 6) {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        C5971j7 c5971j7 = this.f27771h;
        return c5971j7 != null ? c5971j7 : C5920f8.f26771c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: c */
    public void mo34322c() throws IOException {
        this.f27768e.flush();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: d */
    public void mo34323d() throws IOException {
        this.f27768e.flush();
    }

    /* renamed from: e */
    public boolean m35039e() {
        return this.f27769f == 6;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: b */
    public InterfaceC6183zb mo34321b(C6127v7 c6127v7) {
        if (!C5960i9.m34415b(c6127v7)) {
            return m35022a(0L);
        }
        if ("chunked".equalsIgnoreCase(c6127v7.m35582b("Transfer-Encoding"))) {
            return m35023a(c6127v7.m35578H().m35423k());
        }
        long jM34403a = C5960i9.m34403a(c6127v7);
        return jM34403a != -1 ? m35022a(jM34403a) : m35034h();
    }

    /* renamed from: c */
    public void m35038c(C6127v7 c6127v7) throws IOException {
        long jM34403a = C5960i9.m34403a(c6127v7);
        if (jM34403a == -1) {
            return;
        }
        InterfaceC6183zb interfaceC6183zbM35022a = m35022a(jM34403a);
        C5920f8.m34260b(interfaceC6183zbM35022a, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        interfaceC6183zbM35022a.close();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public C6127v7.a mo34316a(boolean z10) throws NumberFormatException, IOException {
        int i10 = this.f27769f;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.f27769f);
        }
        try {
            C6038o9 c6038o9M34931a = C6038o9.m34931a(m35035i());
            C6127v7.a aVarM35598a = new C6127v7.a().m35599a(c6038o9M34931a.f27628a).m35595a(c6038o9M34931a.f27629b).m35603a(c6038o9M34931a.f27630c).m35598a(m35036j());
            if (z10 && c6038o9M34931a.f27629b == 100) {
                return null;
            }
            if (c6038o9M34931a.f27629b == 100) {
                this.f27769f = 3;
                return aVarM35598a;
            }
            this.f27769f = 4;
            return aVarM35598a;
        } catch (EOFException e10) {
            C6167y8 c6167y8 = this.f27766c;
            throw new IOException("unexpected end of stream on " + (c6167y8 != null ? c6167y8.mo35837b().m35787a().m34990l().m34807r() : "unknown"), e10);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public C6167y8 mo34317a() {
        return this.f27766c;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public InterfaceC6170yb mo34318a(C6101t7 c6101t7, long j10) throws IOException {
        if (c6101t7.m35413b() != null && c6101t7.m35413b().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(c6101t7.m35411a("Transfer-Encoding"))) {
            return m35031f();
        }
        if (j10 != -1) {
            return m35033g();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: a */
    private InterfaceC6183zb m35022a(long j10) {
        if (this.f27769f == 4) {
            this.f27769f = 5;
            return new e(j10);
        }
        throw new IllegalStateException("state: " + this.f27769f);
    }

    /* renamed from: a */
    private InterfaceC6183zb m35023a(C6010m7 c6010m7) {
        if (this.f27769f == 4) {
            this.f27769f = 5;
            return new d(c6010m7);
        }
        throw new IllegalStateException("state: " + this.f27769f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m35024a(C5962ib c5962ib) {
        C5855ac c5855acM34425f = c5962ib.m34425f();
        c5962ib.m34424a(C5855ac.f26380d);
        c5855acM34425f.mo33841a();
        c5855acM34425f.mo33844b();
    }

    /* renamed from: a */
    public void m35037a(C5971j7 c5971j7, String str) throws IOException {
        if (this.f27769f != 0) {
            throw new IllegalStateException("state: " + this.f27769f);
        }
        this.f27768e.mo33934a(str).mo33934a("\r\n");
        int iM34527d = c5971j7.m34527d();
        for (int i10 = 0; i10 < iM34527d; i10++) {
            this.f27768e.mo33934a(c5971j7.m34520a(i10)).mo33934a(": ").mo33934a(c5971j7.m34522b(i10)).mo33934a("\r\n");
        }
        this.f27768e.mo33934a("\r\n");
        this.f27769f = 1;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC5934g9
    /* renamed from: a */
    public void mo34319a(C6101t7 c6101t7) throws IOException {
        m35037a(c6101t7.m35417e(), C6012m9.m34855a(c6101t7, this.f27766c.mo35837b().m35788b().type()));
    }
}
