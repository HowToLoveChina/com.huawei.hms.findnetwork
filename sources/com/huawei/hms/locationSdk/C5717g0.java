package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import bs.C1280g;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LogConfig;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.checksettings.CheckLocationSettingsRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationRequest;
import com.huawei.hms.support.api.entity.location.mock.SetMockLocationRequest;
import com.huawei.hms.support.api.entity.location.mock.SetMockModeRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationRequest;
import com.huawei.hms.support.api.entity.location.offlinelocation.OfflineLocationResponse;
import com.huawei.hms.support.api.entity.location.updates.RemoveLocationUpdatesRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.report.C6791a;
import com.huawei.location.req.BackgroundReq;
import es.C9542g;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;
import p531or.C11991a;

/* renamed from: com.huawei.hms.locationSdk.g0 */
/* loaded from: classes8.dex */
public class C5717g0 extends HuaweiApi<C5765w0> implements InterfaceC5709e0 {

    /* renamed from: b */
    private static final C5713f0 f25513b = new C5713f0();

    /* renamed from: c */
    private static final Api<C5765w0> f25514c = new Api<>("HmsLocation.API");

    /* renamed from: a */
    private InterfaceC5761v f25515a;

    public C5717g0(Activity activity, C5765w0 c5765w0) {
        super(activity, f25514c, c5765w0, (AbstractClientBuilder) f25513b);
        m33084c(activity);
    }

    /* renamed from: b */
    private void m33083b(LocationRequest locationRequest) throws ApiException {
        if (locationRequest.getCoordinateType() != 0 && locationRequest.getCoordinateType() != 1) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
    }

