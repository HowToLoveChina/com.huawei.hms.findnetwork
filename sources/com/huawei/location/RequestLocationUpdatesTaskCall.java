package com.huawei.location;

import as.C1016d;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import es.C9542g;
import is.C10606c;
import p622rr.C12619b;
import p819yq.C14035a;
import p819yq.C14036b;
import p852zq.InterfaceC14367h;
import p854zs.C14375d;

/* loaded from: classes8.dex */
public class RequestLocationUpdatesTaskCall extends BaseApiRequest {
    private static final String TAG = "RequestLocationUpdatesApiRequest";
    private InterfaceC14367h hwLocationCallback = new C6727a();

    /* renamed from: com.huawei.location.RequestLocationUpdatesTaskCall$a */
    public class C6727a implements InterfaceC14367h {
        public C6727a() {
        }

        @Override // p852zq.InterfaceC14367h
        /* renamed from: a */
        public final void mo38278a() {
            RequestLocationUpdatesTaskCall.this.onComplete(new RouterResponse(C9542g.m59588a().toJson(new RequestLocationUpdatesResponse()), new StatusInfo(0, 0, "success")));
        }

        @Override // p852zq.InterfaceC14367h
        /* renamed from: b */
        public final void mo38279b(RouterResponse routerResponse) {
            RequestLocationUpdatesTaskCall.this.doExecute(routerResponse);
        }
    }

    private boolean checkNeedOffLineLocation(LocationRequest locationRequest) {
        C1016d.m6186f(TAG, "checkNeedOffLineLocation");
        if (!agcFail()) {
            return true;
        }
        if (locationRequest.getPriority() == 100) {
            C1016d.m6186f(TAG, "agc fail ,but use offLine");
            return true;
        }
        RouterResponse routerResponse = new RouterResponse("", new StatusInfo(0, LocationStatusCode.AGC_CHECK_FAIL, LocationStatusCode.getStatusCodeString(LocationStatusCode.AGC_CHECK_FAIL)));
        if (getRouterCallback() != null) {
            getRouterCallback().onComplete(routerResponse);
        }
        return false;
    }

    private void checkRequest(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        if (requestLocationUpdatesRequest.getLocationRequest() == null) {
            C1016d.m6183c(TAG, "locationRequest is invalid");
            throw new C12619b(10000, LocationStatusCode.getStatusCodeString(10000));
        }
        int priority = requestLocationUpdatesRequest.getLocationRequest().getPriority();
        if (priority != 200 && priority != 100 && priority != 102 && priority != 104 && priority != 300 && priority != 105 && priority != 400) {
            C1016d.m6186f(TAG, "request is invalid");
            throw new C12619b(10101, LocationStatusCode.getStatusCodeString(10101));
        }
        C1016d.m6186f(TAG, "onRequest，tid is " + requestLocationUpdatesRequest.getTid() + ", packageName is " + requestLocationUpdatesRequest.getPackageName() + ", uuid is " + requestLocationUpdatesRequest.getUuid() + ", locationRequest is " + requestLocationUpdatesRequest.getLocationRequest().getPriority());
    }

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest start");
        this.apiName = "Location_requestLocationUpdates";
        RequestLocationUpdatesRequest requestLocationUpdatesRequest = new RequestLocationUpdatesRequest();
        try {
            C14375d.m85589b(str, requestLocationUpdatesRequest);
            checkRequest(requestLocationUpdatesRequest);
            checkApproximatelyPermission();
        } catch (C12619b e10) {
            this.errorCode = String.valueOf(e10.m76135b());
            onRequestFail(e10.m76135b(), e10.getMessage());
        } catch (Exception unused) {
            this.errorCode = String.valueOf(10000);
            onRequestFail(10000, LocationStatusCode.getStatusCodeString(10000));
        }
        if (checkNeedOffLineLocation(requestLocationUpdatesRequest.getLocationRequest())) {
            boolean zM84196h = C14036b.m84189d().m84196h(requestLocationUpdatesRequest.getUuid());
            requestLocationUpdatesRequest.setResendFromHMS(isResendFromHMS());
            C10606c.m65019d().m65023c(new C14035a(requestLocationUpdatesRequest), this.hwLocationCallback);
            this.reportBuilder.m85576b();
            this.reportBuilder.m85580f(requestLocationUpdatesRequest.getLocationRequest(), zM84196h);
            report(requestLocationUpdatesRequest);
        }
    }
}
