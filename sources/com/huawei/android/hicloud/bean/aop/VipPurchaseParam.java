package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class VipPurchaseParam {

    @SerializedName("cbId")
    private String cbId;

    @SerializedName("membershipPurchaseParam")
    private MembershipPurchaseParam membershipPurchaseParam;

    public String getCbId() {
        return this.cbId;
    }

    public MembershipPurchaseParam getMembershipPurchaseParam() {
        return this.membershipPurchaseParam;
    }

    public void setCbId(String str) {
        this.cbId = str;
    }

    public void setMembershipPurchaseParam(MembershipPurchaseParam membershipPurchaseParam) {
        this.membershipPurchaseParam = membershipPurchaseParam;
    }
}
