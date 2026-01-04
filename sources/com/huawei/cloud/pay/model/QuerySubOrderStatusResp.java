package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class QuerySubOrderStatusResp extends Response implements Serializable {
    private static final long serialVersionUID = 2716892445641214166L;
    private BigDecimal amount;
    private long capacity;
    private String currency;
    private BigDecimal discountAmt;
    private int durationMonth;
    private int durationUnit;
    private long endtime;
    private MemGradeRights gradeRights;
    private PackageGrade packageGrade;
    private int productType;
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

    public PackageGrade getPackageGrade() {
        return this.packageGrade;
    }

    public int getProductType() {
        return this.productType;
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

    public void setPackageGrade(PackageGrade packageGrade) {
        this.packageGrade = packageGrade;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setTotalCapacity(long j10) {
        this.totalCapacity = j10;
    }
}
