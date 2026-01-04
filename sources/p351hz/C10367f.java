package p351hz;

import java.io.IOException;
import java.io.InputStream;
import p378iz.C10634b;

/* renamed from: hz.f */
/* loaded from: classes9.dex */
public class C10367f extends InputStream {

    /* renamed from: a */
    public InputStream f50109a;

    /* renamed from: b */
    public final C10634b f50110b;

    /* renamed from: c */
    public IOException f50111c = null;

    /* renamed from: d */
    public final byte[] f50112d = new byte[1];

    public C10367f(InputStream inputStream, int i10) {
        inputStream.getClass();
        this.f50109a = inputStream;
        this.f50110b = new C10634b(i10);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f50109a;
        if (inputStream == null) {
            throw new C10379r("Stream closed");
        }
        IOException iOException = this.f50111c;
        if (iOException == null) {
            return inputStream.available();
        }
        throw iOException;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f50109a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f50109a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f50112d, 0, 1) == -1) {
            return -1;
        }
        return this.f50112d[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = this.f50109a;
        if (inputStream == null) {
            throw new C10379r("Stream closed");
        }
        IOException iOException = this.f50111c;
        if (iOException != null) {
            throw iOException;
        }
        try {
            int i12 = inputStream.read(bArr, i10, i11);
            if (i12 == -1) {
                return -1;
            }
            this.f50110b.m65133a(bArr, i10, i12);
            return i12;
        } catch (IOException e10) {
            this.f50111c = e10;
            throw e10;
        }
    }
}
