package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.n */
/* loaded from: classes5.dex */
public class C8628n implements Serializable {
    private static final long serialVersionUID = -8115898618013300188L;

    /* renamed from: b */
    @SerializedName(ContentResource.FILE_NAME)
    private String f40162b;

    /* renamed from: c */
    @SerializedName("fileSize")
    private long f40163c;

    /* renamed from: d */
    @SerializedName("patchSize")
    private long f40164d;

    /* renamed from: e */
    @SerializedName("patchNum")
    private int f40165e;

    /* renamed from: g */
    @SerializedName("fileHashList")
    private List<C8618d0> f40167g;

    /* renamed from: h */
    @SerializedName("appID")
    private String f40168h = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);

    /* renamed from: i */
    @SerializedName(FaqConstants.FAQ_SHASN)
    private String f40169i = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_SHASN);

    /* renamed from: k */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f40171k = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL);

    /* renamed from: l */
    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String f40172l = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION);

    /* renamed from: j */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f40170j = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION);

    /* renamed from: m */
    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String f40173m = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION);

    /* renamed from: n */
    @SerializedName("countryCode")
    private String f40174n = FaqSdk.getSdk().getSdk("country");

    /* renamed from: f */
    @SerializedName("patchVer")
    private String f40166f = "0";

    /* renamed from: a */
    @SerializedName("logType")
    private int f40161a = 0;

    /* renamed from: o */
    @SerializedName("others")
    private String f40175o = "test";

    /* renamed from: b */
    public void m53242b(int i10) {
        this.f40165e = i10;
    }

    /* renamed from: c */
    public void m53243c(long j10) {
        this.f40163c = j10;
    }

    /* renamed from: d */
    public void m53244d(String str) {
        this.f40162b = str;
    }

    /* renamed from: e */
    public void m53245e(List<C8618d0> list) {
        this.f40167g = list;
    }

    /* renamed from: f */
    public void m53246f(long j10) {
        this.f40164d = j10;
    }
}
