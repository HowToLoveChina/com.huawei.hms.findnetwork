package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class AcceptSignGiftResp extends Response implements Serializable {
    private static final long serialVersionUID = 2450898165215697930L;
    private AcceptSignGiftInfo gift;
    private SignPurchaseResp purchaseInfo;
    private QuerySignStatusResp signInfo;
    private int signMode;
    private int signStatus;

    public AcceptSignGiftInfo getGift() {
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

    public void setGift(AcceptSignGiftInfo acceptSignGiftInfo) {
        this.gift = acceptSignGiftInfo;
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
