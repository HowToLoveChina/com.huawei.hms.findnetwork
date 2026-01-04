package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.t */
/* loaded from: classes5.dex */
public class C8634t {

    /* renamed from: a */
    @SerializedName("reason")
    private String f40200a;

    /* renamed from: b */
    @SerializedName("resCode")
    private int f40201b;

    /* renamed from: c */
    @SerializedName("fileUniqueFlag")
    private String f40202c;

    /* renamed from: d */
    @SerializedName("currentTime")
    private String f40203d;

    /* renamed from: e */
    @SerializedName("uploadInfoList")
    private List<C8611a> f40204e;

    /* renamed from: f */
    @SerializedName("policy")
    private String f40205f;

    /* renamed from: g */
    @SerializedName("patchPolicyList")
    private C8621g f40206g;

    /* renamed from: a */
    public String m53259a() {
        return this.f40202c;
    }

    /* renamed from: b */
    public String m53260b() {
        return this.f40200a;
    }

    /* renamed from: c */
    public int m53261c() {
        return this.f40201b;
    }

    /* renamed from: d */
    public List<C8611a> m53262d() {
        return this.f40204e;
    }

    public String toString() {
        return "UploadInfoResponse{reason='" + this.f40200a + "', resCode=" + this.f40201b + ", fileUniqueFlag='" + this.f40202c + "', currentTime='" + this.f40203d + "', uploadInfoList=" + this.f40204e + ", policy='" + this.f40205f + "', patchPolicyList=" + this.f40206g + '}';
    }
}
