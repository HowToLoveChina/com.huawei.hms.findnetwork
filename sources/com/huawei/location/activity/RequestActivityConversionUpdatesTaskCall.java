package com.huawei.location.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import as.C1016d;
import com.google.gson.JsonSyntaxException;
import com.huawei.hms.location.ActivityConversionData;
import com.huawei.hms.location.ActivityConversionInfo;
import com.huawei.hms.location.ActivityConversionResponse;
import com.huawei.hms.location.api.request.RequestActivityConversionReq;
import com.huawei.hms.location.api.response.RequestActivityConversionResp;
import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.hms.location.entity.activity.ActivityTransitionEvent;
import com.huawei.hms.location.entity.activity.ActivityTransitionRequest;
import com.huawei.hms.location.entity.activity.ActivityTransitionResult;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.constant.ActivityErrorCode;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import com.huawei.location.base.activity.entity.ClientInfo;
import com.huawei.location.base.activity.permission.ARLocationPermissionManager;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9536a;
import es.C9542g;
import es.C9547l;
import hu.C10343b;
import is.C10607d;
import java.util.ArrayList;
import java.util.List;
import p531or.C11991a;
import p622rr.C12619b;
import p852zq.C14362c;
import p852zq.C14364e;
import p852zq.C14369j;

/* loaded from: classes8.dex */
public class RequestActivityConversionUpdatesTaskCall extends BaseApiTaskCall {
    private static final String KEY_RESPONSE = "KEY_RESPONSE";
    private static final String KEY_RESPONSE_RESULT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_RESULT";
    private static final String TAG = "RequestActivityConversionUpdatesAPI";
    private C14364e.a callBackInfo;
    private ClientInfo clientInfo;
    private String moduleName;
    private PendingIntent pendingIntent;
    private RequestActivityConversionReq requestActivityConversionReq = null;

    /* renamed from: com.huawei.location.activity.RequestActivityConversionUpdatesTaskCall$a */
    public class C6730a implements ATCallback {
        public C6730a() {
        }

