package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class OrderPurchaseExtensionInformation implements Serializable {
    private static final long serialVersionUID = 6458725221927657837L;
    private String purchaseExtension;
    private String purchaseExtensionSignature;

    public String getPurchaseExtension() {
        return this.purchaseExtension;
    }

    public String getPurchaseExtensionSignature() {
        return this.purchaseExtensionSignature;
    }

    public void setPurchaseExtension(String str) {
        this.purchaseExtension = str;
    }

    public void setPurchaseExtensionSignature(String str) {
        this.purchaseExtensionSignature = str;
    }
}
