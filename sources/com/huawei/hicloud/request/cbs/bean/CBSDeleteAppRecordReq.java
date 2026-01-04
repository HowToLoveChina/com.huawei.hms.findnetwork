package com.huawei.hicloud.request.cbs.bean;

/* loaded from: classes6.dex */
public class CBSDeleteAppRecordReq extends CBSBaseReq {
    private String appId;
    private String deviceId;
    private int deviceType;

    public CBSDeleteAppRecordReq(String str, int i10, String str2) {
        this.cmd = 28;
        this.info = "DeleteAppBackupRecordReq";
        this.deviceId = str;
        this.deviceType = i10;
        this.appId = str2;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }
}
