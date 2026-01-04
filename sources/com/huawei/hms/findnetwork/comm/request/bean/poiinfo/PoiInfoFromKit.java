package com.huawei.hms.findnetwork.comm.request.bean.poiinfo;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes8.dex */
public class PoiInfoFromKit {

    @SerializedName("confidence")
    private double confidence;

    @SerializedName("floor")
    private int floor;

    /* renamed from: id */
    @SerializedName("id")
    private String f24747id = "";

    @SerializedName("name")
    private String name = "";

    public double getConfidence() {
        return this.confidence;
    }

    public int getFloor() {
        return this.floor;
    }

    public String getId() {
        return this.f24747id;
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
        this.f24747id = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
