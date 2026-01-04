package com.huawei.android.hicloud.cloudbackup.bean;

import com.huawei.android.hicloud.cloudbackup.process.CacheTask;

/* loaded from: classes2.dex */
public class CBState {
    public static final int STAUTS_BACKUPING = 1;
    public static final int STAUTS_DEFAULT = 0;
    public static final int STAUTS_RESTRORING = 2;
    public static final int STAUTS_RESTRORING_PAUSED = 3;
    private int amount;
    private long lastTimeStamp;
    private CacheTask.State state;
    private int status = 0;

    public int getAmount() {
        return this.amount;
    }

    public long getLastTimeStamp() {
        return this.lastTimeStamp;
    }

    public CacheTask.State getState() {
        return this.state;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAmount(int i10) {
        this.amount = i10;
    }

    public void setLastTimeStamp(long j10) {
        this.lastTimeStamp = j10;
    }

    public void setState(CacheTask.State state) {
        this.state = state;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
