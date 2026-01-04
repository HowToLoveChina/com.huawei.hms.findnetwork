package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSAppBaseReq extends CBSBaseReq {
    private String completePath;
    private String md5;
    private String path;
    private String sha256;
    private long size;
    private String type;
    private String userAgent;
    private int hasBucketId = 1;
    private String scheme = "https";

    public CBSAppBaseReq(String str, String str2, String str3, long j10) {
        this.path = str;
        this.md5 = str2;
        this.sha256 = str3;
        this.size = j10;
    }

    public String getCompletePath() {
        return this.completePath;
    }

    public int getHasBucketId() {
        return this.hasBucketId;
    }

    public String getMD5() {
        return this.md5;
    }

    public String getPath() {
        return this.path;
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getSha256() {
        return this.sha256;
    }

    public long getSize() {
        return this.size;
    }

    public String getType() {
        return this.type;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setCompletePath(String str) {
        this.completePath = str;
    }

    public void setHasBucketId(int i10) {
        this.hasBucketId = i10;
    }

    public void setMD5(String str) {
        this.md5 = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setSize(long j10) {
        this.size = j10;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }
}
