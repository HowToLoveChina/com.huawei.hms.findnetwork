package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/* loaded from: classes5.dex */
public class GetPackagesBySpaceRuleResp extends Response implements Serializable {
    private static final long serialVersionUID = 7504260790572145242L;
    private long currentTime;
    private BigDecimal deductAmount;
    private List<PackageGrades> packageGrades;
    private List<CloudPackage> spacePackages;
    private List<Voucher> voucherList;

    public long getCurrentTime() {
        return this.currentTime;
    }

    public BigDecimal getDeductAmount() {
        return this.deductAmount;
    }

    public List<PackageGrades> getPackageGrades() {
        return this.packageGrades;
    }

    public List<CloudPackage> getSpacePackages() {
        return this.spacePackages;
    }

    public List<Voucher> getVoucherList() {
        return this.voucherList;
    }

    public void setCurrentTime(long j10) {
        this.currentTime = j10;
    }

    public void setDeductAmount(BigDecimal bigDecimal) {
        this.deductAmount = bigDecimal;
    }

    public void setPackageGrades(List<PackageGrades> list) {
        this.packageGrades = list;
    }

    public void setSpacePackages(List<CloudPackage> list) {
        this.spacePackages = list;
    }

    public void setVoucherList(List<Voucher> list) {
        this.voucherList = list;
    }
}
