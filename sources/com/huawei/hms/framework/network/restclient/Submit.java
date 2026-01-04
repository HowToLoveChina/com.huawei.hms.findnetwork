package com.huawei.hms.framework.network.restclient;

import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import java.io.IOException;

@Deprecated
/* loaded from: classes8.dex */
public interface Submit<T> extends Cloneable {

    @Deprecated
    public interface Factory {
        Submit newSubmit(Request request);
    }

    void cancel();

    Submit clone();

    void enqueue(ResultCallback<T> resultCallback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request() throws IOException;
}
