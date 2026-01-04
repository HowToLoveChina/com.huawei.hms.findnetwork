package com.huawei.location.resp;

import com.huawei.hms.core.aidl.IMessageEntity;

/* loaded from: classes8.dex */
public class ResponseInfo implements IMessageEntity {
    private LocationAvailabilityInfo locationAvailability;
    private C6804Vw locationResult;

    public LocationAvailabilityInfo getLocationAvailability() {
        return this.locationAvailability;
    }

    public C6804Vw getLocationResult() {
        return this.locationResult;
    }

    public void setLocationAvailability(LocationAvailabilityInfo locationAvailabilityInfo) {
        this.locationAvailability = locationAvailabilityInfo;
    }

    public void setLocationResult(C6804Vw c6804Vw) {
        this.locationResult = c6804Vw;
    }
}
