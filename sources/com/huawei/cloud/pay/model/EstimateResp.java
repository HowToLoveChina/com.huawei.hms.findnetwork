package com.huawei.cloud.pay.model;

import java.util.List;

/* loaded from: classes5.dex */
public class EstimateResp extends Response {
    private Long capacity;
    private ConvertInfo convertInfo;
    private List<CurPkgInfo> curPkgsInfo;
    private Long endtime;
    private PackageGrades grade;
    private MemGradeRights gradeRights;

    /* renamed from: id */
    private String f21406id;
    private int isAutoPay;
    private PackageGrades packageGrade;
    private String productName;
    private int productType;
    private Long starttime;

    public Long getCapacity() {
        return this.capacity;
    }

    public ConvertInfo getConvertInfo() {
        return this.convertInfo;
    }

    public List<CurPkgInfo> getCurPkgsInfo() {
        return this.curPkgsInfo;
    }

    public Long getEndtime() {
        return this.endtime;
    }

    public PackageGrades getGrade() {
        return this.grade;
    }

    public MemGradeRights getGradeRights() {
        return this.gradeRights;
    }

    public String getId() {
        return this.f21406id;
    }

    public int getIsAutoPay() {
        return this.isAutoPay;
    }

    public PackageGrades getPackageGrade() {
        return this.packageGrade;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductType() {
        return this.productType;
    }

    public Long getStarttime() {
        return this.starttime;
    }

    public void setCapacity(Long l10) {
        this.capacity = l10;
    }

    public void setConvertInfo(ConvertInfo convertInfo) {
        this.convertInfo = convertInfo;
    }

    public void setCurPkgsInfo(List<CurPkgInfo> list) {
        this.curPkgsInfo = list;
    }

    public void setEndtime(Long l10) {
        this.endtime = l10;
    }

    public void setGrade(PackageGrades packageGrades) {
        this.grade = packageGrades;
    }

    public void setGradeRights(MemGradeRights memGradeRights) {
        this.gradeRights = memGradeRights;
    }

    public void setId(String str) {
        this.f21406id = str;
    }

    public void setIsAutoPay(int i10) {
        this.isAutoPay = i10;
    }

    public void setPackageGrade(PackageGrades packageGrades) {
        this.packageGrade = packageGrades;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setStarttime(Long l10) {
        this.starttime = l10;
    }
}
