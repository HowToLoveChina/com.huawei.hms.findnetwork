package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;

/* renamed from: com.huawei.hms.locationSdk.v */
/* loaded from: classes8.dex */
public interface InterfaceC5761v {
    @InterfaceC5767x
    /* renamed from: a */
    <TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> Task<TResult> mo33178a(HuaweiApi<TOption> huaweiApi, TaskApiCall<TClient, TResult> taskApiCall, AbstractClientBuilder<TClient, TOption> abstractClientBuilder);
}
