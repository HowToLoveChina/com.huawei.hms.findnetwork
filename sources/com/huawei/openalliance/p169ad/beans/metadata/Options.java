package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;

@DataKeep
/* loaded from: classes8.dex */
public class Options {
    private String adRating;
    private Integer coppa;
    private Integer tfua;

    /* renamed from: a */
    public Integer m40372a() {
        return this.coppa;
    }

    /* renamed from: b */
    public Integer m40375b() {
        return this.tfua;
    }

    /* renamed from: c */
    public String m40377c() {
        return this.adRating;
    }

    /* renamed from: d */
    public boolean m40378d() {
        return (this.coppa == null && this.tfua == null && this.adRating == null) ? false : true;
    }

    /* renamed from: a */
    public void m40373a(Integer num) {
        this.coppa = num;
    }

    /* renamed from: b */
    public void m40376b(Integer num) {
        this.tfua = num;
    }

    /* renamed from: a */
    public void m40374a(String str) {
        this.adRating = str;
    }
}
