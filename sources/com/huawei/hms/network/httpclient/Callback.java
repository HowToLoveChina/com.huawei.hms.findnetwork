package com.huawei.hms.network.httpclient;

import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class Callback<T> {
    public abstract void onFailure(Submit<T> submit, Throwable th2);

    public abstract void onResponse(Submit<T> submit, Response<T> response) throws IOException;
}
