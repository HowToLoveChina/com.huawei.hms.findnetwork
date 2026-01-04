package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class CreateOrder extends Response {
    private String amount;
    private String applicationId;
    private String country;
    private String currency;
    private String merchantId;
    private String notifyUrl;
    private String productDesc;
    private String productId;
    private String productName;
    private String requestId;
    private String reservedInfor;
    private int sdkChannel;
    private String sign;
    private String urlVer;

    public String getAmount() {
        return this.amount;
    }

    public String getApplicationID() {
        return this.applicationId;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
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

    public String getSign() {
        return this.sign;
    }

    public String getUrlVer() {
        return this.urlVer;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public void setNotifyUrl(String str) {
        this.notifyUrl = str;
    }

    public void setProductDesc(String str) {
        this.productDesc = str;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setReservedInfor(String str) {
        this.reservedInfor = str;
    }

    public void setSdkChannel(int i10) {
        this.sdkChannel = i10;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setUrlVer(String str) {
        this.urlVer = str;
    }
}
