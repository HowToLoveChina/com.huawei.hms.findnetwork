package com.huawei.android.remotecontrol.sharing.bean;

import com.google.gson.Gson;
import java.util.List;

/* loaded from: classes4.dex */
public class CptLocateInfo {
    private String batteryStatus;
    private int connectType;
    private List<String> coordinateInfoList;
    private String country;
    private String cptList;

    public String getBatteryStatus() {
        return this.batteryStatus;
    }

    public int getConnectType() {
        return this.connectType;
    }

    public List<String> getCoordinateInfoList() {
        return this.coordinateInfoList;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCptList() {
        return this.cptList;
    }

    public void setBatteryStatus(String str) {
        this.batteryStatus = str;
    }

    public void setConnectType(int i10) {
        this.connectType = i10;
    }

    public void setCoordinateInfoList(List<String> list) {
        this.coordinateInfoList = list;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCptList(String str) {
        this.cptList = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
