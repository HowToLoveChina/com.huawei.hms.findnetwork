package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.o */
/* loaded from: classes5.dex */
public class C8629o implements Serializable {
    private static final long serialVersionUID = -8764490769713094093L;

    /* renamed from: a */
    @SerializedName("responseCode")
    private String f40176a;

    /* renamed from: b */
    @SerializedName("responseDesc")
    private String f40177b;

    /* renamed from: c */
    @SerializedName("responseData")
    private C8619e f40178c;

    /* renamed from: b */
    public String m53247b() {
        return this.f40176a;
    }

    /* renamed from: c */
    public C8619e m53248c() {
        return this.f40178c;
    }
}
