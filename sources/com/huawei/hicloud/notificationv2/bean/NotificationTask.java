package com.huawei.hicloud.notificationv2.bean;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes6.dex */
public class NotificationTask {
    String data;
    private int eventType;
    long notifyTime;
    private int type;

    public NotificationTask(long j10, String str, int i10) {
        this.notifyTime = j10;
        this.data = str;
        this.type = i10;
    }

    public String getData() {
        return this.data;
    }

    public int getEventType() {
        return this.eventType;
    }

    public long getNotifyTime() {
        return this.notifyTime;
    }

    public int getType() {
        return this.type;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setEventType(int i10) {
        this.eventType = i10;
    }

    public void setNotifyTime(long j10) {
        this.notifyTime = j10;
    }

    public void setType(int i10) {
        this.type = i10;
    }
}
