package com.huawei.hms.framework.network.restclient.proxy;

import com.huawei.hms.framework.network.restclient.ResultCallback;
import com.huawei.hms.framework.network.restclient.Submit;
import com.huawei.hms.framework.network.restclient.hianalytics.RequestFinishedInfo;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.proxy.new2old.ProxyRequest;
import com.huawei.hms.network.httpclient.Callback;
import com.huawei.hms.network.httpclient.Response;
import java.io.IOException;

/* loaded from: classes8.dex */
public class ProxyTypeSubmit<R> implements Submit<R> {
    private final com.huawei.hms.network.httpclient.Submit<R> proxy;

    public ProxyTypeSubmit(com.huawei.hms.network.httpclient.Submit<R> submit) {
        this.proxy = submit;
    }

    @Override // com.huawei.hms.framework.network.restclient.Submit
    public void cancel() {
        this.proxy.cancel();
    }

    @Override // com.huawei.hms.framework.network.restclient.Submit
    public void enqueue(final ResultCallback<R> resultCallback) {
        this.proxy.enqueue(new Callback<R>() { // from class: com.huawei.hms.framework.network.restclient.proxy.ProxyTypeSubmit.1
            @Override // com.huawei.hms.network.httpclient.Callback
            public void onFailure(com.huawei.hms.network.httpclient.Submit<R> submit, Throwable th2) {
                resultCallback.onFailure(th2);
            }

            @Override // com.huawei.hms.network.httpclient.Callback
            public void onResponse(com.huawei.hms.network.httpclient.Submit<R> submit, Response<R> response) {
                resultCallback.onResponse(ProxyTypeResponse.response2Old(response));
            }
        });
    }

    @Override // com.huawei.hms.framework.network.restclient.Submit
    public com.huawei.hms.framework.network.restclient.Response<R> execute() throws IOException {
        return ProxyTypeResponse.response2Old(this.proxy.execute());
    }

    @Override // com.huawei.hms.framework.network.restclient.Submit
    public boolean isCanceled() {
        return this.proxy.isCanceled();
    }

    @Override // com.huawei.hms.framework.network.restclient.Submit
    public boolean isExecuted() {
        return this.proxy.isExecuted();
    }

    @Override // com.huawei.hms.framework.network.restclient.Submit
    public Request request() throws IOException {
        Request requestRequest2Old = ProxyRequest.request2Old(this.proxy.request());
        requestRequest2Old.setRequestFinishedInfo(new RequestFinishedInfo(this.proxy.getRequestFinishedInfo()));
        return requestRequest2Old;
    }

    @Override // com.huawei.hms.framework.network.restclient.Submit
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Submit<R> m85651clone() {
        return new ProxyTypeSubmit(this.proxy.mo85656clone());
    }
}
