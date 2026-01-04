package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.e */
/* loaded from: classes5.dex */
public class C8619e {

    /* renamed from: a */
    @SerializedName("reason")
    private String f40117a;

    /* renamed from: b */
    @SerializedName("resCode")
    private int f40118b;

    /* renamed from: c */
    @SerializedName("fileUniqueFlag")
    private String f40119c;

    /* renamed from: d */
    @SerializedName("currentTime")
    private String f40120d;

    /* renamed from: e */
    @SerializedName("uploadInfoList")
    private List<C8611a> f40121e;

    /* renamed from: f */
    @SerializedName("policy")
    private String f40122f;

    /* renamed from: g */
    @SerializedName("patchPolicyList")
    private C8621g f40123g;

    /* renamed from: a */
    public String m53226a() {
        return this.f40119c;
    }

    /* renamed from: b */
    public C8621g m53227b() {
        return this.f40123g;
    }

    /* renamed from: c */
    public String m53228c() {
        return this.f40117a;
    }

    /* renamed from: d */
    public int m53229d() {
        return this.f40118b;
    }

    /* renamed from: e */
    public List<C8611a> m53230e() {
        return this.f40121e;
    }

    public String toString() {
        return "UploadInfoResponse{reason='" + this.f40117a + "', resCode=" + this.f40118b + ", fileUniqueFlag='" + this.f40119c + "', currentTime='" + this.f40120d + "', uploadInfoList=" + this.f40121e + ", policy='" + this.f40122f + "', patchPolicyList=" + this.f40123g + '}';
    }
}
