package com.huawei.hicloud.cloudbackup.p104v3.omconfig.model;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class SyncSwitchBackupInfo {
    private String backupAppName;
    private int code;
    private String syncAppName;
    private boolean isSyncAppExclusiveSupport = false;
    private boolean syncSwitchOpen = false;
    private boolean backupSwitchOpen = true;
    private int policy = 0;

    public String getBackupAppName() {
        return TextUtils.isEmpty(this.backupAppName) ? "" : this.backupAppName;
    }

    public int getCode() {
        this.code = 0;
        if (this.isSyncAppExclusiveSupport && 1 == this.policy) {
            if (this.syncSwitchOpen) {
                if (this.backupSwitchOpen) {
                    this.code = 2;
                } else {
                    this.code = 3;
                }
            } else if (this.backupSwitchOpen) {
                this.code = 0;
            } else {
                this.code = 1;
            }
        }
        return this.code;
    }

    public int getPolicy() {
        return this.policy;
    }

    public String getSyncAppName() {
        return TextUtils.isEmpty(this.syncAppName) ? "" : this.syncAppName;
    }

    public boolean isBackupSwitchOpen() {
        return this.backupSwitchOpen;
    }

    public boolean isSyncAppExclusiveSupport() {
        return this.isSyncAppExclusiveSupport;
    }

    public boolean isSyncSwitchOpen() {
        return this.syncSwitchOpen;
    }

    public void setBackupAppName(String str) {
        this.backupAppName = str;
    }

    public void setBackupSwitchOpen(boolean z10) {
        this.backupSwitchOpen = z10;
    }

    public void setPolicy(int i10) {
        this.policy = i10;
    }

    public void setSyncAppExclusiveSupport(boolean z10) {
        this.isSyncAppExclusiveSupport = z10;
    }

    public void setSyncAppName(String str) {
        this.syncAppName = str;
    }

    public void setSyncSwitchOpen(boolean z10) {
        this.syncSwitchOpen = z10;
    }
}
