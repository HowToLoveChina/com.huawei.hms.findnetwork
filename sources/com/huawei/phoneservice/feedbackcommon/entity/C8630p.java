package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.p */
/* loaded from: classes5.dex */
public class C8630p {

    /* renamed from: a */
    @SerializedName("accessToken")
    private String f40179a;

    /* renamed from: b */
    @SerializedName("problemSourceCode")
    private String f40180b;

    /* renamed from: c */
    @SerializedName("problemId")
    private String f40181c;

    /* renamed from: d */
    @SerializedName("pageSize")
    private int f40182d;

    /* renamed from: e */
    @SerializedName("orderType")
    private int f40183e;

    public C8630p(String str, String str2, String str3) {
        this.f40179a = str;
        this.f40180b = str2;
        this.f40181c = str3;
    }

    /* renamed from: a */
    public void m53249a(int i10) {
        this.f40183e = i10;
    }

    /* renamed from: b */
    public void m53250b(int i10) {
        this.f40182d = i10;
    }
}
