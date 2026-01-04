package com.huawei.android.hicloud.cloudspace.bean;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BackupStorageInfo {
    private long backupUsedSize;
    private CBSpaceDetail currentDeviceBackupDetails;
    private List<CBSpaceDetail> backupDetails = new ArrayList();
    private List<CBSpaceDetail> otherDeviceBackupDetails = new ArrayList();

    public List<CBSpaceDetail> getBackupDetails() {
        return this.backupDetails;
    }

    public long getBackupUsedSize() {
        return this.backupUsedSize;
    }

    public CBSpaceDetail getCurrentDeviceBackupDetails() {
        return this.currentDeviceBackupDetails;
    }

    public List<CBSpaceDetail> getOtherDeviceBackupDetails() {
        return this.otherDeviceBackupDetails;
    }

    public void setBackupDetails(List<CBSpaceDetail> list) {
        this.backupDetails = list;
    }

    public void setBackupUsedSize(long j10) {
        this.backupUsedSize = j10;
    }

    public void setCurrentDeviceBackupDetails(CBSpaceDetail cBSpaceDetail) {
        this.currentDeviceBackupDetails = cBSpaceDetail;
    }

    public void setOtherDeviceBackupDetails(List<CBSpaceDetail> list) {
        this.otherDeviceBackupDetails = list;
    }
}
