package com.huawei.android.hicloud.album.service.p075vo;

/* loaded from: classes2.dex */
public class GalleryAlbum {
    private String albumName;
    private String lPath;
    private String uploadStatus;

    public String getAlbumName() {
        return this.albumName;
    }

    public String getUploadStatus() {
        return this.uploadStatus;
    }

    public String getlPath() {
        return this.lPath;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setUploadStatus(String str) {
        this.uploadStatus = str;
    }

    public void setlPath(String str) {
        this.lPath = str;
    }

    public String toString() {
        return "GalleryAlbum{albumName='" + this.albumName + "', lPath='" + this.lPath + "', uploadStatus='" + this.uploadStatus + "'}";
    }
}
