package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

/* loaded from: classes6.dex */
public class SyncSwitchStatus {
    private int status;
    private String syncType;

    public SyncSwitchStatus(String str, int i10) {
        this.syncType = str;
        this.status = i10;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSyncType() {
        return this.syncType;
    }

    public String toString() {
        return "syncType: " + this.syncType + ", status: " + this.status;
    }
}
