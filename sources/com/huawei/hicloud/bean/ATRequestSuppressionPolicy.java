package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class ATRequestSuppressionPolicy {
    private String endTime;
    private String startTime;
    private int suppressDuration;
    private int suppressRate;

    public String getEndTime() {
        return this.endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getSuppressDuration() {
        return this.suppressDuration;
    }

    public int getSuppressRate() {
        return this.suppressRate;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setSuppressDuration(int i10) {
        this.suppressDuration = i10;
    }

    public void setSuppressRate(int i10) {
        this.suppressRate = i10;
    }
}
