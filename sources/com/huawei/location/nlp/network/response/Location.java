package com.huawei.location.nlp.network.response;

import com.huawei.location.activity.C6738e;

/* loaded from: classes8.dex */
public class Location {
    private float acc;
    private float bearing;
    private String buildingId;
    private String extraInfo;
    private short flags;
    private int floor;
    private int floorAcc;
    private double lat;
    private double lon;
    private float speed;
    private long time;

    public float getAccuracy() {
        return this.acc;
    }

    public float getBearing() {
        return this.bearing;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public short getFlags() {
        return this.flags;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getFloorAcc() {
        return this.floorAcc;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public float getSpeed() {
        return this.speed;
    }

    public long getTime() {
        return this.time;
    }

    public void setAccuracy(float f10) {
        this.acc = f10;
    }

    public void setBearing(float f10) {
        this.bearing = f10;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setExtraInfo(String str) {
        this.extraInfo = str;
    }

    public void setFlags(short s10) {
        this.flags = s10;
    }

    public void setFloor(int i10) {
        this.floor = i10;
    }

    public void setFloorAcc(int i10) {
        this.floorAcc = i10;
    }

    public void setLatitude(double d10) {
        this.lat = d10;
    }

    public void setLongitude(double d10) {
        this.lon = d10;
    }

    public void setSpeed(float f10) {
        this.speed = f10;
    }

    public void setTime(long j10) {
        this.time = j10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Location{lat=");
        sb2.append(this.lat);
        sb2.append(", lon=");
        sb2.append(this.lon);
        sb2.append(", acc=");
        sb2.append(this.acc);
        sb2.append(", speed=");
        sb2.append(this.speed);
        sb2.append(", bearing=");
        sb2.append(this.bearing);
        sb2.append(", flags=");
        sb2.append((int) this.flags);
        sb2.append(", time=");
        sb2.append(this.time);
        sb2.append(", buildingId='");
        sb2.append(this.buildingId);
        sb2.append("', floor=");
        sb2.append(this.floor);
        sb2.append(", floorAcc=");
        sb2.append(this.floorAcc);
        sb2.append(", extraInfo='");
        return C6738e.m38291a(sb2, this.extraInfo, "'}");
    }
}
