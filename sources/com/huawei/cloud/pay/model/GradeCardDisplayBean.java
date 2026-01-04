package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class GradeCardDisplayBean implements Serializable {
    private static final long serialVersionUID = 1;
    private long capacity;
    private String currency;
    private int durationMonth;
    private int durationUnit;

    /* renamed from: id */
    private String f21409id;
    private PackageGrades packageGrades;
    private BigDecimal price;
    private String productName;
    private int productType;
    private BigDecimal spPrice;
    private String symbol;

    public GradeCardDisplayBean(CloudPackage cloudPackage, PackageGrades packageGrades) {
        this.productName = cloudPackage.getProductName();
        this.price = cloudPackage.getPrice();
        this.spPrice = cloudPackage.getSpPrice();
        this.symbol = cloudPackage.getSymbol();
        this.currency = cloudPackage.getCurrency();
        this.f21409id = cloudPackage.getId();
        this.durationMonth = cloudPackage.getDurationMonth();
        this.capacity = cloudPackage.getCapacity();
        this.packageGrades = packageGrades;
        this.productType = cloudPackage.getProductType();
        this.durationUnit = cloudPackage.getDurationUnit();
    }

    public long getCapacity() {
        return this.capacity;
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

    public String getId() {
        return this.f21409id;
    }

    public PackageGrades getPackageGrades() {
        return this.packageGrades;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductType() {
        return this.productType;
    }

    public BigDecimal getSpPrice() {
        return this.spPrice;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
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

    public void setId(String str) {
        this.f21409id = str;
    }

    public void setPackageGrades(PackageGrades packageGrades) {
        this.packageGrades = packageGrades;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setSpPrice(BigDecimal bigDecimal) {
        this.spPrice = bigDecimal;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public GradeCardDisplayBean(CardPackage cardPackage, PackageGrades packageGrades) {
        this.productName = cardPackage.getProductName();
        this.price = cardPackage.getPrice();
        this.symbol = cardPackage.getSymbol();
        this.currency = cardPackage.getCurrency();
        this.f21409id = cardPackage.getId();
        this.durationMonth = cardPackage.getDurationMonth();
        this.capacity = cardPackage.getCapacity();
        this.packageGrades = packageGrades;
        this.durationUnit = cardPackage.getDurationUnit();
    }
}
