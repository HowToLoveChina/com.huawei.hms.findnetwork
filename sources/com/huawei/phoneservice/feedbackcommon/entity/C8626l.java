package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.l */
/* loaded from: classes5.dex */
public class C8626l implements Serializable {
    private static final long serialVersionUID = -8764490769713094093L;

    /* renamed from: a */
    @SerializedName("responseCode")
    private String f40156a;

    /* renamed from: b */
    @SerializedName("responseDesc")
    private String f40157b;

    /* renamed from: c */
    @SerializedName("responseData")
    private C8636v f40158c;

    /* renamed from: b */
    public String m53237b() {
        return this.f40156a;
    }

    /* renamed from: c */
    public C8636v m53238c() {
        return this.f40158c;
    }

    /* renamed from: d */
    public String m53239d() {
        return this.f40157b;
    }
}
