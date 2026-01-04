package com.huawei.hicloud.bean;

/* loaded from: classes6.dex */
public class RetryPolicy {
    private int moment;
    private int period;
    private int retryTimes;
    private String syncType;

    public RetryPolicy(String str, int i10, int i11, int i12) {
        this.syncType = str;
        this.moment = i10;
        this.period = i11;
        this.retryTimes = i12;
    }

    public int getMoment() {
        return this.moment;
    }

    public int getPeriod() {
        return this.period;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public void setMoment(int i10) {
        this.moment = i10;
    }

    public void setPeriod(int i10) {
        this.period = i10;
    }

    public void setRetryTimes(int i10) {
        this.retryTimes = i10;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }

    public String toString() {
        return "RetryPolicy{syncType='" + this.syncType + "', moment=" + this.moment + ", period=" + this.period + ", retryTimes=" + this.retryTimes + '}';
    }
}
