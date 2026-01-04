package com.huawei.hicloud.cloudbackup.server.slice;

/* loaded from: classes6.dex */
public class BaseSliceObject extends BaseObject {
    private long length;
    private String md5;
    private String sha256;

    public long getLength() {
        return this.length;
    }

    public String getMD5() {
        return this.md5;
    }

    public String getSha256() {
        return this.sha256;
    }

    public BaseSliceObject setLength(long j10) {
        this.length = j10;
        return this;
    }

    public BaseSliceObject setMD5(String str) {
        this.md5 = str;
        return this;
    }

    public BaseSliceObject setSha256(String str) {
        this.sha256 = str;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseObject
    public BaseSliceObject setNumber(int i10) {
        return (BaseSliceObject) super.setNumber(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseObject
    public BaseSliceObject setStart(long j10) {
        return (BaseSliceObject) super.setStart(j10);
    }
}
