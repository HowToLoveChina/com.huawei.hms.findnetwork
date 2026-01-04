package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class DeviceDeleteListReq extends BaseRequest {
    private int clearTime;
    private boolean isBackground;

    public DeviceDeleteListReq(boolean z10, int i10) {
        super(-1, "DeviceDeleteListReq");
        this.isBackground = z10;
        this.clearTime = i10;
    }

    public int getClearTime() {
        return this.clearTime;
    }

    public boolean isBackground() {
        return this.isBackground;
    }

    public void setBackground(boolean z10) {
        this.isBackground = z10;
    }

    public void setClearTime(int i10) {
        this.clearTime = i10;
    }
}
