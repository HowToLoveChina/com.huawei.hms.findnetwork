package p595qy;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import my.C11562e;

/* renamed from: qy.a */
/* loaded from: classes9.dex */
public abstract class AbstractC12429a extends OutputStream {

    /* renamed from: b */
    public int f57271b;

    /* renamed from: c */
    public int f57272c;

    /* renamed from: d */
    public byte[] f57273d;

    /* renamed from: e */
    public int f57274e;

    /* renamed from: a */
    public final List<byte[]> f57270a = new ArrayList();

    /* renamed from: f */
    public boolean f57275f = true;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    /* renamed from: d */
    public void m74620d(int i10) {
        if (this.f57271b < this.f57270a.size() - 1) {
            this.f57272c += this.f57273d.length;
            int i11 = this.f57271b + 1;
            this.f57271b = i11;
            this.f57273d = this.f57270a.get(i11);
            return;
        }
        byte[] bArr = this.f57273d;
        if (bArr == null) {
            this.f57272c = 0;
        } else {
            i10 = Math.max(bArr.length << 1, i10 - this.f57272c);
            this.f57272c += this.f57273d.length;
        }
        this.f57271b++;
        byte[] bArrM69022c = C11562e.m69022c(i10);
        this.f57273d = bArrM69022c;
        this.f57270a.add(bArrM69022c);
    }

    /* renamed from: s */
    public abstract byte[] mo74621s();

    /* renamed from: t */
    public byte[] m74622t() {
        int i10 = this.f57274e;
        if (i10 == 0) {
            return C11562e.f53609b;
        }
        byte[] bArrM69022c = C11562e.m69022c(i10);
        int i11 = 0;
        for (byte[] bArr : this.f57270a) {
            int iMin = Math.min(bArr.length, i10);
            System.arraycopy(bArr, 0, bArrM69022c, i11, iMin);
            i11 += iMin;
            i10 -= iMin;
            if (i10 == 0) {
                break;
            }
        }
        return bArrM69022c;
    }

    @Deprecated
    public String toString() {
        return new String(mo74621s(), Charset.defaultCharset());
    }

    /* renamed from: u */
    public String m74623u(Charset charset) {
        return new String(mo74621s(), charset);
    }

    /* renamed from: v */
    public void m74624v(int i10) {
        int i11 = this.f57274e;
        int i12 = i11 - this.f57272c;
        if (i12 == this.f57273d.length) {
            m74620d(i11 + 1);
            i12 = 0;
        }
        this.f57273d[i12] = (byte) i10;
        this.f57274e++;
    }

    /* renamed from: w */
    public void m74625w(byte[] bArr, int i10, int i11) {
        int i12 = this.f57274e;
        int i13 = i12 + i11;
        int i14 = i12 - this.f57272c;
        int i15 = i11;
        while (i15 > 0) {
            int iMin = Math.min(i15, this.f57273d.length - i14);
            System.arraycopy(bArr, (i10 + i11) - i15, this.f57273d, i14, iMin);
            i15 -= iMin;
            if (i15 > 0) {
                m74620d(i13);
                i14 = 0;
            }
        }
        this.f57274e = i13;
    }
}
