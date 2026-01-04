package com.huawei.hwcloudjs.service.hms;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hwcloudjs.core.JsCallback;
import java.lang.ref.WeakReference;

/* renamed from: com.huawei.hwcloudjs.service.hms.h */
/* loaded from: classes8.dex */
public class C6676h implements HuaweiApiClient.ConnectionCallbacks {

    /* renamed from: a */
    final /* synthetic */ WeakReference f30951a;

    /* renamed from: b */
    final /* synthetic */ JsCallback f30952b;

    /* renamed from: c */
    final /* synthetic */ WeakReference f30953c;

    /* renamed from: d */
    final /* synthetic */ boolean f30954d;

    /* renamed from: e */
    final /* synthetic */ boolean f30955e;

    /* renamed from: f */
    final /* synthetic */ HmsCoreApi f30956f;

    public C6676h(HmsCoreApi hmsCoreApi, WeakReference weakReference, JsCallback jsCallback, WeakReference weakReference2, boolean z10, boolean z11) {
        this.f30956f = hmsCoreApi;
        this.f30951a = weakReference;
        this.f30952b = jsCallback;
        this.f30953c = weakReference2;
        this.f30954d = z10;
        this.f30955e = z11;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks
    public void onConnected() {
        this.f30956f.m37932a(this.f30951a, this.f30952b, this.f30953c, this.f30954d, this.f30955e);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i10) {
    }
}
