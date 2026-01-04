package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class CheckFileExistV2Req extends BaseRequest {
    private String md5;
    private String path;
    private String sha256;
    private long size;

    public CheckFileExistV2Req() {
        this(45, "CheckFileExistV2Req");
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

    public CheckFileExistV2Req setMD5(String str) {
        this.md5 = str;
        return this;
    }

    public CheckFileExistV2Req setPath(String str) {
        this.path = str;
        return this;
    }

    public CheckFileExistV2Req setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public CheckFileExistV2Req setSize(long j10) {
        this.size = j10;
        return this;
    }

    public CheckFileExistV2Req(int i10, String str) {
        super(i10, str);
    }
}
