package com.huawei.hms.drive;

import com.huawei.hms.drive.C5190aw;
import com.huawei.hms.drive.C5203bh;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import p022ay.C1050a0;
import p022ay.C1054d;
import p022ay.C1060j;
import p022ay.InterfaceC1055e;
import p022ay.InterfaceC1056f;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;

/* renamed from: com.huawei.hms.drive.cu */
/* loaded from: classes8.dex */
public final class C5244cu implements InterfaceC5235cl {

    /* renamed from: a */
    private final C5198bc f24231a;

    /* renamed from: b */
    private final C5227cd f24232b;

    /* renamed from: c */
    private final InterfaceC1056f f24233c;

    /* renamed from: d */
    private final InterfaceC1055e f24234d;

    /* renamed from: e */
    private int f24235e = 0;

    /* renamed from: f */
    private long f24236f = 262144;

    /* renamed from: g */
    private C5190aw f24237g;

    /* renamed from: com.huawei.hms.drive.cu$a */
    public abstract class a implements InterfaceC1076z {

        /* renamed from: a */
        protected final C1060j f24238a;

        /* renamed from: b */
        protected boolean f24239b;

        private a() {
            this.f24238a = new C1060j(C5244cu.this.f24233c.timeout());
        }

        /* renamed from: a */
        public final void m31453a() {
            if (C5244cu.this.f24235e == 6) {
                return;
            }
            if (C5244cu.this.f24235e == 5) {
                C5244cu.this.m31438a(this.f24238a);
                C5244cu.this.f24235e = 6;
            } else {
                throw new IllegalStateException("state: " + C5244cu.this.f24235e);
            }
        }

        @Override // p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public abstract /* synthetic */ void close() throws IOException;

