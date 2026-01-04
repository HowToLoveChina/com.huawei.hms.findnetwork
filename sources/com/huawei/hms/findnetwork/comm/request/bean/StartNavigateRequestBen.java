package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class StartNavigateRequestBen extends SnRequestBean {
    private boolean isRestart;
    private long startRecordTime;

    public long getStartRecordTime() {
        return this.startRecordTime;
    }

    public boolean isRestart() {
        return this.isRestart;
    }

    public void setRestart(boolean z10) {
        this.isRestart = z10;
    }

    public void setStartRecordTime(long j10) {
        this.startRecordTime = j10;
    }
}
