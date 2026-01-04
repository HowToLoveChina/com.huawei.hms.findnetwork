package com.huawei.location.resp;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;

/* loaded from: classes8.dex */
public class CheckLocationSettingsResp extends LocationBaseResponse {

    @Packed
    private LocationSettingsStates locationSettingsStates;

    @Packed
    private StatusCheck statusCheck;

    public LocationSettingsStates getLocationSettingsStates() {
        return this.locationSettingsStates;
    }

    public StatusCheck getStatusCheck() {
        return this.statusCheck;
    }

    public void setLocationSettingsStates(LocationSettingsStates locationSettingsStates) {
        this.locationSettingsStates = locationSettingsStates;
    }

    public void setStatusCheck(StatusCheck statusCheck) {
        this.statusCheck = statusCheck;
    }
}
