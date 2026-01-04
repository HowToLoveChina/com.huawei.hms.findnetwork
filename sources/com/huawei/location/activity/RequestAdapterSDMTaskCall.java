package com.huawei.location.activity;

import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.location.router.entity.IRouterResponse;
import es.C9542g;
import is.C10610g;

/* loaded from: classes8.dex */
public class RequestAdapterSDMTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RequestAdapterSDMAPI";

    @Override // com.huawei.location.router.BaseRouterTaskCallImpl, com.huawei.location.router.interfaces.IRouterRequest
    public IRouterResponse onExecute(String str) {
        BaseLocationReq baseLocationReq;
        C1016d.m6186f(TAG, "onExecute start");
        try {
            baseLocationReq = (BaseLocationReq) C9542g.m59588a().fromJson(str, BaseLocationReq.class);
        } catch (JsonSyntaxException unused) {
            C1016d.m6186f(TAG, "removeActivityIdentificationUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest RequestAdapterSDMTaskCall exception";
            baseLocationReq = null;
        }
        this.reportBuilder.m84225c("AR_requestAdapterSDM");
        C10610g c10610gM65039a = C10610g.m65039a();
        this.reportBuilder.m84224b(baseLocationReq);
        this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
        return c10610gM65039a;
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest start");
    }
}
