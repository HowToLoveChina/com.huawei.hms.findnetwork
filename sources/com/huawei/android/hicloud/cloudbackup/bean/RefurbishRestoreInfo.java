package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class RefurbishRestoreInfo {
    private String backupId;
    private long restoreEndTime;
    private long restoreStartTime;
    private int status;

    public RefurbishRestoreInfo() {
    }

    public String getBackupId() {
        return this.backupId;
    }

    public long getRestoreEndTime() {
        return this.restoreEndTime;
    }

    public long getRestoreStartTime() {
        return this.restoreStartTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setRestoreEndTime(long j10) {
        this.restoreEndTime = j10;
    }

    public void setRestoreStartTime(long j10) {
        this.restoreStartTime = j10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public String toString() {
        return "RefurbishRestoreInfo{backupId='" + this.backupId + "', restoreStartTime=" + this.restoreStartTime + ", restoreEndTime=" + this.restoreEndTime + ", status=" + this.status + '}';
    }

    public RefurbishRestoreInfo(String str, long j10, long j11, int i10) {
        this.backupId = str;
        this.restoreStartTime = j10;
        this.restoreEndTime = j11;
        this.status = i10;
    }
}
