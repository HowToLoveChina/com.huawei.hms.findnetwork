package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class BaseResponse {
    private String info;
    private int result;

    public String getInfo() {
        return this.info;
    }

    public int getResult() {
        return this.result;
    }

    public BaseResponse setInfo(String str) {
        this.info = str;
        return this;
    }

    public BaseResponse setResult(int i10) {
        this.result = i10;
        return this;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
