package com.huawei.location;

import android.content.Context;
import android.content.Intent;
import as.C1016d;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.service.BackGroundService;
import es.C9542g;
import p531or.C11991a;

/* loaded from: classes8.dex */
public class DisableGroundTaskCall extends BaseApiRequest {
    private static final String TAG = "DisableGroundTaskCall";

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest DisableGroundTaskCall");
        Context contextM72145a = C11991a.m72145a();
        contextM72145a.stopService(new Intent(contextM72145a, (Class<?>) BackGroundService.class));
        onComplete(new RouterResponse(C9542g.m59588a().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, 0, "SUCCESS")));
    }
}
