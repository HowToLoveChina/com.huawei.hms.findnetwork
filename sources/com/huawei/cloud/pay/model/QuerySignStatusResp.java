package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class QuerySignStatusResp extends Response implements Serializable {
    private static final long serialVersionUID = 3068038691406532828L;
    private String amount;
    private String applicationID;
    private String country;
    private String currency;
    private BigDecimal discountAmt;
    private String merchantId;
    private String merchantName;
    private String productDesc;
    private String productName;
    private int productType;
    private String requestId;
    private String reservedInfor;
    private int sdkChannel;
    private String serviceCatalog;
    private String sign;
    private int signStatus;
    private String tradeType;
    private String url;
    private String urlVer;
    private String voucherCode;

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

    public BigDecimal getDiscountAmt() {
        return this.discountAmt;
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

    public int getProductType() {
        return this.productType;
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

    public int getSignStatus() {
        return this.signStatus;
    }

    public String getTradeType() {
        return this.tradeType;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUrlVer() {
        return this.urlVer;
    }

    public String getVoucherCode() {
        return this.voucherCode;
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

    public void setDiscountAmt(BigDecimal bigDecimal) {
        this.discountAmt = bigDecimal;
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

    public void setProductType(int i10) {
        this.productType = i10;
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

    public void setServiceCatalog(String str) {
        this.serviceCatalog = str;
    }

    public void setSign(String str) {
        this.sign = str;
    }

    public void setSignStatus(int i10) {
        this.signStatus = i10;
    }

    public void setTradeType(String str) {
        this.tradeType = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUrlVer(String str) {
        this.urlVer = str;
    }

    public void setVoucherCode(String str) {
        this.voucherCode = str;
    }
}
