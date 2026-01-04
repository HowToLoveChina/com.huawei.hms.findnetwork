package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.p169ad.p171db.bean.ContentResource;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import com.huawei.phoneservice.faq.base.util.FaqSdk;
import java.io.Serializable;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.c */
/* loaded from: classes5.dex */
public class C8615c implements Serializable {
    private static final long serialVersionUID = -2965823344242365762L;

    /* renamed from: a */
    @SerializedName("logType")
    private int f40095a;

    /* renamed from: b */
    @SerializedName(ContentResource.FILE_NAME)
    private String f40096b;

    /* renamed from: c */
    @SerializedName("fileSize")
    private long f40097c;

    /* renamed from: d */
    @SerializedName("encryptKey")
    private String f40098d;

    /* renamed from: e */
    @SerializedName("patchSize")
    private long f40099e;

    /* renamed from: f */
    @SerializedName("patchNum")
    private int f40100f;

    /* renamed from: i */
    @SerializedName("fileHashList")
    private List<C8618d0> f40103i;

    /* renamed from: k */
    @SerializedName(FaqConstants.FAQ_SHASN)
    private String f40105k;

    /* renamed from: p */
    @SerializedName("countryCode")
    private String f40110p;

    /* renamed from: j */
    @SerializedName("appID")
    private String f40104j = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_LOG_SERVER_APPID);

    /* renamed from: l */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f40106l = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_MODEL);

    /* renamed from: m */
    @SerializedName(FaqConstants.FAQ_ROMVERSION)
    private String f40107m = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_ROMVERSION);

    /* renamed from: n */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f40108n = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_EMUIVERSION);

    /* renamed from: o */
    @SerializedName(FaqConstants.FAQ_OSVERSION)
    private String f40109o = FaqSdk.getSdk().getSdk(FaqConstants.FAQ_OSVERSION);

    /* renamed from: g */
    @SerializedName("patchVer")
    private String f40101g = "0";

    /* renamed from: h */
    @SerializedName("others")
    private String f40102h = "test";

    public C8615c(String str, String str2) {
        this.f40105k = str;
        this.f40110p = str2;
    }

    /* renamed from: b */
    public void m53216b(int i10) {
        this.f40095a = i10;
    }

    /* renamed from: c */
    public void m53217c(long j10) {
        this.f40097c = j10;
    }

    /* renamed from: d */
    public void m53218d(String str) {
        this.f40098d = str;
    }

    /* renamed from: e */
    public void m53219e(List<C8618d0> list) {
        this.f40103i = list;
    }

    /* renamed from: f */
    public void m53220f(int i10) {
        this.f40100f = i10;
    }

    /* renamed from: g */
    public void m53221g(long j10) {
        this.f40099e = j10;
    }

    /* renamed from: h */
    public void m53222h(String str) {
        this.f40096b = str;
    }
}
