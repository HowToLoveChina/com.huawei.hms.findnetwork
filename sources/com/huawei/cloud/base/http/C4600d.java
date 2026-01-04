package com.huawei.cloud.base.http;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.http.d */
/* loaded from: classes.dex */
public class C4600d implements InterfaceC4605h {
    @Override // com.huawei.cloud.base.http.InterfaceC4605h, com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        outputStream.flush();
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    /* renamed from: b */
    public boolean mo28153b() {
        return true;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public long getLength() throws IOException {
        return 0L;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public String getType() {
        return null;
    }
}
