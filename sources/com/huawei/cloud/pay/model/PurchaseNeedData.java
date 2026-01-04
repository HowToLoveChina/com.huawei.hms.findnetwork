package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class PurchaseNeedData implements Serializable {
    private static final long serialVersionUID = -5631982525196781768L;
    private PackageGrades packageGrades;
    private ReportVoucherInfo reportVoucherInfo;
    private CloudPackage selectPackage;
    private List<Voucher> selectVouchers;

    public PackageGrades getPackageGrades() {
        return this.packageGrades;
    }

    public ReportVoucherInfo getReportVoucherInfo() {
        return this.reportVoucherInfo;
    }

    public CloudPackage getSelectPackage() {
        return this.selectPackage;
    }

    public List<Voucher> getSelectVouchers() {
        return this.selectVouchers;
    }

    public void setPackageGrades(PackageGrades packageGrades) {
        this.packageGrades = packageGrades;
    }

    public void setReportVoucherInfo(ReportVoucherInfo reportVoucherInfo) {
        this.reportVoucherInfo = reportVoucherInfo;
    }

    public void setSelectPackage(CloudPackage cloudPackage) {
        this.selectPackage = cloudPackage;
    }

    public void setSelectVouchers(List<Voucher> list) {
        this.selectVouchers = list;
    }
}
