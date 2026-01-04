package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class FamilyShareInfoAndDetailResult {
    private String gradeCode;
    private FamilyDetailInfoResult mFamilyDetailInfoResult;
    private FamilyShareInfoResult mFamilyShareInfoResult;
    private long totalSpace;

    public FamilyDetailInfoResult getFamilyDetailInfoResult() {
        return this.mFamilyDetailInfoResult;
    }

    public FamilyShareInfoResult getFamilyShareInfoResult() {
        return this.mFamilyShareInfoResult;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public long getTotalSpace() {
        return this.totalSpace;
    }

    public void setFamilyDetailInfoResult(FamilyDetailInfoResult familyDetailInfoResult) {
        this.mFamilyDetailInfoResult = familyDetailInfoResult;
    }

    public void setFamilyShareInfoResult(FamilyShareInfoResult familyShareInfoResult) {
        this.mFamilyShareInfoResult = familyShareInfoResult;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setTotalSpace(long j10) {
        this.totalSpace = j10;
    }
}
