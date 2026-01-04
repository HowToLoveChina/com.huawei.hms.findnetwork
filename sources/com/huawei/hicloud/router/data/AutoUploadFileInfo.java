package com.huawei.hicloud.router.data;

/* loaded from: classes.dex */
public class AutoUploadFileInfo {
    private String appName;
    private String cloudDirectory;
    private String cloudFileName;
    private String fileMd5;
    private String filePath;
    private int fileType;
    private long modifyDate;

    public String getAppName() {
        return this.appName;
    }

    public String getCloudDirectory() {
        return this.cloudDirectory;
    }

    public String getCloudFileName() {
        return this.cloudFileName;
    }

    public String getFileMD5() {
        return this.fileMd5;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getFileType() {
        return this.fileType;
    }

    public long getModifyDate() {
        return this.modifyDate;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setCloudDirectory(String str) {
        this.cloudDirectory = str;
    }

    public void setCloudFileName(String str) {
        this.cloudFileName = str;
    }

    public void setFileMD5(String str) {
        this.fileMd5 = str;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setFileType(int i10) {
        this.fileType = i10;
    }

    public void setModifyDate(long j10) {
        this.modifyDate = j10;
    }
}
