package com.huawei.android.hicloud.cloudspace.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DiskStorageInfo {
    private long cloudDriveSize;
    private List<HDSpaceDetail> diskDetails = new ArrayList();
    private long diskUsedSize = -1;
    private long recycleSize = 0;

    public long getCloudDriveSize() {
        return this.cloudDriveSize;
    }

    public List<HDSpaceDetail> getDiskDetails() {
        return this.diskDetails;
    }

    public long getDiskUsedSize() {
        return this.diskUsedSize;
    }

    public long getRecycleSize() {
        return this.recycleSize;
    }

    public void setCloudDriveSize(long j10) {
        this.cloudDriveSize = j10;
    }

    public void setDiskDetails(List<HDSpaceDetail> list) {
        this.diskDetails = list;
    }

    public void setDiskUsedSize(long j10) {
        this.diskUsedSize = j10;
    }

    public void setRecycleSize(long j10) {
        this.recycleSize = j10;
    }
}
