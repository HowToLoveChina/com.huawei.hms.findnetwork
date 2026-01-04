package com.huawei.android.remotecontrol.offlinelocate.bean;

/* loaded from: classes4.dex */
public class OfflineLocateInfo {
    private long broadcastTime;
    private float confidence;
    private String createTime;
    private String encLocation;
    private String extendData;
    private String offlinePublicKey;
    private String perDeviceType;
    private String tag;
    private String tmpPublicKey;

    public long getBroadcastTime() {
        return this.broadcastTime;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public String getEncLocation() {
        return this.encLocation;
    }

    public String getExtendData() {
        return this.extendData;
    }

    public String getOfflinePublicKey() {
        return this.offlinePublicKey;
    }

    public String getPerDeviceType() {
        return this.perDeviceType;
    }

    public String getTag() {
        return this.tag;
    }

    public String getTmpPublicKey() {
        return this.tmpPublicKey;
    }

    public void setBroadcastTime(long j10) {
        this.broadcastTime = j10;
    }

    public void setConfidence(float f10) {
        this.confidence = f10;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public void setEncLocation(String str) {
        this.encLocation = str;
    }

    public void setExtendData(String str) {
        this.extendData = str;
    }

    public void setOfflinePublicKey(String str) {
        this.offlinePublicKey = str;
    }

    public void setPerDeviceType(String str) {
        this.perDeviceType = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTmpPublicKey(String str) {
        this.tmpPublicKey = str;
    }
}
