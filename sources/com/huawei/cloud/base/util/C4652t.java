package com.huawei.cloud.base.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.huawei.cloud.base.util.t */
/* loaded from: classes.dex */
public class C4652t extends FilterInputStream {

    /* renamed from: a */
    public final C4651s f21339a;

    public C4652t(InputStream inputStream, C4650r c4650r, int i10) {
        super(inputStream);
        this.f21339a = new C4651s(c4650r, i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f21339a.close();
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10 = super.read();
        this.f21339a.write(i10);
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = super.read(bArr, i10, i11);
        if (i12 > 0) {
            this.f21339a.write(bArr, i10, i12);
        }
        return i12;
    }
}
