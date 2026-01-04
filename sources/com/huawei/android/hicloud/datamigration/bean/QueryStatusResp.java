package com.huawei.android.hicloud.datamigration.bean;

/* loaded from: classes3.dex */
public class QueryStatusResp extends CutBaseResp {
    private int interval;
    private int retry;
    private int verifyStatus;

    public int getInterval() {
        return this.interval;
    }

    public int getRetry() {
        return this.retry;
    }

    public int getVerifyStatus() {
        return this.verifyStatus;
    }

    public void setInterval(int i10) {
        this.interval = i10;
    }

    public void setRetry(int i10) {
        this.retry = i10;
    }

    public void setVerifyStatus(int i10) {
        this.verifyStatus = i10;
    }
}
