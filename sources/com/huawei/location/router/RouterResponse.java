package com.huawei.location.router;

import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.StatusInfo;

/* loaded from: classes8.dex */
public class RouterResponse implements IRouterResponse {
    private final String body;
    private final StatusInfo statusInfo;
    private String transactionId;

    public RouterResponse(String str, StatusInfo statusInfo) {
        this.body = str;
        this.statusInfo = statusInfo;
    }

    public String getBody() {
        return this.body;
    }

    public StatusInfo getStatusInfo() {
        return this.statusInfo;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }
}
