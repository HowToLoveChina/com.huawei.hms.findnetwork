package com.huawei.android.p069cg.request.response;

/* loaded from: classes2.dex */
public class QueryUserSpaceResponse extends BaseResponse {
    private long cloudPhotoSize;
    private long recyclePhotoSize;
    private long totalSpaceSize;
    private long useSpaceSize;

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
}
