package com.huawei.hicloud.request.cbs.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class CBSQueryAsyncExecResultReq extends CBSBaseReq {
    private String backupId;
    private String deviceId;
    private int deviceType;

    public CBSQueryAsyncExecResultReq(String str, String str2, int i10) {
        this.backupId = str;
        this.deviceId = str2;
        this.deviceType = i10;
        this.cmd = 34;
        this.info = "QueryAsyncExecResultReq";
    }

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

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseReq
    public String toString() {
        return new Gson().toJson(this);
    }
}
