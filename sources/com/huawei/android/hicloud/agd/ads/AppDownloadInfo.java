package com.huawei.android.hicloud.agd.ads;

/* loaded from: classes2.dex */
public class AppDownloadInfo {
    private String adId;
    private String channelName;
    private String packageName;
    private String uniqueId;

    public AppDownloadInfo(String str, String str2, String str3, String str4) {
        this.adId = str;
        this.packageName = str2;
        this.uniqueId = str3;
        this.channelName = str4;
    }

    public String getAdId() {
        return this.adId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }
}
