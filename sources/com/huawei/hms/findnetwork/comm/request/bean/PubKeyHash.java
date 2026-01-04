package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class PubKeyHash {
    private String createTime;
    private String firstSixByte;
    private int keyType;
    private int pij;
    private String pubKeyHash;

    public String getCreateTime() {
        return this.createTime;
    }

    public String getFirstSixByte() {
        return this.firstSixByte;
    }

    public int getKeyType() {
        return this.keyType;
    }

    public int getPij() {
        return this.pij;
    }

    public String getPubKeyHash() {
        return this.pubKeyHash;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setFirstSixByte(String str) {
        this.firstSixByte = str;
    }

    public void setKeyType(int i10) {
        this.keyType = i10;
    }

    public void setPij(int i10) {
        this.pij = i10;
    }

    public void setPubKeyHash(String str) {
        this.pubKeyHash = str;
    }
}
