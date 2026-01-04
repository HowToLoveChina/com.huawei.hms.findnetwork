package com.huawei.hms.iap.entity;

import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class IsSandboxActivatedResult extends Result {
    private String errMsg;
    private Boolean isSandboxApk;
    private Boolean isSandboxUser;
    private int returnCode;
    private String versionFrMarket;
    private String versionInApk;

    public String getErrMsg() {
        return this.errMsg;
    }

    public Boolean getIsSandboxApk() {
        return this.isSandboxApk;
    }

    public Boolean getIsSandboxUser() {
        return this.isSandboxUser;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getVersionFrMarket() {
        return this.versionFrMarket;
    }

    public String getVersionInApk() {
        return this.versionInApk;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setIsSandboxApk(Boolean bool) {
        this.isSandboxApk = bool;
    }

    public void setIsSandboxUser(Boolean bool) {
        this.isSandboxUser = bool;
    }

    public void setReturnCode(int i10) {
        this.returnCode = i10;
    }

    public void setVersionFrMarket(String str) {
        this.versionFrMarket = str;
    }

    public void setVersionInApk(String str) {
        this.versionInApk = str;
    }
}
