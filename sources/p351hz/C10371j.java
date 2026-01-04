package p351hz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import kz.C11205b;
import p411jz.C10962a;
import p463lz.C11381c;

/* renamed from: hz.j */
/* loaded from: classes9.dex */
public class C10371j extends InputStream {

    /* renamed from: a */
    public final C10364c f50114a;

    /* renamed from: b */
    public DataInputStream f50115b;

    /* renamed from: c */
    public C10962a f50116c;

    /* renamed from: d */
    public C11381c f50117d;

    /* renamed from: e */
    public C11205b f50118e;

    /* renamed from: f */
    public int f50119f;

    /* renamed from: g */
    public boolean f50120g;

    /* renamed from: h */
    public boolean f50121h;

    /* renamed from: i */
    public boolean f50122i;

    /* renamed from: j */
    public boolean f50123j;

    /* renamed from: k */
    public IOException f50124k;

    /* renamed from: l */
    public final byte[] f50125l;

    public C10371j(InputStream inputStream, int i10) {
        this(inputStream, i10, null);
    }

    /* renamed from: u */
    public static int m63799u(int i10) {
        if (i10 >= 4096 && i10 <= 2147483632) {
            return (i10 + 15) & (-16);
        }
        throw new IllegalArgumentException("Unsupported dictionary size " + i10);
    }

    /* renamed from: v */
    public static int m63800v(int i10) {
        return (m63799u(i10) / 1024) + 104;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        DataInputStream dataInputStream = this.f50115b;
        if (dataInputStream == null) {
            throw new C10379r("Stream closed");
        }
        IOException iOException = this.f50124k;
        if (iOException != null) {
            throw iOException;
        }
        boolean z10 = this.f50120g;
        int i10 = this.f50119f;
        return z10 ? i10 : Math.min(i10, dataInputStream.available());
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f50115b != null) {
            m63803w();
            try {
                this.f50115b.close();
            } finally {
                this.f50115b = null;
            }
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f50125l, 0, 1) == -1) {
            return -1;
        }
        return this.f50125l[0] & 255;
    }

    /* renamed from: s */
    public final void m63801s() throws IOException {
        int unsignedByte = this.f50115b.readUnsignedByte();
        if (unsignedByte == 0) {
            this.f50123j = true;
            m63803w();
            return;
        }
        if (unsignedByte >= 224 || unsignedByte == 1) {
            this.f50122i = true;
            this.f50121h = false;
            this.f50116c.m66169k();
        } else if (this.f50121h) {
            throw new C10366e();
        }
        if (unsignedByte < 128) {
            if (unsignedByte > 2) {
                throw new C10366e();
            }
            this.f50120g = false;
            this.f50119f = this.f50115b.readUnsignedShort() + 1;
            return;
        }
        this.f50120g = true;
        int i10 = (unsignedByte & 31) << 16;
        this.f50119f = i10;
        this.f50119f = i10 + this.f50115b.readUnsignedShort() + 1;
        int unsignedShort = this.f50115b.readUnsignedShort() + 1;
        if (unsignedByte >= 192) {
            this.f50122i = false;
            m63802t();
        } else {
            if (this.f50122i) {
                throw new C10366e();
            }
            if (unsignedByte >= 160) {
                this.f50118e.mo67247b();
            }
        }
        this.f50117d.m68246h(this.f50115b, unsignedShort);
    }

    /* renamed from: t */
    public final void m63802t() throws IOException {
        int unsignedByte = this.f50115b.readUnsignedByte();
        if (unsignedByte > 224) {
            throw new C10366e();
        }
        int i10 = unsignedByte / 45;
        int i11 = unsignedByte - (i10 * 45);
        int i12 = i11 / 9;
        int i13 = i11 - (i12 * 9);
        if (i13 + i12 > 4) {
            throw new C10366e();
        }
        this.f50118e = new C11205b(this.f50116c, this.f50117d, i13, i12, i10);
    }

    /* renamed from: w */
    public final void m63803w() {
        C10962a c10962a = this.f50116c;
        if (c10962a != null) {
            c10962a.m66165g(this.f50114a);
            this.f50116c = null;
            this.f50117d.m68247i(this.f50114a);
            this.f50117d = null;
        }
    }

    public C10371j(InputStream inputStream, int i10, byte[] bArr) {
        this(inputStream, i10, bArr, C10364c.m63794b());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        if (i10 < 0 || i11 < 0 || (i12 = i10 + i11) < 0 || i12 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i13 = 0;
        if (i11 == 0) {
            return 0;
        }
        if (this.f50115b == null) {
            throw new C10379r("Stream closed");
        }
        IOException iOException = this.f50124k;
        if (iOException != null) {
            throw iOException;
        }
        if (this.f50123j) {
            return -1;
        }
        while (i11 > 0) {
            try {
                if (this.f50119f == 0) {
                    m63801s();
                    if (this.f50123j) {
                        if (i13 == 0) {
                            return -1;
                        }
                        return i13;
                    }
                }
                int iMin = Math.min(this.f50119f, i11);
                if (this.f50120g) {
                    this.f50116c.m66170l(iMin);
                    this.f50118e.m67253e();
                } else {
                    this.f50116c.m66159a(this.f50115b, iMin);
                }
                int iM66160b = this.f50116c.m66160b(bArr, i10);
                i10 += iM66160b;
                i11 -= iM66160b;
                i13 += iM66160b;
                int i14 = this.f50119f - iM66160b;
                this.f50119f = i14;
                if (i14 == 0 && (!this.f50117d.m68245g() || this.f50116c.m66163e())) {
                    throw new C10366e();
                }
            } catch (IOException e10) {
                this.f50124k = e10;
                throw e10;
            }
        }
        return i13;
    }

    public C10371j(InputStream inputStream, int i10, byte[] bArr, C10364c c10364c) {
        this.f50119f = 0;
        this.f50120g = false;
        this.f50121h = true;
        this.f50122i = true;
        this.f50123j = false;
        this.f50124k = null;
        this.f50125l = new byte[1];
        inputStream.getClass();
        this.f50114a = c10364c;
        this.f50115b = new DataInputStream(inputStream);
        this.f50117d = new C11381c(65536, c10364c);
        this.f50116c = new C10962a(m63799u(i10), bArr, c10364c);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        this.f50121h = false;
    }
}
