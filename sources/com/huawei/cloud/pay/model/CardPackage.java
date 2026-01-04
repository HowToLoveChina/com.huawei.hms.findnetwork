package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class CardPackage implements Serializable {
    private static final long serialVersionUID = 2767434633527399121L;
    private long capacity;
    private String country;
    private long createTime;
    private String currency;
    private int durationMonth;
    private int durationUnit;
    private String encCardNo;

    /* renamed from: id */
    private String f21397id;
    private String omid;
    private BigDecimal price;
    private String productName;
    private String productType;
    private int status;
    private int supportAutoPay;
    private String symbol;
    private long updateTime;
    private String version;

    public long getCapacity() {
        return this.capacity;
    }

    public String getCountry() {
        return this.country;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getDurationMonth() {
        return this.durationMonth;
    }

    public int getDurationUnit() {
        return this.durationUnit;
    }

    public String getEncCardNo() {
        return this.encCardNo;
    }

    public String getId() {
        return this.f21397id;
    }

    public String getOmid() {
        return this.omid;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductType() {
        return this.productType;
    }

    public int getStatus() {
        return this.status;
    }

    public int getSupportAutoPay() {
        return this.supportAutoPay;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCreateTime(long j10) {
        this.createTime = j10;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDurationMonth(int i10) {
        this.durationMonth = i10;
    }

    public void setDurationUnit(int i10) {
        this.durationUnit = i10;
    }

    public void setEncCardNo(String str) {
        this.encCardNo = str;
    }

    public void setId(String str) {
        this.f21397id = str;
    }

    public void setOmid(String str) {
        this.omid = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setProductType(String str) {
        this.productType = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setSupportAutoPay(int i10) {
        this.supportAutoPay = i10;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUpdateTime(long j10) {
        this.updateTime = j10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
