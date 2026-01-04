package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.b0 */
/* loaded from: classes5.dex */
public class C8614b0 {

    /* renamed from: a */
    @SerializedName("problemSourceCode")
    private String f40075a;

    /* renamed from: b */
    @SerializedName("countryCode")
    private String f40076b;

    /* renamed from: c */
    @SerializedName(FaqConstants.FAQ_LANGUAGE)
    private String f40077c;

    /* renamed from: d */
    @SerializedName("emuiLanguageCode")
    private String f40078d;

    /* renamed from: e */
    @SerializedName("problemCatalogCode")
    private String f40079e;

    /* renamed from: f */
    @SerializedName("problemDesc")
    private String f40080f;

    /* renamed from: g */
    @SerializedName("attachs")
    private List<String> f40081g;

    /* renamed from: h */
    @SerializedName("logPath")
    private String f40082h;

    /* renamed from: i */
    @SerializedName(HNConstants.DataType.CONTACT)
    private String f40083i;

    /* renamed from: j */
    @SerializedName("sn")
    private String f40084j;

    /* renamed from: k */
    @SerializedName(FaqConstants.FAQ_EMUIVERSION)
    private String f40085k;

    /* renamed from: l */
    @SerializedName("appVersion")
    private String f40086l;

    /* renamed from: m */
    @SerializedName(FaqConstants.FAQ_SOFT_VERSION)
    private String f40087m;

    /* renamed from: n */
    @SerializedName(FaqConstants.FAQ_MODEL)
    private String f40088n;

    /* renamed from: o */
    @SerializedName("accessToken")
    private String f40089o;

    /* renamed from: p */
    @SerializedName("parentProblemId")
    private String f40090p;

    /* renamed from: q */
    @SerializedName("srno")
    private String f40091q;

    /* renamed from: r */
    @SerializedName("uploadUrls")
    private List<FeedbackZipBean> f40092r;

    /* renamed from: s */
    @SerializedName("id")
    private Long f40093s;

    /* renamed from: t */
    @SerializedName("uniqueCode")
    private String f40094t;

    /* renamed from: a */
    public void m53196a(Long l10) {
        this.f40093s = l10;
    }

    /* renamed from: b */
    public void m53197b(String str) {
        this.f40089o = str;
    }

    /* renamed from: c */
    public void m53198c(List<String> list) {
        this.f40081g = list;
    }

    /* renamed from: d */
    public void m53199d(String str) {
        this.f40086l = str;
    }

    /* renamed from: e */
    public void m53200e(List<FeedbackZipBean> list) {
        this.f40092r = list;
    }

    /* renamed from: f */
    public void m53201f(String str) {
        this.f40083i = str;
    }

    /* renamed from: g */
    public void m53202g(String str) {
        this.f40076b = str;
    }

    /* renamed from: h */
    public void m53203h(String str) {
        this.f40078d = str;
    }

    /* renamed from: i */
    public void m53204i(String str) {
        this.f40085k = str;
    }

    /* renamed from: j */
    public void m53205j(String str) {
        this.f40077c = str;
    }

    /* renamed from: k */
    public void m53206k(String str) {
        this.f40082h = str;
    }

    /* renamed from: l */
    public void m53207l(String str) {
        this.f40088n = str;
    }

    /* renamed from: m */
    public void m53208m(String str) {
        this.f40090p = str;
    }

    /* renamed from: n */
    public void m53209n(String str) {
        this.f40079e = str;
    }

    /* renamed from: o */
    public void m53210o(String str) {
        this.f40080f = str;
    }

    /* renamed from: p */
    public void m53211p(String str) {
        this.f40075a = str;
    }

    /* renamed from: q */
    public void m53212q(String str) {
        this.f40084j = str;
    }

    /* renamed from: r */
    public void m53213r(String str) {
        this.f40087m = str;
    }

    /* renamed from: s */
    public void m53214s(String str) {
        this.f40091q = str;
    }

    /* renamed from: t */
    public void m53215t(String str) {
        this.f40094t = str;
    }
}
