package com.huawei.openalliance.p169ad.beans.vast;

import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;

/* loaded from: classes8.dex */
public class Tracking {
    private String event;

    @InterfaceC6929a
    private String url;

    public Tracking(String str, String str2) {
        this.url = str;
        this.event = str2;
    }

    /* renamed from: a */
    public String m41006a() {
        return this.url;
    }
}
