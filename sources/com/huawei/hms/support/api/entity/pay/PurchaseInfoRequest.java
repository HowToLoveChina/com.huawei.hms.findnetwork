package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class PurchaseInfoRequest implements IMessageEntity {

    @Packed
    public String appId;

    @Packed
    public String merchantId;

    @Packed
    public long pageNo = 1;

    @Packed
    public String priceType;

    @Packed
    public String productId;

    @Packed
    public String reservedInfor;

    @Packed
    public String sign;

    @Packed
    public String signatureAlgorithm;

    /* renamed from: ts */
    @Packed
    public long f29796ts;

    public String getAppId() {
        return this.appId;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public long getPageNo() {
        return this.pageNo;
    }

    public String getPriceType() {
        return this.priceType;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getReservedInfor() {
        return this.reservedInfor;
    }

    public String getSign() {
        return this.sign;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public long getTs() {
        return this.f29796ts;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void setPageNo(long j10) {
        this.pageNo = j10;
    }

    public void setPriceType(String str) {
        this.priceType = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setReservedInfor(String str) {
        this.reservedInfor = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }

    public void setTs(long j10) {
        this.f29796ts = j10;
    }
}
