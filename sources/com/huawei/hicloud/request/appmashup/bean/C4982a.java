package com.huawei.hicloud.request.appmashup.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* renamed from: com.huawei.hicloud.request.appmashup.bean.a */
/* loaded from: classes6.dex */
public class C4982a {

    /* renamed from: a */
    @SerializedName("cmd")
    private String f22798a;

    public C4982a(String str) {
        this.f22798a = str;
    }

    /* renamed from: a */
    public String m30011a() {
        return this.f22798a;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
