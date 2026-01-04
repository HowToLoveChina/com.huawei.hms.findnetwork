package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class QueryGiftableWelfaresResp extends Response {
    private Welfare giftableWelfare;
    private Welfare pickedWelfare;

    public Welfare getGiftableWelfare() {
        return this.giftableWelfare;
    }

    public Welfare getPickedWelfare() {
        return this.pickedWelfare;
    }

    public void setGiftableWelfare(Welfare welfare) {
        this.giftableWelfare = welfare;
    }

    public void setPickedWelfare(Welfare welfare) {
        this.pickedWelfare = welfare;
    }
}
