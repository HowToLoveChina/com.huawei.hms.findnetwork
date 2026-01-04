package com.huawei.location.router.interfaces;

import com.huawei.location.router.RouterResponse;

/* loaded from: classes8.dex */
public interface IRouterCallback {
    void doExecute(RouterResponse routerResponse);

    void onComplete(RouterResponse routerResponse);
}