        @Override // com.huawei.location.base.activity.callback.ATCallback
        public final void onActivityTransition(ActivityTransitionResult activityTransitionResult) throws PendingIntent.CanceledException {
            String str;
            RequestActivityConversionUpdatesTaskCall.this.reportBuilder.m84225c("AR_activityTransitionCallback");
            if (RequestActivityConversionUpdatesTaskCall.this.pendingIntent == null) {
                RequestActivityConversionResp requestActivityConversionResp = new RequestActivityConversionResp();
                requestActivityConversionResp.setActivityTransitionResult(activityTransitionResult);
                String json = C9542g.m59588a().toJson(requestActivityConversionResp);
                RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall = RequestActivityConversionUpdatesTaskCall.this;
                requestActivityConversionUpdatesTaskCall.doExecute(new RouterResponse(json, new StatusInfo(0, requestActivityConversionUpdatesTaskCall.errorCode, requestActivityConversionUpdatesTaskCall.errorReason)));
            } else {
                if (!ARLocationPermissionManager.checkCPActivityRecognitionPermissionByException(RequestActivityConversionUpdatesTaskCall.this.getTAG(), "checkActivityRecognitionPermission", RequestActivityConversionUpdatesTaskCall.this.clientInfo.getClientPid(), RequestActivityConversionUpdatesTaskCall.this.clientInfo.getClientUid())) {
                    RequestActivityConversionUpdatesTaskCall.this.removeActivityConversionUpdates();
                    return;
                }
                try {
                    List<ActivityTransitionEvent> transitionEvents = activityTransitionResult.getTransitionEvents();
                    ArrayList arrayList = new ArrayList();
                    for (ActivityTransitionEvent activityTransitionEvent : transitionEvents) {
                        arrayList.add(new ActivityConversionData(activityTransitionEvent.getActivityType() + 100, activityTransitionEvent.getTransitionType(), activityTransitionEvent.getElapsedRealTimeNanos()));
                    }
                    ActivityConversionResponse activityConversionResponse = new ActivityConversionResponse(arrayList);
                    C1016d.m6186f(RequestActivityConversionUpdatesTaskCall.TAG, "sending transition result:" + activityTransitionResult);
                    Intent intent = new Intent();
                    C10343b c10343b = new C10343b();
                    c10343b.m63699u(RequestActivityConversionUpdatesTaskCall.KEY_RESPONSE, activityConversionResponse);
                    intent.putExtra(RequestActivityConversionUpdatesTaskCall.KEY_RESPONSE_RESULT, c10343b.m63683e());
                    RequestActivityConversionUpdatesTaskCall.this.pendingIntent.send(C11991a.m72145a(), 0, intent);
                } catch (PendingIntent.CanceledException unused) {
                    str = "CanceledException";
                    C1016d.m6185e(RequestActivityConversionUpdatesTaskCall.TAG, str, true);
                    RequestActivityConversionUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall2 = RequestActivityConversionUpdatesTaskCall.this;
                    requestActivityConversionUpdatesTaskCall2.reportBuilder.m84224b(requestActivityConversionUpdatesTaskCall2.requestActivityConversionReq);
                    RequestActivityConversionUpdatesTaskCall.this.reportBuilder.m84223a().m84221a(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
                } catch (NullPointerException unused2) {
                    str = "NullPointerException";
                    C1016d.m6185e(RequestActivityConversionUpdatesTaskCall.TAG, str, true);
                    RequestActivityConversionUpdatesTaskCall.this.errorCode = 10000;
                    RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall22 = RequestActivityConversionUpdatesTaskCall.this;
                    requestActivityConversionUpdatesTaskCall22.reportBuilder.m84224b(requestActivityConversionUpdatesTaskCall22.requestActivityConversionReq);
                    RequestActivityConversionUpdatesTaskCall.this.reportBuilder.m84223a().m84221a(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
                }
            }
            RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall222 = RequestActivityConversionUpdatesTaskCall.this;
            requestActivityConversionUpdatesTaskCall222.reportBuilder.m84224b(requestActivityConversionUpdatesTaskCall222.requestActivityConversionReq);
            RequestActivityConversionUpdatesTaskCall.this.reportBuilder.m84223a().m84221a(String.valueOf(RequestActivityConversionUpdatesTaskCall.this.errorCode));
        }

        public /* synthetic */ C6730a(RequestActivityConversionUpdatesTaskCall requestActivityConversionUpdatesTaskCall, int i10) {
            this();
        }
    }

    private boolean checkRequest(RequestActivityConversionReq requestActivityConversionReq) {
        RouterResponse routerResponse;
        if (requestActivityConversionReq.getPackageName().isEmpty()) {
            C1016d.m6183c(TAG, "packageName is invalid");
            routerResponse = new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else if (requestActivityConversionReq.getLocTransactionId().isEmpty()) {
            C1016d.m6183c(TAG, "tid is invalid");
            routerResponse = new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        } else {
            if (!requestActivityConversionReq.getModuleName().isEmpty()) {
                return true;
            }
            C1016d.m6183c(TAG, "ModuleName is invalid");
            routerResponse = new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, 10101, ActivityErrorCode.getErrorCodeMessage(10101)));
        }
        onComplete(routerResponse);
        return false;
    }

