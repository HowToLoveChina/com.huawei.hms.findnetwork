package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class PluginResult {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private Object message;

    public int getCode() {
        return this.code;
    }

    public Object getMessage() {
        return this.message;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setMessage(Object obj) {
        this.message = obj;
    }
}
