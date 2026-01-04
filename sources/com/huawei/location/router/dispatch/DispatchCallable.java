package com.huawei.location.router.dispatch;

import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class DispatchCallable extends DispatchBaseRunnable implements Callable<IRouterResponse> {
    public DispatchCallable(RouterRequest routerRequest) {
        super(routerRequest);
    }

    @Override // java.util.concurrent.Callable
    public IRouterResponse call() throws DispatchException {
        this.apiRequest.setRouterRequest(this.routerRequest);
        return this.apiRequest.onExecute(this.routerRequest.getRequestJson());
    }
}
