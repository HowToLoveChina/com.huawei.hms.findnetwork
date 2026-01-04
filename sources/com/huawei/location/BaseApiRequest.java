package com.huawei.location;

import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.router.BaseRouterTaskCallImpl;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import p622rr.C12619b;
import p854zs.C14373b;
import p854zs.C14374c;

/* loaded from: classes8.dex */
public abstract class BaseApiRequest extends BaseRouterTaskCallImpl {
    private static final String TAG = "BaseApiRequest";
    protected String apiName;
    protected C14373b.a reportBuilder = new C14373b.a();
    protected String errorCode = String.valueOf(0);

    public void checkApproximatelyPermission() throws C12619b {
        if (C14374c.m85585c()) {
            throw new C12619b(LocationStatusCode.NO_PRECISE_LOCATION_PERMISSION, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_PRECISE_LOCATION_PERMISSION));
        }
    }

    public void onRequestFail(int i10, String str) {
        onComplete(new RouterResponse("", new StatusInfo(0, i10, str)));
    }

    public void report(LocationBaseRequest locationBaseRequest) {
        this.reportBuilder.m85578d(this.apiName);
        this.reportBuilder.m85581g(locationBaseRequest);
        this.reportBuilder.m85579e().m85574b(this.errorCode);
    }
}
