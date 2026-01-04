package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.phoneservice.faqcommon.webapi.request.j */
/* loaded from: classes4.dex */
public class C8444j {

    /* renamed from: a */
    @SerializedName("q")
    private String f39418a;

    /* renamed from: b */
    @SerializedName("country")
    private String f39419b;

    /* renamed from: c */
    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String f39420c;

    /* renamed from: d */
    @SerializedName("site")
    private String f39421d;

    /* renamed from: e */
    @SerializedName("qAppName")
    private String f39422e;

    /* renamed from: a */
    public void m52523a(String str) {
        this.f39419b = str;
    }

    /* renamed from: b */
    public void m52524b(String str) {
        this.f39420c = str;
    }

    /* renamed from: c */
    public void m52525c(String str) {
        this.f39418a = str;
    }

    /* renamed from: d */
    public void m52526d(String str) {
        this.f39422e = str;
    }
}
