package com.huawei.hicloud.model.response;

/* loaded from: classes6.dex */
public class SMSLoginResp extends Response {
    private String accessToken;
    private long atExpireTime;
    private long sessionExpireTime;
    private String sessionID;
    private String sinKey;

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getAtExpireTime() {
        return this.atExpireTime;
    }

    public long getSessionExpireTime() {
        return this.sessionExpireTime;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public String getSinKey() {
        return this.sinKey;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAtExpireTime(long j10) {
        this.atExpireTime = j10;
    }

    public void setSessionExpireTime(long j10) {
        this.sessionExpireTime = j10;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setSinKey(String str) {
        this.sinKey = str;
    }
}
