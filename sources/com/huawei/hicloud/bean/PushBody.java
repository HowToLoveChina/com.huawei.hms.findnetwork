package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class PushBody {
    private String grade = "";
    private String bmType = "";
    private int fromRegretDay = -1;

    public String getBmType() {
        return this.bmType;
    }

    public int getFromRegretDay() {
        return this.fromRegretDay;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setBmType(String str) {
        this.bmType = str;
    }

    public void setFromRegretDay(int i10) {
        this.fromRegretDay = i10;
    }

    public void setGrade(String str) {
        this.grade = str;
    }
}
