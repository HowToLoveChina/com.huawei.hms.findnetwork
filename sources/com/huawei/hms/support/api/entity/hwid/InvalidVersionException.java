package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.support.api.client.Status;

/* loaded from: classes8.dex */
public class InvalidVersionException extends Exception {

    /* renamed from: a */
    private Status f29791a;

    public InvalidVersionException(Status status) {
        this.f29791a = status;
    }

    public Status getError() {
        return this.f29791a;
    }
}
