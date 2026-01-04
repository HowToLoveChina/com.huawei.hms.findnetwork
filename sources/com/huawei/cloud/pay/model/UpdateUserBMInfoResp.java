package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class UpdateUserBMInfoResp extends Response {
    private MemGrade gradeInfo;

    public MemGrade getGradeInfo() {
        return this.gradeInfo;
    }

    @Override // com.huawei.cloud.pay.model.Response
    public String toString() {
        return "UpdateUserBMInfoResp{gradeInfo=" + this.gradeInfo + '}';
    }
}
