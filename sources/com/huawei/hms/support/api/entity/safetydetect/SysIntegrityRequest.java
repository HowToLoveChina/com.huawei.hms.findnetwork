package com.huawei.hms.support.api.entity.safetydetect;

/* loaded from: classes8.dex */
public class SysIntegrityRequest {
    private String alg;
    private String appId;
    private byte[] nonce;

    public String getAlg() {
        return this.alg;
    }

    public String getAppId() {
        return this.appId;
    }

    public byte[] getNonce() {
        byte[] bArr = this.nonce;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public void setAlg(String str) {
        this.alg = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setNonce(byte[] bArr) {
        this.nonce = bArr == null ? null : (byte[]) bArr.clone();
    }
}
