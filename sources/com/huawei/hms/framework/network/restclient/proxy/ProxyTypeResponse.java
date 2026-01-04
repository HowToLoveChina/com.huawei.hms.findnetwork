package com.huawei.hms.framework.network.restclient.proxy;

import com.huawei.hms.network.httpclient.Response;

/* loaded from: classes8.dex */
public class ProxyTypeResponse {
    public static <T> Response<T> response2New(com.huawei.hms.framework.network.restclient.Response<T> response) {
        return response.getRawResponse();
    }

    public static <R> com.huawei.hms.framework.network.restclient.Response<R> response2Old(Response<R> response) {
        return new com.huawei.hms.framework.network.restclient.Response<>(response);
    }
}
