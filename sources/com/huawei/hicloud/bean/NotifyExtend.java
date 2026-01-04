package com.huawei.hicloud.bean;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class NotifyExtend {

    @SerializedName("accountSetVer")
    private String accountSetVer;

    @SerializedName("params")
    private JsonObject params;

    @SerializedName("spaceType")
    private int spaceType;

    public String getAccountSetVer() {
        return this.accountSetVer;
    }

    public JsonObject getParams() {
        return this.params;
    }

    public int getSpaceType() {
        return this.spaceType;
    }

    public void setAccountSetVer(String str) {
        this.accountSetVer = str;
    }

    public void setParams(JsonObject jsonObject) {
        this.params = jsonObject;
    }

    public void setSpaceType(int i10) {
        this.spaceType = i10;
    }
}
