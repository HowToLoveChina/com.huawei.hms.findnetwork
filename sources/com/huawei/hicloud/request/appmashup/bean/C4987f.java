package com.huawei.hicloud.request.appmashup.bean;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.huawei.hicloud.request.appmashup.bean.f */
/* loaded from: classes6.dex */
public class C4987f {

    /* renamed from: a */
    @SerializedName("key")
    private String f22808a;

    /* renamed from: b */
    @SerializedName("val")
    private String f22809b;

    /* renamed from: c */
    @SerializedName("ttl")
    private String f22810c;

    public C4987f(String str, String str2, String str3) {
        this.f22808a = str;
        this.f22809b = str2;
        this.f22810c = str3;
    }

    /* renamed from: a */
    public String m30025a() {
        return this.f22810c;
    }

    /* renamed from: b */
    public String m30026b() {
        return this.f22808a;
    }

    /* renamed from: c */
    public String m30027c() {
        return this.f22809b;
    }

    /* renamed from: d */
    public void m30028d(String str) {
        this.f22810c = str;
    }

    public String toString() {
        return "ParamsValue{key='" + this.f22808a + "', value='" + this.f22809b + "', expireTime='" + this.f22810c + "'}";
    }
}
