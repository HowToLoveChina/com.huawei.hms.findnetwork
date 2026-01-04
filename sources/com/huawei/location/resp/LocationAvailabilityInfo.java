package com.huawei.location.resp;

/* loaded from: classes8.dex */
public class LocationAvailabilityInfo {
    private int cellStatus;
    private long elapsedRealtimeNs;
    private int locationStatus;
    private int wifiStatus;

    public int getCellStatus() {
        return this.cellStatus;
    }

    public long getElapsedRealtimeNs() {
        return this.elapsedRealtimeNs;
    }

    public int getLocationStatus() {
        return this.locationStatus;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public void setCellStatus(int i10) {
        this.cellStatus = i10;
    }

    public void setElapsedRealtimeNs(long j10) {
        this.elapsedRealtimeNs = j10;
    }

    public void setLocationStatus(int i10) {
        this.locationStatus = i10;
    }

    public void setWifiStatus(int i10) {
        this.wifiStatus = i10;
    }
}
