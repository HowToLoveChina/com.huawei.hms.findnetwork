package com.huawei.location.req;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

/* loaded from: classes8.dex */
public class RemoveLocationUpdatesReq extends LocationBaseRequest {

    @Packed
    private String uuid;

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }
}
