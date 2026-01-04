package com.huawei.location;

import as.C1016d;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.hms.support.api.entity.location.locationavailability.GetLocationAvailabilityResponse;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import is.C10606c;
import p854zs.C14375d;

/* loaded from: classes8.dex */
public class GetAvailabilityTaskCall extends BaseApiRequest {
    private static final String TAG = "GetLocationAvailabilityApi";

    @Override // com.huawei.location.router.interfaces.IRouterRequest
    public void onRequest(String str) {
        C1016d.m6186f(TAG, "onRequest GetAvailabilityTaskCall");
        C10606c.m65019d().getClass();
        LocationAvailability locationAvailability = new LocationAvailability();
        if (C10606c.m65018b() != null) {
            C1016d.m6186f("HwLocationManager", "get last location successful");
            locationAvailability.setLocationStatus(0);
        } else {
            C1016d.m6183c("HwLocationManager", "get last location failed");
            locationAvailability.setLocationStatus(1001);
        }
        StatusInfo statusInfo = new StatusInfo(0, 0, "");
        GetLocationAvailabilityResponse getLocationAvailabilityResponse = new GetLocationAvailabilityResponse();
        LocationBaseRequest locationBaseRequest = new LocationBaseRequest();
        C14375d.m85589b(str, locationBaseRequest);
        getLocationAvailabilityResponse.setLocationAvailability(locationAvailability);
        doExecute(new RouterResponse(C14375d.m85591d(getLocationAvailabilityResponse), statusInfo));
        this.errorCode = String.valueOf(0);
        this.reportBuilder.m85578d("Location_getLocationAvailability");
        this.reportBuilder.m85581g(locationBaseRequest);
        this.reportBuilder.m85579e().m85574b(this.errorCode);
    }
}
