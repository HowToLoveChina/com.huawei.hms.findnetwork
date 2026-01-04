package com.huawei.hms.videokit.player;

/* loaded from: classes8.dex */
public class LogConfigInfo {
    private int logFileNum;
    private String logFilePath;
    private int logFileSize;
    private int logLevel;

    public LogConfigInfo(int i10, String str, int i11, int i12) {
        this.logLevel = i10;
        this.logFilePath = str;
        this.logFileNum = i11;
        this.logFileSize = i12;
    }

    public int getLogFileNum() {
        return this.logFileNum;
    }

    public String getLogFilePath() {
        return this.logFilePath;
    }

    public int getLogFileSize() {
        return this.logFileSize;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public void setLogFileNum(int i10) {
        this.logFileNum = i10;
    }

    public void setLogFilePath(String str) {
        this.logFilePath = str;
    }

    public void setLogFileSize(int i10) {
        this.logFileSize = i10;
    }

    public void setLogLevel(int i10) {
        this.logLevel = i10;
    }
}
