package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class GiftRight implements Serializable {
    private static final long serialVersionUID = -7552608532770262261L;
    private int duration;
    private String unit;

    public int getDuration() {
        return this.duration;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String toString() {
        return "GiftRight{duration=" + this.duration + ", unit='" + this.unit + "'}";
    }
}
