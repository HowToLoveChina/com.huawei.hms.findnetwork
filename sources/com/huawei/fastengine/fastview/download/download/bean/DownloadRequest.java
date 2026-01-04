package com.huawei.fastengine.fastview.download.download.bean;

import java.io.File;

/* loaded from: classes5.dex */
public class DownloadRequest {
    private String hash;
    private boolean needCheck;
    private File outFile;
    private int size;
    private int timeOut;
    private String url;

    public DownloadRequest() {
        this.size = -1;
        this.timeOut = 0;
    }

    public String getHash() {
        return this.hash;
    }

    public File getOutFile() {
        return this.outFile;
    }

    public int getSize() {
        return this.size;
    }

    public int getTimeOut() {
        return this.timeOut;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isNeedCheck() {
        return this.needCheck;
    }

    public void setHash(String str) {
        this.hash = str;
    }

    public void setNeedCheck(boolean z10) {
        this.needCheck = z10;
    }

    public void setOutFile(File file) {
        this.outFile = file;
    }

    public void setSize(int i10) {
        this.size = i10;
    }

    public void setTimeOut(int i10) {
        this.timeOut = i10;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public DownloadRequest(String str) {
        this.size = -1;
        this.timeOut = 0;
        this.url = str;
    }

    public DownloadRequest(String str, int i10) {
        this.timeOut = 0;
        this.url = str;
        this.size = i10;
    }

    public DownloadRequest(String str, boolean z10, String str2) {
        this.size = -1;
        this.timeOut = 0;
        this.url = str;
        this.needCheck = z10;
        this.hash = str2;
    }
}
