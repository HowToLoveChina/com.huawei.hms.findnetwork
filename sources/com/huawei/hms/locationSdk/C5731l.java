package com.huawei.hms.locationSdk;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.locationavailability.GetLocationAvailabilityResponse;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.hms.utils.JsonUtil;
import p208cq.C8941i;

/* renamed from: com.huawei.hms.locationSdk.l */
/* loaded from: classes8.dex */
public class C5731l extends AbstractC5696b<C5750r0, LocationAvailability> {
    public C5731l(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public /* bridge */ /* synthetic */ void doExecute(AnyClient anyClient, ResponseErrorCode responseErrorCode, String str, C8941i c8941i) throws ApiException {
        doExecute((C5750r0) anyClient, responseErrorCode, str, (C8941i<LocationAvailability>) c8941i);
    }

    public void doExecute(C5750r0 c5750r0, ResponseErrorCode responseErrorCode, String str, C8941i<LocationAvailability> c8941i) throws ApiException {
        LocationAvailability locationAvailability;
        try {
            HMSLocationLog.m36662i("GetLocationAvailabilityTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute");
            if (responseErrorCode == null) {
                throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
            if (responseErrorCode.getErrorCode() == 0) {
                GetLocationAvailabilityResponse getLocationAvailabilityResponse = new GetLocationAvailabilityResponse();
                JsonUtil.jsonToEntity(str, getLocationAvailabilityResponse);
                locationAvailability = getLocationAvailabilityResponse.getLocationAvailability();
            } else {
                locationAvailability = null;
            }
            ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(c8941i, responseErrorCode, locationAvailability);
        } catch (Exception unused) {
            HMSLocationLog.m36660e("GetLocationAvailabilityTaskApiCall", ((AbstractC5696b) this).f25484a, "doExecute exception");
            c8941i.m56657c(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }
}
