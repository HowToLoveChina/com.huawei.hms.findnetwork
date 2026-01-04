package com.huawei.cloud.pay.model;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class CreateFreeOrderResp extends Response {
    private BigDecimal amount;
    private long capacity;
    private String currency;
    private BigDecimal discountAmt;

    @SerializedName("endtime")
    private long endTime;
    private MemGradeRights gradeRights;
    private PackageGrade packageGrade;
    private int productType;

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

    public long getEndTime() {
        return this.endTime;
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

    public void setEndTime(long j10) {
        this.endTime = j10;
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
}
