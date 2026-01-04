package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class RetResult {
    public static final int STATUS_OK = 0;
    private int retCode = 0;
    private String retDesc;

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetDesc() {
        return this.retDesc;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setRetDesc(String str) {
        this.retDesc = str;
    }
}
