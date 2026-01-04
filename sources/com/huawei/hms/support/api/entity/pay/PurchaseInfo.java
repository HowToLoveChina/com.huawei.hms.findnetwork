package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class PurchaseInfo implements IMessageEntity {

    @Packed
    private String appId;

    @Packed
    private String merchantId;

    @Packed
    private String productId;

    @Packed
    private String requestId;

    @Packed
    private String tradeTime;

    public String getAppId() {
        return this.appId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getTradeTime() {
        return this.tradeTime;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setTradeTime(String str) {
        this.tradeTime = str;
    }
}
