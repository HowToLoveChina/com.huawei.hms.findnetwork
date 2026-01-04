package com.huawei.hms.findnetwork.comm.request.bean;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.findnetwork.comm.OfflineLocateInfo;
import com.huawei.hms.findnetwork.comm.PlainLocation;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;

/* loaded from: classes8.dex */
public class OfflineLocateResult {

    @SerializedName("battery")
    private String battery;

    @SerializedName("broadcastTime")
    private long broadcastTime;

    @SerializedName("confidence")
    private float confidence;

    @SerializedName("country")
    private String country;

    @SerializedName("createTime")
    private long createTime;

    @SerializedName("extendData")
    private String extendData;

    @SerializedName(JsbMapKeyNames.H5_LOC)
    private PlainLocation location;

    @SerializedName("locationSourceType")
    private int locationSourceType;

    @SerializedName("perDeviceType")
    private String perDeviceType;

    @SerializedName("traceId")
    private String traceId;

    public OfflineLocateResult(OfflineLocateInfo offlineLocateInfo, PlainLocation plainLocation) {
        setPerDeviceType(offlineLocateInfo.getPerDeviceType());
        setCreateTime(offlineLocateInfo.getCreateTime());
        setBroadcastTime(offlineLocateInfo.getBroadcastTime());
        setConfidence(offlineLocateInfo.getConfidence());
        setTraceId(offlineLocateInfo.getTraceId());
        setCountry(offlineLocateInfo.getCountry());
        setExtendData(offlineLocateInfo.getExtendData());
        this.battery = offlineLocateInfo.getBattery();
        setLocation(plainLocation);
        setLocationSourceType(offlineLocateInfo.getLocationSourceType());
    }

    public String getBattery() {
        return this.battery;
    }

    public long getBroadcastTime() {
        return this.broadcastTime;
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

    public String getExtendData() {
        return this.extendData;
    }

    public PlainLocation getLocation() {
        return this.location;
    }

    public int getLocationSourceType() {
        return this.locationSourceType;
    }

    public String getPerDeviceType() {
        return this.perDeviceType;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setBroadcastTime(long j10) {
        this.broadcastTime = j10;
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

    public void setExtendData(String str) {
        this.extendData = str;
    }

    public void setLocation(PlainLocation plainLocation) {
        this.location = plainLocation;
    }

    public void setLocationSourceType(int i10) {
        this.locationSourceType = i10;
    }

    public void setPerDeviceType(String str) {
        this.perDeviceType = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
