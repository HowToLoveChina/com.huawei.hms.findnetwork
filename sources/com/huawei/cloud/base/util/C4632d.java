package com.huawei.cloud.base.util;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.util.d */
/* loaded from: classes.dex */
public final class C4632d extends OutputStream {

    /* renamed from: a */
    public long f21265a;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f21265a += i11;
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f21265a++;
    }
}
