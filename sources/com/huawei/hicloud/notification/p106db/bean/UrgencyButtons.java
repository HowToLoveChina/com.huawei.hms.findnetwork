package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class UrgencyButtons {

    @SerializedName("actionType")
    private String actionType;

    @SerializedName("name")
    private String name;

    public String getActionType() {
        return this.actionType;
    }

    public String getName() {
        return this.name;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
