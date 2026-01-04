package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* renamed from: com.huawei.hms.iap.entity.a */
/* loaded from: classes8.dex */
public class C5634a extends AbstractMessageEntity {

    @Packed
    private String consumedPurchaseData;

    @Packed
    private String dataSignature;

    @Packed
    private String errMsg;

    @Packed
    private int returnCode;

    @Packed
    private String signatureAlgorithm;

    public String getConsumePurchaseData() {
        return this.consumedPurchaseData;
    }

    public String getDataSignature() {
        return this.dataSignature;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }
}
