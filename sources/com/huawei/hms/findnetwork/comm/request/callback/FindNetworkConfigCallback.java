package com.huawei.hms.findnetwork.comm.request.callback;

import com.huawei.hms.findnetwork.comm.request.result.FindNetworkConfigResult;

/* loaded from: classes8.dex */
public interface FindNetworkConfigCallback<T> {
    void onFail(FindNetworkConfigResult<T> findNetworkConfigResult);

    void onSuccess(FindNetworkConfigResult<T> findNetworkConfigResult);
}
