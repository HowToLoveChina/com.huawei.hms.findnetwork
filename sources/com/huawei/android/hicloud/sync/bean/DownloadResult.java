package com.huawei.android.hicloud.sync.bean;

/* loaded from: classes3.dex */
public class DownloadResult {
    private int downloadState;
    private int errorCode;
    private String fileId;
    private String fileName;

    public DownloadResult(String str, String str2) {
        this.fileId = str;
        this.fileName = str2;
        this.downloadState = 0;
        this.errorCode = 0;
    }

    public int getDownloadState() {
        return this.downloadState;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setDownloadState(int i10) {
        this.downloadState = i10;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public DownloadResult(String str, String str2, int i10) {
        this.fileId = str;
        this.fileName = str2;
        this.downloadState = -1;
        this.errorCode = i10;
    }
}
