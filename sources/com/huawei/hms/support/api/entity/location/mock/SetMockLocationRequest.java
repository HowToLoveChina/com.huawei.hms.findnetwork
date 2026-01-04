package com.huawei.hms.support.api.entity.location.mock;

import android.content.Context;
import android.location.Location;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

/* loaded from: classes8.dex */
public class SetMockLocationRequest extends LocationBaseRequest {

    @Packed
    private Location mockLocation;

    public SetMockLocationRequest(Context context) {
        super(context);
    }

    public Location getMockLocation() {
        return this.mockLocation;
    }

    public void setMockLocation(Location location) {
        this.mockLocation = location;
    }
}
