package com.huawei.hms.location.api.request;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes8.dex */
public class RequestActivityIdentificationReq extends BaseLocationReq {

    @Packed
    private long detectionIntervalMillis;

    public long getDetectionIntervalMillis() {
        return this.detectionIntervalMillis;
    }

    public void setDetectionIntervalMillis(long j10) {
        this.detectionIntervalMillis = j10;
    }
}
