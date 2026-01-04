package com.huawei.android.hicloud.album.service.hihttp.request.response;

/* loaded from: classes2.dex */
public class SaveOriginalInfo {
    private int downloadNum;
    private int haveAnotherNum;
    private long latestVersion;
    private int saveOriginalStatus;
    private String shareVersion;

    public int getDownloadNum() {
        return this.downloadNum;
    }

    public int getHaveAnotherNum() {
        return this.haveAnotherNum;
    }

    public long getLatestVersion() {
        return this.latestVersion;
    }

    public int getSaveOriginalStatus() {
        return this.saveOriginalStatus;
    }

    public String getShareVersion() {
        return this.shareVersion;
    }

    public void setDownloadNum(int i10) {
        this.downloadNum = i10;
    }

    public void setHaveAnotherNum(int i10) {
        this.haveAnotherNum = i10;
    }

    public void setLatestVersion(long j10) {
        this.latestVersion = j10;
    }

    public void setSaveOriginalStatus(int i10) {
        this.saveOriginalStatus = i10;
    }

    public void setShareVersion(String str) {
        this.shareVersion = str;
    }

    public String toString() {
        return "SaveOriginalInfo{latestVersion=" + this.latestVersion + ", shareVersion='" + this.shareVersion + "', saveOriginalStatus=" + this.saveOriginalStatus + ", haveAnotherNum=" + this.haveAnotherNum + ", downloadNum=" + this.downloadNum + '}';
    }
}
