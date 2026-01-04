package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class GetAvailableGradePackagesResp extends Response {
    private List<Voucher> availableVouchers;
    private List<PackageGrades> packageGrades;
    private long serverTime = -1;
    private List<CloudPackage> spacePackages;

    public List<Voucher> getAvailableVouchers() {
        return this.availableVouchers;
    }

    public List<PackageGrades> getPackageGrades() {
        return this.packageGrades;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public List<CloudPackage> getSpacePackages() {
        return this.spacePackages;
    }

    public void setAvailableVouchers(List<Voucher> list) {
        this.availableVouchers = list;
    }

    public void setPackageGrades(List<PackageGrades> list) {
        this.packageGrades = list;
    }

    public void setServerTime(long j10) {
        this.serverTime = j10;
    }

    public void setSpacePackages(List<CloudPackage> list) {
        this.spacePackages = list;
    }
}
