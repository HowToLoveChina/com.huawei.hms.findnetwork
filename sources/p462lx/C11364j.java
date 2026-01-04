package p462lx;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: lx.j */
/* loaded from: classes9.dex */
public class C11364j extends OutputStream {

    /* renamed from: b */
    public OutputStream f53077b;

    /* renamed from: a */
    public long f53076a = 0;

    /* renamed from: c */
    public boolean f53078c = false;

    public C11364j(OutputStream outputStream) {
        this.f53077b = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    /* renamed from: s */
    public void m68188s() throws IOException {
        this.f53078c = true;
    }

    /* renamed from: t */
    public long m68189t() {
        return this.f53076a;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.f53078c) {
            this.f53077b.write(bArr, i10, i11);
            this.f53076a += i11;
            return;
        }
        throw new IllegalStateException("ZipEntryOutputStream is closed");
    }
}
