package com.huawei.hwcloudjs.service.hms;

import android.app.Activity;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.hwid.SignInResult;
import com.huawei.hwcloudjs.core.JsCallback;
import java.lang.ref.WeakReference;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.i */
/* loaded from: classes8.dex */
public class C6677i implements ResultCallback<SignInResult> {

    /* renamed from: a */
    final /* synthetic */ boolean f30957a;

    /* renamed from: b */
    final /* synthetic */ WeakReference f30958b;

    /* renamed from: c */
    final /* synthetic */ WeakReference f30959c;

    /* renamed from: d */
    final /* synthetic */ boolean f30960d;

    /* renamed from: e */
    final /* synthetic */ JsCallback f30961e;

    /* renamed from: f */
    final /* synthetic */ HmsCoreApi f30962f;

    public C6677i(HmsCoreApi hmsCoreApi, boolean z10, WeakReference weakReference, WeakReference weakReference2, boolean z11, JsCallback jsCallback) {
        this.f30962f = hmsCoreApi;
        this.f30957a = z10;
        this.f30958b = weakReference;
        this.f30959c = weakReference2;
        this.f30960d = z11;
        this.f30961e = jsCallback;
    }

    @Override // com.huawei.hms.support.api.client.ResultCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResult(SignInResult signInResult) throws JSONException {
        this.f30962f.m37923a(signInResult, this.f30957a, (WeakReference<Activity>) this.f30958b, (WeakReference<HuaweiApiClient>) this.f30959c, this.f30960d, this.f30961e);
    }
}
