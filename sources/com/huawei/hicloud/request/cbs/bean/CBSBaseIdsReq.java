package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSBaseIdsReq extends CBSBaseReq {
    protected String backupId;
    protected String deviceId;
    protected int deviceType;

    public String getBackupId() {
        return this.backupId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setCBIdDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }
}
