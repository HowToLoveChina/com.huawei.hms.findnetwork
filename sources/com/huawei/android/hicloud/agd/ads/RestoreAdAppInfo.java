package com.huawei.android.hicloud.agd.ads;

/* loaded from: classes2.dex */
public class RestoreAdAppInfo {
    private String appName;
    private long cloudVersionCode;
    private long localVersionCode;
    private String packageName;

    public RestoreAdAppInfo(String str, String str2, long j10, long j11) {
        this.appName = str;
        this.packageName = str2;
        this.cloudVersionCode = j10;
        this.localVersionCode = j11;
    }

    public String getAppName() {
        return this.appName;
    }

    public long getCloudVersionCode() {
        return this.cloudVersionCode;
    }

    public long getLocalVersionCode() {
        return this.localVersionCode;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCloudVersionCode(long j10) {
        this.cloudVersionCode = j10;
    }

    public void setLocalVersionCode(long j10) {
        this.localVersionCode = j10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
