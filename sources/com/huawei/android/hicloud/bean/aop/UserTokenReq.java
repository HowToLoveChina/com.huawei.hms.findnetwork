package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class UserTokenReq {

    @SerializedName("extendInfo")
    private ExtendInfo extendInfo;

    @SerializedName("forceOn")
    private String forceOn;

    @SerializedName("scopes")
    private String[] scopes;

    @SerializedName("userTokenOld")
    private String userTokenOld;

    public ExtendInfo getExtendInfo() {
        return this.extendInfo;
    }

    public String getForceOn() {
        return this.forceOn;
    }

    public String[] getScopes() {
        return this.scopes;
    }

    public String getUserTokenOld() {
        return this.userTokenOld;
    }

    public void setExtendInfo(ExtendInfo extendInfo) {
        this.extendInfo = extendInfo;
    }

    public void setForceOn(String str) {
        this.forceOn = str;
    }

    public void setScopes(String[] strArr) {
        this.scopes = strArr;
    }

    public void setUserTokenOld(String str) {
        this.userTokenOld = str;
    }
}
