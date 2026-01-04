package com.huawei.android.hicloud.datamigration.bean;

import com.google.gson.Gson;

/* loaded from: classes3.dex */
public class CutBaseReq {
    protected String cmd;

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
