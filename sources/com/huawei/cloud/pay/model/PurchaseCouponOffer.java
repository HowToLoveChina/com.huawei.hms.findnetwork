package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class PurchaseCouponOffer implements Serializable {
    private static final long serialVersionUID = 4135910723811105825L;
    private String couponInfo;
    private String couponSignature;

    public String getCouponInfo() {
        return this.couponInfo;
    }

    public String getCouponSignature() {
        return this.couponSignature;
    }

    public void setCouponInfo(String str) {
        this.couponInfo = str;
    }

    public void setCouponSignature(String str) {
        this.couponSignature = str;
    }
}
