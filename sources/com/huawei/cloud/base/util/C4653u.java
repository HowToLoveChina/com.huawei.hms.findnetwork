package com.huawei.cloud.base.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.util.u */
/* loaded from: classes.dex */
public class C4653u extends FilterOutputStream {

    /* renamed from: a */
    public final C4651s f21340a;

    public C4653u(OutputStream outputStream, C4650r c4650r, int i10) {
        super(outputStream);
        this.f21340a = new C4651s(c4650r, i10);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21340a.close();
        super.close();
    }

    /* renamed from: s */
    public final C4651s m28494s() {
        return this.f21340a;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        ((FilterOutputStream) this).out.write(i10);
        this.f21340a.write(i10);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i10, i11);
        this.f21340a.write(bArr, i10, i11);
    }
}
