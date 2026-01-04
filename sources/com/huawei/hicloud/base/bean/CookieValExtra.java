package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class CookieValExtra {

    /* renamed from: e */
    @SerializedName("e")
    private long f22139e;

    /* renamed from: v */
    @SerializedName("v")
    private String f22140v;

    public CookieValExtra(String str, long j10) {
        this.f22140v = str;
        this.f22139e = j10;
    }

    public long getE() {
        return this.f22139e;
    }

    public String getV() {
        return this.f22140v;
    }

    public void setE(long j10) {
        this.f22139e = j10;
    }

    public void setV(String str) {
        this.f22140v = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
