package com.huawei.hms.identity.entity;

import com.huawei.hms.support.api.client.Result;

/* loaded from: classes8.dex */
public class GetUserAddressResult extends Result {

    /* renamed from: a */
    private int f25458a;

    /* renamed from: b */
    private String f25459b;

    /* renamed from: a */
    public void m33030a(int i10) {
        this.f25458a = i10;
    }

    public int getReturnCode() {
        return this.f25458a;
    }

    public String getReturnDesc() {
        return this.f25459b;
    }

    /* renamed from: a */
    public void m33031a(String str) {
        this.f25459b = str;
    }
}
