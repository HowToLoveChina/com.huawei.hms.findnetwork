package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.phoneservice.faqcommon.webapi.request.a */
/* loaded from: classes4.dex */
public class C8435a {

    /* renamed from: a */
    @SerializedName("countriesCode")
    private String f39390a;

    /* renamed from: b */
    @SerializedName(FaqConstants.FAQ_LANGUAGE)
    private String f39391b;

    /* renamed from: c */
    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private String f39392c;

    /* renamed from: d */
    @SerializedName("productCategoryCode")
    private String f39393d;

    /* renamed from: e */
    @SerializedName("brands")
    private String f39394e;

    /* renamed from: f */
    @SerializedName("secretType")
    private String f39395f;

    /* renamed from: g */
    @SerializedName("defaultCountryCode")
    private String f39396g;

    /* renamed from: h */
    @SerializedName("defaultLanguageCode")
    private String f39397h;

    /* renamed from: a */
    public void m52498a(String str) {
        this.f39392c = str;
    }

    /* renamed from: b */
    public void m52499b(String str) {
        this.f39390a = str;
    }

    /* renamed from: c */
    public void m52500c(String str) {
        this.f39396g = str;
    }

    /* renamed from: d */
    public void m52501d(String str) {
        this.f39397h = str;
    }

    /* renamed from: e */
    public void m52502e(String str) {
        this.f39391b = str;
    }

    /* renamed from: f */
    public void m52503f(String str) {
        this.f39393d = str;
    }

    public String toString() {
        return "Classification{co='" + this.f39390a + "', la='" + this.f39391b + "', pr='" + this.f39393d + "', deCo='" + this.f39396g + "', deLa='" + this.f39397h + "'}";
    }
}
