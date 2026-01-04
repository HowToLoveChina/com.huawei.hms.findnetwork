package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.cloudbackup.server.slice.SliceStatus;

/* loaded from: classes6.dex */
public class MakeFileReq extends BaseRequest {
    private boolean checkComplete;

    @SerializedName("filekey")
    private String fileKey;
    private String hash;
    private long length;
    private SliceStatus[] objects;
    private String sha256;

    public MakeFileReq() {
        super(-1, "MakeFileReq");
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

    public SliceStatus[] getObjects() {
        return this.objects;
    }

    public String getSha256() {
        return this.sha256;
    }

    public boolean isCheckComplete() {
        return this.checkComplete;
    }

    public MakeFileReq setCheckComplete(boolean z10) {
        this.checkComplete = z10;
        return this;
    }

    public MakeFileReq setFileKey(String str) {
        this.fileKey = str;
        return this;
    }

    public MakeFileReq setHash(String str) {
        this.hash = str;
        return this;
    }

    public MakeFileReq setLength(long j10) {
        this.length = j10;
        return this;
    }

    public MakeFileReq setObjects(SliceStatus[] sliceStatusArr) {
        this.objects = sliceStatusArr;
        return this;
    }

    public MakeFileReq setSha256(String str) {
        this.sha256 = str;
        return this;
    }
}
