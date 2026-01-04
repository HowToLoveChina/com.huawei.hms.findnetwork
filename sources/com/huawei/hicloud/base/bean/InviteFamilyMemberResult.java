package com.huawei.hicloud.base.bean;

import java.util.List;

/* loaded from: classes6.dex */
public class InviteFamilyMemberResult {
    public static final int STATUS_OK = 0;
    private List<FailedFamilyMemberInfo> failedFamilyMembers;
    private int retCode = 0;
    private String retDesc;

    public List<FailedFamilyMemberInfo> getFailedFamilyMembers() {
        return this.failedFamilyMembers;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetDesc() {
        return this.retDesc;
    }

    public void setFailedFamilyMembers(List<FailedFamilyMemberInfo> list) {
        this.failedFamilyMembers = list;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setRetDesc(String str) {
        this.retDesc = str;
    }
}
