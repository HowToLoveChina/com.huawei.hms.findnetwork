package com.huawei.android.hicloud.sync.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class ReportInfo {

    @SerializedName("business_id")
    private String businessId = "";
    private String returnCode = "";
    private String syncInfoType = "";
    private String syncInfo = "";

    public String getBusinessId() {
        return this.businessId;
    }

    public String getReturnCode() {
        return this.returnCode;
    }

    public String getSyncInfo() {
        return this.syncInfo;
    }

    public String getSyncInfoType() {
        return this.syncInfoType;
    }

    public void setBusinessId(String str) {
        this.businessId = str;
    }

    public void setReturnCode(String str) {
        this.returnCode = str;
    }

    public void setSyncInfo(String str) {
        this.syncInfo = str;
    }

    public void setSyncInfoType(String str) {
        this.syncInfoType = str;
    }
}
