package com.huawei.hms.findnetwork.comm.request.bean;

/* loaded from: classes8.dex */
public class StandbyStatus {
    private int combinationStatus;
    private String fid;
    private int sequence;

    public StandbyStatus(String str, int i10, int i11) {
        this.fid = str;
        this.sequence = i10;
        this.combinationStatus = i11;
    }

    public int getCombinationStatus() {
        return this.combinationStatus;
    }

    public String getFid() {
        return this.fid;
    }

    public int getSequence() {
        return this.sequence;
    }

    public void setCombinationStatus(int i10) {
        this.combinationStatus = i10;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setSequence(int i10) {
        this.sequence = i10;
    }
}
