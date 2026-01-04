package com.huawei.hms.findnetwork.comm.request.bean.poiinfo;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;

/* loaded from: classes8.dex */
public class PoiInfoResponse {

    @SerializedName("confidence")
    private double confidence;

    @SerializedName("floor")
    private int floor;

    @SerializedName(JsbMapKeyNames.H5_LOC)
    private PoiLocation location;

    /* renamed from: id */
    @SerializedName("id")
    private String f24748id = "";

    @SerializedName("name")
    private String name = "";

    public double getConfidence() {
        return this.confidence;
    }

    public int getFloor() {
        return this.floor;
    }

    public String getId() {
        return this.f24748id;
    }

    public PoiLocation getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public void setConfidence(double d10) {
        this.confidence = d10;
    }

    public void setFloor(int i10) {
        this.floor = i10;
    }

    public void setId(String str) {
        this.f24748id = str;
    }

    public void setLocation(PoiLocation poiLocation) {
        this.location = poiLocation;
    }

    public void setName(String str) {
        this.name = str;
    }
}
