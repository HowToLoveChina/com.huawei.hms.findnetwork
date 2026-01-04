package com.huawei.hms.iap;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;

/* loaded from: classes8.dex */
public class IapApiException extends ApiException {
    public IapApiException(Status status) {
        super(status);
    }

    public Status getStatus() {
        return this.mStatus;
    }
}
