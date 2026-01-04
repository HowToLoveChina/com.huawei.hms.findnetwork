package com.huawei.hms.support.api.entity.location.updates;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;

/* loaded from: classes8.dex */
public class RequestLocationUpdatesResponse extends LocationBaseResponse {

    @Packed
    private LocationAvailability locationAvailability;

    @Packed
    private LocationResult locationResult;

    public LocationAvailability getLocationAvailability() {
        return this.locationAvailability;
    }

    public LocationResult getLocationResult() {
        return this.locationResult;
    }

    public void setLocationAvailability(LocationAvailability locationAvailability) {
        this.locationAvailability = locationAvailability;
    }

    public void setLocationResult(LocationResult locationResult) {
        this.locationResult = locationResult;
    }
}
