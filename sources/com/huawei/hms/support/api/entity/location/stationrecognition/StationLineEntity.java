package com.huawei.hms.support.api.entity.location.stationrecognition;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes8.dex */
public class StationLineEntity {

    @SerializedName("lineCode")
    private String lineCode;

    @SerializedName("lineName")
    private String lineName;

    @SerializedName("station")
    private List<StationEntity> stations;

    public String getLineCode() {
        return this.lineCode;
    }

    public String getLineName() {
        return this.lineName;
    }

    public List<StationEntity> getStations() {
        return this.stations;
    }

    public void setLineCode(String str) {
        this.lineCode = str;
    }

    public void setLineName(String str) {
        this.lineName = str;
    }

    public void setStations(List<StationEntity> list) {
        this.stations = list;
    }
}
