package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSQueryRecordDetailReq extends CBSBaseIdsReq {
    private String clientIp;
    private boolean includeArk;
    private boolean isConvertUrl;
    private boolean queryFiles;
    private String siteId;
    private boolean useCDN;

    public CBSQueryRecordDetailReq() {
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public String getQuerySiteId() {
        return this.siteId;
    }

    public String getSiteID() {
        return this.siteId;
    }

    public boolean isConvertUrl() {
        return this.isConvertUrl;
    }

    public boolean isIncludeArk() {
        return this.includeArk;
    }

    public boolean isQueryFiles() {
        return this.queryFiles;
    }

    public boolean isUseCDN() {
        return this.useCDN;
    }

    public void setClientIp(String str) {
        this.clientIp = str;
    }

    public void setConvertUrl(boolean z10) {
        this.isConvertUrl = z10;
    }

    public void setIncludeArk(boolean z10) {
        this.includeArk = z10;
    }

    public void setQueryFiles(boolean z10) {
        this.queryFiles = z10;
    }

    public void setSiteID(String str) {
        this.siteId = str;
    }

    public void setUseCDN(boolean z10) {
        this.useCDN = z10;
    }

    public CBSQueryRecordDetailReq(String str, int i10, String str2) {
        this.cmd = 23;
        this.info = "QueryRecordDetailReq";
        this.useCDN = true;
        this.deviceId = str;
        this.deviceType = i10;
        this.backupId = str2;
        this.includeArk = true;
    }
}
