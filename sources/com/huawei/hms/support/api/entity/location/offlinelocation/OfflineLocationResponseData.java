package com.huawei.hms.support.api.entity.location.offlinelocation;

import com.huawei.hms.location.HWLocation;

/* loaded from: classes8.dex */
public class OfflineLocationResponseData {
    private HWLocation hwLocation;
    private long locationTime;

    public HWLocation getHwLocation() {
        return this.hwLocation;
    }

    public long getLocationTime() {
        return this.locationTime;
    }

    public void setHwLocation(HWLocation hWLocation) {
        this.hwLocation = hWLocation;
    }

    public void setLocationTime(long j10) {
        this.locationTime = j10;
    }
}
