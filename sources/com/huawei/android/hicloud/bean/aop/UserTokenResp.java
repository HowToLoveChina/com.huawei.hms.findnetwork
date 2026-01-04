package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class UserTokenResp {

    @SerializedName("type")
    private int type;

    @SerializedName("userToken")
    private String userToken;

    public int getType() {
        return this.type;
    }

    public String getUserToken() {
        return this.userToken;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setUserToken(String str) {
        this.userToken = str;
    }
}
