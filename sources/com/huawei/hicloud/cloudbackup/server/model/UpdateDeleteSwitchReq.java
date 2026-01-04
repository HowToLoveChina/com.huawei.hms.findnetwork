package com.huawei.hicloud.cloudbackup.server.model;

/* loaded from: classes6.dex */
public class UpdateDeleteSwitchReq extends BaseRequest {
    private int clearTime;
    private int status;

    public UpdateDeleteSwitchReq(int i10, int i11) {
        super(-1, "UpdateDeleteSwitchReq");
        this.status = i10;
        this.clearTime = i11;
    }

    public int getClearTime() {
        return this.clearTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setClearTime(int i10) {
        this.clearTime = i10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
