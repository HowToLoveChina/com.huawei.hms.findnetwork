package com.huawei.hicloud.notificationv2.bean;

import androidx.annotation.Keep;
import p714vp.AbstractC13477b;

@Keep
/* loaded from: classes6.dex */
public class LogInfoRecord extends AbstractC13477b {
    private String errorReason;
    private long eventTime;

    public LogInfoRecord(long j10, String str) {
        this.eventTime = j10;
        this.errorReason = str;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public long getEventTime() {
        return this.eventTime;
    }

    public void setErrorReason(String str) {
        this.errorReason = str;
    }

    public void setEventTime(long j10) {
        this.eventTime = j10;
    }
}
