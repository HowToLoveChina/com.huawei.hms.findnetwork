package com.huawei.hms.network.file.api;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.exception.NetworkException;
import java.io.Closeable;

/* loaded from: classes8.dex */
public interface Callback<R extends Request, T> {
    void onException(R r10, NetworkException networkException, Response<R, T, Closeable> response);

    void onProgress(R r10, Progress progress);

    R onStart(R r10);

    void onSuccess(Response<R, T, Closeable> response);
}
