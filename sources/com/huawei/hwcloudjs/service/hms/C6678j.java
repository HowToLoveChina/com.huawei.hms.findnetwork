package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.service.hms.C6668a;
import java.lang.ref.WeakReference;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.j */
/* loaded from: classes8.dex */
public class C6678j implements C6668a.c {

    /* renamed from: a */
    final /* synthetic */ WeakReference f30963a;

    /* renamed from: b */
    final /* synthetic */ JsCallback f30964b;

    /* renamed from: c */
    final /* synthetic */ WeakReference f30965c;

    /* renamed from: d */
    final /* synthetic */ boolean f30966d;

    /* renamed from: e */
    final /* synthetic */ boolean f30967e;

    /* renamed from: f */
    final /* synthetic */ HmsCoreApi f30968f;

    public C6678j(HmsCoreApi hmsCoreApi, WeakReference weakReference, JsCallback jsCallback, WeakReference weakReference2, boolean z10, boolean z11) {
        this.f30968f = hmsCoreApi;
        this.f30963a = weakReference;
        this.f30964b = jsCallback;
        this.f30965c = weakReference2;
        this.f30966d = z10;
        this.f30967e = z11;
    }

    @Override // com.huawei.hwcloudjs.service.hms.C6668a.c
    /* renamed from: a */
    public void mo37934a(C6668a.b bVar) throws JSONException {
        HmsCoreApi hmsCoreApi = this.f30968f;
        WeakReference weakReference = this.f30963a;
        hmsCoreApi.m37931a(bVar, (WeakReference<HuaweiApiClient>) weakReference, this.f30964b, (WeakReference<Activity>) this.f30965c, this.f30966d, this.f30967e);
    }
}
