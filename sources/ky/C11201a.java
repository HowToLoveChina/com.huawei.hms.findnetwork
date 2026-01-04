package ky;

import java.io.IOException;
import java.io.InputStream;
import my.C11562e;
import p377iy.AbstractC10632a;

/* renamed from: ky.a */
/* loaded from: classes9.dex */
public class C11201a extends AbstractC10632a {

    /* renamed from: b */
    public InputStream f52525b;

    /* renamed from: c */
    public C11202b f52526c;

    /* renamed from: d */
    public long f52527d;

    /* renamed from: e */
    public final byte[] f52528e;

    public C11201a(C11202b c11202b) {
        this.f52528e = new byte[1];
        this.f52526c = c11202b;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        C11202b c11202b = this.f52526c;
        if (c11202b != null) {
            return c11202b.available();
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            m67213s();
            InputStream inputStream = this.f52525b;
            if (inputStream != null) {
                inputStream.close();
                this.f52525b = null;
            }
        } catch (Throwable th2) {
            if (this.f52525b != null) {
                this.f52525b.close();
                this.f52525b = null;
            }
            throw th2;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        C11202b c11202b = this.f52526c;
        if (c11202b == null) {
            return -1;
        }
        try {
            int iM67230x = c11202b.m67230x(bArr, i10, i11);
            this.f52527d = this.f52526c.m67231y();
            m65131d(iM67230x);
            if (iM67230x == -1) {
                m67213s();
            }
            return iM67230x;
        } catch (RuntimeException e10) {
            throw new IOException("Invalid Deflate64 input", e10);
        }
    }

    /* renamed from: s */
    public final void m67213s() throws IOException {
        C11562e.m69026g(this.f52526c);
        this.f52526c = null;
    }

    public C11201a(InputStream inputStream) {
        this(new C11202b(inputStream));
        this.f52525b = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i10;
        do {
            i10 = read(this.f52528e);
            if (i10 == -1) {
                return -1;
            }
        } while (i10 == 0);
        if (i10 == 1) {
            return this.f52528e[0] & 255;
        }
        throw new IllegalStateException("Invalid return value from read: " + i10);
    }
}
