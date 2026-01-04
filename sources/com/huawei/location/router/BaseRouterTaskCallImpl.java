package com.huawei.location.router;

import android.os.Parcelable;
import com.huawei.location.router.entity.IRouterResponse;
import com.huawei.location.router.entity.RouterRequest;
import com.huawei.location.router.interfaces.IRouterCallback;
import com.huawei.location.router.interfaces.IRouterRequest;

/* loaded from: classes8.dex */
public abstract class BaseRouterTaskCallImpl implements IRouterRequest, IRouterCallback {
    private RouterRequest routerRequest;

    public boolean agcFail() {
        return this.routerRequest.isAgcFail();
    }

    @Override // com.huawei.location.router.interfaces.IRouterCallback
    public void doExecute(RouterResponse routerResponse) {
        if (getRouterCallback() != null) {
            routerResponse.setTransactionId(getTransactionId());
            getRouterCallback().doExecute(routerResponse);
        }
    }

    public String getApiName() {
        return this.routerRequest.getApiName();
    }

    public Parcelable getParcelable() {
        return this.routerRequest.getParcelable();
    }

    public String getRequestJson() {
        return this.routerRequest.getRequestJson();
    }

    public IRouterCallback getRouterCallback() {
        return this.routerRequest.getRouterCallback();
    }

    public String getTransactionId() {
        return this.routerRequest.getTransactionId();
    }

    public boolean isResendFromHMS() {
        return this.routerRequest.isResendFromHMS();
    }

    @Override // com.huawei.location.router.interfaces.IRouterCallback
    public void onComplete(RouterResponse routerResponse) {
        if (getRouterCallback() != null) {
            routerResponse.setTransactionId(getTransactionId());
            getRouterCallback().onComplete(routerResponse);
        }
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public IRouterResponse onExecute(String str) {
        return null;
    }

    public void setRouterRequest(RouterRequest routerRequest) {
        this.routerRequest = routerRequest;
    }
}
