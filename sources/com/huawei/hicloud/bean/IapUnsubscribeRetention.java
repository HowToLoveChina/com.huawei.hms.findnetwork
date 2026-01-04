package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class IapUnsubscribeRetention {

    @SerializedName("passwordVerification")
    int passwordVerification = 1;

    @SerializedName("url")
    String url;

    public int getPasswordVerification() {
        return this.passwordVerification;
    }

    public String getUrl() {
        return this.url;
    }

    public void setPasswordVerification(int i10) {
        this.passwordVerification = i10;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
