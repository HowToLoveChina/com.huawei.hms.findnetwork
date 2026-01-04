package p301fy;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/* renamed from: fy.g */
/* loaded from: classes9.dex */
public final class C9789g extends InputStream {

    /* renamed from: a */
    public final ByteBuffer f48133a;

    /* renamed from: b */
    public final SeekableByteChannel f48134b;

    /* renamed from: c */
    public long f48135c;

    public C9789g(SeekableByteChannel seekableByteChannel, long j10) {
        this.f48134b = seekableByteChannel;
        this.f48135c = j10;
        if (j10 >= 8192 || j10 <= 0) {
            this.f48133a = ByteBuffer.allocate(8192);
        } else {
            this.f48133a = ByteBuffer.allocate((int) j10);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: d */
    public final int m60866d(int i10) throws IOException {
        this.f48133a.rewind().limit(i10);
        int i11 = this.f48134b.read(this.f48133a);
        this.f48133a.flip();
        return i11;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        ByteBuffer byteBufferAllocate;
        int iM60866d;
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f48135c;
        if (j10 <= 0) {
            return -1;
        }
        if (i11 > j10) {
            i11 = (int) j10;
        }
        if (i11 <= this.f48133a.capacity()) {
            byteBufferAllocate = this.f48133a;
            iM60866d = m60866d(i11);
        } else {
            byteBufferAllocate = ByteBuffer.allocate(i11);
            iM60866d = this.f48134b.read(byteBufferAllocate);
            byteBufferAllocate.flip();
        }
        if (iM60866d >= 0) {
            byteBufferAllocate.get(bArr, i10, iM60866d);
            this.f48135c -= iM60866d;
        }
        return iM60866d;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j10 = this.f48135c;
        if (j10 <= 0) {
            return -1;
        }
        this.f48135c = j10 - 1;
        int iM60866d = m60866d(1);
        return iM60866d < 0 ? iM60866d : this.f48133a.get() & 255;
    }
}
