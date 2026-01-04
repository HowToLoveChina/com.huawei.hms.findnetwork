package com.huawei.hicloud.request.cbs.bean;

import gp.C10028c;
import java.util.List;

/* loaded from: classes6.dex */
public class CBSUpdateBackupRecordReq extends CBSUpdateBackupRecordBaseReq {
    private int backupType;
    private List<String> clientActions;
    private String snapshot;
    private int status;
    private String version;

    public CBSUpdateBackupRecordReq() {
    }

    public int getBackupType() {
        return this.backupType;
    }

    public List<String> getClientActions() {
        return this.clientActions;
    }

    public String getSnapshot() {
        return this.snapshot;
    }

    public int getStatus() {
        return this.status;
    }

    public String getVersion() {
        return this.version;
    }

    public void setBackupType(int i10) {
        this.backupType = i10;
    }

    public void setClientActions(List<String> list) {
        this.clientActions = list;
    }

    public void setSnapshot(String str) {
        this.snapshot = str;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public CBSUpdateBackupRecordReq(String str, String str2, int i10, int i11, int i12, String str3) {
        super(str, i10, str2);
        this.cmd = 25;
        this.info = "UpdateBackupRecordReq";
        this.backupType = i11;
        this.version = "V2";
        if (C10028c.m62182c0().m62335h1()) {
            this.version = CBSBaseReq.CURRENT_API_VERSION;
        }
        this.status = i12;
        this.snapshot = str3;
    }
}
