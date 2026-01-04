package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class PassiveLocationRequestBean extends SnRequestBean {
    private long endTime;
    private int locationSourceType;
    private long startTime;

    public long getEndTime() {
        return this.endTime;
    }

    public int getLocationSourceType() {
        return this.locationSourceType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    public void setLocationSourceType(int i10) {
        this.locationSourceType = i10;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }
}
