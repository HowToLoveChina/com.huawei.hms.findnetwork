package com.huawei.hms.location;

import com.huawei.hms.common.api.Response;

/* loaded from: classes8.dex */
public class LocationSettingsResponse extends Response<LocationSettingsResult> {
    public LocationSettingsResponse(LocationSettingsResult locationSettingsResult) {
        super(locationSettingsResult);
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return getResult().getLocationSettingsStates();
    }
}
