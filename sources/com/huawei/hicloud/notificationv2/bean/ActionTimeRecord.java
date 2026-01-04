package com.huawei.hicloud.notificationv2.bean;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes6.dex */
public class ActionTimeRecord {
    int actionType;
    long timeStamp;

    public ActionTimeRecord(int i10, long j10) {
        this.actionType = i10;
        this.timeStamp = j10;
    }

    public int getActionType() {
        return this.actionType;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setActionType(int i10) {
        this.actionType = i10;
    }

    public void setTimeStamp(long j10) {
        this.timeStamp = j10;
    }

    public String toString() {
        return "ActionTimeRecord{actionType=" + this.actionType + ",timeStamp=" + this.timeStamp + '}';
    }
}
