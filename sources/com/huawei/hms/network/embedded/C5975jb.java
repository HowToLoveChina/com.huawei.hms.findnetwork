package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* renamed from: com.huawei.hms.network.embedded.jb */
/* loaded from: classes8.dex */
public final class C5975jb implements InterfaceC6170yb {

    /* renamed from: a */
    public final InterfaceC5882cb f27147a;

    /* renamed from: b */
    public final Deflater f27148b;

    /* renamed from: c */
    public final C5923fb f27149c;

    /* renamed from: d */
    public boolean f27150d;

    /* renamed from: e */
    public final CRC32 f27151e = new CRC32();

    public C5975jb(InterfaceC6170yb interfaceC6170yb) {
        if (interfaceC6170yb == null) {
            throw new IllegalArgumentException("sink == null");
        }
        Deflater deflater = new Deflater(-1, true);
        this.f27148b = deflater;
        InterfaceC5882cb interfaceC5882cbM34933a = C6040ob.m34933a(interfaceC6170yb);
        this.f27147a = interfaceC5882cbM34933a;
        this.f27149c = new C5923fb(interfaceC5882cbM34933a, deflater);
        m34554g();
    }

    /* renamed from: a */
    private void m34552a(C5868bb c5868bb, long j10) {
        C6131vb c6131vb = c5868bb.f26523a;
        while (j10 > 0) {
            int iMin = (int) Math.min(j10, c6131vb.f28800c - c6131vb.f28799b);
            this.f27151e.update(c6131vb.f28798a, c6131vb.f28799b, iMin);
            j10 -= iMin;
            c6131vb = c6131vb.f28803f;
        }
    }

    /* renamed from: f */
    private void m34553f() throws IOException {
        this.f27147a.mo33925a((int) this.f27151e.getValue());
        this.f27147a.mo33925a((int) this.f27148b.getBytesRead());
    }

    /* renamed from: g */
    private void m34554g() {
        C5868bb c5868bbMo33924a = this.f27147a.mo33924a();
        c5868bbMo33924a.writeShort(8075);
        c5868bbMo33924a.writeByte(8);
        c5868bbMo33924a.writeByte(0);
        c5868bbMo33924a.writeInt(0);
        c5868bbMo33924a.writeByte(0);
        c5868bbMo33924a.writeByte(0);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws Throwable {
        if (this.f27150d) {
            return;
        }
        try {
            this.f27149c.m34274e();
            m34553f();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f27148b.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f27147a.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f27150d = true;
        if (th != null) {
            C5883cc.m34089a(th);
        }
    }

    /* renamed from: e */
    public final Deflater m34555e() {
        return this.f27148b;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
    public void flush() throws IOException {
        this.f27149c.flush();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f27147a.timeout();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public void write(C5868bb c5868bb, long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return;
        }
        m34552a(c5868bb, j10);
        this.f27149c.write(c5868bb, j10);
    }
}
