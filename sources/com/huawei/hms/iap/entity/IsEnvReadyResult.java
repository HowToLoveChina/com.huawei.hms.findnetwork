package com.huawei.hms.iap.entity;

import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class IsEnvReadyResult extends Result {
    private int accountFlag;
    private String carrierId;
    private String country;
    private String errMsg;
    private int returnCode;

    @Deprecated
    public int getAccountFlag() {
        return this.accountFlag;
    }

    public String getCarrierId() {
        return this.carrierId;
    }

    public String getCountry() {
        return this.country;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public void setAccountFlag(int i10) {
        this.accountFlag = i10;
    }

    public void setCarrierId(String str) {
        this.carrierId = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }
}
