package com.huawei.hms.findnetwork.comm.request;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes8.dex */
public class OfflineLocationCipher {

    @SerializedName("broadcastTime")
    private long broadcastTime;

    @SerializedName("cipherText")
    private String cipherText;

    @SerializedName("confidence")
    private float confidence;

    @SerializedName("extendData")
    private String extendData;

    @SerializedName("pubKeyHash")
    private String pubKeyHash;

    /* renamed from: sn */
    @SerializedName("sn")
    private String f24732sn;

    public long getBroadcastTime() {
        return this.broadcastTime;
    }

    public String getCipherText() {
        return this.cipherText;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public String getExtendData() {
        return this.extendData;
    }

    public String getPubKeyHash() {
        return this.pubKeyHash;
    }

    public String getSn() {
        return this.f24732sn;
    }

    public void setBroadcastTime(long j10) {
        this.broadcastTime = j10;
    }

    public void setCipherText(String str) {
        this.cipherText = str;
    }

    public void setConfidence(float f10) {
        this.confidence = f10;
    }

    public void setExtendData(String str) {
        this.extendData = str;
    }

    public void setPubKeyHash(String str) {
        this.pubKeyHash = str;
    }

    public void setSn(String str) {
        this.f24732sn = str;
    }
}
