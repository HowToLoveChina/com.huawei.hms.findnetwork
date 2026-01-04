package com.huawei.hms.iap.entity;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* renamed from: com.huawei.hms.iap.entity.e */
/* loaded from: classes8.dex */
public class C5638e implements IMessageEntity {

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
    public int status;

    @Packed
    private String subsFreeTrialPeriod;

    @Packed
    private String subsGroupId;

    @Packed
    private String subsGroupTitle;

    @Packed
    private String subsIntroductoryPeriod;

    @Packed
    private int subsIntroductoryPeriodCycles;

    @Packed
    private String subsIntroductoryPrice;

    @Packed
    private long subsIntroductoryPriceMicros;

    @Packed
    private int subsProductLevel;

    @Packed
    private String subscriptionPeriod;

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

    public String getSubsFreeTrialPeriod() {
        return this.subsFreeTrialPeriod;
    }

    public String getSubsGroupId() {
        return this.subsGroupId;
    }

    public String getSubsGroupTitle() {
        return this.subsGroupTitle;
    }

    public String getSubsIntroductoryPeriod() {
        return this.subsIntroductoryPeriod;
    }

    public int getSubsIntroductoryPeriodCycles() {
        return this.subsIntroductoryPeriodCycles;
    }

    public String getSubsIntroductoryPrice() {
        return this.subsIntroductoryPrice;
    }

    public long getSubsIntroductoryPriceMicros() {
        return this.subsIntroductoryPriceMicros;
    }

    public int getSubsProductLevel() {
        return this.subsProductLevel;
    }

    public String getSubscriptionPeriod() {
        return this.subscriptionPeriod;
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

    public void setSubsFreeTrialPeriod(String str) {
        this.subsFreeTrialPeriod = str;
    }

    public void setSubsGroupId(String str) {
        this.subsGroupId = str;
    }

    public void setSubsGroupTitle(String str) {
        this.subsGroupTitle = str;
    }

    public void setSubsIntroductoryPeriod(String str) {
        this.subsIntroductoryPeriod = str;
    }

    public void setSubsIntroductoryPeriodCycles(int i10) {
        this.subsIntroductoryPeriodCycles = i10;
    }

    public void setSubsIntroductoryPrice(String str) {
        this.subsIntroductoryPrice = str;
    }

    public void setSubsIntroductoryPriceMicros(long j10) {
        this.subsIntroductoryPriceMicros = j10;
    }

    public void setSubsProductLevel(int i10) {
        this.subsProductLevel = i10;
    }

    public void setSubscriptionPeriod(String str) {
        this.subscriptionPeriod = str;
    }

    public ProductInfo toProductInfo() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(getProductId());
        productInfo.setPriceType(getPriceType());
        productInfo.setPrice(getPrice());
        productInfo.setMicrosPrice(getMicrosPrice());
        productInfo.setOriginalLocalPrice(getOriginalLocalPrice());
        productInfo.setOriginalMicroPrice(getOriginalMicroPrice());
        productInfo.setCurrency(getCurrency());
        productInfo.setProductName(getProductName());
        productInfo.setProductDesc(getProductDesc());
        productInfo.setSubPeriod(getSubscriptionPeriod());
        productInfo.setSubSpecialPrice(getSubsIntroductoryPrice());
        productInfo.setOfferUsedStatus(getOfferUsedStatus());
        productInfo.setSubSpecialPriceMicros(getSubsIntroductoryPriceMicros());
        productInfo.setSubSpecialPeriod(getSubsIntroductoryPeriod());
        productInfo.setSubSpecialPeriodCycles(getSubsIntroductoryPeriodCycles());
        productInfo.setSubFreeTrialPeriod(getSubsFreeTrialPeriod());
        productInfo.setSubGroupId(getSubsGroupId());
        productInfo.setSubGroupTitle(getSubsGroupTitle());
        productInfo.setSubProductLevel(getSubsProductLevel());
        productInfo.setStatus(getStatus());
        return productInfo;
    }
}
