package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.StringUtils;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.hms.network.embedded.b4 */
/* loaded from: classes8.dex */
public class C5861b4 extends OutputStream {

    /* renamed from: a */
    public InterfaceC5882cb f26407a;

    public C5861b4(InterfaceC5882cb interfaceC5882cb) {
        this.f26407a = interfaceC5882cb;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26407a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f26407a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        write(StringUtils.getBytes(String.valueOf(i10)));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f26407a.write(bArr, i10, i11);
    }
}
