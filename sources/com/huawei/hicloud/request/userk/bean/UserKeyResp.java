package com.huawei.hicloud.request.userk.bean;

/* loaded from: classes6.dex */
public class UserKeyResp extends EncryptBaseResp {
    private String guid;
    private String keySHA256;
    private String userKey;

    public String getGuid() {
        return this.guid;
    }

    public String getKeySHA256() {
        return this.keySHA256;
    }

    public String getUserKey() {
        return this.userKey;
    }

    public void setGuid(String str) {
        this.guid = str;
    }

    public void setKeySHA256(String str) {
        this.keySHA256 = str;
    }

    public void setUserKey(String str) {
        this.userKey = str;
    }
}
