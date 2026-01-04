package com.huawei.location.activity;

import android.app.PendingIntent;
import android.os.Parcelable;
import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.api.request.RemoveActivityConversionReq;
import com.huawei.hms.location.api.response.RequestActivityConversionResp;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9536a;
import es.C9542g;
import es.C9547l;
import is.C10607d;
import p622rr.C12619b;
import p852zq.C14362c;
import p852zq.C14364e;

/* loaded from: classes8.dex */
public class RemoveActivityConversionUpdatesTaskCall extends BaseApiTaskCall {
    private static final String TAG = "RemoveActivityConversionUpdatesAPI";

    private boolean checkRequest(RemoveActivityConversionReq removeActivityConversionReq) {
        if (removeActivityConversionReq == null || removeActivityConversionReq.getPackageName() == null || removeActivityConversionReq.getLocTransactionId() == null) {
            dealRequest();
            return false;
        }
        if (!removeActivityConversionReq.getPackageName().isEmpty() && !removeActivityConversionReq.getLocTransactionId().isEmpty()) {
            return true;
        }
        dealRequest();
        return false;
    }

    private void dealRequest() {
        onComplete(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101))));
        this.errorCode = 10101;
    }

    private C14362c getBaseCallbackMapping(PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            return C14364e.m85546f().m85537d(getRouterCallback());
        }
        C14362c c14362cM85536c = C14364e.m85546f().m85536c(pendingIntent);
        C9547l.m59616b(TAG, c14362cM85536c, ActivityErrorCode.NO_MATCHED_INTENT, "NO_MATCHED_INTENT");
        return c14362cM85536c;
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
        RemoveActivityConversionReq removeActivityConversionReq;
        C1016d.m6186f(TAG, "onRequest start");
        this.reportBuilder.m84225c("AR_removeActivityTransition");
        RemoveActivityConversionReq removeActivityConversionReq2 = null;
        try {
            C9547l.m59615a(TAG, str);
            removeActivityConversionReq = (RemoveActivityConversionReq) C9542g.m59588a().fromJson(str, RemoveActivityConversionReq.class);
        } catch (JsonSyntaxException unused) {
        } catch (C12619b e10) {
            e = e10;
        } catch (Exception unused2) {
        }
        try {
        } catch (JsonSyntaxException unused3) {
            removeActivityConversionReq2 = removeActivityConversionReq;
            C1016d.m6186f(TAG, "removeActivityConversionUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest removeActivityConversionUpdates exception";
            removeActivityConversionReq = removeActivityConversionReq2;
            this.reportBuilder.m84224b(removeActivityConversionReq);
            this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
            doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        } catch (C12619b e11) {
            e = e11;
            removeActivityConversionReq2 = removeActivityConversionReq;
            this.errorCode = e.m76135b();
            this.errorReason = "onRequest removeActivityConversionUpdates LocationServiceException:" + e.getMessage();
            removeActivityConversionReq = removeActivityConversionReq2;
            this.reportBuilder.m84224b(removeActivityConversionReq);
            this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
            doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        } catch (Exception unused4) {
            removeActivityConversionReq2 = removeActivityConversionReq;
            this.errorCode = 10000;
            this.errorReason = "onRequest removeActivityConversionUpdates exception";
            removeActivityConversionReq = removeActivityConversionReq2;
            this.reportBuilder.m84224b(removeActivityConversionReq);
            this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
            doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        }
        if (!checkRequest(removeActivityConversionReq)) {
            this.reportBuilder.m84224b(removeActivityConversionReq);
            this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
            return;
        }
        removeActivityConversionReq.setModuleName(ActivityRecognitionConstants.LOCATION_MODULE);
        String locTransactionId = removeActivityConversionReq.getLocTransactionId();
        String packageName = removeActivityConversionReq.getPackageName();
        ClientInfo clientInfo = new ClientInfo(packageName, C9536a.m59552l(packageName), 0, locTransactionId);
        C14362c baseCallbackMapping = getBaseCallbackMapping(getPendingIntent());
        C14364e.a aVar = new C14364e.a();
        if (baseCallbackMapping instanceof C14364e.a) {
            aVar = (C14364e.a) baseCallbackMapping;
        }
        C9547l.m59617c(TAG, aVar, C14364e.a.class);
        C9547l.m59617c(TAG, aVar.m85547e(), C14364e.a.class);
        ((C10607d) C10607d.m65027a()).m65031e(removeActivityConversionReq.getModuleName(), aVar.m85547e(), clientInfo);
        C14364e.m85546f().m85538e(aVar);
        this.errorReason = "removeActivityConversionUpdates success";
        this.reportBuilder.m84224b(removeActivityConversionReq);
        this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
        doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
    }
}
