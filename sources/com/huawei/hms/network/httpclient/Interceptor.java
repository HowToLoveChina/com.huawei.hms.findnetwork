package com.huawei.hms.network.httpclient;

import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class Interceptor {

    public static abstract class Chain {
        public abstract Response<ResponseBody> proceed(Request request) throws IOException;

        public abstract Request request();

        public abstract RequestFinishedInfo requestFinishedInfo();
    }

    public abstract Response<ResponseBody> intercept(Chain chain) throws IOException;
}
