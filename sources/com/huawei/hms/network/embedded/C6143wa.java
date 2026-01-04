package com.huawei.hms.network.embedded;

import com.google.flatbuffers.reflection.BaseType;
import com.huawei.hms.network.embedded.C5868bb;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;

/* renamed from: com.huawei.hms.network.embedded.wa */
/* loaded from: classes8.dex */
public final class C6143wa {

    /* renamed from: t */
    public static final int f28883t = 65535;

    /* renamed from: a */
    public final boolean f28884a;

    /* renamed from: b */
    public final InterfaceC5896db f28885b;

    /* renamed from: c */
    public final a f28886c;

    /* renamed from: d */
    public boolean f28887d;

    /* renamed from: e */
    public int f28888e;

    /* renamed from: f */
    public long f28889f;

    /* renamed from: g */
    public boolean f28890g;

    /* renamed from: h */
    public boolean f28891h;

    /* renamed from: i */
    public boolean f28892i;

    /* renamed from: j */
    public boolean f28893j;

    /* renamed from: k */
    public C5868bb f28894k;

    /* renamed from: l */
    public C6027nb f28895l;

    /* renamed from: m */
    public C5868bb f28896m;

    /* renamed from: n */
    public C5868bb f28897n;

    /* renamed from: o */
    public Inflater f28898o;

    /* renamed from: p */
    public final C5868bb f28899p;

    /* renamed from: q */
    public final C5868bb f28900q;

    /* renamed from: r */
    public final byte[] f28901r;

    /* renamed from: s */
    public final C5868bb.c f28902s;

    /* renamed from: com.huawei.hms.network.embedded.wa$a */
    public interface a {
        /* renamed from: a */
        void mo35524a(C5910eb c5910eb);

        /* renamed from: a */
        void mo35529a(String str) throws IOException;

        /* renamed from: b */
        void mo35534b(int i10, String str);

        /* renamed from: c */
        void mo35538c(C5910eb c5910eb);

        /* renamed from: d */
        void mo35540d(C5910eb c5910eb) throws IOException;
    }

    public C6143wa(boolean z10, InterfaceC5896db interfaceC5896db, C6117ua c6117ua, boolean z11, boolean z12) {
        this(z10, interfaceC5896db, c6117ua);
        this.f28892i = z11;
        this.f28893j = z12;
        m35753b();
    }

    /* renamed from: b */
    private void m35753b() {
        if (this.f28892i) {
            this.f28894k = new C5868bb();
            this.f28896m = new C5868bb();
            this.f28897n = new C5868bb();
            Inflater inflater = new Inflater(true);
            this.f28898o = inflater;
            this.f28895l = new C6027nb((InterfaceC5896db) this.f28896m, inflater);
        }
    }

