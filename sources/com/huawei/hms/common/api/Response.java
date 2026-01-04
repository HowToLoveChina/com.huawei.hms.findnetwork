package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class Response<T extends Result> {
    protected T result;

    public Response() {
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T t10) {
        this.result = t10;
    }

    public Response(T t10) {
        this.result = t10;
    }
}
