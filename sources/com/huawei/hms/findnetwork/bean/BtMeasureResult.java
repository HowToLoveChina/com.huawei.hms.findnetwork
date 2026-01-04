package com.huawei.hms.findnetwork.bean;

/* loaded from: classes8.dex */
public class BtMeasureResult {
    private String extData;
    private int flag;
    private float percentage;
    private int rssi;

    /* renamed from: sn */
    private String f24731sn;

    public String getExtData() {
        return this.extData;
    }

    public int getFlag() {
        return this.flag;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSn() {
        return this.f24731sn;
    }

    public void setExtData(String str) {
        this.extData = str;
    }

    public void setFlag(int i10) {
        this.flag = i10;
    }

    public void setPercentage(float f10) {
        this.percentage = f10;
    }

    public void setRssi(int i10) {
        this.rssi = i10;
    }

    public void setSn(String str) {
        this.f24731sn = str;
    }

    public String toString() {
        return "BtMeasureResult{rssi=" + this.rssi + ", flag=" + this.flag + ", percentage=" + this.percentage + '}';
    }
}
