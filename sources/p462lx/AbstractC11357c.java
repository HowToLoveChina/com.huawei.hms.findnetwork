package p462lx;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: lx.c */
/* loaded from: classes9.dex */
public abstract class AbstractC11357c extends OutputStream {

    /* renamed from: a */
    public AbstractC11356b<?> f53065a;

    public AbstractC11357c(AbstractC11356b<?> abstractC11356b) {
        this.f53065a = abstractC11356b;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f53065a.close();
    }

    /* renamed from: s */
    public void mo68170s() throws IOException {
        this.f53065a.mo68163s();
    }

    /* renamed from: t */
    public long m68171t() {
        return this.f53065a.m68168u();
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
        this.f53065a.write(bArr, i10, i11);
    }
}
