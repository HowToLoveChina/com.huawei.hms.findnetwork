package com.huawei.hwcloudjs.service.hms.bean;

import com.huawei.hwcloudjs.api.Result;
import com.huawei.hwcloudjs.support.enables.NoProguard;

@NoProguard
/* loaded from: classes8.dex */
public class AccessTokenInfo implements Result {
    private String accessToken;
    private Status status;

    public AccessTokenInfo(String str, Status status) {
        this.accessToken = str;
        this.status = status;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // com.huawei.hwcloudjs.api.Result
    public Status getStatus() {
        return this.status;
    }

    public boolean isSuccess() {
        return this.status.isSuccess();
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }
}
