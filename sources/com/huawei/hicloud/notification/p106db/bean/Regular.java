package com.huawei.hicloud.notification.p106db.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class Regular {

    @SerializedName("delNum")
    private String delNum = "";

    @SerializedName("addNum")
    private String addNum = "";

    @SerializedName("mdfNum")
    private String mdfNum = "";

    public String getAddNum() {
        return this.addNum;
    }

    public String getDelNum() {
        return this.delNum;
    }

    public String getMdfNum() {
        return this.mdfNum;
    }

    public void setAddNum(String str) {
        this.addNum = str;
    }

    public void setDelNum(String str) {
        this.delNum = str;
    }

    public void setMdfNum(String str) {
        this.mdfNum = str;
    }
}
