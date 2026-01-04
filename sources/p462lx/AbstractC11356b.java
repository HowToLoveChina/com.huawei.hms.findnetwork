package p462lx;

import java.io.IOException;
import java.io.OutputStream;
import mx.C11557q;
import p300fx.InterfaceC9781c;

/* renamed from: lx.b */
/* loaded from: classes9.dex */
public abstract class AbstractC11356b<T extends InterfaceC9781c> extends OutputStream {

    /* renamed from: a */
    public C11364j f53063a;

    /* renamed from: b */
    public T f53064b;

    public AbstractC11356b(C11364j c11364j, C11557q c11557q, char[] cArr, boolean z10) throws IOException {
        this.f53063a = c11364j;
        this.f53064b = (T) mo68164v(c11364j, c11557q, cArr, z10);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f53063a.close();
    }

    /* renamed from: s */
    public void mo68163s() throws IOException {
        this.f53063a.m68188s();
    }

    /* renamed from: t */
    public T m68167t() {
        return this.f53064b;
    }

    /* renamed from: u */
    public long m68168u() {
        return this.f53063a.m68189t();
    }

    /* renamed from: v */
    public abstract T mo68164v(OutputStream outputStream, C11557q c11557q, char[] cArr, boolean z10) throws IOException;

    /* renamed from: w */
    public void m68169w(byte[] bArr) throws IOException {
        this.f53063a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f53063a.write(i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.f53063a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f53064b.mo60839a(bArr, i10, i11);
        this.f53063a.write(bArr, i10, i11);
    }
}
