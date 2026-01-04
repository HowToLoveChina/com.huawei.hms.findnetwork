package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class AdVideoInfo {
    private String sha256;
    private String videoDownloadUrl;
    private int videoDuration;
    private int videoFileSize;

    public int getGetVideoFileSize() {
        return this.videoFileSize;
    }

    public String getSha256() {
        return this.sha256;
    }

    public String getVideoDownloadUrl() {
        return this.videoDownloadUrl;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public void setSha256(String str) {
        this.sha256 = str;
    }

    public void setVideoDownloadUrl(String str) {
        this.videoDownloadUrl = str;
    }

    public void setVideoDuration(int i10) {
        this.videoDuration = i10;
    }

    public void setvideoFileSize(int i10) {
        this.videoFileSize = i10;
    }
}
