package com.huawei.android.hicloud.security.bean;

/* loaded from: classes3.dex */
public class UserKeyObject {
    private byte[] userKey;
    private String userKeyGuid;
    private String userKeySHA256;

    public byte[] getUserKey() {
        return this.userKey;
    }

    public String getUserKeyGuid() {
        String str = this.userKeyGuid;
        return str == null ? "" : str;
    }

    public String getUserKeySHA256() {
        return this.userKeySHA256;
    }

    public void setUserKey(byte[] bArr) {
        this.userKey = bArr;
    }

    public void setUserKeyGuid(String str) {
        this.userKeyGuid = str;
    }

    public void setUserKeySHA256(String str) {
        this.userKeySHA256 = str;
    }
}
