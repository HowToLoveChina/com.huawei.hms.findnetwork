package com.huawei.hms.framework.network.restclient.hwhttp;

import java.io.IOException;

@Deprecated
/* loaded from: classes8.dex */
public interface Submit extends Cloneable {

    @Deprecated
    public interface Factory {
        Submit newSubmit(Request request);
    }

    void cancel();

    /* renamed from: clone */
    Submit m85652clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request() throws IOException;
}
