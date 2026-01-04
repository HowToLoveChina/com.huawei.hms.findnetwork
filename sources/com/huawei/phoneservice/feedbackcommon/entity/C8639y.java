package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Serializable;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.y */
/* loaded from: classes5.dex */
public class C8639y implements Serializable {
    private static final long serialVersionUID = -4589818087876763047L;

    /* renamed from: a */
    @SerializedName("problemSourceCode")
    private String f40221a;

    /* renamed from: b */
    @SerializedName("countryCode")
    private String f40222b;

    /* renamed from: c */
    @SerializedName(FaqConstants.FAQ_LANGUAGE)
    private String f40223c;

    /* renamed from: d */
    @SerializedName("emuiLanguageCode")
    private String f40224d;

    public C8639y(String str, String str2, String str3, String str4) {
        this.f40221a = str;
        this.f40222b = str2;
        this.f40223c = str3;
        this.f40224d = str4;
    }
}
