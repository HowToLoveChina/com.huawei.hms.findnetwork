package com.huawei.android.remotecontrol.tag.bean;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public class AncDeviceLocationBean {
    private String fid = "";
    private long foundTime = -1;
    private float accuracy = -1.0f;
    private double longitude = -200.0d;
    private double latitude = -200.0d;
    private String floor = "";
    private int status = -1;
    private int batteryLevel = -1;
    private String batteryDescription = "";
    private ArrayList<StandByDevice> mStandbyDevice = new ArrayList<>();

    public static class StandByDevice {
        private String fid = "";
        private int sequence = 0;
        private int status = -1;

        public String getFid() {
            return this.fid;
        }

        public int getSequence() {
            return this.sequence;
        }

        public int getStatus() {
            return this.status;
        }

        public void setFid(String str) {
            this.fid = str;
        }

        public void setSequence(int i10) {
            this.sequence = i10;
        }

        public void setStatus(int i10) {
            this.status = i10;
        }
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public String getBatteryDescription() {
        return this.batteryDescription;
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }

    public String getFid() {
        return this.fid;
    }

    public String getFloor() {
        return this.floor;
    }

    public long getFoundTime() {
        return this.foundTime;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getStatus() {
        return this.status;
    }

    public ArrayList<StandByDevice> getmStandbyDevice() {
        return this.mStandbyDevice;
    }

    public void setAccuracy(float f10) {
        this.accuracy = f10;
    }

    public void setBatteryDescription(String str) {
        this.batteryDescription = str;
    }

    public void setBatteryLevel(int i10) {
        this.batteryLevel = i10;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setFloor(String str) {
        this.floor = str;
    }

    public void setFoundTime(long j10) {
        this.foundTime = j10;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setmStandbyDevice(ArrayList<StandByDevice> arrayList) {
        this.mStandbyDevice = arrayList;
    }
}
