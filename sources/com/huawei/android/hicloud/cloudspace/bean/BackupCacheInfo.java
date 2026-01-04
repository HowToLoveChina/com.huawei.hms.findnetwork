package com.huawei.android.hicloud.cloudspace.bean;

import java.util.List;

/* loaded from: classes2.dex */
public class BackupCacheInfo {
    private long backupUsedSize = -1;
    private List<String> deviceCategorys;

    public long getBackupUsedSize() {
        return this.backupUsedSize;
    }

    public List<String> getDeviceCategorys() {
        return this.deviceCategorys;
    }

    public void setBackupUsedSize(long j10) {
        this.backupUsedSize = j10;
    }

    public void setDeviceCategorys(List<String> list) {
        this.deviceCategorys = list;
    }
}
