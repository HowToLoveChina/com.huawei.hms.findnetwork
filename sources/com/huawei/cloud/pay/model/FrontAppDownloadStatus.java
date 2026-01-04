package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class FrontAppDownloadStatus {
    private int downloadStatus;
    private String packageName;
    private String uniqueId;

    public FrontAppDownloadStatus(String str, int i10, String str2) {
        this.packageName = str;
        this.downloadStatus = i10;
        this.uniqueId = str2;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setDownloadStatus(int i10) {
        this.downloadStatus = i10;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }
}
