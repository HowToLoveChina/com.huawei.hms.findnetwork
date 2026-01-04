package com.huawei.cloud.pay.model;

/* loaded from: classes5.dex */
public class GetActivityEntryResp extends Response {
    private long clientVersion;
    private ActivityEntry entry;

    public long getClientVersion() {
        return this.clientVersion;
    }

    public ActivityEntry getEntry() {
        return this.entry;
    }

    public void setClientVersion(long j10) {
        this.clientVersion = j10;
    }

    public void setEntry(ActivityEntry activityEntry) {
        this.entry = activityEntry;
    }
}
