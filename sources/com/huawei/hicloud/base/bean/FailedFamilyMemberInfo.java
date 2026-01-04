package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class FailedFamilyMemberInfo {
    private Long failedUserId;
    private int retCode;
    private String retDesc;

    public Long getFailedUserId() {
        return this.failedUserId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetDesc() {
        return this.retDesc;
    }

    public void setFailedUserId(Long l10) {
        this.failedUserId = l10;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setRetDesc(String str) {
        this.retDesc = str;
    }
}
