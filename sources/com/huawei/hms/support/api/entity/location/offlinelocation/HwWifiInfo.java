package com.huawei.hms.support.api.entity.location.offlinelocation;

/* loaded from: classes8.dex */
public class HwWifiInfo {
    private String bssid;
    private int frequency;
    private int rssi;
    private long timestamp;

    public String getBssid() {
        return this.bssid;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setFrequency(int i10) {
        this.frequency = i10;
    }

    public void setRssi(int i10) {
        this.rssi = i10;
    }

    public void setTimestamp(long j10) {
        this.timestamp = j10;
    }
}
