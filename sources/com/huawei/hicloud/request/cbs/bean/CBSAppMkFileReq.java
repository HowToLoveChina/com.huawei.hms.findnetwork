package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSAppMkFileReq extends CBSBaseReq {
    private String bucketId;
    private String extend;
    private boolean isCheckCompletePath;
    private String md5;
    private String path;
    private String sha256;
    private long size;

    public CBSAppMkFileReq(String str, String str2, String str3, long j10, String str4) {
        this.cmd = 44;
        this.info = "AppMkFileReq";
        this.path = str;
        this.md5 = str2;
        this.sha256 = str3;
        this.size = j10;
        this.bucketId = str4;
        this.isCheckCompletePath = false;
    }

    public String getBucketID() {
        return this.bucketId;
    }

    public String getExtend() {
        return this.extend;
    }

    public String getMD5() {
        return this.md5;
    }

    public String getPath() {
        return this.path;
    }

    public String getSha256() {
        return this.sha256;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isCheckCompletePath() {
        return this.isCheckCompletePath;
    }

    public void setBucketID(String str) {
        this.bucketId = str;
    }

    public void setCheckCompletePath(boolean z10) {
        this.isCheckCompletePath = z10;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setMD5(String str) {
        this.md5 = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }
}
