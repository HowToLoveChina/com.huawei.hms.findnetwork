package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import android.os.Parcelable;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.LocationSettingsResult;
import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.hms.support.feature.result.AccountPickerCommonConstant;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.c */
/* loaded from: classes8.dex */
public class C5700c extends AbstractC5696b<C5750r0, LocationSettingsResponse> {
    public C5700c(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException, JSONException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<LocationSettingsResponse>) c8941i);
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<LocationSettingsResponse> c8941i) throws ApiException, JSONException {
        LocationSettingsResponse locationSettingsResponse;
        Status status;
        try {
            HMSLocationLog.m36662i("CheckLocationSettingsTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            Status status2 = null;
            LocationSettingsStates locationSettingsStates = null;
            if (responseErrorCode.getErrorCode() == 0) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("statusCheck")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("statusCheck");
                    Parcelable parcelable = responseErrorCode.getParcelable();
                    status = new Status(jSONObject2.has("statusCode") ? jSONObject2.getInt("statusCode") : -100, jSONObject2.has(AccountPickerCommonConstant.KEY_STATUS_MESSAGE) ? jSONObject2.getString(AccountPickerCommonConstant.KEY_STATUS_MESSAGE) : "", (parcelable == null || !(parcelable instanceof PendingIntent)) ? null : (PendingIntent) parcelable);
                } else {
                    status = null;
                }
                if (jSONObject.has("locationSettingsStates")) {
                    locationSettingsStates = new LocationSettingsStates();
                    JsonUtil.jsonToEntity(jSONObject.getJSONObject("locationSettingsStates").toString(), locationSettingsStates);
                    locationSettingsStates.setGnssPresent(locationSettingsStates.isGpsPresent());
                    locationSettingsStates.setGnssUsable(locationSettingsStates.isGpsUsable());
                }
                LocationSettingsResult locationSettingsResult = new LocationSettingsResult();
                locationSettingsResult.setLocationSettingsStates(locationSettingsStates);
                locationSettingsResult.setStatus(status);
                locationSettingsResponse = new LocationSettingsResponse(locationSettingsResult);
                status2 = status;
            } else {
                locationSettingsResponse = null;
            }
            if (status2 == null || status2.getStatusCode() != 6) {
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, locationSettingsResponse);
            } else {
                c8941i.m56657c(new ResolvableApiException(status2));
            }
        } catch (Exception unused) {
            HMSLocationLog.m36660e("CheckLocationSettingsTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
