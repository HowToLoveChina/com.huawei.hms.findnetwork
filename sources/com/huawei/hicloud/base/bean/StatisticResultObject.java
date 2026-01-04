package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class StatisticResultObject {
    private int code;
    private String info;

    public int getCode() {
        return this.code;
    }

    public String getInfo() {
        return this.info;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
