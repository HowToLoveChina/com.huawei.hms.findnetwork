package com.huawei.hms.support.api.entity.location.checksettings;

import android.content.Context;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

/* loaded from: classes8.dex */
public class CheckLocationSettingsRequest extends LocationBaseRequest {

    @Packed
    private LocationSettingsRequest locationSettingsRequest;

    public CheckLocationSettingsRequest(Context context) {
        super(context);
    }

    public LocationSettingsRequest getLocationSettingsRequest() {
        return this.locationSettingsRequest;
    }

    public void setLocationSettingsRequest(LocationSettingsRequest locationSettingsRequest) {
        this.locationSettingsRequest = locationSettingsRequest;
    }
}
