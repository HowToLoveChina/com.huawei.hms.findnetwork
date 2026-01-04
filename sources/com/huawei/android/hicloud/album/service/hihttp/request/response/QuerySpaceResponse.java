package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class QuerySpaceResponse extends BaseResponse {
    private static final long DEFAULT_SPACE_SIZE = -1;
    private long totalSpaceSize = -1;
    private long useSpaceSize = -1;
    private long cloudPhotoSize = -1;
    private long recyclePhotoSize = -1;

    public long getCloudPhotoSize() {
        return this.cloudPhotoSize;
    }

    public long getRecyclePhotoSize() {
        return this.recyclePhotoSize;
    }

    public long getTotalSpaceSize() {
        return this.totalSpaceSize;
    }

    public long getUseSpaceSize() {
        return this.useSpaceSize;
    }

    public void setCloudPhotoSize(long j10) {
        this.cloudPhotoSize = j10;
    }

    public void setRecyclePhotoSize(long j10) {
        this.recyclePhotoSize = j10;
    }

    public void setTotalSpaceSize(long j10) {
        this.totalSpaceSize = j10;
    }

    public void setUseSpaceSize(long j10) {
        this.useSpaceSize = j10;
    }

    public String toString() {
        return "QuerySpaceResponse{totalSpaceSize='" + this.totalSpaceSize + "', useSpaceSize='" + this.useSpaceSize + "', cloudPhotoSize='" + this.cloudPhotoSize + "', recyclePhotoSize='" + this.recyclePhotoSize + "'}";
    }
}
