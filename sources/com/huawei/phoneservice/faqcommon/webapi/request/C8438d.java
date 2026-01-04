package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.phoneservice.faqcommon.webapi.request.d */
/* loaded from: classes4.dex */
public class C8438d {

    /* renamed from: a */
    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private String f39402a;

    /* renamed from: b */
    @SerializedName("countryCode")
    private String f39403b;

    /* renamed from: c */
    @SerializedName("description")
    private String f39404c;

    /* renamed from: d */
    @SerializedName("descriptionType")
    private String f39405d;

    /* renamed from: e */
    @SerializedName("knowledgeId")
    private String f39406e;

    /* renamed from: a */
    public void m52508a(String str) {
        this.f39402a = str;
    }

    /* renamed from: b */
    public void m52509b(String str) {
        this.f39403b = str;
    }

    /* renamed from: c */
    public void m52510c(String str) {
        this.f39404c = str;
    }

    /* renamed from: d */
    public void m52511d(String str) {
        this.f39405d = str;
    }

    /* renamed from: e */
    public void m52512e(String str) {
        this.f39406e = str;
    }
}
