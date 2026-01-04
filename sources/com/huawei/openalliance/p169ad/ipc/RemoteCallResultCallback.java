package com.huawei.openalliance.p169ad.ipc;

import com.huawei.openalliance.p169ad.annotations.OuterVisible;

@OuterVisible
/* loaded from: classes2.dex */
public interface RemoteCallResultCallback<T> {
    void onRemoteCallResult(String str, CallResult<T> callResult);
}
