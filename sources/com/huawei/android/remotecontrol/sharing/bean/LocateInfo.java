package com.huawei.android.remotecontrol.sharing.bean;

import com.google.gson.Gson;

/* loaded from: classes4.dex */
public class LocateInfo {
    private double accuracy;
    private String country;
    private int isLockScreen;
    private double latitude;
    private double latitude_WGS;
    private double longitude;
    private double longitude_WGS;
    private int type;

    public double getAccuracy() {
        return this.accuracy;
    }

    public String getCountry() {
        return this.country;
    }

    public int getIsLockScreen() {
        return this.isLockScreen;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLatitudeWGS() {
        return this.latitude_WGS;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLongitudeWGS() {
        return this.longitude_WGS;
    }

    public int getType() {
        return this.type;
    }

    public void setAccuracy(double d10) {
        this.accuracy = d10;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setIsLockScreen(int i10) {
        this.isLockScreen = i10;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLatitudeWGS(double d10) {
        this.latitude_WGS = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setLongitudeWGS(double d10) {
        this.longitude_WGS = d10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