        @Override // p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            try {
                return C5244cu.this.f24233c.read(c1054d, j10);
            } catch (IOException e10) {
                C5244cu.this.f24232b.m31316a();
                this.m31453a();
                throw e10;
            }
        }

        @Override // p022ay.InterfaceC1076z
        public C1050a0 timeout() {
            return this.f24238a;
        }
    }

    /* renamed from: com.huawei.hms.drive.cu$b */
    public final class b implements InterfaceC1074x {

        /* renamed from: b */
        private final C1060j f24242b;

        /* renamed from: c */
        private boolean f24243c;

        public b() {
            this.f24242b = new C1060j(C5244cu.this.f24234d.timeout());
        }

        @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f24243c) {
                return;
            }
            this.f24243c = true;
            C5244cu.this.f24234d.mo6329R("0\r\n\r\n");
            C5244cu.this.m31438a(this.f24242b);
            C5244cu.this.f24235e = 3;
        }

        @Override // p022ay.InterfaceC1074x, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f24243c) {
                return;
            }
            C5244cu.this.f24234d.flush();
        }

        @Override // p022ay.InterfaceC1074x
        public C1050a0 timeout() {
            return this.f24242b;
        }

        @Override // p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            if (this.f24243c) {
                throw new IllegalStateException("closed");
            }
            if (j10 == 0) {
                return;
            }
            C5244cu.this.f24234d.mo6333W(j10);
            C5244cu.this.f24234d.mo6329R("\r\n");
            C5244cu.this.f24234d.write(c1054d, j10);
            C5244cu.this.f24234d.mo6329R("\r\n");
        }
    }

    /* renamed from: com.huawei.hms.drive.cu$c */
    public class c extends a {

        /* renamed from: e */
        private final C5193az f24245e;

        /* renamed from: f */
        private long f24246f;

        /* renamed from: g */
        private boolean f24247g;

        public c(C5193az c5193az) {
            super();
            this.f24246f = -1L;
            this.f24247g = true;
            this.f24245e = c5193az;
        }

        /* renamed from: b */
        private void m31454b() throws IOException {
            if (this.f24246f != -1) {
                C5244cu.this.f24233c.mo6341f0();
            }
            try {
                this.f24246f = C5244cu.this.f24233c.mo6315C0();
                String strTrim = C5244cu.this.f24233c.mo6341f0().trim();
                if (this.f24246f < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f24246f + strTrim + "\"");
                }
                if (this.f24246f == 0) {
                    this.f24247g = false;
                    C5244cu c5244cu = C5244cu.this;
                    c5244cu.f24237g = c5244cu.m31445f();
                    C5237cn.m31413a(C5244cu.this.f24231a.m31053h(), this.f24245e, C5244cu.this.f24237g);
                    m31453a();
                }
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }

        @Override // com.huawei.hms.drive.C5244cu.a, p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f24239b) {
                return;
            }
            if (this.f24247g && !C5210bo.m31194a(this, 100, TimeUnit.MILLISECONDS)) {
                C5244cu.this.f24232b.m31316a();
                m31453a();
            }
            this.f24239b = true;
        }

        @Override // com.huawei.hms.drive.C5244cu.a, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f24239b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f24247g) {
                return -1L;
            }
            long j11 = this.f24246f;
            if (j11 == 0 || j11 == -1) {
                m31454b();
                if (!this.f24247g) {
                    return -1L;
                }
            }
            long j12 = super.read(c1054d, Math.min(j10, this.f24246f));
            if (j12 != -1) {
                this.f24246f -= j12;
                return j12;
            }
            C5244cu.this.f24232b.m31316a();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m31453a();
            throw protocolException;
        }
    }

    /* renamed from: com.huawei.hms.drive.cu$d */
    public class d extends a {

        /* renamed from: e */
        private long f24249e;

        public d(long j10) {
            super();
            this.f24249e = j10;
            if (j10 == 0) {
                m31453a();
            }
        }

        @Override // com.huawei.hms.drive.C5244cu.a, p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f24239b) {
                return;
            }
            if (this.f24249e != 0 && !C5210bo.m31194a(this, 100, TimeUnit.MILLISECONDS)) {
                C5244cu.this.f24232b.m31316a();
                m31453a();
            }
            this.f24239b = true;
        }

        @Override // com.huawei.hms.drive.C5244cu.a, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f24239b) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f24249e;
            if (j11 == 0) {
                return -1L;
            }
            long j12 = super.read(c1054d, Math.min(j11, j10));
            if (j12 == -1) {
                C5244cu.this.f24232b.m31316a();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m31453a();
                throw protocolException;
            }
            long j13 = this.f24249e - j12;
            this.f24249e = j13;
            if (j13 == 0) {
                m31453a();
            }
            return j12;
        }
    }

    /* renamed from: com.huawei.hms.drive.cu$e */
    public final class e implements InterfaceC1074x {

        /* renamed from: b */
        private final C1060j f24251b;

        /* renamed from: c */
        private boolean f24252c;

        private e() {
            this.f24251b = new C1060j(C5244cu.this.f24234d.timeout());
        }

        @Override // p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f24252c) {
                return;
            }
            this.f24252c = true;
            C5244cu.this.m31438a(this.f24251b);
            C5244cu.this.f24235e = 3;
        }

        @Override // p022ay.InterfaceC1074x, java.io.Flushable
        public void flush() throws IOException {
            if (this.f24252c) {
                return;
            }
            C5244cu.this.f24234d.flush();
        }

        @Override // p022ay.InterfaceC1074x
        public C1050a0 timeout() {
            return this.f24251b;
        }

        @Override // p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            if (this.f24252c) {
                throw new IllegalStateException("closed");
            }
            C5210bo.m31190a(c1054d.m6322J(), 0L, j10);
            C5244cu.this.f24234d.write(c1054d, j10);
        }
    }

    /* renamed from: com.huawei.hms.drive.cu$f */
    public class f extends a {

        /* renamed from: e */
        private boolean f24254e;

        private f() {
            super();
        }

        @Override // com.huawei.hms.drive.C5244cu.a, p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f24239b) {
                return;
            }
            if (!this.f24254e) {
                m31453a();
            }
            this.f24239b = true;
        }

        @Override // com.huawei.hms.drive.C5244cu.a, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (j10 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j10);
            }
            if (this.f24239b) {
                throw new IllegalStateException("closed");
            }
            if (this.f24254e) {
                return -1L;
            }
            long j11 = super.read(c1054d, j10);
            if (j11 != -1) {
                return j11;
            }
            this.f24254e = true;
            m31453a();
            return -1L;
        }
    }

    public C5244cu(C5198bc c5198bc, C5227cd c5227cd, InterfaceC1056f interfaceC1056f, InterfaceC1055e interfaceC1055e) {
        this.f24231a = c5198bc;
        this.f24232b = c5227cd;
        this.f24233c = interfaceC1056f;
        this.f24234d = interfaceC1055e;
    }

    /* renamed from: h */
    private InterfaceC1074x m31449h() {
        if (this.f24235e == 1) {
            this.f24235e = 2;
            return new e();
        }
        throw new IllegalStateException("state: " + this.f24235e);
    }

    /* renamed from: i */
    private InterfaceC1076z m31450i() {
        if (this.f24235e == 4) {
            this.f24235e = 5;
            this.f24232b.m31316a();
            return new f();
        }
        throw new IllegalStateException("state: " + this.f24235e);
    }

    /* renamed from: e */
    private String m31444e() throws IOException {
        String strMo6327O = this.f24233c.mo6327O(this.f24236f);
        this.f24236f -= strMo6327O.length();
        return strMo6327O;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public C5190aw m31445f() throws IOException {
        C5190aw.a aVar = new C5190aw.a();
        while (true) {
            String strM31444e = m31444e();
            if (strM31444e.length() == 0) {
                return aVar.m30930a();
            }
            AbstractC5207bl.f23983a.mo31076a(aVar, strM31444e);
        }
    }

    /* renamed from: g */
    private InterfaceC1074x m31447g() {
        if (this.f24235e == 1) {
            this.f24235e = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.f24235e);
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: b */
    public InterfaceC1076z mo31401b(C5203bh c5203bh) {
        if (!C5237cn.m31415b(c5203bh)) {
            return m31435a(0L);
        }
        if ("chunked".equalsIgnoreCase(c5203bh.m31127a("Transfer-Encoding"))) {
            return m31436a(c5203bh.m31126a().m31107a());
        }
        long jM31411a = C5237cn.m31411a(c5203bh);
        return jM31411a != -1 ? m31435a(jM31411a) : m31450i();
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: c */
    public void mo31403c() throws IOException {
        this.f24234d.flush();
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: d */
    public void mo31404d() throws IOException {
        C5227cd c5227cd = this.f24232b;
        if (c5227cd != null) {
            c5227cd.m31328d();
        }
    }

    /* renamed from: c */
    public void m31452c(C5203bh c5203bh) throws IOException {
        long jM31411a = C5237cn.m31411a(c5203bh);
        if (jM31411a == -1) {
            return;
        }
        InterfaceC1076z interfaceC1076zM31435a = m31435a(jM31411a);
        C5210bo.m31204b(interfaceC1076zM31435a, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        interfaceC1076zM31435a.close();
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public C5227cd mo31399a() {
        return this.f24232b;
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public InterfaceC1074x mo31397a(C5201bf c5201bf, long j10) throws IOException {
        if (c5201bf.m31111d() != null && c5201bf.m31111d().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if ("chunked".equalsIgnoreCase(c5201bf.m31108a("Transfer-Encoding"))) {
            return m31447g();
        }
        if (j10 != -1) {
            return m31449h();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: b */
    public void mo31402b() throws IOException {
        this.f24234d.flush();
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public void mo31400a(C5201bf c5201bf) throws IOException {
        m31451a(c5201bf.m31110c(), C5241cr.m31425a(c5201bf, this.f24232b.m31327c().m31163b().type()));
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public long mo31396a(C5203bh c5203bh) {
        if (!C5237cn.m31415b(c5203bh)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(c5203bh.m31127a("Transfer-Encoding"))) {
            return -1L;
        }
        return C5237cn.m31411a(c5203bh);
    }

    /* renamed from: a */
    public void m31451a(C5190aw c5190aw, String str) throws IOException {
        if (this.f24235e == 0) {
            this.f24234d.mo6329R(str).mo6329R("\r\n");
            int iM30921a = c5190aw.m30921a();
            for (int i10 = 0; i10 < iM30921a; i10++) {
                this.f24234d.mo6329R(c5190aw.m30922a(i10)).mo6329R(": ").mo6329R(c5190aw.m30925b(i10)).mo6329R("\r\n");
            }
            this.f24234d.mo6329R("\r\n");
            this.f24235e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f24235e);
    }

    @Override // com.huawei.hms.drive.InterfaceC5235cl
    /* renamed from: a */
    public C5203bh.a mo31398a(boolean z10) throws NumberFormatException, IOException {
        String strM30977m;
        int i10 = this.f24235e;
        if (i10 != 1 && i10 != 3) {
            throw new IllegalStateException("state: " + this.f24235e);
        }
        try {
            C5243ct c5243ctM31432a = C5243ct.m31432a(m31444e());
            C5203bh.a aVarM31144a = new C5203bh.a().m31145a(c5243ctM31432a.f24228a).m31141a(c5243ctM31432a.f24229b).m31149a(c5243ctM31432a.f24230c).m31144a(m31445f());
            if (z10 && c5243ctM31432a.f24229b == 100) {
                return null;
            }
            if (c5243ctM31432a.f24229b == 100) {
                this.f24235e = 3;
                return aVarM31144a;
            }
            this.f24235e = 4;
            return aVarM31144a;
        } catch (EOFException e10) {
            C5227cd c5227cd = this.f24232b;
            if (c5227cd != null) {
                strM30977m = c5227cd.m31327c().m31162a().m30808b().m30977m();
            } else {
                strM30977m = "unknown";
            }
            throw new IOException("unexpected end of stream on " + strM30977m, e10);
        }
    }

    /* renamed from: a */
    private InterfaceC1076z m31435a(long j10) {
        if (this.f24235e == 4) {
            this.f24235e = 5;
            return new d(j10);
        }
        throw new IllegalStateException("state: " + this.f24235e);
    }

    /* renamed from: a */
    private InterfaceC1076z m31436a(C5193az c5193az) {
        if (this.f24235e == 4) {
            this.f24235e = 5;
            return new c(c5193az);
        }
        throw new IllegalStateException("state: " + this.f24235e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m31438a(C1060j c1060j) {
        C1050a0 c1050a0M6393b = c1060j.m6393b();
        c1060j.m6394c(C1050a0.NONE);
        c1050a0M6393b.clearDeadline();
        c1050a0M6393b.clearTimeout();
    }
}
