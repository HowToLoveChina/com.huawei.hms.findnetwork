package com.huawei.hms.common.internal;

import p208cq.C8941i;

/* loaded from: classes8.dex */
public class TaskApiCallWrapper<TResult> extends BaseContentWrapper {

    /* renamed from: a */
    private final TaskApiCall<? extends AnyClient, TResult> f23518a;

    /* renamed from: b */
    private final C8941i<TResult> f23519b;

    public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> taskApiCall, C8941i<TResult> c8941i) {
        super(1);
        this.f23518a = taskApiCall;
        this.f23519b = c8941i;
    }

    public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall() {
        return this.f23518a;
    }

    public C8941i<TResult> getTaskCompletionSource() {
        return this.f23519b;
    }
}
