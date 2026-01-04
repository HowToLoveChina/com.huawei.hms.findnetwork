package com.huawei.android.hicloud.cloudbackup.bean;

import ne.C11667a;

/* loaded from: classes2.dex */
public class TimeScope {
    private static final String TAG = "TimeScope";
    private String endTime;
    private String startTime;

    private boolean isTimeIllegal(String str) {
        return false;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public boolean isArgumentInvalid() {
        return isTimeIllegal(this.startTime) || isTimeIllegal(this.endTime) || C11667a.m69672n(this.startTime, this.endTime, "HH:mm");
    }
}
