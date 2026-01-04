package com.huawei.hicloud.request.appmashup.bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.network.embedded.C5963j;

/* renamed from: com.huawei.hicloud.request.appmashup.bean.b */
/* loaded from: classes6.dex */
public class C4983b {

    /* renamed from: a */
    @SerializedName(C5963j.f27041j)
    private int f22799a;

    /* renamed from: b */
    @SerializedName(C5963j.f27042k)
    private String f22800b;

    /* renamed from: a */
    public int m30012a() {
        return this.f22799a;
    }

    /* renamed from: b */
    public String m30013b() {
        return this.f22800b;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
