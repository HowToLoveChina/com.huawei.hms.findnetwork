package com.huawei.hms.support.api.entity.location.enhance;

import android.content.Context;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.RoadData;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;

/* loaded from: classes8.dex */
public class RoadDataRequest extends LocationBaseRequest {

    @Packed
    private RoadData roadData;

    public RoadDataRequest(Context context) {
        super(context);
    }

    public RoadData getRoadData() {
        return this.roadData;
    }

    public void setRoadData(RoadData roadData) {
        this.roadData = roadData;
    }
}
