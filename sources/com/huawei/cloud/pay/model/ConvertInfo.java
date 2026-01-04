package com.huawei.cloud.pay.model;

import com.google.gson.Gson;
import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class ConvertInfo implements Serializable {
    private static final long serialVersionUID = 1;
    private BigDecimal basePrice;
    private long capacity;
    private int convertDays;
    private int convertPopType;
    private String currency;
    private int durationMonth;
    private int packageConvertDays;
    private int packageDays;
    private String productName;
    private int remainDays;
    private int supportAutoPay;
    private String symbol;
    private long totalCapacity;
    private int totalConvertDays;

    public BigDecimal getBasePrice() {
        return this.basePrice;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public int getConvertDays() {
        return this.convertDays;
    }

    public int getConvertPopType() {
        return this.convertPopType;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getDurationMonth() {
        return this.durationMonth;
    }

    public int getPackageConvertDays() {
        return this.packageConvertDays;
    }

    public int getPackageDays() {
        return this.packageDays;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getRemainDays() {
        return this.remainDays;
    }

    public int getSupportAutoPay() {
        return this.supportAutoPay;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getTotalCapacity() {
        return this.totalCapacity;
    }

    public int getTotalConvertDays() {
        return this.totalConvertDays;
    }

    public void setBasePrice(BigDecimal bigDecimal) {
        this.basePrice = bigDecimal;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setConvertDays(int i10) {
        this.convertDays = i10;
    }

    public void setConvertPopType(int i10) {
        this.convertPopType = i10;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDurationMonth(int i10) {
        this.durationMonth = i10;
    }

    public void setPackageConvertDays(int i10) {
        this.packageConvertDays = i10;
    }

    public void setPackageDays(int i10) {
        this.packageDays = i10;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setRemainDays(int i10) {
        this.remainDays = i10;
    }

    public void setSupportAutoPay(int i10) {
        this.supportAutoPay = i10;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTotalCapacity(long j10) {
        this.totalCapacity = j10;
    }

    public void setTotalConvertDays(int i10) {
        this.totalConvertDays = i10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