    /* renamed from: c */
    private void m35754c() throws IOException {
        short s10;
        String strMo33979o;
        long j10 = this.f28889f;
        if (j10 > 0) {
            this.f28885b.mo33941a(this.f28899p, j10);
            if (!this.f28884a) {
                this.f28899p.m33923a(this.f28902s);
                this.f28902s.m33993k(0L);
                C6130va.m35698a(this.f28902s, this.f28901r);
                this.f28902s.close();
            }
        }
        switch (this.f28888e) {
            case 8:
                long jM33913B = this.f28899p.m33913B();
                if (jM33913B == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (jM33913B != 0) {
                    s10 = this.f28899p.readShort();
                    strMo33979o = this.f28899p.mo33979o();
                    String strM35696a = C6130va.m35696a(s10);
                    if (strM35696a != null) {
                        throw new ProtocolException(strM35696a);
                    }
                } else {
                    s10 = 1005;
                    strMo33979o = "";
                }
                this.f28886c.mo35534b(s10, strMo33979o);
                this.f28887d = true;
                return;
            case 9:
                this.f28886c.mo35538c(this.f28899p.mo33982r());
                return;
            case 10:
                this.f28886c.mo35524a(this.f28899p.mo33982r());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f28888e));
        }
    }

    /* renamed from: d */
    private void m35755d() throws IOException {
        if (this.f28887d) {
            throw new IOException("closed");
        }
        long jMo33847e = this.f28885b.timeout().mo33847e();
        this.f28885b.timeout().mo33844b();
        try {
            byte b10 = this.f28885b.readByte();
            this.f28885b.timeout().timeout(jMo33847e, TimeUnit.NANOSECONDS);
            this.f28888e = b10 & BaseType.Obj;
            boolean z10 = (b10 & 128) != 0;
            this.f28890g = z10;
            boolean z11 = (b10 & 8) != 0;
            this.f28891h = z11;
            if (z11 && !z10) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z12 = (b10 & 64) != 0;
            boolean z13 = (b10 & 32) != 0;
            boolean z14 = (b10 & BaseType.Union) != 0;
            if (!this.f28892i && (z12 || z13 || z14)) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            byte b11 = this.f28885b.readByte();
            boolean z15 = (b11 & 128) != 0;
            boolean z16 = this.f28884a;
            if (z15 == z16) {
                throw new ProtocolException(z16 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j10 = b11 & 127;
            this.f28889f = j10;
            if (j10 == 126) {
                this.f28889f = this.f28885b.readShort() & C6130va.f28792s;
            } else if (j10 == 127) {
                long j11 = this.f28885b.readLong();
                this.f28889f = j11;
                if (j11 < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f28889f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.f28891h && this.f28889f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z15) {
                this.f28885b.readFully(this.f28901r);
            }
        } catch (Throwable th2) {
            this.f28885b.timeout().timeout(jMo33847e, TimeUnit.NANOSECONDS);
            throw th2;
        }
    }

    /* renamed from: e */
    private void m35756e() throws IOException {
        while (!this.f28887d) {
            long j10 = this.f28889f;
            if (j10 > 0) {
                this.f28885b.mo33941a(this.f28900q, j10);
                if (!this.f28884a) {
                    this.f28900q.m33923a(this.f28902s);
                    this.f28902s.m33993k(this.f28900q.m33913B() - this.f28889f);
                    C6130va.m35698a(this.f28902s, this.f28901r);
                    this.f28902s.close();
                }
            }
            if (this.f28890g) {
                return;
            }
            m35758g();
            if (this.f28888e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f28888e));
            }
        }
        throw new IOException("closed");
    }

    /* renamed from: f */
    private void m35757f() throws IOException {
        int i10 = this.f28888e;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i10));
        }
        m35756e();
        if (!this.f28892i || this.f28900q.m33913B() <= 0) {
            if (i10 == 1) {
                this.f28886c.mo35529a(this.f28900q.mo33979o());
                return;
            } else {
                this.f28886c.mo35540d(this.f28900q.mo33982r());
                return;
            }
        }
        try {
            m35752a(i10, this.f28900q);
        } catch (Exception e10) {
            C6013ma.m34863f().mo34331a(5, e10.getMessage(), e10);
            throw new IOException(e10);
        }
    }

    /* renamed from: g */
    private void m35758g() throws IOException {
        while (!this.f28887d) {
            m35755d();
            if (!this.f28891h) {
                return;
            } else {
                m35754c();
            }
        }
    }

    /* renamed from: a */
    public void m35759a() throws IOException {
        m35755d();
        if (this.f28891h) {
            m35754c();
        } else {
            m35757f();
        }
    }

    public C6143wa(boolean z10, InterfaceC5896db interfaceC5896db, a aVar) {
        this.f28892i = false;
        this.f28899p = new C5868bb();
        this.f28900q = new C5868bb();
        if (interfaceC5896db == null) {
            throw new NullPointerException("source == null");
        }
        if (aVar == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.f28884a = z10;
        this.f28885b = interfaceC5896db;
        this.f28886c = aVar;
        this.f28901r = z10 ? null : new byte[4];
        this.f28902s = z10 ? null : new C5868bb.c();
    }

    /* renamed from: a */
    private void m35752a(int i10, C5868bb c5868bb) throws IOException {
        if (this.f28893j) {
            this.f28898o.reset();
        }
        this.f28896m.write(c5868bb, c5868bb.m33913B());
        if (!this.f28893j) {
            this.f28896m.writeInt(65535);
        }
        this.f28896m.flush();
        while (this.f28895l.read(this.f28894k, Long.MAX_VALUE) != -1) {
            try {
                C5868bb c5868bb2 = this.f28894k;
                c5868bb.write(c5868bb2, c5868bb2.m33913B());
                if (this.f28895l.m34909b()) {
                    break;
                }
            } catch (EOFException e10) {
                C6013ma.m34863f().mo34331a(4, e10.getMessage(), e10);
            }
        }
        a aVar = this.f28886c;
        if (i10 == 1) {
            aVar.mo35529a(c5868bb.mo33979o());
        } else {
            aVar.mo35540d(c5868bb.mo33982r());
        }
    }
}
