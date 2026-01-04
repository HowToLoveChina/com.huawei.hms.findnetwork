package com.huawei.hicloud.request.notify.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class NotifyBaseReq {
    protected String info;

    public NotifyBaseReq(String str) {
        this.info = str;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
