package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class PurchaseInfoInnerRequest extends PurchaseInfoRequest {

    @Packed
    private String hmsSdkVersionName;

    public PurchaseInfoInnerRequest() {
        this.hmsSdkVersionName = "6.13.0.303";
    }

    public String getHmsSdkVersionName() {
        return this.hmsSdkVersionName;
    }

    public void setHmsSdkVersionName(String str) {
        this.hmsSdkVersionName = str;
    }

    public PurchaseInfoInnerRequest(PurchaseInfoRequest purchaseInfoRequest) {
        setSign(purchaseInfoRequest.getSign());
        setTs(purchaseInfoRequest.getTs());
        setPageNo(purchaseInfoRequest.getPageNo());
        setPriceType(purchaseInfoRequest.getPriceType());
        setAppId(purchaseInfoRequest.getAppId());
        setMerchantId(purchaseInfoRequest.getMerchantId());
        setProductId(purchaseInfoRequest.getProductId());
        this.hmsSdkVersionName = "6.13.0.303";
    }
}
