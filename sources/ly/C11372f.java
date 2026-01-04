package ly;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

/* renamed from: ly.f */
/* loaded from: classes9.dex */
public class C11372f extends CheckedInputStream {

    /* renamed from: a */
    public long f53099a;

    /* renamed from: b */
    public final long f53100b;

    public C11372f(Checksum checksum, InputStream inputStream, long j10, long j11) {
        super(inputStream, checksum);
        this.f53100b = j11;
        this.f53099a = j10;
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        int i12 = super.read(bArr, i10, i11);
        if (i12 >= 0) {
            this.f53099a -= i12;
        }
        m68221t();
        return i12;
    }

    /* renamed from: s */
    public long m68220s() {
        return this.f53099a;
    }

    /* renamed from: t */
    public final void m68221t() throws IOException {
        if (this.f53099a <= 0 && this.f53100b != getChecksum().getValue()) {
            throw new IOException("Checksum verification failed");
        }
    }

    @Override // java.util.zip.CheckedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f53099a <= 0) {
            return -1;
        }
        int i10 = super.read();
        if (i10 >= 0) {
            this.f53099a--;
        }
        m68221t();
        return i10;
    }
}
