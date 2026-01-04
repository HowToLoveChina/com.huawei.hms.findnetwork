package com.huawei.cloud.pay.model;

import com.google.gson.Gson;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class MemGrade implements Serializable {
    private static final long serialVersionUID = -8645859404941562287L;
    private String gradeCode;
    private String gradeName;

    public String getGradeCode() {
        return this.gradeCode;
    }

    public String getGradeName() {
        return this.gradeName;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setGradeName(String str) {
        this.gradeName = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
