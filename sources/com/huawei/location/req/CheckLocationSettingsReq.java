package com.huawei.location.req;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import java.util.List;

/* loaded from: classes8.dex */
public class CheckLocationSettingsReq extends LocationBaseRequest {

    @Packed
    private boolean alwaysShow;

    @Packed
    private boolean needBle;

    @Packed
    private List<LocationRequest> requests;

    public List<LocationRequest> getRequests() {
        return this.requests;
    }

    public boolean isAlwaysShow() {
        return this.alwaysShow;
    }

    public boolean isNeedBle() {
        return this.needBle;
    }

    public void setAlwaysShow(boolean z10) {
        this.alwaysShow = z10;
    }

    public void setNeedBle(boolean z10) {
        this.needBle = z10;
    }

    public void setRequests(List<LocationRequest> list) {
        this.requests = list;
    }
}
