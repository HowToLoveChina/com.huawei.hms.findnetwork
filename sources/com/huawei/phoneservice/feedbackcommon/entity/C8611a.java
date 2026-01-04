package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.a */
/* loaded from: classes5.dex */
public class C8611a {

    /* renamed from: a */
    @SerializedName("uploadUrl")
    private String f40068a;

    /* renamed from: b */
    @SerializedName("method")
    private String f40069b;

    /* renamed from: c */
    @SerializedName("headers")
    private Map<String, String> f40070c;

    /* renamed from: d */
    @SerializedName("objectId")
    private String f40071d;

    /* renamed from: a */
    public Map<String, String> m53190a() {
        return this.f40070c;
    }

    /* renamed from: b */
    public String m53191b() {
        return this.f40069b;
    }

    /* renamed from: c */
    public String m53192c() {
        return this.f40068a;
    }

    public String toString() {
        return "UploadInfoList{uploadUrl='" + this.f40068a + "', method='" + this.f40069b + "', headers=" + this.f40070c + ", objectId='" + this.f40071d + "'}";
    }
}
