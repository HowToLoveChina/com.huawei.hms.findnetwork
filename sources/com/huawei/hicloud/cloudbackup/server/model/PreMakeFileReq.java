package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class PreMakeFileReq extends BaseRequest {

    @SerializedName("filekey")
    private String fileKey;
    private String hash;
    private long length;
    private String sha256;

    public PreMakeFileReq() {
        super(-1, "PreMakeFileReq");
    }

    public String getFileKey() {
        return this.fileKey;
    }

    public String getHash() {
        return this.hash;
    }

    public long getLength() {
        return this.length;
    }

    public String getSha256() {
        return this.sha256;
    }

    public PreMakeFileReq setFileKey(String str) {
        this.fileKey = str;
        return this;
    }

    public PreMakeFileReq setHash(String str) {
        this.hash = str;
        return this;
    }

    public PreMakeFileReq setLength(long j10) {
        this.length = j10;
        return this;
    }

    public PreMakeFileReq setSha256(String str) {
        this.sha256 = str;
        return this;
    }
}
