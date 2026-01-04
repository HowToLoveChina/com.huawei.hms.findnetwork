package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class BackupSpeedInfo {
    private String backupSpeedId;
    private long totalSize;
    private long totalTime;

    public BackupSpeedInfo(String str, long j10, long j11) {
        this.backupSpeedId = str;
        this.totalSize = j10;
        this.totalTime = j11;
    }

    public String getBackupSpeedId() {
        return this.backupSpeedId;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public void setBackupSpeedId(String str) {
        this.backupSpeedId = str;
    }

    public void setTotalSize(long j10) {
        this.totalSize = j10;
    }

    public void setTotalTime(long j10) {
        this.totalTime = j10;
    }

    public String toString() {
        return "BackupSpeedInfo{backupSpeedId='" + this.backupSpeedId + "', totalSize=" + this.totalSize + ", totalTime=" + this.totalTime + '}';
    }
}
