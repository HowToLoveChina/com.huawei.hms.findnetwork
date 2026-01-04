package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class ExtendInfo {

    @SerializedName("campaignAlias")
    private String[] campaignAlias;

    @SerializedName("otherInfo")
    private String otherInfo;

    @SerializedName("tokenScence")
    private String tokenScence;

    public String[] getCampaignAlias() {
        return this.campaignAlias;
    }

    public String getOtherInfo() {
        return this.otherInfo;
    }

    public String getTokenScence() {
        return this.tokenScence;
    }

    public void setCampaignAlias(String[] strArr) {
        this.campaignAlias = strArr;
    }

    public void setOtherInfo(String str) {
        this.otherInfo = str;
    }

    public void setTokenScence(String str) {
        this.tokenScence = str;
    }
}
