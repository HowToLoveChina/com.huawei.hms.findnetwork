package com.huawei.hicloud.notification.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class FrequencyBean {

    @SerializedName("days")
    private int days;

    @SerializedName("times")
    private int times;

    public int getDays() {
        return this.days;
    }

    public int getTimes() {
        return this.times;
    }

    public void setDays(int i10) {
        this.days = i10;
    }

    public void setTimes(int i10) {
        this.times = i10;
    }
}
