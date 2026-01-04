package com.huawei.hms.network.inner.api;

import com.huawei.hms.network.httpclient.Interceptor;

/* loaded from: classes8.dex */
public abstract class InterceptorNetworkService extends NetworkService {
    public abstract Interceptor getInterceptor();

    public abstract boolean isNetworkInterceptor();
}
