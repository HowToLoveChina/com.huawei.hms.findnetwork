package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class DownloadItem {
    public String fileId;
    public String fileMD5;
    public String fileName;
    private long fileSize;
    public String saveName;
    public String savePath;
    private String sha256;
    private int status;
    public String url;

    public String getFileId() {
        return this.fileId;
    }

    public String getFileMD5() {
        return this.fileMD5;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public String getSaveName() {
        return this.saveName;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getSha256() {
        return this.sha256;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileMD5(String str) {
        this.fileMD5 = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setSaveName(String str) {
        this.saveName = str;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
