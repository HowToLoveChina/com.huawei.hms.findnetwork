package com.huawei.hms.iap.entity;

import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class ConsumeOwnedPurchaseResult extends Result {
    private String consumePurchaseData;
    private String dataSignature;
    private String errMsg;
    private int returnCode;
    private String signatureAlgorithm;

    public String getConsumePurchaseData() {
        return this.consumePurchaseData;
    }

    public String getDataSignature() {
        return this.dataSignature;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setConsumePurchaseData(String str) {
        this.consumePurchaseData = str;
    }

    public void setDataSignature(String str) {
        this.dataSignature = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }
}
