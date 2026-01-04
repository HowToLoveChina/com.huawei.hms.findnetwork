package com.huawei.hms.findnetwork.comm.request.bean.poiinfo;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;

/* loaded from: classes8.dex */
public class PoiInfo {

    @SerializedName("confidence")
    private double confidence;

    @SerializedName("floor")
    private double floor;

    @SerializedName(JsbMapKeyNames.H5_LOC_LAT)
    private double latitude;

    @SerializedName(JsbMapKeyNames.H5_LOC_LON)
    private double longitude;

    /* renamed from: id */
    @SerializedName("id")
    private String f24746id = "";

    @SerializedName("name")
    private String name = "";

    public PoiInfo copy() {
        PoiInfo poiInfo = new PoiInfo();
        poiInfo.setId(this.f24746id);
        poiInfo.setName(this.name);
        poiInfo.setLongitude(this.longitude);
        poiInfo.setLatitude(this.latitude);
        poiInfo.setConfidence(this.confidence);
        poiInfo.setFloor(this.floor);
        return poiInfo;
    }

    public double getConfidence() {
        return this.confidence;
    }

    public double getFloor() {
        return this.floor;
    }

    public String getId() {
        return this.f24746id;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public void setConfidence(double d10) {
        this.confidence = d10;
    }

    public void setFloor(double d10) {
        this.floor = d10;
    }

    public void setId(String str) {
        this.f24746id = str;
    }

    public void setLatitude(double d10) {
        this.latitude = d10;
    }

    public void setLongitude(double d10) {
        this.longitude = d10;
    }

    public void setName(String str) {
        this.name = str;
    }
}
