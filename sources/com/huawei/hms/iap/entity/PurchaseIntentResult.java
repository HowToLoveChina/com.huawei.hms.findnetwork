package com.huawei.hms.iap.entity;

import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class PurchaseIntentResult extends Result {
    private String errMsg;

    @Deprecated
    private String paymentData;

    @Deprecated
    private String paymentSignature;
    private int returnCode;
    private String signatureAlgorithm;

    public String getErrMsg() {
        return this.errMsg;
    }

    @Deprecated
    public String getPaymentData() {
        return this.paymentData;
    }

    @Deprecated
    public String getPaymentSignature() {
        return this.paymentSignature;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    @Deprecated
    public void setPaymentData(String str) {
        this.paymentData = str;
    }

    @Deprecated
    public void setPaymentSignature(String str) {
        this.paymentSignature = str;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }
}
