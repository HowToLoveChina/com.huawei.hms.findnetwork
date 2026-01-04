package com.huawei.hms.location;

/* loaded from: classes8.dex */
public class LogConfig {
    private int fileExpiredTime;
    private int fileNum;
    private int fileSize;
    private String logPath;

    public LogConfig() {
    }

    public LogConfig(String str) {
        this.logPath = str;
    }

    public int getFileExpiredTime() {
        return this.fileExpiredTime;
    }

    public int getFileNum() {
        return this.fileNum;
    }

    public int getFileSize() {
        return this.fileSize;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public void setFileExpiredTime(int i10) {
        this.fileExpiredTime = i10;
    }

    public void setFileNum(int i10) {
        this.fileNum = i10;
    }

    public void setFileSize(int i10) {
        this.fileSize = i10;
    }

    public void setLogPath(String str) {
        this.logPath = str;
    }

    public LogConfig(String str, int i10, int i11, int i12) {
        this.logPath = str;
        this.fileSize = i10;
        this.fileNum = i11;
        this.fileExpiredTime = i12;
    }
}
