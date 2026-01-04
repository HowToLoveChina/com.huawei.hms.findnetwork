package com.huawei.hicloud.request.notify.bean;

import java.util.Arrays;

/* loaded from: classes6.dex */
public class EventResp extends NotifyBaseResp {
    private NotifyResult[] notifyWays;

    public NotifyResult[] getNotifyWays() {
        return this.notifyWays;
    }

    public void setNotifyWays(NotifyResult[] notifyResultArr) {
        this.notifyWays = notifyResultArr;
    }

    public String toString() {
        return "EventResp{notifyWays=" + Arrays.toString(this.notifyWays) + '}';
    }
}
