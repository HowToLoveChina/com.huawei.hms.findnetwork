package com.huawei.hwcloudjs.service.hms;

import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.service.hms.HmsCoreApi;
import p208cq.InterfaceC8937e;

/* renamed from: com.huawei.hwcloudjs.service.hms.c */
/* loaded from: classes8.dex */
public class C6671c implements InterfaceC8937e<AuthHuaweiId> {

    /* renamed from: a */
    final /* synthetic */ HmsCoreApi.LoginReq f30940a;

    /* renamed from: b */
    final /* synthetic */ JsCallback f30941b;

    /* renamed from: c */
    final /* synthetic */ HmsCoreApi f30942c;

    public C6671c(HmsCoreApi hmsCoreApi, HmsCoreApi.LoginReq loginReq, JsCallback jsCallback) {
        this.f30942c = hmsCoreApi;
        this.f30940a = loginReq;
        this.f30941b = jsCallback;
    }

    @Override // p208cq.InterfaceC8937e
    public void onComplete(Task<AuthHuaweiId> task) throws Throwable {
        try {
            this.f30942c.m37925a(task.getResultThrowException(ApiException.class), this.f30940a.needAuthCode, this.f30941b);
        } catch (ApiException e10) {
            this.f30942c.m37922a(e10, this.f30941b);
        }
    }
}
