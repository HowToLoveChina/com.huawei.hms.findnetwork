package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.CommonStatusCodes;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.GeofenceRequest;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.fence.AddGeofencesRequest;
import com.huawei.hms.support.api.entity.location.fence.RemoveGeofencesRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import java.util.List;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.p0 */
/* loaded from: classes8.dex */
public class C5744p0 extends HuaweiApi<C5765w0> implements InterfaceC5738n0 {

    /* renamed from: b */
    private static final C5741o0 f25553b = new C5741o0();

    /* renamed from: c */
    private static final Api<C5765w0> f25554c = new Api<>("HmsLocation.API");

    /* renamed from: a */
    private InterfaceC5761v f25555a;

    public C5744p0(Activity activity, C5765w0 c5765w0) {
        super(activity, f25554c, c5765w0, (AbstractClientBuilder) f25553b);
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5738n0
    /* renamed from: a */
    public Task<Void> mo33141a(GeofenceRequest geofenceRequest, PendingIntent pendingIntent) throws ApiException {
        C8941i c8941i = new C8941i();
        AddGeofencesRequest addGeofencesRequest = new AddGeofencesRequest(getContext());
        String tid = addGeofencesRequest.getTid();
        try {
            if (geofenceRequest == null || pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            if (!PermissionUtil.isGeofencePermissionAvailable(getContext())) {
                throw new ApiException(new Status(10204, CommonStatusCodes.getStatusCodeString(10204)));
            }
            addGeofencesRequest.setGeofencingRequest(geofenceRequest);
            C5692a c5692a = new C5692a("location.addGeofences", JsonUtil.createJsonString(addGeofencesRequest), tid);
            c5692a.setParcelable(pendingIntent);
            return doWrite(c5692a);
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("LocationGeofenceClientImpl", tid, "addGeofences api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        InterfaceC5761v interfaceC5761v;
        if (this.f25555a == null) {
            Object objM33213a = C5770y.m33213a(getContext(), new C5773z());
            if (objM33213a instanceof InterfaceC5761v) {
                this.f25555a = (InterfaceC5761v) objM33213a;
            }
        }
        return (C5773z.m33216a(getContext()) || (interfaceC5761v = this.f25555a) == null) ? super.doWrite(taskApiCall) : interfaceC5761v.mo33178a(this, taskApiCall, f25553b);
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getKitSdkVersion() {
        return 61403300;
    }

    public C5744p0(Context context, C5765w0 c5765w0) {
        super(context, f25554c, c5765w0, f25553b);
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5738n0
    /* renamed from: a */
    public Task<Void> mo33140a(PendingIntent pendingIntent) throws ApiException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C8941i c8941i = new C8941i();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            if (pendingIntent == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            C5694a1 c5694a1 = new C5694a1("location.removeGeofences", JsonUtil.createJsonString(locationBaseRequest), tid);
            c5694a1.setParcelable(pendingIntent);
            Task<Void> taskDoWrite = doWrite(c5694a1);
            HMSLocationLog.m36662i("LocationGeofenceClientImpl", tid, "removeGeofences sdk useTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return taskDoWrite;
        } catch (ApiException e10) {
            HMSLocationLog.m36660e("LocationGeofenceClientImpl", tid, "removeGeofences api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            HMSLocationLog.m36662i("LocationGeofenceClientImpl", tid, "removeGeofences sdk useTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5738n0
    /* renamed from: a */
    public Task<Void> mo33142a(List<String> list) throws ApiException {
        C8941i c8941i = new C8941i();
        RemoveGeofencesRequest removeGeofencesRequest = new RemoveGeofencesRequest(getContext());
        String tid = removeGeofencesRequest.getTid();
        if (list != null) {
            try {
                if (list.size() != 0) {
                    removeGeofencesRequest.setGeofenceRequestIds(list);
                    return doWrite(new C5694a1("location.removeGeofences", JsonUtil.createJsonString(removeGeofencesRequest), tid));
                }
            } catch (ApiException e10) {
                HMSLocationLog.m36660e("LocationGeofenceClientImpl", tid, "removeGeofences api exception:" + e10.getMessage());
                c8941i.m56657c(e10);
                return c8941i.m56656b();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }
}
