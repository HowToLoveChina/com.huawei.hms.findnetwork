package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class AppMkFileReq extends BaseRequest {

    @SerializedName("bucketId")
    private String contentBucketId;

    @SerializedName("md5")
    private String contentMd5;

    @SerializedName("sha256")
    private String contentSha256;
    private String extend;
    private boolean isCheckCompletePath;
    private String path;
    private long size;

    public AppMkFileReq() {
        super(44, "AppMkFileReq");
        this.isCheckCompletePath = true;
    }

    public String getContentBucketId() {
        return this.contentBucketId;
    }

    public String getContentMd5() {
        return this.contentMd5;
    }

    public String getContentSha256() {
        return this.contentSha256;
    }

    public String getExtend() {
        return this.extend;
    }

    public String getPath() {
        return this.path;
    }

    public long getSize() {
        return this.size;
    }

    public boolean isCheckCompletePath() {
        return this.isCheckCompletePath;
    }

    public AppMkFileReq setCheckCompletePath(boolean z10) {
        this.isCheckCompletePath = z10;
        return this;
    }

    public AppMkFileReq setContentBucketId(String str) {
        this.contentBucketId = str;
        return this;
    }

    public AppMkFileReq setContentMd5(String str) {
        this.contentMd5 = str;
        return this;
    }

    public AppMkFileReq setContentSha256(String str) {
        this.contentSha256 = str;
        return this;
    }

    public AppMkFileReq setExtend(String str) {
        this.extend = str;
        return this;
    }

    public AppMkFileReq setPath(String str) {
        this.path = str;
        return this;
    }

    public AppMkFileReq setSize(long j10) {
        this.size = j10;
        return this;
    }
}
