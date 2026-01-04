package com.huawei.hicloud.request.agreement.request;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class BaseRsp {
    private int errorCode = 39999;
    private String errorMessage;

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
