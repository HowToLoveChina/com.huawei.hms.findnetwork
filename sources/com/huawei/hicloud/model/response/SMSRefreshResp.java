package com.huawei.hicloud.model.response;

/* loaded from: classes6.dex */
public class SMSRefreshResp extends Response {
    private String accessToken;
    private long atExpireTime;

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getAtExpireTime() {
        return this.atExpireTime;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAtExpireTime(long j10) {
        this.atExpireTime = j10;
    }
}
