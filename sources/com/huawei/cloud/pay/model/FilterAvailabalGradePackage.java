package com.huawei.cloud.pay.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class FilterAvailabalGradePackage {
    private long capacity;
    private CountDownConfig countDownConfig;
    private String gradeCode;
    private String memAD;
    private PackageGrades packageGrades;
    private String renewChooseDesc;
    private int renewChooseType;
    private List<CloudPackage> basicPackageList = new ArrayList();
    private List<CloudPackage> monthlyPackageList = new ArrayList();
    private List<CloudPackage> incrementList = new ArrayList();
    private List<String> packageIdList = new ArrayList();
    private long serverTime = -1;

    public List<CloudPackage> getBasicPackageList() {
        return this.basicPackageList;
    }

    public long getCapacity() {
        return this.capacity;
    }

    public CountDownConfig getCountDownConfig() {
        return this.countDownConfig;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public List<CloudPackage> getIncrementList() {
        return this.incrementList;
    }

    public String getMemAD() {
        return this.memAD;
    }

    public List<CloudPackage> getMonthlyPackageList() {
        return this.monthlyPackageList;
    }

    public PackageGrades getPackageGrades() {
        return this.packageGrades;
    }

    public List<String> getPackageIdList() {
        return this.packageIdList;
    }

    public String getRenewChooseDesc() {
        return this.renewChooseDesc;
    }

    public int getRenewChooseType() {
        return this.renewChooseType;
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public void setBasicPackageList(List<CloudPackage> list) {
        this.basicPackageList = list;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setCountDownConfig(CountDownConfig countDownConfig) {
        this.countDownConfig = countDownConfig;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setIncrementList(List<CloudPackage> list) {
        this.incrementList = list;
    }

    public void setMemAD(String str) {
        this.memAD = str;
    }

    public void setMonthlyPackageList(List<CloudPackage> list) {
        this.monthlyPackageList = list;
    }

    public void setPackageGrades(PackageGrades packageGrades) {
        this.packageGrades = packageGrades;
    }

    public void setPackageIdList(List<String> list) {
        this.packageIdList = list;
    }

    public void setRenewChooseDesc(String str) {
        this.renewChooseDesc = str;
    }

    public void setRenewChooseType(int i10) {
        this.renewChooseType = i10;
    }

    public void setServerTime(long j10) {
        this.serverTime = j10;
    }
}
