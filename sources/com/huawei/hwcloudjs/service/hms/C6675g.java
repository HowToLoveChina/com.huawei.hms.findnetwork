package com.huawei.hwcloudjs.service.hms;

import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import org.json.JSONException;

/* renamed from: com.huawei.hwcloudjs.service.hms.g */
/* loaded from: classes8.dex */
public class C6675g implements ResultCallback<Status> {

    /* renamed from: a */
    final /* synthetic */ JsCallback f30949a;

    /* renamed from: b */
    final /* synthetic */ HmsCoreApi f30950b;

    public C6675g(HmsCoreApi hmsCoreApi, JsCallback jsCallback) {
        this.f30950b = hmsCoreApi;
        this.f30949a = jsCallback;
    }

    @Override // com.huawei.hms.support.api.client.ResultCallback
    /* renamed from: a */
    public void onResult(Status status) throws JSONException {
        if (status == null) {
            C6659d.m37881b("HmsCoreApi", "signOut failed, status is null", true);
            this.f30949a.failure("signOut failed, status is null");
            return;
        }
        C6659d.m37882c("HmsCoreApi", "signOut status is not null", true);
        if (status.isSuccess()) {
            C6659d.m37882c("HmsCoreApi", "signOut successed", true);
            this.f30949a.success();
            return;
        }
        C6659d.m37881b("HmsCoreApi", "signOut failed, statusCode:" + status.getStatusCode() + " msg:" + status.getStatusMessage(), true);
        this.f30949a.failure(status.getStatusCode(), status.getStatusMessage());
    }
}
