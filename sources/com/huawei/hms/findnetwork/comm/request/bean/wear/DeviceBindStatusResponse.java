package com.huawei.hms.findnetwork.comm.request.bean.wear;

/* loaded from: classes8.dex */
public class DeviceBindStatusResponse implements WearResponse {
    private boolean bindStatus;
    private String fid;
    private int syncCode;

    public String getFid() {
        return this.fid;
    }

    public int getSyncCode() {
        return this.syncCode;
    }

    public boolean isBindStatus() {
        return this.bindStatus;
    }

    public void setBindStatus(boolean z10) {
        this.bindStatus = z10;
    }

    public void setFid(String str) {
        this.fid = str;
    }

    public void setSyncCode(int i10) {
        this.syncCode = i10;
    }
}
