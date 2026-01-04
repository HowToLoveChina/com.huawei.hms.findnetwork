package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqSdk;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.s */
/* loaded from: classes5.dex */
public class C8633s {

    /* renamed from: a */
    @SerializedName("fileUniqueFlag")
    private String f40191a;

    /* renamed from: d */
    @SerializedName(FaqConstants.FAQ_SHASN)
    private String f40194d;

    /* renamed from: i */
    @SerializedName("countryCode")
    private String f40199i;

    /* renamed from: c */
    @SerializedName("appID")
    private String f40193c = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);

    /* renamed from: f */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f40196f = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL);

    /* renamed from: g */
    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String f40197g = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION);

    /* renamed from: h */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f40198h = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION);

    /* renamed from: e */
    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String f40195e = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION);

    /* renamed from: b */
    @SerializedName("patchVer")
    private String f40192b = "0";

    public C8633s(String str, String str2) {
        this.f40194d = str;
        this.f40199i = str2;
    }

    /* renamed from: a */
    public void m53258a(String str) {
        this.f40191a = str;
    }
}
