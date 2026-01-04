package com.huawei.hicloud.request.cbs.bean;

import com.google.gson.Gson;
import gp.C10028c;

/* loaded from: classes6.dex */
public class CBSCreateBackupRecordReq extends CBSBaseReq {
    private String deviceId;
    private int deviceType;
    private String extend;
    private long startTime;
    private int type = 0;
    private String version;

    public CBSCreateBackupRecordReq() {
        this.cmd = 24;
        this.info = "CreateBackupRecordReq";
        this.startTime = System.currentTimeMillis();
        this.version = "V2";
        if (C10028c.m62182c0().m62335h1()) {
            this.version = CBSBaseReq.CURRENT_API_VERSION;
        }
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getExtend() {
        return this.extend;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setCBSDeviceID(String str) {
        this.deviceId = str;
    }

    public void setDeviceType(int i10) {
        this.deviceType = i10;
    }

    public void setExtend(String str) {
        this.extend = str;
    }

    public void setStartTime(long j10) {
        this.startTime = j10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    @Override // com.huawei.hicloud.request.cbs.bean.CBSBaseReq
    public String toString() {
        return new Gson().toJson(this);
    }
}
