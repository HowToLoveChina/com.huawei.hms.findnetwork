package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.x */
/* loaded from: classes5.dex */
public class C8638x {

    /* renamed from: a */
    @SerializedName("countryCode")
    private String f40219a;

    /* renamed from: b */
    @SerializedName(FaqConstants.FAQ_EMUI_LANGUAGE)
    private String f40220b;

    public C8638x(String str, String str2) {
        this.f40219a = str;
        this.f40220b = str2;
    }
}
