package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes6.dex */
public class HwCookie {

    @SerializedName("domain")
    private String domain;

    /* renamed from: ts */
    @SerializedName("ts")
    private Long f22141ts;

    @SerializedName("vals")
    private List<CookieVal> vals;

    public String getDomain() {
        return this.domain;
    }

    public Long getTs() {
        return this.f22141ts;
    }

    public List<CookieVal> getVals() {
        return this.vals;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setTs(long j10) {
        this.f22141ts = Long.valueOf(j10);
    }

    public void setVals(List<CookieVal> list) {
        this.vals = list;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
