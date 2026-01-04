package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.LocationSceneRequest;
import com.huawei.hms.location.LocationSceneResponse;
import com.huawei.hms.location.NavigationRequest;
import com.huawei.hms.location.NavigationResult;
import com.huawei.hms.location.RoadData;
import com.huawei.hms.location.RoadDataResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.enhance.LocationSceneApiRequest;
import com.huawei.hms.support.api.entity.location.enhance.RequestNavigationStateRequest;
import com.huawei.hms.support.api.entity.location.enhance.RequestReportLocationRequest;
import com.huawei.hms.support.api.entity.location.enhance.RoadDataRequest;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineRequest;
import com.huawei.hms.support.api.entity.location.stationrecognition.CityStationLineResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoRequest;
import com.huawei.hms.support.api.entity.location.stationrecognition.HistoryStationInfoResponse;
import com.huawei.hms.support.api.entity.location.stationrecognition.StationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.PermissionUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.openalliance.p169ad.p171db.bean.SdkCfgSha256Record;
import es.C9542g;
import es.C9553r;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.j0 */
/* loaded from: classes8.dex */
public class C5726j0 extends HuaweiApi<C5765w0> implements InterfaceC5720h0 {

    /* renamed from: b */
    private static final C5723i0 f25525b = new C5723i0();

    /* renamed from: c */
    private static final Api<C5765w0> f25526c = new Api<>("HmsLocation.API");

    /* renamed from: a */
    private InterfaceC5761v f25527a;

    public C5726j0(Activity activity, C5765w0 c5765w0) {
        super(activity, f25526c, c5765w0, (AbstractClientBuilder) f25525b);
    }

