package com.huawei.hicloud.request.userk.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class EncryptBaseResp {
    public static final int RESULTCODE_AUTH_FAIL = 401;
    public static final int RESULTCODE_FAIL = 1;
    public static final int RESULTCODE_INTERNAL_ERROR = 503;
    public static final int RESULTCODE_INVAILD_PARAM = 2;
    public static final int RESULTCODE_SUCCESS = 0;
    private String info;
    private int result;
    private String version;

    public String getInfo() {
        return this.info;
    }

    public int getResult() {
        return this.result;
    }

    public String getVersion() {
        return this.version;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setResult(int i10) {
        this.result = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
