package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.g */
/* loaded from: classes5.dex */
public class C8621g {

    /* renamed from: a */
    @SerializedName("patchVer")
    private String f40131a;

    /* renamed from: b */
    @SerializedName("patchNum")
    private String f40132b;

    /* renamed from: c */
    @SerializedName("patchSize")
    private String f40133c;

    /* renamed from: a */
    public String m53231a() {
        return this.f40132b;
    }

    public String toString() {
        return "UploadPatchPolicyList{patchVer='" + this.f40131a + "', patchNum='" + this.f40132b + "', patchSize='" + this.f40133c + "'}";
    }
}
