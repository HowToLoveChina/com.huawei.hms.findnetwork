package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetAllVouchersResp extends Response {
    private String pageToken;
    private long unusefulCount;
    private String unusefulVouchers;
    private long usedCount;
    private String usedVouchers;
    private long usefulCount;
    private String usefulVouchers;

    public String getPageToken() {
        return this.pageToken;
    }

    public long getUnusefulCount() {
        return this.unusefulCount;
    }

    public String getUnusefulVouchers() {
        return this.unusefulVouchers;
    }

    public long getUsedCount() {
        return this.usedCount;
    }

    public String getUsedVouchers() {
        return this.usedVouchers;
    }

    public long getUsefulCount() {
        return this.usefulCount;
    }

    public String getUsefulVouchers() {
        return this.usefulVouchers;
    }

    public void setPageToken(String str) {
        this.pageToken = str;
    }

    public void setUnusefulCount(long j10) {
        this.unusefulCount = j10;
    }

    public void setUsedCount(long j10) {
        this.usedCount = j10;
    }

    public void setUsefulCount(long j10) {
        this.usefulCount = j10;
    }
}
