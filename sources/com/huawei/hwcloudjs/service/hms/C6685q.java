package com.huawei.hwcloudjs.service.hms;

import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import iq.C10597k;
import iq.C10600n;
import iq.InterfaceC10596j;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.q */
/* loaded from: classes8.dex */
public class C6685q implements InterfaceC10596j<C10597k> {

    /* renamed from: a */
    final /* synthetic */ JsCallback f31004a;

    /* renamed from: b */
    final /* synthetic */ HmsLiteCoreApi f31005b;

    public C6685q(HmsLiteCoreApi hmsLiteCoreApi, JsCallback jsCallback) {
        this.f31005b = hmsLiteCoreApi;
        this.f31004a = jsCallback;
    }

    @Override // iq.InterfaceC10596j
    /* renamed from: a */
    public void onResult(C10597k c10597k) throws JSONException {
        C6659d.m37882c("HmsLiteCoreApi", "cancelAuthorization onResult begin", true);
        if (c10597k == null) {
            this.f31004a.failure("cancelAuthorization result is null");
            C6659d.m37881b("HmsLiteCoreApi", "result is null", true);
            return;
        }
        try {
            C10600n c10600nM64991a = c10597k.m64991a();
            int iM64995a = c10600nM64991a.m64995a();
            if (iM64995a == 200) {
                C6659d.m37882c("HmsLiteCoreApi", "cancelAuthorization success", true);
                this.f31004a.success();
            } else {
                C6659d.m37881b("HmsLiteCoreApi", "cancelAuthorization failed", true);
                this.f31004a.failure(iM64995a, c10600nM64991a.m64996b());
            }
        } catch (RuntimeException unused) {
            this.f31004a.failure("cancelAuthorization exception");
            C6659d.m37881b("HmsLiteCoreApi", "cancelAuthorization exception", true);
        }
    }
}
