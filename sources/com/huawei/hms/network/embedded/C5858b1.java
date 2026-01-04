package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Interceptor;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.inner.api.RequestContext;
import java.io.IOException;
import java.util.List;

/* renamed from: com.huawei.hms.network.embedded.b1 */
/* loaded from: classes8.dex */
public class C5858b1 extends Interceptor.Chain {

    /* renamed from: a */
    public final int f26397a;

    /* renamed from: b */
    public HttpClient f26398b;

    /* renamed from: c */
    public List<Interceptor> f26399c;

    /* renamed from: d */
    public AbstractC6174z2 f26400d;

    /* renamed from: e */
    public InterfaceC5886d1 f26401e;

    /* renamed from: f */
    public RequestContext f26402f;

    public C5858b1(HttpClient httpClient, RequestContext requestContext, List<Interceptor> list, AbstractC6174z2 abstractC6174z2, int i10, InterfaceC5886d1 interfaceC5886d1) {
        this.f26398b = httpClient;
        this.f26402f = requestContext;
        this.f26399c = list;
        this.f26397a = i10;
        this.f26400d = abstractC6174z2;
        this.f26401e = interfaceC5886d1;
    }

    /* renamed from: a */
    public C5939h1.f<ResponseBody> m33854a(RequestContext requestContext, InterfaceC5886d1 interfaceC5886d1) throws IOException {
        if (this.f26397a >= this.f26399c.size()) {
            throw new AssertionError();
        }
        C5939h1.b bVar = new C5939h1.b(new C5858b1(this.f26398b, requestContext, this.f26399c, this.f26400d, this.f26397a + 1, interfaceC5886d1));
        Interceptor interceptor = this.f26399c.get(this.f26397a);
        Response<ResponseBody> responseIntercept = interceptor.intercept(bVar);
        if (this.f26397a == 0) {
            this.f26400d.cpApplicationInterceptorResEnd();
            C5929g4.getInstance().traceResponseNetworkKitOutEvent(this.f26400d);
        }
        if (responseIntercept != null) {
            return responseIntercept instanceof C5939h1.f ? (C5939h1.f) responseIntercept : new C5939h1.f<>(responseIntercept);
        }
        throw new NullPointerException("interceptor " + interceptor + " returned null");
    }

    public HttpClient getClient() {
        return this.f26398b;
    }

    public AbstractC6174z2 getRCEventListener() {
        return this.f26400d;
    }

    public InterfaceC5886d1 getRequestTask() {
        return this.f26401e;
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor.Chain
    public Response<ResponseBody> proceed(Request request) throws IOException {
        ((C6123v3) this.f26402f).setRequest(request);
        return m33854a(this.f26402f, this.f26401e);
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor.Chain
    public C5939h1.d request() {
        return (C5939h1.d) this.f26402f.request();
    }

    @Override // com.huawei.hms.network.httpclient.Interceptor.Chain
    public RequestFinishedInfo requestFinishedInfo() {
        InterfaceC5886d1 interfaceC5886d1 = this.f26401e;
        if (interfaceC5886d1 != null) {
            return interfaceC5886d1.getRequestFinishedInfo();
        }
        return null;
    }
}
