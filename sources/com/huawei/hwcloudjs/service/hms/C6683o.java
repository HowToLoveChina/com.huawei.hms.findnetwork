package com.huawei.hwcloudjs.service.hms;

import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import iq.C10598l;
import iq.InterfaceC10596j;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.o */
/* loaded from: classes8.dex */
public class C6683o implements InterfaceC10596j<C10598l> {

    /* renamed from: a */
    final /* synthetic */ JsCallback f31000a;

    /* renamed from: b */
    final /* synthetic */ HmsLiteCoreApi f31001b;

    public C6683o(HmsLiteCoreApi hmsLiteCoreApi, JsCallback jsCallback) {
        this.f31001b = hmsLiteCoreApi;
        this.f31000a = jsCallback;
    }

    @Override // iq.InterfaceC10596j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResult(C10598l c10598l) throws JSONException {
        C6659d.m37882c("HmsLiteCoreApi", "signInOauth onResult", true);
        this.f31001b.m37941a(c10598l, this.f31000a);
    }
}
