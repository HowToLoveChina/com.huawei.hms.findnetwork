package com.huawei.hms.findnetwork.comm.request.bean.wear;

/* loaded from: classes8.dex */
public class PublicKeyResponse implements WearResponse {
    private String publicKey;
    private String srcTranId;

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getSrcTranId() {
        return this.srcTranId;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
    }

    public void setSrcTranId(String str) {
        this.srcTranId = str;
    }
}
