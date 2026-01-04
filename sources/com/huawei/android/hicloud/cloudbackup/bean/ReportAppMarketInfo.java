package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class ReportAppMarketInfo {
    private long failedTime;
    private String packageName;
    private String pkgChannelId;
    private String spKey;
    private String subSource;
    private int version;

    public long getFailedTime() {
        return this.failedTime;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPkgChannelId() {
        return this.pkgChannelId;
    }

    public String getSpKey() {
        return this.spKey;
    }

    public String getSubSource() {
        return this.subSource;
    }

    public int getVersion() {
        return this.version;
    }

    public void setFailedTime(long j10) {
        this.failedTime = j10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPkgChannelId(String str) {
        this.pkgChannelId = str;
    }

    public void setSpKey(String str) {
        this.spKey = str;
    }

    public void setSubSource(String str) {
        this.subSource = str;
    }

    public void setVersion(int i10) {
        this.version = i10;
    }

    public String toString() {
        return "AppReportInfo{spKey='" + this.spKey + "', failedTime=" + this.failedTime + ", subSource='" + this.subSource + "', version=" + this.version + ", packageName='" + this.packageName + "', pkgChannelId='" + this.pkgChannelId + "'}";
    }
}
