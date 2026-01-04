package com.huawei.cloud.pay.model;

import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class OrderResult extends Response {
    private BigDecimal amount;
    private long capacity;
    private String currency;
    private BigDecimal discountAmt;
    private int durationMonth;
    private int durationUnit;
    private long endtime;
    private MemGradeRights gradeRights;
    private int isAutoPay;
    private PackageGrade packageGrade;
    private int productType;
    private int scheme;
    private String status;
    private int subType;
    private long totalCapacity;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public String getCurrency() {
        return this.currency;
    }

    public BigDecimal getDiscountAmt() {
        return this.discountAmt;
    }

    public int getDurationMonth() {
        return this.durationMonth;
    }

    public int getDurationUnit() {
        return this.durationUnit;
    }

    public long getEndTime() {
        return this.endtime;
    }

    public MemGradeRights getGradeRights() {
        return this.gradeRights;
    }

    public int getIsAutoPay() {
        return this.isAutoPay;
    }

    public PackageGrade getPackageGrade() {
        return this.packageGrade;
    }

    public int getProductType() {
        return this.productType;
    }

    public int getScheme() {
        return this.scheme;
    }

    public String getStatus() {
        return this.status;
    }

    public int getSubType() {
        return this.subType;
    }

    public long getTotalCapacity() {
        return this.totalCapacity;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDiscountAmt(BigDecimal bigDecimal) {
        this.discountAmt = bigDecimal;
    }

    public void setDurationMonth(int i10) {
        this.durationMonth = i10;
    }

    public void setDurationUnit(int i10) {
        this.durationUnit = i10;
    }

    public void setEndTime(long j10) {
        this.endtime = j10;
    }

    public void setGradeRights(MemGradeRights memGradeRights) {
        this.gradeRights = memGradeRights;
    }

    public void setIsAutoPay(int i10) {
        this.isAutoPay = i10;
    }

    public void setPackageGrade(PackageGrade packageGrade) {
        this.packageGrade = packageGrade;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setScheme(int i10) {
        this.scheme = i10;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSubType(int i10) {
        this.subType = i10;
    }

    public void setTotalCapacity(long j10) {
        this.totalCapacity = j10;
    }
}
