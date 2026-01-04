package com.huawei.hicloud.cloudbackup.server.slice;

/* loaded from: classes6.dex */
public class SliceStatus extends BaseObject {
    private long length;
    private String md5;
    private String sha256;
    private BaseSliceStatus uploadStatus;

    public long getLength() {
        return this.length;
    }

    public String getMD5() {
        return this.md5;
    }

    public String getSha256() {
        return this.sha256;
    }

    public BaseSliceStatus getUploadStatus() {
        return this.uploadStatus;
    }

    public SliceStatus setLength(long j10) {
        this.length = j10;
        return this;
    }

    public SliceStatus setMD5(String str) {
        this.md5 = str;
        return this;
    }

    public SliceStatus setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    public SliceStatus setUploadStatus(BaseSliceStatus baseSliceStatus) {
        this.uploadStatus = baseSliceStatus;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseObject
    public SliceStatus setNumber(int i10) {
        return (SliceStatus) super.setNumber(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseObject
    public SliceStatus setStart(long j10) {
        return (SliceStatus) super.setStart(j10);
    }
}
