package py;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: py.d */
/* loaded from: classes9.dex */
public class C12251d extends AbstractC12253f {

    /* renamed from: a */
    public long f56654a;

    public C12251d(InputStream inputStream) {
        super(inputStream);
    }

    @Override // py.AbstractC12253f
    /* renamed from: d */
    public synchronized void mo73501d(int i10) {
        if (i10 != -1) {
            this.f56654a += i10;
        }
    }

    /* renamed from: s */
    public synchronized long m73502s() {
        return this.f56654a;
    }

    @Override // py.AbstractC12253f, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) throws IOException {
        long jSkip;
        jSkip = super.skip(j10);
        this.f56654a += jSkip;
        return jSkip;
    }
}
