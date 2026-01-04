package com.huawei.hwcloudjs.service.hms.bean;

import com.huawei.hwcloudjs.api.Result;
import com.huawei.hwcloudjs.support.enables.NoProguard;

@NoProguard
/* loaded from: classes8.dex */
public final class Status implements Result {
    private boolean isSuccess;
    private int stateCode;
    private String stateMessage;

    public Status(int i10) {
        this.stateCode = i10;
    }

    public int getStateCode() {
        return this.stateCode;
    }

    public String getStateMessage() {
        return this.stateMessage;
    }

    @Override // com.huawei.hwcloudjs.api.Result
    public Status getStatus() {
        return null;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccessFlag(boolean z10) {
        this.isSuccess = z10;
    }

    public Status(int i10, String str) {
        this.stateCode = i10;
        this.stateMessage = str;
    }
}
