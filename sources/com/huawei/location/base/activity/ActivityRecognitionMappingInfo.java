package com.huawei.location.base.activity;

import com.huawei.location.base.activity.callback.ARCallback;
import com.huawei.location.base.activity.entity.ClientInfo;
import java.util.Objects;

/* loaded from: classes8.dex */
public class ActivityRecognitionMappingInfo {
    private ARCallback callback;
    private ClientInfo clientInfo;
    private long detectionIntervalMillis;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof ActivityRecognitionMappingInfo)) {
            return false;
        }
        ActivityRecognitionMappingInfo activityRecognitionMappingInfo = (ActivityRecognitionMappingInfo) obj;
        ARCallback aRCallback = this.callback;
        return aRCallback != null && aRCallback.equals(activityRecognitionMappingInfo.callback);
    }

    public ARCallback getCallback() {
        return this.callback;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public long getDetectionIntervalMillis() {
        return this.detectionIntervalMillis;
    }

    public int hashCode() {
        return Objects.hash(this.callback);
    }

    public void setCallback(ARCallback aRCallback) {
        this.callback = aRCallback;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public void setDetectionIntervalMillis(long j10) {
        this.detectionIntervalMillis = j10;
    }
}
