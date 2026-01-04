package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class ExchangePackageResp extends Response {
    private CloudCardGiftInfo gift;
    private SignPurchaseResp purchaseInfo;
    private QuerySignStatusResp signInfo;
    private int signMode;
    private int signStatus;

    public CloudCardGiftInfo getGift() {
        return this.gift;
    }

    public SignPurchaseResp getPurchaseInfo() {
        return this.purchaseInfo;
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

    public void setGift(CloudCardGiftInfo cloudCardGiftInfo) {
        this.gift = cloudCardGiftInfo;
    }

    public void setPurchaseInfo(SignPurchaseResp signPurchaseResp) {
        this.purchaseInfo = signPurchaseResp;
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
