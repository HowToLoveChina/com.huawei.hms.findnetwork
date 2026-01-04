package com.huawei.hms.findnetwork.comm.request.bean;

import com.huawei.hms.findnetwork.comm.util.MaskUtil;

/* loaded from: classes8.dex */
public class DisConnectLocation {
    private float accuracy;
    private String buildingId;
    private long disConnectTime;
    private int floor;
    private int floorAcc;
    private String floorInfo;
    private int indoor;
    private double latitude;
    private long locationTime;
    private double longitude;

    /* renamed from: sn */
    private String f24736sn;
    private String standbyInfo;
    private int status;

    public DisConnectLocation(String str, long j10, long j11, double d10, double d11, int i10, float f10, int i11, String str2, String str3, int i12, int i13) {
        this.f24736sn = str;
        this.disConnectTime = j10;
        this.locationTime = j11;
        this.longitude = d10;
        this.latitude = d11;
        this.status = i10;
        this.accuracy = f10;
        this.floor = i11;
        this.buildingId = str2;
        this.floorInfo = str3;
        this.indoor = i12;
        this.floorAcc = i13;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public long getDisConnectTime() {
        return this.disConnectTime;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getFloorAcc() {
        return this.floorAcc;
    }

    public String getFloorInfo() {
        return this.floorInfo;
    }

    public int getIndoor() {
        return this.indoor;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public long getLocationTime() {
        return this.locationTime;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getSn() {
        return this.f24736sn;
    }

    public String getStandbyInfo() {
        return this.standbyInfo;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAccuracy(float f10) {
        this.accuracy = f10;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setDisConnectTime(long j10) {
        this.disConnectTime = j10;
    }

    public void setFloor(int i10) {
        this.floor = i10;
    }

    public void setFloorAcc(int i10) {
        this.floorAcc = i10;
    }

    public void setFloorInfo(String str) {
        this.floorInfo = str;
    }

    public void setIndoor(int i10) {
        this.indoor = i10;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLocationTime(long j10) {
        this.locationTime = j10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setSn(String str) {
        this.f24736sn = str;
    }

    public void setStandbyInfo(String str) {
        this.standbyInfo = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return "DisConnectLocation{, disConnectTime=" + this.disConnectTime + ", locationTime=" + this.locationTime + ", status=" + this.status + ", accuracy=" + this.accuracy + ", standbyInfo=" + MaskUtil.maskCommon(this.standbyInfo) + ", indoor=" + this.indoor + '}';
    }
}
