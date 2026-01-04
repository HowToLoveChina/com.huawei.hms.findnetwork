package com.huawei.hicloud.base.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class QuotaInfo {

    @SerializedName("fileuploadsize")
    private long fileUploadSize;
    private QuotaPackageInfo quotaPackageInfo;
    private QuotaSpaceInfo quotaSpaceInfo;

    public long getFileUploadSize() {
        return this.fileUploadSize;
    }

    public QuotaPackageInfo getQuotaPackageInfo() {
        return this.quotaPackageInfo;
    }

    public QuotaSpaceInfo getQuotaSpaceInfo() {
        return this.quotaSpaceInfo;
    }

    public void setFileUploadSize(long j10) {
        this.fileUploadSize = j10;
    }

    public void setQuotaPackageInfo(QuotaPackageInfo quotaPackageInfo) {
        this.quotaPackageInfo = quotaPackageInfo;
    }

    public void setQuotaSpaceInfo(QuotaSpaceInfo quotaSpaceInfo) {
        this.quotaSpaceInfo = quotaSpaceInfo;
    }
}
