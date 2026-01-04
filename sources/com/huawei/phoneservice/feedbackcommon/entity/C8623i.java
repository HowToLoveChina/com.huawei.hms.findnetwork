package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import java.io.Serializable;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.i */
/* loaded from: classes5.dex */
public class C8623i implements Serializable {
    private static final long serialVersionUID = 7368877497797411927L;

    /* renamed from: a */
    @SerializedName("fileUniqueFlag")
    private String f40135a;

    /* renamed from: c */
    @SerializedName("appID")
    private String f40137c = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);

    /* renamed from: d */
    @SerializedName(FaqConstants.FAQ_SHASN)
    private String f40138d = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN);

    /* renamed from: e */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f40139e = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL);

    /* renamed from: f */
    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String f40140f = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION);

    /* renamed from: g */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f40141g = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION);

    /* renamed from: h */
    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String f40142h = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION);

    /* renamed from: i */
    @SerializedName("countryCode")
    private String f40143i = FaqSdk.getSdk().getSdk("country");

    /* renamed from: b */
    @SerializedName("patchVer")
    private String f40136b = "0";

    /* renamed from: b */
    public void m53232b(String str) {
        this.f40135a = str;
    }
}
