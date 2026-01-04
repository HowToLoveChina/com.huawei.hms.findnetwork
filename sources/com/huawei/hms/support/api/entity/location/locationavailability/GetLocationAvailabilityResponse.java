package com.huawei.hms.support.api.entity.location.locationavailability;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;

/* loaded from: classes8.dex */
public class GetLocationAvailabilityResponse extends LocationBaseResponse {

    @Packed
    private LocationAvailability locationAvailability;

    public LocationAvailability getLocationAvailability() {
        return this.locationAvailability;
    }

    public void setLocationAvailability(LocationAvailability locationAvailability) {
        this.locationAvailability = locationAvailability;
    }
}
