package com.huawei.hicloud.base.bean;

/* loaded from: classes6.dex */
public class QuotaSpaceInfo {
    private long total = -1;
    private long used = -1;
    private long available = -1;
    private int retCode = -1;

    public long getAvailable() {
        return this.available;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public long getTotal() {
        return this.total;
    }

    public long getUsed() {
        return this.used;
    }

    public void setAvailable(long j10) {
        this.available = j10;
    }

    public void setRetCode(int i10) {
        this.retCode = i10;
    }

    public void setTotal(long j10) {
        this.total = j10;
    }

    public void setUsed(long j10) {
        this.used = j10;
    }
}
