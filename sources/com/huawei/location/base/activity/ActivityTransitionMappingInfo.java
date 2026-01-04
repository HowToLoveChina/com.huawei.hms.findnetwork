package com.huawei.location.base.activity;

import com.huawei.hms.location.entity.activity.ActivityTransition;
import com.huawei.location.base.activity.callback.ATCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class ActivityTransitionMappingInfo {
    private List<ActivityTransition> activityTransitions = new CopyOnWriteArrayList();
    private ATCallback callback;
    private ClientInfo clientInfo;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof ActivityTransitionMappingInfo)) {
            return false;
        }
        ActivityTransitionMappingInfo activityTransitionMappingInfo = (ActivityTransitionMappingInfo) obj;
        ATCallback aTCallback = this.callback;
        return aTCallback != null && aTCallback.equals(activityTransitionMappingInfo.callback);
    }

    public List<ActivityTransition> getActivityTransitions() {
        return this.activityTransitions;
    }

    public ATCallback getCallback() {
        return this.callback;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public int hashCode() {
        return Objects.hash(this.callback);
    }

    public void setActivityTransitions(List<ActivityTransition> list) {
        this.activityTransitions = list;
    }

    public void setCallback(ATCallback aTCallback) {
        this.callback = aTCallback;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
