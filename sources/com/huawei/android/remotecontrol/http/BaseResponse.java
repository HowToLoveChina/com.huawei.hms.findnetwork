package com.huawei.android.remotecontrol.http;

/* loaded from: classes4.dex */
public class BaseResponse {
    protected int resultCode;
    protected String resultDesc;

    public BaseResponse(int i10, String str) {
        this.resultCode = i10;
        this.resultDesc = str;
    }

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
}
