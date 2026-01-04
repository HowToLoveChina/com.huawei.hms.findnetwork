package com.huawei.hms.support.api.entity.location.offlinelocation;

/* loaded from: classes8.dex */
public class HwCellInfo {
    private long cellId;
    private int channelNumber;
    private boolean isRegistered;
    private int lacOrTac;
    private int mcc;
    private int mnc;
    private int physicalIdentity;
    private int rat;
    private int rssi;
    private long timeStamp;

    public long getCellId() {
        return this.cellId;
    }

    public int getChannelNumber() {
        return this.channelNumber;
    }

    public int getLacOrTac() {
        return this.lacOrTac;
    }

    public int getMcc() {
        return this.mcc;
    }

    public int getMnc() {
        return this.mnc;
    }

    public int getPhysicalIdentity() {
        return this.physicalIdentity;
    }

    public int getRat() {
        return this.rat;
    }

    public int getRssi() {
        return this.rssi;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void setCellId(long j10) {
        this.cellId = j10;
    }

    public void setChannelNumber(int i10) {
        this.channelNumber = i10;
    }

    public void setLacOrTac(int i10) {
        this.lacOrTac = i10;
    }

    public void setMcc(int i10) {
        this.mcc = i10;
    }

    public void setMnc(int i10) {
        this.mnc = i10;
    }

    public void setPhysicalIdentity(int i10) {
        this.physicalIdentity = i10;
    }

    public void setRat(int i10) {
        this.rat = i10;
    }

    public void setRegistered(boolean z10) {
        this.isRegistered = z10;
    }

    public void setRssi(int i10) {
        this.rssi = i10;
    }

    public void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }
}
