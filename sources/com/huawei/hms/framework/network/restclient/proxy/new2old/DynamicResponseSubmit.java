package com.huawei.hms.framework.network.restclient.proxy.new2old;

import com.huawei.hms.framework.network.restclient.hianalytics.RequestFinishedInfo;
import com.huawei.hms.framework.network.restclient.hwhttp.Callback;
import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.Submit;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;

/* loaded from: classes8.dex */
public class DynamicResponseSubmit implements Submit {
    private com.huawei.hms.network.httpclient.Submit<ResponseBody> submit;

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit
    public void cancel() {
        this.submit.cancel();
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit
    public void enqueue(final Callback callback) {
        this.submit.enqueue(new com.huawei.hms.network.httpclient.Callback<ResponseBody>() { // from class: com.huawei.hms.framework.network.restclient.proxy.new2old.DynamicResponseSubmit.1
            @Override // com.huawei.hms.network.httpclient.Callback
            public void onFailure(com.huawei.hms.network.httpclient.Submit<ResponseBody> submit, Throwable th2) {
                callback.onFailure(DynamicResponseSubmit.this, th2);
            }

            @Override // com.huawei.hms.network.httpclient.Callback
            public void onResponse(com.huawei.hms.network.httpclient.Submit<ResponseBody> submit, Response<ResponseBody> response) throws IOException {
                callback.onResponse(DynamicResponseSubmit.this, ProxyResponse.response2Old(response));
            }
        });
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit
    public com.huawei.hms.framework.network.restclient.hwhttp.Response execute() throws IOException {
        return ProxyResponse.response2Old(this.submit.execute());
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit
    public boolean isCanceled() {
        return this.submit.isCanceled();
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit
    public boolean isExecuted() {
        return this.submit.isExecuted();
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit
    public Request request() throws IOException {
        Request requestRequest2Old = ProxyRequest.request2Old(this.submit.request());
        requestRequest2Old.setRequestFinishedInfo(new RequestFinishedInfo(this.submit.getRequestFinishedInfo()));
        return requestRequest2Old;
    }

    public void setSubmit(com.huawei.hms.network.httpclient.Submit<ResponseBody> submit) {
        this.submit = submit;
    }

    @Override // com.huawei.hms.framework.network.restclient.hwhttp.Submit
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Submit m85652clone() {
        DynamicResponseSubmit dynamicResponseSubmit = new DynamicResponseSubmit();
        dynamicResponseSubmit.setSubmit(this.submit.mo85656clone());
        return dynamicResponseSubmit;
    }
}
