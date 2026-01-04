package com.huawei.hicloud.router.data;

/* loaded from: classes.dex */
public class AutoUploadProcess {
    private String currentAppName;
    private String currentFilePath;
    private int currentUploadStatus;
    private int failCount;
    private boolean isFinish;
    private String netDiskFileName;
    private int successCount;
    private int total;
    private long uploadTime;

    public String getCurrentAppName() {
        return this.currentAppName;
    }

    public String getCurrentFilePath() {
        return this.currentFilePath;
    }

    public int getCurrentUploadStatus() {
        return this.currentUploadStatus;
    }

    public int getFailCount() {
        return this.failCount;
    }

    public String getNetDiskFileName() {
        return this.netDiskFileName;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public int getTotal() {
        return this.total;
    }

    public long getUploadTime() {
        return this.uploadTime;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    public void setCurrentAppName(String str) {
        this.currentAppName = str;
    }

    public void setCurrentFilePath(String str) {
        this.currentFilePath = str;
    }

    public void setCurrentUploadStatus(int i10) {
        this.currentUploadStatus = i10;
    }

    public void setFailCount(int i10) {
        this.failCount = i10;
    }

    public void setFinish(boolean z10) {
        this.isFinish = z10;
    }

    public void setNetDiskFileName(String str) {
        this.netDiskFileName = str;
    }

    public void setSuccessCount(int i10) {
        this.successCount = i10;
    }

    public void setTotal(int i10) {
        this.total = i10;
    }

    public void setUploadTime(long j10) {
        this.uploadTime = j10;
    }
}
