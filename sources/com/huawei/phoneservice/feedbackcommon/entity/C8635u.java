package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqSdk;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.u */
/* loaded from: classes5.dex */
public class C8635u {

    /* renamed from: a */
    @SerializedName("fileUniqueFlag")
    private String f40207a;

    /* renamed from: b */
    @SerializedName("uploadTime")
    private String f40208b;

    /* renamed from: d */
    @SerializedName(FaqConstants.FAQ_SHASN)
    private String f40210d;

    /* renamed from: h */
    @SerializedName("countryCode")
    private String f40214h;

    /* renamed from: c */
    @SerializedName("appID")
    private String f40209c = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);

    /* renamed from: f */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f40212f = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL);

    /* renamed from: e */
    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String f40211e = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION);

    /* renamed from: g */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f40213g = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION);

    /* renamed from: i */
    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String f40215i = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION);

    public C8635u(String str, String str2) {
        this.f40210d = str;
        this.f40214h = str2;
    }

    /* renamed from: a */
    public void m53263a(String str) {
        this.f40207a = str;
    }

    /* renamed from: b */
    public void m53264b(String str) {
        this.f40208b = str;
    }
}
