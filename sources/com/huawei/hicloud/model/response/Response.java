package com.huawei.hicloud.model.response;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class Response {
    private int resultCode;
    private String resultDesc;

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultCode(int i10) {
        this.resultCode = i10;
    }

    public void setResultDesc(String str) {
        this.resultDesc = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
