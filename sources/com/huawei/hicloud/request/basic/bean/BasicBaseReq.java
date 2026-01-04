package com.huawei.hicloud.request.basic.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class BasicBaseReq {
    protected String info;
    private boolean isRefurbish;

    public BasicBaseReq(String str) {
        this.info = str;
    }

    public String getInfo() {
        return this.info;
    }

    public boolean isRefurbish() {
        return this.isRefurbish;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setRefurbish(boolean z10) {
        this.isRefurbish = z10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
