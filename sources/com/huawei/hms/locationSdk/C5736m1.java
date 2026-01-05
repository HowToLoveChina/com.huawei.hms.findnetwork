package com.huawei.hms.locationSdk;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import as.C1016d;
import bs.C1280g;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationClientStateManager;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.LocationRequestHelper;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.riemann.location.common.utils.Constant;
import es.C9540e;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;
import p208cq.InterfaceC8934b;
import p295fs.C9768b;
import p295fs.C9769c;
import p531or.C11991a;

/* renamed from: com.huawei.hms.locationSdk.m1 */
/* loaded from: classes8.dex */
public class C5736m1 extends AbstractC5696b<C5750r0, Void> {

    /* renamed from: d */
    protected C5733l1 f25546d;

    /* renamed from: e */
    private Location f25547e;

    /* renamed from: f */
    private boolean f25548f;

    /* renamed from: g */
    protected Handler f25549g;

    /* renamed from: com.huawei.hms.locationSdk.m1$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            C5736m1.this.m33137a(message);
        }
    }

    public C5736m1(String str, String str2, String str3, C5733l1 c5733l1, Looper looper, String str4) throws ApiException {
        super(str, str2, str3, str4);
        this.f25548f = false;
        this.f25546d = c5733l1;
        if (looper == null) {
            throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        }
        a aVar = new a(looper);
        this.f25549g = aVar;
        aVar.sendEmptyMessageDelayed(3, 10000L);
    }

    /* renamed from: a */
    public void m33138a(LocationResult locationResult) {
        String strMo33104a;
        String str;
        String str2;
        String strMo33104a2;
        String str3;
        String str4;
        if (locationResult == null) {
            strMo33104a2 = mo33104a();
            str3 = ((AbstractC5696b) this).f25484a;
            str4 = "locationResult is null";
        } else {
            LocationRequest locationRequestM33122d = this.f25546d.m33122d();
            if (locationRequestM33122d == null) {
                strMo33104a2 = mo33104a();
                str3 = ((AbstractC5696b) this).f25484a;
                str4 = "locationRequest is null";
            } else {
                List<HWLocation> hWLocationList = locationResult.getHWLocationList();
                if (!hWLocationList.isEmpty()) {
                    if (1 != locationRequestM33122d.getCoordinateType()) {
                        if (locationRequestM33122d.getCoordinateType() == 0) {
                            C1016d.m6181a(mo33104a(), "ConvertCoord-- current coordinateType is 0 --no conversion");
                            return;
                        } else {
                            HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "ConvertCoord-- current coordinateType is unKnown --return 84");
                            return;
                        }
                    }
                    try {
                        for (HWLocation hWLocation : hWLocationList) {
                            Map<String, Object> extraInfo = hWLocation.getExtraInfo();
                            if (extraInfo != null && extraInfo.containsKey(Constant.LOCATION_SOURCE_TYPE) && m33040a(((Integer) extraInfo.get(Constant.LOCATION_SOURCE_TYPE)).intValue())) {
                                HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "RTK position, no conversion required");
                            } else {
                                C9769c c9769cM60797a = C9768b.m60797a(hWLocation.getLatitude(), hWLocation.getLongitude(), 1);
                                if (c9769cM60797a != null) {
                                    hWLocation.setCoordinateType(1);
                                    hWLocation.setLatitude(c9769cM60797a.m60801a());
                                    hWLocation.setLongitude(c9769cM60797a.m60802b());
                                } else {
                                    hWLocation.setCoordinateType(0);
                                    HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "ConvertCoord-- result is null,reset the coordinateType to 0");
                                }
                            }
                        }
                        return;
                    } catch (ClassCastException unused) {
                        strMo33104a = mo33104a();
                        str = ((AbstractC5696b) this).f25484a;
                        str2 = "convertCoord ClassCastException:";
                        HMSLocationLog.m36660e(strMo33104a, str, str2);
                        return;
                    } catch (Exception unused2) {
                        strMo33104a = mo33104a();
                        str = ((AbstractC5696b) this).f25484a;
                        str2 = "convertCoord Exception";
                        HMSLocationLog.m36660e(strMo33104a, str, str2);
                        return;
                    }
                }
                strMo33104a2 = mo33104a();
                str3 = ((AbstractC5696b) this).f25484a;
                str4 = "hwLocationList is empty";
            }
        }
        HMSLocationLog.m36660e(strMo33104a2, str3, str4);
    }

    /* renamed from: b */
    public void mo33116b(boolean z10) {
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<Void>) c8941i);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m33134c(LocationResult locationResult) {
        C5705d0.m33051b().m33060b(locationResult.getLastHWLocation());
    }

    /* renamed from: a */
    public String mo33104a() {
        return "RequestLocationUpdatesTaskApiCall";
    }

    /* renamed from: b */
    public void mo33105b(final LocationResult locationResult) {
        if (locationResult == null || locationResult.getLastHWLocation() == null) {
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "locationResult is null or locationResult.getLastHWLocation is null");
            return;
        }
        C9540e.m59581d().m59582a(new Runnable() { // from class: com.huawei.hms.locationSdk.a2
            @Override // java.lang.Runnable
            public final void run() {
                C5736m1.m33134c(locationResult);
            }
        });
        m33138a(locationResult);
        this.f25546d.m33121c().onLocationResult(locationResult);
    }

    /* renamed from: d */
    public void m33139d(LocationResult locationResult) {
        HWLocation lastHWLocation;
        Location lastLocation;
        Map<String, Object> extraInfo;
        if (locationResult == null || (lastHWLocation = locationResult.getLastHWLocation()) == null || (lastLocation = locationResult.getLastLocation()) == null || (extraInfo = lastHWLocation.getExtraInfo()) == null) {
            return;
        }
        Location location = this.f25547e;
        float fDistanceTo = location != null ? lastLocation.distanceTo(location) : -1.0f;
        String strMo33104a = mo33104a();
        String str = ((AbstractC5696b) this).f25484a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("log location info, SourceType: ");
        sb2.append(extraInfo.containsKey(Constant.LOCATION_SOURCE_TYPE) ? extraInfo.get(Constant.LOCATION_SOURCE_TYPE) : -1);
        sb2.append(", provider: ");
        sb2.append(lastHWLocation.getProvider());
        sb2.append(", acc: ");
        sb2.append(lastHWLocation.getAccuracy());
        sb2.append(", bearing: ");
        sb2.append(lastHWLocation.getBearing());
        sb2.append(", speed: ");
        sb2.append(lastHWLocation.getSpeed());
        sb2.append(", positionType: ");
        sb2.append(extraInfo.containsKey("positionType") ? extraInfo.get("positionType") : -1);
        sb2.append(", tripId: ");
        sb2.append(extraInfo.containsKey("tripId") ? extraInfo.get("tripId") : "");
        sb2.append(", requestId: ");
        sb2.append(extraInfo.containsKey("session_id") ? extraInfo.get("session_id") : "");
        sb2.append(", vendorType: ");
        sb2.append(extraInfo.containsKey("vendorType") ? extraInfo.get("vendorType") : "");
        sb2.append(",distanceToPrev:");
        sb2.append(fDistanceTo);
        sb2.append(", locationSource:");
        sb2.append(extraInfo.containsKey("LocationSource") ? extraInfo.get("LocationSource") : "");
        HMSLocationLog.m36662i(strMo33104a, str, sb2.toString());
        this.f25547e = lastLocation;
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<Void> c8941i) throws ApiException {
        HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "doExecute");
        try {
            mo33039a(true);
            if (responseErrorCode == null) {
                C5768x0.m33197b().mo33194c(this.f25546d);
                LocationRequestHelper.reportRequest(((AbstractC5696b) this).f25484a, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(this.f25546d.m33122d()));
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getStatusCode() == 0 && responseErrorCode.getErrorCode() == 0) {
                JSONObject jSONObject = new JSONObject(str);
                C5733l1 c5733l1 = this.f25546d;
                if (c5733l1 != null && c5733l1.m33122d() != null && this.f25546d.m33121c() != null) {
                    if (jSONObject.has("locationResult")) {
                        m33130a(c5750r0, jSONObject);
                        return;
                    } else if (jSONObject.has("locationAvailability")) {
                        m33131a(str);
                        return;
                    } else {
                        C5768x0.m33197b().mo33195d(this.f25546d);
                        LocationRequestHelper.reportRequest(((AbstractC5696b) this).f25484a, responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), LocationRequestHelper.getCpTid(this.f25546d.m33122d()));
                        mo33116b(true);
                    }
                }
                LocationRequestHelper.reportRequest(((AbstractC5696b) this).f25484a, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(this.f25546d.m33122d()));
                HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "INTERNAL_ERROR : doExecute requestLocationUpdatesCache is null");
                return;
            }
            Map<String, String> extras = this.f25546d.m33122d().getExtras();
            if (extras != null && TextUtils.equals(extras.get(LocationClientStateManager.IS_RE_REQUEST), "1")) {
                HMSLocationLog.m36663w(mo33104a(), ((AbstractC5696b) this).f25484a, "is re request,not remove");
                return;
            }
            C5768x0.m33197b().mo33194c(this.f25546d);
            if ((responseErrorCode.getErrorCode() < 10000 || responseErrorCode.getErrorCode() > 20000 || responseErrorCode.getErrorCode() == 10102) && C5773z.m33216a(c5750r0.getContext())) {
                C5773z.m33214a(true);
                this.f25548f = true;
                final LocationClientImpl LocationClientImpl = new LocationClientImpl(c5750r0.getContext(), (C5765w0) null);
                c8941i.m56656b().continueWithTask(new InterfaceC8934b() { // from class: com.huawei.hms.locationSdk.b2
                    @Override // p208cq.InterfaceC8934b
                    /* renamed from: a */
                    public final Object mo33041a(Task task) {
                        return C5736m1.m33129a(LocationClientImpl, this, task);
                    }
                });
                c8941i.m56658d(null);
            } else {
                LocationRequestHelper.reportRequest(((AbstractC5696b) this).f25484a, responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason(), LocationRequestHelper.getCpTid(this.f25546d.m33122d()));
            }
            if (this.f25548f) {
                return;
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, null);
        } catch (ApiException e10) {
            C5768x0.m33197b().mo33194c(this.f25546d);
            LocationRequestHelper.reportRequest(((AbstractC5696b) this).f25484a, e10.getStatusCode(), e10.getStatusMessage(), LocationRequestHelper.getCpTid(this.f25546d.m33122d()));
            mo33116b(false);
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "request location doExecute exception:" + e10.getMessage());
            c8941i.m56657c(e10);
        } catch (Exception unused) {
            C5768x0.m33197b().mo33194c(this.f25546d);
            LocationRequestHelper.reportRequest(((AbstractC5696b) this).f25484a, 10000, LocationStatusCode.getStatusCodeString(10000), LocationRequestHelper.getCpTid(this.f25546d.m33122d()));
            mo33116b(false);
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "request location doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ Task m33132b(LocationClientImpl LocationClientImpl, TaskApiCall taskApiCall, Task task) throws Exception {
        return LocationClientImpl.doWrite(taskApiCall);
    }

    /* renamed from: a */
    public void m33137a(Message message) {
        HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "handleOnResultMessage code:" + message.what);
        try {
            int i10 = message.what;
            if (i10 == 1) {
                Object obj = message.obj;
                if (obj instanceof LocationResult) {
                    mo33105b((LocationResult) obj);
                    return;
                }
                return;
            }
            if (i10 == 2) {
                Object obj2 = message.obj;
                if (obj2 instanceof LocationAvailability) {
                    LocationAvailability locationAvailability = (LocationAvailability) obj2;
                    HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "getLocationStatus:" + locationAvailability.getLocationStatus());
                    this.f25546d.m33121c().onLocationAvailability(locationAvailability);
                    return;
                }
                return;
            }
            if (i10 != 3) {
                return;
            }
            if (!C5773z.m33216a(C11991a.m72145a()) || ((AbstractC5696b) this).f25486c == null) {
                HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "request time out,report and remove");
                C5768x0.m33197b().mo33194c(this.f25546d);
            } else {
                HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "request time out re send");
                C5768x0.m33197b().mo33194c(this.f25546d);
                C5773z.m33214a(true);
                this.f25548f = true;
                final LocationClientImpl LocationClientImpl = new LocationClientImpl(C11991a.m72145a(), (C5765w0) null);
                ((AbstractC5696b) this).f25486c.m56656b().continueWithTask(new InterfaceC8934b() { // from class: com.huawei.hms.locationSdk.z1
                    @Override // p208cq.InterfaceC8934b
                    /* renamed from: a */
                    public final Object mo33041a(Task task) {
                        return C5736m1.m33132b(LocationClientImpl, this, task);
                    }
                });
                ((AbstractC5696b) this).f25486c.m56658d(null);
            }
            LocationRequestHelper.reportRequest(((AbstractC5696b) this).f25484a, 10811, "REQUEST_GET_RESULT_TIME_OUT", LocationRequestHelper.getCpTid(this.f25546d.m33122d()));
        } catch (Exception e10) {
            HMSLocationLog.m36660e(mo33104a(), ((AbstractC5696b) this).f25484a, "handleOnResultMessage exception:" + e10.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ Task m33129a(LocationClientImpl LocationClientImpl, TaskApiCall taskApiCall, Task task) throws Exception {
        return LocationClientImpl.doWrite(taskApiCall);
    }

    /* renamed from: a */
    private void m33131a(String str) throws JSONException {
        LocationAvailability locationAvailabilityFromString = LocationJsonUtil.parseLocationAvailabilityFromString(str);
        HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "doExecute onLocationAvailability");
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = locationAvailabilityFromString;
        this.f25549g.sendMessage(messageObtain);
    }

    /* renamed from: a */
    private void m33130a(C5750r0 c5750r0, JSONObject jSONObject) throws ApiException, JSONException, IllegalArgumentException {
        HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "doExecute onLocationResult");
        LocationResult locationResultFromJsonObject = LocationJsonUtil.parseLocationResultFromJsonObject(jSONObject);
        int iM33125g = this.f25546d.m33125g();
        int size = locationResultFromJsonObject.getLocations().size();
        HMSLocationLog.m36662i(mo33104a(), ((AbstractC5696b) this).f25484a, "modify numUpdates with callback, numUpdates:" + iM33125g + " , locationSize:" + size);
        m33139d(locationResultFromJsonObject);
        if (iM33125g <= 0 || iM33125g < size) {
            C5758u.m33173b(c5750r0.getContext(), (C5765w0) null).mo33068a(this.f25546d.m33121c());
            return;
        }
        if (iM33125g == size) {
            C5758u.m33173b(c5750r0.getContext(), (C5765w0) null).mo33068a(this.f25546d.m33121c());
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = locationResultFromJsonObject;
        this.f25549g.sendMessage(messageObtain);
        if (C5769x1.m33210b()) {
            C1280g.m7593e(C5769x1.m33206a(((AbstractC5696b) this).f25484a, locationResultFromJsonObject), C5769x1.m33210b());
        }
        int i10 = iM33125g - size;
        this.f25546d.m33117a(i10);
        C5768x0.m33197b().m33201a(this.f25546d, i10);
    }

    @Override // com.huawei.hms.locationSdk.AbstractC5696b
    /* renamed from: a */
    public void mo33039a(boolean z10) {
        super.mo33039a(z10);
        this.f25549g.removeMessages(3);
    }
}
