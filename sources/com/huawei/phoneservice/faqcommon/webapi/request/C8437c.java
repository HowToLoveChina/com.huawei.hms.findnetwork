package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.phoneservice.faqcommon.webapi.request.c */
/* loaded from: classes4.dex */
public class C8437c {

    /* renamed from: a */
    @SerializedName("knowledgeId")
    private String f39399a;

    /* renamed from: b */
    @SerializedName("score")
    private String f39400b;

    /* renamed from: c */
    @SerializedName(FaqConstants.FAQ_CHANNEL)
    private String f39401c;

    /* renamed from: a */
    public void m52505a(String str) {
        this.f39401c = str;
    }

    /* renamed from: b */
    public void m52506b(String str) {
        this.f39399a = str;
    }

    /* renamed from: c */
    public void m52507c(String str) {
        this.f39400b = str;
    }
}
