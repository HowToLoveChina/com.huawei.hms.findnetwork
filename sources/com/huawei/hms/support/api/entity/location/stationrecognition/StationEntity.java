package com.huawei.hms.support.api.entity.location.stationrecognition;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes8.dex */
public class StationEntity {

    @SerializedName("stationCode")
    private String stationCode;

    @SerializedName("stationName")
    private String stationName;

    public String getStationCode() {
        return this.stationCode;
    }

    public String getStationName() {
        return this.stationName;
    }

    public void setStationCode(String str) {
        this.stationCode = str;
    }

    public void setStationName(String str) {
        this.stationName = str;
    }
}
