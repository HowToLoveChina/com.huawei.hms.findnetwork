package com.huawei.fastengine.fastview.download.download.bean;

import java.io.File;

/* loaded from: classes5.dex */
public class DownLoadResponse {
    private File downloadFile;
    private int errorCode;

    public File getDownloadFile() {
        return this.downloadFile;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setDownloadFile(File file) {
        this.downloadFile = file;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }
}
