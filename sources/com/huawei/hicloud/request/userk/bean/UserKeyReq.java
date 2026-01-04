package com.huawei.hicloud.request.userk.bean;

/* loaded from: classes6.dex */
public class UserKeyReq extends UserKeyBaseReq {
    private String tempAesKey;
    private String version;

    public UserKeyReq(int i10, String str, String str2, String str3) {
        super(2, EncryptBaseReq.INFO_QUERY_USER_KEY, EncryptBaseReq.TYPE_ECDH);
        this.keyType = str;
        this.businessType = i10;
        this.tempAesKey = str2;
        this.version = str3;
    }

    public String getTempAesKey() {
        return this.tempAesKey;
    }

    public String getVersion() {
        return this.version;
    }

    public void setTempAesKey(String str) {
        this.tempAesKey = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
