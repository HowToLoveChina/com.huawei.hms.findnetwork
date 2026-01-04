package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.pay.internal.BaseReq;

/* loaded from: classes8.dex */
public class PayReq extends BaseReq {

    @Packed
    public String amount;

    @Packed
    public String country;

    @Packed
    public String currency;

    @Packed
    public String expireTime;

    @Packed
    public String partnerIDs;

    @Packed
    public String productDesc;

    @Packed
    public String productName;

    @Packed
    public int validTime;

    public String getAmount() {
        return this.amount;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getExpireTime() {
        return this.expireTime;
    }

    public String getPartnerIDs() {
        return this.partnerIDs;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getValidTime() {
        return this.validTime;
    }
}
