package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class AppCohortsInfo {
    private String appCohortsInfo;
    private String beginTime;
    private String endTime;
    private String foregroundTime;
    private String launchCount;
    private String packageName;

    public String getAppCohortsInfo() {
        return this.appCohortsInfo;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getForegroundTime() {
        return this.foregroundTime;
    }

    public String getLaunchCount() {
        return this.launchCount;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setAppCohortsInfo(String str) {
        this.appCohortsInfo = str;
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setForegroundTime(String str) {
        this.foregroundTime = str;
    }

    public void setLaunchCount(String str) {
        this.launchCount = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        return "AppCohortsInfo{foregroundTime='" + this.foregroundTime + "', launchCount='" + this.launchCount + "', beginTime='" + this.beginTime + "', endTime='" + this.endTime + "'}";
    }
}
