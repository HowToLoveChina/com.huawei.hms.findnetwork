package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

/* loaded from: classes6.dex */
public class SyncSwitchRestoreResult {
    private int code;
    private int statusAfterRestore;
    private int statusBefore;
    private String syncType;

    public int getCode() {
        return this.code;
    }

    public int getStatusAfterRestore() {
        return this.statusAfterRestore;
    }

    public int getStatusBefore() {
        return this.statusBefore;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setStatusAfterRestore(int i10) {
        this.statusAfterRestore = i10;
    }

    public void setStatusBefore(int i10) {
        this.statusBefore = i10;
    }

    public void setSyncType(String str) {
        this.syncType = str;
    }
}
