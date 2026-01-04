package com.huawei.hicloud.base.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class CloudSpace {
    private long endtime;
    private long endtime2;
    private long limit;
    private long maxPackageSize = -1;
    private long oldMaxPackageSize = -1;
    private long total;
    private long used;

    public long getEndTime() {
        return this.endtime;
    }

    public long getLimit() {
        return this.limit;
    }

    public long getMaxPackageSize() {
        return this.maxPackageSize;
    }

    public long getOldMaxPackageSize() {
        return this.oldMaxPackageSize;
    }

    public long getTotal() {
        return this.total;
    }

    public long getUsed() {
        return this.used;
    }

    public long getWorryEndTime2() {
        return this.endtime2;
    }

    public void setEndTime(long j10) {
        this.endtime = j10;
    }

    public void setLimit(long j10) {
        this.limit = j10;
    }

    public void setMaxPackageSize(long j10) {
        this.maxPackageSize = j10;
    }

    public void setOldMaxPackageSize(long j10) {
        this.oldMaxPackageSize = j10;
    }

    public void setTotal(long j10) {
        this.total = j10;
    }

    public void setUsed(long j10) {
        this.used = j10;
    }

    public void setWorryEndTime2(long j10) {
        this.endtime2 = j10;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
