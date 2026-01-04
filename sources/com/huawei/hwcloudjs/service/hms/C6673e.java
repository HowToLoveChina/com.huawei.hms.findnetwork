package com.huawei.hwcloudjs.service.hms;

import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.e */
/* loaded from: classes8.dex */
public class C6673e implements ResultCallback<Status> {

    /* renamed from: a */
    final /* synthetic */ JsCallback f30945a;

    /* renamed from: b */
    final /* synthetic */ HmsCoreApi f30946b;

    public C6673e(HmsCoreApi hmsCoreApi, JsCallback jsCallback) {
        this.f30946b = hmsCoreApi;
        this.f30945a = jsCallback;
    }

    @Override // com.huawei.hms.support.api.client.ResultCallback
    /* renamed from: a */
    public void onResult(Status status) throws JSONException {
        if (status == null) {
            C6659d.m37881b("HmsCoreApi", "cancelAuthorization failed, status is null", true);
            this.f30945a.failure("cancelAuthorization failed, status is null");
            return;
        }
        C6659d.m37882c("HmsCoreApi", "cancelAuthorization status is not null", true);
        if (status.isSuccess()) {
            C6659d.m37882c("HmsCoreApi", "cancelAuthorization successed", true);
            this.f30945a.success();
            return;
        }
        C6659d.m37881b("HmsCoreApi", "cancelAuthorization failed, statusCode:" + status.getStatusCode() + " msg:" + status.getStatusMessage(), true);
        this.f30945a.failure(status.getStatusCode(), status.getStatusMessage());
    }
}
