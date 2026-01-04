package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class DriveConfigQuotaCountData {
    private int dcount;
    private int fcount;
    private long fsize;
    private String moduleName;
    private long quota;
    private String serviceId;

    public int getDcount() {
        return this.dcount;
    }

    public int getFcount() {
        return this.fcount;
    }

    public long getFsize() {
        return this.fsize;
    }

    public String getModuleName() {
        return this.moduleName;
    }

    public long getQuota() {
        return this.quota;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public void setDcount(int i10) {
        this.dcount = i10;
    }

    public void setFcount(int i10) {
        this.fcount = i10;
    }

    public void setFsize(long j10) {
        this.fsize = j10;
    }

    public void setModuleName(String str) {
        this.moduleName = str;
    }

    public void setQuota(long j10) {
        this.quota = j10;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }
}
