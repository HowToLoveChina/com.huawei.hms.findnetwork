package com.huawei.location.lite.common.http;

import java.io.IOException;
import okhttp3.C11912b0;
import okhttp3.HttpRequestBuilder;
import okhttp3.HttpResponseBuilder;
import p688ur.C13243c;
import p688ur.C13244d;
import p688ur.C13245e;
import p750wr.C13626a;
import p785xr.C13851a;
import tr.C13065i;
import tr.InterfaceC13060d;

/* renamed from: com.huawei.location.lite.common.http.d */
/* loaded from: classes8.dex */
public class C6787d implements InterfaceC13060d {

    /* renamed from: a */
    public C13851a f31377a;

    /* renamed from: b */
    public final C11912b0 f31378b;

    public C6787d(C11912b0 c11912b0) {
        this.f31378b = c11912b0;
    }

    @Override // tr.InterfaceC13060d
    /* renamed from: a */
    public C13065i mo38453a(C13851a c13851a) throws C13245e, C13244d, IOException {
        this.f31377a = c13851a;
        HttpResponseBuilder HttpResponseBuilderExecute = this.f31378b.m71495z(C13626a.m81982b(c13851a, new HttpRequestBuilder.a())).execute();
        if (HttpResponseBuilderExecute.m71595s() != null) {
            return C13626a.m81983c(HttpResponseBuilderExecute);
        }
        throw new C13245e(C13243c.m79629a(10307));
    }
}
