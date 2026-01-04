package com.huawei.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import as.C1016d;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.req.BackgroundReq;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.service.BackGroundService;
import es.C9542g;
import p531or.C11991a;
import p854zs.C14375d;

/* loaded from: classes8.dex */
public class EnableGroundTaskCall extends BaseApiRequest {
    private static final String TAG = "EnableGroundTaskCall";

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest EnableGroundTaskCall");
        BackgroundReq backgroundReq = new BackgroundReq();
        C14375d.m85589b(str, backgroundReq);
        Context contextM72145a = C11991a.m72145a();
        Notification notification = (Notification) getParcelable();
        Intent intent = new Intent(contextM72145a, (Class<?>) BackGroundService.class);
        intent.putExtra("notificationId", backgroundReq.getNotificationId());
        intent.putExtra("notification", notification);
        contextM72145a.startForegroundService(intent);
        onComplete(new RouterResponse(C9542g.m59588a().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, 0, "SUCCESS")));
    }
}
