package com.huawei.hwcloudjs.service.hms;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import org.json.JSONException;
import p208cq.InterfaceC8937e;

/* renamed from: com.huawei.hwcloudjs.service.hms.d */
/* loaded from: classes8.dex */
public class C6672d implements InterfaceC8937e<Void> {

    /* renamed from: a */
    final /* synthetic */ JsCallback f30943a;

    /* renamed from: b */
    final /* synthetic */ HmsCoreApi f30944b;

    public C6672d(HmsCoreApi hmsCoreApi, JsCallback jsCallback) {
        this.f30944b = hmsCoreApi;
        this.f30943a = jsCallback;
    }

    @Override // p208cq.InterfaceC8937e
    public void onComplete(Task<Void> task) throws JSONException {
        String str;
        if (task != null) {
            C6659d.m37882c("HmsCoreApi", "cancelAuthorization task is not null", true);
            if (task.isSuccessful()) {
                C6659d.m37882c("HmsCoreApi", "cancelAuthorization successed", true);
                this.f30943a.success();
                return;
            }
            Exception exception = task.getException();
            if (exception != null && (exception instanceof ApiException)) {
                ApiException apiException = (ApiException) task.getException();
                C6659d.m37881b("HmsCoreApi", "cancelAuthorization failed, statusCode:" + apiException.getStatusCode() + " msg:" + apiException.getStatusMessage(), true);
                this.f30943a.failure(apiException.getStatusCode(), apiException.getStatusMessage());
                return;
            }
            str = "cancelAuthorization getException failed";
        } else {
            str = "cancelAuthorization failed, task is null";
        }
        C6659d.m37881b("HmsCoreApi", str, true);
        this.f30943a.failure(str);
    }
}
