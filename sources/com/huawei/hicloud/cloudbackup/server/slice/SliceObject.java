package com.huawei.hicloud.cloudbackup.server.slice;

/* loaded from: classes6.dex */
public class SliceObject extends BaseSliceObject {
    private EndpointURL downloadUrl;
    private int state;
    private EndpointURL uploadUrl;

    public EndpointURL getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getState() {
        return this.state;
    }

    public EndpointURL getUploadUrl() {
        return this.uploadUrl;
    }

    public boolean needUpload() {
        return this.state != 0;
    }

    public SliceObject setDownloadUrl(EndpointURL endpointURL) {
        this.downloadUrl = endpointURL;
        return this;
    }

    public SliceObject setState(int i10) {
        this.state = i10;
        return this;
    }

    public SliceObject setUploadUrl(EndpointURL endpointURL) {
        this.uploadUrl = endpointURL;
        return this;
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseSliceObject
    public SliceObject setLength(long j10) {
        return (SliceObject) super.setLength(j10);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseSliceObject
    public SliceObject setMD5(String str) {
        return (SliceObject) super.setMD5(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseSliceObject
    public SliceObject setSha256(String str) {
        return (SliceObject) super.setSha256(str);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseSliceObject, com.huawei.hicloud.cloudbackup.server.slice.BaseObject
    public SliceObject setNumber(int i10) {
        return (SliceObject) super.setNumber(i10);
    }

    @Override // com.huawei.hicloud.cloudbackup.server.slice.BaseSliceObject, com.huawei.hicloud.cloudbackup.server.slice.BaseObject
    public SliceObject setStart(long j10) {
        return (SliceObject) super.setStart(j10);
    }
}
