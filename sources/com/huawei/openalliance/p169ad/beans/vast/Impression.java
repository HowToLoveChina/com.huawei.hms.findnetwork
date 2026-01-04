package com.huawei.openalliance.p169ad.beans.vast;

import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.utils.AbstractC7806cz;

/* loaded from: classes8.dex */
public class Impression {

    /* renamed from: id */
    private String f32019id;

    @InterfaceC6929a
    private String url;

    public Impression(String str, String str2) {
        this.f32019id = str;
        this.url = str2;
    }

    /* renamed from: a */
    public String m40977a() {
        return this.url;
    }

    public String toString() {
        return "Impression{id='" + this.f32019id + "', url='" + AbstractC7806cz.m48174f(this.url) + "'}";
    }
}
