package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.cloudbackup.server.slice.BaseSliceObject;

/* loaded from: classes6.dex */
public class GetUploadUrlReq extends BaseRequest {

    @SerializedName("filekey")
    private String fileKey;
    private String hash;
    private long length;
    private BaseSliceObject[] objects;
    private String userAgent;

    public GetUploadUrlReq() {
        super(-1, "GetUploadUrlReq");
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

    public BaseSliceObject[] getObjects() {
        return this.objects;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public GetUploadUrlReq setFileKey(String str) {
        this.fileKey = str;
        return this;
    }

    public GetUploadUrlReq setHash(String str) {
        this.hash = str;
        return this;
    }

    public GetUploadUrlReq setLength(long j10) {
        this.length = j10;
        return this;
    }

    public GetUploadUrlReq setObjects(BaseSliceObject[] baseSliceObjectArr) {
        this.objects = baseSliceObjectArr;
        return this;
    }

    public GetUploadUrlReq setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }
}
