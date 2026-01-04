package com.huawei.location.nlp.network.request.cell;

import com.huawei.location.C6769i;

/* loaded from: classes8.dex */
public class NeighborCell {
    private int cNum;
    private int pId;
    private short rssi;

    public NeighborCell(int i10, int i11, short s10) {
        this.cNum = i10;
        this.pId = i11;
        this.rssi = s10;
    }

    public short getRssi() {
        return this.rssi;
    }

    public int getcNum() {
        return this.cNum;
    }

    public int getpId() {
        return this.pId;
    }

    public void setRssi(short s10) {
        this.rssi = s10;
    }

    public void setcNum(int i10) {
        this.cNum = i10;
    }

    public void setpId(int i10) {
        this.pId = i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("NeighborCell{cNum=");
        sb2.append(this.cNum);
        sb2.append(", pId=");
        sb2.append(this.pId);
        sb2.append(", rssi=");
        return C6769i.m38373a(sb2, this.rssi, '}');
    }
}
