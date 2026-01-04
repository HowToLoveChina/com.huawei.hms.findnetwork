package p462lx;

import java.io.IOException;
import java.io.OutputStream;
import p376ix.C10631a;

/* renamed from: lx.d */
/* loaded from: classes9.dex */
public class C11358d extends OutputStream implements InterfaceC11361g {

    /* renamed from: a */
    public OutputStream f53066a;

    /* renamed from: b */
    public long f53067b = 0;

    public C11358d(OutputStream outputStream) {
        this.f53066a = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f53066a.close();
    }

    /* renamed from: d */
    public boolean m68172d(int i10) throws C10631a {
        if (m68178x()) {
            return ((C11362h) this.f53066a).m68181d(i10);
        }
        return false;
    }

    @Override // p462lx.InterfaceC11361g
    /* renamed from: s */
    public int mo68173s() {
        if (m68178x()) {
            return ((C11362h) this.f53066a).mo68173s();
        }
        return 0;
    }

    @Override // p462lx.InterfaceC11361g
    /* renamed from: t */
    public long mo68174t() throws IOException {
        OutputStream outputStream = this.f53066a;
        return outputStream instanceof C11362h ? ((C11362h) outputStream).mo68174t() : this.f53067b;
    }

    /* renamed from: u */
    public long m68175u() throws IOException {
        OutputStream outputStream = this.f53066a;
        return outputStream instanceof C11362h ? ((C11362h) outputStream).mo68174t() : this.f53067b;
    }

    /* renamed from: v */
    public long m68176v() throws IOException {
        OutputStream outputStream = this.f53066a;
        return outputStream instanceof C11362h ? ((C11362h) outputStream).mo68174t() : this.f53067b;
    }

    /* renamed from: w */
    public long m68177w() {
        if (m68178x()) {
            return ((C11362h) this.f53066a).m68182u();
        }
        return 0L;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10});
    }

    /* renamed from: x */
    public boolean m68178x() {
        OutputStream outputStream = this.f53066a;
        return (outputStream instanceof C11362h) && ((C11362h) outputStream).m68185x();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f53066a.write(bArr, i10, i11);
        this.f53067b += i11;
    }
}
