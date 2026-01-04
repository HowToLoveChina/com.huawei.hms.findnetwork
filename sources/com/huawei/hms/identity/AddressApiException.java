package com.huawei.hms.identity;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;

/* loaded from: classes8.dex */
public class AddressApiException extends ApiException {

    /* renamed from: a */
    private static final long f25452a = 2842663452776795088L;

    public AddressApiException(Status status) {
        super(status);
    }

    public Status getStatus() {
        return this.mStatus;
    }
}
