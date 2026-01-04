package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class GameProductPayReq extends ProductPayRequest {

    @Packed
    public String channelId;

    @Packed
    public String cpId;

    @Packed
    public String sdkVersionName;

    public GameProductPayReq() {
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getCpID() {
        return this.cpId;
    }

    public String getSdkVersionName() {
        return this.sdkVersionName;
    }

    public GameProductPayReq(ProductPayRequest productPayRequest, String str) {
        this.sdkVersionName = "6.13.0.303";
        this.cpId = str;
        this.expireTime = productPayRequest.expireTime;
        this.validTime = productPayRequest.validTime;
        this.applicationID = productPayRequest.applicationID;
        this.extReserved = productPayRequest.extReserved;
        this.merchantId = productPayRequest.merchantId;
        this.merchantName = productPayRequest.merchantName;
        this.requestId = productPayRequest.requestId;
        this.sdkChannel = productPayRequest.sdkChannel;
        this.serviceCatalog = productPayRequest.serviceCatalog;
        this.sign = productPayRequest.sign;
        this.signatureAlgorithm = productPayRequest.signatureAlgorithm;
        this.url = productPayRequest.url;
        this.urlVer = productPayRequest.urlVer;
        this.productNo = productPayRequest.productNo;
        this.reservedInfor = productPayRequest.reservedInfor;
    }
}
