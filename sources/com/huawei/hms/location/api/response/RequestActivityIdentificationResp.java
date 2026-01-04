package com.huawei.hms.location.api.response;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.location.entity.activity.ActivityRecognitionResult;

/* loaded from: classes8.dex */
public class RequestActivityIdentificationResp extends BaseLocationResp {

    @Packed
    private ActivityRecognitionResult activityRecognitionResult;

    public ActivityRecognitionResult getActivityRecognitionResult() {
        return this.activityRecognitionResult;
    }

    public void setActivityRecognitionResult(ActivityRecognitionResult activityRecognitionResult) {
        this.activityRecognitionResult = activityRecognitionResult;
    }
}
