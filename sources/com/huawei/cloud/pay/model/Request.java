package com.huawei.cloud.pay.model;

import com.google.gson.Gson;

/* loaded from: classes5.dex */
public class Request {
    private String cmd;

    public Request(String str) {
        this.cmd = str;
    }

    public String getCmd() {
        return this.cmd;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
