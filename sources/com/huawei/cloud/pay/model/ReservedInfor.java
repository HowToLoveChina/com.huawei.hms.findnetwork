package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class ReservedInfor implements Serializable {
    private static final long serialVersionUID = -6336310153444639902L;
    private OrderPurchaseExtensionInformation orderPurchaseExtensionInformation;
    private PromotionalOffer promotionalOffer;
    private PurchaseCouponOffer purchaseCouponOffer;

    public OrderPurchaseExtensionInformation getOrderPurchaseExtensionInformation() {
        return this.orderPurchaseExtensionInformation;
    }

    public PromotionalOffer getPromotionalOffer() {
        return this.promotionalOffer;
    }

    public PurchaseCouponOffer getPurchaseCouponOffer() {
        return this.purchaseCouponOffer;
    }

    public void setOrderPurchaseExtensionInformation(OrderPurchaseExtensionInformation orderPurchaseExtensionInformation) {
        this.orderPurchaseExtensionInformation = orderPurchaseExtensionInformation;
    }

    public void setPromotionalOffer(PromotionalOffer promotionalOffer) {
        this.promotionalOffer = promotionalOffer;
    }

    public void setPurchaseCouponOffer(PurchaseCouponOffer purchaseCouponOffer) {
        this.purchaseCouponOffer = purchaseCouponOffer;
    }
}
