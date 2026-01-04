package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class DevicePeriodRequestBean extends BaseRequestBean {
    private String fid;
    private String mac;
    private int years;

    public DevicePeriodRequestBean() {
    }

    public String getFid() {
        return this.fid;
    }

    public String getMac() {
        return this.mac;
    }

    public int getYears() {
        return this.years;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setYears(int i10) {
        this.years = i10;
    }

    public DevicePeriodRequestBean(String str, String str2) {
        this.fid = str;
        this.mac = str2;
    }

    public DevicePeriodRequestBean(String str, String str2, int i10) {
        this.fid = str;
        this.mac = str2;
        this.years = i10;
    }
}
