package com.huawei.cloud.base.http;

import com.huawei.cloud.base.util.C4647o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.huawei.cloud.base.http.b */
/* loaded from: classes.dex */
public abstract class AbstractC4596b implements InterfaceC4605h {

    /* renamed from: a */
    public String f21131a;

    /* renamed from: b */
    public boolean f21132b = true;

    public AbstractC4596b(String str) {
        mo28165e(str);
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h, com.huawei.cloud.base.util.InterfaceC4631c0
    /* renamed from: a */
    public void mo28157a(OutputStream outputStream) throws IOException {
        C4647o.m28476c(mo28163c(), outputStream, this.f21132b);
        outputStream.flush();
    }

    /* renamed from: c */
    public abstract InputStream mo28163c() throws IOException;

    /* renamed from: d */
    public AbstractC4596b m28164d(boolean z10) {
        this.f21132b = z10;
        return this;
    }

    /* renamed from: e */
    public AbstractC4596b mo28165e(String str) {
        this.f21131a = str;
        return this;
    }

    @Override // com.huawei.cloud.base.http.InterfaceC4605h
    public String getType() {
        return this.f21131a;
    }
}
