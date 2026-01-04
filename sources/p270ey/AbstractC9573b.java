package p270ey;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import my.C11558a;
import p270ey.InterfaceC9572a;

/* renamed from: ey.b */
/* loaded from: classes9.dex */
public abstract class AbstractC9573b<E extends InterfaceC9572a> extends FilterInputStream {

    /* renamed from: a */
    public final byte[] f47667a;

    /* renamed from: b */
    public long f47668b;

    /* renamed from: c */
    public Charset f47669c;

    public AbstractC9573b(InputStream inputStream, Charset charset) {
        super(inputStream);
        this.f47667a = new byte[1];
        this.f47669c = C11558a.m69018c(charset);
    }

    /* renamed from: d */
    public void m59754d(int i10) {
        m59755j(i10);
    }

    /* renamed from: j */
    public void m59755j(long j10) {
        if (j10 != -1) {
            this.f47668b += j10;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (read(this.f47667a, 0, 1) == -1) {
            return -1;
        }
        return this.f47667a[0] & 255;
    }

    /* renamed from: s */
    public long m59756s() {
        return this.f47668b;
    }

    /* renamed from: t */
    public void m59757t(long j10) {
        this.f47668b -= j10;
    }

    public AbstractC9573b(InputStream inputStream, String str) {
        this(inputStream, C11558a.m69016a(str));
    }
}
