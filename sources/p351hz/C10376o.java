package p351hz;

import java.io.IOException;
import java.io.InputStream;
import mz.InterfaceC11569f;

/* renamed from: hz.o */
/* loaded from: classes9.dex */
public class C10376o extends InputStream {

    /* renamed from: a */
    public InputStream f50147a;

    /* renamed from: b */
    public final InterfaceC11569f f50148b;

    /* renamed from: c */
    public final byte[] f50149c = new byte[4096];

    /* renamed from: d */
    public int f50150d = 0;

    /* renamed from: e */
    public int f50151e = 0;

    /* renamed from: f */
    public int f50152f = 0;

    /* renamed from: g */
    public boolean f50153g = false;

    /* renamed from: h */
    public IOException f50154h = null;

    /* renamed from: i */
    public final byte[] f50155i = new byte[1];

    public C10376o(InputStream inputStream, InterfaceC11569f interfaceC11569f) {
        inputStream.getClass();
        this.f50147a = inputStream;
        this.f50148b = interfaceC11569f;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f50147a == null) {
            throw new C10379r("Stream closed");
        }
        IOException iOException = this.f50154h;
        if (iOException == null) {
            return this.f50151e;
        }
        throw iOException;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f50147a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f50147a = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f50155i, 0, 1) == -1) {
            return -1;
        }
        return this.f50155i[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        if (i10 < 0 || i11 < 0 || (i12 = i10 + i11) < 0 || i12 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return 0;
        }
        if (this.f50147a == null) {
            throw new C10379r("Stream closed");
        }
        IOException iOException = this.f50154h;
        if (iOException != null) {
            throw iOException;
        }
        int i13 = 0;
        while (true) {
            try {
                int iMin = Math.min(this.f50151e, i11);
                System.arraycopy(this.f50149c, this.f50150d, bArr, i10, iMin);
                int i14 = this.f50150d + iMin;
                this.f50150d = i14;
                int i15 = this.f50151e - iMin;
                this.f50151e = i15;
                i10 += iMin;
                i11 -= iMin;
                i13 += iMin;
                int i16 = this.f50152f;
                if (i14 + i15 + i16 == 4096) {
                    byte[] bArr2 = this.f50149c;
                    System.arraycopy(bArr2, i14, bArr2, 0, i15 + i16);
                    this.f50150d = 0;
                }
                if (i11 == 0 || this.f50153g) {
                    break;
                }
                int i17 = this.f50150d;
                int i18 = this.f50151e;
                int i19 = this.f50152f;
                int i20 = this.f50147a.read(this.f50149c, i17 + i18 + i19, 4096 - ((i17 + i18) + i19));
                if (i20 == -1) {
                    this.f50153g = true;
                    this.f50151e = this.f50152f;
                    this.f50152f = 0;
                } else {
                    int i21 = this.f50152f + i20;
                    this.f50152f = i21;
                    int iMo69042a = this.f50148b.mo69042a(this.f50149c, this.f50150d, i21);
                    this.f50151e = iMo69042a;
                    this.f50152f -= iMo69042a;
                }
            } catch (IOException e10) {
                this.f50154h = e10;
                throw e10;
            }
        }
        if (i13 > 0) {
            return i13;
        }
        return -1;
    }
}
