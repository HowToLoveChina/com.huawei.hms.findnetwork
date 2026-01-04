package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class CardPayResp {

    /* renamed from: id */
    private String f21399id;
    private String orderId;
    private SignPurchaseResp purchaseInfo;
    private String requestId;
    private String sign;
    private QuerySignStatusResp signInfo;
    private int signMode;
    private int signStatus;

    public String getId() {
        return this.f21399id;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public SignPurchaseResp getPurchaseInfo() {
        return this.purchaseInfo;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getSign() {
        return this.sign;
    }

    public QuerySignStatusResp getSignInfo() {
        return this.signInfo;
    }

    public int getSignMode() {
        return this.signMode;
    }

    public int getSignStatus() {
        return this.signStatus;
    }

    public void setId(String str) {
        this.f21399id = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setPurchaseInfo(SignPurchaseResp signPurchaseResp) {
        this.purchaseInfo = signPurchaseResp;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSignInfo(QuerySignStatusResp querySignStatusResp) {
        this.signInfo = querySignStatusResp;
    }

    public void setSignMode(int i10) {
        this.signMode = i10;
    }

    public void setSignStatus(int i10) {
        this.signStatus = i10;
    }
}
