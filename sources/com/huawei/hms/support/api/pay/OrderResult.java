package com.huawei.hms.support.api.pay;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.entity.pay.OrderResp;

/* loaded from: classes8.dex */
public class OrderResult extends Result {
    private String newSign;
    private String orderID;
    private String orderTime;
    private String requestId;
    private int returnCode;
    private String returnDesc;
    private String sign;
    private String signatureAlgorithm;
    private String status;
    private String tradeTime;

    public OrderResult() {
    }

    private static <T> T get(T t10) {
        return t10;
    }

    private void setOrderID(String str) {
        this.orderID = str;
    }

    private void setOrderStatus(String str) {
        this.status = str;
    }

    private void setOrderTime(String str) {
        this.orderTime = str;
    }

    private void setRequestId(String str) {
        this.requestId = str;
    }

    private void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    private void setReturnDesc(String str) {
        this.returnDesc = str;
    }

    private void setSign(String str) {
        this.sign = str;
    }

    private void setTradeTime(String str) {
        this.tradeTime = str;
    }

    public String getNewSign() {
        return this.newSign;
    }

    public String getOrderID() {
        return (String) get(this.orderID);
    }

    public String getOrderStatus() {
        return (String) get(this.status);
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
        return this.signatureAlgorithm;
    }

    public String getTradeTime() {
        return (String) get(this.tradeTime);
    }

    public void setNewSign(String str) {
        this.newSign = str;
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
    }

    public OrderResult(OrderResp orderResp) {
        setReturnCode(orderResp.getReturnCode());
        setReturnDesc(orderResp.getReturnDesc());
        setRequestId(orderResp.getRequestId());
        setOrderID(orderResp.getOrderID());
        setOrderTime(orderResp.getOrderTime());
        setTradeTime(orderResp.getTradeTime());
        setOrderStatus(orderResp.getStatus());
        setSign(orderResp.getSign());
        setNewSign(orderResp.getNewSign());
        setSignatureAlgorithm(orderResp.getSignatureAlgorithm());
    }
}
