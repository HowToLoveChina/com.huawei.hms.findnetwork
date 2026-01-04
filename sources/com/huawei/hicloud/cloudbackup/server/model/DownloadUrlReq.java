package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class DownloadUrlReq extends BaseRequest {
    private String clientIp;
    private String path;
    private String siteId;

    public DownloadUrlReq() {
        super(31, "ApkDownloadUrlReq ");
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

    public DownloadUrlReq setClientIp(String str) {
        this.clientIp = str;
        return this;
    }

    public DownloadUrlReq setPath(String str) {
        this.path = str;
        return this;
    }

    public DownloadUrlReq setSiteID(String str) {
        this.siteId = str;
        return this;
    }
}
