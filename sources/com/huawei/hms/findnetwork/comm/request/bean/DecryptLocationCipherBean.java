package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class DecryptLocationCipherBean extends SnRequestBean {
    private String cipherText;
    private String pubKeyHash;

    public String getCipherText() {
        return this.cipherText;
    }

    public String getPubKeyHash() {
        return this.pubKeyHash;
    }

    public void setCipherText(String str) {
        this.cipherText = str;
    }

    public void setPubKeyHash(String str) {
        this.pubKeyHash = str;
    }
}
