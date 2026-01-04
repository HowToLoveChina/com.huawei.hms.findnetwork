package p630s2;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: s2.c */
/* loaded from: classes.dex */
public final class C12668c extends FilterInputStream {

    /* renamed from: a */
    public final long f58168a;

    /* renamed from: b */
    public int f58169b;

    public C12668c(InputStream inputStream, long j10) {
        super(inputStream);
        this.f58168a = j10;
    }

    /* renamed from: e */
    public static InputStream m76253e(InputStream inputStream, long j10) {
        return new C12668c(inputStream, j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f58168a - this.f58169b, ((FilterInputStream) this).in.available());
    }

    /* renamed from: d */
    public final int m76254d(int i10) throws IOException {
        if (i10 >= 0) {
            this.f58169b += i10;
        } else if (this.f58168a - this.f58169b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f58168a + ", but read: " + this.f58169b);
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int i10;
        i10 = super.read();
        m76254d(i10 >= 0 ? 1 : -1);
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        return m76254d(super.read(bArr, i10, i11));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
