package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import java.io.Serializable;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.k */
/* loaded from: classes5.dex */
public class C8625k implements Serializable {
    private static final long serialVersionUID = -3641436311375093508L;

    /* renamed from: a */
    @SerializedName("fileUniqueFlag")
    private String f40147a;

    /* renamed from: b */
    @SerializedName("uploadTime")
    private String f40148b;

    /* renamed from: c */
    @SerializedName("appID")
    private String f40149c = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);

    /* renamed from: d */
    @SerializedName(FaqConstants.FAQ_SHASN)
    private String f40150d = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN);

    /* renamed from: f */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f40152f = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL);

    /* renamed from: e */
    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String f40151e = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION);

    /* renamed from: g */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f40153g = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION);

    /* renamed from: h */
    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String f40154h = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION);

    /* renamed from: i */
    @SerializedName("countryCode")
    private String f40155i = FaqSdk.getSdk().getSdk("country");

    /* renamed from: b */
    public void m53235b(String str) {
        this.f40147a = str;
    }

    /* renamed from: c */
    public void m53236c(String str) {
        this.f40148b = str;
    }
}
