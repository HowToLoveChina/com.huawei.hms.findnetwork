package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.InterfaceC4631c0;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.http.h */
/* loaded from: classes.dex */
public interface InterfaceC4605h extends InterfaceC4631c0 {
    @Override // com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    void mo28157a(OutputStream outputStream) throws IOException;

    /* renamed from: b */
    boolean mo28153b();

    long getLength() throws IOException;

    String getType();
}
