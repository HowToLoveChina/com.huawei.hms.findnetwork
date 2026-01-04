package com.huawei.hms.framework.network.restclient.hwhttp.trans;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes8.dex */
public class CounterOutputStream extends OutputStream {
    private final com.huawei.hms.network.base.common.trans.CounterOutputStream proxyStream = new com.huawei.hms.network.base.common.trans.CounterOutputStream();

    public long getLenth() {
        return this.proxyStream.getLenth();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        this.proxyStream.write(i10);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.proxyStream.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.proxyStream.write(bArr, i10, i11);
    }
}
