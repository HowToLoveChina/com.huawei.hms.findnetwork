package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.phoneservice.faqcommon.webapi.request.h */
/* loaded from: classes4.dex */
public class C8442h {

    /* renamed from: a */
    @SerializedName("knowledgeId")
    private String f39411a;

    /* renamed from: b */
    @SerializedName("userAccount")
    private String f39412b;

    /* renamed from: c */
    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private String f39413c;

    /* renamed from: a */
    public void m52517a(String str) {
        this.f39413c = str;
    }

    /* renamed from: b */
    public void m52518b(String str) {
        this.f39411a = str;
    }

    /* renamed from: c */
    public void m52519c(String str) {
        this.f39412b = str;
    }
}
