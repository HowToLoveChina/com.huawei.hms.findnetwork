package com.huawei.hms.framework.network.restclient.hwhttp;

import java.io.IOException;

@Deprecated
/* loaded from: classes8.dex */
public interface Callback {
    void onFailure(Submit submit, Throwable th2);

    void onResponse(Submit submit, Response response) throws IOException;
}
