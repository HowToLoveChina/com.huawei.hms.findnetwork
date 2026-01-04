package com.huawei.phoneservice.faqcommon.webapi.request;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.phoneservice.faqcommon.webapi.request.i */
/* loaded from: classes4.dex */
public class C8443i {

    /* renamed from: a */
    @SerializedName("country")
    private String f39414a;

    /* renamed from: b */
    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String f39415b;

    /* renamed from: c */
    @SerializedName("site")
    private String f39416c;

    /* renamed from: d */
    @SerializedName("qAppName")
    private String f39417d;

    /* renamed from: a */
    public void m52520a(String str) {
        this.f39414a = str;
    }

    /* renamed from: b */
    public void m52521b(String str) {
        this.f39415b = str;
    }

    /* renamed from: c */
    public void m52522c(String str) {
        this.f39417d = str;
    }
}
