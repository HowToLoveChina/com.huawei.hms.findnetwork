package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class BackupTimeWindowBean {
    private int timingInterval = 10;
    private int periodRandomFactor = 7;
    private int standAloneTask = 0;

    public int getPeriodRandomFactor() {
        return this.periodRandomFactor;
    }

    public int getStandAloneTask() {
        return this.standAloneTask;
    }

    public int getTimingInterval() {
        return this.timingInterval;
    }

    public void setPeriodRandomFactor(int i10) {
        this.periodRandomFactor = i10;
    }

    public void setStandAloneTask(int i10) {
        this.standAloneTask = i10;
    }

    public void setTimingInterval(int i10) {
        this.timingInterval = i10;
    }
}
