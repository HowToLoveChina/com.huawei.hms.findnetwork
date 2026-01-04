package com.huawei.android.hicloud.sync.bean;

/* loaded from: classes3.dex */
public class CloudSyncRetryInfo {
    private boolean isRetry;
    private long retryTime;
    private int retryTimes;
    private int syncStatus;
    private long syncTime;
    private String syncType;
    private int taskId;

    public CloudSyncRetryInfo(int i10, String str, long j10, int i11, long j11, int i12, boolean z10) {
        this.taskId = i10;
        this.syncType = str;
        this.syncTime = j10;
        this.syncStatus = i11;
        this.retryTime = j11;
        this.retryTimes = i12;
        this.isRetry = z10;
    }

    public long getRetryTime() {
        return this.retryTime;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public long getSyncTime() {
        return this.syncTime;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public boolean isRetry() {
        return this.isRetry;
    }

    public void setRetry(boolean z10) {
        this.isRetry = z10;
    }

    public void setRetryTime(long j10) {
        this.retryTime = j10;
    }

    public void setRetryTimes(int i10) {
        this.retryTimes = i10;
    }

    public void setSyncStatus(int i10) {
        this.syncStatus = i10;
    }

    public void setSyncTime(long j10) {
        this.syncTime = j10;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }

    public void setTaskId(int i10) {
        this.taskId = i10;
    }

    public String toString() {
        return "CloudSyncRetryInfo{taskId=" + this.taskId + ", syncType='" + this.syncType + "', syncTime=" + this.syncTime + ", syncStatus=" + this.syncStatus + ", retryTime=" + this.retryTime + ", retryTimes=" + this.retryTimes + ", isRetry=" + this.isRetry + '}';
    }
}
