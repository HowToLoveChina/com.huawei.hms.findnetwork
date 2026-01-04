package com.huawei.hms.network.embedded;

import java.io.IOException;

/* renamed from: com.huawei.hms.network.embedded.qb */
/* loaded from: classes8.dex */
public final class C6066qb implements InterfaceC6183zb {

    /* renamed from: a */
    public final InterfaceC5896db f27946a;

    /* renamed from: b */
    public final C5868bb f27947b;

    /* renamed from: c */
    public C6131vb f27948c;

    /* renamed from: d */
    public int f27949d;

    /* renamed from: e */
    public boolean f27950e;

    /* renamed from: f */
    public long f27951f;

    public C6066qb(InterfaceC5896db interfaceC5896db) {
        this.f27946a = interfaceC5896db;
        C5868bb c5868bbMo33924a = interfaceC5896db.mo33924a();
        this.f27947b = c5868bbMo33924a;
        C6131vb c6131vb = c5868bbMo33924a.f26523a;
        this.f27948c = c6131vb;
        this.f27949d = c6131vb != null ? c6131vb.f28799b : -1;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void close() throws IOException {
        this.f27950e = true;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
    public long read(C5868bb c5868bb, long j10) throws IOException {
        C6131vb c6131vb;
        C6131vb c6131vb2;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f27950e) {
            throw new IllegalStateException("closed");
        }
        C6131vb c6131vb3 = this.f27948c;
        if (c6131vb3 != null && (c6131vb3 != (c6131vb2 = this.f27947b.f26523a) || this.f27949d != c6131vb2.f28799b)) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        if (j10 == 0) {
            return 0L;
        }
        if (!this.f27946a.mo33969h(this.f27951f + 1)) {
            return -1L;
        }
        if (this.f27948c == null && (c6131vb = this.f27947b.f26523a) != null) {
            this.f27948c = c6131vb;
            this.f27949d = c6131vb.f28799b;
        }
        long jMin = Math.min(j10, this.f27947b.f26524b - this.f27951f);
        this.f27947b.m33927a(c5868bb, this.f27951f, jMin);
        this.f27951f += jMin;
        return jMin;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f27946a.timeout();
    }
}
