package com.huawei.android.hicloud.cloudbackup.bean;

/* loaded from: classes2.dex */
public class DsStartMainProcessPolicy {
    public static final int DEFAULT_PERIOD_INTERVAL = 8;
    public static final int DEFAULT_TIMES = 1;
    int periodInterval = 8;
    int times = 1;

    public int getPeriodInterval() {
        return this.periodInterval;
    }

    public int getTimes() {
        return this.times;
    }

    public void setPeriodInterval(int i10) {
        this.periodInterval = i10;
    }

    public void setTimes(int i10) {
        this.times = i10;
    }

    public String toString() {
        return "DsStartMainProcessPolicy{periodInterval=" + this.periodInterval + ", times=" + this.times + '}';
    }
}
