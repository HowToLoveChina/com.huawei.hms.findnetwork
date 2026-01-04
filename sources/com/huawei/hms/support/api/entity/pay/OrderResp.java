package com.huawei.hms.support.api.entity.pay;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class OrderResp extends AbstractMessageEntity {

    @Packed
    public String newSign;

    @Packed
    public String orderID;

    @Packed
    public String orderTime;

    @Packed
    public String requestId;

    @Packed
    public int returnCode;

    @Packed
    public String returnDesc;

    @Packed
    public String sign;

    @Packed
    public String signatureAlgorithm;

    @Packed
    public String status;

    @Packed
    public String tradeTime;

    private static <T> T get(T t10) {
        return t10;
    }

    public String getNewSign() {
        return this.newSign;
    }

    public String getOrderID() {
        return (String) get(this.orderID);
    }

    public String getOrderTime() {
        return (String) get(this.orderTime);
    }

    public String getRequestId() {
        return (String) get(this.requestId);
    }

    public int getReturnCode() {
        return ((Integer) get(Integer.valueOf(this.returnCode))).intValue();
    }

    public String getReturnDesc() {
        return (String) get(this.returnDesc);
    }

    public String getSign() {
        return (String) get(this.sign);
    }

    public String getSignatureAlgorithm() {
        return (String) get(this.signatureAlgorithm);
    }

    public String getStatus() {
        return (String) get(this.status);
    }

    public String getTradeTime() {
        return (String) get(this.tradeTime);
    }

    public void setNewSign(String str) {
        this.newSign = str;
    }

    public void setOrderID(String str) {
        this.orderID = str;
    }

    public void setOrderTime(String str) {
        this.orderTime = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public void setReturnDesc(String str) {
        this.returnDesc = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTradeTime(String str) {
        this.tradeTime = str;
    }
}
