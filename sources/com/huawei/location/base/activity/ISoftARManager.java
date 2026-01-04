package com.huawei.location.base.activity;

import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.router.entity.IRouterResponse;
import java.util.List;

/* loaded from: classes8.dex */
public interface ISoftARManager extends IRouterResponse {
    void removeActivityTransitionUpdates(ATCallback aTCallback);

    void removeActivityUpdates(ARCallback aRCallback);

    void requestActivityTransitionUpdates(List<ActivityTransition> list, ATCallback aTCallback);

    void requestActivityUpdates(long j10, ARCallback aRCallback);
}
