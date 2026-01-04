package com.huawei.hms.support.api.entity.location.stationrecognition;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes8.dex */
public class CityLinesEntity {

    @SerializedName("cityCode")
    private String cityCode;

    @SerializedName("cityName")
    private String cityName;

    @SerializedName("stationLine")
    private List<StationLineEntity> stationLine;

    @SerializedName("stationType")
    private String stationType;

    public String getCityCode() {
        return this.cityCode;
    }

    public String getCityName() {
        return this.cityName;
    }

    public List<StationLineEntity> getStationLine() {
        return this.stationLine;
    }

    public String getStationType() {
        return this.stationType;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setCityName(String str) {
        this.cityName = str;
    }

    public void setStationLine(List<StationLineEntity> list) {
        this.stationLine = list;
    }

    public void setStationType(String str) {
        this.stationType = str;
    }
}
