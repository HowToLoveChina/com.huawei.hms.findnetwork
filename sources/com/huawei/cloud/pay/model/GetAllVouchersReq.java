package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetAllVouchersReq extends Request {
    private String clientVer;
    private String features;
    private String feeMode;
    private String pageSize;
    private String pageToken;
    private String sheetFlag;

    public GetAllVouchersReq(String str, String str2, String str3, String str4, String str5) {
        super(str);
        this.feeMode = str2;
        this.sheetFlag = str3;
        this.pageSize = str4;
        this.pageToken = str5;
        this.clientVer = "3";
        this.features = "Y";
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public String getFeatures() {
        return this.features;
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

    public void setClientVer(String str) {
        this.clientVer = str;
    }

    public void setFeatures(String str) {
        this.features = str;
    }

    public void setFeeMode(String str) {
        this.feeMode = str;
    }

    public void setPageSize(String str) {
        this.pageSize = str;
    }

    public void setPageToken(String str) {
        this.pageToken = str;
    }

    public void setSheetFlag(String str) {
        this.sheetFlag = str;
    }
}
