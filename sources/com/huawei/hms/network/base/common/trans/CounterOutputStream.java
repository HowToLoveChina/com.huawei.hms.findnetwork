package com.huawei.hms.network.base.common.trans;

import com.huawei.hms.framework.common.StringUtils;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes8.dex */
public class CounterOutputStream extends OutputStream {

    /* renamed from: a */
    private final AtomicLong f26227a = new AtomicLong(0);

    public long getLenth() {
        return this.f26227a.get();
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f26227a.addAndGet(StringUtils.getBytes(String.valueOf(i10)).length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f26227a.addAndGet(bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        this.f26227a.addAndGet(i11);
    }
}
