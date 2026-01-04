package com.huawei.location.nlp.network.request.wifi;

/* loaded from: classes8.dex */
public class WifiInfo {
    private static final int FLAG_SAME_CODE = 16;
    private int frequency;
    private long mac;
    private int rssi;
    private long time;

    public WifiInfo(long j10, int i10, long j11, int i11) {
        this.mac = j10;
        this.rssi = i10;
        this.time = j11;
        this.frequency = i11;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public long getMac() {
        return this.mac;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getSameCode() {
        return this.mac / 16;
    }

    public long getTime() {
        return this.time;
    }

    public void setFrequency(int i10) {
        this.frequency = i10;
    }

    public void setMac(long j10) {
        this.mac = j10;
    }

    public void setRssi(short s10) {
        this.rssi = s10;
    }

    public void setTime(long j10) {
        this.time = j10;
    }
}
