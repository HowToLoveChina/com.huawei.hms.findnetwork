package com.huawei.hicloud.request.cbs.bean;

import gp.C10028c;

/* loaded from: classes6.dex */
public class CBSDeleteSingleBackupRecordReq extends CBSBaseIdsReq {
    private int isInBackup;
    private String version;

    public CBSDeleteSingleBackupRecordReq(String str, int i10, String str2) {
        this.cmd = 32;
        this.info = "DeleteSingleBackupRecordReq";
        this.deviceId = str;
        this.deviceType = i10;
        this.backupId = str2;
        this.version = "V2";
        if (C10028c.m62182c0().m62335h1()) {
            this.version = CBSBaseReq.CURRENT_API_VERSION;
        }
        this.isInBackup = 1;
    }

    public int getIsInBackup() {
        return this.isInBackup;
    }

    public String getVersion() {
        return this.version;
    }

    public void setIsInBackup(int i10) {
        this.isInBackup = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
