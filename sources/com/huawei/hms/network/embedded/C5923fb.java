package com.huawei.hms.network.embedded;

import java.io.IOException;
import java.util.zip.Deflater;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* renamed from: com.huawei.hms.network.embedded.fb */
/* loaded from: classes8.dex */
public final class C5923fb implements InterfaceC6170yb {

    /* renamed from: a */
    public final InterfaceC5882cb f26782a;

    /* renamed from: b */
    public final Deflater f26783b;

    /* renamed from: c */
    public boolean f26784c;

    public C5923fb(InterfaceC5882cb interfaceC5882cb, Deflater deflater) {
        if (interfaceC5882cb == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.f26782a = interfaceC5882cb;
        this.f26783b = deflater;
    }

    @IgnoreJRERequirement
    /* renamed from: a */
    private void m34273a(boolean z10) throws IOException {
        C6131vb c6131vbM33961e;
        C5868bb c5868bbMo33924a = this.f26782a.mo33924a();
        while (true) {
            c6131vbM33961e = c5868bbMo33924a.m33961e(1);
            Deflater deflater = this.f26783b;
            byte[] bArr = c6131vbM33961e.f28798a;
            int i10 = c6131vbM33961e.f28800c;
            int i11 = 8192 - i10;
            int iDeflate = z10 ? deflater.deflate(bArr, i10, i11, 2) : deflater.deflate(bArr, i10, i11);
            if (iDeflate > 0) {
                c6131vbM33961e.f28800c += iDeflate;
                c5868bbMo33924a.f26524b += iDeflate;
                this.f26782a.mo33955d();
            } else if (this.f26783b.needsInput()) {
                break;
            }
        }
        if (c6131vbM33961e.f28799b == c6131vbM33961e.f28800c) {
            c5868bbMo33924a.f26523a = c6131vbM33961e.m35704b();
            C6144wb.m35761a(c6131vbM33961e);
        }
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws Throwable {
        if (this.f26784c) {
            return;
        }
        try {
            m34274e();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f26783b.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f26782a.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f26784c = true;
        if (th != null) {
            C5883cc.m34089a(th);
        }
    }

    /* renamed from: e */
    public void m34274e() throws IOException {
        this.f26783b.finish();
        m34273a(false);
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb, java.io.Flushable
    public void flush() throws IOException {
        m34273a(true);
        this.f26782a.flush();
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public C5855ac timeout() {
        return this.f26782a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f26782a + ")";
    }

    @Override // com.huawei.hms.network.embedded.InterfaceC6170yb
    public void write(C5868bb c5868bb, long j10) throws IOException {
        C5883cc.m34088a(c5868bb.f26524b, 0L, j10);
        while (j10 > 0) {
            C6131vb c6131vb = c5868bb.f26523a;
            int iMin = (int) Math.min(j10, c6131vb.f28800c - c6131vb.f28799b);
            this.f26783b.setInput(c6131vb.f28798a, c6131vb.f28799b, iMin);
            m34273a(false);
            long j11 = iMin;
            c5868bb.f26524b -= j11;
            int i10 = c6131vb.f28799b + iMin;
            c6131vb.f28799b = i10;
            if (i10 == c6131vb.f28800c) {
                c5868bb.f26523a = c6131vb.m35704b();
                C6144wb.m35761a(c6131vb);
            }
            j10 -= j11;
        }
    }

    public C5923fb(InterfaceC6170yb interfaceC6170yb, Deflater deflater) {
        this(C6040ob.m34933a(interfaceC6170yb), deflater);
    }
}
