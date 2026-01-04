package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetGradeRightDetailReq extends Request {
    private String gradeCode;
    private int queryType;

    public GetGradeRightDetailReq(String str, String str2, int i10) {
        super(str);
        this.gradeCode = str2;
        this.queryType = i10;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public int getQueryType() {
        return this.queryType;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setQueryType(int i10) {
        this.queryType = i10;
    }
}
