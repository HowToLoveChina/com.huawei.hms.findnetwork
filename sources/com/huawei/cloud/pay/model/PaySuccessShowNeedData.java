package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public class PaySuccessShowNeedData implements Serializable {
    private static final long serialVersionUID = -2323310636927453097L;
    private BigDecimal amount;
    private long capacity;
    private String currency;
    private int durationMonth;
    private int durationUnit;
    private MemGradeRights gradeRights;
    private int isAutoPay;
    private PackageGrade packageGrade;
    private GetClientUIConfigResp params;
    private int productType;
    private long renewalTime;
    private int scheme;
    private int subType;
    private long totalCapacity;
    private UserPackage user;

    public BigDecimal getAmount() {
        return this.amount;
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

    public MemGradeRights getGradeRights() {
        return this.gradeRights;
    }

    public int getIsAutoPay() {
        return this.isAutoPay;
    }

    public PackageGrade getPackageGrade() {
        return this.packageGrade;
    }

    public GetClientUIConfigResp getParams() {
        return this.params;
    }

    public int getProductType() {
        return this.productType;
    }

    public long getRenewalTime() {
        return this.renewalTime;
    }

    public int getScheme() {
        return this.scheme;
    }

    public int getSubType() {
        return this.subType;
    }

    public long getTotalCapacity() {
        return this.totalCapacity;
    }

    public UserPackage getUser() {
        return this.user;
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

    public void setDurationMonth(int i10) {
        this.durationMonth = i10;
    }

    public void setDurationUnit(int i10) {
        this.durationUnit = i10;
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

    public void setParams(GetClientUIConfigResp getClientUIConfigResp) {
        this.params = getClientUIConfigResp;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setRenewalTime(long j10) {
        this.renewalTime = j10;
    }

    public void setScheme(int i10) {
        this.scheme = i10;
    }

    public void setSubType(int i10) {
        this.subType = i10;
    }

    public void setTotalCapacity(long j10) {
        this.totalCapacity = j10;
    }

    public void setUser(UserPackage userPackage) {
        this.user = userPackage;
    }
}
