package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSCheckFileExistReq extends CBSBaseReq {
    private String clientIp;
    private String filePath;
    private String hash;
    private String siteId;

    public CBSCheckFileExistReq() {
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getHash() {
        return this.hash;
    }

    public String getSiteID() {
        return this.siteId;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setUserID(String str) {
        this.siteId = str;
    }

    public CBSCheckFileExistReq(String str, String str2) {
        this.cmd = 41;
        this.info = "CheckFileExistReq";
        setFilePath(str);
        this.hash = str2;
    }
}
