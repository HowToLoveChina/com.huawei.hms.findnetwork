package com.huawei.hms.support.api.entity.location.stationrecognition;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes8.dex */
public class HistoryStationInfoResponse {

    @SerializedName("historyStationInfo")
    private List<HistoryStationBean> historyStationInfo;

    public List<HistoryStationBean> getHistoryStationInfo() {
        return this.historyStationInfo;
    }

    public void setHistoryStationInfo(List<HistoryStationBean> list) {
        this.historyStationInfo = list;
    }
}
