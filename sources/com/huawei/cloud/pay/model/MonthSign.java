package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class MonthSign extends Response {
    private String amount;
    private String applicationID;
    private String country;
    private String currency;
    private String merchantId;
    private String merchantName;
    private String productDesc;
    private String productName;
    private String requestId;
    private int sdkChannel;
    private String serviceCatalog;
    private String sign;
    private String tradeType;
    private String url;

    public String getAmount() {
        return this.amount;
    }

    public String getApplicationID() {
        return this.applicationID;
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

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getProductDesc() {
        return this.productDesc;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getRequestId() {
        return this.requestId;
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

    public String getTradeType() {
        return this.tradeType;
    }

    public String getUrl() {
        return this.url;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setApplicationID(String str) {
        this.applicationID = str;
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

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setProductDesc(String str) {
        this.productDesc = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSdkChannel(int i10) {
        this.sdkChannel = i10;
    }

    public void setServiceCatalog(String str) {
        this.serviceCatalog = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setTradeType(String str) {
        this.tradeType = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
