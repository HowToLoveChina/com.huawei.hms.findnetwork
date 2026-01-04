package com.huawei.hwcloudjs.service.hms;

import com.huawei.hms.support.hwid.HuaweiIdAuthAPIManager;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import com.huawei.hwcloudjs.service.hms.C6668a;
import com.huawei.hwcloudjs.service.hms.HmsCoreApi;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.b */
/* loaded from: classes8.dex */
public class C6669b implements C6668a.c {

    /* renamed from: a */
    final /* synthetic */ HmsCoreApi.LoginReq f30935a;

    /* renamed from: b */
    final /* synthetic */ JsCallback f30936b;

    /* renamed from: c */
    final /* synthetic */ HmsCoreApi f30937c;

    public C6669b(HmsCoreApi hmsCoreApi, HmsCoreApi.LoginReq loginReq, JsCallback jsCallback) {
        this.f30937c = hmsCoreApi;
        this.f30935a = loginReq;
        this.f30936b = jsCallback;
    }

    @Override // com.huawei.hwcloudjs.service.hms.C6668a.c
    /* renamed from: a */
    public void mo37934a(C6668a.b bVar) throws JSONException {
        HuaweiIdAuthResult huaweiIdFromIntent = HuaweiIdAuthAPIManager.HuaweiIdAuthAPIService.parseHuaweiIdFromIntent(bVar.m37949a());
        if (huaweiIdFromIntent == null) {
            C6659d.m37881b("HmsCoreApi", "getSignInIntent failed, result is null", true);
            this.f30936b.failure("getSignInIntent failed, result is null");
            return;
        }
        C6659d.m37882c("HmsCoreApi", "getSignInIntent result is not null", true);
        if (!huaweiIdFromIntent.isSuccess()) {
            C6659d.m37881b("HmsCoreApi", "getSignInIntent failed, statusCode:" + huaweiIdFromIntent.getStatus().getStatusCode() + " msg:" + huaweiIdFromIntent.getStatus().getStatusMessage(), true);
            this.f30936b.failure(huaweiIdFromIntent.getStatus().getStatusCode(), huaweiIdFromIntent.getStatus().getStatusMessage());
            return;
        }
        AuthHuaweiId huaweiId = huaweiIdFromIntent.getHuaweiId();
        if (huaweiId != null) {
            C6659d.m37882c("HmsCoreApi", "getSignInIntent authHuaweiId is not null", true);
            this.f30937c.m37925a(huaweiId, this.f30935a.needAuthCode, this.f30936b);
            return;
        }
        C6659d.m37881b("HmsCoreApi", "getSignInIntent authHuaweiId is null", true);
        C6659d.m37881b("HmsCoreApi", "getSignInIntent statusCode:" + huaweiIdFromIntent.getStatus().getStatusCode() + " msg:" + huaweiIdFromIntent.getStatus().getStatusMessage(), true);
        this.f30936b.failure(1);
    }
}
