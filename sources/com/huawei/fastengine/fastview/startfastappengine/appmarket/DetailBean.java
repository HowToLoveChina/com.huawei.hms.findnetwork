package com.huawei.fastengine.fastview.startfastappengine.appmarket;

/* loaded from: classes5.dex */
public class DetailBean {
    private String downloadUrl;
    private String packageName;
    private String sha256;
    private String versionCode;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSha256() {
        return this.sha256;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }

    public String toString() {
        return "DetailBean{packageName='" + this.packageName + "', downloadUrl='" + this.downloadUrl + "', sha256='" + this.sha256 + "', versionCode='" + this.versionCode + "'}";
    }
}
