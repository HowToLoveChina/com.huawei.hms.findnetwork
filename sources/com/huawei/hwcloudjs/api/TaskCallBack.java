package com.huawei.hwcloudjs.api;

import com.huawei.hwcloudjs.api.Result;
import com.huawei.hwcloudjs.support.enables.NoProguard;

@NoProguard
/* loaded from: classes8.dex */
public interface TaskCallBack<R extends Result> {
    void onResult(R r10);
}
