package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSApkDownloadUrlReq extends CBSBaseReq {
    private String clientIp;
    private String path;
    private String siteId;

    public CBSApkDownloadUrlReq() {
        this.clientIp = null;
        this.siteId = null;
        this.path = null;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public String getPath() {
        return this.path;
    }

    public String getSiteID() {
        return this.siteId;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSiteID(String str) {
        this.siteId = str;
    }

    public CBSApkDownloadUrlReq(String str, String str2, String str3) {
        this.cmd = 31;
        this.info = "ApkDownloadUrlReq";
        this.clientIp = str;
        this.siteId = str2;
        this.path = str3;
    }
}
