package com.huawei.hms.network.file.api;

import com.huawei.hms.network.file.api.Request;
import com.huawei.hms.network.file.api.Result;
import java.util.List;

/* loaded from: classes8.dex */
public interface IRequestManager<R extends Request> {
    Result cancelRequest(long j10);

    Result closeThreadPools();

    Result destoryRequests();

    List<R> getAllRequests();

    R getRequest(long j10);

    Result.STATUS getRequestStatus(long j10);

    Result start(R r10, Callback callback);
}