    private void getCallback() {
        C14362c c14362cM85536c = this.pendingIntent != null ? C14364e.m85546f().m85536c(this.pendingIntent) : C14369j.m85556f().m85537d(getRouterCallback());
        if (c14362cM85536c instanceof C14364e.a) {
            this.callBackInfo = (C14364e.a) c14362cM85536c;
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

    private List<ActivityTransition> getTransitionLists() {
        List<ActivityConversionInfo> activityConversions = this.requestActivityConversionReq.getActivityConversions();
        ArrayList arrayList = new ArrayList();
        for (ActivityConversionInfo activityConversionInfo : activityConversions) {
            ActivityTransition activityTransition = new ActivityTransition();
            activityTransition.setActivityType(activityConversionInfo.getActivityType() - 100);
            activityTransition.setTransitionType(activityConversionInfo.getConversionType());
            arrayList.add(activityTransition);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeActivityConversionUpdates() {
        int i10;
        C1016d.m6186f(TAG, "removeActivityConversionUpdates start");
        if (this.callBackInfo != null) {
            try {
                ((C10607d) C10607d.m65027a()).m65031e(this.moduleName, this.callBackInfo.m85547e(), this.clientInfo);
                C14364e.m85546f().m85538e(this.callBackInfo);
                i10 = 0;
            } catch (C12619b e10) {
                int iM76135b = e10.m76135b();
                this.errorReason = "removeActivityConversionUpdates in request api LocationServiceException:" + e10.getMessage();
                i10 = iM76135b;
            } catch (Exception unused) {
                this.errorReason = "removeActivityConversionUpdates in request api exception";
                i10 = 10000;
            }
        } else {
            i10 = 0;
        }
        this.reportBuilder.m84224b(this.requestActivityConversionReq);
        this.reportBuilder.m84225c("AR_removeActivityTransition");
        this.reportBuilder.m84223a().m84221a(String.valueOf(i10));
    }

    private void saveCallbackInfo() {
        if (this.callBackInfo == null) {
            C14364e.a aVar = new C14364e.a();
            this.callBackInfo = aVar;
            aVar.m85548f(new C6730a(this, 0));
            this.callBackInfo.m85541c(this.pendingIntent);
            this.callBackInfo.m85542d(getRouterCallback());
            C14364e.m85546f().m85534a(this.callBackInfo);
        }
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest start");
        this.reportBuilder.m84225c("AR_requestActivityTransition");
        try {
            C9547l.m59615a(TAG, str);
            RequestActivityConversionReq requestActivityConversionReq = (RequestActivityConversionReq) C9542g.m59588a().fromJson(str, RequestActivityConversionReq.class);
            this.requestActivityConversionReq = requestActivityConversionReq;
            if (requestActivityConversionReq.getModuleName() == null || this.requestActivityConversionReq.getModuleName().isEmpty()) {
                this.requestActivityConversionReq.setModuleName(ActivityRecognitionConstants.LOCATION_MODULE);
            }
        } catch (JsonSyntaxException unused) {
            C1016d.m6186f(TAG, "requestActivityConversionUpdatesTaskCall json parse failed");
            this.errorCode = 10000;
            this.errorReason = "onRequest requestActivityConversionUpdates exception";
        } catch (C12619b e10) {
            this.errorCode = e10.m76135b();
            this.errorReason = "onRequest requestActivityConversionUpdates LocationServiceException:" + e10.getMessage();
        } catch (Exception unused2) {
            this.errorCode = 10000;
            this.errorReason = "onRequest requestActivityConversionUpdates exception";
        }
        if (!checkRequest(this.requestActivityConversionReq)) {
            this.reportBuilder.m84224b(this.requestActivityConversionReq);
            this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
            return;
        }
        String locTransactionId = this.requestActivityConversionReq.getLocTransactionId();
        String packageName = this.requestActivityConversionReq.getPackageName();
        this.clientInfo = new ClientInfo(packageName, C9536a.m59552l(packageName), 0, locTransactionId);
        this.pendingIntent = getPendingIntent();
        getCallback();
        saveCallbackInfo();
        List<ActivityTransition> transitionLists = getTransitionLists();
        ActivityTransitionRequest activityTransitionRequest = new ActivityTransitionRequest();
        activityTransitionRequest.setTransitions(transitionLists);
        this.moduleName = this.requestActivityConversionReq.getModuleName();
        ((C10607d) C10607d.m65027a()).m65030d(this.moduleName, activityTransitionRequest, this.callBackInfo.m85547e(), this.clientInfo);
        this.errorReason = "requestActivityConversionUpdates success";
        if (this.errorCode != 0 || this.callBackInfo.m85540b() != null) {
            doExecute(new RouterResponse(C9542g.m59588a().toJson(new RequestActivityConversionResp()), new StatusInfo(0, this.errorCode, this.errorReason)));
        }
        this.reportBuilder.m84224b(this.requestActivityConversionReq);
        this.reportBuilder.m84223a().m84222b(String.valueOf(this.errorCode));
    }
}
