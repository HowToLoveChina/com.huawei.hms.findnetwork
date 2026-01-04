package com.huawei.location;

import as.C1016d;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.location.req.RemoveLocationUpdatesReq;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9542g;
import is.C10606c;
import p622rr.C12619b;
import p854zs.C14375d;

/* loaded from: classes8.dex */
public class RemoveUpdateTaskCall extends BaseApiRequest {
    private static final String TAG = "RemoveLocationUpdateApi";

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest start");
        RemoveLocationUpdatesReq removeLocationUpdatesReq = new RemoveLocationUpdatesReq();
        C14375d.m85589b(str, removeLocationUpdatesReq);
        this.reportBuilder.m85578d("Location_removeLocationUpdates");
        this.reportBuilder.m85581g(removeLocationUpdatesReq);
        try {
            C1016d.m6186f(TAG, "onRequest start:" + removeLocationUpdatesReq.getUuid());
            C10606c.m65019d().m65025g(removeLocationUpdatesReq.getUuid());
            this.reportBuilder.m85579e().m85574b("0");
            onComplete(new RouterResponse(C9542g.m59588a().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, 0, "SUCCESS")));
        } catch (C12619b e10) {
            this.reportBuilder.m85579e().m85574b(e10.m76135b() + "");
            onComplete(new RouterResponse(C9542g.m59588a().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, e10.m76135b(), e10.getMessage())));
        }
    }
}
