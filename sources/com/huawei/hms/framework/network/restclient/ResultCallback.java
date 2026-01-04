package com.huawei.hms.framework.network.restclient;

@Deprecated
/* loaded from: classes8.dex */
public interface ResultCallback<T> {
    void onFailure(Throwable th2);

    void onResponse(Response<T> response);
}
