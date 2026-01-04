package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class CookieVal {

    /* renamed from: e */
    @SerializedName("e")
    private long f22136e;

    /* renamed from: k */
    @SerializedName("k")
    private String f22137k;

    /* renamed from: v */
    @SerializedName("v")
    private String f22138v;

    public long getE() {
        return this.f22136e;
    }

    public String getK() {
        return this.f22137k;
    }

    public String getV() {
        return this.f22138v;
    }

    public void setE(long j10) {
        this.f22136e = j10;
    }

    public void setK(String str) {
        this.f22137k = str;
    }

    public void setV(String str) {
        this.f22138v = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
