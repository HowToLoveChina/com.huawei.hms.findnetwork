package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class ProductInfo implements IMessageEntity {

    @Packed
    private String currency;

    @Packed
    private long microsPrice;

    @Packed
    private int offerUsedStatus = -1;

    @Packed
    private String originalLocalPrice;

    @Packed
    private long originalMicroPrice;

    @Packed
    private String price;

    @Packed
    private int priceType;

    @Packed
    private String productDesc;

    @Packed
    private String productId;

    @Packed
    private String productName;

    @Packed
    private int status;

    @Packed
    private String subFreeTrialPeriod;

    @Packed
    private String subGroupId;

    @Packed
    private String subGroupTitle;

    @Packed
    private String subPeriod;

    @Packed
    private int subProductLevel;

    @Packed
    private String subSpecialPeriod;

    @Packed
    private int subSpecialPeriodCycles;

    @Packed
    private String subSpecialPrice;

    @Packed
    private long subSpecialPriceMicros;

    public String getCurrency() {
        return this.currency;
    }

    public long getMicrosPrice() {
        return this.microsPrice;
    }

    public int getOfferUsedStatus() {
        return this.offerUsedStatus;
    }

    public String getOriginalLocalPrice() {
        return this.originalLocalPrice;
    }

    public long getOriginalMicroPrice() {
        return this.originalMicroPrice;
    }

    public String getPrice() {
        return this.price;
    }

    public int getPriceType() {
        return this.priceType;
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

    public int getStatus() {
        return this.status;
    }

    public String getSubFreeTrialPeriod() {
        return this.subFreeTrialPeriod;
    }

    public String getSubGroupId() {
        return this.subGroupId;
    }

    public String getSubGroupTitle() {
        return this.subGroupTitle;
    }

    public String getSubPeriod() {
        return this.subPeriod;
    }

    public int getSubProductLevel() {
        return this.subProductLevel;
    }

    public String getSubSpecialPeriod() {
        return this.subSpecialPeriod;
    }

    public int getSubSpecialPeriodCycles() {
        return this.subSpecialPeriodCycles;
    }

    public String getSubSpecialPrice() {
        return this.subSpecialPrice;
    }

    public long getSubSpecialPriceMicros() {
        return this.subSpecialPriceMicros;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setMicrosPrice(long j10) {
        this.microsPrice = j10;
    }

    public void setOfferUsedStatus(int i10) {
        this.offerUsedStatus = i10;
    }

    public void setOriginalLocalPrice(String str) {
        this.originalLocalPrice = str;
    }

    public void setOriginalMicroPrice(long j10) {
        this.originalMicroPrice = j10;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPriceType(int i10) {
        this.priceType = i10;
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

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setSubFreeTrialPeriod(String str) {
        this.subFreeTrialPeriod = str;
    }

    public void setSubGroupId(String str) {
        this.subGroupId = str;
    }

    public void setSubGroupTitle(String str) {
        this.subGroupTitle = str;
    }

    public void setSubPeriod(String str) {
        this.subPeriod = str;
    }

    public void setSubProductLevel(int i10) {
        this.subProductLevel = i10;
    }

    public void setSubSpecialPeriod(String str) {
        this.subSpecialPeriod = str;
    }

    public void setSubSpecialPeriodCycles(int i10) {
        this.subSpecialPeriodCycles = i10;
    }

    public void setSubSpecialPrice(String str) {
        this.subSpecialPrice = str;
    }

    public void setSubSpecialPriceMicros(long j10) {
        this.subSpecialPriceMicros = j10;
    }
}
