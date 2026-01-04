package com.huawei.phoneservice.feedbackcommon.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.huawei.phoneservice.feedbackcommon.entity.b */
/* loaded from: classes5.dex */
public class C8613b {

    /* renamed from: a */
    @SerializedName("appId")
    private String f40072a;

    /* renamed from: b */
    @SerializedName("accessToken")
    private String f40073b;

    /* renamed from: c */
    @SerializedName("problemIdList")
    private List<String> f40074c;

    /* renamed from: a */
    public void m53193a(String str) {
        this.f40073b = str;
    }

    /* renamed from: b */
    public void m53194b(List<String> list) {
        this.f40074c = list;
    }

    /* renamed from: c */
    public void m53195c(String str) {
        this.f40072a = str;
    }
}
