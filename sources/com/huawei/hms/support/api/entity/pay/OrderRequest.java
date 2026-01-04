package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class OrderRequest implements IMessageEntity {

    @Packed
    public String keyType;

    @Packed
    public String merchantId;

    @Packed
    public String requestId;

    @Packed
    public String reservedInfor;

    @Packed
    public String sign;

    @Packed
    public String signatureAlgorithm;

    @Packed
    public String time;

    private static <T> T get(T t10) {
        return t10;
    }

    public String getKeyType() {
        return (String) get(this.keyType);
    }

    public String getMerchantId() {
        return (String) get(this.merchantId);
    }

    public String getRequestId() {
        return (String) get(this.requestId);
    }

    public String getReservedInfor() {
        return this.reservedInfor;
    }

    public String getSign() {
        return (String) get(this.sign);
    }

    public String getSignatureAlgorithm() {
        return (String) get(this.signatureAlgorithm);
    }

    public String getTime() {
        return (String) get(this.time);
    }

    public void setKeyType(String str) {
        this.keyType = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }

    public void setTime(String str) {
        this.time = str;
    }
}
