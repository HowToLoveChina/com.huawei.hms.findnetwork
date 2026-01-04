package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class GradePackage {

    @SerializedName("clearableSpace")
    private String clearableSpace;

    @SerializedName("gradeCode")
    private String gradeCode;

    @SerializedName("residualSpace")
    private String residualSpace;

    public String getClearableSpace() {
        return this.clearableSpace;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getResidualSpace() {
        return this.residualSpace;
    }

    public void setClearableSpace(String str) {
        this.clearableSpace = str;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setResidualSpace(String str) {
        this.residualSpace = str;
    }
}
