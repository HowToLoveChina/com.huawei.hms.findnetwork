package com.huawei.hms.network.embedded;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.huawei.hms.network.embedded.kb */
/* loaded from: classes8.dex */
public final class C5988kb implements InterfaceC6183zb {

    /* renamed from: f */
    public static final byte f27324f = 1;

    /* renamed from: g */
    public static final byte f27325g = 2;

    /* renamed from: h */
    public static final byte f27326h = 3;

    /* renamed from: i */
    public static final byte f27327i = 4;

    /* renamed from: j */
    public static final byte f27328j = 0;

    /* renamed from: k */
    public static final byte f27329k = 1;

    /* renamed from: l */
    public static final byte f27330l = 2;

    /* renamed from: m */
    public static final byte f27331m = 3;

    /* renamed from: b */
    public final InterfaceC5896db f27333b;

    /* renamed from: c */
    public final Inflater f27334c;

    /* renamed from: d */
    public final C6027nb f27335d;

    /* renamed from: a */
    public int f27332a = 0;

    /* renamed from: e */
    public final CRC32 f27336e = new CRC32();

    public C5988kb(InterfaceC6183zb interfaceC6183zb) {
        if (interfaceC6183zb == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f27334c = inflater;
        InterfaceC5896db interfaceC5896dbM34934a = C6040ob.m34934a(interfaceC6183zb);
        this.f27333b = interfaceC5896dbM34934a;
        this.f27335d = new C6027nb(interfaceC5896dbM34934a, inflater);
    }

    /* renamed from: a */
    private void m34631a(C5868bb c5868bb, long j10, long j11) {
        C6131vb c6131vb = c5868bb.f26523a;
        while (true) {
            long j12 = c6131vb.f28800c - c6131vb.f28799b;
            if (j10 < j12) {
                break;
            }
            j10 -= j12;
            c6131vb = c6131vb.f28803f;
        }
        while (j11 > 0) {
            int iMin = (int) Math.min(c6131vb.f28800c - r6, j11);
            this.f27336e.update(c6131vb.f28798a, (int) (c6131vb.f28799b + j10), iMin);
            j11 -= iMin;
            c6131vb = c6131vb.f28803f;
            j10 = 0;
        }
    }

    /* renamed from: b */
    private void m34633b() throws IOException {
        this.f27333b.mo33970i(10L);
        byte bM33972j = this.f27333b.mo33924a().m33972j(3L);
        boolean z10 = ((bM33972j >> 1) & 1) == 1;
        if (z10) {
            m34631a(this.f27333b.mo33924a(), 0L, 10L);
        }
        m34632a("ID1ID2", 8075, this.f27333b.readShort());
        this.f27333b.skip(8L);
        if (((bM33972j >> 2) & 1) == 1) {
            this.f27333b.mo33970i(2L);
            if (z10) {
                m34631a(this.f27333b.mo33924a(), 0L, 2L);
            }
            long jMo33973j = this.f27333b.mo33924a().mo33973j();
            this.f27333b.mo33970i(jMo33973j);
            if (z10) {
                m34631a(this.f27333b.mo33924a(), 0L, jMo33973j);
            }
            this.f27333b.skip(jMo33973j);
        }
        if (((bM33972j >> 3) & 1) == 1) {
            long jMo33917a = this.f27333b.mo33917a((byte) 0);
            if (jMo33917a == -1) {
                throw new EOFException();
            }
            if (z10) {
                m34631a(this.f27333b.mo33924a(), 0L, jMo33917a + 1);
            }
            this.f27333b.skip(jMo33917a + 1);
        }
        if (((bM33972j >> 4) & 1) == 1) {
            long jMo33917a2 = this.f27333b.mo33917a((byte) 0);
            if (jMo33917a2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                m34631a(this.f27333b.mo33924a(), 0L, jMo33917a2 + 1);
            }
            this.f27333b.skip(jMo33917a2 + 1);
        }
        if (z10) {
            m34632a("FHCRC", this.f27333b.mo33973j(), (short) this.f27336e.getValue());
            this.f27336e.reset();
        }
    }

    /* renamed from: c */
    private void m34634c() throws IOException {
        m34632a("CRC", this.f27333b.mo33959e(), (int) this.f27336e.getValue());
        m34632a("ISIZE", this.f27333b.mo33959e(), (int) this.f27334c.getBytesWritten());
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void close() throws IOException {
        this.f27335d.close();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
    public long read(C5868bb c5868bb, long j10) throws DataFormatException, IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (j10 == 0) {
            return 0L;
        }
        if (this.f27332a == 0) {
            m34633b();
            this.f27332a = 1;
        }
        if (this.f27332a == 1) {
            long j11 = c5868bb.f26524b;
            long j12 = this.f27335d.read(c5868bb, j10);
            if (j12 != -1) {
                m34631a(c5868bb, j11, j12);
                return j12;
            }
            this.f27332a = 2;
        }
        if (this.f27332a == 2) {
            m34634c();
            this.f27332a = 3;
            if (!this.f27333b.mo33971i()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f27333b.timeout();
    }

    /* renamed from: a */
    private void m34632a(String str, int i10, int i11) throws IOException {
        if (i11 != i10) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }
}
