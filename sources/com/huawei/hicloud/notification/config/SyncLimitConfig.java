package com.huawei.hicloud.notification.config;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SyncLimitConfig {

    @SerializedName("download_limit_num")
    private int downloadLimitNum;

    @SerializedName("download_num")
    private int downloadNum;

    @SerializedName("upload_limit_num")
    private int uploadLimitNum;

    @SerializedName("upload_limit_size")
    private int uploadLimitSize;

    public int getDownloadLimitNum() {
        return this.downloadLimitNum;
    }

    public int getDownloadNum() {
        return this.downloadNum;
    }

    public int getUploadLimitNum() {
        return this.uploadLimitNum;
    }

    public int getUploadLimitSize() {
        return this.uploadLimitSize;
    }

    public void setDownloadLimitNum(int i10) {
        this.downloadLimitNum = i10;
    }

    public void setDownloadNum(int i10) {
        this.downloadNum = i10;
    }

    public void setUploadLimitNum(int i10) {
        this.uploadLimitNum = i10;
    }

    public void setUploadLimitSize(int i10) {
        this.uploadLimitSize = i10;
    }
}
