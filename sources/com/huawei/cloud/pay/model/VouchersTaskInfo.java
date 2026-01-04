package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class VouchersTaskInfo {
    private String feeMode;
    private String pageSize;
    private String pageToken;
    private String sheetFlag;

    public VouchersTaskInfo(String str, String str2, String str3, String str4) {
        this.feeMode = str;
        this.sheetFlag = str2;
        this.pageSize = str3;
        this.pageToken = str4;
    }

    public String getFeeMode() {
        return this.feeMode;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public String getSheetFlag() {
        return this.sheetFlag;
    }
}
