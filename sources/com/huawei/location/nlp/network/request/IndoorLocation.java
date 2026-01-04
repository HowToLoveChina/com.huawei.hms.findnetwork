package com.huawei.location.nlp.network.request;

import com.huawei.location.C6769i;

/* loaded from: classes8.dex */
public class IndoorLocation {
    private float acc;
    private String buildingId;
    private int flags;
    private int floor;
    private float floorAcc;
    private double lat;
    private double lon;
    private long time;

    public float getAcc() {
        return this.acc;
    }

    public String getBuildingId() {
        return this.buildingId;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getFloor() {
        return this.floor;
    }

    public float getFloorAcc() {
        return this.floorAcc;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLon() {
        return this.lon;
    }

    public long getTime() {
        return this.time;
    }

    public void setAcc(float f10) {
        this.acc = f10;
    }

    public void setBuildingId(String str) {
        this.buildingId = str;
    }

    public void setFlags(int i10) {
        this.flags = i10;
    }

    public void setFloor(int i10) {
        this.floor = i10;
    }

    public void setFloorAcc(float f10) {
        this.floorAcc = f10;
    }

    public void setLat(double d10) {
        this.lat = d10;
    }

    public void setLon(double d10) {
        this.lon = d10;
    }

    public void setTime(long j10) {
        this.time = j10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IndoorLocation{lat=");
        sb2.append(this.lat);
        sb2.append(", lon=");
        sb2.append(this.lon);
        sb2.append(", acc=");
        sb2.append(this.acc);
        sb2.append(", buildingId='");
        sb2.append(this.buildingId);
        sb2.append("', floor=");
        sb2.append(this.floor);
        sb2.append(", floorAcc=");
        sb2.append(this.floorAcc);
        sb2.append(", time=");
        sb2.append(this.time);
        sb2.append(", flags=");
        return C6769i.m38373a(sb2, this.flags, '}');
    }
}
