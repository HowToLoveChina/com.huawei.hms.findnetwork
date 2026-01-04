package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5868bb;
import java.io.IOException;
import java.util.Random;

/* renamed from: com.huawei.hms.network.embedded.xa */
/* loaded from: classes8.dex */
public final class C6156xa {

    /* renamed from: a */
    public final boolean f29088a;

    /* renamed from: b */
    public final Random f29089b;

    /* renamed from: c */
    public final InterfaceC5882cb f29090c;

    /* renamed from: d */
    public final C5868bb f29091d;

    /* renamed from: e */
    public boolean f29092e;

    /* renamed from: f */
    public final C5868bb f29093f;

    /* renamed from: g */
    public final a f29094g;

    /* renamed from: h */
    public boolean f29095h;

    /* renamed from: i */
    public boolean f29096i;

    /* renamed from: j */
    public final byte[] f29097j;

    /* renamed from: k */
    public final C5868bb.c f29098k;

    /* renamed from: com.huawei.hms.network.embedded.xa$a */
    public final class a implements InterfaceC6170yb {

        /* renamed from: a */
        public int f29099a;

        /* renamed from: b */
        public long f29100b;

        /* renamed from: c */
        public boolean f29101c;

        /* renamed from: d */
        public boolean f29102d;

        public a() {
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.f29102d) {
                throw new IOException("closed");
            }
            C6156xa c6156xa = C6156xa.this;
            c6156xa.m35809a(this.f29099a, c6156xa.f29093f.m33913B(), this.f29101c, true);
            this.f29102d = true;
            C6156xa.this.f29095h = false;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
        public void flush() throws IOException {
            if (this.f29102d) {
                throw new IOException("closed");
            }
            C6156xa c6156xa = C6156xa.this;
            c6156xa.m35809a(this.f29099a, c6156xa.f29093f.m33913B(), this.f29101c, false);
            this.f29101c = false;
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public C5855ac timeout() {
            return C6156xa.this.f29090c.timeout();
        }

        @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
        public void write(C5868bb c5868bb, long j10) throws IOException {
            if (this.f29102d) {
                throw new IOException("closed");
            }
            C6156xa.this.f29093f.write(c5868bb, j10);
            boolean z10 = this.f29101c && this.f29100b != -1 && C6156xa.this.f29093f.m33913B() > this.f29100b - 8192;
            long jM33984t = C6156xa.this.f29093f.m33984t();
            if (jM33984t <= 0 || z10) {
                return;
            }
            C6156xa.this.m35809a(this.f29099a, jM33984t, this.f29101c, false);
            this.f29101c = false;
        }
    }

    public C6156xa(boolean z10, InterfaceC5882cb interfaceC5882cb, Random random) {
        this.f29093f = new C5868bb();
        this.f29094g = new a();
        this.f29096i = false;
        if (interfaceC5882cb == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.f29088a = z10;
        this.f29090c = interfaceC5882cb;
        this.f29091d = interfaceC5882cb.mo33924a();
        this.f29089b = random;
        this.f29097j = z10 ? new byte[4] : null;
        this.f29098k = z10 ? new C5868bb.c() : null;
    }

    /* renamed from: b */
    private void m35807b(int i10, C5910eb c5910eb) throws IOException {
        if (this.f29092e) {
            throw new IOException("closed");
        }
        int iMo34192j = c5910eb.mo34192j();
        if (iMo34192j > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f29091d.writeByte(i10 | 128);
        if (this.f29088a) {
            this.f29091d.writeByte(iMo34192j | 128);
            this.f29089b.nextBytes(this.f29097j);
            this.f29091d.write(this.f29097j);
            if (iMo34192j > 0) {
                long jM33913B = this.f29091d.m33913B();
                this.f29091d.mo33928a(c5910eb);
                this.f29091d.m33923a(this.f29098k);
                this.f29098k.m33993k(jM33913B);
                C6130va.m35698a(this.f29098k, this.f29097j);
                this.f29098k.close();
            }
        } else {
            this.f29091d.writeByte(iMo34192j);
            this.f29091d.mo33928a(c5910eb);
        }
        this.f29090c.flush();
    }

    /* renamed from: a */
    public InterfaceC6170yb m35808a(int i10, long j10) {
        if (this.f29095h) {
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        this.f29095h = true;
        a aVar = this.f29094g;
        aVar.f29099a = i10;
        aVar.f29100b = j10;
        aVar.f29101c = true;
        aVar.f29102d = false;
        return aVar;
    }

    public C6156xa(boolean z10, InterfaceC5882cb interfaceC5882cb, Random random, boolean z11) {
        this(z10, interfaceC5882cb, random);
        this.f29096i = z11;
    }

    /* renamed from: a */
    public void m35809a(int i10, long j10, boolean z10, boolean z11) throws IOException {
        if (this.f29092e) {
            throw new IOException("closed");
        }
        if (!z10) {
            i10 = 0;
        }
        if (z11) {
            i10 |= 128;
        }
        if (this.f29096i) {
            i10 |= 64;
        }
        this.f29091d.writeByte(i10);
        int i11 = this.f29088a ? 128 : 0;
        if (j10 <= 125) {
            this.f29091d.writeByte(((int) j10) | i11);
        } else if (j10 <= C6130va.f28792s) {
            this.f29091d.writeByte(i11 | 126);
            this.f29091d.writeShort((int) j10);
        } else {
            this.f29091d.writeByte(i11 | 127);
            this.f29091d.writeLong(j10);
        }
        if (this.f29088a) {
            this.f29089b.nextBytes(this.f29097j);
            this.f29091d.write(this.f29097j);
            if (j10 > 0) {
                long jM33913B = this.f29091d.m33913B();
                this.f29091d.write(this.f29093f, j10);
                this.f29091d.m33923a(this.f29098k);
                this.f29098k.m33993k(jM33913B);
                C6130va.m35698a(this.f29098k, this.f29097j);
                this.f29098k.close();
            }
        } else {
            this.f29091d.write(this.f29093f, j10);
        }
        this.f29090c.mo33954c();
    }

    /* renamed from: b */
    public void m35812b(C5910eb c5910eb) throws IOException {
        m35807b(10, c5910eb);
    }

    /* renamed from: a */
    public void m35810a(int i10, C5910eb c5910eb) throws IOException {
        C5910eb c5910ebMo33982r = C5910eb.f26711f;
        if (i10 != 0 || c5910eb != null) {
            if (i10 != 0) {
                C6130va.m35699b(i10);
            }
            C5868bb c5868bb = new C5868bb();
            c5868bb.writeShort(i10);
            if (c5910eb != null) {
                c5868bb.mo33928a(c5910eb);
            }
            c5910ebMo33982r = c5868bb.mo33982r();
        }
        try {
            m35807b(8, c5910ebMo33982r);
        } finally {
            this.f29092e = true;
        }
    }

    /* renamed from: a */
    public void m35811a(C5910eb c5910eb) throws IOException {
        m35807b(9, c5910eb);
    }
}
