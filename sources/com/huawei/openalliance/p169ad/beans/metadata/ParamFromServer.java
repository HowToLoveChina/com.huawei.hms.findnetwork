package com.huawei.openalliance.p169ad.beans.metadata;

import com.huawei.openalliance.p169ad.annotations.DataKeep;
import com.huawei.openalliance.p169ad.annotations.InterfaceC6929a;
import com.huawei.openalliance.p169ad.beans.base.RspBean;

@DataKeep
/* loaded from: classes8.dex */
public class ParamFromServer extends RspBean {

    /* renamed from: a */
    @InterfaceC6929a
    private String f32012a;

    @InterfaceC6929a
    private String sig;

    /* renamed from: t */
    @InterfaceC6929a
    private String f32013t;

    /* renamed from: a */
    public String m40379a() {
        return this.f32012a;
    }

    /* renamed from: b */
    public String m40381b() {
        return this.sig;
    }

    /* renamed from: c */
    public void m40383c(String str) {
        this.sig = str;
    }

    /* renamed from: a */
    public void m40380a(String str) {
        this.f32013t = str;
    }

    /* renamed from: b */
    public void m40382b(String str) {
        this.f32012a = str;
    }
}
