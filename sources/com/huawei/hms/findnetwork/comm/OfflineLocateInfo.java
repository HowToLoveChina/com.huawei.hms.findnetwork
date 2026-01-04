package com.huawei.hms.findnetwork.comm;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.findnetwork.comm.request.bean.TagBatteryEnum;

/* loaded from: classes8.dex */
public class OfflineLocateInfo {

    @SerializedName("battery")
    private String battery;

    @SerializedName("broadcastTime")
    private long broadcastTime;

    @SerializedName("cmacSign")
    private String cmacSign;

    @SerializedName("confidence")
    private float confidence;

    @SerializedName("country")
    private String country;

    @SerializedName("createTime")
    private long createTime;

    @SerializedName("encLocation")
    private String encLocation;

    @SerializedName("extendData")
    private String extendData;

    @SerializedName("locationSourceType")
    private int locationSourceType;

    @SerializedName("offlinePublicKey")
    private String offlinePublicKey;

    @SerializedName("perDeviceType")
    private String perDeviceType;

    @SerializedName("tag")
    private String tag;

    @SerializedName("tmpPublickey")
    private String tmpPublicKey;

    @SerializedName("traceId")
    private String traceId;

    public String getBattery() {
        return this.battery;
    }

    public long getBroadcastTime() {
        return this.broadcastTime;
    }

    public String getCmacSign() {
        return this.cmacSign;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public String getCountry() {
        return this.country;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getEncLocation() {
        return this.encLocation;
    }

    public String getExtendData() {
        return this.extendData;
    }

    public int getLocationSourceType() {
        return this.locationSourceType;
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

    public String getTraceId() {
        return this.traceId;
    }

    public void setBattery(int i10) {
        if (i10 < 0 || i10 >= TagBatteryEnum.getTagBatteryMaxLevel()) {
            return;
        }
        this.battery = TagBatteryEnum.getTagBatteryEnum(i10).getBatteryDescription();
    }

    public void setBroadcastTime(long j10) {
        this.broadcastTime = j10;
    }

    public void setCmacSign(String str) {
        this.cmacSign = str;
    }

    public void setConfidence(float f10) {
        this.confidence = f10;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setEncLocation(String str) {
        this.encLocation = str;
    }

    public void setExtendData(String str) {
        this.extendData = str;
    }

    public void setLocationSourceType(int i10) {
        this.locationSourceType = i10;
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

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
