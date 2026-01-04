package com.huawei.hms.drive;

import com.huawei.hms.drive.C5203bh;
import java.io.IOException;
import java.net.ProtocolException;
import p022ay.AbstractC1058h;
import p022ay.AbstractC1059i;
import p022ay.C1054d;
import p022ay.C1064n;
import p022ay.InterfaceC1074x;
import p022ay.InterfaceC1076z;

/* renamed from: com.huawei.hms.drive.ca */
/* loaded from: classes8.dex */
public final class C5224ca {

    /* renamed from: a */
    final C5232ci f24103a;

    /* renamed from: b */
    final InterfaceC5177aj f24104b;

    /* renamed from: c */
    final AbstractC5188au f24105c;

    /* renamed from: d */
    final C5225cb f24106d;

    /* renamed from: e */
    final InterfaceC5235cl f24107e;

    /* renamed from: f */
    private boolean f24108f;

    /* renamed from: com.huawei.hms.drive.ca$a */
    public final class a extends AbstractC1058h {

        /* renamed from: b */
        private boolean f24110b;

        /* renamed from: c */
        private long f24111c;

        /* renamed from: d */
        private long f24112d;

        /* renamed from: e */
        private boolean f24113e;

        public a(InterfaceC1074x interfaceC1074x, long j10) {
            super(interfaceC1074x);
            this.f24111c = j10;
        }

        /* renamed from: a */
        private IOException m31295a(IOException iOException) {
            if (this.f24110b) {
                return iOException;
            }
            this.f24110b = true;
            return C5224ca.this.m31282a(this.f24112d, false, true, iOException);
        }

