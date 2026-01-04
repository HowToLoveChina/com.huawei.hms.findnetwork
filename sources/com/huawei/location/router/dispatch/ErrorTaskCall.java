package com.huawei.location.router.dispatch;

import as.C1016d;
import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import p622rr.C12620c;

/* loaded from: classes8.dex */
class ErrorTaskCall extends BaseRouterTaskCallImpl {
    public void onComplete(int i10) {
        onComplete(i10, C12620c.m76137a(i10));
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
    }

    public void onComplete(int i10, String str) {
        C1016d.m6183c("ErrorRequestApi", "handlerNoApiTask");
        onComplete(new RouterResponse("", new StatusInfo(0, i10, str)));
    }
}
