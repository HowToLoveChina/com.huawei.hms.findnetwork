package com.huawei.location.activity;

import android.app.PendingIntent;
import android.os.Parcelable;
import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.hms.location.api.response.RequestActivityIdentificationResp;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9536a;
import es.C9542g;
import es.C9547l;
import is.C10607d;
import p622rr.C12619b;
import p852zq.C14362c;
import p852zq.C14369j;

/* loaded from: classes8.dex */
public class RemoveActivityIdentificationUpdatesTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RemoveActivityIdentificationUpdatesAPI";

    private boolean checkRequest(BaseLocationReq baseLocationReq) {
        if (!baseLocationReq.getLocTransactionId().isEmpty() && !baseLocationReq.getPackageName().isEmpty()) {
            return true;
        }
        C1016d.m6183c(TAG, "tid or packageName is invalid");
        onComplete(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101))));
        return false;
    }

    private PendingIntent getPendingIntent() {
        Parcelable parcelable = getParcelable();
        if (parcelable instanceof PendingIntent) {
            return (PendingIntent) parcelable;
        }
        return null;
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        BaseLocationReq baseLocationReq;
        C14362c c14362cM85537d;
        C1016d.m6186f(TAG, "onRequest start");
        this.reportBuilder.m84225c("AR_removeActivityState");
        BaseLocationReq baseLocationReq2 = null;
        try {
            C9547l.m59615a(TAG, str);
            baseLocationReq = (BaseLocationReq) C9542g.m59588a().fromJson(str, BaseLocationReq.class);
            try {
            } catch (JsonSyntaxException unused) {
                baseLocationReq2 = baseLocationReq;
                C1016d.m6186f(TAG, "removeActivityIdentificationUpdatesTaskCall json parse failed");
                this.errorCode = 10000;
                this.errorReason = "onRequest removeActivityIdentificationUpdates exception";
                baseLocationReq = baseLocationReq2;
                this.reportBuilder.m84224b(baseLocationReq);
                this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
                doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
            } catch (C12619b e10) {
                e = e10;
                baseLocationReq2 = baseLocationReq;
                this.errorCode = e.m76135b();
                this.errorReason = "onRequest removeActivityIdentificationUpdates LocationServiceException:" + e.getMessage();
                baseLocationReq = baseLocationReq2;
                this.reportBuilder.m84224b(baseLocationReq);
                this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
                doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
            } catch (Exception unused2) {
                baseLocationReq2 = baseLocationReq;
                this.errorCode = 10000;
                this.errorReason = "onRequest removeActivityIdentificationUpdates exception";
                baseLocationReq = baseLocationReq2;
                this.reportBuilder.m84224b(baseLocationReq);
                this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
                doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
            }
        } catch (JsonSyntaxException unused3) {
        } catch (C12619b e11) {
            e = e11;
        } catch (Exception unused4) {
        }
        if (!checkRequest(baseLocationReq)) {
            this.reportBuilder.m84224b(baseLocationReq);
            this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
            return;
        }
        String locTransactionId = baseLocationReq.getLocTransactionId();
        String packageName = baseLocationReq.getPackageName();
        ClientInfo clientInfo = new ClientInfo(packageName, C9536a.m59552l(packageName), 0, locTransactionId);
        PendingIntent pendingIntent = getPendingIntent();
        if (pendingIntent != null) {
            c14362cM85537d = C14369j.m85556f().m85536c(pendingIntent);
            C9547l.m59616b(TAG, c14362cM85537d, ActivityErrorCode.NO_MATCHED_INTENT, "NO_MATCHED_INTENT");
        } else {
            c14362cM85537d = C14369j.m85556f().m85537d(getRouterCallback());
        }
        C14369j.a aVar = new C14369j.a();
        if (c14362cM85537d instanceof C14369j.a) {
            aVar = (C14369j.a) c14362cM85537d;
        }
        C9547l.m59617c(TAG, aVar, C14369j.a.class);
        C9547l.m59617c(TAG, aVar.m85557e(), C14369j.a.class);
        ((C10607d) C10607d.m65027a()).m65029c(aVar.m85557e(), clientInfo);
        C14369j.m85556f().m85538e(aVar);
        this.errorReason = "removeActivityIdentificationUpdates success";
        this.reportBuilder.m84224b(baseLocationReq);
        this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
        doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
    }
}
