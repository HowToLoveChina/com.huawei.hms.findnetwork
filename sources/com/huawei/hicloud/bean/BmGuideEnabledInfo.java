package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class BmGuideEnabledInfo {

    @SerializedName("isCheck")
    boolean isCheck = true;

    @SerializedName("packageId")
    String packageId;

    public String getPackageId() {
        return this.packageId;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setCheck(boolean z10) {
        this.isCheck = z10;
    }

    public void setPackageId(String str) {
        this.packageId = str;
    }
}
