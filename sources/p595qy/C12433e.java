package p595qy;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import my.C11562e;
import p538oy.InterfaceC12057a;

/* renamed from: qy.e */
/* loaded from: classes9.dex */
public class C12433e extends FilterOutputStream {
    public C12433e(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        C11562e.m69025f(((FilterOutputStream) this).out, new InterfaceC12057a() { // from class: qy.d
            @Override // p538oy.InterfaceC12057a
            public final void accept(Object obj) throws IOException {
                this.f57277a.m74628f((IOException) obj);
            }
        });
    }

    /* renamed from: d */
    public void m74627d(int i10) throws IOException {
    }

    /* renamed from: e */
    public void mo74626e(int i10) throws IOException {
        throw null;
    }

    /* renamed from: f */
    public void m74628f(IOException iOException) throws IOException {
        throw iOException;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException e10) {
            m74628f(e10);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        try {
            mo74626e(1);
            ((FilterOutputStream) this).out.write(i10);
            m74627d(1);
        } catch (IOException e10) {
            m74628f(e10);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        try {
            int iM69033n = C11562e.m69033n(bArr);
            mo74626e(iM69033n);
            ((FilterOutputStream) this).out.write(bArr);
            m74627d(iM69033n);
        } catch (IOException e10) {
            m74628f(e10);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        try {
            mo74626e(i11);
            ((FilterOutputStream) this).out.write(bArr, i10, i11);
            m74627d(i11);
        } catch (IOException e10) {
            m74628f(e10);
        }
    }
}
