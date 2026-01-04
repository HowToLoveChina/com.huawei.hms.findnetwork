package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class LocationRecordBean {
    private float accuracy;
    private double latitude;
    private long locationLastTimestamp;
    private int locationSourceType;
    private long locationTimestamp;
    private int locationType;
    private double longitude;

    public LocationRecordBean(long j10, double d10, double d11, float f10, int i10, int i11) {
        this.locationTimestamp = j10;
        this.longitude = d10;
        this.latitude = d11;
        this.accuracy = f10;
        this.locationType = i10;
        this.locationLastTimestamp = j10;
        this.locationSourceType = i11;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public long getLocationLastTimestamp() {
        return this.locationLastTimestamp;
    }

    public int getLocationSourceType() {
        return this.locationSourceType;
    }

    public long getLocationTimestamp() {
        return this.locationTimestamp;
    }

    public int getLocationType() {
        return this.locationType;
    }

    public double getLongitude() {
        return this.longitude;
    }
}
