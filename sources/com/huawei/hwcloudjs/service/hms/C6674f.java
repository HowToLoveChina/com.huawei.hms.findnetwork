package com.huawei.hwcloudjs.service.hms;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.p164f.C6659d;
import org.json.JSONException;
import p208cq.InterfaceC8937e;

/* renamed from: com.huawei.hwcloudjs.service.hms.f */
/* loaded from: classes8.dex */
public class C6674f implements InterfaceC8937e<Void> {

    /* renamed from: a */
    final /* synthetic */ JsCallback f30947a;

    /* renamed from: b */
    final /* synthetic */ HmsCoreApi f30948b;

    public C6674f(HmsCoreApi hmsCoreApi, JsCallback jsCallback) {
        this.f30948b = hmsCoreApi;
        this.f30947a = jsCallback;
    }

    @Override // p208cq.InterfaceC8937e
    public void onComplete(Task<Void> task) throws JSONException {
        String str;
        if (task != null) {
            C6659d.m37882c("HmsCoreApi", "signOut task is not null", true);
            if (task.isSuccessful()) {
                C6659d.m37882c("HmsCoreApi", "signOut successed", true);
                this.f30947a.success();
                return;
            }
            Exception exception = task.getException();
            if (exception != null && (exception instanceof ApiException)) {
                ApiException apiException = (ApiException) exception;
                C6659d.m37881b("HmsCoreApi", "signOut failed, statusCode:" + apiException.getStatusCode() + " msg:" + apiException.getStatusMessage(), true);
                this.f30947a.failure(apiException.getStatusCode(), apiException.getStatusMessage());
                return;
            }
            str = "signOut getException failed";
        } else {
            str = "signOut failed, task is null";
        }
        C6659d.m37881b("HmsCoreApi", str, true);
        this.f30947a.failure(str);
    }
}
