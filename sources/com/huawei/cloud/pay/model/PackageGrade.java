package com.huawei.cloud.pay.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes5.dex */
public class PackageGrade implements Serializable {
    private static final long serialVersionUID = -5376495033230799801L;
    private String gradeCode;
    private String gradeName;
    private List<MemGradeRight> rights;

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public List<MemGradeRight> getRights() {
        return this.rights;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public void setRights(List<MemGradeRight> list) {
        this.rights = list;
    }
}
