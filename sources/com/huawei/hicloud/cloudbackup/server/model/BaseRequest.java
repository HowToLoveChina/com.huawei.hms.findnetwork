package com.huawei.hicloud.cloudbackup.server.model;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class BaseRequest {
    private int cmd;
    private String info;

    public BaseRequest(int i10, String str) {
        this.cmd = i10;
        this.info = str;
    }

    public int getCmd() {
        return this.cmd;
    }

    public String getInfo() {
        return this.info;
    }

    public BaseRequest setCmd(int i10) {
        this.cmd = i10;
        return this;
    }

    public BaseRequest setInfo(String str) {
        this.info = str;
        return this;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
