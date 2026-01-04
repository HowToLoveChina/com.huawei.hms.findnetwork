package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class AcceptSignGiftInfo implements Serializable {
    private static final long serialVersionUID = -7362253451091664146L;
    private BigDecimal amount;
    private String baseId;
    private long capacity;
    private String currency;
    private int durationMonth;
    private int durationUnit;
    private long endtime;
    private MemGradeRights gradeRights;

    /* renamed from: id */
    private String f21393id;
    private int isAutoPay;
    private PackageGrade packageGrade;
    private int productType;
    private String requestId;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getBaseId() {
        return this.baseId;
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

    public long getEndtime() {
        return this.endtime;
    }

    public MemGradeRights getGradeRights() {
        return this.gradeRights;
    }

    public String getId() {
        return this.f21393id;
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

    public String getRequestId() {
        return this.requestId;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setBaseId(String str) {
        this.baseId = str;
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

    public void setEndtime(long j10) {
        this.endtime = j10;
    }

    public void setGradeRights(MemGradeRights memGradeRights) {
        this.gradeRights = memGradeRights;
    }

    public void setId(String str) {
        this.f21393id = str;
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

    public void setRequestId(String str) {
        this.requestId = str;
    }
}
