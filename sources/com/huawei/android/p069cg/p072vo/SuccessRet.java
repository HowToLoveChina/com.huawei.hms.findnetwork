package com.huawei.android.p069cg.p072vo;

/* loaded from: classes2.dex */
public class SuccessRet {
    protected String albumId;
    protected String albumName;
    protected long createTime;
    protected String fileName;
    protected String lpath;
    protected String uniqueId;

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getLpath() {
        return this.lpath;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setLpath(String str) {
        this.lpath = str;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("SuccessRet uniqueId=");
        sb2.append(this.uniqueId);
        sb2.append(", albumId=");
        sb2.append(this.albumId);
        sb2.append(", filename=");
        sb2.append(this.fileName);
        sb2.append(", albumName=");
        sb2.append(this.albumName);
        sb2.append(", lpath=");
        sb2.append(this.lpath);
        return sb2.toString();
    }
}
