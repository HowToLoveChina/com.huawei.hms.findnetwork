package com.huawei.location.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import as.C1016d;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.ActivityIdentificationData;
import com.huawei.hms.location.ActivityIdentificationResponse;
import com.huawei.hms.location.api.request.RequestActivityIdentificationReq;
import com.huawei.hms.location.api.response.RequestActivityIdentificationResp;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;
import com.huawei.hms.location.entity.activity.DetectedActivity;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9542g;
import hu.C10343b;
import is.C10607d;
import java.util.ArrayList;
import java.util.List;
import p531or.C11991a;
import p622rr.C12619b;
import p852zq.C14362c;
import p852zq.C14369j;

/* loaded from: classes8.dex */
public class RequestActivityIdentificationUpdatesTaskCall extends BaseApiTaskCall {
    private static final String KEY_RESPONSE = "KEY_RESPONSE";
    private static final String KEY_RESPONSE_RESULT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_RESULT";
    private static final String TAG = "RequestActivityIdentificationUpdatesAPI";
    private C14369j.a callBackInfo;
    private ClientInfo clientInfo;
    private PendingIntent pendingIntent;
    private RequestActivityIdentificationReq requestActivityIdentificationReq = null;

    /* renamed from: com.huawei.location.activity.RequestActivityIdentificationUpdatesTaskCall$a */
    public class C6731a implements ARCallback {
        public C6731a() {
        }

