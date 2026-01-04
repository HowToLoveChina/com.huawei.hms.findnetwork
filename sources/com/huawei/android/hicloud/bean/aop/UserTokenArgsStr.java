package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class UserTokenArgsStr {

    @SerializedName("userTokenReq")
    private UserTokenReq userTokenReq;

    public UserTokenReq getUserTokenReq() {
        return this.userTokenReq;
    }

    public void setUserTokenReq(UserTokenReq userTokenReq) {
        this.userTokenReq = userTokenReq;
    }
}
