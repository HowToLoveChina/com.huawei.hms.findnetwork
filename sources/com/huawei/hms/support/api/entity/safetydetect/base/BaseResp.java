package com.huawei.hms.support.api.entity.safetydetect.base;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class BaseResp {

    @Packed
    private String errorReason;

    @Packed
    private int rtnCode;

    public String getErrorReason() {
        return this.errorReason;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setRtnCode(int i10) {
        this.rtnCode = i10;
    }

    public String toString() {
        return "rtnCode=" + getRtnCode() + "|errorReason=" + getErrorReason();
    }
}
