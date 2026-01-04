package com.huawei.hwcloudjs.service.hms;

import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import iq.C10588b;
import iq.InterfaceC10596j;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.p */
/* loaded from: classes8.dex */
public class C6684p implements InterfaceC10596j<C10588b> {

    /* renamed from: a */
    final /* synthetic */ JsCallback f31002a;

    /* renamed from: b */
    final /* synthetic */ HmsLiteCoreApi f31003b;

    public C6684p(HmsLiteCoreApi hmsLiteCoreApi, JsCallback jsCallback) {
        this.f31003b = hmsLiteCoreApi;
        this.f31002a = jsCallback;
    }

    @Override // iq.InterfaceC10596j
    /* renamed from: a */
    public void onResult(C10588b c10588b) throws JSONException {
        if (c10588b == null) {
            this.f31002a.failure("signOut result is null");
            C6659d.m37881b("HmsLiteCoreApi", "signOut result is null", true);
        } else if (c10588b.m64965b()) {
            C6659d.m37882c("HmsLiteCoreApi", "signOut success", true);
            this.f31002a.success();
        } else {
            C6659d.m37881b("HmsLiteCoreApi", "signOut failed", true);
            this.f31002a.failure(c10588b.m64964a().m64995a(), c10588b.m64964a().m64996b());
        }
    }
}
