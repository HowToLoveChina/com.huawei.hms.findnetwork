package com.huawei.hms.network.embedded;

import com.huawei.hms.network.embedded.C5939h1;
import com.huawei.hms.network.httpclient.Request;
import com.huawei.hms.network.httpclient.RequestFinishedInfo;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import com.huawei.hms.network.inner.api.RequestContext;

/* renamed from: com.huawei.hms.network.embedded.v3 */
/* loaded from: classes8.dex */
public class C6123v3 extends RequestContext {

    /* renamed from: a */
    public Request f28633a;

    /* renamed from: b */
    public Response<ResponseBody> f28634b;

    /* renamed from: c */
    public Throwable f28635c;

    /* renamed from: d */
    public boolean f28636d = false;

    /* renamed from: e */
    public RequestFinishedInfo f28637e;

    /* renamed from: f */
    public String f28638f;

    /* renamed from: g */
    public int f28639g;

    @Override // com.huawei.hms.network.inner.api.RequestContext
    public String getChannel() {
        return this.f28638f;
    }

    @Override // com.huawei.hms.network.inner.api.RequestContext
    public int getConnectTimeout() {
        return this.f28639g;
    }

    @Override // com.huawei.hms.network.inner.api.RequestContext
    public boolean isCancel() {
        return this.f28636d;
    }

    @Override // com.huawei.hms.network.inner.api.RequestContext
    public Request request() {
        return this.f28633a;
    }

    @Override // com.huawei.hms.network.inner.api.RequestContext
    public RequestFinishedInfo requestFinishedInfo() {
        return this.f28637e;
    }

    @Override // com.huawei.hms.network.inner.api.RequestContext
    public Response<ResponseBody> response() {
        return this.f28634b;
    }

    public void setCancel(boolean z10) {
        this.f28636d = z10;
    }

    public void setChannel(String str) {
        this.f28638f = str;
    }

    public void setConnectTimeout(int i10) {
        this.f28639g = i10;
    }

    public void setRequest(Request request) {
        if (request == null || (request instanceof C5939h1.d)) {
            this.f28633a = request;
        } else {
            this.f28633a = new C5939h1.d(request);
        }
    }

    public void setRequestFinishedInfo(RequestFinishedInfo requestFinishedInfo) {
        this.f28637e = requestFinishedInfo;
    }

    public void setResponse(Response<ResponseBody> response) {
        if (response == null || (response instanceof C5939h1.f)) {
            this.f28634b = response;
        } else {
            this.f28634b = new C5939h1.f(response);
        }
    }

    public void setThrowable(Throwable th2) {
        this.f28635c = th2;
    }

    @Override // com.huawei.hms.network.inner.api.RequestContext
    public Throwable throwable() {
        return this.f28635c;
    }
}
