package com.huawei.hicloud.notification.data;

/* loaded from: classes6.dex */
public abstract class BaseDataCollector {
    protected int mAmount;
    protected long mSize;

    public abstract void execute();

    public long getSize() {
        return this.mSize;
    }

    public int getmAmount() {
        return this.mAmount;
    }

    public void setSize(long j10) {
        this.mSize = j10;
    }

    public void setmAmount(int i10) {
        this.mAmount = i10;
    }
}
