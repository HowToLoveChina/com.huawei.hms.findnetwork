package com.huawei.hicloud.request.cbs.bean;

import com.google.gson.Gson;

/* loaded from: classes6.dex */
public class CBSLockAndFlowControlReq {
    private static final int LOCKTYPE_BACKUP = 0;
    private String backupId;
    private int backupType;
    private String deviceId;
    private int deviceType;
    private int lockType = 0;
    private String extend = "";

    public CBSLockAndFlowControlReq(String str, int i10, String str2, int i11) {
        this.deviceId = str;
        this.deviceType = i10;
        this.backupId = str2;
        this.backupType = i11;
    }

    public String getBackupId() {
        return this.backupId;
    }

    public int getBackupType() {
        return this.backupType;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getExtend() {
        return this.extend;
    }

    public int getLockType() {
        return this.lockType;
    }

    public String getTheDeviceId() {
        return this.deviceId;
    }

    public void setBackupId(String str) {
        this.backupId = str;
    }

    public void setBackupType(int i10) {
        this.backupType = i10;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setLockType(int i10) {
        this.lockType = i10;
    }

    public void setTheDeviceId(String str) {
        this.deviceId = str;
    }

    public String toString() {
        return new Gson().toJson(this);
    }
}
