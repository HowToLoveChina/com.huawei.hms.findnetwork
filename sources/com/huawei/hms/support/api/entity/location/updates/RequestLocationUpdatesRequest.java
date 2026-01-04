package com.huawei.hms.support.api.entity.location.updates;

import android.content.Context;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

/* loaded from: classes8.dex */
public class RequestLocationUpdatesRequest extends LocationBaseRequest {

    @Packed
    private LocationRequest locationRequest;
    private boolean resendFromHMS;

    @Packed
    private String uuid;

    public RequestLocationUpdatesRequest() {
    }

    public LocationRequest getLocationRequest() {
        return this.locationRequest;
    }

    public String getUuid() {
        return this.uuid;
    }

    public boolean isResendFromHMS() {
        return this.resendFromHMS;
    }

    public void setLocationRequest(LocationRequest locationRequest) {
        this.locationRequest = locationRequest;
    }

    public void setResendFromHMS(boolean z10) {
        this.resendFromHMS = z10;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public RequestLocationUpdatesRequest(Context context) {
        super(context);
    }
}
