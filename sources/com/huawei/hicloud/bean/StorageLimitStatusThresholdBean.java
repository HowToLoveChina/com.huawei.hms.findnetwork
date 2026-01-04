package com.huawei.hicloud.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes6.dex */
public class StorageLimitStatusThresholdBean {

    @SerializedName("lower")
    private int lower;

    @SerializedName("timeout")
    private int timeout;

    @SerializedName("upper")
    private int upper;

    public int getLower() {
        return this.lower;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getUpper() {
        return this.upper;
    }

    public void setLower(int i10) {
        this.lower = i10;
    }

    public void setTimeout(int i10) {
        this.timeout = i10;
    }

    public void setUpper(int i10) {
        this.upper = i10;
    }
}
