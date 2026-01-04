package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class PromotionalOffer implements Serializable {
    private static final long serialVersionUID = 3176942358148203707L;
    String purchaseDiscountInfo;
    String purchaseDiscountSignature;

    public String getPurchaseDiscountInfo() {
        return this.purchaseDiscountInfo;
    }

    public String getPurchaseDiscountSignature() {
        return this.purchaseDiscountSignature;
    }

    public void setPurchaseDiscountInfo(String str) {
        this.purchaseDiscountInfo = str;
    }

    public void setPurchaseDiscountSignature(String str) {
        this.purchaseDiscountSignature = str;
    }
}
