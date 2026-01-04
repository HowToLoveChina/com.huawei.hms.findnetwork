package com.huawei.hwcloudjs.service.hms.bean;

import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.service.hms.HmsLiteCoreApi;

/* renamed from: com.huawei.hwcloudjs.service.hms.bean.a */
/* loaded from: classes8.dex */
public class C6670a {

    /* renamed from: a */
    private HmsLiteCoreApi.LoginLiteReq f30938a;

    /* renamed from: b */
    private JsCallback f30939b;

    public C6670a(HmsLiteCoreApi.LoginLiteReq loginLiteReq, JsCallback jsCallback) {
        this.f30938a = loginLiteReq;
        this.f30939b = jsCallback;
    }

    /* renamed from: a */
    public JsCallback m37955a() {
        return this.f30939b;
    }

    /* renamed from: b */
    public HmsLiteCoreApi.LoginLiteReq m37958b() {
        return this.f30938a;
    }

    /* renamed from: a */
    public void m37956a(JsCallback jsCallback) {
        this.f30939b = jsCallback;
    }

    /* renamed from: a */
    public void m37957a(HmsLiteCoreApi.LoginLiteReq loginLiteReq) {
        this.f30938a = loginLiteReq;
    }
}
