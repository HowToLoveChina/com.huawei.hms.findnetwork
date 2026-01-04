package com.huawei.location.nlp.network.request.cell;

import com.huawei.location.C6769i;

/* loaded from: classes8.dex */
public class CurrentCell {
    private long boottime;
    private long cellId;
    private int lac;
    private int mcc;
    private int mnc;
    private int rat;
    private short rssi;

    public long getBoottime() {
        return this.boottime;
    }

    public long getCellId() {
        return this.cellId;
    }

    public int getLac() {
        return this.lac;
    }

    public int getMcc() {
        return this.mcc;
    }

    public int getMnc() {
        return this.mnc;
    }

    public int getRat() {
        return this.rat;
    }

    public short getRssi() {
        return this.rssi;
    }

    public void setBoottime(long j10) {
        this.boottime = j10;
    }

    public void setCellId(long j10) {
        this.cellId = j10;
    }

    public void setLac(int i10) {
        this.lac = i10;
    }

    public void setMcc(int i10) {
        this.mcc = i10;
    }

    public void setMnc(int i10) {
        this.mnc = i10;
    }

    public void setRat(int i10) {
        this.rat = i10;
    }

    public void setRssi(short s10) {
        this.rssi = s10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CurrentCell{boottime=");
        sb2.append(this.boottime);
        sb2.append(", mcc=");
        sb2.append(this.mcc);
        sb2.append(", mnc=");
        sb2.append(this.mnc);
        sb2.append(", lac=");
        sb2.append(this.lac);
        sb2.append(", cellId=");
        sb2.append(this.cellId);
        sb2.append(", rat=");
        sb2.append(this.rat);
        sb2.append(", rssi=");
        return C6769i.m38373a(sb2, this.rssi, '}');
    }
}
