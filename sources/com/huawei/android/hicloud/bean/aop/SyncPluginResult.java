package com.huawei.android.hicloud.bean.aop;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class SyncPluginResult {

    @SerializedName("result")
    private Object result;

    @SerializedName("status")
    private int status;

    public Object getResult() {
        return this.result;
    }

    public int getStatus() {
        return this.status;
    }

    public void setResult(Object obj) {
        this.result = obj;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
