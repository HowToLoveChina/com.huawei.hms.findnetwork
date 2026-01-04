package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class AntiStalkingRecord {
    private float accuracy;
    private String buildingId;
    private int floor;
    private int floorAcc;
    private String floorInfo;
    private int indoor;
    private double latitude;
    private double longitude;
    private String mStandbyDevice;
    private String macAddress;
    private int rssi;
    private long timeStamp;

    public AntiStalkingRecord() {
        this.floor = -100;
        this.buildingId = "";
        this.floorInfo = "";
        this.indoor = 0;
        this.floorAcc = 0;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public String getBuildingId() {
        return this.buildingId;
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

    public double getLongitude() {
        return this.longitude;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getStandbyDevice() {
        return this.mStandbyDevice;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setAccuracy(float f10) {
        this.accuracy = f10;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
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

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setMacAddress(String str) {
        this.macAddress = str;
    }

    public void setRssi(int i10) {
        this.rssi = i10;
    }

    public void setStandbyDevice(String str) {
        this.mStandbyDevice = str;
    }

    public void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public AntiStalkingRecord(String str, int i10, long j10, double d10, double d11, float f10, String str2, int i11, String str3, String str4, int i12, int i13) {
        this.macAddress = str;
        this.rssi = i10;
        this.timeStamp = j10;
        this.latitude = d10;
        this.longitude = d11;
        this.accuracy = f10;
        this.mStandbyDevice = str2;
        this.floor = i11;
        this.buildingId = str3;
        this.floorInfo = str4;
        this.indoor = i12;
        this.floorAcc = i13;
    }
}
