package com.huawei.hms.location.api.response;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.entity.activity.ActivityTransitionResult;

/* loaded from: classes8.dex */
public class RequestActivityConversionResp extends BaseLocationResp {

    @Packed
    private ActivityTransitionResult activityTransitionResult;

    public ActivityTransitionResult getActivityTransitionResult() {
        return this.activityTransitionResult;
    }

    public void setActivityTransitionResult(ActivityTransitionResult activityTransitionResult) {
        this.activityTransitionResult = activityTransitionResult;
    }
}
