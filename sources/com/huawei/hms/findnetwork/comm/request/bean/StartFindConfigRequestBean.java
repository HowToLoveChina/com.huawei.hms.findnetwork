package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class StartFindConfigRequestBean extends BaseRequestBean {
    private String deviceName;
    private String electricity;
    private int goodsType;
    private String mac;

    public StartFindConfigRequestBean(String str) {
        this.mac = str;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getElectricity() {
        return this.electricity;
    }

    public int getGoodsType() {
        return this.goodsType;
    }

    public String getMac() {
        return this.mac;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setElectricity(String str) {
        this.electricity = str;
    }

    public void setGoodsType(int i10) {
        this.goodsType = i10;
    }

    public void setMac(String str) {
        this.mac = str;
    }
}