    /* renamed from: a */
    private void m33107a() throws ApiException {
        if (!PermissionUtil.isPermissionAvailable(getContext(), "android.permission.ACCESS_COARSE_LOCATION") && !PermissionUtil.isPermissionAvailable(getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: b */
    public Task<HistoryStationInfoResponse> mo33094b(String str) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        HistoryStationInfoRequest historyStationInfoRequest = new HistoryStationInfoRequest(getContext());
        String tid = historyStationInfoRequest.getTid();
        try {
            if (TextUtils.isEmpty(str)) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            m33107a();
            historyStationInfoRequest.setTripId(str);
            return doWrite(new C5722i(LocationNaming.GET_HISTORY_STATION_INFO, C9542g.m59588a().toJson(historyStationInfoRequest), historyStationInfoRequest.getTid()));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "getHistoryStationInfo api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "getHistoryStationInfo exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        InterfaceC5761v interfaceC5761v;
        if (this.f25527a == null) {
            Object objM33213a = C5770y.m33213a(getContext(), new C5773z());
            if (objM33213a instanceof InterfaceC5761v) {
                this.f25527a = (InterfaceC5761v) objM33213a;
            }
        }
        return (C5773z.m33216a(getContext()) || (interfaceC5761v = this.f25527a) == null) ? super.doWrite(taskApiCall) : interfaceC5761v.mo33178a(this, taskApiCall, f25525b);
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 2;
    }

    public C5726j0(Context context, C5765w0 c5765w0) {
        super(context, f25526c, c5765w0, f25525b);
    }

    /* renamed from: a */
    private void m33108a(StationRequest stationRequest) throws ApiException {
        if (stationRequest == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(stationRequest.getAppId());
        arrayList.add(stationRequest.getProjectId());
        arrayList.add(stationRequest.getPkgName());
        arrayList.add(stationRequest.getType());
        arrayList.add(stationRequest.getOperation());
        if (C9553r.m59644a(arrayList)) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: b */
    public Task<LocationSceneResponse> mo33093b(LocationSceneRequest locationSceneRequest) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        LocationSceneApiRequest locationSceneApiRequest = new LocationSceneApiRequest(getContext());
        String tid = locationSceneApiRequest.getTid();
        try {
            if (locationSceneRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            locationSceneApiRequest.setLocationSceneRequest(locationSceneRequest);
            return doWrite(new C5751r1(LocationNaming.SET_LOCATION_SCENE_MODE, C9542g.m59588a().toJson(locationSceneApiRequest), locationSceneApiRequest.getTid()));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "setLocationSceneMode api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "setLocationSceneMode exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: a */
    public Task<LocationSceneResponse> mo33088a(LocationSceneRequest locationSceneRequest) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        LocationSceneApiRequest locationSceneApiRequest = new LocationSceneApiRequest(getContext());
        String tid = locationSceneApiRequest.getTid();
        try {
            if (locationSceneRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            locationSceneApiRequest.setLocationSceneRequest(locationSceneRequest);
            return doWrite(new C5734m(LocationNaming.GET_LOCATION_SCENE_RESPONSE, C9542g.m59588a().toJson(locationSceneApiRequest), locationSceneApiRequest.getTid()));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "setLocationSceneMode api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "setLocationSceneMode exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: a */
    public Task<NavigationResult> mo33089a(NavigationRequest navigationRequest) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        RequestNavigationStateRequest requestNavigationStateRequest = new RequestNavigationStateRequest(getContext());
        String tid = requestNavigationStateRequest.getTid();
        try {
            if (navigationRequest == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            if (!PermissionUtil.isLocationPermissionAvailable(getContext())) {
                throw new ApiException(new Status(10803, LocationStatusCode.getStatusCodeString(10803)));
            }
            requestNavigationStateRequest.setNavigationRequest(navigationRequest);
            return doWrite(new C5737n("location.getNavigationContextState", JsonUtil.createJsonString(requestNavigationStateRequest), requestNavigationStateRequest.getTid(), navigationRequest.getType()));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "getNavigationState api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "getNavigationState exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: a */
    public Task<CityStationLineResponse> mo33092a(String str, String str2) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        CityStationLineRequest cityStationLineRequest = new CityStationLineRequest(getContext());
        String tid = cityStationLineRequest.getTid();
        try {
            if (TextUtils.isEmpty(str)) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            m33107a();
            cityStationLineRequest.setCityCode(str);
            if (!TextUtils.isEmpty(str2)) {
                cityStationLineRequest.setStationType(str2);
            }
            return doWrite(new C5743p(LocationNaming.GET_STATION_LINE, C9542g.m59588a().toJson(cityStationLineRequest), cityStationLineRequest.getTid()));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "getStationLines api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "getStationLines exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: a */
    public Task<Void> mo33087a(Location location, String str) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        RequestReportLocationRequest requestReportLocationRequest = new RequestReportLocationRequest(getContext());
        String tid = requestReportLocationRequest.getTid();
        if (location != null && str != null) {
            try {
                if (!str.equals("")) {
                    requestReportLocationRequest.setReportType(str);
                    C5742o1 c5742o1 = new C5742o1("location.requestReportLocation", JsonUtil.createJsonString(requestReportLocationRequest), tid);
                    c5742o1.setParcelable(location);
                    return doWrite(c5742o1);
                }
            } catch (ApiException e11) {
                e10 = e11;
                HMSLocationLog.m36660e("EnhanceClientImpl", tid, "requestReportLocation api exception:" + e10.getMessage());
                c8941i.m56657c(e10);
                return c8941i.m56656b();
            } catch (Exception unused) {
                HMSLocationLog.m36660e("EnhanceClientImpl", tid, "requestReportLocation exception");
                e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                c8941i.m56657c(e10);
                return c8941i.m56656b();
            }
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: a */
    public Task<Void> mo33091a(String str) throws ApiException, JSONException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        String string = UUID.randomUUID().toString();
        try {
            if (C9553r.m59645b(str)) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            m33108a((StationRequest) C9542g.m59588a().fromJson(str, StationRequest.class));
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(SdkCfgSha256Record.PKGNAME)) {
                String string2 = jSONObject.getString(SdkCfgSha256Record.PKGNAME);
                jSONObject.remove(SdkCfgSha256Record.PKGNAME);
                jSONObject.put("packageName", string2);
            }
            m33107a();
            return doWrite(new C5745p1(LocationNaming.REQUEST_STATION_NAME, jSONObject.toString(), string));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("EnhanceClientImpl", string, "requestStationRecognition api exception" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (JSONException unused) {
            HMSLocationLog.m36660e("EnhanceClientImpl", string, "requestStationRecognition JSONException");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused2) {
            HMSLocationLog.m36660e("EnhanceClientImpl", string, "requestStationRecognition exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5720h0
    /* renamed from: a */
    public Task<RoadDataResult> mo33090a(RoadData roadData) throws ApiException {
        ApiException e10;
        C8941i c8941i = new C8941i();
        RoadDataRequest roadDataRequest = new RoadDataRequest(getContext());
        String tid = roadDataRequest.getTid();
        try {
            if (roadData == null) {
                throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
            }
            roadDataRequest.setRoadData(roadData);
            return doWrite(new C5760u1(LocationNaming.SET_ROAD_DATA, C9542g.m59588a().toJson(roadDataRequest), roadDataRequest.getTid()));
        } catch (ApiException e11) {
            e10 = e11;
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "setRoadData api exception:" + e10.getMessage());
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        } catch (Exception unused) {
            HMSLocationLog.m36660e("EnhanceClientImpl", tid, "setRoadData exception");
            e10 = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            c8941i.m56657c(e10);
            return c8941i.m56656b();
        }
    }
}
