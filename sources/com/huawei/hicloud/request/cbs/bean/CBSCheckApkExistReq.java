package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSCheckApkExistReq extends CBSBaseReq {
    private String androidVer;
    private String apkHash;
    private String apkMd5;
    private String clientIp;
    private String emuiVer;
    private String filePath;
    private String packageName;
    private String siteId;
    private String versionCode;

    public CBSCheckApkExistReq() {
        this.cmd = 48;
        this.info = "CheckApkExistReq";
    }

    public String getAndroidVer() {
        return this.androidVer;
    }

    public String getApkHash() {
        return this.apkHash;
    }

    public String getApkMd5() {
        return this.apkMd5;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public String getEmuiVer() {
        return this.emuiVer;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSiteID() {
        return this.siteId;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setAndroidVer(String str) {
        this.androidVer = str;
    }

    public void setApkHash(String str) {
        this.apkHash = str;
    }

    public void setApkMd5(String str) {
        this.apkMd5 = str;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public void setEmuiVer(String str) {
        this.emuiVer = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSiteID(String str) {
        this.siteId = str;
    }

    public void setVersionCode(String str) {
        this.versionCode = str;
    }
}