        @Override // p022ay.AbstractC1058h, p022ay.InterfaceC1074x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f24113e) {
                return;
            }
            this.f24113e = true;
            long j10 = this.f24111c;
            if (j10 != -1 && this.f24112d != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m31295a(null);
            } catch (IOException e10) {
                throw m31295a(e10);
            }
        }

        @Override // p022ay.AbstractC1058h, p022ay.InterfaceC1074x, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw m31295a(e10);
            }
        }

        @Override // p022ay.AbstractC1058h, p022ay.InterfaceC1074x
        public void write(C1054d c1054d, long j10) throws IOException {
            if (this.f24113e) {
                throw new IllegalStateException("closed");
            }
            long j11 = this.f24111c;
            if (j11 == -1 || this.f24112d + j10 <= j11) {
                try {
                    super.write(c1054d, j10);
                    this.f24112d += j10;
                    return;
                } catch (IOException e10) {
                    throw m31295a(e10);
                }
            }
            throw new ProtocolException("expected " + this.f24111c + " bytes but received " + (this.f24112d + j10));
        }
    }

    /* renamed from: com.huawei.hms.drive.ca$b */
    public final class b extends AbstractC1059i {

        /* renamed from: b */
        private final long f24115b;

        /* renamed from: c */
        private long f24116c;

        /* renamed from: d */
        private boolean f24117d;

        /* renamed from: e */
        private boolean f24118e;

        public b(InterfaceC1076z interfaceC1076z, long j10) {
            super(interfaceC1076z);
            this.f24115b = j10;
            if (j10 == 0) {
                m31296a(null);
            }
        }

        /* renamed from: a */
        public IOException m31296a(IOException iOException) {
            if (this.f24117d) {
                return iOException;
            }
            this.f24117d = true;
            return C5224ca.this.m31282a(this.f24116c, true, false, iOException);
        }

        @Override // p022ay.AbstractC1059i, p022ay.InterfaceC1076z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f24118e) {
                return;
            }
            this.f24118e = true;
            try {
                super.close();
                m31296a(null);
            } catch (IOException e10) {
                throw m31296a(e10);
            }
        }

        @Override // p022ay.AbstractC1059i, p022ay.InterfaceC1076z
        public long read(C1054d c1054d, long j10) throws IOException {
            if (this.f24118e) {
                throw new IllegalStateException("closed");
            }
            try {
                long j11 = delegate().read(c1054d, j10);
                if (j11 == -1) {
                    m31296a(null);
                    return -1L;
                }
                long j12 = this.f24116c + j11;
                long j13 = this.f24115b;
                if (j13 != -1 && j12 > j13) {
                    throw new ProtocolException("expected " + this.f24115b + " bytes but received " + j12);
                }
                this.f24116c = j12;
                if (j12 == j13) {
                    m31296a(null);
                }
                return j11;
            } catch (IOException e10) {
                throw m31296a(e10);
            }
        }
    }

    public C5224ca(C5232ci c5232ci, InterfaceC5177aj interfaceC5177aj, AbstractC5188au abstractC5188au, C5225cb c5225cb, InterfaceC5235cl interfaceC5235cl) {
        this.f24103a = c5232ci;
        this.f24104b = interfaceC5177aj;
        this.f24105c = abstractC5188au;
        this.f24106d = c5225cb;
        this.f24107e = interfaceC5235cl;
    }

    /* renamed from: a */
    public C5227cd m31281a() {
        return this.f24107e.mo31399a();
    }

    /* renamed from: b */
    public boolean m31287b() {
        return this.f24108f;
    }

    /* renamed from: c */
    public void m31288c() throws IOException {
        try {
            this.f24107e.mo31402b();
        } catch (IOException e10) {
            this.f24105c.m30897a(this.f24104b, e10);
            m31285a(e10);
            throw e10;
        }
    }

    /* renamed from: d */
    public void m31289d() throws IOException {
        try {
            this.f24107e.mo31403c();
        } catch (IOException e10) {
            this.f24105c.m30897a(this.f24104b, e10);
            m31285a(e10);
            throw e10;
        }
    }

    /* renamed from: e */
    public void m31290e() {
        this.f24105c.m30910e(this.f24104b);
    }

    /* renamed from: f */
    public void m31291f() {
        this.f24107e.mo31399a().m31316a();
    }

    /* renamed from: g */
    public void m31292g() {
        this.f24107e.mo31404d();
    }

    /* renamed from: h */
    public void m31293h() {
        this.f24107e.mo31404d();
        this.f24103a.m31379a(this, true, true, null);
    }

    /* renamed from: i */
    public void m31294i() {
        this.f24103a.m31379a(this, true, false, null);
    }

    /* renamed from: a */
    public void m31283a(C5201bf c5201bf) throws IOException {
        try {
            this.f24105c.m30907c(this.f24104b);
            this.f24107e.mo31400a(c5201bf);
            this.f24105c.m30895a(this.f24104b, c5201bf);
        } catch (IOException e10) {
            this.f24105c.m30897a(this.f24104b, e10);
            m31285a(e10);
            throw e10;
        }
    }

    /* renamed from: b */
    public AbstractC5204bi m31286b(C5203bh c5203bh) throws IOException {
        try {
            this.f24105c.m30911f(this.f24104b);
            String strM31127a = c5203bh.m31127a("Content-Type");
            long jMo31396a = this.f24107e.mo31396a(c5203bh);
            return new C5240cq(strM31127a, jMo31396a, C1064n.m6403b(new b(this.f24107e.mo31401b(c5203bh), jMo31396a)));
        } catch (IOException e10) {
            this.f24105c.m30906b(this.f24104b, e10);
            m31285a(e10);
            throw e10;
        }
    }

    /* renamed from: a */
    public InterfaceC1074x m31279a(C5201bf c5201bf, boolean z10) throws IOException {
        this.f24108f = z10;
        long jContentLength = c5201bf.m31111d().contentLength();
        this.f24105c.m30909d(this.f24104b);
        return new a(this.f24107e.mo31397a(c5201bf, jContentLength), jContentLength);
    }

    /* renamed from: a */
    public C5203bh.a m31280a(boolean z10) throws IOException {
        try {
            C5203bh.a aVarMo31398a = this.f24107e.mo31398a(z10);
            if (aVarMo31398a != null) {
                AbstractC5207bl.f23983a.mo31078a(aVarMo31398a, this);
            }
            return aVarMo31398a;
        } catch (IOException e10) {
            this.f24105c.m30906b(this.f24104b, e10);
            m31285a(e10);
            throw e10;
        }
    }

    /* renamed from: a */
    public void m31284a(C5203bh c5203bh) {
        this.f24105c.m30896a(this.f24104b, c5203bh);
    }

    /* renamed from: a */
    public void m31285a(IOException iOException) {
        this.f24106d.m31303b();
        this.f24107e.mo31399a().m31321a(iOException);
    }

    /* renamed from: a */
    public IOException m31282a(long j10, boolean z10, boolean z11, IOException iOException) {
        if (iOException != null) {
            m31285a(iOException);
        }
        if (z11) {
            if (iOException != null) {
                this.f24105c.m30897a(this.f24104b, iOException);
            } else {
                this.f24105c.m30892a(this.f24104b, j10);
            }
        }
        if (z10) {
            if (iOException != null) {
                this.f24105c.m30906b(this.f24104b, iOException);
            } else {
                this.f24105c.m30904b(this.f24104b, j10);
            }
        }
        return this.f24103a.m31379a(this, z11, z10, iOException);
    }
}
