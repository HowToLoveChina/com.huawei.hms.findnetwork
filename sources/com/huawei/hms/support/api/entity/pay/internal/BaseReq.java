package com.huawei.hms.support.api.entity.pay.internal;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class BaseReq implements IMessageEntity {

    @Packed
    public String applicationID;

    @Packed
    public String extReserved;

    @Packed
    public String merchantId;

    @Packed
    public String merchantName;

    @Packed
    public String requestId;

    @Packed
    public String reservedInfor;

    @Packed
    public int sdkChannel;

    @Packed
    public String serviceCatalog;

    @Packed
    public String sign;

    @Packed
    public String signatureAlgorithm;

    @Packed
    public String url;

    @Packed
    public String urlVer;

    public String getApplicationID() {
        return this.applicationID;
    }

    public String getExtReserved() {
        return this.extReserved;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getReservedInfor() {
        return this.reservedInfor;
    }

    public int getSdkChannel() {
        return this.sdkChannel;
    }

    public String getServiceCatalog() {
        return this.serviceCatalog;
    }

    public String getSign() {
        return this.sign;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlVer() {
        return this.urlVer;
    }
}
