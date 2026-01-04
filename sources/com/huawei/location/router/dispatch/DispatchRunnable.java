package com.huawei.location.router.dispatch;

import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.router.entity.RouterRequest;

/* loaded from: classes8.dex */
public class DispatchRunnable extends DispatchBaseRunnable implements Runnable {
    public DispatchRunnable(RouterRequest routerRequest) {
        super(routerRequest);
    }

    private boolean isOffLineLocation(RouterRequest routerRequest) {
        return "location.requestLocationUpdates".equals(routerRequest.getApiName()) || "location.requestLocationUpdatesEx".equals(routerRequest.getApiName()) || "location.removeLocationUpdates".equals(routerRequest.getApiName()) || "location.getLastLocation".equals(routerRequest.getApiName());
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isError) {
            return;
        }
        this.apiRequest.setRouterRequest(this.routerRequest);
        if (!agcAuthDelay()) {
            if (!isOffLineLocation(this.routerRequest)) {
                handlerErrorResult(LocationStatusCode.AGC_CHECK_FAIL);
                return;
            }
            this.routerRequest.setAgcFail(true);
        }
        this.apiRequest.onRequest(this.routerRequest.getRequestJson());
    }
}
