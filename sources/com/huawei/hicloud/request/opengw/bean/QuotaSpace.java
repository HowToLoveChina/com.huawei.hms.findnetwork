package com.huawei.hicloud.request.opengw.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class QuotaSpace {
    private long limit;
    private long total;
    private long used;

    public long getLimit() {
        return this.limit;
    }

    public long getTotal() {
        return this.total;
    }

    public long getUsed() {
        return this.used;
    }

    public void setLimit(long j10) {
        this.limit = j10;
    }

    public void setTotal(long j10) {
        this.total = j10;
    }

    public void setUsed(long j10) {
        this.used = j10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
