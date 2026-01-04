package com.huawei.android.hicloud.cloudbackup.model;

/* loaded from: classes2.dex */
public class HiddenAlbumFileData {
    int fileCount;
    long fileSize = 0;

    public int getFileCount() {
        return this.fileCount;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void incrementFileCount() {
        this.fileCount++;
    }

    public void incrementFileSize(long j10) {
        this.fileSize += j10;
    }

    public void setFileCount(int i10) {
        this.fileCount = i10;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public String toString() {
        return "HiddenAlbumFileData{fileCount=" + this.fileCount + ", fileSize=" + this.fileSize + '}';
    }
}
