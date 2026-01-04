package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.cloudbackup.server.slice.BaseObject;

/* loaded from: classes6.dex */
public class GetDownloadUrlReq extends BaseRequest {

    @SerializedName("filekey")
    private String fileKey;
    private String hash;
    private long length;
    private BaseObject[] objects;

    public GetDownloadUrlReq() {
        super(-1, "GetDownloadUrlReq");
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

    public BaseObject[] getObjects() {
        return this.objects;
    }

    public GetDownloadUrlReq setFileKey(String str) {
        this.fileKey = str;
        return this;
    }

    public GetDownloadUrlReq setHash(String str) {
        this.hash = str;
        return this;
    }

    public GetDownloadUrlReq setLength(long j10) {
        this.length = j10;
        return this;
    }

    public GetDownloadUrlReq setObjects(BaseObject[] baseObjectArr) {
        this.objects = baseObjectArr;
        return this;
    }
}
