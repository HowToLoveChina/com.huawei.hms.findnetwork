package com.huawei.hms.network.embedded;

import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: com.huawei.hms.network.embedded.nb */
/* loaded from: classes8.dex */
public final class C6027nb implements InterfaceC6183zb {

    /* renamed from: a */
    public final InterfaceC5896db f27594a;

    /* renamed from: b */
    public final Inflater f27595b;

    /* renamed from: c */
    public int f27596c;

    /* renamed from: d */
    public boolean f27597d;

    public C6027nb(InterfaceC5896db interfaceC5896db, Inflater inflater) {
        if (interfaceC5896db == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f27594a = interfaceC5896db;
        this.f27595b = inflater;
    }

    /* renamed from: c */
    private void m34908c() throws IOException {
        int i10 = this.f27596c;
        if (i10 == 0) {
            return;
        }
        int remaining = i10 - this.f27595b.getRemaining();
        this.f27596c -= remaining;
        this.f27594a.skip(remaining);
    }

    /* renamed from: b */
    public final boolean m34909b() throws IOException {
        if (!this.f27595b.needsInput()) {
            return false;
        }
        m34908c();
        if (this.f27595b.getRemaining() != 0) {
            throw new IllegalStateException(Constants.QUESTION_STR);
        }
        if (this.f27594a.mo33971i()) {
            return true;
        }
        C6131vb c6131vb = this.f27594a.mo33924a().f26523a;
        int i10 = c6131vb.f28800c;
        int i11 = c6131vb.f28799b;
        int i12 = i10 - i11;
        this.f27596c = i12;
        this.f27595b.setInput(c6131vb.f28798a, i11, i12);
        return false;
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.huawei.hms.network.embedded.InterfaceC6170yb
    public void close() throws IOException {
        if (this.f27597d) {
            return;
        }
        this.f27595b.end();
        this.f27597d = true;
        this.f27594a.close();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb
    public long read(C5868bb c5868bb, long j10) throws DataFormatException, IOException {
        boolean zM34909b;
        if (j10 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j10);
        }
        if (this.f27597d) {
            throw new IllegalStateException("closed");
        }
        if (j10 == 0) {
            return 0L;
        }
        do {
            zM34909b = m34909b();
            try {
                C6131vb c6131vbM33961e = c5868bb.m33961e(1);
                int iInflate = this.f27595b.inflate(c6131vbM33961e.f28798a, c6131vbM33961e.f28800c, (int) Math.min(j10, 8192 - c6131vbM33961e.f28800c));
                if (iInflate > 0) {
                    c6131vbM33961e.f28800c += iInflate;
                    long j11 = iInflate;
                    c5868bb.f26524b += j11;
                    return j11;
                }
                if (!this.f27595b.finished() && !this.f27595b.needsDictionary()) {
                }
                m34908c();
                if (c6131vbM33961e.f28799b != c6131vbM33961e.f28800c) {
                    return -1L;
                }
                c5868bb.f26523a = c6131vbM33961e.m35704b();
                C6144wb.m35761a(c6131vbM33961e);
                return -1L;
            } catch (DataFormatException e10) {
                throw new IOException(e10);
            }
        } while (!zM34909b);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6183zb, com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f27594a.timeout();
    }

    public C6027nb(InterfaceC6183zb interfaceC6183zb, Inflater inflater) {
        this(C6040ob.m34934a(interfaceC6183zb), inflater);
    }
}
