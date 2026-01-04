package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class CountDownConfig implements Serializable {
    private static final long serialVersionUID = -7214966696526559718L;
    private long endTime = -1;

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j10) {
        this.endTime = j10;
    }

    public String toString() {
        return "CountDownConfig{endTime=" + this.endTime + '}';
    }
}
