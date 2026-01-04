package com.huawei.hicloud.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class SyncFlowControlTime {

    @SerializedName("begin")
    private String begin;

    @SerializedName("end")
    private String end;

    public String getBegin() {
        return this.begin;
    }

    public String getEnd() {
        return this.end;
    }

    public void setBegin(String str) {
        this.begin = str;
    }

    public void setEnd(String str) {
        this.end = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