        @Override // com.huawei.location.base.activity.callback.ARCallback
        public final void onActivityRecognition(ActivityRecognitionResult activityRecognitionResult) throws PendingIntent.CanceledException {
            String str;
            RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.m84225c("AR_activityStateCallback");
            if (RequestActivityIdentificationUpdatesTaskCall.this.pendingIntent == null) {
                RequestActivityIdentificationResp requestActivityIdentificationResp = new RequestActivityIdentificationResp();
                requestActivityIdentificationResp.setActivityRecognitionResult(activityRecognitionResult);
                String json = C9542g.m59588a().toJson(requestActivityIdentificationResp);
                RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall = RequestActivityIdentificationUpdatesTaskCall.this;
                requestActivityIdentificationUpdatesTaskCall.doExecute(new RouterResponse(json, new StatusInfo(0, requestActivityIdentificationUpdatesTaskCall.errorCode, requestActivityIdentificationUpdatesTaskCall.errorReason)));
            } else {
                if (!ARLocationPermissionManager.checkCPActivityRecognitionPermissionByException(RequestActivityIdentificationUpdatesTaskCall.this.getTAG(), "checkActivityRecognitionPermission", RequestActivityIdentificationUpdatesTaskCall.this.clientInfo.getClientPid(), RequestActivityIdentificationUpdatesTaskCall.this.clientInfo.getClientUid())) {
                    RequestActivityIdentificationUpdatesTaskCall.this.removeActivityIdentificationUpdates();
                    return;
                }
                try {
                    List<DetectedActivity> probableActivities = activityRecognitionResult.getProbableActivities();
                    ArrayList arrayList = new ArrayList();
                    for (DetectedActivity detectedActivity : probableActivities) {
                        arrayList.add(new ActivityIdentificationData(detectedActivity.getType() + 100, detectedActivity.getConfidence()));
                    }
                    ActivityIdentificationResponse activityIdentificationResponse = new ActivityIdentificationResponse(arrayList, activityRecognitionResult.getTime(), activityRecognitionResult.getElapsedRealtimeMillis());
                    C1016d.m6186f(RequestActivityIdentificationUpdatesTaskCall.TAG, "sending recognition result:" + activityRecognitionResult);
                    Intent intent = new Intent();
                    C10343b c10343b = new C10343b();
                    c10343b.m63699u(RequestActivityIdentificationUpdatesTaskCall.KEY_RESPONSE, activityIdentificationResponse);
                    intent.putExtra(RequestActivityIdentificationUpdatesTaskCall.KEY_RESPONSE_RESULT, c10343b.m63683e());
                    RequestActivityIdentificationUpdatesTaskCall.this.pendingIntent.send(C11991a.m72145a(), 0, intent);
                } catch (PendingIntent.CanceledException unused) {
                    str = "CanceledException";
                    C1016d.m6185e(RequestActivityIdentificationUpdatesTaskCall.TAG, str, true);
                    RequestActivityIdentificationUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall2 = RequestActivityIdentificationUpdatesTaskCall.this;
                    requestActivityIdentificationUpdatesTaskCall2.reportBuilder.m84224b(requestActivityIdentificationUpdatesTaskCall2.requestActivityIdentificationReq);
                    RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.m84223a().m84221a(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
                } catch (ApiException unused2) {
                    str = "ApiException";
                    C1016d.m6185e(RequestActivityIdentificationUpdatesTaskCall.TAG, str, true);
                    RequestActivityIdentificationUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall22 = RequestActivityIdentificationUpdatesTaskCall.this;
                    requestActivityIdentificationUpdatesTaskCall22.reportBuilder.m84224b(requestActivityIdentificationUpdatesTaskCall22.requestActivityIdentificationReq);
                    RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.m84223a().m84221a(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
                } catch (NullPointerException unused3) {
                    str = "NullPointerException";
                    C1016d.m6185e(RequestActivityIdentificationUpdatesTaskCall.TAG, str, true);
                    RequestActivityIdentificationUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall222 = RequestActivityIdentificationUpdatesTaskCall.this;
                    requestActivityIdentificationUpdatesTaskCall222.reportBuilder.m84224b(requestActivityIdentificationUpdatesTaskCall222.requestActivityIdentificationReq);
                    RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.m84223a().m84221a(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
                }
            }
            RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall2222 = RequestActivityIdentificationUpdatesTaskCall.this;
            requestActivityIdentificationUpdatesTaskCall2222.reportBuilder.m84224b(requestActivityIdentificationUpdatesTaskCall2222.requestActivityIdentificationReq);
            RequestActivityIdentificationUpdatesTaskCall.this.reportBuilder.m84223a().m84221a(String.valueOf(RequestActivityIdentificationUpdatesTaskCall.this.errorCode));
        }

        public /* synthetic */ C6731a(RequestActivityIdentificationUpdatesTaskCall requestActivityIdentificationUpdatesTaskCall, int i10) {
            this();
        }
    }

    private boolean checkRequest(RequestActivityIdentificationReq requestActivityIdentificationReq) {
        RouterResponse routerResponse;
        if (requestActivityIdentificationReq.getPackageName().isEmpty()) {
            C1016d.m6183c(TAG, "packageName is invalid");
            routerResponse = new RouterResponse(C9542g.m59588a().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else {
            if (!requestActivityIdentificationReq.getLocTransactionId().isEmpty()) {
                return true;
            }
            C1016d.m6183c(TAG, "tid is invalid");
            routerResponse = new RouterResponse(C9542g.m59588a().toJson(new RequestActivityIdentificationResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        }
        onComplete(routerResponse);
        return false;
    }

    private void getCallback() {
        C14362c c14362cM85536c = this.pendingIntent != null ? C14369j.m85556f().m85536c(this.pendingIntent) : C14369j.m85556f().m85537d(getRouterCallback());
        if (c14362cM85536c instanceof C14369j.a) {
            this.callBackInfo = (C14369j.a) c14362cM85536c;
        }
    }

    private PendingIntent getPendingIntent() {
        Parcelable parcelable = getParcelable();
        if (parcelable instanceof PendingIntent) {
            this.pendingIntent = (PendingIntent) parcelable;
        }
        return this.pendingIntent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTAG() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeActivityIdentificationUpdates() {
        int i10;
        C1016d.m6186f(TAG, "removeActivityIdentificationUpdates start");
        if (this.callBackInfo != null) {
            try {
                ((C10607d) C10607d.m65027a()).m65029c(this.callBackInfo.m85557e(), this.clientInfo);
                C14369j.m85556f().m85538e(this.callBackInfo);
                i10 = 0;
            } catch (C12619b e10) {
                int iM76135b = e10.m76135b();
                this.errorReason = "removeActivityUpdates in request api LocationServiceException:" + e10.getMessage();
                i10 = iM76135b;
            } catch (Exception unused) {
                this.errorReason = "removeActivityUpdates in request api exception";
                i10 = 10000;
            }
        } else {
            i10 = 0;
        }
        this.reportBuilder.m84224b(this.requestActivityIdentificationReq);
        this.reportBuilder.m84225c("AR_removeActivityState");
        this.reportBuilder.m84223a().m84221a(String.valueOf(i10));
    }

    private void saveCallbackInfo() {
        if (this.callBackInfo == null) {
            C14369j.a aVar = new C14369j.a();
            this.callBackInfo = aVar;
            aVar.m85558f(new C6731a(this, 0));
            this.callBackInfo.m85541c(this.pendingIntent);
            this.callBackInfo.m85542d(getRouterCallback());
            C14369j.m85556f().m85534a(this.callBackInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    @Override // com.huawei.location.router.interfaces.IRouterRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRequest(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "onRequest start"
            java.lang.String r1 = "RequestActivityIdentificationUpdatesAPI"
            as.C1016d.m6186f(r1, r0)
            ys.a$a r0 = r7.reportBuilder
            java.lang.String r2 = "AR_requestActivityState"
            r0.m84225c(r2)
            r0 = 10000(0x2710, float:1.4013E-41)
            r2 = 0
            es.C9547l.m59615a(r1, r8)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.google.gson.Gson r3 = es.C9542g.m59588a()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            java.lang.Class<com.huawei.hms.location.api.request.RequestActivityIdentificationReq> r4 = com.huawei.hms.location.api.request.RequestActivityIdentificationReq.class
            java.lang.Object r8 = r3.fromJson(r8, r4)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = (com.huawei.hms.location.api.request.RequestActivityIdentificationReq) r8     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r7.requestActivityIdentificationReq = r8     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            boolean r8 = r7.checkRequest(r8)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            if (r8 != 0) goto L41
            ys.a$a r8 = r7.reportBuilder     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r3 = r7.requestActivityIdentificationReq     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r8.m84224b(r3)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            ys.a$a r8 = r7.reportBuilder     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            ys.a r8 = r8.m84223a()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            int r3 = r7.errorCode     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r8.m84222b(r3)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            return
        L3f:
            r8 = move-exception
            goto L8f
        L41:
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = r7.requestActivityIdentificationReq     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            java.lang.String r8 = r8.getLocTransactionId()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r3 = r7.requestActivityIdentificationReq     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            java.lang.String r3 = r3.getPackageName()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            int r4 = es.C9536a.m59552l(r3)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.huawei.location.base.activity.entity.ClientInfo r5 = new com.huawei.location.base.activity.entity.ClientInfo     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r5.<init>(r3, r4, r2, r8)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r7.clientInfo = r5     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r8 = r7.requestActivityIdentificationReq     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            long r3 = r8.getDetectionIntervalMillis()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r5 = 0
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L66
            r3 = 30000(0x7530, double:1.4822E-319)
        L66:
            android.app.PendingIntent r8 = r7.getPendingIntent()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r7.pendingIntent = r8     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r7.getCallback()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r7.saveCallbackInfo()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            is.b r8 = is.C10607d.m65027a()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            zq.j$a r5 = r7.callBackInfo     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.huawei.location.base.activity.callback.ARCallback r5 = r5.m85557e()     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            com.huawei.location.base.activity.entity.ClientInfo r6 = r7.clientInfo     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            is.d r8 = (is.C10607d) r8     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            r8.m65028b(r3, r5, r6)     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            java.lang.String r8 = "requestActivityIdentificationUpdates success"
            r7.errorReason = r8     // Catch: p622rr.C12619b -> L3f java.lang.Exception -> L88 com.google.gson.JsonSyntaxException -> La8
            goto Lb2
        L88:
            r7.errorCode = r0
            java.lang.String r8 = "onRequest requestActivityIdentificationUpdates exception"
        L8c:
            r7.errorReason = r8
            goto Lb2
        L8f:
            int r0 = r8.m76135b()
            r7.errorCode = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "onRequest requestActivityIdentificationUpdates LocationServiceException:"
            r0.<init>(r1)
            java.lang.String r8 = r8.getMessage()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            goto L8c
        La8:
            java.lang.String r8 = "requestActivityIdentificationUpdatesTaskCall json parse failed"
            as.C1016d.m6186f(r1, r8)
            r7.errorCode = r0
            java.lang.String r8 = "onRequest requestActivityIdentificationUpdates json parse exception"
            goto L8c
        Lb2:
            int r8 = r7.errorCode
            if (r8 != 0) goto Lbe
            zq.j$a r8 = r7.callBackInfo
            android.app.PendingIntent r8 = r8.m85540b()
            if (r8 == 0) goto Ldc
        Lbe:
            com.huawei.location.router.RouterResponse r8 = new com.huawei.location.router.RouterResponse
            com.google.gson.Gson r0 = es.C9542g.m59588a()
            com.huawei.hms.location.api.response.RequestActivityIdentificationResp r1 = new com.huawei.hms.location.api.response.RequestActivityIdentificationResp
            r1.<init>()
            java.lang.String r0 = r0.toJson(r1)
            com.huawei.location.router.entity.StatusInfo r1 = new com.huawei.location.router.entity.StatusInfo
            int r3 = r7.errorCode
            java.lang.String r4 = r7.errorReason
            r1.<init>(r2, r3, r4)
            r8.<init>(r0, r1)
            r7.doExecute(r8)
        Ldc:
            ys.a$a r8 = r7.reportBuilder
            com.huawei.hms.location.api.request.RequestActivityIdentificationReq r0 = r7.requestActivityIdentificationReq
            r8.m84224b(r0)
            ys.a$a r8 = r7.reportBuilder
            ys.a r8 = r8.m84223a()
            int r7 = r7.errorCode
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r8.m84222b(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.activity.RequestActivityIdentificationUpdatesTaskCall.onRequest(java.lang.String):void");
    }
}
