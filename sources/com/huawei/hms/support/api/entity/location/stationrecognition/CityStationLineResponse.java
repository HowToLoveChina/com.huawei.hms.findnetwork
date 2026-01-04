package com.huawei.hms.support.api.entity.location.stationrecognition;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;
import java.util.List;

/* loaded from: classes8.dex */
public class CityStationLineResponse extends LocationBaseResponse {

    @SerializedName("cityStationLines")
    private List<CityLinesEntity> cityStationLineInfo;

    public List<CityLinesEntity> getCityStationLineInfo() {
        return this.cityStationLineInfo;
    }

    public void setCityStationLineInfo(List<CityLinesEntity> list) {
        this.cityStationLineInfo = list;
    }
}