    /* renamed from: e */
    private void m33085e() throws ApiException {
        if (!PermissionUtil.isLocationPermissionAvailable(getContext())) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<LocationSettingsResponse> mo33072a(LocationSettingsRequest locationSettingsRequest) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        CheckLocationSettingsRequest checkLocationSettingsRequest = new CheckLocationSettingsRequest(getContext());
        String tid = checkLocationSettingsRequest.getTid();
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, "checkLocationSettings");
            if (locationSettingsRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            checkLocationSettingsRequest.setLocationSettingsRequest(locationSettingsRequest);
            return doWrite(new C5700c("location.checkLocationSettings", JsonUtil.createJsonString(checkLocationSettingsRequest), tid));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", tid, "check location settings api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, "check location settings exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: c */
    public Task<Void> mo33078c() {
        C8941i c8941i = new C8941i();
        c8941i.m56657c(new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED))));
        return c8941i.m56656b();
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: d */
    public Task<Void> mo33079d() {
        C8941i c8941i = new C8941i();
        if (C5773z.m33216a(getContext())) {
            c8941i.m56657c(new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED))));
            return c8941i.m56656b();
        }
        String tid = new BackgroundReq(getContext()).getTid();
        HMSLocationLog.m36662i("LocationClientImpl", tid, "disableBackgroundLocation");
        return doWrite(new C5708e("location.disableBackgroundLocation", "", tid));
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        InterfaceC5761v interfaceC5761v;
        if (this.f25515a == null) {
            Object objM33213a = C5770y.m33213a(getContext(), new C5773z());
            if (objM33213a instanceof InterfaceC5761v) {
                this.f25515a = (InterfaceC5761v) objM33213a;
            }
        }
        return (C5773z.m33216a(getContext()) || (interfaceC5761v = this.f25515a) == null) ? super.doWrite(taskApiCall) : interfaceC5761v.mo33178a(this, taskApiCall, f25513b);
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getKitSdkVersion() {
        return 61403300;
    }

    public C5717g0(Context context, C5765w0 c5765w0) {
        super(context, f25514c, c5765w0, f25513b);
        m33084c(context);
    }

    /* renamed from: c */
    private void m33084c(Context context) {
        C11991a.m72147c(context);
        C6791a.m38458h().m38464i();
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33065a(int i10, Notification notification) throws ApiException {
        C8941i c8941i = new C8941i();
        if (C5773z.m33216a(getContext())) {
            e = new ApiException(new Status(LocationStatusCode.NOT_YET_SUPPORTED, LocationStatusCode.getStatusCodeString(LocationStatusCode.NOT_YET_SUPPORTED)));
        } else {
            BackgroundReq backgroundReq = new BackgroundReq(getContext());
            String tid = backgroundReq.getTid();
            try {
                HMSLocationLog.m36662i("LocationClientImpl", tid, "enableBackgroundLocation");
                if (i10 == 0) {
                    throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
                }
                if (notification == null) {
                    throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
                }
                if (!PermissionUtil.isPermissionAvailable(getContext(), "android.permission.FOREGROUND_SERVICE")) {
                    throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
                }
                backgroundReq.setNotificationId(i10);
                C5712f c5712f = new C5712f("location.enableBackgroundLocation", JsonUtil.createJsonString(backgroundReq), tid);
                c5712f.setParcelable(notification);
                return doWrite(c5712f);
            } catch (ApiException e10) {
                e = e10;
                HMSLocationLog.m36660e("LocationClientImpl", tid, "enable background location api exception:" + e.getMessage());
            }
        }
        c8941i.m56657c(e);
        return c8941i.m56656b();
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: b */
    public Task<Location> mo33076b() {
        ApiException e10;
        C8941i c8941i = new C8941i();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, "get last location begin. Version Code = 61403300");
            m33085e();
            return doWrite(new C5728k("location.getLastLocation", JsonUtil.createJsonString(locationBaseRequest), locationBaseRequest.getTid(), ""));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", tid, "get last location api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, "get last location exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<HWLocation> mo33069a(LocationRequest locationRequest) {
        ApiException e10;
        C8941i c8941i = new C8941i();
        GetLastLocationRequest getLastLocationRequest = new GetLastLocationRequest(getContext(), locationRequest.getNeedAddress(), locationRequest.getLanguage(), locationRequest.getCountryCode());
        String tid = getLastLocationRequest.getTid();
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, "get last location begin. Version Code = 61403300");
            m33085e();
            m33083b(locationRequest);
            return doWrite(new C5725j("location.getLastLocation", JsonUtil.createJsonString(getLastLocationRequest), getLastLocationRequest.getTid(), "", locationRequest.getCoordinateType()));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", tid, "get last location with address api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, "get last location with address exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: b */
    public Task<Void> mo33077b(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return m33082a(locationRequest, locationCallback, looper, null, "ExCallback");
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<LocationAvailability> mo33064a() {
        ApiException e10;
        C8941i c8941i = new C8941i();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest(getContext());
        String tid = locationBaseRequest.getTid();
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, "get location availability begin");
            m33085e();
            return doWrite(new C5731l("location.getLocationAvailability", JsonUtil.createJsonString(locationBaseRequest), tid));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", tid, "getLocationAvailability ApiException:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, "getLocationAvailability exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<OfflineLocationResponse> mo33074a(OfflineLocationRequest offlineLocationRequest) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        if (offlineLocationRequest != null) {
            try {
                if (offlineLocationRequest.getRequestDataList() != null && !offlineLocationRequest.getRequestDataList().isEmpty()) {
                    String tid = offlineLocationRequest.getTid();
                    HMSLocationLog.m36662i("LocationClientImpl", tid, "getOfflineLocation begin. Version Code = 61403300");
                    m33085e();
                    return doWrite(new C5740o(LocationNaming.GET_OFFLINE_LOCATION_NAME, C9542g.m59588a().toJson(offlineLocationRequest), tid));
                }
            } catch (ApiException e11) {
                e10 = e11;
                HMSLocationLog.m36660e("LocationClientImpl", null, "getOfflineLocation api exception:" + e10.getMessage());
                c8941i.m56657c(e10);
                return c8941i.m56656b();
            } catch (Exception unused) {
                HMSLocationLog.m36660e("LocationClientImpl", null, "getOfflineLocation exception");
                e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                c8941i.m56657c(e10);
                return c8941i.m56656b();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    /* renamed from: a */
    private Task<Void> m33081a(LocationCallback locationCallback, PendingIntent pendingIntent, String str) {
        ApiException e10;
        C8941i c8941i = new C8941i();
        RemoveLocationUpdatesRequest removeLocationUpdatesRequest = new RemoveLocationUpdatesRequest(getContext());
        String tid = removeLocationUpdatesRequest.getTid();
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, str + " removeLocationUpdates  begin");
            return doWrite(LocationRequestHelper.createRemoveTaskApiCall(locationCallback, pendingIntent, str, tid, removeLocationUpdatesRequest));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", tid, str + " remove location updates api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, str + " remove location updates exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    /* renamed from: a */
    private Task<Void> m33082a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper, PendingIntent pendingIntent, String str) {
        C8941i c8941i = new C8941i();
        RequestLocationUpdatesRequest requestLocationUpdatesRequest = new RequestLocationUpdatesRequest(getContext());
        String tid = requestLocationUpdatesRequest.getTid();
        AbstractC5696b abstractC5696bCreateRequestApiCall = null;
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, str + " requestLocationUpdates begin");
            abstractC5696bCreateRequestApiCall = LocationRequestHelper.createRequestApiCall(str, locationRequest, locationCallback, looper, pendingIntent, requestLocationUpdatesRequest);
            abstractC5696bCreateRequestApiCall.m33038a(c8941i);
            return doWrite(abstractC5696bCreateRequestApiCall);
        } catch (ApiException e10) {
            if (abstractC5696bCreateRequestApiCall != null) {
                abstractC5696bCreateRequestApiCall.mo33039a(true);
            }
            HMSLocationLog.m36660e("LocationClientImpl", tid, str + " requestLocationUpdates api exception" + e10.getMessage());
            LocationRequestHelper.reportRequest(tid, e10.getStatusCode(), e10.getStatusMessage(), LocationRequestHelper.getCpTid(locationRequest));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, str + " requestLocationUpdates exception");
            if (abstractC5696bCreateRequestApiCall != null) {
                abstractC5696bCreateRequestApiCall.mo33039a(true);
            }
            LocationRequestHelper.reportRequest(tid, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(locationRequest));
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33066a(PendingIntent pendingIntent) {
        return m33081a((LocationCallback) null, pendingIntent, "Intent");
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33068a(LocationCallback locationCallback) {
        return m33081a(locationCallback, (PendingIntent) null, "NORMAL Callback");
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33070a(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return m33082a(locationRequest, null, null, pendingIntent, "Intent");
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33071a(LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return m33082a(locationRequest, locationCallback, looper, null, "NORMAL Callback");
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33073a(LogConfig logConfig) throws ApiException {
        ApiException e10;
        String string = UUID.randomUUID().toString();
        HMSLocationLog.m36662i("LocationClientImpl", string, "setLogConfig start");
        C8941i c8941i = new C8941i();
        try {
            if (logConfig == null) {
                throw new ApiException(new Status(LocationStatusCode.ARGUMENTS_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.ARGUMENTS_EMPTY)));
            }
            HMSLocationLog.m36662i("LocationClientImpl", string, "setLogConfig logConfig check");
            String logPath = logConfig.getLogPath();
            C11991a.m72147c(getContext());
            C5769x1.m33207a(getContext(), logPath, string);
            C5769x1.m33209b(getContext(), logPath, string);
            C1280g.m7592d(C5769x1.m33203a(logConfig));
            if (C5769x1.m33210b()) {
                C1280g.m7591c("LocationClientImpl", C5769x1.m33205a(getContext()), null);
            }
            return c8941i.m56656b();
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", string, "setLogConfig apiException");
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", string, "setLogConfig exception");
            e10 = new ApiException(new Status(LocationStatusCode.METHOD_INVOKE_ERROR, LocationStatusCode.getStatusCodeString(LocationStatusCode.METHOD_INVOKE_ERROR)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33067a(Location location) throws ApiException, JSONException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        SetMockLocationRequest setMockLocationRequest = new SetMockLocationRequest(getContext());
        String tid = setMockLocationRequest.getTid();
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, "set mock location begin");
            if (location == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            if (!PermissionUtil.isLocationPermissionAvailable(getContext()) || !PermissionUtil.canAccessMockLocation(getContext().getPackageName(), getContext())) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            setMockLocationRequest.setPackageName(getContext().getPackageName());
            setMockLocationRequest.setMockLocation(location);
            JSONObject jSONObjectCreateLocationJsonObject = LocationJsonUtil.createLocationJsonObject(setMockLocationRequest.getMockLocation());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FusedLocationProviderClient.KEY_MOCK_LOCATION, jSONObjectCreateLocationJsonObject);
            jSONObject.put("packageName", setMockLocationRequest.getPackageName());
            jSONObject.put("locTransactionId", setMockLocationRequest.getTid());
            return doWrite(new C5754s1("location.setMockLocation", jSONObject.toString(), tid));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", tid, "set mock location api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, "set mock location exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5709e0
    /* renamed from: a */
    public Task<Void> mo33075a(boolean z10) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        String tid = new LocationBaseRequest(getContext()).getTid();
        try {
            HMSLocationLog.m36662i("LocationClientImpl", tid, "set mock mode begin");
            if (!PermissionUtil.isLocationPermissionAvailable(getContext()) || !PermissionUtil.canAccessMockLocation(getContext().getPackageName(), getContext())) {
                HMSLocationLog.m36660e("LocationClientImpl", tid, "setMockEnabled,Permission is false ");
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            SetMockModeRequest setMockModeRequest = new SetMockModeRequest(getContext());
            setMockModeRequest.setMockMode(z10);
            return doWrite(new C5757t1("location.setMockMode", JsonUtil.createJsonString(setMockModeRequest), tid));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("LocationClientImpl", tid, "set mock mode api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("LocationClientImpl", tid, "set mock mode exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }
}
