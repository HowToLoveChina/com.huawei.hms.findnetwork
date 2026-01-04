package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class RestoreRetry {
    private static final int RETRYINTERVAL_DEFAULT_VALUE = 10;
    private static final int RETRYTIMES_DEFAULT_VALUE = 8;
    int pauseBattery = 10;
    int restartBattery = 20;
    int retryInterval = 10;
    int retryTimes = 8;

    public int getPauseBattery() {
        return this.pauseBattery;
    }

    public int getRestartBattery() {
        return this.restartBattery;
    }

    public int getRetryInterval() {
        return this.retryInterval;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public void setPauseBattery(int i10) {
        this.pauseBattery = i10;
    }

    public void setRestartBattery(int i10) {
        this.restartBattery = i10;
    }

    public void setRetryInterval(int i10) {
        this.retryInterval = i10;
    }

    public void setRetryTimes(int i10) {
        this.retryTimes = i10;
    }

    public String toString() {
        return "RestoreRetry{pauseBattery=" + this.pauseBattery + ", restartBattery=" + this.restartBattery + ", retryInterval=" + this.retryInterval + ", retryTimes=" + this.retryTimes + '}';
    }
}
