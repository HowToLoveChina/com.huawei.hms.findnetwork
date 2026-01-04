package com.huawei.hicloud.base.bean;

import java.io.Serializable;

/* loaded from: classes6.dex */
public class LastMemberInfo implements Serializable {
    private int expireDays;
    private String gradeCode;
    private long totalCapacity;

    public int getExpireDays() {
        return this.expireDays;
    }

    public String getGradeCode() {
        return this.gradeCode;
    }

    public long getTotalCapacity() {
        return this.totalCapacity;
    }

    public void setExpireDays(int i10) {
        this.expireDays = i10;
    }

    public void setGradeCode(String str) {
        this.gradeCode = str;
    }

    public void setTotalCapacity(long j10) {
        this.totalCapacity = j10;
    }
}
