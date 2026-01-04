package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class AcceptRightGiftResp extends Response {
    private GiftProductBean giftProduct;
    private MemGradeRights gradeRights;

    public GiftProductBean getGiftProduct() {
        return this.giftProduct;
    }

    public MemGradeRights getGradeRights() {
        return this.gradeRights;
    }

    public void setGiftProduct(GiftProductBean giftProductBean) {
        this.giftProduct = giftProductBean;
    }

    public void setGradeRights(MemGradeRights memGradeRights) {
        this.gradeRights = memGradeRights;
    }
}
