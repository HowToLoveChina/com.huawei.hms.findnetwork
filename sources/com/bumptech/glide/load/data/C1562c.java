package com.bumptech.glide.load.data;

import java.io.IOException;
import java.io.OutputStream;
import p003a2.InterfaceC0007b;

/* renamed from: com.bumptech.glide.load.data.c */
/* loaded from: classes.dex */
public final class C1562c extends OutputStream {

    /* renamed from: a */
    public final OutputStream f6942a;

    /* renamed from: b */
    public byte[] f6943b;

    /* renamed from: c */
    public InterfaceC0007b f6944c;

    /* renamed from: d */
    public int f6945d;

    public C1562c(OutputStream outputStream, InterfaceC0007b interfaceC0007b) {
        this(outputStream, interfaceC0007b, 65536);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f6942a.close();
            m9029u();
        } catch (Throwable th2) {
            this.f6942a.close();
            throw th2;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        m9027s();
        this.f6942a.flush();
    }

    /* renamed from: s */
    public final void m9027s() throws IOException {
        int i10 = this.f6945d;
        if (i10 > 0) {
            this.f6942a.write(this.f6943b, 0, i10);
            this.f6945d = 0;
        }
    }

    /* renamed from: t */
    public final void m9028t() throws IOException {
        if (this.f6945d == this.f6943b.length) {
            m9027s();
        }
    }

    /* renamed from: u */
    public final void m9029u() {
        byte[] bArr = this.f6943b;
        if (bArr != null) {
            this.f6944c.put(bArr);
            this.f6943b = null;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f6943b;
        int i11 = this.f6945d;
        this.f6945d = i11 + 1;
        bArr[i11] = (byte) i10;
        m9028t();
    }

    public C1562c(OutputStream outputStream, InterfaceC0007b interfaceC0007b, int i10) {
        this.f6942a = outputStream;
        this.f6944c = interfaceC0007b;
        this.f6943b = (byte[]) interfaceC0007b.mo10c(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f6945d;
            if (i15 == 0 && i13 >= this.f6943b.length) {
                this.f6942a.write(bArr, i14, i13);
                return;
            }
            int iMin = Math.min(i13, this.f6943b.length - i15);
            System.arraycopy(bArr, i14, this.f6943b, this.f6945d, iMin);
            this.f6945d += iMin;
            i12 += iMin;
            m9028t();
        } while (i12 < i11);
    }
}
