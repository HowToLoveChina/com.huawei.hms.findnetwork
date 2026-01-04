package com.huawei.cloud.pay.model;

import java.io.Serializable;

/* loaded from: classes5.dex */
public class CardGiftResp implements Serializable {
    private static final long serialVersionUID = -7111742566389959524L;
    private long capacity;
    private float duration;

    /* renamed from: id */
    private String f21396id;
    private int productType;
    private int timeUnit;

    public long getCapacity() {
        return this.capacity;
    }

    public float getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.f21396id;
    }

    public int getProductType() {
        return this.productType;
    }

    public int getTimeUnit() {
        return this.timeUnit;
    }

    public void setCapacity(long j10) {
        this.capacity = j10;
    }

    public void setDuration(float f10) {
        this.duration = f10;
    }

    public void setId(String str) {
        this.f21396id = str;
    }

    public void setProductType(int i10) {
        this.productType = i10;
    }

    public void setTimeUnit(int i10) {
        this.timeUnit = i10;
    }
}
