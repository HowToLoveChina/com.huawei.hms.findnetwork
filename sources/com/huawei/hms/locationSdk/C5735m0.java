package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import as.C1016d;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.location.GetFromLocationNameRequest;
import com.huawei.hms.location.GetFromLocationRequest;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.geocoder.GeocoderRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import java.util.List;
import java.util.Locale;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.m0 */
/* loaded from: classes8.dex */
public class C5735m0 extends HuaweiApi<C5765w0> implements InterfaceC5729k0 {

    /* renamed from: c */
    private static final C5732l0 f25542c = new C5732l0();

    /* renamed from: d */
    private static final Api<C5765w0> f25543d = new Api<>("HmsLocation.API");

    /* renamed from: a */
    private InterfaceC5761v f25544a;

    /* renamed from: b */
    private Locale f25545b;

    public C5735m0(Activity activity, Locale locale, C5765w0 c5765w0) {
        super(activity, f25543d, c5765w0, (AbstractClientBuilder) f25542c);
        this.f25545b = locale;
    }

    /* renamed from: b */
    private boolean m33127b(GetFromLocationNameRequest getFromLocationNameRequest) {
        boolean z10 = getFromLocationNameRequest.getLowerLeftLatitude() < -90.0d || getFromLocationNameRequest.getLowerLeftLatitude() > 90.0d;
        boolean z11 = getFromLocationNameRequest.getLowerLeftLongitude() < -180.0d || getFromLocationNameRequest.getLowerLeftLongitude() > 180.0d;
        boolean z12 = getFromLocationNameRequest.getUpperRightLatitude() < -90.0d || getFromLocationNameRequest.getUpperRightLatitude() > 90.0d;
        if (!z10 && !z11 && !z12) {
            boolean z13 = getFromLocationNameRequest.getUpperRightLongitude() < -180.0d || getFromLocationNameRequest.getUpperRightLongitude() > 180.0d;
            boolean z14 = getFromLocationNameRequest.getMaxResults() < 0;
            if (!z13 && !z14) {
                return false;
            }
        }
        return true;
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5729k0
    /* renamed from: a */
    public Task<List<HWLocation>> mo33110a(GetFromLocationRequest getFromLocationRequest) {
        ApiException apiException;
        C8941i c8941i = new C8941i();
        if (getFromLocationRequest == null) {
            apiException = new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        } else if (m33128b(getFromLocationRequest)) {
            apiException = new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        } else {
            C1016d.m6186f("LocationGeocoderClientImpl", "getFromLocation checkParams success");
            GeocoderRequest geocoderRequest = new GeocoderRequest(getContext(), getFromLocationRequest.getLatitude(), getFromLocationRequest.getLongitude(), getFromLocationRequest.getMaxResults());
            Locale locale = this.f25545b;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            geocoderRequest.setLanguage(locale.getLanguage());
            Locale locale2 = this.f25545b;
            if (locale2 == null) {
                locale2 = Locale.getDefault();
            }
            geocoderRequest.setCountry(locale2.getCountry());
            String tid = geocoderRequest.getTid();
            try {
                HMSLocationLog.m36662i("LocationGeocoderClientImpl", tid, "getFromLocation begin. Version Code = 61403300");
                return doWrite(new C5719h(getContext(), LocationNaming.GET_FROM_LOCATION, JsonUtil.createJsonString(geocoderRequest), geocoderRequest.getTid(), ""));
            } catch (Exception unused) {
                HMSLocationLog.m36660e("LocationGeocoderClientImpl", tid, "getFromLocation exception");
                apiException = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
        }
        c8941i.m56657c(apiException);
        return c8941i.m56656b();
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        InterfaceC5761v interfaceC5761v;
        if (this.f25544a == null) {
            Object objM33213a = C5770y.m33213a(getContext(), new C5773z());
            if (objM33213a instanceof InterfaceC5761v) {
                this.f25544a = (InterfaceC5761v) objM33213a;
            }
        }
        return (C5773z.m33216a(getContext()) || (interfaceC5761v = this.f25544a) == null) ? super.doWrite(taskApiCall) : interfaceC5761v.mo33178a(this, taskApiCall, f25542c);
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getApiLevel() {
        return 5;
    }

    @Override // com.huawei.hms.common.HuaweiApi
    public int getKitSdkVersion() {
        return 61403300;
    }

    public C5735m0(Context context, Locale locale, C5765w0 c5765w0) {
        super(context, f25543d, c5765w0, f25542c);
        this.f25545b = locale;
    }

    /* renamed from: b */
    private boolean m33128b(GetFromLocationRequest getFromLocationRequest) {
        boolean z10 = getFromLocationRequest.getLatitude() < -90.0d || getFromLocationRequest.getLatitude() > 90.0d;
        boolean z11 = getFromLocationRequest.getLongitude() < -180.0d || getFromLocationRequest.getLongitude() > 180.0d;
        boolean z12 = getFromLocationRequest.getMaxResults() < 0;
        C1016d.m6186f("LocationGeocoderClientImpl", "isValidReversesRequest latitudeState = " + z10 + ",longitudeState = " + z11 + ",maxState = " + z12);
        return z10 || z11 || z12;
    }

    @Override // com.huawei.hms.locationSdk.InterfaceC5729k0
    /* renamed from: a */
    public Task<List<HWLocation>> mo33109a(GetFromLocationNameRequest getFromLocationNameRequest) {
        ApiException apiException;
        C8941i c8941i = new C8941i();
        if (getFromLocationNameRequest == null || getFromLocationNameRequest.getLocationName() == null || getFromLocationNameRequest.getLocationName().isEmpty()) {
            apiException = new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        } else if (m33127b(getFromLocationNameRequest)) {
            apiException = new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        } else {
            C1016d.m6186f("LocationGeocoderClientImpl", "getFromLocationName checkParams success");
            GeocoderRequest geocoderRequest = new GeocoderRequest(getContext(), getFromLocationNameRequest.getLocationName(), getFromLocationNameRequest.getMaxResults());
            geocoderRequest.setLowerLeftLatitude(getFromLocationNameRequest.getLowerLeftLatitude());
            geocoderRequest.setLowerLeftLongitude(getFromLocationNameRequest.getLowerLeftLongitude());
            geocoderRequest.setUpperRightLatitude(getFromLocationNameRequest.getUpperRightLatitude());
            geocoderRequest.setUpperRightLongitude(getFromLocationNameRequest.getUpperRightLongitude());
            Locale locale = this.f25545b;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            geocoderRequest.setLanguage(locale.getLanguage());
            Locale locale2 = this.f25545b;
            if (locale2 == null) {
                locale2 = Locale.getDefault();
            }
            geocoderRequest.setCountry(locale2.getCountry());
            String tid = geocoderRequest.getTid();
            try {
                HMSLocationLog.m36662i("LocationGeocoderClientImpl", tid, "getFromLocationName begin. Version Code = 61403300");
                return doWrite(new C5716g(getContext(), LocationNaming.GET_FROM_LOCATION_NAME, JsonUtil.createJsonString(geocoderRequest), geocoderRequest.getTid(), ""));
            } catch (Exception unused) {
                HMSLocationLog.m36660e("LocationGeocoderClientImpl", tid, "getFromLocationName exception");
                apiException = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
        }
        c8941i.m56657c(apiException);
        return c8941i.m56656b();
    }
}
